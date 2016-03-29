package com.r2development.leveris.tdd.apollo.sso;

import com.r2development.leveris.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.joda.time.DateTime;
import org.junit.Assert;

import java.io.IOException;

public class LoginClientTest {

    public static void main(String... arg) throws IOException {

        if ( StringUtils.isEmpty(System.getProperty("environment")))
            System.setProperty("environment", "dev2");

        if ( StringUtils.isEmpty(System.getProperty("domain.apollo")))
            System.setProperty("domain.apollo", "dv2apl.opoqodev.com");

        if ( StringUtils.isEmpty(System.getProperty("apollo.client")))
            System.setProperty("apollo.client", "https://dv2apl.opoqodev.com/client");

        if ( StringUtils.isEmpty(System.getProperty("apollo.payment")))
            System.setProperty("apollo.payment", "https://dv2apl.opoqodev.com/payment");

        if ( StringUtils.isEmpty(System.getProperty("apollo.context.client")))
            System.setProperty("apollo.context.client", "/client");

        if ( StringUtils.isEmpty(System.getProperty("apollo.context.payment")))
            System.setProperty("apollo.context.payment", "/payment");

        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));

        HttpClient httpClient = HttpUtils.createHttpClient();

        Assert.assertNotNull("Maven didn't load the System property Environment", System.getProperty("environment"));
        Assert.assertNotNull("Maven didn't load the System property Domain", System.getProperty("domain.apollo"));
        Assert.assertNotNull("Maven didn't load the System property Apollo.Client", System.getProperty("apollo.client"));
//        Assert.assertNotNull("Maven didn't load the System property Apollo.Client", System.getProperty("apollo.client"));
        Assert.assertNotNull("Maven didn't load the System property Apollo.Payment", System.getProperty("apollo.payment"));

        HttpClientContext localContext = HttpUtils.initContext(System.getProperty("domain.apollo"), System.getProperty("apollo.context.client"));

/*        // Step 1 - SSO
        HttpPost httpPostValidateAuthProcessStep = new HttpPost("https://dv2apl.opoqodev.com/sso/api/public/sso/validateAuthProcessStep");
        httpPostValidateAuthProcessStep.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpPostValidateAuthProcessStep.setHeader("Referer", "https://dv2apl.opoqodev.com/sso/?host=http://dv2apl.opoqodev.com/client/&application=CLIENT");
        StringEntity se2 = new StringEntity("{\"authProcessId\":null,\"authProcessStepValues\":[{\"authDetailCode\":\"LDAPUSERNAME\",\"value\":\"test_automation@abakus.com\"},{\"authDetailCode\":\"LDAPPWD\",\"value\":\"autPassword1122\"}],\"operation\":\"LOGIN\",\"originalRequest\":{\"url\":\"http://dv2apl.opoqodev.com/client/\",\"applicationCode\":\"CLIENT\"},\"scenarioCode\":\"LDAP_USR_PWD\"}");
        se2.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostValidateAuthProcessStep.setEntity(se2);
        HttpResponse responseValidateAuthProcessStep = httpClient.execute(httpPostValidateAuthProcessStep, localContext);
        HttpEntity httpEntityValidateAuthProcessStep = responseValidateAuthProcessStep.getEntity();
        System.out.println("==== httpPostValidateAuthProcessStep ====");
        String parse2json = EntityUtils.toString(httpEntityValidateAuthProcessStep);
        System.out.println(parse2json);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(parse2json);

        String ssoTicket = jsonObject.get("serviceTicket").getAsString();
        System.out.println("TICKET: " + ssoTicket);

        // Step 2 -- SSO
        HttpGet httpGetAccessStep2 = new HttpGet("http://dv2apl.opoqodev.com/client/?ticket=" + ssoTicket);
        httpGetAccessStep2.setHeader("Content-Type", "txt/html");
        HttpResponse responseGetAccessStep2 = httpClient.execute(httpGetAccessStep2, localContext);
        HttpEntity httpEntityGetAccessStep2 = responseGetAccessStep2.getEntity();
        System.out.println("==== httpGetAccessStep2 ====");
        String parse2json2 = EntityUtils.toString(httpEntityGetAccessStep2);
        System.out.println(parse2json2);

        // Ping
        HttpGet httpGetPing = new HttpGet("http://dv2apl.opoqodev.com/client/api/public/ping");
        httpGetPing.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpGetPing.setHeader("Referer", "http://dv2apl.opoqodev.com/client/?ticket=" + ssoTicket);
        HttpResponse responsePing = httpClient.execute(httpGetPing, localContext);
        HttpEntity httpEntityResponsePing = responsePing.getEntity();
        System.out.println("==== httpEntityResponsePing ====");
        String entityGetPing = EntityUtils.toString(httpEntityResponsePing);
        System.out.println(entityGetPing);

        String xsrfToken = StringUtils.EMPTY;
        for (Cookie currentCookie : localContext.getCookieStore().getCookies()) {
            if ( currentCookie.getName().equals("XSRF-TOKEN") )
                xsrfToken = currentCookie.getValue();
        }

        // getInitialData
        HttpPost httpGetInitialData = new HttpPost("http://dv2apl.opoqodev.com/client/api/private/auth/getInitialData?ticket=" + ssoTicket);
        httpGetInitialData.setHeader("Content-Type", "application/json; charset=UTF-8");
        httpGetInitialData.setHeader("Referer", "http://dv2apl.opoqodev.com/client/");
        httpGetInitialData.setHeader("x-xsrf-token", xsrfToken);
        StringEntity se3 = new StringEntity("ticket=" + ssoTicket);
        se3.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpGetInitialData.setEntity(se3);

        HttpResponse responseGetInitialDataStep3 = httpClient.execute(httpGetInitialData, localContext);
        HttpEntity httpEntityGetInitialDataStep3 = responseGetInitialDataStep3.getEntity();
        System.out.println("==== httpEntityGetInitialDataStep3 ====");
        String parse2json3 = EntityUtils.toString(httpEntityGetInitialDataStep3);
        System.out.println(parse2json3);*/


        HttpGet httpApolloClientContext = new HttpGet("https://dv2apl.opoqodev.com/client");
        httpApolloClientContext.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//        HttpResponse responsePing = httpClient.execute(httpApolloClientContext, localContext);
        httpClient.execute(httpApolloClientContext, localContext);
    }
}
