package com.r2development.leveris.utils.enums;

/*
<select class="content control combobox valid" name="root:c:w:pnlMortgageApplicationResidency:c:w:cmbResidentialStatus:combobox" id="comboboxaa9" wicketpath="main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMortgageApplicationResidency_c_w_cmbResidentialStatus_combobox" aria-readonly="false" aria-labelledby="labelaa8" data-default="TEN" data-readonly="false" data-enabled="true" aria-required="true" data-height="40" tabindex="3506" data-whisper="true" data-forcevalue="true" style="display:none;" data-button="true">
<option value="OWN">Owner</option>
<option value="LWP">Living with parents</option>
<option selected="selected" value="TEN">Tenant</option>
<option value="CTE">Council tenant</option>
<option value="JOW">Joint owner</option>
<option value="OTH">Other</option>
</select>
*/

public enum RESIDENTIAL_STATUS {

    OWNER ( "OWN" ),
    LIVING_WITH_PARENTS ( "LWP" ),
    TENANT ( "TEN" ),
    COUNCIL_TENANT ( "CTE" ),
    JOINT_OWNER ( "JOW" ),
    OTHER ( "OTH" );

    private String shortValue;
//    private String longValue;

    private RESIDENTIAL_STATUS(String shortValue) {
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
        for (RESIDENTIAL_STATUS value : RESIDENTIAL_STATUS.values()) {
            if ( value.name().equalsIgnoreCase(longValue)) {
                return  value.getShortValue();
            }
        }
        return null;
    }
}