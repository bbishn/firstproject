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
 * <p>Java class for PlannedPageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlannedPageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MetaData" type="{}MetaDataType" minOccurs="0"/>
 *         &lt;element name="Basket" type="{}BasketType" minOccurs="0"/>
 *         &lt;element name="VersionLink" type="{}VersionLinkType" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;element name="TemplateLayout" type="{}TemplateLayoutType"/>
 *           &lt;element name="PickupPage" type="{}PickupPageType"/>
 *         &lt;/choice>
 *         &lt;element name="PageContents" type="{}PageContentsType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlannedPageType", propOrder = {
    "name",
    "metaData",
    "basket",
    "versionLink",
    "templateLayout",
    "pickupPage",
    "pageContents"
})
public class PlannedPageType {

    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "MetaData")
    protected MetaDataType metaData;
    @XmlElement(name = "Basket")
    protected BasketType basket;
    @XmlElement(name = "VersionLink", required = true)
    protected List<VersionLinkType> versionLink;
    @XmlElement(name = "TemplateLayout")
    protected TemplateLayoutType templateLayout;
    @XmlElement(name = "PickupPage")
    protected PickupPageType pickupPage;
    @XmlElement(name = "PageContents", required = true)
    protected PageContentsType pageContents;
    @XmlAttribute(name = "ID")
    protected String id;

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
     * Gets the value of the basket property.
     * 
     * @return
     *     possible object is
     *     {@link BasketType }
     *     
     */
    public BasketType getBasket() {
        return basket;
    }

    /**
     * Sets the value of the basket property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketType }
     *     
     */
    public void setBasket(BasketType value) {
        this.basket = value;
    }

    /**
     * Gets the value of the versionLink property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versionLink property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersionLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VersionLinkType }
     * 
     * 
     */
    public List<VersionLinkType> getVersionLink() {
        if (versionLink == null) {
            versionLink = new ArrayList<VersionLinkType>();
        }
        return this.versionLink;
    }

    /**
     * Gets the value of the templateLayout property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateLayoutType }
     *     
     */
    public TemplateLayoutType getTemplateLayout() {
        return templateLayout;
    }

    /**
     * Sets the value of the templateLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateLayoutType }
     *     
     */
    public void setTemplateLayout(TemplateLayoutType value) {
        this.templateLayout = value;
    }

    /**
     * Gets the value of the pickupPage property.
     * 
     * @return
     *     possible object is
     *     {@link PickupPageType }
     *     
     */
    public PickupPageType getPickupPage() {
        return pickupPage;
    }

    /**
     * Sets the value of the pickupPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupPageType }
     *     
     */
    public void setPickupPage(PickupPageType value) {
        this.pickupPage = value;
    }

    /**
     * Gets the value of the pageContents property.
     * 
     * @return
     *     possible object is
     *     {@link PageContentsType }
     *     
     */
    public PageContentsType getPageContents() {
        return pageContents;
    }

    /**
     * Sets the value of the pageContents property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageContentsType }
     *     
     */
    public void setPageContents(PageContentsType value) {
        this.pageContents = value;
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