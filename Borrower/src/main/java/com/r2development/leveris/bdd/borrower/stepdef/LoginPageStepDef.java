package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.qa.utils.Orasql;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;

@Singleton
public class LoginPageStepDef /*extends BorrowerStepDef*/ {

    private static final Log log = LogFactory.getLog(LoginPageStepDef.class);
    private final SharedDriver webDriver;

    @Inject
    IUser user;
    ILoginPage loginPage;
    IBorrowerHomePage borrowerHomePage;
    IWelcomePage welcomePage;
    IBuildQuotationPage buildQuotationPage;

    @Inject
    LoginPageStepDef(SharedDriver webDriver/*, IUser user*/) {
//        super(webDriver);
//        loginPage = new LoginPage(WebDriverService.getWebDriverInstance());
        this.webDriver = webDriver;
//        this.user = user;
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

    @And("^Borrower user logs in as his account is activated$")
    public void user_logs_in_as_his_account_is_activated() throws Exception {
        loginPage = welcomePage.clickSignIn();
        activateAccount(user.getEmail());
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

    // TODO ACMESQL or multi git jenkins plugins
    private void activateAccount(String emailAsUserLoginId) throws Exception {
        //noinspection ConstantConditions
        File file = new File(LoginPageStepDef.class.getClassLoader().getResource("tnsnames.ora").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));
        System.setProperty("oracle.net.tns_admin", file.getParentFile().getAbsolutePath());

        if (StringUtils.isEmpty(System.getProperty("database")))
            System.setProperty("database", "jdbc:oracle:thin:@DV2000.LEVERIS");

//        Orasql.displayResult(System.getProperty("database"), "stable_pxmchuser", "heslo", "select * from mch_user where userloginid = '" + user.getEmail() + "'");

        Orasql.executeSqlUpdateQuery(System.getProperty("database"), "stable_pxmchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + user.getEmail() + "'");

//        Orasql.displayResult(System.getProperty("database"), "stable_pxmchuser", "heslo", "select * from mch_user where userloginid = '" + user.getEmail() + "'");

    }
}
