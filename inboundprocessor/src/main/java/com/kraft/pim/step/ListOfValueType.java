//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.13 at 03:27:41 PM IST 
//


package com.kraft.pim.step;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Represents a LOV. Values in this LOV have the dimension dependencies described by the dimension links
 *                 and must conform to the validation rules described in Validation. The list of values is described by the
 *                 nested Value and/or ValueGroup elements.
 *             
 * 
 * <p>Java class for ListOfValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Validation" type="{}ValidationType"/>
 *         &lt;element name="DimensionLink" type="{}DimensionLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MetaData" type="{}MetaDataType" minOccurs="0"/>
 *         &lt;element name="AttributeGroupLink" type="{}AttributeGroupLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Value" type="{}ValueType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="ValueGroup" type="{}ValueGroupType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" use="required" type="{}StepID" />
 *       &lt;attribute name="ParentID" type="{}StepID" />
 *       &lt;attribute name="AllowUserValueAddition" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="UseValueID" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="IDPattern" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DefaultUnitID" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfValueType", propOrder = {
    "name",
    "validation",
    "dimensionLink",
    "metaData",
    "attributeGroupLink",
    "value",
    "valueGroup"
})
public class ListOfValueType {

    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "Validation", required = true)
    protected ValidationType validation;
    @XmlElement(name = "DimensionLink")
    protected List<DimensionLinkType> dimensionLink;
    @XmlElement(name = "MetaData")
    protected MetaDataType metaData;
    @XmlElement(name = "AttributeGroupLink")
    protected List<AttributeGroupLinkType> attributeGroupLink;
    @XmlElement(name = "Value")
    protected List<ValueType> value;
    @XmlElement(name = "ValueGroup")
    protected List<ValueGroupType> valueGroup;
    @XmlAttribute(name = "ID", required = true)
    protected String id;
    @XmlAttribute(name = "ParentID")
    protected String parentID;
    @XmlAttribute(name = "AllowUserValueAddition")
    protected TrueFalseType allowUserValueAddition;
    @XmlAttribute(name = "UseValueID")
    protected TrueFalseType useValueID;
    @XmlAttribute(name = "IDPattern")
    protected String idPattern;
    @XmlAttribute(name = "DefaultUnitID")
    protected String defaultUnitID;

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     * 
     * 
     */
    public List<NameType> getName() {
        if (name == null) {
            name = new ArrayList<NameType>();
        }
        return this.name;
    }

    /**
     * Gets the value of the validation property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationType }
     *     
     */
    public ValidationType getValidation() {
        return validation;
    }

    /**
     * Sets the value of the validation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationType }
     *     
     */
    public void setValidation(ValidationType value) {
        this.validation = value;
    }

    /**
     * Gets the value of the dimensionLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dimensionLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDimensionLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionLinkType }
     * 
     * 
     */
    public List<DimensionLinkType> getDimensionLink() {
        if (dimensionLink == null) {
            dimensionLink = new ArrayList<DimensionLinkType>();
        }
        return this.dimensionLink;
    }

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
     * Gets the value of the attributeGroupLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeGroupLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeGroupLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeGroupLinkType }
     * 
     * 
     */
    public List<AttributeGroupLinkType> getAttributeGroupLink() {
        if (attributeGroupLink == null) {
            attributeGroupLink = new ArrayList<AttributeGroupLinkType>();
        }
        return this.attributeGroupLink;
    }

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueType }
     * 
     * 
     */
    public List<ValueType> getValue() {
        if (value == null) {
            value = new ArrayList<ValueType>();
        }
        return this.value;
    }

    /**
     * Gets the value of the valueGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueGroupType }
     * 
     * 
     */
    public List<ValueGroupType> getValueGroup() {
        if (valueGroup == null) {
            valueGroup = new ArrayList<ValueGroupType>();
        }
        return this.valueGroup;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the parentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentID() {
        return parentID;
    }

    /**
     * Sets the value of the parentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentID(String value) {
        this.parentID = value;
    }

    /**
     * Gets the value of the allowUserValueAddition property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getAllowUserValueAddition() {
        if (allowUserValueAddition == null) {
            return TrueFalseType.FALSE;
        } else {
            return allowUserValueAddition;
        }
    }

    /**
     * Sets the value of the allowUserValueAddition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setAllowUserValueAddition(TrueFalseType value) {
        this.allowUserValueAddition = value;
    }

    /**
     * Gets the value of the useValueID property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getUseValueID() {
        if (useValueID == null) {
            return TrueFalseType.FALSE;
        } else {
            return useValueID;
        }
    }

    /**
     * Sets the value of the useValueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setUseValueID(TrueFalseType value) {
        this.useValueID = value;
    }

    /**
     * Gets the value of the idPattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPattern() {
        return idPattern;
    }

    /**
     * Sets the value of the idPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPattern(String value) {
        this.idPattern = value;
    }

    /**
     * Gets the value of the defaultUnitID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultUnitID() {
        return defaultUnitID;
    }

    /**
     * Sets the value of the defaultUnitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultUnitID(String value) {
        this.defaultUnitID = value;
    }

}