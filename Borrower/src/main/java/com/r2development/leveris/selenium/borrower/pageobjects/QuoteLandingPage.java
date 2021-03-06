package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QuoteLandingPage extends Borrower implements IQuoteLandingPage {

    private static final Log log = LogFactory.getLog(QuoteLandingPage.class.getName());

    private IQuoteLandingSection quoteLandingSection;

//    @Inject
    public QuoteLandingPage(SharedDriver_Borrower webDriver ) {
        super( webDriver );
        quoteLandingSection = new QuoteLandingSection(webDriver);
    }

    @Override
    public IQuoteLandingPage goToBorrowerQuoteLandingPage(){
        get(System.getProperty("borrower"));
        return this;
    }

    @Override
    public IQuotePaydayLoanPage clickContinuePaydayLoanTealButton(){
        return quoteLandingSection.clickContinuePaydayLoan();
    }

    @Override
    public IQuoteQuickLoanPage clickContinueUnsecuredLoanRedButton(){
        return quoteLandingSection.clickContinueUnsecuredLoan();
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
        return quoteLandingSection.isHeaderGreatAndQuickLoanPresent();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return quoteLandingSection.isSubHeaderUnsecuredLoanPresent();
    }

    @Override
    public boolean isLoanUpToLoanAmountPresent() {
        return quoteLandingSection.isLoanUpToLoanAmountPresent();
    }

    @Override
    public String getValueLoanUpTo(){
        return quoteLandingSection.getValueLoanUpTo();
    }

    @Override
    public boolean isHeaderPayDayLoanPresent(){
        return quoteLandingSection.isHeaderPayDayLoanPresent();
    }

    @Override
    public String getPayDayLoanAmount(){
        return quoteLandingSection.getPayDayLoanAmount();
    }

    @Override
    public boolean isHeaderMortgagePresent() {
        return quoteLandingSection.isHeaderMortgagePresent();
    }

    @Override
    public boolean isHeaderDebitConsolidationPresent() {
        return quoteLandingSection.isHeaderDebitConsolidationPresent();
    }

    @Override
    public boolean isTitleFromAmountPerMonthPresent() {
        return quoteLandingSection.isTitleFromAmountPerMonthPresent();
    }

    @Override
    public String getFromAmountPerMonthValue() {
        return quoteLandingSection.getFromAmountPerMonthValue();
    }

    @Override
    public boolean isFromAmountPerMonthEqualToValue( String fromAmountPerMonth ) {
        return quoteLandingSection.isFromAmountPerMonthEqualToValue( fromAmountPerMonth );
    }
}