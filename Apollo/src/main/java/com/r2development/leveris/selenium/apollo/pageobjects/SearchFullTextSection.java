package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class SearchFullTextSection extends Apollo implements ISearchFullTextSection, ISearchSection {

    private static final Log log = LogFactory.getLog(SearchFullTextSection.class);

    @FindBy( xpath = INPUT_SEARCH_XPATH )
    private WebElement weFulltextSearch;

    @FindBy( xpath = SUBMIT_BUTTON_XPATH )
    private WebElement webSubmit;

    //    public static ISearchFullTextSection getSearchSectionInstance(WebDriver webDriver) {
    public static ISearchSection getSearchSectionInstance(WebDriver webDriver) {
//        SearchFullTextSection searchFullTextSection = new SearchFullTextSection(webDriver).waitForSearchSectionToLoad();
        ISearchFullTextSection searchFullTextSection = new SearchFullTextSection(webDriver);
        PageFactory.initElements(webDriver, searchFullTextSection);
//        return searchFullTextSection;
        return (ISearchSection) searchFullTextSection;
    }

    public SearchFullTextSection(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public SearchFullTextSection setFulltextSearch(String fulltextSearch) {
        isVisible(INPUT_SEARCH_XPATH);
        this.weFulltextSearch.clear();
        this.weFulltextSearch.sendKeys(fulltextSearch);
        return this;
    }

    @Override
    public boolean validateSearch() {
        return isVisible(HELP_BLOCK_XPATH);
    }

    @Override
    public boolean validateNegativeSearch() {
        return isInvisible(HELP_BLOCK_XPATH);
    }

    @Override
    public boolean warningSearch() {
        return isVisible(WARNING_XPATH);
    }

    @Override
    public boolean warningNegativeSearch() {
        return isInvisible(WARNING_XPATH);
    }

    @Override
    public ISearchPage clickSearch() {
        webSubmit.click();
        ISearchPage searchPage = SearchPage.getSearchSectionInstance(webDriver, this);
        PageFactory.initElements(webDriver, searchPage);
        return searchPage;
    }

//    @Override
//    public SearchFullTextSection waitForSearchSectionToLoad() {
//        isVisible(INPUT_SEARCH_XPATH);
//        isVisible(SUBMIT_BUTTON_XPATH);
//        return this;
//    }

    @Override
    public String getHelpBlockContent() {
        isVisible(HELP_BLOCK_XPATH);
        return getWebElement(HELP_BLOCK_XPATH).getText();
    }


    @Override
    public ISearchSection changeSearchMode() {
        isVisible(ADVANCED_SEARCH_LINK_XPATH);
        getWebElement(ADVANCED_SEARCH_LINK_XPATH).click();
//        SearchAdvancedSection searchAdvancedSection = new SearchAdvancedSection(webDriver).waitForSearchSectionToLoad();
//        ISearchAdvancedSection searchAdvancedSection = new SearchAdvancedSection(webDriver);
        ISearchSection searchAdvancedSection = new SearchAdvancedSection(webDriver);
        PageFactory.initElements(webDriver, searchAdvancedSection);
//        return searchAdvancedSection;
        return searchAdvancedSection;
    }

    @Override
    public ISearchSection fillInForm(Map<String, String> data) throws Exception{
        if ( data == null || data.size() == 0 || !data.containsKey("Fulltext search") ) {
            log.error("Error to fill In the Form : missing data \'Fulltext search\'");
            throw new Exception("Error to fill In the Form : missing data \'Fulltext search\'");
        }

        setFulltextSearch(data.get("Fulltext search"));
        return this;
    }

    @Override
    public ISearchSection clickReset() {
        // No Reset Action on FullTextSection.
        return this;
    }
}
