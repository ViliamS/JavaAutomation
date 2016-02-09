package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * todo LandingPageStepDef Specific Implementation
 */
public class QuotationConfigurationSubSection extends Borrower implements IQuotationConfigurationSubSection{

    private static final Log log = LogFactory.getLog(QuotationConfigurationSubSection.class.getName());

    @FindBy(xpath = HEADER_GREAT_AND_QUICK_LOAN_XPATH)
    protected WebElement weHeaderGreatAndQuickLoan;

    @FindBy(xpath = TITLE_UNSECURED_LOAN_CALCULATOR_XPATH)
    protected WebElement weTitleUnsecuredLoanCalculator;

    @FindBy(xpath = SUB_TITLE_CONFIGURE_YOUR_LOAN_XPATH)
    protected WebElement weTitleConfigureYourLoan;

    @FindBy(xpath = INPUT_AMOUNT_TO_BORROW_SLIDER_CONTROL_XPATH)
    protected WebElement weInputAmountToBorrowSliderControl;

    @FindBy(xpath = INPUT_MONTHLY_REPAYMENT_SLIDER_CONTROL_XPATH)
    protected WebElement weInputMonthlyRepaymentSliderControl;

    @FindBy(xpath = APPLY_ONLINE_TEAL_BUTTON_XPATH)
    protected WebElement weApplyOnlineButton;

    @FindBy(xpath = CHANGE_PRODUCT_XPATH)
    protected WebElement weChangeProductLink;

    @FindBy(xpath = TITLE_NUMBER_OF_REPAYMENTS_XPATH)
    protected WebElement weTitleNumberOfRepayments;

    @FindBy(xpath = AMOUNT_NUMBER_OF_REPAYMENTS_XPATH)
    protected WebElement weAmountNumberOfRepayments;

    @FindBy(xpath = TITLE_APR_XPATH)
    protected WebElement weTitleAPR;

    @FindBy(xpath = AMOUNT_APR_XPATH)
    protected WebElement weAmountAPR;

    @FindBy(xpath = TITLE_LAST_REPAYMENT_AMOUNT)
    protected WebElement weTitleLastRepaymentAmount;

    @FindBy(xpath = AMOUNT_LAST_REPAYMENT_AMOUNT)
    protected WebElement weAmountLastRepaymentAmount;

    @FindBy(xpath = TITLE_TOTAL_COST_OF_LOAN)
    protected WebElement weTitleTotalCostOfLoan;

    @FindBy(xpath = AMOUNT_TOTAL_COST_OF_LOAN)
    protected WebElement weAmountTotalCostOfLoan;

    public QuotationConfigurationSubSection(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        checkPage();
    }

    public QuotationConfigurationSubSection checkPage(){
        isHeaderGreatAndQuickLoanPresent();
        isTitleUnsecuredLoanCalculatorPresent();
        isTitleConfigureYourLoanPresent();
        weInputAmountToBorrowSliderControl.isDisplayed();
        weInputMonthlyRepaymentSliderControl.isDisplayed();
        weApplyOnlineButton.isDisplayed();
        isChangeProductPresent();
        isTitleNumberOfRepaymentsPresent();
        weAmountNumberOfRepayments.isDisplayed();
        isTitleAprPresent();
        weAmountAPR.isDisplayed();
        isTitleLastRepaymentAmountPresent();
        weAmountLastRepaymentAmount.isDisplayed();
        isTitleTotalCostOfLoanPresent();
        weAmountTotalCostOfLoan.isDisplayed();
        return this;
    }

    @Override
    public QuotationConfigurationSubSection clickApplyOnline(){
        weApplyOnlineButton.isDisplayed();
        weApplyOnlineButton.click();
        return this; //// // TODO: 05/02/16 change to proper PageObject
    }

    @Override
    public QuotationConfigurationSubSection clickChangeProduct(){
        weChangeProductLink.isDisplayed();
        weChangeProductLink.click();
        return this; //// TODO: 05/02/16 change to proper PageObject
    }

    @Override
    public QuotationConfigurationSubSection setAmountToBorrowInput(String amountToBorrow) {
        weInputAmountToBorrowSliderControl.isDisplayed();
        weInputAmountToBorrowSliderControl.clear();
        weInputAmountToBorrowSliderControl.sendKeys(amountToBorrow);
        return this;
    }

    @Override
    public String getAmountToBorrow (){
        return weInputAmountToBorrowSliderControl.getAttribute("value");
    }

    @Override
    public QuotationConfigurationSubSection setMonthlyRepaymentInput(String monthlyRepayment){
        weInputMonthlyRepaymentSliderControl.clear();
        weInputMonthlyRepaymentSliderControl.sendKeys(monthlyRepayment);
        return this;
    }

    @Override
    public String getMonthlyRepayment(){
        return weInputMonthlyRepaymentSliderControl.getAttribute("value");
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
        return weHeaderGreatAndQuickLoan.isDisplayed();
    }

    @Override
    public boolean isTitleUnsecuredLoanCalculatorPresent(){
        return weTitleUnsecuredLoanCalculator.isDisplayed();
    }

    @Override
    public boolean isTitleConfigureYourLoanPresent(){
        return weTitleConfigureYourLoan.isDisplayed();
    }

    @Override
    public boolean isTitleNumberOfRepaymentsPresent(){
        return weTitleNumberOfRepayments.isDisplayed();
    }

    @Override
    public String getNumberOfRepayments(){
        return weAmountNumberOfRepayments.getAttribute("text");
    }

    @Override
    public boolean isTitleLastRepaymentAmountPresent(){
        return weTitleLastRepaymentAmount.isDisplayed();
    }

    @Override
    public String getLastRepaymentAmount(){
        return weAmountLastRepaymentAmount.getAttribute("text");
    }

    @Override
    public boolean isTitleAprPresent(){
        return weTitleAPR.isDisplayed();
    }

    @Override
    public String getApr(){
        return weAmountAPR.getAttribute("text");
    }

    @Override
    public boolean isTitleTotalCostOfLoanPresent(){
        return weTitleTotalCostOfLoan.isDisplayed();
    }

    @Override
    public String getTotalCostOfLoan(){
        return weAmountTotalCostOfLoan.getAttribute("text");
    }

    @Override
    public boolean isChangeProductPresent(){
        return weChangeProductLink.isDisplayed();
    }
}
