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
 * <p>Java class for AssetElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssetElementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="RuleBasedLayout" type="{}RuleBasedLayoutType"/>
 *         &lt;element name="TemplateLayout" type="{}TemplateLayoutType"/>
 *         &lt;element name="PickupLayout" type="{}PickupLayoutType"/>
 *       &lt;/choice>
 *       &lt;attribute name="ExtendToFrameID" type="{}StepID" />
 *       &lt;attribute name="FrameID" use="required" type="{}StepID" />
 *       &lt;attribute name="AssetID" use="required" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssetElementType", propOrder = {
    "ruleBasedLayout",
    "templateLayout",
    "pickupLayout"
})
public class AssetElementType {

    @XmlElement(name = "RuleBasedLayout")
    protected String ruleBasedLayout;
    @XmlElement(name = "TemplateLayout")
    protected TemplateLayoutType templateLayout;
    @XmlElement(name = "PickupLayout")
    protected PickupLayoutType pickupLayout;
    @XmlAttribute(name = "ExtendToFrameID")
    protected String extendToFrameID;
    @XmlAttribute(name = "FrameID", required = true)
    protected String frameID;
    @XmlAttribute(name = "AssetID", required = true)
    protected String assetID;

    /**
     * Gets the value of the ruleBasedLayout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleBasedLayout() {
        return ruleBasedLayout;
    }

    /**
     * Sets the value of the ruleBasedLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleBasedLayout(String value) {
        this.ruleBasedLayout = value;
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
     * Gets the value of the pickupLayout property.
     * 
     * @return
     *     possible object is
     *     {@link PickupLayoutType }
     *     
     */
    public PickupLayoutType getPickupLayout() {
        return pickupLayout;
    }

    /**
     * Sets the value of the pickupLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link PickupLayoutType }
     *     
     */
    public void setPickupLayout(PickupLayoutType value) {
        this.pickupLayout = value;
    }

    /**
     * Gets the value of the extendToFrameID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtendToFrameID() {
        return extendToFrameID;
    }

    /**
     * Sets the value of the extendToFrameID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtendToFrameID(String value) {
        this.extendToFrameID = value;
    }

    /**
     * Gets the value of the frameID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrameID() {
        return frameID;
    }

    /**
     * Sets the value of the frameID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameID(String value) {
        this.frameID = value;
    }

    /**
     * Gets the value of the assetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssetID() {
        return assetID;
    }

    /**
     * Sets the value of the assetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssetID(String value) {
        this.assetID = value;
    }

}