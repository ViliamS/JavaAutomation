package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.EmploymentAndIncome;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum EMPANDINCOME_unemployedHomemaker implements IBWInterface, IBWSheetInterface {

    CATEGORY(employmentAndIncomeCategory, employmentAndIncomeCategoryUnemployedHomemakerValue),

    START_DATE(startDate, null),
    END_DATE(endDate, null),
    CURRENTLY(currently, currentlyYesValue);

    private static final Log log = LogFactory.getLog(EMPANDINCOME_unemployedHomemaker.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    EMPANDINCOME_unemployedHomemaker(String getFieldName, String getFieldNameValue){
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
        return ExcelSheetVerificator.BW_EMPLOYMENT_AND_INCOME_UNEMPLOYED_HOMEMAKER.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     *
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(CATEGORY.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String currently){
        List<String> expectedFieldNames = EMPANDINCOME_unemployedHomemaker.getExpectedFieldNames();
        expectedFieldNames.addAll(EMPANDINCOME_subCurrently.getExpectedFieldNamesWithCurrently(currently));
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
