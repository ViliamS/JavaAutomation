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
        return data.get("addressLine1");
    }

    public void setAddressLine1(String addressLine1) {
        data.replace("addressLine1", addressLine1);
    }

    public String getAddressLine2() {
        return data.get("addressLine2");
    }

    public void setAddressLine2(String addressLine2) {
        data.replace("addressLine2", addressLine2);
    }

    public String getTownCity() {
        return data.get("townCity");
    }

    public void setTownCity(String townCity) {
        data.replace("townCity", townCity);
    }

    public String getCountyState() {
        return data.get("countyState");
    }

    public void setCountyState(String countyState) {
        data.replace("countyState", countyState);
    }

    public String getCountry() { return data.get("country"); }

    public void setPostcodeZip(String postcodeZip) {
        data.replace("postcode/zip", postcodeZip);
    }

    public String getPostcodeZip() { return data.get("postcode/zip"); }

    public void setCountry(String country) {
        data.replace("country", country);
    }

    public String getStartDate() {
        return data.get("startDate");
    }

    public void setStartDate(String postcodeZip) {
        data.replace("startDate", postcodeZip);
    }

    public String getEndDate() {
        return data.get("endDate");
    }

    public void setEndDate(String postcodeZip) {
        data.replace("endDate", postcodeZip);
    }

    public String getResidentialStatus() {
        return data.get("residentialStatus");
    }

    public void setResidentialStatus(String residentialStatus) {
        data.replace("residentialStatus", residentialStatus);
    }
}