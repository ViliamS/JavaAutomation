package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum PERSONAL_DETAILS implements IBWInterface, IBWSheetInterface {

    FIRST_NAME (                                firstName,                                      null), //If second value is present then this value is responsible for triggering this Collection of expected data
    LAST_NAME (                                 lastName,                                       null),
    GENDER (                                    gender,                                         genderFemaleValue),
    DATE_OF_BIRTH (                             dateOfBirth,                                    null),
    MARITAL_STATUS (                            maritalStatus,                                  single),
    MAIDEN_NAME (                               maidenName,                                     null),
    NATIONALITY (                               personalDetailsNationality,                     personalDetailsSubNationalityIrishValue), //If second value is NOT present then the triggering is going to happen
    HOW_MANY_YEARS (                            personalDetailsHowManyYears,                    null),
    ADDRESS_LINE_1 (                            addressLine1,                                   null),
    ADDRESS_LINE_2 (                            addressLine2,                                   null),
    TOWN_CITY (                                 townCity,                                       null),
    POST_CODE_ZIP (                             postCodeZip,                                    null),
    COUNTRY (                                   personalDetailsCountry,                         countryIreland), //If second value Ireland is present then this value is responsible for triggering this Collection of expected data
    COUNTY_STATE (                              countyState,                                    null),
    THIS_ACCOMMODATION_IS (                     thisAccommodationIs,                            PERSONAL_DETAILS_subAccommodation.THIS_ACCOMMODATION_IS.getFieldNameValue()),  //If one of the values divided by '|' is present then this set it triggered
    RENT (                                      rent,                                           null),
    HAVE_YOU_LIVED_ON_THIS_ADDRESS_FOR_3Y (     haveYouLivedHereFor3Years,                      haveYouLivedHereFor3YearsNoValue), //If 'No' is present then this set it triggered
    PREVIOUS_ADDRESS_LINE_1 (                   previousAddressLine1,                           null),
    PREVIOUS_ADDRESS_LINE_2 (                   previousAddressLine2,                           null),
    PREVIOUS_TOWN_CITY (                        previousTownCity,                               null),
    PREVIOUS_POSTCODE_ZIP (                     previousPostCodeZip,                            null),
    PREVIOUS_COUNTRY (                          previousCountry,                                null);

    private static final Log log = LogFactory.getLog(PERSONAL_DETAILS.class.getName());

    private String getFieldName;
    private String getFieldNameValue;



    PERSONAL_DETAILS(String getFieldName, String getFieldNameValue) {
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
        return ExcelSheetVerificator.BW_PERSONAL_DETAILS_sheetName.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(FIRST_NAME.getFieldName());
        expectedFieldNames.add(LAST_NAME.getFieldName());
        //expectedFieldNames.add(GENDER.getFieldName());
        expectedFieldNames.add(DATE_OF_BIRTH.getFieldName());
        expectedFieldNames.add(MARITAL_STATUS.getFieldName());
        //expectedFieldNames.add(NATIONALITY.getFieldName());
        expectedFieldNames.add(ADDRESS_LINE_1.getFieldName());
        expectedFieldNames.add(ADDRESS_LINE_2.getFieldName());
        expectedFieldNames.add(TOWN_CITY.getFieldName());
        expectedFieldNames.add(POST_CODE_ZIP.getFieldName());

       // expectedFieldNames.add(10, COUNTRY.getFieldName());

       // expectedFieldNames.add(11, THIS_ACCOMMODATION_IS.getFieldName());

       // expectedFieldNames.add(12, HAVE_YOU_LIVED_ON_THIS_ADDRESS_FOR_3Y.getFieldName());

        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String gender, String maritalStatus, String nationality, String country, String thisAccommodationIs, String haveYouLivedOnThisAddressFor3Y){
        log.info("PERSONAL_DETAILS executing method getExpectedFieldNames(String gender = '" + gender + "', String maritalStatus = '" + maritalStatus + "', String nationality = '" + nationality + "', String country = '" + country + "', String thisAccommodationIs = '" + thisAccommodationIs + "', String haveYouLivedOnThisAddressFor3Y = '" + haveYouLivedOnThisAddressFor3Y + "')");
        List<String> expectedFieldNames = PERSONAL_DETAILS.getExpectedFieldNames();
        //Adds Gender based expected fields
        expectedFieldNames.addAll(PERSONAL_DETAILS_subGender.getExpectedFieldNames(gender, maritalStatus));
        //Adds Nationality expected fields
        expectedFieldNames.addAll(PERSONAL_DETAILS_subNationality.getExpectedFieldNames(nationality));
        //Adds Country expected fields
        expectedFieldNames.addAll(PERSONAL_DETAILS_subCountry.getExpectedFieldNames(country));
        //Adds Accommodation expected fields
        expectedFieldNames.addAll(PERSONAL_DETAILS_subAccommodation.getExpectedFieldNames(thisAccommodationIs));
        //Adds Have you lived here for past three years? related expected fields
        expectedFieldNames.addAll(PERSONAL_DETAILS_subHaveYouLivedHere3Y.getExpectedFieldNames(haveYouLivedOnThisAddressFor3Y));
        return expectedFieldNames;
    }
}
