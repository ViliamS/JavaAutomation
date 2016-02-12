package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class YourAccountsSection extends HeaderAndBottomAndFormsMenuSection implements IYourAccountsSection {

    private static final Log log = LogFactory.getLog(YourAccountsSection.class);

    @Inject
    public YourAccountsSection(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        bottomSection = new BottomSection(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy ( xpath = YOUR_ACCOUNTS_TITLE_XPATH )
    WebElement weAccountsTitle;
    @FindBy ( xpath = YOUR_ACCOUNTS_DESCRIPTION_XPATH )
    WebElement weAccountsDescription;

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

    @FindBy ( xpath = YOUR_ACCOUNTS_LABEL_TOTAL_XPATH )
    WebElement weAccountsLabelTotal;
    @FindBy ( xpath = YOUR_ACCOUNTS_TOTAL_VALUE_XPATH )
    WebElement weAccountsTotalValue;

    @FindBy ( xpath = YOUR_ACCOUNTS_WHICH_FUNDS_XPATH )
    // Current Account, Savings Account
    WebElement weAccountsWhichFunds;
    @FindBy ( xpath = YOUR_ACCOUNTS_APPLIES_TO_BORROWER_XPATH )
    WebElement weAccountAppliesToBorrower;
    @FindBy ( xpath = YOUR_ACCOUNTS_APPLIES_TO_COAPPLICANT_XPATH )
    WebElement weAccountAppliesToCoapplicant;

    // Current Account
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_XPATH )
    WebElement weAccountsCurrentAccountProvider;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_4LAST_NUMBER_XPATH )
    WebElement weAccountsCurrentAccount4LastNumber;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_XPATH )
    WebElement weAccountsCurrentAccountBalance;
    @FindBy ( xpath = YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_XPATH )
    WebElement weAccountsCurrentAccountOverdraft;

    // Savings Account
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_XPATH )
    WebElement weAccountsSavingAccountProvider;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_4LAST_NUMBER_XPATH )
    WebElement weAccountsSavingAccount4LastNumber;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_XPATH )
    WebElement weAccountsSavingAccountBalance;
    // Gift, Inheritance, Accident Claim, Redundancy, Income from Regular Savings, Other
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_SOURCE_XPATH )
    WebElement weAccountsSavingSource;
    @FindBy ( xpath = YOUR_ACCOUNTS_SAVING_MONTHLY_SAVING_XPATH )
    WebElement weAccountsSavingMonthlySaving;

    @FindBy ( xpath = YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH )
    WebElement weAccountsAddAccount;
    @FindBy ( xpath = YOUR_ACCOUNTS_NEXT_XPATH )
    WebElement weAccountsNext;
    @FindBy ( xpath = YOUR_ACCOUNTS_CANCEL_XPATH )
    WebElement weAccountsCancel;
    @FindBy ( xpath = YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH )
    WebElement weAccountsAddThisAccount;
    @FindBy ( xpath = YOUR_ACCOUNTS_POPUP_ADD_ACCOUNT_MANUALLY_XPATH )
    WebElement weAccountsPopupAddAccountManually;
    @FindBy ( xpath = YOUR_ACCOUNTS_POPUP_SELECT_ACCOUNT_XPATH )
    WebElement weAccountsPopupSelectAccount;

    @Override
    public String getTitle() {
        isVisible(YOUR_ACCOUNTS_TITLE_XPATH, true, 10);
        return weAccountsTitle.getText();
    }

    @Override
    public String getDescription() {
        isVisible(YOUR_ACCOUNTS_DESCRIPTION_XPATH, true);
        return weAccountsDescription.getText();
    }

    @Override
    public IYourAccountsSection clickAddAccount() {
        try {
            isVisible(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH, true, 15);
            clickElement(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH);
            isVisible("//div[@wicketpath='main_c_form_dialogWrapper_dialog']", true, 15);
        } catch ( TimeoutException te ) {
            clickElement(YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH);
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
    public IYourAccountsSection clickCancel() {
//        isVisible(YOUR_ACCOUNTS_CANCEL_XPATH, true);
        clickElement(YOUR_ACCOUNTS_CANCEL_XPATH);
//        weAccountsCancel.click();
        return this;
    }

    @Override
    public IYourAccountsSection clickAddAccountManually() {
//        isVisible(YOUR_ACCOUNTS_POPUP_ADD_ACCOUNT_MANUALLY_XPATH, true, 10);
        clickElement(YOUR_ACCOUNTS_POPUP_ADD_ACCOUNT_MANUALLY_XPATH);
//        weAccountsPopupAddAccountManually.click();
//        isNotVisible("//div[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMain']", true, 10);
        isNotVisible("//div[@wicketpath='main_c_form_dialogWrapper_dialog']", true, 15);
        return this;
    }

    @Override
    public IYourAccountsSection checkAccountAppliesToBorrower(String borrower) {
        isVisible(YOUR_ACCOUNTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower));
        getWebElement(YOUR_ACCOUNTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower)).click();
        return this;
    }

    @Override
    public IYourAccountsSection checkAccountAppliesToCoapplicant(String coapplicant) {
        isVisible(YOUR_ACCOUNTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant));
        getWebElement(YOUR_ACCOUNTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant)).click();
        return this;
    }

    @Override
    public IYourAccountsSection selectAccount(String account) {
        isVisible(YOUR_ACCOUNTS_POPUP_SELECT_ACCOUNT_XPATH, true);
        selectFromDropDown(YOUR_ACCOUNTS_POPUP_SELECT_ACCOUNT_XPATH, account);
        return this;
    }

    @Override
    public IYourAccountsSection selectSourceOfFunds(String sourceOfFund) {
//        isVisible("//div[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMain']", true, 10);
//        isVisible(YOUR_ACCOUNTS_WHICH_FUNDS_XPATH, true, 10);
        selectFromDropDown(YOUR_ACCOUNTS_WHICH_FUNDS_XPATH, sourceOfFund);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountProvider(String accountProvider) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_XPATH, true);
        weAccountsCurrentAccountProvider.clear();
        weAccountsCurrentAccountProvider.sendKeys(accountProvider);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentIban(String iban) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_4LAST_NUMBER_XPATH, true);
        weAccountsCurrentAccount4LastNumber.clear();
        weAccountsCurrentAccount4LastNumber.sendKeys(iban);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentAccountBalance(String accountBalance) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_XPATH, true);
        weAccountsCurrentAccountBalance.clear();
        weAccountsCurrentAccountBalance.sendKeys(accountBalance);
        return this;
    }

    @Override
    public IYourAccountsSection typeCurrentOverdraftLimit(String overdraftLimit) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_XPATH, true);
        weAccountsCurrentAccountOverdraft.clear();
        weAccountsCurrentAccountOverdraft.sendKeys(overdraftLimit);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingAccountProvider(String accountProvider) {
        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_XPATH, true);
        weAccountsSavingAccountProvider.clear();
        weAccountsSavingAccountProvider.sendKeys(accountProvider);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingIban(String iban) {
        isVisible(YOUR_ACCOUNTS_CURRENT_ACCOUNT_4LAST_NUMBER_XPATH, true);
        weAccountsSavingAccount4LastNumber.clear();
        weAccountsSavingAccount4LastNumber.sendKeys(iban);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingAccountBalance(String accountBalance) {
        isVisible(YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_XPATH, true);
        weAccountsSavingAccountBalance.clear();
        weAccountsSavingAccountBalance.sendKeys(accountBalance);
        return this;
    }

    @Override
    public IYourAccountsSection selectSavingSourceSavings(String sourceSaving) {
        isVisible(YOUR_ACCOUNTS_SAVING_SOURCE_XPATH, true);
        selectFromDropDown(YOUR_ACCOUNTS_SAVING_SOURCE_XPATH, sourceSaving);
        return this;
    }

    @Override
    public IYourAccountsSection typeSavingRegularMonthlySavings(String savingRegularMonthlySavings) {
        isVisible(YOUR_ACCOUNTS_SAVING_MONTHLY_SAVING_XPATH, true);
        weAccountsSavingMonthlySaving.clear();
        weAccountsSavingMonthlySaving.sendKeys(savingRegularMonthlySavings);
        return null;
    }

    @Override
    public IYourAccountsSection deleteAccount(int index) {
        isVisible(YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH, true);
        weAccountsAccountDelete.click();
        return this;
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
    public String getFundType(int index) {
        return null;
    }

    @Override
    public String getFundName(int index) {
        return null;
    }

    @Override
    public String computeFundSum(int index) {
        return null;
    }

    @Override
    public String getFundSubtotalAmount() {
        return null;
    }

    @Override
    public IYourAccountsSection clickFundPanel(int index) {
        return null;
    }

    @Override
    public IYourAccountsSection validateAccounts() {
        List<WebElement> weDeposit = getWebElements(YOUR_ACCOUNTS_REPORTS_XPATH);

        Float computeResult = 0.00f;
        for ( WebElement weCurrent : weDeposit) {
            String currentAmount = weCurrent.findElement(By.xpath("//div[contains(@id, 'Sum')]//span")).getText();
            currentAmount = currentAmount.replace("€", "").trim();
            computeResult +=  Float.parseFloat(currentAmount);
        }

        assertThat("Amount should be equal", computeResult, Is.is(Float.parseFloat(weAccountsTotalValue.getText().replace("€", "").trim())));

        return this;
    }
}
