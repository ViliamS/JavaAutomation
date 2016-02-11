package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class QuotePaydayLoanPage extends Borrower implements IQuotePaydayLoanPage {

    public IQuotePaydayLoanSection quotePaydayLoanSection;

    private static final Log log = LogFactory.getLog( QuoteQuickLoanPage.class.getName() );

    public QuotePaydayLoanPage(WebDriver webDriver ) {
        super( webDriver );
        quotePaydayLoanSection = new QuotePaydayLoanSection(webDriver);
    }

//    @Override
//    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent(){
//        return quickLoanSection.isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
//    }
//
//    @Override
//    public boolean isSubHeaderUnsecuredLoanPresent(){
//        return quickLoanSection.isSubHeaderUnsecuredLoanPresent();
//    }
//
//    @Override
//    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent(){
//        return quickLoanSection.isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
//    }

    @Override
    public IQuotePaydayLoanPage setLoanPurpose(String loanPurposeType){
        log.info("selecting loan");
        return quotePaydayLoanSection.setLoanPurpose( loanPurposeType );
    }

    @Override
    public IQuotePaydayLoanPage setNetMonthlyIncome(String netMonthlyIncome){
        return quotePaydayLoanSection.setNetMonthlyIncome( netMonthlyIncome );
    }

    @Override
    public IQuotePaydayLoanPage setMonthlyExpenses(String monthlyExpenses){
        return quotePaydayLoanSection.setMonthlyExpenses( monthlyExpenses );
    }

    @Override
    public IQuotePaydayLoanPage setNumberOfDependents(String numberOfDependents){
        return quotePaydayLoanSection.setNumberOfDependents( numberOfDependents );
    }

    @Override
    public IQuotePaydayLoanPage setAmountToBorrow(String amountToBorrow) {
        return quotePaydayLoanSection.setAmountToBorrow( amountToBorrow );
    }

    @Override
    public IQuoteConfigurationPage clickContinue(){
        return quotePaydayLoanSection.clickContinue();
    }

}
