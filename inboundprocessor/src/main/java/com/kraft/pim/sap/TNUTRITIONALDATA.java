//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:49:43 PM IST 
//


package com.kraft.pim.sap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for T_NUTRITIONAL_DATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_NUTRITIONAL_DATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_NUTRITION_SERVING_CODE" type="{}T_NUTRITION_SERVINGS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="F_NUTRITION_ATTRIBUTE" type="{}T_NUTRITION_ATTRIBUTE_TYPES" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="F_NUTRITION_WEIGHT_UOM" type="{}T_WEIGHT_UOMS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="F_NUTRITION_ATTRIBUTE_UOM" type="{}T_NUTRITION_UOMS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="F_NUTRITION_SERVING_WEIGHT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_NUTRITION_SERVING_DESCRIPTION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_NUTRITION_PREPARATION_STATE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_NUTRITION_ATTRIBUTE_PRECISION" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_NUTRITION_ATTRIBUTE_QTY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="F_NUTRITION_ATTRIBUTE_PCT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "T_NUTRITIONAL_DATA", propOrder = {
    "fnutritionservingcode",
    "fnutritionattribute",
    "fnutritionweightuom",
    "fnutritionattributeuom",
    "fnutritionservingweight",
    "fnutritionservingdescription",
    "fnutritionpreparationstate",
    "fnutritionattributeprecision",
    "fnutritionattributeqty",
    "fnutritionattributepct"
})
public class TNUTRITIONALDATA {

    @XmlElement(name = "F_NUTRITION_SERVING_CODE")
    protected List<TNUTRITIONSERVINGS> fnutritionservingcode;
    @XmlElement(name = "F_NUTRITION_ATTRIBUTE")
    protected List<TNUTRITIONATTRIBUTETYPES> fnutritionattribute;
    @XmlElement(name = "F_NUTRITION_WEIGHT_UOM")
    protected List<TWEIGHTUOMS> fnutritionweightuom;
    @XmlElement(name = "F_NUTRITION_ATTRIBUTE_UOM")
    protected List<TNUTRITIONUOMS> fnutritionattributeuom;
    @XmlElement(name = "F_NUTRITION_SERVING_WEIGHT")
    protected String fnutritionservingweight;
    @XmlElement(name = "F_NUTRITION_SERVING_DESCRIPTION")
    protected String fnutritionservingdescription;
    @XmlElement(name = "F_NUTRITION_PREPARATION_STATE")
    protected String fnutritionpreparationstate;
    @XmlElement(name = "F_NUTRITION_ATTRIBUTE_PRECISION")
    protected String fnutritionattributeprecision;
    @XmlElement(name = "F_NUTRITION_ATTRIBUTE_QTY")
    protected String fnutritionattributeqty;
    @XmlElement(name = "F_NUTRITION_ATTRIBUTE_PCT")
    protected String fnutritionattributepct;

    /**
     * Gets the value of the fnutritionservingcode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fnutritionservingcode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFNUTRITIONSERVINGCODE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TNUTRITIONSERVINGS }
     * 
     * 
     */
    public List<TNUTRITIONSERVINGS> getFNUTRITIONSERVINGCODE() {
        if (fnutritionservingcode == null) {
            fnutritionservingcode = new ArrayList<TNUTRITIONSERVINGS>();
        }
        return this.fnutritionservingcode;
    }

    /**
     * Gets the value of the fnutritionattribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fnutritionattribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFNUTRITIONATTRIBUTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TNUTRITIONATTRIBUTETYPES }
     * 
     * 
     */
    public List<TNUTRITIONATTRIBUTETYPES> getFNUTRITIONATTRIBUTE() {
        if (fnutritionattribute == null) {
            fnutritionattribute = new ArrayList<TNUTRITIONATTRIBUTETYPES>();
        }
        return this.fnutritionattribute;
    }

    /**
     * Gets the value of the fnutritionweightuom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fnutritionweightuom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFNUTRITIONWEIGHTUOM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TWEIGHTUOMS }
     * 
     * 
     */
    public List<TWEIGHTUOMS> getFNUTRITIONWEIGHTUOM() {
        if (fnutritionweightuom == null) {
            fnutritionweightuom = new ArrayList<TWEIGHTUOMS>();
        }
        return this.fnutritionweightuom;
    }

    /**
     * Gets the value of the fnutritionattributeuom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fnutritionattributeuom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFNUTRITIONATTRIBUTEUOM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TNUTRITIONUOMS }
     * 
     * 
     */
    public List<TNUTRITIONUOMS> getFNUTRITIONATTRIBUTEUOM() {
        if (fnutritionattributeuom == null) {
            fnutritionattributeuom = new ArrayList<TNUTRITIONUOMS>();
        }
        return this.fnutritionattributeuom;
    }

    /**
     * Gets the value of the fnutritionservingweight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONSERVINGWEIGHT() {
        return fnutritionservingweight;
    }

    /**
     * Sets the value of the fnutritionservingweight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONSERVINGWEIGHT(String value) {
        this.fnutritionservingweight = value;
    }

    /**
     * Gets the value of the fnutritionservingdescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONSERVINGDESCRIPTION() {
        return fnutritionservingdescription;
    }

    /**
     * Sets the value of the fnutritionservingdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONSERVINGDESCRIPTION(String value) {
        this.fnutritionservingdescription = value;
    }

    /**
     * Gets the value of the fnutritionpreparationstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONPREPARATIONSTATE() {
        return fnutritionpreparationstate;
    }

    /**
     * Sets the value of the fnutritionpreparationstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONPREPARATIONSTATE(String value) {
        this.fnutritionpreparationstate = value;
    }

    /**
     * Gets the value of the fnutritionattributeprecision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONATTRIBUTEPRECISION() {
        return fnutritionattributeprecision;
    }

    /**
     * Sets the value of the fnutritionattributeprecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONATTRIBUTEPRECISION(String value) {
        this.fnutritionattributeprecision = value;
    }

    /**
     * Gets the value of the fnutritionattributeqty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONATTRIBUTEQTY() {
        return fnutritionattributeqty;
    }

    /**
     * Sets the value of the fnutritionattributeqty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONATTRIBUTEQTY(String value) {
        this.fnutritionattributeqty = value;
    }

    /**
     * Gets the value of the fnutritionattributepct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFNUTRITIONATTRIBUTEPCT() {
        return fnutritionattributepct;
    }

    /**
     * Sets the value of the fnutritionattributepct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFNUTRITIONATTRIBUTEPCT(String value) {
        this.fnutritionattributepct = value;
    }

}
