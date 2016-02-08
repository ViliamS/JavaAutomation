package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.qa.utils.Orasql;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.protocol.HttpClientContext;
import org.hamcrest.core.Is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Singleton
public class ApiLoginPageStepDef extends ApiAbakusBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiLoginPageStepDef.class);

    @Given("^User types his email login (.*) in Login page$")
    public void user_types_his_login(String email) {
        loginParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", email);
    }

    @Given("^User types his pwd (.*) in Login page$")
    public void user_types_his_pwd(String pwd) {
        loginParameters.put("root:c:w:pnlMain:c:w:pwdPassword:tb", pwd);
    }

    @When("^user logs in$")
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

        activateAccount(user.getEmail());

        Assert.assertNotEquals("Should be different HttpClientContext object", localContext, initContext());
        HttpClientContext newLocalContext = newHttpClientContext(System.getProperty("domain"), "/borrower");
        Assert.assertEquals("not same HttpClientContext object", newLocalContext, localContext);
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

        Thread.sleep(1000); // ??? without that we have white page
        log.info("Email : " + user.getEmail());
        user_types_his_login(user.getEmail());
        Thread.sleep(1000); // ??? without that we have white page
        log.info("Pwd : " + user.getPwd());
        user_types_his_pwd(user.getPwd());
        Thread.sleep(1000); // ??? without that we have white page
        user_logs_in();
        Thread.sleep(1000); // ??? without that we have white page
    }

    // TODO ACMESQL or use multi git jenkins plugin then to be able to load
    private void activateAccount(String emailAsUserLoginId) throws Exception {

        //noinspection ConstantConditions
        File file = new File(ApiLoginPageStepDef.class.getClassLoader().getResource("tnsnames.ora").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));

        System.setProperty("oracle.net.tns_admin", file.getParentFile().getAbsolutePath());

        if (StringUtils.isEmpty(System.getProperty("database")))
            System.setProperty("database", "jdbc:oracle:thin:@ST0000D");

//        Class.forName("oracle.jdbc.OracleDriver");
////        Connection connection = DriverManager.getConnection(ABAKUS_ENVIRONMENT.get(ENVIRONMENT_RUN).get(APP_TYPE.DB), "anthony_mottot", "Heslo6897");
////        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@DBINT1", "abakus_mchuser", "heslo");
//        Connection connection = DriverManager.getConnection(System.getProperty("database"), "anthony_mottot", "Heslo6897");
//        Statement statement = connection.createStatement();
//
//        statement.execute("update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + emailAsUserLoginId + "'");
//
//        statement.close();
//        connection.close();

//        Orasql.executeSqlUpdateQuery("jdbc:oracle:thin:@TEST1", "abakus_mchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + emailAsUserLoginId + "'");
        Orasql.executeSqlUpdateQuery(System.getProperty("database"), "anthony_mottot", "Heslo6897", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + emailAsUserLoginId + "'");

//        WebDriver webDriver = ApiSupportWebDriverStepDef.getWebDriverInstance();
//        webDriver.get("gmail.com");

    }
}
