package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.model.AccountData;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.utils.enums.SAVING;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.junit.Assert.assertEquals;

//@Singleton
public class ApiYourAccountsStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiYourAccountsStepDef.class.getName());

    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    private IUser user;
    @Inject
    IBorrowerHttpResponse httpResponse;

    private boolean isThereAccountList = false;
//    private int stepTokenAddThisSource = 1;
//    private int stepTokenHiddenSubmit = 1;
    private String btnHiddenSubmitWicketInterface = StringUtils.EMPTY;
    private String btnHiddenRefreshWicketInterface = StringUtils.EMPTY;
    private String btnCloseWicketInterface = StringUtils.EMPTY;

//    @Inject
    public ApiYourAccountsStepDef(/*IHttpResponse httpResponse*/) {
        isThereAccountList = false;
//        this.httpResponse = httpResponse;
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
//                borrower_selects_his_source_of_saving(userType, formType, accountData.get("sourceOfSaving"));
//                if (!StringUtils.isEmpty(accountData.get("regularMonthlySaving")))
//                    borrower_types_his_regular_monthly_saving(userType, formType, accountData.get("regularMonthlySaving"));
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
            case "Account scraping":

                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("data", "{\"widgets\":[{\"widget\":\"pnlBasicInfo pnlYodleeIframe\",\"data\":{\"enable\":false}}]}");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("data", "{\"widgets\":[{\"widget\":\"pnlBasicInfo pnlYodleeIframe\",\"data\":{\"enable\":true}}]}");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("data", "{\"widgets\":[{\"widget\":\"pnlBasicInfo pnlYodleeProcess\",\"data\":{\"visible\":true},\"delta\":40,\"visibleEvent\":\"show\"},{\"widget\":\"pnlBasicInfo btnCancel\",\"data\":{\"visible\":false},\"visibleEvent\":\"hide\"},{\"widget\":\"pnlBasicInfo btnCancel\",\"data\":{\"enable\":false}},{\"widget\":\"pnlBasicInfo chkConditions\",\"data\":{\"visible\":false},\"visibleEvent\":\"hide\"},{\"widget\":\"pnlBasicInfo lblConditions\",\"data\":{\"visible\":false},\"visibleEvent\":\"hide\"},{\"widget\":\"pnlBasicInfo pnlYodleeProcess lblYodleeProcess\",\"delta\":12}]}");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );


                Pattern pYodlee = Pattern.compile("\\$\\.parseJSON\\(\\'\\{\\\"yodleeUrl\\\":\\\".*\\\",\\\"rsession\\\":\\\"([0-9a-z_:]+)\\\",\\\"finappId\\\":\\\"(\\d+)\\\",\\\"redirectReq\\\":\\\"true\\\",\\\"token\\\":\\\"([0-9a-z]+)\\\",\\\"extraParams\\\":\\\"(.*)\\\"\\}\\', true\\),");
                Matcher mYodlee = pYodlee.matcher(httpResponse.getHttpResponse());
                String rsession = null;
                String finappId = null;
                String token = null;
                String extraParams = null;
                while (mYodlee.find()) {
                    rsession = mYodlee.group(1);
                    finappId = mYodlee.group(2);
                    token = mYodlee.group(3);
                    extraParams = mYodlee.group(4);
                }
                final String finalRSession = rsession;
                final String finalFinappId = finappId;
                final String finalToken = token;
                final String finalExtraParams = "isOLB=true&callback=" + URLEncoder.encode(extraParams, "UTF-8");

