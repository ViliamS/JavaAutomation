package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuoteQuickLoanSection {

    String

            DIRECT_SELECT = "/select",
            DIRECT_SPAN =   "/span",
            DIV =           "//div",
            DIRECT_DIV =    "/div",
            DIRECT_INPUT =  "/input",
            DIRECT_A =      "/a",

            BASIC_INFO_WICKET =             "[contains(@wicketpath,'BasicInfo')]",
            LOAN_PURPOSE_WICKET =           "[contains(@wicketpath,'LoanPurpose')]",
            COMBOBOX_WICKET =               "[contains(@wicketpath,'combobox')]",
            UNSECURED_LOAN_WICKET =         "[contains(@wicketpath,'UnsecuredLoanQuotation')]",
            NET_MONTHLY_INCOME_WICKET =     "[contains(@wicketpath,'NetMonthlyIncome')]",
            MONTHLY_EXPENSES_WICKET =       "[contains(@wicketpath,'MonthlyExpenses')]",
            NUMBER_OF_DEPENDENTS_WICKET =   "[contains(@wicketpath,'NumberOfDependents')]",
            AMOUNT_TO_BORROW_WICKET =       "[contains(@wicketpath,'AmountToBorrow')]",
            BTN_CONTINUE_WICKET =           "[contains(@wicketpath,'btnContinue')]",
            SUBMIT_WICKET =                 "[contains(@wicketpath,'submit')]",

            TEXT_BASIC_INFO =       "[text()='Basic info about you should give us.']",
            TEXT_UNSECURED_LOAN =   "[text()='Unsecured Loan']",
            TEXT_CONTINUE =         "[text()='Continue']",

            UNSECURED_LOAN_AREA =   DIV + UNSECURED_LOAN_WICKET + DIRECT_DIV    + UNSECURED_LOAN_WICKET,
            UNSECURED_LOAN_SPACE =  DIV + UNSECURED_LOAN_WICKET + DIV           + UNSECURED_LOAN_WICKET,

            //HEADER_TITLE_YES_I_LIKE_LOAN = UNSECURED_LOAN_AREA, // TODO: 09/02/16 is Missing in conflict with specification

            UNSECURED_LOAN_TITLE =          UNSECURED_LOAN_AREA     + DIRECT_SPAN                   + TEXT_UNSECURED_LOAN,
            BASIC_INFO_TITLE =              UNSECURED_LOAN_AREA     + BASIC_INFO_WICKET             + DIRECT_SPAN + TEXT_BASIC_INFO,
            LOAN_PURPOSE_SELECT_XPATH =     "//select[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanQuotation_c_w_cmbLoanPurpose_combobox']", //UNSECURED_LOAN_AREA     + LOAN_PURPOSE_WICKET           + DIRECT_SELECT + LOAN_PURPOSE_WICKET + COMBOBOX_WICKET,

            NET_MONTHLY_INCOME_INPUT =      UNSECURED_LOAN_SPACE    + NET_MONTHLY_INCOME_WICKET     + DIRECT_INPUT,
            MONTHLY_EXPENSES_INPUT =        UNSECURED_LOAN_SPACE    + MONTHLY_EXPENSES_WICKET       + DIRECT_INPUT,
            NUMBER_OF_DEPENDENTS_INPUT =    UNSECURED_LOAN_SPACE    + NUMBER_OF_DEPENDENTS_WICKET   + DIRECT_INPUT,
            AMOUNT_TO_BORROW_INPUT =        UNSECURED_LOAN_SPACE    + AMOUNT_TO_BORROW_WICKET       + DIRECT_INPUT,

            CONTINUE_TEAL_BUTTON_XPATH =    UNSECURED_LOAN_SPACE    + BTN_CONTINUE_WICKET + DIRECT_A + BTN_CONTINUE_WICKET + SUBMIT_WICKET + DIRECT_SPAN + TEXT_CONTINUE;

    //boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent();

   // boolean isSubHeaderUnsecuredLoanPresent();

  //  boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent();

    IQuoteQuickLoanPage setLoanPurpose(String loanPurposeType);

    IQuoteQuickLoanPage setNetMonthlyIncome(String netMonthlyIncome);

    IQuoteQuickLoanPage setMonthlyExpenses(String monthlyExpenses);

    IQuoteQuickLoanPage setNumberOfDependents(String numberOfDependents);

    IQuoteQuickLoanPage setAmountToBorrow(String amountToBorrow);

    IQuoteConfigurationPage clickContinue();

}
