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
 * <p>Java class for F_GTIN_TRADE_ITEM_TYPE_16_ML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="F_GTIN_TRADE_ITEM_TYPE_16_ML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_GTIN_TRADE_ITEM_TYPELanguage" type="{}Language" minOccurs="0"/>
 *         &lt;element name="F_GTIN_TRADE_ITEM_TYPE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
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
@XmlType(name = "F_GTIN_TRADE_ITEM_TYPE_16_ML", propOrder = {
    "fgtintradeitemtypeLanguage",
    "fgtintradeitemtype"
})
public class FGTINTRADEITEMTYPE16ML {

    @XmlElement(name = "F_GTIN_TRADE_ITEM_TYPELanguage")
    @XmlSchemaType(name = "string")
    protected Language fgtintradeitemtypeLanguage;
    @XmlElement(name = "F_GTIN_TRADE_ITEM_TYPE")
    protected String fgtintradeitemtype;

    /**
     * Gets the value of the fgtintradeitemtypeLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getFGTINTRADEITEMTYPELanguage() {
        return fgtintradeitemtypeLanguage;
    }

    /**
     * Sets the value of the fgtintradeitemtypeLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setFGTINTRADEITEMTYPELanguage(Language value) {
        this.fgtintradeitemtypeLanguage = value;
    }

    /**
     * Gets the value of the fgtintradeitemtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFGTINTRADEITEMTYPE() {
        return fgtintradeitemtype;
    }

    /**
     * Sets the value of the fgtintradeitemtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFGTINTRADEITEMTYPE(String value) {
        this.fgtintradeitemtype = value;
    }

}
