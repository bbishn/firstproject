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
 * 
 *                 A configuration of a Business Rule.
 *             
 * 
 * <p>Java class for BusinessRuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessRuleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SetupGroupLink" type="{}SetupGroupLinkType" minOccurs="0"/>
 *         &lt;element name="Name" type="{}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Description" type="{}BusinessRuleDescriptionType" minOccurs="0"/>
 *         &lt;element name="OnApprove" type="{}OnApproveType" minOccurs="0"/>
 *         &lt;element name="Configuration" type="{}ConfigurationType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" use="required" type="{}StepID" />
 *       &lt;attribute name="Scope" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Local"/>
 *             &lt;enumeration value="Global"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="Condition"/>
 *             &lt;enumeration value="Action"/>
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
@XmlType(name = "BusinessRuleType", propOrder = {
    "setupGroupLink",
    "name",
    "description",
    "onApprove",
    "configuration"
})
public class BusinessRuleType {

    @XmlElement(name = "SetupGroupLink")
    protected SetupGroupLinkType setupGroupLink;
    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "Description")
    protected BusinessRuleDescriptionType description;
    @XmlElement(name = "OnApprove")
    protected OnApproveType onApprove;
    @XmlElement(name = "Configuration")
    protected byte[] configuration;
    @XmlAttribute(name = "ID", required = true)
    protected String id;
    @XmlAttribute(name = "Scope", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String scope;
    @XmlAttribute(name = "Type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;

    /**
     * Gets the value of the setupGroupLink property.
     * 
     * @return
     *     possible object is
     *     {@link SetupGroupLinkType }
     *     
     */
    public SetupGroupLinkType getSetupGroupLink() {
        return setupGroupLink;
    }

    /**
     * Sets the value of the setupGroupLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetupGroupLinkType }
     *     
     */
    public void setSetupGroupLink(SetupGroupLinkType value) {
        this.setupGroupLink = value;
    }

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessRuleDescriptionType }
     *     
     */
    public BusinessRuleDescriptionType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessRuleDescriptionType }
     *     
     */
    public void setDescription(BusinessRuleDescriptionType value) {
        this.description = value;
    }

    /**
     * Gets the value of the onApprove property.
     * 
     * @return
     *     possible object is
     *     {@link OnApproveType }
     *     
     */
    public OnApproveType getOnApprove() {
        return onApprove;
    }

    /**
     * Sets the value of the onApprove property.
     * 
     * @param value
     *     allowed object is
     *     {@link OnApproveType }
     *     
     */
    public void setOnApprove(OnApproveType value) {
        this.onApprove = value;
    }

    /**
     * Gets the value of the configuration property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setConfiguration(byte[] value) {
        this.configuration = ((byte[]) value);
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
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
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
        return type;
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

}
