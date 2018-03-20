package com.kraft.pim.preprocess;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.microsoft.windowsazure.serviceruntime.RoleEnvironment;

public class InboundProperties {
	public static int downloadCount = 0;
	public static String accountName;
	public static String accountKey;
	public static String defaultEndpointProtocol;
	public static String storageConnectionString;
	public static String successSAPContainer;
	public static String failSAPContainer;
	public static String iiepUploadUrl;
	public static String bgpUrl;
	public static String stepUser;
	public static String stepPwd;
	public static String stepHost;
	public static int stepPort = 0;
	public static SimpleDateFormat bgpDateFormat;
	public static String containerName;
	public static SimpleDateFormat cloudDateFormat;
	public static String outputPath;
	public static SimpleDateFormat sapDateFormat;
	public static SimpleDateFormat stepDateFormat;
	public static SimpleDateFormat crossPlantDateFormat;
	public static String bgpProcessTag;
	public static String bgpCreated;
	public static String bgpStatus;
	public static String bgpID;
	public static String bgpStatusFailed;
	public static String failWaitTime;
	public static String appWaitTime;
	public static String tmpFolder;
	public static String cloudRecieverID;
	public static String stepRecieverID;
	public static String senderID;
	public static String senderPwd;
	public static String senderDomain;
	public static String emailHost;
	public static String emailHostType;
	public static String emailDownloadFailSubject;
	public static String emailDownloadFailContent;
	public static String emailUploadFailSubject;
	public static String emailUploadFailContent;
	public static String emailConversionFailSubject;
	public static String emailConversionFailContent;
	public static String contextID;
	public static String frContextID;
	public static String assetCrossRefTypePrimary;
	public static String assetCrossRefTypeSecondary;
	public static String orderableRootParentID;
	public static String palletRootID;
	public static String palletSubbrandType;
	public static String palletFunctionalNameType;
	public static String consumerRootID;
	public static String consumerSubbrandType;
	public static String consumerFunctionalNameType;
	public static String assetRootID;
	public static String assetClassificationType;
	public static String assetType;
	public static String imageEndDate;
	public static String imageFileFormat;
	public static String imageFileName;
	public static String imageStartDate;
	public static String imageType;
	public static String imageUrl;
	public static SimpleDateFormat imageDateFormat;
	public static String engLangCode;
	public static String freLangCode;
	public static SimpleDateFormat appDateFormat;
	public static String workspaceID;
	public static String removedFromRecipies;
	public static int nutritionalAttributeIndex;
	public static int otherNutritionalAttributeIndex;
	public static int declaredContentIndex;

	public static Properties props;
	public static int leaseTime = 1;

	public static final String propsFile = "azure-config.properties";

	static final Logger logger = Logger.getLogger(InboundProperties.class);
	static {
		try {
			props = new Properties();
			props.load(InboundProperties.class.getClassLoader()
					.getResourceAsStream("azure-config.properties"));
			if (RoleEnvironment.isAvailable()) {
				Map<String, String> configMap = RoleEnvironment
						.getConfigurationSettings();
				appWaitTime = configMap.get("app-wait-time");
			} else {
				appWaitTime = props.getProperty("app-wait-time");
			}
		} catch (Exception e) {
			logger.error("Error loading properties file", e);
		}
	}

