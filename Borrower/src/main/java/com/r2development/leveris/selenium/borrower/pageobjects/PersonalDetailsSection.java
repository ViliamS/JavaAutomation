package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IPersonalDetailsSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsSection extends Borrower implements IPersonalDetailsSection {

    private static final Log log = LogFactory.getLog(PersonalDetailsSection.class.getName());

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

//    @Inject
    public PersonalDetailsSection(SharedDriver webDriver) {
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
        loadingCheck();
        isVisible(FIRSTNAME_XPATH, true, 0);
        weFirstName.clear();
        weFirstName.sendKeys(firstName);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setLastname(String lastName) {
        loadingCheck();
        isVisible(LASTNAME_XPATH, true, 0);
        weLastName.clear();
        weLastName.sendKeys(lastName);
        loadingCheck();
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
        loadingCheck();
        isVisible(GENDER_MALE_XPATH, true, 0);
        isVisible(GENDER_FEMALE_XPATH, true, 0);
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
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setDateOfBirth(String dateOfBirth) {
        loadingCheck();
        isVisible(DATE_OF_BIRTH_XPATH, true, 0);
        try {
            weDateOfBirth.clear();
            weDateOfBirth.sendKeys(dateOfBirth);
        }
        catch ( StaleElementReferenceException sere ) {
            sendKeysElement(DATE_OF_BIRTH_XPATH, dateOfBirth, 0);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectMaritalStatus(String maritalStatus) {
        loadingCheck();
        isVisible(MARITAL_STATUS_XPATH, true, 0);
        selectFromDropDown(MARITAL_STATUS_XPATH, maritalStatus);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectNationality(String nationality) {
        loadingCheck();
        isVisible(NATIONALITY_XPATH, true, 0);
        selectFromDropDown(NATIONALITY_XPATH, nationality);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidentYears(String residentYears) {
        loadingCheck();
        isVisible(RESIDENT_YEARS_XPATH, true, 0);
        weResidentYears.clear();
        weResidentYears.sendKeys(residentYears);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isRequiredVisa() {
        return false;
    }

    @Override
    public IPersonalDetailsSection checkRequiredVisaYes() {
        loadingCheck();
        isVisible(REQUIRED_VISA_YES_XPATH, true, 0);
        weRequiredVisaYes.click();
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkRequiredVisaNo() {
        loadingCheck();
        isVisible(REQUIRED_VISA_NO_XPATH, true, 0);
        weRequiredVisaNo.click();
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkRequiredVisa(boolean requiredVisa) {
        loadingCheck();
        isVisible(REQUIRED_VISA_XPATH, true, 0);
        isVisible(REQUIRED_VISA_YES_XPATH, true, 0);
        isVisible(REQUIRED_VISA_NO_XPATH, true, 0);
        if (requiredVisa)
            weRequiredVisaYes.click();
        else //if (!requiredVisa)
            weRequiredVisaNo.click();
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyAddressLine1(String residencyAddressLine1) {
        loadingCheck();
        isVisible(RESIDENCY_ADDRESS_LINE_1_XPATH, true, 0);
        weResidencyAddressLine1.clear();
        weResidencyAddressLine1.sendKeys(residencyAddressLine1);
        checkAlert();
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyAddressLine2(String residencyAddressLine2) {
        loadingCheck();
        isVisible(RESIDENCY_ADDRESS_LINE_2_XPATH, true, 0);
        weResidencyAddressLine2.clear();
        weResidencyAddressLine2.sendKeys(residencyAddressLine2);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyTownCity(String residencyTownCity) {
        loadingCheck();
        isVisible(RESIDENCY_TOWN_CITY_XPATH, true, 0);
        weResidencyTownCity.clear();
        weResidencyTownCity.sendKeys(residencyTownCity);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectResidencyCountyState(String residencyCountyState) {
        loadingCheck();
        isVisible(RESIDENCY_COUNTY_STATE_XPATH, true, 0);
        selectFromDropDown(RESIDENCY_COUNTY_STATE_XPATH, residencyCountyState);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyPostcodeZip(String residencyPostcodeZip) {
        loadingCheck();
        isVisible(RESIDENCY_POSTCODE_ZIP_XPATH, true, 0);
        weResidencyPostcodeZip.clear();
        weResidencyPostcodeZip.sendKeys(residencyPostcodeZip);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectResidencyCountry(String residencyCountry) {
        loadingCheck();
        moveTo(RESIDENCY_COUNTRY_LABEL_XPATH);
        isVisible(RESIDENCY_COUNTRY_XPATH, true);
//        weResidencyCountry.clear();
//        weResidencyCountry.sendKeys(residencyCountry);
        selectFromDropDown(RESIDENCY_COUNTRY_XPATH, residencyCountry);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectResidencyAccommodation(String residencyAccommodation) {
        loadingCheck();
        isVisible(RESIDENCY_ACCOMMODATION_XPATH, true, 0);
        selectFromDropDown(RESIDENCY_ACCOMMODATION_XPATH, residencyAccommodation);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setResidencyRent(String residencyRent) {
        loadingCheck();
        isVisible(RESIDENCY_RENT_XPATH, true, 0);
        weResidencyRent.clear();
        weResidencyRent.sendKeys(residencyRent);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isLivedLast3Years() {
        return false;
    }

    @Override
    public IPersonalDetailsSection checkLivedLast3YearsYes() {
        loadingCheck();
        isVisible(LIVED_LAST_3_YEARS_YES_XPATH, true, 0);
        weLivedLast3YearsYes.click();
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkLivedLast3YearsNo() {
        loadingCheck();
        isVisible(LIVED_LAST_3_YEARS_NO_XPATH, true, 0);
        weLivedLast3YearsNo.click();
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkLivedLast3Years(boolean livedLast3Years) {
        loadingCheck();
        isVisible(LIVED_LAST_3_YEARS_XPATH, true, 0);
        isVisible(LIVED_LAST_3_YEARS_YES_XPATH, true, 0);
        isVisible(LIVED_LAST_3_YEARS_NO_XPATH, true, 0);
        if (livedLast3Years) {
            weLivedLast3YearsYes.click();
            loadingCheck();
            clickElement(LIVED_LAST_3_YEARS_YES_XPATH);
        }
        else /*if (!livedLast3Years)*/ {
            weLivedLast3YearsNo.click();
        }
//        else
//            log.error("Wrong data for livedLast3years !");
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyAddressLine1(String previousResidencyAddressLine1) {
        loadingCheck();
        isVisible(PREVIOUS_RESIDENCY_ADDRESS_LINE_1_XPATH, true, 0);
        wePreviousResidencyAddressLine1.clear();
        wePreviousResidencyAddressLine1.sendKeys(previousResidencyAddressLine1);
        loadingCheck();
        checkAlert();
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyAddressLine2(String previousResidencyAddressLine2) {
        loadingCheck();
        isVisible(PREVIOUS_RESIDENCY_ADDRESS_LINE_2_XPATH, true, 0);
        wePreviousResidencyAddressLine2.clear();
        wePreviousResidencyAddressLine2.sendKeys(previousResidencyAddressLine2);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyTownCity(String previousResidencyTownCity) {
        loadingCheck();
        isVisible(PREVIOUS_RESIDENCY_TOWN_CITY_XPATH, true, 0);
        wePreviousResidencyTownCity.clear();
        wePreviousResidencyTownCity.sendKeys(previousResidencyTownCity);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectPreviousResidencyCountyState(String previousResidencyCountyState) {
        loadingCheck();
        isVisible(PREVIOUS_RESIDENCY_COUNTY_STATE_XPATH, true, 0);
        selectFromDropDown(PREVIOUS_RESIDENCY_COUNTY_STATE_XPATH, previousResidencyCountyState);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyPostcodeZip(String previousResidencyPostcodeZip) {
        loadingCheck();
        isVisible(PREVIOUS_RESIDENCY_POSTCODE_ZIP_XPATH, true, 0);
        wePreviousResidencyPostcodeZip.clear();
        wePreviousResidencyPostcodeZip.sendKeys(previousResidencyPostcodeZip);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectPreviousResidencyCountry(String previousResidencyCountry) {
        loadingCheck();
        isVisible(PREVIOUS_RESIDENCY_COUNTRY_XPATH, true, 0);
        selectFromDropDown(PREVIOUS_RESIDENCY_COUNTRY_XPATH, previousResidencyCountry);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setPreviousResidencyCountry(String previousResidencyCountry) {
        loadingCheck();
        isVisible(PREVIOUS_RESIDENCY_COUNTRY_XPATH, true, 0);
        wePreviousResidencyCountry.clear();
        wePreviousResidencyCountry.sendKeys(previousResidencyCountry);
        wePreviousResidencyCountry.sendKeys(Keys.ENTER);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection clickSave() {
        loadingCheck();
        isVisible(SAVE_BUTTON_XPATH, true, 0);
        weSaveButton.click();
        loadingCheck();
        return this;
    }

    @Override
    public boolean isLoaded() {
        loadingCheck();
//        isVisible(TITLE_XPATH, true);
        isVisible(SAVE_BUTTON_XPATH, true, 0);
        return true;
    }
}
