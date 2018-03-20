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
 * <p>Java class for T_WARNING_STATEMENT_SEGMENT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_WARNING_STATEMENT_SEGMENT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_LANGUAGE" type="{}T_LANGUAGES" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="F_WARNING_STATEMENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_WARNING_STATEMENT_SEGMENT", propOrder = {
    "flanguage",
    "fwarningstatement"
})
public class TWARNINGSTATEMENTSEGMENT {

    @XmlElement(name = "F_LANGUAGE")
    protected List<TLANGUAGES> flanguage;
    @XmlElement(name = "F_WARNING_STATEMENT")
    protected String fwarningstatement;

    /**
     * Gets the value of the flanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFLANGUAGE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLANGUAGES }
     * 
     * 
     */
    public List<TLANGUAGES> getFLANGUAGE() {
        if (flanguage == null) {
            flanguage = new ArrayList<TLANGUAGES>();
        }
        return this.flanguage;
    }

    /**
     * Gets the value of the fwarningstatement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFWARNINGSTATEMENT() {
        return fwarningstatement;
    }

    /**
     * Sets the value of the fwarningstatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFWARNINGSTATEMENT(String value) {
        this.fwarningstatement = value;
    }

}