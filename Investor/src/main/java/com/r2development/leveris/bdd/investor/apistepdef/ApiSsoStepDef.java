package com.r2development.leveris.bdd.investor.apistepdef;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Singleton;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.io.IOException;

@Singleton
public class ApiSsoStepDef extends ApiOpoqoInvestorStepDef {

    private static final Log log = LogFactory.getLog(ApiSsoStepDef.class.getName());

    private String token;

    @Given("^user processes SSO (Investor) Auth Step$")
    public void user_processes_SSO_Auth(String application) throws IOException {

        // Step 1 - SSO
        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://dv2pub.opoqodev.com/proxy/router/api/public/auth/validateAuthProcessStep");
        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep.setHeader("Referer", "https://dv2pub.opoqodev.com/");
        StringEntity seValidateAuthProcessStep = new StringEntity("{\"scenarioCode\":\"USR_PWD\",\"authProcessStepValues\":[{\"authDetailType\":\"USERNAME\",\"value\":\"anthony.mottot@finfactory.com\"},{\"authDetailType\":\"PWD\",\"value\":\"autPassword1122+\"}]}");
        seValidateAuthProcessStep.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep.setEntity(seValidateAuthProcessStep);
        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext);
        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
        System.out.println("==== httpPostValidateAuthProcessStep ====");
        String parse2jsonValidateAuthProcessStep = EntityUtils.toString(httpEntityValidateAuthProcessStep);
        System.out.println(parse2jsonValidateAuthProcessStep);

        JsonParser jsonParserValidateAuthProcessStep = new JsonParser();
        JsonObject jsonObjectValidateAuthProcessSte = (JsonObject) jsonParserValidateAuthProcessStep.parse(parse2jsonValidateAuthProcessStep);

        String idScenario = jsonObjectValidateAuthProcessSte.get("idScenario").getAsString();
        System.out.println("idScenario: " + idScenario);

        // Step 2 - SSO
        HttpPost httpPostGenerateServiceTicket = new HttpPost("https://dv2pub.opoqodev.com/proxy/router/api/public/ticket/generateServiceTicket");
        httpPostGenerateServiceTicket.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostGenerateServiceTicket.setHeader("Referer", "https://dv2pub.opoqodev.com/");
        StringEntity seGenerateServiceTicket = new StringEntity("{\"idAuthProcess\":\"" + idScenario + "\"}");
        seGenerateServiceTicket.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostGenerateServiceTicket.setEntity(seGenerateServiceTicket);
        HttpResponse responseGenerateServiceTicket = httpClient.execute(httpPostGenerateServiceTicket, localContext);
        HttpEntity httpEntityGenerateServiceTicket = responseGenerateServiceTicket.getEntity();
        System.out.println("==== httpEntityGenerateServiceTicket ====");
        String parse2jsonGenerateServiceTicket = EntityUtils.toString(httpEntityGenerateServiceTicket);
        System.out.println(parse2jsonGenerateServiceTicket);

        JsonParser jsonParserGenerateServiceTicket = new JsonParser();
        JsonObject jsonObjectGenerateServiceTicket = (JsonObject) jsonParserGenerateServiceTicket.parse(parse2jsonGenerateServiceTicket);

        String serviceTicketCode = jsonObjectGenerateServiceTicket.get("serviceTicketCode").getAsString();
        System.out.println("serviceTicketCode: " + serviceTicketCode);
        String applicationCode = jsonObjectGenerateServiceTicket.get("applicationCode").getAsString();
        System.out.println("applicationCode <=> applicationid: " + applicationCode);

        String channeluuid = RandomStringUtils.random(8, true, true) + "-" + RandomStringUtils.random(4, true, true) + "-" + RandomStringUtils.random(4, true, false) + "-" + RandomStringUtils.random(4, true, false) + "-" + RandomStringUtils.random(12, true, true);
//        System.out.println("channeluuid: " + xrsf_token);


