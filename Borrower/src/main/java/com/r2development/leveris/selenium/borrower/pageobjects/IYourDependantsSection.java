package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourDependantsSection {

    String YOUR_DEPENDANTS_PANEL_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper_dialog']";

//    String YOUR_DEPENDANTS_TITLE_XPATH = "//h2[contains(., 'Your deoendants')]";
    String YOUR_DEPENDANTS_TITLE_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoDepTitle_l' and contains(., 'Your dependants')]";
    String YOUR_DEPENDANTS_TITLE2_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlDepList_c_w_lblDependantListTitle_l']";
    String YOUR_DEPENDANTS_DESCRIPTION_INTRO_XPATH = "//div[@]wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoEmpText_l']";
    String YOUR_DEPENDANTS_DESCRIPTION_INTRO2_XPATH = "//div[@]wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoEmpText_l']";

    String YOUR_DEPENDANTS_NONE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnNoneDependants_submit' and contains(., 'I have none')]";

    String YOUR_DEPENDANTS_DATE_OF_BIRTH_LABEL_XPATH = "//label[contains(., 'Date of birth')]";
    String YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_txtDateOfBirth_tb']";

    String YOUR_DEPENDANTS_ADD_THIS_DEPENDANT_XPATH = "//a[contains(., 'ADD THIS DEPENDENT')]";
    String YOUR_DEPENDANTS_SAVE_AND_CLOSE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_btnAddDependent_submit']";

   // String YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnAddDependant_dialog' and contains(., 'Add a dependant')]";
    String YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlDepList_c_w_btnAddDep_dialog']/span[text()='Add']";

    String YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnAddDependant_dialog']";
    String YOUR_DEPENDANTS_ADD_DEPENDANT2_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlDepList_c_w_btnAddDep_dialog']";
    String YOUR_DEPENDANTS_EDIT_THIS_DEPENDANT_XPATH = "//a[contains(., 'EDIT THIS DEPENDENT')]";
    String YOUR_DEPENDANTS_CANCEL_DEPENDANT_XPATH = "//a[contains(., 'CANCEL')]";
    String YOUR_DEPENDANTS_NEXT_DEPENDANT_XPATH = "//a[contains(., 'Next section')]";
    String YOUR_DEPENDANTS_DONE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlDepList_c_w_btnImDone_submit']";

    String FINANCIAL_COMMITMENTS_NAVIGATION_CHECK_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAddPersonalLoan_dialog']";


    String getTitle();
    String getDescription();
    String getDescription2();

    IYourDependantsSection clickNone();
    IYourDependantsSection clickNext();
    IYourDependantsSection clickWaitWeHaveDependants();

    IYourDependantsSection typeDateOfBirth(String dateOfBirth);

    IYourDependantsSection clickAddThisDependant();
    IYourDependantsSection clickSaveAndClose();
    IYourDependantsSection clickAddDependant();
    IYourDependantsSection clickCancel();
    IYourFinancialCommitmentsPage clickDone();

    String getDependantAge(int index);
    IYourDependantsSection editDependant(int index);
    IYourDependantsSection deleteDependant(int index);

}
