package com.r2development.leveris.utils.enums;

public enum EMPLOYMENT {

    CONTRACT ( "CON" ),
    PERMANENT ( "PER" ),
    TEMPORARY ( "TMP" );

    private String shortValue;

    private EMPLOYMENT(String shortValue) {
        this.shortValue = shortValue;
    }

    public String getShortValue() {
        return  shortValue;
    }

    public static String getShortValueByLongValue(String longValue) {
        for (EMPLOYMENT value : EMPLOYMENT.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}
