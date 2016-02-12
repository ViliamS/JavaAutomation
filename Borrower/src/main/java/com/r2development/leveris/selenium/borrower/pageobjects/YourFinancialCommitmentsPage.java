package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class YourFinancialCommitmentsPage extends HeaderAndBottomAndFormsMenuSection implements IYourFinancialCommitmentsPage {
    
    private static final Log log = LogFactory.getLog(YourFinancialCommitmentsPage.class);
    
//    IFormsMenu formsMenu;
    protected IYourFinancialCommitmentsSection yourFinancialCommitmentsSection;

    @Inject
    public YourFinancialCommitmentsPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        yourFinancialCommitmentsSection = new YourFinancialCommitmentsSection(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public IYourFinancialCommitmentsPage clickSingleNo() {
        yourFinancialCommitmentsSection.clickSingleNo();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickSingleYes() {
        yourFinancialCommitmentsSection.clickSingleYes();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickCoupleNo() {
        yourFinancialCommitmentsSection.clickCoupleNo();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickCoupleYes() {
        yourFinancialCommitmentsSection.clickCoupleYes();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectFinancialCommitmentType(String type) {
        yourFinancialCommitmentsSection.selectFinancialCommitmentType(type);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage checkFinancialCommitmentAppliesToBorrower(String borrower) {
        yourFinancialCommitmentsSection.checkFinancialCommitmentAppliesToBorrower(borrower);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage checkFinancialCommitmentAppliesToCoapplicant(String coapplicant) {
        yourFinancialCommitmentsSection.checkFinancialCommitmentAppliesToCoapplicant(coapplicant);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalLoanBalance(String personalLoanBalance) {
        yourFinancialCommitmentsSection.typePersonalLoanBalance(personalLoanBalance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalLoanInstitution(String personalLoanInstitution) {
        yourFinancialCommitmentsSection.typePersonalLoanInstitution(personalLoanInstitution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectPersonalLoanRepaymentFrequency(String repaymentFrequency) {
        yourFinancialCommitmentsSection.selectPersonalLoanRepaymentFrequency(repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalLoanPurpose(String purpose) {
        yourFinancialCommitmentsSection.typePersonalLoanPurpose(purpose);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalLoanFinalRepaymentDate(String finalRepaymentDate) {
        yourFinancialCommitmentsSection.typePersonalLoanFinalRepaymentDate(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typePersonalLoanRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typePersonalLoanRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditCardRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeCreditCardRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditCardProvider(String provider) {
        yourFinancialCommitmentsSection.typeCreditCardProvider(provider);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectCreditCardType(String type) {
        yourFinancialCommitmentsSection.selectCreditCardType(type);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditCardLimit(String limit) {
        yourFinancialCommitmentsSection.typeCreditCardLimit(limit);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCreditCardBalance(String balance) {
        yourFinancialCommitmentsSection.typeCreditCardBalance(balance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeMaintenanceMonthlyPayment(String monthlyPayment) {
        yourFinancialCommitmentsSection.typeMaintenanceMonthlyPayment(monthlyPayment);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeOtherRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeOtherRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeOtherValue(String value) {
        yourFinancialCommitmentsSection.typeOtherValue(value);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeOtherDescription(String description) {
        yourFinancialCommitmentsSection.typeOtherDescription(description);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarLoanBalance(String balance) {
        yourFinancialCommitmentsSection.typeCarLoanBalance(balance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarLoanInstitution(String institution) {
        yourFinancialCommitmentsSection.typeCarLoanInstitution(institution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectCarLoanRepaymentFrequency(String repaymentFrequency) {
        yourFinancialCommitmentsSection.selectCarLoanRepaymentFrequency(repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarLoanFinalRepaymentDate(String finalRepaymentDate) {
        yourFinancialCommitmentsSection.typeCarLoanFinalRepaymentDate(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeCarLoanRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeCarLoanRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentLoanBalance(String balance) {
        yourFinancialCommitmentsSection.typeStudentLoanBalance(balance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentLoanInstitution(String institution) {
        yourFinancialCommitmentsSection.typeStudentLoanInstitution(institution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage selectStudentLoanRepaymentFrequency(String repaymentFrequency) {
        yourFinancialCommitmentsSection.selectStudentLoanRepaymentFrequency(repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentLoanFinalRepaymentDate(String finalRepaymentDate) {
        yourFinancialCommitmentsSection.typeStudentLoanFinalRepaymentDate(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage typeStudentLoanRepaymentAmount(String repaymentAmount) {
        yourFinancialCommitmentsSection.typeStudentLoanRepaymentAmount(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickEditThisLiability() {
        yourFinancialCommitmentsSection.clickEditThisLiability();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickAddLiability() {
        yourFinancialCommitmentsSection.clickAddLiability();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickAddThisLiability() {
        yourFinancialCommitmentsSection.clickAddThisLiability();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickCancel() {
        yourFinancialCommitmentsSection.clickCancel();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickNext() {
        yourFinancialCommitmentsSection.clickNext();
        return this;
    }

    @Override
    public String getTitle() {
        return yourFinancialCommitmentsSection.getTitle();
    }

    @Override
    public String getDescription() {
        return yourFinancialCommitmentsSection.getDescription();
    }
}
