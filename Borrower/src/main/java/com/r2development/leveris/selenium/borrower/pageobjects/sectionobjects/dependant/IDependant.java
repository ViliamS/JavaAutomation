package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.dependant;

public interface IDependant {

    String YOUR_DEPENDANTS_DATE_OF_BIRTH_LABEL_XPATH = "//label[contains(., 'Date of birth')]";
    String YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_txtDateOfBirth_tb']";

    IDependant typeDateOfBirth(String dateOfBirth);
}