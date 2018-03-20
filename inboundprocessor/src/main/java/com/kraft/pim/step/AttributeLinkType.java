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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The AttributeLink element links an attribute into a classification or a product
 *             
 * 
 * <p>Java class for AttributeLinkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttributeLinkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MetaData" type="{}MetaDataType" minOccurs="0"/>
 *         &lt;element name="ValueFilter" type="{}ValueFilterType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Changed" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="QualifierID" type="{}StepID" />
 *       &lt;attribute name="Mandatory" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="AttributeID" use="required" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeLinkType", propOrder = {
    "metaData",
    "valueFilter"
})
public class AttributeLinkType {

    @XmlElement(name = "MetaData")
    protected MetaDataType metaData;
    @XmlElement(name = "ValueFilter")
    protected ValueFilterType valueFilter;
    @XmlAttribute(name = "Changed")
    protected TrueFalseType changed;
    @XmlAttribute(name = "QualifierID")
    protected String qualifierID;
    @XmlAttribute(name = "Mandatory")
    protected TrueFalseType mandatory;
    @XmlAttribute(name = "AttributeID", required = true)
    protected String attributeID;

    /**
     * Gets the value of the metaData property.
     * 
     * @return
     *     possible object is
     *     {@link MetaDataType }
     *     
     */
    public MetaDataType getMetaData() {
        return metaData;
    }

    /**
     * Sets the value of the metaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaDataType }
     *     
     */
    public void setMetaData(MetaDataType value) {
        this.metaData = value;
    }

    /**
     * Gets the value of the valueFilter property.
     * 
     * @return
     *     possible object is
     *     {@link ValueFilterType }
     *     
     */
    public ValueFilterType getValueFilter() {
        return valueFilter;
    }

    /**
     * Sets the value of the valueFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueFilterType }
     *     
     */
    public void setValueFilter(ValueFilterType value) {
        this.valueFilter = value;
    }

    /**
     * Gets the value of the changed property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getChanged() {
        if (changed == null) {
            return TrueFalseType.FALSE;
        } else {
            return changed;
        }
    }

    /**
     * Sets the value of the changed property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setChanged(TrueFalseType value) {
        this.changed = value;
    }

    /**
     * Gets the value of the qualifierID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifierID() {
        return qualifierID;
    }

    /**
     * Sets the value of the qualifierID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifierID(String value) {
        this.qualifierID = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getMandatory() {
        if (mandatory == null) {
            return TrueFalseType.FALSE;
        } else {
            return mandatory;
        }
    }

    /**
     * Sets the value of the mandatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setMandatory(TrueFalseType value) {
        this.mandatory = value;
    }

    /**
     * Gets the value of the attributeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeID() {
        return attributeID;
    }

    /**
     * Sets the value of the attributeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeID(String value) {
        this.attributeID = value;
    }

}