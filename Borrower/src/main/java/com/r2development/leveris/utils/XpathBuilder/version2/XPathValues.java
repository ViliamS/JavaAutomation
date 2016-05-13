package com.r2development.leveris.utils.XpathBuilder.version2;

import java.util.Collections;
import java.util.LinkedList;

public class XPathValues extends XPTableActionsAttributesValues {

    protected LinkedList<String> xpathValuesList;

    public XPathValues() {
        this.xpathValuesList = new LinkedList<>();
    }

    public XPathValues(LinkedList<String> xpathValuesList) {
        new XPathValues();
        this.xpathValuesList = xpathValuesList;
    }

    public XPathValues(String value) {
        this.xpathValuesList = new LinkedList<String>() {{
            add(value);
        }};
    }

    public XPathValues(String[] values) {
        new XPathValues();
        Collections.addAll(this.xpathValuesList, values);
    }

    public LinkedList<String> getXpathValues() {
        return this.xpathValuesList;
    }

    public static XPathValues setXpathValues(LinkedList<String> xpathValuesList) {
        return new XPathValues(xpathValuesList);
    }

    public static LinkedList<String> getXPathValues(String value) {
        return new XPathValues(value).getXpathValues();
    }

    public static LinkedList<String> getXPathValues(String[] values) {
        return new XPathValues(values).getXpathValues();
    }
}