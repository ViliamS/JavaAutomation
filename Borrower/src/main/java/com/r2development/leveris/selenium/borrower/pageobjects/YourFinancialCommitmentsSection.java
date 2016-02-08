package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourFinancialCommitmentsSection extends Borrower implements IYourFinancialCommitmentsSection {

    private static final Log log = LogFactory.getLog(YourFinancialCommitmentsSection.class);

    @FindBy( xpath = FINANCIAL_COMMITMENT_TITLE_XPATH )
    protected WebElement weFinancialCommitmentTitle;
    @FindBy( xpath = FINANCIAL_COMMITMENT_DESCRIPTION_XPATH )
    protected WebElement weFinancialCommitmentDescription;

    @FindBy( xpath = FINANCIAL_COMMITMENT_SINGLE_NO_XPATH )
    protected WebElement weFinancialCommitmentSingleNo;
    @FindBy( xpath = FINANCIAL_COMMITMENT_SINGLE_YES_XPATH )
    protected WebElement weFinancialCommitmentSingleYes;
    @FindBy( xpath = FINANCIAL_COMMITMENT_COUPLE_NO_XPATH )
    protected WebElement weFinancialCommitmentCoupleNo;
    @FindBy( xpath = FINANCIAL_COMMITMENT_COUPLE_YES_XPATH )
    protected WebElement weFinancialCommitmentCoupleYes;

    //label[contains(., 'What is type of financial commitment?')]
    // Personal Loan, Credit Card, Maintenance Payment, Other, Car Loan, Student Loan
    @FindBy( xpath = FINANCIAL_COMMITMENT_WHICH_TYPE_XPATH )
    protected WebElement weFinancialCommitmentWhichType;

    @FindBy( xpath = FINANCIAL_COMMITMENT_APPLIES_TO_BORROWER_XPATH )
    protected WebElement weFinancialCommitmentAppliesToBorrower;
    @FindBy( xpath = FINANCIAL_COMMITMENT_APPLIES_TO_COAPPLICANT_XPATH )
    protected WebElement weFinancialCommitmentAppliesToCoapplicant;

    //div[contains(@id, 'pnlLiabilityList')]
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'LiabilityType')]/span
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'AmountHeader')]/span
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'Borrowers')]/span
    //div[contains(@id, 'pnlLiabilityList')]//div[contains(@wicketpath, 'LiabilityAmount')]/span

    //div[contains(@id, 'Subtotal') and contains(., 'Subtotal:')]
    //div[contains(@id, 'SubtotalValue')]//span

    // Personal Loan
    @FindBy( xpath = FINANCIAL_COMMITMENT_PERSONAL_LOAN_BALANCE_XPATH )      // wicketpath pnlOutstandingAmount
    protected WebElement weFinancialCommitmentPersonalLoanBalance;
    @FindBy( xpath = FINANCIAL_COMMITMENT_PERSONAL_LOAN_INSTITUTION_XPATH )             // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentPersonalLoanInstitution;
    @FindBy( xpath = FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_FREQUENCY_XPATH )               // wicketpath pnlPersonalLoan // Weekly, Fortnightly, Monthly, Yearly
    protected WebElement weFinancialCommitmentPersonalLoanRepaymentFrequency;
    @FindBy( xpath = FINANCIAL_COMMITMENT_PERSONAL_LOAN_PURPOSE_XPATH )               // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentPersonalLoanPurpose;
    @FindBy( xpath = FINANCIAL_COMMITMENT_PERSONAL_LOAN_FINAL_REPAYMENT_DATE_XPATH )              // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentPersonalLoanFinalRepaymentDate;
    @FindBy( xpath = FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_AMOUNT_XPATH )                  // wicketpath pnlRepaymentAmount
    protected WebElement weFinancialCommitmentPersonalLoanRepaymentAmount;

    // Credit Card
    @FindBy( xpath = FINANCIAL_COMMITMENT_CREDIT_CARD_REPAYMENT_AMOUNT_XPATH )                  // wicketpath pnlRepaymentAmount
    protected WebElement weFinancialCommitmentCreditCardRepaymentAmount;
    @FindBy( xpath = FINANCIAL_COMMITMENT_CREDIT_CARD_PROVIDER_XPATH )                     //div[contains(@wicketpath, 'CreditCard')]
    protected WebElement weFinancialCommitmentCreditCardProvider;
    // VISA, Mastercard, American Express, Store Card, Other
    @FindBy( xpath = FINANCIAL_COMMITMENT_CREDIT_CARD_TYPE_XPATH )                         //div[contains(@wicketpath, 'CreditCard')]
    protected WebElement weFinancialCommitmentCreditCardType;
    @FindBy( xpath = FINANCIAL_COMMITMENT_CREDIT_CARD_LIMIT_XPATH )                        //div[contains(@wicketpath, 'CreditCard')]
    protected WebElement weFinancialCommitmentCreditCardLimit;
    @FindBy( xpath = FINANCIAL_COMMITMENT_CREDIT_CARD_BALANCE_XPATH )
    protected WebElement weFinancialCommitmentCreditCardBalance;

    // Maintenance Payment
    @FindBy( xpath = FINANCIAL_COMMITMENT_MAINTENANCE_MONTHLY_PAYMENT_XPATH )
    protected WebElement weFinancialCommitmentMaintenanceMonthlyPayment;

    // Other
    @FindBy( xpath = FINANCIAL_COMMITMENT_OTHER_REPAYMENT_AMOUNT_XPATH )
    protected WebElement weFinancialCommitmentOtherRepaymentAmount;
    @FindBy( xpath = FINANCIAL_COMMITMENT_OTHER_VALUE_XPATH )
    protected WebElement weFinancialCommitmentOtherValue;
    @FindBy( xpath = FINANCIAL_COMMITMENT_OTHER_DESCRIPTION_XPATH )
    protected WebElement weFinancialCommitmentOtherDescription;

    // Car Loan
    @FindBy( xpath = FINANCIAL_COMMITMENT_CAR_LOAN_BALANCE_XPATH  )      // wicketpath pnlOutstandingAmount
    protected WebElement weFinancialCommitmentCarLoanBalance;
    @FindBy( xpath = FINANCIAL_COMMITMENT_CAR_LOAN_INSTITUTION_XPATH  )             // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentCarLoanInstitution;
    @FindBy( xpath = FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_FREQUENCY_XPATH  )               // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentCarLoanRepaymentFrequency;
    @FindBy( xpath = FINANCIAL_COMMITMENT_CAR_LOAN_FINAL_REPAYMENT_DATE_XPATH  )              // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentCarLoanFinalRepaymentDate;
    @FindBy( xpath = FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_AMOUNT_XPATH  )                  // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentCarLoanRepaymentAmount;

    // Student Loan
    @FindBy( xpath = FINANCIAL_COMMITMENT_STUDENT_LOAN_BALANCE_XPATH  )      // wicketpath pnlOutstandingAmount
    protected WebElement weFinancialCommitmentStudentLoanBalance;
    @FindBy( xpath = FINANCIAL_COMMITMENT_STUDENT_LOAN_INSTITUTION_XPATH  )             // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentStudentLoanInstitution;
    @FindBy( xpath = FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_FREQUENCY_XPATH  )               // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentStudentLoanRepaymentFrequency;
    @FindBy( xpath = FINANCIAL_COMMITMENT_STUDENT_LOAN_FINAL_REPAYMENT_DATE_XPATH  )              // wicketpath pnlPersonalLoan
    protected WebElement weFinancialCommitmentStudentLoanFinalRepaymentDate;
    @FindBy( xpath = FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_AMOUNT_XPATH  )                  // wicketpath pnlRepaymentAmount
    protected WebElement weFinancialCommitmentStudentLoanRepaymentAmount;

    @FindBy( xpath = FINANCIAL_COMMITMENTS_ADD_LIABILITY_XPATH )
    protected WebElement weFinancialCommitmentAddLiability;
    @FindBy( xpath = FINANCIAL_COMMITMENTS_ADD_THIS_LIABILITY_XPATH  )
    protected WebElement weFinancialCommitmentAddThisLiability;
    @FindBy( xpath = FINANCIAL_COMMITMENTS_EDIT_THIS_LIABILITY_XPATH  )
    protected WebElement weFinancialCommitmentEditThisLiability;
    @FindBy( xpath = FINANCIAL_COMMITMENTS_CANCEL_XPATH  )
    protected WebElement weFinancialCommitmentCancel;
    @FindBy( xpath = FINANCIAL_COMMITMENTS_NEXT_XPATH  )
    protected WebElement weFinancialCommitmentNext;

    public YourFinancialCommitmentsSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        isVisible(FINANCIAL_COMMITMENT_TITLE_XPATH, true, 10);
        return getWebElement(FINANCIAL_COMMITMENT_TITLE_XPATH).getText();
