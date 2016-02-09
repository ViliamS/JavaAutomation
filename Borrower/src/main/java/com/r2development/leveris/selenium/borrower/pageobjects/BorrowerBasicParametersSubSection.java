package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * todo Page Object Specific Implementation
 */
public class BorrowerBasicParametersSubSection extends Borrower implements IBorrowerBasicParameters {

    @FindBy(xpath = HEADER_YES_I_WOULD_LIKE_GREAT_AND_QUICK_LOAN)
    protected WebElement weHeaderYesIWouldLikeGreatAndQuickLoan;

    @FindBy(xpath = SUB_HEADER_UNSECURED_LOAN_XPATH)
    protected WebElement weSubHeaderUnsecuredLoan;

    @FindBy(xpath = SUB_TITLE_BASIC_INFO_ABOUT_YOU_SHOULD_GIVE_US_XPATH)
    protected WebElement weSubTitleBasicInfoAboutYouShouldGiveUs;

    @FindBy(xpath = LOAN_PURPOSE_INPUT_DROP_DOWN_SELECT_XPATH)
    protected WebElement weLoanPurposeInputDropDown;

    @FindBy(xpath = CONTINUE_TEAL_BUTTON_XPATH)
    protected WebElement weTealContinueButton;

    @FindBy(xpath = NET_MONTHLY_INCOME_INPUT_XPATH)
    protected WebElement weNetMonthlyIncomeInput;

    @FindBy(xpath = MONTHLY_EXPENSES_INPUT_XPATH)
    protected WebElement weMonthlyExpenses;

    @FindBy(xpath = NUMBER_OF_DEPENDENTS_INPUT_XPATH)
    protected WebElement weNumberOfDependentsInput;

    @FindBy(xpath = AMOUNT_TO_BORROW_INPUT_XPATH)
    protected WebElement weAmountToBorrowInput;

    public BorrowerBasicParametersSubSection(WebDriver webDriver){
        super( webDriver );
        checkPage();
    }

    public BorrowerBasicParametersSubSection checkPage(){
        isSubHeaderUnsecuredLoanPresent();
        isHeaderYesIWouldLikeGreatAndQuickLoanPresent();
        isSubTitleBasicInfoAboutYouShouldGiveUsPresent();
        weLoanPurposeInputDropDown.isDisplayed();
        weTealContinueButton.isDisplayed();
        weNetMonthlyIncomeInput.isDisplayed();
        weMonthlyExpenses.isDisplayed();
        weNumberOfDependentsInput.isDisplayed();
        weAmountToBorrowInput.isDisplayed();
        return this;
    }

    @Override
    public boolean isHeaderYesIWouldLikeGreatAndQuickLoanPresent() {
        return weHeaderYesIWouldLikeGreatAndQuickLoan.isDisplayed();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent() {
        return weSubHeaderUnsecuredLoan.isDisplayed();
    }

    @Override
    public boolean isSubTitleBasicInfoAboutYouShouldGiveUsPresent() {
        return weSubTitleBasicInfoAboutYouShouldGiveUs.isDisplayed();
    }

    @Override
    public BorrowerBasicParametersSubSection loanPurposeSendKeys(String loanPurposeType) {
        weLoanPurposeInputDropDown.clear();
        weLoanPurposeInputDropDown.sendKeys( loanPurposeType );
        return this;
    }

    @Override
    public BorrowerBasicParametersSubSection netMonthlyIncomeSendKeys(String netMonthlyIncome) {
        weNetMonthlyIncomeInput.clear();
        weNetMonthlyIncomeInput.sendKeys( netMonthlyIncome );
        return this;
    }

    @Override
    public BorrowerBasicParametersSubSection monthlyExpensesSendKeys(String monthlyExpenses) {
        weMonthlyExpenses.clear();
        weMonthlyExpenses.sendKeys( monthlyExpenses );
        return this;
    }

    @Override
    public BorrowerBasicParametersSubSection numberOfDependentsSendKeys(String numberOfDependents) {
        weNumberOfDependentsInput.clear();
        weNumberOfDependentsInput.sendKeys( numberOfDependents );
        return this;
    }

    @Override
    public BorrowerBasicParametersSubSection amountToBorrowSendKeys(String amountToBorrow) {
        weAmountToBorrowInput.clear();
        weAmountToBorrowInput.sendKeys( amountToBorrow );
        return this;
    }

    @Override
    public QuotationConfigurationPage clickContinue() {
        weTealContinueButton.click();
        return new QuotationConfigurationPage( webDriver );
    }

}
