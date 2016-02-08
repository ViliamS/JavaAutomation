package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.Map;

public interface IEmploymentIncomesPage {
    String getTitle();
    boolean isTitle(String FirstName);

    String getDescriptionEmploymentIncome();

    IEmploymentIncomesPage selectCategory(String category);
    IEmploymentIncomesPage clickCategory(String category);

    // case PAYE
    IEmploymentIncomesPage selectEIP_Occupation(String occupation);
    IEmploymentIncomesPage typeEIP_EmployerName(String employerName);
    // Contract, Permanent, Temporary
    IEmploymentIncomesPage selectEIP_EmploymentType(String employmentType);
    IEmploymentIncomesPage typeEIP_StartDate(String startDate);
    // case PAY Contract
    IEmploymentIncomesPage typeEIP_MandatoryEndDate(String mandatoryEndDate);
    // case PAY Permanent, Temporary
    IEmploymentIncomesPage typeEIP_EndDate(String endDate);
    // case not valid for PAY Contract only for Permanent, Temporary
    IEmploymentIncomesPage checkEIP_Currently();
    IEmploymentIncomesPage uncheckEIP_Currently();
    IEmploymentIncomesPage typeEIP_GrossSalary(String grossSalary);
    IEmploymentIncomesPage typeEIP_RegularOvertime(String regularOvertime);
    IEmploymentIncomesPage typeEIP_RegularGuaranteedBonus(String regularGuaranteedBonus);
    IEmploymentIncomesPage typeEIP_GuaranteedCommission(String guaranteedCommission);

    // case SELF_EMPLOYED
    IEmploymentIncomesPage selectEISE_Occupation(String occupation);
    IEmploymentIncomesPage typeEISE_BusinessName(String businessName);
    IEmploymentIncomesPage typeEISE_AddressLine1(String addressLine1);
    IEmploymentIncomesPage typeEISE_AddressLine2(String addressLine2);
    IEmploymentIncomesPage typeEISE_TownCity(String townCity);
    // if country is Ireland
    IEmploymentIncomesPage selectEISE_CountyState(String countyState);
    IEmploymentIncomesPage selectEISE_Country(String country);
    IEmploymentIncomesPage typeEISE_BusinessNature(String businessNature);
    IEmploymentIncomesPage typeEISE_StartDate(String startDate);
    IEmploymentIncomesPage typeEISE_EndDate(String endDate);
    IEmploymentIncomesPage checkEISE_Currently();
    IEmploymentIncomesPage uncheckEISE_Currently();
    IEmploymentIncomesPage typeEISE_NetProfitLastYear(String netProfitLastYear);
    IEmploymentIncomesPage typeEISE_NetProfitPreviousYear(String netProfitPreviousYear);
    IEmploymentIncomesPage typeEISE_AccountantName(String accountantName);

    // case CIVIL_SERVANT
    IEmploymentIncomesPage selectEICS_Occupation(String occupation);
    IEmploymentIncomesPage typeEICS_EmployerName(String employerName);
    // Contract, Permanent, Temporary
    IEmploymentIncomesPage selectEICS_EmploymentType(String employmentType);
    IEmploymentIncomesPage typeEICS_StartDate(String startDate);
    // case PAY Contract
    IEmploymentIncomesPage typeEICS_MandatoryEndDate(String mandatoryEndDate);
    // case PAY Permanent, Temporary
    IEmploymentIncomesPage typeEICS_EndDate(String endDate);
    // case not valid for PAY Contract only for Permanent, Temporary
    IEmploymentIncomesPage checkEICS_Currently();
    IEmploymentIncomesPage uncheckEICS_Currently();
    IEmploymentIncomesPage typeEICS_GrossSalary(String grossSalary);
    IEmploymentIncomesPage typeEICS_RegularOvertime(String regularOvertime);
    IEmploymentIncomesPage typeEICS_RegularGuaranteedBonus(String regularGuaranteedBonus);
    IEmploymentIncomesPage typeEICS_GuaranteedCommission(String guaranteedCommission);

    // case UNEMPLOYED_HOMEMAKER
    IEmploymentIncomesPage typeEIUH_StartDate(String startDate);
    IEmploymentIncomesPage typeEIUH_EndDate(String endDate);
    IEmploymentIncomesPage checkEIUH_Currently();
    IEmploymentIncomesPage uncheckEIUH_Currently();

    // case OTHER
    IEmploymentIncomesPage typeEIO_SourceIncome(String sourceIncome);
    IEmploymentIncomesPage typeEIO_GrossIncomes(String grossIncomes);
    IEmploymentIncomesPage typeEIO_TimeEarningIncome(String timeEarningIncome);

    boolean isExistReportIncomes();
    Map<Integer, ReportEmploymentIncome> getReportsEmploymentIncome(); // model or di ?
    Map<Integer, ReportEmploymentIncome> delReportEmploymentIncome(int i); // to think about it !

    IEmploymentIncomesPage clickEmploymentIncomeCancel();
    IEmploymentIncomesPage clickEmploymentIncomeAddEmployment();
    IEmploymentIncomesPage clickEmploymentIncomeAddThisEmployment();
    IEmploymentIncomesPage clickEmploymentIncomeDone();
}
