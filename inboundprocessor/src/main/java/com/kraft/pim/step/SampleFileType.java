//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.13 at 03:27:41 PM IST 
//


package com.kraft.pim.step;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SampleFileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SampleFileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SampleFileContents" type="{}ConfigurationType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SampleFileName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SampleFileType", propOrder = {
    "sampleFileContents"
})
public class SampleFileType {

    @XmlElement(name = "SampleFileContents", required = true)
    protected byte[] sampleFileContents;
    @XmlAttribute(name = "SampleFileName", required = true)
    protected String sampleFileName;

    /**
     * Gets the value of the sampleFileContents property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSampleFileContents() {
        return sampleFileContents;
    }

    /**
     * Sets the value of the sampleFileContents property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSampleFileContents(byte[] value) {
        this.sampleFileContents = ((byte[]) value);
    }

    /**
     * Gets the value of the sampleFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSampleFileName() {
        return sampleFileName;
    }

    /**
     * Sets the value of the sampleFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSampleFileName(String value) {
        this.sampleFileName = value;
    }

}