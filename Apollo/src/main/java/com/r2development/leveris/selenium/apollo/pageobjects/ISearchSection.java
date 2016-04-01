package com.r2development.leveris.selenium.apollo.pageobjects;

import java.util.Map;

public interface ISearchSection {
    String SUBMIT_BUTTON_XPATH = "//button[@type='submit' and contains(.,'Search')]";
    String HELP_BLOCK_XPATH = "//span[@class='help-block']";
    String ADVANCED_SEARCH_LINK_XPATH = "//a[contains(.,'Go to Advanced search >>')]";
    String FULLTEXT_SEARCH_LINK_XPATH = "//a[contains(.,'Go to Fulltext search >>')]";
    String WARNING_XPATH = "//div[contains(@class, 'alert-warning') and @role='alert']";

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

