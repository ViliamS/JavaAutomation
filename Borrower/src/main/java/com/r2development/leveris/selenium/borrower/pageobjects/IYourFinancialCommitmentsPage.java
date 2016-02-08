package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourFinancialCommitmentsPage {
    IYourFinancialCommitmentsPage clickSingleNo();
    IYourFinancialCommitmentsPage clickSingleYes();
    IYourFinancialCommitmentsPage clickCoupleNo();
    IYourFinancialCommitmentsPage clickCoupleYes();

    IYourFinancialCommitmentsPage selectFinancialCommitmentType(String type);

    IYourFinancialCommitmentsPage checkFinancialCommitmentAppliesToBorrower(String borrower);
    IYourFinancialCommitmentsPage checkFinancialCommitmentAppliesToCoapplicant(String coapplicant);

    IYourFinancialCommitmentsPage typePersonalLoanBalance(String personalLoanBalance);
    IYourFinancialCommitmentsPage typePersonalLoanInstitution(String personalLoanInstitution);
    // Weekly, Fortnightly, Monthly, Yearly
    IYourFinancialCommitmentsPage selectPersonalLoanRepaymentFrequency(String repaymentFrequency);
    IYourFinancialCommitmentsPage typePersonalLoanPurpose(String purpose);
    IYourFinancialCommitmentsPage typePersonalLoanFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsPage typePersonalLoanRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsPage typeCreditCardRepaymentAmount(String repaymentAmount);
    IYourFinancialCommitmentsPage typeCreditCardProvider(String provider);
    // VISA, Mastercard, American Express, Store Card, Other
    IYourFinancialCommitmentsPage selectCreditCardType(String type);
    IYourFinancialCommitmentsPage typeCreditCardLimit(String limit);
    IYourFinancialCommitmentsPage typeCreditCardBalance(String balance);

    IYourFinancialCommitmentsPage typeMaintenanceMonthlyPayment(String monthlyPayment);

    IYourFinancialCommitmentsPage typeOtherRepaymentAmount(String repaymentAmount);
    IYourFinancialCommitmentsPage typeOtherValue(String value);
    IYourFinancialCommitmentsPage typeOtherDescription(String description);

    IYourFinancialCommitmentsPage typeCarLoanBalance(String balance);
    IYourFinancialCommitmentsPage typeCarLoanInstitution(String institution);
    IYourFinancialCommitmentsPage selectCarLoanRepaymentFrequency(String repaymentFrequency);
    IYourFinancialCommitmentsPage typeCarLoanFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsPage typeCarLoanRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsPage typeStudentLoanBalance(String balance);
    IYourFinancialCommitmentsPage typeStudentLoanInstitution(String institution);
    IYourFinancialCommitmentsPage selectStudentLoanRepaymentFrequency(String repaymentFrequency);
    IYourFinancialCommitmentsPage typeStudentLoanFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsPage typeStudentLoanRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsPage clickEditThisLiability();
    IYourFinancialCommitmentsPage clickAddLiability();
    IYourFinancialCommitmentsPage clickAddThisLiability();
    IYourFinancialCommitmentsPage clickCancel();
    IYourFinancialCommitmentsPage clickNext();

    String getTitle();
    String getDescription();
}
