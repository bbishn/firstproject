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
 * <p>Java class for T_FIRST_AVAILABLE_SHIP_DATE_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_FIRST_AVAILABLE_SHIP_DATE_DATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_SHIP_TO_COUNTRY" type="{}T_COUNTRIES" minOccurs="0"/>
 *         &lt;element name="F_FIRST_AVAILABLE_SHIP_DATE" minOccurs="0">
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
@XmlType(name = "T_FIRST_AVAILABLE_SHIP_DATE_DATA", propOrder = {
    "fshiptocountry",
    "ffirstavailableshipdate"
})
public class TFIRSTAVAILABLESHIPDATEDATA {

    @XmlElement(name = "F_SHIP_TO_COUNTRY")
    protected TCOUNTRIES fshiptocountry;
    @XmlElement(name = "F_FIRST_AVAILABLE_SHIP_DATE")
    protected String ffirstavailableshipdate;

    /**
     * Gets the value of the fshiptocountry property.
     * 
     * @return
     *     possible object is
     *     {@link TCOUNTRIES }
     *     
     */
    public TCOUNTRIES getFSHIPTOCOUNTRY() {
        return fshiptocountry;
    }

    /**
     * Sets the value of the fshiptocountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCOUNTRIES }
     *     
     */
    public void setFSHIPTOCOUNTRY(TCOUNTRIES value) {
        this.fshiptocountry = value;
    }

    /**
     * Gets the value of the ffirstavailableshipdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFIRSTAVAILABLESHIPDATE() {
        return ffirstavailableshipdate;
    }

    /**
     * Sets the value of the ffirstavailableshipdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFIRSTAVAILABLESHIPDATE(String value) {
        this.ffirstavailableshipdate = value;
    }

}
