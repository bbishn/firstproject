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
 * <p>Java class for T_MATERIAL_TYPES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_MATERIAL_TYPES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_MATERIAL_TYPE_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_MATERIAL_TYPE_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
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
@XmlType(name = "T_MATERIAL_TYPES", propOrder = {
    "fmaterialtypecode",
    "fmaterialtypename"
})
public class TMATERIALTYPES {

    @XmlElement(name = "F_MATERIAL_TYPE_CODE")
    protected String fmaterialtypecode;
    @XmlElement(name = "F_MATERIAL_TYPE_NAME")
    protected String fmaterialtypename;

    /**
     * Gets the value of the fmaterialtypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMATERIALTYPECODE() {
        return fmaterialtypecode;
    }

    /**
     * Sets the value of the fmaterialtypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMATERIALTYPECODE(String value) {
        this.fmaterialtypecode = value;
    }

    /**
     * Gets the value of the fmaterialtypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMATERIALTYPENAME() {
        return fmaterialtypename;
    }

    /**
     * Sets the value of the fmaterialtypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMATERIALTYPENAME(String value) {
        this.fmaterialtypename = value;
    }

}