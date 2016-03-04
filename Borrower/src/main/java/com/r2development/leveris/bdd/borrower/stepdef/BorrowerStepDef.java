package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class BorrowerStepDef /*extends Abakus*/ /*implements IBorrower*/ {

    private static final Log log = LogFactory.getLog(BorrowerStepDef.class);

    IWelcomePage welcomePage;
    IRegisterPage registerPage;
    ILoginPage loginPage;
    IAutomaticRegistrationPage automaticRegistrationPage;
    IVerifyEmailPage verifyEmailPage;
    IBuildQuotationPage buildQuotationPage;
    IBorrowerHomePage borrowerHomePage;
    INewPasswordPage newPasswordPage;
    IFormsMenu formsMenu;
    IPersonalDetailsPage borrowerPersonalDetailsPage;
    IPersonalDetailsPage coapplicantPersonalDetailsPage;
    IEmploymentIncomesPage borrowerEmploymentIncomesPage;
    IEmploymentIncomesPage coapplicantEmploymentIncomesPage;
    IYourAccountsPage yourAccountsPage;
    IYourDependantsPage yourDependentsPage;
    IYourFinancialCommitmentsPage yourFinancialCommitmentsPage;
    IDocumentUploadPage documentUploadPage;
    IFormsMenu currentPage;

    IQuoteLandingPage quoteLandingPage;
    IQuoteQuickLoanPage quoteQuickLoanPage;
    IQuotePaydayLoanPage quotePaydayLoanPage;
    IQuoteConfigurationPage quoteConfigurationPage;
//    IRegisterPage registerPage;

    ITopBannerMenu topBannerMenu;

    @Inject
    IUser user;
//    @Inject
    WebDriver webDriver;

//    public BorrowerStepDef() {
//
//    }

//    public BorrowerStepDef() {
//        quoteLandingPage = new QuoteLandingPage(WebDriverService.getWebDriverInstance());
//        quoteQuickLoanPage = new QuoteQuickLoanPage(WebDriverService.getWebDriverInstance());
//        quotePaydayLoanPage = new QuotePaydayLoanPage(WebDriverService.getWebDriverInstance());
//        quoteConfigurationPage = new QuoteConfigurationPage(WebDriverService.getWebDriverInstance());
//
//        welcomePage = new WelcomePage(WebDriverService.getWebDriverInstance());
//        registerPage = new RegisterPage(WebDriverService.getWebDriverInstance());
//        loginPage = new LoginPage(WebDriverService.getWebDriverInstance());
//        verifyEmailPage = new VerifyEmailPage(WebDriverService.getWebDriverInstance());
//        buildQuotationPage = new BuildQuotationPage(WebDriverService.getWebDriverInstance());
//        addYourCoapplicantPage = new AddYourCoapplicantPage(WebDriverService.getWebDriverInstance());
//        borrowerHomePage = new BorrowerHomePage(WebDriverService.getWebDriverInstance());
//        newPasswordPage = new NewPasswordPage(WebDriverService.getWebDriverInstance());
//        //IFormsPage formsPage;
////        formsMenu = new FormsMenu(WebDriverStepDef.getWebDriverInstance());
//        borrowerPersonalDetailsPage = new PersonalDetailsPage(WebDriverService.getWebDriverInstance());
//        coapplicantPersonalDetailsPage = new PersonalDetailsPage(WebDriverService.getWebDriverInstance());
//        borrowerEmploymentIncomesPage = new EmploymentIncomesPage(WebDriverService.getWebDriverInstance());
//        coapplicantEmploymentIncomesPage = new EmploymentIncomesPage(WebDriverService.getWebDriverInstance());
//        yourAccountsPage = new YourAccountsPage(WebDriverService.getWebDriverInstance());
//        yourDependentsPage = new YourDependantsPage(WebDriverService.getWebDriverInstance());
//        yourFinancialAssetsPage = new YourFinancialAssetsPage(WebDriverService.getWebDriverInstance());
//        yourFundingPage = new YourFundingPage(WebDriverService.getWebDriverInstance());
//        yourFinancialCommitmentsPage = new YourFinancialCommitmentsPage(WebDriverService.getWebDriverInstance());
//        documentUploadPage = new DocumentUploadPage(WebDriverService.getWebDriverInstance(), user);
//    }

//    @Inject
//    public BorrowerStepDef(User user) {
////        super(webDriver);
//        this.user = user;
//    }

    @Inject
//    BorrowerStepDef(WebDriver webDriver, User user) {
    BorrowerStepDef(SharedDriver webDriver/*, IUser user*/) {
//        super(webDriver);
//        this.user = user;

        this.webDriver = webDriver;
//        this.user = user;

        quoteLandingPage = new QuoteLandingPage(webDriver);
        quoteQuickLoanPage = new QuoteQuickLoanPage(webDriver);
        quotePaydayLoanPage = new QuotePaydayLoanPage(webDriver);
        quoteConfigurationPage = new QuoteConfigurationPage(webDriver);

        welcomePage = new WelcomePage(webDriver);
        registerPage = new RegisterPage(webDriver);
        loginPage = new LoginPage(webDriver);
        verifyEmailPage = new VerifyEmailPage(webDriver);
        buildQuotationPage = new BuildQuotationPage(webDriver);
        borrowerHomePage = new BorrowerHomePage(webDriver);
        newPasswordPage = new NewPasswordPage(webDriver);
        //IFormsPage formsPage;
//        formsMenu = new FormsMenu(WebDriverStepDef.getWebDriverInstance());
        borrowerPersonalDetailsPage = new PersonalDetailsPage(webDriver);
        coapplicantPersonalDetailsPage = new PersonalDetailsPage(webDriver);
        borrowerEmploymentIncomesPage = new EmploymentIncomesPage(webDriver);
        coapplicantEmploymentIncomesPage = new EmploymentIncomesPage(webDriver);
        yourAccountsPage = new YourAccountsPage(webDriver);
        yourDependentsPage = new YourDependantsPage(webDriver);
        yourFinancialCommitmentsPage = new YourFinancialCommitmentsPage(webDriver);
//        documentUploadPage = new DocumentUploadPage(webDriver, user);
    }

}
