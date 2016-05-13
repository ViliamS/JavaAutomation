package com.r2development.leveris.utils.XpathBuilder.version2;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.XPathValues;
import com.r2development.leveris.utils.XpathBuilder.XPathBuilder;
import org.junit.Assert;

import java.util.LinkedList;

public class XPTableActionsAttributesValues extends XPTableElementsActions {

    protected Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable;

    public XPTableActionsAttributesValues() {
        this.xPathTable = HashBasedTable.create();
    }

    public XPTableActionsAttributesValues(Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable) {
        this.xPathTable = xPathTable;
    }

    public XPTableActionsAttributesValues(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable = HashBasedTable.create();
        xPathTable.put(action, attributes, values);
        this.xPathTable = xPathTable;
    }

    public XPTableActionsAttributesValues(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        this.xPathTable = XPTableActionsAttributesValues.getXPathTable(action, new LinkedList<ATTRIBUTES>() {{
            add(attribute);
        }}, new LinkedList<XPathValues>() {{
            add(values);
        }});
    }

    public XPTableActionsAttributesValues(ACTIONS action, ATTRIBUTES attribute, String value) {
        this.xPathTable = XPTableActionsAttributesValues.getXPathTable(action, attribute, new XPathValues(value));
    }

    public String getXPath() {

        String xPath = "";

        for (Table.Cell<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> tableCell : this.xPathTable.cellSet()) {

            if (tableCell.getColumnKey() == null)
                Assert.assertTrue("attributesList is null", false);

            if (tableCell.getValue() == null)
                Assert.assertTrue("listOfListValues is null", false);

            for (ATTRIBUTES attribute : tableCell.getColumnKey()) {

                for (XPathValues values : tableCell.getValue()) {

                    for (String value : values.getXpathValuesList()) {

                        xPath = xPath + XPathBuilder.getXPath(tableCell.getRowKey(), attribute, value);
                    }
                }
            }
        }
        return xPath;
    }

    public String getTableXPath(ACTIONS action, ATTRIBUTES attribute, String value) {
        return new XPTableActionsAttributesValues(action, attribute, value).getXPath();
    }

    public String getTableXPath(ACTIONS action, ATTRIBUTES attribute, XPathValues value) {
        return new XPTableActionsAttributesValues(action, attribute, value).getXPath();
    }

    public String getTableXPath(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        return new XPTableActionsAttributesValues(action, attributes, values).getXPath();
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getXPathTable(ACTIONS action, ATTRIBUTES attribute, String value) {
        return XPTableActionsAttributesValues.getXPathTable(action, attribute, new XPathValues(new LinkedList<String>() {{
            add(value);
        }}));
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getXPathTable(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return XPTableActionsAttributesValues.getXPathTable(action, new LinkedList<ATTRIBUTES>() {{
            add(attribute);
        }}, new LinkedList<XPathValues>() {{
            add(values);
        }});
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getXPathTable(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable = HashBasedTable.create();
        xPathTable.put(action, attributes, values);
        return xPathTable;
    }

    public static String getXPathFromTable(ACTIONS action, ATTRIBUTES attribute, String value) {
        XPTableActionsAttributesValues actionsAttributesValues = new XPTableActionsAttributesValues(action, attribute, value);
        return actionsAttributesValues.getXPath();
    }

    public static String getXPathFromTable(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        XPTableActionsAttributesValues actionsAttributesValues = new XPTableActionsAttributesValues(action, attribute, values);
        return actionsAttributesValues.getXPath();

    }

    public static String getXPathFromTable(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        XPTableActionsAttributesValues actionsAttributesValues = new XPTableActionsAttributesValues(action, attributes, values);
        return actionsAttributesValues.getXPath();
    }

}