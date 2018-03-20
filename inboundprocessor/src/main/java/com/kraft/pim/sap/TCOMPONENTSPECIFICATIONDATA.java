//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:49:43 PM IST 
//


package com.kraft.pim.sap;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_COMPONENT_SPECIFICATION_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_COMPONENT_SPECIFICATION_DATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_COMPONENT_SPECIFICATION_GTIN" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_COMPONENT_SPECIFICATION_NUMBER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="22"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_COMPONENT_QUANTITY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_COMPONENT_SPECIFICATION_TYPE" type="{}T_SPECIFICATION_TYPES" minOccurs="0"/>
 *         &lt;element name="F_COMPONENT_KRAFT_ITEM_CODES" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_COMPONENT_SPECIFICATION_DATA", propOrder = {
    "fcomponentspecificationgtin",
    "fcomponentspecificationnumber",
    "fcomponentquantity",
    "fcomponentspecificationtype",
    "fcomponentkraftitemcodes"
})
public class TCOMPONENTSPECIFICATIONDATA {

    @XmlElement(name = "F_COMPONENT_SPECIFICATION_GTIN")
    protected String fcomponentspecificationgtin;
    @XmlElement(name = "F_COMPONENT_SPECIFICATION_NUMBER")
    protected String fcomponentspecificationnumber;
    @XmlElement(name = "F_COMPONENT_QUANTITY")
    protected BigDecimal fcomponentquantity;
    @XmlElement(name = "F_COMPONENT_SPECIFICATION_TYPE")
    protected TSPECIFICATIONTYPES fcomponentspecificationtype;
    @XmlElement(name = "F_COMPONENT_KRAFT_ITEM_CODES")
    protected String fcomponentkraftitemcodes;

    /**
     * Gets the value of the fcomponentspecificationgtin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCOMPONENTSPECIFICATIONGTIN() {
        return fcomponentspecificationgtin;
    }

    /**
     * Sets the value of the fcomponentspecificationgtin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCOMPONENTSPECIFICATIONGTIN(String value) {
        this.fcomponentspecificationgtin = value;
    }

    /**
     * Gets the value of the fcomponentspecificationnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCOMPONENTSPECIFICATIONNUMBER() {
        return fcomponentspecificationnumber;
    }

    /**
     * Sets the value of the fcomponentspecificationnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCOMPONENTSPECIFICATIONNUMBER(String value) {
        this.fcomponentspecificationnumber = value;
    }

    /**
     * Gets the value of the fcomponentquantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFCOMPONENTQUANTITY() {
        return fcomponentquantity;
    }

    /**
     * Sets the value of the fcomponentquantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFCOMPONENTQUANTITY(BigDecimal value) {
        this.fcomponentquantity = value;
    }

    /**
     * Gets the value of the fcomponentspecificationtype property.
     * 
     * @return
     *     possible object is
     *     {@link TSPECIFICATIONTYPES }
     *     
     */
    public TSPECIFICATIONTYPES getFCOMPONENTSPECIFICATIONTYPE() {
        return fcomponentspecificationtype;
    }

    /**
     * Sets the value of the fcomponentspecificationtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSPECIFICATIONTYPES }
     *     
     */
    public void setFCOMPONENTSPECIFICATIONTYPE(TSPECIFICATIONTYPES value) {
        this.fcomponentspecificationtype = value;
    }

    /**
     * Gets the value of the fcomponentkraftitemcodes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCOMPONENTKRAFTITEMCODES() {
        return fcomponentkraftitemcodes;
    }

    /**
     * Sets the value of the fcomponentkraftitemcodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCOMPONENTKRAFTITEMCODES(String value) {
        this.fcomponentkraftitemcodes = value;
    }

}
