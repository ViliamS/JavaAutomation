package com.r2development.leveris.utils.XpathBuilder;

import com.google.common.collect.LinkedListMultimap;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;

import java.util.LinkedList;

public class XPathAttributes extends XPath {

    public LinkedListMultimap<ATTRIBUTES, XPathValues> xpathAttributesListMap;

    public XPathAttributes() {
        this.xpathAttributesListMap = LinkedListMultimap.create();
    }

    public XPathAttributes(XPathAttributes xPathAttributes){
        this.xpathAttributesListMap = xPathAttributes.getXpathAttributesListMap();
    }

//    public XPathAttributes(LinkedListMultimap<ATTRIBUTES, LinkedList<String>> xpathAttributesListMap){
//        this.xpathAttributesListMap = xpathAttributesListMap;
//    }

    public XPathAttributes(LinkedListMultimap<ATTRIBUTES, XPathValues> xpathAttributesListMap){
        this.xpathAttributesListMap = xpathAttributesListMap;
    }

    public XPathAttributes(ATTRIBUTES attribute, String attributeValue) {
        super();
        this.xpathAttributesListMap = LinkedListMultimap.create();
        this.xpathAttributesListMap.put(attribute, new XPathValues(attributeValue));
    }

    public XPathAttributes(ATTRIBUTES attribute, XPathValues attributeValues) {
        super();
        this.xpathAttributesListMap = LinkedListMultimap.create();
        this.xpathAttributesListMap.put(attribute, attributeValues);
    }

    public XPathAttributes addEntryToMultimap(ATTRIBUTES attribute, String attributeValue){
        this.xpathAttributesListMap.put(attribute, new XPathValues(attributeValue));
        return this;
    }

    public XPathAttributes addEntryToMultimap(ATTRIBUTES attribute, XPathValues attributeValues){
        this.xpathAttributesListMap.put(attribute, attributeValues);
        return this;
    }

    /** Differently done the literally same thing as method below  */
    public static XPathAttributes addEntryToMultimap(XPathAttributes xPathAttributes, ATTRIBUTES attribute, String attributeValue){
        return new XPathAttributes(xPathAttributes).addEntryToMultimap(attribute, attributeValue);
    }

    /** Differently done the literally same thing as method above  */
    public static XPathAttributes addEntryToMultimap(XPathAttributes xPathAttributes, ATTRIBUTES attribute, XPathValues attributeValues){
        LinkedListMultimap<ATTRIBUTES, XPathValues> xpathAttributesListMapCustom = xPathAttributes.getXpathAttributesListMap();
        xpathAttributesListMapCustom.put(attribute, attributeValues);
        return new XPathAttributes(xpathAttributesListMapCustom);
    }

    public LinkedListMultimap<ATTRIBUTES, XPathValues> getXpathAttributesListMap() {
        return this.xpathAttributesListMap;
    }

    public XPathAttributes setXpathAttributesListMap(LinkedListMultimap<ATTRIBUTES, XPathValues> xpathAttributesListMap) {
        this.xpathAttributesListMap = xpathAttributesListMap;
        return this;
    }
}