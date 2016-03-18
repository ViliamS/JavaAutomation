package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

public interface IPersonalDetailsSection {
    String TITLE_XPATH = "//h2[contains(. , '${replace}$') and contains(., 'Personal Details')]";

    String FIRSTNAME_XPATH = "//label[contains(., 'First name')]/following-sibling::input";
    String LASTNAME_XPATH = "//label[contains(., 'Last name')]/following-sibling::input";

    String GENDER_LABEL_XPATH = "//div[contains(., 'Gender')]";
    String GENDER_MALE_XPATH = "//label[contains(@wicketpath, 'Gender') and contains(@wicketpath, 'Male')]/following-sibling::span/a";
    String GENDER_FEMALE_XPATH = "//label[contains(@wicketpath, 'Gender') and contains(@wicketpath, 'Female')]/following-sibling::span/a";

    // format dd/mm/yyyy
    String DATE_OF_BIRTH_XPATH = "//label[contains(., 'Date of birth')]/following-sibling::input";
    String DATE_OF_BIRTH_DONE_XPATH = "";
    // enum single, separated, married/civil partner(s), divorced/dissolved civil partnership, widowed
    String MARITAL_STATUS_XPATH = "//label[contains(., 'Marital status')]/following-sibling::input";

    String NATIONALITY_XPATH = "//label[contains(., 'Nationality')]/following-sibling::input";
    String RESIDENT_YEARS_XPATH = "//label[contains(., 'How many years have you been resident in the Republic of Ireland?')]/following-sibling::input";
    String REQUIRED_VISA_XPATH = "//div[contains(@wicketpath, 'RequiredVisa_label') and contains(., 'Require work permit / visa')]";
    String REQUIRED_VISA_YES_XPATH = "//div[contains(@wicketpath, 'RequiredVisaYes')]/span/a";
    String REQUIRED_VISA_NO_XPATH = "//div[contains(@wicketpath, 'RequiredVisaNo')]/span/a";

//    String RESIDENCY_TITLE_XPATH = "";

    String RESIDENCY_ADDRESS_LINE_1_XPATH = "//label[contains(., 'Address line 1')]/following-sibling::input[contains(@id, 'pnlAddress')]";
    String RESIDENCY_ADDRESS_LINE_2_XPATH = "//label[contains(., 'Address line 2')]/following-sibling::input[contains(@wicketpath, 'txtAddressLine2')]";
    String RESIDENCY_TOWN_CITY_XPATH = "//label[contains(., 'Town/city')]/following-sibling::input[contains(@wicketpath, 'txtTownCity')]";
    String RESIDENCY_COUNTY_STATE_XPATH = "//label[contains(., 'County/state')]/following-sibling::input[contains(@wicketpath, 'cmbCountyState')]";
    String RESIDENCY_POSTCODE_ZIP_XPATH = "//label[contains(., 'Postcode/ZIP(optional)')]/following-sibling::input[contains(@wicketpath, 'txtPostcode')]";
    String RESIDENCY_COUNTRY_LABEL_XPATH = "//label[contains(@wicketpath, 'cmbCountry')]";
    String RESIDENCY_COUNTRY_XPATH = "//label[contains(@wicketpath, 'cmbCountry')]/following-sibling::input";
//    String RESIDENCY_COUNTRY_XPATH = "//label[contains(@wicketpath, 'cmbCountry')]/following-sibling::input[not(contains(@wicketpath,'PreviousResidency'))]";
//    String RESIDENCY_COUNTRY_XPATH = "//input[@wicketpath='main_c_form_form_root_c_w_cmbCountry_v']";
    // enum Rented on contract, Rented from family/friends, Property owner, Others
    String RESIDENCY_ACCOMMODATION_XPATH = "//label[contains(., 'This accommodation is')]/following-sibling::input";
    String RESIDENCY_RENT_XPATH = "//label[contains(., 'Rent')]/following-sibling::input";

    String LIVED_LAST_3_YEARS_XPATH = "//div[contains(@wicketpath, 'Last3Years_label') and contains(., 'Have you lived at this address for the last 3 years?')]";
    String LIVED_LAST_3_YEARS_YES_XPATH = "//label[contains(@wicketpath, 'Last3Years') and contains(., 'Yes')]/following-sibling::span/a";
    String LIVED_LAST_3_YEARS_NO_XPATH = "//label[contains(@wicketpath, 'Last3Years') and contains(., 'No')]/following-sibling::span/a";

//    String PREVIOUS_RESIDENCY_TITLE_XPATH = "";