//                https://node.developer.yodlee.com/finapp/10003600/?brand=10010352&id=10003600&appId=3A4CAE9B71A1CCD7FF41F51006E9ED00&channelId=-1&version=9.18&status=published&c=csit_key_0:ICzhZehpUKYKjfUe3m3Mu5WqoFk=&finappCDNURL=&resturl=https%3A%2F%2F172.17.25.88%2Fservices%2Fsrest%2Frestserver&l=&isOLB=true&callback=http%3A%2F%2Fdv2app.opoqodev.com%2Fstable-borrower%2Fother%2Fyodlee.html
                HttpClient yodleeClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
                HttpClientContext yodleeContext = HttpClientContext.create();

                requestHttpPost(
                        yodleeClient,
                        "https://node.developer.yodlee.com/authenticate/restserver/",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("rsession", finalRSession);
                                put("finappId", finalFinappId);
                                put("redirectReq", "true");
                                put("token", finalToken);
                                put("extraParams", finalExtraParams);
                            }
                        },
                        yodleeContext,
                        CONSUME_QUIETLY
                );


                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("data", "{\"widgets\":[{\"widget\":\"pnlBasicInfo pnlYodleeProcess\",\"data\":{\"visible\":false},\"delta\":-42,\"visibleEvent\":\"hide\"}]}");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );



                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("root:c:w:pnlBasicInfo:c:w:chkConditions:checkbox", "on");
                                put("root:c:w:pnlBasicInfo:c:w:pnlYodleeIframe:data", "");
                                put("stepToken","1");
                                put("root:c:w:btnHiddenSubmit:submit","1");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::IFormChangeListener:2:-1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("data", "{\"widgets\":[{\"widget\":\"pnlBasicInfo pnlYodleeProcess lblYodleeReceiving\",\"delta\":12}]}");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog::ILazyCallListener:1:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("data", "{\"actionName\":\"instantNotificationHandleCall\",\"id\":\"\",\"triggerWidgetPath\":\"\"}");
                                put("ignoreve", "false");
                                put("ignorerve", "false");
                                put("ready","false");
                                put("callbackId","");

                                /*
                                data:{"actionName":"instantNotificationHandleCall","id":"4|IMLrNCYVO($XRT","triggerWidgetPath":""} y0\\PEI)lM[6^{sn5 2=!N}P0oWqV`zC8=
                                ignoreve:false
                                ignorerve:false
                                ready:false
                                callbackId:RpdPciz CpOnMaWopF NixTRygq
                                */
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                requestHttpGet(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlBasicInfo:c:w:hbxScraping:c:i:w:btnContinue:cancel::IBehaviorListener:0:&stepToken=2",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                requestHttpGet(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoAccount:c:w:lnkAuto:close::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

                requestHttpPost(
                        httpClient,
                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/xml");
                                put("Content-Type", "application/x-www-form-urlencoded");
                            }
                        },
                        new LinkedHashMap<String, String>(){
                            {
                                put("stepToken", "5");
                                put("root:c:w:btnHiddenSubmit:submit", "1");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );

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
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlAccountList:c:w:btnAdd:dialog::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>(){},
                localContext.getHttpContext(),
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
        String btnAddThisSource = currentFormDoc2.select("div[id~=btnAddThisSource][data-path~=btnAddThisSource]").select("a[id~=submit]").select("a[wicketpath~=btnAddThisSource").attr("onclick");
        Pattern pBtnAddThisSource = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnAddThisSource = pBtnAddThisSource.matcher(btnAddThisSource);
        String btnAddThisSourceWicketInterface = StringUtils.EMPTY;
        while( mBtnAddThisSource.find() ) {
            btnAddThisSourceWicketInterface = mBtnAddThisSource.group(1);
        }

//        accountParameters.put("root:c:w:txtId:tb", "");
        finalAccountParameters.put("root:c:w:txtId:tb", "");
//        accountParameters.put("stepToken", stepToken);
        finalAccountParameters.put("stepToken", stepToken);
//        accountParameters.put("root:c:w:pnlAddSource:c:w:btnAddThisSource:submit", "1");
        finalAccountParameters.put("root:c:w:pnlAddSource:c:w:btnAddThisSource:submit", "1");

        requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlAddSource:c:w:btnAddThisSource:submit::IBehaviorListener:0:-1",
                System.getProperty("borrower.url") + "/form.2?" + btnAddThisSourceWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
//                accountParameters,
                finalAccountParameters,
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );


        Document currentClose = Jsoup.parse(currentFormDoc.select("component[id~=close]").select("component[encoding~=wicket]").text());
        Pattern pClose = Pattern.compile("\\?(wicket:interface=.*:)'");
        Matcher mClose = null;
        String linkClose = StringUtils.EMPTY;
        switch(accountType) { // BUG Internal CLV Framework ?!
            case "Current account":
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoAccount:c:w:lnkCurrent:close::IBehaviorListener:0:-1";
                mClose = pClose.matcher(currentClose.select("a[id~=close]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoAccount_c_w_lnkCurrent_close]").attr("onclick"));
                while ( mClose.find() ) {
                    linkClose = mClose.group(1);
                }
                break;
            case "Savings account":
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoAccount:c:w:lnkSavings:close::IBehaviorListener:0:-1";
                mClose = pClose.matcher(currentClose.select("a[id~=close]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoAccount_c_w_lnkSavings_close]").attr("onclick"));
                while ( mClose.find() ) {
                    linkClose = mClose.group(1);
                }
                break;
            case "Scrapping":
//                :main:c:form:dialogWrapper:dialog:form:root:c:w:pnl-608:c:w:btnClose:cancel::IBehaviorListener:0:
                linkClose = ":1:main:c:form:form:root:c:w:pnlNoAccount:c:w:lnkAuto:close::IBehaviorListener:0:-1";
                mClose = pClose.matcher(currentClose.select("a[id~=close]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoAccount_c_w_lnkAuto_close]").attr("onclick"));
                while ( mClose.find() ) {
                    linkClose = mClose.group(1);
                }
                break;
            default:
        }

        if ( isThereAccountList ) {
            linkClose = ":1:main:c:form:form:root:c:w:pnlAccountList:c:w:btnAdd:close::IBehaviorListener:0:-1";
            linkClose = btnCloseWicketInterface;
        }

        requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=" + linkClose,
                System.getProperty("borrower.url") + "/form.2?" + linkClose,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        if ( isThereAccountList ) {
//            String finalStepToken =  String.valueOf(stepTokenHiddenSubmit+1);
            String responseHiddenThisSource = requestHttpPost(
                    httpClient,
//                    System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenRefresh:submit::IBehaviorListener:0:-1",
                    System.getProperty("borrower.url") + "/form.2?" + btnHiddenRefreshWicketInterface,
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
                    localContext.getHttpContext(),
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
//                    System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:-1",
                    System.getProperty("borrower.url") + "/form.2?" + btnHiddenSubmitWicketInterface,
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
                    localContext.getHttpContext(),
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
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlButtons:c:w:btnNext:cancel::IBehaviorListener:0:&stepToken=1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext.getHttpContext(),
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
        String btnImDone = currentFormDoc2.select("a[id~=submit]").select("a[wicketpath=main_c_form_form_root_c_w_pnlAccountList_c_w_btnImDone_submit]").attr("onclick");
        Pattern pBtnImDone = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnImDone = pBtnImDone.matcher(btnImDone);
        String imDoneWicketInterface =StringUtils.EMPTY;
        while(mBtnImDone.find()) {
            imDoneWicketInterface = mBtnImDone.group(1);
        }

        String yourAccountPageResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlAccountList:c:w:btnImDone:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + imDoneWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", stepToken); // TODO extract stepToken should be 3
                        put("root:c:w:pnlAccountList:c:w:btnImDone:submit", "1");
                    }
                },
                localContext.getHttpContext(),
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
        String currentComponentId = StringUtils.EMPTY;
        for (String aComponentId : componentId) {
            try {
                accountDoc2 = Jsoup.parse(accountDoc.select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                log.info("is " + aComponentId);
                currentComponentId = aComponentId;
                if ( !aComponentId.equals("main") )
                    isThereAccountList = true;
                break;
            } catch (NullPointerException npe) {
                log.info("isnot " + aComponentId);
            }
        }

//        if ( currentComponentId.equals("main") ) {
            if ( !isThereAccountList ) {
                String onclickBtnHiddenSubmit = accountDoc2.select("a[id~=submit]").select("a[wicketpath~=btnHiddenSubmit]").attr("onclick");
                Pattern pBtnHiddenSubmit = Pattern.compile("\\?(wicket:interface=.*)&");
                Matcher mBtnHiddenSubmit = pBtnHiddenSubmit.matcher(onclickBtnHiddenSubmit);
                while (mBtnHiddenSubmit.find()) {
                    btnHiddenSubmitWicketInterface = mBtnHiddenSubmit.group(1);
                }
            }
            else {
                String onclickBtnHiddenRefresh = accountDoc2.select("a[id~=submit]").select("a[wicketpath~=btnHiddenRefresh]").attr("onclick");
                Pattern pBtnHiddenRefresh = Pattern.compile("\\?(wicket:interface=.*)&");
                Matcher mBtnHiddenRefresh = pBtnHiddenRefresh.matcher(onclickBtnHiddenRefresh);
                while(mBtnHiddenRefresh.find()) {
                    btnHiddenRefreshWicketInterface = mBtnHiddenRefresh.group(1);
                }

                String onclickBtnClose = accountDoc2.select("a[wicketpath~=main_c_form_form_root_c_w_pnlAccountList_c_w_btnAdd_close]").attr("onclick");
                Pattern pBtnClose = Pattern.compile("\\?(wicket:interface=.*)&");
                Matcher mBtnClose = pBtnClose.matcher(onclickBtnClose);
                while(mBtnClose.find()) {
                    btnCloseWicketInterface = mBtnClose.group(1);
                }
            }
//        }

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
            Elements divAccountTypeAddElements = accountDoc2.select("div[data-path=pnlAccountList btnAdd]");
            for (Element current : divAccountTypeAddElements) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath=main_c_form_form_root_c_w_pnlAccountList_c_w_btnAdd_dialog]").attr("onclick");
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
            Elements divAccountTypeAddElements2 = accountDoc2.select("div[data-path~=pnlNoAccount").select("div[data-path~=lnk" + finalFixCategory + "]");
            for (Element current : divAccountTypeAddElements2) {
//                String currentKey = current.attr("data-path").split(" ")[1];
                String currentOnClick = current.select("a[wicketpath~=main_c_form_form_root_c_w_pnlNoAccount_c_w_").select("a[wicketpath~=lnk" + finalFixCategory + "_dialog]").attr("onclick");
                Pattern pWicketInterface = Pattern.compile("\\?wicket:interface=(.*)&");
                Matcher mWicketInterface = pWicketInterface.matcher(currentOnClick);
                String currentWicketInterface = null;
                while (mWicketInterface.find()) {
                    currentWicketInterface = mWicketInterface.group(1);
                }
//                wicketInterfaceMap.put(currentKey, currentWicketInterface);
                linkAdd = currentWicketInterface;
            }
