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
 * 
 *                 A list of in- and outbound Integration End Points.
 *             
 * 
 * <p>Java class for IntegrationEndpointsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegrationEndpointsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OutBoundIntegrationEndpoint" type="{}OutBoundIntegrationEndpointType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InBoundIntegrationEndpoint" type="{}InBoundIntegrationEndpointType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegrationEndpointsType", propOrder = {
    "outBoundIntegrationEndpoint",
    "inBoundIntegrationEndpoint"
})
public class IntegrationEndpointsType {

    @XmlElement(name = "OutBoundIntegrationEndpoint")
    protected List<OutBoundIntegrationEndpointType> outBoundIntegrationEndpoint;
    @XmlElement(name = "InBoundIntegrationEndpoint")
    protected List<InBoundIntegrationEndpointType> inBoundIntegrationEndpoint;

    /**
     * Gets the value of the outBoundIntegrationEndpoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outBoundIntegrationEndpoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutBoundIntegrationEndpoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutBoundIntegrationEndpointType }
     * 
     * 
     */
    public List<OutBoundIntegrationEndpointType> getOutBoundIntegrationEndpoint() {
        if (outBoundIntegrationEndpoint == null) {
            outBoundIntegrationEndpoint = new ArrayList<OutBoundIntegrationEndpointType>();
        }
        return this.outBoundIntegrationEndpoint;
    }

    /**
     * Gets the value of the inBoundIntegrationEndpoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inBoundIntegrationEndpoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInBoundIntegrationEndpoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InBoundIntegrationEndpointType }
     * 
     * 
     */
    public List<InBoundIntegrationEndpointType> getInBoundIntegrationEndpoint() {
        if (inBoundIntegrationEndpoint == null) {
            inBoundIntegrationEndpoint = new ArrayList<InBoundIntegrationEndpointType>();
        }
        return this.inBoundIntegrationEndpoint;
    }

}
