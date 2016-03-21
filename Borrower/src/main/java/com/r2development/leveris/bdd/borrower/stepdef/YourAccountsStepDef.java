package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourAccountsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.YourAccountsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Singleton
public class YourAccountsStepDef /*extends BorrowerStepDef*/ /*implements CLV312Workaround*/ {

    private static final Log log = LogFactory.getLog(YourAccountsStepDef.class);

    private WebDriver webDriver;

    @Inject
    private IUser user;

    IYourAccountsPage yourAccountsPage;

    @Inject
    public YourAccountsStepDef(SharedDriver webDriver/*, IUser user*/) {
        this.webDriver = webDriver;
        yourAccountsPage = new YourAccountsPage(webDriver);
    }

    @Given("^(Borrower) fills in (Current account|Savings account|Account scraping)$")
    public void borrower_fills_in_account(String userType, String accountType, List<String> accountDataMap) {
        AccountData accountData = new AccountData(accountDataMap);

        Assert.assertEquals(
                "'Filling of formType : '" + accountType + "' have Failed StepDef list data check \n " +
                        "accountType = '" + accountType + "' should equals to the accountData.getFormType() : '" + accountData.getFormType() + "'",
                accountType,
                accountData.getFormType());

        yourAccountsPage.getTitle();
        borrower_clicks_an_account_type(userType, accountType);

        if (!StringUtils.isEmpty(accountData.getStatementDate()))
            borrower_types_the_statement_date(userType, accountType, accountData.getStatementDate());

        borrower_types_his_account_provider(userType, accountType, accountData.getAccountProvider());

        borrower_types_his_account_holder_name(userType, accountType, accountData.getAccountHolderName());

        borrower_types_his_sort_code_1(userType, accountType, accountData.getSortCode1());

        borrower_types_his_sort_code_2(userType, accountType, accountData.getSortCode2());

        borrower_types_his_sort_code_3(userType, accountType, accountData.getSortCode3());

        borrower_types_his_account_number(userType, accountType, accountData.getAccountNumber());

        borrower_types_his_account_balance(userType, accountType, accountData.getAccountBalance());

        if ( !StringUtils.isEmpty(accountData.getOverdraftLimit()))
            borrower_types_his_overdraft_limit(userType, accountType, accountData.getOverdraftLimit());

        borrower_selects_his_source_of_saving(userType, accountType, accountData.getSourceOfSaving());

        if ( !StringUtils.isEmpty(accountData.getRegularMonthlySaving()))
            borrower_types_his_regular_monthly_saving(userType, accountType, accountData.getRegularMonthlySaving());

        borrower_clicks_add_this_account(userType);
    }

    @When("^(Borrower) clicks \"ADD ACCOUNT\"$")
    public void borrower_clicks_add_account(String userType) throws InterruptedException {
        yourAccountsPage.clickAddAccount();
    }

    @When("^(Borrower) clicks \"ADD THIS ACCOUNT\"$")
    public void borrower_clicks_add_this_account(String userType) {
        yourAccountsPage.clickAddThisAccount();
    }

    @When("^(Borrower) clicks Accounts \"NEXT\"$")
    public void borrower_clicks_next(String userType) {
        yourAccountsPage.clickNext();

        if (!((IFormsMenu) yourAccountsPage).isAccountFormDone("single")) {
            ((IFormsMenu) yourAccountsPage).clickAccount("single");
            yourAccountsPage.clickNext();
        }
    }

    @When("^(Borrower) clicks Accounts \"Done\"$")
    public void borrower_clicks_done(String userType) {
        yourAccountsPage.clickDone();
    }

//    @And("^(Borrower) selects (Other) account$")
//    public void borrower_selects_account(String account){
//        yourAccountsPage.selectAccount(account);
//    }

    @And("^(Borrower) clicks \"ADD ACCOUNT MANUALLY\"$")
    public void borrower_clicks_add_account_manually(String userType) {
    }

    @And("^(Borrower) clicks (Current account|Savings account|Account scraping)$")
    public void borrower_clicks_an_account_type(String userType, String accountType) {
        yourAccountsPage.selectAccountType(accountType);
    }

