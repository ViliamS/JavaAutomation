package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

import java.util.Map;

public class YourAccountsPage extends HeaderAndBottomAndFormsMenuSection implements IYourAccountsPage {

    private static final Log log = LogFactory.getLog(YourAccountsPage.class);

    protected IYourAccountsSection yourAccountsSection;
    protected IYourDependantsPage yourDependantsPage;

//    @Inject
    public YourAccountsPage(SharedDriver webDriver) {
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
    public String getDialogTitle() {
        return yourAccountsSection.getDialogTitle();
    }

    @Override
    public String getDescription() {
        return yourAccountsSection.getDescription();
    }

    @Override
    public IYourAccountsPage selectAccountType(String accountType) {
        yourAccountsSection.selectAccountType(accountType);
        return this;
    }

    @Override
    public IYourAccountsPage clickCurrentAccount() {
        yourAccountsSection.clickCurrentAccount();
        return this;
    }

    @Override
    public IYourAccountsPage clickSavingsAccount() {
        yourAccountsSection.clickSavingsAccount();
        return this;
    }

    @Override
    public IYourAccountsPage clickAccountScraping() {
        yourAccountsSection.clickAccountScraping();
        return this;
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
    public IYourDependantsPage clickDone() {
        yourDependantsPage = yourAccountsSection.clickDone();

        try {
            yourDependantsPage.getTitle();
        } catch ( TimeoutException te ) {
            boolean toGoOn = false;
            while ( !toGoOn ) {
                try {
                    yourDependantsPage = yourAccountsSection.clickDone();
                    yourDependantsPage.getTitle();
                    toGoOn = true;
                } catch ( TimeoutException te2) {
                    log.debug("Problem of clicking on Your Account Done or getting the Dependant title.");
                }
            }
        }
        return yourDependantsPage;
    }

    @Override
    public IYourAccountsPage clickCancel() {
        yourAccountsSection.clickCancel();
        return this;
    }

    @Override
    public IYourAccountsPage selectAccount(String account) {
        yourAccountsSection.selectAccount(account);
        return this;
    }

    @Override
    public IYourAccountsPage selectAccount(int index) {
        return this;
    }

    @Override
    public IYourAccountsPage deleteAccount(String account) {
        return this;
    }

    @Override
    public IYourAccountsPage deleteAccount(int index) {
        yourAccountsSection.deleteAccount(index);
        return this;
    }

    @Override
    public IYourAccountsPage deleteAccountConfirm() {
        return this;
    }

    @Override
    public IYourAccountsPage cancelAccountConfirm() {
        return this;
    }

    @Override
    public IYourAccountsPage closeAccountConfirm() {
        return this;
    }

    @Override
    public IYourAccountsPage editAccount(int index) {
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
    public IYourAccountsPage typeAccountProvider(String accountProvider){
        yourAccountsSection.typeAccountProvider(accountProvider);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentStatementDate(String statementDate) {
        yourAccountsSection.typeCurrentStatementDate(statementDate);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentAccountName(String accountName) {
        yourAccountsSection.typeCurrentAccountName(accountName);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentSortCode1(String sortCode1) {
        yourAccountsSection.typeCurrentSortCode1(sortCode1);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentSortCode2(String sortCode2) {
        yourAccountsSection.typeCurrentSortCode2(sortCode2);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentSortCode3(String sortCode3) {
        yourAccountsSection.typeCurrentSortCode3(sortCode3);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentAccountNumber(String accountNumber) {
        yourAccountsSection.typeCurrentAccountNumber(accountNumber);
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
    public IYourAccountsPage selectCurrentSavingSource(String savingSource) {
        yourAccountsSection.selectCurrentSavingSource(savingSource);
        return this;
    }

    @Override
    public IYourAccountsPage typeCurrentRegularMonthlySavings(String regularMonthlySavings) {
        yourAccountsSection.typeCurrentRegularMonthlySavings(regularMonthlySavings);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingsStatementDate(String statementDate) {
        yourAccountsSection.typeSavingStatementDate(statementDate);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingsAccountName(String accountName) {
        yourAccountsSection.typeSavingsAccountName(accountName);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingsSortCode1(String sortCode1) {
        yourAccountsSection.typeSavingsSortCode1(sortCode1);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingsSortCode2(String sortCode2) {
        yourAccountsSection.typeSavingsSortCode2(sortCode2);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingsSortCode3(String sortCode3) {
        yourAccountsSection.typeSavingsSortCode3(sortCode3);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingsAccountNumber(String accountNumber) {
        yourAccountsSection.typeSavingsAccountNumber(accountNumber);
        return this;
    }

    @Override
    public IYourAccountsPage typeSavingsAccountProvider(String accountProvider) {
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
    public IYourAccountsPage typeSavingOverdraftLimit(String savingOverdrafLimit) {
        yourAccountsSection.typeSavingOverdraftLimit(savingOverdrafLimit);
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
    public IYourAccountsPage closeScraping() {
        yourAccountsSection.closeScraping();
        return this;
    }

}
