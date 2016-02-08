package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Quotation;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum QUOTATION implements IBWInterface {

    NUMBER_OF_BORROWERS (numberOfBorrowers, "I want a quote for", numberOfBorrowersTwoBorrowersValue), //If second value is present then this value is responsible for triggering this Collection of expected data
    MORTGAGE_TYPE (mortgageType, "We're", null),
    FIRST_BORROWER_AGE (firstBorrowerAge, "I’m", null),
    SECOND_BORROWER_AGE (secondBorrowerAge, "my partner is", null),
    BORROWERS_MARITAL_STATUS (borrowersMaritalStatus, "We're", null),
    NUMBER_OF_DEPENDENTS(numberOfDependents, "and have", null),
    INCOME_TYPE_FIRST_BORROWER (incomeTypeFirstBorrower, "I'm",  null),
    INCOME_AMOUNT_FIRST_BORROWER (incomeAmountFirstBorrower, "and I earned", null),
    INCOME_TYPE_SECOND_BORROWER (incomeTypeSecondBorrower, "My partner is", null),
    INCOME_AMOUNT_SECOND_BORROWER (incomeAmountSecondBorrower, "and they earn", null),
    OTHER_FINANCIAL_COMMITMENTS (otherFinancialCommitments, "Our personal loan repayments are", null);

    private static final Log log = LogFactory.getLog(QUOTATION.class.getName());

    private String getFieldName;
    private String getTextNextToField;
    private String getFieldNameValue;

    QUOTATION(String getFieldName, String getTextNextToField, String getFieldNameValue) {
        this.getFieldName = getFieldName;
        this.getTextNextToField = getTextNextToField;
        this.getFieldNameValue = getFieldNameValue;
    }

    public String getFieldLabel(){
        return getTextNextToField;
    }

    public String getFieldName(){ log.info("return " + getFieldName);
        return getFieldName;
    }

    public String getFieldNameValue(){ log.info("return " + getFieldNameValue);
        return getFieldNameValue;
    }

    public static ClassLoader getClassLoader(){
        return log.getClass().getClassLoader();
    }

    public static String getEnumClass() {
        return log.getClass().toString();
    }

    public static List<String> getEnumConstants() throws ClassNotFoundException {
        Object[] enums = log.getClass().getClassLoader().loadClass(log.getClass().toString()).getEnumConstants();
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
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(NUMBER_OF_BORROWERS.getFieldName());
        expectedFieldNames.add(MORTGAGE_TYPE.getFieldName());
        expectedFieldNames.add(FIRST_BORROWER_AGE.getFieldName());
        expectedFieldNames.add(BORROWERS_MARITAL_STATUS.getFieldName());
        expectedFieldNames.add(NUMBER_OF_DEPENDENTS.getFieldName());
        expectedFieldNames.add(INCOME_TYPE_FIRST_BORROWER.getFieldName());
        expectedFieldNames.add(INCOME_AMOUNT_FIRST_BORROWER.getFieldName());
        expectedFieldNames.add(OTHER_FINANCIAL_COMMITMENTS.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String twoBorrowers){
        List<String> expectedFieldNames = getExpectedFieldNames();
        expectedFieldNames.addAll(QUOTATION_subTwoBorrowers.getExpectedFieldNames(twoBorrowers));
        return expectedFieldNames;
    }

    /**
     * Is returning name of field responsible for enabling this data Collection
     * @return - String with value 'Number of Borrowers'
     */
    public static String getTriggerField(){
        return NUMBER_OF_BORROWERS.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return NUMBER_OF_BORROWERS.getFieldNameValue();
    }
}
