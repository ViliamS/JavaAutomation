package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmploymentIncomesPage extends HeaderAndBottomAndFormsMenuSection implements IEmploymentIncomesPage {

    private static final Log log = LogFactory.getLog(EmploymentIncomesPage.class);

    protected IEmploymentIncomeSection employmentIncomeSection;

//    @Inject
    public EmploymentIncomesPage(SharedDriver_Borrower webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        employmentIncomeSection = new EmploymentIncomeSection(webDriver);
        bottomSection = new BottomSection(webDriver);
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
        employmentIncomeSection.selectPaye_Occupation(occupation);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_EmploymentName(String employmentName) {
        employmentIncomeSection.typePaye_EmploymentName(employmentName);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectPaye_EmploymentType(String employmentType) {
        employmentIncomeSection.selectPaye_EmploymentType(employmentType);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_StartDate(String startDate) {
        employmentIncomeSection.typePaye_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_EndDate(String endDate) {
        employmentIncomeSection.typePaye_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage checkPaye_Currently(String currently) {
        employmentIncomeSection.checkPaye_Currently(currently);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typePaye_NetIncomeMonthly(String netIncomeMonthly) {
        employmentIncomeSection.typePaye_NetIncomeMonthly(netIncomeMonthly);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectSelfEmployment_Occupation(String occupation) {
        employmentIncomeSection.selectSelfEmployment_Occupation(occupation);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_StartDate(String startDate) {
        employmentIncomeSection.typeSelfEmployment_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_EndDate(String endDate) {
        employmentIncomeSection.typeSelfEmployment_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage checkSelfEmployment_Currently(String currently) {
        employmentIncomeSection.checkSelfEmployment_Currently(currently);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly) {
        employmentIncomeSection.typeSelfEmployment_NetIncomeMonthly(netIncomeMonthly);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_BusinessName(String businessNAme) {
        employmentIncomeSection.typeSelfEmployment_BusinessName(businessNAme);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_AddressLine1(String addressLine1) {
        employmentIncomeSection.typeSelfEmployment_AddressLine1(addressLine1);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_AddressLine2(String addressLine2) {
        employmentIncomeSection.typeSelfEmployment_AddressLine2(addressLine2);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_TownCity(String townCity) {
        employmentIncomeSection.typeSelfEmployment_TownCity(townCity);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectSelfEmployment_CountyState(String countyState) {
        employmentIncomeSection.selectSelfEmployment_CountyState(countyState);
        return this;
    }

    @Override
    public IEmploymentIncomesPage selectSelfEmployment_Country(String country) {
        employmentIncomeSection.selectSelfEmployment_Country(country);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeSelfEmployment_BusinessNature(String businessNature) {
        employmentIncomeSection.typeSelfEmployment_BusinessNature(businessNature);
        return this;
    }
    @Override
    public IEmploymentIncomesPage typeOther_StartDate(String startDate) {
        employmentIncomeSection.typeOther_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeOther_EndDate(String endDate) {
        employmentIncomeSection.typeOther_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeUnemployment_StartDate(String startDate) {
        employmentIncomeSection.typeUnemployment_StartDate(startDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeUnemployment_EndDate(String endDate) {
        employmentIncomeSection.typeUnemployment_EndDate(endDate);
        return this;
    }

    @Override
    public IEmploymentIncomesPage checkUnemployment_Currently(String currently) {
        employmentIncomeSection.checkUnemployment_Currently(currently);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeOther_NetIncomeMonthly(String netIncomeMonthly) {
        employmentIncomeSection.typeOther_NetIncomeMonthly(netIncomeMonthly);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeOther_AdditionalIncomeSource(String additionalIncomeSource) {
        employmentIncomeSection.typeOther_AdditionalIncomeSource(additionalIncomeSource);
        return this;
    }

    @Override
    public IEmploymentIncomesPage typeOther_EarningTime(String earningTIme) {
        employmentIncomeSection.typeOther_EarningTime(earningTIme);
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
}