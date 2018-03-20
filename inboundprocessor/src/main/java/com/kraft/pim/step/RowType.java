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
 * <p>Java class for RowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RowType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cell" type="{}CellType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProcessFlag" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Height" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RuleAbove" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RuleBelow" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BackgroundColor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="KeepWithNext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RowTypeID" type="{}StepID" />
 *       &lt;attribute name="CellRotation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TextStyle" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VerticalAlignment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CellVerticalStoryDirection" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RowType", propOrder = {
    "cell"
})
public class RowType {

    @XmlElement(name = "Cell")
    protected List<CellType> cell;
    @XmlAttribute(name = "ProcessFlag")
    protected String processFlag;
    @XmlAttribute(name = "Height")
    protected String height;
    @XmlAttribute(name = "RuleAbove")
    protected String ruleAbove;
    @XmlAttribute(name = "RuleBelow")
    protected String ruleBelow;
    @XmlAttribute(name = "BackgroundColor")
    protected String backgroundColor;
    @XmlAttribute(name = "KeepWithNext")
    protected String keepWithNext;
    @XmlAttribute(name = "RowTypeID")
    protected String rowTypeID;
    @XmlAttribute(name = "CellRotation")
    protected String cellRotation;
    @XmlAttribute(name = "TextStyle")
    protected String textStyle;
    @XmlAttribute(name = "VerticalAlignment")
    protected String verticalAlignment;
    @XmlAttribute(name = "CellVerticalStoryDirection")
    protected String cellVerticalStoryDirection;

    /**
     * Gets the value of the cell property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cell property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCell().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CellType }
     * 
     * 
     */
    public List<CellType> getCell() {
        if (cell == null) {
            cell = new ArrayList<CellType>();
        }
        return this.cell;
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
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeight(String value) {
        this.height = value;
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
     * Gets the value of the keepWithNext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeepWithNext() {
        return keepWithNext;
    }

    /**
     * Sets the value of the keepWithNext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeepWithNext(String value) {
        this.keepWithNext = value;
    }

    /**
     * Gets the value of the rowTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRowTypeID() {
        return rowTypeID;
    }

    /**
     * Sets the value of the rowTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowTypeID(String value) {
        this.rowTypeID = value;
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

}
