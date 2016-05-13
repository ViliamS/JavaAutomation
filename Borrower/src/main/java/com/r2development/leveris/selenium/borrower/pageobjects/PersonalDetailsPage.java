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
    public IPersonalDetailsPage setTitle(String title) {
        personalDetailsSection.setTitle(title);
        return this;
    }

    @Override
    public IPersonalDetailsPage setMiddleName(String middleName) {
        personalDetailsSection.setMiddleName(middleName);
        return this;
    }

    @Override
    public IPersonalDetailsPage setSuffix(String suffix) {
        personalDetailsSection.setSuffix(suffix);
        return this;
    }

    @Override
    public IPersonalDetailsPage setFirstName(String firstName) {
        personalDetailsSection = personalDetailsSection.setFirstName(firstName);
        return this;
    }

    @Override
    public IPersonalDetailsPage setLastName(String lastName) {
        personalDetailsSection = personalDetailsSection.setLastName(lastName);
        return this;
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