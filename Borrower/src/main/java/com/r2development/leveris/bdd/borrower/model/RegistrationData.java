package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class RegistrationData extends DataModel {

    public RegistrationData(Map<String, String> registrationDataMap) {
        super(registrationDataMap);
    }

    public RegistrationData(List<String> registrationDataList) {
        super((registrationDataList));
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

    public String getEmail() {
        return data.get("email");
    }

    public void setEmail(String email) {
        data.replace("email", email);
    }

    public String getPhoneNumber() {
        return data.get("phoneNumber");
    }

    public void setPhoneNumber(String phoneNumber) {
        data.replace("phoneNumber", phoneNumber);
    }

    public String getPassword() {
        return data.get("password");
    }

    public void setPassword(String password) {
        data.replace("password", password);
    }

    public boolean isTermsBusiness() {
        return data.get("termsBusiness").equals("accepts");
    }

    public void setTermsBusiness(String termsBusiness) {
        data.replace("termsBusiness", termsBusiness);
    }

    public boolean isProtectionBusiness() {
        return data.get("protectionPolicy").equals("accepts");
    }

    public String getDateOfBirth(){ return data.get("dateOfBirth"); }

    public void setProtectionBusiness(String protectionBusiness) {
        data.replace("protectionPolicy", protectionBusiness);
    }
}