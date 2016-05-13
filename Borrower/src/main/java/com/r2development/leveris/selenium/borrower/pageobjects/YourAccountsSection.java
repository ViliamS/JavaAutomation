package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class YourAccountsSection extends HeaderAndBottomAndFormsMenuSection implements IYourAccountsSection {

    private static final Log log = LogFactory.getLog(YourAccountsSection.class);

    WebDriver webDriver;

    public YourAccountsSection(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = new HeaderSection(webDriver);
        bottomSection = new BottomSection(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_TITLE_XPATH, 0);
        return getText(YOUR_ACCOUNTS_TITLE_XPATH);
    }

    @Override
    public String getDialogTitle() {
        loadingCheck();
        return getText(YOUR_ACCOUNTS_DIALOG_XPATH);
    }

    @Override
    public String getDescription() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_DESCRIPTION_XPATH, 0);
        return getText(YOUR_ACCOUNTS_DESCRIPTION_XPATH);
    }

    @Override
    public IYourAccountsSection selectAccountType(String accountType) {
        loadingCheck();
        switch (accountType) {
            case "Current":
                clickCurrentAccount();
                break;

            case "Savings":
                clickSavingsAccount();
                break;

//            case "Account scraping":
//                clickAccountScraping();
//                break;
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection clickCurrentAccount() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH, true);
        clickElement(YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH, YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection clickSavingsAccount() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH, true);
        clickElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH, YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsAccountScrapingWindow clickAccountScraping() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH, true);
        clickElement(YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH, IYourAccountsAccountScrapingWindow.I_AGREE_CHECKBOX);
        loadingCheck();
        return new YourAccountsAccountScrapingWindow((SharedDriver) webDriver);
    }

    @Override
    public IYourAccountsSection clickAddAccount() {
        loadingCheck();

        log.info("IYourAccountsSection.YOUR_ACCOUNTS_SAVING_OR_CURRENT_OR_SCRAPING --> shouldn't be visible to proceed to add click");
        if (!isVisible(YOUR_ACCOUNTS_SAVING_OR_CURRENT_OR_SCRAPING, 3)) {     /** If is visible Current Account or Savings Account or Account Scraping link then is none-sense to click on any Add button... */

            log.info("IYourAccountsSection.ACCOUNTS_ADD_ACCOUNT_XPATH --> have to be visible to proceed clicking onto it");
            if (isVisible(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH, 0)) {             /** If Add button is visible then we want only to click on it */

                log.info("\n Clicking ----> IYourAccountsSection.clickAddAccount() -- > clickAndWait for ---> IYourAccountsSections.YOUR_ACCOUNTS_SAVING_OR_CURRENT_OR_SCRAPING");
                clickElement(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH, YOUR_ACCOUNTS_SAVING_OR_CURRENT_OR_SCRAPING);
                loadingCheck();

            } else {
                log.info("IYourAccountsSection.ACCOUNTS_ADD_ACCOUNT_XPATH --> was not visible add button click was skipped");
            }

        } else {
            log.info("IYourAccountsSection.YOUR_ACCOUNTS_SAVING_OR_CURRENT_OR_SCRAPING --> was visible add button click was skipped");
        }
        return this;
    }

    private Map<String, String> formExceptionDetails() {
        Map<String, String> formExceptionDetails = new LinkedHashMap<>();
        formExceptionDetails.put(
                "FormName",
                "\n Add this account button is still present! \n" +
                        " Extracting exception text from the form \n"
        );

        formExceptionDetails.put(
                "GetExceptionResult1",
                "\n --------------------------------------------------------------\n" +
                        " | Not being able to save the form @!wtf!@                         | \n" +
                        " | it is due to : '"
        );

        formExceptionDetails.put(
                "GetExceptionResult2",
                "' is displayed on page | \n" +
                        " -------------------------------------------------------------- \n"
        );

        formExceptionDetails.put(
                "FormAction",
                "Failed clickAddThisAccount"
        );
        return formExceptionDetails;
    }

    @Override
    public IYourAccountsSection clickAddThisAccount() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH, 0);
        clickElement(YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH);
        loadingCheck();
        formSubmitPostSync(YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH, formExceptionDetails());
        return this;
    }

    @Override
    public IYourAccountsSection iAgreeCheckbox(String action) {
        loadingCheck();
        checkBox(IYourAccountsAccountScrapingWindow.I_AGREE_CHECKBOX, action);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsAccountScrapingWindow clickStartScraping() {
        loadingCheck();
        isVisible(IYourAccountsAccountScrapingWindow.START_SCRAPING_BUTTON, true);
        clickElement(IYourAccountsAccountScrapingWindow.START_SCRAPING_BUTTON);
        return new YourAccountsAccountScrapingWindow((SharedDriver) webDriver);
    }

    @Override
    public IYourAccountsSection clickNext() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_NEXT_XPATH, 0);
        clickElement(YOUR_ACCOUNTS_NEXT_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourDependantsPage clickDone() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_DONE_XPATH, true);
        clickElementLoop(YOUR_ACCOUNTS_DONE_XPATH, IYourDependantsSection.YOUR_DEPENDANTS_NONE_XPATH);
        loadingCheck();
        return new YourDependantsPage((SharedDriver) webDriver);
    }

    @Override
    public IYourAccountsSection clickCancel() {
        loadingCheck();
        clickElement(YOUR_ACCOUNTS_CANCEL_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection selectAccount(String account) {
        return null;
    }

    @Override
    public IYourAccountsSection selectAccount(int index) {
        return null;
    }

    @Override
    public IYourAccountsSection deleteAccount(String account) {
        return null;
    }

    @Override
    public IYourAccountsSection deleteAccount(int index) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH, 0);
        clickElement(YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection deleteAccountConfirm() {
        return null;
    }

    @Override
    public IYourAccountsSection cancelAccountConfirm() {
        return null;
    }

    @Override
    public IYourAccountsSection closeAccountConfirm() {
        return null;
    }

    @Override
    public IYourAccountsSection editAccount(int index) {
        return null;
    }

    @Override
    public Map<Integer, YourAccount> getAccountsOf(String accountType) {
        isVisible(YOUR_ACCOUNTS_REPORTS_XPATH, true);
//        Map<Integer, YourAccount> toReturn = null;
//        return
        return null;
    }

    @Override
    public Map<Integer, YourAccount> getAllAccounts() {
        isVisible(YOUR_ACCOUNTS_REPORTS_XPATH, true);
//        Map<Integer, YourAccount> toReturn = null;
//        return toReturn;
        return null;
    }

    @Override
    public IYourAccountsSection typeAccountName(String accountName){
        log.info("");
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_ACCOUNT_NAME, true);
        typeEndWithTab(YOUR_ACCOUNTS_ACCOUNT_NAME, accountName, true);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentStatementDate(String statementDate) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH, 10);
        clickElement(YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH);
        typeEndWithTab(YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH, statementDate, true);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountHolderName(String accountHolderName) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_HOLDER_NAME_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_HOLDER_NAME_INPUT_XPATH, accountHolderName);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentSortCode1(String sortCode1) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH, sortCode1);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentSortCode2(String sortCode2) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH, sortCode2);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentSortCode3(String sortCode3) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH, sortCode3);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountNumber(String accountNumber) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH, accountNumber);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountProvider(String accountProvider) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH, accountProvider);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentIban(String iban) {
//        loadingCheck();
//        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_INPUT_XPATH, 0);
//        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_INPUT_XPATH, iban);
//        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountBalance(String accountBalance) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH, accountBalance);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentOverdraftLimit(String overdraftLimit) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_INPUT_XPATH, overdraftLimit);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection selectCurrentSavingsSource(String savingSource) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_SELECT_XPATH, 0);
        selectFromDropDown(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_SELECT_XPATH, savingSource, scrollHorizontal, scrollVertical);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentRegularMonthlySavings(String regularMonthlySavings) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, regularMonthlySavings);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsStatementDate(String statementDate) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH, 10);
        type(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH, statementDate);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsAccountHolderName(String accountHolderName) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_HOLDER_NAME_INPUT_XPATH, 0);
        clickElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_HOLDER_NAME_INPUT_XPATH);
        type(YOUR_ACCOUNTS_SAVING_ACCOUNT_HOLDER_NAME_INPUT_XPATH, accountHolderName);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsSortCode1(String sortCode1) {
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH, sortCode1, 60);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsSortCode2(String sortCode2) {
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH, sortCode2, 60);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsSortCode3(String sortCode3) {
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH, sortCode3, 60);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsAccountNumber(String accountNumber) {
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH, accountNumber, 60);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsAccountProvider(String accountProvider) {
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH, accountProvider, 60);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsIban(String iban) {
//        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH, iban, 60);
//        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsAccountBalance(String accountBalance) {
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH, accountBalance, 60);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection selectSavingsSourceOfSavings(String sourceSaving) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_SELECT_XPATH, 0);
        selectFromDropDown(YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_SELECT_XPATH, sourceSaving, scrollHorizontal, scrollVertical);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsRegularMonthlySavings(String savingRegularMonthlySavings) {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, 0);
        type(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, savingRegularMonthlySavings);
        loadingCheck();
        return this;
    }

    @Override
    public IYourAccountsSection closeScraping() {
        loadingCheck();
        isVisible(YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH, 0);
        clickElement(YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH);
        loadingCheck();
        return this;
    }
}