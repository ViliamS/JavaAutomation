package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.employmentincome.IEmploymentIncomeUnemployed;

import java.util.Map;

public class ExpenseFinancialPersonalLoan implements IEmploymentIncomeUnemployed, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public ExpenseFinancialPersonalLoan(SharedDriver webDriver) {
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
