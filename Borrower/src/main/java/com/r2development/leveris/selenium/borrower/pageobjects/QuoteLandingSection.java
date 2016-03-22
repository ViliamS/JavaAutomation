package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QuoteLandingSection extends Borrower implements IQuoteLandingSection {

    private static final Log log = LogFactory.getLog(QuoteLandingSection.class.getName());

//    @Inject
    public QuoteLandingSection(SharedDriver webDriver) {
        super(webDriver);
    }

    @Override
    public IQuotePaydayLoanPage clickContinuePaydayLoanTealButton() {
        if(System.getProperty("browser").equalsIgnoreCase(SharedDriver.PHANTOMJS))
            clickElement(PAYDAY_LOAN_CONTINUE_BUTTON_XPATH);
        else
            clickElementViaJavascript(PAYDAY_LOAN_CONTINUE_BUTTON_XPATH, true);
        loadingCheck();
        return new QuotePaydayLoanPage(webDriver);
    }

    @Override
    public IQuoteQuickLoanPage clickContinueUnsecuredLoanRedButton(){
        if(System.getProperty("browser").equalsIgnoreCase(SharedDriver.PHANTOMJS))
            clickElement(UNSECURED_LOAN_CONTINUE_BUTTON_XPATH);
        else
            clickElementViaJavascript(UNSECURED_LOAN_CONTINUE_BUTTON_XPATH, true);
        loadingCheck();
        return new QuoteQuickLoanPage(webDriver);
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
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