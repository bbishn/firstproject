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


/**
 * 
 *                 A multi valued attribute value is represented with this tag. The attribute is in this element, and all
 *                 the values in the multi value are represented as sub values without an attribute identification
 *             
 * 
 * <p>Java class for MultiValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultiValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="Value" type="{}ValueType"/>
 *           &lt;element name="ValueGroup" type="{}ValueGroupType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Inherited" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Changed" type="{}TrueFalseType" default="false" />
 *       &lt;attribute name="AttributeID" use="required" type="{}StepID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiValueType", propOrder = {
    "valueOrValueGroup"
})
public class MultiValueType {

    @XmlElements({
        @XmlElement(name = "ValueGroup", type = ValueGroupType.class),
        @XmlElement(name = "Value", type = ValueType.class)
    })
    protected List<Object> valueOrValueGroup;
    @XmlAttribute(name = "Inherited")
    protected String inherited;
    @XmlAttribute(name = "Changed")
    protected TrueFalseType changed;
    @XmlAttribute(name = "AttributeID", required = true)
    protected String attributeID;

    /**
     * Gets the value of the valueOrValueGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueOrValueGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueOrValueGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueGroupType }
     * {@link ValueType }
     * 
     * 
     */
    public List<Object> getValueOrValueGroup() {
        if (valueOrValueGroup == null) {
            valueOrValueGroup = new ArrayList<Object>();
        }
        return this.valueOrValueGroup;
    }

    /**
     * Gets the value of the inherited property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInherited() {
        return inherited;
    }

    /**
     * Sets the value of the inherited property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInherited(String value) {
        this.inherited = value;
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
     * Gets the value of the attributeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeID() {
        return attributeID;
    }

    /**
     * Sets the value of the attributeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeID(String value) {
        this.attributeID = value;
    }

}
