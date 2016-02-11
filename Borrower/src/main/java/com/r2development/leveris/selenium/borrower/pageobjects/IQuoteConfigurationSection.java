package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IQuoteConfigurationSection {

    String
            // TODO : page is not programmed even from like 5% of functionality that should be if comparing it to the specification
            DIRECT_SPAN =   "/span",
            DIV =           "//div",
            DIRECT_DIV =    "/div",
            DIRECT_INPUT =  "/input",
            INPUT =         "//input",
            A = "//a",
            DIRECT_A =      "/a",
            H3 =            "//h3",
            DIRECT_H3 =     "/h3",

            UNSECURED_LOAN_CALCULATOR_WICKET =  "[contains(@wicketpath,'UnsecuredLoanCalculator')]",
            LOAN_AMOUNT_WICKET =                "[contains(@wicketpath,'txtAmount')]",
            MONTHLY_INSTALMENT_WICKET =         "[contains(@wicketpath,'MonthlyInstalment')]",

            TITLE_WICKET = "[contains(@wicketpath,'Title')]",
            MAIN_WICKET = "[contains(@wicketpath,'Main')]",
            MORTGAGE_CALC_WICKET = "[contains(@wicketpath,'MortgageCalc')]",


            CLASS_LOAN_VALID = "[@class='loan valid']",

            CLASS_REPAYMENT_VALID = "[@class='repayment valid']",

            ON_CLICK = "[contains(@onclick,'btnApplyOnline')]",


            CALCULATOR_AREA = DIV + UNSECURED_LOAN_CALCULATOR_WICKET + DIRECT_DIV + UNSECURED_LOAN_CALCULATOR_WICKET,

            LOAN_AMOUNT_INPUT = CALCULATOR_AREA + INPUT + LOAN_AMOUNT_WICKET,
            MONTHLY_INSTALMENT_INPUT = CALCULATOR_AREA + INPUT + MONTHLY_INSTALMENT_WICKET,

          //  HEADER_GREAT_AND_QUICK_LOAN_XPATH =             DIV,  // TODO missing in page

            TITLE_UNSECURED_LOAN_CALCULATOR_XPATH =         DIV + MAIN_WICKET + DIV + MAIN_WICKET + TITLE_WICKET + DIRECT_H3 + MAIN_WICKET + TITLE_WICKET + DIRECT_SPAN,
            TITLE_UNSECURED_LOAN_CALCULATOR_TEXT = "Unsecured loan calculator",



         //   SUB_TITLE_CONFIGURE_YOUR_LOAN_XPATH =           DIV,
            INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH =   DIV + MAIN_WICKET + MORTGAGE_CALC_WICKET + DIV + MAIN_WICKET + MORTGAGE_CALC_WICKET + INPUT + CLASS_LOAN_VALID,
            INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH =  DIV + MAIN_WICKET + MORTGAGE_CALC_WICKET + DIV + MAIN_WICKET + MORTGAGE_CALC_WICKET + INPUT + CLASS_REPAYMENT_VALID,
            APPLY_ONLINE_TEAL_BUTTON_XPATH =                DIV + MAIN_WICKET + MORTGAGE_CALC_WICKET + DIV + MAIN_WICKET + MORTGAGE_CALC_WICKET + A + ON_CLICK;
         //   CHANGE_PRODUCT_XPATH =                          DIV,
         //   TITLE_NUMBER_OF_REPAYMENTS_XPATH =              DIV,
          //  AMOUNT_NUMBER_OF_REPAYMENTS_XPATH =             DIV,
          //  TITLE_APR_XPATH =                               DIV,
          //  AMOUNT_APR_XPATH =                              DIV,
         //   TITLE_LAST_REPAYMENT_AMOUNT =                   DIV,
        //    AMOUNT_LAST_REPAYMENT_AMOUNT =                  DIV,
          //  TITLE_TOTAL_COST_OF_LOAN =                      DIV,
         //   AMOUNT_TOTAL_COST_OF_LOAN =                     DIV;

    IQuoteConfigurationPage setLoanAmountInput(String amountToBorrow);

//    String getLoanAmount();

    IQuoteConfigurationPage setMonthlyInstallmentInput(String monthlyRepayment);

//    String getMonthlyInstalmentAmount();

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
