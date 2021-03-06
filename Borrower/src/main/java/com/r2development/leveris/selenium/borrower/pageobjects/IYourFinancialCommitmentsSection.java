package com.r2development.leveris.selenium.borrower.pageobjects;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IYourFinancialCommitmentsSection {

    String FINANCIAL_TITLE_XPATH = "//div[@wicketpath='main_c_title']";
    String FINANCIAL_DIALOG_TITLE_XPATH = "//h2[@wicketpath='main_c_title']";
    String FINANCIAL_DIALOG_DESCRIPTION_XPATH = "//div[contains(@wicketpath,'pnlNoLiability') and contains(@wicketpath,'lblNoLiabText')]";
    String FINANCIAL_DIALOG_DESCRIPTION2_XPATH = "//div[contains(@wicketpath,'pnlLiabList') and contains(@wicketpath,'lblLiabListText')]";

    String DIALOG = "[contains(@wicketpath,'dialogWrapper')]";
    String LABEL = "[contains(@wicketpath,'label')]";

    String FINANCIAL_PERSONAL_LOAN_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "PersonalLoan") + getXPath_DirectAButtonContainsOrContainsWicketpath("PersonalLoan_dialog", "PersonalLoan_submit");
    String FINANCIAL_CREDIT_CARD_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "CreditCard") + getXPath_DirectAButtonContainsOrContainsWicketpath("AddCreditCard_dialog", "CreditCard_submit");
    String FINANCIAL_MAINTENANCE_PAYMENT_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "MaintenancePayment") + getXPath_DirectAButtonContainsOrContainsWicketpath("MaintenancePayment_dialog", "MaintenancePayment_submit");
    String FINANCIAL_OTHER_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "Other") + getXPath_DirectAButtonContainsOrContainsWicketpath("Other_dialog", "Other_submit");
    String FINANCIAL_CAR_LOAN_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "CarLoan") + getXPath_DirectAButtonContainsOrContainsWicketpath("CarLoan_dialog", "CarLoan_submit");
    String FINANCIAL_STUDENT_LOAN_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "StudentLoan") + getXPath_DirectAButtonContainsOrContainsWicketpath("StudentLoan_dialog", "StudentLoan_submit");
    String FINANCIAL_RENT_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "Rent") + getXPath_DirectAButtonContainsOrContainsWicketpath("Rent_dialog", "Rent_submit");
    String FINANCIAL_UTILITIES_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "Utilities") + getXPath_DirectAButtonContainsOrContainsWicketpath("Utilities_dialog", "Utilities_submit");
    String FINANCIAL_CHILDCARE_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "Childcare") + getXPath_DirectAButtonContainsOrContainsWicketpath("Childcare_dialog", "Childcare_submit");
    String FINANCIAL_MORTGAGE_XPATH = getXPath_DivAndContainsDataPath("pnlNoLiability", "Mortgage") + getXPath_DirectAButtonContainsOrContainsWicketpath("Mortage_dialog", "Mortgage_submit");

    String FINANCIAL_DIALOG_PERSONAL_LOAN_XPATH = FINANCIAL_PERSONAL_LOAN_XPATH;
    String FINANCIAL_DIALOG_CREDIT_CARD_XPATH = FINANCIAL_CREDIT_CARD_XPATH;
    String FINANCIAL_DIALOG_MAINTENANCE_PAYMENT_XPATH = FINANCIAL_MAINTENANCE_PAYMENT_XPATH;
    String FINANCIAL_DIALOG_OTHER_XPATH = FINANCIAL_OTHER_XPATH;
    String FINANCIAL_DIALOG_CAR_LOAN_XPATH = FINANCIAL_CAR_LOAN_XPATH;
    String FINANCIAL_DIALOG_STUDENT_LOAN_XPATH = FINANCIAL_STUDENT_LOAN_XPATH;
    String FINANCIAL_DIALOG_RENT_XPATH = FINANCIAL_RENT_XPATH;
    String FINANCIAL_DIALOG_UTILITIES_XPATH = FINANCIAL_UTILITIES_XPATH;
    String FINANCIAL_DIALOG_CHILD_CARE_XPATH = FINANCIAL_CHILDCARE_XPATH;
    String FINANCIAL_DIALOG_MORTGAGE_XPATH = FINANCIAL_MORTGAGE_XPATH;



    String FINANCIAL_CONTAINER_XPATH = "//div[@wicketpath='main_c_form_dialogWrapper']";
    String FINANCIAL_COMMITMENT_NONE_XPATH = "//a[contains(@wicketpath,'pnlNoLiability') and contains(@wicketpath,'lnkHaveNoCommitments_submit')]//span[text()='I have no expenses/financial commitments']";
    String FINANCIAL_SAVE_AND_CLOSE_XPATH = getXPath_DivEqualsDataPath("btnAddLiability") + getXPath_DirectAButtonContainsWicketpath("btnAddLiability_submit") + getXPath_HasADescendantSpanEqualsText("Save and close");
    String FINANCIAL_CANCEL_XPATH = getXPath_DivEqualsDataPath("btnCacnel") + getXPath_DirectAButtonContainsWicketpath("btnCacnel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");
    String FINANCIAL_EDIT_XPATH = "//a[contains(@wicketpath,'pnlLiabList') and contains(@wicketpath,'rptLiability') and contains(@wicketpath,'rows_1_item_pnlItems') and contains(@wicketpath,'btnEdit_dialog')]";
    String FINANCIAL_DELETE_XPATH = "//a[contains(@wicketpath,'pnlLiabList') and contains(@wicketpath,'rptLiability') and contains(@wicketpath,'rows_1_item_pnlItems') and contains(@wicketpath,'btnDelete_dialog')]";
    String FINANCIAL_DONE_XPATH = "//a[contains(@wicketpath,'pnlLiabList') and contains(@wicketpath,'btnImDone_submit')]";
    String FINANCIAL_ADD_XPATH = getXPath_DivEqualsDataPath("pnlLiabList btnAddLiab") + getXPath_DirectAButtonContainsWicketpath("btnAddLiab_dialog") + getXPath_HasADescendantSpanEqualsText("Add");
    String FINANCIAL_COMMITMENTS_NEXT_XPATH = "//a[contains(@wicketpath,'pnlNoCommitments') and contains(@wicketpath,'btnNextSection_submit')]";
    String FINANCIAL_WAIT_I_HAVE = "";

    // Shared
    String REPAYMENT_AMOUNT_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'RepaymentAmount')]";
    String PAYMENT_FREQUENCY_LABEL_XPATH = "//label[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'PaymentFreq') and contains(@wicketpath,'RepaymentFrequency_label')]";
    String OUTSTANDING_AMOUNT_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'OutstandingAmount')]";
    String PAYMENT_FREQUENCY_INPUT_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'PaymentFreq') and contains(@wicketpath,'RepaymentFrequency')]";
    String NOTE_TEXTAREA_XPATH = "//textarea[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'Note') and contains(@wicketpath,'Note_textarea')]";
    String FINANCIAL_INSTITUTION_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'PersonalLoan') and contains(@wicketpath,'FinancialInstitution')]";
    String FINAL_REPAYMENT_DATE = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'PersonalLoan') and contains(@wicketpath,'FinalRepaymentDate')]";


    //    Personal Loan Details
    String FINANCIAL_PERSONAL_OUTSTANDING_BALANCE_AMOUNT_XPATH = "//input[contains(@wicketpath,'pnlAddNew')][contains(@wicketpath,'OutstandingLoanAmount')]" + DIALOG;
    String FINANCIAL_PERSONAL_FINANCIAL_INSTITUTION_XPATH = "//input[contains(@wicketpath,'pnlAddNew')][contains(@wicketpath,'FinancialInstitution')]" + DIALOG;
    String FINANCIAL_PERSONAL_LOAN_PURPOSE_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'PersonalLoan') and contains(@wicketpath,'txtLoanPurpose')]" + DIALOG;
    String FINANCIAL_PERSONAL_FINAL_REPAYMENT_DATE_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'PersonalLoan') and contains(@wicketpath,'RepaymentDate')]" + DIALOG;
    String FINANCIAL_PERSONAL_PAYMENT_FREQUENCY_INPUT_XPATH = PAYMENT_FREQUENCY_INPUT_XPATH + DIALOG;
    String FINANCIAL_PERSONAL_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;

    //    credit card
    String FINANCIAL_CREDITC_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;
    String FINANCIAL_CREDITC_PROVIDER_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'CreditCard') and contains(@wicketpath,'CardProvider')]" + DIALOG;
    String FINANCIAL_CREDITC_CARD_TYPE_LABEL_XPATH = "//label[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'CreditCard') and contains(@wicketpath,'CardType_label')]" + LABEL + DIALOG;
    String FINANCIAL_CREDITC_CARD_TYPE_XPATH = "//input[contains(@wicketpath,'pnlAddNew')][contains(@wicketpath,'CreditCard')][contains(@wicketpath,'CardType')]" + DIALOG;
    String FINANCIAL_CREDITC_CARD_LIMIT_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'CreditCard') and contains(@wicketpath,'CardLimit')]" + DIALOG;
    String FINANCIAL_CREDITC_CARD_BALANCE_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'CreditCard') and contains(@wicketpath,'CardBalance')]" + DIALOG;

    //    maintenance payment
    String FINANCIAL_MAINTENANCEP_PAYMENT_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'Maintenance') and contains(@wicketpath,'MaintenancePayment')]" + DIALOG;

    //    other
    String FINANCIAL_OTHER_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;
    String FINANCIAL_OTHER_VALUE_XPATH = "//input[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'OtherValue') and contains(@wicketpath,'Value')]" + DIALOG;
    String FINANCIAL_OTHER_DESCRIPTION_XPATH = "//textarea[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'OtherValue') and contains(@wicketpath,'Description_textarea')]" + DIALOG;

    //    car loan
    String FINANCIAL_CAR_OUTSTANDING_BALANCE_AMOUNT_XPATH = OUTSTANDING_AMOUNT_XPATH + DIALOG;
    String FINANCIAL_CAR_FINANCIAL_INSTITUTION_XPATH = FINANCIAL_INSTITUTION_XPATH + DIALOG;
    String FINANCIAL_CAR_FINAL_REPAYMENT_DATE_XPATH = FINAL_REPAYMENT_DATE + DIALOG;
    String FINANCIAL_CAR_PAYMENT_FREQUENCY_LABEL_XPATH = PAYMENT_FREQUENCY_LABEL_XPATH + DIALOG;
    String FINANCIAL_CAR_PAYMENT_FREQUENCY_INPUT_XPATH = PAYMENT_FREQUENCY_INPUT_XPATH + DIALOG;
    String FINANCIAL_CAR_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;

    //    student loan
    String FINANCIAL_STUDENT_OUTSTANDING_BALANCE_AMOUNT_XPATH = OUTSTANDING_AMOUNT_XPATH + DIALOG;
    String FINANCIAL_STUDENT_FINANCIAL_INSTITUTION_XPATH = FINANCIAL_INSTITUTION_XPATH + DIALOG;
    String FINANCIAL_STUDENT_FINAL_REPAYMENT_DATE_XPATH = FINAL_REPAYMENT_DATE + DIALOG;
    String FINANCIAL_STUDENT_PAYMENT_FREQUENCY_LABEL_XPATH = PAYMENT_FREQUENCY_LABEL_XPATH + DIALOG;
    String FINANCIAL_STUDENT_PAYMENT_FREQUENCY_INPUT_XPATH = PAYMENT_FREQUENCY_INPUT_XPATH + DIALOG;
    String FINANCIAL_STUDENT_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;

    //    rent
    String FINANCIAL_RENT_PAYMENT_FREQUENCY_LABEL_XPATH = PAYMENT_FREQUENCY_LABEL_XPATH + DIALOG;
    //optional
    String FINANCIAL_RENT_PAYMENT_FREQUENCY_INPUT_XPATH = PAYMENT_FREQUENCY_INPUT_XPATH + DIALOG;
    String FINANCIAL_RENT_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;
    //optional
    String FINANCIAL_RENT_NOTE_XPATH = "//textarea[contains(@wicketpath,'pnlAddNew') and contains(@wicketpath,'Note') and contains(@wicketpath,'txaNote_textarea')]" + DIALOG;

    //    utilities
    String FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_LABEL_XPATH = PAYMENT_FREQUENCY_LABEL_XPATH + DIALOG;

    //optional
    String FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_INPUT_XPATH = PAYMENT_FREQUENCY_INPUT_XPATH + DIALOG;
    String FINANCIAL_UTILITIES_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;

    //optional
    String FINANCIAL_UTILITIES_NOTE_XPATH = NOTE_TEXTAREA_XPATH + DIALOG;

    //    childcare
    String FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_LABEL_XPATH = PAYMENT_FREQUENCY_LABEL_XPATH + DIALOG;

    //optional
    String FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_INPUT_XPATH = PAYMENT_FREQUENCY_INPUT_XPATH + DIALOG;
    String FINANCIAL_CHILDCARE_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;

    //optional
    String FINANCIAL_CHILDCARE_NOTE_XPATH = NOTE_TEXTAREA_XPATH + DIALOG;

    //    mortgage
    String FINANCIAL_MORTGAGE_OUTSTANDING_BALANCE_AMOUNT_XPATH = OUTSTANDING_AMOUNT_XPATH + DIALOG;
    String FINANCIAL_MORTGAGE_FINANCIAL_INSTITUTION_XPATH = FINANCIAL_INSTITUTION_XPATH + DIALOG;

    //optional
    String FINANCIAL_MORTGAGE_FINAL_REPAYMENT_DATE_XPATH = FINAL_REPAYMENT_DATE + DIALOG;
    String FINANCIAL_MORTGAGE_REPAYMENT_AMOUNT_XPATH = REPAYMENT_AMOUNT_XPATH + DIALOG;

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

    IYourFinancialCommitmentsSection typePersonalOutstandingBalanceAmount(String outstandingBalanceAmount);

    IYourFinancialCommitmentsSection typePersonalFinancialInstitution(String financialInstitution);

    IYourFinancialCommitmentsSection typePersonalLoanPurpose(String loanPurpose);

    IYourFinancialCommitmentsSection typePersonalFinalRepaymentDate(String finalRepaymentDate);

    IYourFinancialCommitmentsSection selectPersonalPaymentFrequency(String paymentFrequency);

    IYourFinancialCommitmentsSection typePersonalRepaymentAmount(String repaymentAmount);

    //    credit card
    IYourFinancialCommitmentsSection typeCreditCardRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsSection typeCreditCardProvider(String provider);

    IYourFinancialCommitmentsSection selectCreditCardType(String type);

    IYourFinancialCommitmentsSection typeCreditCardLimit(String limit);

    IYourFinancialCommitmentsSection typeCreditCardBalance(String balance);

    //    maintenance payment
    IYourFinancialCommitmentsSection typeMaintenancePayment(String payment);

    //    other
    IYourFinancialCommitmentsSection typeOtherRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsSection typeOtherValue(String value);

    IYourFinancialCommitmentsSection typeOtherDescription(String description);

    //    car loan
    IYourFinancialCommitmentsSection typeCarOutstandingBalanceAmount(String outstandingBalanceAmount);

    IYourFinancialCommitmentsSection typeCarFinancialInstitution(String financialInstitution);

    IYourFinancialCommitmentsSection typeCarFinalRepaymentDate(String finalRepaymentDate);

    IYourFinancialCommitmentsSection selectCarPaymentFrequency(String paymentFrequency);

    IYourFinancialCommitmentsSection typeCarRepaymentAmount(String repaymentAmount);

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