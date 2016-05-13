package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourFinancialCommitmentsPage {

    String getTitle();

    String getDialogTitle();

    String getDialogDescription();

    String getDialogDescription2();

    IYourFinancialCommitmentsPage clickFinancialType(String financialType);

    IYourFinancialCommitmentsPage clickPersonal();

    IYourFinancialCommitmentsPage clickDialogPersonal();

    IYourFinancialCommitmentsPage clickCreditCard();

    IYourFinancialCommitmentsPage clickDialogCreditCard();

    IYourFinancialCommitmentsPage clickMaintenancePayment();

    IYourFinancialCommitmentsPage clickDialogMaintenancePayment();

    IYourFinancialCommitmentsPage clickOther();

    IYourFinancialCommitmentsPage clickDialogOther();

    IYourFinancialCommitmentsPage clickCar();

    IYourFinancialCommitmentsPage clickDialogCar();

    IYourFinancialCommitmentsPage clickStudent();

    IYourFinancialCommitmentsPage clickDialogStudent();

    IYourFinancialCommitmentsPage clickRent();

    IYourFinancialCommitmentsPage clickDialogRent();

    IYourFinancialCommitmentsPage clickUtilities();

    IYourFinancialCommitmentsPage clickDialogUtilities();

    IYourFinancialCommitmentsPage clickChildCare();

    IYourFinancialCommitmentsPage clickDialogChildCare();

    IYourFinancialCommitmentsPage clickMortgage();

    IYourFinancialCommitmentsPage clickDialogMortgage();

    IYourFinancialCommitmentsPage clickNone();

    IYourFinancialCommitmentsPage clickCancel();

    IYourFinancialCommitmentsPage clickSaveAndClose();

    IYourFinancialCommitmentsPage clickEdit();

    IYourFinancialCommitmentsPage clickDelete();

    IDocumentUploadPage clickDone();

    IYourFinancialCommitmentsPage clickAdd();

    IDocumentUploadPage clickNext();

    IYourFinancialCommitmentsPage clickWaitIHave();

    IYourFinancialCommitmentsPage typePersonalOutstandingBalanceAmount(String outstandingBalanceAmount);

    IYourFinancialCommitmentsPage typePersonalFinancialInstitution(String financialInstitution);

    IYourFinancialCommitmentsPage typePersonalLoanPurpose(String loanPurpose);

    IYourFinancialCommitmentsPage typePersonalFinalRepaymentDate(String finalRepaymentDate);

    IYourFinancialCommitmentsPage selectPersonalPaymentFrequency(String paymentFrequency);

    IYourFinancialCommitmentsPage typePersonalRepaymentAmount(String repaymentAmount);

    //    credit card
    IYourFinancialCommitmentsPage typeCreditcRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsPage typeCreditcProvider(String provider);

    IYourFinancialCommitmentsPage selectCreditcType(String type);

    IYourFinancialCommitmentsPage typeCreditcLimit(String limit);

    IYourFinancialCommitmentsPage typeCreditcBalance(String balance);

    //    maintenance payment
    IYourFinancialCommitmentsPage typeMaintenancepPayment(String payment);

    //    other
    IYourFinancialCommitmentsPage typeOtherRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsPage typeOtherValue(String value);

    IYourFinancialCommitmentsPage typeOtherDescription(String description);

    //    car loan
    IYourFinancialCommitmentsPage typeCarOutstandingBalanceAmount(String outstandingBalanceAmount);

    IYourFinancialCommitmentsPage typeCarFinancialInstitution(String financialInstitution);

    IYourFinancialCommitmentsPage typeCarFinalRepaymentDate(String finalRepaymentDate);

    IYourFinancialCommitmentsPage selectCarPaymentFrequency(String paymentFrequency);

    IYourFinancialCommitmentsPage typeCarRepaymentAmount(String repaymentAmount);

    //    student loan
    IYourFinancialCommitmentsPage typeStudentOutstandingBalanceAmount(String outstandingBalanceAmount);

    IYourFinancialCommitmentsPage typeStudentFinancialInstitution(String financialInstitution);

    IYourFinancialCommitmentsPage typeStudentFinalRepaymentDate(String finalRepaymentDate);

    IYourFinancialCommitmentsPage selectStudentPaymentFrequency(String paymentFrequency);

    IYourFinancialCommitmentsPage typeStudentRepaymentAmount(String repaymentAmount);

    //    rent
    //optional
    IYourFinancialCommitmentsPage selectRentPaymentFrequency(String repaymentFrequency);

    IYourFinancialCommitmentsPage typeRentRepaymentAmount(String repaymentAmount);

    //optional
    IYourFinancialCommitmentsPage typeRentNote(String note);

    //    utilities
    //optional
    IYourFinancialCommitmentsPage selectUtilitiesPaymentFrequency(String paymentFrequency);

    IYourFinancialCommitmentsPage typeUtilitiesRepaymentAmount(String repaymentAmount);

    //optional
    IYourFinancialCommitmentsPage typeUtilitiesNote(String note);

    //    childcare
    //optional
    IYourFinancialCommitmentsPage selectChildCarePaymentFrequency(String paymentFrequency);

    IYourFinancialCommitmentsPage typeChildCareRepaymentAmount(String repaymentAmount);

    //optional
    IYourFinancialCommitmentsPage typeChildCareNote(String note);

    //    mortgage
    IYourFinancialCommitmentsPage typeMortgageOutstandingBalanceAmount(String outstandingBalanceAmount);

    IYourFinancialCommitmentsPage typeMortgageFinancialInstitution(String financialInstitution);

    //optional
    IYourFinancialCommitmentsPage typeMortgageFinalRepaymentDate(String finalRepaymentDate);

    IYourFinancialCommitmentsPage typeMortgageRepaymentAmount(String repaymentAmount);
}