package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IBorrowerBasicParameters {

    String HEADER_YES_I_WOULD_LIKE_GREAT_AND_QUICK_LOAN = "//div[@id='value']//h2[text()='Yes, I'd like a great and quick loan.']",
            SUB_HEADER_UNSECURED_LOAN_XPATH = "//div[@id='value']//h2[text()='Unsecured loan']",
            SUB_TITLE_BASIC_INFO_ABOUT_YOU_SHOULD_GIVE_US_XPATH = "//div[@id='value']//h2[text()='Basic info about you should give us.']",
            LOAN_PURPOSE_INPUT_DROP_DOWN_SELECT_XPATH = "//input[@id='input']",
            NET_MONTHLY_INCOME_INPUT_XPATH = "",
            MONTHLY_EXPENSES_INPUT_XPATH = "",
            NUMBER_OF_DEPENDENTS_INPUT_XPATH = "",
            AMOUNT_TO_BORROW_INPUT_XPATH = "",
            CONTINUE_TEAL_BUTTON_XPATH = "";

    boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent();

    boolean isSubHeaderUnsecuredLoanPresent();

    boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent();

    BorrowerBasicParametersSubSection loanPurposeSendKeys(String loanPurposeType);

    BorrowerBasicParametersSubSection netMonthlyIncomeSendKeys(String netMonthlyIncome);

    BorrowerBasicParametersSubSection monthlyExpensesSendKeys(String monthlyExpenses);

    BorrowerBasicParametersSubSection numberOfDependentsSendKeys(String numberOfDependents);

    BorrowerBasicParametersSubSection amountToBorrowSendKeys(String amountToBorrow);

    QuotationConfigurationPage clickContinue();

}
