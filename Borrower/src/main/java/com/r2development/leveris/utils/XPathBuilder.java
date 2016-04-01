package com.r2development.leveris.utils;

import com.google.common.collect.*;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;
import static com.r2development.leveris.utils.XPathBuilder.*;

public class XPathBuilder {

    public static final String
            input = "input",
            div = "div",
            a = "a",
            id = "id",
            h1 = "h1",
            h2 = "h2",
            href = "href",
            class_att = "class",
            span = "span",
            button = "button",
            select = "select",
            textarea = "textarea",
            singleSlash = "/",
            doubleSlash = "//",
            role = "role",
            type = "type",
            name = "name",
            disabled = "disabled",
            wicketpath = "wicketpath",
            dataPath = "data-path",
            ul = "ul",
            li = "li",
            text = "text()",
            and = "and",
            contains = "contains",
            followingSibling = singleSlash + "following-sibling::",
            not = "not",
            notContains = not + contains,
            equals = "equals",
            notEquals = not + equals,
            label = "label";


    public static String element(String singleOrDoubleSlash, String element){
        return singleOrDoubleSlash + element;
    }

    public static String element(String element){
        return XPathBuilder.element(doubleSlash, element);
    }

    public static String followingElement(String element){
        return XPathBuilder.element(singleSlash, element);
    }

