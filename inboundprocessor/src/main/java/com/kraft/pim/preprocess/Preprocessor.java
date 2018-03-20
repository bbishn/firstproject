package com.kraft.pim.preprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

import javax.servlet.ServletContext;

import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.MessageBody;
import microsoft.exchange.webservices.data.WebCredentials;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.kraft.pim.step.STEPProductInformation;

public class Preprocessor {

	private static final Logger logger = Logger.getLogger(Preprocessor.class);

	static AzureConnect azureConnect;

	public Preprocessor() { 
		// Loading properties
		InboundProperties.loadProperties();
	}

	public boolean startPreprocessor(ServletContext context) {
		logger.debug("Starting preprocessor....");
		azureConnect = new AzureConnect();
		Set<String> blobDateSet = null;
		try {
			blobDateSet = azureConnect.connectToAzure();
		} catch (Exception e) {
			logger.debug("Error connecting to Cloud Storage", e);
			return false;
		}
	
		int cnt = 1;

		// for each file in the sorted list of filenames in ASC from cloud
		for (String fileName : blobDateSet) {
			if (InboundProperties.downloadCount != 0
					&& cnt > InboundProperties.downloadCount)
				break;
			cnt++;
			String entryString = "";

			/*-----Download Process---------*/
			// Download the file as String from cloud
			Date now = new Date();
			entryString = "File: " + fileName + "	UTC time:"
					+ InboundProperties.bgpDateFormat.format(now)
					+ "	local-time:"
					+ InboundProperties.appDateFormat.format(now) + "	Result: ";
			String xmlString = "";

			xmlString = downloadSAPFilefromCloud(fileName);
			if ("".equals(xmlString)) {
				entryString += "Download Failed";
				PreprocessorThread.addToList(entryString);
				logger.error("Sleeping the application since Download operation failed");
				sendEmail(fileName,null, null, 1);
				continue;
			}
			/*-------------------------------*/

			/*----Conversion of MDM xml to STEP xml ------------*/
			LinkedList<STEPProductInformation> prodInfoList = null;
			ParseSap parse = new ParseSap();
			try {
				prodInfoList = parse.parse(xmlString,context);
			} catch (Exception e) {
				logger.error("Eroor converting MDM xml to STEP xml", e);
			}

			boolean result = false;
			if (null == prodInfoList) {
				logger.error("Sleeping the application since SAP xml to STEP xml conversion failed.");
				entryString += "Conversion Failed";
				PreprocessorThread.addToList(entryString);
				sendEmail(null,fileName, xmlString, 3);
				azureConnect.moveSapXml(fileName, null, xmlString, false);
				continue;
			}
			/*----------------------------------------*/

			
			// Storing STEP xml in local folder
			/*for (STEPProductInformation prodInfo : prodInfoList) {
				parse.storeSTEPinLocal(prodInfo);
			}*/

			
			
			/*-----Upload process to STEP---------*/
			// Uploading STEPxml to STEP through IIEP
			result = uploadStepXML(prodInfoList);
			if (!result) {
				logger.error("Failed uploading STEP xml to STEP after 3 trials");
				logger.error("Sleeping the application since Download/Upload operation failed");

				entryString += "Upload Failed";
				PreprocessorThread.addToList(entryString);
				sendEmail(null,fileName, xmlString, 2);
				break;
			} else {
				// Moving SAP xml
				azureConnect.moveSapXml(fileName, prodInfoList, xmlString,
						result);
			}
			/*--------------------------------------*/
			entryString += "Success";

			// Static list to check the file-names processed. For debug purpose
			// only.
			PreprocessorThread.addToList(entryString);
		}
		return true;
	}

	private static void sendEmail(String fileName, String attachFilenname, String attachContent,
			int errorSource) {
		String recipientID = "";
		String subject = "";
		String content = "";
		if (errorSource == 1) {
			recipientID = InboundProperties.cloudRecieverID;
			subject = InboundProperties.emailDownloadFailSubject;
			content = InboundProperties.emailDownloadFailContent+" "+fileName;
		} else if (errorSource == 2) {
			recipientID = InboundProperties.stepRecieverID;
			subject = InboundProperties.emailUploadFailSubject;
			content = InboundProperties.emailUploadFailContent;
		} else if (errorSource == 3) {
			recipientID = InboundProperties.stepRecieverID;
			subject = InboundProperties.emailConversionFailSubject;
			content = InboundProperties.emailConversionFailContent;
		}
		logger.info("Sending email");

		ExchangeService service = new ExchangeService(
				ExchangeVersion.Exchange2010_SP1);
		ExchangeCredentials credentials = new WebCredentials(
				InboundProperties.senderID, InboundProperties.senderPwd,
				InboundProperties.senderDomain);
		service.setCredentials(credentials);
		try {
			service.setUrl(new URI(InboundProperties.emailHost));
			EmailMessage msg = new EmailMessage(service);
			msg.setSubject(subject);
			if (null != attachFilenname && null != attachContent) {
				msg.getAttachments().addFileAttachment(attachFilenname,
						attachContent.getBytes());
			}
			msg.setBody(MessageBody.getMessageBodyFromText(content));
			if (recipientID.contains(";")) {
				for (String recipient : recipientID.split(";")) {
					msg.getToRecipients().add(recipient.trim());
				}
			} else {
				msg.getToRecipients().add(recipientID.trim());
			}
			msg.send();
		} catch (Exception e) {
			logger.error("Error sending email", e);
		}
		if (errorSource == 2 || errorSource == 1) {
			Long sleepTime = (long) Integer
					.parseInt(InboundProperties.failWaitTime);
			try {
				logger.info("Sleeping the application");
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				logger.error("Error sleeping the application", e);
			}
		}
	}

