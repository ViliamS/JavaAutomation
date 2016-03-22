package com.r2development.leveris.selenium.borrower.pageobjects;

public class XPathBuilder {

    public static final String
            input = "input",
            div = "div",
            a = "a",
            button = "button",
            textarea = "textarea",
            singleSlash = "/",
            doubleSlash = "//",
            wicketpath = "wicketpath",
            dataPath = "data-path",
            text = "text()",
            contains = "contains";

    public static String contains(String parameter, String parameterValue){
        if(parameter.equalsIgnoreCase("text") || parameter.equalsIgnoreCase(text))
            return "[" + contains + "(" + text + ",'" + parameterValue + "']";
        return "[" + contains + "(@" + parameter + ",'" + parameterValue + "')]";
    }

    public static String equals(String parameter, String parameterValue){
        if(parameter.equalsIgnoreCase("text") || parameter.equalsIgnoreCase(text))
            return "[" + text + "='" + parameterValue + "']";
        return "[@" + parameter + "='" + parameterValue + "']";
    }

    public static String cXpath(String element, String parameter, String parameterValue){
        return doubleSlash + element + contains(parameter, parameterValue);
    }

    public static String xpath(String element, String parameter, String parameterValue){
        return doubleSlash + element + equals(parameter, parameterValue);
    }

    public static String cWicket(String element, String wicketpathValue){
        return cXpath(element, wicketpath, wicketpathValue);
    }

    public static String wicket(String element, String wicketpathValue){
        return xpath(element, wicketpath, wicketpathValue);
    }

    public static String andCWicket(String wicketpathValue){
        return contains(wicketpath, wicketpathValue);
    }

    public static String dataPathDiv(String dataPathValue){
        return xpath(div, dataPath, dataPathValue);
    }
}