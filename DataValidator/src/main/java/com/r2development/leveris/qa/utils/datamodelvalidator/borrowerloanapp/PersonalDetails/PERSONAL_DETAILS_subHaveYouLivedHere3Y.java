package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum PERSONAL_DETAILS_subHaveYouLivedHere3Y implements IBWInterface {

    HAVE_YOU_LIVED_HERE_3_Y (haveYouLivedHereFor3Years, haveYouLivedHereFor3YearsNoValue), //If 'No' is present then this set it triggered
    PREVIOUS_ADDRESS_LINE_1 (addressLine1, null),
    PREVIOUS_ADDRESS_LINE_2 (addressLine2, null),
    PREVIOUS_TOWN_CITY (townCity, null),
    PREVIOUS_POSTCODE_ZIP (postCodeZip, null),
    PREVIOUS_COUNTRY (previousCountry, null);

    private static final Log log = LogFactory.getLog(PERSONAL_DETAILS_subHaveYouLivedHere3Y.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    PERSONAL_DETAILS_subHaveYouLivedHere3Y(String getFieldName, String getFieldNameValue) {
        this.getFieldName = getFieldName;
        this.getFieldNameValue = getFieldNameValue;
    }

    public String getFieldName(){ log.info("return " + getFieldName);
        return getFieldName;
    }

    public String getFieldNameValue(){ log.info("return " + getFieldNameValue);
        return getFieldNameValue;
    }

    /**
     * @return - String with value
     */
    private String getFieldNameWithIndex(String index){
        return getFieldName + index;
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

        expectedFieldNames.add(HAVE_YOU_LIVED_HERE_3_Y.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String haveYouLiveHere){
        List<String> expectedFieldNames = PERSONAL_DETAILS_subHaveYouLivedHere3Y.getExpectedFieldNames();
        int i = 1;
        if(haveYouLiveHere.equalsIgnoreCase(PERSONAL_DETAILS_subHaveYouLivedHere3Y.getTriggerFieldValue())){
            i = i + 1;
            //Because DataModel is using ArrayList but Excel is loaded into Map where is not possible to have a duplicate entries with the same key
            //So the duplicate entries are by DataModelValidator loaded with an attached index ".2" if there is already the same entry and +1 for more and more duplicate entries.
            //Because of that we have to simulate the same behavior as well in the expected fields
            String duplicity = "." + i;
            expectedFieldNames.add(PREVIOUS_ADDRESS_LINE_1.getFieldNameWithIndex(duplicity));
            expectedFieldNames.add(PREVIOUS_ADDRESS_LINE_2.getFieldNameWithIndex(duplicity));
            expectedFieldNames.add(PREVIOUS_TOWN_CITY.getFieldNameWithIndex(duplicity));
            expectedFieldNames.add(PREVIOUS_POSTCODE_ZIP.getFieldNameWithIndex(duplicity));
            expectedFieldNames.add(PREVIOUS_COUNTRY.getFieldNameWithIndex(duplicity));
        }
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return HAVE_YOU_LIVED_HERE_3_Y.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return HAVE_YOU_LIVED_HERE_3_Y.getFieldNameValue();
    }

}
