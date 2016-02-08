package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFinancialCommitments;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.BW_subToWhomThisApplies;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum FCOMMITMENTS_personalLoan implements IBWInterface, IBWSheetInterface {

    PLEASE_OUTLINE_ANY_SHORT_TERM_DEBT(pleaseOutlineAnyShortTermDebt, pleaseOutlineAnyShortTermDebtYesValue),
    WHAT_IS_TYPE_OF_FINANCIAL_COMMITMENT(financialCommitmentsWhatIsTypeOfFinancialCommitment, financialCommitmentsWhatIsTypeOfFinancialCommitmentPersonalLoanValue),
    OUTSTANDING_AMOUNT_BALANCE(financialCommitmentsOutstandingAmountBalance, null),
    FINANCIAL_INSTITUTION(financialCommitmentsFinancialInstitution, null),
    REPAYMENT_FREQUENCY(financialCommitmentsRepaymentFrequency, null),
    PURPOSE_OF_THE_LOAN(financialCommitmentsPurposeOfTheLoan, null),
    FINAL_REPAYMENT_DATE(financialCommitmentsFinalRepaymentDate, null),
    REPAYMENT_AMOUNT(financialCommitmentsRepaymentAmount, null);

    private static final Log log = LogFactory.getLog(FCOMMITMENTS_personalLoan.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    FCOMMITMENTS_personalLoan(String getFieldName, String getFieldNameValue) {
        this.getFieldName = getFieldName;
        this.getFieldNameValue = getFieldNameValue;
    }

    public String getFieldName(){ log.info("return " + getFieldName);
        return getFieldName;
    }

    public String getFieldNameValue(){ log.info("return " + getFieldNameValue);
        return getFieldNameValue;
    }

    public static String getEnumClass() {
        return log.getClass().toString();
    }

    public static Class<?> getEnumClassLoader() throws ClassNotFoundException {
        return log.getClass().getClassLoader().loadClass(getEnumClass());
    }

    public static List<String> getEnumConstants() throws ClassNotFoundException {
        Object[] enums = getEnumClassLoader().getEnumConstants();
        List<String> allConstants = new LinkedList<>();

        for (Object anEnum : enums) {
            allConstants.add(anEnum.toString());
        }
        return allConstants;
    }

    public static String getEnumValue(int i) throws ClassNotFoundException {
        return  getEnumConstants().get(i);
    }
    /**
     *
     * @return - Returns String 'Employment and Income - Unemployed Homemaker'
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public String getSheetName() throws ClassNotFoundException, NoSuchMethodException{
        return ExcelSheetVerificator.YOUR_FINANCIAL_COMMITMENTS_PERSONAL_LOAN.getSheetName();
    }

    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(PLEASE_OUTLINE_ANY_SHORT_TERM_DEBT.getFieldName());
        expectedFieldNames.add(WHAT_IS_TYPE_OF_FINANCIAL_COMMITMENT.getFieldName());
        expectedFieldNames.add(OUTSTANDING_AMOUNT_BALANCE.getFieldName());
        expectedFieldNames.add(FINANCIAL_INSTITUTION.getFieldName());
        expectedFieldNames.add(REPAYMENT_FREQUENCY.getFieldName());
        expectedFieldNames.add(PURPOSE_OF_THE_LOAN.getFieldName());
        expectedFieldNames.add(FINAL_REPAYMENT_DATE.getFieldName());
        expectedFieldNames.add(REPAYMENT_AMOUNT.getFieldName());
        return expectedFieldNames;
    }

    private static List<String> getExpectedFieldNamesValues(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(PLEASE_OUTLINE_ANY_SHORT_TERM_DEBT.getFieldNameValue());
        expectedFieldNames.add(WHAT_IS_TYPE_OF_FINANCIAL_COMMITMENT.getFieldNameValue());
        expectedFieldNames.add(OUTSTANDING_AMOUNT_BALANCE.getFieldNameValue());
        expectedFieldNames.add(FINANCIAL_INSTITUTION.getFieldNameValue());
        expectedFieldNames.add(REPAYMENT_FREQUENCY.getFieldNameValue());
        expectedFieldNames.add(PURPOSE_OF_THE_LOAN.getFieldNameValue());
        expectedFieldNames.add(FINAL_REPAYMENT_DATE.getFieldNameValue());
        expectedFieldNames.add(REPAYMENT_AMOUNT.getFieldNameValue());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String twoBorrowers){
        List<String> expectedFieldNames = getExpectedFieldNames();
        expectedFieldNames.addAll(BW_subToWhomThisApplies.getExpectedFieldNames(twoBorrowers));
        return expectedFieldNames;
    }

/*
    example code to generate data ( Vili's idea )

    public static List<String> getExpectedFieldNamesValues(String twoBorrowers){
        return getExpectedFieldNamesValues();
    }

    public static Map<List<String>, List<String>> generateFormData(){
        String random = "something";
        Map<List<String>, List<String>> generatedFormData = new LinkedHashMap<>();
        generatedFormData.put(getExpectedFieldNames(random), getExpectedFieldNamesValues(random));
        return generatedFormData;
    }
*/

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return WHAT_IS_TYPE_OF_FINANCIAL_COMMITMENT.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return WHAT_IS_TYPE_OF_FINANCIAL_COMMITMENT.getFieldNameValue();
    }
}
