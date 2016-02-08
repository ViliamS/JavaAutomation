package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Quotation;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum QUOTATION_inviteCoapplicant implements IBWInterface {

    FIRST_NAME (firstName),
    EMAIL_ADDRESS (emailAddress);

    private static final Log log = LogFactory.getLog(QUOTATION_inviteCoapplicant.class.getName());
    private String getFieldName;

    QUOTATION_inviteCoapplicant(String getFieldName) {
        this.getFieldName = getFieldName;
    }

    public String getFieldName(){ log.info("return " + getFieldName);
        return getFieldName;
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

    public static List<String> getExpectedFieldNames(){ log.info("");
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(FIRST_NAME.getFieldName());
        expectedFieldNames.add(EMAIL_ADDRESS.getFieldName());
        return expectedFieldNames;
    }
}
