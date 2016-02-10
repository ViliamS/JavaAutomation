package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Singleton
public class MainFormsProcessesStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(MainFormsProcessesStepDef.class);

    public MainFormsProcessesStepDef() {

    }

    // "proxy page"
    @And("^user processes \"Forms\"$")
    public void user_processes_Forms() {
        borrowerHomePage.clickInfoUpload();
        currentPage = (IFormsMenu) borrowerPersonalDetailsPage;
    }

//    @When("^user clicks \"Dashboard\"$")
//    public void user_clicks_Dashboard() {
//        formsPage.clickDashboard();
//    }


    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();
    }

    @When("^user clicks \"Borrower Personal Details\"$")
    public void user_clicks_Borrower_Personal_Details() {
        workaroundCLV312("borrower");
        if ( StringUtils.isNotEmpty(user.getFirstNameCoApplicant()) ) {
            currentPage.clickCoupleBorrowerPersonalDetails();
            currentPage = (IFormsMenu) borrowerPersonalDetailsPage;
        }
        else {
            currentPage.clickSingleBorrowerPersonalDetails();
            currentPage = (IFormsMenu) borrowerPersonalDetailsPage;
        }

    }

    @When("^user clicks \"Borrower Employment Income\"$")
    public void clickBorrowerEmploymentIncome() throws InterruptedException {
        // TODO to redesign as Borrower_Personal_Details
        if ( StringUtils.isNotEmpty(user.getFirstNameCoApplicant()) ) {
            currentPage.clickBorrowerEmploymentIncome(user.getFirstName());
            currentPage = (IFormsMenu) borrowerPersonalDetailsPage;
        }
        else {
            Thread.sleep(1000);
            currentPage.clickBorrowerEmploymentIncome();
            currentPage = (IFormsMenu) borrowerEmploymentIncomesPage;
        }
    }

    @When("^user clicks \"Coapplicant Personal Details\"$")
    public void clickCoapplicantPersonalDetails() {
        currentPage.clickCoapplicantPersonalDetails(user.getFirstNameCoApplicant());
        currentPage = (IFormsMenu) coapplicantPersonalDetailsPage;
    }

    @When("^user clicks \"Coapplicant Employment Income\"$")
    public void clickCoapplicantEmploymentIncome() {
//        workaroundCLV312(null);
        currentPage.clickCoapplicantEmploymentIncome(user.getFirstNameCoApplicant());
        currentPage = (IFormsMenu) coapplicantEmploymentIncomesPage;
    }

    @When("^user clicks \"Account\"$")
    public void clickAccount() {
        currentPage.clickAccount();
        currentPage = (IFormsMenu) yourAccountsPage;
    }

    @When("^user clicks \"Dependents\"$")
    public void clickDependents() {
        currentPage.clickDependents();
        currentPage = (IFormsMenu) yourDependentsPage;
    }

    @When("^user clicks \"Financial Assets\"$")
    public void clickFinancialAssets() {
        currentPage.clickFinancialAssets();
        currentPage = (IFormsMenu) yourDependentsPage;
    }

    @When("^user clicks \"Properties\"$")
    public void clickProperties() {
        currentPage.clickProperties();
        currentPage = (IFormsMenu) yourPropertiesPage;
    }

    @When("^user clicks \"Financial Commitments\"$")
    public void clickFinancialCommitments() {
        currentPage.clickFinancialCommitments();
        currentPage = (IFormsMenu) yourFinancialCommitmentsPage;
    }

    @When("^user clicks \"Funding\"$")
    public void clickFunding() {
        currentPage.clickFunding();
        currentPage = (IFormsMenu) yourFundingPage;
    }

    @When("^user clicks \"Document Upload\"$")
    public void clickDocumentUpload() {
        currentPage.clickDocumentUpload();
        currentPage = (IFormsMenu) documentUploadPage;
    }

    @When("^user clicks \"Home\"$")
    public void clickHome() {
        currentPage.clickHome();
        currentPage = (IFormsMenu) borrowerHomePage;
    }

}
