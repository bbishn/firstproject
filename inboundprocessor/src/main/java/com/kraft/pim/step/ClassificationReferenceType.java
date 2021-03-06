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
 *                 This element describes a link to a classification from either a product or an asset
 *             
 * 
 * <p>Java class for ClassificationReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassificationReferenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MetaData" type="{}MetaDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="InheritedFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AnalyzerResult" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Changed" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="QualifierID" type="{}StepID" />
 *       &lt;attribute name="ClassificationID" use="required" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassificationReferenceType", propOrder = {
    "metaData"
})
public class ClassificationReferenceType {

    @XmlElement(name = "MetaData")
    protected MetaDataType metaData;
    @XmlAttribute(name = "InheritedFrom")
    protected String inheritedFrom;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "AnalyzerResult")
    protected String analyzerResult;
    @XmlAttribute(name = "Changed")
    protected TrueFalseType changed;
    @XmlAttribute(name = "QualifierID")
    protected String qualifierID;
    @XmlAttribute(name = "ClassificationID", required = true)
    protected String classificationID;

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
     * Gets the value of the inheritedFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInheritedFrom() {
        return inheritedFrom;
    }

    /**
     * Sets the value of the inheritedFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInheritedFrom(String value) {
        this.inheritedFrom = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the analyzerResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnalyzerResult() {
        return analyzerResult;
    }

    /**
     * Sets the value of the analyzerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalyzerResult(String value) {
        this.analyzerResult = value;
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
     * Gets the value of the classificationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassificationID() {
        return classificationID;
    }

    /**
     * Sets the value of the classificationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassificationID(String value) {
        this.classificationID = value;
    }

}
