//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:49:43 PM IST 
//


package com.kraft.pim.sap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_ALTERNATE_UOM_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_ALTERNATE_UOM_DATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_ALTERNATE_KRAFT_ITEM_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_UOM" type="{}T_ALTERNATE_UOMS" minOccurs="0"/>
 *         &lt;element name="F_ALTERNATE_PRODUCT_DESCRIPTION_SHORT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_CALCULATION_OVERRIDE_INDICATOR" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_DENOMINATOR_FOR_CONVERSION_TO_BASE_UOM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_NUMERATOR_FOR_CONVERSION_TO_BASE_UOM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_GTIN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_GTIN_GTIN_TYPE" type="{}T_GTIN_GTIN_TYPES" minOccurs="0"/>
 *         &lt;element name="F_ALTERNATE_LENGTH_DEPTH_IN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_WIDTH_IN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_HEIGHT_IN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_STACKING_FACTOR" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_CUBIC_VOLUME_FT3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_GROSS_WEIGHT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_LENGTH_DEPTH_IN_MM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_WIDTH_IN_MM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_HEIGHT_IN_MM" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_CUBIC_VOLUME_IN_M3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_GROSS_WEIGHT_IN_KG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_UOM_ERP" type="{}T_ALTERNATE_SYSTEMS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_ALTERNATE_UOM_DATA", propOrder = {
    "falternatekraftitemcode",
    "falternateuom",
    "falternateproductdescriptionshort",
    "fcalculationoverrideindicator",
    "fdenominatorforconversiontobaseuom",
    "fnumeratorforconversiontobaseuom",
    "falternategtin",
    "falternategtingtintype",
    "falternatelengthdepthin",
    "falternatewidthin",
    "falternateheightin",
    "falternatestackingfactor",
    "falternatecubicvolumeft3",
    "fgrossweight",
    "falternatelengthdepthinmm",
    "falternatewidthinmm",
    "falternateheightinmm",
    "falternatecubicvolumeinm3",
    "falternategrossweightinkg",
    "falternateuomerp"
})
public class TALTERNATEUOMDATA {

    @XmlElement(name = "F_ALTERNATE_KRAFT_ITEM_CODE")
    protected String falternatekraftitemcode;
    @XmlElement(name = "F_ALTERNATE_UOM")
    protected TALTERNATEUOMS falternateuom;
    @XmlElement(name = "F_ALTERNATE_PRODUCT_DESCRIPTION_SHORT")
    protected String falternateproductdescriptionshort;
    @XmlElement(name = "F_CALCULATION_OVERRIDE_INDICATOR")
    protected String fcalculationoverrideindicator;
    @XmlElement(name = "F_DENOMINATOR_FOR_CONVERSION_TO_BASE_UOM")
    protected BigInteger fdenominatorforconversiontobaseuom;
    @XmlElement(name = "F_NUMERATOR_FOR_CONVERSION_TO_BASE_UOM")
    protected BigInteger fnumeratorforconversiontobaseuom;
    @XmlElement(name = "F_ALTERNATE_GTIN")
    protected String falternategtin;
    @XmlElement(name = "F_ALTERNATE_GTIN_GTIN_TYPE")
    protected TGTINGTINTYPES falternategtingtintype;
    @XmlElement(name = "F_ALTERNATE_LENGTH_DEPTH_IN")
    protected BigDecimal falternatelengthdepthin;
    @XmlElement(name = "F_ALTERNATE_WIDTH_IN")
    protected BigDecimal falternatewidthin;
    @XmlElement(name = "F_ALTERNATE_HEIGHT_IN")
    protected BigDecimal falternateheightin;
    @XmlElement(name = "F_ALTERNATE_STACKING_FACTOR")
    protected BigDecimal falternatestackingfactor;
    @XmlElement(name = "F_ALTERNATE_CUBIC_VOLUME_FT3")
    protected BigDecimal falternatecubicvolumeft3;
    @XmlElement(name = "F_GROSS_WEIGHT")
    protected BigDecimal fgrossweight;
    @XmlElement(name = "F_ALTERNATE_LENGTH_DEPTH_IN_MM")
    protected BigDecimal falternatelengthdepthinmm;
    @XmlElement(name = "F_ALTERNATE_WIDTH_IN_MM")
    protected BigDecimal falternatewidthinmm;
    @XmlElement(name = "F_ALTERNATE_HEIGHT_IN_MM")
    protected BigDecimal falternateheightinmm;
    @XmlElement(name = "F_ALTERNATE_CUBIC_VOLUME_IN_M3")
    protected BigDecimal falternatecubicvolumeinm3;
    @XmlElement(name = "F_ALTERNATE_GROSS_WEIGHT_IN_KG")
    protected BigDecimal falternategrossweightinkg;
    @XmlElement(name = "F_ALTERNATE_UOM_ERP")
    protected List<TALTERNATESYSTEMS> falternateuomerp;