	public static void loadProperties() {

		logger.debug("Loading properties");

		// Loading properties from local properties file
		downloadCount = Integer.parseInt(props.getProperty("download-count"));
		accountName = props.getProperty("account-name");
		accountKey = props.getProperty("account-key");
		defaultEndpointProtocol = props.getProperty("default-endpint-protocol");
		storageConnectionString = "DefaultEndpointsProtocol="
				+ defaultEndpointProtocol + ";AccountName=" + accountName
				+ ";AccountKey=" + accountKey + ";";
		containerName = props.getProperty("container-name");
		successSAPContainer = props.getProperty("container-name-sap-success");
		failSAPContainer=props.getProperty("container-name-sap-failed");
		cloudDateFormat = new SimpleDateFormat(props.getProperty("date-format"));
		leaseTime = Integer.parseInt(props.getProperty("blob-lease-time"));
		stepHost = props.getProperty("step-server");
		stepPort = Integer.parseInt(props.getProperty("step-port"));
		iiepUploadUrl = "http://"
				+ stepHost
				+ props.getProperty("step-iiep-url").replace("ID",
						props.getProperty("iiep-id"));
		bgpUrl = "http://"
				+ stepHost
				+ props.getProperty("step-iiep-bgp-url").replace("ID",
						props.getProperty("iiep-id"));
		bgpProcessTag = props.getProperty("bgp-process-tag");
		bgpCreated = props.getProperty("bgp-process-attr-created");
		bgpStatus = props.getProperty("bgp-process-attr-status");
		bgpID = props.getProperty("bgp-process-attr-id");
		bgpStatusFailed = props.getProperty("bgp-status-failed");
		tmpFolder = props.getProperty("tmp-folder");
		cloudRecieverID = props.getProperty("email-reciever-cloud");
		stepRecieverID = props.getProperty("email-reciever-step");
		senderID = props.getProperty("email-sender");
		senderPwd = new String(Base64.decodeBase64(props.getProperty("email-sender-password")));
		senderDomain= props.getProperty("email-sender-domain");
		emailHost = props.getProperty("email-host");
		emailHostType = props.getProperty("email-host-type");
		stepUser = props.getProperty("step-user");
		stepPwd = new String(Base64.decodeBase64(props.getProperty("step-pwd")));
		bgpDateFormat = new SimpleDateFormat(
				props.getProperty("bgp-date-format"));
		bgpDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		stepDateFormat = new SimpleDateFormat(
				props.getProperty("step-date-format"));
		crossPlantDateFormat= new SimpleDateFormat(props.getProperty("cross-plant-date-format"));
		sapDateFormat = new SimpleDateFormat(
				props.getProperty("sap-date-format"));
		outputPath = props.getProperty("output-path");
		failWaitTime = props.getProperty("try-fail-wait-time");

		emailDownloadFailSubject = props
				.getProperty("email-download-fail-subject");
		emailDownloadFailContent = props
				.getProperty("email-download-fail-text");
		emailUploadFailSubject = props.getProperty("email-upload-fail-subject");
		emailUploadFailContent = props.getProperty("email-upload-fail-text");
		emailConversionFailSubject = props
				.getProperty("email-conversion-fail-subject");
		emailConversionFailContent = props
				.getProperty("email-conversion-fail-text");
		contextID = props.getProperty("context-id");
		frContextID = props.getProperty("context-id-fr");
		assetCrossRefTypePrimary = props
				.getProperty("asset-cross-reference-type-primary");
		assetCrossRefTypeSecondary = props
				.getProperty("asset-cross-reference-type-secondary");
		orderableRootParentID = props.getProperty("orderable-root-parent-id");
		palletRootID = props.getProperty("pallet-root");
		palletSubbrandType = props.getProperty("pallet-subbrand-type");
		palletFunctionalNameType = props
				.getProperty("pallet-functional-name-type");
		consumerRootID = props.getProperty("consumer-root");
		consumerSubbrandType = props.getProperty("consumer-subbrand-type");
		consumerFunctionalNameType = props
				.getProperty("consumer-functional-name-type");
		assetRootID = props.getProperty("asset-root");
		assetClassificationType = props.getProperty("asset-classification-type");
		assetType = props.getProperty("asset-type");
		imageEndDate = props.getProperty("image-end-date");
		imageFileFormat = props.getProperty("image-file-format");
		imageFileName = props.getProperty("image-file-name");
		imageStartDate = props.getProperty("image-start-date");
		imageType = props.getProperty("image-type");
		imageUrl = props.getProperty("image-url");
		imageDateFormat = new SimpleDateFormat(
				props.getProperty("image-date-format"));
		engLangCode = props.getProperty("lang-code-eng");
		freLangCode = props.getProperty("lang-code-fre");
		appDateFormat = new SimpleDateFormat(
				props.getProperty("app-date-format"));
		workspaceID = props.getProperty("workspace-id");
		removedFromRecipies=props.getProperty("remove-from-kraft-recipies");
		nutritionalAttributeIndex=Integer.parseInt(props.getProperty("nutritional-index"));
		otherNutritionalAttributeIndex=Integer.parseInt(props.getProperty("other-nutritional-index"));
		declaredContentIndex=Integer.parseInt(props.getProperty("declared-content-index"));

		// Loading properties inside Cloud Environment
		if (RoleEnvironment.isAvailable()) {
			Map<String, String> configMap = RoleEnvironment
					.getConfigurationSettings();
			downloadCount = Integer.parseInt(configMap.get("download-count"));
			accountName = configMap.get("account-name");
			accountKey = configMap.get("account-key");
			defaultEndpointProtocol = configMap.get("default-endpint-protocol");
			storageConnectionString = "DefaultEndpointsProtocol="
					+ defaultEndpointProtocol + ";AccountName=" + accountName
					+ ";AccountKey=" + accountKey + ";";
			containerName = configMap.get("container-name");
			successSAPContainer = configMap.get("container-name-sap-success");
			failSAPContainer=configMap.get("container-name-sap-failed");
			cloudDateFormat = new SimpleDateFormat(configMap.get("date-format"));
			leaseTime = Integer.parseInt(configMap.get("blob-lease-time"));
			stepHost = configMap.get("step-server");
			stepPort = Integer.parseInt(configMap.get("step-port"));
			iiepUploadUrl = "http://"
					+ stepHost
					+ configMap.get("step-iiep-url").replace("ID",
							configMap.get("iiep-id"));
			bgpUrl = "http://"
					+ stepHost
					+ configMap.get("step-iiep-bgp-url").replace("ID",
							configMap.get("iiep-id"));
			bgpProcessTag = configMap.get("bgp-process-tag");
			bgpCreated = configMap.get("bgp-process-attr-created");
			bgpStatus = configMap.get("bgp-process-attr-status");
			bgpID = configMap.get("bgp-process-attr-id");
			bgpStatusFailed = configMap.get("bgp-status-failed");
			tmpFolder = configMap.get("tmp-folder");
			cloudRecieverID = configMap.get("email-reciever-cloud");
			stepRecieverID = configMap.get("email-reciever-step");
			senderID = configMap.get("email-sender");
			senderPwd = new String(Base64.decodeBase64(configMap.get("email-sender-password")));
			senderDomain= props.getProperty("email-sender-domain");
			emailHost = configMap.get("email-host");
			emailHostType = configMap.get("email-host-type");
			stepUser = configMap.get("step-user");
			stepPwd = new String(Base64.decodeBase64(configMap.get("step-pwd")));
			bgpDateFormat = new SimpleDateFormat(
					configMap.get("bgp-date-format"));
			bgpDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			stepDateFormat = new SimpleDateFormat(
					configMap.get("step-date-format"));
			crossPlantDateFormat= new SimpleDateFormat(configMap.get("cross-plant-date-format"));
			sapDateFormat = new SimpleDateFormat(
					configMap.get("sap-date-format"));
			outputPath = configMap.get("output-path");
			failWaitTime = configMap.get("try-fail-wait-time");

			emailDownloadFailSubject = configMap
					.get("email-download-fail-subject");
			emailDownloadFailContent = configMap
					.get("email-download-fail-text");
			emailUploadFailSubject = configMap.get("email-upload-fail-subject");
			emailUploadFailContent = configMap.get("email-upload-fail-text");
			emailConversionFailSubject = configMap
					.get("email-conversion-fail-subject");
			emailConversionFailContent = configMap
					.get("email-conversion-fail-text");
			contextID = configMap.get("context-id");
			frContextID = configMap.get("context-id-fr");
			assetCrossRefTypePrimary = configMap
					.get("asset-cross-reference-type-primary");
			assetCrossRefTypeSecondary = configMap
					.get("asset-cross-reference-type-secondary");
			orderableRootParentID = configMap.get("orderable-root-parent-id");
			palletRootID = configMap.get("pallet-root");
			palletSubbrandType = configMap.get("pallet-subbrand-type");
			palletFunctionalNameType = configMap
					.get("pallet-functional-name-type");
			consumerRootID = configMap.get("consumer-root");
			consumerSubbrandType = configMap.get("consumer-subbrand-type");
			consumerFunctionalNameType = configMap
					.get("consumer-functional-name-type");
			assetType = configMap.get("asset-type");
			imageEndDate = configMap.get("image-end-date");
			imageFileFormat = configMap.get("image-file-format");
			imageFileName = configMap.get("image-file-name");
			imageStartDate = configMap.get("image-start-date");
			imageType = configMap.get("image-type");
			imageUrl = configMap.get("image-url");
			imageDateFormat = new SimpleDateFormat(
					configMap.get("image-date-format"));
			engLangCode = configMap.get("lang-code-eng");
			freLangCode = configMap.get("lang-code-fre");
			appDateFormat = new SimpleDateFormat(
					configMap.get("app-date-format"));
			workspaceID = configMap.get("workspace-id");
			removedFromRecipies=configMap.get("remove-from-kraft-recipies");
			nutritionalAttributeIndex=Integer.parseInt(configMap.get("nutritional-index"));
			otherNutritionalAttributeIndex=Integer.parseInt(configMap.get("other-nutritional-index"));
			declaredContentIndex=Integer.parseInt(configMap.get("declared-content-index"));
		}

	}

	public static String loadProperty(String propKey) {
		String propVal = "";
		propVal = props.getProperty(propKey);
		if (RoleEnvironment.isAvailable()) {
			Map<String, String> configMap = RoleEnvironment
					.getConfigurationSettings();
			propVal = configMap.get(propKey);
		}
		return propVal;
	}

}
