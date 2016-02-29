package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class PersonalDetailsData extends DataModel {

    public PersonalDetailsData(Map<String, String> personalDetailsData) {
        super(personalDetailsData);
    }

    public PersonalDetailsData(List<String> personalDetailsData) {
        super(personalDetailsData);
    }

    public String getFirstName() {
        return data.get("firstName");
    }

    public void setFirstName(String firstName) {
        data.replace("firstName", firstName);
    }

    public String getLastName() {
        return data.get("lastName");
    }

    public void setLastName(String lastName) {
        data.replace("lastName", lastName);
    }

    public String getGender() {
        return data.get("gender");
    }

    public void setGender(String gender) {
        data.replace("gender", gender);
    }

    public String getDateOfBirth() {
        return  data.get("dateOfBirth");
    }

    public void setDateOfBirth(String dateOfBirth) {
        data.replace("dateOfBirth", dateOfBirth);
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

    public void setCountyState(String countyState) {
        data.replace("county/state", countyState);
    }

    public String getAccommodation() {
        return data.get("accommodation");
    }

    public void setAccommodation(String accommodation) {
        data.replace("accommodation", accommodation);
    }

    public boolean isLivingSince3years() {
        return data.get("isLivingSince3years").equals("yes");
    }

    public void setIsLivingSince3years(String isLivingSince3years) {
        data.replace("isLivingSince3years", isLivingSince3years);
    }
}