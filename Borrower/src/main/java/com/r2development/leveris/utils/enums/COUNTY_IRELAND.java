package com.r2development.leveris.utils.enums;

public enum COUNTY_IRELAND {

    CARLOW ("CW"),
    CAVAN ("CN"),
    CLARE ("CE"),
    ORK ("C" ),
    DONEGAL ("DL"),
    UBLIN ("D" ),
    ALWAY ("G" ),
    KERRY ("KY"),
    KILDARE ("KE"),
    KILKENNY ("KK"),
    LAOIS ("LS"),
    LEITRIM ("LM"),
    IMERICK ("L" ),
    LONGFORD ("LD"),
    LOUTH ("LH"),
    MAYO ("MO"),
    MEATH ("MH"),
    MONAGHAN ("MN"),
    OFFALY ("OY"),
    ROSCOMMON ("RN"),
    SLIGO ("SO"),
    TIPPERARY ("TA"),
    WESTMEATH ("WH"),
    WEXFORD ("WX"),
    WICKLOW ("WW"),
    WATERFORD ("WD");
                                                       
    private String shortValue;

    private COUNTY_IRELAND(String shortValue) {
        this.shortValue = shortValue;
    }

    public String getShortValue() {
        return  shortValue;
    }

    public static String getShortValueByLongValue(String longValue) {
        for (COUNTY_IRELAND value : COUNTY_IRELAND.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }

}
