package com.r2development.leveris.selenium.borrower.pageobjects;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IQuoteLandingSection {

    String
            UNSECURED_LOAN_CONTINUE_BUTTON = getXPath_DivEqualsDataPath("pnlUnsecuredLoan pnlUnsecuredLoan0 btnContinue0") + getXPath_DirectAButtonContainsWicketpath("pnlUnsecuredLoan0_c_w_btnContinue0_submit") + getXPath_HasADescendantSpanEqualsText("Continue"),

            UNSECURED_LOAN_CONTINUE_BUTTON_TITLE = getXPath_DivEqualsDataPath("pnlUnsecuredLoan pnlUnsecuredLoan0 btnContinue0") + getXPath_DirectAButtonContainsWicketpath("pnlUnsecuredLoan0_c_w_btnContinue0_submit") + getXPath_DirectSpanEqualsText("Continue"),

            PAYDAY_LOAN_CONTINUE_BUTTON = getXPath_DivEqualsDataPath("pnlUnsecuredLoan pnlUnsecuredLoan1 btnContinue1") + getXPath_DirectAButtonContainsWicketpath("btnContinue1_submit") + getXPath_HasADescendantSpanEqualsText("Continue"),

            PAYDAY_LOAN_CONTINUE_BUTTON_TITLE = getXPath_DivEqualsDataPath("pnlUnsecuredLoan pnlUnsecuredLoan0 btnContinue0") + getXPath_DirectAButtonContainsWicketpath("pnlUnsecuredLoan0_c_w_btnContinue0_submit") + getXPath_DirectSpanEqualsText("Continue");

    IQuotePaydayLoanPage clickContinuePaydayLoan();
    IQuoteQuickLoanPage clickContinueUnsecuredLoan();
    boolean isHeaderGreatAndQuickLoanPresent();
    boolean isSubHeaderUnsecuredLoanPresent();
    boolean isLoanUpToLoanAmountPresent();
    boolean isHeaderPayDayLoanPresent();
    boolean isHeaderMortgagePresent();
    boolean isHeaderDebitConsolidationPresent();
    boolean isTitleFromAmountPerMonthPresent();
    boolean isFromAmountPerMonthEqualToValue(String expectedFromAmountPerMonth);
    String getValueLoanUpTo();
    String getPayDayLoanAmount();
    String getFromAmountPerMonthValue();

}
