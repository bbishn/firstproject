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
 * <p>Java class for T_FUNCTIONAL_NAMES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="T_FUNCTIONAL_NAMES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_FUNCTIONAL_NAME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="F_FUNCTIONAL_NAME_ML" type="{}F_FUNCTIONAL_NAME_20_ML" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "T_FUNCTIONAL_NAMES", propOrder = {
    "ffunctionalname"
})
public class TFUNCTIONALNAMES {

    @XmlElement(name = "F_FUNCTIONAL_NAME")
    protected TFUNCTIONALNAMES.FFUNCTIONALNAME ffunctionalname;

    /**
     * Gets the value of the ffunctionalname property.
     * 
     * @return
     *     possible object is
     *     {@link TFUNCTIONALNAMES.FFUNCTIONALNAME }
     *     
     */
    public TFUNCTIONALNAMES.FFUNCTIONALNAME getFFUNCTIONALNAME() {
        return ffunctionalname;
    }

    /**
     * Sets the value of the ffunctionalname property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFUNCTIONALNAMES.FFUNCTIONALNAME }
     *     
     */
    public void setFFUNCTIONALNAME(TFUNCTIONALNAMES.FFUNCTIONALNAME value) {
        this.ffunctionalname = value;
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
     *         &lt;element name="F_FUNCTIONAL_NAME_ML" type="{}F_FUNCTIONAL_NAME_20_ML" maxOccurs="unbounded"/>
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
        "ffunctionalnameml"
    })
    public static class FFUNCTIONALNAME {

        @XmlElement(name = "F_FUNCTIONAL_NAME_ML", required = true)
        protected List<FFUNCTIONALNAME20ML> ffunctionalnameml;

        /**
         * Gets the value of the ffunctionalnameml property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ffunctionalnameml property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFFUNCTIONALNAMEML().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FFUNCTIONALNAME20ML }
         * 
         * 
         */
        public List<FFUNCTIONALNAME20ML> getFFUNCTIONALNAMEML() {
            if (ffunctionalnameml == null) {
                ffunctionalnameml = new ArrayList<FFUNCTIONALNAME20ML>();
            }
            return this.ffunctionalnameml;
        }

    }

}
