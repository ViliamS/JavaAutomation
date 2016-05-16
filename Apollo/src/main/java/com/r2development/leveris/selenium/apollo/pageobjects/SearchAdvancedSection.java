package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchAdvancedSection extends Apollo implements ISearchSection, ISearchAdvancedSection {

    private static final Log log = LogFactory.getLog(SearchAdvancedSection.class);

    @FindBy( xpath = FIRSTNAME_XPATH )
    private WebElement weFirstName;

    @FindBy( xpath = MIDDLE_NAME_XPATH )
    private WebElement weMiddleName;

    @FindBy( xpath = LAST_NAME_XPATH )
    private WebElement weLastName;

    @FindBy( xpath = DATE_OF_BIRTH_XPATH)
    private WebElement weDateOfBirth;

    @FindBy( xpath = EMAIL_XPATH )
    private WebElement weEmail;

    @FindBy( xpath = PHONE_XPATH )
    private WebElement wePhone;

    @FindBy( xpath = ADDRESS_LINE_1_XPATH )
    private WebElement weAddressLine1;

    @FindBy( xpath = ADDRESS_LINE_2_XPATH )
    private WebElement weAddressLine2;

    @FindBy( xpath = RESET_BUTTON_XPATH)
    private WebElement weReset;

    @FindBy( xpath = SUBMIT_BUTTON_XPATH )
    private WebElement weSubmit;

    public static ISearchSection getSearchSectionInstance(SharedDriver_Apollo webDriver) {
//    public static ISearchAdvancedSection getSearchSectionInstance(SharedDriver_Apollo webDriver) {
//        SearchAdvancedSection searchAdvancedSection = new SearchAdvancedSection(webDriver);
        ISearchAdvancedSection searchAdvancedSection = new SearchAdvancedSection(webDriver);
        PageFactory.initElements(webDriver, searchAdvancedSection);
//        return searchAdvancedSection;
        return (ISearchSection) searchAdvancedSection;
    }

    public SearchAdvancedSection(SharedDriver_Apollo webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public SearchAdvancedSection setFirstName(String firstName) {
        this.weFirstName.clear();
        this.weFirstName.sendKeys(firstName + Keys.ENTER);
        return this;
    }

    public SearchAdvancedSection setMiddleName(String middleName) {
        this.weMiddleName.clear();
        this.weMiddleName.sendKeys(middleName + Keys.ENTER);
        return this;
    }

    public SearchAdvancedSection setLastName(String lastName) {
        this.weLastName.clear();
        this.weLastName.sendKeys(lastName + Keys.ENTER);
        return this;
    }

    public SearchAdvancedSection setDateOfBirth(String dateOfBirth) {
        this.weDateOfBirth.sendKeys(dateOfBirth);
        return this;
    }

    public SearchAdvancedSection setEmail(String email) {
        this.weEmail.clear();
        this.weEmail.sendKeys(email + Keys.ENTER);
        return this;
    }

    public SearchAdvancedSection setPhone(String phone) {
        this.wePhone.clear();
        this.wePhone.sendKeys(phone + Keys.ENTER);
        return this;
    }

    public SearchAdvancedSection setAddressLine1(String addressLine1) {
        this.weAddressLine1.clear();
        this.weAddressLine1.sendKeys(addressLine1 + Keys.ENTER);
        return this;
    }

    public SearchAdvancedSection setAddressLine2(String addressLine2) {
        this.weAddressLine2.clear();
        this.weAddressLine2.sendKeys(addressLine2 + Keys.ENTER);
        return this;
    }

    @Override
    public boolean validateSearch() {
        boolean toReturn = true;

        String fsibling = "/following-sibling::span[@class='help-block']";
        Map<String, String> errorMessage = new HashMap<>();

        if (isVisible(FIRSTNAME_XPATH + fsibling, 5))
            errorMessage.put("FirstName", getWebElement(FIRSTNAME_XPATH + fsibling).getText());
        if (isVisible(MIDDLE_NAME_XPATH + fsibling, 5))
            errorMessage.put("MiddleName", getWebElement(MIDDLE_NAME_XPATH + fsibling).getText());
        if (isVisible(LAST_NAME_XPATH + fsibling, 5))
            errorMessage.put("LastName", getWebElement(LAST_NAME_XPATH + fsibling).getText());
        if (isVisible(EMAIL_XPATH + fsibling, 5))
            errorMessage.put("Email", getWebElement(EMAIL_XPATH + fsibling).getText());
        if (isVisible(PHONE_XPATH + fsibling, 5))
            errorMessage.put("Phone", getWebElement(PHONE_XPATH + fsibling).getText());
        if (isVisible(ADDRESS_LINE_1_XPATH + fsibling, 5))
            errorMessage.put("AddressLine1", getWebElement(ADDRESS_LINE_1_XPATH + fsibling).getText());
        if (isVisible(ADDRESS_LINE_2_XPATH + fsibling, 5))
            errorMessage.put("AddressLine2", getWebElement(ADDRESS_LINE_2_XPATH + fsibling).getText());

        if ( errorMessage.size() != 0)
            toReturn = false;

        return toReturn;
    }

    @Override
    public boolean validateNegativeSearch() {
        boolean toReturn = false;

        String fsibling = "/following-sibling::span[@class='help-block']";
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("FirstName", "");
        errorMessage.put("MiddleName", "");
        errorMessage.put("LastName", "");
        errorMessage.put("Email", "");
        errorMessage.put("Phone", "");
        errorMessage.put("AddressLine1", "");
        errorMessage.put("AddressLine2", "");

        if (isInvisible(FIRSTNAME_XPATH + fsibling, 5)) errorMessage.remove("FirstName");
        else errorMessage.replace("FirstName", getWebElement(FIRSTNAME_XPATH + fsibling).getText());

        if (isInvisible(MIDDLE_NAME_XPATH + fsibling, 5)) errorMessage.remove("MiddleName");
        else errorMessage.put("MiddleName", getWebElement(MIDDLE_NAME_XPATH + fsibling).getText());

        if (isInvisible(LAST_NAME_XPATH + fsibling, 5)) errorMessage.remove("LastName");
        else errorMessage.put("LastName", getWebElement(LAST_NAME_XPATH + fsibling).getText());

        if (isInvisible(EMAIL_XPATH + fsibling, 5)) errorMessage.remove("Email");
        else errorMessage.put("Email", getWebElement(EMAIL_XPATH + fsibling).getText());

        if (isInvisible(PHONE_XPATH + fsibling, 5)) errorMessage.remove("Phone");
        else errorMessage.put("Phone", getWebElement(PHONE_XPATH + fsibling).getText());

        if (isInvisible(ADDRESS_LINE_1_XPATH + fsibling, 5)) errorMessage.remove("AddressLine1");
        else errorMessage.put("AddressLine1", getWebElement(ADDRESS_LINE_1_XPATH + fsibling).getText());

        if (isInvisible(ADDRESS_LINE_2_XPATH + fsibling, 5)) errorMessage.remove("AddressLine2");
        else errorMessage.put("AddressLine2", getWebElement(ADDRESS_LINE_2_XPATH + fsibling).getText());

        if ( errorMessage.size() == 0)
            toReturn = true;

        return toReturn;
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
        weSubmit.click();
        ISearchPage searchPage = SearchPage.getSearchSectionInstance((SharedDriver_Apollo)webDriver, this);
        PageFactory.initElements(webDriver, searchPage);
        return searchPage;
    }

//    @Override
//    public SearchAdvancedSection waitForSearchSectionToLoad() {
//        System.out.println("In SearchAdvanceSection, TODO Implementation waitForSectionToLoad()");
//        return this;
//    }

    @Override
    public String getHelpBlockContent() {
        isVisible(HELP_BLOCK_XPATH);
        return getWebElement(HELP_BLOCK_XPATH).getText();
    }

    @Override
    public ISearchSection changeSearchMode() {
        isVisible(FULLTEXT_SEARCH_LINK_XPATH);
        getWebElement(FULLTEXT_SEARCH_LINK_XPATH).click();
//        SearchFullTextSection searchFullTextSection = new SearchFullTextSection(webDriver).waitForSearchSectionToLoad();
//        ISearchFullTextSection searchFullTextSection = new SearchFullTextSection(webDriver);
        ISearchSection searchFullTextSection = new SearchFullTextSection((SharedDriver_Apollo)webDriver);
        PageFactory.initElements(webDriver, searchFullTextSection);
//        return searchFullTextSection;
        return searchFullTextSection;
    }

    @Override
    public ISearchSection fillInForm(Map<String, String> data) throws Exception {
        if ( data == null || data.size() == 0) {
            log.error("Error to fill In the Form : no data sent ( NULL or EMPTY )");
            throw new Exception("Error to fill In the Form : no data sent ( NULL or EMPTY )");
        }

        Boolean[] correctData = new Boolean[] { true, true, true, true, true, true, true, true };

        if (!data.containsKey(FIRST_NAME)) correctData[0] = false;
        if (!data.containsKey(MIDDLE_NAME)) correctData[1] = false;
        if (!data.containsKey(LAST_NAME)) correctData[2] = false;
        if (!data.containsKey(DATE_OF_BIRTH)) correctData[3] = false;
        if (!data.containsKey(EMAIL)) correctData[4] = false;
        if (!data.containsKey(PHONE)) correctData[5] = false;
        if (!data.containsKey(ADDRESS_LINE_1)) correctData[6] = false;
        if (!data.containsKey(ADDRESS_LINE_2)) correctData[7] = false;

        if (!Arrays.asList(correctData).contains(true)) {
            log.error("Error to fill In the Form : no accurate data sent");
            throw new Exception("Error to fill In the Form : no accurate data sent");
        }

        if (data.containsKey(FIRST_NAME)) setFirstName(data.get(FIRST_NAME));
        if (data.containsKey(MIDDLE_NAME)) setMiddleName(data.get(MIDDLE_NAME));
        if (data.containsKey(LAST_NAME)) setLastName(data.get(LAST_NAME));
        if (data.containsKey(DATE_OF_BIRTH)) setDateOfBirth(data.get(DATE_OF_BIRTH));
        if (data.containsKey(EMAIL)) setEmail(data.get(EMAIL));
        if (data.containsKey(PHONE)) setPhone(data.get(PHONE));
        if (data.containsKey(ADDRESS_LINE_1)) setAddressLine1(data.get(ADDRESS_LINE_1));
        if (data.containsKey(ADDRESS_LINE_2)) setAddressLine2(data.get(ADDRESS_LINE_2));

        return this;
    }

    @Override
    public ISearchSection clickReset() {
        this.weReset.click();
        return this;
    }
}

