package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import com.r2development.leveris.selenium.borrower.pageobjects.IFormsMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.Map;

@Singleton
public class YourAccountsStepDef extends BorrowerStepDef implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(YourAccountsStepDef.class);

    @Inject
    public YourAccountsStepDef(WebDriver webDriver) {
        super(webDriver);
//        yourAccountsPage = new YourAccountsPage(ApiSupportWebDriverStepDef.getWebDriverInstance());
    }

    @Given("^user fills in \"Account\"$")
    public void user_fills_in_account(Map<String, String> accountDataMap) {
        AccountData accountData = new AccountData(accountDataMap);
//        user_selects_source_funds(accountData.getFundsSource());
        user_selects_source_funds(accountData.get("fundsSource"));
//        user_types_current_account_provider(accountData.getAccountProvider());
        user_types_current_account_provider(accountData.get("accountProvider"));
//        user_types_current_iban(accountData.getIban());
        user_types_current_iban(accountData.get("IBAN"));
//        user_types_current_account_balance(accountData.getAccountBalance());
        user_types_current_account_balance(accountData.get("accountBalance"));
        user_clicks_add_this_account();
    }

    @When("^user clicks \"ADD ACCOUNT\"$")
    public void user_clicks_add_account() throws InterruptedException {
        workaroundCLV312(null);
        yourAccountsPage.clickAddAccount();
        yourAccountsPage.clickAddAccountManually();
    }

    @Override
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

    @And("^user selects (Other) account$")
    public void user_selects_account(String account){
        yourAccountsPage.selectAccount(account);
    }

    @And("^user clicks \"ADD ACCOUNT MANUALLY\"$")
    public void user_clicks_add_account_manually() {
        yourAccountsPage.clickAddAccountManually();
    }

    @When("^user selects (Current Account|Savings Account) as source of funds$")
    public void user_selects_source_funds(String sourceOfFund) {
        yourAccountsPage.selectSourceOfFunds(sourceOfFund);
    }

    @And("^this account is applied to (borrower)$")
    public void this_account_is_applied_to(String toWhom) {
        yourAccountsPage.checkAccountAppliesToBorrower(user.getFirstName());
    }

    @And("^user types his (Current|Savings) account provider: (.)$")
    public void user_types_his_account_provider(String currentOrSavings, String accountProvider) {
    }

    @And("^user types his Current account provider: (.*)$")
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
    public void user_types_his_current_overdraft_limit(String overdraftLimit) {
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

    @And("^user selects (Gift|Inheritance|Accident Claim|Redundancy|Income from Regular Savings|Other) as Source of savings")
    public void user_selects_his_source_of_savings(String sourceSavings) {
        yourAccountsPage.selectSavingSourceSavings(sourceSavings);
    }

    @And("^user types his Savings regular monthly: (.*)$")
    public void user_types_his_Savings_regular_monthly(String regularMonthly) {
        yourAccountsPage.typeSavingRegularMonthlySavings(regularMonthly);
    }

    @And("^user verifies account data$")
    public void user_verifies_account_data() {
        yourAccountsPage.validateAccounts();
    }
}
