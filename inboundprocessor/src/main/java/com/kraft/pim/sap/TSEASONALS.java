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
 * <p>Java class for T_SEASONALS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_SEASONALS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_SEASONAL_CODE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="F_SEASONAL_CODE_ML" type="{}F_SEASONAL_CODE_18_ML" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="F_SEASONAL_NAME" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
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
@XmlType(name = "T_SEASONALS", propOrder = {
    "fseasonalcode",
    "fseasonalname"
})
public class TSEASONALS {

    @XmlElement(name = "F_SEASONAL_CODE")
    protected TSEASONALS.FSEASONALCODE fseasonalcode;
    @XmlElement(name = "F_SEASONAL_NAME")
    protected String fseasonalname;

    /**
     * Gets the value of the fseasonalcode property.
     * 
     * @return
     *     possible object is
     *     {@link TSEASONALS.FSEASONALCODE }
     *     
     */
    public TSEASONALS.FSEASONALCODE getFSEASONALCODE() {
        return fseasonalcode;
    }

    /**
     * Sets the value of the fseasonalcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSEASONALS.FSEASONALCODE }
     *     
     */
    public void setFSEASONALCODE(TSEASONALS.FSEASONALCODE value) {
        this.fseasonalcode = value;
    }

    /**
     * Gets the value of the fseasonalname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFSEASONALNAME() {
        return fseasonalname;
    }

    /**
     * Sets the value of the fseasonalname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFSEASONALNAME(String value) {
        this.fseasonalname = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="F_SEASONAL_CODE_ML" type="{}F_SEASONAL_CODE_18_ML" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fseasonalcodeml"
    })
    public static class FSEASONALCODE {

        @XmlElement(name = "F_SEASONAL_CODE_ML", required = true)
        protected List<FSEASONALCODE18ML> fseasonalcodeml;

        /**
         * Gets the value of the fseasonalcodeml property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fseasonalcodeml property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFSEASONALCODEML().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FSEASONALCODE18ML }
         * 
         * 
         */
        public List<FSEASONALCODE18ML> getFSEASONALCODEML() {
            if (fseasonalcodeml == null) {
                fseasonalcodeml = new ArrayList<FSEASONALCODE18ML>();
            }
            return this.fseasonalcodeml;
        }

    }

}