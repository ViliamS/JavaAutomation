package com.r2development.leveris.selenium.apollo.pageobjects;

public interface IEditContactSection {
    String ADDRESS1_XPATH = "//*[text()[contains(.,'Address line 1')]]/ancestor::div[@class='form-group']/input[@label='Address line 1']";
    String ADDRESS2_XPATH = "//*[text()[contains(.,'Address line 2')]]/ancestor::div[@class='form-group']/input[@label='Address line 2']";
    String CITY_XPATH = "//*[text()[contains(.,'City')]]/ancestor::div[@class='form-group']/input[@label='City']";
    String COUNTY_XPATH = "//*[text()[contains(.,'County (optional)')]]/ancestor::div[@class='form-group']/input[@label='County (optional)']";
    String ZIP_XPATH = "//*[text()[contains(.,'ZIP (optional)')]]/ancestor::div[@class='form-group']/input[@label='ZIP (optional)']";
    String COUNTRY_XPATH = "//*[text()[contains(.,'Country')]]/ancestor::div[@class='form-group']/input[@label='Country']";
    String SAVE_CHANGES_BUTTON_XPATH = "//button[text()[contains(.,'Save changes')]]";
    String DISCARD_CHANGE_LINK_XPATH = "//button[text()[contains(.,'Discard changes')]]";

    String getAddress1();
    IEditContactSection setAddress1(String address1);
    String getAddress2();
    IEditContactSection setAddress2(String address2);
    String getCity();
    IEditContactSection setCity(String city);
    String getCounty();
    IEditContactSection setCounty(String county);
    String getZip();
    IEditContactSection setZip(String zip);
    String getCountry();
    IEditContactSection setCountry(String country);

    IRecordPage clickSaveChanges();
    IRecordPage clickDiscardChanges();
}
