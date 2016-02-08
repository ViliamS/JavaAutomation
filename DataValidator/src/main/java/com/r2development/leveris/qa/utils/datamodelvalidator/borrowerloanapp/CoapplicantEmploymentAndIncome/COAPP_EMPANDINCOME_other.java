package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.CoapplicantEmploymentAndIncome;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum COAPP_EMPANDINCOME_other implements IBWInterface, IBWSheetInterface {

    CATEGORY(employmentAndIncomeCategory, employmentAndIncomeCategoryOtherValue),
    SOURCE_OF_ADDITIONAL_INCOME(sourceOfAdditionalIncome, null),
    GROSS_INCOME(grossIncome, null),
    TIME_EARNING_THIS_INCOME(timeEarningThisIncome, null);

    private static final Log log = LogFactory.getLog(COAPP_EMPANDINCOME_other.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    COAPP_EMPANDINCOME_other(String getFieldName, String getFieldNameValue){
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
        return coappEmploymentAndIncomePath + "COAPP_EMPANDINCOME_other";
    }

    public static Class<?> getEnumClassLoader() throws ClassNotFoundException {
        return log.getClass().getClassLoader().loadClass(getEnumClass());
    }

    public static List<String> getEnumConstants() throws ClassNotFoundException {
        Object[] enums = getEnumClassLoader().getEnumConstants();
        List<String> allConstants = new LinkedList<>();

//        for(int i = 0; i < enums.length; i++){
//            allConstants.add(enums[i].toString());
//        }

        for ( Object currentEnum : enums ) {
            allConstants.add(currentEnum.toString());
        }

        return allConstants;
    }

    public static String getEnumValue(int i) throws ClassNotFoundException {
        return  getEnumConstants().get(i);
    }

    /**
     *
     * @return - Returns String 'Employment and Income - Other'
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public String getSheetName() throws ClassNotFoundException, NoSuchMethodException{
        return ExcelSheetVerificator.COAPP_EMPLOYMENT_AND_INCOME_OTHER.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     *
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    public static List<String> getExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(CATEGORY.getFieldName());
        expectedFieldNames.add(SOURCE_OF_ADDITIONAL_INCOME.getFieldName());
        expectedFieldNames.add(GROSS_INCOME.getFieldName());
        expectedFieldNames.add(TIME_EARNING_THIS_INCOME.getFieldName());
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return CATEGORY.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return CATEGORY.getFieldNameValue();
    }

}
