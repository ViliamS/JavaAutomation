package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFinancialCommitments;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.BW_subToWhomThisApplies;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum FCOMMITMENTS_creditCard implements IBWInterface, IBWSheetInterface {

    PLEASE_OUTLINE_ANY_SHORT_TERM_DEBT(pleaseOutlineAnyShortTermDebt, pleaseOutlineAnyShortTermDebtYesValue),
    WHAT_IS_TYPE_OF_FINANCIAL_COMMITMENT(financialCommitmentsWhatIsTypeOfFinancialCommitment, financialCommitmentsWhatIsTypeOfFinancialCommitmentCreditCardValue),
    REPAYMENT_AMOUNT(financialCommitmentsRepaymentAmount, null),
    CREDIT_CARD_PROVIDER(financialCommitmentsCreditCardProvider, null),
    CREDIT_CARD_TYPE(financialCommitmentsCreditCardType, null),
    CREDIT_CARD_LIMIT(financialCommitmentsCreditCardLimit, null),
    CREDIT_CARD_BALANCE(financialCommitmentsCreditCardBalance, null);

    private static final Log log = LogFactory.getLog(FCOMMITMENTS_creditCard.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    FCOMMITMENTS_creditCard(String getFieldName, String getFieldNameValue) {
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
        return ExcelSheetVerificator.YOUR_FINANCIAL_COMMITMENTS_CREDIT_CARD.getSheetName();
    }

    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(PLEASE_OUTLINE_ANY_SHORT_TERM_DEBT.getFieldName());
        expectedFieldNames.add(WHAT_IS_TYPE_OF_FINANCIAL_COMMITMENT.getFieldName());
        expectedFieldNames.add(REPAYMENT_AMOUNT.getFieldName());
        expectedFieldNames.add(CREDIT_CARD_PROVIDER.getFieldName());
        expectedFieldNames.add(CREDIT_CARD_TYPE.getFieldName());
        expectedFieldNames.add(CREDIT_CARD_LIMIT.getFieldName());
        expectedFieldNames.add(CREDIT_CARD_BALANCE.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String twoBorrowers){
        List<String> expectedFieldNames = getExpectedFieldNames();
        expectedFieldNames.addAll(BW_subToWhomThisApplies.getExpectedFieldNames(twoBorrowers));
        return expectedFieldNames;
    }

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
