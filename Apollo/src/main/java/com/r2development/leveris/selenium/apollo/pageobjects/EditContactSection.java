package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class EditContactSection extends Apollo implements IEditContactSection {

    private static final Log log = LogFactory.getLog(EditContactSection.class);

    private SharedDriver webDriver;

    @FindBy( xpath = ADDRESS1_XPATH)
    protected WebElement weAddress1;

    @FindBy( xpath = ADDRESS2_XPATH)
    protected WebElement weAddress2;

    @FindBy( xpath = CITY_XPATH)
    protected WebElement weCity;

    @FindBy( xpath = COUNTY_XPATH)
    protected WebElement weCounty;

    @FindBy( xpath = ZIP_XPATH)
    protected WebElement weZip;

    @FindBy( xpath = COUNTRY_XPATH)
    protected WebElement weCountry;

    @FindBy( xpath = SAVE_CHANGES_BUTTON_XPATH)
    protected WebElement weSaveChanges;

    @FindBy( xpath = DISCARD_CHANGE_LINK_XPATH)
    protected WebElement weDiscardChanges;

    // TODO ... to enhance guice di with cancel possibility
    Map<String, String> oldContactData = new HashMap<>();
    Map<String, String> newContactData = new HashMap<>();

    public EditContactSection(SharedDriver webDriver, Map<String, String> oldContactData) {
        super(webDriver);
        this.webDriver = webDriver;
        this.oldContactData = oldContactData;
    }

    public static IEditContactSection getEditContactSectionInstance(SharedDriver webDriver, Map<String, String> oldContactData) {
        IEditContactSection editContactSection = new EditContactSection(webDriver, oldContactData);
        PageFactory.initElements(webDriver, editContactSection);
        return editContactSection;
    }

    @Override
    public String getAddress1() {
        isVisible(ADDRESS1_XPATH);
        return weAddress1.getText();
    }

    @Override
    public IEditContactSection setAddress1(String address1) {
        isVisible(ADDRESS1_XPATH);
        weAddress1.clear();
        weAddress1.sendKeys(address1);
        newContactData.put("address1", address1);
        return this;
    }

    @Override
    public String getAddress2() {
        isVisible(ADDRESS2_XPATH);
        return weAddress2.getText();
    }

    @Override
    public IEditContactSection setAddress2(String address2) {
        isVisible(ADDRESS2_XPATH);
        weAddress2.clear();
        weAddress2.sendKeys(address2);
        newContactData.put("address2", address2);
        return this;
    }

    @Override
    public String getCity() {
        isVisible(CITY_XPATH);
        return weCity.getText();
    }

    @Override
    public IEditContactSection setCity(String city) {
        isVisible(CITY_XPATH);
        weCity.clear();
        weCity.sendKeys(city);
        newContactData.put("city", city);
        return this;
    }

    @Override
    public String getCounty() {
        isVisible(COUNTY_XPATH);
        return weCounty.getText();
    }

    @Override
    public IEditContactSection setCounty(String county) {
        isVisible(COUNTY_XPATH);
        weCounty.clear();
        weCounty.sendKeys(county);
        newContactData.put("county", county);
        return this;
    }

    @Override
    public String getZip() {
        isVisible(ZIP_XPATH);
        return weZip.getText();
    }

    @Override
    public IEditContactSection setZip(String zip) {
        isVisible(ZIP_XPATH);
        weZip.clear();
        weZip.sendKeys(zip);
        newContactData.put("zip", zip);
        return this;
    }

    @Override
    public String getCountry() {
        isVisible(COUNTRY_XPATH);
        return weCountry.getText();
    }

    @Override
    public IEditContactSection setCountry(String country) {
        isVisible(COUNTRY_XPATH);
        weCountry.clear();
        weCountry.sendKeys(country);
        newContactData.put("country", country);
        return this;
    }

    @Override
    public IRecordPage clickSaveChanges() {
        isVisible(SAVE_CHANGES_BUTTON_XPATH);
        weSaveChanges.click();
        return RecordPage.getRecordPageInstance(webDriver, null, newContactData);
    }

    @Override
    public IRecordPage clickDiscardChanges() {
        isVisible(DISCARD_CHANGE_LINK_XPATH);
        weDiscardChanges.click();
        return RecordPage.getRecordPageInstance(webDriver);
    }
}

