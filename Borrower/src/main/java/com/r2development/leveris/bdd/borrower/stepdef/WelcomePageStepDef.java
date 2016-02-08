package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.WelcomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Singleton
public class WelcomePageStepDef extends AbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(WelcomePageStepDef.class);

    @Given("^user is on Abakus Borrower homepage$")
    public void user_is_on_Abakus_Borrower_homepage() {
        welcomePage = new WelcomePage(WebDriverService.getWebDriverInstance());
        welcomePage.isLoaded();
    }

    private void user_clicks_on_register_link() {
        registerPage = welcomePage.clickRegister();
        registerPage.isLoaded();
    }

    private void user_clicks_on_login_link() {
        loginPage = welcomePage.clickLogin();
    }

    private void user_clicks_on_quote_link() {
        buildQuotationPage = welcomePage.clickQuote();
    }

    @When("^user clicks on (Register|Login|Quote) link on Welcome Page$")
    public void user_clicks_on_link(String link) {
        switch (link) {
            case "Register":
                user_clicks_on_register_link();
                break;
            case "Login":
                user_clicks_on_login_link();
                break;
            case "Quote":
                user_clicks_on_quote_link();
                break;
            default:
        }
    }

    private void welcome_page_loaded() {
        welcomePage.isLoaded();
    }

    private void register_page_loaded() {
        registerPage.isLoaded();
    }

    private void login_page_loaded() {
        loginPage.isLoaded();
    }

    private void welcome_quote_page_loaded() {
        buildQuotationPage.isWelcomeQuoteLoaded();
    }

    @Then("^(Welcome|Register|Login|Welcome Quote) page is loaded")
    public void page_loaded(String page) {
        switch (page) {
            case "Welcome page":
                welcome_page_loaded();
                break;
            case "Register":
                register_page_loaded();
                break;
            case "Login":
                login_page_loaded();
                break;
            case "Welcome Quote":
                welcome_quote_page_loaded();
                break;
            default:
        }
    }

    private void closeLogin() {
        welcomePage = loginPage.closeLogin();
    }

    private void closeRegister() {
        welcomePage = registerPage.closeRegister();
    }

    private void closeWelcomeQuote() {
        welcomePage = buildQuotationPage.closeWelcomeQuote();
    }

    @When("^(Login|Register|Welcome Quote) page is closed$")
    public void page_is_closed(String page) {
        switch (page) {
            case "Login":
                closeLogin();
                break;
            case "Register":
                closeRegister();
                break;
            case "welcome Quote":
                closeWelcomeQuote();
            default:
        }
        welcomePage.isLoaded();
    }
}
