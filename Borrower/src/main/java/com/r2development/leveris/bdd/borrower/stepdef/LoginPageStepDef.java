package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.LoginData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Singleton
public class LoginPageStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(LoginPageStepDef.class.getName());
    private final WebDriver webDriver;

    @Inject
    IUser user;
    private ILoginPage loginPage;
//    private IBorrowerHomePage borrowerHomePage;
    private IWelcomePage welcomePage;
//    private IBuildQuotationPage buildQuotationPage;

    @Inject
    LoginPageStepDef(SharedDriver webDriver/*, IUser user*/) {
//        super(webDriver);
//        loginPage = new LoginPage(WebDriverService.getWebDriverInstance());
        this.webDriver = webDriver;
//        this.user = user;
        welcomePage = new WelcomePage(webDriver);
    }

    @Given("^Borrower types his email login (.*) in Login page$")
    public void user_types_his_login(String email) {
        loginPage.setEmailAddress(email);
    }

    @Given("^Borrower types his pwd (.*) in Login page$")
    public void user_types_his_pwd(String pwd) {
        loginPage.setPassword(pwd);
    }

    @When("^Borrower logs in$")
    public void user_logs_in() {
        loginPage.clickLogin();
    }

    @When("^Borrower forgets his password$")
    public void user_forgets_his_password() {
        loginPage.clickForgotPassword();
    }

    @When("^Borrower closes the login page")
    public void user_closes_the_login_page() {
        loginPage.closeLogin();
    }

    @When("^Borrower wants to (show|hide) his password in Login page$")
    public void user_wants_to_his_password(String showOrHide) {
        loginPage = (showOrHide.equals("show") ? loginPage.clickShowPassword() : loginPage.clickHidePassword());
    }

    @Given("^Borrower loggins into application$")
    public void borrower_loggins_into_application(List<String> login){

        LoginData loginData = new LoginData(login);

        welcomePage = new WelcomePage((SharedDriver)webDriver, true);
        loginPage = welcomePage.clickSignIn();
        log.info("\n --------------------------------------------------------------------------------------------------- \n" +
                " | \n ---> Email : " + loginData.get("email") + " <--- \n" +
                " | \n --------------------------------------------------------------------------------------------------- \n");
        user_types_his_login(loginData.get("email"));
        log.info("\n --------------------------------- \n" +
                " | \n ---> Pwd : " + loginData.get("password") + " <--- \n" +
                " | \n --------------------------------- \n");
        user_types_his_pwd(loginData.get("password"));
        user_logs_in();


    }

    @Then("^Home Borrower Page is loaded$")
    public void home_borrower_page_is_loaded() {
        try {
//            borrowerHomePage = new BorrowerHomePage(WebDriverService.getWebDriverInstance());
//            borrowerHomePage = new BorrowerHomePage((SharedDriver)webDriver);
            new BorrowerHomePage((SharedDriver)webDriver).clickGetQuoteOrGetStarted();
//            borrowerHomePage.clickGetQuoteOrGetStarted();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        buildQuotationPage = new BuildQuotationPage(WebDriverService.getWebDriverInstance());
        IBuildQuotationPage buildQuotationPage = new BuildQuotationPage((SharedDriver)webDriver);
        buildQuotationPage.isLoaded();
    }

    @Deprecated @And("^Borrower logs in as his account is activated$")
    public void user_logs_in_as_his_account_is_activated() throws Exception {
        loginPage = welcomePage.clickSignIn();
//        activateAccount(user.getEmail());
        log.info("\n --------------------------------------------------------------------------------------------------- \n" +
                " | \n ---> Email : " + user.getEmail() + " <--- \n" +
                " | \n --------------------------------------------------------------------------------------------------- \n");
        user_types_his_login(user.getEmail());
        log.info("\n --------------------------------- \n" +
                " | \n ---> Pwd : " + user.getPwd() + " <--- \n" +
                " | \n --------------------------------- \n");
        user_types_his_pwd(user.getPwd());
        user_logs_in();
    }

    @When("^Borrower logs in with these credentials$")
    public void user_logs_in_with_these_credentials(List<String> credentials) throws Exception {
        user.setEmail(credentials.get(0));
        user.setPwd(credentials.get(1));
        user_logs_in_as_his_account_is_activated();
    }

    /*
    private void activateAccount(String emailAsUserLoginId) throws Exception {
        //noinspection ConstantConditions
        File file = new File(LoginPageStepDef.class.getClassLoader().getResource("tnsnames.ora").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));
        System.setProperty("oracle.net.tns_admin", file.getParentFile().getAbsolutePath());

        if (StringUtils.isEmpty(System.getProperty("database")))
            System.setProperty("database", "jdbc:oracle:thin:@DV2000.LEVERIS");

        Orasql.executeSqlUpdateQuery(System.getProperty("database"), "stable_pxmchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + user.getEmail() + "'");
    }
    */
}
