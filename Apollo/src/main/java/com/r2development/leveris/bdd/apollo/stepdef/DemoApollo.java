package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.User;
import com.r2development.leveris.selenium.apollo.pageobjects.ILoginPage;
import com.r2development.leveris.selenium.apollo.pageobjects.IRecordPage;
import com.r2development.leveris.selenium.apollo.pageobjects.ISearchPage;
import com.r2development.leveris.selenium.apollo.pageobjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@Singleton
public class DemoApollo {

    private static final Log log = LogFactory.getLog(DemoApollo.class);

    @Inject
    private WebDriverService webDriverService;

    @Inject
    protected User user;

    protected ILoginPage loginPage;
    protected ISearchPage searchPage;
    protected IRecordPage recordPage;
    protected ClientData clientData = new ClientData();

    @Given("^user is on Apollo homepage$")
    public void user_is_on_Apollo_homepage() {
        loginPage = LoginPage
                .getLoginPageInstance(webDriverService.getWebDriver())
                .setUsername("harry.potter@abakus.com")
                .setPassword("heslo");
        searchPage = loginPage.clickSubmit();
    }

    @Given("^client's (.*) is (.*|\"\")$")
    public void client_data(String key, String value) {
        clientData.put(key, value);
    }

    @Given("^client's data are")
    public void client_data_are(Map<String, String> clientData) {
        this.clientData.putAll(clientData);
    }

    @When("^user searches (.*) as a client on simple search$")
    public void user_searches_a_client_on_simple_search(String client) throws Exception {
        clientData.put("Fulltext search", client);
        search();
    }

    @When("^user searches the created client on simple search$")
    public void user_searches_the_created_client_on_simple() throws Exception {
        clientData.put("Fulltext search", user.getEmail());
        search();
    }

    @When("^user searches a client on advanced search$")
    public void user_searches_a_client_on_advanced_search() throws Exception {
        searchPage.changeSearchMode();
        search();
    }

    @And("^user chooses ([1-9]+)(st|nd|rd|th) client$")
    public void user_chooses_the_client(int row) throws Exception {
        recordPage = searchPage.selectCustomer(row-1);
    }

    @Then("^user checks client's data$")
    public void user_edits_client_s_data() {
        assertEquals("Data are not displayed correctly,", recordPage.checkContactData(), true);
    }

    private void search() throws Exception {
        searchPage
                .fillInForm(clientData.getClientData())
                .clickSearch();
//                .extractResult();
    }
}
