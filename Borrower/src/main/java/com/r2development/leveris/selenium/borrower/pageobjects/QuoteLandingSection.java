package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * todo Page Object Specific Implementation
 */
public class QuoteLandingSection extends Borrower implements IQuoteLandingSection {

    private static final Log log = LogFactory.getLog(QuoteLandingSection.class.getName());

    private static final String UNSEC_LOAN_XPATH = UNSECURED_LOAN_SUB_HEADER_XPATH;


//    @FindBy(xpath = HEADER_GREAT_AND_QUICK_LOAN_XPATH)
//    protected WebElement weHeaderGreatAndQuickLoan;
//
//    @FindBy(xpath = UNSEC_LOAN_XPATH)
//    protected WebElement weSubHeaderUnsecuredLoan;

    @FindBy(xpath = LOAN_UP_TO_LOAN_AMOUNT_XPATH)
    protected WebElement weLoanUpToLoanAmount;

    @FindBy(xpath = UNSECURED_LOAN_CONTINUE_BUTTON_XPATH)
    protected WebElement weContinueUnsecuredLoanRedButton;

    @FindBy(xpath = PAYDAY_LOAN_CONTINUE_BUTTON_XPATH)
    protected WebElement weContinuePaydayLoanTealButton;

//    @FindBy(xpath = PAYDAY_LOAN_HEADER_XPATH)
//    protected WebElement weHeaderPayDayLoan;

    @FindBy(xpath = PAYDAY_LOAN_AMOUNT_XPATH)
    protected WebElement wePayDayLoan;

//    @FindBy(xpath = MORTGAGE_HEADER_XPATH)
//    protected WebElement weHeaderMortgage;
//
//    @FindBy(xpath = DEBT_CONSOLIDATION_HEADER_XPATH)
//    protected WebElement weHeaderDebitConsolidation;

    @FindBy(xpath = UNSECURED_LOAN_TITLE_FROM_XPATH)
    protected WebElement weHeaderTitleFromAmountPerMonth;

//    @FindBy(xpath = UNSECURED_LOAN_TITLE_PER_MONTH_XPATH)
//    protected WebElement wePerMonthTitle;
//
//    @FindBy(xpath = UNSECURED_LOAN_TITLE_AMOUNT_XPATH)
//    protected WebElement weFromAmount;

    public QuoteLandingSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

        //   isVisible(HEADER_GREAT_AND_QUICK_LOAN_XPATH);
        isVisible(UNSEC_LOAN_XPATH, true);

        isHeaderGreatAndQuickLoanPresent();
        isSubHeaderUnsecuredLoanPresent();
        isTitleFromAmountPerMonthPresent();
        isLoanUpToLoanAmountPresent();
        isHeaderMortgagePresent();
        isHeaderDebitConsolidationPresent();

        isVisible("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlPaydayLoan_c_w_btnContinue_submit']", true);
        isVisible("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlUnsecuredLoanSmall_c_w_btnContinue1_submit']", true);
    }

    @Override
    public IQuoteQuickLoanPage clickContinuePaydayLoanTealButton() {
        log.info( "Clicking 1" );

        clickElement("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlPaydayLoan_c_w_btnContinue_submit']");
        log.info( "Clicking 2" );

        clickElementViaJavascript("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlPaydayLoan_c_w_btnContinue_submit']");
        log.info( "Clicking 3" );

        webDriver.findElement(By.xpath("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlPaydayLoan_c_w_btnContinue_submit']")).submit();
        log.info( "Clicking 4" );


        return new QuoteQuickLoanPage(webDriver);  // TODO: 05/02/16 Check te PageObject return is valid
    }

    @Override
    public IQuoteQuickLoanPage clickContinueUnsecuredLoanRedButton(){
//        log.info( "Clicking 1" );
//
//        clickElement("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlUnsecuredLoanSmall_c_w_btnContinue1_submit']");
//        log.info( "Clicking 2" );
        log.info( "Clicking javascript" );
        clickElementViaJavascript("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlUnsecuredLoanSmall_c_w_btnContinue1_submit']");
//
//        webDriver.findElement(By.xpath("//a[@wicketpath='main_c_form_form_root_c_w_pnlUnsecuredLoan_c_w_pnlUnsecuredLoanSmall_c_w_btnContinue1_submit']")).submit();
//        log.info( "Clicking 4" );
//

        return new QuoteQuickLoanPage(webDriver); // TODO: 05/02/16 Check te PageObject return is valid
    }

    @Override
    public boolean isHeaderGreatAndQuickLoanPresent(){
//        log.info( "Executing class" + this.getClass().toString() + "will this display methodName : " + this.getClass().getEnclosingMethod().toString() );
        log.info( "testing...." );
        return isVisible(HEADER_GREAT_AND_QUICK_LOAN_XPATH);
    }

    @Override
    public boolean isSubHeaderUnsecuredLoanPresent(){
        return isVisible(UNSEC_LOAN_XPATH);
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
        return isVisible(PAYDAY_LOAN_HEADER_XPATH);
    }

    @Override
    public String getPayDayLoanAmount(){
        return wePayDayLoan.getAttribute("text");
    }

    @Override
    public boolean isHeaderMortgagePresent() {
        return isVisible(MORTGAGE_HEADER_XPATH);
    }

    @Override
    public boolean isHeaderDebitConsolidationPresent() {
        return isVisible(DEBT_CONSOLIDATION_HEADER_XPATH);
    }

    @Override // Not verifying the number in title
    public boolean isTitleFromAmountPerMonthPresent() {
        return isVisible(UNSECURED_LOAN_TITLE_FROM_XPATH) && isVisible(UNSECURED_LOAN_TITLE_PER_MONTH_XPATH) && isVisible(UNSECURED_LOAN_TITLE_AMOUNT_XPATH);
    }

    @Override
    public boolean isFromAmountPerMonthEqualToValue(String expectedFromAmountPerMonth){
        return getFromAmountPerMonthValue().equalsIgnoreCase(expectedFromAmountPerMonth);
    }

    @Override
    public String getFromAmountPerMonthValue() {
        return weHeaderTitleFromAmountPerMonth.getAttribute("text");
    }



}
