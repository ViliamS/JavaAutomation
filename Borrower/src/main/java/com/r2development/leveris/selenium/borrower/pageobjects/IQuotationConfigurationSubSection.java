package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuotationConfigurationSubSection {

    String HEADER_GREAT_AND_QUICK_LOAN_XPATH = "//div[@id='value']//h2[text()='Yes, I'd like a great and quick loan.']",
            TITLE_UNSECURED_LOAN_CALCULATOR_XPATH = "//div[@id='value']//h2[text()='Unsecured loan calculator']",
            SUB_TITLE_CONFIGURE_YOUR_LOAN_XPATH = "//div[@id='value']//a[contains(text(),'Configure your loan')]",
            INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH = "//div[contains(text(),'Amount to borrow')]/input[@id='input']",
            INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH = "//div[contains(text(),'Monthly repayment')]/input[@id='input']",
            APPLY_ONLINE_TEAL_BUTTON_XPATH = "//div[@id='value']//button[@name='ApplyOnlineButton']",
            CHANGE_PRODUCT_XPATH = "//div[contains(text(),'Change product')]/div[@src='http://address']",
            TITLE_NUMBER_OF_REPAYMENTS_XPATH = "",
            AMOUNT_NUMBER_OF_REPAYMENTS_XPATH = "",
            TITLE_APR_XPATH = "",
            AMOUNT_APR_XPATH = "",
            TITLE_LAST_REPAYMENT_AMOUNT = "",
            AMOUNT_LAST_REPAYMENT_AMOUNT = "",
            TITLE_TOTAL_COST_OF_LOAN = "",
            AMOUNT_TOTAL_COST_OF_LOAN = "";

    QuotationConfigurationSubSection setAmountToBorrowInput(String amountToBorrow);

    String getAmountToBorrow();

    QuotationConfigurationSubSection setMonthlyRepaymentInput(String monthlyRepayment);

    String getMonthlyRepayment();

    boolean isHeaderGreatAndQuickLoanPresent();

    boolean isTitleUnsecuredLoanCalculatorPresent();

    boolean isTitleConfigureYourLoanPresent();

    boolean isTitleNumberOfRepaymentsPresent();

    String getNumberOfRepayments();

    boolean isTitleLastRepaymentAmountPresent();

    String getLastRepaymentAmount();

    boolean isTitleAprPresent();

    String getApr();

    boolean isTitleTotalCostOfLoanPresent();

    String getTotalCostOfLoan();

    QuotationConfigurationSubSection clickApplyOnline();

    QuotationConfigurationSubSection clickChangeProduct();

    boolean isChangeProductPresent();
}
