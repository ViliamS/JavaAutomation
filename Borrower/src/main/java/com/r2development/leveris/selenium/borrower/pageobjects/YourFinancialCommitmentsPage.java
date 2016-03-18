package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class YourFinancialCommitmentsPage extends HeaderAndBottomAndFormsMenuSection implements IYourFinancialCommitmentsPage {
    
    private static final Log log = LogFactory.getLog(YourFinancialCommitmentsPage.class);
    
//    IFormsMenu formsMenu;

    @Inject
    private IUser user;
    protected IYourFinancialCommitmentsSection yourFinancialCommitmentsSection;

//    @Inject
    public YourFinancialCommitmentsPage(SharedDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourFinancialCommitmentsSection = new YourFinancialCommitmentsSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return yourFinancialCommitmentsSection.getTitle();
    }

    @Override
    public String getDialogTitle() {
        return yourFinancialCommitmentsSection.getDialogTitle();
    }

    @Override
    public String getDialogDescription() {
        return yourFinancialCommitmentsSection.getDialogDescription();
    }

    @Override
    public String getDialogDescription2() {
        return yourFinancialCommitmentsSection.getDialogDescription2();
    }

    @Override
    public IYourFinancialCommitmentsPage clickFinancialType(String financialType) {
        yourFinancialCommitmentsSection.clickFinancialType(financialType);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickPersonal() {
        yourFinancialCommitmentsSection.clickPersonal();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogPersonal() {
        yourFinancialCommitmentsSection.clickDialogPersonal();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickCreditCard() {
        yourFinancialCommitmentsSection.clickCreditCard();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogCreditCard() {
        yourFinancialCommitmentsSection.clickDialogCreditCard();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickMaintenancePayment() {
        yourFinancialCommitmentsSection.clickMaintenancePayment();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogMaintenancePayment() {
        yourFinancialCommitmentsSection.clickDialogMaintenancePayment();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickOther() {
        yourFinancialCommitmentsSection.clickOther();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogOther() {
        yourFinancialCommitmentsSection.clickDialogOther();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickCar() {
        yourFinancialCommitmentsSection.clickCar();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogCar() {
        yourFinancialCommitmentsSection.clickDialogCar();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickStudent() {
        yourFinancialCommitmentsSection.clickStudent();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogStudent() {
        yourFinancialCommitmentsSection.clickDialogStudent();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickRent() {
        yourFinancialCommitmentsSection.clickRent();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogRent() {
        yourFinancialCommitmentsSection.clickDialogRent();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickUtilities() {
        yourFinancialCommitmentsSection.clickUtilities();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogUtilities() {
        yourFinancialCommitmentsSection.clickDialogUtilities();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickChildCare() {
        yourFinancialCommitmentsSection.clickChildCare();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogChildCare() {
        yourFinancialCommitmentsSection.clickDialogChildCare();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickMortgage() {
        yourFinancialCommitmentsSection.clickMortgage();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDialogMortgage() {
        yourFinancialCommitmentsSection.clickDialogMortgage();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickNone() {
        yourFinancialCommitmentsSection.clickNone();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickCancel() {
        yourFinancialCommitmentsSection.clickCancel();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickSaveAndClose() {
        yourFinancialCommitmentsSection.clickSaveAndClose();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickEdit() {
        yourFinancialCommitmentsSection.clickEdit();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDelete() {
        yourFinancialCommitmentsSection.clickDelete();
        return this;
    }

    @Override
    public IDocumentUploadPage clickDone() {
        yourFinancialCommitmentsSection.clickDone();
//        return new DocumentUploadPage(webDriver, user);
        return new DocumentUploadPage(webDriver);
    }

    @Override
    public IYourFinancialCommitmentsPage clickAdd() {
        yourFinancialCommitmentsSection.clickAdd();
        return this;
    }

    @Override
    public IDocumentUploadPage clickNext() {
        yourFinancialCommitmentsSection.clickNext();
//        return new DocumentUploadPage(webDriver, user);
        return new DocumentUploadPage(webDriver);
    }

    @Override
    public IYourFinancialCommitmentsPage clickWaitIHave() {
        yourFinancialCommitmentsSection.clickWaitIHave();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalOutstandingBalanceAmount(String outstandingBalanceAmount) {
//        yourFinancialCommitmentsSection.typePersonalOutstandingBalanceAmount(outstandingBalanceAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalFinancialInstitution(String financialInstitution) {
//        yourFinancialCommitmentsSection.typePersonalFinancialInstitution(financialInstitution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalLoanPurpose(String loanPurpose) {
//        yourFinancialCommitmentsSection.typePersonalLoanPurpose(loanPurpose);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalFinalRepaymentDate(String finalRepaymentDate) {
//        yourFinancialCommitmentsSection.typePersonalFinalRepaymentDate(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectPersonalPaymentFrequency(String paymentFrequency) {
//        yourFinancialCommitmentsSection.selectPersonalPaymentFrequency(paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalRepaymentAmount(String repaymentAmount) {
//        yourFinancialCommitmentsSection.typePersonalRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditcRepaymentAmount(String repaymentAmount) {
//        yourFinancialCommitmentsSection.typeCreditcRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditcProvider(String provider) {
//        yourFinancialCommitmentsSection.typeCreditcProvider(provider);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectCreditcType(String type) {
//        yourFinancialCommitmentsSection.selectCreditcType(type);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditcLimit(String limit) {
//        yourFinancialCommitmentsSection.typeCreditcLimit(limit);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditcBalance(String balance) {
//        yourFinancialCommitmentsSection.typeCreditcBalance(balance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeMaintenancepPayment(String payment) {
//        yourFinancialCommitmentsSection.typeMaintenancepPayment(payment);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeOtherRepaymentAmount(String repaymentAmount) {
//        yourFinancialCommitmentsSection.typeOtherRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeOtherValue(String value) {
//        yourFinancialCommitmentsSection.typeOtherValue(value);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeOtherDescription(String description) {
//        yourFinancialCommitmentsSection.typeOtherDescription(description);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarOutstandingBalanceAmount(String outstandingBalanceAmount) {
//        yourFinancialCommitmentsSection.typeCarOutstandingBalanceAmount(outstandingBalanceAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarFinancialInstitution(String financialInstitution) {
//        yourFinancialCommitmentsSection.typeCarFinancialInstitution(financialInstitution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarFinalRepaymentDate(String finalRepaymentDate) {
//        yourFinancialCommitmentsSection.typeCarFinalRepaymentDate(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectCarPaymentFrequency(String paymentFrequency) {
//        yourFinancialCommitmentsSection.selectCarPaymentFrequency(paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarRepaymentAmount(String repaymentAmount) {
//        yourFinancialCommitmentsSection.typeCarRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentOutstandingBalanceAmount(String outstandingBalanceAmount) {
        yourFinancialCommitmentsSection.typeStudentOutstandingBalanceAmount(outstandingBalanceAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentFinancialInstitution(String financialInstitution) {
        yourFinancialCommitmentsSection.typeStudentFinancialInstitution(financialInstitution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentFinalRepaymentDate(String finalRepaymentDate) {
        yourFinancialCommitmentsSection.typeStudentFinalRepaymentDate(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectStudentPaymentFrequency(String paymentFrequency) {
        yourFinancialCommitmentsSection.selectStudentPaymentFrequency(paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeStudentRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectRentPaymentFrequency(String repaymentFrequency) {
        yourFinancialCommitmentsSection.selectRentPaymentFrequency(repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeRentRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeRentRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeRentNote(String note) {
        yourFinancialCommitmentsSection.typeRentNote(note);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectUtilitiesPaymentFrequency(String paymentFrequency) {
        yourFinancialCommitmentsSection.selectUtilitiesPaymentFrequency(paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeUtilitiesRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeUtilitiesRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeUtilitiesNote(String note) {
        yourFinancialCommitmentsSection.typeUtilitiesNote(note);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectChildCarePaymentFrequency(String paymentFrequency) {
        yourFinancialCommitmentsSection.selectChildCarePaymentFrequency(paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeChildCareRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeChildCareRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeChildCareNote(String note) {
        yourFinancialCommitmentsSection.typeChildCareNote(note);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeMortgageOutstandingBalanceAmount(String outstandingBalanceAmount) {
        yourFinancialCommitmentsSection.typeMortgageOutstandingBalanceAmount(outstandingBalanceAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeMortgageFinancialInstitution(String financialInstitution) {
        yourFinancialCommitmentsSection.typeMortgageFinancialInstitution(financialInstitution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeMortgageFinalRepaymentDate(String finalRepaymentDate) {
        yourFinancialCommitmentsSection.typeMortgageFinancialInstitution(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeMortgageRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeMortgageRepaymentAmount(repaymentAmount);
        return this;
    }
}
