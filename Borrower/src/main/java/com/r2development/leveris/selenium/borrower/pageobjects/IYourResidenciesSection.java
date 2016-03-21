package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourResidenciesSection {

    //div[contains(@wicketpath,'')][contains(@wicketpath,'')]

    String CURRENT_RESIDENCY_XPATH = "//div[contains(@wicketpath,'pnlNoEmplyments')][contains(@wicketpath,'lnkCurrentResidency')]";
    String OTHER_PREVIOUS_RESIDENCY_XPATH = "//div[contains(@wicketpath,'pnlNoEmplyments')][contains(@wicketpath,'lnkOtherResidency')]";

    String RESIDENCY_ADDRESS_LINE_1_XPATH = "//label[contains(., 'Address line 1')]/following-sibling::input[contains(@id, 'pnlAddress')]";
    String RESIDENCY_ADDRESS_LINE_2_XPATH = "//label[contains(., 'Address line 2')]/following-sibling::input[contains(@wicketpath, 'txtAddressLine2')]";
    String RESIDENCY_TOWN_CITY_XPATH = "//label[contains(., 'Town/city')]/following-sibling::input[contains(@wicketpath, 'txtTownCity')]";
    String RESIDENCY_COUNTY_STATE_XPATH = "//label[contains(., 'County/state')]/following-sibling::input[contains(@wicketpath, 'cmbCountyState')]";
    String RESIDENCY_POSTCODE_ZIP_XPATH = "//label[contains(., 'Postcode/ZIP(optional)')]/following-sibling::input[contains(@wicketpath, 'txtPostcode')]";
    String RESIDENCY_COUNTRY_LABEL_XPATH = "//label[contains(@wicketpath, 'cmbCountry')]";


    IYourResidenciesSection clickCurrentResidency();
    IYourResidenciesSection clickOtherPreviousResidency();

    IEmploymentIncomesPage clickNext();

}
