package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IPersonalDetailsPage {

    IPersonalDetailsPage setTitle(String title);

    IPersonalDetailsPage setFirstName(String FirstName);

    IPersonalDetailsPage setLastName(String LastName);

    IPersonalDetailsPage setMiddleName(String middleName);

    IPersonalDetailsPage setSuffix(String suffix);

    IPersonalDetailsPage checkGenderMale();

    IPersonalDetailsPage checkGenderFemale();

    IPersonalDetailsPage checkGender(String gender);

    IPersonalDetailsPage setDateOfBirth(String dateOfBirth);

    IPersonalDetailsPage selectMaritalStatus(String maritalStatus);

    IPersonalDetailsPage selectNationality(String nationality);

    IPersonalDetailsPage clickSave();

    boolean isLoaded();

    IFormsMenu clickBorrowerEmploymentIncome();

    IFormsMenu clickBorrowerEmploymentIncome(String borrowerOrCoapplicant);

    IFormsMenu clickAccount();

    IFormsMenu clickDependants();

    IFormsMenu clickFinancialAssets();

    IFormsMenu clickProperties();

    IFormsMenu clickFinancialCommitments();

    IFormsMenu clickFunding();

    IFormsMenu clickDocumentUpload();
}