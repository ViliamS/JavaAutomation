package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class YourAccountsPage extends HeaderAndBottomAndFormsMenuSection implements IYourAccountsPage {

    private static final Log log = LogFactory.getLog(YourAccountsPage.class);

    protected IYourAccountsSection yourAccountsSection;

    @Inject
    public YourAccountsPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourAccountsSection = new YourAccountsSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return yourAccountsSection.getTitle();
    }

    @Override
    public String getDescription() {
        return yourAccountsSection.getDescription();
    }

    @Override
    public IYourAccountsPage clickAddAccount() {
        yourAccountsSection.clickAddAccount();
        return this;
    }

    @Override
    public IYourAccountsPage clickAddThisAccount() {
        yourAccountsSection.clickAddThisAccount();
        return this;
    }

    @Override
    public IYourAccountsPage clickNext() {
        yourAccountsSection.clickNext();
        return this;
    }

    @Override
    public IYourAccountsPage clickCancel() {
        yourAccountsSection.clickCancel();
        return this;
    }

    @Override
    public IYourAccountsPage clickAddAccountManually() {
        yourAccountsSection.clickAddAccountManually();
        return this;
    }

    @Override
    public IYourAccountsPage selectAccount(String account) {
        yourAccountsSection.selectAccount(account);
        return this;
    }

    @Override
    public IYourAccountsPage selectSourceOfFunds(String sourceOfFund) {
        yourAccountsSection.selectSourceOfFunds(sourceOfFund);
        return this;
    }

    @Override
    public IYourAccountsPage checkAccountAppliesToBorrower(String borrower) {
        yourAccountsSection.checkAccountAppliesToBorrower(borrower);
        return this;
    }

    @Override
    public IYourAccountsPage checkAccountAppliesToCoapplicant(String coapplicant) {
        yourAccountsSection.checkAccountAppliesToCoapplicant(coapplicant);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentAccountProvider(String accountProvider) {
        yourAccountsSection.typeCurrentAccountProvider(accountProvider);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentIban(String iban) {
        yourAccountsSection.typeCurrentIban(iban);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentAccountBalance(String accountBalance) {
        yourAccountsSection.typeCurrentAccountBalance(accountBalance);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentOverdraftLimit(String overdraftLimit) {
        yourAccountsSection.typeCurrentOverdraftLimit(overdraftLimit);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingAccountProvider(String accountProvider) {
        yourAccountsSection.typeSavingAccountProvider(accountProvider);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingIban(String iban) {
        yourAccountsSection.typeSavingIban(iban);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingAccountBalance(String accountBalance) {
        yourAccountsSection.typeSavingAccountBalance(accountBalance);
        return this;
    }

    @Override
    public IYourAccountsPage selectSavingSourceSavings(String sourceSaving) {
        yourAccountsSection.selectSavingSourceSavings(sourceSaving);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingRegularMonthlySavings(String savingRegularMonthlySavings) {
        yourAccountsSection.typeSavingRegularMonthlySavings(savingRegularMonthlySavings);
        return this;
    }

    @Override
    public IYourAccountsPage deleteAccount(int index) {
        yourAccountsSection.deleteAccount(index);
        return this;
    }

    @Override
    public Map<Integer, YourAccount> getAccountsOf(String accountType) {
        return yourAccountsSection.getAccountsOf(accountType);
    }

    @Override
    public Map<Integer, YourAccount> getAllAccounts() {
        return yourAccountsSection.getAllAccounts();
    }

    @Override
    public String getFundType(int index) {
        return yourAccountsSection.getFundType(index);
    }

    @Override
    public String getFundName(int index) {
        return yourAccountsSection.getFundType(index);
    }

    @Override
    public String computeFundSum(int index) {
        return yourAccountsSection.computeFundSum(index);
    }

    @Override
    public String getFundSubtotalAmount() {
        return yourAccountsSection.getFundSubtotalAmount();
    }

    @Override
    public IYourAccountsPage clickFundPanel(int index) {
        yourAccountsSection.clickFundPanel(index);
        return this;
    }

    @Override
    public IYourAccountsPage validateAccounts() {
        yourAccountsSection.validateAccounts();
        return this;
    }



}
