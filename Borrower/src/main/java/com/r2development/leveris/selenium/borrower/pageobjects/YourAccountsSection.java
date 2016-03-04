package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class YourAccountsSection extends HeaderAndBottomAndFormsMenuSection implements IYourAccountsSection {

    private static final Log log = LogFactory.getLog(YourAccountsSection.class);

//    @Inject
    public YourAccountsSection(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        bottomSection = new BottomSection(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy ( xpath = YOUR_ACCOUNTS_TITLE_XPATH )
    WebElement weAccountsTitle;
    @FindBy ( xpath = YOUR_ACCOUNTS_DIALOG_XPATH )
    WebElement weAccountsDialogTitle;
    @FindBy ( xpath = YOUR_ACCOUNTS_DESCRIPTION_XPATH )
    WebElement weAccountsDescription;

    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH )
    WebElement weAccountsCurrentAccount;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH )
    WebElement weAccountsSavingAccount;
    @FindBy ( xpath = YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH )
    WebElement weAccountsAccountScraping;

    @FindBy ( xpath = YOUR_ACCOUNTS_REPORTS_XPATH )
    WebElement weAccountsReports;
    @FindBy ( xpath = YOUR_ACCOUNTS_ACCOUNT_TYPE_XPATH )
    WebElement weAccountsAccountType;     // to get text
    @FindBy ( xpath = YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH )
    WebElement weAccountsAccountDelete;   // to delete
    @FindBy ( xpath = YOUR_ACCOUNTS_ACCOUNT_LABEL_AMOUNT_XPATH )
    WebElement weAccountsAccountLabelAmount;            // to get text
    @FindBy ( xpath = YOUR_ACCOUNTS_ACCOUNT_OWNER_XPATH )
    WebElement weAccountsAccountOwner;              // to get
    @FindBy ( xpath = YOUR_ACCOUNTS_ACCOUNT_AMOUNT_XPATH )
    WebElement weAccountsAccountAmount;
    @FindBy ( xpath = YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH )
    WebElement weAccountsAddAccount;
    @FindBy ( xpath = YOUR_ACCOUNTS_NEXT_XPATH )
    WebElement weAccountsNext;
    @FindBy ( xpath = YOUR_ACCOUNTS_CANCEL_XPATH )
    WebElement weAccountsCancel;
    @FindBy ( xpath = YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH )
    WebElement weAccountsAddThisAccount;


    // Current Account
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_LABEL_XPATH )
    WebElement weAccountsCurrentStatementDateLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH )
    WebElement weAccountsCurrentStatementDateInput;

//    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NAME_LABEL_XPATH = "main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccName_label";
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_NAME_INPUT_XPATH )
    WebElement weAccountsCurrentAccountName;
//    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_LABEL_XPATH = "main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtSortCode1_label";
    @FindBy ( xpath =  YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH )
    WebElement weAccountsCurrentSortCode1;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH )
    WebElement weAccountsCurrentSortCode2;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH )
    WebElement weAccountsCurrentSortCode3;
