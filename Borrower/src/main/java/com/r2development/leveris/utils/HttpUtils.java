package com.r2development.leveris.utils;


import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HttpUtils {

    private static final Log log = LogFactory.getLog(HttpUtils.class.getName());

    public final static boolean CONSUME_QUIETLY = (StringUtils.isNotEmpty(System.getProperty("HttpConsumeQuietly")) /*&& System.getProperty("HttpConsumeQuietly") != ""*/ && BooleanUtils.toBoolean(System.getProperty("HttpConsumeQuietly")));

    public static HttpClient createHttpClient() {
        return HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    public static HttpClientContext emptyContext() {
        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCookieStore(cookieStore);

        return localContext;
    }

    public static HttpClientContext initContext() {

        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();

        BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
//        cookieScUnload.setDomain("st1app.loftkeys.com");
        cookieScUnload.setDomain(System.getProperty("domain.apollo"));
        cookieScUnload.setPath("/client");
        cookieStore.addCookie(cookieScUnload);
        localContext.setCookieStore(cookieStore);

        return localContext;
    }

    public static HttpClientContext initContext(String domain, String application) {

        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();

        BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
        cookieScUnload.setDomain(domain);
        cookieScUnload.setPath(application);
        cookieStore.addCookie(cookieScUnload);
        localContext.setCookieStore(cookieStore);

        return localContext;
    }

    public static HttpClientContext initTestContext(String domain, String application) {

        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();

//        BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
//        cookieScUnload.setDomain(domain);
//        cookieScUnload.setPath(application);
//        cookieStore.addCookie(cookieScUnload);
        BasicClientCookie cookieScTest = new BasicClientCookie("sc-test", "sc");
        cookieScTest.setDomain(domain);
        cookieScTest.setPath(application);
        cookieStore.addCookie(cookieScTest);
        localContext.setCookieStore(cookieStore);

        return localContext;
    }


    public static String requestHttpGet(HttpClient httpClient, String url, Map<String, String> headers/*, Map<String, String> urlParameters*/, HttpContext localContext, boolean consumeQuietly) throws IOException {
        String toReturn = StringUtils.EMPTY;
        Instant begin_timestamp = DateTime.now().toInstant();
        log.info("\n= Begin Request :" + url);
        HttpGet httpGet = new HttpGet(url);

        if ( headers != null) {
            for (Map.Entry<String, String> currentEntry : headers.entrySet()) {
                httpGet.setHeader(currentEntry.getKey(), currentEntry.getValue());
            }
        }

//        if ( urlParameters != null ) {
//            List<NameValuePair> urlParametersGet = new ArrayList<>();
//            for (Map.Entry<String, String> currentEntry : urlParameters.entrySet()) {
//                urlParametersGet.add(new BasicNameValuePair(currentEntry.getKey(), currentEntry.getValue()));
//            }
//            httpGet.setEntity(new UrlEncodedFormEntity(urlParametersGet));
//        }

        HttpResponse response = httpClient.execute(httpGet, localContext);

        assertEquals(200, response.getStatusLine().getStatusCode());

        HttpEntity httpEntity = response.getEntity();
        if ( !consumeQuietly ) {
            log.info("\n= Response of :" + url);
            log.info(toReturn = EntityUtils.toString(httpEntity));
        } else {
            EntityUtils.consumeQuietly(httpEntity);
            Instant end_timestamp = DateTime.now().toInstant();
            log.info("done... in " + new Interval(begin_timestamp, end_timestamp).toDuration().getStandardSeconds());
        }

        HttpClientUtils.closeQuietly(response);

        Document response2Jsoup = Jsoup.parse(toReturn);
        String errorMessage;

        if (toReturn.contains("<!-- Page Class com.cleverlance.abakus.ib.borrower.web.ui.error.UnknownErrorPage -->")) {
            Elements divPageWrapper = response2Jsoup.select("div[class=page-wrapper]");
            errorMessage = prettyFormat(divPageWrapper.html(), 2);

            if (divPageWrapper.select("div[class=content-error") != null)
                errorMessage = prettyFormat(divPageWrapper.select("div[class=content-error").html(), 2);

            assertFalse(errorMessage, true);
        } else if (toReturn.contains("component.error")) {
            errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(response2Jsoup.select("component").html()), 2);
            assertFalse(errorMessage, true);
        } else if (toReturn.contains("Field is required.") && toReturn.contains("<li class=\"widget-label error\"")) {
            errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(response2Jsoup.select("component[id~=feedback]").html()), 2);
            assertFalse(errorMessage, true);
        } else if (toReturn.contains("A JavaScript error occurred while processing custom server")) {
            errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(response2Jsoup.select("component[id~=feedback]").html()), 2);
            assertFalse(errorMessage, true);
        } else if (toReturn.contains("Hide message")) {
            errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(response2Jsoup.select("component[id~=feedback]").html()), 2);
            assertFalse(errorMessage, true);
        }

        return toReturn;
    }

    public static String requestHttpPost(HttpClient httpClient, String url, Map<String, String> headers, Map<String, String> urlParameters, HttpContext localContext, boolean consumeQuietly) throws IOException {
        String toReturn = StringUtils.EMPTY;
        Instant begin_timestamp = DateTime.now().toInstant();
        log.info("\n= Begin Request :" + url);
        HttpPost httpPost = new HttpPost(url);

        if ( headers != null ) {
            for (Map.Entry<String, String> currentEntry : headers.entrySet() ) {
                httpPost.setHeader(currentEntry.getKey(), currentEntry.getValue());
            }
        }

        if ( urlParameters != null && urlParameters.size() != 0) {
            List<NameValuePair> urlParametersPost = urlParameters.entrySet().stream().map(currentEntry -> new BasicNameValuePair(currentEntry.getKey(), currentEntry.getValue())).collect(Collectors.toList());
            httpPost.setEntity(new UrlEncodedFormEntity(urlParametersPost));

//            List<NameValuePair> urlParametersPost = new ArrayList<>();
//            for (Map.Entry<String, String> currentEntry : urlParameters.entrySet()) {
//                urlParametersPost.add(new BasicNameValuePair(currentEntry.getKey(), currentEntry.getValue()));
//            }
//            httpPost.setEntity(new UrlEncodedFormEntity(urlParametersPost));
        }

        HttpResponse response = httpClient.execute(httpPost, localContext);

        assertTrue(response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 302);

        HttpEntity httpEntity = response.getEntity();
        if ( !consumeQuietly ) {
            log.info("\n= Response of :" + url);
            log.info(toReturn = EntityUtils.toString(httpEntity));
        } else {
            EntityUtils.consumeQuietly(httpEntity);
            Instant end_timestamp = DateTime.now().toInstant();
            log.info("done... in " + new Interval(begin_timestamp, end_timestamp).toDuration().toStandardSeconds());
        }

        HttpClientUtils.closeQuietly(response);

        Document response2Jsoup = Jsoup.parse(toReturn);
        String errorMessage;
        if ( !url.equals("http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlNoEmplyments:c:w:btnHiddenSubmit:submit::IBehaviorListener:0:") && !url.equals("http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnHidenRefresh:submit::IBehaviorListener:0:") ) {
            if (toReturn.contains("<!-- Page Class com.cleverlance.abakus.ib.borrower.web.ui.error.UnknownErrorPage -->")) {
                Elements divPageWrapper = response2Jsoup.select("div[class=page-wrapper]");
                errorMessage = prettyFormat(divPageWrapper.html(), 2);

                if (divPageWrapper.select("div[class=content-error") != null)
                    errorMessage = prettyFormat(divPageWrapper.select("div[class=content-error").html(), 2);

                assertFalse(errorMessage, true);
            } else if (toReturn.contains("component.error")) {
                errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(response2Jsoup.select("component").html()), 2);
                assertFalse(errorMessage, true);
            } else if (toReturn.contains("Field is required.") && toReturn.contains("<li class=\"widget-label error\"")) {
                errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(response2Jsoup.select("component[id~=feedback]").html()), 2);
                if ( System.getProperty("errorHandler") != null && System.getProperty("errorHandler").equals("true") )
                    assertFalse(errorMessage, true);
            } else if (toReturn.contains("A JavaScript error occurred while processing custom server")) {
                errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(response2Jsoup.select("component[id~=feedback]").html()), 2);
                assertFalse(errorMessage, true);
            } else if (toReturn.contains("Hide message") || toReturn.contains("is not valid.")) {
                String[] componentId = { "main", "form", "dialog" };
                for (String aComponentId : componentId) {
                    try {
                        response2Jsoup = Jsoup.parse(Jsoup.parse(toReturn).select("component[id~=" + aComponentId + "]").select("component[encoding~=wicket]").first().text());
                        log.info("is " + aComponentId);
                        break;
                    } catch (NullPointerException npe) {
                        log.info("isnot " + aComponentId);
                    }
                }
                Elements feedbackElements = response2Jsoup.select("div[wicketpath~=main_c_form_feedbackBox");
                if ( feedbackElements.size() == 1 ) {
                    errorMessage = prettyFormat(StringEscapeUtils.unescapeXml(feedbackElements.text()), 2);
                    assertFalse(errorMessage, true);
                }
            }

            // TODO to handle <!-- Page Class com.cleverlance.abakus.ib.borrower.web.ui.error.PageExpiredErrorPage -->
            // TODO to handle <!-- Page Class com.cleverlance.abakus.ib.borrower.web.ui.error.UnknownErrorPage -->
        }

        /*
        <?xml version="1.0" encoding="UTF-8"?><ajax-response><evaluate><![CDATA[scTimeVar = new Date().getTime();]]></evaluate><component id="feedback578" ><![CDATA[<div class="feedbackbox" id="feedback578" wicketpath="main_c_form_dialogWrapper_dialog_feedbackBox1_feedback" aria-live="assertive"><!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.desktop.component.feedback.FormFeedbackPanel BEGIN -->
        <ul class="feedbackul" wicketpath="main_c_form_dialogWrapper_dialog_feedbackBox1_feedback_feedbackul">
        <li class="widget-label error" onclick="return feedback.clickFocus(this);" id="id0607" wicketpath="main_c_form_dialogWrapper_dialog_feedbackBox1_feedback_feedbackul_messages_0" data-for="form56d">
        <a href="javascript:void(0);" class="close ui-corner-all" onclick="return feedback.close($(this), event);" wicketpath="main_c_form_dialogWrapper_dialog_feedbackBox1_feedback_feedbackul_messages_0_close" title="Hide message">
        <span class="ui-icon ui-icon-closethick">Hide message</span>
        </a>
        <div class="title-single" server="true" wicketpath="main_c_form_dialogWrapper_dialog_feedbackBox1_feedback_feedbackul_messages_0_title">EFEGEN00043: A JavaScript error occurred while processing custom server validations:TypeError: Cannot read property &quot;inputText&quot; from null (sc_validate_validationScript.EmploymentAndIncomeEdit#26)</div>

        </li>
        </ul>
        <!-- MARKUP FOR com.cleverlance.smartclient.frontend.wicket.desktop.component.feedback.FormFeedbackPanel END --></div>]]></component><evaluate><![CDATA[window.showLastBusyIndicator && showLastBusyIndicator();]]></evaluate><evaluate><![CDATA[
                SC.utils.resetWidgets('dialog52c');
        $('#feedbackBox156e').show();]]></evaluate><evaluate encoding="wicket1"><![CDATA[feedback.synchronizeAriaIds([{"elm":"form56d","lbl":"id0607"}]^);]]></evaluate><evaluate><![CDATA[niceButtons();]]></evaluate><evaluate><![CDATA[window.hideLastBusyIndicator && hideLastBusyIndicator();]]></evaluate><evaluate><![CDATA[
        if (window.scConsole) {
            scConsole.log('ajax request', 'server time', 10);
            scConsole.log('ajax request', 'client time', new Date().getTime() - scTimeVar);}]]></evaluate></ajax-response>
        */

        return toReturn;
    }

    public static String requestHttpPost(HttpClient httpClient, String url, Map<String, String> headers, String json, HttpContext localContext, boolean consumeQuietly) throws IOException {
        String toReturn = StringUtils.EMPTY;
        Instant begin_timestamp = DateTime.now().toInstant();
        log.info("\n= Begin Request :" + url);
        HttpPost httpPost = new HttpPost(url);

        if ( headers != null ) {
            for (Map.Entry<String, String> currentEntry : headers.entrySet() ) {
                httpPost.setHeader(currentEntry.getKey(), currentEntry.getValue());
            }
        }

        if ( json != null ) {
            StringEntity jsonEntity =new StringEntity(json);
            httpPost.setEntity(jsonEntity);
        }

        HttpResponse response = httpClient.execute(httpPost, localContext);

//        assertTrue(response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 302);

        HttpEntity httpEntity = response.getEntity();
        if ( !consumeQuietly ) {
            log.info("\n= Response of :" + url);
            log.info(toReturn = EntityUtils.toString(httpEntity));
        } else {
            EntityUtils.consumeQuietly(httpEntity);
            Instant end_timestamp = DateTime.now().toInstant();
            log.info("done... in " + new Interval(begin_timestamp, end_timestamp).toDuration().toStandardSeconds());
        }

        HttpClientUtils.closeQuietly(response);
        return toReturn;
    }

    // TODO to be continued
