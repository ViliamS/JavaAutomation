package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface ISetFICODialog {

    String SET_FICO_DIALOG = getXPath_DivEqualsDataPath("pnlSetFico");
    String SET_FICO_TITLE = getXPath_DivEqualsDataPath("pnlSetFico lblNazev") + getXPath_HasADescendantSpanEqualsText("Set FICO");

    String FICO_INPUT = getXPath_DivEqualsDataPath("pnlSetFico txtFico") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "FICO") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlSetFico_c_w_txtFico");
    String TICKET_ID_INPUT = getXPath_DivEqualsDataPath("pnlSetFico txtExternalId") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, "Ticket Id") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlSetFico_c_w_txtExternalId");
    String COMMENT_INPUT = getXPath_DivEqualsDataPath("pnlSetFico txaDescription") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, "Comment") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlSetFico_c_w_txaDescription_textarea");

    String SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlSetFico btnSave") + getXPath_DirectAButtonContainsWicketpath("pnlSetFico_c_w_btnSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");
    String CANCEL_BUTTON = getXPath_DivEqualsDataPath("pnlSetFico btnCancel") + getXPath_DirectAButtonContainsWicketpath("pnlSetFico_c_w_btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");

    ISetFICODialog setFICO(String value);

    ISetFICODialog setTicketID(String value);

    ISetFICODialog setComment(String value);

    IRiskToolSection clickSave();

    IRiskToolSection clickCancel();
}