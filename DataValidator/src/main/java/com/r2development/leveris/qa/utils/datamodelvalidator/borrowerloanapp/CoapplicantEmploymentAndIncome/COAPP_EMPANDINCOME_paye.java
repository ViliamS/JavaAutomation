package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.CoapplicantEmploymentAndIncome;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum COAPP_EMPANDINCOME_paye implements IBWInterface, IBWSheetInterface {

    CATEGORY(employmentAndIncomeCategory, employmentAndIncomeCategoryPAYEValue),
    OCCUPATION(occupation, null),
    EMPLOYERS_NAME(employersName, null),
    EMPLOYMENT_TYPE(employmentType, employmentTypePermanentValue + ":" + employmentTypeContractValue + ":" + employmentTypeTemporaryValue),
    START_DATE(startDate, null),
    END_DATE(endDate, null),
    CURRENTLY(currently, currentlyYesValue),
    GROSS_SALARY(grossSalary, null),
    REGULAR_OVERTIME(regularOvertime, null),
    REGULAR_GUARANTEED_BONUS(regularGuaranteedBonus, null),
    GUARANTEED_COMMISSION(guaranteedCommission, null);

    private static final Log log = LogFactory.getLog(COAPP_EMPANDINCOME_paye.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    COAPP_EMPANDINCOME_paye(String getFieldName, String getFieldNameValue){
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
     * @return - Returns String 'Employment and Income - PAYE'
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public String getSheetName() throws ClassNotFoundException, NoSuchMethodException{
        return ExcelSheetVerificator.COAPP_EMPLOYMENT_AND_INCOME_PAYE.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     *
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(CATEGORY.getFieldName());
        expectedFieldNames.add(OCCUPATION.getFieldName());
        expectedFieldNames.add(EMPLOYERS_NAME.getFieldName());
        expectedFieldNames.add(EMPLOYMENT_TYPE.getFieldName());
        expectedFieldNames.add(GROSS_SALARY.getFieldName());
        expectedFieldNames.add(REGULAR_OVERTIME.getFieldName());
        expectedFieldNames.add(REGULAR_GUARANTEED_BONUS.getFieldName());
        expectedFieldNames.add(GUARANTEED_COMMISSION.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String employmentType, String currently){
        List<String> expectedFieldNames = COAPP_EMPANDINCOME_paye.getExpectedFieldNames();

        if(employmentType.equalsIgnoreCase(employmentTypeContractValue)){
            expectedFieldNames.add(START_DATE.getFieldName());
            expectedFieldNames.add(END_DATE.getFieldName());
        } else {
            if (employmentType.equalsIgnoreCase(employmentTypePermanentValue) || employmentType.equalsIgnoreCase(employmentTypeTemporaryValue)) {
                expectedFieldNames.add(IBWInterface.currently);
                expectedFieldNames.addAll(COAPP_EMPANDINCOME_subCurrently.getExpectedFieldNames(currently));
            }
        }
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
    public static String[] getTriggerFieldValue(){
        String values = EMPLOYMENT_TYPE.getFieldNameValue();
        java.lang.String[] field = values.split(":");
        log.info("values.split(':') resulted into result : '" + Arrays.toString(field) + "'");
        return field;
    }


}
