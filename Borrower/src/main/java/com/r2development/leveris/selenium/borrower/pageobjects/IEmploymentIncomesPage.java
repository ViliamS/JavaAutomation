package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IEmploymentIncomesPage {

    IEmploymentIncomesPage selectCategory(String category);

    IEmploymentIncomesPage clickCategory(String category);

    IEmploymentIncomesPage selectPaye_Occupation(String occupation);

    IEmploymentIncomesPage typePaye_EmploymentName(String employmentName);

    IEmploymentIncomesPage selectPaye_EmploymentType(String employmentType);

    IEmploymentIncomesPage typePaye_StartDate(String startDate);

    IEmploymentIncomesPage typePaye_EndDate(String endDate);

    IEmploymentIncomesPage checkPaye_Currently(String currently);

    IEmploymentIncomesPage typePaye_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomesPage selectSelfEmployment_Occupation(String occupation);

    IEmploymentIncomesPage typeSelfEmployment_StartDate(String startDate);

    IEmploymentIncomesPage typeSelfEmployment_EndDate(String endDate);

    IEmploymentIncomesPage checkSelfEmployment_Currently(String currently);

    IEmploymentIncomesPage typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomesPage typeSelfEmployment_BusinessName(String businessNAme);

    IEmploymentIncomesPage typeSelfEmployment_AddressLine1(String addressLine1);

    IEmploymentIncomesPage typeSelfEmployment_AddressLine2(String addressLine2);

    IEmploymentIncomesPage typeSelfEmployment_TownCity(String townCity);

    IEmploymentIncomesPage selectSelfEmployment_CountyState(String countyState);

    IEmploymentIncomesPage selectSelfEmployment_Country(String country);

    IEmploymentIncomesPage typeSelfEmployment_BusinessNature(String businessNature);

    IEmploymentIncomesPage typeOther_StartDate(String startDate);

    IEmploymentIncomesPage typeOther_EndDate(String endDate);

    IEmploymentIncomesPage typeUnemployment_StartDate(String startDate);

    IEmploymentIncomesPage typeUnemployment_EndDate(String endDate);

    IEmploymentIncomesPage checkUnemployment_Currently(String currently);

    IEmploymentIncomesPage typeOther_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomesPage typeOther_AdditionalIncomeSource(String additionalIncomeSource);

    IEmploymentIncomesPage typeOther_EarningTime(String earningTIme);

    IEmploymentIncomesPage clickSaveAndClose();

    IEmploymentIncomesPage clickCancel();

    IEmploymentIncomesPage clickAdd();

    IYourAccountsPage clickDone();

    IEmploymentIncomesPage clickDelete(int index);

    IEmploymentIncomesPage clickDelete(String detailCategory);

    IEmploymentIncomesPage clickEdit(int index);

    IEmploymentIncomesPage clickEdit(String detailCategory);
}