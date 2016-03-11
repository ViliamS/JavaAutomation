package com.r2development.leveris.tdd.investor.sso;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.r2development.leveris.bdd.investor.apistepdef.WebSocketClient;
import com.r2development.leveris.utils.HttpUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;

/*
import java.net.URI;
import com.kaazing.gateway.client.html5.WebSocket;
import com.kaazing.gateway.client.html5.WebSocketAdapter;
import com.kaazing.gateway.client.html5.WebSocketEvent;
*/

/**
 * Created by anthonymottot on 29/02/2016.
 */
public class LoginInvestorTest {

    public WebSocketClient wsc;
    public LoginInvestorTest() {
    }

    public void Start(String token) throws InterruptedException, IOException {
//
//        final SecureRandom random = new SecureRandom();
//        final byte[] bytes = new byte[32];
//        random.nextBytes(bytes);
//        String xrsf_token =  Base64.encodeBase64URLSafeString(bytes);


        wsc = new WebSocketClient();
//        wsc. = this;
        wsc.Connect("wss://dv2pub.opoqodev.com/pull/" + token );
//        wsc.Connect("wss://dv2pub.opoqodev.com/service");
        Thread.sleep(1000);
//        wsc.userSession
        wsc.Disconnect();
    }


    public static void main(String... arg) throws IOException, URISyntaxException, InterruptedException {

        if ( StringUtils.isEmpty(System.getProperty("environment")))
            System.setProperty("environment", "dev2");

        if ( StringUtils.isEmpty(System.getProperty("domain.investor")))
            System.setProperty("domain.investor", "dv2pub.opoqodev.com");

        if ( StringUtils.isEmpty(System.getProperty("investor")))
            System.setProperty("investor", "https://dv2pub.opoqodev.com/");

        if ( StringUtils.isEmpty(System.getProperty("investor.context")))
            System.setProperty("investor.context", "/");

        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));

        HttpClient httpClient = HttpUtils.createHttpClient();

        Assert.assertNotNull("Maven didn't load the System property Environment", System.getProperty("environment"));
        Assert.assertNotNull("Maven didn't load the System property Domain", System.getProperty("domain.investor"));
        Assert.assertNotNull("Maven didn't load the System property Investor", System.getProperty("investor"));

        HttpClientContext localContext = HttpUtils.initContext(System.getProperty("domain.investor"), System.getProperty("investor.context"));


        HttpGet httpGetApiModule = new HttpGet("https://dv2pub.opoqodev.com/api/modules");
        httpGetApiModule.setHeader("Accept", "*/*");
        HttpResponse responseGetApiModule = httpClient.execute(httpGetApiModule, localContext);
        HttpEntity httpEntityGetApiModule = responseGetApiModule.getEntity();
        System.out.println("==== httpEntityGetApiModule ====");
        String parse2json_1 = EntityUtils.toString(httpEntityGetApiModule);
        System.out.println(parse2json_1);


        /*
        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://dv2pub.opoqodev.com/proxy/router/api/public/auth/validateAuthProcessSte");
        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep.setHeader("Referer", "https://dv2pub.opoqodev.com/");
        StringEntity se2 = new StringEntity("{\"scenarioCode\":\"USR_PWD\",\"authProcessStepValues\":[{\"authDetailType\":\"USERNAME\",\"value\":\"anthony.mottot@finfactory.com\"},{\"authDetailType\":\"PWD\",\"value\":\"autPassword1122+\"}]}");
        se2.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep.setEntity(se2);
        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext);
        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
        System.out.println("==== httpPostValidateAuthProcessStep ====");
        String parse2json = EntityUtils.toString(httpEntityValidateAuthProcessStep);
        System.out.println(parse2json);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(parse2json);
        */


//        final WebSocket ws = WebSocketFactory.createWebSocketFactory().createWebSocket(URI.create("wss://dv2pub.opoqodev.com"));
//        ws.
//        ws.addWebSocketListener(
//            new WebSocketAdapter() {
//                @Override
//                public void onMessage(WebSocketEvent messageEvent) {
//                    System.out.println("Received Event Data: " + messageEvent.getData());
//                    // let's close the open connection...
//                    try {
//                        ws.close();
//                    }
//                    catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                @Override
//                public void onOpen(WebSocketEvent openEvent) {
//                    System.out.println("Connection to Server is up!");
//                    // we are able to talk to the WebSocket gateway
//                    try {
//                        ws.send("Hey, server!");
//                    }
//                    catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        );
//        ws.connect(new URI("ws://echo.websocket.org:80"));



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


//        final SecureRandom random = new SecureRandom();
//        final byte[] bytes = new byte[32];
//        random.nextBytes(bytes);
//        String xrsf_token =  Base64.encodeBase64URLSafeString(bytes);
//
//        LoginInvestorTest t = new LoginInvestorTest();
//        t.Start(xrsf_token);
//        Thread.sleep(1000);
//
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

        String token = jsonObjectIssueToken.get("token").getAsString();
        System.out.println("TICKET: " + token);


        HttpGet httpGetApiModuleBis = new HttpGet("https://dv2pub.opoqodev.com/api/modules");
        httpGetApiModuleBis.setHeader("Accept", "*/*");
        HttpResponse responseGetApiModuleBis = httpClient.execute(httpGetApiModuleBis, localContext);
        HttpEntity httpEntityGetApiModuleBis = responseGetApiModuleBis.getEntity();
        System.out.println("==== httpEntityGetApiModule ====");
        String parse2json_1bis = EntityUtils.toString(httpEntityGetApiModuleBis);
        System.out.println(parse2json_1bis);


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

        /*
        HttpPost httpPostAccountBalances = new HttpPost("https://dv2pub.opoqodev.com/proxy/investormanager/api/private/account/balances");
        httpPostAccountBalances.setHeader("accept", "application/json");
        httpPostAccountBalances.setHeader("content-type", "application/json");
        httpPostAccountBalances.setHeader("authorization", "Bearer " + token);
        httpPostAccountBalances.setHeader("device", "1405344663");
        httpPostAccountBalances.setHeader("Referer", "https://dv2pub.opoqodev.com/");
        HttpResponse responseAccountBalance = httpClient.execute(httpPostAccountBalances, localContext);
        HttpEntity httpEntityAccountBalance = responseAccountBalance.getEntity();
        System.out.println("==== httpEntityAccountBalance ====");
        String parse2jsonAccountBalance = EntityUtils.toString(httpEntityAccountBalance);
        System.out.println(parse2jsonAccountBalance);
        */

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
