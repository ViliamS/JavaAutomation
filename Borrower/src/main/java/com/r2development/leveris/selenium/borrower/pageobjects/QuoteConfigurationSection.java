package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QuoteConfigurationSection extends Borrower implements IQuoteConfigurationSection {

    private static final Log log = LogFactory.getLog(QuoteConfigurationSection.class.getName());

//    @Inject
    public QuoteConfigurationSection(SharedDriver webDriver){
        super(webDriver);
/*        PageFactory.initElements(webDriver, this);
        isHeaderGreatAndQuickLoanPresent();
        isTitleUnsecuredLoanCalculatorPresent();
        isTitleConfigureYourLoanPresent();*/
//        //isVisible(TITLE_UNSECURED_LOAN_CALCULATOR_XPATH, true);
//        isVisible(TITLE_UNSECURED_LOAN_CALCULATOR_XPATH + "[text()='" + TITLE_UNSECURED_LOAN_CALCULATOR_TEXT + "']");

//        //isVisible(INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH, true);
//        //isVisible(INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH, true);
//        //isVisible(APPLY_ONLINE_TEAL_BUTTON_XPATH, true);
       /* isVisible(APPLY_ONLINE_TEAL_BUTTON_XPATH);
        isChangeProductPresent();
        isTitleNumberOfRepaymentsPresent();
        isVisible(AMOUNT_NUMBER_OF_REPAYMENTS_XPATH);
        isTitleAprPresent();
        isVisible(AMOUNT_APR_XPATH);
        isTitleLastRepaymentAmountPresent();
        isVisible(AMOUNT_LAST_REPAYMENT_AMOUNT);
        isTitleTotalCostOfLoanPresent();
        isVisible(AMOUNT_TOTAL_COST_OF_LOAN);*/
    }

    @Override
    public IRegisterPage clickApplyOnline(){
        log.info("APPLY ONLINE");
        loadingCheck();
        isVisible(APPLY_ONLINE_TEAL_BUTTON_XPATH2, 1);

        if(System.getProperty("browser").equalsIgnoreCase(SharedDriver.PHANTOMJS))
            clickElement(APPLY_ONLINE_TEAL_BUTTON_XPATH2);
        else
            clickElementViaJavascript(APPLY_ONLINE_TEAL_BUTTON_XPATH2, false);

        loadingCheck();
        return new RegisterPage(webDriver);
    }

    @Override
    public IQuoteConfigurationPage clickChangeProduct(){
//        isVisible(CHANGE_PRODUCT_XPATH);
//        clickElement(CHANGE_PRODUCT_XPATH);
        return new QuoteConfigurationPage(webDriver);
    }

    @Override
    public IQuoteConfigurationSection setLoanAmountInput(String amountToBorrow) {
        loadingCheck();
        isVisible(INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH, 1);
        typeEndWithTab(INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH, amountToBorrow, true);
//        webDriver.findElement(By.xpath(INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH)).sendKeys(Keys.TAB);
        return this;
    }

//    @Override
//    public String getLoanAmount (){
//        return weInputAmountToBorrowSliderControl.getAttribute("value");
//    }

    @Override
    public IQuoteConfigurationSection setMonthlyInstallmentInput(String monthlyRepayment){
        loadingCheck();
        isVisible(INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH, 1);
        typeEndWithTab(INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH, monthlyRepayment, true);
        return this;
    }

//    @Override
//    public String getMonthlyInstalmentAmount(){
//        return weInputMonthlyRepaymentSliderControl.getAttribute("value");
//    }

//    @Override
//    public boolean isHeaderGreatAndQuickLoanPresent(){
//        return isVisible(HEADER_GREAT_AND_QUICK_LOAN_XPATH);
//    }
//
//    @Override
//    public boolean isTitleUnsecuredLoanCalculatorPresent(){
//        return isVisible(TITLE_UNSECURED_LOAN_CALCULATOR_XPATH);
//    }
//
//    @Override
//    public boolean isTitleConfigureYourLoanPresent(){
//        return isVisible(SUB_TITLE_CONFIGURE_YOUR_LOAN_XPATH);
//    }
//
//    @Override
//    public boolean isTitleNumberOfRepaymentsPresent(){
//        return isVisible(TITLE_NUMBER_OF_REPAYMENTS_XPATH);
//    }

//    @Override
//    public String getNumberOfRepayments(){
//        return weAmountNumberOfRepayments.getAttribute("text");
//    }

//    @Override
//    public boolean isTitleLastRepaymentAmountPresent(){
//        return isVisible(TITLE_LAST_REPAYMENT_AMOUNT);
//    }

//    @Override
//    public String getLastRepaymentAmount(){
//        return weAmountLastRepaymentAmount.getAttribute("text");
//    }

//    @Override
//    public boolean isTitleAprPresent(){
//        return isVisible(TITLE_APR_XPATH);
//    }

//    @Override
//    public String getApr(){
//        return weAmountAPR.getAttribute("text");
//    }

//    @Override
//    public boolean isTitleTotalCostOfLoanPresent(){
//        return isVisible(TITLE_TOTAL_COST_OF_LOAN);
//    }

//    @Override
//    public String getTotalCostOfLoan(){
//        return weAmountTotalCostOfLoan.getAttribute("text");
//    }
//
//    @Override
//    public boolean isChangeProductPresent(){
//        return isVisible(CHANGE_PRODUCT_XPATH);
//    }
}