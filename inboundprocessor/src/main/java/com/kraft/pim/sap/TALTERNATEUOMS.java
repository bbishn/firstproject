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
 * <p>Java class for T_ALTERNATE_UOMS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_ALTERNATE_UOMS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_ALTERNATE_UOM_CODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_ALTERNATE_UOM_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
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
@XmlType(name = "T_ALTERNATE_UOMS", propOrder = {
    "falternateuomcode",
    "falternateuomname"
})
public class TALTERNATEUOMS {

    @XmlElement(name = "F_ALTERNATE_UOM_CODE")
    protected String falternateuomcode;
    @XmlElement(name = "F_ALTERNATE_UOM_NAME")
    protected String falternateuomname;

    /**
     * Gets the value of the falternateuomcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFALTERNATEUOMCODE() {
        return falternateuomcode;
    }

    /**
     * Sets the value of the falternateuomcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFALTERNATEUOMCODE(String value) {
        this.falternateuomcode = value;
    }

    /**
     * Gets the value of the falternateuomname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFALTERNATEUOMNAME() {
        return falternateuomname;
    }

    /**
     * Sets the value of the falternateuomname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFALTERNATEUOMNAME(String value) {
        this.falternateuomname = value;
    }

}