    @When("^(Borrower) types the (Current account|Savings account) statement date: (.*)")
    public void borrower_types_the_statement_date(String userType, String currentOrSaving, String statementDate) {
        switch (currentOrSaving) {
            case "Current account":
                yourAccountsPage.typeCurrentStatementDate(statementDate);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingsStatementDate(statementDate);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) Account holder name: (.*)$")
    public void borrower_types_his_account_holder_name(String userType, String currentOrSavings, String accountHolderName) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentAccountHolderName(accountHolderName);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingsAccountHolderName(accountHolderName);
                break;
        }

    }


    @And("^(Borrower) types his (Current account|Savings account) sort code 1: (.*)$")
    public void borrower_types_his_sort_code_1(String userType, String currentOrSavings, String sortCode1) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentSortCode1(sortCode1);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingsSortCode1(sortCode1);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) sort code 2: (.*)$")
    public void borrower_types_his_sort_code_2(String userType, String currentOrSavings, String sortCode2) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentSortCode2(sortCode2);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingsSortCode2(sortCode2);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) sort code 3: (.*)$")
    public void borrower_types_his_sort_code_3(String userType, String currentOrSavings, String sortCode3) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentSortCode3(sortCode3);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingsSortCode3(sortCode3);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) number: (.*)$")
    public void borrower_types_his_account_number(String userType, String currentOrSavings, String accountNumber) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentAccountNumber(accountNumber);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingsAccountNumber(accountNumber);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) provider: (.*)$")
    public void borrower_types_his_account_provider(String userType, String currentOrSavings, String accountProvider) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentAccountProvider(accountProvider);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingAccountProvider(accountProvider);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) IBAN: (.*)")
    public void borrower_types_his_iban(String userType, String currentOrSavings, String iban) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentIban(iban);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingIban(iban);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) balance: (.*)$")
    public void borrower_types_his_account_balance(String userType, String currentOrSavings, String accountBalance) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentAccountBalance(accountBalance);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingAccountBalance(accountBalance);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) overdraft limit: (.*)$")
    public void borrower_types_his_overdraft_limit(String userType, String currentOrSavings, String overdraftLimit) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingOverdraftLimit(overdraftLimit);
                break;
        }
    }

    @And("^(Borrower) selects his (Current|Savings) source of savings: (Gift|Inheritance|Accident Claim|Redundancy|Income from Regular Savings|Other)")
    public void borrower_selects_his_source_of_saving(String userType, String currentOrSavings, String sourceOfSavings) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.selectCurrentSavingSource(sourceOfSavings);
                break;
            case "Savings account":
                yourAccountsPage.selectSavingSourceSavings(sourceOfSavings);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) regular monthly saving: (.*)$")
    public void borrower_types_his_regular_monthly_saving(String userType, String currentOrSavings, String regularMonthlySaving) {
        switch (currentOrSavings) {
            case "Current account":
                yourAccountsPage.typeCurrentRegularMonthlySavings(regularMonthlySaving);
                break;
            case "Savings account":
                yourAccountsPage.typeSavingRegularMonthlySavings(regularMonthlySaving);
                break;
        }
    }

    @When("^(Borrower) closes \"scraping\" form$")
    public void borrower_closes_scraping_form(String userType) {
        yourAccountsPage.closeScraping();
    }


/*    @And("^(Borrower) types his Current account provider: (.*)$")
    public void borrower_types_current_account_provider(String accountProvider) {
        yourAccountsPage.typeCurrentAccountProvider(accountProvider);
    }

    @And("^(Borrower) types his Current IBAN: (.*)")
    public void borrower_types_current_iban(String iban) {
        yourAccountsPage.typeCurrentIban(iban);
    }

    @And("^(Borrower) types his Current account balance: (.*)$")
    public void borrower_types_current_account_balance(String accountBalance) {
        yourAccountsPage.typeCurrentAccountBalance(accountBalance);
    }

    @And("^(Borrower) types his Current overdraft limit: (.*)$")
    public void borrower_types_current_overdraft_limit(String overdraftLimit) {
        yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
    }

    @And("^(Borrower) types his Savings account provider: (.*)$")
    public void borrower_types_his_savings_account_provider(String accountProvider) {
        yourAccountsPage.typeSavingAccountProvider(accountProvider);
    }

    @And("^(Borrower) types his Savings IBAN: (.*)")
    public void borrower_type_savings_iban(String iban) {
        yourAccountsPage.typeSavingIban(iban);
    }

    @And("^(Borrower) types his Savings account balance: (.*)$")
    public void borrower_types_his_savings_account_balance(String accountBalance) {
        yourAccountsPage.typeSavingAccountBalance(accountBalance);
    }

    @And("^(Borrower) verifies account data$")
    public void borrower_verifies_account_data() {
//        yourAccountsPage.validateAccounts();
    }*/
}
