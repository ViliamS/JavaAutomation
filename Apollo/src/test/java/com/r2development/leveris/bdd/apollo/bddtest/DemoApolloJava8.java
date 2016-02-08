package com.r2development.leveris.bdd.apollo.bddtest;

import com.r2development.leveris.bdd.apollo.stepdef.ClientData;
import com.r2development.leveris.selenium.apollo.pageobjects.ILoginPage;
import com.r2development.leveris.selenium.apollo.pageobjects.IRecordPage;
import com.r2development.leveris.selenium.apollo.pageobjects.ISearchPage;
import com.r2development.leveris.selenium.apollo.pageobjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class DemoApolloJava8 implements En {

    private static final Log log = LogFactory.getLog(DemoApolloJava8.class);

    private WebDriver webDriver;

    protected ILoginPage loginPage;
    protected ISearchPage searchPage;
    protected IRecordPage recordPage;
    protected ClientData clientData = new ClientData();

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ui-prioritize-in-gpu-process");
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
    }

    @After
    public void teardown() {

        if (System.getProperty("automation.mode").equals("Production")) {
//        if (AUTOMATION_MODE.equals("Production")) {
            if ( webDriver!= null )
                webDriver.quit();
        }
    }

    public DemoApolloJava8() {
        Given("^user is on Apollo homepage$", () -> {

            loginPage = LoginPage
                    .getLoginPageInstance(webDriver)
                    .setUsername("harry.potter@abakus.com")
                    .setPassword("heslo");
            searchPage = loginPage.clickSubmit();
        });

        Given("^client's (.*) is (.*)$", this.clientData::put);
//        Given("^client's (.*) is (.*)$", (String key, String value) -> {
//            this.clientData.put(key, value);
//        });

        Given("^client's data are", this.clientData::putAll);
//        Given("^client's data are", (Map<String, String> clientData) -> {
//            this.clientData.putAll(clientData);
//        });

        When("^user searches (.*) as a client on simple search$", (String client) -> {
            clientData.put("Fulltext search", client);
            try {
                search();
            } catch (Exception e) {
                log.error(e.getMessage());
                log.error(e.fillInStackTrace());
//                throw new Exception("Error on user_chooses_the_client");
            }
        });

        When("^user searches a client on advanced search$", () -> {
            searchPage.changeSearchMode();
            try {
                search();
            } catch (Exception e) {
                log.error(e.getMessage());
                log.error(e.fillInStackTrace());
//                throw new Exception("Error on user_chooses_the_client");
            }
        });

        And("^user chooses (.*)st|nd|rd|th client$", (Integer row) -> {
            try {
                recordPage = searchPage.selectCustomer(row - 1);
            } catch (Exception e) {
                log.error(e.getMessage());
                log.error(e.fillInStackTrace());
//                throw new Exception("Error on user_chooses_the_client");
            }
        });

        Then("^user checks client's data$", () -> {
            assertEquals("Data are not displayed correctly,", recordPage.checkContactData(), true);
        });
    }

    private void search() throws Exception {
        searchPage
                .fillInForm(clientData.getClientData())
                .clickSearch()
                .extractResult();
    }
}

