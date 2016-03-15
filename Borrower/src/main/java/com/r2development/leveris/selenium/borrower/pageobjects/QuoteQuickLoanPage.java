package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteQuickLoanPage extends Borrower implements IQuoteQuickLoanPage {

    public IQuoteQuickLoanSection quickLoanSection;

    private static final Log log = LogFactory.getLog( QuoteQuickLoanPage.class.getName() );

//    @Inject
    public QuoteQuickLoanPage(SharedDriver webDriver ) {
        super( webDriver );
        quickLoanSection = new QuoteQuickLoanSection(webDriver);
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent(){
        return quickLoanSection.isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return quickLoanSection.isSubHeaderUnsecuredLoanPresent();
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent(){
        return quickLoanSection.isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
    }

    @Override
    public IQuoteQuickLoanPage setLoanPurpose(String loanPurposeType){
        log.info("selecting loan");
        quickLoanSection.setLoanPurpose( loanPurposeType );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setNetMonthlyIncome(String netMonthlyIncome){
        quickLoanSection.setNetMonthlyIncome( netMonthlyIncome );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setMonthlyExpenses(String monthlyExpenses){
        quickLoanSection.setMonthlyExpenses( monthlyExpenses );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setNumberOfDependants(String numberOfDependants){
        quickLoanSection.setNumberOfDependants( numberOfDependants );
        return this;
    }

    @Override
    public IQuoteQuickLoanPage setAmountToBorrow(String amountToBorrow) {
        quickLoanSection.setAmountToBorrow( amountToBorrow );
        return this;
    }

    @Override
    public IQuoteConfigurationPage clickContinue(){
        return quickLoanSection.clickContinue();
    }
}
