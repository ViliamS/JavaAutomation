package com.r2development.leveris.tdd.borrower;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.r2development.leveris.utils.HttpUtils;
import com.r2development.leveris.utils.mdg.MdgCallBack;
import com.r2development.leveris.utils.mdg.MdgCallBackImpl;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.junit.Assert.assertNotNull;

public class MdgTest {

    public String email(MdgCallBack mdgCallback) throws IOException {
        return mdgCallback.methodToEmailCallBack();
    }

    public String sms(MdgCallBack mdgCallBack) throws IOException {
        return mdgCallBack.methodToSmsCallBack();
    }


    public static void main(String... args) throws IOException {

        System.setProperty("borrower", "http://dv2app.opoqodev.com/stable-borrower");
        System.setProperty("domain.borrower", "dv2app.opoqodev.com");

        HttpClient httpClientBorrower = HttpUtils.createHttpClient();
        HttpClientContext localContextBorrower = HttpUtils.initContext(System.getProperty("domain.borrower"), "/stable-borrower");

        requestHttpGet(
                httpClientBorrower,
                System.getProperty("borrower.url") + "/home",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContextBorrower,
                CONSUME_QUIETLY
        );

        requestHttpGet(
                httpClientBorrower,
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:2:link::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContextBorrower,
                CONSUME_QUIETLY
        );

        Map<String, String> registerParameters = new LinkedHashMap<>();
        registerParameters.put("root:c:w:pnlMain:c:w:txtName:tb", "Anthony" /*+ new DateTime().now().toString("yyyyMMddHHmmssSSS")*/);
        String emailUser = "test.automation+tddapi" + DateTime.now().toString("yyyyMMddHHmmssSSS") + "@finfactory.com";
        registerParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", emailUser);
        String phoneNumberUser = "+420778098091";
        registerParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", phoneNumberUser);
        registerParameters.put("root:c:w:pnlMain:c:w:pwdPassword:tb", "Password1122+");
        registerParameters.put("root:c:w:pnlMain:c:w:chkTermsOfBusiness:checkbox", "on");
        registerParameters.put("root:c:w:pnlMain:c:w:chkDataProtectionPolicy:checkbox", "on");
        registerParameters.putAll(
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1"); // Extract StepToken !!!
                        put("root:c:w:pnlMain:c:w:btnRegister:submit", "1");
                    }
                }
        );

        requestHttpPost(
                httpClientBorrower,
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnRegister:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                registerParameters,
                localContextBorrower,
                false
        );


        MdgTest mdgTest = new MdgTest();
        MdgCallBack mdgCallBack = new MdgCallBackImpl(emailUser, phoneNumberUser);
        System.out.println("ExternalId: " + mdgTest.email(mdgCallBack));

        HttpClient httpClient = createHttpClient();
        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCookieStore(cookieStore);

        String queryEmailResponse = requestHttpPost(
                httpClient,
                "https://dv2mdg.opoqodev.com/queryemail",
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Accept", "application/json");
                    }
                },
                "{\"to\": \"" + emailUser + "\"}",
                localContext,
                false
        );

        JsonParser jsonParserQueryEmailResponse = new JsonParser();
        JsonObject jsonObjectQueryEmailResponse = (JsonObject) jsonParserQueryEmailResponse.parse(queryEmailResponse.substring(1, queryEmailResponse.length()-1));

        String emailId = jsonObjectQueryEmailResponse.get("_id").getAsString();
        assertNotNull("emailId should n't be null", emailId);
        System.out.println("emailId: " + emailId);


        String queryEmailDetailResponse = requestHttpPost(
                httpClient,
                "https://dv2mdg.opoqodev.com/queryemail/detail",
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Accept", "application/json");
                    }
                },
                "{\"ids\":[\"" + emailId + "\"]}",
                localContext,
                false
        );


        JsonParser jsonParserQueryEmailDetailsResponse = new JsonParser();
        JsonObject jsonObjectQueryEmailDetailsResponse = (JsonObject) jsonParserQueryEmailDetailsResponse.parse(queryEmailDetailResponse.substring(1, queryEmailDetailResponse.length()-1));

        String oid = jsonObjectQueryEmailDetailsResponse.get("body").getAsJsonObject().get("$oid").getAsString();
        String TheExternalId = jsonObjectQueryEmailDetailsResponse.get("externalId").getAsString();
        assertNotNull("emailId should n't be null", oid);
        System.out.println("emailId: " + oid);
        System.out.println("externalId: " + TheExternalId);


        String queryDataQueryResponse = requestHttpGet(
                httpClient,
                "https://dv2mdg.opoqodev.com/email/body/" + oid,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "application/html");
                    }
                },
                localContext,
                false
        );

        Document email = Jsoup.parse(queryDataQueryResponse);
        String urlVerifyRegistration = email.select("a[href~=useCase=verifyregistration]").attr("href");

        System.out.println(urlVerifyRegistration);

        String borrowerUIResponse = requestHttpGet(
                httpClientBorrower,
                urlVerifyRegistration,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "application/html");
                    }
                },
                localContextBorrower,
                false
        );
//        httpResponse.setHttpResponse(borrowerUIResponse);

        String smsCode = mdgTest.sms(mdgCallBack);
        System.out.println("Sms Code: " + smsCode);

        Document jsoup = Jsoup.parse(borrowerUIResponse);
        String stepToken = jsoup.select("input[name=stepToken]").attr("value");
        String onclick = jsoup.select("div[id~=btnConfirmRegistration] a").attr("onclick");

        Pattern pLinkWithSession = Pattern.compile("\\?(wicket:interface=.*btnConfirmRegistration.*)&");
        Matcher mLinkWithSession = pLinkWithSession.matcher(onclick);
        String linkWithSession = null;
        while (mLinkWithSession.find()) {
            linkWithSession = mLinkWithSession.group(1);
        }
        final String finalLink = linkWithSession;
        System.out.println("link: " + finalLink);

        final String finalActivationCode = smsCode;
        String smsCodeActivationResponse = requestHttpPost(
                httpClientBorrower,
                System.getProperty("borrower.url") + "/form.2?" + finalLink,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "application/json");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlForVerify:c:w:txtVerificationCode:tb", finalActivationCode);
                        put("stepToken", stepToken);
                        put("root:c:w:pnlMain:c:w:btnConfirmRegistration:submit", "1");
                    }
                },
                localContextBorrower,
                false
        );
//        httpResponse.setHttpResponse(smsCodeActivationResponse);

        System.out.println("let's check it !! " + emailUser);

    }
}
