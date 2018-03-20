package com.kraft.pim.preprocess;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.kraft.pim.sap.Products;
import com.kraft.pim.sap.ProductsMsg;
import com.kraft.pim.sap.TALLERGENDATA;
import com.kraft.pim.sap.TCHILDPACKAGINGRELATIONSHIPS;
import com.kraft.pim.sap.TCOUNTRIES;
import com.kraft.pim.sap.TDECLAREDNETCONTENTDATA;
import com.kraft.pim.sap.TECOMMERCEIMAGEDATA;
import com.kraft.pim.sap.TGENERALMARKETINGDESCRIPTIONS;
import com.kraft.pim.sap.TINGREDIENTINFORMATIONDATA;
import com.kraft.pim.sap.TNUTRITIONALDATA;
import com.kraft.pim.sap.TPARENTPACKAGINGRELATIONSHIPS;
import com.kraft.pim.sap.TPCLRECORD;
import com.kraft.pim.sap.TPREPARATIONANDCOOKINGSUGGESTIONS;
import com.kraft.pim.sap.TPRODUCTBENEFITS;
import com.kraft.pim.sap.TSERVINGSUGGESTIONS;
import com.kraft.pim.sap.TSUITABILITYINFORMATIONDATA;
import com.kraft.pim.step.AssetCrossReferenceType;
import com.kraft.pim.step.AssetType;
import com.kraft.pim.step.AssetsType;
import com.kraft.pim.step.ClassificationReferenceType;
import com.kraft.pim.step.ClassificationType;
import com.kraft.pim.step.ClassificationsType;
import com.kraft.pim.step.MetaDataType;
import com.kraft.pim.step.MultiValueType;
import com.kraft.pim.step.NameType;
import com.kraft.pim.step.ProductCrossReferenceType;
import com.kraft.pim.step.ProductType;
import com.kraft.pim.step.ProductsType;
import com.kraft.pim.step.STEPProductInformation;
import com.kraft.pim.step.ValueType;
import com.kraft.pim.step.ValuesType;
import com.kraft.pim.step.YesNoType;

public class ParseSap {

	private static final String sapSchemaPath = "com.kraft.pim.sap";
	private static final String stepSchemaPath = "com.kraft.pim.step";

	/**
	 * Unit Descriptor Code for the main Product
	 */
	private static String unitDescCode = "";

	/**
	 * ID for the main Product
	 */
	private static String productId = "";

	/**
	 * Object Type of main product
	 */
	private static String userTypeId = "";

	/**
	 * Name of main Product from Consumer Unit
	 */
	private static String productDescShort = "";

	/**
	 * Name for main Product from Orderable and Unorderable
	 */
	private String catalystCodeName = "";

	/**
	 * ID for parent of main product from Ordarable
	 */
	private static String orderableParentId = "";

	/**
	 * ID for parent of main product from Unorderable
	 */
	private static String unorderableParentId = "";

	/**
	 * Id for parent of main product from Consumer Unit
	 */
	private static String consumerParentId = "";
	/**
	 *  List of all the Nutritional Attributes except other Nutritional
	 */
	List<String> nutrAllAttributes=new ArrayList<String>();

	/**
	 *  List of Other Nutritional Attributes except Ingredient
	 */
	List<String> otherNutrAllAttributes=new ArrayList<String>();
	/**
	 *  List of Declared Net Content except F_DECLARED_NET_CONTENT & F_DECLARED_NET_CONTENT_UOM_CODE
	 */
	List<String> declareAllNetContent=new ArrayList<String>();

	/**
	 * 
	 * Declaring Sevlet context for setting Attribute List
	 */
	ServletContext context;

	private static final Logger logger = Logger.getLogger(ParseSap.class);

	public LinkedList<STEPProductInformation> parse(String inputFile,ServletContext context)
			throws Exception {

		logger.debug("Input file String:" + inputFile);
		LinkedList<STEPProductInformation> stepList = new LinkedList<STEPProductInformation>();
		STEPProductInformation prodInfo = new STEPProductInformation();
		STEPProductInformation freProdInfo = new STEPProductInformation();
		STEPProductInformation childProdInfo = new STEPProductInformation();
		ProductsType stepProducts = new ProductsType();
		ProductsType freStepProductsType = new ProductsType();
		ProductsType stepChildProducts = new ProductsType();
		ClassificationsType stepClassifications = new ClassificationsType();
		List<ProductType> productTypeList = null;
		List<ClassificationType> classificationTypeList = null;
		NameType nameType = null;
		ProductsMsg productMsg = null;
		this.context=context;

		logger.debug("Creating JAXBContext");
		JAXBContext sapContext = JAXBContext.newInstance(sapSchemaPath);
		productMsg = (ProductsMsg) sapContext.createUnmarshaller().unmarshal(
				new ByteArrayInputStream(inputFile.getBytes("UTF-8")));
		prodInfo.setContextID(InboundProperties.contextID);
		//prodInfo.setAutoApprove(YesNoType.Y);
		prodInfo.setWorkspaceID(InboundProperties.workspaceID);

		freProdInfo.setContextID(InboundProperties.frContextID);
		//freProdInfo.setAutoApprove(YesNoType.Y);
		freProdInfo.setWorkspaceID(InboundProperties.workspaceID);

		childProdInfo.setReplaceProductToProductCrossReferences(YesNoType.Y);
		childProdInfo.setContextID(InboundProperties.contextID);
		//childProdInfo.setAutoApprove(YesNoType.Y);
		childProdInfo.setWorkspaceID(InboundProperties.workspaceID);

		for (Products sapProducts : productMsg.getProducts()) {
			ProductType mainProduct = new ProductType();

			nameType = new NameType();

			// GTIN of the main Product
			if (sapProducts.getFGTIN() != null) {
				productId = sapProducts.getFGTIN();
				logger.info("GTIN for the main product:" + productId);
			}


			// Unit Descriptor Code of the main product
			if (sapProducts.getFUNITDESCRIPTOR() != null) {
				if (sapProducts.getFUNITDESCRIPTOR().getFUNITDESCRIPTORCODE() != null) {
					unitDescCode = sapProducts.getFUNITDESCRIPTOR()
							.getFUNITDESCRIPTORCODE();
					logger.info("Unit Descriptor Code for the main Product:"
							+ unitDescCode);
				}
			}

			// F_PRODUCT_DESCRIPTION_SHORT
			if (null != sapProducts.getFPRODUCTDESCRIPTIONSHORT()) {
				productDescShort = sapProducts.getFPRODUCTDESCRIPTIONSHORT();
			}
			userTypeId = InboundProperties.loadProperty(unitDescCode
					.replaceAll("/", "-").replaceAll(" ", "-").toLowerCase());

			mainProduct.setID(productId);
			mainProduct.setUserTypeID(userTypeId);

			/* Add Parent Product Hierarchy */
			if (!unitDescCode.isEmpty()) {
				productTypeList = new ArrayList<ProductType>();

				/* Parent Hierarchy for Orderable */
				if ("CASE".equals(unitDescCode)
						|| "DISPLAY/SHIPPER".equals(unitDescCode)
						|| "MIXED MODULE".equals(unitDescCode)) {
					productTypeList = extractOrderableParentHierarchy(sapProducts);
					/*
					 * if (!productTypeList.isEmpty()) {
					 * stepProducts.getProduct().addAll(productTypeList); }
					 */
					mainProduct.setParentID(orderableParentId);
					nameType.setContent(productDescShort);
					mainProduct.getName().add(nameType);
				}
				/* Parent Hierarchy for Unordereable */
				else if ("PALLET".equals(unitDescCode)) {
					productTypeList = extractUnorderedParentHierarchy(sapProducts);
					/*
					 * if (!productTypeList.isEmpty()) {
					 * stepProducts.getProduct().addAll(productTypeList); }
					 */
					mainProduct.setParentID(unorderableParentId);
					nameType.setContent(productDescShort);
					mainProduct.getName().add(nameType);
				}
				/* Parent Hierarchy for Consumer Unit */
				else if ("EACH".equals(unitDescCode)
						|| "PACK/INNER PACK".equals(unitDescCode)) {
					productTypeList = extractConsumerParentHierarchy(sapProducts);
					/*
					 * if (!productTypeList.isEmpty()) {
					 * stepProducts.getProduct().addAll(productTypeList); }
					 */
					// F_PRODUCT_DESCRIPTION_SHORT
					if (null != sapProducts.getFPRODUCTDESCRIPTIONSHORT()) {
						productDescShort = sapProducts
								.getFPRODUCTDESCRIPTIONSHORT();
					}
					mainProduct.setParentID(consumerParentId);
					nameType.setContent(productDescShort);
					mainProduct.getName().add(nameType);
				}
			}

			/* Add attributes and child product references */
			mainProduct = getUpdatedProduct(sapProducts, mainProduct);

			// Add child Product References
			ProductType childProduct = extractChildProductRef(sapProducts);
			if (!childProduct
					.getProductOrSequenceProductOrSuppressedProductCrossReference()
					.isEmpty()) {
				childProduct.setID(productId);
				childProduct.setUserTypeID(userTypeId);
				stepChildProducts.getProduct().add(childProduct);
			}


			if (!productTypeList.isEmpty()) {
				stepProducts.getProduct().addAll(productTypeList);
			}

			stepProducts.getProduct().add(mainProduct);

			/* Add Parent Product References */
			stepProducts.getProduct().addAll(getParentProductRef(sapProducts));

			/* Add Parent Hierarchy for Assets */
			/*classificationTypeList = new ArrayList<ClassificationType>();
			classificationTypeList = extractAssetParentHierarchy(sapProducts);
			if (!classificationTypeList.isEmpty()) {
				stepClassifications.getClassification().addAll(classificationTypeList);
			}*/

			/* Add Assets */
			/* Parent Hierarchy for Consumer Unit */
			/*if (!("EACH".equals(unitDescCode))){
				prodInfo.setAssets(extractAssets(sapProducts));	
			}*/


			/* Extract French dependent Attributes */
			ValuesType frenchValuesType = extractFrenchAttributes(sapProducts);
			if (!frenchValuesType.getValueOrMultiValueOrValueGroup().isEmpty()) {
				ProductType freProduct = new ProductType();
				freProduct.setID(productId);
				freProduct.setUserTypeID(userTypeId);
				freProduct
				.getProductOrSequenceProductOrSuppressedProductCrossReference()
				.add(frenchValuesType);
				freStepProductsType.getProduct().add(freProduct);
			}
		}

		//prodInfo.setClassifications(stepClassifications);
		prodInfo.setProducts(stepProducts);
		stepList.add(prodInfo);

		if (!freStepProductsType.getProduct().isEmpty()) {
			freProdInfo.setProducts(freStepProductsType);
			stepList.add(freProdInfo);
		}
		if (!stepChildProducts.getProduct().isEmpty()) {
			childProdInfo.setProducts(stepChildProducts);
			stepList.add(childProdInfo);
		}

		return stepList;
	}

	/* Add the main Product to STEP xml */
	public ProductType getUpdatedProduct(Products sapProducts,
			ProductType productType) {
		logger.debug("Updating STEP Product");

		ValuesType values = new ValuesType();

		// Add attributes to the main Product
		extractAttributes(sapProducts, values);

		productType
		.getProductOrSequenceProductOrSuppressedProductCrossReference()
		.add(values);

		/*productType
		.getProductOrSequenceProductOrSuppressedProductCrossReference()
		.addAll(addAssetCrossRefence(sapProducts));*/

		return productType;
	}

	/* Add AssetCrossReference */
	/*private List<AssetCrossReferenceType> addAssetCrossRefence(
			Products sapProducts) {
		List<AssetCrossReferenceType> assetRefList = new ArrayList<AssetCrossReferenceType>();
		AssetCrossReferenceType assetRef;
		if (null != sapProducts.getFECOMMERCEIMAGES()) {
			for (TECOMMERCEIMAGEDATA ecomData : sapProducts
					.getFECOMMERCEIMAGES()) {
				assetRef = new AssetCrossReferenceType();
				assetRef.setAssetID(ecomData.getFECOMMERCEIMAGEFILENAME());
				if (ecomData.getFECOMMERCEIMAGEFILENAME().endsWith("_A1L1")) {
					assetRef.setType(InboundProperties.assetCrossRefTypePrimary);
				} else {
					assetRef.setType(InboundProperties.assetCrossRefTypeSecondary);
				}
				assetRefList.add(assetRef);
			}
		}
		return assetRefList;
	}*/

	/* Add Child Product references */
	private ProductType extractChildProductRef(Products sapProducts) {
		ProductType productType = new ProductType();
		logger.debug("Populating child product references");
		if (sapProducts.getFCHILDPACKAGINGRELATIONSHIP() != null
				&& !sapProducts.getFCHILDPACKAGINGRELATIONSHIP().isEmpty()) {

			for (TCHILDPACKAGINGRELATIONSHIPS childRelation : sapProducts
					.getFCHILDPACKAGINGRELATIONSHIP()) {
				if (childRelation.getFCHILDKRAFTITEMCODE() != null
						&& !childRelation.getFCHILDKRAFTITEMCODE().isEmpty()) {
					ProductCrossReferenceType prodRef;
					String childUnitDescCode = "";
					for (TPCLRECORD childCode : childRelation
							.getFCHILDKRAFTITEMCODE()) {
						prodRef = new ProductCrossReferenceType();
						prodRef.setProductID(childCode.getFGTIN());
						logger.debug("Child GTIN:" + childCode.getFGTIN());
						if (childCode.getFUNITDESCRIPTOR() != null) {
							if (childCode.getFUNITDESCRIPTOR()
									.getFUNITDESCRIPTORCODE() != null) {
								childUnitDescCode = childCode
										.getFUNITDESCRIPTOR()
										.getFUNITDESCRIPTORCODE();
								logger.debug("Child Unit Descriptor Code:"
										+ childUnitDescCode);
								prodRef.setType(InboundProperties.loadProperty(InboundProperties
										.loadProperty(unitDescCode
												.replaceAll("/", "-")
												.replaceAll(" ", "-")
												.toLowerCase())
												+ "-"
												+ InboundProperties
												.loadProperty(childUnitDescCode
														.replaceAll("/", "-")
														.replaceAll(" ", "-")
														.toLowerCase())));
								MetaDataType metaDataType = new MetaDataType();
								if (null != sapProducts
										.getFCHILDPACKAGINGRELATIONSHIP()
										&& !sapProducts
										.getFCHILDPACKAGINGRELATIONSHIP()
										.isEmpty()) {
									if (null != sapProducts
											.getFCHILDPACKAGINGRELATIONSHIP()
											.get(0)
											.getFCHILDPACKAGINGQUANTITY()) {
										ValueType valueType = new ValueType();
										valueType
										.setAttributeID("F_CHILD_PACKAGING_QUANTITY");
										valueType
										.setContent(sapProducts
												.getFCHILDPACKAGINGRELATIONSHIP()
												.get(0)
												.getFCHILDPACKAGINGQUANTITY());
										metaDataType
										.getValueOrMultiValueOrValueGroup()
										.add(valueType);
										prodRef.setMetaData(metaDataType);
									}
								}

								productType
								.getProductOrSequenceProductOrSuppressedProductCrossReference()
								.add(prodRef);
							}
						}

					}
				}
			}
		}
		return productType;
	}

