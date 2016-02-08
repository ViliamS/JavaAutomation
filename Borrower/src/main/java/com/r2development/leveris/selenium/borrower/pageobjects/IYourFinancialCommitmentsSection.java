package com.r2development.leveris.selenium.borrower.pageobjects;

public interface IYourFinancialCommitmentsSection {
    String FINANCIAL_COMMITMENT_TITLE_XPATH = "//h2[contains(., 'Your financial commitments')]";
//    String FINANCIAL_COMMITMENT_TITLE_XPATH = "//div[contains(@data-path, 'pnlNoEmplyments lblNoLiabTitle') and contains(., 'Your financial commitments')]";
    String FINANCIAL_COMMITMENT_DESCRIPTION_XPATH = "//div[@data-path='lblLiabilityQuestion']//span";

//    String FINANCIAL_COMMITMENT_SINGLE_NO_XPATH = "//label[contains(., 'NO I DON')]/following-sibling::span/a";
    String FINANCIAL_COMMITMENT_SINGLE_NO_XPATH = "//a[contains(., 'I have no financial commitments')]";
    String FINANCIAL_COMMITMENT_SINGLE_YES_XPATH = "//label[contains(., 'YES I DO')]/following-sibling::span/a";
    String FINANCIAL_COMMITMENT_COUPLE_NO_XPATH = "//a[contains(., 'We have no financial commitments')]"; //"//label[contains(., 'NO WE DON')]/following-sibling::span/a";
    String FINANCIAL_COMMITMENT_COUPLE_YES_XPATH = "//label[contains(., 'YES WE DO')]/following-sibling::span/a";

    //label[contains(., 'What is type of financial commitment?')]
    // Personal Loan, Credit Card, Maintenance Payment, Other, Car Loan, Student Loan
    String FINANCIAL_COMMITMENT_WHICH_TYPE_XPATH = "//label[contains(., 'What is type of financial commitment?')]/following-sibling::input";

    String FINANCIAL_COMMITMENT_APPLIES_TO_BORROWER_XPATH = "//label[contains(., '${replaceBorrower}$')]/following-sibling::span/a";
    String FINANCIAL_COMMITMENT_APPLIES_TO_COAPPLICANT_XPATH = "//label[contains(., '${replaceCoapplicant}$')]/following-sibling::span/a";

    //div[contains(@id, 'pnlLiabilityList')]
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'LiabilityType')]/span
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'AmountHeader')]/span
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'Borrowers')]/span
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'LiabilityAmount')]/span

    //div[contains(@id, 'Subtotal') and contains(., 'Subtotal:')]
    //div[contains(@id, 'SubtotalValue')]//span

    // Personal Loan
    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_BALANCE_XPATH = "//label[contains(., 'Outstanding amount (balance)')]/following-sibling::input";      // wicketpath pnlOutstandingAmount
//    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_INSTITUTION_XPATH = "//label[contains(., 'Financial institution')]/following-sibling::input";             // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_INSTITUTION_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb']";             // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_FREQUENCY_XPATH = "//label[contains(., 'Repayment frequency')]/following-sibling::input";               // wicketpath pnlPersonalLoan // Weekly, Fortnightly, Monthly, Yearly
//    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_PURPOSE_XPATH = "//label[contains(., 'Purpose of the loan')]/following-sibling::input";               // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_PURPOSE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtLoanPurpose:tb']";               // wicketpath pnlPersonalLoan
//    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_FINAL_REPAYMENT_DATE_XPATH = "//label[contains(., 'Final repayment date')]/following-sibling::input";              // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_FINAL_REPAYMENT_DATE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb']";              // wicketpath pnlPersonalLoan
//    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_AMOUNT_XPATH = "//label[contains(., 'Repayment amount')]/following-sibling::input";                  // wicketpath pnlRepaymentAmount
    String FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_AMOUNT_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb']";                  // wicketpath pnlRepaymentAmount

    // Credit Card
//    String FINANCIAL_COMMITMENT_CREDIT_CARD_REPAYMENT_AMOUNT_XPATH =  "//label[contains(., 'Repayment amount')]/following-sibling::input";                  // wicketpath pnlRepaymentAmount
    String FINANCIAL_COMMITMENT_CREDIT_CARD_REPAYMENT_AMOUNT_XPATH =  "//input[@name='root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb']";                  // wicketpath pnlRepaymentAmount
//    String FINANCIAL_COMMITMENT_CREDIT_CARD_PROVIDER_XPATH = "//label[contains(., 'Card provider')]/following-sibling::input";                     //div[contains(@wicketpath, 'CreditCard')]
    String FINANCIAL_COMMITMENT_CREDIT_CARD_PROVIDER_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:txtCardProvider:tb']";                     //div[contains(@wicketpath, 'CreditCard')]
    // VISA, Mastercard, American Express, Store Card, Other
