package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuoteConfigurationSection {

    String
            // TODO : page is not programmed even from like 5% of functionality that should be if comparing it to the specification
            DIRECT_SPAN =   "/span",
            DIV =           "//div",
            DIRECT_DIV =    "/div",
            DIRECT_INPUT =  "/input",
            INPUT =         "//input",
            DIRECT_A =      "/a",

            UNSECURED_LOAN_CALCULATOR_WICKET =  "[contains(@wicketpath,'UnsecuredLoanCalculator')]",
            LOAN_AMOUNT_WICKET =                "[contains(@wicketpath,'txtAmount')]",
            MONTHLY_INSTALMENT_WICKET =         "[contains(@wicketpath,'MonthlyInstalment')]",

            CALCULATOR_AREA = DIV + UNSECURED_LOAN_CALCULATOR_WICKET + DIRECT_DIV + UNSECURED_LOAN_CALCULATOR_WICKET,

            LOAN_AMOUNT_INPUT = CALCULATOR_AREA + INPUT + LOAN_AMOUNT_WICKET,
            MONTHLY_INSTALMENT_INPUT = CALCULATOR_AREA + INPUT + MONTHLY_INSTALMENT_WICKET,

          //  HEADER_GREAT_AND_QUICK_LOAN_XPATH =             DIV,  // TODO missing in page
         //   TITLE_UNSECURED_LOAN_CALCULATOR_XPATH =         DIV,
         //   SUB_TITLE_CONFIGURE_YOUR_LOAN_XPATH =           DIV,
            INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH =   "//input[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanCalculator_c_w_pnlCalculator_c_w_txtAmount_tb']",
            INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH =  "//input[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanCalculator_c_w_pnlCalculator_c_w_txtMonthlyInstalment_tb']",
            APPLY_ONLINE_TEAL_BUTTON_XPATH =                "//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoanCalculator_c_w_btnApply_submit']";
         //   CHANGE_PRODUCT_XPATH =                          DIV,
         //   TITLE_NUMBER_OF_REPAYMENTS_XPATH =              DIV,
          //  AMOUNT_NUMBER_OF_REPAYMENTS_XPATH =             DIV,
          //  TITLE_APR_XPATH =                               DIV,
          //  AMOUNT_APR_XPATH =                              DIV,
         //   TITLE_LAST_REPAYMENT_AMOUNT =                   DIV,
        //    AMOUNT_LAST_REPAYMENT_AMOUNT =                  DIV,
          //  TITLE_TOTAL_COST_OF_LOAN =                      DIV,
         //   AMOUNT_TOTAL_COST_OF_LOAN =                     DIV;

    IQuoteConfigurationPage setAmountToBorrowInput(String amountToBorrow);

//    String getAmountToBorrow();

    IQuoteConfigurationPage setMonthlyRepaymentInput(String monthlyRepayment);

//    String getMonthlyRepayment();

//    boolean isHeaderGreatAndQuickLoanPresent();
//
//    boolean isTitleUnsecuredLoanCalculatorPresent();
//
//    boolean isTitleConfigureYourLoanPresent();
//
//    boolean isTitleNumberOfRepaymentsPresent();

//    String getNumberOfRepayments();

//    boolean isTitleLastRepaymentAmountPresent();

//    String getLastRepaymentAmount();

//    boolean isTitleAprPresent();

//    String getApr();

//    boolean isTitleTotalCostOfLoanPresent();

//    String getTotalCostOfLoan();

    IRegisterPage clickApplyOnline();

    IQuoteConfigurationPage clickChangeProduct();

//    boolean isChangeProductPresent();
}
