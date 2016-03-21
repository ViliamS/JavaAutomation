package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class ResidencyData extends DataModel {

    public ResidencyData(Map<String, String> personalDetailsData) {
        super(personalDetailsData);
    }

    public ResidencyData(List<String> personalDetailsData) {
        super(personalDetailsData);
    }

    public String getFormType() {
        return data.get("formType");
    }

    public String getAddressLine1() {
        return data.get("address line 1");
    }

    public void setAddressLine1(String addressLine1) {
        data.replace("address line 1", addressLine1);
    }

    public String getTownCity() {
        return data.get("town/city");
    }

    public void setTownCity(String townCity) {
        data.replace("town/city", townCity);
    }

    public String getCountyState() {
        return data.get("county/state");
    }

    public String getCountry() { return data.get("country"); }

    public void setCountyState(String countyState) {
        data.replace("county/state", countyState);
    }

}
