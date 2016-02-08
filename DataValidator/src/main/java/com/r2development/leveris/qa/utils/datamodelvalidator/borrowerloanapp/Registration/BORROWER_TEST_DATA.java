package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Registration;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelSheetVerificator;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWSheetInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails.PERSONAL_DETAILS_subNationality;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public enum BORROWER_TEST_DATA implements IBWInterface, IBWSheetInterface {

    FIRST_NAME(firstName),
    EMAIL_ADDRESS(emailAddress),
    PHONE_NUMBER(phoneNumber),
    CREATE_PASSWORD(createPassword);

    private static final Log log = LogFactory.getLog(PERSONAL_DETAILS_subNationality.class.getName());

    private String getFieldName;

    BORROWER_TEST_DATA(String getFieldName){
        this.getFieldName = getFieldName;
    }

    public String getFieldName(){ log.info("return " + getFieldName);
        return getFieldName;
    }

    public static ClassLoader getClassLoader(){
        return log.getClass().getClassLoader();
    }

    public static String getEnumClass() {
        return log.getClass().toString();
    }

    private List<String> getEnumConstants() throws ClassNotFoundException {
        Object[] enums = log.getClass().getClassLoader().loadClass(log.getClass().toString()).getEnumConstants();
        List<String> allConstants = new LinkedList<>();

        for (Object anEnum : enums) {
            allConstants.add(anEnum.toString());
        }
        return allConstants;
    }

    public String getEnumValue(int i) throws ClassNotFoundException {
        return  getEnumConstants().get(i);
    }

    public String getSheetName(){
        return ExcelSheetVerificator.REGISTRATION.getSheetName();
    }

    /**
     * Is returning all expected Field Names for successful competition of Single Borrower Quotation.
     *
     * @return ArrayList with ordered FieldNames that will be Expected/Mandatory to fill
     */
    public static List<String> getExpectedFieldNames() {
        List<String> expectedFieldNames = new LinkedList<>();
        expectedFieldNames.add(FIRST_NAME.getFieldName());
        expectedFieldNames.add(EMAIL_ADDRESS.getFieldName());
        expectedFieldNames.add(PHONE_NUMBER.getFieldName());
        expectedFieldNames.add(CREATE_PASSWORD.getFieldName());
        return expectedFieldNames;
    }


}
