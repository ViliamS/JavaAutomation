package com.r2development.leveris.selenium.apollo.pageobjects;

import java.util.Map;

interface ISearchFullTextSection {

    String INPUT_SEARCH_XPATH = "//input[@placeholder='Fulltext Search']";

    boolean validateSearch();
    boolean validateNegativeSearch();
    boolean warningSearch();
    boolean warningNegativeSearch();
    ISearchPage clickSearch();
    //static ISearchSection getSearchSectionInstance(WebDriver webDriver) { return null; }
//    ISearchSection waitForSearchSectionToLoad();
    String getHelpBlockContent();
    ISearchSection changeSearchMode();
    ISearchSection fillInForm(Map<String, String> data) throws Exception;
    ISearchSection clickReset();
}
