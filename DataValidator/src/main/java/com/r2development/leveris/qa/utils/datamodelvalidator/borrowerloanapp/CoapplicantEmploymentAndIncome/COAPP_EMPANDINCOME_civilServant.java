package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.CoapplicantEmploymentAndIncome;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.EmploymentAndIncome.EMPANDINCOME_subCurrently;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum COAPP_EMPANDINCOME_civilServant implements IBWInterface, IBWSheetInterface {

    CATEGORY(employmentAndIncomeCategory, employmentAndIncomeCategoryCivilServantValue),
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

    private static final Log log = LogFactory.getLog(COAPP_EMPANDINCOME_civilServant.class);

    private String getFieldName;
    private String getFieldNameValue;
    private String getEnumFieldNameValue;


    COAPP_EMPANDINCOME_civilServant(String getFieldName, String getFieldNameValue){
        this.getFieldName = getFieldName;
        this.getFieldNameValue = getFieldNameValue;
    }

    public String getFieldName(){
        return getFieldName;
    }

    public String getFieldNameValue(){
        return getFieldNameValue;
    }

    public String getEnumFieldNameValue(){
        return getEnumFieldNameValue;
    }

    /**
     * @return - Returns String 'Employment and Income - Civil Servant'
     */
    public static String getSheetName(){
        log.info(getEnumClass() + " method getSheetName returning string: '" + ExcelSheetVerificator.COAPP_EMPLOYMENT_AND_INCOME_CIVIL_SERVANT.getSheetName());
        return ExcelSheetVerificator.COAPP_EMPLOYMENT_AND_INCOME_CIVIL_SERVANT.getSheetName();
    }

    public static String getEnumClass() {
        return "DataModelValidator.borrowerLoanApp.CoapplicantEmploymentAndIncome.COAPP_EMPANDINCOME_civilServant";
    }

    public static Class<?> getEnumClassLoader() throws ClassNotFoundException {
        return log.getClass().getClassLoader().loadClass(getEnumClass());
    }

    public static List<String> getEnumConstants() throws ClassNotFoundException {

        Object[] enums = getEnumClassLoader().getEnumConstants();
        List<String> allConstants = new LinkedList<>();

        for (Object anEnum : enums) {
            allConstants.add(anEnum.toString());  // lucky it provides string value
        }
        return allConstants;
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     *
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames() {
        log.info(getEnumClass() + " executing method getExpectedFieldNames");
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

    public static List<String> getNotExpectedFields(List<String> allExpectedFields, String sheetName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info(getEnumClass() + " executing method getNotExpectedFields(LinkedList<String> getExpectedFieldNames = '" + allExpectedFields + "', , String sheetName = '" + sheetName + "')");
        List<String> notExpectedFieldNames = getEnumConstants();

        for (int i = 0; i < allExpectedFields.size(); i++) {

            String comparedValue = allExpectedFields.get(i);
            log.info("String comparedValue = allExpectedFieldNames.get(i) ==> '" + allExpectedFields.get(i) + "'");

            for (String valueToCompare : allExpectedFields) {

                log.info("valueToCompare.equalsIgnoreCase(comparedValue)" + " == " + valueToCompare + ".equalIgnoreCase(" + comparedValue + ") == " + valueToCompare.equalsIgnoreCase(comparedValue) + " ");
                if (valueToCompare.equalsIgnoreCase(comparedValue)) {
                    //If value is matched in allExpectedFields and those we obtained based on Excel, then we remove it from not expected list...
                    // as there should be values that differs so we will check they are not present in excel

                    log.info("Removing from the non Expected list : '" + allExpectedFields.get(i) + " because its same as : '" + valueToCompare);
                    notExpectedFieldNames.remove(i);
                }
            }
        }

        log.info("Values we don't want to be present in Excel sheet are : \n");
        for (String notExpectedFieldName : notExpectedFieldNames) {
            log.info("Not Expected Field Names                                     '" + notExpectedFieldName + "'\n");
        }

        log.info("Values we Expect to be present in the Excel sheet are : \n");
        for (String getExpectedFieldName : allExpectedFields) {
            log.info("Expected Field Names                                         '" + getExpectedFieldName + "'\n");
        }

        return notExpectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String employmentType){
        log.info(getEnumClass() + " executing method getExpectedFieldName(String employmentType = '" + employmentType + "')");
        List<String> expectedFieldNames = COAPP_EMPANDINCOME_civilServant.getExpectedFieldNames();
        if(employmentType.equalsIgnoreCase(employmentTypeContractValue)){
            expectedFieldNames.addAll(EMPANDINCOME_subCurrently.getExpectedFieldNamesWithoutCurrently());
        }
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String employmentType, String currently){
        log.info(getEnumClass() + " executing method getExpectedFieldName(String employmentType = '" + employmentType + "', String currently = '" + currently + "')");
        List<String> expectedFieldNames = new LinkedList<>();
        if(currently==null){
            expectedFieldNames = getExpectedFieldNames(employmentType);
        } else {
            expectedFieldNames.addAll(COAPP_EMPANDINCOME_civilServant.getExpectedFieldNames());
            expectedFieldNames.addAll(COAPP_EMPANDINCOME_subCurrently.getExpectedFieldNamesWithCurrently(currently));
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
        log.info(getEnumClass() + " executing method getTriggerFieldValue");
        String values = EMPLOYMENT_TYPE.getEnumFieldNameValue();
        String[] field = values.split(":");
        log.info("values.split(':') resulted into result : '" + Arrays.toString(field) + "'");
        return field;
    }

}
