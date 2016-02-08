package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourProperties;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.BW_subToWhomThisApplies;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum YPROPERTIES_holidayHome implements IBWInterface, IBWSheetInterface{

    DO_YOU_HAVE_STAKE_IN_PROPERTY(doEitherOfYouHaveAStakeInAnyProperty, doEitherOfYouHaveAStakeInAnyPropertyYesValue),
    PROPERTY_CATEGORY(yourPropertiesPropertyCategory, yourPropertiesPropertyCategoryHolidayHomeValue),
    ADDRESS_LINE1(addressLine1, null),
    ADDRESS_LINE2(addressLine2, null),
    TOWN_CITY(townCity, null),
    POST_CODE(postCode, null),
    COUNTRY(countryProperties, countryPropertiesIrelandValue),
    COUNTY(countyProperties, null),
    PROPERTY_TYPE(yourPropertiesPropertyType, null),
    NUMBER_OF_BEDROOMS(yourPropertiesNumberOfBedrooms, null),
    YEAR_PROPERTY_WAS_ACQUIRED(yourPropertiesYearPropertyWasAcquired, null),
    ORIGINAL_PURCHASE_PRICE(yourPropertiesOriginalPurchasePrice, null),
    IS_THIS_PROPERTY_MORTGAGED(isThisPropertyMortgaged, isThisPropertyMortgagedYesValue),
    MORTGAGE_PROVIDER(mortgageProvider, null),
    MORTGAGE_ACCOUNT_NUMBER(mortgageAccountNumber, null),
    CURRENT_BALANCE(currentBalance, null),
    MONTHLY_PAYMENT(monthlyPayment, null),
    INTEREST_ONLY(interestOnly, null),
    CURRENT_INTEREST_RATE(currentInterestRate, null),
    RATE_TYPE(rateType, null),
    IS_THE_MORTGAGE_NOW_OR_IT_HAS_BEEN_IN(isTheMortgageNowOrItHasBeenIn, null),
    ADD_ANOTHER_MORTGAGE_ACCOUNT(addAnotherMortgageAccount, addAnotherMortgageAccountYesValue),
    ANOTHER_MORTGAGE_ACCOUNT_NUMBER(mortgageAccountNumber, null),
    ANOTHER_CURRENT_BALANCE(currentBalance, null),
    ANOTHER_MONTHLY_PAYMENT(monthlyPayment, null),
    ANOTHER_INTEREST_ONLY(interestOnly, null),
    ANOTHER_CURRENT_INTEREST_RATE(currentInterestRate, null),
    ANOTHER_RATE_TYPE(rateType, null),
    ANOTHER_IS_THE_MORTGAGE_NOW_OR_IT_HAS_BEEN_IN(isTheMortgageNowOrItHasBeenIn, null),
    DO_YOU_PLAN_TO_SELL_IT(yourPropertiesDoYouPlanToSellIt, null),
    ESTIMATED_VALUE_SALE_AGREED_PRICE(yourPropertiesEstimatedValueSaleAgreedPrice, null);

    private static final Log log = LogFactory.getLog(YPROPERTIES_holidayHome.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    YPROPERTIES_holidayHome(String getFieldName, String getFieldNameValue){
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
        return ExcelSheetVerificator.YOUR_PROPERTIES_HOLIDAY_HOME.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    public static List<String> getDefaultExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(DO_YOU_HAVE_STAKE_IN_PROPERTY.getFieldName());
        expectedFieldNames.add(PROPERTY_CATEGORY.getFieldName());
        expectedFieldNames.add(ADDRESS_LINE1.getFieldName());
        expectedFieldNames.add(ADDRESS_LINE2.getFieldName());
        expectedFieldNames.add(TOWN_CITY.getFieldName());
        expectedFieldNames.add(POST_CODE.getFieldName());
        expectedFieldNames.add(PROPERTY_TYPE.getFieldName());
        expectedFieldNames.add(NUMBER_OF_BEDROOMS.getFieldName());
        expectedFieldNames.add(YEAR_PROPERTY_WAS_ACQUIRED.getFieldName());
        expectedFieldNames.add(ORIGINAL_PURCHASE_PRICE.getFieldName());
        expectedFieldNames.add(DO_YOU_PLAN_TO_SELL_IT.getFieldName());
        expectedFieldNames.add(ESTIMATED_VALUE_SALE_AGREED_PRICE.getFieldName());
        return expectedFieldNames;
    }

    /**
     *
     * @return List<String> of expectedField according to the trigger field.
     */
    public static List<String> getExpectedFieldNames(){ log.info("");
        List<String> defaultExpectedFields = new LinkedList<>();
        defaultExpectedFields.addAll(YPROPERTIES_holidayHome.getDefaultExpectedFieldNames());
        return defaultExpectedFields;
    }

    /**
     *
     * @param twoBorrowers -
     * @param dataToSearchIn -
     * @return List<String> of expectedField according to the trigger field.
     */
    public static List<String> getExpectedFieldNames(String twoBorrowers, Map<String, String> dataToSearchIn){

        List<String> expectedFields = getExpectedFieldNames();
        String  isThisPropertyMortgagedValue =  dataToSearchIn.get(IS_THIS_PROPERTY_MORTGAGED   .getFieldName()),
                countryIrelandValue =           dataToSearchIn.get(COUNTRY                      .getFieldName());
        expectedFields.addAll(BW_subToWhomThisApplies.getExpectedFieldNames(twoBorrowers));
        List<Boolean> addAnotherMortgage = YPROPERTIES_holidayHome.detectAddAnotherMortgage(dataToSearchIn);

        switch (isThisPropertyMortgagedValue) {
            case isThisPropertyMortgagedYesValue :
                expectedFields.addAll(YPROPERTIES_subIsThisPropertyMortgagedYes.getExpectedFieldNames(addAnotherMortgage));
                break;
            case itThisPropertyMortgagedNoMortgageRepaid :
                expectedFields.addAll(YPROPERTIES_subIsThisPropertyMortgagedNoMortgageRepaid.getExpectedFieldNames());
                break;
            case isThisPropertyMortgagedNoNeverHadAMortgage :
                break;
        }
        expectedFields.addAll(YPROPERTIES_subCountry.getExpectedFieldNames(countryIrelandValue));
        return expectedFields;
    }

    public static List<Boolean> detectAddAnotherMortgage(Map<String, String> dataToSearch) {
        List<Boolean> addAnotherMortgageArray = new LinkedList<>();

        //This case is creating first entry True for "Add another mortgage account" without index
        if(dataToSearch.get(addAnotherMortgageAccount).equalsIgnoreCase(addAnotherMortgageAccountYesValue)) {
            addAnotherMortgageArray.add(true);
        } else {
            //This is end for case there is No detected for the very first Add another mortgage account
            addAnotherMortgageArray.add(false);
            return addAnotherMortgageArray;
        }
        String test = dataToSearch.get(addAnotherMortgageAccount + ".2");
        //Is there entry with index ".2"
            //Is there entry with index ".2" containing value "Yes"
            if (test != null && test.equalsIgnoreCase(addAnotherMortgageAccountYesValue)) {
                //adding true value for entry with index ".2"
                addAnotherMortgageArray.add(true);
                //starting detection of entries with index ".3" and above
                for (int i = 3; i <= dataToSearch.size(); i++) {
                    log.info(
                            "Loop = '" + i + "'" +
                                    "dataToSearch.get(YPROPERTIES_subIsThisPropertyMortgagedYes.ADD_ANOTHER_MORTGAGE_ACCOUNT.getFieldNameWithIndex(i)) = " +
                                    "'" + dataToSearch.get(YPROPERTIES_subIsThisPropertyMortgagedYes.ADD_ANOTHER_MORTGAGE_ACCOUNT.getFieldNameWithIndex(i)) + "'"
                    );

                    if(dataToSearch.get(YPROPERTIES_subIsThisPropertyMortgagedYes.ADD_ANOTHER_MORTGAGE_ACCOUNT.getFieldNameWithIndex(i))!=null || dataToSearch.get(YPROPERTIES_subIsThisPropertyMortgagedYes.ADD_ANOTHER_MORTGAGE_ACCOUNT.getFieldNameWithIndex(i)).equalsIgnoreCase("No")){

                        if (dataToSearch.get(dataToSearch.get(YPROPERTIES_subIsThisPropertyMortgagedYes.ADD_ANOTHER_MORTGAGE_ACCOUNT.getFieldNameWithIndex(i))).equalsIgnoreCase(addAnotherMortgageAccountYesValue)) {
                            addAnotherMortgageArray.add(true);
                        }} else {
                        //When false is detected then is no-longer needed to continue
                        addAnotherMortgageArray.add(false);

                        return addAnotherMortgageArray;
                    }
                }
            } else {
                //There is entry with index ".2" but containing "No"
                addAnotherMortgageArray.add(false);

                return addAnotherMortgageArray;
            }
        return addAnotherMortgageArray;
    }
}
