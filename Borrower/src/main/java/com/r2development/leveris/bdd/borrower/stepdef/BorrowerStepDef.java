package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.User;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Singleton
public class BorrowerStepDef /*extends Abakus*/ /*implements IBorrower*/ {

    private static final Log log = LogFactory.getLog(BorrowerStepDef.class);

    IWelcomePage welcomePage;
    IRegisterPage registerPage;
    ILoginPage loginPage;
    IAutomaticRegistrationPage automaticRegistrationPage;
    IVerifyEmailPage verifyEmailPage;
    IBuildQuotationPage buildQuotationPage;
    IAddYourCoapplicantPage addYourCoapplicantPage;
    IBorrowerHomePage borrowerHomePage;
    INewPasswordPage newPasswordPage;
    IFormsMenu formsMenu;
    IPersonalDetailsPage borrowerPersonalDetailsPage;
    IPersonalDetailsPage coapplicantPersonalDetailsPage;
    IEmploymentIncomesPage borrowerEmploymentIncomesPage;
    IEmploymentIncomesPage coapplicantEmploymentIncomesPage;
    IYourAccountsPage yourAccountsPage;
    IYourDependentsPage yourDependentsPage;
    IYourFinancialAssetsPage yourFinancialAssetsPage;
    IYourFundingPage yourFundingPage;
    IYourFinancialCommitmentsPage yourFinancialCommitmentsPage;
    IYourPropertiesPage yourPropertiesPage;
    IDocumentUploadPage documentUploadPage;
    IFormsMenu currentPage;

    IQuoteLandingPage landingPage;
    IQuoteQuickLoanPage quickLoanPage;
    IQuoteConfigurationPage quoteConfigurationPage;

    ITopBannerMenu topBannerMenu;

    @Inject
    User user;
//    @Inject
//    WebDriver webDriver;

    public BorrowerStepDef() {
        landingPage = new QuoteLandingPage(WebDriverService.getWebDriverInstance());
        //quickLoanPage = new QuoteQuickLoanPage(WebDriverService.getWebDriverInstance());
        //quoteConfigurationPage = new QuoteConfigurationPage(WebDriverService.getWebDriverInstance());

        welcomePage = new WelcomePage(WebDriverService.getWebDriverInstance());
        registerPage = new RegisterPage(WebDriverService.getWebDriverInstance());
        loginPage = new LoginPage(WebDriverService.getWebDriverInstance());
        verifyEmailPage = new VerifyEmailPage(WebDriverService.getWebDriverInstance());
        buildQuotationPage = new BuildQuotationPage(WebDriverService.getWebDriverInstance());
        addYourCoapplicantPage = new AddYourCoapplicantPage(WebDriverService.getWebDriverInstance());
        borrowerHomePage = new BorrowerHomePage(WebDriverService.getWebDriverInstance());
        newPasswordPage = new NewPasswordPage(WebDriverService.getWebDriverInstance());
        //IFormsPage formsPage;
//        formsMenu = new FormsMenu(WebDriverStepDef.getWebDriverInstance());
        borrowerPersonalDetailsPage = new PersonalDetailsPage(WebDriverService.getWebDriverInstance());
        coapplicantPersonalDetailsPage = new PersonalDetailsPage(WebDriverService.getWebDriverInstance());
        borrowerEmploymentIncomesPage = new EmploymentIncomesPage(WebDriverService.getWebDriverInstance());
        coapplicantEmploymentIncomesPage = new EmploymentIncomesPage(WebDriverService.getWebDriverInstance());
        yourAccountsPage = new YourAccountsPage(WebDriverService.getWebDriverInstance());
        yourDependentsPage = new YourDependentsPage(WebDriverService.getWebDriverInstance());
        yourFinancialAssetsPage = new YourFinancialAssetsPage(WebDriverService.getWebDriverInstance());
        yourFundingPage = new YourFundingPage(WebDriverService.getWebDriverInstance());
        yourFinancialCommitmentsPage = new YourFinancialCommitmentsPage(WebDriverService.getWebDriverInstance());
        documentUploadPage = new DocumentUploadPage(WebDriverService.getWebDriverInstance(), user);
    }

    @Inject
    public BorrowerStepDef(User user) {
//        super(webDriver);
        this.user = user;
    }
}
