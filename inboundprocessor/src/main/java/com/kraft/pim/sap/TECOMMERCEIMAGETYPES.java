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
 * <p>Java class for T_ECOMMERCE_IMAGE_TYPES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_ECOMMERCE_IMAGE_TYPES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_ECOMMERCE_IMAGE_TYPE_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
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
@XmlType(name = "T_ECOMMERCE_IMAGE_TYPES", propOrder = {
    "fecommerceimagetypename"
})
public class TECOMMERCEIMAGETYPES {

    @XmlElement(name = "F_ECOMMERCE_IMAGE_TYPE_NAME")
    protected String fecommerceimagetypename;

    /**
     * Gets the value of the fecommerceimagetypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFECOMMERCEIMAGETYPENAME() {
        return fecommerceimagetypename;
    }

    /**
     * Sets the value of the fecommerceimagetypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFECOMMERCEIMAGETYPENAME(String value) {
        this.fecommerceimagetypename = value;
    }

}