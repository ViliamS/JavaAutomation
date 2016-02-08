package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFinancialAssets;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum FASSETS_investmentProductFundsBonds implements IBWInterface, IBWSheetInterface{

    DO_YOU_HAVE_ANY_ASSETS(doYouHaveAnyAssets, doYouHaveAnyAssetsYesValue),
    WHAT_IS_TYPE_OF_ASSET(whatIsTypeOfAsset, whatIsTypeOfAssetInvestmentProductFundsBonds),
    CURRENT_VALUE_OF_INVESTMENTS_FUNDS("Current value of investments funds / bonds", null),
    FUNDS_BONDS_INSTITUTION("Funds / bonds institution", null),
    MATURITY_DATE(yourAssetsMaturityDate, null);

    private static final Log log = LogFactory.getLog(FASSETS_investmentProductFundsBonds.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    FASSETS_investmentProductFundsBonds(String getFieldName, String getFieldNameValue){
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
        return ExcelSheetVerificator.YOUR_FINANCIAL_ASSETS_INVESTMENT_AND_PRODUCT_FUNDS.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    private static List<String> getExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(DO_YOU_HAVE_ANY_ASSETS.getFieldName());
        expectedFieldNames.add(WHAT_IS_TYPE_OF_ASSET.getFieldName());
        expectedFieldNames.add(CURRENT_VALUE_OF_INVESTMENTS_FUNDS.getFieldName());
        expectedFieldNames.add(FUNDS_BONDS_INSTITUTION.getFieldName());
        expectedFieldNames.add(MATURITY_DATE.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String twoBorrowers) {
        List<String> expectedFieldNames = FASSETS_investmentProductFundsBonds.getExpectedFieldNames();
        log.info("twoBorrowers.equalsIgnoreCase(IBWInterface.numberOfBorrowersTwoBorrowersValue) = '" + twoBorrowers.equalsIgnoreCase(IBWInterface.numberOfBorrowersTwoBorrowersValue) + '"');

        if(twoBorrowers.equalsIgnoreCase(IBWInterface.numberOfBorrowersTwoBorrowersValue)){
            log.info("Have to be added!!!!!! value : '" + IBWInterface.selectBorrowerToWhomThisApplies + "'");
            expectedFieldNames.add(IBWInterface.selectBorrowerToWhomThisApplies);
        }
        return expectedFieldNames;
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return WHAT_IS_TYPE_OF_ASSET.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return WHAT_IS_TYPE_OF_ASSET.getFieldNameValue();
    }

}
