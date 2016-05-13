package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs.*;
import com.r2development.leveris.utils.XpathBuilder.Enums.*;
import com.r2development.leveris.utils.XpathBuilder.XPathValues;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IRiskToolSection {

    String RISK_TOOL_TAB = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_7");
    String RISK_TOOL_PANEL_TITLE = RISK_TOOL_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Risk Tool") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_7_header");

    String RISK_TOOL_PANEL_HIDE = RISK_TOOL_TAB + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "collapse");
    String RISK_TOOL_PANEL_HIDDEN = RISK_TOOL_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none");
    String RISK_TOOL_PANEL_NOT_HIDDEN = RISK_TOOL_PANEL_HIDE + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.STYLE, "display: none");

    String KYC_CHECK_MANUALLY_UPDATE_CHECKBOX =             getXPath_DivEqualsDataPath("pnlMain pnlManualKYC chkKycManualSwitch") + getXPath_HasADescendantLabelEqualsText("Manually update") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.ID, "checkbox");

    String KYC_CHECK_TITLE = getXPath_DivEqualsDataPath("pnlMain lblKycTitle") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.H3, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlMain_c_w_lblKycTitle") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "KYC Check");
    String KYC_TABLE_FIRST_ROW_STATUS_COMBOBOX = getXPath(ELEMENTS.TD, ACTIONS.EQUALS, ATTRIBUTES.DATA_PATH, "pnlMain pnlManualKYC tblKycTable 0 cmbStatus") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.AND_CONTAINS, ATTRIBUTES.WICKETPATH, new XPathValues("pnlManualKYC", "tblKycTable", "cmbStatus"));
    String KYC_SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlMain pnlManualKYC btnManualSave") + getXPath_DirectAButtonContainsWicketpath("pnlManualKYC_c_w_btnManualSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");

    String SET_FICO_BUTTON = getXPath_DivEqualsDataPath("pnlMain pnlScoreCard btnSetFico") + getXPath_DirectAButtonContainsWicketpath("pnlScoreCard_c_w_btnSetFico_dialog") + getXPath_HasADescendantSpanEqualsText("Set FICO");
    String SET_AML_BUTTON = getXPath_DivEqualsDataPath("pnlMain pnlScoreCard btnSetAML") + getXPath_DirectAButtonContainsWicketpath("pnlScoreCard_c_w_btnSetAML_dialog") + getXPath_HasADescendantSpanEqualsText("Set AML");
    String SET_FRAUD_BUTTON = getXPath_DivEqualsDataPath("pnlMain pnlScoreCard btnSetFraud") + getXPath_DirectAButtonContainsWicketpath("pnlScoreCard_c_w_btnSetFraud_dialog") + getXPath_HasADescendantSpanEqualsText("Set Fraud");
    String SET_REP_CUSTOMER_BUTTON = getXPath_DivEqualsDataPath("pnlMain pnlScoreCard btnSetRepCustomer") + getXPath_DirectAButtonContainsWicketpath("pnlScoreCard_c_w_btnSetRepCustomer_dialog") + getXPath_HasADescendantSpanEqualsText("Set rep. customer");
    String SET_SCORE_OVERRIDE_BUTTON = getXPath_DivEqualsDataPath("pnlMain pnlScoreCard btnSetScoreOverride") + getXPath_DirectAButtonContainsWicketpath("pnlScoreCard_c_w_btnSetScoreOverride_dialog") + getXPath_HasADescendantSpanEqualsText("Set score override");
    String SET_NOTE_BUTTON = getXPath_DivEqualsDataPath("pnlMain pnlScoreCard btnSetNote") + getXPath_DirectAButtonContainsWicketpath("pnlScoreCard_c_w_btnSetNote_dialog") + getXPath_HasADescendantSpanEqualsText("Set note");


    IRiskToolSection setStatusDropDown(String value);

    IRiskToolSection riskToolSectionHideUnhide(ACTION action);

    IRiskToolSection setManuallyUpdateCheckbox(ACTION checkUncheck);

    IRiskToolSection clickSaveKYC();

    ISetFICODialog clickSetFICO();

    ISetAMLDialog clickSetAML();

    ISetFraudDialog clickSetFraud();

    IRepeatCustomerDialog clickSetRepCustomer();

    ISetScoreOverrideDialog clickSetScoreOverride();

    IAddNoteDialog clickSetNote();

}
