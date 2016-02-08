package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class User implements IUser {

    private String firstName;
    private String email;
    private String pwd;
    private String phoneNumber;
    private String firstNameCoApplicant;
    private String emailCoApplicant;
//    private MORTGAGE_TYPE mortgageType;

    @Inject
    public User(String firstName, String email, String pwd, String phoneNumber, String firstNameCoApplicant, String emailCoApplicant/*, MORTGAGE_TYPE mortgageType*/) {
        this.firstName = firstName;
        this.email = email;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
        this.firstNameCoApplicant = firstNameCoApplicant;
        this.emailCoApplicant = emailCoApplicant;
//        this.mortgageType = mortgageType;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPwd() {
        return this.pwd;
    }

    @Override
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getFirstNameCoApplicant() {
        return firstNameCoApplicant;
    }

    @Override
    public void setFirstNameCoApplicant(String firstNameCoApplicant) {
        this.firstNameCoApplicant = firstNameCoApplicant;
    }

    @Override
    public String getEmailCoApplicant() {
        return emailCoApplicant;
    }

    @Override
    public void setEmailCoApplicant(String emailCoApplicant) {
        this.emailCoApplicant = emailCoApplicant;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //    @Override
//    public boolean isMortgageType(MORTGAGE_TYPE mortgageType) {
//        return (this.mortgageType == mortgageType);
//    }
//
//    @Override
//    public MORTGAGE_TYPE getMortgageType() {
//        return this.mortgageType;
//    }
//
//    @Override
//    public void setMortgageType(MORTGAGE_TYPE mortgageType) {
//        this.mortgageType = mortgageType;
//    }
}
