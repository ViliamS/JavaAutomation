package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmploymentIncomesPage extends HeaderAndBottomAndFormsMenuSection implements IEmploymentIncomesPage {

    private static final Log log = LogFactory.getLog(EmploymentIncomesPage.class);

    protected IEmploymentIncomeSection employmentIncomeSection;

//    @Inject
    public EmploymentIncomesPage(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        employmentIncomeSection = new EmploymentIncomeSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return employmentIncomeSection.getTitle();
    }

    @Override
    public boolean isTitle(String firstName) {
        return employmentIncomeSection.isTitle(firstName);
    }

    @Override
    public String getDescriptionEmploymentIncome() {
        return employmentIncomeSection.getDescriptionEmploymentIncome();
    }

    @Override @Deprecated
    public IEmploymentIncomesPage selectCategory(String category) {
        employmentIncomeSection.selectCategory(category);
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickCategory(String category) {
        employmentIncomeSection.clickCategory(category);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectPaye_Occupation(String occupation) {
//        employmentIncomeSection.selectPaye_Occupation(occupation);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_EmploymentName(String employmentName) {
//        employmentIncomeSection.typePaye_EmploymentName(employmentName);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectPaye_EmploymentType(String employmentType) {
//        employmentIncomeSection.selectPaye_EmploymentType(employmentType);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_StartDate(String startDate) {
//        employmentIncomeSection.typePaye_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_EndDate(String endDate) {
//        employmentIncomeSection.typePaye_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage checkPaye_Currently(String currently) {
//        employmentIncomeSection.checkPaye_Currently(currently);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_NetIncomeMonthly(String netIncomeMonthly) {
//        employmentIncomeSection.typePaye_NetIncomeMonthly(netIncomeMonthly);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectSelfEmployment_Occupation(String occupation) {
//        employmentIncomeSection.selectSelfEmployment_Occupation(occupation);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_StartDate(String startDate) {
//        employmentIncomeSection.typeSelfEmployment_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_EndDate(String endDate) {
//        employmentIncomeSection.typeSelfEmployment_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage checkSelfEmployment_Currently(String currently) {
//        employmentIncomeSection.checkSelfEmployment_Currently(currently);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly) {
//        employmentIncomeSection.typeSelfEmployment_NetIncomeMonthly(netIncomeMonthly);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_BusinessName(String businessNAme) {
//        employmentIncomeSection.typeSelfEmployment_BusinessName(businessNAme);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_AddressLine1(String addressLine1) {
//        employmentIncomeSection.typeSelfEmployment_AddressLine1(addressLine1);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_AddressLine2(String addressLine2) {
//        employmentIncomeSection.typeSelfEmployment_AddressLine2(addressLine2);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_TownCity(String townCity) {
//        employmentIncomeSection.typeSelfEmployment_TownCity(townCity);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectSelfEmployment_CountyState(String countyState) {
//        employmentIncomeSection.selectSelfEmployment_CountyState(countyState);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectSelfEmployment_Country(String country) {
//        employmentIncomeSection.selectSelfEmployment_Country(country);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_BusinessNature(String businessNature) {
//        employmentIncomeSection.typeSelfEmployment_BusinessNature(businessNature);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectCivilServant_Occupation(String occupation) {
//        employmentIncomeSection.selectCivilServant_Occupation(occupation);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeCivilServant_EmploymentName(String employmentName) {
//        employmentIncomeSection.typeCivilServant_EmploymentName(employmentName);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectCivilServant_EmploymentType(String employmentType) {
//        employmentIncomeSection.selectCivilServant_EmploymentType(employmentType);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeCivilServant_StartDate(String startDate) {
//        employmentIncomeSection.typeCivilServant_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeCivilServant_EndDate(String endDate) {
//        employmentIncomeSection.typeCivilServant_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage checkCivilServant_Currently(String currently) {
//        employmentIncomeSection.checkCivilServant_Currently(currently);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeCivilServant_NetIncomeMonthly(String netIncomeMonthly) {
//        employmentIncomeSection.typeCivilServant_NetIncomeMonthly(netIncomeMonthly);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeUnemployment_StartDate(String startDate) {
//        employmentIncomeSection.typeUnemployment_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeUnemployment_EndDate(String endDate) {
//        employmentIncomeSection.typeUnemployment_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage checkUnemployment_Currently(String currently) {
//        employmentIncomeSection.checkUnemployment_Currently(currently);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeOther_NetIncomeMonthly(String netIncomeMonthly) {
//        employmentIncomeSection.typeOther_NetIncomeMonthly(netIncomeMonthly);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeOther_AdditionalIncomeSource(String additionalIncomeSource) {
//        employmentIncomeSection.typeOther_AdditionalIncomeSource(additionalIncomeSource);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeOther_EarningTime(String earningTIme) {
//        employmentIncomeSection.typeOther_EarningTime(earningTIme);
        return this;
    }


    @Override
    public IEmploymentIncomesPage clickSaveAndClose() {
        employmentIncomeSection.clickSaveAndClose();
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickCancel() {
        employmentIncomeSection.clickCancel();
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickAdd() {
        employmentIncomeSection.clickAdd();
        return this;
    }

    @Override
    public IYourAccountsPage clickDone() {
        return employmentIncomeSection.clickDone();
    }

    @Override
    public IEmploymentIncomesPage clickDelete(int index) {
        employmentIncomeSection.clickDelete(index);
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickDelete(String detailCategory) {
        employmentIncomeSection.clickDelete(detailCategory);
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickEdit(int index) {
        employmentIncomeSection.clickEdit(index);
        return this;
    }

    @Override
    public IEmploymentIncomesPage clickEdit(String detailCategory) {
        employmentIncomeSection.clickEdit(detailCategory);
        return this;
    }










//    @Override
//    public IEmploymentIncomesPage selectEIP_Occupation(String occupation) {
//        employmentIncomeSection.selectEIP_Occupation(occupation);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_EmployerName(String employerName) {
//        employmentIncomeSection.typeEIP_EmployerName(employerName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage selectEIP_EmploymentType(String employmentType) {
//        employmentIncomeSection.selectEIP_EmploymentType(employmentType);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_StartDate(String startDate) {
//        employmentIncomeSection.typeEIP_StartDate(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_MandatoryEndDate(String mandatoryEndDate) {
//        employmentIncomeSection.typeEIP_MandatoryEndDate(mandatoryEndDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_EndDate(String endDate) {
//        employmentIncomeSection.typeEIP_EndDate(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage checkEIP_Currently() {
//        employmentIncomeSection.checkEIP_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage uncheckEIP_Currently() {
//        employmentIncomeSection.uncheckEIP_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_NetMonthlyIncome(String netMonthlyIncome) {
//        employmentIncomeSection.typeEIP_NetMonthlyIncome(netMonthlyIncome);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_GrossSalary(String grossSalary) {
//        employmentIncomeSection.typeEIP_GrossSalary(grossSalary);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_RegularOvertime(String regularOvertime) {
//        employmentIncomeSection.typeEIP_RegularOvertime(regularOvertime);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_RegularGuaranteedBonus(String regularGuaranteedBonus) {
//        employmentIncomeSection.typeEIP_RegularGuaranteedBonus(regularGuaranteedBonus);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIP_GuaranteedCommission(String guaranteedCommission) {
//        employmentIncomeSection.typeEIP_GuaranteedCommission(guaranteedCommission);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage selectEISE_Occupation(String occupation) {
//        employmentIncomeSection.selectEISE_Occupation(occupation);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_BusinessName(String businessName) {
//        employmentIncomeSection.typeEISE_BusinessName(businessName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_AddressLine1(String addressLine1) {
//        employmentIncomeSection.typeEISE_AddressLine1(addressLine1);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_AddressLine2(String addressLine2) {
//        employmentIncomeSection.typeEISE_AddressLine2(addressLine2);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_TownCity(String townCity) {
//        employmentIncomeSection.typeEISE_TownCity(townCity);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage selectEISE_CountyState(String countyState) {
//        employmentIncomeSection.selectEISE_CountyState(countyState);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage selectEISE_Country(String country) {
//        employmentIncomeSection.selectEISE_Country(country);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_BusinessNature(String businessNature) {
//        employmentIncomeSection.typeEISE_BusinessNature(businessNature);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_StartDate(String startDate) {
//        employmentIncomeSection.typeEISE_StartDate(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_EndDate(String endDate) {
//        employmentIncomeSection.typeEISE_EndDate(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage checkEISE_Currently() {
//        employmentIncomeSection.checkEISE_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage uncheckEISE_Currently() {
//        employmentIncomeSection.uncheckEISE_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_NetProfitLastYear(String netProfitLastYear) {
//        employmentIncomeSection.typeEISE_NetProfitLastYear(netProfitLastYear);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_NetProfitPreviousYear(String netProfitPreviousYear) {
//        employmentIncomeSection.typeEISE_NetProfitPreviousYear(netProfitPreviousYear);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEISE_AccountantName(String accountantName) {
//        employmentIncomeSection.typeEISE_AccountantName(accountantName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage selectEICS_Occupation(String occupation) {
//        employmentIncomeSection.selectEICS_Occupation(occupation);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_EmployerName(String employerName) {
//        employmentIncomeSection.typeEICS_EmployerName(employerName);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage selectEICS_EmploymentType(String employmentType) {
//        employmentIncomeSection.selectEICS_EmploymentType(employmentType);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_StartDate(String startDate) {
//        employmentIncomeSection.typeEICS_StartDate(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_MandatoryEndDate(String mandatoryEndDate) {
//        employmentIncomeSection.typeEICS_MandatoryEndDate(mandatoryEndDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_EndDate(String endDate) {
//        employmentIncomeSection.typeEICS_EndDate(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage checkEICS_Currently() {
//        employmentIncomeSection.checkEICS_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage uncheckEICS_Currently() {
//        employmentIncomeSection.uncheckEICS_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_GrossSalary(String grossSalary) {
//        employmentIncomeSection.typeEICS_GrossSalary(grossSalary);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_RegularOvertime(String regularOvertime) {
//        employmentIncomeSection.typeEICS_RegularOvertime(regularOvertime);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_RegularGuaranteedBonus(String regularGuaranteedBonus) {
//        employmentIncomeSection.typeEICS_RegularGuaranteedBonus(regularGuaranteedBonus);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEICS_GuaranteedCommission(String guaranteedCommission) {
//        employmentIncomeSection.typeEICS_GuaranteedCommission(guaranteedCommission);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIUH_StartDate(String startDate) {
//        employmentIncomeSection.typeEIUH_StartDate(startDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIUH_EndDate(String endDate) {
//        employmentIncomeSection.typeEIUH_EndDate(endDate);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage checkEIUH_Currently() {
//        employmentIncomeSection.checkEIUH_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage uncheckEIUH_Currently() {
//        employmentIncomeSection.uncheckEIUH_Currently();
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIO_SourceIncome(String sourceIncome) {
//        employmentIncomeSection.typeEIO_SourceIncome(sourceIncome);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIO_GrossIncomes(String grossIncomes) {
//        employmentIncomeSection.typeEIO_GrossIncomes(grossIncomes);
//        return this;
//    }
//
//    @Override
//    public IEmploymentIncomesPage typeEIO_TimeEarningIncome(String timeEarningIncome) {
//        employmentIncomeSection.typeEIO_TimeEarningIncome(timeEarningIncome);
//        return this;
//    }
//
//    @Override
//    public boolean isExistReportIncomes() {
//        return employmentIncomeSection.isExistReportIncomes();
//    }
//
//    @Override
//    public Map<Integer, ReportEmploymentIncome> getReportsEmploymentIncome() {
//        return employmentIncomeSection.getReportsEmploymentIncome();
//    }
//
//    @Override
//    public Map<Integer, ReportEmploymentIncome> delReportEmploymentIncome(int i) {
//        return employmentIncomeSection.delReportEmploymentIncome(i);
//    }
//
//    @Override
//    public IEmploymentIncomesPage clickEmploymentIncomeCancel() {
//        employmentIncomeSection.clickEmploymentIncomeCancel();
//        return this;
//    }
//
//    // TODO checking if the box is rendered
//    @Override
//    public IEmploymentIncomesPage clickEmploymentIncomeAddEmployment() {
//        employmentIncomeSection.clickEmploymentIncomeAddEmployment();
//        return this;
//    }
//
//    // TODO checking if the box is rendered
//    @Override
//    public IEmploymentIncomesPage clickEmploymentIncomeAddThisEmployment() {
//        employmentIncomeSection.clickEmploymentIncomeAddThisEmployment();
//        return this;
//    }
//
//    @Override
//    public IYourAccountsPage clickEmploymentIncomeDone() {
//        return employmentIncomeSection.clickEmploymentIncomeDone();
//    }
}
