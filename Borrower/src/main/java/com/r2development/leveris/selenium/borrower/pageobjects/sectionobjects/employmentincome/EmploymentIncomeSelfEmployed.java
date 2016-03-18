package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Created by anthonymottot on 18/03/2016.
 */
public class EmploymentIncomeSelfEmployed implements IEmploymentIncomeSelfEmployed, IHeaderForm, IForm, ICancelSaveClose {

    private final WebDriver webDriver;

    public EmploymentIncomeSelfEmployed(SharedDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void FillIn(Map<String, String> data) {

    }

    @Override
    public IEmploymentIncomeSelfEmployed selectSelfEmployment_Occupation(String occupation) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_StartDate(String startDate) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_EndDate(String endDate) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed checkSelfEmployment_Currently(String currently) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_BusinessName(String businessName) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_AddressLine1(String addressLine1) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_AddressLine2(String addressLine2) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_TownCity(String townCity) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed selectSelfEmployment_CountyState(String countyState) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed selectSelfEmployment_Country(String country) {
        return null;
    }

    @Override
    public IEmploymentIncomeSelfEmployed typeSelfEmployment_BusinessNature(String businessNature) {
        return null;
    }

    @Override
    public void clickCancel() {

    }

    @Override
    public void clickSaveAndClose() {

    }
}
