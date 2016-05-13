package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface ISetFraudDialog {

    String SET_FRAUD_DIALOG = getXPath_DivEqualsDataPath("pnlFraud");

    String SET_FRAUD_TITLE = getXPath_DivEqualsDataPath("pnlFraud lblFraud") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlFraud_c_w_lblFraud") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Set Fraud");

    String FRAUD_COMBOBOX_INPUT = getXPath_DivEqualsDataPath("pnlFraud cmbFraud") + getXPath_HasADescendantLabelEqualsText("Fraud") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlFraud_c_w_cmbFraud");

    String TICKET_ID_INPUT = getXPath_DivEqualsDataPath("pnlFraud txtTiketId") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, "Ticket Id") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlFraud_c_w_txtTiketId");

    String COMMENT_INPUT = getXPath_DivEqualsDataPath("pnlFraud txaDescription") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, "Comment") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlFraud_c_w_txaDescription_textarea");

    String CANCEL_BUTTON = getXPath_DivEqualsDataPath("pnlFraud btnCancel") + getXPath_DirectAButtonContainsWicketpath("pnlFraud_c_w_btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");

    String SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlFraud btnSave") + getXPath_DirectAButtonContainsWicketpath("pnlFraud_c_w_btnSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");

    ISetFraudDialog setFraud(String value);

    ISetFraudDialog setTickedId(String value);

    ISetFraudDialog setComment(String value);

    IRiskToolSection clickCancel();

    IRiskToolSection clickSave();
}