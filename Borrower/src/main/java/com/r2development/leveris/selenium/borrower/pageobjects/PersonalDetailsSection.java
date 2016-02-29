package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsSection extends Borrower implements IPersonalDetailsSection {

    private static final Log log = LogFactory.getLog(PersonalDetailsSection.class);

    @FindBy( xpath = TITLE_XPATH )
    protected WebElement weTitle;

    @FindBy( xpath = FIRSTNAME_XPATH )
    protected WebElement weFirstName;
    @FindBy( xpath = LASTNAME_XPATH )
    protected WebElement weLastName;

    @FindBy( xpath = GENDER_LABEL_XPATH )
    protected WebElement weGenderLabel;
    @FindBy( xpath = GENDER_MALE_XPATH )
    protected WebElement weGenderMale;
    @FindBy( xpath = GENDER_FEMALE_XPATH )
    protected WebElement weGenderFemale;

    // format dd/mm/yyyy
    @FindBy( xpath = DATE_OF_BIRTH_XPATH )
    protected WebElement weDateOfBirth;
    @FindBy( xpath = DATE_OF_BIRTH_DONE_XPATH )
    protected WebElement weDateOfBirthDone;
    // enum single, separated, married/civil partner(s), divorced/dissolved civil partnership, widowed
    @FindBy( xpath = MARITAL_STATUS_XPATH )
    protected WebElement weMaritalStatus;

    @FindBy( xpath = NATIONALITY_XPATH )
    protected WebElement weNationality;
    @FindBy( xpath = RESIDENT_YEARS_XPATH )
    protected WebElement weResidentYears;
    @FindBy( xpath = REQUIRED_VISA_XPATH )
    protected WebElement weRequiredVisa;
    @FindBy( xpath = REQUIRED_VISA_YES_XPATH )
    protected WebElement weRequiredVisaYes;
    @FindBy( xpath = REQUIRED_VISA_NO_XPATH )
    protected WebElement weRequiredVisaNo;

//    @FindBy ( xpath = RESIDENCY_TITLE_XPATH )
//    WebElement weResidencyTitle;

    @FindBy( xpath = RESIDENCY_ADDRESS_LINE_1_XPATH )
    protected WebElement weResidencyAddressLine1;
    @FindBy( xpath = RESIDENCY_ADDRESS_LINE_2_XPATH )
    protected WebElement weResidencyAddressLine2;
    @FindBy( xpath = RESIDENCY_TOWN_CITY_XPATH )
    protected WebElement weResidencyTownCity;
    @FindBy( xpath = RESIDENCY_COUNTY_STATE_XPATH )
    protected WebElement weResidencyCountyState;
    @FindBy( xpath = RESIDENCY_POSTCODE_ZIP_XPATH )
    protected WebElement weResidencyPostcodeZip;
    @FindBy( xpath = RESIDENCY_COUNTRY_XPATH )
    protected WebElement weResidencyCountry;
    // enum Rented on contract, Rented from family/friends, Property owner, Others
    @FindBy( xpath = RESIDENCY_ACCOMMODATION_XPATH )
    protected WebElement weResidencyAccommodation;
    @FindBy( xpath = RESIDENCY_RENT_XPATH )
    protected WebElement weResidencyRent;

    @FindBy( xpath = LIVED_LAST_3_YEARS_XPATH )
    protected WebElement weLivedLast3Years;
    @FindBy( xpath = LIVED_LAST_3_YEARS_YES_XPATH )
    protected WebElement weLivedLast3YearsYes;
    @FindBy( xpath = LIVED_LAST_3_YEARS_NO_XPATH )
    protected WebElement weLivedLast3YearsNo;

//    @FindBy( xpath = PREVIOUS_RESIDENCY_TITLE_XPATH )
//    WebElement wePreviousResidencyTitle;

    @FindBy( xpath = PREVIOUS_RESIDENCY_ADDRESS_LINE_1_XPATH )
    protected WebElement wePreviousResidencyAddressLine1;
    @FindBy( xpath = PREVIOUS_RESIDENCY_ADDRESS_LINE_2_XPATH )
    protected WebElement wePreviousResidencyAddressLine2;
    @FindBy( xpath = PREVIOUS_RESIDENCY_TOWN_CITY_XPATH )
    protected WebElement wePreviousResidencyTownCity;
    @FindBy( xpath = PREVIOUS_RESIDENCY_COUNTY_STATE_XPATH )
    protected WebElement wePreviousResidencyCountyState;
    @FindBy( xpath = PREVIOUS_RESIDENCY_POSTCODE_ZIP_XPATH )
    protected WebElement wePreviousResidencyPostcodeZip;
    @FindBy( xpath = PREVIOUS_RESIDENCY_COUNTRY_XPATH )
    protected WebElement wePreviousResidencyCountry;

    @FindBy( xpath = SAVE_BUTTON_XPATH )
    protected WebElement weSaveButton;

    @Inject
    public PersonalDetailsSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public boolean isTitle(String FirstName) {
        // TODO to implement warning single or couple
        return false;
    }

    @Override
    public IPersonalDetailsSection setFirstname(String firstName) {
        isVisible(FIRSTNAME_XPATH, true, 5);
        weFirstName.clear();
        weFirstName.sendKeys(firstName);
        return this;
    }

    @Override
    public IPersonalDetailsSection setLastname(String lastName) {
        isVisible(LASTNAME_XPATH, true, 5);
        weLastName.clear();
        weLastName.sendKeys(lastName);
        return this;
    }

    @Override
    public boolean isGenderLabel() {
        return false;
    }

    @Override
    public IPersonalDetailsSection checkGenderMale() {
        return null;
    }

    @Override
    public IPersonalDetailsSection checkGenderFemale() {
        return null;
    }

    @Override
    public IPersonalDetailsSection checkGender(String gender) {
        isVisible(GENDER_MALE_XPATH, true);
        isVisible(GENDER_FEMALE_XPATH, true);
        switch (gender) {
            case "Male":
                clickElement(GENDER_MALE_XPATH);
                break;
            case "Female":
                clickElement(GENDER_FEMALE_XPATH);
                break;
            default:
                log.error("Wrong type of gender !");
        }
        return this;
    }

    @Override
    public IPersonalDetailsSection setDateOfBirth(String dateOfBirth) {
        isVisible(DATE_OF_BIRTH_XPATH, true);
        try {
            weDateOfBirth.clear();
            weDateOfBirth.sendKeys(dateOfBirth);
        }
        catch ( StaleElementReferenceException sere ) {
            sendKeysElement(DATE_OF_BIRTH_XPATH, dateOfBirth, 5);
        }
        return this;
    }

    @Override
    public IPersonalDetailsSection selectMaritalStatus(String maritalStatus) {
        isVisible(MARITAL_STATUS_XPATH, true);
        selectFromDropDown(MARITAL_STATUS_XPATH, maritalStatus);
        return this;
    }

    @Override
    public IPersonalDetailsSection selectNationality(String nationality) {
        isVisible(NATIONALITY_XPATH, true);
        selectFromDropDown(NATIONALITY_XPATH, nationality);
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidentYears(String residentYears) {
        isVisible(RESIDENT_YEARS_XPATH, true);
        weResidentYears.clear();
        weResidentYears.sendKeys(residentYears);
        return this;
    }

    @Override
    public boolean isRequiredVisa() {
        return false;
    }

    @Override
    public IPersonalDetailsSection checkRequiredVisaYes() {
        isVisible(REQUIRED_VISA_YES_XPATH, true);
        weRequiredVisaYes.click();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkRequiredVisaNo() {
        isVisible(REQUIRED_VISA_NO_XPATH, true);
        weRequiredVisaNo.click();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkRequiredVisa(boolean requiredVisa) {
        isVisible(REQUIRED_VISA_XPATH, true);
        isVisible(REQUIRED_VISA_YES_XPATH, true);
        isVisible(REQUIRED_VISA_NO_XPATH, true);
        if (requiredVisa)
            weRequiredVisaYes.click();
        else //if (!requiredVisa)
            weRequiredVisaNo.click();

        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyAddressLine1(String residencyAddressLine1) {
        isVisible(RESIDENCY_ADDRESS_LINE_1_XPATH, true);
        weResidencyAddressLine1.clear();
        weResidencyAddressLine1.sendKeys(residencyAddressLine1);
        checkAlert();
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyAddressLine2(String residencyAddressLine2) {
        isVisible(RESIDENCY_ADDRESS_LINE_2_XPATH, true);
        weResidencyAddressLine2.clear();
        weResidencyAddressLine2.sendKeys(residencyAddressLine2);
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyTownCity(String residencyTownCity) {
        isVisible(RESIDENCY_TOWN_CITY_XPATH, true);
        weResidencyTownCity.clear();
        weResidencyTownCity.sendKeys(residencyTownCity);
        return this;
    }

    @Override
    public IPersonalDetailsSection selectResidencyCountyState(String residencyCountyState) {
        isVisible(RESIDENCY_COUNTY_STATE_XPATH, true);
        selectFromDropDown(RESIDENCY_COUNTY_STATE_XPATH, residencyCountyState);
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyPostcodeZip(String residencyPostcodeZip) {
        isVisible(RESIDENCY_POSTCODE_ZIP_XPATH, true);
        weResidencyPostcodeZip.clear();
        weResidencyPostcodeZip.sendKeys(residencyPostcodeZip);
        return this;
    }

    @Override
    public IPersonalDetailsSection selectResidencyCountry(String residencyCountry) {
        moveTo(RESIDENCY_COUNTRY_LABEL_XPATH);
        isVisible(RESIDENCY_COUNTRY_XPATH, true);
//        weResidencyCountry.clear();
//        weResidencyCountry.sendKeys(residencyCountry);
        selectFromDropDown(RESIDENCY_COUNTRY_XPATH, residencyCountry);
        return this;
    }

    @Override
    public IPersonalDetailsSection selectResidencyAccommodation(String residencyAccommodation) {
        isVisible(RESIDENCY_ACCOMMODATION_XPATH, true);
        selectFromDropDown(RESIDENCY_ACCOMMODATION_XPATH, residencyAccommodation);
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyRent(String residencyRent) {
        isVisible(RESIDENCY_RENT_XPATH, true);
        weResidencyRent.clear();
        weResidencyRent.sendKeys(residencyRent);
        return this;
    }

    @Override
    public boolean isLivedLast3Years() {
        return false;
    }

    @Override
    public IPersonalDetailsSection checkLivedLast3YearsYes() {
        isVisible(LIVED_LAST_3_YEARS_YES_XPATH, true);
        weLivedLast3YearsYes.click();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkLivedLast3YearsNo() {
        isVisible(LIVED_LAST_3_YEARS_NO_XPATH, true);
        weLivedLast3YearsNo.click();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkLivedLast3Years(boolean livedLast3Years) {
        isVisible(LIVED_LAST_3_YEARS_XPATH, true);
        isVisible(LIVED_LAST_3_YEARS_YES_XPATH, true);
        isVisible(LIVED_LAST_3_YEARS_NO_XPATH, true);
        if (livedLast3Years) {
            weLivedLast3YearsYes.click();
            clickElement(LIVED_LAST_3_YEARS_YES_XPATH);
        }
        else /*if (!livedLast3Years)*/ {
            weLivedLast3YearsNo.click();
        }
//        else
//            log.error("Wrong data for livedLast3years !");

        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyAddressLine1(String previousResidencyAddressLine1) {
        isVisible(PREVIOUS_RESIDENCY_ADDRESS_LINE_1_XPATH, true);
        wePreviousResidencyAddressLine1.clear();
        wePreviousResidencyAddressLine1.sendKeys(previousResidencyAddressLine1);
        checkAlert();
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyAddressLine2(String previousResidencyAddressLine2) {
        isVisible(PREVIOUS_RESIDENCY_ADDRESS_LINE_2_XPATH, true);
        wePreviousResidencyAddressLine2.clear();
        wePreviousResidencyAddressLine2.sendKeys(previousResidencyAddressLine2);
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyTownCity(String previousResidencyTownCity) {
        isVisible(PREVIOUS_RESIDENCY_TOWN_CITY_XPATH, true);
        wePreviousResidencyTownCity.clear();
        wePreviousResidencyTownCity.sendKeys(previousResidencyTownCity);
        return this;
    }

    @Override
    public IPersonalDetailsSection selectPreviousResidencyCountyState(String previousResidencyCountyState) {
        isVisible(PREVIOUS_RESIDENCY_COUNTY_STATE_XPATH, true);
        selectFromDropDown(PREVIOUS_RESIDENCY_COUNTY_STATE_XPATH, previousResidencyCountyState);
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyPostcodeZip(String previousResidencyPostcodeZip) {
        isVisible(PREVIOUS_RESIDENCY_POSTCODE_ZIP_XPATH, true);
        wePreviousResidencyPostcodeZip.clear();
        wePreviousResidencyPostcodeZip.sendKeys(previousResidencyPostcodeZip);
        return this;
    }

    @Override
    public IPersonalDetailsSection selectPreviousResidencyCountry(String previousResidencyCountry) {
        isVisible(PREVIOUS_RESIDENCY_COUNTRY_XPATH, true);
        selectFromDropDown(PREVIOUS_RESIDENCY_COUNTRY_XPATH, previousResidencyCountry);
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyCountry(String previousResidencyCountry) {
        isVisible(PREVIOUS_RESIDENCY_COUNTRY_XPATH, true);
        wePreviousResidencyCountry.clear();
        wePreviousResidencyCountry.sendKeys(previousResidencyCountry);
        wePreviousResidencyCountry.sendKeys(Keys.ENTER);
        return this;
    }

    @Override
    public IPersonalDetailsSection clickSave() {
        isVisible(SAVE_BUTTON_XPATH, true);
        weSaveButton.click();
        if(isVisible(INDICATOR_SMALL_ON, false, 5))
            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public boolean isLoaded() {
//        isVisible(TITLE_XPATH, true);
        isVisible(SAVE_BUTTON_XPATH, true);
        return true;
    }
}
