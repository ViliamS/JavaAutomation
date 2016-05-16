package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.StaleElementReferenceException;

public class PersonalDetailsSection extends Borrower implements IPersonalDetailsSection {

    private static final Log log = LogFactory.getLog(PersonalDetailsSection.class.getName());

    public PersonalDetailsSection(SharedDriver_Borrower webDriver) {
        super(webDriver);
    }

    @Override
    public IPersonalDetailsSection setTitle(String title) {
        loadingCheck();
        isVisible(TITLE_INPUT_XPATH);
        type(TITLE_INPUT_XPATH, title);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setFirstName(String firstName) {
        loadingCheck();
        isVisible(FIRST_NAME_XPATH, true);
        type(FIRST_NAME_XPATH, firstName);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setMiddleName(String middleName) {
        loadingCheck();
        isVisible(MIDDLE_NAME_INPUT_XPATH);
        type(MIDDLE_NAME_INPUT_XPATH, middleName);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setLastName(String lastName) {
        loadingCheck();
        isVisible(LAST_NAME_XPATH, true);
        type(LAST_NAME_XPATH, lastName);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setSuffix(String suffix) {
        loadingCheck();
        isVisible(SUFFIX_INPUT_XPATH);
        type(SUFFIX_INPUT_XPATH, suffix);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection checkGenderMale() {
        return checkGender("Male");
    }

    @Override
    public IPersonalDetailsSection checkGenderFemale() {
        return checkGender("Female");
    }

    @Override
    public IPersonalDetailsSection checkGender(String gender) {
        loadingCheck();
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
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection setDateOfBirth(String dateOfBirth) {
        loadingCheck();
        isVisible(DATE_OF_BIRTH_XPATH, true);
        try {
            type(DATE_OF_BIRTH_XPATH, dateOfBirth);
        } catch (StaleElementReferenceException sere) {
            log.info(sere);
            sendKeysElement(DATE_OF_BIRTH_XPATH, dateOfBirth, 0);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectMaritalStatus(String maritalStatus) {
        loadingCheck();
        isVisible(MARITAL_STATUS_XPATH, true);
        selectFromDropDown(MARITAL_STATUS_XPATH, maritalStatus);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection selectNationality(String nationality) {
        loadingCheck();
        isVisible(NATIONALITY_XPATH, true);
        selectFromDropDown(NATIONALITY_XPATH, nationality);
        loadingCheck();
        return this;
    }

    @Override
    public IPersonalDetailsSection clickSave() {
        loadingCheck();
        isVisible(SAVE_BUTTON_XPATH, true);
        clickElement(SAVE_BUTTON_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isLoaded() {
        loadingCheck();
        isVisible(SAVE_BUTTON_XPATH, true);
        return true;
    }
}