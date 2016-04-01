package com.r2development.leveris.selenium.apollo.pageobjects;

import java.util.Map;

public interface ISearchAdvancedSection {
    String FIRSTNAME_XPATH = "//input[@placeholder='First Name']";
    String MIDDLE_NAME_XPATH = "//input[@placeholder='Middle Name']";
    String LAST_NAME_XPATH = "//input[@placeholder='Last Name']";
    String DATE_OF_BIRTH_XPATH = "//input[@placeholder='Date of Birth']";
    String EMAIL_XPATH = "//input[@placeholder='Email']";
    String PHONE_XPATH = "//input[@placeholder='Phone']";
    String ADDRESS_LINE_1_XPATH = "//input[@placeholder='Address Line 1']";
    String ADDRESS_LINE_2_XPATH = "//input[@placeholder='Address Line 2']";
    String RESET_BUTTON_XPATH = "//button[@type='button' and contains(.,' Reset')]";

    String FIRST_NAME = "First Name";
    String MIDDLE_NAME = "Middle Name";
    String LAST_NAME = "Last Name";
    String DATE_OF_BIRTH = "Date Of Birth";
    String EMAIL = "Email";
    String PHONE = "Phone";
    String ADDRESS_LINE_1 = "Address Line 1";
    String ADDRESS_LINE_2 = "Address Line 2";

    boolean validateSearch();
    boolean validateNegativeSearch();
    boolean warningSearch();
    boolean warningNegativeSearch();
    ISearchPage clickSearch();
    //static ISearchSection getSearchSectionInstance(SharedDriver webDriver) { return null; }
//    ISearchSection waitForSearchSectionToLoad();
    String getHelpBlockContent();
    ISearchSection changeSearchMode();
    ISearchSection fillInForm(Map<String, String> data) throws Exception;
    ISearchSection clickReset();
}
