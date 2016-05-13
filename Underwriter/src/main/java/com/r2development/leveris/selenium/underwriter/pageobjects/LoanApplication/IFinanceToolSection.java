package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.XpathBuilder.Enums.*;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IFinanceToolSection {

    String FINANCE_TOOL_TAB = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_1");
    String FINANCE_TOOL_TAB_TITLE = FINANCE_TOOL_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Finance Tool") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_1_header");


    String FINANCE_TOOL_PANEL_HIDE =        FINANCE_TOOL_TAB + getXPath(ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "collapse");
    String FINANCE_TOOL_PANEL_HIDDEN =      FINANCE_TOOL_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String FINANCE_TOOL_PANEL_NOT_HIDDEN =  FINANCE_TOOL_PANEL_HIDE + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "display: none");

    String COMMENTS_TEXTAREA =              getXPath_DivEqualsDataPath("txaComment") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txaComment_textarea");
    String SAVE_BUTTON =                    getXPath_DivEqualsDataPath("btnSave") + getXPath_HasADescendantSpanEqualsText("Save") + getXPath_DirectAButtonContainsWicketpath("btnSave_submit");
    String SAVE_BUTTON_TITLE =              SAVE_BUTTON + getXPath_DirectSpanEqualsText("Save");
    String CANCEL_BUTTON =                  getXPath_DivEqualsDataPath("btnCancel") + getXPath_HasADescendantSpanEqualsText("Cancel") + getXPath_DirectAButtonContainsWicketpath("btnCancel_cancel");
    String CANCEL_BUTTON_TITLE =            CANCEL_BUTTON + getXPath_DirectSpanEqualsText("Cancel");
    String ADD_ITEM_BUTTON =                getXPath_DivEqualsDataPath("btnAddItem") + getXPath_HasADescendantSpanEqualsText("Add item") + getXPath_DirectAButtonContainsWicketpath("btnAddItem_dialog");
    String ADD_ITEM_BUTTON_TITLE =          ADD_ITEM_BUTTON + getXPath_DirectSpanEqualsText("Add item");

    IFinanceToolSection financeToolSectionHideUnhide(ACTION action);
}
