//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:49:43 PM IST 
//


package com.kraft.pim.sap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_LANGUAGES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_LANGUAGES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_LANGUAGE_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_LANGUAGE_NAME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_LANGUAGE_ERP_LOOKUP" type="{}T_LANGUAGE_ERP_LOOKUP" maxOccurs="unbounded"/>
 *         &lt;element name="F_LANGUAGE_ISO_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_LANGUAGE_SAP_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
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
@XmlType(name = "T_LANGUAGES", propOrder = {
    "flanguagecode",
    "flanguagename",
    "flanguageerplookup",
    "flanguageisocode",
    "flanguagesapcode"
})
public class TLANGUAGES {

    @XmlElement(name = "F_LANGUAGE_CODE", required = true)
    protected String flanguagecode;
    @XmlElement(name = "F_LANGUAGE_NAME", required = true)
    protected String flanguagename;
    @XmlElement(name = "F_LANGUAGE_ERP_LOOKUP", required = true)
    protected List<TLANGUAGEERPLOOKUP> flanguageerplookup;
    @XmlElement(name = "F_LANGUAGE_ISO_CODE", required = true)
    protected String flanguageisocode;
    @XmlElement(name = "F_LANGUAGE_SAP_CODE", required = true)
    protected String flanguagesapcode;

    /**
     * Gets the value of the flanguagecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLANGUAGECODE() {
        return flanguagecode;
    }

    /**
     * Sets the value of the flanguagecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLANGUAGECODE(String value) {
        this.flanguagecode = value;
    }

    /**
     * Gets the value of the flanguagename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLANGUAGENAME() {
        return flanguagename;
    }

    /**
     * Sets the value of the flanguagename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLANGUAGENAME(String value) {
        this.flanguagename = value;
    }

    /**
     * Gets the value of the flanguageerplookup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flanguageerplookup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFLANGUAGEERPLOOKUP().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLANGUAGEERPLOOKUP }
     * 
     * 
     */
    public List<TLANGUAGEERPLOOKUP> getFLANGUAGEERPLOOKUP() {
        if (flanguageerplookup == null) {
            flanguageerplookup = new ArrayList<TLANGUAGEERPLOOKUP>();
        }
        return this.flanguageerplookup;
    }

    /**
     * Gets the value of the flanguageisocode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLANGUAGEISOCODE() {
        return flanguageisocode;
    }

    /**
     * Sets the value of the flanguageisocode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLANGUAGEISOCODE(String value) {
        this.flanguageisocode = value;
    }

    /**
     * Gets the value of the flanguagesapcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLANGUAGESAPCODE() {
        return flanguagesapcode;
    }

    /**
     * Sets the value of the flanguagesapcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLANGUAGESAPCODE(String value) {
        this.flanguagesapcode = value;
    }

}
