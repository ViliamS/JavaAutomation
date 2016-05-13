package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;

import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath;

public interface IDocuments2Section {

    String DOCUMENTS2_TAB = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_5");
    String DOCUMENTS2_PANEL_TITLE = DOCUMENTS2_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Documents 2") + getXPath(ACTIONS.NOT_EQUALS, ATTRIBUTES.TITLE, "Documents 1") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_5_header");

    String DOCUMENTS2_PANEL_HIDE = DOCUMENTS2_TAB + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "collapse");
    String DOCUMENTS2_PANEL_HIDDEN = DOCUMENTS2_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String DOCUMENTS2_PANEL_NOT_HIDDEN = DOCUMENTS2_PANEL_HIDE + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "display: none");

    IDocuments2Section documents2SectionHideUnhide(ACTION action);


}