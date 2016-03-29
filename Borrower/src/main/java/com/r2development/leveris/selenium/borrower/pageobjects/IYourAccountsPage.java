package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.Map;

public interface IYourAccountsPage {

    String getTitle();
    String getDialogTitle();
    String getDescription();

    IYourAccountsPage selectAccountType(String accountType);
    IYourAccountsPage clickCurrentAccount();
    IYourAccountsPage clickSavingsAccount();
    IYourAccountsPage clickAccountScraping();

    IYourAccountsPage clickAddAccount();
    IYourAccountsPage clickAddThisAccount();
    IYourAccountsPage clickNext();
    IYourDependantsPage clickDone();
    IYourAccountsPage clickCancel();
    IYourAccountsPage selectAccount(String account);
    IYourAccountsPage selectAccount(int index);
    IYourAccountsPage deleteAccount(String account);
    IYourAccountsPage deleteAccount(int index);
    IYourAccountsPage deleteAccountConfirm();
    IYourAccountsPage cancelAccountConfirm();
    IYourAccountsPage closeAccountConfirm();
    IYourAccountsPage editAccount(int index);
    Map<Integer, YourAccount> getAccountsOf(String accountType);
    Map<Integer, YourAccount> getAllAccounts();

    IYourAccountsPage typeCurrentStatementDate(String statementDate);
    IYourAccountsPage typeCurrentAccountHolderName(String accountName);
    IYourAccountsPage typeCurrentSortCode1(String sortCode1);
    IYourAccountsPage typeCurrentSortCode2(String sortCode2);
    IYourAccountsPage typeCurrentSortCode3(String sortCode3);
    IYourAccountsPage typeCurrentAccountNumber(String accountNumber);
    IYourAccountsPage typeCurrentAccountProvider(String accountProvider);
    IYourAccountsPage typeCurrentIban(String iban);
    IYourAccountsPage typeCurrentAccountBalance(String accountBalance);
    IYourAccountsPage typeCurrentOverdraftLimit(String overdraftLimit);
    IYourAccountsPage selectCurrentSavingsSource(String savingSource);
    IYourAccountsPage typeCurrentRegularMonthlySavings(String regularMonthlySavings);

    IYourAccountsPage typeSavingsStatementDate(String statementDate);
    IYourAccountsPage typeSavingsAccountHolderName(String accountName);
    IYourAccountsPage typeSavingsSortCode1(String sortCode1);
    IYourAccountsPage typeSavingsSortCode2(String sortCode2);
    IYourAccountsPage typeSavingsSortCode3(String sortCode3);
    IYourAccountsPage typeSavingsAccountNumber(String accountNumber);
    IYourAccountsPage typeSavingsAccountProvider(String accountProvider);
    IYourAccountsPage typeSavingsIban(String iban);
    IYourAccountsPage typeSavingAccountBalance(String accountBalance);
    IYourAccountsPage typeSavingsOverdraftLimit(String savingOverdraftLimit);
    IYourAccountsPage selectSavingsSourceOfSavings(String sourceSaving);
    IYourAccountsPage typeSavingsRegularMonthlySavings(String savingRegularMonthlySavings);

    IYourAccountsPage closeScraping();
}