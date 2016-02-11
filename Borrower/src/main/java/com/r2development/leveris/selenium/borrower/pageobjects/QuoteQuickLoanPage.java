package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteQuickLoanPage extends Borrower implements IQuoteQuickLoanPage {

    public IQuoteQuickLoanSection quickLoanSection;

    private static final Log log = LogFactory.getLog( QuoteQuickLoanPage.class.getName() );

    public QuoteQuickLoanPage(WebDriver webDriver ) {
        super( webDriver );
        quickLoanSection = new QuoteQuickLoanSection(webDriver);
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
    public IQuoteQuickLoanPage setLoanPurpose(String loanPurposeType){
        log.info("selecting loan");
        return quickLoanSection.setLoanPurpose( loanPurposeType );
    }

    @Override
    public IQuoteQuickLoanPage setNetMonthlyIncome(String netMonthlyIncome){
        return quickLoanSection.setNetMonthlyIncome( netMonthlyIncome );
    }

    @Override
    public IQuoteQuickLoanPage setMonthlyExpenses(String monthlyExpenses){
        return quickLoanSection.setMonthlyExpenses( monthlyExpenses );
    }

    @Override
    public IQuoteQuickLoanPage setNumberOfDependents(String numberOfDependents){
        return quickLoanSection.setNumberOfDependents( numberOfDependents );
    }

    @Override
    public IQuoteQuickLoanPage setAmountToBorrow(String amountToBorrow) {
        return quickLoanSection.setAmountToBorrow( amountToBorrow );
    }

    @Override
    public IQuoteConfigurationPage clickContinue(){
        return quickLoanSection.clickContinue();
    }
}
