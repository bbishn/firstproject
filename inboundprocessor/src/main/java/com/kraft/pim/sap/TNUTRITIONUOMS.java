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
 * <p>Java class for T_NUTRITION_UOMS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_NUTRITION_UOMS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_NUTRITION_UOM_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_NUTRITION_UOM_NAME" minOccurs="0">
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
@XmlType(name = "T_NUTRITION_UOMS", propOrder = {
    "fnutritionuomcode",
    "fnutritionuomname"
})
public class TNUTRITIONUOMS {

    @XmlElement(name = "F_NUTRITION_UOM_CODE")
    protected String fnutritionuomcode;
    @XmlElement(name = "F_NUTRITION_UOM_NAME")
    protected String fnutritionuomname;

    /**
     * Gets the value of the fnutritionuomcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONUOMCODE() {
        return fnutritionuomcode;
    }

    /**
     * Sets the value of the fnutritionuomcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONUOMCODE(String value) {
        this.fnutritionuomcode = value;
    }

    /**
     * Gets the value of the fnutritionuomname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONUOMNAME() {
        return fnutritionuomname;
    }

    /**
     * Sets the value of the fnutritionuomname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONUOMNAME(String value) {
        this.fnutritionuomname = value;
    }

}
