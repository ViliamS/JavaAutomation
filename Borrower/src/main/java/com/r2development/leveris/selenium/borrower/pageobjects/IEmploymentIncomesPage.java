package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IEmploymentIncomesPage {
    String getTitle();
    boolean isTitle(String FirstName);

    String getDescriptionEmploymentIncome();

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

    IEmploymentIncomesPage selectCivilServant_Occupation(String occupation);
    IEmploymentIncomesPage typeCivilServant_EmploymentName(String employmentName);
    IEmploymentIncomesPage selectCivilServant_EmploymentType(String employmentType);
    IEmploymentIncomesPage typeCivilServant_StartDate(String startDate);
    IEmploymentIncomesPage typeCivilServant_EndDate(String endDate);
    IEmploymentIncomesPage checkCivilServant_Currently(String currently);
    IEmploymentIncomesPage typeCivilServant_NetIncomeMonthly(String netIncomeMonthly);

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




//    // case PAYE
//    IEmploymentIncomesPage selectEIP_Occupation(String occupation);
//    IEmploymentIncomesPage typeEIP_EmployerName(String employerName);
//    IEmploymentIncomesPage typeEIP_NetMonthlyIncome(String netMonthlyIncome);
//    // Contract, Permanent, Temporary
//    IEmploymentIncomesPage selectEIP_EmploymentType(String employmentType);
//    IEmploymentIncomesPage typeEIP_StartDate(String startDate);
//    // case PAY Contract
//    IEmploymentIncomesPage typeEIP_MandatoryEndDate(String mandatoryEndDate);
//    // case PAY Permanent, Temporary
//    IEmploymentIncomesPage typeEIP_EndDate(String endDate);
//    // case not valid for PAY Contract only for Permanent, Temporary
//    IEmploymentIncomesPage checkEIP_Currently();
//    IEmploymentIncomesPage uncheckEIP_Currently();
//    IEmploymentIncomesPage typeEIP_GrossSalary(String grossSalary);
//    IEmploymentIncomesPage typeEIP_RegularOvertime(String regularOvertime);
//    IEmploymentIncomesPage typeEIP_RegularGuaranteedBonus(String regularGuaranteedBonus);
//    IEmploymentIncomesPage typeEIP_GuaranteedCommission(String guaranteedCommission);
//
//    // case SELF_EMPLOYED
//    IEmploymentIncomesPage selectEISE_Occupation(String occupation);
//    IEmploymentIncomesPage typeEISE_BusinessName(String businessName);
//    IEmploymentIncomesPage typeEISE_AddressLine1(String addressLine1);
//    IEmploymentIncomesPage typeEISE_AddressLine2(String addressLine2);
//    IEmploymentIncomesPage typeEISE_TownCity(String townCity);
//    // if country is Ireland
//    IEmploymentIncomesPage selectEISE_CountyState(String countyState);
//    IEmploymentIncomesPage selectEISE_Country(String country);
//    IEmploymentIncomesPage typeEISE_BusinessNature(String businessNature);
//    IEmploymentIncomesPage typeEISE_StartDate(String startDate);
//    IEmploymentIncomesPage typeEISE_EndDate(String endDate);
//    IEmploymentIncomesPage checkEISE_Currently();
//    IEmploymentIncomesPage uncheckEISE_Currently();
//    IEmploymentIncomesPage typeEISE_NetProfitLastYear(String netProfitLastYear);
//    IEmploymentIncomesPage typeEISE_NetProfitPreviousYear(String netProfitPreviousYear);
//    IEmploymentIncomesPage typeEISE_AccountantName(String accountantName);
//
//    // case CIVIL_SERVANT
//    IEmploymentIncomesPage selectEICS_Occupation(String occupation);
//    IEmploymentIncomesPage typeEICS_EmployerName(String employerName);
//    // Contract, Permanent, Temporary
//    IEmploymentIncomesPage selectEICS_EmploymentType(String employmentType);
//    IEmploymentIncomesPage typeEICS_StartDate(String startDate);
//    // case PAY Contract
//    IEmploymentIncomesPage typeEICS_MandatoryEndDate(String mandatoryEndDate);
//    // case PAY Permanent, Temporary
//    IEmploymentIncomesPage typeEICS_EndDate(String endDate);
//    // case not valid for PAY Contract only for Permanent, Temporary
//    IEmploymentIncomesPage checkEICS_Currently();
//    IEmploymentIncomesPage uncheckEICS_Currently();
//    IEmploymentIncomesPage typeEICS_GrossSalary(String grossSalary);
//    IEmploymentIncomesPage typeEICS_RegularOvertime(String regularOvertime);
//    IEmploymentIncomesPage typeEICS_RegularGuaranteedBonus(String regularGuaranteedBonus);
//    IEmploymentIncomesPage typeEICS_GuaranteedCommission(String guaranteedCommission);
//
//    // case UNEMPLOYED_HOMEMAKER
//    IEmploymentIncomesPage typeEIUH_StartDate(String startDate);
//    IEmploymentIncomesPage typeEIUH_EndDate(String endDate);
//    IEmploymentIncomesPage checkEIUH_Currently();
//    IEmploymentIncomesPage uncheckEIUH_Currently();
//
//    // case OTHER
//    IEmploymentIncomesPage typeEIO_SourceIncome(String sourceIncome);
//    IEmploymentIncomesPage typeEIO_GrossIncomes(String grossIncomes);
//    IEmploymentIncomesPage typeEIO_TimeEarningIncome(String timeEarningIncome);
//
//    boolean isExistReportIncomes();
//    Map<Integer, ReportEmploymentIncome> getReportsEmploymentIncome(); // model or di ?
//    Map<Integer, ReportEmploymentIncome> delReportEmploymentIncome(int i); // to think about it !
//
//    IEmploymentIncomesPage clickEmploymentIncomeCancel();
//    IEmploymentIncomesPage clickEmploymentIncomeAddEmployment();
//    IEmploymentIncomesPage clickEmploymentIncomeAddThisEmployment();
//    IYourAccountsPage clickEmploymentIncomeDone();
}