	/* Add Parent Product References */
	private List<ProductType> getParentProductRef(Products sapProducts) {
		logger.debug("Populating parent product references");
		ArrayList<ProductType> parentList = new ArrayList<ProductType>();
		if (sapProducts.getFPARENTPACKAGINGRELATIONSHIP() != null
				&& !sapProducts.getFPARENTPACKAGINGRELATIONSHIP().isEmpty()) {
			for (TPARENTPACKAGINGRELATIONSHIPS parentRelation : sapProducts
					.getFPARENTPACKAGINGRELATIONSHIP()) {
				if (parentRelation.getFPARENTKRAFTITEMCODE() != null
						&& !parentRelation.getFPARENTKRAFTITEMCODE().isEmpty()) {

					String parentID = "";
					for (TPCLRECORD parentCode : parentRelation
							.getFPARENTKRAFTITEMCODE()) {
						parentID = parentCode.getFGTIN();
						if (parentCode.getFUNITDESCRIPTOR() != null && parentID != null) {
							ProductType parentProduct = new ProductType();
							parentProduct.setID(parentID);

							parentProduct
							.setUserTypeID(InboundProperties
									.loadProperty(parentCode
											.getFUNITDESCRIPTOR()
											.getFUNITDESCRIPTORCODE()
											.replaceAll("/", "-")
											.replaceAll(" ", "-")
											.toLowerCase()));
							ProductCrossReferenceType prodRef = new ProductCrossReferenceType();
							prodRef.setProductID(productId);
							String parentUnitCode = parentCode
									.getFUNITDESCRIPTOR()
									.getFUNITDESCRIPTORCODE()
									.replaceAll("/", "-").replaceAll(" ", "-")
									.toLowerCase();
							prodRef.setType(InboundProperties
									.loadProperty(InboundProperties
											.loadProperty(parentUnitCode)
											+ "-"
											+ InboundProperties
											.loadProperty(unitDescCode
													.replaceAll("/",
															"-")
															.replaceAll(" ",
																	"-")
																	.toLowerCase())));

							MetaDataType metaDataType = new MetaDataType();

							if (parentRelation.getFPARENTPACKAGINGQUANTITY() != null){
								ValueType valueType = new ValueType();
								valueType
								.setAttributeID("F_CHILD_PACKAGING_QUANTITY");
								valueType.setContent(parentRelation
										.getFPARENTPACKAGINGQUANTITY());
								metaDataType.getValueOrMultiValueOrValueGroup().add(valueType);
								prodRef.setMetaData(metaDataType);
							}
							parentProduct
							.getProductOrSequenceProductOrSuppressedProductCrossReference()
							.add(prodRef);
							parentList.add(parentProduct);
						}
					}
				}
			}

		}
		return parentList;
	}

	/* Add Orderable Parent Product Hierarchy */
	private List<ProductType> extractOrderableParentHierarchy(
			Products sapProducts) {
		logger.debug("Populating Previous parent Hierarchy for Orderable");
		orderableParentId = "";
		ArrayList<ProductType> prodList = new ArrayList<ProductType>();
		// Gtin of the parent product
		if (sapProducts.getFPRODUCTHIERARCHYCATALYST()
				.getFPRODUCTHIERARCHYCATALYSTCODE() != null) {
			String catCodeString = sapProducts.getFPRODUCTHIERARCHYCATALYST()
					.getFPRODUCTHIERARCHYCATALYSTCODE();
			String[] catCodeArr = catCodeString.split(">");
			catalystCodeName = catCodeArr[0].split(",")[1].trim();
			for (int j = 0; j < catCodeArr.length - 1; j++) {
				orderableParentId += "-" + catCodeArr[j].split(",")[0];
			}

			orderableParentId = orderableParentId.replaceFirst("-", "");

			String prevParentId = "";
			if (catCodeArr.length > 1) {
				for (int i = 0; i < catCodeArr.length - 1; i++) {
					String catCode = catCodeArr[i].split(",")[0];
					String catName = catCodeArr[i].split(",")[1];
					ProductType parentProduct = new ProductType();

					if (i == 0) {
						parentProduct
						.setParentID(InboundProperties.orderableRootParentID);
						prevParentId = catCode;
					} else {
						// parentProduct.setParentID(parentCatCodes[i - 1]);
						parentProduct.setParentID(prevParentId);
						prevParentId += "-" + catCode;
					}
					parentProduct.setID(prevParentId);
					NameType nameType = new NameType();
					nameType.setContent(catName);
					parentProduct.getName().add(nameType);
					parentProduct.setUserTypeID(InboundProperties
							.loadProperty("ordered-l" + (i + 1) + "-type"));
					prodList.add(parentProduct);
				}
			}
		}
		return prodList;
	}

	private List<ProductType> extractUnorderedParentHierarchy(
			Products sapProducts) {
		orderableParentId = "";
		List<ProductType> productList = new ArrayList<ProductType>();
		// GTIN of the parent product
		if (sapProducts.getFPRODUCTHIERARCHYCATALYST()
				.getFPRODUCTHIERARCHYCATALYSTCODE() != null) {
			String catCode = sapProducts.getFPRODUCTHIERARCHYCATALYST()
					.getFPRODUCTHIERARCHYCATALYSTCODE();
			String[] catCodeArr = catCode.split(">");
			for (int j = 0; j < catCodeArr.length - 1; j++) {
				orderableParentId += "-" + catCodeArr[j].split(",")[0];
				catalystCodeName = catCodeArr[j].split(",")[1].trim();
			}
			orderableParentId = orderableParentId.replaceFirst("-", "");
		}

		String[] brandSubbrandName = extractBrandSubbrand(sapProducts);
		String brandName = brandSubbrandName[0];
		if (!brandName.isEmpty()) {
			ProductType product1 = new ProductType();
			product1.setID("P_" + brandName);
			NameType nameType = new NameType();
			nameType.setContent(brandName);
			product1.getName().add(nameType);
			product1.setParentID(InboundProperties.palletRootID);
			product1.setUserTypeID(InboundProperties.palletSubbrandType);
			productList.add(product1);

			String functionalName = extractFunctionalName(sapProducts);
			if (!functionalName.isEmpty()) {
				ProductType product2 = new ProductType();
				String prefix = "P_";
				String l4name = restructureHier(brandName, functionalName,
						prefix);
				product2.setID(l4name);
				product2.setParentID(product1.getID());
				NameType nameType2 = new NameType();
				nameType2.setContent(functionalName);
				product2.getName().add(nameType2);
				product2.setUserTypeID(InboundProperties.palletFunctionalNameType);
				productList.add(product2);
				unorderableParentId = product2.getID();
			}
		}
		return productList;
	}

	/*private List<ClassificationType> extractAssetParentHierarchy(
			Products sapProducts){
		List<ClassificationType> classificationList = new ArrayList<ClassificationType>();

		String[] brandSubbrandName = extractBrandSubbrand(sapProducts);
		String brandName = brandSubbrandName[0];
		if (!brandName.isEmpty()) {
			ClassificationType classification1 = new ClassificationType();
			classification1.setID("I_" + brandName);
			NameType nameType = new NameType();
			nameType.setContent(brandName);
			classification1.getName().add(nameType);
			classification1.setParentID(InboundProperties.assetRootID);
			classification1.setUserTypeID(InboundProperties.assetClassificationType);
			classificationList.add(classification1);

			String functionalName = extractFunctionalName(sapProducts);
			if (!functionalName.isEmpty()) {
				ClassificationType classification2 = new ClassificationType();
				String prefix = "I_";
				String l4name = restructureHier(brandName, functionalName,
						prefix);
				classification2.setID(l4name);
				NameType nameType2 = new NameType();
				nameType2.setContent(functionalName);
				classification2.getName().add(nameType2);
				classification2.setParentID(classification1.getID());
				classification2.setUserTypeID(InboundProperties.assetClassificationType);
				classificationList.add(classification2);
			}
		}
		return classificationList;

	}*/

	private List<ProductType> extractConsumerParentHierarchy(
			Products sapProducts) {
		List<ProductType> productList = new ArrayList<ProductType>();
		String[] brandSubbrandName = extractBrandSubbrand(sapProducts);
		String brandName = brandSubbrandName[0];
		if (!brandName.isEmpty()) {
			ProductType product1 = new ProductType();
			product1.setID("C_" + brandName);
			NameType nameType = new NameType();
			nameType.setContent(brandName);
			product1.getName().add(nameType);
			product1.setParentID(InboundProperties.consumerRootID);
			product1.setUserTypeID(InboundProperties.consumerSubbrandType);
			productList.add(product1);

			String functionalName = extractFunctionalName(sapProducts);
			if (!functionalName.isEmpty()) {
				ProductType product2 = new ProductType();
				String prefix = "C_";
				String l4name = restructureHier(brandName, functionalName,
						prefix);
				product2.setID(l4name);
				NameType nameType2 = new NameType();
				nameType2.setContent(functionalName);
				product2.getName().add(nameType2);
				product2.setParentID(product1.getID());
				product2.setUserTypeID(InboundProperties.consumerFunctionalNameType);
				productList.add(product2);
				consumerParentId = product2.getID();
			}
		}

		return productList;
	}

	/* Add assets */
	/*private AssetsType extractAssets(Products sapProducts) throws Exception {
		logger.debug("Populating assets");
		AssetsType assets = new AssetsType();
		if (null != sapProducts.getFECOMMERCEIMAGES()) {

			String filename = "";
			String tmpfilename = "";
			Date startDate=null;
			Date endDate=null;
			Date tmpStartDate=null;
			Date tmpEndDate=null;


			List<TECOMMERCEIMAGEDATA> imageRemovalList = new ArrayList<TECOMMERCEIMAGEDATA>();
			for (TECOMMERCEIMAGEDATA ecomData1 : sapProducts
					.getFECOMMERCEIMAGES()) {
				filename=ecomData1.getFECOMMERCEIMAGEFILENAME();
				startDate=InboundProperties.sapDateFormat.parse(ecomData1
						.getFECOMMERCEIMAGESTARTDATE());
				endDate=InboundProperties.sapDateFormat.parse(ecomData1
						.getFECOMMERCEIMAGEENDDATE());	
				for (TECOMMERCEIMAGEDATA ecomData2 : sapProducts
						.getFECOMMERCEIMAGES()) {
					tmpfilename=ecomData2.getFECOMMERCEIMAGEFILENAME();
					tmpStartDate=InboundProperties.sapDateFormat.parse(ecomData2
							.getFECOMMERCEIMAGESTARTDATE());
					tmpEndDate=InboundProperties.sapDateFormat.parse(ecomData2
							.getFECOMMERCEIMAGEENDDATE());
					if(filename.equals(tmpfilename))
					{
						if(startDate.after(tmpStartDate))
						{
							//sapProducts.getFECOMMERCEIMAGES().remove(ecomData2);
							imageRemovalList.add(ecomData2);
							continue;

						}
						else
							if(tmpStartDate.equals(startDate))
							{

								if(endDate.after(tmpEndDate))
								{
									//sapProducts.getFECOMMERCEIMAGES().remove(ecomData2);
									imageRemovalList.add(ecomData2);
									continue;
								}
							}
					}

				}
			}
			for(TECOMMERCEIMAGEDATA t:imageRemovalList)
			{
				if(sapProducts.getFECOMMERCEIMAGES().contains(t))
				{
					sapProducts.getFECOMMERCEIMAGES().remove(t);
				}
			}




			for (TECOMMERCEIMAGEDATA ecomData : sapProducts
					.getFECOMMERCEIMAGES()) {

				AssetType asset = new AssetType();
				asset.setID(ecomData.getFECOMMERCEIMAGEFILENAME());
				asset.setUserTypeID(InboundProperties.assetType);
				NameType assetName = new NameType();
				assetName.setContent(ecomData.getFECOMMERCEIMAGEFILENAME());
				asset.getName().add(assetName);
				ValuesType values = new ValuesType();

				// F_ECOMMERCE_IMAGE_END_DATE
				ValueType imageEndDate = new ValueType();
				imageEndDate.setAttributeID(InboundProperties.imageEndDate);
				imageEndDate.setContent(InboundProperties.imageDateFormat
						.format(InboundProperties.sapDateFormat.parse(ecomData
								.getFECOMMERCEIMAGEENDDATE())));
				values.getValueOrMultiValueOrValueGroup().add(imageEndDate);

				// F_ECOMMERCE_IMAGE_FILE_FORMAT
				ValueType imageFormat = new ValueType();
				imageFormat.setAttributeID(InboundProperties.imageFileFormat);
				imageFormat.setContent(ecomData.getFECOMMERCEIMAGEFILEFORMAT());
				values.getValueOrMultiValueOrValueGroup().add(imageFormat);

				// F_ECOMMERCE_IMAGE_FILE_NAME
				ValueType imageName = new ValueType();
				imageName.setAttributeID(InboundProperties.imageFileName);
				imageName.setContent(ecomData.getFECOMMERCEIMAGEFILENAME());
				values.getValueOrMultiValueOrValueGroup().add(imageName);

				// F_ECOMMERCE_IMAGE_START_DATE
				ValueType imageStartDate = new ValueType();
				imageStartDate.setAttributeID(InboundProperties.imageStartDate);
				imageStartDate.setContent(InboundProperties.imageDateFormat
						.format(InboundProperties.sapDateFormat.parse(ecomData
								.getFECOMMERCEIMAGESTARTDATE())));
				values.getValueOrMultiValueOrValueGroup().add(imageStartDate);

				// F_ECOMMERCE_IMAGE_TYPE
				if (null != ecomData.getFECOMMERCEIMAGETYPE()
						&& !ecomData.getFECOMMERCEIMAGETYPE().isEmpty()) {
					ValueType imageType = new ValueType();
					imageType.setAttributeID(InboundProperties.imageType);
					imageType.setContent(ecomData.getFECOMMERCEIMAGETYPE()
							.get(0).getFECOMMERCEIMAGETYPENAME());
					values.getValueOrMultiValueOrValueGroup().add(imageType);
				}

				// F_ECOMMERCE_IMAGE_URL
				ValueType imageUrl = new ValueType();
				imageUrl.setAttributeID(InboundProperties.imageUrl);
				imageUrl.setContent(ecomData.getFECOMMERCEIMAGEURL());
				values.getValueOrMultiValueOrValueGroup().add(imageUrl);

				asset.setValues(values);

				// Add Asset Classification Reference
				ClassificationReferenceType assetClassification = new ClassificationReferenceType();
				String[] brandSubbrandName = extractBrandSubbrand(sapProducts);
				String brandName = brandSubbrandName[0];
				String functionalName = extractFunctionalName(sapProducts);
				if (!brandName.isEmpty()) {
					if (!functionalName.isEmpty()) {
						String prefix = "I_";
						String hierarchyId = restructureHier(brandName,
								functionalName, prefix);

						assetClassification.setClassificationID(hierarchyId);
						asset.getClassificationReference().add(
								assetClassification);
					}
				}
				assets.getAsset().add(asset);
			}



		}
		return assets;
	}*/