//    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_LABEL_XPATH = "main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccnumber_label";
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH )
    WebElement weAccountsCurrentAccountNumber;

    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_LABEL_XPATH )
    WebElement weAccountsCurrentProviderLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH )
    WebElement weAccountsCurrentProviderInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_LABEL_XPATH )
    WebElement weAccountsCurrentIbanLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_INPUT_XPATH )
    WebElement weAccountsCurrentIbanInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_LABEL_XPATH )
    WebElement weAccountsCurrentAccountBalanceLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH )
    WebElement weAccountsCurrentAccountBalanceInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_LABEL_XPATH )
    WebElement weAccountsCurrentAccountOverdraftLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_INPUT_XPATH )
    WebElement weAccountsCurrentAccountOverdraftInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_LABEL_XPATH )
    WebElement weAccountsCurrentAccountSavingSourceLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_INPUT_XPATH )
    WebElement weAccountsCurrentAccountSavingSourceIntput;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_LABEL_XPATH )
    WebElement weAccountsCurrentRegularMonthlySavingsLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH )
    WebElement weAccountsCurrentRegularMonthlySavingsInput;

    // Savings Account
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_LABEL_XPATH )
    WebElement weAccountsSavingStatementDateLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH )
    WebElement weAccountsSavingStatementDateInput;

    //    String YOUR_ACCOUNTS_SAVING_ACCOUNT_NAME_LABEL_XPATH = "main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccName_label";
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_NAME_INPUT_XPATH )
    WebElement weAccountsSavingAccountName;
    //    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_LABEL_XPATH = "main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtSortCode1_label";
    @FindBy ( xpath =  YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH )
    WebElement weAccountsSavingSortCode1;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH )
    WebElement weAccountsSavingSortCode2;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH )
    WebElement weAccountsSavingSortCode3;
    //    String YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_LABEL_XPATH = "main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccnumber_label";
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH )
    WebElement weAccountsSavingAccountNumber;

    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_LABEL_XPATH )
    WebElement weAccountsSavingProviderLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH )
    WebElement weAccountsSavingProviderInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_LABEL_XPATH )
    WebElement weAccountsSavingIbanLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH )
    WebElement weAccountsSavingIbanInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_LABEL_XPATH )
    WebElement weAccountsSavingAccountBalanceLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH )
    WebElement weAccountsSavingAccountBalanceInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_LABEL_XPATH )
    WebElement weAccountsSavingAccountOverdraftLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_INPUT_XPATH )
    WebElement weAccountsSavingAccountOverdraftInput;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_LABEL_XPATH )
    WebElement weAccountsSavingAccountSavingSourceLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_INPUT_XPATH )
    WebElement weAccountsSavingAccountSavingSourceIntput;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_LABEL_XPATH )
    WebElement weAccountsSavingRegularMonthlySavingsLabel;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH )
    WebElement weAccountsSavingRegularMonthlySavingsInput;

    // Account Scraping
    @FindBy ( xpath = YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH )
    WebElement weAccountScrapingClose;




    @Override
    public String getTitle() {
        isVisible(YOUR_ACCOUNTS_TITLE_XPATH, true, 10);
        return weAccountsTitle.getText();
    }

    @Override
    public String getDialogTitle() {
        return weAccountsTitle.getText();
    }

    @Override
    public String getDescription() {
        isVisible(YOUR_ACCOUNTS_DESCRIPTION_XPATH, true);
        return weAccountsDescription.getText();
    }

    @Override
    public IYourAccountsSection clickCurrentAccount() {
        try {
            isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH, true);
            clickElementViaJavascript(YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH);
        } catch ( Exception e ) {
            isVisible(YOUR_ACCOUNTS_ACCOUNT_MAIN_DIALOG_XPATH);
            isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_DIALOG_XPATH, true);
            clickElementViaJavascript(YOUR_ACCOUNTS_CURRENT_ACCOUNT_DIALOG_XPATH);
        }
        return this;
    }

    @Override
    public IYourAccountsSection clickSavingsAccount() {
        try {
            isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH, true);
            clickElementViaJavascript(YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH);
        } catch ( Exception e ) {
            isVisible(YOUR_ACCOUNTS_ACCOUNT_MAIN_DIALOG_XPATH);
            isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_DIALOG_XPATH);
            clickElementViaJavascript(YOUR_ACCOUNTS_SAVING_ACCOUNT_DIALOG_XPATH);
        }
        return this;
    }

    @Override
    public IYourAccountsSection clickAccountScraping() {
        try {
            isVisible(YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH, true);
            clickElementViaJavascript(YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH);
            isVisible(YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH, true);
        } catch ( Exception e ) {
            isVisible(YOUR_ACCOUNTS_ACCOUNT_MAIN_DIALOG_XPATH);
            clickElementViaJavascript(YOUR_ACCOUNTS_ACCOUNT_SCRAPING_DIALOG_XPATH);
            isVisible(YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH, true);
        }
        return this;
    }

    @Override
    public IYourAccountsSection clickAddAccount() {
        isVisible(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH, true, 15);
        clickElement(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH);

        try {
            isVisible(YOUR_ACCOUNTS_ACCOUNT_MAIN_DIALOG_XPATH, true, 60);
        } catch ( TimeoutException ioe) {
            boolean toGoOn = false;
            while ( !toGoOn ) {
                try {
                    clickElement(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH);
                    isVisible(YOUR_ACCOUNTS_ACCOUNT_MAIN_DIALOG_XPATH, false, 5);
                    toGoOn = true;
                } catch (TimeoutException te) {
                    log.debug("Issues of getting YourAccount page.");
                }
            }
        }

        return this;
    }

    @Override
    public IYourAccountsSection clickAddThisAccount() {
        isVisible(YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH, true);
        weAccountsAddThisAccount.click();
        return this;
    }

    @Override
    public IYourAccountsSection clickNext() {
        isVisible(YOUR_ACCOUNTS_NEXT_XPATH, true);
        clickElement(YOUR_ACCOUNTS_NEXT_XPATH);
//        weAccountsNext.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourDependantsPage clickDone() {
        isVisible(YOUR_ACCOUNTS_DONE_XPATH, true);
        clickElement(YOUR_ACCOUNTS_DONE_XPATH);
//        weAccountsNext.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return new YourDependantsPage(webDriver);
    }

    @Override
    public IYourAccountsSection clickCancel() {
//        isVisible(YOUR_ACCOUNTS_CANCEL_XPATH, true);
        clickElement(YOUR_ACCOUNTS_CANCEL_XPATH);
//        weAccountsCancel.click();
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
        isVisible(YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH, true);
        weAccountsAccountDelete.click();
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
    public IYourAccountsSection typeCurrentStatementDate(String statementDate) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH).sendKeys(statementDate);
        weAccountsCurrentStatementDateInput.clear();
        weAccountsCurrentStatementDateInput.sendKeys(statementDate);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountName(String accountName) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH, true);
        weAccountsCurrentAccountName.clear();
        weAccountsCurrentAccountName.sendKeys(accountName);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentSortCode1(String sortCode1) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH, true);
        weAccountsCurrentSortCode1.clear();
        weAccountsCurrentSortCode1.sendKeys(sortCode1);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentSortCode2(String sortCode2) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH, true);
        weAccountsCurrentSortCode2.clear();
        weAccountsCurrentSortCode2.sendKeys(sortCode2);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentSortCode3(String sortCode3) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH, true);
        weAccountsCurrentSortCode3.clear();
        weAccountsCurrentSortCode3.sendKeys(sortCode3);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountNumber(String accountNumber) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH, true);
        weAccountsCurrentAccountNumber.clear();
        weAccountsCurrentAccountNumber.sendKeys(accountNumber);
        return this;
    }

    @Deprecated @Override
    public IYourAccountsSection typeCurrentAccountProvider(String accountProvider) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH, true);
        weAccountsCurrentProviderInput.clear();
        weAccountsCurrentProviderInput.sendKeys(accountProvider);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentIban(String iban) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_INPUT_XPATH, true);
        weAccountsCurrentIbanInput.clear();
        weAccountsCurrentIbanInput.sendKeys(iban);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountBalance(String accountBalance) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH, true);
        weAccountsCurrentAccountBalanceInput.clear();
        weAccountsCurrentAccountBalanceInput.sendKeys(accountBalance);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentOverdraftLimit(String overdraftLimit) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_INPUT_XPATH, true);
        weAccountsCurrentAccountOverdraftInput.clear();
        weAccountsCurrentAccountOverdraftInput.sendKeys(overdraftLimit);
        return this;
    }

    @Override
    public IYourAccountsSection selectCurrentSavingSource(String savingSource) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_INPUT_XPATH, true);
        selectFromDropDown(YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_INPUT_XPATH, savingSource);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentRegularMonthlySavings(String regularMonthlySavings) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, true);
        weAccountsCurrentRegularMonthlySavingsInput.clear();
        weAccountsCurrentRegularMonthlySavingsInput.sendKeys(regularMonthlySavings);
        return this;
    }


    @Override
    public IYourAccountsSection typeSavingStatementDate(String statementDate) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH).sendKeys(statementDate);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH, statementDate, 30);
