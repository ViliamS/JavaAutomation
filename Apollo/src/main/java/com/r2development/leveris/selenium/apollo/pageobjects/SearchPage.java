package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class SearchPage extends Apollo implements ISearchPage, IResultSection, ISearchSection, IHeaderSection {

    private static final Log log = LogFactory.getLog(SearchPage.class);
    private IHeaderSection headerSection; // = new HeaderSection();
    private ISearchSection searchSection; // = new SearchFullTextSection();
    private IResultSection resultSection;

    public static ISearchPage getSearchSectionInstance(SharedDriver_Apollo webDriver) {
//        ISearchPage searchPage = new SearchPage(webDriver).waitForPageToLoad();
        ISearchPage searchPage = new SearchPage(webDriver);
        PageFactory.initElements(webDriver, searchPage);
        return searchPage;
    }

    public static ISearchPage getSearchSectionInstance(SharedDriver_Apollo webDriver, ISearchSection iSearchSection) {
//        ISearchPage searchPage = new SearchPage(webDriver).waitForPageToLoad();
        ISearchPage searchPage = new SearchPage(webDriver);
        searchPage.setSearchSection(iSearchSection);
        PageFactory.initElements(webDriver, searchPage);
        return searchPage;
    }

    SearchPage(SharedDriver_Apollo webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = HeaderSection.getHeaderSectionInstance(webDriver);
        searchSection = SearchFullTextSection.getSearchSectionInstance(webDriver);
        resultSection = ResultSection.getResultSectionInstance(webDriver);
    }

    SearchPage(SharedDriver_Apollo webDriver, ISearchSection iSearchSection) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = HeaderSection.getHeaderSectionInstance(webDriver);
        searchSection = iSearchSection;
        resultSection = ResultSection.getResultSectionInstance(webDriver);
    }

    SearchPage(SharedDriver_Apollo webDriver, IHeaderSection iheaderSection, ISearchSection iSearchSection, IResultSection iResultSection) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = iheaderSection;
        searchSection = iSearchSection;
        resultSection = iResultSection;
    }

    @Override
    public ISearchPage setSearchSection(ISearchSection iSearchSection) {
        searchSection = iSearchSection;
        return this;
    }

//    private ISearchPage waitForPageToLoad() {
//        headerSection.waitForHeaderSectionToLoad();
//        searchSection.waitForSearchSectionToLoad();
//        return this;
//    }

    @Override
    public boolean validateSearch() {
        return this.searchSection.validateSearch();
    }

    @Override
    public boolean validateNegativeSearch() {
        return this.searchSection.validateNegativeSearch();
    }

    @Override
    public boolean warningSearch() {
        return this.searchSection.warningSearch();
    }

    @Override
    public boolean warningNegativeSearch() {
        return this.searchSection.warningNegativeSearch();
    }

    @Override
    public ISearchPage clickSearch() {
        this.searchSection.clickSearch();
        return this;
    }

//    @Override
//    public ISearchSection waitForSearchSectionToLoad() {
//        searchSection.waitForSearchSectionToLoad();
//        return this.searchSection;
//    }

//    @Override
//    public IHeaderSection waitForHeaderSectionToLoad() {
//        headerSection.waitForHeaderSectionToLoad();
//        return this.headerSection;
//    }

    @Override
    public ILoginPage clickLogOutButton() {
        return this.headerSection.clickLogOutButton();
    }

    @Override
    public String getVersion() {
        return this.headerSection.getVersion();
    }

    @Override
    public Map<String, String> clickClientOverviewMenu() {
        // TODO implementation
        return null;
    }

    @Override
    public void clickClientOverviewItemMenu() {
        // TODO implementation
    }

    @Override
    public void clickPaymentItemMenu() {
        // TODO implementation
    }

    @Override
    public String getHelpBlockContent() {
        return searchSection.getHelpBlockContent();
    }

    @Override
    public SearchPage changeSearchMode() {
        searchSection = searchSection.changeSearchMode();
        return this;
    }

    @Override
    public SearchPage fillInForm(Map<String, String> data) throws Exception {
        searchSection = searchSection.fillInForm(data);
        return this;
    }

    @Override
    public SearchPage clickReset() {
        searchSection = searchSection.clickReset();
        return this;
    }

    @Override
    public SearchPage extractResult() throws Exception {
        resultSection = resultSection.extractResult();
        return this;
    }

    @Override
    public String getInfoData() throws Exception {
        return this.resultSection.getInfoData();
    }

    @Override
    public IResultSection sortBy(String columnName, String orderBy) throws Exception {
        return this.resultSection.sortBy(columnName, orderBy);
    }

    @Override
    public IRecordPage selectCustomer(int row) throws Exception {
        return this.resultSection.selectCustomer(row);
    }
}

