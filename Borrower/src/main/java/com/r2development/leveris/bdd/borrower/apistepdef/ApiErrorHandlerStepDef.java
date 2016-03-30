package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.r2development.leveris.di.IHttpResponse;
import cucumber.api.java.en.Then;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiErrorHandlerStepDef {

    @Inject
    IHttpResponse httpResponse;

    private Map<String, String> errorHandler;

    ApiErrorHandlerStepDef() {
        errorHandler = new LinkedHashMap<>();
    }

    @Then("^(Borrower) sees these errors messages$")
    public void borrower_sees_these_error_messages(String userType, Map<String, String> values) {

        errorHandler = getErrorHandler();

        Assert.assertEquals(
                true,
                CollectionUtils.isSubCollection(
                        errorHandler.keySet(),
                        values.keySet()
                )
                &&
                CollectionUtils.isSubCollection(
                        errorHandler.values(),
                        values.values()
                )
        );
    }

    @Then("^(Borrower) don't see these errors message$")
    public void borrower_do_not_sees_these_error_messages(String userType, Map<String, String> values) {
        Assert.assertEquals(
                true,
                CollectionUtils.isSubCollection(values.keySet(), errorHandler.keySet())
                ||
                CollectionUtils.isSubCollection(values.values(), errorHandler.values())
        );
    }

    private Map<String, String> getErrorHandler() {

        Map<String, String>  toReturn = null;
        Document jsoup = Jsoup.parse(httpResponse.getHttpResponse());

        Document componentDoc = null;
        String[] componentId = { "main", "form", "dialog", "feedback" };
        String currentComponentId = StringUtils.EMPTY;
        for (String aComponentId : componentId) {
            try {
                componentDoc = Jsoup.parse(jsoup.select("component[id~=" + aComponentId + "]").first().text());
                System.out.println("is " + aComponentId);
                currentComponentId = aComponentId;
                break;
            } catch (NullPointerException npe) {
                System.out.println("isnot " + aComponentId);
            }
        }

        if (httpResponse.getHttpResponse().contains("<ajax-response>")) {

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

            }
            else {
                toReturn = new LinkedHashMap<>();
                Elements liList = componentDoc.select("li");
                for ( Element currentLi : liList ) {
                    String divTitle = currentLi.select("div[class=title]").first().text();
                    String divDesc = currentLi.select("div[class=desc]").first().text();
                    errorHandler.put(divTitle, divDesc);
                }
            }

        } else {

            Elements pnlEmployed = jsoup.select("div[id~=pnlEmployed]");
            Assert.assertEquals(1, pnlEmployed.size());

            toReturn = new LinkedHashMap<>();
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

//            Map<String, String> expectedError = new LinkedHashMap<>();
//            expectedError.put("Occupation", "Field is required.");
//            expectedError.put("Employer's name","Required field / Entered value contains forbidden characters");
//            expectedError.put("Employment type","Field is required.");
//            expectedError.put("Start date","Field is required.");
//            expectedError.put("Net Income (monthly)","Field is required / Entered currency amount must be a number from 0 to 99 999 999");

//            Assert.assertEquals(true, CollectionUtils.isEqualCollection( errorHandler.keySet(), expectedError.keySet() ) && CollectionUtils.isEqualCollection( errorHandler.values(), expectedError.values() ));

//            Map<String, String> expectedError2 = new LinkedHashMap<>();
//            expectedError2.put("Occupation 2", "Field is required2.");
//            expectedError2.put("Employer's name 2","Required field / Entered value contains forbidden characters 2");
//            expectedError2.put("Start date 2","Field is required2.");

//            Assert.assertEquals(
//                    false,
//                    CollectionUtils.isSubCollection( expectedError2.keySet(), errorHandler.keySet() )
//                            ||
//                            CollectionUtils.isSubCollection( expectedError2.values(), errorHandler.values() )
//            );


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

        }

        return toReturn;
    }

}
