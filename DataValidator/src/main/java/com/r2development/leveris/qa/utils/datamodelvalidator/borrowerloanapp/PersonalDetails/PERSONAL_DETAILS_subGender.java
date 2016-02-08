package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum PERSONAL_DETAILS_subGender implements IBWInterface {

    GENDER (gender, genderFemaleValue),
    MAIDEN_NAME (maidenName, null);

    private static final Log log = LogFactory.getLog(PERSONAL_DETAILS_subGender.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    PERSONAL_DETAILS_subGender(String getFieldName, String getFieldNameValue) {
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
        expectedFieldNames.add(GENDER.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String gender, String maritalStatus){
        List<String> expectedFieldNames = PERSONAL_DETAILS_subGender.getExpectedFieldNames();

        if(gender.equalsIgnoreCase(PERSONAL_DETAILS_subGender.getTriggerFieldValue())){
            if(!maritalStatus.equalsIgnoreCase(PERSONAL_DETAILS.MARITAL_STATUS.getFieldNameValue())) {
                expectedFieldNames.add(MAIDEN_NAME.getFieldName());
            }
        }
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return GENDER.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return GENDER.getFieldNameValue();
    }


}
