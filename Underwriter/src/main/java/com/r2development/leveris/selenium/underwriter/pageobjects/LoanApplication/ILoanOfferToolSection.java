package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.XpathBuilder.Enums.*;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface ILoanOfferToolSection {

    String LOAN_OFFER_TOOL_TAB = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_2");
    String LOAN_OFFER_TOOL_PANEL_TITLE = LOAN_OFFER_TOOL_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Loan Offer Tool") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_2_header");

    String LOAN_OFFER_TOOL_PANEL_HIDE = LOAN_OFFER_TOOL_TAB + getXPath(ELEMENTS.A, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "collapse");
    String LOAN_OFFER_TOOL_PANEL_HIDDEN = LOAN_OFFER_TOOL_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String LOAN_OFFER_TOOL_PANEL_NOT_HIDDEN = LOAN_OFFER_TOOL_PANEL_HIDE + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "display: none");

    String LOAN_OFFER_TOOL_VERSION_SELECT = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("cmbLoanOfferVersion") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "cmbLoanOfferVersion");
    String LOAN_OFFER_TOOL_EDIT_REVIEW_BUTTON = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("btnSaveOffer") + getXPath_DirectAButtonContainsWicketpath("btnSaveOffer_submit") + getXPath_HasADescendantSpanEqualsText("Edit review");
    String LOAN_OFFER_TOOL_RESET_BUTTON = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("btnReset") + getXPath_DirectAButtonContainsWicketpath("btnReset_cancel") + getXPath_HasADescendantSpanEqualsText("Reset");
    String LOAN_OFFER_TOOL_ADD_COMMENTS_HERE = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("pnlCommentAndSign txaComments") + getXPath_HasADescendantLabelContainsText("Add comments here") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, "pnlCommentAndSign_c_w_txaComments_textarea");
    String LOAN_OFFER_TOOL_SIGN_REVIEW_BUTTON = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("pnlCommentAndSign btnCompleteReview") + getXPath_DirectAButtonContainsWicketpath("btnCompleteReview_submit") + getXPath_HasADescendantSpanEqualsText("Sign review");
    String LOAN_OFFER_TOOL_ADD_CONDITION_BUTTON = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("btnAddCondition") + getXPath_DirectAButtonContainsWicketpath("btnAddCondition_dialog") + getXPath_HasADescendantSpanEqualsText("Add condition");
    String LOAN_OFFER_TOOL_MIN_REPAYMENT_INPUT = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("pnlOfferValuesUWOffer crbMinRepayment") + getXPath_HasADescendantLabelEqualsText("Min repayment") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "crbMinRepayment");
    String LOAN_OFFER_TOOL_MAX_REPAYMENT_INPUT = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("pnlOfferValuesUWOffer crbMaxRepayment") + getXPath_HasADescendantLabelEqualsText("Max repayment") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "crbMaxRepayment");
    String LOAN_OFFER_TOOL_SAVE_OFFER_BUTTON = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("btnSaveOffer") + getXPath_DirectAButtonContainsWicketpath("btnSaveOffer_submit") + getXPath_HasADescendantSpanEqualsText("Save offer");

    String LOAN_OFFER_TOOL_WARNING_SCORE_NOT_FULLY_SET_UP_YET = LOAN_OFFER_TOOL_TAB + getXPath_DivEqualsDataPath("pnlOfferValuesSysOffer pnlWarningScoreCardNotSetuped lblWarnScoreCardNotSetuped") + getXPath_ContainsWicketpath(ELEMENTS.DIV, "pnlWarningScoreCardNotSetuped_c_w_lblWarnScoreCardNotSetuped") + getXPath_HasADescendantSpanEqualsText("Score card was not fully set-up yet!");

    ILoanOfferToolSection loanOfferToolSectionHideUnhide(ACTION action);

    ILoanOfferToolSection selectLoanOfferVersion(String version);

    ILoanOfferToolSection clickEditReview();

    ILoanOfferToolSection clickReset();

    ILoanOfferToolSection clickSaveOffer();

    INewLoanOfferConditionDialog clickAddCondition();

    ILoanOfferToolSection addComment(String comment);

    IRiskToolSection clickSignReview();

    boolean isScoreWarningDisplayed();

    ILoanOfferToolSection selectLoanOfferVersionLatest();
}