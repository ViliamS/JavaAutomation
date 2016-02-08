package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.r2development.leveris.utils.HttpUtils.*;

@Singleton
public class ApiYourAccountsStepDef extends ApiAbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourAccountsStepDef.class);

    public ApiYourAccountsStepDef() {
    }

    @Given("^user fills in \"Account\"$")
    public void user_fills_in_account(Map<String, String> accountDataMap) throws IOException {
        AccountData accountData = new AccountData(accountDataMap);
        user_selects_source_funds(accountData.get("fundsSource"));
        user_types_current_account_provider(accountData.get("accountProvider"));
        user_types_current_iban(accountData.get("IBAN"));
        user_types_current_account_balance(accountData.get("accountBalance"));
        user_clicks_add_this_account();
    }

    @When("^user clicks \"ADD ACCOUNT\"$")
    public void user_clicks_add_account() throws IOException {

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlButtons:c:w:btnAddSource:dialog::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                null,
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlMain:c:w:pnlOther:c:w:btnAddAccountManually:cancel::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlButtons:c:w:btnAddSource:close::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form::IFormChangeListener:2:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put(
                                "data",
                                "{" +
                                        "  \"widgets\": [" +
                                        "    {" +
                                        "      \"widget\": \"pnlButtons\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -130," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 760," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource cmbSourceOfFunds\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers chkBorrower1\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers chkBorrower2\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate txtStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider txtAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits txtIban\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance crbAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft crbOverdraft\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings cmbSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings crbRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource cmbSourceOfFunds\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 80," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 80," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 80," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 80," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 80," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": true" +
                                        "      }," +
                                        "      \"delta\": 80," +
                                        "      \"visibleEvent\": \"show\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers chkBorrower1\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers chkBorrower2\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlBorrowers\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate txtStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlStatementDate\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider txtAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountProvider\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits txtIban\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlLastFourDigits\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance crbAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlAccountBalance\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft crbOverdraft\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlOverDraft\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings cmbSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings crbRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": true" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlSourceOfSavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"visible\": false" +
                                        "      }," +
                                        "      \"delta\": -80," +
                                        "      \"visibleEvent\": \"hide\"" +
                                        "    }," +
                                        "    {" +
                                        "      \"widget\": \"pnlAddSource pnlRegularMonthlySavings\"," +
                                        "      \"data\": {" +
                                        "        \"enable\": false" +
                                        "      }" +
                                        "    }" +
                                        "  ]" +
                                        "}"
                        );
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @When("^user clicks \"ADD THIS ACCOUNT\"$")
    public void user_clicks_add_this_account() throws IOException {
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlAddSource:c:w:btnAddThisSource:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                accountParameters,
                localContext,
                CONSUME_QUIETLY
        );
    }

    @When("^user clicks Accounts \"NEXT\"$")
    public void user_clicks_next() throws IOException {
//        yourAccountsPage.clickNext();
        requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlButtons:c:w:btnNext:cancel::IBehaviorListener:0:&stepToken=1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
    }

    @And("^user selects (Other) account$")
    public void user_selects_account(String account){
//        yourAccountsPage.selectAccount(account);
    }

    @And("^user clicks \"ADD ACCOUNT MANUALLY\"$")
    public void user_clicks_add_account_manually() {
//        yourAccountsPage.clickAddAccountManually();
    }

    @When("^user selects (Current Account|Savings Account) as source of funds$")
    public void user_selects_source_funds(String sourceOfFund) {
//        yourAccountsPage.selectSourceOfFunds(sourceOfFund);

        switch (sourceOfFund) {
            case "Current Account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:cmbSourceOfFunds:combobox", "CA");
                break;
            case "Savings Account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:cmbSourceOfFunds:combobox", "SA");
                break;
            default:
        }

    }

    @And("^this account is applied to (borrower|coapplicant|both)$")
    public void this_account_is_applied_to(String toWhom) {
        switch (toWhom) {
            case "borrower":
//                yourAccountsPage.checkAccountAppliesToBorrower(user.getFirstName());
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlBorrowers:c:w:chkBorrower1:checkbox", "on");
                break;
            case "coapplicant":
//                yourAccountsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlBorrowers:c:w:chkBorrower2:checkbox", "on");
                break;
            case "both":
//                yourAccountsPage.checkAccountAppliesToBorrower(user.getFirstName());
//                yourAccountsPage.checkAccountAppliesToCoapplicant(user.getFirstNameCoApplicant());
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlBorrowers:c:w:chkBorrower1:checkbox", "on");
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlBorrowers:c:w:chkBorrower2:checkbox", "on");
                break;
            default:
        }
    }

    @And("^user types his (Current|Savings) account provider: (.)$")
    public void user_types_his_account_provider(String currentOrSavings, String accountProvider) {

    }

    @And("^user types his Current account provider: (.*)$")
    public void user_types_current_account_provider(String accountProvider) {
//        yourAccountsPage.typeCurrentAccountProvider(accountProvider);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountProvider:c:w:txtAccountProvider:tb", "Central Bank of Ireland");
    }

    @And("^user types his Current IBAN: (.*)")
    public void user_types_current_iban(String iban) {
//        yourAccountsPage.typeCurrentIban(iban);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlLastFourDigits:c:w:txtIban:tb", "IE92BOFI90001710027952");
    }

    @And("^user types his Current account balance: (.*)$")
    public void user_types_current_account_balance(String accountBalance) {
//        yourAccountsPage.typeCurrentAccountBalance(accountBalance);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountBalance:c:w:crbAccountBalance:tb", "20000");
    }

    @And("^user types his Current overdraft limit: (.*)$")
    public void user_types_his_current_overdraft_limit(String overdraftLimit) {
//        yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlOverDraft:c:w:crbOverdraft:tb", null);
    }

    @And("^user types his Savings account provider: (.*)$")
    public void user_types_his_savings_account_provider(String accountProvider) {
//        yourAccountsPage.typeSavingAccountProvider(accountProvider);
//        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlLastFourDigits:c:w:txtIban:tb", "IE92BOFI90001710027952");
    }

    @And("^user types his Savings IBAN: (.*)")
    public void user_type_savings_iban(String iban) {
//        yourAccountsPage.typeSavingIban(iban);
    }

    @And("^user types his Savings account balance: (.*)$")
    public void user_types_his_savings_account_balance(String accountBalance) {
//        yourAccountsPage.typeSavingAccountBalance(accountBalance);
//        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountBalance:c:w:crbAccountBalance:tb", "20000");
    }

    @And("^user selects (Gift|Inheritance|Accident Claim|Redundancy|Income from Regular Savings|Other) as Source of savings")
    public void user_selects_his_source_of_savings(String sourceSavings) {
//        yourAccountsPage.selectSavingSourceSavings(sourceSavings);
    }

    @And("^user types his Savings regular monthly: (.*)$")
    public void user_types_his_Savings_regular_monthly(String regularMonthly) {
//        yourAccountsPage.typeSavingRegularMonthlySavings(regularMonthly);

    }

    @And("^user verifies account data$")
    public void user_verifies_account_data() {
//        yourAccountsPage.validateAccounts();
    }
}
