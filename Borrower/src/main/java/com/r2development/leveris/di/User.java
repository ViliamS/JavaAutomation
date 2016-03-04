package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;

@Singleton
public class User implements IUser {

    private String firstName;
    private String email;
    private String pwd;
    private String phoneNumber;
//    private MORTGAGE_TYPE mortgageType;

    public User() {
        this.firstName = StringUtils.EMPTY;
        this.email = StringUtils.EMPTY;
        this.pwd = StringUtils.EMPTY;
        this.phoneNumber = StringUtils.EMPTY;
    }

    public User(IUser user) {
        this.firstName = user.getFirstName();
        this.email = user.getEmail();
        this.pwd = user.getPwd();
        this.phoneNumber = user.getPhoneNumber();
    }

//    @Inject
    public User(String firstName, String email, String pwd, String phoneNumber, String extraJenkins, String extraJenkins2) {
        this.firstName = firstName;
        this.email = email;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
    }

    @Inject
    public User(String firstName, String email, String pwd, String phoneNumber /*, MORTGAGE_TYPE mortgageType*/) {
        this.firstName = firstName;
        this.email = email;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
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
