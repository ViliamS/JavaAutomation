package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.LoginData;
import com.r2development.leveris.di.IHttpResponse;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.qa.utils.Orasql;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.hamcrest.core.Is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Singleton
public class ApiLoginPageStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiLoginPageStepDef.class);

//    private HttpClient httpClient;
//    private HttpContext localContext;

    @Inject
    private IHttpResponse httpResponse;

    @Inject
    private IUser user;

//    @Inject
//    public ApiLoginPageStepDef(HttpClient httpClient, HttpContext localContext, IUser user, IHttpResponse httpResponse) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//        this.user = user;
//        this.httpResponse = httpResponse;
//        loginParameters = new LinkedHashMap<>();
//    }

    public ApiLoginPageStepDef() {
        super();
    }

    @Inject
    public ApiLoginPageStepDef(IUser user, IHttpResponse httpResponse) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
        this.user = user;
        this.httpResponse = httpResponse;
//        loginParameters = new LinkedHashMap<>();
    }


    @Given("^Borrower User types his email login (.*) in Login page$")
    public void user_types_his_login(String email) {
        loginParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", email);
    }

    @Given("^Borrower User types his pwd (.*) in Login page$")
    public void user_types_his_pwd(String pwd) {
        loginParameters.put("root:c:w:pnlMain:c:w:pwdPassword:tb", pwd);
    }

    @When("^Borrower user logs in$")
    public void user_logs_in() throws IOException {

        String currentHttpResponse = httpResponse.getHttpResponse();

        Document loginResponseDoc = Jsoup.parse(currentHttpResponse);
        TextNode textNodeLoginResponseDoc = loginResponseDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
        Document loginResponseDoc2 = Jsoup.parse(textNodeLoginResponseDoc.text());
//        Elements panelTasksHidden = loginResponseDoc2.select("div[wicketpath=main_c_form_form_root_c_w_btnTasksHidden]");
        String stepToken = loginResponseDoc2.select("input[name=stepToken]").attr("value");

        loginParameters.put("stepToken", stepToken);
        loginParameters.put("root:c:w:pnlMain:c:w:btnLogin:submit", "1");

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                loginParameters,
                localContext,
                CONSUME_QUIETLY
        );
    }

    @When("^Borrower user logs in with these credentials$")
    public void user_logs_in_with_these_credentials(List<String> credentials) throws IOException {

        String loginPageResponse = requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:1:link::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        httpResponse.setHttpResponse(loginPageResponse);

        LoginData loginData = new LoginData(credentials);

        user_types_his_login(loginData.get("email"));
        user_types_his_pwd(loginData.get("pwd"));

        if ( StringUtils.isEmpty(httpResponse.getHttpResponse())) {
            loginParameters.put("stepToken", "1");
        }
        else {
            String currentHttpResponse = httpResponse.getHttpResponse();
            Document loginResponseDoc = Jsoup.parse(currentHttpResponse);
            TextNode textNodeLoginResponseDoc = loginResponseDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
            Document loginResponseDoc2 = Jsoup.parse(textNodeLoginResponseDoc.text());
//        Elements panelTasksHidden = loginResponseDoc2.select("div[wicketpath=main_c_form_form_root_c_w_btnTasksHidden]");
            String stepToken = loginResponseDoc2.select("input[name=stepToken]").attr("value");
            loginParameters.put("stepToken", stepToken);
        }
        loginParameters.put("root:c:w:pnlMain:c:w:btnLogin:submit", "1");

        requestHttpPost(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                loginParameters,
                localContext,
                CONSUME_QUIETLY
        );
    }

    @When("^Borrower forgets his password$")
    public void user_forgets_his_password() {
    }

    @When("^Borrower closes the login page")
    public void user_closes_the_login_page() {
    }

    @When("^Borrower wants to (show|hide) his password in Login page$")
    public void user_wants_to_his_password(String showOrHide) {
    }

    @Then("^Home Borrower Page is loaded$")
    public void home_borrower_page_is_loaded() {
    }

    @And("^Borrower logs in as his account is activated$")
    public void user_logs_in_as_his_account_is_activated() throws Exception {

//        activateAccount("db", user.getEmail());

        user.setEmail("test.automation.api123456789@finfactory.com");
        user.setPwd("Password1122+");

        Assert.assertNotEquals("Should be different HttpClientContext object", localContext, initContext());
        HttpContext newLocalContext = newHttpClientContext(System.getProperty("domain.borrower"), "/stable-borrower");
        Assert.assertEquals("not same HttpClientContext object", newLocalContext, localContext);

//        CookieStore cookieStore = new BasicCookieStore();
//        HttpClientContext localContextBody = HttpClientContext.create();
//        BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
//        cookieScUnload.setDomain(System.getProperty("domain"));
//        cookieScUnload.setPath("/stable-borrower");
//        cookieStore.addCookie(cookieScUnload);
//        localContextBody.setCookieStore(cookieStore);
//        localContext = localContextBody;

//        localContext = BorrowerDependenciesModule.getNewLocalContext();

        requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/home",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        String loginPageResponse = requestHttpGet(
                httpClient,
                System.getProperty("borrower") + "/form.2?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:1:link::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );

        httpResponse.setHttpResponse(loginPageResponse);

        requestHttpGet(
            httpClient,
            "http://dv2pub.opoqodev.com/",
            new LinkedHashMap<String, String>() {
                {
                    put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    put("Referer", "http://dv2app.opoqodev.com/stable-borrower/form.1?sc=1");
                    put("Upgrade-Insecure-Requests", "1");
                }
            },
            localContext,
            CONSUME_QUIETLY
        );

        requestHttpGet(
                httpClient,
                "http://dv2pub.opoqodev.com/",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Referer", "http://dv2app.opoqodev.com/stable-borrower/form.1?sc=1");
                        put("Upgrade-Insecure-Requests", "1");
                        put("Cookie", "testcookie");
                    }
                },
                localContext,
                CONSUME_QUIETLY
        );


        WebSocketClient wsc = new WebSocketClient();
