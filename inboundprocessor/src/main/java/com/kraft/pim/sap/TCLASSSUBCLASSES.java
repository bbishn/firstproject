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
 * <p>Java class for T_CLASS_SUBCLASSES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_CLASS_SUBCLASSES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_CLASS_SUBCLASS_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_CLASS_SUBCLASS_NAME" minOccurs="0">
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
@XmlType(name = "T_CLASS_SUBCLASSES", propOrder = {
    "fclasssubclasscode",
    "fclasssubclassname"
})
public class TCLASSSUBCLASSES {

    @XmlElement(name = "F_CLASS_SUBCLASS_CODE")
    protected String fclasssubclasscode;
    @XmlElement(name = "F_CLASS_SUBCLASS_NAME")
    protected String fclasssubclassname;

    /**
     * Gets the value of the fclasssubclasscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCLASSSUBCLASSCODE() {
        return fclasssubclasscode;
    }

    /**
     * Sets the value of the fclasssubclasscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCLASSSUBCLASSCODE(String value) {
        this.fclasssubclasscode = value;
    }

    /**
     * Gets the value of the fclasssubclassname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFCLASSSUBCLASSNAME() {
        return fclasssubclassname;
    }

    /**
     * Sets the value of the fclasssubclassname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFCLASSSUBCLASSNAME(String value) {
        this.fclasssubclassname = value;
    }

}