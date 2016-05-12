package com.r2development.leveris.utils.mdg;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.createHttpClient;

/**
 * Created by anthonymottot on 28/04/2016.
 */
public class MdgCallBackImpl implements MdgCallBack {

    private String email;
    private String phoneNumber;
    private String externalId;
//    private String smsCode;

//    MdgCallBackImpl() {
//        email = StringUtils.EMPTY;
//    }

    public MdgCallBackImpl(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.externalId = null;
    }

    @Override
    public String methodToEmailCallBack() throws IOException {

        HttpClient httpClient = createHttpClient();
        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCookieStore(cookieStore);

//        HttpPost httpPostMDGApiEmailFilter = new HttpPost("https://dv2mdg.opoqodev.com/ui/api/email");
        HttpPost httpPostMDGApiEmailFilter = new HttpPost(System.getProperty("mdg.url")+"/ui/api/email");
        httpPostMDGApiEmailFilter.setHeader("Content-Type", "application/json; charset=UTF-8");
//        httpPostMDGApiEmailFilter.setHeader("Referer", "https://dv2mdg.opoqodev.com/ui/email");
        httpPostMDGApiEmailFilter.setHeader("Referer", System.getProperty("mdg.url")+"/ui/email");
//        httpPostMDGApiEmailFilter.setHeader("Origin", "https://dv2mdg.opoqodev.com");
        httpPostMDGApiEmailFilter.setHeader("Origin", System.getProperty("mdg.url"));
//        httpPostMDGApiEmailFilter.setHeader("Host", "dv2mdg.opoqodev.com");
        httpPostMDGApiEmailFilter.setHeader("Host", System.getProperty("domain.mdg"));
        StringEntity seMDGApiEmailFilter = new StringEntity("{\"$type\":\"redone.FindFilter\",\"to\":[\"" + email + "\"]}");
        seMDGApiEmailFilter.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPostMDGApiEmailFilter.setEntity(seMDGApiEmailFilter);
        HttpResponse responseMDGApiEmailFilter = httpClient.execute(httpPostMDGApiEmailFilter, localContext);
        HttpEntity httpEntityMDGApiEmailFilter = responseMDGApiEmailFilter.getEntity();
        String contentMDGApiEmailFilter = EntityUtils.toString(httpEntityMDGApiEmailFilter);
        System.out.println("==== httpEntityMDGApiEmailFilter ====");
        System.out.println(contentMDGApiEmailFilter);

        JsonParser jsonParserEmailFilter = new JsonParser();
        JsonObject jsonObjectEmailFilter = (JsonObject) jsonParserEmailFilter.parse(contentMDGApiEmailFilter);

        JsonArray jsonObjectEmailFilterItem = jsonObjectEmailFilter.getAsJsonArray("items");

        if ( jsonObjectEmailFilterItem.size() > 1 ) {
            //TODO to check populated inform
        } else {
            Assert.assertEquals(jsonObjectEmailFilterItem.size(), 1);
        }

        JsonElement currentElementEmail = jsonObjectEmailFilterItem.get(0);
        JsonObject currentElementEmailAsJsonObject = currentElementEmail.getAsJsonObject();

        Assert.assertEquals(currentElementEmailAsJsonObject.get("to").getAsJsonArray().get(0).getAsString(), email);
        Assert.assertEquals(currentElementEmailAsJsonObject.get("status").getAsString(), "sent");
        // TODO to loop ? or not to do
//        Assert.assertEquals(currentElementEmailAsJsonObject.get("deliveryStatus").toString(), "[[{\"email\":\"" + email + "\",\"status\":\"delivery\",\"delivered\":true,\"detail\":[]}]]");
        externalId = currentElementEmailAsJsonObject.get("externalId").getAsString();

        return externalId;
    }

