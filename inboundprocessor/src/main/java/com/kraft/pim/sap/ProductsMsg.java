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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="RECEIVER_SYSTEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="B2B_SENDER_QUALF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="B2B_SENDER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="B2B_DOCUMENT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="B2B_3PL_RECEIVER_QUALF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="B2B_3PL_RECEIVER_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INTERFACE_TO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Products" type="{}Products" maxOccurs="unbounded" minOccurs="0"/>
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
    "receiversystem",
    "b2BSENDERQUALF",
    "b2BSENDERID",
    "b2BDOCUMENTID",
    "b2B3PLRECEIVERQUALF",
    "b2B3PLRECEIVERID",
    "interfaceto",
    "products"
})
@XmlRootElement(name = "ProductsMsg")
public class ProductsMsg {

    @XmlElement(name = "RECEIVER_SYSTEM")
    protected String receiversystem;
    @XmlElement(name = "B2B_SENDER_QUALF")
    protected String b2BSENDERQUALF;
    @XmlElement(name = "B2B_SENDER_ID")
    protected String b2BSENDERID;
    @XmlElement(name = "B2B_DOCUMENT_ID")
    protected String b2BDOCUMENTID;
    @XmlElement(name = "B2B_3PL_RECEIVER_QUALF")
    protected String b2B3PLRECEIVERQUALF;
    @XmlElement(name = "B2B_3PL_RECEIVER_ID")
    protected String b2B3PLRECEIVERID;
    @XmlElement(name = "INTERFACE_TO")
    protected String interfaceto;
    @XmlElement(name = "Products")
    protected List<Products> products;

    /**
     * Gets the value of the receiversystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECEIVERSYSTEM() {
        return receiversystem;
    }

    /**
     * Sets the value of the receiversystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECEIVERSYSTEM(String value) {
        this.receiversystem = value;
    }

    /**
     * Gets the value of the b2BSENDERQUALF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2BSENDERQUALF() {
        return b2BSENDERQUALF;
    }

    /**
     * Sets the value of the b2BSENDERQUALF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2BSENDERQUALF(String value) {
        this.b2BSENDERQUALF = value;
    }

    /**
     * Gets the value of the b2BSENDERID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2BSENDERID() {
        return b2BSENDERID;
    }

    /**
     * Sets the value of the b2BSENDERID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2BSENDERID(String value) {
        this.b2BSENDERID = value;
    }

    /**
     * Gets the value of the b2BDOCUMENTID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2BDOCUMENTID() {
        return b2BDOCUMENTID;
    }

    /**
     * Sets the value of the b2BDOCUMENTID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2BDOCUMENTID(String value) {
        this.b2BDOCUMENTID = value;
    }

    /**
     * Gets the value of the b2B3PLRECEIVERQUALF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2B3PLRECEIVERQUALF() {
        return b2B3PLRECEIVERQUALF;
    }

    /**
     * Sets the value of the b2B3PLRECEIVERQUALF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2B3PLRECEIVERQUALF(String value) {
        this.b2B3PLRECEIVERQUALF = value;
    }

    /**
     * Gets the value of the b2B3PLRECEIVERID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2B3PLRECEIVERID() {
        return b2B3PLRECEIVERID;
    }

    /**
     * Sets the value of the b2B3PLRECEIVERID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2B3PLRECEIVERID(String value) {
        this.b2B3PLRECEIVERID = value;
    }

    /**
     * Gets the value of the interfaceto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERFACETO() {
        return interfaceto;
    }

    /**
     * Sets the value of the interfaceto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERFACETO(String value) {
        this.interfaceto = value;
    }

    /**
     * Gets the value of the products property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the products property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Products }
     * 
     * 
     */
    public List<Products> getProducts() {
        if (products == null) {
            products = new ArrayList<Products>();
        }
        return this.products;
    }

}
