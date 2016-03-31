package com.r2development.leveris.utils.enums;

/**
 * Created by anthonymottot on 31/03/2016.
 */
public enum LOAN {

    PAYDAY ( "PAYDAY" ),
    CREDIT_CARD ( "CRD" ),
    MAINTENANCE_PAYMENT ( "MP" ),
    OTHER ( "OTH" ),
    CAR_LOAN ( "CL" ),
    STUDENT_LOAN ( "SL" ),
    RENT ( "RENT" ),
    UTILITIES ( "UTILITIES" ),
    CHILDCARE ( "CHILDCARE" ),
    MORTGAGE ( "MORTGAGE" );

    private String shortValue;

    private LOAN(String shortValue) {
        this.shortValue = shortValue;
    }

    public String getShortValue() {
        return  shortValue;
    }

    public static String getShortValueByLongValue(String longValue) {
        for (LOAN value : LOAN.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}
