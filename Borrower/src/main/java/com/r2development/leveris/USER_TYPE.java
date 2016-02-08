package com.r2development.leveris;

public enum USER_TYPE {
    BORROWER("Borrower"),
    COAPPLICANT("Coapplicant");

    private String userType;

    USER_TYPE(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
