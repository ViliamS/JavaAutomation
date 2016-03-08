package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import com.r2development.leveris.di.IHttpResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static com.r2development.leveris.utils.HttpUtils.*;

@Singleton
public class ApiYourAccountsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourAccountsStepDef.class);

    int countAccount = 0;


    @Inject
    IHttpResponse httpResponse;

    @Inject
    public ApiYourAccountsStepDef(IHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Given("^user fills in \"(Current|Savings) Account\"$")
//    public void user_fills_in_account(Map<String, String> accountDataMap) throws IOException {
    public void user_fills_in_account(String currentOrSaving, List<String> accountDataMap) throws IOException {
        AccountData accountData = new AccountData(accountDataMap);
//        user_selects_source_funds(accountData.get("fundsSource"));
//        yourAccountsPage.getTitle();
        if (!org.apache.commons.lang3.StringUtils.isEmpty(accountData.get("statementDate")))
            user_types_the_statement_date(currentOrSaving, accountData.get("statementDate"));
        user_types_his_account_name(currentOrSaving, accountData.get("accountName"));
        user_types_his_sort_code_1(currentOrSaving, accountData.get("sortCode1"));
        user_types_his_sort_code_2(currentOrSaving, accountData.get("sortCode2"));
        user_types_his_sort_code_3(currentOrSaving, accountData.get("sortCode3"));
//        user_types_his_account_provider(currentOrSaving, accountData.get("accountProvider"));
//        user_types_his_iban(currentOrSaving, accountData.get("IBAN"));
        user_types_his_account_number(currentOrSaving, accountData.get("accountNumber"));
        user_types_his_account_balance(currentOrSaving, accountData.get("accountBalance"));
        if ( !org.apache.commons.lang3.StringUtils.isEmpty(accountData.get("overdraftLimit")))
            user_types_his_overdraft_limit(currentOrSaving, accountData.get("overdraftLimit"));
        user_selects_his_source_of_saving(currentOrSaving, accountData.get("sourceOfSaving"));
        if ( !org.apache.commons.lang3.StringUtils.isEmpty(accountData.get("regularMonthlySaving")))
            user_types_his_regular_monthly_saving(currentOrSaving, accountData.get("regularMonthlySaving"));
        user_clicks_add_this_account();
    }

    @When("^user clicks \"ADD ACCOUNT\"$")
    public void user_clicks_add_account() throws IOException {

        Document yourAccountDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodeYourAccount = yourAccountDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Document yourAccountDoc2 = Jsoup.parse(textNodeYourAccount.text());

        Elements countElementAccount = yourAccountDoc2.select("div[wicketpath~=^main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_\\d+_item_pnlItems$]");
        countAccount = countElementAccount.size();

        String menuAccountResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAdd:dialog::IBehaviorListener:0:",
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
        httpResponse.setHttpResponse(menuAccountResponse);
    }

    @When("^user clicks \"ADD THIS ACCOUNT\"$")
    public void user_clicks_add_this_account() throws IOException {

        Document formToFillDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodeFormToFill = null;
        try {
            textNodeFormToFill = formToFillDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
        } catch ( NullPointerException npe ) {
            textNodeFormToFill = formToFillDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        }
        Document formToFillDoc2 = Jsoup.parse(textNodeFormToFill.text());

        String stepToken = formToFillDoc2.select("input[name=stepToken]").attr("value");

        accountParameters.put("root:c:w:txtId:tb", "");
        accountParameters.put("stepToken", stepToken);
        accountParameters.put("root:c:w:pnlAddSource:c:w:btnAddThisSource:submit", "1");

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlAddSource:c:w:btnAddThisSource:submit::IBehaviorListener:0:-1",
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

        if (countAccount == 0) {

            requestHttpGet(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:close::IBehaviorListener:0:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

            String responseAddThisSource = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:btnHiddenSubmit:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(responseAddThisSource);
        }
        else {

            requestHttpGet(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAdd:close::IBehaviorListener:0:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );

            String responseAddThisSource = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenRefresh:submit::IBehaviorListener:0:",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "1");
                            put("root:c:w:btnHiddenSubmit:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(responseAddThisSource);
        }
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

    @When("^user clicks Accounts \"Done\"$")
    public void user_clicks_done() throws IOException {

        Document yourAccountDoc = Jsoup.parse(httpResponse.getHttpResponse()); // ???? BUG CLV response from abakus
//        TextNode textNodeYourAccount = yourAccountDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document yourAccountDoc2 = Jsoup.parse(textNodeYourAccount.text());

//        yourAccountsPage.clickDone();
        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnImDone:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:pnlEmpList:c:w:btnImDone:submit", "1");
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

    @And("^user clicks \"(Current account|Savings account|Account scraping)\"$")
    public void user_clicks_an_account_type(String accountType) throws IOException {

        Document menuAccountDoc = Jsoup.parse(httpResponse.getHttpResponse());
//        TextNode textNodeMenuAccountDoc = menuAccountDoc.select("id=main encodinh=wicket").first().textNodes().get(0);
//        try {
//            textNodeYourAccount = yourAccountDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        } catch ( Exception e ) {
//            textNodeYourAccount = yourAccountDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        }
//        Document menuAccountDoc2 = Jsoup.parse(textNodeMenuAccountDoc.text());


        String formToFillResponse = StringUtils.EMPTY;
        switch (accountType) {
            case "Current account":
//                yourAccountsPage.clickCurrentAccount();
                if ( countAccount == 0 ) {
                    formToFillResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:dialog::IBehaviorListener:0:",
//                            ?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:dialog::IBehaviorListener:0:
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
                    httpResponse.setHttpResponse(formToFillResponse);
                }
                else {
//                :main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit::IBehaviorListener:0:

                    requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit::IBehaviorListener:0:",

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
                break;
            case "Savings account":
//                yourAccountsPage.clickSavingsAccount();
                if ( countAccount == 0 ) {
                    formToFillResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:dialog::IBehaviorListener:0:",
//                            ?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:dialog::IBehaviorListener:0:
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
                    httpResponse.setHttpResponse(formToFillResponse);
                }
                else {
//                :main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:submit::IBehaviorListener:0:
                    requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:submit::IBehaviorListener:0:",
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
                break;
            case "Account scraping":
                accountParameters = new LinkedHashMap<>();
                accountParameters.put("stepToken", "1");
                accountParameters.put("root:c:w:pnlNoEmplyments:c:w:lnkAuto:submit", "1");

                if ( countAccount == 0 ) {
                    String responseScraping = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAuto:dialog::IBehaviorListener:0:",
//                            ?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAuto:dialog::IBehaviorListener:0:
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
                    httpResponse.setHttpResponse(responseScraping);
                }
                else {
//                :main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:submit::IBehaviorListener:0:
                    String responseScraping = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:submit::IBehaviorListener:0:-1",
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
                    httpResponse.setHttpResponse(responseScraping);
                }
                break;
        }

    }

    @When("^user types the (Current|Savings) statement date: (.*)")
    public void user_types_the_statement_date(String currentOrSaving, String statementDate) {
        switch (currentOrSaving) {
            case "Current":
//                yourAccountsPage.typeCurrentStatementDate(statementDate);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlStatementDate:c:w:txtStatementDate:tb", statementDate);
                break;
            case "Savings":
//                yourAccountsPage.typeSavingStatementDate(statementDate);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlStatementDate:c:w:txtStatementDate:tb", statementDate);
                break;
        }
    }


    @Deprecated @And("^user types his (Current|Savings) account provider: (.*)$")
    public void user_types_his_account_provider(String currentOrSavings, String accountProvider) {
        switch (currentOrSavings) {
            case "Current":
//                yourAccountsPage.typeCurrentAccountProvider(accountProvider);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountProvider:c:w:txtAccountProvider:tb", accountProvider);
                break;
            case "Savings":
//                yourAccountsPage.typeSavingAccountProvider(accountProvider);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountProvider:c:w:txtAccountProvider:tb", accountProvider);
                break;
        }
    }

    @Deprecated @And("^user types his (Current|Savings) IBAN: (.*)")
    public void user_types_his_iban(String currentOrSavings, String iban) {
        switch (currentOrSavings) {
            case "Current":
//                yourAccountsPage.typeCurrentIban(iban);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlLastFourDigits:c:w:txtIban:tb", iban);
                break;
            case "Savings":
//                yourAccountsPage.typeSavingIban(iban);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlLastFourDigits:c:w:txtIban:tb", iban);
                break;
        }
    }

    @And("^user types his (Current|Savings) account name: (.*)")
    public void user_types_his_account_name(String currentOrSavings, String accountName) {
        switch (currentOrSavings) {
            case "Current":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtAccName:tb", accountName);
                break;
            case "Savings":
                accountParameters.put("", accountName);
                break;
        }
    }

    @And("^user types his (Current|Savings) sort code: ([0-9]{2})")
    public void user_types_his_sort_code_1(String currentOrSavings, String sortCode1) {
        switch (currentOrSavings) {
            case "Current":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode1:tb", sortCode1);
                break;
            case "Savings":
                accountParameters.put("", sortCode1);
        }
    }

    @And("^user types his (Current|Savings) sort code 2: ([0-9]{2})")
    public void user_types_his_sort_code_2(String currentOrSavings, String sortCode2) {
        switch (currentOrSavings) {
            case "Current":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode2:tb", sortCode2);
                break;
            case "Savings":
                accountParameters.put("", sortCode2);
        }
    }

    @And("^user types his (Current|Savings) sort code 3: ([0-9]{2})")
    public void user_types_his_sort_code_3(String currentOrSavings, String sortCode3) {
        switch (currentOrSavings) {
            case "Current":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode3:tb", sortCode3);
                break;
            case "Savings":
                accountParameters.put("", sortCode3);
        }
    }

    @And("^user types his (Current|Savings) account number: (.*)")
    public void user_types_his_account_number(String currentOrSavings, String accountNumber) {
        switch (currentOrSavings) {
            case "Current":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtAccnumber:tb", accountNumber);
                break;
            case "Savings":
                accountParameters.put("", accountNumber);
        }
    }

    @And("^user types his (Current|Savings) account balance: (.*)$")
    public void user_types_his_account_balance(String currentOrSavings, String accountBalance) {
        switch (currentOrSavings) {
            case "Current":
//                yourAccountsPage.typeCurrentAccountBalance(accountBalance);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountBalance:c:w:crbAccountBalance:tb", accountBalance);
                break;
            case "Savings":
//                yourAccountsPage.typeSavingAccountBalance(accountBalance);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountBalance:c:w:crbAccountBalance:tb", accountBalance);
                break;
        }
    }

    @And("^user types his (Current|Savings) overdraft limit: (.*)$")
    public void user_types_his_overdraft_limit(String currentOrSavings, String overdraftLimit) {
        switch (currentOrSavings) {
            case "Current":
//                yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlOverDraft:c:w:crbOverdraft:tb", overdraftLimit);
                break;
            case "Savings":
//                yourAccountsPage.typeSavingOverdraftLimit(overdraftLimit);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlOverDraft:c:w:crbOverdraft:tb", overdraftLimit);
                break;
        }
    }

    @And("^user selects his (Current|Savings) source of savings: (Gift|Inheritance|Accident Claim|Redundancy|Income from Regular Savings|Other)")
    public void user_selects_his_source_of_saving(String currentOrSavings, String sourceOfSavings) {

/*        <option selected="selected" value="">Choose One</option>
        <option value="G">Gift</option>
        <option value="INH">Inheritance</option>
        <option value="ACC">Accident Claim</option>
        <option value="RDN">Redundancy</option>
        <option value="IRS">Income from Regular Savings</option>
        <option value="OTH">Other</option>*/

        String abbreviationSavingSource = StringUtils.EMPTY;
        switch (sourceOfSavings) {
            case "Gift":
                abbreviationSavingSource = "G";
                break;
            case "Inheritance":
                abbreviationSavingSource = "INH";
                break;
            case "Accident Claim":
                abbreviationSavingSource = "ACC";
                break;
            case "Redundancy":
                abbreviationSavingSource = "RDN";
                break;
            case "Income from Regular Savings":
                abbreviationSavingSource = "IRS";
                break;
            case "Other":
                abbreviationSavingSource = "Other";
                break;
        }

        switch (currentOrSavings) {
            case "Current":
//                yourAccountsPage.selectCurrentSavingSource(sourceOfSavings);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", abbreviationSavingSource);
                break;
            case "Savings":
//                yourAccountsPage.selectSavingSourceSavings(sourceOfSavings);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", abbreviationSavingSource);
                break;
        }
    }

    @And("^user types his (Current|Savings) regular monthly saving: (.*)$")
    public void user_types_his_regular_monthly_saving(String currentOrSavings, String regularMonthlySaving) {
        switch (currentOrSavings) {
            case "Current":
//                yourAccountsPage.typeCurrentRegularMonthlySavings(regularMonthlySaving);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlRegularMonthlySavings:c:w:crbRegularMonthlySavings:tb", regularMonthlySaving);
                break;
            case "Savings":
//                yourAccountsPage.typeSavingRegularMonthlySavings(regularMonthlySaving);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlRegularMonthlySavings:c:w:crbRegularMonthlySavings:tb", regularMonthlySaving);
                break;
        }
    }


    @When("^user closes \"scraping\" form$")
    public void user_closes_scraping_form() throws IOException {
        Document yourAccountDoc = Jsoup.parse(httpResponse.getHttpResponse());
        TextNode textNodeYourAccount = null;
        try {
            textNodeYourAccount = yourAccountDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
        } catch ( Exception e ) {
            textNodeYourAccount = yourAccountDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
        }
        Document yourAccountDoc2 = Jsoup.parse(textNodeYourAccount.text());

//        yourAccountsPage.closeScraping();
        requestHttpGet(
                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnl-608:c:w:btnClose:cancel::IBehaviorListener:0&stepToken=1",
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnImDone:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

//        requestHttpGet(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAuto:close::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/xml");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );
    }







/*    @And("^user types his Current account provider: (.*)$")
    public void user_types_current_account_provider(String accountProvider) {
//        yourAccountsPage.typeCurrentAccountProvider(accountProvider);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountProvider:c:w:txtAccountProvider:tb", accountProvider);
    }

    @And("^user types his Current IBAN: (.*)")
    public void user_types_current_iban(String iban) {
//        yourAccountsPage.typeCurrentIban(iban);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlLastFourDigits:c:w:txtIban:tb", iban);
    }

    @And("^user types his Current account balance: (.*)$")
    public void user_types_current_account_balance(String accountBalance) {
//        yourAccountsPage.typeCurrentAccountBalance(accountBalance);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountBalance:c:w:crbAccountBalance:tb", accountBalance);
    }

    @And("^user types his Current savings source : (.*)$")
    public void user_types_current_savings_source(String savingSource) {
//        yourAccountsPage.typeCurrentSavingSource(savingSource);
        String abbreviationSavingSource = StringUtils.EMPTY;
        switch (savingSource) {
            case "Gift":
                abbreviationSavingSource = "G";
                break;
            default:
        }
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", abbreviationSavingSource);
    }

    @And("^user types his Current overdraft limit: (.*)$")
    public void user_types_his_current_overdraft_limit(String overdraftLimit) {
//        yourAccountsPage.typeCurrentOverdraftLimit(overdraftLimit);
        accountParameters.put("root:c:w:pnlAddSource:c:w:pnlOverDraft:c:w:crbOverdraft:tb", "");
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
    }*/
}
