//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 12:49:43 PM IST 
//


package com.kraft.pim.sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for F_PRODUCT_DESCRIPTION_GRID_1_ML complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="F_PRODUCT_DESCRIPTION_GRID_1_ML">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="F_PRODUCT_DESCRIPTION_GRIDLanguage" type="{}Language" minOccurs="0"/>
 *         &lt;element name="F_PRODUCT_DESCRIPTION_GRID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
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
@XmlType(name = "F_PRODUCT_DESCRIPTION_GRID_1_ML", propOrder = {
    "fproductdescriptiongridLanguage",
    "fproductdescriptiongrid"
})
public class FPRODUCTDESCRIPTIONGRID1ML {

    @XmlElement(name = "F_PRODUCT_DESCRIPTION_GRIDLanguage")
    @XmlSchemaType(name = "string")
    protected Language fproductdescriptiongridLanguage;
    @XmlElement(name = "F_PRODUCT_DESCRIPTION_GRID")
    protected String fproductdescriptiongrid;

    /**
     * Gets the value of the fproductdescriptiongridLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link Language }
     *     
     */
    public Language getFPRODUCTDESCRIPTIONGRIDLanguage() {
        return fproductdescriptiongridLanguage;
    }

    /**
     * Sets the value of the fproductdescriptiongridLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Language }
     *     
     */
    public void setFPRODUCTDESCRIPTIONGRIDLanguage(Language value) {
        this.fproductdescriptiongridLanguage = value;
    }

    /**
     * Gets the value of the fproductdescriptiongrid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFPRODUCTDESCRIPTIONGRID() {
        return fproductdescriptiongrid;
    }

    /**
     * Sets the value of the fproductdescriptiongrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFPRODUCTDESCRIPTIONGRID(String value) {
        this.fproductdescriptiongrid = value;
    }

}
