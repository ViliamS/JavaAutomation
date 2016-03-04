package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourFinancialCommitmentsSection extends Borrower implements IYourFinancialCommitmentsSection {

    private static final Log log = LogFactory.getLog(YourFinancialCommitmentsSection.class);

    @FindBy ( xpath = FINANCIAL_COMMITMENT_NONE_XPATH )
    protected WebElement weFinancialCommitmentNone;

    @FindBy( xpath = FINANCIAL_COMMITMENTS_NEXT_XPATH )
    protected WebElement weFinancialCommitmentNext;

//    @Inject
    public YourFinancialCommitmentsSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        return getWebElement(FINANCIAL_TITLE_XPATH).getText();
    }

    @Override
    public String getDialogTitle() {
        isVisible(FINANCIAL_CONTAINER_XPATH);
        return getWebElement(FINANCIAL_DIALOG_TITLE_XPATH).getText();
    }

    @Override
    public String getDialogDescription() {
        isVisible(FINANCIAL_DIALOG_DESCRIPTION_XPATH);
        return getWebElement(FINANCIAL_DIALOG_DESCRIPTION_XPATH).getText();
    }

    @Override
    public String getDialogDescription2() {
        isVisible(FINANCIAL_DIALOG_DESCRIPTION2_XPATH);
        return getWebElement(FINANCIAL_DIALOG_DESCRIPTION2_XPATH).getText();
    }

    @Override
    public IYourFinancialCommitmentsSection clickFinancialType(String financialType) {
        switch (financialType) {
            case "Personal":
                this.clickAllPersonal();
                break;
            case "Credit Card":
                this.clickAllCreditCard();
                break;
            case "Maintenance Payment":
                this.clickAllMaintenancePayment();
                break;
            case "Other":
                this.clickAllOther();
                break;
            case "Car":
                this.clickAllCar();
                break;
            case "Student":
                this.clickAllStudent();
                break;
            case "Rent":
                this.clickAllRent();
                break;
            case "Utilities":
                this.clickAllUtilities();
                break;
            case "Child Care":
                this.clickAllChildCare();
                break;
            case "Mortgage":
                this.clickAllMortgage();
                break;
            default:

        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllPersonal() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_PERSONAL_LOAN_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_PERSONAL_LOAN_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickPersonal() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_PERSONAL_LOAN_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogPersonal() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_PERSONAL_LOAN_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllCreditCard() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_CREDIT_CARD_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_CREDIT_CARD_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCreditCard() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_CREDIT_CARD_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogCreditCard() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_CREDIT_CARD_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllMaintenancePayment() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_MAINTENANCE_PAYMENT_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_MAINTENANCE_PAYMENT_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickMaintenancePayment() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_MAINTENANCE_PAYMENT_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogMaintenancePayment() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_MAINTENANCE_PAYMENT_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllOther() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_OTHER_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_OTHER_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickOther() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_OTHER_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogOther() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_OTHER_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllCar() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_CAR_LOAN_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_CAR_LOAN_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCar() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_CAR_LOAN_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogCar() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_CAR_LOAN_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllStudent() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_STUDENT_LOAN_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_STUDENT_LOAN_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickStudent() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_STUDENT_LOAN_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogStudent() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_STUDENT_LOAN_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllRent() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_RENT_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_RENT_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickRent() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_RENT_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogRent() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_RENT_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllUtilities() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_UTILITIES_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_UTILITIES_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickUtilities() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_UTILITIES_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogUtilities() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_UTILITIES_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllChildCare() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_CHILDCARE_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_CHILD_CARE_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickChildCare() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_CHILDCARE_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogChildCare() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_CHILD_CARE_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllMortgage() {
        try {
            isNotVisibleDialog(true);
            getWebElement(FINANCIAL_MORTGAGE_XPATH).click();
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            getWebElement(FINANCIAL_DIALOG_MORTGAGE_XPATH).click();
        }
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickMortgage() {
        isNotVisibleDialog(false);
        clickElement(FINANCIAL_MORTGAGE_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogMortgage() {
        isVisibleDialog(true);
        clickElement(FINANCIAL_DIALOG_MORTGAGE_XPATH);
        return this;
    }

    @Override
    public boolean isVisibleDialog(boolean throwException/*, int timeOut*/) {
        return isVisible(FINANCIAL_CONTAINER_XPATH, true);
//        return this;
    }

    @Override
    public boolean isNotVisibleDialog(boolean throwException/*, int timeOut*/) {
        return isNotVisible(FINANCIAL_CONTAINER_XPATH, 5);
//        return this;
    }

    @Override
    public YourFinancialCommitmentsSection clickNone() {
        isVisible(FINANCIAL_COMMITMENT_NONE_XPATH);
        weFinancialCommitmentNone.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCancel() {
        isVisible(FINANCIAL_CANCEL_XPATH, true);
        clickElement(FINANCIAL_CANCEL_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickSaveAndClose() {
        isVisible(FINANCIAL_SAVE_AND_CLOSE_XPATH, true);
        clickElement(FINANCIAL_SAVE_AND_CLOSE_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickEdit() {
        isVisible(FINANCIAL_EDIT_XPATH, true);
        clickElement(FINANCIAL_EDIT_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDelete() {
        isVisible(FINANCIAL_DELETE_XPATH, true);
        clickElement(FINANCIAL_DELETE_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDone() {
        isVisible(FINANCIAL_DONE_XPATH, true);
        clickElement(FINANCIAL_DONE_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAdd() {
        isVisible(FINANCIAL_ADD_XPATH, true);
        clickElement(FINANCIAL_ADD_XPATH);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickNext() {
        isVisible(FINANCIAL_COMMITMENTS_NEXT_XPATH, true);
        clickElement(FINANCIAL_COMMITMENTS_NEXT_XPATH);
//        weFinancialCommitmentNext.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickWaitIHave() {
        isVisible(FINANCIAL_WAIT_I_HAVE, true);
        clickElement(FINANCIAL_WAIT_I_HAVE);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalOutstandingBalanceAmount(String outstandingBalanceAmount) {
        isVisible(FINANCIAL_PERSONAL_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalFinancialInstitution(String financialInstitution) {
        isVisible(FINANCIAL_PERSONAL_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalLoanPurpose(String loanPurpose) {
        isVisible(FINANCIAL_PERSONAL_LOAN_PURPOSE_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_LOAN_PURPOSE_XPATH, loanPurpose, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalFinalRepaymentDate(String finalRepaymentDate) {
        isVisible(FINANCIAL_PERSONAL_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectPersonalPaymentFrequency(String paymentFrequency) {
        isVisible(FINANCIAL_PERSONAL_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_PERSONAL_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_PERSONAL_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditcRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_CREDITC_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditcProvider(String provider) {
        isVisible(FINANCIAL_CREDITC_PROVIDER_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_PROVIDER_XPATH, provider, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectCreditcType(String type) {
        isVisible(FINANCIAL_CREDITC_CARD_TYPE_XPATH, true);
        selectFromDropDown(FINANCIAL_CREDITC_CARD_TYPE_XPATH, type);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditcLimit(String limit) {
        isVisible(FINANCIAL_CREDITC_CARD_LIMIT_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_CARD_LIMIT_XPATH, limit, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditcBalance(String balance) {
        isVisible(FINANCIAL_CREDITC_CARD_BALANCE_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_CARD_BALANCE_XPATH, balance, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMaintenancepPayment(String payment) {
        isVisible(FINANCIAL_MAINTENANCEP_PAYMENT_XPATH, true);
        sendKeysElement(FINANCIAL_MAINTENANCEP_PAYMENT_XPATH, payment, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_OTHER_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_OTHER_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherValue(String value) {
        isVisible(FINANCIAL_OTHER_VALUE_XPATH, true);
        sendKeysElement(FINANCIAL_OTHER_VALUE_XPATH, value, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherDescription(String description) {
        isVisible(FINANCIAL_OTHER_DESCRIPTION_XPATH, true);
        sendKeysElement(FINANCIAL_OTHER_DESCRIPTION_XPATH, description, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarOutstandingBalanceAmount(String outstandingBalanceAmount) {
        isVisible(FINANCIAL_CAR_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarFinancialInstitution(String financialInstitution) {
        isVisible(FINANCIAL_CAR_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarFinalRepaymentDate(String finalRepaymentDate) {
        isVisible(FINANCIAL_CAR_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectCarPaymentFrequency(String paymentFrequency) {
        isVisible(FINANCIAL_CAR_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_CAR_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_CAR_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentOutstandingBalanceAmount(String outstandingBalanceAmount) {
        isVisible(FINANCIAL_STUDENT_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentFinancialInstitution(String financialInstitution) {
        isVisible(FINANCIAL_STUDENT_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentFinalRepaymentDate(String finalRepaymentDate) {
        isVisible(FINANCIAL_STUDENT_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectStudentPaymentFrequency(String paymentFrequency) {
        isVisible(FINANCIAL_STUDENT_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_STUDENT_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectRentPaymentFrequency(String repaymentFrequency) {
        isVisible(FINANCIAL_RENT_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_RENT_PAYMENT_FREQUENCY_INPUT_XPATH, repaymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeRentRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_RENT_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_RENT_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeRentNote(String note) {
        isVisible(FINANCIAL_RENT_NOTE_XPATH, true);
        sendKeysElement(FINANCIAL_RENT_NOTE_XPATH, note, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectUtilitiesPaymentFrequency(String paymentFrequency) {
        isVisible(FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeUtilitiesRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_UTILITIES_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_UTILITIES_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeUtilitiesNote(String note) {
        isVisible(FINANCIAL_UTILITIES_NOTE_XPATH, true);
        sendKeysElement(FINANCIAL_UTILITIES_NOTE_XPATH, note, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectChildCarePaymentFrequency(String paymentFrequency) {
        isVisible(FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeChildCareRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_CHILDCARE_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CHILDCARE_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeChildCareNote(String note) {
        isVisible(FINANCIAL_CHILDCARE_NOTE_XPATH, true);
        sendKeysElement(FINANCIAL_CHILDCARE_NOTE_XPATH, note, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageOutstandingBalanceAmount(String outstandingBalanceAmount) {
        isVisible(FINANCIAL_MORTGAGE_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageFinancialInstitution(String financialInstitution) {
        isVisible(FINANCIAL_MORTGAGE_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageFinalRepaymentDate(String finalRepaymentDate) {
        isVisible(FINANCIAL_MORTGAGE_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageRepaymentAmount(String repaymentAmount) {
        isVisible(FINANCIAL_MORTGAGE_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        return this;
    }
}
