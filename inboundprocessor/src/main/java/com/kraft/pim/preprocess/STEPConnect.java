package com.kraft.pim.preprocess;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.LinkedList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kraft.pim.step.STEPProductInformation;

public class STEPConnect {

	private static final String stepSchemaPath = "com.kraft.pim.step";

	private static final Logger logger = Logger.getLogger(STEPConnect.class);

	/*public static void main(String[] args) throws Exception {
		System.out.println("STEPCONNECT main");
		JAXBContext jaxbContext = JAXBContext.newInstance(stepSchemaPath);
		STEPProductInformation productInfo = (STEPProductInformation) jaxbContext
				.createUnmarshaller().unmarshal(
						new File("STEP-2014-11-21--08-23-33-816.xml"));
		LinkedList<STEPProductInformation> prodInfoList = new LinkedList<STEPProductInformation>();
		prodInfoList.add(productInfo);
		new STEPConnect().iiepUpload(prodInfoList);
	}*/

	public boolean iiepUpload(LinkedList<STEPProductInformation> productInfoList) {
		int listSize = productInfoList.size();
		int resultSum = 0;
		boolean result = false;
		for (STEPProductInformation productInfo : productInfoList) {
			result = iiepUploadSingleFile(productInfo);
			
//			result=uploadToLocal(productInfo);
			
			
			logger.debug("Uploaded Step Xml with result:" + result);
			if (result) {
				resultSum++;
			}
		}
		if (resultSum == listSize) {
			return true;
		} else {
			return false;
		}
	}

	private boolean iiepUploadSingleFile(STEPProductInformation productInfo) {
		boolean result = false;

		// StringWriter writer = new StringWriter();
		JAXBContext jaxbContext;
		logger.info("Beginning uploading STEP xml to Integration Endpoint");
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();

		BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(new AuthScope(
				InboundProperties.stepHost, InboundProperties.stepPort),
				new UsernamePasswordCredentials(InboundProperties.stepUser,
						InboundProperties.stepPwd));
		clientBuilder.setDefaultCredentialsProvider(credentialsProvider);

		CloseableHttpClient httpClient = clientBuilder.build();
		Date startDate = new Date();

		try {
			jaxbContext = JAXBContext.newInstance(stepSchemaPath);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(productInfo, byteStream);
			String xmlString =byteStream.toString("UTF-8");
			
			logger.debug("Uploading xml string:" + xmlString);
			logger.info("Connecting to IIEP");
			HttpPost postRequest = new HttpPost(InboundProperties.iiepUploadUrl);
			postRequest.addHeader("Content-Type", "application/xml");
			StringEntity userEntity = new StringEntity(xmlString,
					Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(new InputStreamReader(userEntity.getContent()));
			String k = null;
			logger.info("STREAM");
			while((k=br.readLine())!=null) {
				logger.info(k);
			}
			postRequest.setEntity(userEntity);			
			logger.info("Uploading STEP xml to connected IIEP");
			/*HttpResponse response = httpClient.execute(postRequest);

			int statusCode = response.getStatusLine().getStatusCode();
			String reason = response.getStatusLine().getReasonPhrase();
			logger.info("Response Code on Uploading STEP xml to IIEP:"
					+ statusCode);
			if (statusCode != 204) {
				throw new RuntimeException("Failed with HTTP error code : "
						+ statusCode + " - Reason : " + reason);
			}*/
			result = true;

			/*// Analyzing BGP for upload
			String bgpStatus = "";
			try {
				bgpStatus = getBgProcess(httpClient, startDate);
			} catch (Exception e) {
				logger.error("Error fetching Background Process Details", e);
			}
			if (bgpStatus.equals(InboundProperties.bgpStatusFailed)) {
				result = false;
			}*/
			
		} catch (Exception e) {
			logger.error("Error uploading STEP xml ", e);
		} finally {

			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("Error while closing connection", e);
			}
		}
		return result;
	}

