package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface ISetAMLDialog {

    String SET_AML_DIALOG = getXPath_DivEqualsDataPath("pnlAml");

    String AML_COMBOBOX = getXPath_DivEqualsDataPath("pnlAml cmbValue") + getXPath_HasADescendantLabelEqualsText("AML") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlAml_c_w_cmbValue");
    String TICKET_ID_INPUT = getXPath_DivEqualsDataPath("pnlAml txtTicketId") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, "Ticket Id") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlAml_c_w_txtTicketId");
    String COMMENT_INPUT = getXPath_DivEqualsDataPath("pnlAml txaDescription") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, "Comment") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txaDescription_textarea");

    String SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlAml btnSave") + getXPath_DirectAButtonContainsWicketpath("pnlAml_c_w_btnSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");
    String CANCEL_BUTTON = getXPath_DivEqualsDataPath("pnlAml btnCancel") + getXPath_DirectAButtonContainsWicketpath("pnlAml_c_w_btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");

    ISetAMLDialog setAMLcombobox(String value);

    ISetAMLDialog setTicketId(String value);

    ISetAMLDialog setComment(String value);

    IRiskToolSection clickCancel();

    IRiskToolSection clickSave();
}