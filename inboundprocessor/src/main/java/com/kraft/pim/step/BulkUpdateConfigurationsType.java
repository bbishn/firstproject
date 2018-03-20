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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Element that holds all bulk update configurations.
 * 
 * <p>Java class for BulkUpdateConfigurationsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BulkUpdateConfigurationsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BulkUpdateConfiguration" type="{}BulkUpdateConfigurationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkUpdateConfigurationsType", propOrder = {
    "bulkUpdateConfiguration"
})
public class BulkUpdateConfigurationsType {

    @XmlElement(name = "BulkUpdateConfiguration")
    protected List<BulkUpdateConfigurationType> bulkUpdateConfiguration;

    /**
     * Gets the value of the bulkUpdateConfiguration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bulkUpdateConfiguration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBulkUpdateConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BulkUpdateConfigurationType }
     * 
     * 
     */
    public List<BulkUpdateConfigurationType> getBulkUpdateConfiguration() {
        if (bulkUpdateConfiguration == null) {
            bulkUpdateConfiguration = new ArrayList<BulkUpdateConfigurationType>();
        }
        return this.bulkUpdateConfiguration;
    }

}