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
 * <p>Java class for F_VARIANT_NAME_22_ML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="F_VARIANT_NAME_22_ML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_VARIANT_NAMELanguage" type="{}Language" minOccurs="0"/>
 *         &lt;element name="F_VARIANT_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="115"/>
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
@XmlType(name = "F_VARIANT_NAME_22_ML", propOrder = {
    "fvariantnameLanguage",
    "fvariantname"
})
public class FVARIANTNAME22ML {

    @XmlElement(name = "F_VARIANT_NAMELanguage")
    @XmlSchemaType(name = "string")
    protected Language fvariantnameLanguage;
    @XmlElement(name = "F_VARIANT_NAME")
    protected String fvariantname;

    /**
     * Gets the value of the fvariantnameLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getFVARIANTNAMELanguage() {
        return fvariantnameLanguage;
    }

    /**
     * Sets the value of the fvariantnameLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setFVARIANTNAMELanguage(Language value) {
        this.fvariantnameLanguage = value;
    }

    /**
     * Gets the value of the fvariantname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFVARIANTNAME() {
        return fvariantname;
    }

    /**
     * Sets the value of the fvariantname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFVARIANTNAME(String value) {
        this.fvariantname = value;
    }

}
