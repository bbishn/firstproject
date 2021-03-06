//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.13 at 03:27:41 PM IST 
//


package com.kraft.pim.step;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TableTypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TableTypeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UserTypeLink" type="{}UserTypeLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProcessFlag" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VerticalSpan" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HorizontalSpan" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RuleAbove" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BackgroundColor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RuleBelow" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RuleRight" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ID" type="{}StepID" />
 *       &lt;attribute name="CellRotation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RuleLeft" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TextStyle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VerticalAlignment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CellVerticalStoryDirection" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Width" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="WidthUnit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Height" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="HeightUnit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TableTypeType", propOrder = {
    "name",
    "userTypeLink"
})
public class TableTypeType {

    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "UserTypeLink")
    protected List<UserTypeLinkType> userTypeLink;
    @XmlAttribute(name = "ProcessFlag")
    protected String processFlag;
    @XmlAttribute(name = "VerticalSpan")
    protected String verticalSpan;
    @XmlAttribute(name = "HorizontalSpan")
    protected String horizontalSpan;
    @XmlAttribute(name = "RuleAbove")
    protected String ruleAbove;
    @XmlAttribute(name = "BackgroundColor")
    protected String backgroundColor;
    @XmlAttribute(name = "RuleBelow")
    protected String ruleBelow;
    @XmlAttribute(name = "RuleRight")
    protected String ruleRight;
    @XmlAttribute(name = "ID")
    protected String id;
    @XmlAttribute(name = "CellRotation")
    protected String cellRotation;
    @XmlAttribute(name = "RuleLeft")
    protected String ruleLeft;
    @XmlAttribute(name = "TextStyle")
    protected String textStyle;
    @XmlAttribute(name = "VerticalAlignment")
    protected String verticalAlignment;
    @XmlAttribute(name = "CellVerticalStoryDirection")
    protected String cellVerticalStoryDirection;
    @XmlAttribute(name = "Width")
    protected BigDecimal width;
    @XmlAttribute(name = "WidthUnit")
    protected String widthUnit;
    @XmlAttribute(name = "Height")
    protected BigDecimal height;
    @XmlAttribute(name = "HeightUnit")
    protected String heightUnit;

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
     * Gets the value of the processFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessFlag() {
        return processFlag;
    }

    /**
     * Sets the value of the processFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessFlag(String value) {
        this.processFlag = value;
    }

    /**
     * Gets the value of the verticalSpan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerticalSpan() {
        return verticalSpan;
    }

    /**
     * Sets the value of the verticalSpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerticalSpan(String value) {
        this.verticalSpan = value;
    }

    /**
     * Gets the value of the horizontalSpan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorizontalSpan() {
        return horizontalSpan;
    }

    /**
     * Sets the value of the horizontalSpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorizontalSpan(String value) {
        this.horizontalSpan = value;
    }

    /**
     * Gets the value of the ruleAbove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleAbove() {
        return ruleAbove;
    }

    /**
     * Sets the value of the ruleAbove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleAbove(String value) {
        this.ruleAbove = value;
    }

    /**
     * Gets the value of the backgroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the value of the backgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundColor(String value) {
        this.backgroundColor = value;
    }

    /**
     * Gets the value of the ruleBelow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleBelow() {
        return ruleBelow;
    }

    /**
     * Sets the value of the ruleBelow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleBelow(String value) {
        this.ruleBelow = value;
    }

    /**
     * Gets the value of the ruleRight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleRight() {
        return ruleRight;
    }

    /**
     * Sets the value of the ruleRight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleRight(String value) {
        this.ruleRight = value;
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
     * Gets the value of the cellRotation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellRotation() {
        return cellRotation;
    }

    /**
     * Sets the value of the cellRotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellRotation(String value) {
        this.cellRotation = value;
    }

    /**
     * Gets the value of the ruleLeft property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleLeft() {
        return ruleLeft;
    }

    /**
     * Sets the value of the ruleLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleLeft(String value) {
        this.ruleLeft = value;
    }

    /**
     * Gets the value of the textStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextStyle() {
        return textStyle;
    }

    /**
     * Sets the value of the textStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextStyle(String value) {
        this.textStyle = value;
    }

    /**
     * Gets the value of the verticalAlignment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerticalAlignment() {
        return verticalAlignment;
    }

    /**
     * Sets the value of the verticalAlignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerticalAlignment(String value) {
        this.verticalAlignment = value;
    }

    /**
     * Gets the value of the cellVerticalStoryDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellVerticalStoryDirection() {
        return cellVerticalStoryDirection;
    }

    /**
     * Sets the value of the cellVerticalStoryDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellVerticalStoryDirection(String value) {
        this.cellVerticalStoryDirection = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWidth(BigDecimal value) {
        this.width = value;
    }

    /**
     * Gets the value of the widthUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidthUnit() {
        return widthUnit;
    }

    /**
     * Sets the value of the widthUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidthUnit(String value) {
        this.widthUnit = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeight(BigDecimal value) {
        this.height = value;
    }

    /**
     * Gets the value of the heightUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeightUnit() {
        return heightUnit;
    }

    /**
     * Sets the value of the heightUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeightUnit(String value) {
        this.heightUnit = value;
    }

}
