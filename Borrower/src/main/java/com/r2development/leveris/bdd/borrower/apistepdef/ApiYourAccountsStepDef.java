package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.junit.Assert.assertEquals;

@Singleton
public class ApiYourAccountsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourAccountsStepDef.class.getName());

    @Inject
    private IUser user;
    @Inject
    IHttpResponse httpResponse;

    private boolean isThereAccountList = false;
//    private int stepTokenAddThisSource = 1;
    private int stepTokenHiddenSubmit = 1;

    @Inject
    public ApiYourAccountsStepDef(IHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Given("^(Borrower) fills in (Current account|Savings account|Account scraping)$")
    public void borrower_fills_in_account(String userType, String formType, Map<String, String> accountDataMap) throws IOException {
        AccountData accountData = new AccountData(accountDataMap);

        assertEquals(
                "We should have the same employment and income category in step def calling and in the table",
                formType,
                accountData.getFormType()
        );

        borrower_clicks_an_account_type(userType, formType);

        switch (formType) {

            case "Current account":
                if (!StringUtils.isEmpty(accountData.getStatementDate()))
                    borrower_types_the_statement_date(userType, formType, accountData.getStatementDate());
                borrower_types_his_account_provider(userType, formType, accountData.get("accountProvider"));
                borrower_types_his_account_holder_name(userType, formType, accountData.getAccountHolderName());
//                borrower_types_his_account_name(userType, formType, accountData.get("accountName"));
                borrower_types_his_sort_code_1(userType, formType, accountData.get("sortCode1"));
                borrower_types_his_sort_code_2(userType, formType, accountData.get("sortCode2"));
                borrower_types_his_sort_code_3(userType, formType, accountData.get("sortCode3"));
                borrower_types_his_account_number(userType, formType, accountData.get("accountNumber"));
                borrower_types_his_account_balance(userType, formType, accountData.get("accountBalance"));
                if (!StringUtils.isEmpty(accountData.get("overdraftLimit")))
                    borrower_types_his_overdraft_limit(userType, formType, accountData.get("overdraftLimit"));
                borrower_selects_his_source_of_saving(userType, formType, accountData.get("sourceOfSaving"));
                if (!StringUtils.isEmpty(accountData.get("regularMonthlySaving")))
                    borrower_types_his_regular_monthly_saving(userType, formType, accountData.get("regularMonthlySaving"));
                break;
            case "Savings account":
                if (!StringUtils.isEmpty(accountData.get("statementDate")))
                    borrower_types_the_statement_date(userType, formType, accountData.get("statementDate"));
                borrower_types_his_account_provider(userType, formType, accountData.get("accountProvider"));
                borrower_types_his_account_holder_name(userType, formType, accountData.getAccountHolderName());
//                borrower_types_his_account_name(userType, formType, accountData.get("accountName"));
                borrower_types_his_sort_code_1(userType, formType, accountData.get("sortCode1"));
                borrower_types_his_sort_code_2(userType, formType, accountData.get("sortCode2"));
                borrower_types_his_sort_code_3(userType, formType, accountData.get("sortCode3"));
                borrower_types_his_account_number(userType, formType, accountData.get("accountNumber"));
                borrower_types_his_account_balance(userType, formType, accountData.get("accountBalance"));
                if (!StringUtils.isEmpty(accountData.get("overdraftLimit")))
                    borrower_types_his_overdraft_limit(userType, formType, accountData.get("overdraftLimit"));
                borrower_selects_his_source_of_saving(userType, formType, accountData.get("sourceOfSaving"));
                if (!StringUtils.isEmpty(accountData.get("regularMonthlySaving")))
                    borrower_types_his_regular_monthly_saving(userType, formType, accountData.get("regularMonthlySaving"));
                break;
            case "Account scrapping":
                break;
            default:
        }

        borrower_clicks_add_this_account(userType, formType);
    }

    @When("^(Borrower) clicks \"ADD ACCOUNT\"$")
    public void borrower_clicks_add_account(String userType) throws IOException {

//        Document yourAccountDoc = Jsoup.parse(httpResponse.getHttpResponse());
//        TextNode textNodeYourAccount = yourAccountDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document yourAccountDoc2 = Jsoup.parse(textNodeYourAccount.text());

//        Elements countElementAccount = yourAccountDoc2.select("div[wicketpath~=^main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_\\d+_item_pnlItems$]");
//        countAccount = countElementAccount.size();

        String menuAccountResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAdd:dialog::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>(){},
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(menuAccountResponse);
    }

    @When("^(Borrower) clicks \"ADD THIS ACCOUNT\"$")
    public void borrower_clicks_add_this_account(String userType, String accountType) throws IOException {

        Map<String, String> finalAccountParameters = new LinkedHashMap<>();
        finalAccountParameters.putAll(accountParameters);

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");
//        int stepTokenInt = Integer.parseInt(stepToken);

//        accountParameters.put("root:c:w:txtId:tb", "");
        finalAccountParameters.put("root:c:w:txtId:tb", "");
//        accountParameters.put("stepToken", stepToken);
        finalAccountParameters.put("stepToken", stepToken);
//        accountParameters.put("root:c:w:pnlAddSource:c:w:btnAddThisSource:submit", "1");
        finalAccountParameters.put("root:c:w:pnlAddSource:c:w:btnAddThisSource:submit", "1");

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlAddSource:c:w:btnAddThisSource:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
//                accountParameters,
                finalAccountParameters,
                localContext,
                CONSUME_QUIETLY
        );

//        String finalCategory = StringUtils.EMPTY;
        String linkClose = StringUtils.EMPTY;
        switch(accountType) { // BUG Internal CLV Framework ?!
            case "Current account":
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:close::IBehaviorListener:0:-1";
                break;
            case "Savings account":
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:close::IBehaviorListener:0:-1";
                break;
            case "Scrapping":
//                :main:c:form:dialogWrapper:dialog:form:root:c:w:pnl-608:c:w:btnClose:cancel::IBehaviorListener:0:
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAuto:close::IBehaviorListener:0:-1";
                break;
            default:
        }

        if ( isThereAccountList ) {
            linkClose = ":1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnAdd:close::IBehaviorListener:0:-1";
        }

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=" + linkClose,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                },
                localContext,
                CONSUME_QUIETLY
        );

        if ( isThereAccountList ) {
//            String finalStepToken =  String.valueOf(stepTokenHiddenSubmit+1);
            String responseHiddenThisSource = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenRefresh:submit::IBehaviorListener:0:-1",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/xml");
                            put("Content-Type", "application/x-www-form-urlencoded");
                        }
                    },
                    new LinkedHashMap<String, String>() {
                        {
                            put("stepToken", "2");
                            put("root:c:w:btnHiddenRefresh:submit", "1");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(responseHiddenThisSource);
        }
        else {
//            String finalStepToken = String.valueOf(Integer.parseInt(stepToken)+1);
//            stepTokenHiddenSubmit = stepTokenHiddenSubmit + 1;
//            String finalStepToken = String.valueOf(stepTokenHiddenSubmit);
            String responseRefreshThisSource = requestHttpPost(
                    httpClient,
                    System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:-1",
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
            httpResponse.setHttpResponse(responseRefreshThisSource);
        }
        isThereAccountList = true;
    }

    @When("^Borrower clicks Accounts \"NEXT\"$")
    public void borrower_clicks_next() throws IOException {
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

    @When("^(Borrower) clicks Accounts \"Done\"$")
    public void borrower_clicks_done(String userType) throws IOException {

        Document currentFormDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document currentFormDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                currentFormDoc2 = Jsoup.parse(currentFormDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String stepToken = currentFormDoc2.select("input[name=stepToken]").attr("value");

        String yourAccountPageResponse = requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlEmpList:c:w:btnImDone:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", stepToken); // TODO extract stepToken should be 3
                        put("root:c:w:pnlEmpList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(yourAccountPageResponse);
    }

//    @And("^(Borrower) selects (Other) account$")
//    public void borrower_selects_account(String account){
//        yourAccountsPage.selectAccount(account);
//    }

    @And("^(Borrower) clicks \"ADD ACCOUNT MANUALLY\"$")
    public void borrower_clicks_add_account_manually(String userType) {
    }

    @And("^(Borrower) clicks (Current account|Savings account|Account scraping)$")
    public void borrower_clicks_an_account_type(String userType, String accountType) throws IOException {

        Document accountDoc = Jsoup.parse(httpResponse.getHttpResponse());
        Document accountDoc2 = null;
        String[] componentId = { "main", "form", "dialog" };
        for (String aComponentId : componentId) {
            try {
                accountDoc2 = Jsoup.parse(accountDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

        String fixCategory = StringUtils.EMPTY;
        switch ( accountType ) {
            case "Current account":
                fixCategory = "Current";
                break;
            case "Savings account":
                fixCategory = "Savings";
                break;
            case "Account scraping":
                fixCategory = "Auto";
                break;
            default:
                log.error("Huston, we have an issue on Fix Category Type");
        }
        final String finalFixCategory = fixCategory;

//        Map<String, String> wicketInterfaceMap = new LinkedHashMap<>();
        String linkAdd = null;
//        String currentKey = "linkAdd";
        if ( isThereAccountList ) {
            Elements divAccountTypeAddElements = accountDoc2.select("div[data-path=pnlEmpList btnAdd]");
            for (Element current : divAccountTypeAddElements) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath=main_c_form_form_root_c_w_pnlEmpList_c_w_btnAdd_dialog]").attr("onclick");
                Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
                Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
                String currentWicketInterface = null;
                while (mWicketInterface.find()) {
                    currentWicketInterface = mWicketInterface.group(1);
                }
                linkAdd = currentWicketInterface;
            }
        }
        else /*if ( divAccountTypeAddElements2.size() == 0)*/ {
//            divAccountTypeAddElements2 = accountDoc2.select("div[data-path~=pnlEmpList btnAdd]");
//            Elements divAccountTypeAddElements2 = null;
            Elements divAccountTypeAddElements2 = accountDoc2.select("div[data-path~=pnlNoEmplyments").select("div[data-path~=lnk" + finalFixCategory + "]");
            for (Element current : divAccountTypeAddElements2) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoEmplyments_c_w_").select("a[wicketpath~=lnk" + finalFixCategory + "_dialog]").attr("onclick");
                Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
                Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
                String currentWicketInterface = null;
                while (mWicketInterface.find()) {
                    currentWicketInterface = mWicketInterface.group(1);
                }
//                wicketInterfaceMap.put(currentKey, currentWicketInterface);
                linkAdd = currentWicketInterface;
            }
        }
        final String finalLinkAdd = linkAdd;

        Map<String, String> linkAddParameters = new LinkedHashMap<>();
        if ( isThereAccountList ) {
            String stepToken = accountDoc2.select("input[name=stepToken").attr("value");
            linkAddParameters.put("stepToken", stepToken);
        }

        String employmentLinkAddResponse = requestHttpPost(
                httpClient,
//                        System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAddPaye:dialog::IBehaviorListener:0:",
//                        System.getProperty("borrower") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
                System.getProperty("borrower") + "/form.2?wicket:interface=" + finalLinkAdd,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                linkAddParameters,
                localContext,
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(employmentLinkAddResponse);


        String linkSubmitResponse;
        switch ( fixCategory ) {
            case "Current":

                if ( isThereAccountList ) {
                    linkSubmitResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit::IBehaviorListener:0:",

                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit", "1");
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(linkSubmitResponse);
                }

                break;
            case "Savings":

                if ( isThereAccountList ) {
                    linkSubmitResponse = requestHttpPost(
                            httpClient,
//                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit::IBehaviorListener:0:",
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:submit::IBehaviorListener:0:",

                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit", "1");
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(linkSubmitResponse);
                }

                break;
            case "Auto":

                if ( isThereAccountList ) {
                    linkSubmitResponse = requestHttpPost(
                            httpClient,
                            System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkSavings:submit::IBehaviorListener:0:",
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit", "1");
                                }
                            },
                            localContext,
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(linkSubmitResponse);
                }

                break;
            default:
        }
    }

    @When("^(Borrower) types the (Current account|Savings account) statement date: (.*)")
    public void borrower_types_the_statement_date(String userType, String currentOrSaving, String statementDate) {
        switch (currentOrSaving) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlStatementDate:c:w:txtStatementDate:tb", statementDate);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlStatementDate:c:w:txtStatementDate:tb", statementDate);
                break;
        }
    }

    @And("^(Borrower) types the (Current account|Savings account) account provider: (.*)")
    public void borrower_types_his_account_provider(String userType, String currentOrSaving, String accountProvider) {
        switch (currentOrSaving) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountProvider:c:w:txtAccountProvider:tb", accountProvider);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountProvider:c:w:txtAccountProvider:tb", accountProvider);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) Account holder name: (.*)")
    public void borrower_types_his_account_holder_name(String userType, String currentOrSavings, String accountHolderName) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtAccName:tb", accountHolderName);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtAccName:tb", accountHolderName);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) sort code 1: ([0-9]{2})")
    public void borrower_types_his_sort_code_1(String userType, String currentOrSavings, String sortCode1) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode1:tb", sortCode1);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode1:tb", sortCode1);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) sort code 2: ([0-9]{2})")
    public void borrower_types_his_sort_code_2(String userType, String currentOrSavings, String sortCode2) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode2:tb", sortCode2);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode2:tb", sortCode2);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) sort code 3: ([0-9]{2})")
    public void borrower_types_his_sort_code_3(String userType, String currentOrSavings, String sortCode3) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode3:tb", sortCode3);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtSortCode3:tb", sortCode3);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) account number: (.*)$")
    public void borrower_types_his_account_number(String userType, String currentOrSavings, String accountNumber) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtAccnumber:tb", accountNumber);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:txtAccnumber:tb", accountNumber);
                break;
        }
    }

