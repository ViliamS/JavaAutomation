package com.r2development.leveris.utils.XpathBuilder.version2;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

public class XPathTableMap {

    Multimap<Table<ELEMENTS, PREFIX, ACTIONS>, Table<ACTIONS, ATTRIBUTES, XPathValues>> xPathMap;


    public XPathTableMap() {
        this.xPathMap = LinkedHashMultimap.create();
    }

    public XPathTableMap(Multimap<Table<ELEMENTS, PREFIX, ACTIONS>, Table<ACTIONS, ATTRIBUTES, XPathValues>> xPathMap) {
        this.xPathMap = xPathMap;
    }

    public Multimap<Table<ELEMENTS, PREFIX, ACTIONS>, Table<ACTIONS, ATTRIBUTES, XPathValues>> getXPathTableMapMultimap() {
        return this.xPathMap;
    }
}