package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.hamcrest.MatcherAssert.assertThat;

@Singleton
public class LoginPageStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(LoginPageStepDef.class);
    private final WebDriver webDriver;
    IUser user;
    ILoginPage loginPage;
    IBorrowerHomePage borrowerHomePage;
    IWelcomePage welcomePage;
    IBuildQuotationPage buildQuotationPage;

    @Inject
    LoginPageStepDef(WebDriver webDriver, IUser user) {
//        super(webDriver);
//        loginPage = new LoginPage(WebDriverService.getWebDriverInstance());
        this.webDriver = webDriver;
        this.user = user;
        welcomePage = new WelcomePage(webDriver);
    }

    @Given("^User types his email login (.*) in Login page$")
    public void user_types_his_login(String email) {
        loginPage.setEmailAddress(email);
    }

    @Given("^User types his pwd (.*) in Login page$")
    public void user_types_his_pwd(String pwd) {
        loginPage.setPassword(pwd);
    }

    @When("^user logs in$")
    public void user_logs_in() {
        loginPage.clickLogin();
    }

    @When("^user forgets his password$")
    public void user_forgets_his_password() {
        loginPage.clickForgotPassword();
    }

    @When("^user closes the login page")
    public void user_closes_the_login_page() {
        loginPage.closeLogin();
    }

    @When("^user wants to (show|hide) his password in Login page$")
    public void user_wants_to_his_password(String showOrHide) {
        loginPage = (showOrHide.equals("show") ? loginPage.clickShowPassword() : loginPage.clickHidePassword());
    }

    @Then("^Home Borrower Page is loaded$")
    public void home_borrower_page_is_loaded() {
        try {
//            borrowerHomePage = new BorrowerHomePage(WebDriverService.getWebDriverInstance());
            borrowerHomePage = new BorrowerHomePage(webDriver);
            borrowerHomePage.clickGetQuoteOrGetStarted();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        buildQuotationPage = new BuildQuotationPage(WebDriverService.getWebDriverInstance());
        buildQuotationPage = new BuildQuotationPage(webDriver);
        buildQuotationPage.isLoaded();
    }

    @And("^user logs in as his account is activated$")
    public void user_logs_in_as_his_account_is_activated() throws Exception {
//        verifyEmailPage = new VerifyEmailPage(ApiSupportWebDriverStepDef.getWebDriverInstance());
//        welcomePage = verifyEmailPage.redirectToWelcomePage();
//        loginPage = welcomePage.clickLogin();
        loginPage = welcomePage.clickSignIn();

        activateAccount(user.getEmail());

        log.info("Email : " + user.getEmail());
        user_types_his_login(user.getEmail());
        log.info("Pwd : " + user.getPwd());
        user_types_his_pwd(user.getPwd());
        user_logs_in();
    }

    // TODO ACMESQL or multi git jenkins plugins
    private void activateAccount(String emailAsUserLoginId) throws Exception {

        //noinspection ConstantConditions
        File file = new File(LoginPageStepDef.class.getClassLoader().getResource("tnsnames.ora").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));

        System.setProperty("oracle.net.tns_admin", file.getParentFile().getAbsolutePath());

        if (StringUtils.isEmpty(System.getProperty("database")))
            System.setProperty("database", "jdbc:oracle:thin:@DV2000.LEVERIS");

        Class.forName("oracle.jdbc.OracleDriver");
//        Connection connection = DriverManager.getConnection(ABAKUS_ENVIRONMENT.get(ENVIRONMENT_RUN).get(APP_TYPE.DB), "anthony_mottot", "Heslo6897");
        Connection connection = DriverManager.getConnection(System.getProperty("database"), "STABLE_PXMCHUSER", "heslo");
        Statement statement = connection.createStatement();

        statement.execute("update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + emailAsUserLoginId + "'");

        statement.close();
        connection.close();

//        Orasql.executeSqlUpdateQuery("jdbc:oracle:thin:@TEST1", "abakus_mchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + emailAsUserLoginId + "'");
//        Orasql.executeSqlUpdateQuery(ABAKUS_ENVIRONMENT.get(ENVIRONMENT_RUN).get(APP_TYPE.DB), "abakus_mchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + emailAsUserLoginId + "'");

//        WebDriver webDriver = ApiSupportWebDriverStepDef.getWebDriverInstance();
//        webDriver.get("gmail.com");

    }
}