//            isThereAccountList = true;
        }
        final String finalLinkAdd = linkAdd;

        Map<String, String> linkAddParameters = new LinkedHashMap<>();
        if ( isThereAccountList ) {
            String stepToken = accountDoc2.select("input[name=stepToken").attr("value");
            linkAddParameters.put("stepToken", stepToken);
        }

        String accountLinkAddResponse = requestHttpPost(
                httpClient,
//                        System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAddPaye:dialog::IBehaviorListener:0:",
//                        System.getProperty("borrower.url") + "/form.2?wicket:interface=" + wicketInterfaceMap.get("lnkAdd" + finalFixCategory),
                System.getProperty("borrower.url") + "/form.2?wicket:interface=" + finalLinkAdd,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                linkAddParameters,
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(accountLinkAddResponse);

        String btnClose = Jsoup.parse(Jsoup.parse(accountLinkAddResponse).select("component[id~=close]").select("component[encoding~=wicket]").text()).select("a[wicketpath=main_c_form_form_root_c_w_pnlAccountList_c_w_btnAdd_close]").attr("onclick");
        Pattern pBtnClose = Pattern.compile("\\?(wicket:interface=.*:0:)'");
        Matcher mBtnClose = pBtnClose.matcher(btnClose);

        while ( mBtnClose.find() )
            btnCloseWicketInterface = mBtnClose.group(1);

        String linkSubmitResponse;
        switch ( fixCategory ) {
            case "Current":

                if ( isThereAccountList ) {

                    String addCurrentAccount = Jsoup.parse(Jsoup.parse(accountLinkAddResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[wicketpath=main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoAccount_c_w_lnkCurrent_submit]").attr("onclick");
                    Pattern pAddCurrentAccount = Pattern.compile("\\?(wicket:interface=.*)&");
                    Matcher mAddCurrentAccount = pAddCurrentAccount.matcher(addCurrentAccount);

                    String addCurrentAccountWicketInterface = null;
                    while ( mAddCurrentAccount.find() ) {
                        addCurrentAccountWicketInterface = mAddCurrentAccount.group(1);
                    }

                    linkSubmitResponse = requestHttpPost(
                            httpClient,
//                            System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoAccount:c:w:lnkCurrent:submit::IBehaviorListener:0:",
                            System.getProperty("borrower.url") + "/form.2?" + addCurrentAccountWicketInterface,
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoAccount:c:w:lnkCurrent:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(linkSubmitResponse);
                }

                break;
            case "Savings":

                if ( isThereAccountList ) {

                    String addCurrentSavings = Jsoup.parse(Jsoup.parse(accountLinkAddResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[wicketpath=main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoAccount_c_w_lnkSavings_submit]").attr("onclick");
                    Pattern pAddCurrentSavings = Pattern.compile("\\?(wicket:interface=.*)&");
                    Matcher mAddCurrentSavings = pAddCurrentSavings.matcher(addCurrentSavings);

                    String addCurrentSavingsWicketInterface = null;
                    while ( mAddCurrentSavings.find() ) {
                        addCurrentSavingsWicketInterface = mAddCurrentSavings.group(1);
                    }

                    linkSubmitResponse = requestHttpPost(
                            httpClient,
//                            System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoEmplyments:c:w:lnkCurrent:submit::IBehaviorListener:0:",
//                            System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoAccount:c:w:lnkSavings:submit::IBehaviorListener:0:",
                            System.getProperty("borrower.url") + "/form.2?" + addCurrentSavingsWicketInterface,
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoAccount:c:w:lnkCurrent:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
                            CONSUME_QUIETLY
                    );
                    httpResponse.setHttpResponse(linkSubmitResponse);
                }

                break;
            case "Auto":

                if ( isThereAccountList ) {

                    String addAuto = Jsoup.parse(Jsoup.parse(accountLinkAddResponse).select("component[id~=dialog]").select("component[encoding~=wicket]").text()).select("a[wicketpath=main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoAccount_c_w_lnkAuto_submit]").attr("onclick");
                    Pattern pAddAuto = Pattern.compile("\\?(wicket:interface=.*)&");
                    Matcher mAddAuto = pAddAuto.matcher(addAuto);

                    String addAutoWicketInterface = null;
                    while ( mAddAuto.find() ) {
                        addAutoWicketInterface = mAddAuto.group(1);
                    }

                    linkSubmitResponse = requestHttpPost(
                            httpClient,
//                            System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnlNoAccount:c:w:lnkAuto:submit::IBehaviorListener:0:",
                            System.getProperty("borrower.url") + "/form.2?" + addAutoWicketInterface,
                            new LinkedHashMap<String, String>() {
                                {
                                    put("Accept", "text/xml");
                                    put("Content-Type", "application/x-www-form-urlencoded");
                                }
                            },
                            new LinkedHashMap<String, String>() {
                                {
                                    put("stepToken", "1");
                                    put("root:c:w:pnlNoAccount:c:w:lnkAuto:submit", "1");
                                }
                            },
                            localContext.getHttpContext(),
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
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:pnlAccNum:c:w:txtAccnumber:tb", accountNumber);
                break;
            case "Savings account":
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlAccNumb:c:w:pnlAccNum:c:w:txtAccnumber:tb", accountNumber);
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
/*
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
*/

        switch (currentOrSavings) {
            case "Current account":
//                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", abbreviationSavingSource);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", SAVING.getShortValueByLongValue(sourceOfSavings));
                break;
            case "Savings account":
//                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", abbreviationSavingSource);
                accountParameters.put("root:c:w:pnlAddSource:c:w:pnlSourceOfSavings:c:w:cmbSourceOfSavings:combobox", SAVING.getShortValueByLongValue(sourceOfSavings));
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
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:dialogWrapper:dialog:form:root:c:w:pnl-608:c:w:btnClose:cancel::IBehaviorListener:0&stepToken=1",
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlAccountList:c:w:btnImDone:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/xml");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

//        requestHttpGet(
//                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:lnkAuto:close::IBehaviorListener:0:",
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
