package com.r2development.leveris.selenium.borrower.pageobjects;

import java.util.Map;

public interface IYourAccountsSection {

    String YOUR_ACCOUNTS_TITLE_XPATH = "//h2[contains(., 'Your accounts')]";
    String YOUR_ACCOUNTS_DIALOG_XPATH = "//div[contains(@aria-labelledby, 'ui-dialog-title-dialogWrapper')]/h3[text()='Your accounts']";
    String YOUR_ACCOUNTS_DESCRIPTION_XPATH = "//div[contains(@id, 'lblDeposit')]//span";

    String ACCOUNT_PROVIDER_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddSource_c_w_pnlAccountProvider_c_w_txtAccountProvider_tb']";

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkCurrent_dialog']";
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkSavings_dialog']";
    String YOUR_ACCOUNTS_ACCOUNT_SCRAPING_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAuto_dialog']";

    String YOUR_ACCOUNTS_ACCOUNT_MAIN_DIALOG_XPATH = "//div[contains(@style,'display: block')]/div[@wicketpath='main_c_form_dialogWrapper']/div[@wicketpath='main_c_form_dialogWrapper_dialog']";

    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_DIALOG_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkCurrent_submit']";
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_DIALOG_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkSavings_submit']";
    String YOUR_ACCOUNTS_ACCOUNT_SCRAPING_DIALOG_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAuto_submit']";

    String YOUR_ACCOUNTS_REPORTS_XPATH = "//div[contains(@id, 'pnlDeposit')]";
    String YOUR_ACCOUNTS_ACCOUNT_TYPE_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Type')]//span";     // to get text
    String YOUR_ACCOUNTS_ACCOUNT_DELETE_XPATH = "//div[contains(@id, 'pnlDeposit')]//a[contains(@wicketpath, 'lnkDelete')]";   // to delete
    String YOUR_ACCOUNTS_ACCOUNT_LABEL_AMOUNT_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Amount')]";            // to get text
    String YOUR_ACCOUNTS_ACCOUNT_OWNER_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Name')]";              // to get
    String YOUR_ACCOUNTS_ACCOUNT_AMOUNT_XPATH = "//div[contains(@id, 'pnlDeposit')]//div[contains(@id, 'Sum')]//span";
    String YOUR_ACCOUNTS_ADD_ACCOUNT_XPATH = "//a[contains(., 'Add')]";
    String YOUR_ACCOUNTS_NEXT_XPATH = "//a[contains(., 'Next')]";
    String YOUR_ACCOUNTS_DONE_XPATH = "//a[contains(., 'done')]";
    String YOUR_ACCOUNTS_CANCEL_XPATH = "//a[contains(., 'CANCEL')]";
    String YOUR_ACCOUNTS_ADD_THIS_ACCOUNT_XPATH = "//a[contains(., 'Add this account')]";
    String YOUR_ACCOUNTS_ROW_ACCOUNT = "//div[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_${replace}$_item_pnlItems_c']";
    String YOUR_ACCOUNTS_ROW_DELETE = "//div[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_${replace}$_item_pnlItems_c_w_btnDelete_dialog']";
    String YOUR_ACCOUNTS_ROW_EDIT = "//div[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_${replace)}_item_pnlItems_c_w_btnEdit_dialog']";
    String YOUR_ACCOUNTS_ROW_IBAN = "//div[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_${replace_row}_item_pnlItems_c_w_lblIban']";

    // Current Account
    String STATEMENT_DATE = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlStatementDate')][contains(@wicketpath,'txtStatementDate')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_LABEL_XPATH = "//label" + STATEMENT_DATE;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_STATEMENT_DATE_INPUT_XPATH = "//input" + STATEMENT_DATE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_LABEL_XPATH = "//label" + STATEMENT_DATE;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_STATEMENT_DATE_INPUT_XPATH = "//input" + STATEMENT_DATE;

    String ACCOUNT_HOLDER_NAME = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccNumb')][contains(@wicketpath,'txtAccName')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_HOLDER_NAME_LABEL_XPATH = "//label" + ACCOUNT_HOLDER_NAME;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_HOLDER_NAME_INPUT_XPATH = "//input" + ACCOUNT_HOLDER_NAME;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_HOLDER_NAME_LABEL_XPATH = "//label" + ACCOUNT_HOLDER_NAME;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_HOLDER_NAME_INPUT_XPATH = "//input" + ACCOUNT_HOLDER_NAME;

    String SORT_CODE1 = "[contains(@wicketpath,'pnlAddSource')][contains(@wicketpath,'pnlAccNumb')][contains(@wicketpath,'txtSortCode1')]";
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_LABEL_XPATH = "//label" + SORT_CODE1;
    String YOUR_ACCOUNTS_CURRENT_ACCOUNT_SORT_CODE_1_INPUT_XPATH = "//input" + SORT_CODE1;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_LABEL_XPATH = "//input" + SORT_CODE1;
    String YOUR_ACCOUNTS_SAVING_ACCOUNT_SORT_CODE_1_INPUT_XPATH = "//input" + SORT_CODE1;


    String INPUT = "//input";
    String LABEL = "//label[contains(@id,label)]";


    String SORT_CODE2 = "//div[@data-path='pnlAddSource pnlAccNumb txtSortCode2']";
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

    // Account Scraping
    String YOUR_ACCOUNTS_SCRAPING_CLOSE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnl-608_c_w_btnClose_cancel']";

    String getTitle();
    String getDialogTitle();
    String getDescription();

    IYourAccountsSection selectAccountType(String accountType);
    IYourAccountsSection clickCurrentAccount();
    IYourAccountsSection clickSavingsAccount();
    IYourAccountsSection clickAccountScraping();

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
    IYourAccountsSection selectCurrentSavingSource(String savingSource);
    IYourAccountsSection typeCurrentRegularMonthlySavings(String regularMonthlySavings);

    IYourAccountsSection typeSavingStatementDate(String statementDate);
    IYourAccountsSection typeSavingsAccountHolderName(String accountName);
    IYourAccountsSection typeSavingsSortCode1(String sortCode1);
    IYourAccountsSection typeSavingsSortCode2(String sortCode2);
    IYourAccountsSection typeSavingsSortCode3(String sortCode3);
    IYourAccountsSection typeSavingsAccountNumber(String accountNumber);
    IYourAccountsSection typeSavingAccountProvider(String accountProvider);
    IYourAccountsSection typeSavingIban(String iban);
    IYourAccountsSection typeSavingAccountBalance(String accountBalance);
    IYourAccountsSection typeSavingOverdraftLimit(String savingOverdraftLimit);
    IYourAccountsSection selectSavingSourceSavings(String sourceSaving);
    IYourAccountsSection typeSavingRegularMonthlySavings(String savingRegularMonthlySavings);

    IYourAccountsSection closeScraping();
}
