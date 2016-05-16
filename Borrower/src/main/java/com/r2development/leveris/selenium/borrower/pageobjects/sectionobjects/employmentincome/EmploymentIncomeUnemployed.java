package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class EmploymentIncomeUnemployed implements IEmploymentIncomeUnemployed, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public EmploymentIncomeUnemployed(SharedDriver_Borrower webDriver) {
//        this.webDriver = webDriver;
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
    public IEmploymentIncomeUnemployed typeUnemployment_StartDate(String startDate) {
        return null;
    }

    @Override
    public IEmploymentIncomeUnemployed typeUnemployment_EndDate(String endDate) {
        return null;
    }

    @Override
    public IEmploymentIncomeUnemployed checkUnemployment_Currently(String currently) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}