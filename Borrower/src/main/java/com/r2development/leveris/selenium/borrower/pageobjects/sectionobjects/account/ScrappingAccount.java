package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.account;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class ScrappingAccount implements ISavingsAccount, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public ScrappingAccount(SharedDriver_Borrower webDriver) {
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
    public ISavingsAccount typeSavingStatementDate(String statementDate) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingsAccountName(String accountName) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingsSortCode1(String sortCode1) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingsSortCode2(String sortCode2) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingsSortCode3(String sortCode3) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingsAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingAccountProvider(String accountProvider) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingIban(String iban) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingAccountBalance(String accountBalance) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingOverdraftLimit(String savingOverdraftLimit) {
        return null;
    }

    @Override
    public ISavingsAccount selectSavingSourceSavings(String sourceSaving) {
        return null;
    }

    @Override
    public ISavingsAccount typeSavingRegularMonthlySavings(String savingRegularMonthlySavings) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}