	private String getBgProcess(HttpClient httpClient, Date startDate)
			throws Exception {

		HttpGet getRequest = new HttpGet(InboundProperties.bgpUrl);

		logger.info("Connecting to IIEP");
		HttpResponse response = httpClient.execute(getRequest);

		int statusCode = response.getStatusLine().getStatusCode();

		logger.info("Response Code on requesting for BGPs:" + statusCode);

		return analyseBgpResponse(response.getEntity().getContent(), startDate);

	}

	private String analyseBgpResponse(InputStream bgpInReader, Date startDate)
			throws Exception {
		logger.debug("Analysing BGPs");

		Document bgpXml = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(bgpInReader);
		NodeList bgpList = bgpXml
				.getElementsByTagName(InboundProperties.bgpProcessTag);
		String bgpStatus = "";
		String bgpID = null;
		int bgpId = 0;
		int tempId = 0;

		for (int i = 0; i < bgpList.getLength(); i++) {
			Node bgpNode = bgpList.item(i);
			NamedNodeMap bgpAttrMap = bgpNode.getAttributes();
			Date bgpDate = InboundProperties.bgpDateFormat.parse(bgpAttrMap
					.getNamedItem(InboundProperties.bgpCreated).getNodeValue());

			if (bgpDate.equals(startDate) || bgpDate.after(startDate)) {

				tempId = Integer.parseInt(bgpAttrMap
						.getNamedItem(InboundProperties.bgpID).getNodeValue()
						.replace("BGP_", ""));

				if (bgpId < tempId) {
					bgpStatus = bgpAttrMap.getNamedItem(
							InboundProperties.bgpStatus).getNodeValue();
					bgpID = bgpAttrMap.getNamedItem(InboundProperties.bgpID)
							.getNodeValue();
					bgpId = tempId;
				}
			}
		}

		logger.debug("BGP identified with ID " + bgpID + " and status "
				+ bgpStatus);
		return bgpStatus;
	}

	public boolean uploadToLocal(STEPProductInformation productInfo) {
		boolean result = false;

		// StringWriter writer = new StringWriter();
		JAXBContext jaxbContext;
		logger.info("Beginning uploading STEP xml to Integration Endpoint");
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();

//		BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//		credentialsProvider.setCredentials(new AuthScope(
//				InboundProperties.stepHost, InboundProperties.stepPort),
//				new UsernamePasswordCredentials(InboundProperties.stepUser,
//						InboundProperties.stepPwd));
//		clientBuilder.setDefaultCredentialsProvider(credentialsProvider);

		CloseableHttpClient httpClient = clientBuilder.build();
		Date startDate = new Date();

		try {
			jaxbContext = JAXBContext.newInstance(stepSchemaPath);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(productInfo, byteStream);
			String xmlString = byteStream.toString("UTF-8");
			logger.debug("Uploading xml string:" + xmlString);
			logger.info("Connecting to IIEP");
			HttpPost postRequest = new HttpPost("http://localhost:8080/sample-rest/upload");
			postRequest.addHeader("Content-Type", "application/xml");
			StringEntity userEntity = new StringEntity(xmlString);
			System.out.println("UTF8:");
			// userEntity.writeTo(System.out);
			postRequest.setEntity(userEntity);
			logger.info("Uploading STEP xml to connected IIEP");
			HttpResponse response = httpClient.execute(postRequest);

			int statusCode = response.getStatusLine().getStatusCode();
			String reason = response.getStatusLine().getReasonPhrase();
			logger.info("Response Code on Uploading STEP xml to IIEP:"
					+ statusCode);
			System.out.println(reason);
			result = true;

			
		} catch (Exception e) {
			logger.error("Error uploading STEP xml ", e);
		} finally {

			try {
				httpClient.close();
			} catch (IOException e) {
				logger.error("Error while closing connection", e);
			}
		}
		return result;
	}
}
