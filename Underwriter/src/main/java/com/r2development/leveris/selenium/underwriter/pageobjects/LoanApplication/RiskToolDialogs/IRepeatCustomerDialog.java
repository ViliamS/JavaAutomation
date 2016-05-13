package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.IRiskToolSection;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IRepeatCustomerDialog {

    String REEPEAT_CUSTOMER_DIALOG = getXPath_DivEqualsDataPath("pnlRepeatCustomer");

    String REPEAT_CUSTOMER_TITLE = getXPath_DivEqualsDataPath("pnlRepeatCustomer lblRepeatCustomer") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlRepeatCustomer_c_w_lblRepeatCustomer") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Repeat Customer");

    String REPEAT_CUSTOMER_INPUT = getXPath_DivEqualsDataPath("pnlRepeatCustomer txtRepeatCustomer") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlRepeatCustomer_c_w_txtRepeatCustomer");

    String CANCEL_BUTTON = getXPath_DivEqualsDataPath("pnlRepeatCustomer btnCancel") + getXPath_DirectAButtonContainsWicketpath("pnlRepeatCustomer_c_w_btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");

    String SAVE_BUTTON = getXPath_DivEqualsDataPath("pnlRepeatCustomer btnSave") + getXPath_DirectAButtonContainsWicketpath("pnlRepeatCustomer_c_w_btnSave_submit") + getXPath_HasADescendantSpanEqualsText("Save");

    IRepeatCustomerDialog setRepeatCustomerInput(String value);

    IRiskToolSection clickCancel();

    IRiskToolSection clickSave();

}
