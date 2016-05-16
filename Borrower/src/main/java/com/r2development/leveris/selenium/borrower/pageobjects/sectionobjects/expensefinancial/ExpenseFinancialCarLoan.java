package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class ExpenseFinancialCarLoan implements IExpenseFinancialCarLoan, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public ExpenseFinancialCarLoan(SharedDriver_Borrower webDriver) {
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
    public IExpenseFinancialCarLoan typeCarOutstandingBalanceAmount(String outstandingBalanceAmount) {
        return null;
    }

    @Override
    public IExpenseFinancialCarLoan typeCarFinancialInstitution(String financialInstitution) {
        return null;
    }

    @Override
    public IExpenseFinancialCarLoan typeCarFinalRepaymentDate(String finalRepaymentDate) {
        return null;
    }

    @Override
    public IExpenseFinancialCarLoan selectCarPaymentFrequency(String paymentFrequency) {
        return null;
    }

    @Override
    public IExpenseFinancialCarLoan typeCarRepaymentAmount(String repaymentAmount) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}