//        wsc. = this;
        wsc.Connect("wss://dv2pub.opoqodev.com/pull/wicket-wicket-0" );
//        wsc.Connect("wss://dv2pub.opoqodev.com/service");
        Thread.sleep(1000);
//        wsc.userSession
//        wsc.Disconnect();

        // Step 1 - SSO
        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://dv2pub.opoqodev.com/proxy/router/api/public/auth/validateAuthProcessStep");
        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep.setHeader("Referer", "https://dv2pub.opoqodev.com/");
        httpPostValidateAuthProcessStep.setHeader("Cookie", "testcookie");
//        StringEntity seValidateAuthProcessStep = new StringEntity("{\"scenarioCode\":\"USR_PWD\",\"authProcessStepValues\":[{\"authDetailType\":\"USERNAME\",\"value\":\"anthony.mottot@finfactory.com\"},{\"authDetailType\":\"PWD\",\"value\":\"autPassword1122+\"}]}");
        StringEntity seValidateAuthProcessStep = new StringEntity("{\"scenarioCode\":\"USR_PWD\",\"authProcessStepValues\":[{\"authDetailType\":\"USERNAME\",\"value\":\"" + user.getEmail() + "\"},{\"authDetailType\":\"PWD\",\"value\":\"" + user.getPwd() + "\"}]}");
        seValidateAuthProcessStep.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep.setEntity(seValidateAuthProcessStep);
        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext);
        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
        log.info("==== httpPostValidateAuthProcessStep ====");
        String parse2jsonValidateAuthProcessStep = EntityUtils.toString(httpEntityValidateAuthProcessStep);
        log.info(parse2jsonValidateAuthProcessStep);

        JsonParser jsonParserValidateAuthProcessStep = new JsonParser();
        JsonObject jsonObjectValidateAuthProcessSte = (JsonObject) jsonParserValidateAuthProcessStep.parse(parse2jsonValidateAuthProcessStep);

        String idScenario = jsonObjectValidateAuthProcessSte.get("idScenario").getAsString();
        log.info("idScenario: " + idScenario);

        // Step 2 - SSO
        HttpPost httpPostGenerateServiceTicket = new HttpPost("https://dv2pub.opoqodev.com/proxy/router/api/public/ticket/generateServiceTicket");
        httpPostGenerateServiceTicket.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostGenerateServiceTicket.setHeader("Referer", "https://dv2pub.opoqodev.com/");
        httpPostGenerateServiceTicket.setHeader("Cookie", "testcookie");
        StringEntity seGenerateServiceTicket = new StringEntity("{\"idAuthProcess\":\"" + idScenario + "\"}");
        seGenerateServiceTicket.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostGenerateServiceTicket.setEntity(seGenerateServiceTicket);
        HttpResponse responseGenerateServiceTicket = httpClient.execute(httpPostGenerateServiceTicket, localContext);
        HttpEntity httpEntityGenerateServiceTicket = responseGenerateServiceTicket.getEntity();
        log.info("==== httpEntityGenerateServiceTicket ====");
        String parse2jsonGenerateServiceTicket = EntityUtils.toString(httpEntityGenerateServiceTicket);
        log.info(parse2jsonGenerateServiceTicket);

        JsonParser jsonParserGenerateServiceTicket = new JsonParser();
        JsonObject jsonObjectGenerateServiceTicket = (JsonObject) jsonParserGenerateServiceTicket.parse(parse2jsonGenerateServiceTicket);

        String serviceTicketCode = jsonObjectGenerateServiceTicket.get("serviceTicketCode").getAsString();
        log.info("serviceTicketCode: " + serviceTicketCode);
        String applicationCode = jsonObjectGenerateServiceTicket.get("applicationCode").getAsString();
        log.info("applicationCode <=> applicationid: " + applicationCode);

