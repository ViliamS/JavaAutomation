package com.r2development.leveris.enums;

public enum E_MARITAL_STATUS {

    SINGLE ( "SIN" ),
    SEPARATED ( "SEP" ),
    MARRIED_CIVIL_PARTNER ( "MAR" ),
    DIVORCED_DISSOLVED_CIVIL_PARTNERSHIP ( "DIV" ),
    WIDOWED ( "WID" );

    private String shortValue;
//    private String longValue;

    private E_MARITAL_STATUS(String shortValue) {
        this.shortValue = shortValue;
    }

//    private EMaritalStatus(String shortValue, String longValue ) {
//        this.shortValue = shortValue;
//        this.longValue = longValue;
//    }

    public String getShortValue() {
        return  shortValue;
    }

//    public String getLongValue() {
//        return longValue;
//    }

    public static String getShortValueByLongValue(String longValue) {
        for (E_MARITAL_STATUS value : E_MARITAL_STATUS.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}

/*
MaritalStatus
root:c:w:cmbMaritalStatus:v
<option value="SIN">single</option>
<option value="SEP">separated</option>
<option value="MAR">married/civil partner(s)</option>
<option value="DIV">divorced/dissolved civil partnership</option>
<option value="WID">widowed</option>
*/