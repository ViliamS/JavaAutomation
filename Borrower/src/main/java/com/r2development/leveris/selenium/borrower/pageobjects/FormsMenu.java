package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsMenu extends Borrower implements IFormsMenu {

    private static final Log log = LogFactory.getLog(FormsMenu.class);

    @FindBy ( xpath = DASHBOARD_LINK_XPATH )
    protected WebElement webDashboardLink;

    @FindBy ( xpath = HOME_LINK_XPATH )
    protected WebElement weHomeLink;

    @FindBy ( xpath = CURRENT_CATEGORY_XPATH )
    protected WebElement webCurrentCategory;


    @FindBy ( xpath = FORM_TITLE_XPATH )
    protected WebElement weFormTitle;

    @FindBy ( xpath = BORROWER_PERSONAL_DETAILS_XPATH )
    protected WebElement weBorrowerPersonalDetails;

    @FindBy ( xpath = BORROWER_EMPLOYMENT_INCOME_XPATH )
    protected WebElement weBorrowerEmploymentIncome;

    @FindBy ( xpath = COAPPLICANT_PERSONAL_DETAILS_XPATH )
    protected WebElement weCoapplicantPersonalDetails;

    @FindBy ( xpath = COAPPLICANT_EMPLOYMENT_INCOME_XPATH )
    protected WebElement weCoapplicantEmploymentIncome;


    @FindBy ( xpath = FORMS_ROOT_XPATH )
    protected WebElement weFormsRoot;

    @FindBy ( xpath = ACCOUNT_XPATH )
    protected WebElement weAccount;

    @FindBy ( xpath = DEPENDANTS_XPATH )
    protected WebElement weDependants;

    @FindBy ( xpath = FINANCIAL_ASSETS_XPATH )
    protected WebElement weFinancialAssets;

    @FindBy ( xpath = PROPERTIES_XPATH )
    protected WebElement weProperties;

    @FindBy ( xpath = FINANCIAL_COMMITMENTS_XPATH )
    protected WebElement weFinancialCommitments;

    @FindBy ( xpath = FUNDING_XPATH )
    protected WebElement weFunding;

    @FindBy ( xpath = DOCUMENT_UPLOAD_XPATH )
    protected WebElement weDocumentUpload;

//    @Inject
    public FormsMenu(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public IBorrowerHomePage clickDashboard() {
        isVisible(DASHBOARD_LINK_XPATH, true);
        webDashboardLink.click();
        return new BorrowerHomePage(webDriver);
    }

    @Override
    public IBorrowerHomePage clickHome() {
        isVisible(HOME_LINK_XPATH, true);
        weHomeLink.click();
        return new BorrowerHomePage(webDriver);
    }
    //div[contains(@id, 'pnlBorrower1UncommonForms') and contains(., 'Tonda-coapplicant') and contains(., 'personal details')]
    @Override
    public IFormsMenu clickBorrowerPersonalDetails(String borrowerFirstName) {
        isVisible(BORROWER_PERSONAL_DETAILS_XPATH.replace("${replace}$", borrowerFirstName), true);
//        getWebElement(BORROWER_PERSONAL_DETAILS_XPATH.replace("${replace}$", borrowerFirstName)).click();
        clickElement(BORROWER_PERSONAL_DETAILS_XPATH.replace("${replace}$", borrowerFirstName));
        return this;
    }

    @Override
    public IFormsMenu clickBorrowerPersonalDetails() {
        isVisible(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH, true);
//        getWebElement(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH).click();
        clickElement(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH);
        return this;
    }

    @Override
    public IFormsMenu clickSingleBorrowerPersonalDetails() {
        isVisible(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH, true);
//        getWebElement(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH).click();
        clickElement(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH);
        return this;
    }

    @Override
    public IFormsMenu clickCoupleBorrowerPersonalDetails() {
        isVisible(BORROWER_PERSONAL_DETAILS_COUPLE_XPATH, true);
//        getWebElement(BORROWER_PERSONAL_DETAILS_COUPLE_XPATH).click();
        clickElement(BORROWER_PERSONAL_DETAILS_COUPLE_XPATH);
        return this;
    }

    @Override
    public boolean isBorrowerPersonalDetailsValid(String borrowerFirstName) {
        isVisible(BORROWER_PERSONAL_DETAILS_XPATH.replace("${replace}$", borrowerFirstName), true);
        isVisible(BORROWER_PERSONAL_DETAILS_XPATH.replace("${replace}$", borrowerFirstName) + FORMDONE_ICON_XPATH, true);
        return true;
    }

    @Override
    public boolean isBorrowerPersonalDetailsValid() {
        isVisible(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH, true);
        isVisible(BORROWER_PERSONAL_DETAILS_SINGLE_XPATH + FORMDONE_ICON_XPATH, true);
        return true;
    }

    @Override
    public IFormsMenu clickBorrowerEmploymentIncome(String borrowerFirstName) {
        isVisible(BORROWER_EMPLOYMENT_INCOME_XPATH.replace("${replace}$", borrowerFirstName), true, 10);
        //weBorrowerEmploymentIncome.click();
//        getWebElement(BORROWER_EMPLOYMENT_INCOME_XPATH.replace("${replace}$", borrowerFirstName)).click();
        clickElement(BORROWER_EMPLOYMENT_INCOME_XPATH.replace("${replace}$", borrowerFirstName));
        return this;
    }

    @Override
    public IFormsMenu clickBorrowerEmploymentIncome() {
        isVisible(BORROWER_EMPLOYMENT_INCOME_SINGLE_XPATH, true, 10);
//        getWebElement(BORROWER_EMPLOYMENT_INCOME_SINGLE_XPATH).click();
        clickElement(BORROWER_EMPLOYMENT_INCOME_SINGLE_XPATH);
        return new EmploymentIncomesPage(webDriver);
    }

    @Override
    public IFormsMenu clickCoapplicantPersonalDetails(String coapplicantFirstName) {
        //isVisible(COAPPLICANT_PERSONAL_DETAILS_XPATH.replace("${replace}$", coapplicantFirstName), true);
//        Exception on PageObject Pattern
        //weCoapplicantPersonalDetails.click();
//        getWebElement(COAPPLICANT_PERSONAL_DETAILS_XPATH.replace("${replace}$", coapplicantFirstName)).click();
        clickElement(COAPPLICANT_PERSONAL_DETAILS_XPATH.replace("${replace}$", coapplicantFirstName));
//        clickElement();
        return this;
    }

    @Override
    public boolean isCoapplicantPersonalDetailsValid(String coapplicantFirstName) {
//        isVisible(COAPPLICANT_PERSONAL_DETAILS_XPATH.replace("${replace}$", coapplicantFirstName), true, 180);
        isVisible(COAPPLICANT_PERSONAL_DETAILS_XPATH, true, 180);
//        isVisible(COAPPLICANT_PERSONAL_DETAILS_XPATH.replace("${replace}$", coapplicantFirstName) + FORMDONE_ICON_XPATH, true, 180);
        isVisible(COAPPLICANT_PERSONAL_DETAILS_XPATH + FORMDONE_ICON_XPATH, true, 180);
        return true;
    }

    @Override
    public IFormsMenu clickCoapplicantEmploymentIncome(String coapplicantFirstName) {
        isVisible(COAPPLICANT_EMPLOYMENT_INCOME_XPATH.replace("${replace}$", coapplicantFirstName), true);
//        getWebElement(COAPPLICANT_EMPLOYMENT_INCOME_XPATH.replace("${replace}$", coapplicantFirstName)).click();
        clickElement(COAPPLICANT_EMPLOYMENT_INCOME_XPATH.replace("${replace}$", coapplicantFirstName));
        return this;
    }

    @Override
    public IFormsMenu clickAccount() {
        try {
//            isVisible(ACCOUNT_XPATH, true, 10);
//            weAccount.click();
            clickElement(ACCOUNT_XPATH);
        } catch ( TimeoutException te ) {
            clickElementViaJavascript(ACCOUNT_XPATH);
        }
        return this;
    }

    @Override
    public IFormsMenu clickAccount(String singleOrDouble) {
        try {
//            isVisible(ACCOUNT_COMMON_XPATH, true, 10);
//            weAccount.click();
            if ( singleOrDouble.equals("single"))
                clickElement(ACCOUNT_XPATH);
            else
                clickElement(ACCOUNT_COMMON_XPATH);
        } catch ( TimeoutException te ) {
            if ( singleOrDouble.equals("single"))
                clickElementViaJavascript(ACCOUNT_XPATH);
            else
                clickElementViaJavascript(ACCOUNT_COMMON_XPATH);
        }
        return this;
    }

    @Override
    public boolean isAccountFormDone(String singleOrDouble) {
        if ( singleOrDouble.equals("single")) {
            return isVisible(ACCOUNT_DONE_XPATH, false, 10);
        }
        else {
            return isVisible(ACCOUNT_COMMON_DONE_XPATH, false, 10);
        }
    }

    @Override
    public IFormsMenu clickDependants() {
//        isVisible(DEPENDANTS_XPATH, true, 10);
//        weDependants.click();
        clickElement(DEPENDANTS_XPATH);
        return this;
    }

    @Override
    public IFormsMenu clickDependants(String singleOrDouble) {
        if ( singleOrDouble.equals("single"))
            clickElement(DEPENDANTS_XPATH);
        else
            clickElement(DEPENDANTS_COMMON_XPATH);
        return this;
    }

    @Override
    public boolean isDependantFormDone(String singleOrDouble) {
        if ( singleOrDouble.equals("single")) {
            return isVisible(DEPENDANTS_DONE_XPATH, false, 10);
        }
        else {
            return isVisible(DEPENDANTS_COMMON_DONE_XPATH, false, 10);
        }
    }

    @Override
    public IFormsMenu clickFinancialAssets() {
//        isVisible(FINANCIAL_ASSETS_XPATH, true);
//        weFinancialAssets.click();
        clickElement(FINANCIAL_ASSETS_XPATH);
        return this;
    }

    @Override
    public IFormsMenu clickFinancialAssets(String singleOrDouble) {
        if ( singleOrDouble.equals("single"))
            clickElement(FINANCIAL_ASSETS_XPATH);
        else
            clickElement(FINANCIAL_ASSETS_COMMON_XPATH);
        return this;
    }

    @Override
    public boolean isFinancialAssetsFormDone(String singleOrDouble) {
        if ( singleOrDouble.equals("single")) {
            return isVisible(FINANCIAL_ASSETS_DONE_XPATH, false, 10);
        }
        else {
            return isVisible(FINANCIAL_COMMITMENTS_DONE_XPATH, false, 10);
        }
    }

    @Override
    public IFormsMenu clickProperties() {
//        isVisible(PROPERTIES_XPATH, true);
//        weProperties.click();
        clickElement(PROPERTIES_XPATH);
        return this;
    }

    @Override
    public IFormsMenu clickProperties(String singleOrDouble) {
        if ( singleOrDouble.equals("single"))
            clickElement(PROPERTIES_XPATH);
        else
            clickElement(PROPERTIES_COMMON_XPATH);
        return this;
    }

    @Override
    public boolean isPropertiesDone(String singleOrDouble) {
        if ( singleOrDouble.equals("single")) {
            return isVisible(PROPERTIES_DONE_XPATH, false, 10);
        }
        else {
            return isVisible(PROPERTIES_COMMON_DONE_XPATH, false, 10);
        }
    }

    @Override
    public IFormsMenu clickFinancialCommitments() {
        clickElement(FINANCIAL_COMMITMENTS_XPATH);
        return this;
    }

    @Override
    public IFormsMenu clickFinancialCommitments(String singleOrDouble) {
        if ( singleOrDouble.equals("single"))
            clickElement(FINANCIAL_COMMITMENTS_XPATH);
        else
            clickElement(FINANCIAL_COMMITMENTS_COMMON_XPATH);
        return this;
    }

    @Override
    public boolean isFinancialCommitmentsFormDone(String singleOrDouble) {
        if ( singleOrDouble.equals("single")) {
            return isVisible(FINANCIAL_COMMITMENTS_DONE_XPATH, false, 10);
        }
        else {
            return isVisible(FINANCIAL_COMMITMENTS_COMMON_DONE_XPATH, false, 10);
        }
    }

    @Override
    public IFormsMenu clickFunding() {
        clickElement(FUNDING_XPATH);
        return this;
    }

    @Override
    public IFormsMenu clickFunding(String singleOrDouble) {
        if ( singleOrDouble.equals("single"))
            clickElement(FUNDING_XPATH);
        else
            clickElement(FUNDING_COMMON_XPATH);
        return this;
    }

    @Override
    public boolean isFundingFormDone(String singleOrDouble) {
        if ( singleOrDouble.equals("single")) {
            return isVisible(FUNDING_DONE_XPATH, false, 10);
        }
        else {
            return isVisible(FUNDING_COMMON_DONE_XPATH, false, 10);
        }
    }

    @Override
    public IFormsMenu clickDocumentUpload() {
//        isVisible(DOCUMENT_UPLOAD_XPATH, true);
//        weDocumentUpload.click();
        clickElement(DOCUMENT_UPLOAD_XPATH);
        if(isVisible(INDICATOR_SMALL_ON, false, 5))
            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public boolean isLoaded() {
        isVisible(DASHBOARD_LINK_XPATH, true);
        isVisible(FORM_TITLE_XPATH, true);
        isVisible(FINANCIAL_COMMITMENTS_XPATH, true);
        isVisible(FUNDING_XPATH, true);
        isVisible(DOCUMENT_UPLOAD_XPATH, true);
        return true;
    }
}
