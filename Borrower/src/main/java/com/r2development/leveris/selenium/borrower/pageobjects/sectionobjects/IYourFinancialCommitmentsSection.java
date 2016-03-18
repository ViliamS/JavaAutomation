package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

public interface IYourFinancialCommitmentsSection {

    String FINANCIAL_TITLE_XPATH = "//div[@wicketpath='main_c_title']";
    String FINANCIAL_DIALOG_TITLE_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lblNoLiabTitle_l']";
    String FINANCIAL_DIALOG_DESCRIPTION_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lblNoEmpText_l']";
    String FINANCIAL_DIALOG_DESCRIPTION2_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lblNoEmpText_l']";

    String FINANCIAL_PERSONAL_LOAN_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAddPersonalLoan_dialog']";
    String FINANCIAL_DIALOG_PERSONAL_LOAN_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddPersonalLoan_submit']";
    String FINANCIAL_CREDIT_CARD_XPATH = "//a[@wickeptpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAddCreditCard_dialog']";
    String FINANCIAL_DIALOG_CREDIT_CARD_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddCreditCard_submit']";
    String FINANCIAL_MAINTENANCE_PAYMENT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAddMaintenancePayment_dialog']";
    String FINANCIAL_DIALOG_MAINTENANCE_PAYMENT_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddMaintenancePayment_submit']";
    String FINANCIAL_OTHER_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAddOther_dialog']";
    String FINANCIAL_DIALOG_OTHER_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddOther_submit']";
    String FINANCIAL_CAR_LOAN_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAddCarLoan_dialog']";
    String FINANCIAL_DIALOG_CAR_LOAN_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddCarLoan_submit']";
    String FINANCIAL_STUDENT_LOAN_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_lnkAddStudentLoan_dialog']";
    String FINANCIAL_DIALOG_STUDENT_LOAN_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_lnkAddStudentLoan_submit']";
    String FINANCIAL_RENT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlAddExpanses_c_w_lnkRent_dialog']";
    String FINANCIAL_DIALOG_RENT_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnl-737_c_w_lnkRent_submit']";
    String FINANCIAL_UTILITIES_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlAddExpanses_c_w_lnkUtilities_dialog']";
    String FINANCIAL_DIALOG_UTILITIES_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnl-737_c_w_lnkUtilities_submit']";
    String FINANCIAL_CHILDCARE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlAddExpanses_c_w_lnkChildcare_dialog']";
    String FINANCIAL_DIALOG_CHILD_CARE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnl-737_c_w_lnkChildcare_submit']";
    String FINANCIAL_MORTGAGE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNoEmplyments_c_w_pnlAddExpanses_c_w_lnkMortage_dialog']";
    String FINANCIAL_DIALOG_MORTGAGE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlNoEmplyments_c_w_pnl-737_c_w_lnkMortgage_submit']";

    String FINANCIAL_CONTAINER_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper']";

    String FINANCIAL_COMMITMENT_NONE_XPATH = "//a[contains(., 'I have no expenses/financial commitments')]";
    String FINANCIAL_CANCEL_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_btnCacnel_cancel']";
    String FINANCIAL_SAVE_AND_CLOSE_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_btnAddLiability_submit']";
    String FINANCIAL_EDIT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_1_item_pnlItems_c_w_btnEdit_dialog']";
    String FINANCIAL_DELETE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_rptEmployment_c_rows_1_item_pnlItems_c_w_btnDelete_dialog']";
    String FINANCIAL_DONE_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_btnImDone_submit']";
    String FINANCIAL_ADD_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlEmpList_c_w_btnAddLiab_dialog']";
    String FINANCIAL_COMMITMENTS_NEXT_XPATH = "//a[contains(., 'Next section')]";
    String FINANCIAL_WAIT_I_HAVE = "";

//    student loan
    String FINANCIAL_STUDENT_OUTSTANDING_BALANCE_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlOutstandingAmount_c_w_crbOutstandingLoanAmount_tb']";
    String FINANCIAL_STUDENT_FINANCIAL_INSTITUTION_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinancialInstitution_tb']";
    String FINANCIAL_STUDENT_FINAL_REPAYMENT_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinalRepaymentDate_tb']";
    String FINANCIAL_STUDENT_PAYMENT_FREQUENCY_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_label']";
    String FINANCIAL_STUDENT_PAYMENT_FREQUENCY_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_v']";
    String FINANCIAL_STUDENT_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";

//    rent
    String FINANCIAL_RENT_PAYMENT_FREQUENCY_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_label']";
    //optional
    String FINANCIAL_RENT_PAYMENT_FREQUENCY_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_v']";
    String FINANCIAL_RENT_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";
    //optional
    String FINANCIAL_RENT_NOTE_XPATH = "//textarea[@wicketpath='textarea -> main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlNote_c_w_txaNote_textarea']";

//    utilities
    String FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_label']";
    //optional
    String FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_v']";
    String FINANCIAL_UTILITIES_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";
    //optional
    String FINANCIAL_UTILITIES_NOTE_XPATH = "//textarea[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlNote_c_w_txaNote_textarea']";

//    childcare
    String FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_LABEL_XPATH = "//label[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_label']";
    //optional
    String FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_INPUT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPaymentFreq_c_w_cmbRepaymentFrequency_v']";
    String FINANCIAL_CHILDCARE_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";
    //optional
    String FINANCIAL_CHILDCARE_NOTE_XPATH = "//textarea[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlNote_c_w_txaNote_textarea']";

//    mortgage
    String FINANCIAL_MORTGAGE_OUTSTANDING_BALANCE_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlOutstandingAmount_c_w_crbOutstandingLoanAmount_tb']";
    String FINANCIAL_MORTGAGE_FINANCIAL_INSTITUTION_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinancialInstitution_tb']";
    //optional
    String FINANCIAL_MORTGAGE_FINAL_REPAYMENT_DATE_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlPersonalLoan_c_w_txtFinalRepaymentDate_tb']";
    String FINANCIAL_MORTGAGE_REPAYMENT_AMOUNT_XPATH = "//input[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlAddNew_c_w_pnlRepaymentAmount_c_w_crbRepaymentAmount_tb']";


