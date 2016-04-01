package com.r2development.leveris.tdd.borrower;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.*;
import static org.junit.Assert.assertNotNull;

public class MdgTest {

    public static void main(String... args) throws IOException {

        System.out.println("/queryenail filter email");
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
            "{\"to\": \"test.automation.gui201631031542000@test.finfactory.com\"}",
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
//        JsonObject jsonObjectQueryEmailResponse = (JsonObject) jsonParserQueryEmailResponse.parse(queryEmailResponse);

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
        String urlVerifyRegistration = email.select("a").attr("href");

        System.out.println(urlVerifyRegistration);


        String borrowerUIResponse = requestHttpGet(
                httpClient,
                urlVerifyRegistration,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "application/html");
                    }
                },
                localContext,
                false
        );

//        HttpClientContext localContextMdg = HttpUtils.emptyContext();
//        String uiMDG = requestHttpGet(
//                httpClient,
//                "https://dv2mdg.opoqodev.com/ui/email",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "application/html");
//                    }
//                },
//                localContextMdg,
//                false
//        );
//
//
//        HttpPost httpPostUIApiEmail = new HttpPost( "https://dv2mdg.opoqodev.com/ui/api/email" );
//        httpPostUIApiEmail.setHeader("Content-Type", "application/json; charset=UTF-8");
//        httpPostUIApiEmail.setHeader("Referer", "https://dv2mdg.opoqodev.com/ui/email" );
//        StringEntity seUIApiEmail = new StringEntity("{$type: \"redone.FindFilter\"}");
//        seUIApiEmail.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//        httpPostUIApiEmail.setEntity(seUIApiEmail);
//        HttpResponse responseUIApiEmail = httpClient.execute(httpPostUIApiEmail, localContextMdg);
//        HttpEntity httpEntityUIApiEmail = responseUIApiEmail.getEntity();
//        String parse2jsonUIApiEmail = EntityUtils.toString(httpEntityUIApiEmail);
//        System.out.println(parse2jsonUIApiEmail);


//        String uiApiEmail = requestHttpPost(
//                httpClient,
//                "https://dv2mdg.opoqodev.com/ui/api/email",
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Content-Type", "application/json");
//                        put("Accept", "application/json");
//                    }
//                },
//                new LinkedHashMap<String, String>() {},
//                localContext,
//                false
//        );

//        JsonParser jsonParserUiApiEmailResponse = new JsonParser();
//        JsonObject jsonObjectUiApiEmailResponse = (JsonObject) jsonParserUiApiEmailResponse.parse(parse2jsonUIApiEmail);

//        JsonParser jsonParserQueryEmailDetailResponse = new JsonParser();
//        JsonObject jsonObjectQueryEmailDetailResponse = (JsonObject) jsonParserQueryEmailDetailResponse.parse(queryEmailDetailResponse.substring(1, queryEmailDetailResponse.length()-1));
//
//        String bodyEmail = jsonObjectQueryEmailDetailResponse.get("body").getAsString();
//        JsonArray toEmailId = jsonObjectQueryEmailDetailResponse.get("to").getAsJsonArray();
//
//        assertNotNull("emailId should n't be null", emailId);
//        System.out.println("email body: " + new String(Base64.getDecoder().decode(bodyEmail.getBytes())));
//        System.out.println("to: " + toEmailId);

        // Extravct Url .....







        String querySmsResponse = requestHttpPost(
                httpClient,
                "https://dv2mdg.opoqodev.com/querysms",
                new LinkedHashMap<String, String>() {
                    {
                        put("Content-Type", "application/json");
                        put("Accept", "application/json");
                    }
                },
                "{\"to\": \"+420778098091\"}", // TODO, input parameters generated by Automation Framework with Epoch value
                localContext,
                false
        );

        JsonParser jsonParserQuerySmsResponse = new JsonParser();
        JsonObject jsonObjectQuerySmsResponse = (JsonObject) jsonParserQuerySmsResponse.parse("{\"listSms\":" + querySmsResponse + "}");
//        JsonObject jsonObjectQueryEmailResponse = (JsonObject) jsonParserQueryEmailResponse.parse(queryEmailResponse);

        JsonArray smsId = jsonObjectQuerySmsResponse.get("listSms").getAsJsonArray();
        assertNotNull("smsId should n't be null", smsId);
        System.out.println("smsId: " + smsId);

        String activationCode;

        if ( smsId.size() == 1) {
            JsonObject jsonSmsId = smsId.get(0).getAsJsonObject();
            String theSmsId = jsonSmsId.get("_id").getAsString();

            String querySmsDetailResponse = requestHttpPost(
                    httpClient,
                    "https://dv2mdg.opoqodev.com/querysms/detail",
                    new LinkedHashMap<String, String>() {
                        {
                            put("Content-Type", "application/json");
                            put("Accept", "application/json");
                        }
                    },
                    //                "{\"ids\":[\"" + 56dd47bc2300002c00eeb75b + "\"]}",
                    "{\"ids\":[\"" + theSmsId + "\"]}",
                    localContext,
                    false
            );
        }
        else {
            for ( JsonElement currentSmsId : smsId) {
                JsonObject jsonSmsId = currentSmsId.getAsJsonObject();
                String theSmsId = jsonSmsId.get("_id").getAsString();

                String querySmsDetailResponse = requestHttpPost(
                        httpClient,
                        "https://dv2mdg.opoqodev.com/querysms/detail",
                        new LinkedHashMap<String, String>() {
                            {
                                put("Content-Type", "application/json");
                                put("Accept", "application/json");
                            }
                        },
                        //                "{\"ids\":[\"" + 56dd47bc2300002c00eeb75b + "\"]}",
                        "{\"ids\":[\"" + theSmsId + "\"]}",
                        localContext,
                        false
                );

                JsonParser jsonParserQuerySmsDetailResponse = new JsonParser();
                JsonObject jsonObjectQuerySmsDetailResponse = (JsonObject) jsonParserQuerySmsDetailResponse.parse(querySmsDetailResponse.substring(1, querySmsDetailResponse.length()-1));

                String externalId = jsonObjectQuerySmsDetailResponse.get("externalId").getAsString();

                if ( !externalId.equals(TheExternalId))
                    continue;

                String bodySms = jsonObjectQuerySmsDetailResponse.get("response").getAsJsonObject().get("body").getAsString();
//                String toSmsId = jsonObjectQuerySmsDetailResponse.get("_id").getAsString();

                assertNotNull("bodySms should n't be null", bodySms);
//                assertNotNull("bodySms should n't be null", toSmsId);
//                System.out.println("sms body: " + new String(Base64.getDecoder().decode(bodySms.getBytes())));
                System.out.println("to: " + bodySms);

                Pattern pBodySms = Pattern.compile("Please enter code (.*) in your browser window within 30 minutes of getting this message. Thanks!");
                Matcher mBodySms = pBodySms.matcher(bodySms);

                activationCode = null;
                while (mBodySms.find()) {
                    activationCode = mBodySms.group(2);
                }

                System.out.println("activationCode: " + activationCode);
                break;

            }
        }


    }
}
