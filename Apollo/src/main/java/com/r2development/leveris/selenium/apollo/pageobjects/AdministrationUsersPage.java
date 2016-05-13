package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;

public class AdministrationUsersPage extends AdministrationTopBanner implements IAdministrationUsersPage {

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
        log.info("\n getFoundXItemsText() \n xpath ---> '" + SEARCH_RESULT_TEXT + "' <---");
        isVisible(SEARCH_RESULT_TEXT, true);
        return getText(getWebElement(SEARCH_RESULT_TEXT));
    }

    @Override
    public boolean isResultExpected(String searchResultString){
        log.info("\n isResultExpected(String searchResultString) \n searchResultString ---> '" + searchResultString + "' \n");
        return getFoundXItemsText().equalsIgnoreCase(searchResultString);
    }

    @Override
    public IAdministrationUsersPage setEmailAddressUsedAsLogin(String setLogin){
        log.info("\n setEmailAddressUsedAsLogin(String setLogin) \n type ---> '" + setLogin + "' \n");
        isVisible(EMAIL_ADDRESS_USED_AS_LOGIN_INPUT, true);
        type(EMAIL_ADDRESS_USED_AS_LOGIN_INPUT, setLogin);
        return this;
    }

    @Override
    public IAdministrationUsersPage setFirstName(String firstName){
        log.info("\n setFirstName(String firstName) \n type ---> '" + firstName + "' \n");
        isVisible(FIRST_NAME_INPUT, true);
        type(FIRST_NAME_INPUT, firstName);
        return this;
    }

    @Override
    public IAdministrationUsersPage setLastName(String lastName){
        log.info("\n setLastName(String lastName) \n type ---> '" + lastName + "' \n");
        isVisible(LAST_NAME_INPUT, true);
        type(LAST_NAME_INPUT, lastName);
        return this;
    }

    @Override
    public IAdministrationUsersPage setPhoneNumber(String phoneNumber){
        log.info("\n setPhoneNumber(String phoneNumber) \n type ---> '" + phoneNumber + "' \n");
        isVisible(PHONE_NUMBER_INPUT, true);
        type(PHONE_NUMBER_INPUT, phoneNumber);
        return this;
    }

    private LinkedList<String> dateOfBirthSplit(String dateOfBirth, String splitChar){
        log.info("\n dateOfBirthSplit(String dateOfBirth, String splitChar) \n type ---> '" + dateOfBirth + "' \n splitChar ---> '" + splitChar + "' <---");
        int indexOf = dateOfBirth.indexOf(splitChar);
        int lastIndexOf = dateOfBirth.lastIndexOf(splitChar);
        String day = dateOfBirth.substring(0, indexOf);
        String month = dateOfBirth.substring(indexOf, lastIndexOf);
        String year = dateOfBirth.substring(lastIndexOf, dateOfBirth.length());

        return new LinkedList<String>(){
            {
                add(0, day);
                add(1, month);
                add(2, year);
            }
        };
    }

    @Override
    public IAdministrationUsersPage setDateOfBirth(String dateOfBirth){
        log.info("\n setDateOfBirth(String dateOfBirth) \n type ---> '" + dateOfBirth + "' \n");
        LinkedList<String> list = new LinkedList<>();
        if (dateOfBirth.contains("."))
           list = dateOfBirthSplit(dateOfBirth, ".");
        else if (dateOfBirth.contains("/"))
            list = dateOfBirthSplit(dateOfBirth, "/");
        else {
            Assert.assertEquals("\n Assertion ERROR \n Unknown format of dateOfBirth \n Please use delimiter characters '.' or '/' |example| DD.MM.YYYY or DD/MM/YYYY \n Current format was ---> '" + dateOfBirth + "' <---", false, true);
        }
        String day = list.get(0);
        String month = list.get(1);
        String year = list.get(2);
        return setDateOfBirth(day, month, year);
    }

    @Override
    public IAdministrationUsersPage setDateOfBirthTest(String dateOfBirth){
        log.info("\n setDateOfBirth(String dateOfBirth) \n type ---> '" + dateOfBirth + "' \n");
        if (dateOfBirth.contains("/"))
            dateOfBirth = dateOfBirth.replace("/", "");
        if (dateOfBirth.contains("."))
            dateOfBirth = dateOfBirth.replace(".", "");

        log.info("\n dateOfBirth ---> '" + dateOfBirth + "'");
        isVisible(DATE_OF_BIRTH_DAY_INPUT, true);
        type(DATE_OF_BIRTH_DAY_INPUT, dateOfBirth);
        return this;
    }

    @Override
    public IAdministrationUsersPage setDateOfBirth(String day, String month, String year){
        log.info("\n setDateOfBirth((String day, String month, String year)) \n type ---> '" + day + "/" + month + "/" + year + "' \n");
        isVisible(DATE_OF_BIRTH_DAY_INPUT, true);
        isVisible(DATE_OF_BIRTH_MONTH_INPUT, true);
        isVisible(DATE_OF_BIRTH_YEAR_INPUT, true);
        type(DATE_OF_BIRTH_DAY_INPUT, day);
        type(DATE_OF_BIRTH_MONTH_INPUT, month);
        type(DATE_OF_BIRTH_YEAR_INPUT, year);
        return this;
    }

    @Override
    public IAdministrationUserDetailPage clickSaveChanges(){
        log.info("\n clickSaveChanges() \n");
        isVisible(SAVE_CHANGES_BUTTON, true);
        clickElement(SAVE_CHANGES_BUTTON);
        return new AdministrationUserDetailPage((SharedDriver) webDriver);
    }
}