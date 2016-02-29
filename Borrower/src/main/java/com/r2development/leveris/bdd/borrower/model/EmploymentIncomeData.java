package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class EmploymentIncomeData extends DataModel {

//    Map<String, String> data = new LinkedHashMap<>();

    public EmploymentIncomeData(Map<String, String> employmentIncomeData) {
        super(employmentIncomeData);
    }

    public EmploymentIncomeData(List<String> employmentIncomeData) {
        super(employmentIncomeData);
    }

//    public String get(String key) {
//        return ( data.containsKey(key) ? data.get(key) : null);
//    }

    public boolean isCurrentEmployment() {
        return data.get("isCurrentEmployment") != null && data.get("isCurrentEmployment").equals("yes");
    }

}
