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
 * <p>Java class for T_REGIONS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_REGIONS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_REGION_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_REGION_NAME">
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
@XmlType(name = "T_REGIONS", propOrder = {
    "fregioncode",
    "fregionname"
})
public class TREGIONS {

    @XmlElement(name = "F_REGION_CODE", required = true)
    protected String fregioncode;
    @XmlElement(name = "F_REGION_NAME", required = true)
    protected String fregionname;

    /**
     * Gets the value of the fregioncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFREGIONCODE() {
        return fregioncode;
    }

    /**
     * Sets the value of the fregioncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFREGIONCODE(String value) {
        this.fregioncode = value;
    }

    /**
     * Gets the value of the fregionname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFREGIONNAME() {
        return fregionname;
    }

    /**
     * Sets the value of the fregionname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFREGIONNAME(String value) {
        this.fregionname = value;
    }

}