    String PREVIOUS_RESIDENCY_ADDRESS_LINE_1_XPATH = "//input[@id='pnlGoogleAddressLine1Previous-autocompleteBox']"; //label[contains(., 'Address line 1 ')]/following-sibling::input[contains(@id, 'AddressLine1Previous')]";
    String PREVIOUS_RESIDENCY_ADDRESS_LINE_2_XPATH = "//label[contains(., 'Address line 2')]/following-sibling::input[contains(@wicketpath, 'PreviousAddressLine2')]";
    String PREVIOUS_RESIDENCY_TOWN_CITY_XPATH = "//label[contains(., 'Town/city')]/following-sibling::input[contains(@wicketpath, 'txtPreviousTownCity')]";
    String PREVIOUS_RESIDENCY_COUNTY_STATE_XPATH = "//label[contains(., 'County/state')]/following-sibling::input";
    String PREVIOUS_RESIDENCY_POSTCODE_ZIP_XPATH = "//label[contains(., 'Postcode/ZIP(optional)')]/following-sibling::input[contains(@wicketpath, 'PreviousPostcode')]";
    String PREVIOUS_RESIDENCY_COUNTRY_XPATH = "//label[contains(., 'Country')]/following-sibling::input[contains(@wicketpath, 'PreviousResidency') and contains(@wicketpath, 'cmbCountry')]";

    String SAVE_BUTTON_XPATH = "//a[contains(., 'Save')]";

    String getTitle();
    boolean isTitle(String FirstName);

    IPersonalDetailsSection setFirstname(String FirstName);
    IPersonalDetailsSection setLastname(String LastName);

    boolean isGenderLabel();
    IPersonalDetailsSection checkGenderMale();
    IPersonalDetailsSection checkGenderFemale();
    IPersonalDetailsSection checkGender(String gender);

    IPersonalDetailsSection setDateOfBirth(String dateOfBirth);

    IPersonalDetailsSection selectMaritalStatus(String maritalStatus);

    IPersonalDetailsSection selectNationality(String nationality);
    IPersonalDetailsSection setResidentYears(String residentYears);
    boolean isRequiredVisa();
    IPersonalDetailsSection checkRequiredVisaYes();
    IPersonalDetailsSection checkRequiredVisaNo();
    IPersonalDetailsSection checkRequiredVisa(boolean requiredVisa);

    IPersonalDetailsSection setResidencyAddressLine1(String residencyAddressLine1);
    IPersonalDetailsSection setResidencyAddressLine2(String residencyAddressLine2);
    IPersonalDetailsSection setResidencyTownCity(String residencyTownCity);
    IPersonalDetailsSection selectResidencyCountyState(String residencyCountyState);
    IPersonalDetailsSection setResidencyPostcodeZip(String residencyPostcodeZip);
    IPersonalDetailsSection selectResidencyCountry(String residencyCountry);
    IPersonalDetailsSection selectResidencyAccommodation(String residencyAccommodation);
    IPersonalDetailsSection setResidencyRent(String residencyRent);

    boolean isLivedLast3Years();
    IPersonalDetailsSection checkLivedLast3YearsYes();
    IPersonalDetailsSection checkLivedLast3YearsNo();
    IPersonalDetailsSection checkLivedLast3Years(boolean livedLast3Years);

    IPersonalDetailsSection setPreviousResidencyAddressLine1(String previousResidencyAddressLine1);
    IPersonalDetailsSection setPreviousResidencyAddressLine2(String previousResidencyAddressLine2);
    IPersonalDetailsSection setPreviousResidencyTownCity(String previousResidencyTownCity);
    IPersonalDetailsSection selectPreviousResidencyCountyState(String previousResidencyCountyState);
    IPersonalDetailsSection setPreviousResidencyPostcodeZip(String previousResidencyPostcodeZip);
    IPersonalDetailsSection selectPreviousResidencyCountry(String previousResidencyCountry);
    IPersonalDetailsSection setPreviousResidencyCountry(String previousResidencyCountry);

    IPersonalDetailsSection clickSave();
    boolean isLoaded();
}
