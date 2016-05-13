package com.r2development.leveris.utils.XpathBuilder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Table;
import com.r2development.leveris.utils.XpathBuilder.Enums.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Builder {

    private static final Log log = LogFactory.getLog(Builder.class.getName());

    public static final String
            input = "input",
            div = "div",
            a = "a",
            p = "p",
            id = "id",
            h1 = "h1",
            h2 = "h2",
            h3 = "h3",
            em = "em",
            href = "href",
            frag = "frag",
            class_att = "class",
            span = "span",
            button = "button",
            dropdown = "dropdown",
            select = "select",
            textarea = "textarea",
            singleSlash = "/",
            doubleSlash = "//",
            role = "role",
            datareactid = "data-reactid",
            type = "type",
            name = "name",
            title = "title",
            style = "style",
            disabled = "disabled",
            wicketpath = "wicketpath",
            dataPath = "data-path",
            ul = "ul",
            li = "li",
            text = "text()",
            checkbox = "checkbox",
            and = "and",
            contains = "contains",
            followingSibling = singleSlash + "following-sibling::",
            not = "not",
            notContains = not + contains,
            equals = "equals",
            notEquals = not + equals,
            label = "label";

    public static LinkedList<String> attributeValues(String value) {
        String[] values = new String[]{value};
        return attributeValues(values);
    }

    public static LinkedList<String> attributeValues(String value1, String value2) {
        String[] values = new String[]{value1, value2};
        return attributeValues(values);
    }

    public static LinkedList<String> attributeValues(String value1, String value2, String value3) {
        String[] values = new String[]{value1, value2, value3};
        return attributeValues(values);
    }

    private static LinkedList<String> attributeValues(String[] attributeValues) {
        LinkedList<String> classAttValues = new LinkedList<>();
        for (String attributeValue : attributeValues) {
            classAttValues.add(attributeValue);
        }
        return classAttValues;
    }

    public static LinkedListMultimap<String, LinkedList<String>> xPathAttributesMap(String attribute, LinkedList<String> attributeValue) {
        LinkedListMultimap<String, LinkedList<String>> map = LinkedListMultimap.create();
        map.put(attribute, attributeValue);
        return map;
    }

    public static LinkedListMultimap<String, String> xPathAttributesMap(LinkedListMultimap<String, String> map, String attribute, String attributeValue) {
        map.put(attribute, attributeValue);
        return map;
    }

    public static LinkedListMultimap<?, ?> xPathAttributesMap(LinkedListMultimap<String, String> map, LinkedListMultimap<String, String> map1) {
        map.putAll(map1);
        return map;
    }

    public static LinkedListMultimap<String, String> xPathAttributesMap(String attribute, String attributeValues) {
        LinkedListMultimap<String, String> attributesMap = LinkedListMultimap.create();
        attributesMap.put(attribute, attributeValues);
        return attributesMap;
    }

    public static Map<String, LinkedList<String>> xPathAttributesMap(Map<String, LinkedList<String>> attributesMap, String attribute, LinkedList<String> attributeValues) {
        attributesMap.put(attribute, attributeValues);
        return attributesMap;
    }

    public static Map<String, LinkedList<String>> xPathAttributesMap(Map<String, LinkedList<String>> addToAttributesMap1, Map<String, LinkedList<String>> addToAttributesMap2) {
        addToAttributesMap2.putAll(addToAttributesMap1);
        return addToAttributesMap1;
    }

    public static Table<String, String, String> gavaXpathMap(String action, LinkedListMultimap<String, LinkedList<String>> xPathAttributesMap) {
        Table<String, String, String> guavaMap = HashBasedTable.create();
        for (Map.Entry<String, LinkedList<String>> oneMapEntry : xPathAttributesMap.entries()) {
            for (String oneValue : oneMapEntry.getValue())
                guavaMap.put(action, oneMapEntry.getKey(), oneValue);
        }
        return guavaMap;
    }

    public static String element(String prefix, String element) {
        return prefix + element;
    }

    public static String element(String element) {
        return Builder.element(doubleSlash, element);
    }

    public static String followingElement(String element) {
        return Builder.element(singleSlash, element);
    }

    public static String followingSibling(String element) {
        return followingSibling + element;
    }

    public static String hasAsChild(String xpath) {
        return "[" + xpath + "]";
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String notContains(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + notContains(attribute, attributeValue);
    }

    public static String notContains(String element, String attribute, String attributeValue) {
        return element(element) + notContains(attribute, attributeValue);
    }

    public static String notContains(String attribute, String attributeValue) {
        if (attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + not + "(" + contains + "(" + text + ",'" + attributeValue + "'))]";
        return "[" + not + "(" + contains + "(@" + attribute + ",'" + attributeValue + "'))]";
    }

    private static String notContains(String attribute, LinkedList<String> notContainsValues) {
        String xpath = "";
        for (String value : notContainsValues) {
            xpath = xpath + notContains(attribute, value);
        }
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String contains(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + contains(attribute, attributeValue);
    }

    public static String contains(String element, String attribute, String attributeValue) {
        return element(element) + contains(attribute, attributeValue);
    }

    public static String contains(String attribute, String attributeValue) {
        if (attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + contains + "(" + text + ",'" + attributeValue + "')]";
        return "[" + contains + "(@" + attribute + ",'" + attributeValue + "')]";
    }

    public static String contains(String attribute, LinkedList<String> containsValues) {
        String xpath = "";
        for (String value : containsValues) {
            xpath = xpath + contains(attribute, value);
        }
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String notEqualsTo(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + notEqualsTo(attribute, attributeValue);
    }

    public static String notEqualsTo(String element, String attribute, String attributeValue) {
        return element(element) + notEqualsTo(attribute, attributeValue);
    }

    private static String notEqualsTo(String attribute, String attributeValue) {
        if (attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + not + "(" + text + "='" + attributeValue + "')]";
        return "[" + not + "(@" + attribute + "='" + attributeValue + "')]";
    }

    private static String notEqualsTo(String attribute, LinkedList<String> notEqualsValues) {
        String xpath = "";
        for (String value : notEqualsValues) {
            xpath = xpath + notEqualsTo(attribute, value);
        }
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String equalsTo(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + equalsTo(attribute, attributeValue);
    }

    public static String equalsTo(String element, String attribute, String attributeValue) {
        return element(element) + equalsTo(attribute, attributeValue);
    }

    public static String equalsTo(String attribute, String attributeValue) {
        if (attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + text + "='" + attributeValue + "']";
        return "[@" + attribute + "='" + attributeValue + "']";
    }

    public static String equalsTo(String attribute, LinkedList<String> equalsValues) {
        String xpath = "";
        for (String value : equalsValues) {
            xpath = xpath + equalsTo(attribute, value);
        }
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String contains(String singleOrDoubleSlash, String element, Map<String, String> attributeMap) {
        return element(singleOrDoubleSlash, element) + contains(attributeMap);
    }

    public static String contains(String element, Map<String, String> attributeMap) {
        return element(element) + contains(attributeMap);
    }

    public static String contains(Map<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry attributeEntry : attributeMap.entrySet())
            xpath = xpath + Builder.contains(attributeEntry.getKey().toString(), attributeEntry.getValue().toString());
        return xpath;
    }

    public static String contains(LinkedListMultimap<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry<String, String> attributeEntry : attributeMap.entries())
            xpath = xpath + Builder.contains(attributeEntry.getKey(), attributeEntry.getValue());
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String notContains(String singleOrDoubleSlash, String element, Map<String, String> attributeMap) {
        return element(singleOrDoubleSlash, element) + notContains(attributeMap);
    }

    public static String notContains(String element, Map<String, String> attributeMap) {
        return element(element) + notContains(attributeMap);
    }

    private static String notContains(Map<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry attributeEntry : attributeMap.entrySet())
            xpath = xpath + Builder.notContains(attributeEntry.getKey().toString(), attributeEntry.getValue().toString());
        return xpath;
    }

    public static String notContains(LinkedListMultimap<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry<String, String> attributeEntry : attributeMap.entries())
            xpath = xpath + Builder.notContains(attributeEntry.getKey(), attributeEntry.getValue());
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String equalsTo(String singleOrDoubleSlash, String element, Map<String, String> attributeMap) {
        return element(singleOrDoubleSlash, element) + equalsTo(attributeMap);
    }

    public static String equalsTo(String element, Map<String, String> attributeMap) {
        return element(element) + equalsTo(attributeMap);
    }

    public static String equalsTo(Map<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry wicket : attributeMap.entrySet())
            xpath = xpath + Builder.equalsTo(wicket.getKey().toString(), wicket.getValue().toString());
        return xpath;
    }

    public static String equalsTo(LinkedListMultimap<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry<String, String> wicket : attributeMap.entries())
            xpath = xpath + Builder.equalsTo(wicket.getKey(), wicket.getValue());
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String notEqualsTo(String singleOrDoubleSlash, String element, Map<String, String> attributeMap) {
        return element(singleOrDoubleSlash, element) + notEqualsTo(attributeMap);
    }

    public static String notEqualsTo(String element, Map<String, String> attributeMap) {
        return element(element) + notEqualsTo(attributeMap);
    }

    private static String notEqualsTo(Map<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry wicket : attributeMap.entrySet())
            xpath = xpath + Builder.notEqualsTo(wicket.getKey().toString(), wicket.getValue().toString());
        return xpath;
    }

    public static String notEqualsTo(LinkedListMultimap<String, String> attributeMap) {
        String xpath = "";
        for (Map.Entry<String, String> wicket : attributeMap.entries())
            xpath = xpath + Builder.notEqualsTo(wicket.getKey(), wicket.getValue());
        return xpath;
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    /**
     * @param singleOrDoubleSlash - String containing the relative or absolute path we want to use for targeted element
     * @param element             - String with element we want to target ( div|input|button|span|whatever html shows and we need to automate )
     * @param attributeMap        Map<String, String>
     *                            String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                            String - Targeted html attribute => is this value that will be used in xpath )
     * @return String xpath as this example : //div[contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue')]
     */
    public static String andContains(String singleOrDoubleSlash, String element, Map<String, LinkedList<String>> attributeMap) {
        return element(singleOrDoubleSlash, element) + andContains(attributeMap);
    }

    public static String orContains(String singleOrDoubleSlash, String element, Map<String, LinkedList<String>> attributeMap) {
        return element(singleOrDoubleSlash, element) + orContains(attributeMap);
    }

    /**
     * @param element      - String with element we want to target ( div|input|button|span|whatever html shows and we need to automate )
     * @param attributeMap Map<String, String>
     *                     String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                     String - Targeted html attribute => is this value that will be used in xpath )
     * @return String xpath as this example : //div[contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue')]
     */
    public static String andContains(String element, Map<String, LinkedList<String>> attributeMap) {
        return element(element) + andContains(attributeMap);
    }

    public static String orContains(String element, Map<String, LinkedList<String>> attributeMap) {
        return element(element) + orContains(attributeMap);
    }

    private static String andContains(String attribute, LinkedList<String> attributeValues) {
        return andActionContains(ACTION.AND, attribute, attributeValues);
    }

    private static String orContains(String attribute, LinkedList<String> attributeValues) {
        return andActionContains(ACTION.OR, attribute, attributeValues);
    }

    private static String andActionContains(ACTIONS action, String attribute, LinkedList<String> attributeValues) {
        if (action.getAction().equals(ACTION.CONTAINS)) {

            if (action.getPreAction().equals(PREFIX.OR)) {
                return andActionContains(ACTION.OR, attribute, attributeValues);
            } else if (action.getPreAction().equals(PREFIX.AND)) {
                return andActionContains(ACTION.AND, attribute, attributeValues);
            }
        } else if (action.getAction().equals(ACTION.EQUALS)) {

            if (action.getPreAction().equals(PREFIX.OR)) {
                return andActionEquals(ACTION.OR, attribute, attributeValues);
            } else if (action.getPreAction().equals(PREFIX.AND)) {
                return andActionEquals(ACTION.AND, attribute, attributeValues);
            }
        }
        Assert.assertTrue("Not implemented : " + action.getPreAction() + " " + action.getAction() + " xpath creation supported is now contains/equals and and/or ", false);
        return null;
    }

    private static String andActionEquals(ACTION action, String attribute, LinkedList<String> attributeValues) {
        if (!(action.equals(ACTION.AND) || action.equals(ACTION.OR))) {
            Assert.assertTrue("\n Builder method andActionContains(ACTION action, Map<String, List<String>> attributeMap) \n is only allowed to call with ACTION.AND or ACTION.OR values \n but we have detected ---> " + action.get() + " <--- \n please fix it", true);
        }
        LinkedList<String> containsBeforeSubstringAndContains = new LinkedList<>();
        // Changing list containing Values of attribute into List of xPaths contains attribute value for each entry of List
        containsBeforeSubstringAndContains.addAll(attributeValues.stream().map(attributeValue -> equalsTo(attribute, attributeValue)).collect(Collectors.toList()));
        // adding first entry as there is not being removed the first square bracket
        String xpath = containsBeforeSubstringAndContains.get(0).substring(0, containsBeforeSubstringAndContains.get(0).length() - 1);
        for (int i = 1; i < containsBeforeSubstringAndContains.size() - 1; i++) {
            // for cycle is skipping first value as that was already added when initializing String xpath
            xpath = xpath + " " + action.get() + " " + containsBeforeSubstringAndContains.get(i).substring(1, containsBeforeSubstringAndContains.get(i).length() - 1);
        }
        //for skipped also adding a last value as there we don't want to remove the last square bracket
        int listSize = containsBeforeSubstringAndContains.get(attributeValues.size() - 1).length();
        xpath = xpath + " " + action.get() + " " + containsBeforeSubstringAndContains.get(attributeValues.size() - 1).substring(1, listSize);
        return xpath;
    }

    private static String andActionContains(ACTION action, String attribute, LinkedList<String> attributeValues) {
        if (!(action.equals(ACTION.AND) || action.equals(ACTION.OR))) {
            Assert.assertTrue("\n Builder method andActionContains(ACTION action, Map<String, List<String>> attributeMap) \n is only allowed to call with ACTION.AND or ACTION.OR values \n but we have detected ---> " + action.get() + " <--- \n please fix it", true);
        }
        LinkedList<String> containsBeforeSubstringAndContains = new LinkedList<>();
        // Changing list containing Values of attribute into List of xPaths contains attribute value for each entry of List
        containsBeforeSubstringAndContains.addAll(attributeValues.stream().map(attributeValue -> contains(attribute, attributeValue)).collect(Collectors.toList()));
        // adding first entry as there is not being removed the first square bracket
        String xpath = containsBeforeSubstringAndContains.get(0).substring(0, containsBeforeSubstringAndContains.get(0).length() - 1);
        for (int i = 1; i < containsBeforeSubstringAndContains.size() - 1; i++) {
            // for cycle is skipping first value as that was already added when initializing String xpath
            xpath = xpath + " " + action.get() + " " + containsBeforeSubstringAndContains.get(i).substring(1, containsBeforeSubstringAndContains.get(i).length() - 1);
        }
        //for skipped also adding a last value as there we don't want to remove the last square bracket
        int listSize = containsBeforeSubstringAndContains.get(attributeValues.size() - 1).length();
        xpath = xpath + " " + action.get() + " " + containsBeforeSubstringAndContains.get(attributeValues.size() - 1).substring(1, listSize);
        return xpath;
    }

    public static String andContains(String singleOrDoubleSlash, String element, String attribute, LinkedList<String> attributeValuesList) {
        return element(singleOrDoubleSlash, element) + andContains(attribute, attributeValuesList);
    }

    public static String andContains(String element, String attribute, LinkedList<String> attributeValueList) {
        return element(element) + andContains(attribute, attributeValueList);
    }

    public static String orContains(String element, String attribute, LinkedList<String> attributeValueList) {
        return element(element) + orContains(attribute, attributeValueList);
    }

    private static String andContains(Map<String, LinkedList<String>> attributeMap) {
        return andActionContains(ACTION.AND, attributeMap);
    }

    public static String andContains(LinkedListMultimap<String, LinkedList<String>> values) {
        return andActionContains(ACTION.AND, values);
    }

    private static String orContains(Map<String, LinkedList<String>> attributeMap) {
        return andActionContains(ACTION.OR, attributeMap);
    }

    public static String orContains(LinkedListMultimap<String, LinkedList<String>> attributeMap) {
        return andActionContains(ACTION.OR, attributeMap);
    }

    private static String andActionContains(ACTION action, LinkedListMultimap<String, LinkedList<String>> attributeMap) {
        String xpath = "";
        for (Map.Entry<String, LinkedList<String>> oneMapEntry : attributeMap.entries()) {
            xpath = xpath + andActionContains(action, oneMapEntry.getKey(), oneMapEntry.getValue());
        }
        return xpath;
    }

    private static ACTIONS stringToACTIONS(String stringAction) {
        for (ACTIONS oneAction : ACTIONS.getValues()) {
            if (stringAction.equals(oneAction.get())) {
                return oneAction;
            }
        }
        Assert.assertTrue("String stringAction = '" + stringAction + "' is not convertible to any of following actions : " + ACTIONS.getValues(), false);
        return null;
    }

    /**
     * @param attributeMap Map<String, String>
     *                     String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                     String - Targeted html attributeValue => it is the value that will be used in xpath )
     * @return String xpath as this example : [contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue')]
     */
    private static String andActionContains(ACTION action, Map<String, LinkedList<String>> attributeMap) {

        if (!(action.equals(ACTION.AND) || action.equals(ACTION.OR))) {
            Assert.assertTrue("\n Builder method andActionContains(ACTION action, Map<String, List<String>> attributeMap) \n is only allowed to call with ACTION.AND or ACTION.OR values \n but we have detected ---> " + action.get() + " <--- \n please fix it", false);
        }

        String xpath = "";
        String partialXpath = "";
        String firstXpath = "";
        String lastXpath = "";

        int i = 1;
        for (Map.Entry attribute : attributeMap.entrySet()) {

            if (i == 1) {
                firstXpath = andActionContains(action, attribute.getKey().toString(), attributeMap.get(attribute.getKey().toString()));
            } else if (i == attributeMap.size()) {
                lastXpath = andActionContains(action, attribute.getKey().toString(), attributeMap.get(attribute.getKey().toString()));
            } else {
                partialXpath = andActionContains(action, attribute.getKey().toString(), attributeMap.get(attribute.getKey().toString()));
            }
            i++;
        }
        if (!Objects.equals(partialXpath, ""))
            return firstXpath.substring(0, firstXpath.length() - 1) + " " + action.get() + " " + partialXpath.substring(1, partialXpath.length() - 1) + action.get() + " " + lastXpath.substring(1, lastXpath.length());
        else if (!Objects.equals(lastXpath, ""))
            return firstXpath.substring(0, firstXpath.length() - 1) + " " + action.get() + " " + lastXpath.substring(1, lastXpath.length());
        else if (!Objects.equals(firstXpath, ""))
            return firstXpath;
        else
            Assert.assertTrue("mindless usage of andContains(Map<String, List<String>>)", false);
        return xpath;
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String containsWicket(String singleOrDoubleSlash, String element, String dataPathValue) {
        return element(singleOrDoubleSlash, element) + containsWicket(dataPathValue);
    }

    public static String containsWicket(String element, String dataPathValue) {
        return element(element) + containsWicket(dataPathValue);
    }

    public static String containsWicket(String wicketpathValue) {
        return Builder.contains(wicketpath, wicketpathValue);
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String equalsWicket(String singleOrDoubleSlash, String element, String dataPathValue) {
        return element(singleOrDoubleSlash, element) + equalsWicket(dataPathValue);
    }

    public static String equalsWicket(String element, String dataPathValue) {
        return element(element) + equalsWicket(dataPathValue);
    }

    public static String equalsWicket(String wicketpathValue) {
        return Builder.equalsTo(wicketpath, wicketpathValue);
    }

    /**
     * Todo following three methods are considered as one just with/without element and with/without absolute relative path
     */

    public static String dataPath(String singleOrDoubleSlash, String element, String dataPathValue) {
        return element(singleOrDoubleSlash, element) + dataPath(dataPathValue);
    }

    public static String dataPath(String element, String dataPathValue) {
        return element(element) + dataPath(dataPathValue);
    }

    public static String dataPath(String dataPathValue) {
        return Builder.equalsTo(dataPath, dataPathValue);
    }
}