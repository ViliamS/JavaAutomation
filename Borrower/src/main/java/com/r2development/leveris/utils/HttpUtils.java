package com.r2development.leveris.utils;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
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

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HttpUtils {

    private static final Log log = LogFactory.getLog(HttpUtils.class.getName());

    public final static boolean CONSUME_QUIETLY = (StringUtils.isNotEmpty(System.getProperty("HttpConsumeQuietly")) /*&& System.getProperty("HttpConsumeQuietly") != ""*/ && BooleanUtils.toBoolean(System.getProperty("HttpConsumeQuietly")));

    public static HttpClient createHttpClient() {
        return HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
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


}
