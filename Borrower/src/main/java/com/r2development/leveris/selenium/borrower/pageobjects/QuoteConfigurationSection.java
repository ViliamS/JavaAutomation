package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo LandingPageStepDef Specific Implementation
 */
public class QuoteConfigurationSection extends Borrower implements IQuoteConfigurationSection {

    private static final Log log = LogFactory.getLog(QuoteConfigurationSection.class.getName());

    public QuoteConfigurationSection(WebDriver webDriver){
        super(webDriver);
/*        PageFactory.initElements(webDriver, this);
        isHeaderGreatAndQuickLoanPresent();
        isTitleUnsecuredLoanCalculatorPresent();
        isTitleConfigureYourLoanPresent();*/
        isVisible(INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH);
        isVisible(INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH);
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
        isVisible(APPLY_ONLINE_TEAL_BUTTON_XPATH);
        //clickElement(APPLY_ONLINE_TEAL_BUTTON_XPATH);
        return new RegisterPage(webDriver);
    }

    @Override
    public IQuoteConfigurationPage clickChangeProduct(){
//        isVisible(CHANGE_PRODUCT_XPATH);
//        clickElement(CHANGE_PRODUCT_XPATH);
        return new QuoteConfigurationPage(webDriver);
    }

    @Override
    public IQuoteConfigurationPage setAmountToBorrowInput(String amountToBorrow) {
        isVisible(INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH);
        type(INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH, amountToBorrow);
        return new QuoteConfigurationPage(webDriver);
    }

//    @Override
//    public String getAmountToBorrow (){
//        return weInputAmountToBorrowSliderControl.getAttribute("value");
//    }

    @Override
    public IQuoteConfigurationPage setMonthlyRepaymentInput(String monthlyRepayment){
        type(INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH, monthlyRepayment);
        return new QuoteConfigurationPage(webDriver);
    }

//    @Override
//    public String getMonthlyRepayment(){
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
