package com.r2development.leveris.utils.XpathBuilder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Table;
import com.r2development.leveris.utils.XpathBuilder.Enums.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import java.util.LinkedList;
import java.util.Map;

public class XPath {

    private static final Log log = LogFactory.getLog(XPath.class.getName());

    public static ELEMENTS  /** Those are Shortcuts shorter to declare in interfaces xPaths will be more readable */
            input = ELEMENTS.getElement("input"),
            div = ELEMENTS.getElement("div"),
            a = ELEMENTS.getElement("a"),
            p = ELEMENTS.getElement("p"),
            span = ELEMENTS.getElement("span"),
            button = ELEMENTS.getElement("button"),
            select = ELEMENTS.getElement("select"),
            textarea = ELEMENTS.getElement("textarea"),
            label = ELEMENTS.getElement("label"),
            ul = ELEMENTS.getElement("ul"),
            li = ELEMENTS.getElement("li"),
            h1 = ELEMENTS.getElement("h1"),
            h2 = ELEMENTS.getElement("h2"),
            h3 = ELEMENTS.getElement("h3");

    public static ATTRIBUTES
            id = ATTRIBUTES.getAttribute("id"),
            em = ATTRIBUTES.getAttribute("em"),
            href = ATTRIBUTES.getAttribute("href"),
            frag = ATTRIBUTES.getAttribute("frag"),
            class_att = ATTRIBUTES.getAttribute("class"),
            dropdown = ATTRIBUTES.getAttribute("dropdown"),
            text = ATTRIBUTES.getAttribute("text"),
            checkbox = ATTRIBUTES.getAttribute("checkbox"),
            role = ATTRIBUTES.getAttribute("role"),
            datareactid = ATTRIBUTES.getAttribute("data-reactid"),
            type = ATTRIBUTES.getAttribute("type"),
            name = ATTRIBUTES.getAttribute("name"),
            title = ATTRIBUTES.getAttribute("title"),
            style = ATTRIBUTES.getAttribute("style"),
            disabled = ATTRIBUTES.getAttribute("disabled"),
            wicketpath = ATTRIBUTES.getAttribute("wicketpath"),
            dataPath = ATTRIBUTES.getAttribute("data-path");

    public static ACTION
            and = ACTION.getAction("and"),
            not = ACTION.getAction("not");


    public static ACTIONS
            contains = ACTIONS.getActions("contains"),
            notContains = ACTIONS.getActions(not.toString() + "_" + contains.toString()),
            equals = ACTIONS.getActions("equals"),
            notEquals = ACTIONS.getActions(not.toString() + "_" + equals.toString());

    public static PREFIX
            singleSlash = PREFIX.getPrefix("single slash"),
            doubleSlash = PREFIX.getPrefix("double slash");

    /**
     * LinkedListMultimap<LinkedListMultimap<LinkedListMultimap<PREFIX, ELEMENTS>, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, LinkedList<String>>>
     *
     * LinkedListMultimap<LinkedListMultimap<XPathElement,                         LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>>
     *
     * LinkedListMultimap<LinkedListMultimap<XPathActionsElements>,                                      LinkedListMultimap<XPathAttributesValues>
     */
    protected LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap;
    protected LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> xPathElementActionsMap;
    protected LinkedListMultimap<ATTRIBUTES, XPathValues> xPathAttributesListMap;

    public XPath (XPath xPath){
        this.xpathListMap = xPath.getListMapElementActionsAttributesValues();
    }

