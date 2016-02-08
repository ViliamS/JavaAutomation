package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Quotation.QUOTATION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum BW_subToWhomThisApplies implements IBWInterface {

    SELECT_BORROWER_TO_WHOM_THIS_APPLIES(selectBorrowerToWhomThisApplies, coapplicantString + ":" + borrowerString + ":" + borrower + ":" + coapplicant);

    private static final Log log = LogFactory.getLog(BW_subToWhomThisApplies.class.getName());

    private String getFieldName;
    private String getFieldNameValue;

    BW_subToWhomThisApplies(String getFieldName, String getFieldNameValue) {
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
        Enum[] enums = BW_subToWhomThisApplies.values();
        List<String> allConstants = new LinkedList<>();

        for (Enum anEnum : enums) {
            allConstants.add(anEnum.toString());
        }
        return allConstants;
    }

    public static String getEnumValue(int i) throws ClassNotFoundException {
        return  getEnumConstants().get(i);
    }

    private static List<String> getExpectedFieldNames(){
        log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(selectBorrowerToWhomThisApplies);
        return expectedFieldNames;
    }

    private static List<String> getFieldNames(String twoBorrowers){
        List<String> expectedFieldNames = new LinkedList<>();
            //This one is returning expected fields
            if(twoBorrowers.equalsIgnoreCase(QUOTATION.NUMBER_OF_BORROWERS.getFieldNameValue())) {
                expectedFieldNames.addAll(BW_subToWhomThisApplies.getExpectedFieldNames());
            }
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String twoBorrowers){
        return getFieldNames(twoBorrowers);
    }

    public static String getTriggerField(){
        return SELECT_BORROWER_TO_WHOM_THIS_APPLIES.getFieldName();
    }

    public static String[] getTriggerFieldValue(){
        String values = SELECT_BORROWER_TO_WHOM_THIS_APPLIES.getFieldNameValue();
        String[] field = values.split(":");
        log.info("values.split(':') resulted into result : '" + Arrays.toString(field) + "'");
        return field;
    }
}
