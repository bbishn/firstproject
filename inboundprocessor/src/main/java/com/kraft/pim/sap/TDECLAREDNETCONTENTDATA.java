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
 * <p>Java class for T_DECLARED_NET_CONTENT_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_DECLARED_NET_CONTENT_DATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_DECLARED_NET_CONTENT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_DECLARED_NET_CONTENT_UOM" type="{}T_DECLARED_NET_CONTENT_UOMS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_DECLARED_NET_CONTENT_DATA", propOrder = {
    "fdeclarednetcontent",
    "fdeclarednetcontentuom"
})
public class TDECLAREDNETCONTENTDATA {

    @XmlElement(name = "F_DECLARED_NET_CONTENT")
    protected String fdeclarednetcontent;
    @XmlElement(name = "F_DECLARED_NET_CONTENT_UOM")
    protected TDECLAREDNETCONTENTUOMS fdeclarednetcontentuom;

    /**
     * Gets the value of the fdeclarednetcontent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFDECLAREDNETCONTENT() {
        return fdeclarednetcontent;
    }

    /**
     * Sets the value of the fdeclarednetcontent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFDECLAREDNETCONTENT(String value) {
        this.fdeclarednetcontent = value;
    }

    /**
     * Gets the value of the fdeclarednetcontentuom property.
     * 
     * @return
     *     possible object is
     *     {@link TDECLAREDNETCONTENTUOMS }
     *     
     */
    public TDECLAREDNETCONTENTUOMS getFDECLAREDNETCONTENTUOM() {
        return fdeclarednetcontentuom;
    }

    /**
     * Sets the value of the fdeclarednetcontentuom property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDECLAREDNETCONTENTUOMS }
     *     
     */
    public void setFDECLAREDNETCONTENTUOM(TDECLAREDNETCONTENTUOMS value) {
        this.fdeclarednetcontentuom = value;
    }

}