    String getTitle();
    String getDialogTitle();
    String getDialogDescription();
    String getDialogDescription2();

    IYourFinancialCommitmentsSection clickFinancialType(String financialType);
    IYourFinancialCommitmentsSection clickAllPersonal();
    IYourFinancialCommitmentsSection clickPersonal();
    IYourFinancialCommitmentsSection clickDialogPersonal();
    IYourFinancialCommitmentsSection clickAllCreditCard();
    IYourFinancialCommitmentsSection clickCreditCard();
    IYourFinancialCommitmentsSection clickDialogCreditCard();
    IYourFinancialCommitmentsSection clickAllMaintenancePayment();
    IYourFinancialCommitmentsSection clickMaintenancePayment();
    IYourFinancialCommitmentsSection clickDialogMaintenancePayment();
    IYourFinancialCommitmentsSection clickAllOther();
    IYourFinancialCommitmentsSection clickOther();
    IYourFinancialCommitmentsSection clickDialogOther();
    IYourFinancialCommitmentsSection clickAllCar();
    IYourFinancialCommitmentsSection clickCar();
    IYourFinancialCommitmentsSection clickDialogCar();
    IYourFinancialCommitmentsSection clickAllStudent();
    IYourFinancialCommitmentsSection clickStudent();
    IYourFinancialCommitmentsSection clickDialogStudent();
    IYourFinancialCommitmentsSection clickAllRent();
    IYourFinancialCommitmentsSection clickRent();
    IYourFinancialCommitmentsSection clickDialogRent();
    IYourFinancialCommitmentsSection clickAllUtilities();
    IYourFinancialCommitmentsSection clickUtilities();
    IYourFinancialCommitmentsSection clickDialogUtilities();
    IYourFinancialCommitmentsSection clickAllChildCare();
    IYourFinancialCommitmentsSection clickChildCare();
    IYourFinancialCommitmentsSection clickDialogChildCare();
    IYourFinancialCommitmentsSection clickAllMortgage();
    IYourFinancialCommitmentsSection clickMortgage();
    IYourFinancialCommitmentsSection clickDialogMortgage();

    boolean isVisibleDialog(boolean throwException/*, int timeOut*/);
    boolean isNotVisibleDialog(boolean throwException/*, int timeOut*/);

    IYourFinancialCommitmentsSection clickNone();
    IYourFinancialCommitmentsSection clickCancel();
    IYourFinancialCommitmentsSection clickSaveAndClose();
    IYourFinancialCommitmentsSection clickEdit();
    IYourFinancialCommitmentsSection clickDelete();
    IYourFinancialCommitmentsSection clickDone();
    IYourFinancialCommitmentsSection clickAdd();
    IYourFinancialCommitmentsSection clickNext();
    IYourFinancialCommitmentsSection clickWaitIHave();






    //    student loan
    IYourFinancialCommitmentsSection typeStudentOutstandingBalanceAmount(String outstandingBalanceAmount);
    IYourFinancialCommitmentsSection typeStudentFinancialInstitution(String financialInstitution);
    IYourFinancialCommitmentsSection typeStudentFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsSection selectStudentPaymentFrequency(String paymentFrequency);
    IYourFinancialCommitmentsSection typeStudentRepaymentAmount(String repaymentAmount);

    //    rent
    //optional
    IYourFinancialCommitmentsSection selectRentPaymentFrequency(String repaymentFrequency);
    IYourFinancialCommitmentsSection typeRentRepaymentAmount(String repaymentAmount);
    //optional
    IYourFinancialCommitmentsSection typeRentNote(String note);

    //    utilities
    //optional
    IYourFinancialCommitmentsSection selectUtilitiesPaymentFrequency(String paymentFrequency);
    IYourFinancialCommitmentsSection typeUtilitiesRepaymentAmount(String repaymentAmount);
    //optional
    IYourFinancialCommitmentsSection typeUtilitiesNote(String note);

    //    childcare
    //optional
    IYourFinancialCommitmentsSection selectChildCarePaymentFrequency(String paymentFrequency);
    IYourFinancialCommitmentsSection typeChildCareRepaymentAmount(String repaymentAmount);
    //optional
    IYourFinancialCommitmentsSection typeChildCareNote(String note);

    //    mortgage
    IYourFinancialCommitmentsSection typeMortgageOutstandingBalanceAmount(String outstandingBalanceAmount);
    IYourFinancialCommitmentsSection typeMortgageFinancialInstitution(String financialInstitution);
    //optional
    IYourFinancialCommitmentsSection typeMortgageFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsSection typeMortgageRepaymentAmount(String repaymentAmount);

}
