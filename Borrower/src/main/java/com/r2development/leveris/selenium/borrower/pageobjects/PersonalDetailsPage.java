package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PersonalDetailsPage extends HeaderAndBottomAndFormsMenuSection implements IPersonalDetailsPage /*, IPersonalDetailsSection, IHeaderSection, IFormsMenu, IBottomSection*/ {

    private static final Log log = LogFactory.getLog(PersonalDetailsPage.class);

    private IPersonalDetailsSection personalDetailsSection;

//    @Inject
    public PersonalDetailsPage(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        personalDetailsSection = new PersonalDetailsSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public boolean isTitle(String firstName) {
        personalDetailsSection.isTitle(firstName);
        return true;
    }

    @Override
    public IPersonalDetailsPage setTitle(String title){
        personalDetailsSection.setTitle(title);
        return this;
    }

    @Override
    public IPersonalDetailsPage setMiddleName(String middleName){
        personalDetailsSection.setMiddleName(middleName);
        return this;
    }

    @Override
    public IPersonalDetailsPage setSuffix(String suffix){
        personalDetailsSection.setSuffix(suffix);
        return this;
    }

    @Override
    public IPersonalDetailsPage setFirstname(String firstName) {
        personalDetailsSection = personalDetailsSection.setFirstname(firstName);
        return this;
    }

    @Override
    public IPersonalDetailsPage setLastname(String lastName) {
        personalDetailsSection = personalDetailsSection.setLastname(lastName);
        return this;
    }

    @Override
    public boolean isGenderLabel() {
        return false;
    }

    @Override
    public IPersonalDetailsPage checkGenderMale() {
        personalDetailsSection = personalDetailsSection.checkGenderMale();
        return this;
    }

    @Override
    public IPersonalDetailsPage checkGenderFemale() {
        personalDetailsSection = personalDetailsSection.checkGenderFemale();
        return this;
    }

    @Override
    public IPersonalDetailsPage checkGender(String gender) {
        personalDetailsSection = personalDetailsSection.checkGender(gender);
        return this;
    }

    @Override
    public IPersonalDetailsPage setDateOfBirth(String dateOfBirth) {
        personalDetailsSection = personalDetailsSection.setDateOfBirth(dateOfBirth);
        return this;
    }

    @Override
    public IPersonalDetailsPage selectMaritalStatus(String maritalStatus) {
        personalDetailsSection = personalDetailsSection.selectMaritalStatus(maritalStatus);
        return this;
    }

    @Override
    public IPersonalDetailsPage selectNationality(String nationality) {
        personalDetailsSection = personalDetailsSection.selectNationality(nationality);
        return this;
    }

    @Override
    public IPersonalDetailsPage setResidentYears(String residentYears) {
        personalDetailsSection = personalDetailsSection.setResidentYears(residentYears);
        return this;
    }

    @Override
    public boolean isRequiredVisa() {
        return false;
    }

    @Override
    public IPersonalDetailsPage checkRequiredVisaYes() {
        personalDetailsSection = personalDetailsSection.checkRequiredVisaYes();
        return this;
    }

    @Override
    public IPersonalDetailsPage checkRequiredVisaNo() {
        personalDetailsSection = personalDetailsSection.checkRequiredVisaNo();
        return this;
    }

    @Override
    public IPersonalDetailsPage checkRequiredVisa(boolean requiredVisa) {
        personalDetailsSection = personalDetailsSection.checkRequiredVisa(requiredVisa);
        return this;
    }

    @Override
    public IPersonalDetailsPage setResidencyAddressLine1(String residencyAddressLine1) {
        personalDetailsSection = personalDetailsSection.setResidencyAddressLine1(residencyAddressLine1);
        return this;
    }

    @Override
    public IPersonalDetailsPage setResidencyAddressLine2(String residencyAddressLine2) {
        personalDetailsSection = personalDetailsSection.setResidencyAddressLine2(residencyAddressLine2);
        return this;
    }

    @Override
    public IPersonalDetailsPage setResidencyTownCity(String residencyTownCity) {
        personalDetailsSection = personalDetailsSection.setResidencyTownCity(residencyTownCity);
        return this;
    }

    @Override
    public IPersonalDetailsPage selectResidencyCountyState(String residencyCountyState) {
        personalDetailsSection = personalDetailsSection.selectResidencyCountyState(residencyCountyState);
        return this;
    }

    @Override
    public IPersonalDetailsPage setResidencyPostcodeZip(String residencyPostcodeZip) {
        personalDetailsSection = personalDetailsSection.setResidencyPostcodeZip(residencyPostcodeZip);
        return this;
    }

    @Override
    public IPersonalDetailsPage selectResidencyCountry(String residencyCountry) {
        personalDetailsSection = personalDetailsSection.selectResidencyCountry(residencyCountry);
        return this;
    }

    @Override
    public IPersonalDetailsPage selectResidencyAccommodation(String residencyAccommodation) {
        personalDetailsSection = personalDetailsSection.selectResidencyAccommodation(residencyAccommodation);
        return this;
    }

    @Override
    public IPersonalDetailsPage setResidencyRent(String residencyRent) {
        personalDetailsSection = personalDetailsSection.setResidencyRent(residencyRent);
        return this;
    }

    @Override
    public boolean isLivedLast3Years() {
        return false;
    }

    @Override
    public IPersonalDetailsPage checkLivedLast3YearsYes() {
        personalDetailsSection = personalDetailsSection.checkLivedLast3YearsYes();
        return this;
    }

    @Override
    public IPersonalDetailsPage checkLivedLast3YearsNo() {
        personalDetailsSection = personalDetailsSection.checkLivedLast3YearsNo();
        return this;
    }

    @Override
    public IPersonalDetailsPage checkLivedLast3Years(boolean livedLast3Years) {
        personalDetailsSection = personalDetailsSection.checkLivedLast3Years(livedLast3Years);
        return this;
    }

    @Override
    public IPersonalDetailsPage setPreviousResidencyAddressLine1(String previousResidencyAddressLine1) {
        personalDetailsSection = personalDetailsSection.setPreviousResidencyAddressLine1(previousResidencyAddressLine1);
        return this;
    }

    @Override
    public IPersonalDetailsPage setPreviousResidencyAddressLine2(String previousResidencyAddressLine2) {
        personalDetailsSection = personalDetailsSection.setPreviousResidencyAddressLine2(previousResidencyAddressLine2);
        return this;
    }

    @Override
    public IPersonalDetailsPage setPreviousResidencyTownCity(String previousResidencyTownCity) {
        personalDetailsSection = personalDetailsSection.setPreviousResidencyTownCity(previousResidencyTownCity);
        return this;
    }

    @Override
    public IPersonalDetailsPage selectPreviousResidencyCountyState(String previousResidencyCountyState) {
        personalDetailsSection = personalDetailsSection.selectPreviousResidencyCountyState(previousResidencyCountyState);
        return this;
    }

    @Override
    public IPersonalDetailsPage setPreviousResidencyPostcodeZip(String previousResidencyPostcodeZip) {
        personalDetailsSection = personalDetailsSection.setPreviousResidencyPostcodeZip(previousResidencyPostcodeZip);
        return this;
    }

    @Override
    public IPersonalDetailsPage selectPreviousResidencyCountry(String previousResidencyCountry) {
        personalDetailsSection = personalDetailsSection.selectPreviousResidencyCountry(previousResidencyCountry);
        return this;
    }

    @Override
    public IPersonalDetailsPage setPreviousResidencyCountry(String previousResidencyCountry) {
        personalDetailsSection = personalDetailsSection.setPreviousResidencyCountry(previousResidencyCountry);
        return this;
    }

    @Override
    public IPersonalDetailsPage clickSave() {
        personalDetailsSection.clickSave();
        return this;
    }

    @Override
    public boolean isLoaded() {
        personalDetailsSection.isLoaded();
        return true;
    }
}