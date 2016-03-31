package com.r2development.leveris.utils.enums;

public enum PAYMENT_FREQUENCY {

    WEEKLY ( "W" ),
    FORTNIGHTLY ( "F" ),
    MONTHLY ( "M" ),
    YEARLY ( "Y" );

    private String shortValue;

    private PAYMENT_FREQUENCY(String shortValue) {
        this.shortValue = shortValue;
    }

    public String getShortValue() {
        return  shortValue;
    }

    public static String getShortValueByLongValue(String longValue) {
        for (PAYMENT_FREQUENCY value : PAYMENT_FREQUENCY.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}
