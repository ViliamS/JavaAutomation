package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class YourFinancialCommitmentsSection extends Borrower implements IYourFinancialCommitmentsSection {

    private static final Log log = LogFactory.getLog(YourFinancialCommitmentsSection.class.getName());

    @FindBy ( xpath = FINANCIAL_COMMITMENT_NONE_XPATH )
    protected WebElement weFinancialCommitmentNone;

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
        loadingCheck();
        isVisible(FINANCIAL_CONTAINER_XPATH, 0);
        return getWebElement(FINANCIAL_DIALOG_TITLE_XPATH).getText();
    }

    @Override
    public String getDialogDescription() {
        loadingCheck();
        isVisible(FINANCIAL_DIALOG_DESCRIPTION_XPATH, 0);
        return getWebElement(FINANCIAL_DIALOG_DESCRIPTION_XPATH).getText();
    }

    @Override
    public String getDialogDescription2() {
        loadingCheck();
        isVisible(FINANCIAL_DIALOG_DESCRIPTION2_XPATH);
        return getWebElement(FINANCIAL_DIALOG_DESCRIPTION2_XPATH).getText();
    }

    @Override
    public IYourFinancialCommitmentsSection clickFinancialType(String financialType) {
        log.info("clickFinancialType logical crossroad ---> financialType = '" + financialType + "'");

        loadingCheck();
        if(!isVisible(FINANCIAL_PERSONAL_LOAN_XPATH, 5))
            try {
                clickAdd();
            } catch(Exception x){
                if(isVisible(FINANCIAL_ADD_XPATH, 1) && !isVisible(FINANCIAL_PERSONAL_LOAN_XPATH, 1) && !isVisible(FINANCIAL_SAVE_AND_CLOSE_XPATH, 1))
                    clickAdd();
                else if(isVisible(FINANCIAL_PERSONAL_LOAN_XPATH, 1))
                    clickFinancialType(financialType);
                else if(isVisible(FINANCIAL_SAVE_AND_CLOSE_XPATH, 1))
                    Assert.assertTrue("We already choose the Financial commitment so failing due to navigation error", false);
            }

        switch (financialType) {
            case "Personal Loan":
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
            case "Car Loan":
                this.clickAllCar();
                break;
            case "Student Loan":
                this.clickAllStudent();
                break;
            case "Rent":
                this.clickAllRent();
                break;
            case "Utilities":
                this.clickAllUtilities();
                break;
            case "Childcare":
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
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_PERSONAL_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_PERSONAL_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickPersonal() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_PERSONAL_LOAN_XPATH, FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogPersonal() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_PERSONAL_LOAN_XPATH, FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllCreditCard() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_CREDIT_CARD_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_CREDIT_CARD_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCreditCard() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_CREDIT_CARD_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogCreditCard() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_CREDIT_CARD_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllMaintenancePayment() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_MAINTENANCE_PAYMENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_MAINTENANCE_PAYMENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickMaintenancePayment() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_MAINTENANCE_PAYMENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogMaintenancePayment() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_MAINTENANCE_PAYMENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllOther() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_OTHER_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_OTHER_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickOther() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_OTHER_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogOther() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_OTHER_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllCar() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_CAR_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_CAR_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCar() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_CAR_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogCar() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_CAR_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllStudent() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_STUDENT_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_STUDENT_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickStudent() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_STUDENT_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogStudent() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_STUDENT_LOAN_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllRent() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_RENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_RENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickRent() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_RENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogRent() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_RENT_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllUtilities() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_UTILITIES_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_UTILITIES_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickUtilities() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_UTILITIES_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogUtilities() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_UTILITIES_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllChildCare() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_CHILDCARE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_CHILD_CARE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickChildCare() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_CHILDCARE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogChildCare() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_CHILD_CARE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAllMortgage() {
        loadingCheck();
        try {
            isNotVisibleDialog(true);
            clickElementLoop(FINANCIAL_MORTGAGE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        catch ( TimeoutException e) {
            isVisibleDialog(true);
            clickElementLoop(FINANCIAL_DIALOG_MORTGAGE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        }
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickMortgage() {
        loadingCheck();
        isNotVisibleDialog(false);
        clickElementLoop(FINANCIAL_MORTGAGE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDialogMortgage() {
        loadingCheck();
        isVisibleDialog(true);
        clickElementLoop(FINANCIAL_DIALOG_MORTGAGE_XPATH ,FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public boolean isVisibleDialog(boolean throwException/*, int timeOut*/) {
        loadingCheck();
        return isVisible(FINANCIAL_CONTAINER_XPATH, true);
//        return this;
    }

    @Override
    public boolean isNotVisibleDialog(boolean throwException/*, int timeOut*/) {
        loadingCheck();
        return isNotVisible(FINANCIAL_CONTAINER_XPATH, 5);
//        return this;
    }

    @Override
    public YourFinancialCommitmentsSection clickNone() {
        loadingCheck();
        isVisible(FINANCIAL_COMMITMENT_NONE_XPATH);
        weFinancialCommitmentNone.click();
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickCancel() {
        loadingCheck();
        isVisible(FINANCIAL_CANCEL_XPATH, true);
        clickElement(FINANCIAL_CANCEL_XPATH);
        loadingCheck();
        return this;
    }

    private Map<String, String> formExceptionDetails(){
        Map<String, String> formExceptionDetails = new LinkedHashMap<>();
        formExceptionDetails.put(
                "FormName",
                "\n Save and close button is still present! \n" +
                        " Extracting exception text from the form \n"
        );

        formExceptionDetails.put(
                "GetExceptionResult1",
                "\n --------------------------------------------------------------\n" +
                        " | Not being able to save the form @!wtf!@                         | \n" +
                        " | it is due to : '"
        );

        formExceptionDetails.put(
                "GetExceptionResult2",
                "' is displayed on page | \n" +
                        " -------------------------------------------------------------- \n"
        );

        formExceptionDetails.put(
                "FormAction",
                "Failed clickSaveAndClose"
        );
        return formExceptionDetails;
    }


    @Override
    public IYourFinancialCommitmentsSection clickSaveAndClose() {
        log.info("clickSaveAndClose by xpath ---> " + FINANCIAL_SAVE_AND_CLOSE_XPATH + "<---");

        loadingCheck();
        isVisible(FINANCIAL_SAVE_AND_CLOSE_XPATH, true);
        clickElement(FINANCIAL_SAVE_AND_CLOSE_XPATH);
        loadingCheck();
        formSubmitPostSync(FINANCIAL_SAVE_AND_CLOSE_XPATH, formExceptionDetails());
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickEdit() {
        loadingCheck();
        isVisible(FINANCIAL_EDIT_XPATH, true);
        clickElement(FINANCIAL_EDIT_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDelete() {
        loadingCheck();
        isVisible(FINANCIAL_DELETE_XPATH, true);
        clickElement(FINANCIAL_DELETE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickDone() {
        log.info("\n ------------------------------------------ \n" +
                "| IYourFinancialCommitmentsSection.clickDone() \n" +
                "| by xpath ---> " + FINANCIAL_DONE_XPATH + "<---");
        loadingCheck();
        isVisible(FINANCIAL_DONE_XPATH, true);
        clickElement(FINANCIAL_DONE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickAdd() {
        log.info("\n ------------------------------------------ \n" +
                "| IYourFinancialCommitmentsSection.clickAdd() \n" +
                "| by xpath ---> " + FINANCIAL_ADD_XPATH + "<---");
        loadingCheck();
        isVisible(FINANCIAL_ADD_XPATH, true);
        clickElementLoop(FINANCIAL_ADD_XPATH, FINANCIAL_DIALOG_PERSONAL_LOAN_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickNext() {
        loadingCheck();
        isVisible(FINANCIAL_COMMITMENTS_NEXT_XPATH, true);
        clickElement(FINANCIAL_COMMITMENTS_NEXT_XPATH);
        loadingCheck();
//        weFinancialCommitmentNext.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection clickWaitIHave() {
        loadingCheck();
        isVisible(FINANCIAL_WAIT_I_HAVE, true);
        clickElement(FINANCIAL_WAIT_I_HAVE);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalOutstandingBalanceAmount(String outstandingBalanceAmount) {
        loadingCheck();
        isVisible(FINANCIAL_PERSONAL_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalFinancialInstitution(String financialInstitution) {
        loadingCheck();
        isVisible(FINANCIAL_PERSONAL_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalLoanPurpose(String loanPurpose) {
        loadingCheck();
        isVisible(FINANCIAL_PERSONAL_LOAN_PURPOSE_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_LOAN_PURPOSE_XPATH, loanPurpose, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalFinalRepaymentDate(String finalRepaymentDate) {
        loadingCheck();
        isVisible(FINANCIAL_PERSONAL_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectPersonalPaymentFrequency(String paymentFrequency) {
        loadingCheck();
        isVisible(FINANCIAL_PERSONAL_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_PERSONAL_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typePersonalRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_PERSONAL_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_PERSONAL_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_CREDITC_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardProvider(String provider) {
        loadingCheck();
        isVisible(FINANCIAL_CREDITC_PROVIDER_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_PROVIDER_XPATH, provider, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectCreditCardType(String type) {
        loadingCheck();
        isVisible(FINANCIAL_CREDITC_CARD_TYPE_XPATH, true);
        selectFromDropDown(FINANCIAL_CREDITC_CARD_TYPE_XPATH, type);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardLimit(String limit) {
        loadingCheck();
        isVisible(FINANCIAL_CREDITC_CARD_LIMIT_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_CARD_LIMIT_XPATH, limit, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCreditCardBalance(String balance) {
        loadingCheck();
        isVisible(FINANCIAL_CREDITC_CARD_BALANCE_XPATH, true);
        sendKeysElement(FINANCIAL_CREDITC_CARD_BALANCE_XPATH, balance, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMaintenancePayment(String payment) {
        loadingCheck();
        isVisible(FINANCIAL_MAINTENANCEP_PAYMENT_XPATH, true);
        sendKeysElement(FINANCIAL_MAINTENANCEP_PAYMENT_XPATH, payment, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_OTHER_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_OTHER_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherValue(String value) {
        loadingCheck();
        isVisible(FINANCIAL_OTHER_VALUE_XPATH, true);
        sendKeysElement(FINANCIAL_OTHER_VALUE_XPATH, value, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeOtherDescription(String description) {
        loadingCheck();
        isVisible(FINANCIAL_OTHER_DESCRIPTION_XPATH, true);
        sendKeysElement(FINANCIAL_OTHER_DESCRIPTION_XPATH, description, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarOutstandingBalanceAmount(String outstandingBalanceAmount) {
        loadingCheck();
        isVisible(FINANCIAL_CAR_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarFinancialInstitution(String financialInstitution) {
        loadingCheck();
        isVisible(FINANCIAL_CAR_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarFinalRepaymentDate(String finalRepaymentDate) {
        loadingCheck();
        isVisible(FINANCIAL_CAR_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectCarPaymentFrequency(String paymentFrequency) {
        loadingCheck();
        isVisible(FINANCIAL_CAR_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_CAR_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeCarRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_CAR_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CAR_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentOutstandingBalanceAmount(String outstandingBalanceAmount) {
        loadingCheck();
        isVisible(FINANCIAL_STUDENT_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentFinancialInstitution(String financialInstitution) {
        loadingCheck();
        isVisible(FINANCIAL_STUDENT_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentFinalRepaymentDate(String finalRepaymentDate) {
        loadingCheck();
        isVisible(FINANCIAL_STUDENT_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectStudentPaymentFrequency(String paymentFrequency) {
        loadingCheck();
        isVisible(FINANCIAL_STUDENT_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_STUDENT_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeStudentRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_STUDENT_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_STUDENT_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectRentPaymentFrequency(String repaymentFrequency) {
        loadingCheck();
        isVisible(FINANCIAL_RENT_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_RENT_PAYMENT_FREQUENCY_INPUT_XPATH, repaymentFrequency);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeRentRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_RENT_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_RENT_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeRentNote(String note) {
        loadingCheck();
        isVisible(FINANCIAL_RENT_NOTE_XPATH, true);
        sendKeysElement(FINANCIAL_RENT_NOTE_XPATH, note, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectUtilitiesPaymentFrequency(String paymentFrequency) {
        loadingCheck();
        isVisible(FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_UTILITIES_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeUtilitiesRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_UTILITIES_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_UTILITIES_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeUtilitiesNote(String note) {
        loadingCheck();
        isVisible(FINANCIAL_UTILITIES_NOTE_XPATH, true);
        sendKeysElement(FINANCIAL_UTILITIES_NOTE_XPATH, note, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection selectChildCarePaymentFrequency(String paymentFrequency) {
        loadingCheck();
        isVisible(FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_INPUT_XPATH, true);
        selectFromDropDown(FINANCIAL_CHILDCARE_PAYMENT_FREQUENCY_INPUT_XPATH, paymentFrequency);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeChildCareRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_CHILDCARE_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_CHILDCARE_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeChildCareNote(String note) {
        loadingCheck();
        isVisible(FINANCIAL_CHILDCARE_NOTE_XPATH, true);
        sendKeysElement(FINANCIAL_CHILDCARE_NOTE_XPATH, note, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageOutstandingBalanceAmount(String outstandingBalanceAmount) {
        loadingCheck();
        isVisible(FINANCIAL_MORTGAGE_OUTSTANDING_BALANCE_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_OUTSTANDING_BALANCE_AMOUNT_XPATH, outstandingBalanceAmount, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageFinancialInstitution(String financialInstitution) {
        loadingCheck();
        isVisible(FINANCIAL_MORTGAGE_FINANCIAL_INSTITUTION_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_FINANCIAL_INSTITUTION_XPATH, financialInstitution, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageFinalRepaymentDate(String finalRepaymentDate) {
        loadingCheck();
        isVisible(FINANCIAL_MORTGAGE_FINAL_REPAYMENT_DATE_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_FINAL_REPAYMENT_DATE_XPATH, finalRepaymentDate, 30);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsSection typeMortgageRepaymentAmount(String repaymentAmount) {
        loadingCheck();
        isVisible(FINANCIAL_MORTGAGE_REPAYMENT_AMOUNT_XPATH, true);
        sendKeysElement(FINANCIAL_MORTGAGE_REPAYMENT_AMOUNT_XPATH, repaymentAmount, 30);
        loadingCheck();
        return this;
    }
}