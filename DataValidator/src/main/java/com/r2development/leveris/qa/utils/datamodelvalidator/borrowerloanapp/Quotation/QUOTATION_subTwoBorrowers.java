package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Quotation;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum QUOTATION_subTwoBorrowers implements IBWInterface {

    SECOND_BORROWER_AGE (secondBorrowerAge),
    INCOME_TYPE_SECOND_BORROWER (incomeTypeSecondBorrower),
    INCOME_AMOUNT_SECOND_BORROWER (incomeAmountSecondBorrower);

    private static final Log log = LogFactory.getLog(QUOTATION_subTwoBorrowers.class.getName());

    private final String getFieldName;

    QUOTATION_subTwoBorrowers(String getFieldName) {
        this.getFieldName = getFieldName;
    }

    public String getFieldName() {
        return this.getFieldName;
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
        expectedFieldNames.add(SECOND_BORROWER_AGE.getFieldName());
        expectedFieldNames.add(INCOME_TYPE_SECOND_BORROWER.getFieldName());
        expectedFieldNames.add(INCOME_AMOUNT_SECOND_BORROWER.getFieldName());
        return expectedFieldNames;
    }

    public static List<String> getExpectedFieldNames(String twoBorrowers){
        List<String> expectedFieldNames = new LinkedList<>();

        if (twoBorrowers.equalsIgnoreCase(QUOTATION.NUMBER_OF_BORROWERS.getFieldNameValue())) {
            expectedFieldNames.addAll(getExpectedFieldNames());
        }
        return expectedFieldNames;
    }


}
