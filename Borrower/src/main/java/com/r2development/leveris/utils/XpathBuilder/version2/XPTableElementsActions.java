package com.r2development.leveris.utils.XpathBuilder.version2;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Table;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;
import com.r2development.leveris.utils.XpathBuilder.XPathElement;

import java.util.LinkedList;

public class XPTableElementsActions extends XPathTableMap {

    public LinkedListMultimap<XPathElement, ACTIONS> elementActionsMultiMap;

    public Table<ELEMENTS, PREFIX, ACTIONS> elementActionsTable;


    public XPTableElementsActions() {
        this.elementActionsTable = HashBasedTable.create();
    }

    public XPTableElementsActions(Table<ELEMENTS, PREFIX, ACTIONS> elementActionsTable) {
        this.elementActionsTable = elementActionsTable;
    }

    public XPTableElementsActions(ELEMENTS element, PREFIX singleSlash, ACTIONS action) {
        this.elementActionsTable.put(element, singleSlash, action);
    }

    public XPTableElementsActions(ELEMENTS element, ACTIONS action) {
        new XPTableElementsActions(element, PREFIX.DOUBLE_SLASH, action);
    }

    public XPTableElementsActions(ELEMENTS element, PREFIX prefix, LinkedList<ACTIONS> actions) {
        for (ACTIONS action : actions) {
            this.elementActionsTable.put(element, prefix, action);
        }
    }

    public XPTableElementsActions(ELEMENTS element, LinkedList<ACTIONS> actions) {
        new XPTableElementsActions(element, PREFIX.DOUBLE_SLASH, actions);
    }

    public Table<ELEMENTS, PREFIX, ACTIONS> getTableElementActions() {
        return this.elementActionsTable;
    }

    public XPTableElementsActions addToTableElementsActions(ELEMENTS element, PREFIX prefix, ACTIONS action) {
        this.elementActionsTable.put(element, prefix, action);
        return this;
    }

    public XPTableElementsActions setTableElementActions(Table<ELEMENTS, PREFIX, ACTIONS> elementActionsTable) {
        return new XPTableElementsActions(elementActionsTable);
    }

    public String getXPath(Table.Cell<ELEMENTS, PREFIX, ACTIONS> tableCell) {
        return tableCell.getColumnKey().get() + tableCell.getRowKey().get();
    }

    public static Table<ELEMENTS, PREFIX, ACTIONS> getTableElementsActions(ELEMENTS element, PREFIX singleSlash, ACTIONS action) {
        return new XPTableElementsActions(element, singleSlash, action).getTableElementActions();
    }

    public static Table<ELEMENTS, PREFIX, ACTIONS> addToTableElementsActions(Table<ELEMENTS, PREFIX, ACTIONS> elementActionsTable, ELEMENTS element, PREFIX singleSlash, ACTIONS action) {
        return new XPTableElementsActions(elementActionsTable).addToTableElementsActions(element, singleSlash, action).getTableElementActions();
    }
}