    public static String followingSibling(String element){
        return followingSibling + element;
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String notContains(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + notContains(attribute, attributeValue);
    }

    public static String notContains(String element, String attribute, String attributeValue) {
        return element(element) + notContains(attribute, attributeValue);
    }

    public static String notContains(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + not + "(" + contains + "(" + text + ",'" + attributeValue + "'))]";
        return "[" + not + "(" + contains + "(@" + attribute + ",'" + attributeValue + "'))]";
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String contains(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + contains(attribute, attributeValue);
    }

    public static String contains(String element, String attribute, String attributeValue) {
        return element(element) + contains(attribute, attributeValue);
    }
    
    public static String contains(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + contains + "(" + text + ",'" + attributeValue + "')]";
        return "[" + contains + "(@" + attribute + ",'" + attributeValue + "')]";
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String notEqualsTo(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + notEqualsTo(attribute, attributeValue);
    }

    public static String notEqualsTo(String element, String attribute, String attributeValue) {
        return element(element) + notEqualsTo(attribute, attributeValue);
    }

    public static String notEqualsTo(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + not + "(" + text + "='" + attributeValue + "')]";
        return "[" + not + "(@" + attribute + "='" + attributeValue + "')]";
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String equalsTo(String singleOrDoubleSlash, String element, String attribute, String attributeValue) {
        return element(singleOrDoubleSlash, element) + equalsTo(attribute, attributeValue);
    }

    public static String equalsTo(String element, String attribute, String attributeValue) {
        return element(element) + equalsTo(attribute, attributeValue);
    }

    public static String equalsTo(String attribute, String attributeValue){
        if(attribute.equalsIgnoreCase("text") || attribute.equalsIgnoreCase(text))
            return "[" + text + "='" + attributeValue + "']";
        return "[@" + attribute + "='" + attributeValue + "']";
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String contains(String singleOrDoubleSlash, String element, Map<String, String> attributeMap){
        return element(singleOrDoubleSlash, element) + contains(attributeMap);
    }

    public static String contains(String element, Map<String, String> attributeMap){
        return element(element) + contains(attributeMap);
    }

    public static String contains(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry attributeEntry : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.contains(attributeEntry.getKey().toString(), attributeEntry.getValue().toString());
        return xpath;
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String notContains(String singleOrDoubleSlash, String element, Map<String, String> attributeMap){
        return element(singleOrDoubleSlash, element) + notContains(attributeMap);
    }

    public static String notContains(String element, Map<String, String> attributeMap){
        return element(element) + notContains(attributeMap);
    }

    public static String notContains(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry attributeEntry : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.notContains(attributeEntry.getKey().toString(), attributeEntry.getValue().toString());
        return xpath;
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String equalsTo(String singleOrDoubleSlash, String element, Map<String, String> attributeMap){
        return element(singleOrDoubleSlash, element) + equalsTo(attributeMap);
    }

    public static String equalsTo(String element, Map<String, String> attributeMap){
        return element(element) + equalsTo(attributeMap);
    }

    public static String equalsTo(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry wicket : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.equalsTo(wicket.getKey().toString(), wicket.getValue().toString());
        return xpath;
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String notEqualsTo(String singleOrDoubleSlash, String element, Map<String, String> attributeMap){
        return element(singleOrDoubleSlash, element) + notEqualsTo(attributeMap);
    }

    public static String notEqualsTo(String element, Map<String, String> attributeMap){
        return element(element) + notEqualsTo(attributeMap);
    }

    public static String notEqualsTo(Map<String, String> attributeMap){
        String xpath = "";
        for(Map.Entry wicket : attributeMap.entrySet())
            xpath = xpath + XPathBuilder.notEqualsTo(wicket.getKey().toString(), wicket.getValue().toString());
        return xpath;
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    /**
     *
     * @param singleOrDoubleSlash - String containing the relative or absolute path we want to use for targeted element
     * @param element - String with element we want to target ( div|input|button|span|whatever html shows and we need to automate )
     * @param attributeMap Map<String, String>
     *                             String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                             String - Targeted html attribute => is this value that will be used in xpath )
     * @return String xpath as this example : //div[contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue')]
     */
    public static String andContains(String singleOrDoubleSlash, String element, Map<String, String> attributeMap){
        return element(singleOrDoubleSlash, element) + andContains(attributeMap);
    }

    /**
     *
     * @param element - String with element we want to target ( div|input|button|span|whatever html shows and we need to automate )
     * @param attributeMap Map<String, String>
     *                             String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                             String - Targeted html attribute => is this value that will be used in xpath )
     * @return String xpath as this example : //div[contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue')]
     */
    public static String andContains(String element, Map<String, String> attributeMap){
        return element(element) + andContains(attributeMap);
    }

    /**
     *
     * @param attributeMap Map<String, String>
     *                             String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                             String - Targeted html attribute => is this value that will be used in xpath )
     * @return String xpath as this example : [contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue') and contains(@attribute,'attributeValue')]
     */
    public static String andContains(Map<String, String> attributeMap){
        int i = 0;
        String xpath = "";
        for(Map.Entry attribute : attributeMap.entrySet()){

                if(i==0) {
                    int length = contains(attribute.getKey().toString(), attribute.getValue().toString()).length();
                    //removing the ending square bracket to be able to connect the following andContains -- > [contains(@attribute,'attributeValue')] and contains(@attribute,'attributeValue')]
                    xpath = contains(attribute.getKey().toString(), attribute.getValue().toString()).substring(0, length - 1);
                }
                String addedXpathPair = contains(attribute.getKey().toString(), attribute.getValue().toString());
                int length = addedXpathPair.length();
                addedXpathPair = addedXpathPair.substring(1, length - 1);
                xpath = xpath + and + " " + addedXpathPair;
            i++;
        }
        xpath = xpath + "]";
        return xpath;
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    /**
     *
     * @param element - String with element we want to target ( div|input|button|span|whatever html shows and we need to automate )
     * @param attributeGavaMap -   Table<String, String, String>
     *                             String - ( contains|equals|notcontains|notequals ),
     *                             String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                             String - Targeted html attribute => is this value that will be used in xpath )
     * @return String xpath as this example : //div[contains(@attribute,'attributeValue')][not(contains(@attribute,'attributeValue'))][@attribute='attributeValue'][not(@attribute='attributeValue')]
     */
    public static String xpath(String element, Table<String, String, String> attributeGavaMap){
        return element(element) + xpath(attributeGavaMap);
    }

    /**
     *
     * @param singleSlashOrDoubleSlash - String containing the relative or absolute path we want to use for targeted element
     * @param element - String with element we want to target ( div|input|button|span|whatever html shows and we need to automate )
     * @param attributeGavaMap -   Table<String, String, String>
     *                             String - ( contains|equals|notcontains|notequals ),
     *                             String - Targeted html attribute used in xpath ( id|href|class|text|.... ),
     *                             String - Targeted html attribute => is this value that will be used in xpath )
     *
     * @return String xpath as this example : /div[contains(@attribute,'attributeValue')][not(contains(@attribute,'attributeValue'))][@attribute='attributeValue'][not(@attribute='attributeValue')]
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

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String containsWicket(String singleOrDoubleSlash, String element, String dataPathValue){
        return element(singleOrDoubleSlash, element) + containsWicket(dataPathValue);
    }

    public static String containsWicket(String element, String dataPathValue){
        return element(element) + containsWicket(dataPathValue);
    }

    public static String containsWicket(String wicketpathValue){
        return XPathBuilder.contains(wicketpath, wicketpathValue);
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String equalsWicket(String singleOrDoubleSlash, String element, String dataPathValue){
        return element(singleOrDoubleSlash, element) + equalsWicket(dataPathValue);
    }

    public static String equalsWicket(String element, String dataPathValue){
        return element(element) + equalsWicket(dataPathValue);
    }

    public static String equalsWicket(String wicketpathValue){
        return XPathBuilder.equalsTo(wicketpath, wicketpathValue);
    }

    /** Todo following three methods are considered as one just with/without element and with/without absolute relative path */

    public static String dataPath(String singleOrDoubleSlash, String element, String dataPathValue){
        return element(singleOrDoubleSlash, element) + dataPath(dataPathValue);
    }

    public static String dataPath(String element, String dataPathValue){
        return element(element) + dataPath(dataPathValue);
    }

    public static String dataPath(String dataPathValue){
        return XPathBuilder.equalsTo(dataPath, dataPathValue);
    }
}

/**
 * Example Usage implementations
 */
class XPathBuilder_exampleUsage {

    String INPUT = element(singleSlash, input);
    String LABEL = element(label) + contains(id, label);


    Map<String, String> wicketMap = new HashMap<String, String>() {
        {
            put(wicketpath, "wicket1");
            put(wicketpath, "wicket2");
            put(wicketpath, "wicket3");
        }
    };

    Map<String, String> xpathParamMap = new HashMap<String, String>() {
        {
            put(id, "id");
            put(text, "toto");
        }
    };

    String SORT_CODE2 = dataPath(div, "pnlAddSource pnlAccNumb txtSortCode2") + contains(wicketMap) + equalsTo(xpathParamMap);

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH = SORT_CODE2 + INPUT;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_LABEL_XPATH = SORT_CODE2 + LABEL;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH = SORT_CODE2 + INPUT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_LABEL_XPATH = SORT_CODE2 + LABEL;


    String SORT_CODE3 = dataPath(div, "pnlAddSource pnlAccNumb txtSortCode3");      //"//div[@data-path='pnlAddSource pnlAccNumb txtSortCode3']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH = SORT_CODE3 + INPUT;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_LABEL_XPATH = SORT_CODE3 + LABEL;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH = SORT_CODE3 + INPUT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_LABEL_XPATH = SORT_CODE3 + LABEL;


    String ACCOUNT_NUMBER = containsWicket("pnlAddSource") + containsWicket("pnlAccNumb") + containsWicket("txtAccnumber"); //"[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccNumb')][contains(@wicketpath,'txtAccnumber')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_LABEL_XPATH = "//label" + ACCOUNT_NUMBER;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH = "//input" + ACCOUNT_NUMBER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_LABEL_XPATH = "//label" + ACCOUNT_NUMBER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH = "//input" + ACCOUNT_NUMBER;

    Map<String, String> andContainsMap = new HashMap<String, String>() {
        {
            put(wicketpath, "pnlAddSource");
            put(wicketpath, "pnlAccountProvider");
            put(wicketpath, "txtAccountProvider");
        }
    };

    String ACCOUNT_PROVIDER = andContains(andContainsMap);            //"[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccountProvider')][contains(@wicketpath,'txtAccountProvider')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_LABEL_XPATH = "//label" + ACCOUNT_PROVIDER;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH = "//input" + ACCOUNT_PROVIDER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_LABEL_XPATH = andContains(label, andContainsMap);
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH = andContains(input, andContainsMap);

    Map<String, String> andContainsMapIban = new HashMap<String, String>() {
        {
            put(wicketpath, "pnlAddSource");
            put(wicketpath, "pnlLastFourDigits_");
            put(wicketpath, "txtIban");
        }
    };

    String IBAN = andContains(andContainsMapIban);
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_LABEL_XPATH = element(label) + IBAN;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_INPUT_XPATH = element(input) + IBAN;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_LABEL_XPATH = element(label) + IBAN;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH = element(input) + IBAN;

    Map<String, String> andContainsMapBalance = new HashMap<String, String>() {
        {
            put(wicketpath, "pnlAddSource");
            put(wicketpath, "pnlAccountBalance");
            put(wicketpath, "crbAccountBalance");
        }
    };

    String ACCOUNT_BALANCE = andContains(andContainsMapBalance);                                    //"[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccountBalance')][contains(@wicketpath,'crbAccountBalance')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_LABEL_XPATH = element(label) + ACCOUNT_BALANCE;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH = element(input) + ACCOUNT_BALANCE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_LABEL_XPATH = element(label) + ACCOUNT_BALANCE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH = element(input) + ACCOUNT_BALANCE;

    String DIRECT_SELECT = followingElement(select),
            DIRECT_SPAN = element(singleSlash, span), //"/span",
            DIV = element(div), //"//div",
            DIRECT_DIV = followingElement(div), //"/div",
            DIRECT_INPUT = followingElement(input), //"/input",
            DIRECT_A = followingElement(a), //"/a",

    NOT_DISABLED = notContains(disabled, disabled), //"[not(contains(@disabled,'disabled'))]",

    BASIC_INFO_WICKET = containsWicket("BasicInfo"), //"[contains(@wicketpath,'BasicInfo')]",
            LOAN_PURPOSE_WICKET = containsWicket("LoanPurpose"), //"[contains(@wicketpath,'LoanPurpose')]",
            COMBOBOX_WICKET = containsWicket("combobox"), //"[contains(@wicketpath,'combobox')]",
            UNSECURED_LOAN_WICKET = containsWicket("UnsecuredLoanQuotation"), //"[contains(@wicketpath,'UnsecuredLoanQuotation')]",
            NET_MONTHLY_INCOME_WICKET = containsWicket("NetMonthlyIncome"), //"[contains(@wicketpath,'NetMonthlyIncome')]",
            MONTHLY_EXPENSES_WICKET = containsWicket("MonthlyExpenses"), //"[contains(@wicketpath,'MonthlyExpenses')]",
            NUMBER_OF_DEPENDANTS_WICKET = containsWicket("NumberOfDependents"), //"[contains(@wicketpath,'NumberOfDependents')]",
            AMOUNT_TO_BORROW_WICKET = containsWicket("AmountToBorrow"), //"[contains(@wicketpath,'AmountToBorrow')]",
            BTN_CONTINUE_WICKET = containsWicket("Continue"), //"[contains(@wicketpath,'Continue')]",
            SUBMIT_WICKET = containsWicket("submit"), //"[contains(@wicketpath,'submit')]",

    TEXT_BASIC_INFO = equalsTo(text, "Basic info about you should give us."), //"[text()='Basic info about you should give us.']",
            TEXT_UNSECURED_LOAN = equalsTo(text, "Unsecured Loan"),
            TEXT_CONTINUE = equalsTo(text, "Continue");

    private static final Table<String, String, String> guavaMap;
    static
    {
        guavaMap = HashBasedTable.create();

        guavaMap.put(contains, "style", "display: block");
        guavaMap.put(notContains, "style", "display: none");
        guavaMap.put(equals, "class", "ui-menu-item");
    }

    String DROP_DOWN_LIST = xpath(ul, guavaMap); //"//ul[contains(@style,'display: block')][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']",
}