//    @And("^(Borrower) types his (Current account|Savings account) provider: (.*)$")
//    public void borrower_types_his_account_provider(String userType, String currentOrSavings, String accountProvider) {
//        switch (currentOrSavings) {
//            case "Current account":
//                yourAccountsPage.typeCurrentAccountProvider(accountProvider);
//                break;
//            case "Savings account":
//                yourAccountsPage.typeSavingAccountProvider(accountProvider);
//                break;
//        }
//    }

    @And("^(Borrower) types his (Current account|Savings account) IBAN: (.*)")
    public void borrower_types_his_iban(String userType, String currentOrSavings, String iban) {
        switch (currentOrSavings) {
            case "Current account":
//                yourAccountsPage.typeCurrentIban(iban);
                break;
            case "Savings account":
//                yourAccountsPage.typeSavingIban(iban);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) account balance: (.*)$")
    public void borrower_types_his_account_balance(String userType, String currentOrSavings, String accountBalance) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountBalance:c:w:crbAccountBalance:tb", accountBalance);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccountBalance:c:w:crbAccountBalance:tb", accountBalance);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) overdraft limit: (.*)$")
    public void borrower_types_his_overdraft_limit(String userType, String currentOrSavings, String overdraftLimit) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlOverDraft:c:w:crbOverdraft:tb", overdraftLimit);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlOverDraft:c:w:crbOverdraft:tb", overdraftLimit);
                break;
        }
    }

    @And("^(Borrower) selects his (Current account|Savings account) source of savings: (Gift|Inheritance|Accident Claim|Redundancy|Income from Regular Savings|Other)")
    public void borrower_selects_his_source_of_saving(String userType, String currentOrSavings, String sourceOfSavings) {

/*
        <option selected="selected" value="">Choose One</option>
        <option value="G">Gift</option>
        <option value="INH">Inheritance</option>
        <option value="ACC">Accident Claim</option>
        <option value="RDN">Redundancy</option>
        <option value="IRS">Income from Regular Savings</option>
        <option value="OTH">Other</option>
*/

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
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", abbreviationSavingSource);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", abbreviationSavingSource);
                break;
        }
    }

    @And("^(Borrower) types his (Current account|Savings account) regular monthly saving: (.*)$")
    public void borrower_types_his_regular_monthly_saving(String userType, String currentOrSavings, String regularMonthlySaving) {
        switch (currentOrSavings) {
            case "Current account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlRegularMonthlySavings:c:w:crbRegularMonthlySavings:tb", regularMonthlySaving);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlRegularMonthlySavings:c:w:crbRegularMonthlySavings:tb", regularMonthlySaving);
                break;
        }
    }

    @When("^Borrower closes \"scraping\" form$")
    public void borrower_closes_scraping_form() throws IOException {
//        Document yourAccountDoc = Jsoup.parse(httpResponse.getHttpResponse());
//        TextNode textNodeYourAccount;
//        try {
//            textNodeYourAccount = yourAccountDoc.select("component[id~=form]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        } catch ( Exception e ) {
//            textNodeYourAccount = yourAccountDoc.select("component[id~=dialog]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        }
//        Document yourAccountDoc2 = Jsoup.parse(textNodeYourAccount.text());

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
}
