package com.kraft.pim.preprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class AttributeList {

	private static final Logger logger = Logger.getLogger(AttributeList.class);
	static ArrayList<String> nutritionalAttributeList=new ArrayList<String>();
	static ArrayList<String> otherNutritionalAttributeList=new ArrayList<String>();
	static ArrayList<String> declaredNetContent=new ArrayList<String>();
	static List<ArrayList<String>> listAttribute=new ArrayList<ArrayList<String>>();
	public List<ArrayList<String>> setAttribute() 
	{
		// TODO Auto-generated method stub
		//For all the Nutritional Attribute Present in PIM except for other Nutritional
		String[] attributeType=new String[]{"ADDSUG","ASH","BIOT","CA","CAL","CHO-","CHOAVL","CHOL-","CLD","CR","CU","DIFCA","ENER-","ENERPF","FAMS","FAPU","FAPUN3","FAPUN6","FASAT","FAT","FATRN","FIB-","FIBINS","FIBSOL","FIBTSW","FOL","FE","ID","K","LACS","MG","MN","MO","MOIT","NA","NACL","NIA","NIAEQ","OTHPROX","P","PANTAC","PRO-","RIBF","SATFAT","SE","SUGALC","SUGAR","THIA","VITA","VITAA","VITAECA","VITB12","VITB6-","VITC","VITD","VITDCA","VITE","VITK","ZN"};
		String[] servCode=new String[]{"SRV100G","SRV1","SRV2","SRV3"};
		logger.debug("Creating Nutritional Attribute present in PIM except for other Nutritional");
		for(int i=0;i<servCode.length;i++)
		{
			String nutritionAttrPrefix = "F_NUTR" + servCode[i] + "_";
			for(int j=0;j<attributeType.length;j++)
			{
				nutritionalAttributeList.add(nutritionAttrPrefix+attributeType[j]+ "_AMT");
				nutritionalAttributeList.add(nutritionAttrPrefix+attributeType[j]+ "_RDA");
				nutritionalAttributeList.add(nutritionAttrPrefix+attributeType[j]+ "_PRECISION");
			}
			nutritionalAttributeList.add(nutritionAttrPrefix + "PREPSTATE");
			nutritionalAttributeList.add(nutritionAttrPrefix + "SERVDESC");
			nutritionalAttributeList.add(nutritionAttrPrefix + "SERVSIZE");
		}

		// For Other Nutritional Attributes
		String[] sutabilityType=new String[]{"KOSHER","HALAL","ORGANIC"};
		logger.debug("Creating Other Nutritional Attribute present in PIM except for Ingredient Info");
		for(int i=0;i<sutabilityType.length;i++)
		{
			otherNutritionalAttributeList.add(sutabilityType[i]+"_SUITABILITY_INFO_SYMBOL");
			otherNutritionalAttributeList.add(sutabilityType[i]+"_SUITABILITY_CERT_AGENCY");
			otherNutritionalAttributeList.add(sutabilityType[i]+"_SUITABILITY_INFO_DOC_NUMBER");
			otherNutritionalAttributeList.add(sutabilityType[i]+"_SUITABILITY_INFO_INDICATOR");
		}


		//For F_DECLARED_NET_CONTENT_* except F_DECLARED_NET_CONTENT & F_DECLARED_NET_CONTENT_UOM_CODE
		String[] netContent=new String[]{"1N","FO","GA","GR","IN","KG","LB","LT","ML","OZ","PC","PK","PT","QT","UN"};
		logger.debug("Creating all F_DECLARED_NET_CONTENT_* present in PIM ");
		for(int i=0;i<netContent.length;i++)
		{
			declaredNetContent.add("F_DECLARED_NET_CONTENT_"+netContent[i]);
		}
		//sequence must be same for adding to listAttribute 
		//nutritionalAttributeList=0
		//otherNutritionalAttributeList=1
		//declaredNetContent=2
		listAttribute.add(nutritionalAttributeList);
		listAttribute.add(otherNutritionalAttributeList);
		listAttribute.add(declaredNetContent);
		return listAttribute;
	}

}
