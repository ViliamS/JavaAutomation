package com.r2development.leveris.utils;

import com.google.common.collect.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class XPathBuilder {

    public static final String
            input = "input",
            div = "div",
            a = "a",
            id = "id",
            h2 = "h2",
            href = "href",
            span = "span",
            button = "button",
            textarea = "textarea",
            singleSlash = "/",
            doubleSlash = "//",
            wicketpath = "wicketpath",
            dataPath = "data-path",
            li = "li",
            text = "text()",
            contains = "contains",
            not = "not",
            notContains = not + contains,
            equals = "equals",
            notEquals = not + equals,
            label = "label";

    public static String element(String element){
        return XPathBuilder.element(doubleSlash, element);
    }

    public static String followingElement(String element){
        return XPathBuilder.element(singleSlash, element);
    }

    public static String element(String singleOrDoubleSlash, String element){
        return singleOrDoubleSlash + element;
    }

    public static String notContains(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + not + "(" + contains + "(" + text + ",'" + attributeValue + "'))]";
        return "[" + not + "(" + contains + "(@" + attribute + ",'" + attributeValue + "'))]";
    }
    
    public static String contains(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + contains + "(" + text + ",'" + attributeValue + "')]";
        return "[" + contains + "(@" + attribute + ",'" + attributeValue + "')]";
    }

    public static String notEqualsTo(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + not + "(" + text + "='" + attributeValue + "')]";
        return "[" + not + "(@" + attribute + "='" + attributeValue + "')]";
    }
    
    public static String equalsTo(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + text + "='" + attributeValue + "']";
        return "[@" + attribute + "='" + attributeValue + "']";
    }

    public static String contains(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry attributeEntry : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.contains(attributeEntry.getKey().toString(), attributeEntry.getValue().toString());
        return xpath;
    }

    public static String notContains(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry attributeEntry : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.notContains(attributeEntry.getKey().toString(), attributeEntry.getValue().toString());
        return xpath;
    }

    public static String equalsTo(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry wicket : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.equalsTo(wicket.getKey().toString(), wicket.getValue().toString());
        return xpath;
    }

    public static String notEqualsTo(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry wicket : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.notEqualsTo(wicket.getKey().toString(), wicket.getValue().toString());
        return xpath;
    }

    public static String andContains(Map<String, List<String>> attributeMap){
        int i = 0;
        String xpath = "";

//        for(Map.Entry attribute : attributeMap.entrySet()){
//
//                if(i==0) {
//
//                    int length = contains(attribute.getKey().toString(), attribute.getValue().toString()).length();
//                    //removing the ending square bracket to be able to connect the following andContains -- > [contains(@attribute,'attributeValue')] and contains(@attribute,'attributeValue')]
//                    xpath = contains(attribute.getKey().toString(), attribute.getValue().toString()).substring(0, length - 1);
//
//
//                }
//                xpath = xpath + "";
//
//
//
//
//            i++;
//
//
//        }

        return "[contains()]";
    }

    public static String xpath(String element, Table<String, String, String> attributeGavaMap){
        return element(element) + xpath(attributeGavaMap);
    }

    /**
     *
     * @param singleSlashOrDoubleSlash -
     * @param element
     * @param attributeGavaMap
     * @return
     */
    public static String xpath(String singleSlashOrDoubleSlash, String element, Table<String, String, String> attributeGavaMap){
        return element(singleSlashOrDoubleSlash, element) + xpath(attributeGavaMap);
    }

    /**
     * @param attributeGavaMap -   Table<String, String, String>
     *                             String - ( contains|equals|notcontains|notequals ),
     *                             String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                             String - Targeted html attribute => is this value that will be used in xpath )
     *
     * @return - an Xpath as this example shows : [contains(@attribute,'attributeValue')][not(contains(@attribute,'attributeValue'))][@attribute='attributeValue'][not(@attribute='attributeValue')]
     */
    public static String xpath(Table<String, String, String> attributeGavaMap){
        String xpath = "";
        for ( String rowKey : attributeGavaMap.rowKeySet() ){
            Map<String, String> attributeMap = attributeGavaMap.row(rowKey);
            switch (rowKey){
                case "contains":
                    xpath = xpath + XPathBuilder.contains(attributeMap);
                    break;
                case "notcontains":
                    xpath = xpath + XPathBuilder.notContains(attributeMap);
                    break;
                case "equals":
                    xpath = xpath + XPathBuilder.equalsTo(attributeMap);
                    break;
                case "notequals":
                    xpath = xpath + XPathBuilder.notEqualsTo(attributeMap);
                    break;
                default:
                    Assert.assertEquals(
                            "\n !------------------------------------------------------------------------------------! \n " +
                                "Incorrect filling of XPathBuilder allowed is only (contains|equals|notcontains|notequals) \n " +
                                "but you have used :'" + attributeMap + "'",
                            true,
                            false
                    );
            }
        }
        return xpath;
    }

    public static String containsWicket(String wicketpathValue){
        return XPathBuilder.contains(wicketpath, wicketpathValue);
    }

    public static String equalsWicket(String wicketpathValue){
        return XPathBuilder.equalsTo(wicketpath, wicketpathValue);
    }

    public static String dataPath(String dataPathValue){
        return XPathBuilder.equalsTo(dataPath, dataPathValue);
    }








//
//    public static String cXpath(String element, String attribute, String attributeValue){
//        return doubleSlash + element + contains(attribute, attributeValue);
//    }
//
//    public static String xpath(String element, String attribute, String attributeValue){
//        return doubleSlash + element + equalsTo(attribute, attributeValue);
//    }
//
//    public static String cWicket(String element, String wicketpathValue){
//        return cXpath(element, wicketpath, wicketpathValue);
//    }
//
//    public static String wicket(String element, String wicketpathValue){
//        return xpath(element, wicketpath, wicketpathValue);
//    }
//
//    public static String andCWicket(String wicketpathValue){
//        return contains(wicketpath, wicketpathValue);
//    }
//
//    public static String dataPathDiv(String dataPathValue){
//        return xpath(div, dataPath, dataPathValue);
//    }
}