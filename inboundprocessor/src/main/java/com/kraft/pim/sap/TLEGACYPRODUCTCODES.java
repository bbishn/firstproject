//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:49:43 PM IST 
//


package com.kraft.pim.sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_LEGACY_PRODUCT_CODES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_LEGACY_PRODUCT_CODES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_LEGACY_PRODUCT_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_LEGACY_SYSTEM_ID" type="{}T_LEGACY_SYSTEM_IDS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_LEGACY_PRODUCT_CODES", propOrder = {
    "flegacyproductcode",
    "flegacysystemid"
})
public class TLEGACYPRODUCTCODES {

    @XmlElement(name = "F_LEGACY_PRODUCT_CODE")
    protected String flegacyproductcode;
    @XmlElement(name = "F_LEGACY_SYSTEM_ID")
    protected TLEGACYSYSTEMIDS flegacysystemid;

    /**
     * Gets the value of the flegacyproductcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLEGACYPRODUCTCODE() {
        return flegacyproductcode;
    }

    /**
     * Sets the value of the flegacyproductcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLEGACYPRODUCTCODE(String value) {
        this.flegacyproductcode = value;
    }

    /**
     * Gets the value of the flegacysystemid property.
     * 
     * @return
     *     possible object is
     *     {@link TLEGACYSYSTEMIDS }
     *     
     */
    public TLEGACYSYSTEMIDS getFLEGACYSYSTEMID() {
        return flegacysystemid;
    }

    /**
     * Sets the value of the flegacysystemid property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLEGACYSYSTEMIDS }
     *     
     */
    public void setFLEGACYSYSTEMID(TLEGACYSYSTEMIDS value) {
        this.flegacysystemid = value;
    }

}