//        return weFinancialCommitmentTitle.getText();
    }

    @Override
    public String getDescription() {
        return weFinancialCommitmentDescription.getText();
    }

    @Override
    public IYourFinancialCommitmentsSection clickSingleNo() {
        isVisible(FINANCIAL_COMMITMENT_SINGLE_NO_XPATH, true);
//        weFinancialCommitmentSingleNo.click();
        clickElement(FINANCIAL_COMMITMENT_SINGLE_NO_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickSingleYes() {
        isVisible(FINANCIAL_COMMITMENT_SINGLE_YES_XPATH, true);
        weFinancialCommitmentSingleYes.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCoupleNo() {
        isVisible(FINANCIAL_COMMITMENT_COUPLE_NO_XPATH, true);
        weFinancialCommitmentCoupleNo.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCoupleYes() {
        isVisible(FINANCIAL_COMMITMENT_COUPLE_YES_XPATH, true);
        weFinancialCommitmentCoupleYes.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectFinancialCommitmentType(String type) {
        isVisible(FINANCIAL_COMMITMENT_WHICH_TYPE_XPATH, true);
        selectFromDropDown(FINANCIAL_COMMITMENT_WHICH_TYPE_XPATH, type);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection checkFinancialCommitmentAppliesToBorrower(String borrower) {
        isVisible(FINANCIAL_COMMITMENT_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower), true);
        getWebElement(FINANCIAL_COMMITMENT_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower)).click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection checkFinancialCommitmentAppliesToCoapplicant(String coapplicant) {
        isVisible(FINANCIAL_COMMITMENT_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant), true);
        getWebElement(FINANCIAL_COMMITMENT_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant)).click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalLoanBalance(String personalLoanBalance) {
        isVisible(FINANCIAL_COMMITMENT_PERSONAL_LOAN_BALANCE_XPATH, true);
        weFinancialCommitmentPersonalLoanBalance.clear();
        weFinancialCommitmentPersonalLoanBalance.sendKeys(personalLoanBalance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalLoanInstitution(String personalLoanInstitution) {
        isVisible(FINANCIAL_COMMITMENT_PERSONAL_LOAN_INSTITUTION_XPATH, true);
        weFinancialCommitmentPersonalLoanInstitution.clear();
        weFinancialCommitmentPersonalLoanInstitution.sendKeys(personalLoanInstitution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectPersonalLoanRepaymentFrequency(String repaymentFrequency) {
        isVisible(FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_FREQUENCY_XPATH, true);
        selectFromDropDown(FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_FREQUENCY_XPATH, repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalLoanPurpose(String purpose) {
        isVisible(FINANCIAL_COMMITMENT_PERSONAL_LOAN_PURPOSE_XPATH, true);
        weFinancialCommitmentPersonalLoanPurpose.clear();
        weFinancialCommitmentPersonalLoanPurpose.sendKeys(purpose);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalLoanFinalRepaymentDate(String finalRepaymentDate) {
        isVisible(FINANCIAL_COMMITMENT_PERSONAL_LOAN_FINAL_REPAYMENT_DATE_XPATH, true);
        weFinancialCommitmentPersonalLoanFinalRepaymentDate.clear();
        weFinancialCommitmentPersonalLoanFinalRepaymentDate.sendKeys(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalLoanRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_COMMITMENT_PERSONAL_LOAN_REPAYMENT_AMOUNT_XPATH, true);
        weFinancialCommitmentPersonalLoanRepaymentAmount.clear();
        weFinancialCommitmentPersonalLoanRepaymentAmount.sendKeys(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_COMMITMENT_CREDIT_CARD_REPAYMENT_AMOUNT_XPATH, true);
        weFinancialCommitmentCreditCardRepaymentAmount.clear();
        weFinancialCommitmentCreditCardRepaymentAmount.sendKeys(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardProvider(String provider) {
        isVisible(FINANCIAL_COMMITMENT_CREDIT_CARD_PROVIDER_XPATH, true);
        weFinancialCommitmentCreditCardProvider.clear();
        weFinancialCommitmentCreditCardProvider.sendKeys(provider);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectCreditCardType(String type) {
        isVisible(FINANCIAL_COMMITMENT_CREDIT_CARD_TYPE_XPATH, true);
        selectFromDropDown(FINANCIAL_COMMITMENT_CREDIT_CARD_TYPE_XPATH, type);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardLimit(String limit) {
        isVisible(FINANCIAL_COMMITMENT_CREDIT_CARD_LIMIT_XPATH, true);
        weFinancialCommitmentCreditCardLimit.clear();
        weFinancialCommitmentCreditCardLimit.sendKeys(limit);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardBalance(String balance) {
        isVisible(FINANCIAL_COMMITMENT_CREDIT_CARD_BALANCE_XPATH, true);
        weFinancialCommitmentCreditCardBalance.clear();
        weFinancialCommitmentCreditCardBalance.sendKeys(balance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMaintenanceMonthlyPayment(String monthlyPayment) {
        isVisible(FINANCIAL_COMMITMENT_MAINTENANCE_MONTHLY_PAYMENT_XPATH, true);
        weFinancialCommitmentMaintenanceMonthlyPayment.clear();
        weFinancialCommitmentMaintenanceMonthlyPayment.sendKeys(monthlyPayment);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_COMMITMENT_OTHER_REPAYMENT_AMOUNT_XPATH, true);
        weFinancialCommitmentOtherRepaymentAmount.clear();
        weFinancialCommitmentOtherRepaymentAmount.sendKeys(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherValue(String value) {
        isVisible(FINANCIAL_COMMITMENT_OTHER_VALUE_XPATH, true);
        weFinancialCommitmentOtherValue.clear();
        weFinancialCommitmentOtherValue.sendKeys(value);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherDescription(String description) {
        isVisible(FINANCIAL_COMMITMENT_OTHER_DESCRIPTION_XPATH, true);
        weFinancialCommitmentOtherDescription.clear();
        weFinancialCommitmentOtherDescription.sendKeys(description);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarLoanBalance(String balance) {
        isVisible(FINANCIAL_COMMITMENT_CAR_LOAN_BALANCE_XPATH, true);
        weFinancialCommitmentCarLoanBalance.clear();
        weFinancialCommitmentCarLoanBalance.sendKeys(balance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarLoanInstitution(String institution) {
        isVisible(FINANCIAL_COMMITMENT_CAR_LOAN_INSTITUTION_XPATH, true);
        weFinancialCommitmentCarLoanInstitution.clear();
        weFinancialCommitmentCarLoanInstitution.sendKeys(institution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectCarLoanRepaymentFrequency(String repaymentFrequency) {
        isVisible(FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_FREQUENCY_XPATH, true);
        selectFromDropDown(FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_FREQUENCY_XPATH, repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarLoanFinalRepaymentDate(String finalRepaymentDate) {
        isVisible(FINANCIAL_COMMITMENT_CAR_LOAN_FINAL_REPAYMENT_DATE_XPATH, true);
        weFinancialCommitmentCarLoanFinalRepaymentDate.clear();
        weFinancialCommitmentCarLoanFinalRepaymentDate.sendKeys(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarLoanRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_COMMITMENT_CAR_LOAN_REPAYMENT_AMOUNT_XPATH, true);
        weFinancialCommitmentCarLoanRepaymentAmount.clear();
        weFinancialCommitmentCarLoanRepaymentAmount.sendKeys(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentLoanBalance(String balance) {
        isVisible(FINANCIAL_COMMITMENT_STUDENT_LOAN_BALANCE_XPATH, true);
        weFinancialCommitmentStudentLoanBalance.clear();
        weFinancialCommitmentStudentLoanBalance.sendKeys(balance);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentLoanInstitution(String institution) {
        isVisible(FINANCIAL_COMMITMENT_STUDENT_LOAN_INSTITUTION_XPATH, true);
        weFinancialCommitmentStudentLoanInstitution.clear();
        weFinancialCommitmentStudentLoanInstitution.sendKeys(institution);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectStudentLoanRepaymentFrequency(String repaymentFrequency) {
        isVisible(FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_FREQUENCY_XPATH, true);
        selectFromDropDown(FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_FREQUENCY_XPATH, repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentLoanFinalRepaymentDate(String finalRepaymentDate) {
        isVisible(FINANCIAL_COMMITMENT_STUDENT_LOAN_FINAL_REPAYMENT_DATE_XPATH, true);
        weFinancialCommitmentStudentLoanFinalRepaymentDate.clear();
        weFinancialCommitmentStudentLoanFinalRepaymentDate.sendKeys(finalRepaymentDate);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentLoanRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_COMMITMENT_STUDENT_LOAN_REPAYMENT_AMOUNT_XPATH, true);
        weFinancialCommitmentStudentLoanRepaymentAmount.clear();
        weFinancialCommitmentStudentLoanRepaymentAmount.sendKeys(repaymentAmount);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickEditThisLiability() {
        isVisible(FINANCIAL_COMMITMENTS_EDIT_THIS_LIABILITY_XPATH, true);
        weFinancialCommitmentEditThisLiability.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAddLiability() {
        isVisible(FINANCIAL_COMMITMENTS_ADD_LIABILITY_XPATH, true);
        weFinancialCommitmentAddLiability.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAddThisLiability() {
        isVisible(FINANCIAL_COMMITMENTS_ADD_THIS_LIABILITY_XPATH, true);
        weFinancialCommitmentAddThisLiability.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCancel() {
        isVisible(FINANCIAL_COMMITMENTS_CANCEL_XPATH, true);
        weFinancialCommitmentCancel.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickNext() {
//        isVisible(FINANCIAL_COMMITMENTS_NEXT_XPATH, true);
        clickElement(FINANCIAL_COMMITMENTS_NEXT_XPATH);
//        weFinancialCommitmentNext.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }
}
