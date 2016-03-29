package com.r2development.leveris.tdd.borrower;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.core.Is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;

public class WicketFieldRequiredTest {

    public static void main(String... args) throws IOException, URISyntaxException {

//        File file = new File(WicketUtilsTest.class.getClassLoader().getResource("./WicketResponse/automaticRegistrationPage1.txt").toURI());
//        File file = new File(WicketUtilsTest.class.getClassLoader().getResource("./WicketResponse/automaticRegistrationPage2.txt").toURI());
//        File file = new File(WicketUtilsTest.class.getClassLoader().getResource("./WicketResponse/home.txt").toURI());
        File file = new File(WicketFieldRequiredTest.class.getClassLoader().getResource("./WicketResponse/FieldsRequired/employmentHtml.txt").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));

        Document jsoup = Jsoup.parse(FileUtils.readFileToString(file));

        Document componentDoc = null;
        String[] componentId = { "main", "form", "dialog", "feedback" };
        String currentComponentId = StringUtils.EMPTY;
        for (String aComponentId : componentId) {
            try {
//                componentDoc = Jsoup.parse(jsoup.select("component[id~="+componentId[i]+"]").select("component[encoding~=wicket]").first().text());
                componentDoc = Jsoup.parse(jsoup.select("component[id~=" + aComponentId + "]").first().text());
                System.out.println("is " + aComponentId);
                currentComponentId = aComponentId;
                break;
            } catch (NullPointerException npe) {
                System.out.println("isnot " + aComponentId);
            }
        }

//        Assert.assertNotNull(componentDoc);