//        weAccountsSavingStatementDateInput.clear();
//        weAccountsSavingStatementDateInput.sendKeys(statementDate);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsAccountName(String accountName) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_NAME_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_NAME_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_NAME_INPUT_XPATH).sendKeys(accountName);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_NAME_INPUT_XPATH, accountName, 60);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsSortCode1(String sortCode1) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH).sendKeys(sortCode1);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH, sortCode1, 60);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsSortCode2(String sortCode2) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH).sendKeys(sortCode2);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH, sortCode2, 60);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsSortCode3(String sortCode3) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH).sendKeys(sortCode3);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH, sortCode3, 60);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingsAccountNumber(String accountNumber) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH).sendKeys(accountNumber);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH, accountNumber, 60);
        return this;
    }

    @Deprecated @Override
    public IYourAccountsSection typeSavingAccountProvider(String accountProvider) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH).sendKeys(accountProvider);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH, accountProvider, 60);
//        weAccountsSavingProviderInput.clear();
//        weAccountsSavingProviderInput.sendKeys(accountProvider);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingIban(String iban) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH).sendKeys(iban);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH, iban, 60);
//        weAccountsSavingIbanInput.clear();
//        weAccountsSavingIbanInput.sendKeys(iban);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingAccountBalance(String accountBalance) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH).sendKeys(accountBalance);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH, accountBalance, 60);
//        weAccountsSavingAccountBalanceInput.clear();
//        weAccountsSavingAccountBalanceInput.sendKeys(accountBalance);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingOverdraftLimit(String savingOverdraftLimit) {
        // TODO to check it ... synchronization
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_INPUT_XPATH,true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_INPUT_XPATH).sendKeys(savingOverdraftLimit);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_INPUT_XPATH, savingOverdraftLimit, 60);
//        weAccountsSavingAccountOverdraftInput.clear();
//        weAccountsSavingAccountOverdraftInput.sendKeys(savingOverdraftLimit);
        return this;
    }

    @Override
    public IYourAccountsSection selectSavingSourceSavings(String sourceSaving) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_LABEL_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_INPUT_XPATH).isDisplayed();
        selectFromDropDown(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, sourceSaving);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingRegularMonthlySavings(String savingRegularMonthlySavings) {
//        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, true);
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH).clear();
//        getWebElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH).sendKeys(savingRegularMonthlySavings);
        sendKeysElement(YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH, savingRegularMonthlySavings, 60);
//        weAccountsSavingRegularMonthlySavingsInput.clear();
//        weAccountsSavingRegularMonthlySavingsInput.sendKeys(savingRegularMonthlySavings);
        return this;
    }


    @Override
    public IYourAccountsSection closeScraping() {
        isVisible(YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH, true);
        weAccountScrapingClose.click();
        return this;
    }

}
