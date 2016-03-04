package com.r2development.leveris.bdd.apollo.apistepdef;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Singleton;
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

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

@Singleton
public class ApiSsoStepDef extends ApiOpoqoApolloStepDef {

    private static final Log log = LogFactory.getLog(ApiSsoStepDef.class.getName());

    private String ssoTicket;

    @Given("^user processes SSO (Payment|Client) Auth Step$")
    public void user_processes_SSO_Auth(String application) throws IOException {

        ApiSupportHttpClientStepDef.getNewInstanceHttpClientContext(System.getProperty("domain.apollo"), System.getProperty("apollo.context." + application.toLowerCase()));

        String referer = "https://dv2apl.opoqodev.com/sso/?host=http://dv2apl.opoqodev.com/" + application.toLowerCase() + "/&application=" + application.toUpperCase();
        String entity = "{\"authProcessId\":null,\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"test_automation@abakus.com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"autPassword1122\"}],\"operation\":\"LOGIN\",\"originalRequest\":{\"url\":\"http://dv2apl.opoqodev.com/" + application.toLowerCase() + "/\",\"applicationCode\":\"" + application.toUpperCase() + "\"},\"scenarioCode\":\"LDAP_USR_PWD\"}";

        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://dv2apl.opoqodev.com/sso/api/public/sso/validateAuthProcessStep");
        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep.setHeader("Referer", referer);
        StringEntity se = new StringEntity(entity);
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep.setEntity(se);
        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext);
        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
        System.out.println("==== httpPostValidateAuthProcessStep ====");
        String parse2json = EntityUtils.toString(httpEntityValidateAuthProcessStep);
        System.out.println(parse2json);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(parse2json);

        ssoTicket = jsonObject.get("serviceTicket").getAsString();
        System.out.println("TICKET: " + ssoTicket);

    }

    @When("^user processes final SSO (Payment|Client) Auth Step$")
    public void user_processes_final_sso_auth_step(String application) throws IOException {

        String authenticateResponse = requestHttpGet(
                    httpClient,
                    "http://dv2apl.opoqodev.com/" + application.toLowerCase() + "/home?useCase=authenticate&ticket=" + ssoTicket,
                    new LinkedHashMap<String, String>() {
                        {
                            put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        }
                    },
                    localContext,
                    CONSUME_QUIETLY
            );
//        httpResponse.setHttpResponse(authenticateResponse);

        Assert.assertNotNull("we shouldn't have a null string", authenticateResponse);

        Document doc = Jsoup.parse(authenticateResponse);
        Elements elts = doc.select("title");

        Assert.assertEquals("We should have one \"title\" element", 1, elts.size());
        Assert.assertEquals("Title Element should contains " + application, true, elts.get(0).text().contains(application));

    }

    @Then("^user logs out from (Client|Payment)$")
    public void user_logs_out(String application) throws IOException {

        String logoutResponse = requestHttpPost(
            httpClient,
            "http://dv2apl.opoqodev.com/client/api/private/sso/logout",
            new LinkedHashMap<String, String>() {
                {
                    put("accept", "*/*");
                    put("content-type", "application/json");
                    put("Referer", "http://dv2apl.opoqodev.com/" + application.toLowerCase());
                }
            },
            null,
            localContext,
            CONSUME_QUIETLY
        );

        Assert.assertNotNull("we shouldn't have a null string", logoutResponse);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(logoutResponse);

        Assert.assertEquals("We should have one \"casUrl\" element", "https://dv2apl.opoqodev.com/sso/", jsonObject.get("casUrl").getAsString());

    }

}
