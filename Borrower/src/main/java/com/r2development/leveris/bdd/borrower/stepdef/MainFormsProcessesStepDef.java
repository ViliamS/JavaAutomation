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

    private static final Log log = LogFactory.getLog(MainFormsProcessesStepDef.class.getName());
    private final SharedDriver webDriver;

    @Inject
    IUser user;
    private IBorrowerHomePage borrowerHomePage;
    private IPersonalDetailsPage borrowerPersonalDetailsPage;
    private IEmploymentIncomesPage borrowerEmploymentIncomesPage;
    private IPersonalDetailsPage coapplicantPersonalDetailsPage;
    private IEmploymentIncomesPage coapplicantEmploymentIncomesPage;
    private IYourAccountsPage yourAccountsPage;
    private IFormsMenu currentPage;
    private IDocumentUploadPage documentUploadPage;
    private IYourFinancialCommitmentsPage yourFinancialCommitmentsPage;
    private IYourDependantsPage yourDependantsPage;

    @Inject
    public MainFormsProcessesStepDef(SharedDriver webDriver) {
//        super(webDriver);
        this.webDriver = webDriver;
        borrowerHomePage = new BorrowerHomePage(webDriver);

    }

    // "proxy page"
    @And("^Borrower processes \"Forms\"$")
    public void user_processes_Forms() {
        borrowerPersonalDetailsPage = borrowerHomePage.clickInfoUpload();
        currentPage = (IFormsMenu) borrowerPersonalDetailsPage;
    }

//    @When("^Borrower clicks \"Dashboard\"$")
//    public void user_clicks_Dashboard() {
//        formsPage.clickDashboard();
//    }

    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();
    }

    @When("^Borrower clicks \"Borrower Personal Details\"$")
    public void user_clicks_Borrower_Personal_Details() {
//        workaroundCLV312("borrower");
        currentPage.clickSingleBorrowerPersonalDetails();
        currentPage = (IFormsMenu) borrowerPersonalDetailsPage;
    }

    @When("^Borrower clicks \"Borrower Employment Income\"$")
    public void clickBorrowerEmploymentIncome() throws InterruptedException {
        // TODO to redesign as Borrower_Personal_Details
        currentPage.clickBorrowerEmploymentIncome();
        currentPage = (IFormsMenu) borrowerEmploymentIncomesPage;
    }

    @When("^Borrower clicks \"Coapplicant Personal Details\"$")
    public void clickCoapplicantPersonalDetails() {
    }

    @When("^Borrower clicks \"Coapplicant Employment Income\"$")
    public void clickCoapplicantEmploymentIncome() {
    }

    @When("^Borrower clicks \"Account\"$")
    public void clickAccount() {
        currentPage.clickAccount();
        currentPage = (IFormsMenu) yourAccountsPage;
    }

    @When("^Borrower clicks \"Dependants\"$")
    public void clickDependants() {
        currentPage.clickDependants();
        currentPage = (IFormsMenu) yourDependantsPage;
    }

    @When("^Borrower clicks \"Financial Assets\"$")
    public void clickFinancialAssets() {
        currentPage.clickFinancialAssets();
        currentPage = (IFormsMenu) yourDependantsPage;
    }

    @When("^Borrower clicks \"Financial Commitments\"$")
    public void clickFinancialCommitments() {

        currentPage.clickFinancialCommitments();

        currentPage = (IFormsMenu) yourFinancialCommitmentsPage;
    }

    @When("^Borrower clicks \"Document Upload\"$")
    public void clickDocumentUpload() {

        currentPage.clickDocumentUpload();

        currentPage = (IFormsMenu) documentUploadPage;
    }

    @When("^Borrower clicks \"Home\"$")
    public void clickHome() {
        currentPage.clickHome();
        currentPage = (IFormsMenu) borrowerHomePage;
    }

}