//    public static void requestHttpUploadPost(HttpClient httpClient, String url, Map<String, String> headers, Table<String, String, String> guavaTable, HttpClientContext localContext, boolean consumeQuietly) throws IOException {
//        Instant begin_timestamp = DateTime.now().toInstant();
//        log.info("= Request :" + url);
//        HttpPost httpPost = new HttpPost(url);
//
//        if ( headers != null ) {
//            for ( Map.Entry<String, String> currentEntry : headers.entrySet() ) {
//                httpPost.setHeader(currentEntry.getKey(), currentEntry.getValue());
//            }
//        }
//
//        if ( guavaTable != null) {
//            for ( guavaTable. )
//        }
//    }

    private static String prettyFormat(String input, int indent) {
        /*
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // simple exception handling, please review it
        }
        */

//        try {
//            final org.w3c.dom.Document document = parseXmlFile(input);
//
//            OutputFormat format = new OutputFormat(document);
//            format.setLineWidth(65);
//            format.setIndenting(true);
//            format.setIndent(indent);
//            Writer out = new StringWriter();
//            XMLSerializer serializer = new XMLSerializer(out, format);
//            serializer.serialize(document);
//
//            return out.toString();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Document.OutputSettings settings = new Document.OutputSettings();
        settings.charset("utf-8").indentAmount(indent).outline(true).prettyPrint();

        Document doc = Jsoup.parse(input);
        doc.outputSettings(settings);
        return doc.html();
    }

}
