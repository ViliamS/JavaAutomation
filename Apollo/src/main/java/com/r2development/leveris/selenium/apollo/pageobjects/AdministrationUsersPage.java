package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationUsersPage extends Apollo implements IAdministrationUsersPage {

    private static final Log log = LogFactory.getLog(AdministrationUsersPage.class.getName());

    WebDriver webDriver;

    public AdministrationUsersPage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IAdministrationUsersPage clickAddUser() {
        log.info("\n clickAddUser() \n");
        isVisible(ADD_USER_BUTTON, true);
        clickElement(ADD_USER_BUTTON);
        return this;
    }

    @Override
    public IAdministrationUsersPage clickSearch() {
        log.info("\n clickSearch() \n");
        isVisible(SEARCH_BUTTON, true);
        clickElement(SEARCH_BUTTON);
        return this;
    }

    @Override
    public IAdministrationUsersPage setSearch(String searchedValue) {
        log.info("\n setSearch(String searchedValue) \n searchedValue ---> '" + searchedValue + "' <--- \n");
        isVisible(SEARCH_INPUT);
        type(SEARCH_INPUT, searchedValue);
        return this;
    }

    @Override
    public String getTitle() {
        log.info("\n getTitle() \n");
        isVisible(GET_TITLE, true);
        return getText(getWebElement(GET_TITLE));
    }

    @Override
    public String getFoundXItemsText(){
        return getText(getWebElement(SEARCH_RESULT_TEXT));
    }

    @Override
    public boolean isResultExpected(String searchResultString){
        return getFoundXItemsText().equalsIgnoreCase(searchResultString);
    }


}
