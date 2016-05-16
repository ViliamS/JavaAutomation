package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.RegistrationData;
import com.r2development.leveris.selenium.apollo.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class OpoqoApolloStepDef {

    private SharedDriver_Apollo webDriver;
    private IAdministrationLoginPage administrationLoginPage;
    private IAdministrationHomePage administrationHomePage;
    private IAdministrationUsersPage administrationUserPage;
    private IAdministrationTopBanner administrationTopBanner;
    private IAdministrationUserDetailPage administrationUserDetailPage;
    private IAdministrationAssignRolesPage administrationAssignRolesPage;
    private RegistrationData registrationData;

    private static final Log log = LogFactory.getLog(OpoqoApolloStepDef.class.getName());

    private String searchLoginID;

    @Inject
    public OpoqoApolloStepDef(SharedDriver_Apollo webDriver){
        this.webDriver = webDriver;
        administrationLoginPage = new AdministrationLoginPage(webDriver);
        administrationHomePage = new AdministrationHomePage(webDriver);
        administrationUserPage = new AdministrationUsersPage(webDriver);
        administrationTopBanner = new AdministrationTopBanner(webDriver);
        administrationUserDetailPage = new AdministrationUserDetailPage(webDriver);
        administrationAssignRolesPage = new AdministrationAssignRolesPage(webDriver);
    }

    @When("^Go to Apollo Administration Login page$")
    public void go_to_user_administration(){
        administrationLoginPage = new AdministrationLoginPage(webDriver)
                .goToApolloAdministrationLoginPage();
    }

    @And("^Set username \"(admin)\" with password \"(changemenow!)\" and click login$")
    public void set_username_with_password_and_click_login(String username, String password){
        administrationLoginPage.setUsername(username);
        administrationLoginPage.setPassword(password);
        administrationLoginPage.clickLogin();
    }

    @And("^Admin clicks on the (Users|Top Banner Users|Roles|Fund Manager|Administration) link$")
    public void admin_clicks_on_the_banner_menu_link(String clickOn){

        switch (clickOn){
            case "Users":
                administrationHomePage.clickUsersLink();
                break;

            case "Top Banner Users":
                administrationTopBanner.clickBannerLinkUsers();
                break;
            default:
                Assert.assertTrue("Not covered case tp navigate", false);
        }
    }

    @And("^Admin set User Search criteria: (.*) and triggers Search$")
    public void admin_set_user_search_criteria (String searchCriteria) {
        Assert.assertEquals("Navigation error there is not present 'Users' title on page", administrationUserPage.getTitle(), "Users");
        administrationUserPage.setSearch(searchCriteria);
        this.searchLoginID = searchCriteria;
        administrationUserPage.clickSearch();
    }

    private String userNameTimeStamping(String userName, String testType){
        String[] userNameArray = userName.split("@");
        userName = userNameArray[0] + "." + testType + System.getProperty("timestamp") + "@" + userNameArray[1];
        return userName;
    }

    @And("^Admin set User Search criteria: (.*) and triggers Search \"Generic for Development\"$")
    public void admin_set_user_search_criteria_generic_development_use_only (String searchCriteria) {
        Assert.assertEquals("Navigation error there is not present 'Users' title on page", administrationUserPage.getTitle(), "Users");
        System.setProperty("ApolloAdminNewUser", userNameTimeStamping(searchCriteria, System.getProperty("modeRun")));
        administrationUserPage.setSearch(System.getProperty("ApolloAdminNewUser"));
        administrationUserPage.clickSearch();
    }

    @Then("^Admin checks if User: \"(.*)\" is present$")
    public void admin_checks_if_user_is_present (String userName) {

    }

    @Then("^Admin checks the search result \"(Found )(.*)( items.)\"$")
    public boolean admin_checks_the_search_result_found_amount_items(String found, String amount, String items){
        //  String --->  Found no items.
        String searchResult = found + amount + items;
        return administrationUserPage.isResultExpected(searchResult);
    }

    @Given("^Admin clicks on button Add user$")
    public void admin_clicks_on_button_add_user(){
        administrationUserPage.clickAddUser();
    }

    @Given("^Admin adds a new user$")
    public void admin_adds_a_new_user(List<String> userData){
        this.registrationData = new RegistrationData(userData);
        registerNewUser(registrationData);
    }

    private void registerNewUser(RegistrationData registrationData){
        this.registrationData = registrationData;
        administrationUserPage.setEmailAddressUsedAsLogin(registrationData.getEmail());
        administrationUserPage.setFirstName(registrationData.getFirstName());
        administrationUserPage.setLastName(registrationData.getLastName());
        administrationUserPage.setPhoneNumber(registrationData.getPhoneNumber());
        administrationUserPage.setDateOfBirthTest(registrationData.getDateOfBirth());
        administrationUserDetailPage = administrationUserPage.clickSaveChanges();
        Assert.assertTrue("\n Something gone wrong we detected different user was created !!! \n expected ---> '" + this.registrationData.getEmail() + "' <--- \n Actually created ---> '" + administrationUserDetailPage.getEmail() + "' <--- \n", administrationUserDetailPage.getEmail().equalsIgnoreCase(this.registrationData.getEmail()));
    }

    @When("^Admin checks that (Activation email has not been sent yet)$")
    public void admin_checks_that_activation_email_not_sent_yet(String alertText){
        Assert.assertEquals("\n Expected text ---> '" + alertText + "' <--- \n do not match ---> '" + administrationUserDetailPage.getAlert() + "' <--- \n", administrationUserDetailPage.getAlert(), alertText);
    }

    @Then("^Admin adds Role to the user (.*)$")
    public void admin_adds_role_to_the_user(String roleName){
        administrationAssignRolesPage = administrationUserDetailPage.clickManageRoles();
        administrationAssignRolesPage.assignRole(roleName);
        administrationAssignRolesPage.clickSaveChanges();
    }

    @Then("^Admin Send activation email$")
    public void admin_clicks_on_send_activation_email(){
        administrationUserDetailPage.clickSendActivationEmail();
    }

    @And("^Admin Log-outs from Apollo Administration$")
    public void admin_logouts_from_apollo_administration(){
        administrationLoginPage = administrationTopBanner.logouts();
        administrationLoginPage.isUsernameInputPresent();
    }

    @When("^\"(Found )(.*)( item.| items.)\" is displayed then Admin (Logouts|Creates new user)$")
    public void If_found_number_items_is_true_then_action(String found, String amount, String items, String action){

        String searchResult = found + amount + items;

        if(administrationUserPage.isResultExpected(searchResult)) {
            log.info("\n Test PASSED \n there was expected result ---> 'Found " + amount + " items.'");
            switch (action){

                case "Logouts":

                    admin_logouts_from_apollo_administration();

                    break;

                case "Creates new user":
                    String userRole = "Administrator";
                    Map<String, String> registrationMap = new HashMap<String, String>(){
                        {
                            put("email", searchLoginID);
                            put("firstName", "Test");
                            put("lastName", "Automation");
                            put("phoneNumber", "+420721945999");
                            put("dateOfBirth", "01/07/1977");
                        }
                    };
                    RegistrationData registrationData = new RegistrationData(registrationMap);
                    admin_clicks_on_button_add_user();
                    registerNewUser(registrationData);
                    admin_adds_role_to_the_user(userRole);
                    admin_clicks_on_send_activation_email();
                    break;
            }
        } else {
            log.info("\n Test FAILED \n there was not expected result ---> '" + administrationUserPage.getFoundXItemsText() + "' ! Expected was ---> 'Found " + amount + " items.'");
        }
    }
}