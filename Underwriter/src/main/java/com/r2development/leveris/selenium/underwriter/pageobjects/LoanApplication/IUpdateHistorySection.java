package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;

import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath;

public interface IUpdateHistorySection {

    String UPDATE_HISTORY_TAB = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_8");
    String UPDATE_HISTORY_PANEL_TITLE = UPDATE_HISTORY_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Update History") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_8_header");

    String UPDATE_HISTORY_PANEL_HIDE = UPDATE_HISTORY_TAB + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "collapse");
    String UPDATE_HISTORY_PANEL_HIDDEN = UPDATE_HISTORY_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String UPDATE_HISTORY_PANEL_NOT_HIDDEN = UPDATE_HISTORY_PANEL_HIDE + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "display: none");

    IUpdateHistorySection updateHistorySectionHideUnhide(ACTION action);

}