        HttpPost httpPostIssueToken = new HttpPost("https://dv2pub.opoqodev.com/api/issueToken");
        httpPostIssueToken.setHeader("accept", "application/json");
        httpPostIssueToken.setHeader("applicationid", applicationCode);
        httpPostIssueToken.setHeader("channeluuid", "8114a4af-1b81-4698-8298-183edc1023c8");
//        httpPostIssueToken.setHeader("channeluuid", xrsf_token);
        httpPostIssueToken.setHeader("Referer", "https://dv2pub.opoqodev.com");

        StringEntity sePostIssueToken = new StringEntity(serviceTicketCode);
        sePostIssueToken.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "text/plain"));
        httpPostIssueToken.setEntity(sePostIssueToken);

        HttpResponse responseIssueToken = httpClient.execute(httpPostIssueToken, localContext);
        HttpEntity httpEntityIssueToken = responseIssueToken.getEntity();
        System.out.println("==== httpEntityIssueToken ====");
        String parse2jsonIssueToken = EntityUtils.toString(httpEntityIssueToken);
        System.out.println(parse2jsonIssueToken);

        JsonParser jsonParserIssueToken = new JsonParser();
        JsonObject jsonObjectIssueToken = (JsonObject) jsonParserIssueToken.parse(parse2jsonIssueToken);

        token = jsonObjectIssueToken.get("token").getAsString();
        System.out.println("TICKET: " + token);

    }

    @When("^user processes final SSO (Investor) Auth Step$")
    public void user_processes_final_sso_auth_step(String application) throws IOException {

        HttpGet httpGetApiModuleWithBearer = new HttpGet("https://dv2pub.opoqodev.com/api/modules");
        httpGetApiModuleWithBearer.setHeader("Accept", "*/*");
        httpGetApiModuleWithBearer.setHeader("authorization", "Bearer " + token);
        HttpResponse responseGetApiModuleWithBearer = httpClient.execute(httpGetApiModuleWithBearer, localContext);
        HttpEntity httpEntityGetApiModuleWithBearer = responseGetApiModuleWithBearer.getEntity();
        System.out.println("==== httpEntityGetApiModuleWithBearer ====");
        String parse2jsonGetApiModuleWithBearer = EntityUtils.toString(httpEntityGetApiModuleWithBearer);
        System.out.println(parse2jsonGetApiModuleWithBearer);

        HttpGet httpGetInvestorManager = new HttpGet("https://dv2pub.opoqodev.com/api/module/investor_manager.js");
        httpGetInvestorManager.setHeader("Accept", "*/*");
        HttpResponse responseInvestorManager = httpClient.execute(httpGetInvestorManager, localContext);
        HttpEntity httpEntityInvestorManager = responseInvestorManager.getEntity();
        System.out.println("==== httpEntityInvestorManager ====");
        String parse2jsonInvestorManager = EntityUtils.toString(httpEntityInvestorManager);
        System.out.println(parse2jsonInvestorManager);

        Assert.assertNotNull("we shouldn't have a null string", parse2jsonInvestorManager);

        JsonParser jsonParseInvestorManager = new JsonParser();
        JsonObject jsonObjectInvestorManager = (JsonObject) jsonParseInvestorManager.parse(parse2jsonGetApiModuleWithBearer);

        Assert.assertEquals("We should have entry module \"investorManager\"", "investorManager", jsonObjectInvestorManager.get("entryModule").getAsString());
    }

    @Then("^user logs out from (Investor)$")
    public void user_logs_out(String application) throws IOException {

        HttpPost httpPostLogOut = new HttpPost("https://dv2pub.opoqodev.com/proxy/router/api/private/login/logout");
        httpPostLogOut.setHeader("accept", "application/json");
        httpPostLogOut.setHeader("content-type", "application/json");
        httpPostLogOut.setHeader("authorization", "Bearer " + token);
        httpPostLogOut.setHeader("device", "1405344663");
        httpPostLogOut.setHeader("Referer", "https://dv2pub.opoqodev.com/");
        HttpResponse responseLogOut = httpClient.execute(httpPostLogOut, localContext);
        HttpEntity httpEntityLogOut = responseLogOut.getEntity();
        System.out.println("==== httpEntityLogOut ====");
        String parse2jsonLogOut = EntityUtils.toString(httpEntityLogOut);
        System.out.println(httpEntityLogOut);
    }

}