//    String FINANCIAL_COMMITMENT_CREDIT_CARD_TYPE_XPATH = "//label[contains(., 'Card type')]/following-sibling::input";                         //div[contains(@wicketpath, 'CreditCard')]
    String FINANCIAL_COMMITMENT_CREDIT_CARD_TYPE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:cmbCardType:v']";                         //div[contains(@wicketpath, 'CreditCard')]
//    String FINANCIAL_COMMITMENT_CREDIT_CARD_LIMIT_XPATH = "//label[contains(., 'Card limit')]/following-sibling::input";                        //div[contains(@wicketpath, 'CreditCard')]
    String FINANCIAL_COMMITMENT_CREDIT_CARD_LIMIT_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:crbCardLimit:tb']";                        //div[contains(@wicketpath, 'CreditCard')]
//    String FINANCIAL_COMMITMENT_CREDIT_CARD_BALANCE_XPATH = "//label[contains(., 'Card balance')]/following-sibling::input";                      //div[contains(@wicketpath, 'CreditCard')]
    String FINANCIAL_COMMITMENT_CREDIT_CARD_BALANCE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlCreditCard:c:w:crbCardBalance:tb']";                      //div[contains(@wicketpath, 'CreditCard')]

    // Maintenance Payment
    String FINANCIAL_COMMITMENT_MAINTENANCE_MONTHLY_PAYMENT_XPATH = "//label[contains(., 'Monthly maintenance payment')]/following-sibling::input";       // wicketpath Maintenance

    // Other
//    String FINANCIAL_COMMITMENT_OTHER_REPAYMENT_AMOUNT_XPATH = "//label[contains(., 'Repayment amount')]/following-sibling::input";
    String FINANCIAL_COMMITMENT_OTHER_REPAYMENT_AMOUNT_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb']";
//    String FINANCIAL_COMMITMENT_OTHER_VALUE_XPATH = "//label[contains(., 'Value')]/following-sibling::input";
    String FINANCIAL_COMMITMENT_OTHER_VALUE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:crbValue:tb']";
//    String FINANCIAL_COMMITMENT_OTHER_DESCRIPTION_XPATH = "//label[contains(., 'Description')]/following-sibling::textarea";
    String FINANCIAL_COMMITMENT_OTHER_DESCRIPTION_XPATH = "//textarea[@name='root:c:w:pnlAddNew:c:w:pnlOtherValue:c:w:txaDescription:textarea']";

    // Car Loan
    String FINANCIAL_COMMITMENT_CAR_LOAN_BALANCE_XPATH = "//label[contains(., 'Outstanding amount (balance)')]/following-sibling::input";      // wicketpath pnlOutstandingAmount
//    String FINANCIAL_COMMITMENT_CAR_LOAN_INSTITUTION_XPATH = "//label[contains(., 'Financial institution')]/following-sibling::input";             // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_CAR_LOAN_INSTITUTION_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb']";             // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_FREQUENCY_XPATH = "//label[contains(., 'Repayment frequency')]/following-sibling::input";               // wicketpath pnlPersonalLoan
//    String FINANCIAL_COMMITMENT_CAR_LOAN_FINAL_REPAYMENT_DATE_XPATH = "//label[contains(., 'Final repayment date')]/following-sibling::input";              // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_CAR_LOAN_FINAL_REPAYMENT_DATE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb']";              // wicketpath pnlPersonalLoan
//    String FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_AMOUNT_XPATH = "//label[contains(., 'Repayment amount')]/following-sibling::input";                  // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_AMOUNT_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb']";                  // wicketpath pnlPersonalLoan


    // Student Loan
    String FINANCIAL_COMMITMENT_STUDENT_LOAN_BALANCE_XPATH = "//label[contains(., 'Outstanding amount (balance)')]/following-sibling::input";      // wicketpath pnlOutstandingAmount
//    String FINANCIAL_COMMITMENT_STUDENT_LOAN_INSTITUTION_XPATH = "//label[contains(., 'Financial institution')]/following-sibling::input";             // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_STUDENT_LOAN_INSTITUTION_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinancialInstitution:tb']";             // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_FREQUENCY_XPATH = "//label[contains(., 'Repayment frequency')]/following-sibling::input";               // wicketpath pnlPersonalLoan
//    String FINANCIAL_COMMITMENT_STUDENT_LOAN_FINAL_REPAYMENT_DATE_XPATH = "//label[contains(., 'Final repayment date')]/following-sibling::input";              // wicketpath pnlPersonalLoan
    String FINANCIAL_COMMITMENT_STUDENT_LOAN_FINAL_REPAYMENT_DATE_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlPersonalLoan:c:w:txtFinalRepaymentDate:tb']";              // wicketpath pnlPersonalLoan
