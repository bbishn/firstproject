package com.kraft.pim.preprocess;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.kraft.pim.step.STEPProductInformation;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

public class AzureConnect {

	private static CloudBlobClient serviceClient;

	private static final String stepSchemaPath = "com.kraft.pim.step";

	private static final Logger logger = Logger.getLogger(AzureConnect.class);

	private CloudBlobContainer container = null;

	public AzureConnect() {
		CloudStorageAccount account = null;
		try {
			String storageConnectionString = "DefaultEndpointsProtocol="
					+ InboundProperties.defaultEndpointProtocol
					+ ";AccountName=" + InboundProperties.accountName
					+ ";AccountKey=" + InboundProperties.accountKey + ";";
			account = CloudStorageAccount.parse(storageConnectionString);
			logger.info("Connected to Cloud Storage Account");
			
		} catch (Exception e) {
			logger.error("Error connecting to cloud", e);
		}

		serviceClient = account.createCloudBlobClient();
	}

	public Set<String> connectToAzure() throws Exception {
		//Set<String> blobDateSet = new TreeSet<String>(new DateComparator());
		Set<String> blobDateSet = new TreeSet<String>();
		container = serviceClient
				.getContainerReference(InboundProperties.containerName);
		logger.info("Fetched container:" + InboundProperties.containerName);

		logger.debug("Container Exists:" + container.exists());
		if (container.exists()) {
			int i=0;
			for (ListBlobItem blobItem : container.listBlobs()) {
			
				if (blobItem instanceof CloudBlob) {
					CloudBlob blob = (CloudBlob) blobItem;
					String blobDate = blob.getName();
					blobDate = blobDate.substring(blobDate.length() - 28,
							blobDate.length() - 4);
					blobDateSet.add(blob.getName());
					logger.debug("Sorting blob:" + blob.getName());
					i++;
				}
				
			}
			if(i>0){
				logger.info("Sorted files based on timestamp");
			}else{
				logger.info("Container is empty");
			}
		
		}
		return blobDateSet;

	}

	public String downloadBlob(String fileName) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		logger.debug("Downloading blob:" + fileName);
		CloudBlob blob = null;

		for (ListBlobItem blobItem : container.listBlobs()) {
			if (blobItem instanceof CloudBlob) {
				blob = (CloudBlob) blobItem;
				if (blob.getName().equals(fileName)) {
					blob.download(outputStream);
					logger.debug("Downloaded blob:" + fileName);
				}
			}
		}

		String xmlString = outputStream.toString();
		String xmlString1 = outputStream.toString("UTF-8");
		//logger.debug("TEST1::"+xmlString);
		//logger.debug("TEST2::"+xmlString1);
		return xmlString1;
	}

	public void deleteBlob(String fileName) {
		// blob.delete();
	}

	public void moveSapXml(String filename,
			LinkedList<STEPProductInformation> prodInfoList, String xmlString,
			boolean result) {
		CloudBlobContainer secondContainer;
		CloudBlockBlob blob;
		ByteArrayOutputStream byteStream;

		try {
			logger.debug("Moving SAP xml to container based on Status of Convertion as "
					+ result);
			if (result) {
				secondContainer = serviceClient
						.getContainerReference(InboundProperties.successSAPContainer);

				blob = secondContainer.getBlockBlobReference(filename);
				logger.debug("Uploading xml to cloud: " + xmlString);
				blob.uploadText(xmlString);
				int i = 1;
				for (STEPProductInformation prodInfo : prodInfoList) {
					JAXBContext stepContext = JAXBContext
							.newInstance(stepSchemaPath);
					Marshaller stepMarshaller = stepContext.createMarshaller();

					byteStream = new ByteArrayOutputStream();
					stepMarshaller.marshal(prodInfo, byteStream);
					logger.debug("Writing "
							+ filename.replace(".xml", "-STEP_" + i + ".xml")
							+ " to cloud");
					blob = secondContainer.getBlockBlobReference(filename
							.replace(".xml", "-STEP_" + i + ".xml"));
					String stepXmlString = byteStream.toString();
					logger.debug("Uloading Step xml top Cloud: "
							+ stepXmlString);
					blob.uploadText(stepXmlString);
					byteStream.close();
					i++;
				}
				logger.debug("Deleting SAP xml from container");
				blob = container.getBlockBlobReference(filename);
				blob.delete();
			} else {
				secondContainer = serviceClient
						.getContainerReference(InboundProperties.failSAPContainer);

				blob = secondContainer.getBlockBlobReference(filename);
				blob.uploadText(xmlString);
				logger.debug("Upload SAP xml to container" +InboundProperties.failSAPContainer);
				blob = container.getBlockBlobReference(filename);
				logger.debug("Deleting SAP xml from container");
				blob.delete();
			}

		} catch (Exception e) {
			logger.error("Error moving SAP xml", e);
		} finally {
			blob = null;
			secondContainer = null;
		}

	}

	class DateComparator implements Comparator<String> {

		public int compare(String o1, String o2) {
			String datePattern = InboundProperties.cloudDateFormat.toPattern();
			o1 = o1.substring(o1.length() - (datePattern.length() + 4),
					o1.length() - 4);
			o2 = o2.substring(o2.length() - (datePattern.length() + 4),
					o2.length() - 4);
			try {
				return InboundProperties.cloudDateFormat.parse(o1).compareTo(
						InboundProperties.cloudDateFormat.parse(o2));
			} catch (ParseException e) {
				logger.error("Error parsing timestamp from blob name", e);
			}
			return 0;

		}

	}

	public void storeSAPinLocal(String xmlString, String filename) {
		// keep in local folder
		try {
			File outputFolder = new File("sapxml");
			if (!outputFolder.exists()) {
				System.out.println("creating FOLDER");
				outputFolder.mkdir();
				System.out.println(outputFolder.getPath());
			}
			File sapFile = new File("sapxml/" + filename);
			sapFile.createNewFile();
			FileWriter fw = new FileWriter(sapFile);
			fw.write(xmlString);
			fw.close();
			logger.debug("Created SAP xml:" + filename);
		} catch (IOException e) {
			logger.debug("Error creating the SAP xml file", e);
		}
	}

}
