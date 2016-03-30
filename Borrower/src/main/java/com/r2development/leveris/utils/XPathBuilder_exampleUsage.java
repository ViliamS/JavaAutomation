package com.r2development.leveris.utils;

import java.util.HashMap;
import java.util.Map;

import static com.r2development.leveris.utils.XPathBuilder.*;

public class XPathBuilder_exampleUsage {

    String INPUT = element(singleSlash, input);
    String LABEL = element(label) + contains(id, label);


    Map<String, String> wicketMap = new HashMap<String, String>(){
        {
            put(wicketpath, "wicket1");
            put(wicketpath, "wicket2");
            put(wicketpath, "wicket3");
        }
    };

    Map<String, String> xpathParamMap = new HashMap<String, String>(){
        {
            put(id, "id");
            put(text, "toto");
        }
    };

    String SORT_CODE2 = element(div) + dataPath("pnlAddSource pnlAccNumb txtSortCode2") + contains(wicketMap) + XPathBuilder.equalsTo(xpathParamMap);

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH = SORT_CODE2 + INPUT;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_LABEL_XPATH = SORT_CODE2 + LABEL;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH = SORT_CODE2 + INPUT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_LABEL_XPATH = SORT_CODE2 + LABEL;


    String SORT_CODE3 = "//div[@data-path='pnlAddSource pnlAccNumb txtSortCode3']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH = SORT_CODE3 + INPUT;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_LABEL_XPATH = SORT_CODE3 + LABEL;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH = SORT_CODE3 + INPUT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_LABEL_XPATH = SORT_CODE3 + LABEL;


    String ACCOUNT_NUMBER = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccNumb')][contains(@wicketpath,'txtAccnumber')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_LABEL_XPATH = "//label" + ACCOUNT_NUMBER;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH = "//input" + ACCOUNT_NUMBER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_LABEL_XPATH = "//label" + ACCOUNT_NUMBER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH = "//input" + ACCOUNT_NUMBER;

    String ACCOUNT_PROVIDER = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccountProvider')][contains(@wicketpath,'txtAccountProvider')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_LABEL_XPATH = "//label" + ACCOUNT_PROVIDER;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH = "//input" + ACCOUNT_PROVIDER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_LABEL_XPATH = "//label" + ACCOUNT_PROVIDER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH = "//input" + ACCOUNT_PROVIDER;

    String IBAN = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlLastFourDigits_')][contains(@wicketpath,'txtIban')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_LABEL_XPATH = "//label" + IBAN;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_INPUT_XPATH = "//input" + IBAN;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_LABEL_XPATH = "//label" + IBAN;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_IBAN_INPUT_XPATH = "//input" + IBAN;

    String ACCOUNT_BALANCE = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccountBalance')][contains(@wicketpath,'crbAccountBalance')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_LABEL_XPATH = "//label" + ACCOUNT_BALANCE;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH = "//input" + ACCOUNT_BALANCE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_LABEL_XPATH = "//label" + ACCOUNT_BALANCE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH = "//input" + ACCOUNT_BALANCE;

    String OVERDRAFT = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlOverDraft')][contains(@wicketpath,'crbOverdraft')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_LABEL_XPATH = "//label" + OVERDRAFT;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_INPUT_XPATH = "//input" + OVERDRAFT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_LABEL_XPATH = "//label" + OVERDRAFT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_OVERDRAFT_INPUT_XPATH = "//input" + OVERDRAFT;

    String SAVING_SOURCE = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlSourceOfSavings')][contains(@wicketpath,'cmbSourceOfSavings')]";

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_LABEL_XPATH = "//label" + SAVING_SOURCE;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_INPUT_XPATH = "//input" + SAVING_SOURCE;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_SELECT_XPATH = "//select" + SAVING_SOURCE;

    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_LABEL_XPATH = "//label" + SAVING_SOURCE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_INPUT_XPATH = "//input" + SAVING_SOURCE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_SELECT_XPATH = "//select" + SAVING_SOURCE;