    /**
     * Gets the value of the falternatekraftitemcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFALTERNATEKRAFTITEMCODE() {
        return falternatekraftitemcode;
    }

    /**
     * Sets the value of the falternatekraftitemcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFALTERNATEKRAFTITEMCODE(String value) {
        this.falternatekraftitemcode = value;
    }

    /**
     * Gets the value of the falternateuom property.
     * 
     * @return
     *     possible object is
     *     {@link TALTERNATEUOMS }
     *     
     */
    public TALTERNATEUOMS getFALTERNATEUOM() {
        return falternateuom;
    }

    /**
     * Sets the value of the falternateuom property.
     * 
     * @param value
     *     allowed object is
     *     {@link TALTERNATEUOMS }
     *     
     */
    public void setFALTERNATEUOM(TALTERNATEUOMS value) {
        this.falternateuom = value;
    }

    /**
     * Gets the value of the falternateproductdescriptionshort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFALTERNATEPRODUCTDESCRIPTIONSHORT() {
        return falternateproductdescriptionshort;
    }

    /**
     * Sets the value of the falternateproductdescriptionshort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFALTERNATEPRODUCTDESCRIPTIONSHORT(String value) {
        this.falternateproductdescriptionshort = value;
    }

    /**
     * Gets the value of the fcalculationoverrideindicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCALCULATIONOVERRIDEINDICATOR() {
        return fcalculationoverrideindicator;
    }

    /**
     * Sets the value of the fcalculationoverrideindicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCALCULATIONOVERRIDEINDICATOR(String value) {
        this.fcalculationoverrideindicator = value;
    }

    /**
     * Gets the value of the fdenominatorforconversiontobaseuom property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFDENOMINATORFORCONVERSIONTOBASEUOM() {
        return fdenominatorforconversiontobaseuom;
    }

    /**
     * Sets the value of the fdenominatorforconversiontobaseuom property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFDENOMINATORFORCONVERSIONTOBASEUOM(BigInteger value) {
        this.fdenominatorforconversiontobaseuom = value;
    }

    /**
     * Gets the value of the fnumeratorforconversiontobaseuom property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFNUMERATORFORCONVERSIONTOBASEUOM() {
        return fnumeratorforconversiontobaseuom;
    }

    /**
     * Sets the value of the fnumeratorforconversiontobaseuom property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFNUMERATORFORCONVERSIONTOBASEUOM(BigInteger value) {
        this.fnumeratorforconversiontobaseuom = value;
    }

    /**
     * Gets the value of the falternategtin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFALTERNATEGTIN() {
        return falternategtin;
    }

    /**
     * Sets the value of the falternategtin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFALTERNATEGTIN(String value) {
        this.falternategtin = value;
    }

    /**
     * Gets the value of the falternategtingtintype property.
     * 
     * @return
     *     possible object is
     *     {@link TGTINGTINTYPES }
     *     
     */
    public TGTINGTINTYPES getFALTERNATEGTINGTINTYPE() {
        return falternategtingtintype;
    }

