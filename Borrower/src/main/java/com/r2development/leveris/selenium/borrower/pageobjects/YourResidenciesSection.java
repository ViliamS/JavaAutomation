package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YourResidenciesSection extends Borrower implements IYourResidenciesSection {

    private static final Log log = LogFactory.getLog(YourResidenciesSection.class.getName());

    WebDriver webDriver;

    public YourResidenciesSection(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public String getFormTitle() {
        log.info("");
        isVisible(TITLE_RESIDENCY_DETAILS, 2);
        return getText(GET_FORM_TITLE);
    }

    @Override
    public boolean isCurrentResidencyFormTitlePresent() {
        log.info("");
        return isVisible(TITLE_CURRENT_RESIDENCY_DETAILS, 2);
    }

    public boolean isOtherPreviousResidencyFormTitlePresent() {
        log.info("");
        return isVisible(TITLE_OTHER_PREVIOUS_RESIDENCY_DETAILS);
    }

    public IYourResidenciesSection setAddressLine1(String addressLine1) {
        log.info("");
        isVisible(ADDRESS_LINE1, true);
        clickElement(ADDRESS_LINE1);
        type(ADDRESS_LINE1, addressLine1, Keys.TAB);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setAddressLine2(String addressLine2) {
        log.info("");
        isVisible(ADDRESS_LINE2, true);
        type(ADDRESS_LINE2, addressLine2);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setTownCity(String townCity) {
        log.info("");
        isVisible(TOWN_CITY, true);
        type(TOWN_CITY, townCity);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setCountyState(String countyState) {
        log.info("");
        isVisible(COUNTY_STATE, true);
        clickElement(COUNTY_STATE);
        selectFromDropDown(COUNTY_STATE, countyState);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setPostCodeZip(String postCodeZip) {
        log.info("");
        isVisible(POST_CODE_ZIP, true);
        type(POST_CODE_ZIP, postCodeZip);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setCountry(String country) {
        log.info("");
        isVisible(COUNTRY, true);
        selectFromDropDown(COUNTRY, country);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setStartDate(String startDate) {
        log.info("");
        isVisible(START_DATE, true);
        typeEndWithTab(START_DATE, startDate, true);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setEndDate(String endDate) {
        log.info("");
        isVisible(END_DATE, true);
        typeEndWithTab(END_DATE, endDate, true);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection setResidentalStatus(String residentalStatus) {
        log.info("");
        isVisible(RESIDENTAL_STATUS, true);
        selectFromDropDown(RESIDENTAL_STATUS, residentalStatus);
        loadingCheck();
        return this;

    }

    @Override
    public IYourResidenciesSection clickCancel() {
        log.info("");
        isVisible(CANCEL, true);
        clickElement(CANCEL);
        loadingCheck();
        return this;
    }

    @Override
    public IYourResidenciesSection clickSaveAndClose() {
        log.info("");
        isVisible(SAVE_AND_CLOSE, true);
        clickElement(SAVE_AND_CLOSE);
        loadingCheck();
        return this;
    }
}