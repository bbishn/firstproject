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
 *                 A GDSN Data Pool Publisher, for publishing product data to a GDSN data pool.
 *             
 * 
 * <p>Java class for DataPoolPublisherType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataPoolPublisherType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MetaData" type="{}MetaDataType" minOccurs="0"/>
 *         &lt;element name="DataPoolRecipient" type="{}DataPoolRecipientType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{}StepID" />
 *       &lt;attribute name="DestinationGLN" type="{}IDLength13" />
 *       &lt;attribute name="GLN" type="{}IDLength13" />
 *       &lt;attribute name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotFolderIn" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotFolderOut" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataPoolPublisherType", propOrder = {
    "name",
    "metaData",
    "dataPoolRecipient"
})
public class DataPoolPublisherType {

    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "MetaData")
    protected MetaDataType metaData;
    @XmlElement(name = "DataPoolRecipient")
    protected List<DataPoolRecipientType> dataPoolRecipient;
    @XmlAttribute(name = "ID")
    protected String id;
    @XmlAttribute(name = "DestinationGLN")
    protected String destinationGLN;
    @XmlAttribute(name = "GLN")
    protected String gln;
    @XmlAttribute(name = "UserID")
    protected String userID;
    @XmlAttribute(name = "HotFolderIn")
    protected String hotFolderIn;
    @XmlAttribute(name = "HotFolderOut")
    protected String hotFolderOut;

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
     * Gets the value of the dataPoolRecipient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataPoolRecipient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataPoolRecipient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataPoolRecipientType }
     * 
     * 
     */
    public List<DataPoolRecipientType> getDataPoolRecipient() {
        if (dataPoolRecipient == null) {
            dataPoolRecipient = new ArrayList<DataPoolRecipientType>();
        }
        return this.dataPoolRecipient;
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
     * Gets the value of the destinationGLN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationGLN() {
        return destinationGLN;
    }

    /**
     * Sets the value of the destinationGLN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationGLN(String value) {
        this.destinationGLN = value;
    }

    /**
     * Gets the value of the gln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLN() {
        return gln;
    }

    /**
     * Sets the value of the gln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLN(String value) {
        this.gln = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the hotFolderIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotFolderIn() {
        return hotFolderIn;
    }

    /**
     * Sets the value of the hotFolderIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotFolderIn(String value) {
        this.hotFolderIn = value;
    }

    /**
     * Gets the value of the hotFolderOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotFolderOut() {
        return hotFolderOut;
    }

    /**
     * Sets the value of the hotFolderOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotFolderOut(String value) {
        this.hotFolderOut = value;
    }

}