package com.r2development.leveris.tdd.borrower.api;

import com.r2development.leveris.utils.HttpUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

public class BorrowerTest {

    public static void main(String... arg) throws IOException, InterruptedException {

        HttpClient httpClient = HttpUtils.createHttpClient();
        HttpClientContext localContext = HttpUtils.initContext("st1app.loftkeys.com", "/borrower");

        requestHttpGet(
                httpClient,
                "https://st1app.loftkeys.com/borrower/home",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                false
        );

        requestHttpPost(
                httpClient,
                "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:lnkLogin:cancel::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                    }
                },
                localContext,
                false
        );

        Map<String, String> loginParameters = new LinkedHashMap<>();
        loginParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", "test_automation.test.stsbapi0001201601271648058838@abakus.com");
        loginParameters.put("root:c:w:pnlMain:c:w:pwdPassword:tb", "Password1122");
        loginParameters.put("stepToken", "2");
        loginParameters.put("root:c:w:pnlMain:c:w:btnLogin:submit", "1");

        String loginResponse = requestHttpPost(
                httpClient,
                "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                loginParameters,
                localContext,
                false
        );

        Document loginResponseDoc = Jsoup.parse(loginResponse);
//        TextNode textNodeLoginResponseDoc = loginResponseDoc.select("component[id~=main]").select("component[encoding~=wicket]").first().textNodes().get(0);
//        Document loginResponseDoc2 = Jsoup.parse(textNodeLoginResponseDoc.text());
//        Elements panelTasksHidden = loginResponseDoc2.select("div[wicketpath=main_c_form_form_root_c_w_btnTasksHidden]");
        Elements textNodeJavascript = loginResponseDoc.select("evaluate[encoding~=wicket]");

        String javascriptBuyerCert = "";
        for (Element currentElement : textNodeJavascript) {
            String currentJavascriptCode = currentElement.outerHtml();
            if ( currentJavascriptCode.contains("AbakusBuyerCertificateCollapsed"))
                javascriptBuyerCert = currentJavascriptCode;
        }
//        SC._setData($.parseJSON('{"workItemId":"56a8f947e4b028a52981da99"}', true), "id171");
//        SC\.\_setData\(\$\.parseJSON\('\{"workItemId"\:"([0-9a-z]*)"\}', true\), "(id[0-9]*)"\);
        Pattern pWorkItemViewTaskId = Pattern.compile("SC\\.\\_setData\\(\\$\\.parseJSON\\('\\{\"workItemId\"\\:\"([0-9a-z]*)\"\\}', true\\), \"(id[0-9]*)\"\\)");
        Matcher mWorkItemViewTaskId = pWorkItemViewTaskId.matcher(javascriptBuyerCert);
        String workItemViewTaskId = null;
        while (mWorkItemViewTaskId.find()) {
            workItemViewTaskId = mWorkItemViewTaskId.group(1);
        }

        Map<String, String> createBuyerCertParameters = new LinkedHashMap<>();
        createBuyerCertParameters.put("root:c:w:txtWorkItemViewTaskId:tb", workItemViewTaskId); // necessary ?
        createBuyerCertParameters.put("stepToken", "1");
        createBuyerCertParameters.put("root:c:w:btnTasksHidden:submit", "1");

        requestHttpPost(
                httpClient,
                "https://st1app.loftkeys.com/borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                createBuyerCertParameters,
                localContext,
                false
        );
    }
}
