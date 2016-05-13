package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;

import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath;

public interface IFormToolsSection {

    String FORM_TOOLS_TAB =                getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_3");
    String FORM_TOOLS_PANEL_TITLE = FORM_TOOLS_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Form Tools") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_3_header");

    String FORM_TOOLS_PANEL_HIDE =         FORM_TOOLS_TAB + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "collapse");
    String FORM_TOOLS_PANEL_HIDDEN =       FORM_TOOLS_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String FORM_TOOLS_PANEL_NOT_HIDDEN =   FORM_TOOLS_PANEL_HIDE + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "display: none");

    IFormToolsSection formToolSectionHideUnhide(ACTION action);
}