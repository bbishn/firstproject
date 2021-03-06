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
 *                 Element that holds all top level asset
 *             
 * 
 * <p>Java class for AssetsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssetsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Asset" type="{}AssetType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DefaultParentID" type="{}StepID" />
 *       &lt;attribute name="DefaultUserTypeID" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssetsType", propOrder = {
    "asset"
})
public class AssetsType {

    @XmlElement(name = "Asset")
    protected List<AssetType> asset;
    @XmlAttribute(name = "DefaultParentID")
    protected String defaultParentID;
    @XmlAttribute(name = "DefaultUserTypeID")
    protected String defaultUserTypeID;

    /**
     * Gets the value of the asset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssetType }
     * 
     * 
     */
    public List<AssetType> getAsset() {
        if (asset == null) {
            asset = new ArrayList<AssetType>();
        }
        return this.asset;
    }

    /**
     * Gets the value of the defaultParentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultParentID() {
        return defaultParentID;
    }

    /**
     * Sets the value of the defaultParentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultParentID(String value) {
        this.defaultParentID = value;
    }

    /**
     * Gets the value of the defaultUserTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultUserTypeID() {
        return defaultUserTypeID;
    }

    /**
     * Sets the value of the defaultUserTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultUserTypeID(String value) {
        this.defaultUserTypeID = value;
    }

}