//        String channeluuid = RandomStringUtils.random(8, true, true) + "-" + RandomStringUtils.random(4, true, true) + "-" + RandomStringUtils.random(4, true, false) + "-" + RandomStringUtils.random(4, true, false) + "-" + RandomStringUtils.random(12, true, true);
//        System.out.println("channeluuid: " + xrsf_token);


        HttpPost httpPostIssueToken = new HttpPost("https://dv2pub.opoqodev.com/api/issueToken");
        httpPostIssueToken.setHeader("accept", "application/json");
        httpPostIssueToken.setHeader("applicationid", applicationCode);
//        httpPostIssueToken.setHeader("channeluuid", "8114a4af-1b81-4698-8298-183edc1023c8");
//        httpPostIssueToken.setHeader("channeluuid", "8114a4af-1b81-4698-8298-183edc1023c8");
        httpPostIssueToken.setHeader("channeluuid", "wicket-wicket-0");
        httpPostIssueToken.setHeader("Referer", "https://dv2pub.opoqodev.com");
        httpPostIssueToken.setHeader("Cookie", "testcookie");

        StringEntity sePostIssueToken = new StringEntity(serviceTicketCode);
        sePostIssueToken.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "text/plain"));
        httpPostIssueToken.setEntity(sePostIssueToken);

        HttpResponse responseIssueToken = httpClient.execute(httpPostIssueToken, localContext);
        HttpEntity httpEntityIssueToken = responseIssueToken.getEntity();
        log.info("==== httpEntityIssueToken ====");
        String parse2jsonIssueToken = EntityUtils.toString(httpEntityIssueToken);
        log.info(parse2jsonIssueToken);

        JsonParser jsonParserIssueToken = new JsonParser();
        JsonObject jsonObjectIssueToken = (JsonObject) jsonParserIssueToken.parse(parse2jsonIssueToken);

        String token = jsonObjectIssueToken.get("token").getAsString();
        log.info("TICKET: " + token);


        HttpGet httpGetApiModuleWithBearer = new HttpGet("https://dv2pub.opoqodev.com/api/modules");
        httpGetApiModuleWithBearer.setHeader("Accept", "*/*");
        httpGetApiModuleWithBearer.setHeader("authorization", "Bearer " + token);
        httpGetApiModuleWithBearer.setHeader("Cookie", "testcookie");
        HttpResponse responseGetApiModuleWithBearer = httpClient.execute(httpGetApiModuleWithBearer, localContext);
        HttpEntity httpEntityGetApiModuleWithBearer = responseGetApiModuleWithBearer.getEntity();
        log.info("==== httpEntityGetApiModuleWithBearer ====");
        String parse2jsonGetApiModuleWithBearer = EntityUtils.toString(httpEntityGetApiModuleWithBearer);
        log.info(parse2jsonGetApiModuleWithBearer);


        HttpGet httpGetApiAuthentication = new HttpGet("http://dv2app.opoqodev.com/stable-borrower/home?useCase=authenticate&ticket="+ serviceTicketCode);
        HttpResponse responseGetApiAuthentication = httpClient.execute(httpGetApiAuthentication, localContext);
        HttpEntity httpEntityGetApiAuthentication = responseGetApiAuthentication.getEntity();
        log.info("==== httpEntityGetApiAuthentication ====");
        String parse2jsonGetApiAuthenticationr = EntityUtils.toString(httpEntityGetApiAuthentication);
        log.info(parse2jsonGetApiAuthenticationr);

        httpResponse.setHttpResponse(parse2jsonGetApiAuthenticationr);

//        Thread.sleep(1000); // ??? without that we have white page
//        log.info("Email : " + user.getEmail());
//        user_types_his_login(user.getEmail());
//        Thread.sleep(1000); // ??? without that we have white page
//        log.info("Pwd : " + user.getPwd());
//        user_types_his_pwd(user.getPwd());
//        Thread.sleep(1000); // ??? without that we have white page
//        user_logs_in();
//        Thread.sleep(1000); // ??? without that we have white page
    }

    // TODO ACMESQL or use multi git jenkins plugin then to be able to load
    private void activateAccount(String activationMode, String emailAsUserLoginId) throws Exception {

        switch (activationMode) {
            case "db":
                //noinspection ConstantConditions
                File file = new File(ApiLoginPageStepDef.class.getClassLoader().getResource("tnsnames.ora").toURI());
                assertThat("File should exist", file.exists(), Is.is(true));
                System.setProperty("oracle.net.tns_admin", file.getParentFile().getAbsolutePath());

                if (StringUtils.isEmpty(System.getProperty("database")))
                    System.setProperty("database", "jdbc:oracle:thin:@DV2000.LEVERIS");

                Orasql.executeSqlUpdateQuery(System.getProperty("database"), "stable_pxmchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + user.getEmail() + "'");

                break;
            case "mdg":


                break;

            default:
                log.error("Huston ! we have a problem. We don't know which activationMode we should use.");
        }

    }

}
