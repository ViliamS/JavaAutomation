package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourProperties;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum YPROPERTIES_subIsThisPropertyMortgagedYes implements IBWInterface {

    IS_THIS_PROPERTY_MORTGAGED (            isThisPropertyMortgaged,        isThisPropertyMortgagedYesValue),
    MORTGAGE_PROVIDER (                     mortgageProvider,               null),
    MORTGAGE_ACCOUNT_NUMBER (               mortgageAccountNumber,          null),
    CURRENT_BALANCE(                        currentBalance,                 null),
    MONTHLY_PAYMENT(                        monthlyPayment,                 null),
    INTEREST_ONLY(                          interestOnly,                   null),
    CURRENT_INTEREST_RATE(                  currentInterestRate,            null),
    RATE_TYPE(                              rateType,                       null),
    IS_THE_MORTGAGE_NOW_OR_IT_HAS_BEEN_IN(  isTheMortgageNowOrItHasBeenIn,  null),
    ADD_ANOTHER_MORTGAGE_ACCOUNT(           addAnotherMortgageAccount,      addAnotherMortgageAccountYesValue);

    private static final Log log = LogFactory.getLog(YPROPERTIES_subIsThisPropertyMortgagedYes.class.getName());

    private final String getFieldName;
    private final String getFieldNameValue;

    YPROPERTIES_subIsThisPropertyMortgagedYes(String getFieldName, String getFieldNameValue) {
        this.getFieldName = getFieldName;
        this.getFieldNameValue = getFieldNameValue;
    }

    public String getFieldName() {
        return this.getFieldName;
    }

    public String getFieldNameValue() {
        return this.getFieldNameValue;
    }

    public String getFieldNameWithIndex(int i) {
        String index = "." + (i + 1);
        return this.getFieldName + index;
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

    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(IS_THIS_PROPERTY_MORTGAGED.getFieldName());
        expectedFieldNames.add(MORTGAGE_PROVIDER.getFieldName());
        expectedFieldNames.add(MORTGAGE_ACCOUNT_NUMBER.getFieldName());
        expectedFieldNames.add(CURRENT_BALANCE.getFieldName());
        expectedFieldNames.add(MONTHLY_PAYMENT.getFieldName());
        expectedFieldNames.add(INTEREST_ONLY.getFieldName());
        expectedFieldNames.add(CURRENT_INTEREST_RATE.getFieldName());
        expectedFieldNames.add(RATE_TYPE.getFieldName());
        expectedFieldNames.add(IS_THE_MORTGAGE_NOW_OR_IT_HAS_BEEN_IN.getFieldName());
        expectedFieldNames.add(ADD_ANOTHER_MORTGAGE_ACCOUNT.getFieldName());
        return expectedFieldNames;
    }

    private static List<String> getExpectedFieldNames(int i){
        List<String> expectedFieldsWithIndex = new LinkedList<>();
        expectedFieldsWithIndex.add(MORTGAGE_ACCOUNT_NUMBER.getFieldNameWithIndex(i));
        expectedFieldsWithIndex.add(CURRENT_BALANCE.getFieldNameWithIndex(i));
        expectedFieldsWithIndex.add(MONTHLY_PAYMENT.getFieldNameWithIndex(i));
        expectedFieldsWithIndex.add(INTEREST_ONLY.getFieldNameWithIndex(i));
        expectedFieldsWithIndex.add(CURRENT_INTEREST_RATE.getFieldNameWithIndex(i));
        expectedFieldsWithIndex.add(RATE_TYPE.getFieldNameWithIndex(i));
        expectedFieldsWithIndex.add(IS_THE_MORTGAGE_NOW_OR_IT_HAS_BEEN_IN.getFieldNameWithIndex(i));
        expectedFieldsWithIndex.add(ADD_ANOTHER_MORTGAGE_ACCOUNT.getFieldNameWithIndex(i));
        log.info(expectedFieldsWithIndex);
        return expectedFieldsWithIndex;
    }


    /**
     * There is possibility to add another mortgage over and over again so we must cover unlimited depth of adding and this method does that
     * @param addAnotherMortgage - ArrayList<Boolean> addAnotherMortgage
     * @return - expectedFieldNames = expectedFieldNames + (addAnotherMortgage.size() * YPROPERTIES_subAddAnotherMortgageAccount.expectedFieldNames)
     */
    public static List<String> getExpectedFieldNames(List<Boolean> addAnotherMortgage){
        // adding fields for is this property mortgaged
        List<String> expectedFieldNames = getExpectedFieldNames();
        //this decides if to add entries for add another mortgage
        for (int i = 1; i <= addAnotherMortgage.size(); i++){
            boolean addMortgage = addAnotherMortgage.get(i-1);

            if(addMortgage){
                    expectedFieldNames.addAll(getExpectedFieldNames(i));
            }
        }
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return IS_THIS_PROPERTY_MORTGAGED.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return IS_THIS_PROPERTY_MORTGAGED.getFieldNameValue();
    }

}
