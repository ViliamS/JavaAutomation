package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface ISetScoreOverrideDialog {

    String SET_SCORE_OVERRIDE_TITLE = getXPath_DivEqualsDataPath("pnlSetScoreOverride lblSetScoreOverride") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlSetScoreOverride_c_w_lblSetScoreOverride") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Set score override");

    String VALUE_INPUT = getXPath_DivEqualsDataPath("pnlSetScoreOverride txtScoreOverride") + getXPath_HasADescendantLabelEqualsText("Value") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlSetScoreOverride_c_w_txtScoreOverride");

    String NOTE_INPUT = getXPath_DivEqualsDataPath("pnlSetScoreOverride txaNote") + getXPath_HasADescendantLabelEqualsText("Note") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.TEXTAREA, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlSetScoreOverride_c_w_txaNote_textarea");

    String CANCEL_BUTTON = getXPath_DivEqualsDataPath("pnlSetScoreOverride btnCancel") + getXPath_DirectAButtonContainsWicketpath("pnlSetScoreOverride_c_w_btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");

    String SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlSetScoreOverride btnSave") + getXPath_DirectAButtonContainsWicketpath("pnlSetScoreOverride_c_w_btnSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");

    String DELETE_ALL_BUTTON = getXPath_DivEqualsDataPath("pnlSetScoreOverride btnDeleteBoth") + getXPath_DirectAButtonContainsWicketpath("pnlSetScoreOverride_c_w_btnDeleteBoth_submit") + getXPath_HasADescendantSpanEqualsText("Delete all");

    String DELETE_SCORE = getXPath_DivEqualsDataPath("pnlSetScoreOverride btnDelete") + getXPath_DirectAButtonContainsWicketpath("pnlSetScoreOverride_c_w_btnDelete_submit") + getXPath_HasADescendantSpanEqualsText("Delete score");

    ISetScoreOverrideDialog setValue(String value);
    ISetScoreOverrideDialog setNote(String value);
    IRiskToolSection clickSave();
    IRiskToolSection clickCancel();
    IRiskToolSection clickDeleteAll();
    IRiskToolSection clickDeleteScore();


}