    /**
     * Sets the value of the falternategtingtintype property.
     * 
     * @param value
     *     allowed object is
     *     {@link TGTINGTINTYPES }
     *     
     */
    public void setFALTERNATEGTINGTINTYPE(TGTINGTINTYPES value) {
        this.falternategtingtintype = value;
    }

    /**
     * Gets the value of the falternatelengthdepthin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATELENGTHDEPTHIN() {
        return falternatelengthdepthin;
    }

    /**
     * Sets the value of the falternatelengthdepthin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATELENGTHDEPTHIN(BigDecimal value) {
        this.falternatelengthdepthin = value;
    }

    /**
     * Gets the value of the falternatewidthin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATEWIDTHIN() {
        return falternatewidthin;
    }

    /**
     * Sets the value of the falternatewidthin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATEWIDTHIN(BigDecimal value) {
        this.falternatewidthin = value;
    }

    /**
     * Gets the value of the falternateheightin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATEHEIGHTIN() {
        return falternateheightin;
    }

    /**
     * Sets the value of the falternateheightin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATEHEIGHTIN(BigDecimal value) {
        this.falternateheightin = value;
    }

    /**
     * Gets the value of the falternatestackingfactor property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATESTACKINGFACTOR() {
        return falternatestackingfactor;
    }

    /**
     * Sets the value of the falternatestackingfactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATESTACKINGFACTOR(BigDecimal value) {
        this.falternatestackingfactor = value;
    }

    /**
     * Gets the value of the falternatecubicvolumeft3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATECUBICVOLUMEFT3() {
        return falternatecubicvolumeft3;
    }

    /**
     * Sets the value of the falternatecubicvolumeft3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATECUBICVOLUMEFT3(BigDecimal value) {
        this.falternatecubicvolumeft3 = value;
    }

    /**
     * Gets the value of the fgrossweight property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFGROSSWEIGHT() {
        return fgrossweight;
    }

    /**
     * Sets the value of the fgrossweight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFGROSSWEIGHT(BigDecimal value) {
        this.fgrossweight = value;
    }

    /**
     * Gets the value of the falternatelengthdepthinmm property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATELENGTHDEPTHINMM() {
        return falternatelengthdepthinmm;
    }

    /**
     * Sets the value of the falternatelengthdepthinmm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATELENGTHDEPTHINMM(BigDecimal value) {
        this.falternatelengthdepthinmm = value;
    }

    /**
     * Gets the value of the falternatewidthinmm property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATEWIDTHINMM() {
        return falternatewidthinmm;
    }

    /**
     * Sets the value of the falternatewidthinmm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATEWIDTHINMM(BigDecimal value) {
        this.falternatewidthinmm = value;
    }

    /**
     * Gets the value of the falternateheightinmm property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATEHEIGHTINMM() {
        return falternateheightinmm;
    }

    /**
     * Sets the value of the falternateheightinmm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATEHEIGHTINMM(BigDecimal value) {
        this.falternateheightinmm = value;
    }

    /**
     * Gets the value of the falternatecubicvolumeinm3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATECUBICVOLUMEINM3() {
        return falternatecubicvolumeinm3;
    }

    /**
     * Sets the value of the falternatecubicvolumeinm3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATECUBICVOLUMEINM3(BigDecimal value) {
        this.falternatecubicvolumeinm3 = value;
    }

    /**
     * Gets the value of the falternategrossweightinkg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFALTERNATEGROSSWEIGHTINKG() {
        return falternategrossweightinkg;
    }

    /**
     * Sets the value of the falternategrossweightinkg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFALTERNATEGROSSWEIGHTINKG(BigDecimal value) {
        this.falternategrossweightinkg = value;
    }

    /**
     * Gets the value of the falternateuomerp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the falternateuomerp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFALTERNATEUOMERP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TALTERNATESYSTEMS }
     * 
     * 
     */
    public List<TALTERNATESYSTEMS> getFALTERNATEUOMERP() {
        if (falternateuomerp == null) {
            falternateuomerp = new ArrayList<TALTERNATESYSTEMS>();
        }
        return this.falternateuomerp;
    }

}
