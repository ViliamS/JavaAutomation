package com.r2development.leveris.selenium.borrower.pageobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

/**
 * todo Page Object Specific Implementation
 */
public class QuickLoanPage extends TopBannerMenu implements IQuickLoanPage, IBorrowerBasicParameters {

    public IBorrowerBasicParameters borrowerBasicParameters;

    private static final Log log = LogFactory.getLog( QuickLoanPage.class.getName() );

    public QuickLoanPage( WebDriver webDriver ) {
        super( webDriver );
        checkPage();
    }

    public QuickLoanPage checkPage(){
        return this;
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent(){
        return borrowerBasicParameters.isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return borrowerBasicParameters.isSubHeaderUnsecuredLoanPresent();
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent(){
        return borrowerBasicParameters.isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
    }

    @Override
    public BorrowerBasicParametersSubSection loanPurposeSendKeys(String loanPurposeType){
        return borrowerBasicParameters.loanPurposeSendKeys( loanPurposeType );
    }

    @Override
    public BorrowerBasicParametersSubSection netMonthlyIncomeSendKeys(String netMonthlyIncome){
        return borrowerBasicParameters.netMonthlyIncomeSendKeys( netMonthlyIncome );
    }

    @Override
    public BorrowerBasicParametersSubSection monthlyExpensesSendKeys(String monthlyExpenses){
        return borrowerBasicParameters.monthlyExpensesSendKeys( monthlyExpenses );
    }

    @Override
    public BorrowerBasicParametersSubSection numberOfDependentsSendKeys(String numberOfDependents){
        return borrowerBasicParameters.numberOfDependentsSendKeys( numberOfDependents );
    }

    @Override
    public BorrowerBasicParametersSubSection amountToBorrowSendKeys(String amountToBorrow) {
        return borrowerBasicParameters.amountToBorrowSendKeys( amountToBorrow );
    }

    @Override
    public QuotationConfigurationPage clickContinue(){
        return borrowerBasicParameters.clickContinue();
    }
}
