package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.account;

/**
 * Created by anthonymottot on 17/03/2016.
 */
public interface ICurrentAccount {

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlStatementDate_c_w_txtStatementDate_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlStatementDate_c_w_txtStatementDate_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NAME_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccName_label";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NAME_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccName_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtSortCode1_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtSortCode1_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_2_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtSortCode2_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_3_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtSortCode3_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccnumber_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_NUMBER_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccNumb_c_w_txtAccnumber_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccountProvider_c_w_txtAccountProvider_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_PROVIDER_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccountProvider_c_w_txtAccountProvider_tb']"; //label[contains(., 'Account provider')]/following-sibling::input";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlLastFourDigits_c_w_txtIban_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_IBAN_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlLastFourDigits_c_w_txtIban_tb']"; //label[contains(., 'IBAN')]/following-sibling::input";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccountBalance_c_w_crbAccountBalance_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_BALANCE_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccountBalance_c_w_crbAccountBalance_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlOverDraft_c_w_crbOverdraft_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_OVERDRAFT_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlOverDraft_c_w_crbOverdraft_tb']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlSourceOfSavings_c_w_cmbSourceOfSavings_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlSourceOfSavings_c_w_cmbSourceOfSavings_v']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SAVING_SOURCE_SELECT_XPATH = "//select[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlSourceOfSavings_c_w_cmbSourceOfSavings_combobox']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlRegularMonthlySavings_c_w_crbRegularMonthlySavings_label']";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_REGULAR_MONTHLY_SAVINGS_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlRegularMonthlySavings_c_w_crbRegularMonthlySavings_tb']";

    ICurrentAccount typeCurrentStatementDate(String statementDate);
    ICurrentAccount typeCurrentAccountName(String accountName);
    ICurrentAccount typeCurrentSortCode1(String sortCode1);
    ICurrentAccount typeCurrentSortCode2(String sortCode2);
    ICurrentAccount typeCurrentSortCode3(String sortCode3);
    ICurrentAccount typeCurrentAccountNumber(String accountNumber);
    ICurrentAccount typeCurrentAccountProvider(String accountProvider);
    ICurrentAccount typeCurrentIban(String iban);
    ICurrentAccount typeCurrentAccountBalance(String accountBalance);
    ICurrentAccount typeCurrentOverdraftLimit(String overdraftLimit);
    ICurrentAccount selectCurrentSavingSource(String savingSource);
    ICurrentAccount typeCurrentRegularMonthlySavings(String regularMonthlySavings);

}
