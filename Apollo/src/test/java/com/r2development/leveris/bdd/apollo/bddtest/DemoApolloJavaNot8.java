package com.r2development.leveris.bdd.apollo.bddtest;

import com.r2development.leveris.AUTOMATION_MODE;
import com.r2development.leveris.bdd.apollo.stepdef.ClientData;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import com.r2development.leveris.selenium.apollo.pageobjects.ILoginPage;
import com.r2development.leveris.selenium.apollo.pageobjects.IRecordPage;
import com.r2development.leveris.selenium.apollo.pageobjects.ISearchPage;
import com.r2development.leveris.selenium.apollo.pageobjects.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DemoApolloJavaNot8 {

    private static final Log log = LogFactory.getLog(DemoApolloJavaNot8.class.getName());

    private SharedDriver_Apollo webDriver = new SharedDriver_Apollo();

    protected ILoginPage loginPage;
    protected ISearchPage searchPage;
    protected IRecordPage recordPage;
    protected ClientData clientData = new ClientData();

    @Before
    public void setup() {

        SharedDriver_Apollo webDriver = new SharedDriver_Apollo();
//        switch (BROWSER_TYPE.getBrowser(System.getProperty("browser"))) {
//            case CHROME:
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("ui-prioritize-in-gpu-process");
//                options.addArguments("--start-maximized");
//                webDriver = new ChromeDriver(options);
//                webDriver.manage().window().maximize();
//                break;
//            case PHANTHOMJS:
//                break;
//            case FIREFOX:
//                break;
//            case IE:
//                break;
//            default:
//
//        }
    }

    @After
    public void teardown(Scenario scenario) {

        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
//                File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(srcFile, new File(./target/scenario.getName() + ".png"));
//                log.info("Log Info: " + scenario.getName());
//                log.info("Log Info2: " + scenario.getId());
            }
        }
        finally {

//            if (AUTOMATION_MODE.compareTo(AUTOMATION_MODE.PROD)==0) {
            if (AUTOMATION_MODE.getAutomationMode(System.getProperty("automation.mode")).compareTo(AUTOMATION_MODE.PROD)==0) {
                if ( webDriver!= null )
                    webDriver.quit();
            }
        }
    }

    @Given("^user is on Apollo homepage$")
    public void user_is_on_Apollo_homepage() {
        loginPage = LoginPage
                .getLoginPageInstance(webDriver)
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

    @When("^user searches a client on advanced search$")
    public void user_searches_a_client_on_advanced_search() throws Exception {
        searchPage.changeSearchMode();
        search();
    }

    @And("^user chooses (.*)st|nd|rd|th client$")
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
                .clickSearch()
                .extractResult();
    }
}