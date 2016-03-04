package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.List;

@Singleton
public class YourAccountsStepDef /*extends BorrowerStepDef*/ /*implements CLV312Workaround*/ {

    private static final Log log = LogFactory.getLog(YourAccountsStepDef.class);

    private WebDriver webDriver;

    @Inject
    private IUser user;

    IYourAccountsPage yourAccountsPage;
    IBorrowerHomePage borrowerHomePage;
    IPersonalDetailsPage borrowerPersonalDetailsPage;

    @Inject
    public YourAccountsStepDef(SharedDriver webDriver/*, IUser user*/) {
        this.webDriver = webDriver;
        yourAccountsPage = new YourAccountsPage(webDriver);
    }

    @Given("^user fills in \"(Current|Savings) Account\"$")
    public void user_fills_in_account(String currentOrSaving, List<String> accountDataMap) {
        AccountData accountData = new AccountData(accountDataMap);

        yourAccountsPage.getTitle();
        if (!StringUtils.isEmpty(accountData.get("statementDate")))
            user_types_the_statement_date(currentOrSaving, accountData.get("statementDate"));
        user_types_his_account_name(currentOrSaving, accountData.get("accountName"));
        user_types_his_sort_code_1(currentOrSaving, accountData.get("sortCode1"));
        user_types_his_sort_code_2(currentOrSaving, accountData.get("sortCode2"));
        user_types_his_sort_code_3(currentOrSaving, accountData.get("sortCode3"));
        user_types_his_account_number(currentOrSaving, accountData.get("accountNumber"));
//        user_types_his_account_provider(currentOrSaving, accountData.get("accountProvider"));
//        user_types_his_iban(currentOrSaving, accountData.get("IBAN"));
        user_types_his_account_balance(currentOrSaving, accountData.get("accountBalance"));
        if ( !StringUtils.isEmpty(accountData.get("overdraftLimit")))
            user_types_his_overdraft_limit(currentOrSaving, accountData.get("overdraftLimit"));
        user_selects_his_source_of_saving(currentOrSaving, accountData.get("sourceOfSaving"));
        if ( !StringUtils.isEmpty(accountData.get("regularMonthlySaving")))
            user_types_his_regular_monthly_saving(currentOrSaving, accountData.get("regularMonthlySaving"));
        user_clicks_add_this_account();
    }

