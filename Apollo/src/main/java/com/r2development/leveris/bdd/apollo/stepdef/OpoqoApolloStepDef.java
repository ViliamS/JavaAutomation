package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Inject;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.apollo.pageobjects.*;
import cucumber.api.java.en.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

public class OpoqoApolloStepDef {

    private SharedDriver webDriver;
    private IAdministrationLoginPage administrationLoginPage;
    private IAdministrationHomePage administrationHomePage;
    private IAdministrationUsersPage administrationUserPage;
    @Inject
    OpoqoApolloStepDef(SharedDriver webDriver){
        this.webDriver = webDriver;
        administrationLoginPage = new AdministrationLoginPage(webDriver);
        administrationHomePage = new AdministrationHomePage(webDriver);
        administrationUserPage = new AdministrationUsersPage(webDriver);
    }

    @When("^Go to Apollo Administration Login page$")
    public void go_to_user_administration(){
        administrationLoginPage = AdministrationLoginPage.getLoginPageInstance(webDriver);
    }

    @And("^Set username (Admin) with password (changemenow!) and click login$")
    public void set_username_with_password_and_click_login(String username, String password){
        administrationLoginPage.setUsername(username);
        administrationLoginPage.setPassword(password);
        administrationHomePage = administrationLoginPage.clickLogin();
    }

    @And("^Admin clicks on the (Users|Roles|Fund Manager|Administration) banner menu link$")
    public void admin_clicks_on_the_banner_menu_link(String clickOn){

        switch (clickOn){
            case "Users":
                administrationUserPage = administrationHomePage.clickUsersLink();
                break;

            default:
                Assert.assertTrue("Not covered case tp navigate", false);
        }
    }

    @And("^Admin set User Search criteria: (.*) and triggers Search$")
    public void admin_set_user_search_criteria (String searchCriteria) {
        Assert.assertEquals("Navigation error there is not present 'Users' title on page", administrationUserPage.getTitle(), "Users");
        administrationUserPage.setSearch(searchCriteria);
        administrationUserPage.clickSearch();
    }

    @Then("^Admin checks if User: \"(.*)\" is present$")
    public void admin_checks_if_user_is_present (String userName) {

    }

    @Then("^Admin checks the search result \"(Found )(.*)( items.)\"$")
    public boolean admin_checks_the_search_result_found_amount_items(String found, String amount, String items){
        //  String --->  Found 0 items.
        String searchResult = found + amount + items;
        return administrationUserPage.isResultExpected(searchResult);
    }

    @When("^\"(Found )(.*)( items.)\" is displayed then Admin (Logouts|Creates new user)$")
    public void If_found_number_items_is_true_then_action(String found, String amount, String items, String action){
        String searchResult = found + amount + items;
        if(administrationUserPage.isResultExpected(searchResult)) {

//            log.info("\n Test PASSED \n there was expected result ---> 'Found " + amount + " items.'");

        } else {

//            log.info("\n Test FAILED \n there was not expected result ---> '" + administrationUserPage.getFoundXItemsText() + "' ! Expected was ---> 'Found " + amount + " items.'");

        }
    }
}