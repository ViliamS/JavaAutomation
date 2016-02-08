package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourProperties;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum YPROPERTIES_subCountry implements IBWInterface {

    COUNTRY (personalDetailsCountry, countryIreland), //If second value Ireland is present then this value is responsible for triggering this Collection of expected data
    COUNTY (county, null);

    private static final Log log = LogFactory.getLog(YPROPERTIES_subCountry.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    YPROPERTIES_subCountry(String getFieldName, String getFieldNameValue) {
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
        expectedFieldNames.add(COUNTRY.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String country){
        List<String> expectedFieldNames = getExpectedFieldNames();
        if(country.equalsIgnoreCase(getTriggerFieldValue())) {
            expectedFieldNames.add(COUNTY.getFieldName());
        }
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return COUNTRY.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return COUNTRY.getFieldNameValue();
    }

}