    public XPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues attributeValues) {
        this.xPathElementActionsMap = new XPathActionsElements(new XPathElement(singleSlash, element), action).getElementActionsMap();
        this.xPathAttributesListMap = new XPathAttributes(attribute, attributeValues).getXpathAttributesListMap();
        this.xpathListMap = new XPath(doubleSlash, element, action, attribute, attributeValues).getListMapElementActionsAttributesValues();
    }

    public XPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, LinkedList<String> attributeValues) {
        this.xPathElementActionsMap = new XPathActionsElements(new XPathElement(singleSlash, element), action).getElementActionsMap();
        this.xPathAttributesListMap = new XPathAttributes(attribute, new XPathValues(attributeValues)).getXpathAttributesListMap();
        this.xpathListMap = new XPath(doubleSlash, element, action, attribute, new XPathValues(attributeValues)).getListMapElementActionsAttributesValues();
    }

    public XPath(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        this.xPathElementActionsMap = new XPathActionsElements(new XPathElement(singleSlash, element), action).getElementActionsMap();
        this.xPathAttributesListMap = new XPathAttributes(attribute, value).getXpathAttributesListMap();
        this.xpathListMap = new XPath(new XPathActionsElements(new XPathElement(prefix, element), action).getElementActionsMap(), new XPathAttributes(attribute, value).getXpathAttributesListMap()).getListMapElementActionsAttributesValues();
    }

    public XPath(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues attributeValues) {
        this.xPathElementActionsMap = new XPathActionsElements(new XPathElement(singleSlash, element), action).getElementActionsMap();
        this.xPathAttributesListMap = new XPathAttributes(attribute, attributeValues).getXpathAttributesListMap();
        this.xpathListMap = new XPath(new XPathActionsElements(new XPathElement(prefix, element), action).getElementActionsMap(), new XPathAttributes(attribute, attributeValues).getXpathAttributesListMap()).getListMapElementActionsAttributesValues();
    }

    public XPath() {
        this.xpathListMap = LinkedListMultimap.create();
        this.xPathElementActionsMap = LinkedListMultimap.create();
        this.xPathAttributesListMap = LinkedListMultimap.create();
    }

    public XPath(XPathActionsElements xPathActionsElements, XPathAttributes xPathAttributes){
        this.xpathListMap = new XPath(xPathActionsElements.getElementActionsMap(), xPathAttributes.getXpathAttributesListMap()).getListMapElementActionsAttributesValues();
        this.xPathElementActionsMap = xPathActionsElements.getElementActionsMap();
        this.xPathAttributesListMap = xPathAttributes.getXpathAttributesListMap();
    }

    public XPath(LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> elementActionsMap, LinkedListMultimap<ATTRIBUTES, XPathValues> xpathAttributesListMap) {
        this.xPathElementActionsMap = elementActionsMap;
        this.xPathAttributesListMap = xpathAttributesListMap;
        this.xpathListMap = LinkedListMultimap.create();
        this.xpathListMap.put(elementActionsMap, xpathAttributesListMap);
    }

    public XPath(LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathTable) {
        this.xpathListMap = xpathTable;
    }

    public XPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String attributeValues) {
        this.xPathElementActionsMap = new XPathActionsElements(new XPathElement(doubleSlash, element), action).getElementActionsMap();
        this.xPathAttributesListMap = new XPathAttributes(attribute, attributeValues).getXpathAttributesListMap();
        this.xpathListMap = LinkedListMultimap.create();
        this.xpathListMap.put(this.xPathElementActionsMap, xPathAttributesListMap);
    }

    public static String getXPath(ELEMENTS element) {
        return new XPathElement(doubleSlash, element).getXPath();
    }

    public static String getXPath(PREFIX prefix, ELEMENTS element) {
        return new XPathElement(prefix, element).getXPath();
    }

    public static String getXPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return new XPath(element, action, attribute, value).getXPath();
    }

    public static String getXPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, LinkedList<String> value) {
        return new XPath(element, action, attribute, value).getXPath();
    }

    public static String getXPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return new XPath(element, action, attribute, values).getXPath();
    }

    public static String getXPath(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return getXPath(prefix, element, action, attribute, new XPathValues(value));
    }

    public static String getXPath(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues value) {
        return new XPath(prefix, element, action, attribute, value).getXPath();
    }

    public static String getXPath_DirectSibling(ELEMENTS element) {
        return new XPathElement(singleSlash, element).getXPath();
    }

    public static String getXPath_DirectSibling(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return getXPath_DirectSibling(element, action, attribute, new XPathValues(value));
    }

    public static String getXPath_DirectSibling(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return new XPath(singleSlash, element, action, attribute, values).getXPath();
    }

    public static String getXPath_DivEqualsDataPath(String dataPath) {
        return new XPath(doubleSlash, ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.DATA_PATH, new XPathValues(dataPath)).getXPath();
    }

    /************************************ Div And Contains DataPath ************************************/
    public static String getXPath_DivAndContainsDataPath(String dataPath) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath));
    }

    public static String getXPath_DivAndContainsDataPath(String dataPath, String dataPath2) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath, dataPath2));
    }

    public static String getXPath_DivAndContainsDataPath(String dataPath, String dataPath2, String dataPath3) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath, dataPath2, dataPath3));
    }

    public static String getXPath_DivAndContainsDataPath(String dataPath, String dataPath2, String dataPath3, String dataPath4) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath, dataPath2, dataPath3, dataPath4));
    }

    public static String getXPath_DivAndContainsDataPath(XPathValues xPathValues) {
        return new XPath(doubleSlash, ELEMENTS.DIV, ACTIONS.AND_CONTAINS, ATTRIBUTES.DATA_PATH, xPathValues).getXPath();
    }/************************************ Div And Contains DataPath ************************************/


    /************************************ Div And Contains Wicketpath ************************************/
    public static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath));
    }

    public static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath, String dataPath2) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath, dataPath2));
    }

    public static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath, String dataPath2, String dataPath3) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath, dataPath2, dataPath3));
    }

    public static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath, String dataPath2, String dataPath3, String dataPath4) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath, dataPath2, dataPath3, dataPath4));
    }

    public static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, XPathValues xPathValues) {
        return new XPath(prefix, element, ACTIONS.AND_CONTAINS, ATTRIBUTES.WICKETPATH, xPathValues).getXPath();
    }/************************************ Div And Contains Wicketpath ************************************/


    public static String getXPath_DivEqualsId(String idValue) {
        return new XPath(doubleSlash, ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.ID, new XPathValues(idValue)).getXPath();
    }

    public static String getXPath_DivEqualsClass(String classValue){
        return new XPath(doubleSlash, ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.CLASS, new XPathValues(classValue)).getXPath();
    }

    public static String getXPath_DivEqualsWicket(String wicketpathValue){
        return new XPath(doubleSlash, ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, wicketpathValue).getXPath();
    }

    /********************************** Containing Wicketpath **************************************/
    public static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, String value) {
        return getXPath_ContainsWicketpath(prefix, element, new XPathValues(value));
    }

    public static String getXPath_ContainsWicketpath(ELEMENTS element, String value) {
        return getXPath_ContainsWicketpath(doubleSlash, element, new XPathValues(value));
    }

    public static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, String value, String value2) {
        return getXPath_ContainsWicketpath(prefix, element, new XPathValues(value, value2));
    }

    public static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, String value, String value2, String value3) {
        return getXPath_ContainsWicketpath(prefix, element, new XPathValues(value, value2, value3));
    }

    public static String getXPath_ContainsWicketpath(ELEMENTS element, LinkedList<String> values) {
        return getXPath_ContainsWicketpath(doubleSlash, element, new XPathValues(values));
    }

    public static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, XPathValues xPathValues){
        return getXPath(prefix, element, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, xPathValues);
    }/********************************** Containing Wicketpath **************************************/

    public static String getXPath_DirectSpanEqualsText(String value) {
        return getXPath(singleSlash, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, value);
    }

    public static String getXPath_SpanEqualsText(String value) {
        return getXPath(doubleSlash, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, value);
    }

    public static String getXPath_DirectAButtonContainsWicketpath(String value) {
        return getXPath(singleSlash, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, value);
    }

    public static String getXPath_DirectAButtonContainsOrContainsWicketpath(String value, String value2) {
        return getXPath_DirectAButtonContainsOrContainsWicketpath(new XPathValues(value, value2));
    }

    public static String getXPath_DirectAButtonContainsOrContainsWicketpath(XPathValues xPathValues) {
        return getXPath(singleSlash, ELEMENTS.A, ACTIONS.OR_CONTAINS, ATTRIBUTES.WICKETPATH, xPathValues);
    }

    /************************************  Direct A Button And Contains Wicketpath ************************************/
    public static String getXPath_DirectAButtonAndContainsWicketpath(String value){
        return getXPath_DirectAButtonAndContainsWicketpath(new XPathValues(value));
    }

    public static String getXPath_DirectAButtonAndContainsWicketpath(String value, String value2){
        return getXPath_DirectAButtonAndContainsWicketpath(new XPathValues(value, value2));
    }

    public static String getXPath_DirectAButtonAndContainsWicketpath(String value, String value2, String value3){
        return getXPath_DirectAButtonAndContainsWicketpath(new XPathValues(value, value2, value3));
    }

    public static String getXPath_DirectAButtonAndContainsWicketpath(XPathValues xPathValues){
        return getXPath(singleSlash, ELEMENTS.A, ACTIONS.AND_CONTAINS, ATTRIBUTES.WICKETPATH, xPathValues);
    }/************************************  Direct A Button And Contains Wicketpath ************************************/

    public static String getXPath_HasADescendant(String xpath){
        return "[" + xpath + "]";
    }

    public static String getXPath_HasADescendant(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return getXPath_HasADescendant(getXPath(element, action, attribute, value));
    }

    /****************************** Has A Descendant Span Text ******************************/
    public static String getXPath_HasADescendantSpanText(ACTIONS action, String value) {
        return getXPath_HasADescendantSpanText(action, new XPathValues(value));
    }

    public static String getXPath_HasADescendantSpanText(ACTIONS action, String value, String value2) {
        return getXPath_HasADescendantSpanText(action, new XPathValues(value, value2));
    }

    public static String getXPath_HasADescendantSpanText(ACTIONS action, String value, String value2, String value3) {
        return getXPath_HasADescendantSpanText(action, new XPathValues(value, value2, value3));
    }

    public static String getXPath_HasADescendantSpanText(ACTIONS action, XPathValues xPathValues) {
        return "[" + getXPath(ELEMENTS.SPAN, action, ATTRIBUTES.TEXT, xPathValues) + "]";
    }/****************************** Has A Descendant Span Text ******************************/

    public static String getXPath_HasADescendantSpanEqualsText(String value) {
        return "[" + getXPath(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, value) + "]";
    }

    public static String getXPath_HasADescendantSpanContainsText(String value) {
        return "[" + getXPath(ELEMENTS.SPAN, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, value) + "]";
    }

    public static String getXPath_HasADescendantLabelEqualsText(String value) {
        return "[" + getXPath(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, value) + "]";
    }

    public static String getXPath_HasADescendantLabelContainsText(String value) {
        return "[" + getXPath(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, value) + "]";
    }

    public static String getXPath_HasADescendant(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, LinkedList<String> values) {
        return "[" + getXPath(element, action, attribute, values) + "]";
    }

    public static String getXPath_HasADescendant(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return "[" + getXPath(element, action, attribute, values) + "]";
    }

    public static String getXPath_HasADescendant(LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap) {
        return "[" + getXPath(xpathListMap) + "]";
    }

    public static String getXPath(ACTIONS action, ATTRIBUTES attribute, String value) {
        return XPathBuilder.getXPath(action, attribute, new XPathValues(value));
    }

    public static String getXPath(ACTIONS action, ATTRIBUTES attribute, XPathValues value) {
        return new XPathActionsAttributesValues(action, attribute, value).getXPath();
    }

    public static String getXPath(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        return new XPathActionsAttributesValues(action, attributes, values).getXPath();
    }

    public static String getXPath(Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable) {
        String xPath = "";
        for (Table.Cell<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> tableCell : xPathTable.cellSet()) {

            if (tableCell.getColumnKey() == null)
                Assert.assertTrue("attributesList is null", false);

            if (tableCell.getValue() == null)
                Assert.assertTrue("listOfListValues is null", false);

            for (ATTRIBUTES attribute : tableCell.getColumnKey()) {

                for (XPathValues values : tableCell.getValue()) {
                    xPath = xPath + XPathBuilder.getXPath(tableCell.getRowKey(), attribute, values);
                }
            }
        }
        return xPath;
    }

    public static String getXPath(LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap) {
        String xpath = "";
        for (Map.Entry<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> mapEntry : xpathListMap.entries()) {
            for (Map.Entry<XPathElement, LinkedList<ACTIONS>> elementActionsMapEntry : mapEntry.getKey().entries()) {
                for (Map.Entry<PREFIX, ELEMENTS> elementEntry : elementActionsMapEntry.getKey().entries()) {
                    /** Adding into Xpath '// + element' or '/ + element' */
                    xpath = xpath + XPathBuilder.getElementXpath(elementEntry.getKey(), elementEntry.getValue());
                    /** Adding into Xpath '// + element' or '/ + element' */
                    for (ACTIONS action : elementActionsMapEntry.getValue()) {
                        for (Map.Entry<ATTRIBUTES, XPathValues> attributesValuesMapEntry : mapEntry.getValue().entries()) {
                            /** Adding into Xpath based on action [contains|equals etc...] an [@attribute='value']  */
                            xpath = xpath + XPathBuilder.getXPath(action, attributesValuesMapEntry.getKey(), attributesValuesMapEntry.getValue());
                            /** Adding into Xpath based on action [contains|equals etc...] an [@attribute='value']  */
                        }
                    }
                }
            }
        }
        return xpath;
    }

    public String getXPath() {
        String xpath = "";
        if (this.xpathListMap.entries() != null) {
            for (Map.Entry<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> mapEntry : xpathListMap.entries()) {
                for (Map.Entry<XPathElement, LinkedList<ACTIONS>> elementActionsMapEntry : mapEntry.getKey().entries()) {
                    for (Map.Entry<PREFIX, ELEMENTS> elementEntry : elementActionsMapEntry.getKey().entries()) {
                        /** Adding into Xpath '// + element' or '/ + element' */
                        xpath = xpath + XPathBuilder.getElementXpath(elementEntry.getKey(), elementEntry.getValue());
                        /** Adding into Xpath '// + element' or '/ + element' */
                        LinkedList<ACTIONS> actions = elementActionsMapEntry.getValue();
                        for (ACTIONS action : actions) {
                            for (Map.Entry<ATTRIBUTES, XPathValues> attributesValuesMapEntry : mapEntry.getValue().entries()) {
                                ATTRIBUTES attributes = attributesValuesMapEntry.getKey();
                                XPathValues list = attributesValuesMapEntry.getValue();
                                /** Adding into Xpath based on action [contains|equals etc...] an [@attribute='value']  */
                                xpath = xpath + XPathBuilder.getXPath(action, attributes, list);
                                /** Adding into Xpath based on action [contains|equals etc...] an [@attribute='value']  */
                            }
                        }
                    }
                }
            }
            return xpath;
        }
        return "//div[@id='ERROR IN XPath Generation']";
    }

    public LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> getListMapElementActionsAttributesValues() {
        return this.xpathListMap;
    }

    public XPath setListMapElementActionsAttributesValues(LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap) {
        this.xpathListMap = new XPath(xpathListMap).getListMapElementActionsAttributesValues();
        return this;
    }

    public static XPathAttributes newAttributesValuesClass(ATTRIBUTES attributes, XPathValues values) {
        return new XPathAttributes(attributes, values);
    }

    public static LinkedListMultimap<ATTRIBUTES, XPathValues> newAttributesValuesMap(ATTRIBUTES attributes, XPathValues values) {
        return new XPathAttributes(attributes, values).getXpathAttributesListMap();
    }

    public static XPath addEntryElementActionsAttributesValues(XPath xPath, XPathActionsElements xPathActionsElements, XPathAttributes xPathAttributes){
        return new XPath(xPath).addEntryElementActionsAttributesValues(xPathActionsElements, xPathAttributes);
    }

    public XPath addEntryElementActionsAttributesValues(XPathActionsElements xPathActionsElements, XPathAttributes xPathAttributes) {
        this.xpathListMap.putAll(new XPath(xPathActionsElements, xPathAttributes).getListMapElementActionsAttributesValues());
        this.xPathElementActionsMap = xPathActionsElements.getElementActionsMap();
        this.xPathAttributesListMap = xPathAttributes.getXpathAttributesListMap();
        return this;
    }

    public static XPathAttributes addEntryAttributesValuesMap(XPathAttributes xPathAttributes, ATTRIBUTES attribute, String value){
        return new XPathAttributes(xPathAttributes).addEntryToMultimap(attribute, value);
    }

    public static XPathAttributes addEntryAttributesValuesMap(XPathAttributes xPathAttributes, ATTRIBUTES attribute, XPathValues value){
        return new XPathAttributes(xPathAttributes).addEntryToMultimap(attribute, value);
    }

    public static XPathActionsElements addEntryActionsElementsMap(XPathActionsElements xPathActionsElements, XPathElement xPathElement, ACTIONS action){
        return new XPathActionsElements(xPathActionsElements).addEntry(xPathElement, action);
    }

    public static XPathActionsElements addEntryActionsElementsMap(XPathActionsElements xPathActionsElements, XPathElement xPathElement, LinkedList<ACTIONS> actions){
        return new XPathActionsElements(xPathActionsElements).addEntry(xPathElement, actions);
    }

    public static XPathActionsElements newActionsElementClass(PREFIX prefix, ELEMENTS element, ACTIONS action){
        return new XPathActionsElements(prefix, element, new LinkedList<ACTIONS>(){{add(action);}});
    }

    public static LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> newActionsElementMap(PREFIX prefix, ELEMENTS element, ACTIONS action){
        return new XPathActionsElements(prefix, element, new LinkedList<ACTIONS>(){{add(action);}}).getElementActionsMap();
    }

    public XPath addEntry(PREFIX slashes, ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        addEntry(slashes, element, action, attribute, new XPathValues(value));
        return this;
    }

    public XPath addEntry(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        addEntry(element, action, attribute, new XPathValues(value));
        return this;
    }

    public XPath addEntry(ELEMENTS element, ACTIONS action, ATTRIBUTES attributes, XPathValues values) {
        addEntry(doubleSlash, element, action, attributes, values);
        return this;
    }

    public XPath addEntry(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attributes, LinkedList<String> values) {
        XPathElement xPathElement = new XPathElement(prefix, element);
        addEntry(xPathElement, action, attributes, values);
        return this;
    }

    public XPath addEntry(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attributes, XPathValues values) {
        XPathElement xPathElement = new XPathElement(prefix, element);
        addEntry(xPathElement, action, attributes, values);
        return this;
    }

    public XPath addEntry(XPathElement element, ACTIONS action, ATTRIBUTES attributes, XPathValues values) {
        XPathAttributes xPathAttributes = new XPathAttributes(attributes, values);
        LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> newElementActionMap = LinkedListMultimap.create();
        newElementActionMap.put(element, new LinkedList<ACTIONS>() {{
            add(action);
        }});
        LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap = LinkedListMultimap.create();
        xpathListMap.put(newElementActionMap, xPathAttributes.getXpathAttributesListMap());
        this.xpathListMap.putAll(xpathListMap);
        return this;
    }

    public XPath addEntry(XPathElement element, ACTIONS action, ATTRIBUTES attributes, LinkedList<String> values) {
        XPathAttributes xPathAttributes = new XPathAttributes(attributes, new XPathValues(values));
        LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> newElementActionMap = LinkedListMultimap.create();
        newElementActionMap.put(element, new LinkedList<ACTIONS>() {{
            add(action);
        }});
        LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap = LinkedListMultimap.create();
        xpathListMap.put(newElementActionMap, xPathAttributes.getXpathAttributesListMap());
        this.xpathListMap.putAll(xpathListMap);
        return this;
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getActionsAttributesValuesTable(ACTIONS action, ATTRIBUTES attribute, String value) {
        return getActionsAttributesValuesTable(action, attribute, new XPathValues(value));
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getActionsAttributesValuesTable(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return getActionsAttributesValuesTable(action, new LinkedList<ATTRIBUTES>() {{
            add(attribute);
        }}, new LinkedList<XPathValues>() {{
            add(values);
        }});
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getActionsAttributesValuesTable(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> newXPathTable = HashBasedTable.create();
        newXPathTable.put(action, attributes, values);
        return newXPathTable;
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<LinkedList<String>>> addToActionsAttributesValuesTable(Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<LinkedList<String>>> xPathTable, ACTIONS action, ATTRIBUTES attribute, LinkedList<String> values) {
        xPathTable.put(action, new LinkedList<ATTRIBUTES>() {{
            add(attribute);
        }}, new LinkedList<LinkedList<String>>() {{
            add(values);
        }});
        return xPathTable;
    }
}