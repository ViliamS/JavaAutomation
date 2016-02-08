package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum PERSONAL_DETAILS_subAccommodation implements IBWInterface {

    THIS_ACCOMMODATION_IS (thisAccommodationIs, thisAccommodationIsRentedOnContractValue + ":" + thisAccommodationIsRentedFromFamilyFriendsValue + ":" + thisAccommodationIsOtherValue), //If one of the values divided by '|' is present then this set it triggered
    RENT (                      rent,                null);

    private static final Log log = LogFactory.getLog(PERSONAL_DETAILS_subAccommodation.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    PERSONAL_DETAILS_subAccommodation(String getFieldName, String getFieldNameValue) {
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
        expectedFieldNames.add(THIS_ACCOMMODATION_IS.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String thisAccommodationIs){
        List<String> expectedFieldNames = PERSONAL_DETAILS_subAccommodation.getExpectedFieldNames();
        String[] values = PERSONAL_DETAILS_subAccommodation.getTriggerFieldValue();
        for(int i = 0; i < values.length; i++) {
            log.info("Decides if Rent is added as expected field... \n" +
                    "loop : '" + i + "'\n" +
                    "expected is : '" + values[i] + "' \n" +
                    "but excel provided a : '" + thisAccommodationIs + "'");
            if (thisAccommodationIs.equalsIgnoreCase(values[i])) {
                log.info("Got it rent should be added");
                expectedFieldNames.add(RENT.getFieldName());
            }
        }
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return THIS_ACCOMMODATION_IS.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String[] getTriggerFieldValue(){
        String values = THIS_ACCOMMODATION_IS.getFieldNameValue();
        java.lang.String[] field = values.split(":");
        log.info("values.split(':') resulted into result : '" + Arrays.toString(field) + "'");
        return field;
    }

}
