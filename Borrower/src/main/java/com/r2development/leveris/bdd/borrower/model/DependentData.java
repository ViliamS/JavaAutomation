package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class DependentData extends DataModel {

    public DependentData(Map<String, String> dependentData) {
        super(dependentData);
    }

    public DependentData(List<String> dependentData) {
        super(dependentData);
    }

//    public DependentData(Map<String, DependentData> dependentData) { super(dependentData); }

}
