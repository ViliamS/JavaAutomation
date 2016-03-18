package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class HeaderAndBottomAndFormsMenuSection extends Borrower implements IHeaderSection, IFormsMenu, IBottomSection {

    private static final Log log = LogFactory.getLog(HeaderAndBottomAndFormsMenuSection.class);

    protected IHeaderSection headerSection;
    protected IFormsMenu formsMenu;
    protected IBottomSection bottomSection;

//    @Inject
    public HeaderAndBottomAndFormsMenuSection(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
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
    public IBorrowerHomePage clickDashboard() {
        return null;
    }

    @Override
    public IFormsMenu clickBorrowerPersonalDetails(String borrowerFirstName) {
        return formsMenu.clickBorrowerPersonalDetails(borrowerFirstName);
    }

    @Override
    public IFormsMenu clickBorrowerPersonalDetails() {
        return formsMenu.clickBorrowerPersonalDetails();
    }

    @Override
    public IFormsMenu clickSingleBorrowerPersonalDetails() {
        return formsMenu.clickSingleBorrowerPersonalDetails();
    }

    @Override
    public IFormsMenu clickCoupleBorrowerPersonalDetails() {
        return formsMenu.clickCoupleBorrowerPersonalDetails();
    }

    @Override
    public boolean isBorrowerPersonalDetailsValid(String borrowerFirstName) {
        return formsMenu.isBorrowerPersonalDetailsValid(borrowerFirstName);
    }

    @Override
    public boolean isBorrowerPersonalDetailsValid() {
        return formsMenu.isBorrowerPersonalDetailsValid();
    }

    @Override
    public IFormsMenu clickBorrowerEmploymentIncome(String borrowerFirstName) {
        return formsMenu.clickBorrowerEmploymentIncome(borrowerFirstName);
    }

    @Override
    public IFormsMenu clickBorrowerEmploymentIncome() {
        return formsMenu.clickBorrowerEmploymentIncome();
    }

    @Override
    public IFormsMenu clickCoapplicantPersonalDetails(String coapplicantFirstName) {
        return formsMenu.clickCoapplicantPersonalDetails(coapplicantFirstName);
    }

    @Override
    public boolean isCoapplicantPersonalDetailsValid(String coapplicantFirstName) {
        return formsMenu.isCoapplicantPersonalDetailsValid(coapplicantFirstName);
    }

    @Override
    public IFormsMenu clickCoapplicantEmploymentIncome(String coapplicantFirstName) {
        return formsMenu.clickCoapplicantEmploymentIncome(coapplicantFirstName);
    }

    @Override
    public IFormsMenu clickAccount() {
        return formsMenu.clickAccount();
    }

    @Override
    public IFormsMenu clickDependants() {
        return formsMenu.clickDependants();
    }

    @Override
    public IFormsMenu clickFinancialAssets() {
        return formsMenu.clickFinancialAssets();
    }

    @Override
    public IFormsMenu clickProperties() {
        return formsMenu.clickProperties();
    }

    @Override
    public IFormsMenu clickFinancialCommitments() {
        return formsMenu.clickFinancialCommitments();
    }

    @Override
    public IFormsMenu clickFunding() {
        return formsMenu.clickFunding();
    }

    @Override
    public IFormsMenu clickDocumentUpload() {
        return formsMenu.clickDocumentUpload();
    }

    @Override
    public IBorrowerHomePage clickHome() {
        return formsMenu.clickHome();
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
    public IFormsMenu clickAccount(String singleOrDouble) {
        return formsMenu.clickAccount(singleOrDouble);
    }

    @Override
    public IFormsMenu clickDependants(String singleOrDouble) {
        return formsMenu.clickDependants(singleOrDouble);
    }

    @Override
    public IFormsMenu clickFinancialAssets(String singleOrDouble) {
        return formsMenu.clickFinancialAssets(singleOrDouble);
    }

    @Override
    public IFormsMenu clickProperties(String singleOrDouble) {
        return formsMenu.clickProperties(singleOrDouble);
    }

    @Override
    public IFormsMenu clickFinancialCommitments(String singleOrDouble) {
        return formsMenu.clickFinancialCommitments(singleOrDouble);
    }

    @Override
    public IFormsMenu clickFunding(String singleOrDouble) {
        return formsMenu.clickFunding(singleOrDouble);
    }

    @Override
    public IWelcomePage clickSignOut() throws Exception {
        return null;
    }

    @Override
    public void closeChat() {

    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public boolean isAccountFormDone(String singleOrDouble) {
        return formsMenu.isAccountFormDone(singleOrDouble);
    }

    @Override
    public boolean isDependantFormDone(String singleOrDouble) {
        return formsMenu.isDependantFormDone(singleOrDouble);
    }

    @Override
    public boolean isFinancialAssetsFormDone(String singleOrDouble) {
        return formsMenu.isFinancialAssetsFormDone(singleOrDouble);
    }

    @Override
    public boolean isPropertiesDone(String singleOrDouble) {
        return formsMenu.isPropertiesDone(singleOrDouble);
    }

    @Override
    public boolean isFinancialCommitmentsFormDone(String singleOrDouble) {
        return formsMenu.isPropertiesDone(singleOrDouble);
    }

    @Override
    public boolean isFundingFormDone(String singleOrDouble) {
        return formsMenu.isFundingFormDone(singleOrDouble);
    }
}
