package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuotePaydayLoanSection {

    String

    DIRECT_SELECT = "/select",
    DIRECT_SPAN =   "/span",
    DIV =           "//div",
    DIRECT_DIV =    "/div",
    DIRECT_INPUT =  "/input",
    INPUT =         "//input",
    DIRECT_A =      "/a",

    NOT_DISABLED = "[not(contains(@disabled,'disabled'))]",

    BASIC_INFO_WICKET =             "[contains(@wicketpath,'BasicInfo')]",
    LOAN_PURPOSE_WICKET =           "[contains(@wicketpath,'LoanPurpose')]",
    COMBOBOX_WICKET =               "[contains(@wicketpath,'combobox')]",
    UNSECURED_LOAN_WICKET =         "[contains(@wicketpath,'UnsecuredLoanQuotation')]",
    NET_MONTHLY_INCOME_WICKET =     "[contains(@wicketpath,'NetMonthlyIncome')]",
    MONTHLY_EXPENSES_WICKET =       "[contains(@wicketpath,'MonthlyExpenses')]",
    NUMBER_OF_DEPENDENTS_WICKET =   "[contains(@wicketpath,'NumberOfDependents')]",
    AMOUNT_TO_BORROW_WICKET =       "[contains(@wicketpath,'AmountToBorrow')]",
    BTN_CONTINUE_WICKET =           "[contains(@wicketpath,'Continue')]",
    SUBMIT_WICKET =                 "[contains(@wicketpath,'submit')]",

    TEXT_BASIC_INFO =       "[text()='Basic info about you should give us.']",
    TEXT_UNSECURED_LOAN =   "[text()='Unsecured Loan']",
    TEXT_CONTINUE =         "[text()='Continue']",

    UNSECURED_LOAN_AREA =   DIV + UNSECURED_LOAN_WICKET + DIRECT_DIV    + UNSECURED_LOAN_WICKET,
    UNSECURED_LOAN_SPACE =  DIV + UNSECURED_LOAN_WICKET + DIV           + UNSECURED_LOAN_WICKET,

    //HEADER_TITLE_YES_I_LIKE_LOAN = UNSECURED_LOAN_AREA, // TODO: 09/02/16 is Missing in conflict with specification

    UNSECURED_LOAN_TITLE =          UNSECURED_LOAN_AREA     + DIRECT_SPAN                   + TEXT_UNSECURED_LOAN,
    BASIC_INFO_TITLE =              UNSECURED_LOAN_AREA     + BASIC_INFO_WICKET             + DIRECT_SPAN + TEXT_BASIC_INFO,

    DROP_DOWN_LIST = "//ul[contains(@style,'display: block')][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']",

    LOAN_PURPOSE_XPATH =            UNSECURED_LOAN_SPACE    + LOAN_PURPOSE_WICKET           + INPUT + LOAN_PURPOSE_WICKET               + NOT_DISABLED,
    NET_MONTHLY_INCOME_INPUT =      UNSECURED_LOAN_SPACE    + NET_MONTHLY_INCOME_WICKET     + INPUT + NET_MONTHLY_INCOME_WICKET         + NOT_DISABLED,
    MONTHLY_EXPENSES_INPUT =        UNSECURED_LOAN_SPACE    + MONTHLY_EXPENSES_WICKET       + INPUT + MONTHLY_EXPENSES_WICKET           + NOT_DISABLED,
    NUMBER_OF_DEPENDENTS_INPUT =    UNSECURED_LOAN_SPACE    + NUMBER_OF_DEPENDENTS_WICKET   + INPUT + NUMBER_OF_DEPENDENTS_WICKET       + NOT_DISABLED,
    AMOUNT_TO_BORROW_INPUT =        UNSECURED_LOAN_SPACE    + AMOUNT_TO_BORROW_WICKET       + DIRECT_INPUT + AMOUNT_TO_BORROW_WICKET    + NOT_DISABLED,

    CONTINUE_TEAL_BUTTON_XPATH =    UNSECURED_LOAN_SPACE    + BTN_CONTINUE_WICKET + DIRECT_A + BTN_CONTINUE_WICKET + SUBMIT_WICKET + DIRECT_SPAN + TEXT_CONTINUE;
//    CONTINUE_TEAL_BUTTON_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanQuotation_c_w_btnContinue_submit']";

    boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent();

    boolean isSubHeaderUnsecuredLoanPresent();

    boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent();

    IQuotePaydayLoanSection setLoanPurpose(String loanPurposeType);

    IQuotePaydayLoanSection setNetMonthlyIncome(String netMonthlyIncome);

    IQuotePaydayLoanSection setMonthlyExpenses(String monthlyExpenses);

    IQuotePaydayLoanSection setNumberOfDependents(String numberOfDependents);

    IQuotePaydayLoanSection setAmountToBorrow(String amountToBorrow);

    IQuoteConfigurationPage clickContinue();

}
