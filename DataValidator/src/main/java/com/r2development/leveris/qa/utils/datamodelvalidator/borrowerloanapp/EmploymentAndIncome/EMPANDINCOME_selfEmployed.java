package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.EmploymentAndIncome;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails.PERSONAL_DETAILS_subCountry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum EMPANDINCOME_selfEmployed implements IBWInterface, IBWSheetInterface {

    CATEGORY(employmentAndIncomeCategory, employmentAndIncomeCategorySelfEmployedValue),
    OCCUPATION(occupation, null),
    BUSINESS_NAME(businessName, null),
    ADDRESS_LINE1(addressLine1, null),
    ADDRESS_LINE2(addressLine2, null),
    TOWN_CITY(townCity, null),
    COUNTRY(personalDetailsCountry, countryIreland),
    COUNTY(countyState, null),
    NATURE_OF_BUSINESS(natureOfBusiness, null),
    START_DATE(startDate, null),
    END_DATE(endDate, null),
    CURRENTLY(currently, currentlyYesValue),
    NET_PROFIT_LAST_YEAR(netProfitLastYear, null),
    NET_PROFIT_PREVIOUS_YEAR(netProfitPreviousYear, null),
    ACCOUNTANT_NAME_PRACTICE(accountantNamePractice, null);

    private static final Log log = LogFactory.getLog(EMPANDINCOME_selfEmployed.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    EMPANDINCOME_selfEmployed(String getFieldName, String getFieldNameValue){
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

    public static Object[] getEnumValues() throws ClassNotFoundException {
        return getEnumClassLoader().getEnumConstants();
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
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     *
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(CATEGORY.getFieldName());
        expectedFieldNames.add(OCCUPATION.getFieldName());
        expectedFieldNames.add(BUSINESS_NAME.getFieldName());
        expectedFieldNames.add(ADDRESS_LINE1.getFieldName());
        expectedFieldNames.add(ADDRESS_LINE2.getFieldName());
        expectedFieldNames.add(TOWN_CITY.getFieldName());
        expectedFieldNames.add(NATURE_OF_BUSINESS.getFieldName());
        expectedFieldNames.add(NET_PROFIT_LAST_YEAR.getFieldName());
        expectedFieldNames.add(NET_PROFIT_PREVIOUS_YEAR.getFieldName());
        expectedFieldNames.add(ACCOUNTANT_NAME_PRACTICE.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String country, String currently){
        List<String> expectedFieldNames = EMPANDINCOME_selfEmployed.getExpectedFieldNames();
        expectedFieldNames.addAll(PERSONAL_DETAILS_subCountry.getExpectedFieldNames(country));
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
