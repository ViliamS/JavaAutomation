package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFunding;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.BW_subToWhomThisApplies;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum YFUNDING_gift implements IBWInterface, IBWSheetInterface {

    WHAT_IS_SOURCE_OF_FUNDS(yourAccountsWhatIsTheSourceOfFunds, yourAccountsWhatIsTheSourceOfFundsGiftValue),
    DESCRIPTION(description, null),
    AMOUNT(amount, null);

    private static final Log log = LogFactory.getLog(YFUNDING_gift.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    YFUNDING_gift(String getFieldName, String getFieldNameValue) {
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
        return ExcelSheetVerificator.YOUR_FUNDING_GIFT.getSheetName();
    }

    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(WHAT_IS_SOURCE_OF_FUNDS.getFieldName());
        expectedFieldNames.add(DESCRIPTION.getFieldName());
        expectedFieldNames.add(AMOUNT.getFieldName());
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
        return WHAT_IS_SOURCE_OF_FUNDS.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return WHAT_IS_SOURCE_OF_FUNDS.getFieldNameValue();
    }

}
