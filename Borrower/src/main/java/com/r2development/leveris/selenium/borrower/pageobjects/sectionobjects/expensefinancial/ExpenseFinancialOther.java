package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class ExpenseFinancialOther implements IExpenseFinancialOther, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public ExpenseFinancialOther(SharedDriver webDriver)  {
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
    public IExpenseFinancialOther typeOtherRepaymentAmount(String repaymentAmount) {
        return null;
    }

    @Override
    public IExpenseFinancialOther typeOtherValue(String value) {
        return null;
    }

    @Override
    public IExpenseFinancialOther typeOtherDescription(String description) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}