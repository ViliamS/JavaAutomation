package com.r2development.leveris.utils.enums;

/**
 * Created by anthonymottot on 31/03/2016.
 */
public enum CARD {

    VISA ( "VIS" ),
    MASTERCARD ( "MC" ),
    AMERICANEXPRESS ( "AME" ),
    STORECARD ( "SC" ),
    OTHER ( "OTH" );

    private String shortValue;

    private CARD(String shortValue) {
        this.shortValue = shortValue;
    }

    public String getShortValue() {
        return  shortValue;
    }

    public static String getShortValueByLongValue(String longValue) {
        for (CARD value : CARD.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}
