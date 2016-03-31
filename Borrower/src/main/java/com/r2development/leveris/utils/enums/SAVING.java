package com.r2development.leveris.utils.enums;

public enum SAVING {

    GIFT ( "G" ),
    INHERITANCE ( "INH" ),
    ACCIDENT_CLAIM ( "ACC" ),
    REDUNDANCY ( "RDN" ),
    INCOME_FROM_REGULAR_SAVINGS ( "IRS" ),
    OTHER ( "OTH" );

    private String shortValue;

    private SAVING(String shortValue) {
        this.shortValue = shortValue;
    }

    public String getShortValue() {
        return  shortValue;
    }

    public static String getShortValueByLongValue(String longValue) {
        for (SAVING value : SAVING.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}
