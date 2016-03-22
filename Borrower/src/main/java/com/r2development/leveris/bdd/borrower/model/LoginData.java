package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class LoginData extends DataModel {
    public LoginData(Map<String, String> loginData) {
        super(loginData);
    }

    public LoginData(List<String> loginData) {
        super(loginData);
    }
}