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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 List of all tags in the system.
 *             
 * 
 * <p>Java class for TagListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TagListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Tag" type="{}TagType"/>
 *         &lt;element name="StyleTag" type="{}StyleTagType"/>
 *         &lt;element name="SpecialCharacterTag" type="{}SpecialCharacterTagType"/>
 *         &lt;element name="CharacterTag" type="{}CharacterTagType"/>
 *         &lt;element name="FootnoteTag" type="{}FootnoteTagType"/>
 *         &lt;element name="HyperlinkTag" type="{}HyperlinkTagType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TagListType", propOrder = {
    "tagOrStyleTagOrSpecialCharacterTag"
})
public class TagListType {

    @XmlElements({
        @XmlElement(name = "SpecialCharacterTag", type = SpecialCharacterTagType.class),
        @XmlElement(name = "Tag", type = TagType.class),
        @XmlElement(name = "HyperlinkTag", type = HyperlinkTagType.class),
        @XmlElement(name = "FootnoteTag", type = FootnoteTagType.class),
        @XmlElement(name = "StyleTag", type = StyleTagType.class),
        @XmlElement(name = "CharacterTag", type = CharacterTagType.class)
    })
    protected List<Object> tagOrStyleTagOrSpecialCharacterTag;

    /**
     * Gets the value of the tagOrStyleTagOrSpecialCharacterTag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tagOrStyleTagOrSpecialCharacterTag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTagOrStyleTagOrSpecialCharacterTag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecialCharacterTagType }
     * {@link TagType }
     * {@link HyperlinkTagType }
     * {@link FootnoteTagType }
     * {@link StyleTagType }
     * {@link CharacterTagType }
     * 
     * 
     */
    public List<Object> getTagOrStyleTagOrSpecialCharacterTag() {
        if (tagOrStyleTagOrSpecialCharacterTag == null) {
            tagOrStyleTagOrSpecialCharacterTag = new ArrayList<Object>();
        }
        return this.tagOrStyleTagOrSpecialCharacterTag;
    }

}
