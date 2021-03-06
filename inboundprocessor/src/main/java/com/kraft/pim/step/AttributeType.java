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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *                 This element represents an attribute in the system. The validation or ListOfValueLink restricts the
 *                 valid values of this attribute. The dimension links is the dimension dependencies for values of this
 *                 attribute. UserTypeLink and LinkType list the objects that are allowed to have values of this attribute.
 *             
 * 
 * <p>Java class for AttributeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttributeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Validation" type="{}ValidationType"/>
 *           &lt;element name="ListOfValueLink" type="{}ListOfValueLinkType"/>
 *         &lt;/choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="ValueTemplate" type="{}ValueTemplateType"/>
 *           &lt;element name="UnitTemplate" type="{}UnitTemplateType"/>
 *         &lt;/choice>
 *         &lt;element name="DimensionLink" type="{}DimensionLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MetaData" type="{}MetaDataType" minOccurs="0"/>
 *         &lt;element name="AttributeGroupLink" type="{}AttributeGroupLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UserTypeLink" type="{}UserTypeLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinkType" type="{}LinkTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ValueFilter" type="{}ValueFilterType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="HierarchicalFiltering" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="ExternallyMaintained" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="FullTextIndexed" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="MultiValued" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="ID" use="required" type="{}StepID" />
 *       &lt;attribute name="DefaultUnitID" type="{}StepID" />
 *       &lt;attribute name="ProductMode" default="Normal">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Normal"/>
 *             &lt;enumeration value="Property"/>
 *             &lt;enumeration value="ClassValidated"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Mandatory" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="Derived" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="Selected" type="{}TrueFalseType" default="true" />
 *       &lt;attribute name="Referenced" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="CryptographicKeyID" type="{}StepID" />
 *       &lt;attribute name="Completeness" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeType", propOrder = {
    "name",
    "validation",
    "listOfValueLink",
    "valueTemplateOrUnitTemplate",
    "dimensionLink",
    "metaData",
    "attributeGroupLink",
    "userTypeLink",
    "linkType",
    "valueFilter"
})
public class AttributeType {

    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "Validation")
    protected ValidationType validation;
    @XmlElement(name = "ListOfValueLink")
    protected ListOfValueLinkType listOfValueLink;
    @XmlElements({
        @XmlElement(name = "UnitTemplate", type = UnitTemplateType.class),
        @XmlElement(name = "ValueTemplate", type = ValueTemplateType.class)
    })
    protected List<Object> valueTemplateOrUnitTemplate;
    @XmlElement(name = "DimensionLink")
    protected List<DimensionLinkType> dimensionLink;
    @XmlElement(name = "MetaData")
    protected MetaDataType metaData;
    @XmlElement(name = "AttributeGroupLink")
    protected List<AttributeGroupLinkType> attributeGroupLink;
    @XmlElement(name = "UserTypeLink")
    protected List<UserTypeLinkType> userTypeLink;
    @XmlElement(name = "LinkType")
    protected List<LinkTypeType> linkType;
    @XmlElement(name = "ValueFilter")
    protected ValueFilterType valueFilter;
    @XmlAttribute(name = "HierarchicalFiltering")
    protected TrueFalseType hierarchicalFiltering;
    @XmlAttribute(name = "ExternallyMaintained")
    protected TrueFalseType externallyMaintained;
    @XmlAttribute(name = "FullTextIndexed")
    protected TrueFalseType fullTextIndexed;
    @XmlAttribute(name = "MultiValued")
    protected TrueFalseType multiValued;
    @XmlAttribute(name = "ID", required = true)
    protected String id;
    @XmlAttribute(name = "DefaultUnitID")
    protected String defaultUnitID;
    @XmlAttribute(name = "ProductMode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String productMode;
    @XmlAttribute(name = "Mandatory")
    protected TrueFalseType mandatory;
    @XmlAttribute(name = "Derived")
    protected TrueFalseType derived;
    @XmlAttribute(name = "Selected")
    protected TrueFalseType selected;
    @XmlAttribute(name = "Referenced")
    protected TrueFalseType referenced;
    @XmlAttribute(name = "CryptographicKeyID")
    protected String cryptographicKeyID;
    @XmlAttribute(name = "Completeness")
    protected String completeness;

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
     * Gets the value of the listOfValueLink property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfValueLinkType }
     *     
     */
    public ListOfValueLinkType getListOfValueLink() {
        return listOfValueLink;
    }

    /**
     * Sets the value of the listOfValueLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfValueLinkType }
     *     
     */
    public void setListOfValueLink(ListOfValueLinkType value) {
        this.listOfValueLink = value;
    }

    /**
     * Gets the value of the valueTemplateOrUnitTemplate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueTemplateOrUnitTemplate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueTemplateOrUnitTemplate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnitTemplateType }
     * {@link ValueTemplateType }
     * 
     * 
     */
    public List<Object> getValueTemplateOrUnitTemplate() {
        if (valueTemplateOrUnitTemplate == null) {
            valueTemplateOrUnitTemplate = new ArrayList<Object>();
        }
        return this.valueTemplateOrUnitTemplate;
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
     * Gets the value of the linkType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinkTypeType }
     * 
     * 
     */
    public List<LinkTypeType> getLinkType() {
        if (linkType == null) {
            linkType = new ArrayList<LinkTypeType>();
        }
        return this.linkType;
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
     * Gets the value of the hierarchicalFiltering property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getHierarchicalFiltering() {
        if (hierarchicalFiltering == null) {
            return TrueFalseType.FALSE;
        } else {
            return hierarchicalFiltering;
        }
    }

    /**
     * Sets the value of the hierarchicalFiltering property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setHierarchicalFiltering(TrueFalseType value) {
        this.hierarchicalFiltering = value;
    }

    /**
     * Gets the value of the externallyMaintained property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getExternallyMaintained() {
        if (externallyMaintained == null) {
            return TrueFalseType.FALSE;
        } else {
            return externallyMaintained;
        }
    }

    /**
     * Sets the value of the externallyMaintained property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setExternallyMaintained(TrueFalseType value) {
        this.externallyMaintained = value;
    }

    /**
     * Gets the value of the fullTextIndexed property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getFullTextIndexed() {
        if (fullTextIndexed == null) {
            return TrueFalseType.FALSE;
        } else {
            return fullTextIndexed;
        }
    }

    /**
     * Sets the value of the fullTextIndexed property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setFullTextIndexed(TrueFalseType value) {
        this.fullTextIndexed = value;
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
            return TrueFalseType.FALSE;
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

    /**
     * Gets the value of the productMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductMode() {
        if (productMode == null) {
            return "Normal";
        } else {
            return productMode;
        }
    }

    /**
     * Sets the value of the productMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductMode(String value) {
        this.productMode = value;
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
     * Gets the value of the derived property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getDerived() {
        if (derived == null) {
            return TrueFalseType.FALSE;
        } else {
            return derived;
        }
    }

    /**
     * Sets the value of the derived property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setDerived(TrueFalseType value) {
        this.derived = value;
    }

    /**
     * Gets the value of the selected property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getSelected() {
        if (selected == null) {
            return TrueFalseType.TRUE;
        } else {
            return selected;
        }
    }

    /**
     * Sets the value of the selected property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setSelected(TrueFalseType value) {
        this.selected = value;
    }

    /**
     * Gets the value of the referenced property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getReferenced() {
        if (referenced == null) {
            return TrueFalseType.FALSE;
        } else {
            return referenced;
        }
    }

    /**
     * Sets the value of the referenced property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setReferenced(TrueFalseType value) {
        this.referenced = value;
    }

    /**
     * Gets the value of the cryptographicKeyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCryptographicKeyID() {
        return cryptographicKeyID;
    }

    /**
     * Sets the value of the cryptographicKeyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCryptographicKeyID(String value) {
        this.cryptographicKeyID = value;
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

}
