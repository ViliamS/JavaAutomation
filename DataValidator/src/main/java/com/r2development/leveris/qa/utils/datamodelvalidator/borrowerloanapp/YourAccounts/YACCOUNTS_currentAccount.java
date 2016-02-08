package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourAccounts;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum YACCOUNTS_currentAccount implements IBWInterface, IBWSheetInterface {

    WHAT_IS_THE_SOURCE_OF_FUNDS(yourAccountsWhatIsTheSourceOfFunds, YourAccountsWhatIsTheSourceOfFundsCurrentAccountValue),
    SELECT_BORROWER_TO_WHOM_THIS_APPLIES(selectBorrowerToWhomThisApplies, null),
    STATEMENT_DATE_OPTIONAL(yourAccountsStatementDateOptional, null),
    ACCOUNT_PROVIDER(yourAccountsAccountProvider, null),
    LAST_FOUR_DIGITS_OF_ACCOUNT_NUMBER_IBAN(yourAccountsLastFourDigitsOfAccountNumberIBAN, null),
    ACCOUNT_BALANCE(yourAccountsAccountBalance, null),
    OVERDRAFT_LIMIT(yourAccountsOverdraftLimit, null);

    private static final Log log = LogFactory.getLog(YACCOUNTS_currentAccount.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    YACCOUNTS_currentAccount(String getFieldName, String getFieldNameValue){
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
        return ExcelSheetVerificator.YOUR_ACCOUNTS_CURRENT_ACCOUNT.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(WHAT_IS_THE_SOURCE_OF_FUNDS.getFieldName());
        expectedFieldNames.add(STATEMENT_DATE_OPTIONAL.getFieldName());
        expectedFieldNames.add(ACCOUNT_PROVIDER.getFieldName());
        expectedFieldNames.add(LAST_FOUR_DIGITS_OF_ACCOUNT_NUMBER_IBAN.getFieldName());
        expectedFieldNames.add(ACCOUNT_BALANCE.getFieldName());
        expectedFieldNames.add(OVERDRAFT_LIMIT.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String twoBorrowers) {
        List<String>  expectedFieldNames =        YACCOUNTS_subAddAccount.getExpectedFieldNames();
                            expectedFieldNames.addAll(  YACCOUNTS_currentAccount.getExpectedFieldNames());

        if(twoBorrowers.equalsIgnoreCase(IBWInterface.numberOfBorrowersTwoBorrowersValue)){
            expectedFieldNames.add(IBWInterface.selectBorrowerToWhomThisApplies);
        }
        return expectedFieldNames;
    }

    /**
     * Is returning name of field responsible for enabling this data Collection
     * @return - String with value 'Number of Borrowers'
     */
    public static String getTriggerField(){
        return WHAT_IS_THE_SOURCE_OF_FUNDS.getFieldNameValue();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return WHAT_IS_THE_SOURCE_OF_FUNDS.getFieldNameValue();
    }


}
