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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for F_SALES_STATUS_CODE_56_ML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="F_SALES_STATUS_CODE_56_ML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_SALES_STATUS_CODELanguage" type="{}Language" minOccurs="0"/>
 *         &lt;element name="F_SALES_STATUS_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
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
@XmlType(name = "F_SALES_STATUS_CODE_56_ML", propOrder = {
    "fsalesstatuscodeLanguage",
    "fsalesstatuscode"
})
public class FSALESSTATUSCODE56ML {

    @XmlElement(name = "F_SALES_STATUS_CODELanguage")
    @XmlSchemaType(name = "string")
    protected Language fsalesstatuscodeLanguage;
    @XmlElement(name = "F_SALES_STATUS_CODE")
    protected String fsalesstatuscode;

    /**
     * Gets the value of the fsalesstatuscodeLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getFSALESSTATUSCODELanguage() {
        return fsalesstatuscodeLanguage;
    }

    /**
     * Sets the value of the fsalesstatuscodeLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setFSALESSTATUSCODELanguage(Language value) {
        this.fsalesstatuscodeLanguage = value;
    }

    /**
     * Gets the value of the fsalesstatuscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFSALESSTATUSCODE() {
        return fsalesstatuscode;
    }

    /**
     * Sets the value of the fsalesstatuscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFSALESSTATUSCODE(String value) {
        this.fsalesstatuscode = value;
    }

}