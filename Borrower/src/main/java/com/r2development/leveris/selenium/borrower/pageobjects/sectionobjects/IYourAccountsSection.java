package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import com.r2development.leveris.selenium.borrower.pageobjects.IYourDependantsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.YourAccount;

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

}