    @Override
    public String methodToSmsCallBack() throws IOException {

        HttpClient httpClient = createHttpClient();
        CookieStore cookieStore = new BasicCookieStore();
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setCookieStore(cookieStore);

        boolean isSent = false;
        boolean isDelivered = false;
        JsonObject currentElementSmsAsJsonObject = null;
        while(!isSent && !isDelivered) {

//            HttpPost httpPostMDGApiSmsFilter = new HttpPost("https://dv2mdg.opoqodev.com/ui/api/sms");
            HttpPost httpPostMDGApiSmsFilter = new HttpPost(System.getProperty("mdg.url")+"/ui/api/sms");
            httpPostMDGApiSmsFilter.setHeader("Content-Type", "application/json; charset=UTF-8");
//            httpPostMDGApiSmsFilter.setHeader("Referer", "https://dv2mdg.opoqodev.com/ui/sms");
            httpPostMDGApiSmsFilter.setHeader("Referer", System.getProperty("mdg.url")+"/ui/sms");
//            httpPostMDGApiSmsFilter.setHeader("Origin", "https://dv2mdg.opoqodev.com");
            httpPostMDGApiSmsFilter.setHeader("Origin", System.getProperty("mdg.url"));
//            httpPostMDGApiSmsFilter.setHeader("Host", "dv2mdg.opoqodev.com");
            httpPostMDGApiSmsFilter.setHeader("Host", System.getProperty("domain.mdg"));
            StringEntity seMDGApiSmsFilter = new StringEntity("{\"$type\":\"redone.FindFilter\",\"externalId\":[\"" + externalId + "\"]}");
            seMDGApiSmsFilter.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            httpPostMDGApiSmsFilter.setEntity(seMDGApiSmsFilter);
            HttpResponse responseMDGApiSmsFilter = httpClient.execute(httpPostMDGApiSmsFilter, localContext);
            HttpEntity httpEntityMDGApiSmsFilter = responseMDGApiSmsFilter.getEntity();
            String contentMDGApiSmsFilter = EntityUtils.toString(httpEntityMDGApiSmsFilter);
            System.out.println("==== httpEntityMDGApiSmsFilter ====");
            System.out.println(contentMDGApiSmsFilter);

            JsonParser jsonParserSmsFilter = new JsonParser();
            JsonObject jsonObjectSmsFilter = (JsonObject) jsonParserSmsFilter.parse(contentMDGApiSmsFilter);

            JsonArray jsonObjectSmsFilterItem = jsonObjectSmsFilter.getAsJsonArray("items");
//            Assert.assertEquals(jsonObjectSmsFilterItem.size(), 1);

            JsonElement currentElementSms = jsonObjectSmsFilterItem.get(0);
            currentElementSmsAsJsonObject = currentElementSms.getAsJsonObject();

            Assert.assertEquals(currentElementSmsAsJsonObject.get("externalId").getAsJsonArray().get(0).getAsString(), externalId);
            Assert.assertEquals(currentElementSmsAsJsonObject.get("to").getAsString(), phoneNumber);

            isSent = currentElementSmsAsJsonObject.get("status").getAsJsonArray().size() != 0 && currentElementSmsAsJsonObject.get("status").getAsJsonArray().get(0).getAsString().equals("sent");
//            isDelivered = currentElementSmsAsJsonObject.get("deliveryStatus").getAsJsonArray().size() != 0 && currentElementSmsAsJsonObject.get("deliveryStatus").getAsJsonArray().get(0).getAsString().equals("delivered");
        }

        Assert.assertEquals(currentElementSmsAsJsonObject.get("status").getAsJsonArray().get(0).getAsString(), "sent");
//        Assert.assertEquals(currentElementSmsAsJsonObject.get("deliveryStatus").getAsJsonArray().get(0).getAsString(), "delivered");
        String textSms = new String(Base64.getDecoder().decode(currentElementSmsAsJsonObject.get("body").getAsJsonArray().get(0).getAsString().getBytes()));
        Assert.assertNotNull(textSms);
        Assert.assertEquals(true, textSms.contains("Please enter code ") && textSms.contains("in your browser window within 5 minutes of getting this message"));

        Pattern patternBodySms = Pattern.compile("Please enter code (\\d+) in your browser window within 5 minutes of getting this message");
        Matcher matcherBodySms = patternBodySms.matcher(textSms);

        String theActivationCode = null;
        while (matcherBodySms.find()) {
            theActivationCode = matcherBodySms.group(1);
        }

        return theActivationCode;
    }
}
