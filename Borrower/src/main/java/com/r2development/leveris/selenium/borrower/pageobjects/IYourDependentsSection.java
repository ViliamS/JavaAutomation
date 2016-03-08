package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourDependentsSection {

    String YOUR_DEPENDENTS_PANEL_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper_dialog']";

//    String YOUR_DEPENDENTS_TITLE_XPATH = "//h2[contains(., 'Your deoendants')]";
    String YOUR_DEPENDENTS_TITLE_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoDepTitle_l' and contains(., 'Your dependants')]";
    String YOUR_DEPENDENTS_TITLE2_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlDepList_c_w_lblDependantListTitle_l']";
    String YOUR_DEPENDENTS_DESCRIPTION_INTRO_XPATH = "//div[@]wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoEmpText_l']";
    String YOUR_DEPENDENTS_DESCRIPTION_INTRO2_XPATH = "//div[@]wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoEmpText_l']";

    String YOUR_DEPENDENTS_NONE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnNoneDependants_submit' and contains(., 'I have none')]";

    String YOUR_DEPENDENTS_DATE_OF_BIRTH_LABEL_XPATH = "//label[contains(., 'Date of birth')]";
    String YOUR_DEPENDENTS_DATE_OF_BIRTH_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_txtDateOfBirth_tb']";

    String YOUR_DEPENDENTS_ADD_THIS_DEPENDENT_XPATH = "//a[contains(., 'ADD THIS DEPENDENT')]";
    String YOUR_DEPENDENTS_SAVE_AND_CLOSE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_btnAddDependent_submit']";
//    String YOUR_DEPENDENTS_ADD_DEPENDENTS_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnAddDependant_dialog' and contains(., 'Add a dependant')]";
    String YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_btnAddDependant_dialog']";
    String YOUR_DEPENDENTS_ADD_DEPENDENT2_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlDepList_c_w_btnAddDep_dialog']";
    String YOUR_DEPENDENTS_EDIT_THIS_DEPENDENT_XPATH = "//a[contains(., 'EDIT THIS DEPENDENT')]";
    String YOUR_DEPENDENTS_CANCEL_DEPENDENT_XPATH = "//a[contains(., 'CANCEL')]";
    String YOUR_DEPENDENTS_NEXT_DEPENDENT_XPATH = "//a[contains(., 'Next section')]";
    String YOUR_DEPENDENTS_DONE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlDepList_c_w_btnImDone_submit']";



    String getTitle();
    String getDescription();
    String getDescription2();

    IYourDependentsSection clickNone();
    IYourDependentsSection clickNext();
    IYourDependentsSection clickWaitWeHaveDependents();

    IYourDependentsSection typeDateOfBirth(String dateOfBirth);

    IYourDependentsSection clickAddThisDependent();
    IYourDependentsSection clickSaveAndClose();
    IYourDependentsSection clickAddDependent();
    IYourDependentsSection clickCancel();
    IYourFinancialCommitmentsPage clickDone();

    String getDependentAge(int index);
    IYourDependentsSection editDependent(int index);
    IYourDependentsSection deleteDependent(int index);

}
