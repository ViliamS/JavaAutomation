package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.Map;

public interface IYourAccountsSection {
    String YOUR_ACCOUNTS_TITLE_XPATH = "//h2[contains(., 'Your accounts')]";
    String YOUR_ACCOUNTS_DESCRIPTION_XPATH = "//div[contains(@id, 'lblDeposit')]//span";

    String YOUR_ACCOUNTS_REPORTS_XPATH = "//div[contains(@id, 'pnlDeposit')]";
    String YOUR_ACCOUNTS_ACCOUNT_TYPE_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Type')]//span";     // to get text
    String YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH = "//div[contains(@id, 'pnlDeposit')]//a[contains(@wicketpath, 'lnkDelete')]";   // to delete
    String YOUR_ACCOUNTS_ACCOUNT_LABEL_AMOUNT_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Amount')]";            // to get text
    String YOUR_ACCOUNTS_ACCOUNT_OWNER_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Name')]";              // to get
    String YOUR_ACCOUNTS_ACCOUNT_AMOUNT_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Sum')]//span";

    String YOUR_ACCOUNTS_LABEL_TOTAL_XPATH = "//div[contains(@id, 'Subtotal')]//div[contains(., 'Subtotal:')]";
    String YOUR_ACCOUNTS_TOTAL_VALUE_XPATH = "//div[contains(@id, 'Subtotal')]//div[contains(@wicketpath, 'SubtotalAmount')]//span";

    // Current Account, Savings Account
    String YOUR_ACCOUNTS_WHICH_FUNDS_XPATH = "//label[contains(., 'What is the source of funds?')]/following-sibling::input"; //"//input[@wicketpath='main_c_form_form_root_c_w_pnlAddSource_c_w_cmbSourceOfFunds_v']";
    String YOUR_ACCOUNTS_APPLIES_TO_BORROWER_XPATH = "//label[contains(., '${replaceBorrower}$')]/following-sibling::span/a";
    String YOUR_ACCOUNTS_APPLIES_TO_COAPPLICANT_XPATH = "//label[contains(., '${replaceCoapplicant}$')]/following-sibling::span/a";

    // Current Account
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_XPATH = "//label[contains(., 'Account provider')]/following-sibling::input";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_4LAST_NUMBER_XPATH = "//label[contains(., 'IBAN')]/following-sibling::input";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_XPATH = "//label[contains(., 'Account balance')]/following-sibling::input";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_XPATH = "//label[contains(., 'Overdraft limit')]/following-sibling::input";

    // Savings Account
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_PROVIDER_XPATH = "//label[contains(., 'Account provider')]/following-sibling::input";
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_4LAST_NUMBER_XPATH = "//label[contains(., 'IBAN')]/following-sibling::input";
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_BALANCE_XPATH = "//label[contains(., 'Account balance')]/following-sibling::input";
    // Gift, Inheritance, Accident Claim, Redundancy, Income from Regular Savings, Other
    String YOUR_ACCOUNTS_SAVING_SOURCE_XPATH = "//label[contains(., 'Source of savings')]/following-sibling::input";
    String YOUR_ACCOUNTS_SAVING_MONTHLY_SAVING_XPATH = "//label[contains(., 'Regular monthly savings')]/following-sibling::input";

    String YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH = "//a[contains(., 'Add account')]";
    String YOUR_ACCOUNTS_NEXT_XPATH = "//a[contains(., 'Next')]";
    String YOUR_ACCOUNTS_CANCEL_XPATH = "//a[contains(., 'CANCEL')]";
    String YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH = "//a[contains(., 'Add this account')]";

    String YOUR_ACCOUNTS_POPUP_ADD_ACCOUNT_MANUALLY_XPATH = "//a[contains(@wicketpath, 'pnlOther') and contains(., 'Add account manually')]";
    String YOUR_ACCOUNTS_POPUP_SELECT_ACCOUNT_XPATH = "//label[contains(@wicketpath, 'cmbBankAccount')]/following-sibling::input";

    String getTitle();
    String getDescription();
    IYourAccountsSection clickAddThisAccount();
    IYourAccountsSection clickAddAccount();
    IYourAccountsSection clickNext();
    IYourAccountsSection clickCancel();

    IYourAccountsSection selectSourceOfFunds(String sourceOfFund);
    IYourAccountsSection checkAccountAppliesToBorrower(String borrower);
    IYourAccountsSection checkAccountAppliesToCoapplicant(String coapplicant);

    IYourAccountsSection typeCurrentAccountProvider(String accountProvider);
    IYourAccountsSection typeCurrentIban(String iban);
    IYourAccountsSection typeCurrentAccountBalance(String accountBalance);
    IYourAccountsSection typeCurrentOverdraftLimit(String overdraftLimit);

    IYourAccountsSection typeSavingAccountProvider(String accountProvider);
    IYourAccountsSection typeSavingIban(String iban);
    IYourAccountsSection typeSavingAccountBalance(String accountBalance);

    IYourAccountsSection selectSavingSourceSavings(String sourceSaving);
    IYourAccountsSection typeSavingRegularMonthlySavings(String savingRegularMonthlySavings);

    IYourAccountsSection deleteAccount(int index);
    Map<Integer, YourAccount> getAccountsOf(String accountType);
    Map<Integer, YourAccount> getAllAccounts();
    String getFundType(int index);
    String getFundName(int index);
    String computeFundSum(int index);
    String getFundSubtotalAmount();
    IYourAccountsSection clickFundPanel(int index);

    IYourAccountsSection clickAddAccountManually();
    /*
    <ul class="ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all sc-combobox-menu ui-short-menu" role="listbox" aria-activedescendant="ui-active-menuitem" style="z-index: 2012; top: 298px; left: 499px; display: block; width: 618px;" data-width="620">
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Choose...</a></li>
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Mock Scraper</a></li>
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Mock Scraper for Authentication Validation</a></li>
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Mock Scraper for Error during Authentication Phase</a></li>
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Mock Scraper for Error during Webscraping Phase</a></li>
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Allied Irish Banks</a></li>
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Ulster Bank</a></li>
       <li class="ui-menu-item" role="menuitem"><a class="ui-corner-all" tabindex="-1">Other</a></li>
    </ul>
    */
    IYourAccountsSection selectAccount(String account);
    IYourAccountsSection validateAccounts();
}
