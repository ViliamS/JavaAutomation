package com.r2development.leveris.selenium.borrower.pageobjects;

/**
 * todo Page Object Specific Implementation
 */
public interface IQuoteLandingPage {

    String  DEFAULT_ENVIRONMENT = "http://dv2app.opoqodev.com/stable-borrower",
            DEFAULT_ENVIRONMENT_VARIABLE = "borrower";

    IQuoteLandingPage goToBorrowerQuoteLandingPage();

    IQuoteQuickLoanPage clickContinuePaydayLoanTealButton();

    IQuoteQuickLoanPage clickContinueUnsecuredLoanRedButton();

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
