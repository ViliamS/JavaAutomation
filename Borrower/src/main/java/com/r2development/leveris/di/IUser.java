package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;

@ImplementedBy(User.class)
public interface IUser {
    String getFirstName();
    void setFirstName(String firstName);
    String getEmail();
    void setEmail(String email);
    String getPwd();
    void setPwd(String pwd);
    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);
//    boolean isMortgageType(MORTGAGE_TYPE mortgageType);
//    MORTGAGE_TYPE getMortgageType();
//    void setMortgageType(MORTGAGE_TYPE mortgageType);
}
