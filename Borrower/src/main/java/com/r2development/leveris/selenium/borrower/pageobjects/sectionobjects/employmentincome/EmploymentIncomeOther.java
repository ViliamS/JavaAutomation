package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class EmploymentIncomeOther implements IEmploymentIncomeOther, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public EmploymentIncomeOther(SharedDriver_Borrower webDriver) {
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
    public IEmploymentIncomeOther typeOther_NetIncomeMonthly(String netIncomeMonthly) {
        return null;
    }

    @Override
    public IEmploymentIncomeOther typeOther_AdditionalIncomeSource(String additionalIncomeSource) {
        return null;
    }

    @Override
    public IEmploymentIncomeOther typeOther_EarningTime(String earningTIme) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}