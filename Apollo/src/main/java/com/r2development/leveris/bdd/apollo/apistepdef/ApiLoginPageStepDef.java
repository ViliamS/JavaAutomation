package com.r2development.leveris.bdd.apollo.apistepdef;

import com.google.inject.Singleton;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;

@Singleton
public class ApiLoginPageStepDef extends ApiOpoqoApolloStepDef {

    private static final Log log = LogFactory.getLog(ApiLoginPageStepDef.class);

//    private HttpClient httpClient;
//    private HttpContext localContext;
//    private IHttpResponse httpResponse;
//    private IUser user;

//    @Inject
//    public ApiLoginPageStepDef(HttpClient httpClient, HttpContext localContext, IUser user, IHttpResponse httpResponse) {
//        this.httpClient = httpClient;
//        this.localContext = localContext;
//        this.user = user;
//        this.httpResponse = httpResponse;
//        loginParameters = new LinkedHashMap<>();
//    }

    @Given("^User types his email login (.*) in Login page$")
    public void user_types_his_login(String email) {
//        loginParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", email);
    }

    @Given("^User types his pwd (.*) in Login page$")
    public void user_types_his_pwd(String pwd) {
//        loginParameters.put("root:c:w:pnlMain:c:w:pwdPassword:tb", pwd);
    }

    @When("^user logs in$")
    public void user_logs_in() throws IOException {

//        String currentHttpResponse = httpResponse.getHttpResponse();
//
//        Document loginResponseDoc = Jsoup.parse(currentHttpResponse);
//        TextNode textNodeLoginResponseDoc = loginResponseDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document loginResponseDoc2 = Jsoup.parse(textNodeLoginResponseDoc.text());
////        Elements panelTasksHidden = loginResponseDoc2.select("div[wicketpath=main_c_form_form_root_c_w_btnTasksHidden]");
//        String stepToken = loginResponseDoc2.select("input[name=stepToken]").attr("value");
//
//        loginParameters.put("stepToken", stepToken);
//        loginParameters.put("root:c:w:pnlMain:c:w:btnLogin:submit", "1");
//
//        requestHttpPost(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                        put("Content-Type", "application/x-www-form-urlencoded");
//                    }
//                },
//                loginParameters,
//                localContext,
//                CONSUME_QUIETLY
//        );

    }

    @When("^user logs in with these credentials$")
    public void user_logs_in_with_these_credentials(List<String> credentials) throws IOException {

//        String loginPageResponse = requestHttpGet(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:1:link::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );
//
//        httpResponse.setHttpResponse(loginPageResponse);
//
//        LoginData loginData = new LoginData(credentials);
//
//        user_types_his_login(loginData.get("email"));
//        user_types_his_pwd(loginData.get("pwd"));
//
//        if ( StringUtils.isEmpty(httpResponse.getHttpResponse())) {
//            loginParameters.put("stepToken", "1");
//        }
//        else {
//            String currentHttpResponse = httpResponse.getHttpResponse();
//            Document loginResponseDoc = Jsoup.parse(currentHttpResponse);
//            TextNode textNodeLoginResponseDoc = loginResponseDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
//            Document loginResponseDoc2 = Jsoup.parse(textNodeLoginResponseDoc.text());
////        Elements panelTasksHidden = loginResponseDoc2.select("div[wicketpath=main_c_form_form_root_c_w_btnTasksHidden]");
//            String stepToken = loginResponseDoc2.select("input[name=stepToken]").attr("value");
//            loginParameters.put("stepToken", stepToken);
//        }
//        loginParameters.put("root:c:w:pnlMain:c:w:btnLogin:submit", "1");
//
//        requestHttpPost(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                        put("Content-Type", "application/x-www-form-urlencoded");
//                    }
//                },
//                loginParameters,
//                localContext,
//                CONSUME_QUIETLY
//        );

    }

    @When("^user forgets his password$")
    public void user_forgets_his_password() {
    }

    @When("^user closes the login page")
    public void user_closes_the_login_page() {
    }

    @When("^user wants to (show|hide) his password in Login page$")
    public void user_wants_to_his_password(String showOrHide) {
    }

    @Then("^Home Borrower Page is loaded$")
    public void home_borrower_page_is_loaded() {
    }

    @And("^user logs in as his account is activated$")
    public void user_logs_in_as_his_account_is_activated() throws Exception {

//        activateAccount(user.getEmail());
//
//        Assert.assertNotEquals("Should be different HttpClientContext object", localContext, initContext());
//        HttpContext newLocalContext = newHttpClientContext(System.getProperty("domain"), "/stable-borrower");
//        Assert.assertEquals("not same HttpClientContext object", newLocalContext, localContext);
//
////        CookieStore cookieStore = new BasicCookieStore();
////        HttpClientContext localContextBody = HttpClientContext.create();
////        BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
////        cookieScUnload.setDomain(System.getProperty("domain"));
////        cookieScUnload.setPath("/stable-borrower");
////        cookieStore.addCookie(cookieScUnload);
////        localContextBody.setCookieStore(cookieStore);
////        localContext = localContextBody;
//
////        localContext = BorrowerDependenciesModule.getNewLocalContext();
//
//        requestHttpGet(
//                httpClient,
//                System.getProperty("borrower") + "/home",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );
//
//        String loginPageResponse = requestHttpGet(
//                httpClient,
//                System.getProperty("borrower") + "/form.2?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:1:link::IBehaviorListener:0:",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                    }
//                },
//                localContext,
//                CONSUME_QUIETLY
//        );
//
//        httpResponse.setHttpResponse(loginPageResponse);
//
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

}
