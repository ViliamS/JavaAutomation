package com.r2development.leveris.bdd.underwriter.apistepdef;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.di.IAUnderwriterHttpContext;
import com.r2development.leveris.utils.HttpUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;

import static com.r2development.leveris.utils.HttpUtils.*;

@Singleton
public class ApiSsoStepDef extends ApiOpoqoUnderwriterStepDef {

    private static final Log log = LogFactory.getLog(ApiSsoStepDef.class.getName());

    @Inject
    IAUnderwriterHttpContext localContext;

    private String ssoTicket;

//    @Deprecated @Given("^user processes SSO Auth Step 1$")
//    public void user_processes_sso_auth_step1() throws IOException {
//        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://dv2apl.opoqodev.com/sso/api/public/sso/validateAuthProcessStep");
//        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
//        httpPostValidateAuthProcessStep.setHeader("Referer", "https://dv2apl.opoqodev.com/sso/?host=http://dv2app.opoqodev.com/stable-underwriter/home%3FuseCase%3Dauthenticate&application=UNDERWRITER");
//        //TODO to move to properties user login / pwd
//        StringEntity se2 = new StringEntity("{\"originalRequest\":{\"url\":\"https://st1app.loftkeys.com/underwriter/home?useCase=authenticate\",\"applicationCode\":\"UNDERWRITER\"},\"scenarioCode\":\"LDAP_USR_PWD\",\"operation\":\"LOGIN\",\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"u1@abakus,com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"Password1122\"}]}");
//        se2.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//        httpPostValidateAuthProcessStep.setEntity(se2);
//        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext);
//        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
//        System.out.println("==== httpPostValidateAuthProcessStep ====");
//        System.out.println(EntityUtils.toString(httpEntityValidateAuthProcessStep));
//    }

//    @Deprecated @Given("^user processes SSO Auth Step 2$")
//    public void user_processes_sso_auth_step2() throws IOException {
//        HttpPost httpPostValidateAuthProcessStep2 = new HttpPost("https://dv2apl.opoqodev.com/sso/api/public/sso/validateAuthProcessStep");
//        httpPostValidateAuthProcessStep2.setHeader("Content-Type", "application/json; charset=UTF-8");
//        httpPostValidateAuthProcessStep2.setHeader("Referer", "https://dv2apl.opoqodev.com/sso/?host=http://dv2app.opoqodev.com/stable-underwriter/home%3FuseCase%3Dauthenticate&application=UNDERWRITER");
//        StringEntity se3 = new StringEntity("{\"originalRequest\":{\"url\":\"http://dv2app.opoqodev.com/stable-underwriter/home%3FuseCase%3Dauthenticate\",\"applicationCode\":\"UNDERWRITER\"},\"scenarioCode\":\"LDAP_USR_PWD\",\"operation\":\"LOGIN\",\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"u1@abakus.com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"Password1122\"}]}");
//        se3.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//        httpPostValidateAuthProcessStep2.setEntity(se3);
//        HttpResponse responseValidateAuthProcessStep2 = httpClient.execute(httpPostValidateAuthProcessStep2, localContext);
//        HttpEntity httpEntityValidateAuthProcessStep2 = responseValidateAuthProcessStep2.getEntity();
//        System.out.println("==== httpPostValidateAuthProcessStep2 ====");
//        String parse2json = EntityUtils.toString(httpEntityValidateAuthProcessStep2);
//        System.out.println(parse2json);
//
//        JsonParser jsonParser = new JsonParser();
//        JsonObject jsonObject = (JsonObject) jsonParser.parse(parse2json);
//
//        ssoTicket = jsonObject.get("serviceTicket").getAsString();
//        System.out.println("TICKET: " + ssoTicket);
//    }

    @Given("^(Operator Underwriter) logs in via SSO (Underwriter)")
    public void user_underwriter_logs_in(String operator, String application) throws IOException {

        Elements elts = null;
        String authenticateResponse = null;
        int iteratorCounter = 1;

        do {
            //        ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext(System.getProperty("domain.underwriter"), System.getProperty("/stable-underwriter"));
            localContext.setHttpContext(HttpUtils.initContext(System.getProperty("domain.underwriter"), System.getProperty("underwriter.ctx")));

            //        String referer = "https://dv2apl.opoqodev.com/sso/?host=http://dv2apl.opoqodev.com/" + application.toLowerCase() + "/&application=" + application.toUpperCase();
            String referer = System.getProperty("apollo.sso.url") + "/?host=http://" + System.getProperty("domain.underwriter") + System.getProperty("underwriter.ctx") + "/&application=" + application.toUpperCase();
            String entity = "{\"authProcessId\":null,\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"test.automation+underwriter@finfactory.com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"autPassword1122+\"}],\"operation\":\"LOGIN\",\"originalRequest\":{\"url\":\"http://" + System.getProperty("domain.underwriter") + System.getProperty("underwriter.ctx") + "/\",\"applicationCode\":\"" + application.toUpperCase() + "\"},\"scenarioCode\":\"LDAP_USR_PWD\"}";

            HttpPost httpPostValidateAuthProcessStep = new HttpPost(System.getProperty("apollo.sso.url") + "/api/public/sso/validateAuthProcessStep");
            httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
            httpPostValidateAuthProcessStep.setHeader("Referer", referer);
            StringEntity se = new StringEntity(entity);
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPostValidateAuthProcessStep.setEntity(se);
            HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext.getHttpContext());
            HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
            System.out.println("==== httpPostValidateAuthProcessStep ====");
            String parse2json = EntityUtils.toString(httpEntityValidateAuthProcessStep);
            System.out.println(parse2json);

            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(parse2json);

            ssoTicket = jsonObject.get("serviceTicket").getAsString();
            System.out.println("TICKET: " + ssoTicket);

            authenticateResponse = requestHttpGet(
                    httpClient,
                    System.getProperty("underwriter.url") + "/home?useCase=authenticate&ticket=" + ssoTicket,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(authenticateResponse);

            Assert.assertNotNull("we shouldn't have a null string", authenticateResponse);

            Document doc = Jsoup.parse(authenticateResponse);
            elts = doc.select("title");

            Assert.assertEquals("We should have one \"title\" element", 1, elts.size());
            Assert.assertEquals("Title Element should contains " + application, true, elts.get(0).text().contains(application));
            Assert.assertEquals("We should have the comment \"<!-- Page Class com.cleverlance.abakus.ib.underwriter.web.ui.form.FormPage -->\"", true, authenticateResponse.contains("<!-- Page Class com.cleverlance.abakus.ib.underwriter.web.ui.form.FormPage -->"));

            iteratorCounter++;
            log.info("Iterator Counter: " + iteratorCounter);
        }
        while (authenticateResponse.contains("dynamic script end: LoginErrorView") && authenticateResponse.contains("dynamic script begin: LoginErrorView"));

    }