    @When("^user clicks \"ADD ACCOUNT\"$")
    public void user_clicks_add_account() throws InterruptedException {
        yourAccountsPage.clickAddAccount();
    }

    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();
        boolean toGoOn = false;
        while ( !toGoOn ) {
            try {
                ((IFormsMenu)borrowerPersonalDetailsPage).clickAccount("double");
//                yourAccountsPage.clickAddAccount();
//                yourAccountsPage.clickAddAccountManually();
                yourAccountsPage.getTitle();
                toGoOn = true;
            } catch (WebDriverException te) {
                log.debug("Many issues to get the Account page.");
            }/* catch (TimeoutException te) {
                log.debug("Many issues to get the Account page.");
            }*/
        }
    }

    @When("^user clicks \"ADD THIS ACCOUNT\"$")
    public void user_clicks_add_this_account() {
        yourAccountsPage.clickAddThisAccount();
    }

    @When("^user clicks Accounts \"NEXT\"$")
    public void user_clicks_next() {
        yourAccountsPage.clickNext();

        if (!((IFormsMenu) yourAccountsPage).isAccountFormDone("single")) {
            ((IFormsMenu) yourAccountsPage).clickAccount("single");
            yourAccountsPage.clickNext();
        }
    }

    @When("^user clicks Accounts \"Done\"$")
    public void user_clicks_done() {
        yourAccountsPage.clickDone();
    }

    @And("^user selects (Other) account$")
    public void user_selects_account(String account){
        yourAccountsPage.selectAccount(account);
    }

    @And("^user clicks \"ADD ACCOUNT MANUALLY\"$")
    public void user_clicks_add_account_manually() {
    }

    @And("^user clicks \"(Current account|Savings account|Account scraping)\"$")
    public void user_clicks_an_account_type(String accountType) {
        switch (accountType) {
            case "Current account":
                yourAccountsPage.clickCurrentAccount();
                break;
            case "Savings account":
                yourAccountsPage.clickSavingsAccount();
                break;
            case "Account scraping":
                yourAccountsPage.clickAccountScraping();
                break;
            default:
        }
    }

    @When("^user types the (Current|Savings) statement date: (.*)")
    public void user_types_the_statement_date(String currentOrSaving, String statementDate) {
        switch (currentOrSaving) {
            case "Current":
                yourAccountsPage.typeCurrentStatementDate(statementDate);
                break;
            case "Savings":
                yourAccountsPage.typeSavingStatementDate(statementDate);
                break;
        }
    }

    @And("^user types his (Current|Savings) account name: (.*)$")
    public void user_types_his_account_name(String currentOrSavings, String accountName) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountName(accountName);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsAccountName(accountName);
                break;
        }

    }

    @And("^user types his (Current|Savings) sort code 1: (.*)$")
    public void user_types_his_sort_code_1(String currentOrSavings, String sortCode1) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentSortCode1(sortCode1);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsSortCode1(sortCode1);
                break;
        }
    }

    @And("^user types his (Current|Savings) sort code 2: (.*)$")
    public void user_types_his_sort_code_2(String currentOrSavings, String sortCode2) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentSortCode2(sortCode2);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsSortCode2(sortCode2);
                break;
        }
    }

    @And("^user types his (Current|Savings) sort code 3: (.*)$")
    public void user_types_his_sort_code_3(String currentOrSavings, String sortCode3) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentSortCode3(sortCode3);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsSortCode3(sortCode3);
                break;
        }
    }

    @And("^user types his (Current|Savings) account number: (.*)$")
    public void user_types_his_account_number(String currentOrSavings, String accountNumber) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountNumber(accountNumber);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsAccountNumber(accountNumber);
                break;
        }
    }

    @Deprecated @And("^user types his (Current|Savings) account provider: (.*)$")
    public void user_types_his_account_provider(String currentOrSavings, String accountProvider) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountProvider(accountProvider);
                break;
            case "Savings":
                yourAccountsPage.typeSavingAccountProvider(accountProvider);
                break;
        }
    }

    @And("^user types his (Current|Savings) IBAN: (.*)")
    public void user_types_his_iban(String currentOrSavings, String iban) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentIban(iban);
                break;
            case "Savings":
                yourAccountsPage.typeSavingIban(iban);
                break;
        }
    }

    @And("^user types his (Current|Savings) account balance: (.*)$")
    public void user_types_his_account_balance(String currentOrSavings, String accountBalance) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountBalance(accountBalance);
                break;
            case "Savings":
                yourAccountsPage.typeSavingAccountBalance(accountBalance);
                break;
        }
    }

    @And("^user types his (Current|Savings) overdraft limit: (.*)$")
    public void user_types_his_overdraft_limit(String currentOrSavings, String overdraftLimit) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
                break;
            case "Savings":
                yourAccountsPage.typeSavingOverdraftLimit(overdraftLimit);
                break;
        }
    }

    @And("^user selects his (Current|Savings) source of savings: (Gift|Inheritance|Accident Claim|Redundancy|Income from Regular Savings|Other)")
    public void user_selects_his_source_of_saving(String currentOrSavings, String sourceOfSavings) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.selectCurrentSavingSource(sourceOfSavings);
                break;
            case "Savings":
                yourAccountsPage.selectSavingSourceSavings(sourceOfSavings);
                break;
        }
    }

    @And("^user types his (Current|Savings) regular monthly saving: (.*)$")
    public void user_types_his_regular_monthly_saving(String currentOrSavings, String regularMonthlySaving) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentRegularMonthlySavings(regularMonthlySaving);
                break;
            case "Savings":
                yourAccountsPage.typeSavingRegularMonthlySavings(regularMonthlySaving);
                break;
        }
    }


    @When("^user closes \"scraping\" form$")
    public void user_closes_scraping_form() {
        yourAccountsPage.closeScraping();
    }






/*    @And("^user types his Current account provider: (.*)$")
    public void user_types_current_account_provider(String accountProvider) {
        yourAccountsPage.typeCurrentAccountProvider(accountProvider);
    }

    @And("^user types his Current IBAN: (.*)")
    public void user_types_current_iban(String iban) {
        yourAccountsPage.typeCurrentIban(iban);
    }

    @And("^user types his Current account balance: (.*)$")
    public void user_types_current_account_balance(String accountBalance) {
        yourAccountsPage.typeCurrentAccountBalance(accountBalance);
    }

    @And("^user types his Current overdraft limit: (.*)$")
    public void user_types_current_overdraft_limit(String overdraftLimit) {
        yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
    }

    @And("^user types his Savings account provider: (.*)$")
    public void user_types_his_savings_account_provider(String accountProvider) {
        yourAccountsPage.typeSavingAccountProvider(accountProvider);
    }

    @And("^user types his Savings IBAN: (.*)")
    public void user_type_savings_iban(String iban) {
        yourAccountsPage.typeSavingIban(iban);
    }

    @And("^user types his Savings account balance: (.*)$")
    public void user_types_his_savings_account_balance(String accountBalance) {
        yourAccountsPage.typeSavingAccountBalance(accountBalance);
    }

    @And("^user verifies account data$")
    public void user_verifies_account_data() {
//        yourAccountsPage.validateAccounts();
    }*/
}
