package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourAccountsAccountScrapingWindow;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourAccountsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.YourAccountsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.util.List;

@Singleton
public class YourAccountsStepDef {

    private static final Log log = LogFactory.getLog(YourAccountsStepDef.class.getName());

    @Inject
    private IUser user;
    private IYourAccountsPage yourAccountsPage;
    private IYourAccountsAccountScrapingWindow yourAccountsAccountScrapingWindow;

    @Inject
    public YourAccountsStepDef(SharedDriver webDriver) {
//        this.webDriver = webDriver;
        yourAccountsPage = new YourAccountsPage(webDriver);
    }

    @Given("^(Borrower) fills in (Current|Savings) account$")
    public void borrower_fills_in_account(String userType, String accountType, List<String> accountDataMap) throws InterruptedException {
        log.info(userType + " fills in "+ accountType +" Account");
        AccountData accountData = new AccountData(accountDataMap);
        Assert.assertEquals(
                "'Filling of formType : '" + accountType + " account' have Failed StepDef list data check \n " +
                        "accountType = '" + accountType + " account' should equals to the accountData.getFormType() : '" + accountData.getFormType() + "'",
                accountType + " account",
                accountData.getFormType());
        yourAccountsPage.getTitle();
        switch (accountType) {
            case "Current":
                borrower_clicks_an_account_type(userType, accountType);
                if(!StringUtils.isEmpty(accountData.getAccountName()))
                    borrower_types_his_account_name(userType, accountType, accountData.getAccountName());
                if (!StringUtils.isEmpty(accountData.getStatementDate()))
                    borrower_types_the_statement_date(userType, accountType, accountData.getStatementDate());
                borrower_types_his_account_provider(userType, accountType, accountData.getAccountProvider());
                if (!StringUtils.isEmpty(accountData.getAccountHolderName()))
                    borrower_types_his_account_holder_name(userType, accountType, accountData.getAccountHolderName());
                borrower_types_his_sort_code_1(userType, accountType, accountData.getSortCode1());
                borrower_types_his_sort_code_2(userType, accountType, accountData.getSortCode2());
                borrower_types_his_sort_code_3(userType, accountType, accountData.getSortCode3());
                borrower_types_his_account_number(userType, accountType, accountData.getAccountNumber());
                borrower_types_his_account_balance(userType, accountType, accountData.getAccountBalance());
                if (!StringUtils.isEmpty(accountData.getOverdraftLimit()))
                    borrower_types_his_overdraft_limit(userType, accountType, accountData.getOverdraftLimit());
                borrower_clicks_add_this_account(userType);
                break;

            case "Savings":
                borrower_clicks_an_account_type(userType, accountType);
                if(!StringUtils.isEmpty(accountData.getAccountName()))
                    borrower_types_his_account_name(userType, accountType, accountData.getAccountName());
                if (!StringUtils.isEmpty(accountData.getStatementDate()))
                    borrower_types_the_statement_date(userType, accountType, accountData.getStatementDate());
                borrower_types_his_account_provider(userType, accountType, accountData.getAccountProvider());
                if (!StringUtils.isEmpty(accountData.getAccountHolderName()))
                    borrower_types_his_account_holder_name(userType, accountType, accountData.getAccountHolderName());
                borrower_types_his_sort_code_1(userType, accountType, accountData.getSortCode1());
                borrower_types_his_sort_code_2(userType, accountType, accountData.getSortCode2());
                borrower_types_his_sort_code_3(userType, accountType, accountData.getSortCode3());
                borrower_types_his_account_number(userType, accountType, accountData.getAccountNumber());
                borrower_types_his_account_balance(userType, accountType, accountData.getAccountBalance());
                borrower_selects_his_source_of_saving(userType, accountType, accountData.getSourceOfSaving());
                if (!StringUtils.isEmpty(accountData.getOverdraftLimit()))
                    borrower_types_his_overdraft_limit(userType, accountType, accountData.getOverdraftLimit());
                if (!StringUtils.isEmpty(accountData.getRegularMonthlySaving()))
                    borrower_types_his_regular_monthly_saving(userType, accountType, accountData.getRegularMonthlySaving());
                borrower_clicks_add_this_account(userType);
                break;

//            case "Account scraping":
//                borrower_clicks_an_account_type(userType, accountType);
//                borrower_checks_unchecks_I_agree_checkbox(userType, ACTION.CHECK.get());
//                borrower_clicks_on_start_scrapping_button(userType);
//                break;
        }
    }

    @And("^(Borrower) (check|uncheck) \"I agree with term & conditions\" checkbox$")
    public void borrower_checks_unchecks_I_agree_checkbox(String userType, String action) {
        yourAccountsPage.iAgreeCheckbox(action);
    }

