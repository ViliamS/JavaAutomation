package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.account;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class CurrentAccount implements ICurrentAccount, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public CurrentAccount(SharedDriver_Borrower webDriver) {
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
    public ICurrentAccount typeCurrentStatementDate(String statementDate) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentAccountName(String accountName) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentSortCode1(String sortCode1) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentSortCode2(String sortCode2) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentSortCode3(String sortCode3) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentAccountProvider(String accountProvider) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentIban(String iban) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentAccountBalance(String accountBalance) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentOverdraftLimit(String overdraftLimit) {
        return null;
    }

    @Override
    public ICurrentAccount selectCurrentSavingSource(String savingSource) {
        return null;
    }

    @Override
    public ICurrentAccount typeCurrentRegularMonthlySavings(String regularMonthlySavings) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}