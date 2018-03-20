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
 * <p>Java class for EntityCrossReferenceTypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntityCrossReferenceTypeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AttributeLink" type="{}AttributeLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DimensionLink" type="{}DimensionLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AttributeGroupLink" type="{}AttributeGroupLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UserTypeLink" type="{}UserTypeLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TargetUserTypeLink" type="{}TargetUserTypeLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Inherited" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="ID" use="required" type="{}StepID" />
 *       &lt;attribute name="Revised" type="{}TrueFalseType" default="true" />
 *       &lt;attribute name="Completeness" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MultiValued" type="{}TrueFalseType" default="true" />
 *       &lt;attribute name="Mandatory" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="Accumulated" type="{}TrueFalseType" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityCrossReferenceTypeType", propOrder = {
    "name",
    "attributeLink",
    "dimensionLink",
    "attributeGroupLink",
    "userTypeLink",
    "targetUserTypeLink"
})
public class EntityCrossReferenceTypeType {

    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "AttributeLink")
    protected List<AttributeLinkType> attributeLink;
    @XmlElement(name = "DimensionLink")
    protected List<DimensionLinkType> dimensionLink;
    @XmlElement(name = "AttributeGroupLink")
    protected List<AttributeGroupLinkType> attributeGroupLink;
    @XmlElement(name = "UserTypeLink")
    protected List<UserTypeLinkType> userTypeLink;
    @XmlElement(name = "TargetUserTypeLink")
    protected List<TargetUserTypeLinkType> targetUserTypeLink;
    @XmlAttribute(name = "Inherited")
    protected TrueFalseType inherited;
    @XmlAttribute(name = "ID", required = true)
    protected String id;
    @XmlAttribute(name = "Revised")
    protected TrueFalseType revised;
    @XmlAttribute(name = "Completeness")
    protected String completeness;
    @XmlAttribute(name = "MultiValued")
    protected TrueFalseType multiValued;
    @XmlAttribute(name = "Mandatory")
    protected TrueFalseType mandatory;
    @XmlAttribute(name = "Accumulated")
    protected TrueFalseType accumulated;

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
     * Gets the value of the attributeLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeLinkType }
     * 
     * 
     */
    public List<AttributeLinkType> getAttributeLink() {
        if (attributeLink == null) {
            attributeLink = new ArrayList<AttributeLinkType>();
        }
        return this.attributeLink;
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
     * Gets the value of the userTypeLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userTypeLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserTypeLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserTypeLinkType }
     * 
     * 
     */
    public List<UserTypeLinkType> getUserTypeLink() {
        if (userTypeLink == null) {
            userTypeLink = new ArrayList<UserTypeLinkType>();
        }
        return this.userTypeLink;
    }

    /**
     * Gets the value of the targetUserTypeLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetUserTypeLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetUserTypeLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TargetUserTypeLinkType }
     * 
     * 
     */
    public List<TargetUserTypeLinkType> getTargetUserTypeLink() {
        if (targetUserTypeLink == null) {
            targetUserTypeLink = new ArrayList<TargetUserTypeLinkType>();
        }
        return this.targetUserTypeLink;
    }

    /**
     * Gets the value of the inherited property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getInherited() {
        if (inherited == null) {
            return TrueFalseType.FALSE;
        } else {
            return inherited;
        }
    }

    /**
     * Sets the value of the inherited property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setInherited(TrueFalseType value) {
        this.inherited = value;
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
     * Gets the value of the revised property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getRevised() {
        if (revised == null) {
            return TrueFalseType.TRUE;
        } else {
            return revised;
        }
    }

    /**
     * Sets the value of the revised property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setRevised(TrueFalseType value) {
        this.revised = value;
    }

    /**
     * Gets the value of the completeness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompleteness() {
        return completeness;
    }

    /**
     * Sets the value of the completeness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompleteness(String value) {
        this.completeness = value;
    }

    /**
     * Gets the value of the multiValued property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getMultiValued() {
        if (multiValued == null) {
            return TrueFalseType.TRUE;
        } else {
            return multiValued;
        }
    }

    /**
     * Sets the value of the multiValued property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setMultiValued(TrueFalseType value) {
        this.multiValued = value;
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
     * Gets the value of the accumulated property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getAccumulated() {
        if (accumulated == null) {
            return TrueFalseType.FALSE;
        } else {
            return accumulated;
        }
    }

    /**
     * Sets the value of the accumulated property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setAccumulated(TrueFalseType value) {
        this.accumulated = value;
    }

}
