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
 * <p>Java class for T_STATUSES_GLOBAL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_STATUSES_GLOBAL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_STATUS_GLOBAL_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
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
@XmlType(name = "T_STATUSES_GLOBAL", propOrder = {
    "fstatusglobalname"
})
public class TSTATUSESGLOBAL {

    @XmlElement(name = "F_STATUS_GLOBAL_NAME")
    protected String fstatusglobalname;

    /**
     * Gets the value of the fstatusglobalname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFSTATUSGLOBALNAME() {
        return fstatusglobalname;
    }

    /**
     * Sets the value of the fstatusglobalname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFSTATUSGLOBALNAME(String value) {
        this.fstatusglobalname = value;
    }

}