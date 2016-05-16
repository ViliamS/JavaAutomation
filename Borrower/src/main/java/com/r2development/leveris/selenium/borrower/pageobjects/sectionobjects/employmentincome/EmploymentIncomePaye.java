package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class EmploymentIncomePaye implements IEmploymentIncomePaye, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public EmploymentIncomePaye(SharedDriver_Borrower webDriver) {
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
    public IEmploymentIncomePaye selectPaye_Occupation(String occupation) {
        return null;
    }

    @Override
    public IEmploymentIncomePaye typePaye_EmploymentName(String employmentName) {
        return null;
    }

    @Override
    public IEmploymentIncomePaye selectPaye_EmploymentType(String employmentType) {
        return null;
    }

    @Override
    public IEmploymentIncomePaye typePaye_StartDate(String startDate) {
        return null;
    }

    @Override
    public IEmploymentIncomePaye typePaye_EndDate(String endDate) {
        return null;
    }

    @Override
    public IEmploymentIncomePaye checkPaye_Currently(String currently) {
        return null;
    }

    @Override
    public IEmploymentIncomePaye typePaye_NetIncomeMonthly(String netIncomeMonthly) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}