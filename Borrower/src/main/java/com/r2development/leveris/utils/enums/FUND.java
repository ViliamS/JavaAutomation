package com.r2development.leveris.utils.enums;

public enum FUND {

    CURRENT_ACCOUNT ( "DIV" ),
    SAVINGS_ACCOUNT ( "WID" ),
    SCRAPPING_ACCOUNT ( "SCR" );

    private String shortValue;

    private FUND(String shortValue) {
        this.shortValue = shortValue;
    }

    public String getShortValue() {
        return  shortValue;
    }

    public static String getShortValueByLongValue(String longValue) {
        for (FUND value : FUND.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}
