package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.EmploymentAndIncome;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum EMPANDINCOME_subCurrently implements IBWInterface {

    CURRENTLY(currently, currentlyYesValue),
    START_DATE (startDate, null),
    END_DATE (endDate, null);


    private static final Log log = LogFactory.getLog(EMPANDINCOME_subCurrently.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    EMPANDINCOME_subCurrently(String getFieldName, String getFieldNameValue) {
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

    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(EMPANDINCOME_subCurrently.START_DATE.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String currently){
        List<String> expectedFieldNames = EMPANDINCOME_subCurrently.getExpectedFieldNames();
        if(!currently.equalsIgnoreCase(EMPANDINCOME_subCurrently.CURRENTLY.getFieldNameValue())){
            expectedFieldNames.add(EMPANDINCOME_subCurrently.END_DATE.getFieldName());
        }
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNamesWithCurrently(String currently){
        List<String> expectedFieldNames = EMPANDINCOME_subCurrently.getExpectedFieldNames(currently);
        expectedFieldNames.add(CURRENTLY.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNamesWithoutCurrently(){
        List<String> expectedFieldNames = EMPANDINCOME_subCurrently.getExpectedFieldNames();
        expectedFieldNames.add(EMPANDINCOME_subCurrently.END_DATE.getFieldName());
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return CURRENTLY.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return CURRENTLY.getFieldNameValue();
    }

}
