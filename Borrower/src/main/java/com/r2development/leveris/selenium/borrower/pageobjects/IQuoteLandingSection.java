package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuoteLandingSection {

    String

            UNSECURED_LOAN_XPATH =                  "//div[contains(@wicketpath,'UnsecuredLoan')]",
            DIRECT_DIV_UNSEC =                      "/div[contains(@wicketpath,'UnsecuredLoan')]",
            UNSECURED_LOAN_SMALL_CONTINUE =         "/div[contains(@wicketpath,'UnsecuredLoan')]//div[contains(@wicketpath,'btnContinue')]",
            PAYDAY_LOAN_AREA =                      "/div[contains(@wicketpath,'UnsecuredLoan') and contains(@wicketpath,'PaydayLoan')]",
            DIR_DESC_SPAN =                         "/span",
            SPAN_TEXT_FROM =                        "/span[text()='from']",
            SPAN_TEXT_PER_MONTH =                   "/span[text()='per month']",
            SPAN_TEXT_UNSECURED_LOAN =              "/span[text()='Unsecured Loan']",
            SPAN_TEXT_UP_TO =                       "/span[text()='Up to']",
            SPAN_TEXT_PAYDAY_LOAN =                 "/span[text()='Payday loan']",
            SPAN_TEXT_MORTGAGE =                    "//span[text()='Mortgage']",
            SPAN_TEXT_DEBT_CONSOLIDATION =          "//span[text()='Debt consolidation']",
            DIV_CONTAINS_BTN_CONTINUE =             "//div[contains(@wicketpath,'Continue')]",
            UP_UP_PRECEDING_SIBLING_FIRST_DIV =     "/../../preceding-sibling::div[1]",
            CONTAINS_WICKETPATH_MORTGAGE =          "[contains(@wicketpath,'Mortgage')]",
            CONTAINS_WICKETPATH_LBLAMOUNT =         "[contains(@wicketpath,'lblAmount')]",
            CONTAINS_WICKETPATH_DEBT_CONS =         "[contains(@wicketpath,'DebitConsolidation')]",
            CONTAINS_WICKETPATH_UNSECURED_LOAN =    "[contains(@wicketpath,'UnsecuredLoan')]",

            A_CONTINUE = "[not(contains(@class,'green'))]/a[contains(@wicketpath,'Continue')]",
            A_CONTINUE2 = "[contains(@class,'green')]/a[contains(@wicketpath,'Continue')]",

            HEADER_GREAT_AND_QUICK_LOAN_XPATH =     UNSECURED_LOAN_XPATH, // TODO: 09/02/16  - This Header is missing compared with specification

         /*   DIV_FOLLOWING_XPATH =                   UNSECURED_LOAN_XPATH            + DIRECT_DIV_UNSEC,
            UNSECURED_LOAN_TITLE_PER_MONTH_XPATH =  DIV_FOLLOWING_XPATH             + SPAN_TEXT_PER_MONTH,
            UNSECURED_LOAN_TITLE_FROM_XPATH =       DIV_FOLLOWING_XPATH             + SPAN_TEXT_FROM,
            UNSECURED_LOAN_TITLE_AMOUNT_XPATH =     UNSECURED_LOAN_TITLE_FROM_XPATH + UP_UP_PRECEDING_SIBLING_FIRST_DIV + CONTAINS_WICKETPATH_UNSECURED_LOAN + DIRECT_DIV_UNSEC + DIR_DESC_SPAN,
            UNSECURED_LOAN_SUB_HEADER_XPATH =       DIV_FOLLOWING_XPATH             + SPAN_TEXT_UNSECURED_LOAN,
            LOAN_UP_TO_LOAN_AMOUNT_XPATH =          DIV_FOLLOWING_XPATH             + SPAN_TEXT_UP_TO + UP_UP_PRECEDING_SIBLING_FIRST_DIV + CONTAINS_WICKETPATH_UNSECURED_LOAN + DIRECT_DIV_UNSEC + DIR_DESC_SPAN,
            */
            UNSECURED_LOAN_CONTINUE_BUTTON_XPATH =  UNSECURED_LOAN_XPATH            + UNSECURED_LOAN_SMALL_CONTINUE + A_CONTINUE,

/*
            PAYDAY_LOAN_PANEL_XPATH =               UNSECURED_LOAN_XPATH            + PAYDAY_LOAN_AREA,
*/

            PAYDAY_LOAN_CONTINUE_BUTTON_XPATH =     UNSECURED_LOAN_XPATH            + UNSECURED_LOAN_SMALL_CONTINUE + A_CONTINUE2;

            /*PAYDAY_LOAN_HEADER_XPATH =              PAYDAY_LOAN_PANEL_XPATH         + SPAN_TEXT_PAYDAY_LOAN,
            PAYDAY_LOAN_AMOUNT_XPATH =              PAYDAY_LOAN_PANEL_XPATH         + CONTAINS_WICKETPATH_LBLAMOUNT + DIR_DESC_SPAN,
            MORTGAGE_PANEL_XPATH =                  UNSECURED_LOAN_XPATH            + CONTAINS_WICKETPATH_MORTGAGE,
            MORTGAGE_HEADER_XPATH =                 MORTGAGE_PANEL_XPATH            + SPAN_TEXT_MORTGAGE,
            DEBT_CONSOLIDATION_PANEL_XPATH =        UNSECURED_LOAN_XPATH            + CONTAINS_WICKETPATH_DEBT_CONS,
            DEBT_CONSOLIDATION_HEADER_XPATH =       DEBT_CONSOLIDATION_PANEL_XPATH  + SPAN_TEXT_DEBT_CONSOLIDATION;*/

    IQuotePaydayLoanPage clickContinuePaydayLoanTealButton();
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
