package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourDependents;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.BW_subToWhomThisApplies;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum YDEPENDENTS implements IBWInterface, IBWSheetInterface {

    DO_EITHER_OF_YOU_HAVE_ANY_OTHER_DEPENDENTS(yourDependentsDoEitherOfYouHaveAnyOtherDependents, YourDependentsDoEitherOfYouHaveAnyOtherDependentsYesValue),
    DATE_OF_BIRTH(yourDependentsDateOfBirth, null);

    private static final Log log = LogFactory.getLog(YDEPENDENTS.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    YDEPENDENTS(String getFieldName, String getFieldNameValue) {
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
        return getEnumConstants().get(i);
    }

    /**
     *
     * @return - Returns String 'Employment and Income - Unemployed Homemaker'
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public String getSheetName() throws ClassNotFoundException, NoSuchMethodException{
        return ExcelSheetVerificator.YOUR_DEPENDENTS.getSheetName();
    }

    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(DO_EITHER_OF_YOU_HAVE_ANY_OTHER_DEPENDENTS.getFieldName());
        expectedFieldNames.add(DATE_OF_BIRTH.getFieldName());
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
        return DO_EITHER_OF_YOU_HAVE_ANY_OTHER_DEPENDENTS.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return DO_EITHER_OF_YOU_HAVE_ANY_OTHER_DEPENDENTS.getFieldNameValue();
    }
}
