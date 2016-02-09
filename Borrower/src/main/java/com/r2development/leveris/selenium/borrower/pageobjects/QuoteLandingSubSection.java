package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteLandingSubSection extends Borrower implements IQuoteLandingSubSection {

    private static final Log log = LogFactory.getLog(QuoteLandingSubSection.class.getName());

    @FindBy(xpath = HEADER_GREAT_AND_QUICK_LOAN_XPATH)
    protected WebElement weHeaderGreatAndQuickLoan;

    @FindBy(xpath = SUB_HEADER_UNSECURED_LOAN_XPATH)
    protected WebElement weSubHeaderUnsecuredLoan;

    @FindBy(xpath = LOAN_UP_TO_LOAN_AMOUNT_XPATH)
    protected WebElement weLoanUpToLoanAmount;

    @FindBy(xpath = RED_CONTINUE_BUTTON_XPATH)
    protected WebElement weRedContinueButton;

    @FindBy(xpath = TEAL_CONTINUE_BUTTON_XPATH)
    protected WebElement weTealContinueButton;

    @FindBy(xpath = HEADER_PAYDAY_LOAN_XPATH)
    protected WebElement weHeaderPayDayLoan;

    @FindBy(xpath = PAYDAY_LOAN_AMOUNT_XPATH)
    protected WebElement wePayDayLoan;

    @FindBy(xpath = HEADER_MORTGAGE_XPATH)
    protected WebElement weHeaderMortgage;

    @FindBy(xpath = HEADER_DEBIT_CONSOLIDATION_XPATH)
    protected WebElement weHeaderDebitConsolidation;

    @FindBy(xpath = TITLE_FROM_AMOUNT_PER_MONTH_XPATH)
    protected WebElement weHeaderTitleFromAmountPerMonth;

    public QuoteLandingSubSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        checkPage();
    }

    public QuoteLandingSubSection checkPage(){
        isHeaderGreatAndQuickLoanPresent();
        isSubHeaderUnsecuredLoanPresent();
        isTitleFromAmountPerMonthPresent();
        isLoanUpToLoanAmountPresent();
        isHeaderMortgagePresent();
        isHeaderDebitConsolidationPresent();
        weRedContinueButton.isDisplayed();
        weTealContinueButton.isDisplayed();
        return this;
    }

    @Override
    public QuickLoanPage clickContinueTealButton(){
        weTealContinueButton.click();
        return new QuickLoanPage(webDriver);  // TODO: 05/02/16 Check te PageObject return is valid
    }

    @Override
    public QuickLoanPage clickContinueRedButton(){
        weRedContinueButton.click();
        return new QuickLoanPage(webDriver); // TODO: 05/02/16 Check te PageObject return is valid
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
        return weHeaderGreatAndQuickLoan.isDisplayed();
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return weSubHeaderUnsecuredLoan.isDisplayed();
    }

    @Override
    public boolean isLoanUpToLoanAmountPresent() {
        return weLoanUpToLoanAmount.isDisplayed();
    }

    @Override
    public String getValueLoanUpTo(){
        return weLoanUpToLoanAmount.getAttribute("text");
    }

    @Override
    public boolean isHeaderPayDayLoanPresent(){
        return weHeaderPayDayLoan.isDisplayed();
    }

    @Override
    public String getPayDayLoanAmount(){
        return wePayDayLoan.getAttribute("text");
    }

    @Override
    public boolean isHeaderMortgagePresent() {
        return weHeaderMortgage.isDisplayed();
    }

    @Override
    public boolean isHeaderDebitConsolidationPresent() {
        return weHeaderDebitConsolidation.isDisplayed();
    }

    @Override
    public boolean isTitleFromAmountPerMonthPresent() {
        return weHeaderTitleFromAmountPerMonth.isDisplayed();
    }

    @Override
    public String getFromAmountPerMonthValue() {
        return weHeaderTitleFromAmountPerMonth.getAttribute("text");
    }



}
