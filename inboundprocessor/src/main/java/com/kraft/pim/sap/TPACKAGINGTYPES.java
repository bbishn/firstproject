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
 * <p>Java class for T_PACKAGING_TYPES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_PACKAGING_TYPES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_PACKAGING_TYPE_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="35"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_PACKAGING_TYPE_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
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
@XmlType(name = "T_PACKAGING_TYPES", propOrder = {
    "fpackagingtypecode",
    "fpackagingtypename"
})
public class TPACKAGINGTYPES {

    @XmlElement(name = "F_PACKAGING_TYPE_CODE")
    protected String fpackagingtypecode;
    @XmlElement(name = "F_PACKAGING_TYPE_NAME")
    protected String fpackagingtypename;

    /**
     * Gets the value of the fpackagingtypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFPACKAGINGTYPECODE() {
        return fpackagingtypecode;
    }

    /**
     * Sets the value of the fpackagingtypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFPACKAGINGTYPECODE(String value) {
        this.fpackagingtypecode = value;
    }

    /**
     * Gets the value of the fpackagingtypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFPACKAGINGTYPENAME() {
        return fpackagingtypename;
    }

    /**
     * Sets the value of the fpackagingtypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFPACKAGINGTYPENAME(String value) {
        this.fpackagingtypename = value;
    }

}