    String REGULAR_MONTHLY_SAVINGS = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlRegularMonthlySavings')][contains(@wicketpath,'crbRegularMonthlySavings')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_LABEL_XPATH = "//label" + REGULAR_MONTHLY_SAVINGS;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH = "//input" + REGULAR_MONTHLY_SAVINGS;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_LABEL_XPATH = "//label" + REGULAR_MONTHLY_SAVINGS;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH = "//input" + REGULAR_MONTHLY_SAVINGS;


    String  DIRECT_SELECT = "/select",
            DIRECT_SPAN =   "/span",
            DIV =           "//div",
            DIRECT_DIV =    "/div",
            DIRECT_INPUT =  "/input",
            DIRECT_A =      "/a",

            NOT_DISABLED = "[not(contains(@disabled,'disabled'))]",

            BASIC_INFO_WICKET =             "[contains(@wicketpath,'BasicInfo')]",
            LOAN_PURPOSE_WICKET =           "[contains(@wicketpath,'LoanPurpose')]",
            COMBOBOX_WICKET =               "[contains(@wicketpath,'combobox')]",
            UNSECURED_LOAN_WICKET =         "[contains(@wicketpath,'UnsecuredLoanQuotation')]",
            NET_MONTHLY_INCOME_WICKET =     "[contains(@wicketpath,'NetMonthlyIncome')]",
            MONTHLY_EXPENSES_WICKET =       "[contains(@wicketpath,'MonthlyExpenses')]",
            NUMBER_OF_DEPENDANTS_WICKET =   "[contains(@wicketpath,'NumberOfDependents')]",
            AMOUNT_TO_BORROW_WICKET =       "[contains(@wicketpath,'AmountToBorrow')]",
            BTN_CONTINUE_WICKET =           "[contains(@wicketpath,'Continue')]",
            SUBMIT_WICKET =                 "[contains(@wicketpath,'submit')]",

            TEXT_BASIC_INFO =       "[text()='Basic info about you should give us.']",
            TEXT_UNSECURED_LOAN =   "[text()='Unsecured Loan']",
            TEXT_CONTINUE =         "[text()='Continue']",
            DROP_DOWN_LIST = "//ul[contains(@style,'display: block')][not(contains(@style,'display: none'))]/li[@class='ui-menu-item']",

            UNSECURED_LOAN_AREA =   DIV + UNSECURED_LOAN_WICKET + DIRECT_DIV    + UNSECURED_LOAN_WICKET,
            UNSECURED_LOAN_SPACE =  DIV + UNSECURED_LOAN_WICKET + DIV           + UNSECURED_LOAN_WICKET,

            UNSECURED_LOAN_TITLE =          UNSECURED_LOAN_AREA     + DIRECT_SPAN                   + TEXT_UNSECURED_LOAN,
            BASIC_INFO_TITLE =              UNSECURED_LOAN_AREA     + BASIC_INFO_WICKET             + DIRECT_SPAN + TEXT_BASIC_INFO,
            LOAN_PURPOSE_XPATH =            UNSECURED_LOAN_SPACE    + LOAN_PURPOSE_WICKET           + INPUT        + LOAN_PURPOSE_WICKET + NOT_DISABLED,
            NET_MONTHLY_INCOME_INPUT =      UNSECURED_LOAN_SPACE    + NET_MONTHLY_INCOME_WICKET     + DIRECT_INPUT + NOT_DISABLED,
            MONTHLY_EXPENSES_INPUT =        UNSECURED_LOAN_SPACE    + MONTHLY_EXPENSES_WICKET       + DIRECT_INPUT + NOT_DISABLED,
            NUMBER_OF_DEPENDANTS_INPUT =    UNSECURED_LOAN_SPACE    + NUMBER_OF_DEPENDANTS_WICKET   + DIRECT_INPUT + NOT_DISABLED,
            AMOUNT_TO_BORROW_INPUT =        UNSECURED_LOAN_SPACE    + AMOUNT_TO_BORROW_WICKET       + DIRECT_INPUT + NOT_DISABLED,
            CONTINUE_TEAL_BUTTON_XPATH =    UNSECURED_LOAN_SPACE    + BTN_CONTINUE_WICKET + DIRECT_A + BTN_CONTINUE_WICKET + SUBMIT_WICKET + DIRECT_SPAN + TEXT_CONTINUE;


}
