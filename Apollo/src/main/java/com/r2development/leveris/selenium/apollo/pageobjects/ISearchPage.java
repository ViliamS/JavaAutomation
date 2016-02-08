package com.r2development.leveris.selenium.apollo.pageobjects;

import java.util.Map;

public interface ISearchPage {

    //    ISearchPage clickSubmit();
    ISearchPage fillInForm(Map<String, String> data) throws Exception;
    ISearchPage extractResult() throws Exception;
    boolean validateSearch();
    boolean validateNegativeSearch();
    boolean warningSearch();
    boolean warningNegativeSearch();
    ISearchPage clickSearch();
    String getHelpBlockContent();
    IResultSection sortBy(String columnName, String orderBy) throws Exception;
    String getInfoData() throws Exception;
    IRecordPage selectCustomer(int row) throws Exception;
    ISearchPage clickReset();
    ISearchPage changeSearchMode();
    ISearchPage setSearchSection(ISearchSection iSearchSection);
    String getVersion();
}
