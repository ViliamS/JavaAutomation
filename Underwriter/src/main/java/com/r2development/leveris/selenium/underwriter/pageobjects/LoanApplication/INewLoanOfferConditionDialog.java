package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface INewLoanOfferConditionDialog {

    String NEW_LOAN_OFFER_DIALOG = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.ROLE, "dialog") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "block");

    String NEW_LOAN_OFFER_DIALOG_TITLE = NEW_LOAN_OFFER_DIALOG + getXPath(ELEMENTS.H3, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Add loan offer condition");

    String NEW_LOAN_OFFER_DIALOG_CLOSE_BUTTON_X = NEW_LOAN_OFFER_DIALOG + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "ui-dialog-titlebar-close") + getXPath_HasADescendantSpanEqualsText("close");

    String NEW_LOAN_OFFER_DIALOG_ADD_COMMENT_TEXTAREA = getXPath_DivEqualsDataPath("pnlMain txaText") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txaText_textarea");

    String NEW_LOAN_OFFER_DIALOG_SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlMain btnSave") + getXPath_DirectAButtonContainsWicketpath("btnSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");

    ILoanOfferToolSection clickCloseX();

    INewLoanOfferConditionDialog addComment(String comment);

    ILoanOfferToolSection clickSave();
}