        if (FileUtils.readFileToString(file).contains("<ajax-response>")) {

//            Elements evaluateElts = jsoup.select("evaluate");

//            Elements headerElts = jsoup.select("header-contribution");
//            Document headerDoc = Jsoup.parse(jsoup.select("header-contribution").first().text());

            if ( !currentComponentId.equals("feedback") ) {

                Elements form = componentDoc.select("form");

                for (Element currentForm : form) {
                    Elements inputForm = currentForm.select("input[name]");
                    for (Element currentElement : inputForm) {
                        System.out.println("name: " + currentElement.attr("name"));
                    }

                    Elements actionForm = currentForm.select("a[id~=submit]");
                    for (Element currentElement : actionForm) {
                        //                System.out.println("link to extract: " + currentElement.attr("onclick"));
                        Pattern pLink = Pattern.compile("\\.apply\\(this,\\['form(\\d|\\D){1,2}','form(\\d|\\D){1,2}','scAjax\\.apply\\(this,\\[\\d,\\d,\\\\'(;)*(.*)&\\$\\{scrollPos\\}\\\\'");
                        Matcher mLink = pLink.matcher(currentElement.attr("onclick"));

                        String link = StringUtils.EMPTY;
                        while (mLink.find()) {
                            link = mLink.group(4);
                        }
                        final String finalLink = link;
                        System.out.println("link: " + finalLink);
                    }

                    Elements scriptForm = currentForm.select("a[id~=script]");
                    for (Element currentElement : scriptForm) {
                        currentElement.attr("id");
                    }


                    Elements stepToken = currentForm.select("input[name=stepToken]");
                    for (Element currentElement : stepToken) {
                        System.out.println("stepToken: " + currentElement.attr("value"));
                    }
                }

                System.out.println("... Ajax Done");
            }
            else {

                Map<String, String> errorHandler = new LinkedHashMap<>();
                Elements liList = componentDoc.select("li");
                for ( Element currentLi : liList ) {
                    String divTitle = currentLi.select("div[class=title]").first().text();
                    String divDesc = currentLi.select("div[class=desc]").first().text();
                    errorHandler.put(divTitle, divDesc);
                }

                System.out.println(errorHandler);

            }

        } else {
//            System.out.println("jsoup: \n\n" + jsoup);

//            Elements javascriptElementLists = jsoup.select("script[type=text/javascript]");
//            String version = jsoup.select("div[wicketpath=version]").outerHtml();

//            Elements anyLink = jsoup.select("a");
//            String header = jsoup.select("div[wicketpath=initialMenuWrapper]").outerHtml();
//            Document jsoupHeader = Jsoup.parse(header);
//            Elements lnkHeader = jsoupHeader.getElementsByTag("div[wicketpath=initialMenuWrapper] a");

//            div => id pnlEmployed

//            label => id label
//            label => class message-inline-error

//            Elements pnlEmployed = jsoup.select("div[class=errorbox] ");


            Elements pnlEmployed = jsoup.select("div[id~=pnlEmployed]");
            Assert.assertEquals(1, pnlEmployed.size());

            Map<String, String> errorHandler = new LinkedHashMap<>();
            Elements elementFromPnlDetail = pnlEmployed.select("div[data-path~=pnlDetail]");
            for ( Element currentElement : elementFromPnlDetail) {
                String key = StringUtils.EMPTY;
                if ( currentElement.select("label[id~=label]").select("label[wicketpath~=pnlDetail]") != null )
                    key = currentElement.select("label[id~=label]").select("label[wicketpath~=pnlDetail]").first().textNodes().get(0).text();
                String message = StringUtils.EMPTY;
                if ( currentElement.select("label[class~=message-inline-error") != null && currentElement.select("label[class~=message-inline-error]").first() != null && currentElement.select("label[class~=message-inline-error]").first().textNodes().get(0) != null )
                    message = currentElement.select("label[class~=message-inline-error]").first().textNodes().get(0).text();
                if ( !StringUtils.isEmpty(key) && !StringUtils.isEmpty(message))
                    errorHandler.put(key, message);
            }

            System.out.println(errorHandler);

            Map<String, String> expectedError = new LinkedHashMap<>();
            expectedError.put("Occupation", "Field is required.");
            expectedError.put("Employer's name","Required field / Entered value contains forbidden characters");
            expectedError.put("Employment type","Field is required.");
            expectedError.put("Start date","Field is required.");
            expectedError.put("Net Income (monthly)","Field is required / Entered currency amount must be a number from 0 to 99 999 999");

            Assert.assertEquals(true, CollectionUtils.isEqualCollection( errorHandler.keySet(), expectedError.keySet() ) && CollectionUtils.isEqualCollection( errorHandler.values(), expectedError.values() ));

            Map<String, String> expectedError2 = new LinkedHashMap<>();
            expectedError2.put("Occupation 2", "Field is required2.");
            expectedError2.put("Employer's name 2","Required field / Entered value contains forbidden characters 2");
            expectedError2.put("Start date 2","Field is required2.");

            Assert.assertEquals(
                    false,
                    CollectionUtils.isSubCollection( expectedError2.keySet(), errorHandler.keySet() )
                    ||
                    CollectionUtils.isSubCollection( expectedError2.values(), errorHandler.values() )
            );


//            pnlEmployed.get(0).select("")

            /*
            String content = jsoup.select("div[wicketpath=content]").outerHtml();
            Document jsoupContent = Jsoup.parse(content);
            Elements form = jsoupContent.select("form");

            for (Element currentForm: form) {
                System.out.println("begin form");
                Elements inputForm = currentForm.select("input[name]");
                for (Element currentElement: inputForm) {
                    System.out.println("name: " + currentElement.attr("name"));
                }

                Elements actionForm = currentForm.select("a[id~=submit]");
                for ( Element currentElement: actionForm) {
//                System.out.println("link to extract: " + currentElement.attr("onclick"));
                    Pattern pLink = Pattern.compile("\\.apply\\(this,\\['form(\\d|\\D){1,2}','form(\\d|\\D){1,2}','scAjax\\.apply\\(this,\\[\\d,\\d,\\\\'(;)*(.*)&\\$\\{scrollPos\\}\\\\'");
                    Matcher mLink = pLink.matcher(currentElement.attr("onclick"));

                    String link = StringUtils.EMPTY;
                    while (mLink.find()) {
                        link=mLink.group(4);
                    }
                    final String finalLink = link;
                    System.out.println("link: " + finalLink);
                }

                Elements stepToken = currentForm.select("input[name=stepToken]");
                for (Element currentElement: stepToken) {
                    System.out.println("stepToken: " + currentElement.attr("value"));
                }
                System.out.println("\n\n");
            }
            */
            System.out.println("... HTML Done");
        }

        System.out.println("End");
    }
}
