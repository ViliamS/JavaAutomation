package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourProperties;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum YPROPERTIES_subIsThisPropertyMortgagedNoMortgageRepaid implements IBWInterface {

    IS_THIS_PROPERTY_MORTGAGED (isThisPropertyMortgaged, itThisPropertyMortgagedNoMortgageRepaid),
    MORTGAGE_PROVIDER (mortgageProvider, null),
    YEAR_REPAID (yourPropertiesYearRepaid, null);

    private static final Log log = LogFactory.getLog(YPROPERTIES_subIsThisPropertyMortgagedNoMortgageRepaid.class.getName());

    private final String getFieldName;
    private final String getFieldNameValue;

    YPROPERTIES_subIsThisPropertyMortgagedNoMortgageRepaid(String getFieldName, String getFieldNameValue) {
        this.getFieldName = getFieldName;
        this.getFieldNameValue = getFieldNameValue;
    }

    public String getFieldName() {
        return this.getFieldName;
    }

    public String getFieldNameValue() {
        return this.getFieldNameValue;
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

    public static List<String> getExpectedFieldNames(){
        log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(IS_THIS_PROPERTY_MORTGAGED.getFieldName());
        expectedFieldNames.add(MORTGAGE_PROVIDER.getFieldName());
        expectedFieldNames.add(YEAR_REPAID.getFieldName());
        return expectedFieldNames;
//        return YPROPERTIES_Utils.getExpectedFieldNames();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerField(){
        return IS_THIS_PROPERTY_MORTGAGED.getFieldName();
    }

    /**
     * @return - String with value
     */
    public static String getTriggerFieldValue(){
        return IS_THIS_PROPERTY_MORTGAGED.getFieldNameValue();
    }

}