	public void startFromLocalSAPfile(String fileName) throws Exception {
		System.out.println(fileName);
		File sapFile = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(sapFile));
		ParseSap parse = new ParseSap();

		String xmlString = br.readLine();
		System.out.println(xmlString);
		LinkedList<STEPProductInformation> prodInfoList = parse
				.parse(xmlString,null);
		br.close();
		boolean result = false;

		if (null == prodInfoList) {
			logger.error("Terminating the application since SAP xml to STEP xml conversion failed.");
			File errorSAPfile = new File(InboundProperties.tmpFolder + "/"
					+ fileName);
			try {
				FileWriter fileWriter = new FileWriter(errorSAPfile);
				fileWriter.write(xmlString);
				fileWriter.close();
			} catch (Exception e) {
				logger.error("Error creating temperory SAP xml file", e);
			}
			// sendEmail(fileName, xmlString, 3);
			
		}

		// Storing STEP xml in local folder
		for (STEPProductInformation prodInfo : prodInfoList) {
			parse.storeSTEPinLocal(prodInfo);
		}

		// Uploading STEPxml to STEP through IIEP
		//result = uploadStepXML(prodInfoList);
		result = true;
		if (!result) {
			logger.error("Failed uploading STEP xml TP STEP after 3 trials");
			logger.error("Sleeping the application since Download/Upload operation failed");
			File errorSAPfile = new File(InboundProperties.tmpFolder + "/"
					+ fileName);
			try {
				FileWriter fileWriter = new FileWriter(errorSAPfile);
				fileWriter.write(xmlString);
				fileWriter.close();
			} catch (Exception e) {
				logger.error("Error creating temperory SAP xml file", e);
			}
			// sendEmail(fileName, xmlString, 2);
		}
		/*azureConnect = new AzureConnect();
		azureConnect.connectToAzure();
		azureConnect.moveSapXml(fileName, prodInfoList, xmlString, true);*/
	}

	private String downloadSAPFilefromCloud(String fileName) {
		int tryCount = 1;
		String xmlString = "";
		do {
			logger.debug("Downloading SAP xml - trail " + (tryCount));
			try {
				xmlString = azureConnect.downloadBlob(fileName);
			} catch (Exception e) {
				logger.error("Error Downloading MDM xml from cloud storage", e);
			}
			if (StringUtils.isNotBlank(xmlString)) {
				break;
			}
			tryCount++;
		} while (tryCount < 4 && (null == xmlString || "".equals(xmlString)));
		if (StringUtils.isBlank(xmlString)) {
			logger.error("Failed downloading file from cloud after 3 trials");
		}
		return xmlString;
	}

	private boolean uploadStepXML(
			LinkedList<STEPProductInformation> prodInfoList) {

		STEPConnect stepConnect = new STEPConnect();

		int tryCount = 1;
		boolean result = false;
		do {

			logger.debug("Uploading STEP xml - trail " + (tryCount));
			result = stepConnect.iiepUpload(prodInfoList);

			if (result)
				break;
			tryCount++;
		} while (tryCount < 4 && !result);

		return result;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Inside Preprocess main");
			new AttributeList().setAttribute();
			new Preprocessor().startFromLocalSAPfile("D://File_STEP//prod//SAPPROD_2017-10-30_18-28-59-3081714.xml");
			//new Preprocessor().startFromLocalSAPfile("D://Kraft Project//Work//09-12-2016 (Enhancement)//Dummy-File//SAPPROD_2016-12-03_10-00-09-8176347.xml");
			// new Preprocessor().startPreprocessor();
		} catch (Exception e) {
			logger.error("Error parsing from local SAP file", e);
		}
	}

}