	/* Add attributes */
	/**
	 * @param sapProducts
	 * @param values
	 */
	private void extractAttributes(Products sapProducts, ValuesType values) {
		logger.debug("Populating attributes");

		ValueType valueType = null;
		//@SuppressWarnings("unchecked")
		//List<ArrayList<String>> attributeList=(List<ArrayList<String>>) context.getAttribute("attributelist");

		if (null != sapProducts)

			// F_CONSUMER_UNIT_FLAG
			valueType = new ValueType();
		valueType.setAttributeID("F_CONSUMER_UNIT_FLAG");
		if (null != sapProducts.getFCONSUMERUNITFLAG()) {
			valueType.setContent(sapProducts.getFCONSUMERUNITFLAG());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_VARIANT_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_VARIANT_NAME");
		if (null != sapProducts.getFVARIANT()) {
			if (null != sapProducts.getFVARIANT().getFVARIANTNAME()) {
				if (null != sapProducts.getFVARIANT().getFVARIANTNAME()
						.getFVARIANTNAMEML()
						&& !sapProducts.getFVARIANT().getFVARIANTNAME()
						.getFVARIANTNAMEML().isEmpty()) {
					if (null != sapProducts.getFVARIANT().getFVARIANTNAME()
							.getFVARIANTNAMEML().get(0).getFVARIANTNAME()) {

						valueType.setContent(sapProducts.getFVARIANT()
								.getFVARIANTNAME().getFVARIANTNAMEML().get(0)
								.getFVARIANTNAME());

					}
				}
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_FUNCTIONAL_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_FUNCTIONAL_NAME");
		if (null != sapProducts.getFFUNCTIONALNAME()) {
			if (null != sapProducts.getFFUNCTIONALNAME().getFFUNCTIONALNAME()) {
				if (null != sapProducts.getFFUNCTIONALNAME()
						.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML()
						&& !sapProducts.getFFUNCTIONALNAME()
						.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML()
						.isEmpty()) {
					if (null != sapProducts.getFFUNCTIONALNAME()
							.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML().get(0)
							.getFFUNCTIONALNAME()) {

						valueType.setContent(sapProducts.getFFUNCTIONALNAME()
								.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML()
								.get(0).getFFUNCTIONALNAME());

					}
				}
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_CHILD_KRAFT_ITEM_CODE
		valueType = new ValueType();
		valueType.setAttributeID("F_CHILD_KRAFT_ITEM_CODE");
		if (null != sapProducts.getFCHILDPACKAGINGRELATIONSHIP()
				&& !sapProducts.getFCHILDPACKAGINGRELATIONSHIP().isEmpty()) {
			if (null != sapProducts.getFCHILDPACKAGINGRELATIONSHIP().get(0)
					.getFCHILDKRAFTITEMCODE()
					&& !sapProducts.getFCHILDPACKAGINGRELATIONSHIP().get(0)
					.getFCHILDKRAFTITEMCODE().isEmpty()) {
				if (null != sapProducts.getFCHILDPACKAGINGRELATIONSHIP().get(0)
						.getFCHILDKRAFTITEMCODE().get(0).getFKRAFTITEMCODE()) {

					valueType.setContent(sapProducts
							.getFCHILDPACKAGINGRELATIONSHIP().get(0)
							.getFCHILDKRAFTITEMCODE().get(0)
							.getFKRAFTITEMCODE());

				}
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_CROSS_DISTRIBUTION_CHAIN_STATUS_NAME
		valueType = new ValueType();
		valueType
		.setAttributeID("F_CROSS_DISTRIBUTION_CHAIN_STATUS_NAME");
		if (null != sapProducts.getFCROSSDISTRIBUTIONCHAINSTATUS()
				&& !sapProducts.getFCROSSDISTRIBUTIONCHAINSTATUS().isEmpty()) {
			if (null != sapProducts.getFCROSSDISTRIBUTIONCHAINSTATUS().get(0)
					.getFCROSSDISTRIBUTIONCHAINSTATUSNAME()) {

				valueType.setContent(sapProducts
						.getFCROSSDISTRIBUTIONCHAINSTATUS().get(0)
						.getFCROSSDISTRIBUTIONCHAINSTATUSNAME());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_MAXIMUM_STACKING_WEIGHT - valid only for CASE in PIM
		valueType = new ValueType();
		valueType.setAttributeID("F_MAXIMUM_STACKING_WEIGHT");
		if (null != sapProducts.getFMAXIMUMSTACKINGWEIGHT()) {
			if ("CASE".equals(unitDescCode)
					|| "DISPLAY/SHIPPER".equals(unitDescCode)
					|| "MIXED MODULE".equals(unitDescCode)) {
				valueType.setContent(sapProducts.getFMAXIMUMSTACKINGWEIGHT()
						.toString());
			}
		}
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode)
				|| "MIXED MODULE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_PACKAGING_LANGUAGE - valid only for CASE in PIM - Made Valid for All
		valueType = new ValueType();
		valueType.setAttributeID("F_PACKAGING_LANGUAGE");
		if (null != sapProducts.getFPACKAGINGLANGUAGE()
				&& !sapProducts.getFPACKAGINGLANGUAGE().isEmpty()) {
			if (null != sapProducts.getFPACKAGINGLANGUAGE().get(0)
					.getFLANGUAGECODE()) {
				valueType.setContent(sapProducts.getFPACKAGINGLANGUAGE().get(0)
						.getFLANGUAGECODE());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_ORDERABLE_UNIT_FLAG
		valueType = new ValueType();
		valueType.setAttributeID("F_ORDERABLE_UNIT_FLAG");
		if (null != sapProducts.getFCONSUMERUNITFLAG()) {
			valueType.setContent(sapProducts.getFCONSUMERUNITFLAG());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_PRODUCT_DESCRIPTION_SHORT
		valueType = new ValueType();
		valueType.setAttributeID("F_PRODUCT_DESCRIPTION_SHORT");
		if (null != sapProducts.getFPRODUCTDESCRIPTIONSHORT()) {
			productDescShort = sapProducts.getFPRODUCTDESCRIPTIONSHORT();
			valueType.setContent(sapProducts.getFPRODUCTDESCRIPTIONSHORT());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_UNIT_DESCRIPTOR_CODE
		valueType = new ValueType();
		valueType.setAttributeID("F_UNIT_DESCRIPTOR_CODE");
		if (null != sapProducts.getFUNITDESCRIPTOR()) {
			if (null != sapProducts.getFUNITDESCRIPTOR()
					.getFUNITDESCRIPTORCODE()) {
				valueType.setContent(sapProducts.getFUNITDESCRIPTOR()
						.getFUNITDESCRIPTORCODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_CROSS_PLANT_STATUS_VALID_FROM - valid only for CASE in PIM - Made Valid for all
		valueType = new ValueType();
		valueType.setAttributeID("F_CROSS_PLANT_STATUS_VALID_FROM");
		if (null != sapProducts.getFCROSSPLANTSTATUS()
				&& !sapProducts.getFCROSSPLANTSTATUS().isEmpty()) {
			if (null != sapProducts.getFCROSSPLANTSTATUS().get(0)
					.getFCROSSPLANTSTATUSVALIDFROM()
					&& !sapProducts.getFCROSSPLANTSTATUS().get(0)
					.getFCROSSPLANTSTATUSVALIDFROM().isEmpty()) {

				try {
					valueType.setContent(InboundProperties.crossPlantDateFormat
							.format(InboundProperties.sapDateFormat
									.parse(sapProducts.getFCROSSPLANTSTATUS()
											.get(0)
											.getFCROSSPLANTSTATUSVALIDFROM())));
				} catch (ParseException e) {
					logger.error(
							"Error parsing date for F_CROSS_PLANT_STATUS_VALID_FROM",
							e);
				}

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		/*
		 * // F_AUTHORISED_SELLING_GROUP_NAME if (null !=
		 * sapProducts.getFAUTHORIZEDSELLINGGROUP() &&
		 * !sapProducts.getFAUTHORIZEDSELLINGGROUP().isEmpty()) { if (null !=
		 * sapProducts.getFAUTHORIZEDSELLINGGROUP().get(0)
		 * .getFAUTHORIZEDSELLINGGROUPSNAME()) { valueType = new ValueType();
		 * valueType.setAttributeID("F_AUTHORISED_SELLING_GROUP_NAME");
		 * valueType.setContent(sapProducts.getFAUTHORIZEDSELLINGGROUP()
		 * .get(0).getFAUTHORIZEDSELLINGGROUPSNAME());
		 * values.getValueOrMultiValueOrValueGroup().add(valueType);
		 * 
		 * } }
		 */

		// F_KRAFT_ITEM_CODE
		valueType = new ValueType();
		valueType.setAttributeID("F_KRAFT_ITEM_CODE");
		if (null != sapProducts.getFKRAFTITEMCODE()) {
			valueType.setContent(sapProducts.getFKRAFTITEMCODE());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_SUB_VARIANT
		valueType = new ValueType();
		valueType.setAttributeID("F_SUB_VARIANT");
		if (null != sapProducts.getFSUBVARIANT()) {
			if (null != sapProducts.getFSUBVARIANT().getFSUBVARIANT()) {
				valueType.setContent(sapProducts.getFSUBVARIANT()
						.getFSUBVARIANT());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_GTIN
		valueType = new ValueType();
		valueType.setAttributeID("F_GTIN");
		if (null != sapProducts.getFGTIN()) {
			valueType.setContent(sapProducts.getFGTIN());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_UPC_CODE_10 - Made Valid for All - setting using business rule
		/*valueType = new ValueType();
		valueType.setAttributeID("F_UPC_CODE_10");
		if (null != sapProducts.getFGTIN()) {
			valueType.setContent(sapProducts.getFGTIN().substring(3, sapProducts.getFGTIN().length()-1));
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);*/

		// F_BRAND_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_BRAND_NAME");
		if (null != sapProducts.getFBRANDSUBBRAND()) {
			if (null != sapProducts.getFBRANDSUBBRAND().getFBRANDNAME()) {
				String[] brandSubbrandName = extractBrandSubbrand(sapProducts);
				String brandName = brandSubbrandName[0];
				valueType.setContent(brandName);

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_SUB_BRAND_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_SUB_BRAND_NAME");
		if (null != sapProducts.getFBRANDSUBBRAND()) {
			if (null != sapProducts.getFBRANDSUBBRAND().getFBRANDNAME()) {
				String[] brandSubbrandName = extractBrandSubbrand(sapProducts);
				String subBrandName = brandSubbrandName[1];
				valueType.setContent(subBrandName);

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_CROSS_DISTRIBUTION_CHAIN_STATUS_CODE
		valueType = new ValueType();
		valueType
		.setAttributeID("F_CROSS_DISTRIBUTION_CHAIN_STATUS_CODE");
		if (null != sapProducts.getFCROSSDISTRIBUTIONCHAINSTATUS()
				&& !sapProducts.getFCROSSDISTRIBUTIONCHAINSTATUS().isEmpty()) {
			if (null != sapProducts.getFCROSSDISTRIBUTIONCHAINSTATUS().get(0)
					.getFCROSSDISTRIBUTIONCHAINSTATUSCODE()) {
				valueType.setContent(sapProducts
						.getFCROSSDISTRIBUTIONCHAINSTATUS().get(0)
						.getFCROSSDISTRIBUTIONCHAINSTATUSCODE());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_DISTRIBUTION_CHANNEL_CODE 
		valueType = new ValueType();
		valueType.setAttributeID("F_DISTRIBUTION_CHANNEL_CODE");
		if (null != sapProducts.getFSALESSTATUSDATA()
				&& !sapProducts.getFSALESSTATUSDATA().isEmpty()) {
			if (null != sapProducts.getFSALESSTATUSDATA().get(0).getFDISTRIBUTIONCHANNELCODE()) {
				valueType.setContent(sapProducts.getFSALESSTATUSDATA().get(0).getFDISTRIBUTIONCHANNELCODE().getFDISTRIBUTIONCHANNELCODE());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_SALES_STATUS_CODE  
		valueType = new ValueType();
		valueType
		.setAttributeID("F_SALES_STATUS_CODE");
		if (null != sapProducts.getFSALESSTATUSDATA()
				&& !sapProducts.getFSALESSTATUSDATA().isEmpty()) {
			if (null != sapProducts.getFSALESSTATUSDATA().get(0).getFSALESSTATUSCODE().getFSALESSTATUSCODE().getFSALESSTATUSCODEML().get(0).getFSALESSTATUSCODE()) {

				valueType.setContent(sapProducts.getFSALESSTATUSDATA().get(0).getFSALESSTATUSCODE().getFSALESSTATUSCODE().getFSALESSTATUSCODEML().get(0).getFSALESSTATUSCODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);



		// F_PRODUCT_HIERARCHY_CATALYST_CODE - valid only for CASE in PIM
		valueType = new ValueType();
		valueType.setAttributeID("F_PRODUCT_HIERARCHY_CATALYST_CODE");
		if (null != sapProducts.getFPREVIOUSPRODUCTHIERARCHYCATALYST()) {
			if ("CASE".equals(unitDescCode)
					|| "DISPLAY/SHIPPER".equals(unitDescCode)
					|| "MIXED MODULE".equals(unitDescCode)) {
				if (null != sapProducts.getFPRODUCTHIERARCHYCATALYST()
						.getFPRODUCTHIERARCHYCATALYSTCODE()) {

					valueType.setContent(sapProducts.getFPRODUCTHIERARCHYCATALYST()
							.getFPRODUCTHIERARCHYCATALYSTCODE()
							.replaceAll(", , >", "||").replaceAll(", ,", "")
							.replaceAll(", ", "::"));

				}
			}
		}
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode)
				|| "MIXED MODULE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_TOTAL_SHELF_LIFE
		valueType = new ValueType();
		valueType.setAttributeID("F_TOTAL_SHELF_LIFE");
		if (null != sapProducts.getFTOTALSHELFLIFE()) {

			valueType.setContent(sapProducts.getFTOTALSHELFLIFE().toString());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_AUTHORIZED_SELLING_GROUPS_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_AUTHORIZED_SELLING_GROUPS_NAME");
		if (null != sapProducts.getFAUTHORIZEDSELLINGGROUP()
				&& !sapProducts.getFAUTHORIZEDSELLINGGROUP().isEmpty()) {
			/*if ("CASE".equals(unitDescCode)
					|| "DISPLAY/SHIPPER".equals(unitDescCode)
					|| "MIXED MODULE".equals(unitDescCode)) {*/
			if (null != sapProducts.getFAUTHORIZEDSELLINGGROUP().get(0)
					.getFAUTHORIZEDSELLINGGROUPSNAME()) {
				valueType.setContent(sapProducts.getFAUTHORIZEDSELLINGGROUP()
						.get(0).getFAUTHORIZEDSELLINGGROUPSNAME());

			}
			//}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_SUITABILITY_INFORMATION_SYMBOL
		// F_SUITABILITY_INFORMATION_CERTIFYING_AGENCY
		// F_SUITABILTY_INFORMATION_DOCUMENT_NUMBER
		// F_SUITABILITY_INFORMATION_TYPE
		// F_SUITABILITY_INFORMATION_INDICATOR	

		//otherNutrAllAttributes.addAll(attributeList.get(InboundProperties.otherNutritionalAttributeIndex));
		otherNutrAllAttributes=AttributeList.otherNutritionalAttributeList;
		if (null != sapProducts.getFSUITABILITYINFORMATIONDATA()
				&& !sapProducts.getFSUITABILITYINFORMATIONDATA().isEmpty()) {
			if ("EACH".equals(unitDescCode)
					|| "PACK/INNER PACK".equals(unitDescCode) || "CASE".equals(unitDescCode)) {

				List<String> otherNutrSetAttribute=new ArrayList<String>();
				// FOR
				for (TSUITABILITYINFORMATIONDATA suitabilityInfo : sapProducts
						.getFSUITABILITYINFORMATIONDATA()) {
					if (null != suitabilityInfo.getFSUITABILITYINFORMATIONTYPE() 
							&& !suitabilityInfo.getFSUITABILITYINFORMATIONTYPE()
							.isEmpty()) {
						if (suitabilityInfo.getFSUITABILITYINFORMATIONTYPE().get(0)
								.getFSUITABILITYTYPENAME().equals("KOSHER")) {
							valueType = new ValueType();
							valueType
							.setAttributeID("KOSHER_SUITABILITY_INFO_SYMBOL");
							otherNutrSetAttribute.add("KOSHER_SUITABILITY_INFO_SYMBOL");
							valueType.setContent(suitabilityInfo
									.getFSUITABILITYINFORMATIONSYMBOL());
							values.getValueOrMultiValueOrValueGroup()
							.add(valueType);

							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
									&& !suitabilityInfo
									.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
									.isEmpty()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("KOSHER_SUITABILITY_CERT_AGENCY");
								otherNutrSetAttribute.add("KOSHER_SUITABILITY_CERT_AGENCY");
								valueType
								.setContent(suitabilityInfo
										.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
										.get(0)
										.getFSUITABILITYCERTIFYINGAGENCYNAME());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}

							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONDOCUMENTNUMBER()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("KOSHER_SUITABILITY_INFO_DOC_NUMBER");
								otherNutrSetAttribute.add("KOSHER_SUITABILITY_INFO_DOC_NUMBER");
								valueType
								.setContent(suitabilityInfo
										.getFSUITABILITYINFORMATIONDOCUMENTNUMBER());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONINDICATOR()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("KOSHER_SUITABILITY_INFO_INDICATOR");
								otherNutrSetAttribute.add("KOSHER_SUITABILITY_INFO_INDICATOR");
								valueType
								.setContent(StringUtils
										.capitalize(suitabilityInfo
												.getFSUITABILITYINFORMATIONINDICATOR()
												.toLowerCase()));
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
						}
						if (suitabilityInfo.getFSUITABILITYINFORMATIONTYPE().get(0)
								.getFSUITABILITYTYPENAME().equals("HALAL")) {
							valueType = new ValueType();
							valueType
							.setAttributeID("HALAL_SUITABILITY_INFO_SYMBOL");
							otherNutrSetAttribute.add("HALAL_SUITABILITY_INFO_SYMBOL");
							valueType.setContent(suitabilityInfo
									.getFSUITABILITYINFORMATIONSYMBOL());
							values.getValueOrMultiValueOrValueGroup()
							.add(valueType);

							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
									&& !suitabilityInfo
									.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
									.isEmpty()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("HALAL_SUITABILITY_CERT_AGENCY");
								otherNutrSetAttribute.add("HALAL_SUITABILITY_CERT_AGENCY");
								valueType
								.setContent(suitabilityInfo
										.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
										.get(0)
										.getFSUITABILITYCERTIFYINGAGENCYNAME());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}

							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONDOCUMENTNUMBER()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("HALAL_SUITABILITY_INFO_DOC_NUMBER");
								otherNutrSetAttribute.add("HALAL_SUITABILITY_INFO_DOC_NUMBER");
								valueType
								.setContent(suitabilityInfo
										.getFSUITABILITYINFORMATIONDOCUMENTNUMBER());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONINDICATOR()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("HALAL_SUITABILITY_INFO_INDICATOR");
								otherNutrSetAttribute.add("HALAL_SUITABILITY_INFO_INDICATOR");
								valueType
								.setContent(StringUtils
										.capitalize(suitabilityInfo
												.getFSUITABILITYINFORMATIONINDICATOR()
												.toLowerCase()));
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}

						}
						if (suitabilityInfo.getFSUITABILITYINFORMATIONTYPE().get(0)
								.getFSUITABILITYTYPENAME().equals("ORGANIC")) {
							valueType = new ValueType();
							valueType
							.setAttributeID("ORGANIC_SUITABILITY_INFO_SYMBOL");
							otherNutrSetAttribute.add("ORGANIC_SUITABILITY_INFO_SYMBOL");
							valueType.setContent(suitabilityInfo
									.getFSUITABILITYINFORMATIONSYMBOL());
							values.getValueOrMultiValueOrValueGroup()
							.add(valueType);

							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
									&& !suitabilityInfo
									.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
									.isEmpty()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("ORGANIC_SUITABILITY_CERT_AGENCY");
								otherNutrSetAttribute.add("ORGANIC_SUITABILITY_CERT_AGENCY");
								valueType
								.setContent(suitabilityInfo
										.getFSUITABILITYINFORMATIONCERTIFYINGAGENCY()
										.get(0)
										.getFSUITABILITYCERTIFYINGAGENCYNAME());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONDOCUMENTNUMBER()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("ORGANIC_SUITABILITY_INFO_DOC_NUMBER");
								otherNutrSetAttribute.add("ORGANIC_SUITABILITY_INFO_DOC_NUMBER");
								valueType
								.setContent(suitabilityInfo
										.getFSUITABILITYINFORMATIONDOCUMENTNUMBER());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
							if (null != suitabilityInfo
									.getFSUITABILITYINFORMATIONINDICATOR()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("ORGANIC_SUITABILITY_INFO_INDICATOR");
								otherNutrSetAttribute.add("ORGANIC_SUITABILITY_INFO_INDICATOR");
								valueType
								.setContent(StringUtils
										.capitalize(suitabilityInfo
												.getFSUITABILITYINFORMATIONINDICATOR()
												.toLowerCase()));
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
						}
					}
				}
				otherNutrAllAttributes.removeAll(otherNutrSetAttribute);
			}
		}

		// These are not mapped to CASE in PIM - Made valid for CASE
		/*if("CASE".equals(unitDescCode)){
			otherNutrAllAttributes.remove("ORGANIC_SUITABILITY_INFO_INDICATOR");
			otherNutrAllAttributes.remove("KOSHER_SUITABILITY_INFO_INDICATOR");
			otherNutrAllAttributes.remove("HALAL_SUITABILITY_INFO_INDICATOR");
		}*/
		// Setting null valued other nutritional attributes except for Ingredient Info
		if(!("PALLET".equals(unitDescCode))){
			for(int i=0;i<otherNutrAllAttributes.size();i++)
			{
				valueType=new ValueType();
				valueType.setAttributeID(otherNutrAllAttributes.get(i));
				values.getValueOrMultiValueOrValueGroup().add(valueType);
			}
		}




		// F_INGREDIENT_INFORMATION_CROSS_CONTACT_STATEMENT
		// F_INGREDIENT_INFORMATION_DOES_CONTAIN_STATEMENT
		// F_INGREDIENT_INFORMATION_HH_SERVING_SIZE
		// F_INGREDIENT_INFORMATION_STATEMENT
		valueType = new ValueType();
		valueType.setAttributeID("F_INGREDIENT_INFO_CROSS_CONCT_STATEMENT");
		ValueType valueType1 = new ValueType();
		valueType1.setAttributeID("F_INGREDIENT_INFO_DOES_CONTAIN_STATEMENT");
		ValueType valueType2 = new ValueType();
		valueType2.setAttributeID("F_INGREDIENT_INFORMATION_HH_SERVING_SIZE");
		ValueType valueType3 = new ValueType();
		valueType3.setAttributeID("F_INGREDIENT_INFORMATION_STATEMENT");
		if (null != sapProducts.getFINGREDIENTS()
				&& !sapProducts.getFINGREDIENTS().isEmpty()) {
			if ("EACH".equals(unitDescCode)
					|| "PACK/INNER PACK".equals(unitDescCode) || "CASE".equals(unitDescCode)) {
				for (TINGREDIENTINFORMATIONDATA ingredients : sapProducts
						.getFINGREDIENTS()) {
					if (null != ingredients.getFINGREDIENTINFORMATIONLANGUAGE()
							&& !ingredients.getFINGREDIENTINFORMATIONLANGUAGE()
							.isEmpty()) {
						if (InboundProperties.engLangCode.equals(ingredients
								.getFINGREDIENTINFORMATIONLANGUAGE().get(0)
								.getFLANGUAGECODE())) {
							if (null != ingredients
									.getFINGREDIENTINFORMATIONCROSSCONTACTSTATEMENT()) {
								valueType
								.setContent(ingredients
										.getFINGREDIENTINFORMATIONCROSSCONTACTSTATEMENT());

							}
							if (null != ingredients
									.getFINGREDIENTINFORMATIONDOESCONTAINSTATEMENT()) {
								valueType1
								.setContent(ingredients
										.getFINGREDIENTINFORMATIONDOESCONTAINSTATEMENT());

							}
							if (null != ingredients
									.getFINGREDIENTINFORMATIONHHSERVINGSIZE()) {
								valueType2.setContent(ingredients
										.getFINGREDIENTINFORMATIONHHSERVINGSIZE());

							}
							if (null != ingredients
									.getFINGREDIENTINFORMATIONSTATEMENT()) {
								valueType3.setContent(ingredients
										.getFINGREDIENTINFORMATIONSTATEMENT());

							}
						}
					}
				}

			}

		}
		if("EACH".equals(unitDescCode)
				|| "PACK/INNER PACK".equals(unitDescCode) || "CASE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(
					valueType);
			values.getValueOrMultiValueOrValueGroup().add(
					valueType1);
			values.getValueOrMultiValueOrValueGroup().add(
					valueType2);
			values.getValueOrMultiValueOrValueGroup().add(
					valueType3);
		}

		// F_ECOMMERCE_PRODUCT_FEATURE
		valueType = new ValueType();
		valueType.setAttributeID("F_ECOMMERCE_PRODUCT_FEATURE");
		if (!("EACH".equals(unitDescCode))) {
			if (null != sapProducts.getFECOMMERCEPRODUCTFEATURE()) {

				valueType.setContent(sapProducts.getFECOMMERCEPRODUCTFEATURE());

			}
		}
		if (!("EACH".equals(unitDescCode))) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_ALLERGEN_INFORMATION_SPEC_AGENCY
		// F_ALLERGEN_INFORMATION_SPEC_NAME
		// F_ALLERGEN_INFORMATION_LEVEL_OF_CONTAINMENT
		valueType = new ValueType();
		valueType.setAttributeID("F_ALLERGEN_INFORMATION_SPEC_AGENCY");
		ValueType valueType4 = new ValueType();
		valueType4.setAttributeID("F_ALLERGEN_INFORMATION_SPEC_NAME");
		MultiValueType allergenContainMultiValueType = new MultiValueType();
		allergenContainMultiValueType.setAttributeID("ALLERGENS_CONTAIN");
		MultiValueType allergenMayContainMultiValueType = new MultiValueType();
		allergenMayContainMultiValueType
		.setAttributeID("ALLERGENS_MAY_CONTAIN");
		if (null != sapProducts.getFALLERGENS()
				&& !sapProducts.getFALLERGENS().isEmpty()) {
			if (null != sapProducts.getFALLERGENS().get(0)
					.getFALLERGENINFORMATIONSPECAGENCY()) {

				valueType.setContent(sapProducts.getFALLERGENS().get(0)
						.getFALLERGENINFORMATIONSPECAGENCY());
			}

			if (null != sapProducts.getFALLERGENS().get(0)
					.getFALLERGENINFORMATIONSPECNAME()) {

				valueType4.setContent(sapProducts.getFALLERGENS().get(0)
						.getFALLERGENINFORMATIONSPECNAME());

			}


			ValueType multiValueType = new ValueType();
			for (TALLERGENDATA allergenData : sapProducts.getFALLERGENS()) {
				if (null != allergenData.getFALLERGENINFORMATIONALLERGEN()
						&& !allergenData.getFALLERGENINFORMATIONALLERGEN()
						.isEmpty()) {
					if (allergenData
							.getFALLERGENINFORMATIONLEVELOFCONTAINMENT()
							.equals("CONTAINS")) {
						multiValueType = new ValueType();
						multiValueType.setContent(allergenData
								.getFALLERGENINFORMATIONALLERGEN().get(0)
								.getFALLERGENNAME());
						allergenContainMultiValueType.getValueOrValueGroup()
						.add(multiValueType);

					}
					if (allergenData
							.getFALLERGENINFORMATIONLEVELOFCONTAINMENT()
							.equals("MAY_CONTAIN")) {
						multiValueType = new ValueType();
						multiValueType.setContent(allergenData
								.getFALLERGENINFORMATIONALLERGEN().get(0)
								.getFALLERGENNAME());
						allergenMayContainMultiValueType.getValueOrValueGroup()
						.add(multiValueType);

					}
				}
			}

			/*if (!allergenContainMultiValueType.getValueOrValueGroup().isEmpty()) {

				}
				if (!allergenMayContainMultiValueType.getValueOrValueGroup()
						.isEmpty()) {

				}*/

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);
		values.getValueOrMultiValueOrValueGroup().add(valueType4);
		values.getValueOrMultiValueOrValueGroup().add(
				allergenContainMultiValueType);
		values.getValueOrMultiValueOrValueGroup().add(
				allergenMayContainMultiValueType);


		// F_ALLERGEN_RELEVANT_PROVIDED_FLAG
		valueType = new ValueType();
		valueType.setAttributeID("F_ALLERGEN_RELEVANT_PROVIDED_FLAG");
		if (null != sapProducts.getFALLERGENRELEVANTPROVIDEDFLAG()) {

			valueType
			.setContent(sapProducts.getFALLERGENRELEVANTPROVIDEDFLAG());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_BRAND_OWNER_GLN
		valueType = new ValueType();
		valueType.setAttributeID("F_BRAND_OWNR_GLN");
		if (null != sapProducts.getFBRANDOWNERGLN()) {
			valueType.setContent(sapProducts.getFBRANDOWNERGLN());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_DISPLAY_READY_PACKAGING_INDICATOR
		valueType = new ValueType();
		valueType.setAttributeID("F_DISPLAY_READY_PACKAGING_INDICATOR");
		if (null != sapProducts.getFDISPLAYREADYPACKAGINGINDICATOR()) {
			valueType.setContent(sapProducts
					.getFDISPLAYREADYPACKAGINGINDICATOR());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);



		// F_FIRST_AVAILABLE_SHIP_DATE - valid only for CASE in PIM - Made Valid for all
		valueType = new ValueType();
		valueType.setAttributeID("F_FIRST_AVAILABLE_SHIP_DATE");
		if (null != sapProducts.getFFIRSTAVAILABLESHIPDATEDATA()
				&& !sapProducts.getFFIRSTAVAILABLESHIPDATEDATA().isEmpty()) {
			if (null != sapProducts.getFFIRSTAVAILABLESHIPDATEDATA().get(0)
					.getFFIRSTAVAILABLESHIPDATE()) {
				String stepDate = "";
				try {
					stepDate = InboundProperties.stepDateFormat
							.format(InboundProperties.sapDateFormat
									.parse(sapProducts
											.getFFIRSTAVAILABLESHIPDATEDATA()
											.get(0)
											.getFFIRSTAVAILABLESHIPDATE()));
				} catch (ParseException e) {
					logger.error("Error parsing date value", e);
				}
				valueType.setContent(stepDate);
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		// F_GLOBAL_PRODUCT_CLASSIFICATION_GPC
		valueType = new ValueType();
		valueType
		.setAttributeID("F_GLOBAL_PRODUCT_CLASSIFICATION_CODE");
		if (null != sapProducts.getFGLOBALPRODUCTCLASSIFICATION()
				&& !sapProducts.getFGLOBALPRODUCTCLASSIFICATION().isEmpty()) {
			if (null != sapProducts.getFGLOBALPRODUCTCLASSIFICATION().get(0)
					.getFGLOBALPRODUCTCLASSIFICATIONCODE()) {

				valueType.setContent(sapProducts
						.getFGLOBALPRODUCTCLASSIFICATION().get(0)
						.getFGLOBALPRODUCTCLASSIFICATIONCODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_GTIN_PL_DISTRIBUTED_CODE
		valueType = new ValueType();
		valueType.setAttributeID("F_GTIN_PL_DISTRIBUTED_CODE");
		if (null != sapProducts.getFGTINPLDISTRIBUTED()) {
			if (null != sapProducts.getFGTINPLDISTRIBUTED()
					.getFGTINPLDISTRIBUTEDCODE()) {
				valueType.setContent(sapProducts.getFGTINPLDISTRIBUTED()
						.getFGTINPLDISTRIBUTEDCODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_GTIN_VARIABLE_WEIGHT
		valueType = new ValueType();
		valueType.setAttributeID("F_GTIN_VARIABLE_WEIGHT");
		if (null != sapProducts.getFGTINVARIABLEWEIGHT()) {
			valueType.setContent(sapProducts.getFGTINVARIABLEWEIGHT());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NEXT_LOWER_LEVEL_UNITS_PER_TRADE_UNIT
		valueType = new ValueType();
		valueType.setAttributeID("F_NEXT_LOWER_LEVEL_UNITS_PER_TRADE_UNIT");
		if (null != sapProducts.getFNEXTLOWERLEVELUNITSPERTRADEUNIT()) {

			valueType.setContent(sapProducts
					.getFNEXTLOWERLEVELUNITSPERTRADEUNIT().toString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NUTRITION_RELEVANT_PROVIDED_FLAG
		valueType = new ValueType();
		valueType.setAttributeID("F_NTRN_RLVNT_PRVD_FLAG");
		if (null != sapProducts.getFNUTRITIONRELEVANTPROVIDEDFLAG()) {

			valueType.setContent(sapProducts
					.getFNUTRITIONRELEVANTPROVIDEDFLAG());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_IS_PACKAGING_MARKED_WITH_INGREDIENTS
		valueType = new ValueType();
		valueType.setAttributeID("F_IS_PACKAGING_MARKED_WITH_INGREDIENTS");
		if (null != sapProducts.getFISPACKAGINGMARKEDWITHINGREDIENTS()) {
			valueType.setContent(sapProducts
					.getFISPACKAGINGMARKEDWITHINGREDIENTS());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_GEN_MKT_DESCRIPTION = F_GENERAL_MARKETING_DESCRIPTION 
		valueType = new ValueType();
		valueType.setAttributeID("F_GEN_MKT_DESCRIPTION");
		if (!("EACH".equals(unitDescCode))) {
			if (null != sapProducts.getFGENERALMARKETINGDESCRIPTIONS()
					&& !sapProducts.getFGENERALMARKETINGDESCRIPTIONS().isEmpty()) {
				for (TGENERALMARKETINGDESCRIPTIONS genMktDesc : sapProducts
						.getFGENERALMARKETINGDESCRIPTIONS()) {
					if (null != genMktDesc.getFLANGUAGE()
							&& !genMktDesc.getFLANGUAGE().isEmpty()) {
						if (InboundProperties.engLangCode.equals(genMktDesc
								.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
							if (null != genMktDesc.getFGENMKTDESCRIPTION()) {

								valueType.setContent(genMktDesc
										.getFGENMKTDESCRIPTION());

							}
						}
					}
				}
			}
		}
		if (!("EACH".equals(unitDescCode))) {
			values.getValueOrMultiValueOrValueGroup().add(
					valueType);
		}

		// F_IS_PACKAGING_MARKED_RETURNABLE
		valueType = new ValueType();
		valueType.setAttributeID("F_IS_PACKAGING_MARKED_RETURNABLE");
		if (null != sapProducts.getFISPACKAGINGMARKEDRETURNABLE()) {

			valueType.setContent(sapProducts.getFISPACKAGINGMARKEDRETURNABLE());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		// F_PACKAGING_TYPE_CODE
		valueType = new ValueType();
		valueType.setAttributeID("F_PACKAGING_TYPE_CODE");
		if (null != sapProducts.getFPACKAGINGTYPE()) {
			if (null != sapProducts.getFPACKAGINGTYPE().getFPACKAGINGTYPECODE()) {

				valueType.setContent(sapProducts.getFPACKAGINGTYPE()
						.getFPACKAGINGTYPECODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_ORGANIZATION_OF_OWNERSHIP Added for USA
		valueType = new ValueType();
		valueType.setAttributeID("F_ORGANIZATION_OF_OWNERSHIP");
		if (null != sapProducts.getFORGANIZATIONOFOWNERSHIP()) {
			if (null != sapProducts.getFORGANIZATIONOFOWNERSHIP().getFCOUNTRYCODE()) {

				valueType.setContent(sapProducts.getFORGANIZATIONOFOWNERSHIP()
						.getFCOUNTRYCODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_PREPARATIONS_AND_COOKING_SUGGESTIONS
		valueType = new ValueType();
		valueType.setAttributeID("F_PREP_AND_COOK_SUGGESTIONS");
		if (!("EACH".equals(unitDescCode))) {
			if (null != sapProducts.getFPREPARATIONANDCOOKINGSUGGESTIONS()
					&& !sapProducts.getFPREPARATIONANDCOOKINGSUGGESTIONS()
					.isEmpty()) {
				for (TPREPARATIONANDCOOKINGSUGGESTIONS cookingSuggs : sapProducts
						.getFPREPARATIONANDCOOKINGSUGGESTIONS()) {
					if (InboundProperties.engLangCode.equals(cookingSuggs
							.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
						if (null != cookingSuggs.getFPREPANDCOOKSUGGESTIONS()) {

							valueType.setContent(cookingSuggs
									.getFPREPANDCOOKSUGGESTIONS());

						}
					}
				}
			}
		}
		if (!("EACH".equals(unitDescCode))) {
			values.getValueOrMultiValueOrValueGroup()
			.add(valueType);
		}

		// F_PRODUCT_BENEFITS
		valueType = new ValueType();
		valueType.setAttributeID("F_PRODUCT_BENEFITS");
		if (!("EACH".equals(unitDescCode))) {
			if (null != sapProducts.getFPRODUCTBENEFITS()
					&& !sapProducts.getFPRODUCTBENEFITS().isEmpty()) {

				for (TPRODUCTBENEFITS prodBenefits : sapProducts
						.getFPRODUCTBENEFITS()) {
					if (null != prodBenefits.getFLANGUAGE()
							&& !prodBenefits.getFLANGUAGE().isEmpty()) {
						if (InboundProperties.engLangCode.equals(prodBenefits
								.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
							if (null != prodBenefits.getFPRODUCTBENEFITS()) {

								valueType.setContent(prodBenefits
										.getFPRODUCTBENEFITS());

							}
						}
					}
				}
			}
		}
		if (!("EACH".equals(unitDescCode))) {
			values.getValueOrMultiValueOrValueGroup().add(
					valueType);
		}
		// F_PROMOTION_TYPE
		valueType = new ValueType();
		valueType.setAttributeID("F_PROMOTION_TYPE");
		if (null != sapProducts.getFPROMOTIONTYPE()) {
			if (null != sapProducts.getFPROMOTIONTYPE().getFPROMOTIONTYPE()) {

				valueType.setContent(sapProducts.getFPROMOTIONTYPE()
						.getFPROMOTIONTYPE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_SEASONAL_CODE
		valueType = new ValueType();
		valueType.setAttributeID("F_SEASONAL_CODE");
		if (null != sapProducts.getFSEASONAL()) {
			if (null != sapProducts.getFSEASONAL().getFSEASONALCODE()) {
				if (null != sapProducts.getFSEASONAL().getFSEASONALCODE()
						.getFSEASONALCODEML()
						&& !sapProducts.getFSEASONAL().getFSEASONALCODE()
						.getFSEASONALCODEML().isEmpty()) {
					if (null != sapProducts.getFSEASONAL().getFSEASONALCODE()
							.getFSEASONALCODEML().get(0).getFSEASONALCODE()) {

						valueType.setContent(sapProducts.getFSEASONAL()
								.getFSEASONALCODE().getFSEASONALCODEML().get(0)
								.getFSEASONALCODE());

					}
				}

			}
		}
		values.getValueOrMultiValueOrValueGroup()
		.add(valueType);

		// F_GROCERY_SNACK_INDICATOR_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_GROCERY_SNACK_INDICATOR_NAME");
		if (null != sapProducts.getFGROCERYSNACKINDICATOR()) {
			if (null != sapProducts.getFGROCERYSNACKINDICATOR()
					.getFGROCERYSNACKINDICATORNAME()) {

				valueType.setContent(sapProducts.getFGROCERYSNACKINDICATOR()
						.getFGROCERYSNACKINDICATORNAME());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_HANDLING_INSTRUCTIONS_CODE - valid only for CASE in PIM - Made valid for all
		valueType = new ValueType();
		valueType.setAttributeID("F_HANDLING_INSTRUCTIONS_CODE");
		if (null != sapProducts.getFHANDLINGINSTRUCTIONSCODE()
				&& !sapProducts.getFHANDLINGINSTRUCTIONSCODE().isEmpty()) {
			if (null != sapProducts.getFHANDLINGINSTRUCTIONSCODE().get(0)
					.getFHANDLINGINSTRUCTIONSCODE()) {

				valueType.setContent(sapProducts.getFHANDLINGINSTRUCTIONSCODE()
						.get(0).getFHANDLINGINSTRUCTIONSCODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		/*// F_LAYERS_PER_TRADE_UNIT - commented as it is setting below for CASE and PALLET
		valueType = new ValueType();
		valueType.setAttributeID("F_LAYERS_PER_TRADE_UNIT");
		if (null != sapProducts.getFLAYERSPERTRADEUNIT()) {

			valueType.setContent(sapProducts.getFLAYERSPERTRADEUNIT()
					.toString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);*/

		// F_SERVINGS_OF_TRADE_ITEM_UNIT
		valueType = new ValueType();
		valueType.setAttributeID("F_SERVINGS_OF_TRADE_ITEM_UNIT");
		if (null != sapProducts.getFSERVINGSOFTRADEITEMUNIT()) {

			valueType.setContent(sapProducts.getFSERVINGSOFTRADEITEMUNIT());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_SERVING_SUGGESTIONS
		valueType = new ValueType();
		valueType.setAttributeID("F_SERVING_SUGGESTIONS");
		if (!("EACH".equals(unitDescCode))) {		
			if (null != sapProducts.getFSERVINGSUGGESTIONS()
					&& !sapProducts.getFSERVINGSUGGESTIONS().isEmpty()) {
				for (TSERVINGSUGGESTIONS servingSuggs : sapProducts
						.getFSERVINGSUGGESTIONS()) {
					if (null != servingSuggs.getFLANGUAGE()
							&& !servingSuggs.getFLANGUAGE().isEmpty()) {
						if (InboundProperties.engLangCode.equals(servingSuggs
								.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
							if (null != servingSuggs.getFSERVINGSUGGESTIONS()) {

								valueType.setContent(servingSuggs
										.getFSERVINGSUGGESTIONS());

							}
						}
					}
				}
			}
		}
		if (!("EACH".equals(unitDescCode))) {
			values.getValueOrMultiValueOrValueGroup().add(
					valueType);
		}

		// F_ECOMMERCE_PRODUCT_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_ECOMMERCE_PRODUCT_NAME");
		if (!("EACH".equals(unitDescCode))) {
			if (null != sapProducts.getFECOMMERCEPRODUCTNAME()) {
				valueType.setContent(sapProducts.getFECOMMERCEPRODUCTNAME());
			}
		}
		if (!("EACH".equals(unitDescCode))) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_FACTS_PANEL_LABEL_TYPE // Added For Food Service
		valueType = new ValueType();
		valueType.setAttributeID("F_FACTS_PANEL_LABEL_TYPE");
		if (null != sapProducts.getFFACTSPANELLABELTYPE()
				&& !sapProducts.getFFACTSPANELLABELTYPE().isEmpty()) {
			if ("EACH".equals(unitDescCode)
					|| "PACK/INNER PACK".equals(unitDescCode) || "CASE".equals(unitDescCode)) {

				valueType.setContent(sapProducts.getFFACTSPANELLABELTYPE());


			}
		}
		if ("EACH".equals(unitDescCode)
				|| "PACK/INNER PACK".equals(unitDescCode) || "CASE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}


		// F_PREPARATION_TYPE_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_PREPARATION_TYPE_NAME");
		if (null != sapProducts.getFPREPARATIONTYPE()) {
			if (null != sapProducts.getFPREPARATIONTYPE()
					.getFPREPARATIONTYPENAME()) {

				valueType.setContent(sapProducts.getFPREPARATIONTYPE()
						.getFPREPARATIONTYPENAME());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_ENDORSER_NAME
		valueType = new ValueType();
		valueType.setAttributeID("F_ENDORSER_NAME");
		if (null != sapProducts.getFENDORSER()) {

			valueType.setContent(sapProducts.getFENDORSER().getFENDORSERNAME());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NET_WEIGHT Closed For Kraft Canada - open this value 
		valueType = new ValueType();
		valueType.setAttributeID("F_NET_WEIGHT");
		if (null != sapProducts.getFNETWEIGHT()) {
			valueType.setContent(sapProducts.getFNETWEIGHT().toPlainString());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		//F_WEIGHT_UOM - UOM for F_NET_WEIGHT
		valueType = new ValueType();
		valueType.setAttributeID("F_WEIGHT_UOM");
		if (null != sapProducts.getFWEIGHTUOM()) {
			if(null != sapProducts.getFWEIGHTUOM().getFWEIGHTUOMCODE()) {
			valueType.setContent(sapProducts.getFWEIGHTUOM().getFWEIGHTUOMCODE());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		/*
		 * // F_WEIGHT_UOM_CODE if (null != sapProducts.getFWEIGHTUOM()) { if
		 * (null != sapProducts.getFWEIGHTUOM().getFWEIGHTUOMCODE()) { valueType
		 * = new ValueType(); valueType.setAttributeID("F_WEIGHT_UOM_CODE");
		 * valueType.setContent((String.valueOf(sapProducts
		 * .getFWEIGHTUOM().getFWEIGHTUOMCODE())));
		 * values.getValueOrMultiValueOrValueGroup().add(valueType); } }
		 */

		// F_PACKAGING_MATERIAL_TYPE_CODE
		valueType = new ValueType();
		valueType.setAttributeID("F_PACKAGING_MATERIAL_TYPE_CODE");
		if (null != sapProducts.getFPACKAGINGMATERIALTYPE()) {
			if (null != sapProducts.getFPACKAGINGMATERIALTYPE()
					.getFPACKAGINGMATERIALTYPECODE()) {

				valueType.setContent(sapProducts.getFPACKAGINGMATERIALTYPE()
						.getFPACKAGINGMATERIALTYPECODE());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_LENGTH_DEPTH_IN
		valueType = new ValueType();
		valueType.setAttributeID("F_LENGTH_DEPTH_IN");
		if (null != sapProducts.getFLENGTHDEPTHIN()) {

			valueType.setContent(sapProducts.getFLENGTHDEPTHIN()
					.toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_WIDTH_IN
		valueType = new ValueType();
		valueType.setAttributeID("F_WIDTH_IN");
		if (null != sapProducts.getFWIDTHIN()) {

			valueType.setContent(sapProducts.getFWIDTHIN().toPlainString());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		// F_WIDTH_MM
		valueType = new ValueType();
		valueType.setAttributeID("F_WIDTH_MM");
		if (null != sapProducts.getFWIDTHMM()) {

			valueType.setContent(sapProducts.getFWIDTHMM().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NET_WEIGHT_KG For Kraft Canada
		valueType = new ValueType();
		valueType.setAttributeID("F_NET_WEIGHT_KG");
		if (null != sapProducts.getFNETWEIGHTKG()) {

			valueType.setContent(sapProducts.getFNETWEIGHTKG().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NET_WEIGHT_GR For Kraft Canada
		valueType = new ValueType();
		valueType.setAttributeID("F_NET_WEIGHT_GR");
		if (null != sapProducts.getFNETWEIGHTGR()) {

			valueType.setContent(sapProducts.getFNETWEIGHTGR().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NET_WEIGHT_OZ
		valueType = new ValueType();
		valueType.setAttributeID("F_NET_WEIGHT_OZ");
		if (null != sapProducts.getFNETWEIGHTOZ()) {

			valueType.setContent(sapProducts.getFNETWEIGHTOZ());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NET_WEIGHT_LB
		valueType = new ValueType();
		valueType.setAttributeID("F_NET_WEIGHT_LB");
		if (null != sapProducts.getFNETWEIGHTLB()) {

			valueType.setContent(sapProducts.getFNETWEIGHTLB().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_LENGTH_DEPTH_MM
		valueType = new ValueType();
		valueType.setAttributeID("F_LENGTH_DEPTH_MM");
		if (null != sapProducts.getFLENGTHDEPTHMM()) {

			valueType.setContent(sapProducts.getFLENGTHDEPTHMM()
					.toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_LAYER_HEIGHT_IN
		valueType = new ValueType();
		valueType.setAttributeID("F_LAYER_HEIGHT_IN");
		if (null != sapProducts.getFLAYERHEIGHTIN()) {
			if ("PALLET".equals(unitDescCode)) {

				valueType.setContent(sapProducts.getFLAYERHEIGHTIN()
						.toPlainString());

			}
		}
		if ("PALLET".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_HEIGHT_MM
		valueType = new ValueType();
		valueType.setAttributeID("F_HEIGHT_MM");
		if (null != sapProducts.getFHEIGHTMM()) {

			valueType.setContent(sapProducts.getFHEIGHTMM().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_HEIGHT_IN
		valueType = new ValueType();
		valueType.setAttributeID("F_HEIGHT_IN");
		if (null != sapProducts.getFHEIGHTIN()) {

			valueType.setContent(sapProducts.getFHEIGHTIN().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		//F_GROSS_WEIGHT_KG For Kraft Canada
		valueType = new ValueType();
		valueType.setAttributeID("F_GROSS_WEIGHT_KG");
		if (null != sapProducts.getFGROSSWEIGHTKG()) {

			valueType.setContent(sapProducts.getFGROSSWEIGHTKG().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		//F_GROSS_WEIGHT_GR For Kraft Canada
		valueType = new ValueType();
		valueType.setAttributeID("F_GROSS_WEIGHT_GR");
		if (null != sapProducts.getFGROSSWEIGHTGR()) {

			valueType.setContent(sapProducts.getFGROSSWEIGHTGR().toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_GROSS_WEIGHT_OZ
		valueType = new ValueType();
		valueType.setAttributeID("F_GROSS_WEIGHT_OZ");
		if (null != sapProducts.getFGROSSWEIGHTOZ()) {

			valueType.setContent(sapProducts.getFGROSSWEIGHTOZ());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_GROSS_WEIGHT_LB
		valueType = new ValueType();
		valueType.setAttributeID("F_GROSS_WEIGHT_LB");
		if (null != sapProducts.getFGROSSWEIGHTLB()) {

			valueType.setContent(sapProducts.getFGROSSWEIGHTLB() 
					.toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		/*// F_GROSS_WEIGHT Closed  For Kraft Canada
		if (null != sapProducts.getFGROSSWEIGHT()) {
			valueType = new ValueType();
			valueType.setAttributeID("F_GROSS_WEIGHT");
			valueType.setContent(sapProducts.getFGROSSWEIGHT().toPlainString());
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}*/

		// F_DECLARED_NET_CONTENT_UOM_CODE Closed For Kraft Canada
		/*if (null != sapProducts.getFDECLAREDNETCONTENTDATA()
				&& !sapProducts.getFDECLAREDNETCONTENTDATA().isEmpty()) {
			if (null != sapProducts.getFDECLAREDNETCONTENTDATA().get(0)
					.getFDECLAREDNETCONTENTUOM()) {
				if (null != sapProducts.getFDECLAREDNETCONTENTDATA().get(0)
						.getFDECLAREDNETCONTENTUOM()
						.getFDECLAREDNETCONTENTUOMCODE()) {
					valueType = new ValueType();
					valueType.setAttributeID("F_DECLARED_NET_CONTENT_UOM_CODE");
					valueType.setContent(sapProducts
							.getFDECLAREDNETCONTENTDATA().get(0)
							.getFDECLAREDNETCONTENTUOM()
							.getFDECLAREDNETCONTENTUOMCODE());
					values.getValueOrMultiValueOrValueGroup().add(valueType);
				}
			}
		}*/

		// F_DECLARED_NET_CONTENT Closed For Kraft Canada
		/*if (null != sapProducts.getFDECLAREDNETCONTENTDATA() 
				&& !sapProducts.getFDECLAREDNETCONTENTDATA().isEmpty()) {
			if (null != sapProducts.getFDECLAREDNETCONTENTDATA().get(0)
					.getFDECLAREDNETCONTENT()) {
				valueType = new ValueType();
				valueType.setAttributeID("F_DECLARED_NET_CONTENT");
				valueType.setContent(sapProducts.getFDECLAREDNETCONTENTDATA()
						.get(0).getFDECLAREDNETCONTENT());
				values.getValueOrMultiValueOrValueGroup().add(valueType);
			}
		}*/

		// F_DECLARED_NET_CONTENT with corresponding F_DECLARED_NET_CONTENT_UOM_CODE for Kraft Canada
		//declareAllNetContent.addAll(attributeList.get(InboundProperties.declaredContentIndex));
		declareAllNetContent=AttributeList.declaredNetContent;
		if (null != sapProducts.getFDECLAREDNETCONTENTDATA()
				&& !sapProducts.getFDECLAREDNETCONTENTDATA().isEmpty()) {
			int i=0;
			List<String> declareContentSetAttributes=new ArrayList<String>();
			for (TDECLAREDNETCONTENTDATA fdecNetdata : sapProducts.getFDECLAREDNETCONTENTDATA()) {
				if (null != fdecNetdata.getFDECLAREDNETCONTENTUOM())
				{
					if(!fdecNetdata.getFDECLAREDNETCONTENTUOM().equals("")) {
						valueType = new ValueType();
						valueType.setAttributeID("F_DECLARED_NET_CONTENT_" + sapProducts.getFDECLAREDNETCONTENTDATA().get(i).getFDECLAREDNETCONTENTUOM().getFDECLAREDNETCONTENTUOMCODE() );
						declareContentSetAttributes.add("F_DECLARED_NET_CONTENT_" + sapProducts.getFDECLAREDNETCONTENTDATA().get(i).getFDECLAREDNETCONTENTUOM().getFDECLAREDNETCONTENTUOMCODE() );
						valueType.setContent(sapProducts.getFDECLAREDNETCONTENTDATA()
								.get(i).getFDECLAREDNETCONTENT());
						values.getValueOrMultiValueOrValueGroup().add(valueType);
						//i++;
					}
				}
				i++;
			}
			declareAllNetContent.removeAll(declareContentSetAttributes);
		}

		//Creating tag for null valued Declared Net Content
		for(int i=0;i<declareAllNetContent.size();i++)
		{
			valueType = new ValueType();
			valueType.setAttributeID(declareAllNetContent.get(i));
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_CUBIC_VOLUME_MR_3
		valueType = new ValueType();
		valueType.setAttributeID("F_CUBIC_VOLUME_MR_3");
		if (null != sapProducts.getFCUBICVOLUMEMR3()) {

			valueType.setContent(sapProducts.getFCUBICVOLUMEMR3()
					.toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_CUBIC_VOLUME_FT_3
		valueType = new ValueType();
		valueType.setAttributeID("F_CUBIC_VOLUME_FT_3");
		if (null != sapProducts.getFCUBICVOLUMEFT3()) {

			valueType.setContent(sapProducts.getFCUBICVOLUMEFT3()
					.toPlainString());

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_TEMPERATURE_CLASSIFICATION_MIN_FAHRENHEIT - valid for only CASE in PIM - Made valid for all
		valueType = new ValueType();
		valueType.setAttributeID("F_TEMPERATURE_MIN_FAHRENHEIT");
		if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()) {
			if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()
					.getFTEMPERATURECLASSIFICATIONMINFAHRENHEIT()) {

				valueType.setContent(sapProducts
						.getFTEMPERATURECLASSIFICATIONCODE()
						.getFTEMPERATURECLASSIFICATIONMINFAHRENHEIT()
						.toPlainString());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		// F_TEMPERATURE_CLASSIFICATION_MIN_CELCIUS- valid for only CASE in PIM - Made valid for all
		valueType = new ValueType();
		valueType.setAttributeID("F_TEMPERATURE_MIN_CELCIUS");
		if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()) {
			if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()
					.getFTEMPERATURECLASSIFICATIONMINCELCIUS()) {
				valueType.setContent(sapProducts
						.getFTEMPERATURECLASSIFICATIONCODE()
						.getFTEMPERATURECLASSIFICATIONMINCELCIUS()
						.toPlainString());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		// F_TEMPERATURE_CLASSIFICATION_MAX_FAHRENHEIT - valid only for CASE in PIM - Made valid for all
		valueType = new ValueType();
		valueType.setAttributeID("F_TEMPERATURE_MAX_FAHRENHEIT");
		if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()) {
			if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()
					.getFTEMPERATURECLASSIFICATIONMAXFAHRENHEIT()) {

				valueType.setContent(sapProducts
						.getFTEMPERATURECLASSIFICATIONCODE()
						.getFTEMPERATURECLASSIFICATIONMAXFAHRENHEIT()
						.toPlainString());

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_TEMPERATURE_CLASSIFICATION_MAX_CELCIUS - valid only for CASE in PIM - Made valid for all
		valueType = new ValueType();
		valueType.setAttributeID("F_TEMPERATURE_MAX_CELCIUS");
		if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()) {
			if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()
					.getFTEMPERATURECLASSIFICATIONMAXCELCIUS()) {

				valueType.setContent(sapProducts
						.getFTEMPERATURECLASSIFICATIONCODE()
						.getFTEMPERATURECLASSIFICATIONMAXCELCIUS()
						.toPlainString());
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		// F_TEMPERATURE_CLASSIFICATION_CODE added for food service
		valueType = new ValueType();
		valueType.setAttributeID("F_TEMPERATURE_CLASSIFICATION_CODE");
		if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()) {
			if (null != sapProducts.getFTEMPERATURECLASSIFICATIONCODE()
					.getFTEMPERATURECLASSIFICATIONCODE()) {

				valueType.setContent(sapProducts
						.getFTEMPERATURECLASSIFICATIONCODE()
						.getFTEMPERATURECLASSIFICATIONCODE().toString());

			}

		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_DIVISION_CATALYST
		valueType = new ValueType();
		valueType.setAttributeID("F_DIVISION_CATALYST");
		if (null != sapProducts.getFDIVISIONCATALYST()){
			if (null != sapProducts.getFDIVISIONCATALYST().getFDIVISIONCATALYSTCODE()) {

				valueType.setContent(sapProducts.getFDIVISIONCATALYST().getFDIVISIONCATALYSTCODE());

			}   
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);


		// F_STACKING_FACTOR - valid only for CASE in PIM
		valueType = new ValueType();
		valueType.setAttributeID("F_STACKING_FACTOR");
		if (sapProducts.getFSTACKINGFACTOR() != null) {
			if ("CASE".equals(unitDescCode)
					|| "DISPLAY/SHIPPER".equals(unitDescCode)
					|| "MIXED MODULE".equals(unitDescCode)) {

				valueType.setContent(sapProducts.getFSTACKINGFACTOR().toString());

			}
		}
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode)
				|| "MIXED MODULE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}


		// F_NEXT_LOWER_LEVEL_TRADE_UNITS_PER_LAYER - valid only for CASE in PIM
		valueType = new ValueType();
		valueType
		.setAttributeID("F_NEXT_LOWER_LEVEL_TRADE_UNITS_PER_LAYER");
		if (sapProducts.getFNEXTLOWERLEVELTRADEUNITSPERLAYER() != null) {
			if ("CASE".equals(unitDescCode)
					|| "DISPLAY/SHIPPER".equals(unitDescCode)
					|| "MIXED MODULE".equals(unitDescCode)) {

				valueType.setContent(sapProducts
						.getFNEXTLOWERLEVELTRADEUNITSPERLAYER().toString());

			}
		}
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode)
				|| "MIXED MODULE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_LAYERS_PER_TRADE_UNIT - vaid for CASE & PALLET in PIM
		valueType = new ValueType();
		valueType.setAttributeID("F_LAYERS_PER_TRADE_UNIT");
		if (sapProducts.getFLAYERSPERTRADEUNIT() != null) {
			if ("CASE".equals(unitDescCode)
					|| "DISPLAY/SHIPPER".equals(unitDescCode)
					|| "MIXED MODULE".equals(unitDescCode)) {

				valueType.setContent(sapProducts.getFLAYERSPERTRADEUNIT()
						.toString());

			}
		}
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode)
				|| "MIXED MODULE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		/*
		 * // F_ACCOUNT_ASSIGNMENT_GROUP_CODE if (null !=
		 * sapProducts.getFACCOUNTASSIGNMENTGROUP()) { valueType = new
		 * ValueType();
		 * valueType.setAttributeID("F_ACCOUNT_ASSIGNMENT_GROUP_CODE");
		 * valueType.setContent(sapProducts.getFACCOUNTASSIGNMENTGROUP()
		 * .getFACCOUNTASSIGNMENTGROUPCODE());
		 * values.getValueOrMultiValueOrValueGroup().add(valueType); }
		 */

		/*
		 * // F_ALLERGEN_CODE if (null != sapProducts.getFALLERGEN()) { if (null
		 * != sapProducts.getFALLERGEN().getFALLERGENCODE()) { valueType = new
		 * ValueType(); valueType.setAttributeID("F_ALLERGEN_CODE");
		 * valueType.setContent(sapProducts.getFALLERGEN() .getFALLERGENCODE());
		 * values.getValueOrMultiValueOrValueGroup().add(valueType); } }
		 */

		/*
		 * // F_STATUS_MDM_CODE if (null != sapProducts.getFSTATUSMDM()) { if
		 * (null != sapProducts.getFSTATUSMDM().getFSTATUSMDMCODE()) { valueType
		 * = new ValueType(); valueType.setAttributeID("F_STATUS_MDM_CODE");
		 * valueType.setContent(sapProducts.getFSTATUSMDM()
		 * .getFSTATUSMDMCODE());
		 * values.getValueOrMultiValueOrValueGroup().add(valueType); } }
		 */

		// F_COUNTRY_OF_PRODUCTION
		valueType = new ValueType();
		valueType.setAttributeID("F_COUNTRY_OF_PRODUCTION");
		if (null != sapProducts.getFCOUNTRYOFPRODUCTION()
				&& !sapProducts.getFCOUNTRYOFPRODUCTION().isEmpty()) {
			if (null != sapProducts.getFCOUNTRYOFPRODUCTION().get(0)
					.getFCOUNTRYCODE()) {


				valueType.setContent(sapProducts.getFCOUNTRYOFPRODUCTION()
						.get(0).getFCOUNTRYCODE());


			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_NUTRITIONALS
		//nutrAllAttributes.addAll(attributeList.get(InboundProperties.nutritionalAttributeIndex));
		nutrAllAttributes=AttributeList.nutritionalAttributeList;
		if (null != sapProducts.getFNUTRITIONALS()
				&& !sapProducts.getFNUTRITIONALS().isEmpty()) {
			if ("EACH".equals(unitDescCode)
					|| "PACK/INNER PACK".equals(unitDescCode) || "CASE".equals(unitDescCode)) {
				String servingCode = "";
				String attrTypeCode = "";
				String nutritionAttrQty = "";
				String nutritionAttrUomCode = "";
				String nutritionAttrPrefix = "";
				String nutritionAttrPct = "";
				String nutritionAttrPrecision = "";
				String nutritionPrepState = "";
				String nutritionServDesc = "";
				String nutritionServWt = "";
				String nutritionServUomCode = "";
				List<String> nutrSetAttributes=new ArrayList<String>();
				for (TNUTRITIONALDATA nutritionalData : sapProducts
						.getFNUTRITIONALS()) {

					servingCode = "";
					attrTypeCode = "";
					nutritionAttrQty = "";
					nutritionAttrUomCode = "";
					nutritionAttrPrefix = "";
					nutritionAttrPct = "";
					nutritionAttrPrecision = "";
					nutritionPrepState = "";
					nutritionServDesc = "";
					nutritionServWt = "";
					nutritionServUomCode = "";

					if (null != nutritionalData.getFNUTRITIONSERVINGCODE()
							&& !nutritionalData.getFNUTRITIONSERVINGCODE()
							.isEmpty()) {
						if (null != nutritionalData.getFNUTRITIONSERVINGCODE()
								.get(0).getFSERVINGCODE()) {
							servingCode = nutritionalData
									.getFNUTRITIONSERVINGCODE().get(0)
									.getFSERVINGCODE();
							if (servingCode.equals("SRV100")) {
								servingCode += "G";
							}
						}
					}
					if (null != nutritionalData.getFNUTRITIONATTRIBUTE()
							&& !nutritionalData.getFNUTRITIONATTRIBUTE()
							.isEmpty()) {
						if (null != nutritionalData.getFNUTRITIONATTRIBUTE()
								.get(0).getFNUTRITIONATTRIBUTETYPECODE()) {
							attrTypeCode = nutritionalData
									.getFNUTRITIONATTRIBUTE().get(0)
									.getFNUTRITIONATTRIBUTETYPECODE();
						}
					}
					if (null != nutritionalData.getFNUTRITIONATTRIBUTEQTY()) {
						nutritionAttrQty = nutritionalData
								.getFNUTRITIONATTRIBUTEQTY();
					}
					if (null != nutritionalData.getFNUTRITIONATTRIBUTEUOM()
							&& !nutritionalData.getFNUTRITIONATTRIBUTEUOM()
							.isEmpty()) {
						if (null != nutritionalData.getFNUTRITIONATTRIBUTEUOM()
								.get(0).getFNUTRITIONUOMCODE()) {
							nutritionAttrUomCode = nutritionalData
									.getFNUTRITIONATTRIBUTEUOM().get(0)
									.getFNUTRITIONUOMCODE();
						}
					}
					if (null != nutritionalData.getFNUTRITIONATTRIBUTEPCT()) {
						nutritionAttrPct = nutritionalData
								.getFNUTRITIONATTRIBUTEPCT();
					}
					if (null != nutritionalData
							.getFNUTRITIONATTRIBUTEPRECISION()) {
						nutritionAttrPrecision = nutritionalData
								.getFNUTRITIONATTRIBUTEPRECISION();
					}
					if (null != nutritionalData.getFNUTRITIONPREPARATIONSTATE()) {
						nutritionPrepState = nutritionalData
								.getFNUTRITIONPREPARATIONSTATE();
					}
					if (null != nutritionalData
							.getFNUTRITIONSERVINGDESCRIPTION()) {
						nutritionServDesc = nutritionalData
								.getFNUTRITIONSERVINGDESCRIPTION();
					}
					if (null != nutritionalData.getFNUTRITIONSERVINGWEIGHT()) {
						nutritionServWt = nutritionalData
								.getFNUTRITIONSERVINGWEIGHT();
					}
					if (null != nutritionalData.getFNUTRITIONWEIGHTUOM()
							&& !nutritionalData.getFNUTRITIONWEIGHTUOM()
							.isEmpty()) {
						if (null != nutritionalData.getFNUTRITIONWEIGHTUOM()
								.get(0).getFWEIGHTUOMCODE()) {
							nutritionServUomCode = nutritionalData
									.getFNUTRITIONWEIGHTUOM().get(0)
									.getFWEIGHTUOMCODE();
						}
					}

					nutritionAttrPrefix = "F_NUTR" + servingCode + "_";

					// F_NUTRSRV....._AMT
					valueType = new ValueType();
					valueType.setAttributeID(nutritionAttrPrefix + attrTypeCode
							+ "_AMT");
					nutrSetAttributes.add(nutritionAttrPrefix + attrTypeCode
							+ "_AMT");
					valueType.setContent(nutritionAttrQty);
					if (!nutritionAttrUomCode.isEmpty())
						valueType.setUnitID(nutritionAttrUomCode);
					values.getValueOrMultiValueOrValueGroup().add(valueType);

					// F_NUTRSRV....._RDA
					valueType = new ValueType();
					valueType.setAttributeID(nutritionAttrPrefix + attrTypeCode
							+ "_RDA");
					nutrSetAttributes.add(nutritionAttrPrefix + attrTypeCode
							+ "_RDA");
					valueType.setContent(nutritionAttrPct);
					values.getValueOrMultiValueOrValueGroup().add(valueType);

					// F_NUTRSRV....._PRECISION
					valueType = new ValueType();
					valueType.setAttributeID(nutritionAttrPrefix + attrTypeCode
							+ "_PRECISION");
					nutrSetAttributes.add(nutritionAttrPrefix + attrTypeCode
							+ "_PRECISION");
					valueType.setContent(nutritionAttrPrecision);
					values.getValueOrMultiValueOrValueGroup().add(valueType);

					// F_NUTRSRV....._PREPARATION_STATE
					valueType = new ValueType();
					valueType.setAttributeID(nutritionAttrPrefix + "PREPSTATE");
					nutrSetAttributes.add(nutritionAttrPrefix + "PREPSTATE");
					valueType.setContent(nutritionPrepState);
					values.getValueOrMultiValueOrValueGroup().add(valueType);

					// F_NUTRSRV....._SERVING_DESCRIPTION
					valueType = new ValueType();
					valueType.setAttributeID(nutritionAttrPrefix + "SERVDESC");
					nutrSetAttributes.add(nutritionAttrPrefix + "SERVDESC");
					valueType.setContent(nutritionServDesc);
					values.getValueOrMultiValueOrValueGroup().add(valueType);

					// F_NUTRSRV....._SERVING_WEIGHT
					valueType = new ValueType();
					valueType.setAttributeID(nutritionAttrPrefix + "SERVSIZE");
					nutrSetAttributes.add(nutritionAttrPrefix + "SERVSIZE");
					valueType.setContent(nutritionServWt);
					if (!nutritionServUomCode.isEmpty()) {
						valueType.setUnitID(nutritionServUomCode);
					}
					values.getValueOrMultiValueOrValueGroup().add(valueType);
				}
				nutrAllAttributes.removeAll(nutrSetAttributes);
			}
		}

		// Setting null valued nutritional attributes
		if(!("PALLET".equals(unitDescCode)))
		{
			for(int i=0;i<nutrAllAttributes.size();i++)
			{
				valueType=new ValueType();
				valueType.setAttributeID(nutrAllAttributes.get(i));
				values.getValueOrMultiValueOrValueGroup().add(valueType);
			}
		}

		// F_COUNTRY_OF_SALE
		valueType = new ValueType();
		valueType.setAttributeID("F_COUNTRY_OF_SALE");
		if (null != sapProducts.getFCOUNTRYOFSALE()
				&& !sapProducts.getFCOUNTRYOFSALE().isEmpty()) {
			String countryCode = "";
			for (TCOUNTRIES countries : sapProducts.getFCOUNTRYOFSALE()) {
				countryCode += "," + countries.getFCOUNTRYCODE();
			}
			countryCode = countryCode.replaceFirst(",", "");
			if (!countryCode.isEmpty()) {

				valueType.setContent(countryCode);

			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// F_CHILD_GTIN
		valueType = new ValueType();
		valueType.setAttributeID("F_CHILD_GTIN");
		if (null != sapProducts.getFCHILDPACKAGINGRELATIONSHIP()
				&& !sapProducts.getFCHILDPACKAGINGRELATIONSHIP().isEmpty()) {
			if (null != sapProducts.getFCHILDPACKAGINGRELATIONSHIP().get(0)
					.getFCHILDKRAFTITEMCODE()
					&& !sapProducts.getFCHILDPACKAGINGRELATIONSHIP().get(0)
					.getFCHILDKRAFTITEMCODE().isEmpty()) {
				String childGtin = "";
				for (TPCLRECORD childItem : sapProducts
						.getFCHILDPACKAGINGRELATIONSHIP().get(0)
						.getFCHILDKRAFTITEMCODE()) {
					childGtin += "," + childItem.getFGTIN();
				}
				childGtin = childGtin.replaceFirst(",", "");
				if (!childGtin.isEmpty()) {

					valueType.setContent(childGtin);

				}
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		// REMOVED_FROM_KRAFTRECIPE -  valid only for CASE in PIM
		valueType = new ValueType();
		valueType.setAttributeID("REMOVED_FROM_KRAFTRECIPE");
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode)
				|| "MIXED MODULE".equals(unitDescCode)) {

			valueType.setContent(InboundProperties.removedFromRecipies);

		}
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode)
				|| "MIXED MODULE".equals(unitDescCode)) {
			values.getValueOrMultiValueOrValueGroup().add(valueType);
		}

		// F_PRODUCT_DESCRIPTION_GRID
		valueType = new ValueType();
		valueType.setAttributeID("F_PRODUCT_DESCRIPTION_GRID");
		if (null != sapProducts.getFPRODUCTDESCRIPTIONGRID()) {
			if (null != sapProducts.getFPRODUCTDESCRIPTIONGRID()
					.getFPRODUCTDESCRIPTIONGRIDML()
					&& !sapProducts.getFPRODUCTDESCRIPTIONGRID()
					.getFPRODUCTDESCRIPTIONGRIDML().isEmpty()) {
				if (null != sapProducts.getFPRODUCTDESCRIPTIONGRID()
						.getFPRODUCTDESCRIPTIONGRIDML().get(0)
						.getFPRODUCTDESCRIPTIONGRID()) {

					valueType.setContent(sapProducts
							.getFPRODUCTDESCRIPTIONGRID()
							.getFPRODUCTDESCRIPTIONGRIDML().get(0)
							.getFPRODUCTDESCRIPTIONGRID());

				}
			}
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		//F_CONSUMER_UNIT_SIZE
		valueType=new ValueType();
		valueType.setAttributeID("F_CONSUMER_UNIT_SIZE");
		if(null !=sapProducts.getFCONSUMERUNITSIZE()){
			valueType.setContent(sapProducts.getFCONSUMERUNITSIZE().toPlainString());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		//F_CONSUMER_UNIT_SIZE_UOM 
		valueType=new ValueType();
		valueType.setAttributeID("F_CONSUMER_UNIT_SIZE_UOM");
		if(null !=sapProducts.getFCONSUMERUNITSIZEUOM()){
			valueType.setContent(sapProducts.getFCONSUMERUNITSIZEUOM().getFDECLAREDNETCONTENTUOMCODE());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		//F_ECOMM_PRODUCT_CATEGORY
		if ("CASE".equals(unitDescCode)
				|| "DISPLAY/SHIPPER".equals(unitDescCode))
		{
			if(!catalystCodeName.equals(""))
			{
				valueType = new ValueType();
				valueType.setAttributeID("F_ECOMM_PRODUCT_CATEGORY");
				valueType.setContent(catalystCodeName);
				values.getValueOrMultiValueOrValueGroup().add(valueType);
			} 
			else
			{
				valueType = new ValueType();
				valueType.setAttributeID("F_ECOMM_PRODUCT_CATEGORY");
				values.getValueOrMultiValueOrValueGroup().add(valueType);
			}
		}

		//F_MINIMUM_REMAINING_SHELF_LIFE
		valueType=new ValueType();
		valueType.setAttributeID("F_MINIMUM_REMAINING_SHELF_LIFE");
		if(null !=sapProducts.getFMINIMUMREMAININGSHELFLIFE()){
			valueType.setContent(sapProducts.getFMINIMUMREMAININGSHELFLIFE().toString());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		//F_FLUID_VOLUME_INDICATOR
		valueType=new ValueType();
		valueType.setAttributeID("F_FLUID_VOLUME_INDICATOR");
		if(null !=sapProducts.getFFLUIDVOLUMEINDICATOR()){
			valueType.setContent(sapProducts.getFFLUIDVOLUMEINDICATOR());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

		//F_SUB_UNITS_PER_ITEM
		valueType=new ValueType();
		valueType.setAttributeID("F_SUB_UNITS_PER_ITEM");
		if(null !=sapProducts.getFSUBUNITSPERITEM()){
			valueType.setContent(sapProducts.getFSUBUNITSPERITEM());
		}
		values.getValueOrMultiValueOrValueGroup().add(valueType);

	}

	private ValuesType extractFrenchAttributes(Products sapProducts) {

		ValuesType values = new ValuesType();
		ValueType valueType;

		// F_INGREDIENT_INFORMATION_CROSS_CONTACT_STATEMENT
		// F_INGREDIENT_INFORMATION_DOES_CONTAIN_STATEMENT
		// F_INGREDIENT_INFORMATION_HH_SERVING_SIZE
		// F_INGREDIENT_INFORMATION_STATEMENT
		if (null != sapProducts.getFINGREDIENTS()
				&& !sapProducts.getFINGREDIENTS().isEmpty()) {
			if ("EACH".equals(unitDescCode)
					|| "PACK/INNER PACK".equals(unitDescCode) || "CASE".equals(unitDescCode)) {
				for (TINGREDIENTINFORMATIONDATA ingredients : sapProducts
						.getFINGREDIENTS()) {
					if (null != ingredients.getFINGREDIENTINFORMATIONLANGUAGE()
							&& !ingredients.getFINGREDIENTINFORMATIONLANGUAGE()
							.isEmpty()) {
						if (InboundProperties.freLangCode.equals(ingredients
								.getFINGREDIENTINFORMATIONLANGUAGE().get(0)
								.getFLANGUAGECODE())) {
							if (null != ingredients
									.getFINGREDIENTINFORMATIONCROSSCONTACTSTATEMENT()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("F_INGREDIENT_INFO_CROSS_CONCT_STATEMENT");
								valueType
								.setContent(ingredients
										.getFINGREDIENTINFORMATIONCROSSCONTACTSTATEMENT());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
							if (null != ingredients
									.getFINGREDIENTINFORMATIONDOESCONTAINSTATEMENT()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("F_INGREDIENT_INFO_DOES_CONTAIN_STATEMENT");
								valueType
								.setContent(ingredients
										.getFINGREDIENTINFORMATIONDOESCONTAINSTATEMENT());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
							if (null != ingredients
									.getFINGREDIENTINFORMATIONHHSERVINGSIZE()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("F_INGREDIENT_INFORMATION_HH_SERVING_SIZE");
								valueType.setContent(ingredients
										.getFINGREDIENTINFORMATIONHHSERVINGSIZE());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
							if (null != ingredients
									.getFINGREDIENTINFORMATIONSTATEMENT()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("F_INGREDIENT_INFORMATION_STATEMENT");
								valueType.setContent(ingredients
										.getFINGREDIENTINFORMATIONSTATEMENT());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
								logger.debug("French value retrieved:"
										+ ingredients
										.getFINGREDIENTINFORMATIONSTATEMENT());
								logger.debug("French value populated:"
										+ valueType.getContent());
							}
						}
					}
				}
			}
		}

		// F_GENERAL_MARKETING_DESCRIPTION
		if (!("EACH".equals(unitDescCode))){
			if (null != sapProducts.getFGENERALMARKETINGDESCRIPTIONS()
					&& !sapProducts.getFGENERALMARKETINGDESCRIPTIONS().isEmpty()) {
				for (TGENERALMARKETINGDESCRIPTIONS genMktDesc : sapProducts
						.getFGENERALMARKETINGDESCRIPTIONS()) {
					if (null != genMktDesc.getFLANGUAGE()
							&& !genMktDesc.getFLANGUAGE().isEmpty()) {
						if (InboundProperties.freLangCode.equals(genMktDesc
								.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
							if (null != genMktDesc.getFGENMKTDESCRIPTION()) {
								valueType = new ValueType();
								valueType.setAttributeID("F_GEN_MKT_DESCRIPTION");
								valueType.setContent(genMktDesc
										.getFGENMKTDESCRIPTION());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
						}
					}
				}
			}
		}

		// F_PREPARATIONS_AND_COOKING_SUGGESTIONS
		if (!("EACH".equals(unitDescCode))) {
			if (null != sapProducts.getFPREPARATIONANDCOOKINGSUGGESTIONS()
					&& !sapProducts.getFPREPARATIONANDCOOKINGSUGGESTIONS()
					.isEmpty()) {
				for (TPREPARATIONANDCOOKINGSUGGESTIONS cookingSuggs : sapProducts
						.getFPREPARATIONANDCOOKINGSUGGESTIONS()) {
					if (null != cookingSuggs.getFLANGUAGE()
							&& !cookingSuggs.getFLANGUAGE().isEmpty()) {
						if (InboundProperties.freLangCode.equals(cookingSuggs
								.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
							if (null != cookingSuggs.getFPREPANDCOOKSUGGESTIONS()) {
								valueType = new ValueType();
								valueType
								.setAttributeID("F_PREP_AND_COOK_SUGGESTIONS");
								valueType.setContent(cookingSuggs
										.getFPREPANDCOOKSUGGESTIONS());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
						}
					}
				}
			}
		}

		// F_PRODUCT_BENEFITS
		if (!("EACH".equals(unitDescCode))) {
			if (null != sapProducts.getFPRODUCTBENEFITS()
					&& !sapProducts.getFPRODUCTBENEFITS().isEmpty()) {

				for (TPRODUCTBENEFITS prodBenefits : sapProducts
						.getFPRODUCTBENEFITS()) {
					if (null != prodBenefits.getFLANGUAGE()
							&& !prodBenefits.getFLANGUAGE().isEmpty()) {
						if (InboundProperties.freLangCode.equals(prodBenefits
								.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
							if (null != prodBenefits.getFPRODUCTBENEFITS()) {
								valueType = new ValueType();
								valueType.setAttributeID("F_PRODUCT_BENEFITS");
								valueType.setContent(prodBenefits
										.getFPRODUCTBENEFITS());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
						}
					}
				}
			}
		}
		// F_SERVING_SUGGESTIONS
		if (!("EACH".equals(unitDescCode))){
			if (null != sapProducts.getFSERVINGSUGGESTIONS()
					&& !sapProducts.getFSERVINGSUGGESTIONS().isEmpty()) {
				for (TSERVINGSUGGESTIONS servingSuggs : sapProducts
						.getFSERVINGSUGGESTIONS()) {
					if (null != servingSuggs.getFLANGUAGE()
							&& !servingSuggs.getFLANGUAGE().isEmpty()) {
						if (InboundProperties.freLangCode.equals(servingSuggs
								.getFLANGUAGE().get(0).getFLANGUAGECODE())) {
							if (null != servingSuggs.getFSERVINGSUGGESTIONS()) {
								valueType = new ValueType();
								valueType.setAttributeID("F_SERVING_SUGGESTIONS");
								valueType.setContent(servingSuggs
										.getFSERVINGSUGGESTIONS());
								values.getValueOrMultiValueOrValueGroup().add(
										valueType);
							}
						}
					}
				}
			}
		}
		return values;
	}

	public void storeSTEPinLocal(STEPProductInformation prodInfo) {
		// keep in local folder
		try {
			logger.debug("Creating STEP xml for GTIN:" + productId);
			File outputFolder = new File(InboundProperties.outputPath);
			if (!outputFolder.exists()) {
				System.out.println("creating FOLDER");
				outputFolder.mkdirs();
				System.out.println(outputFolder.getPath());
			}
			JAXBContext stepContext = JAXBContext.newInstance(stepSchemaPath);
			Marshaller stepMarshaller = stepContext.createMarshaller();
			String sysDate = InboundProperties.cloudDateFormat
					.format(new Date());
			System.out.println(sysDate);
			stepMarshaller
			.marshal(prodInfo, new File(InboundProperties.outputPath
					+ "/STEP-" + sysDate + ".xml"));
			logger.debug("Created STep xml:STEP-" + sysDate + ".xml");
		} catch (JAXBException e) {
			logger.debug("Error marshalling the STEP related JAXBObject", e);
		}
	}

	//brandName=brandSubbrandName[0] ,  brandName=brandSubbrandName[1]
	@SuppressWarnings("null")
	private String[] extractBrandSubbrand(Products sapProducts) {
		String[] brandSubbrandName = new String[2];
		if (null != sapProducts.getFBRANDSUBBRAND()) {
			if (null != sapProducts.getFBRANDSUBBRAND().getFBRANDNAME()) {
				if(sapProducts.getFBRANDSUBBRAND().getFBRANDNAME().contains(">") ) {

					String[] brandNames = sapProducts.getFBRANDSUBBRAND()
							.getFBRANDNAME().split(">");

					if (brandNames.length > 1) {
						brandSubbrandName[0] = brandNames[0];
						brandSubbrandName[1] = brandNames[1];
					} else {
						brandSubbrandName[0] = brandNames[0];
						brandSubbrandName[1] = brandNames[1];
					}
				}
				else
				{
					brandSubbrandName[0] = sapProducts.getFBRANDSUBBRAND().getFBRANDNAME();
					brandSubbrandName[1] = sapProducts.getFBRANDSUBBRAND().getFBRANDNAME();
				}


			}
		}
		return brandSubbrandName;
	}

	private String extractFunctionalName(Products sapProducts) {
		String functionalName = "";
		if (null != sapProducts.getFFUNCTIONALNAME()) {
			if (null != sapProducts.getFFUNCTIONALNAME().getFFUNCTIONALNAME()) {
				if (null != sapProducts.getFFUNCTIONALNAME()
						.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML()
						&& !sapProducts.getFFUNCTIONALNAME()
						.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML()
						.isEmpty()) {
					if (null != sapProducts.getFFUNCTIONALNAME()
							.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML().get(0)
							.getFFUNCTIONALNAME()) {
						functionalName = sapProducts.getFFUNCTIONALNAME()
								.getFFUNCTIONALNAME().getFFUNCTIONALNAMEML()
								.get(0).getFFUNCTIONALNAME();
					}
				}
			}
		}
		return functionalName;
	}

	private static String restructureHier(String BRAND_SUBBRAND,
			String FUNCTIONAL_NAME, String prefix) {
		String hierarchyId = BRAND_SUBBRAND + "|" + FUNCTIONAL_NAME;
		if (hierarchyId.length() > 38) {
			if (BRAND_SUBBRAND.length() > 18) {
				BRAND_SUBBRAND = abbreviate(BRAND_SUBBRAND);
			}
			if (FUNCTIONAL_NAME.length() > 19) {
				FUNCTIONAL_NAME = abbreviate(FUNCTIONAL_NAME);
			}
			hierarchyId = BRAND_SUBBRAND + '|' + FUNCTIONAL_NAME;
		}
		return prefix + hierarchyId;
	}

	private static String abbreviate(String expanded) {
		char[] charArray = expanded.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(charArray[0]);
		for (int i = 0; i < expanded.length(); i++) {
			if (charArray[i] == ' ' || charArray[i] == '-') {
				stringBuilder.append(charArray[i + 1]);
			}
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws Exception {
		File sapFile = new File("CASE_10068100893653.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(sapFile)));
		String sapString = reader.readLine();
		ParseSap parse = new ParseSap();
		LinkedList<STEPProductInformation> prodInfoList = parse
				.parse(sapString,null);
		reader.close();

		// Keep file locally
		for (STEPProductInformation prod : prodInfoList) {
			JAXBContext stepContext = JAXBContext.newInstance(stepSchemaPath);
			Marshaller stepMarshaller = stepContext.createMarshaller();
			String sysDate = InboundProperties.cloudDateFormat
					.format(new Date());
			stepMarshaller.marshal(prod, new File("STEP-" + sysDate + ".xml"));
		}

	}
}
