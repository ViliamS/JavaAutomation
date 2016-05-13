package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IAddNoteDialog {

    String ADD_NOTE_TITLE = getXPath_DivEqualsDataPath("pnlAddNote lblAddNote") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlAddNote_c_w_lblAddNote") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Add note");
    String NOTE_INPUT = getXPath_DivEqualsDataPath("pnlAddNote txaNote") + getXPath_HasADescendantLabelEqualsText("Note") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlAddNote_c_w_txaNote_textarea");

    String CANCEL_BUTTON = getXPath_DivEqualsDataPath("pnlAddNote btnCancel") + getXPath_DirectAButtonContainsWicketpath("pnlAddNote_c_w_btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");
    String SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlAddNote btnSave") + getXPath_DirectAButtonContainsWicketpath("pnlAddNote_c_w_btnSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");

    IAddNoteDialog setNote(String value);
    IRiskToolSection clickCancel();
    IRiskToolSection clickSave();

}
