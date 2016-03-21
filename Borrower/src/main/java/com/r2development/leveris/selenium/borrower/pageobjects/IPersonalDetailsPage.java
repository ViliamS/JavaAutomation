package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IPersonalDetailsPage {
    String getTitle();
    boolean isTitle(String FirstName);

    IPersonalDetailsPage setTitle(String title);
    IPersonalDetailsPage setFirstname(String FirstName);
    IPersonalDetailsPage setLastname(String LastName);
    IPersonalDetailsPage setMiddleName(String middleName);
    IPersonalDetailsPage setSuffix(String suffix);

    boolean isGenderLabel();
    IPersonalDetailsPage checkGenderMale();
    IPersonalDetailsPage checkGenderFemale();
    IPersonalDetailsPage checkGender(String gender);

    IPersonalDetailsPage setDateOfBirth(String dateOfBirth);

    IPersonalDetailsPage selectMaritalStatus(String maritalStatus);

    IPersonalDetailsPage selectNationality(String nationality);
    IPersonalDetailsPage setResidentYears(String residentYears);
    boolean isRequiredVisa();
    IPersonalDetailsPage checkRequiredVisaYes();
    IPersonalDetailsPage checkRequiredVisaNo();
    IPersonalDetailsPage checkRequiredVisa(boolean requiredVisa);

    IPersonalDetailsPage setResidencyAddressLine1(String residencyAddressLine1);
    IPersonalDetailsPage setResidencyAddressLine2(String residencyAddressLine2);
    IPersonalDetailsPage setResidencyTownCity(String residencyTownCity);
    IPersonalDetailsPage selectResidencyCountyState(String residencyCountyState);
    IPersonalDetailsPage setResidencyPostcodeZip(String residencyPostcodeZip);
    IPersonalDetailsPage selectResidencyCountry(String residencyCountry);
    IPersonalDetailsPage selectResidencyAccommodation(String residencyAccommodation);
    IPersonalDetailsPage setResidencyRent(String residencyRent);

    boolean isLivedLast3Years();
    IPersonalDetailsPage checkLivedLast3YearsYes();
    IPersonalDetailsPage checkLivedLast3YearsNo();
    IPersonalDetailsPage checkLivedLast3Years(boolean livedLast3Years);

    IPersonalDetailsPage setPreviousResidencyAddressLine1(String previousResidencyAddressLine1);
    IPersonalDetailsPage setPreviousResidencyAddressLine2(String previousResidencyAddressLine2);
    IPersonalDetailsPage setPreviousResidencyTownCity(String previousResidencyTownCity);
    IPersonalDetailsPage selectPreviousResidencyCountyState(String previousResidencyCountyState);
    IPersonalDetailsPage setPreviousResidencyPostcodeZip(String previousResidencyPostcodeZip);
    IPersonalDetailsPage selectPreviousResidencyCountry(String previousResidencyCountry);
    IPersonalDetailsPage setPreviousResidencyCountry(String previousResidencyCountry);

    IPersonalDetailsPage clickSave();
    boolean isBorrowerPersonalDetailsValid(String borrower);
    boolean isBorrowerPersonalDetailsValid();
    boolean isCoapplicantPersonalDetailsValid(String coapplicant);
    boolean isLoaded();

    IFormsMenu clickBorrowerEmploymentIncome();
    IFormsMenu clickBorrowerEmploymentIncome(String borrowerOrCoapplicant);
    IFormsMenu clickAccount();
//    IFormsMenu clickAccount(String singleOrDouble);
    IFormsMenu clickDependants();
//    IFormsMenu clickDependants(String singleOrDouble);
    IFormsMenu clickFinancialAssets();
//    IFormsMenu clickFinancialAssets(String singleOrDouble);
    IFormsMenu clickProperties();
//    IFormsMenu clickProperties(String singleOrDouble);
    IFormsMenu clickFinancialCommitments();
//    IFormsMenu clickFinancialCommitments(String singleOrDouble);
    IFormsMenu clickFunding();
//    IFormsMenu clickFunding(String singleOrDouble);
    IFormsMenu clickDocumentUpload();
//    IFormsMenu clickDocumentUpload(String singleOrDouble);
}
