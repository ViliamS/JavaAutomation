package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

@Singleton
public class MainFormsProcessesStepDef /*extends BorrowerStepDef*/ implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(MainFormsProcessesStepDef.class);
    private final WebDriver webDriver;

    @Inject
    IUser user;
    IBorrowerHomePage borrowerHomePage;
    IPersonalDetailsPage borrowerPersonalDetailsPage;
    IEmploymentIncomesPage borrowerEmploymentIncomesPage;
    IPersonalDetailsPage coapplicantPersonalDetailsPage;
    IEmploymentIncomesPage coapplicantEmploymentIncomesPage;
    IYourAccountsPage yourAccountsPage;
    IFormsMenu currentPage;
    IDocumentUploadPage documentUploadPage;
    IYourFinancialCommitmentsPage yourFinancialCommitmentsPage;
    IYourDependentsPage yourDependentsPage;

    @Inject
    public MainFormsProcessesStepDef(SharedDriver webDriver) {
//        super(webDriver);
        this.webDriver = webDriver;
        borrowerHomePage = new BorrowerHomePage(webDriver);
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
        currentPage.clickSingleBorrowerPersonalDetails();
        currentPage = (IFormsMenu) borrowerPersonalDetailsPage;
    }

    @When("^user clicks \"Borrower Employment Income\"$")
    public void clickBorrowerEmploymentIncome() throws InterruptedException {
        // TODO to redesign as Borrower_Personal_Details
        currentPage.clickBorrowerEmploymentIncome();
        currentPage = (IFormsMenu) borrowerEmploymentIncomesPage;
    }

    @When("^user clicks \"Coapplicant Personal Details\"$")
    public void clickCoapplicantPersonalDetails() {
    }

    @When("^user clicks \"Coapplicant Employment Income\"$")
    public void clickCoapplicantEmploymentIncome() {
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

    @When("^user clicks \"Financial Commitments\"$")
    public void clickFinancialCommitments() {
        currentPage.clickFinancialCommitments();
        currentPage = (IFormsMenu) yourFinancialCommitmentsPage;
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
