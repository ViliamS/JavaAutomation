package com.r2development.leveris.tdd.borrower;

import org.junit.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.core.Is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;

public class WicketUtilsTest {

    public static void main(String... args) throws IOException, URISyntaxException {

//        File file = new File(WicketUtilsTest.class.getClassLoader().getResource("./WicketResponse/automaticRegistrationPage1.txt").toURI());
//        File file = new File(WicketUtilsTest.class.getClassLoader().getResource("./WicketResponse/automaticRegistrationPage2.txt").toURI());
//        File file = new File(WicketUtilsTest.class.getClassLoader().getResource("./WicketResponse/home.txt").toURI());
        File file = new File(WicketUtilsTest.class.getClassLoader().getResource("./WicketResponse/dashboard.txt").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));

        if (FileUtils.readFileToString(file).contains("<ajax-response>")) {

            Document jsoup = Jsoup.parse(FileUtils.readFileToString(file));

            Elements evaluateElts = jsoup.select("evaluate");

            Elements headerElts = jsoup.select("header-contribution");
            Document headerDoc = Jsoup.parse(jsoup.select("header-contribution").first().text());

            Document componentDoc = null;
            String[] componentId = { "main", "form", "dialog" };
            for ( int i=0; i<componentId.length; i++) {
                try {
                    componentDoc = Jsoup.parse(jsoup.select("component[id~="+componentId[i]+"]").select("component[encoding~=wicket]").first().text());
                    System.out.println("is " + componentId[i]);
                    break;
                }
                catch (NullPointerException npe) {
                    System.out.println("isnot " + componentId[i]);
                }
            }

            Assert.assertNotNull(componentDoc);
            Elements form = componentDoc.select("form");

            for (Element currentForm: form) {
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

                Elements scriptForm = currentForm.select("a[id~=script]");
                for ( Element currentElement: scriptForm) {
                    currentElement.attr("id");
                }


                Elements stepToken = currentForm.select("input[name=stepToken]");
                for (Element currentElement: stepToken) {
                    System.out.println("stepToken: " + currentElement.attr("value"));
                }
            }

            System.out.println("... Ajax Done");

        } else {
            Document jsoup = Jsoup.parse(FileUtils.readFileToString(file));
//            System.out.println("jsoup: \n\n" + jsoup);

//            Elements javascriptElementLists = jsoup.select("script[type=text/javascript]");
//            String version = jsoup.select("div[wicketpath=version]").outerHtml();

//            Elements anyLink = jsoup.select("a");
//            String header = jsoup.select("div[wicketpath=initialMenuWrapper]").outerHtml();
//            Document jsoupHeader = Jsoup.parse(header);
//            Elements lnkHeader = jsoupHeader.getElementsByTag("div[wicketpath=initialMenuWrapper] a");

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

            System.out.println("... HTML Done");
        }

        System.out.println("End");
    }
}
