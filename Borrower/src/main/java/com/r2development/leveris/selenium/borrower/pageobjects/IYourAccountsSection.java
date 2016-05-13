package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.common.collect.LinkedListMultimap;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;
import com.r2development.leveris.utils.XpathBuilder.*;

import java.util.LinkedList;
import java.util.Map;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IYourAccountsSection {

    String YOUR_ACCOUNTS_TITLE_XPATH = getXPath(ELEMENTS.H2, ACTIONS.CONTAINS, ATTRIBUTES.ANY, "Your accounts");

    LinkedListMultimap<ATTRIBUTES, XPathValues> attributes = new XPathAttributes(ATTRIBUTES.WICKETPATH, "main_c_title").addEntryToMultimap(ATTRIBUTES.TEXT, "Your accounts").getXpathAttributesListMap();
    LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> elements = new XPathActionsElements(new XPathElement(PREFIX.DOUBLE_SLASH, ELEMENTS.H2), ACTIONS.EQUALS).getElementActionsMap();

    String YOUR_ACCOUNTS_DIALOG_XPATH = XPath.addEntryElementActionsAttributesValues(new XPath(elements, attributes), new XPathActionsElements(new XPathElement(PREFIX.DOUBLE_SLASH, ELEMENTS.H2), ACTIONS.EQUALS), new XPathAttributes(ATTRIBUTES.WICKETPATH, "main_c_title").addEntryToMultimap(ATTRIBUTES.TEXT, "Your accounts")).getXPath();

    String YOUR_ACCOUNTS_DESCRIPTION_XPATH = getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ID, "lblDeposit");


    String YOUR_ACCOUNTS_DIALOG = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.ROLE, "dialog") + getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ID, "dialogWrapper") + getXPath_DivEqualsDataPath("root");

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH = getXPath_DivEqualsDataPath("pnlNoAccount lnkCurrent") + getXPath_DirectSibling(ELEMENTS.A);
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH = getXPath_DivEqualsDataPath("pnlNoAccount lnkSavings") + getXPath_DirectSibling(ELEMENTS.A);
    String YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH = getXPath(ELEMENTS.DIV, ACTIONS.OR_EQUALS, ATTRIBUTES.DATA_PATH, new XPathValues("pnlNoAccount lnkAuto", "pnlNoAccount hbxAuto lnkAutoYodlee")) + getXPath_DirectSibling(ELEMENTS.A);

    String YOUR_ACCOUNTS_SAVING_OR_CURRENT_OR_SCRAPING = new XPath(ELEMENTS.DIV, ACTIONS.OR_EQUALS, ATTRIBUTES.DATA_PATH, new XPathValues(new LinkedList<String>(){{add("pnlNoAccount lnkCurrent");add("pnlNoAccount lnkSavings"); add("pnlNoAccount lnkAuto"); add("pnlNoAccount hbxAuto lnkAutoYodlee");}})).getXPath() + getXPath_DirectSibling(ELEMENTS.A);

    // Account Scraping
    String YOUR_ACCOUNTS_ACCOUNT_NAME = getXPath_DivEqualsDataPath("pnlAddSource pnlAccNam txtAccountName") + getXPath_HasADescendantSpanEqualsText("(optional)") + getXPath_HasADescendantLabelEqualsText("Account name") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txtAccountName");
    String YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH = getXPath(ELEMENTS.A, ACTIONS.AND_CONTAINS, ATTRIBUTES.CLASS, new XPathValues("dialog", "titlebar", "close")) + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "close");
    String YOUR_ACCOUNTS_REPORTS_XPATH = getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ID, "pnlDeposit");
    String YOUR_ACCOUNTS_ACCOUNT_TYPE_XPATH = new XPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ID, "pnlDeposit").addEntry(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ID, "Type").getXPath() + getXPath(ELEMENTS.SPAN);
    String YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH = new XPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ID, "pnlDeposit").addEntry(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "lnkDelete").getXPath();
    String YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH = getXPath_DivEqualsDataPath("pnlAccountList btnAdd") + getXPath_DirectAButtonContainsWicketpath("btnAdd_dialog") + getXPath_HasADescendant(getXPath(ELEMENTS.SPAN, ACTIONS.CONTAINS, ATTRIBUTES.TEXT, "Add"));//getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.ANY, "Add");
    String YOUR_ACCOUNTS_NEXT_XPATH = getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.ANY, "Next");
    String YOUR_ACCOUNTS_DONE_XPATH = getXPath_DivEqualsDataPath("pnlAccountList btnImDone") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.A, "pnlAccountList", "btnImDone", "submit") + getXPath_HasADescendantSpanText(ACTIONS.AND_CONTAINS, new XPathValues("I", "m done"));
    String YOUR_ACCOUNTS_CANCEL_XPATH = getXPath_DivEqualsDataPath("btnCancel") + getXPath_DirectAButtonContainsWicketpath("btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");
    String YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH = getXPath_DivEqualsDataPath("btnAddThisSource") + getXPath_DirectAButtonContainsWicketpath("btnAddThisSource_submit") + getXPath_HasADescendantSpanEqualsText("Add this account");

    // Current Account
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlAddSource pnlStatementDate txtStatementDate") + getXPath_HasADescendantSpanEqualsText("(optional)") + getXPath_HasADescendantLabelEqualsText("Statement date") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "txtStatementDate");
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH;

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_HOLDER_NAME_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlAddSource pnlAccNumb txtAccName") + getXPath_HasADescendantLabelEqualsText("Account holder name") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "txtAccName");
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_HOLDER_NAME_INPUT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_HOLDER_NAME_INPUT_XPATH;

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlAddSource pnlAccNumb txtSortCode1") + getXPath_HasADescendantLabelEqualsText("Sort code") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "txtSortCode1");
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH;


    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_ACCOUNT_NAME = getXPath_DivEqualsDataPath("pnlAddSource pnlAccNam txtAccountName") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "pnlAccNam_c_w_txtAccountName") + getXPath_HasADescendantLabelContainsText("Account name");
    String INPUT = PREFIX.DOUBLE_SLASH.get() + ELEMENTS.INPUT.get();

    String SORT_CODE2 = getXPath_DivEqualsDataPath("pnlAddSource pnlAccNumb txtSortCode2");
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH = SORT_CODE2 + INPUT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_2_INPUT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH;

    String SORT_CODE3 = getXPath_DivEqualsDataPath("pnlAddSource pnlAccNumb txtSortCode3");
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH = SORT_CODE3 + INPUT;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_3_INPUT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH;

    String ACCOUNT_NUMBER = getXPath_DivEqualsDataPath("pnlAddSource pnlAccNumb pnlAccNum txtAccnumber") + getXPath_HasADescendantLabelEqualsText("Account number") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "txtAccnumber");
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH = ACCOUNT_NUMBER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_NUMBER_INPUT_XPATH = ACCOUNT_NUMBER;

    String ACCOUNT_PROVIDER = getXPath_DivEqualsDataPath("pnlAddSource pnlAccountProvider txtAccountProvider") + getXPath_HasADescendantLabelEqualsText("Account provider") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "txtAccountProvider");
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH = ACCOUNT_PROVIDER;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_INPUT_XPATH = ACCOUNT_PROVIDER;

    String ACCOUNT_BALANCE = getXPath_DivEqualsDataPath("pnlAddSource pnlAccountBalance crbAccountBalance") + getXPath_HasADescendantLabelEqualsText("Account balance") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "crbAccountBalance");
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH = ACCOUNT_BALANCE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_INPUT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH;

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlAddSource pnlOverDraft crbOverdraft") + getXPath_HasADescendantLabelEqualsText("Overdraft limit") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "pnlAddSource", "pnlOverDraft", "crbOverdraft");

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlAddSource pnlSourceOfSavings cmbSourceOfSavings") + getXPath_HasADescendantLabelEqualsText("Source of savings") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "cmbSourceOfSavings");
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_SELECT_XPATH = getXPath_DivEqualsDataPath("pnlAddSource pnlSourceOfSavings cmbSourceOfSavings") + getXPath_HasADescendantLabelEqualsText("Source of savings") + getXPath_ContainsWicketpath(ELEMENTS.SELECT, new LinkedList<String>() {{
        add("cmbSourceOfSavings");
        add("combobox");
    }});
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_INPUT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_INPUT_XPATH;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SAVING_SOURCE_SELECT_XPATH = YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_SELECT_XPATH;

    String REGULAR_MONTHLY_SAVINGS = getXPath_DivEqualsDataPath("pnlAddSource pnlRegularMonthlySavings crbRegularMonthlySavings") + getXPath_HasADescendantSpanEqualsText("(optional)") + getXPath_HasADescendantLabelEqualsText("Regular monthly savings") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "crbRegularMonthlySavings");
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH = REGULAR_MONTHLY_SAVINGS;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH = REGULAR_MONTHLY_SAVINGS;

    String getTitle();

    String getDialogTitle();

    String getDescription();

    IYourAccountsSection typeAccountName(String accountName);

    IYourAccountsSection selectAccountType(String accountType);

    IYourAccountsSection clickCurrentAccount();

    IYourAccountsSection clickSavingsAccount();

    IYourAccountsAccountScrapingWindow clickAccountScraping();

    IYourAccountsSection iAgreeCheckbox(String action);

    IYourAccountsAccountScrapingWindow clickStartScraping();

    IYourAccountsSection clickAddAccount();

    IYourAccountsSection clickAddThisAccount();

    IYourAccountsSection clickNext();

    IYourDependantsPage clickDone();

    IYourAccountsSection clickCancel();

    IYourAccountsSection selectAccount(String account);

    IYourAccountsSection selectAccount(int index);

    IYourAccountsSection deleteAccount(String account);

    IYourAccountsSection deleteAccount(int index);

    IYourAccountsSection deleteAccountConfirm();

    IYourAccountsSection cancelAccountConfirm();

    IYourAccountsSection closeAccountConfirm();

    IYourAccountsSection editAccount(int index);

    Map<Integer, YourAccount> getAccountsOf(String accountType);

    Map<Integer, YourAccount> getAllAccounts();

    IYourAccountsSection typeCurrentStatementDate(String statementDate);

    IYourAccountsSection typeCurrentAccountHolderName(String accountName);

    IYourAccountsSection typeCurrentSortCode1(String sortCode1);

    IYourAccountsSection typeCurrentSortCode2(String sortCode2);

    IYourAccountsSection typeCurrentSortCode3(String sortCode3);

    IYourAccountsSection typeCurrentAccountNumber(String accountNumber);

    IYourAccountsSection typeCurrentAccountProvider(String accountProvider);

    IYourAccountsSection typeCurrentIban(String iban);

    IYourAccountsSection typeCurrentAccountBalance(String accountBalance);

    IYourAccountsSection typeCurrentOverdraftLimit(String overdraftLimit);

    IYourAccountsSection selectCurrentSavingsSource(String savingSource);

    IYourAccountsSection typeCurrentRegularMonthlySavings(String regularMonthlySavings);

    IYourAccountsSection typeSavingsStatementDate(String statementDate);

    IYourAccountsSection typeSavingsAccountHolderName(String accountName);

    IYourAccountsSection typeSavingsSortCode1(String sortCode1);

    IYourAccountsSection typeSavingsSortCode2(String sortCode2);

    IYourAccountsSection typeSavingsSortCode3(String sortCode3);

    IYourAccountsSection typeSavingsAccountNumber(String accountNumber);

    IYourAccountsSection typeSavingsAccountProvider(String accountProvider);

    IYourAccountsSection typeSavingsIban(String iban);

    IYourAccountsSection typeSavingsAccountBalance(String accountBalance);

    IYourAccountsSection selectSavingsSourceOfSavings(String sourceSaving);

    IYourAccountsSection typeSavingsRegularMonthlySavings(String savingRegularMonthlySavings);

    IYourAccountsSection closeScraping();
}