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
 *                 The Classification element lists its names, the linked attributes on this level, sub classification,
 *                 cross-references to other classifications, metadata on classification and assets linked into this
 *                 classification. This recursive definition of classifications spans the classification hierarchy. Note
 *                 that products appear in their own hierarchy below the Products element.
 *             
 * 
 * <p>Java class for ClassificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Name" type="{}NameType"/>
 *         &lt;element name="AttributeLink" type="{}AttributeLinkType"/>
 *         &lt;element name="SequenceProduct" type="{}SequenceProductType"/>
 *         &lt;element name="Classification" type="{}ClassificationType"/>
 *         &lt;element name="SuppressedClassificationCrossReference" type="{}SuppressedClassificationCrossReferenceType"/>
 *         &lt;element name="ClassificationCrossReference" type="{}ClassificationCrossReferenceType"/>
 *         &lt;element name="SuppressedProductCrossReference" type="{}SuppressedProductCrossReferenceType"/>
 *         &lt;element name="ProductCrossReference" type="{}ProductCrossReferenceType"/>
 *         &lt;element name="SuppressedEntityCrossReference" type="{}SuppressedEntityCrossReferenceType"/>
 *         &lt;element name="EntityCrossReference" type="{}EntityCrossReferenceType"/>
 *         &lt;element name="SuppressedAssetCrossReference" type="{}SuppressedAssetCrossReferenceType"/>
 *         &lt;element name="AssetCrossReference" type="{}AssetCrossReferenceType"/>
 *         &lt;element name="MetaData" type="{}MetaDataType"/>
 *         &lt;element name="Tables" type="{}TablesType"/>
 *         &lt;element name="Asset" type="{}AssetType"/>
 *         &lt;element name="PublicationGroup" type="{}PublicationGroupType"/>
 *         &lt;element name="DeleteClassificationCrossReference" type="{}DeleteClassificationCrossReferenceType"/>
 *         &lt;element name="DeleteProductCrossReference" type="{}DeleteProductCrossReferenceType"/>
 *         &lt;element name="CurrentTasks" type="{}CurrentTasksType"/>
 *       &lt;/choice>
 *       &lt;attribute name="Type" default="1">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Changed" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="SourcePos" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AnalyzerResult" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ParentID" type="{}StepID" />
 *       &lt;attribute name="ID" type="{}StepID" />
 *       &lt;attribute name="QualifierID" type="{}StepID" />
 *       &lt;attribute name="Republished" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="UserTypeID" type="{}StepID" />
 *       &lt;attribute name="Selected" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="Referenced" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassificationType", propOrder = {
	"name",
    "nameOrAttributeLinkOrSequenceProduct"
})
public class ClassificationType {

    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElements({
        @XmlElement(name = "SuppressedClassificationCrossReference", type = SuppressedClassificationCrossReferenceType.class),
        @XmlElement(name = "DeleteClassificationCrossReference", type = DeleteClassificationCrossReferenceType.class),
        @XmlElement(name = "Name", type = NameType.class),
        @XmlElement(name = "SuppressedAssetCrossReference", type = SuppressedAssetCrossReferenceType.class),
        @XmlElement(name = "MetaData", type = MetaDataType.class),
        @XmlElement(name = "DeleteProductCrossReference", type = DeleteProductCrossReferenceType.class),
        @XmlElement(name = "SequenceProduct", type = SequenceProductType.class),
        @XmlElement(name = "AssetCrossReference", type = AssetCrossReferenceType.class),
        @XmlElement(name = "Tables", type = TablesType.class),
        @XmlElement(name = "EntityCrossReference", type = EntityCrossReferenceType.class),
        @XmlElement(name = "PublicationGroup", type = PublicationGroupType.class),
        @XmlElement(name = "AttributeLink", type = AttributeLinkType.class),
        @XmlElement(name = "ProductCrossReference", type = ProductCrossReferenceType.class),
        @XmlElement(name = "SuppressedProductCrossReference", type = SuppressedProductCrossReferenceType.class),
        @XmlElement(name = "Classification", type = ClassificationType.class),
        @XmlElement(name = "SuppressedEntityCrossReference", type = SuppressedEntityCrossReferenceType.class),
        @XmlElement(name = "ClassificationCrossReference", type = ClassificationCrossReferenceType.class),
        @XmlElement(name = "CurrentTasks", type = CurrentTasksType.class),
        @XmlElement(name = "Asset", type = AssetType.class)
    })
    protected List<Object> nameOrAttributeLinkOrSequenceProduct;
    @XmlAttribute(name = "Type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "Changed")
    protected TrueFalseType changed;
    @XmlAttribute(name = "SourcePos")
    protected String sourcePos;
    @XmlAttribute(name = "AnalyzerResult")
    protected String analyzerResult;
    @XmlAttribute(name = "ParentID")
    protected String parentID;
    @XmlAttribute(name = "ID")
    protected String id;
    @XmlAttribute(name = "QualifierID")
    protected String qualifierID;
    @XmlAttribute(name = "Republished")
    protected TrueFalseType republished;
    @XmlAttribute(name = "UserTypeID")
    protected String userTypeID;
    @XmlAttribute(name = "Selected")
    protected Boolean selected;
    @XmlAttribute(name = "Referenced")
    protected Boolean referenced;

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
     * Gets the value of the nameOrAttributeLinkOrSequenceProduct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameOrAttributeLinkOrSequenceProduct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameOrAttributeLinkOrSequenceProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SuppressedClassificationCrossReferenceType }
     * {@link DeleteClassificationCrossReferenceType }
     * {@link NameType }
     * {@link SuppressedAssetCrossReferenceType }
     * {@link MetaDataType }
     * {@link DeleteProductCrossReferenceType }
     * {@link SequenceProductType }
     * {@link AssetCrossReferenceType }
     * {@link TablesType }
     * {@link EntityCrossReferenceType }
     * {@link PublicationGroupType }
     * {@link AttributeLinkType }
     * {@link ProductCrossReferenceType }
     * {@link SuppressedProductCrossReferenceType }
     * {@link ClassificationType }
     * {@link SuppressedEntityCrossReferenceType }
     * {@link ClassificationCrossReferenceType }
     * {@link CurrentTasksType }
     * {@link AssetType }
     * 
     * 
     */
    public List<Object> getNameOrAttributeLinkOrSequenceProduct() {
        if (nameOrAttributeLinkOrSequenceProduct == null) {
            nameOrAttributeLinkOrSequenceProduct = new ArrayList<Object>();
        }
        return this.nameOrAttributeLinkOrSequenceProduct;
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
        if (type == null) {
            return "1";
        } else {
            return type;
        }
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
     * Gets the value of the sourcePos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcePos() {
        return sourcePos;
    }

    /**
     * Sets the value of the sourcePos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcePos(String value) {
        this.sourcePos = value;
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
     * Gets the value of the republished property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getRepublished() {
        if (republished == null) {
            return TrueFalseType.FALSE;
        } else {
            return republished;
        }
    }

    /**
     * Sets the value of the republished property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setRepublished(TrueFalseType value) {
        this.republished = value;
    }

    /**
     * Gets the value of the userTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTypeID() {
        return userTypeID;
    }

    /**
     * Sets the value of the userTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTypeID(String value) {
        this.userTypeID = value;
    }

    /**
     * Gets the value of the selected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSelected() {
        if (selected == null) {
            return true;
        } else {
            return selected;
        }
    }

    /**
     * Sets the value of the selected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSelected(Boolean value) {
        this.selected = value;
    }

    /**
     * Gets the value of the referenced property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReferenced() {
        if (referenced == null) {
            return false;
        } else {
            return referenced;
        }
    }

    /**
     * Sets the value of the referenced property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReferenced(Boolean value) {
        this.referenced = value;
    }

}