    @And("^(Borrower) clicks on Start Scraping and closes opened scraping popup window")
    public void borrower_clicks_on_start_scrapping_button(String userType) throws InterruptedException {
        yourAccountsAccountScrapingWindow = yourAccountsPage.clickStartScraping();
        yourAccountsAccountScrapingWindow.closeAccountScraping(); // todo Spike to find out why webDriver.switchTo.frame(frameName or index or WebElement frame) doesn't work with scraping window (may it be an issue due security?)
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


    @And("^(Borrower) clicks \"ADD ACCOUNT MANUALLY\"$")
    public void borrower_clicks_add_account_manually(String userType) {
    }

    @And("^(Borrower) clicks (Current|Savings) Account$")
    public void borrower_clicks_an_account_type(String userType, String accountType) {
        yourAccountsPage.clickAddAccount(); /** added click on add button --- better to place here on just one spot for all account types later branched... */
        yourAccountsPage.selectAccountType(accountType);
    }

    @When("^(Borrower) types the (Current|Savings) Account statement date: (.*)")
    public void borrower_types_the_statement_date(String userType, String currentOrSaving, String statementDate) {
        switch (currentOrSaving) {
            case "Current":
                yourAccountsPage.typeCurrentStatementDate(statementDate);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsStatementDate(statementDate);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account holder name: (.*)$")
    public void borrower_types_his_account_holder_name(String userType, String currentOrSavings, String accountHolderName) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountHolderName(accountHolderName);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsAccountHolderName(accountHolderName);
                break;
        }

    }

    @And("^(Borrower) types his (Current|Savings) Account sort code 1: (.*)$")
    public void borrower_types_his_sort_code_1(String userType, String currentOrSavings, String sortCode1) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentSortCode1(sortCode1);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsSortCode1(sortCode1);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account sort code 2: (.*)$")
    public void borrower_types_his_sort_code_2(String userType, String currentOrSavings, String sortCode2) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentSortCode2(sortCode2);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsSortCode2(sortCode2);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account sort code 3: (.*)$")
    public void borrower_types_his_sort_code_3(String userType, String currentOrSavings, String sortCode3) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentSortCode3(sortCode3);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsSortCode3(sortCode3);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account number: (.*)$")
    public void borrower_types_his_account_number(String userType, String currentOrSavings, String accountNumber) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountNumber(accountNumber);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsAccountNumber(accountNumber);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account provider: (.*)$")
    public void borrower_types_his_account_provider(String userType, String currentOrSavings, String accountProvider) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountProvider(accountProvider);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsAccountProvider(accountProvider);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account IBAN: (.*)")
    public void borrower_types_his_iban(String userType, String currentOrSavings, String iban) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentIban(iban);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsIban(iban);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account balance: (.*)$")
    public void borrower_types_his_account_balance(String userType, String currentOrSavings, String accountBalance) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentAccountBalance(accountBalance);
                break;
            case "Savings":
                yourAccountsPage.typeSavingAccountBalance(accountBalance);
                break;
        }
    }

    @And("^(Borrower) types his (Current) Account Overdraft limit: (.*)$")
    public void borrower_types_his_overdraft_limit(String userType, String currentOrSavings, String overdraftLimit) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
                break;
        }
    }

    @And("^(Borrower) selects his (Current|Savings) Account source of savings: (Gift|Inheritance|Accident Claim|Redundancy|Income from Regular Savings|Other)")
    public void borrower_selects_his_source_of_saving(String userType, String currentOrSavings, String sourceOfSavings) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.selectCurrentSavingsSource(sourceOfSavings);
                break;
            case "Savings":
                yourAccountsPage.selectSavingsSourceOfSavings(sourceOfSavings);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account regular monthly saving: (.*)$")
    public void borrower_types_his_regular_monthly_saving(String userType, String currentOrSavings, String regularMonthlySaving) {
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeCurrentRegularMonthlySavings(regularMonthlySaving);
                break;
            case "Savings":
                yourAccountsPage.typeSavingsRegularMonthlySavings(regularMonthlySaving);
                break;
        }
    }

    @And("^(Borrower) types his (Current|Savings) Account name: (.*)$")
    public void borrower_types_his_account_name(String userType, String currentOrSavings, String accountName){
        log.info(userType + " types his "+ currentOrSavings +" Account name: '"+ accountName +"'");
        switch (currentOrSavings) {
            case "Current":
                yourAccountsPage.typeAccountName(accountName);
                break;
            case "Savings":
                yourAccountsPage.typeAccountName(accountName);
                break;
        }
    }

//    @When("^(Borrower) closes \"scraping\" form$")
//    public void borrower_closes_scraping_form(String userType) {
//        yourAccountsPage.closeScraping();
//    }
}