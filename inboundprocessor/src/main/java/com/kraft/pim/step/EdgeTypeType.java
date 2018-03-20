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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for EdgeTypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EdgeTypeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DimensionLink" type="{}DimensionLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AttributeLink" type="{}AttributeLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="C"/>
 *             &lt;enumeration value="CA"/>
 *             &lt;enumeration value="CP"/>
 *             &lt;enumeration value="CCR"/>
 *             &lt;enumeration value="P"/>
 *             &lt;enumeration value="PPR"/>
 *             &lt;enumeration value="PCR"/>
 *             &lt;enumeration value="PA"/>
 *             &lt;enumeration value="ACR"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EdgeTypeType", propOrder = {
    "dimensionLink",
    "attributeLink"
})
public class EdgeTypeType {

    @XmlElement(name = "DimensionLink")
    protected List<DimensionLinkType> dimensionLink;
    @XmlElement(name = "AttributeLink")
    protected List<AttributeLinkType> attributeLink;
    @XmlAttribute(name = "ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;

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

}
