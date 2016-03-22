package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BuildQuotationPage extends HeaderAndBottomAndFormsMenuSection implements IBuildQuotationPage, IWelcomeGetQuoteSection/*, IHeaderSection, IBuildQuoteSection, IBuildQuoteSection2, IBuildQuoteSection3/*, IBottomSection*/ {

    private static final Log log = LogFactory.getLog(BuildQuotationPage.class);

    protected IHeaderSection headerSection;
    protected IWelcomeGetQuoteSection welcomeGetQuoteSection;
    protected IBuildQuoteSection buildQuoteSection;
    protected IBuildQuoteSection2 buildQuoteSection2;
    protected IBuildQuoteSection3 buildQuoteSection3;
    protected IBottomSection bottomSection;

//    @Inject
    public BuildQuotationPage(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        welcomeGetQuoteSection = new WelcomeGetQuoteSection(webDriver);
        buildQuoteSection = new BuildQuoteSection(webDriver);
        buildQuoteSection2 = new BuildQuoteSection2(webDriver);
        buildQuoteSection3 = new BuildQuoteSection3(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public void clickContactUs() {
    }

    @Override
    public void clickHelpCenter() {
    }

    @Override
    public void clickWhatElse() {
    }

    @Override
    public void clickLegalTerm() {
    }

    @Override
    public IBuildQuotationPage selectNumberOfBorrower(String nbBorrowers) {
        buildQuoteSection.selectNumberOfBorrower(nbBorrowers);
        return this;
    }

    @Override
    public IBuildQuotationPage clickNumberOfBorrower(String nbBorrowers) {
        buildQuoteSection.clickNumberOfBorrower(nbBorrowers);
        return this;
    }

    @Override
    public IBuildQuotationPage selectMortgageType(String mortgageType) {
        buildQuoteSection.selectMortgageType(mortgageType);
        return this;
    }

    @Override
    public IBuildQuotationPage clickMortgageType(String mortgageType) {
        buildQuoteSection.clickMortgageType(mortgageType);
        return this;
    }

    @Override
    public IBuildQuotationPage typeAge(String age) {
        buildQuoteSection.typeAge(age);
        return this;
    }

    @Override
    public IBuildQuotationPage typePartnerAge(String age) {
        buildQuoteSection.typePartnerAge(age);
        return this;
    }

    @Override
    public IBuildQuotationPage selectMaritalStatus(String maritalStatus) {
        buildQuoteSection.selectMaritalStatus(maritalStatus);
        return this;
    }

    @Override
    public IBuildQuotationPage typeTotalDependants(String totalDependants) {
        buildQuoteSection.typeTotalDependants(totalDependants);
        return this;
    }

    @Override
    public IBuildQuotationPage selectIncomeType(String incomeType) {
        buildQuoteSection.selectIncomeType(incomeType);
        return this;
    }


    @Override
    public IBuildQuotationPage selectPartnerIncomeType(String incomeType) {
        buildQuoteSection.selectPartnerIncomeType(incomeType);
        return this;
    }

    @Override
    public IBuildQuotationPage typeIncomeAmount(String incomeAmount) {
        buildQuoteSection.typeIncomeAmount(incomeAmount);
        return this;
    }

    @Override
    public IBuildQuotationPage typePartnerIncomeAmount(String incomeAmount) {
        buildQuoteSection.typePartnerIncomeAmount(incomeAmount);
        return this;
    }

    @Override
    public IBuildQuotationPage typeMonthlyCreditCommitments(String monthCreditCommitment) {
        buildQuoteSection.typeMonthlyCreditCommitments(monthCreditCommitment);
        return this;
    }

    @Override
    public IBuildQuotationPage clickGetQuote() {
        buildQuoteSection.clickGetQuote();
        return this;
    }

//    @Override
//    public IBuildQuotationPage clickGetQuoteFailure() {
//        buildQuoteSection.clickGetQuoteFailure();
//        return this;
//    }

    @Override
    public void clickEdit() {
        buildQuoteSection2.clickEdit();
    }

    @Override
    public void clickConfigureLoan() {
        buildQuoteSection2.clickConfigureLoan();
    }

    @Override
    public String getCurrentStep() {
        return null;
    }

    @Override
    public void clickApplyNow() {
        buildQuoteSection3.clickApplyNow();
    }

    @Override
    public void clickEmailQuote() {
        buildQuoteSection3.clickEmailQuote();
    }

    @Override
    public void clickEditDetails() {
        buildQuoteSection3.clickEditDetails();
    }

    @Override
    public IBorrowerHomePage clickLogo() {
        return null;
    }

    @Override
    public INotificationMessagePage clickNotificationMessages() {
        return null;
    }

    @Override
    public IBorrowerHomePage clickYourAccount() {
        return null;
    }

    @Override
    public void moveToYourAccount() {

    }

    @Override
    public IWelcomePage clickSignOut() {
        return null;
    }

    @Override
    public void closeChat() {

    }

    @Override
    public void clickGetQuoteNow() {
        welcomeGetQuoteSection.clickGetQuoteNow();
    }

    @Override
    public boolean isWelcomeQuoteLoaded() {
//        isVisible(CLOSE_XPATH, true);
//        isVisible(MOTTO_XPATH, true);
        isVisible(GET_QUOTE_NOW_BUTTON_XPATH, true);
        return true;
    }

    @Override
    public IWelcomePage closeWelcomeQuote() {
        welcomeGetQuoteSection.isLoaded();
        welcomeGetQuoteSection.closeWelcomeQuote();
        return new WelcomePage(webDriver);
    }

    @Override
    public boolean isLoaded() {
        //headerSection.isLoaded();
        welcomeGetQuoteSection.isLoaded();
        buildQuoteSection.isLoaded();
        buildQuoteSection2.isLoaded();
        buildQuoteSection3.isLoaded();
        //bottomSection.isLoaded();
        return true;
    }

    @Override
    public String getAffordabilityAmount() {
        return buildQuoteSection2.getAffordabilityAmount();
    }

    @Override
    public String getAffordabilityMonthly() {
        return buildQuoteSection2.getAffordabilityMonthly();
    }

    @Override
    public String getAffordabilityFunds() {
        return buildQuoteSection2.getAffordabilityFunds();
    }

    @Override
    public boolean isEligible() {
        return buildQuoteSection2.isEligible();
    }
}