//    String FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_AMOUNT_XPATH = "//label[contains(., 'Repayment amount')]/following-sibling::input";                  // wicketpath pnlRepaymentAmount
    String FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_AMOUNT_XPATH = "//input[@name='root:c:w:pnlAddNew:c:w:pnlRepaymentAmount:c:w:crbRepaymentAmount:tb']";                  // wicketpath pnlRepaymentAmount


    String FINANCIAL_COMMITMENTS_ADD_LIABILITY_XPATH = "//a[contains(., 'ADD LIABILITY')]";
    String FINANCIAL_COMMITMENTS_ADD_THIS_LIABILITY_XPATH = "//a[contains(., 'ADD THIS LIABILITY')]";
    String FINANCIAL_COMMITMENTS_EDIT_THIS_LIABILITY_XPATH = "//a[contains(., 'EDIT THIS LIABILITY')]";
    String FINANCIAL_COMMITMENTS_CANCEL_XPATH = "//a[contains(., 'CANCEL')]";
    String FINANCIAL_COMMITMENTS_NEXT_XPATH = "//a[contains(., 'Next section')]";


    IYourFinancialCommitmentsSection clickSingleNo();
    IYourFinancialCommitmentsSection clickSingleYes();
    IYourFinancialCommitmentsSection clickCoupleNo();
    IYourFinancialCommitmentsSection clickCoupleYes();

    IYourFinancialCommitmentsSection selectFinancialCommitmentType(String type);

    IYourFinancialCommitmentsSection checkFinancialCommitmentAppliesToBorrower(String borrower);
    IYourFinancialCommitmentsSection checkFinancialCommitmentAppliesToCoapplicant(String coapplicant);

    IYourFinancialCommitmentsSection typePersonalLoanBalance(String personalLoanBalance);
    IYourFinancialCommitmentsSection typePersonalLoanInstitution(String personalLoanInstitution);
    // Weekly, Fortnightly, Monthly, Yearly
    IYourFinancialCommitmentsSection selectPersonalLoanRepaymentFrequency(String repaymentFrequency);
    IYourFinancialCommitmentsSection typePersonalLoanPurpose(String purpose);
    IYourFinancialCommitmentsSection typePersonalLoanFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsSection typePersonalLoanRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsSection typeCreditCardRepaymentAmount(String repaymentAmount);
    IYourFinancialCommitmentsSection typeCreditCardProvider(String provider);
    // VISA, Mastercard, American Express, Store Card, Other
    IYourFinancialCommitmentsSection selectCreditCardType(String type);
    IYourFinancialCommitmentsSection typeCreditCardLimit(String limit);
    IYourFinancialCommitmentsSection typeCreditCardBalance(String balance);

    IYourFinancialCommitmentsSection typeMaintenanceMonthlyPayment(String monthlyPayment);

    IYourFinancialCommitmentsSection typeOtherRepaymentAmount(String repaymentAmount);
    IYourFinancialCommitmentsSection typeOtherValue(String value);
    IYourFinancialCommitmentsSection typeOtherDescription(String description);

    IYourFinancialCommitmentsSection typeCarLoanBalance(String balance);
    IYourFinancialCommitmentsSection typeCarLoanInstitution(String institution);
    IYourFinancialCommitmentsSection selectCarLoanRepaymentFrequency(String repaymentFrequency);
    IYourFinancialCommitmentsSection typeCarLoanFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsSection typeCarLoanRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsSection typeStudentLoanBalance(String balance);
    IYourFinancialCommitmentsSection typeStudentLoanInstitution(String institution);
    IYourFinancialCommitmentsSection selectStudentLoanRepaymentFrequency(String repaymentFrequency);
    IYourFinancialCommitmentsSection typeStudentLoanFinalRepaymentDate(String finalRepaymentDate);
    IYourFinancialCommitmentsSection typeStudentLoanRepaymentAmount(String repaymentAmount);

    IYourFinancialCommitmentsSection clickEditThisLiability();
    IYourFinancialCommitmentsSection clickAddLiability();
    IYourFinancialCommitmentsSection clickAddThisLiability();
    IYourFinancialCommitmentsSection clickCancel();
    IYourFinancialCommitmentsSection clickNext();

    String getTitle();
    String getDescription();
}
