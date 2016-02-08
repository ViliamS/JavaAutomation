package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.Map;

public interface IYourAccountsPage {

    String getTitle();
    String getDescription();

    IYourAccountsPage clickAddAccount();
    IYourAccountsPage clickAddThisAccount();
    IYourAccountsPage clickNext();
    IYourAccountsPage clickCancel();
    IYourAccountsPage clickAddAccountManually();
    IYourAccountsPage selectAccount(String account);

    IYourAccountsPage selectSourceOfFunds(String sourceOfFund);
    IYourAccountsPage checkAccountAppliesToBorrower(String borrower);
    IYourAccountsPage checkAccountAppliesToCoapplicant(String coapplicant);

    IYourAccountsPage typeCurrentAccountProvider(String accountProvider);
    IYourAccountsPage typeCurrentIban(String iban);
    IYourAccountsPage typeCurrentAccountBalance(String accountBalance);
    IYourAccountsPage typeCurrentOverdraftLimit(String overdraftLimit);

    IYourAccountsPage typeSavingAccountProvider(String accountProvider);
    IYourAccountsPage typeSavingIban(String iban);
    IYourAccountsPage typeSavingAccountBalance(String accountBalance);
    IYourAccountsPage selectSavingSourceSavings(String sourceSaving);
    IYourAccountsPage typeSavingRegularMonthlySavings(String savingRegularMonthlySavings);

    IYourAccountsPage deleteAccount(int index);
    Map<Integer, YourAccount> getAccountsOf(String accountType);
    Map<Integer, YourAccount> getAllAccounts();
    String getFundType(int index);
    String getFundName(int index);
    String computeFundSum(int index);
    String getFundSubtotalAmount();
    IYourAccountsPage clickFundPanel(int index);

    IYourAccountsPage validateAccounts();

}
