//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.13 at 03:27:41 PM IST 
//


package com.kraft.pim.step;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Links to a LOV.
 *             
 * 
 * <p>Java class for ListOfValueLinkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfValueLinkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ListOfValueID" use="required" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfValueLinkType")
public class ListOfValueLinkType {

    @XmlAttribute(name = "ListOfValueID", required = true)
    protected String listOfValueID;

    /**
     * Gets the value of the listOfValueID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListOfValueID() {
        return listOfValueID;
    }

    /**
     * Sets the value of the listOfValueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListOfValueID(String value) {
        this.listOfValueID = value;
    }

}