    @Given("^(Operator Underwriter) processes SSO (Underwriter) Auth Step$")
    public void user_processes_SSO_Auth(String operator, String application) throws IOException {

//        ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext(System.getProperty("domain.underwriter"), System.getProperty("/stable-underwriter"));
        localContext.setHttpContext(HttpUtils.initContext(System.getProperty("domain.underwriter"), System.getProperty("")));

//        String referer = "https://dv2apl.opoqodev.com/sso/?host=http://dv2apl.opoqodev.com/" + application.toLowerCase() + "/&application=" + application.toUpperCase();
        String referer = System.getProperty("apollo.sso.url") + "/?host=http://" + System.getProperty("domain.underwriter") + System.getProperty("underwriter.ctx") + "/&application=" + application.toUpperCase();
        String entity = "{\"authProcessId\":null,\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"test.automation+underwriter@finfactory.com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"autPassword1122+\"}],\"operation\":\"LOGIN\",\"originalRequest\":{\"url\":\"http://" + System.getProperty("domain.underwriter") + System.getProperty("underwriter.ctx") + "/\",\"applicationCode\":\"" + application.toUpperCase() + "\"},\"scenarioCode\":\"LDAP_USR_PWD\"}";

        HttpPost httpPostValidateAuthProcessStep = new HttpPost( System.getProperty("apollo.sso.url") + "/api/public/sso/validateAuthProcessStep");
        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep.setHeader("Referer", referer);
        StringEntity se = new StringEntity(entity);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep.setEntity(se);
        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext.getHttpContext());
        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
        System.out.println("==== httpPostValidateAuthProcessStep ====");
        String parse2json = EntityUtils.toString(httpEntityValidateAuthProcessStep);
        System.out.println(parse2json);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(parse2json);

        ssoTicket = jsonObject.get("serviceTicket").getAsString();
        System.out.println("TICKET: " + ssoTicket);

    }

    @When("^(Operator Underwriter) processes final SSO (Underwriter) Auth Step$")
    public void  user_processes_final_sso_auth_step(String operator, String application) throws IOException {

        Elements elts = null;
        String authenticateResponse = null;
        int iteratorCounter = 1;

        do {

            authenticateResponse = requestHttpGet(
                    httpClient,
                    System.getProperty("underwriter.url") + "/home?useCase=authenticate&ticket=" + ssoTicket,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        }
                    },
                    localContext.getHttpContext(),
                    CONSUME_QUIETLY
            );
            httpResponse.setHttpResponse(authenticateResponse);

            Assert.assertNotNull("we shouldn't have a null string", authenticateResponse);

            Document doc = Jsoup.parse(authenticateResponse);
            elts = doc.select("title");

            Assert.assertEquals("We should have one \"title\" element", 1, elts.size());
            Assert.assertEquals("Title Element should contains " + application, true, elts.get(0).text().contains(application));
            Assert.assertEquals("We should have the comment \"<!-- Page Class com.cleverlance.abakus.ib.underwriter.web.ui.form.FormPage -->\"", true, authenticateResponse.contains("<!-- Page Class com.cleverlance.abakus.ib.underwriter.web.ui.form.FormPage -->"));

            iteratorCounter++;
            log.info("Iterator Counter: " + iteratorCounter);
        }
        while ( authenticateResponse.contains("dynamic script end: LoginErrorView") && authenticateResponse.contains("dynamic script begin: LoginErrorView") );
    }

    @Then("^user logs out from (Underwriter)$")
    public void user_logs_out(String application) throws IOException {

        String logoutResponse = requestHttpPost(
                httpClient,
//                "http://dv2apl.opoqodev.com/client/api/private/sso/logout",
                System.getProperty("apollo.client") + "/api/private/sso/logout",
                new LinkedHashMap<String, String>() {
                    {
                        put("accept", "*/*");
                        put("content-type", "application/json");
                        put("Referer", System.getProperty("domain.apollo") + "/" + application.toLowerCase());
                    }
                },
                new LinkedHashMap<String, String>() {},
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );

        Assert.assertNotNull("we shouldn't have a null string", logoutResponse);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(logoutResponse);

        Assert.assertEquals("We should have one \"casUrl\" element", System.getProperty("apollo.sso.url") + "/", jsonObject.get("casUrl").getAsString());
    }
}
