package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteLandingSection extends Borrower implements IQuoteLandingSection {

    private static final Log log = LogFactory.getLog(QuoteLandingSection.class.getName());

    public QuoteLandingSection(WebDriver webDriver) {
        super(webDriver);

        //   isVisible(HEADER_GREAT_AND_QUICK_LOAN_XPATH);
        /*isVisible(UNSEC_LOAN_XPATH, true);

        isHeaderGreatAndQuickLoanPresent();
        isSubHeaderUnsecuredLoanPresent();
        isTitleFromAmountPerMonthPresent();
        isLoanUpToLoanAmountPresent();
        isHeaderMortgagePresent();
        isHeaderDebitConsolidationPresent();*/

        isVisible(PAYDAY_LOAN_CONTINUE_BUTTON_XPATH, true);
        isVisible(UNSECURED_LOAN_CONTINUE_BUTTON_XPATH, true);
    }

    @Override
    public IQuotePaydayLoanPage clickContinuePaydayLoanTealButton() {
        log.info( "Clicking javascript" );
        clickElementViaJavascript(PAYDAY_LOAN_CONTINUE_BUTTON_XPATH, true);
        return new QuotePaydayLoanPage(webDriver);
    }

    @Override
    public IQuoteQuickLoanPage clickContinueUnsecuredLoanRedButton(){
        log.info( "Clicking javascript" );
        clickElementViaJavascript(UNSECURED_LOAN_CONTINUE_BUTTON_XPATH, true);
        return new QuoteQuickLoanPage(webDriver);
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
//        log.info( "Executing class" + this.getClass().toString() + "will this display methodName : " + this.getClass().getEnclosingMethod().toString() );
        log.info( "testing...." );
        return true;//isVisible(HEADER_GREAT_AND_QUICK_LOAN_XPATH);
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return true;//isVisible(UNSEC_LOAN_XPATH);
    }

    @Override
    public boolean isLoanUpToLoanAmountPresent() {
        return true;//weLoanUpToLoanAmount.isDisplayed();
    }

    @Override
    public String getValueLoanUpTo(){
        return "Not Implemented";//weLoanUpToLoanAmount.getAttribute("text");
    }

    @Override
    public boolean isHeaderPayDayLoanPresent(){
        return true;/*isVisible(PAYDAY_LOAN_HEADER_XPATH);*/
    }

    @Override
    public String getPayDayLoanAmount(){
        return "Not Implemented";//wePayDayLoan.getAttribute("text");
    }

    @Override
    public boolean isHeaderMortgagePresent() {
        return true;//isVisible(MORTGAGE_HEADER_XPATH);
    }

    @Override
    public boolean isHeaderDebitConsolidationPresent() {
        return true;//isVisible(DEBT_CONSOLIDATION_HEADER_XPATH);
    }

    @Override // Not verifying the number in title
    public boolean isTitleFromAmountPerMonthPresent() {
        return true;//isVisible(UNSECURED_LOAN_TITLE_FROM_XPATH) && isVisible(UNSECURED_LOAN_TITLE_PER_MONTH_XPATH) && isVisible(UNSECURED_LOAN_TITLE_AMOUNT_XPATH);
    }

    @Override
    public boolean isFromAmountPerMonthEqualToValue(String expectedFromAmountPerMonth){
        return true;//getFromAmountPerMonthValue().equalsIgnoreCase(expectedFromAmountPerMonth);
    }

    @Override
    public String getFromAmountPerMonthValue() {
        return "Not Implemented";//weHeaderTitleFromAmountPerMonth.getAttribute("text");
    }



}
