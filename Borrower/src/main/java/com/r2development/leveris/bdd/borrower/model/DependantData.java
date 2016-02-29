package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class DependantData extends DataModel {

    public DependantData(Map<String, String> dependantData) {
        super(dependantData);
    }

    public DependantData(List<String> dependantData) {
        super(dependantData);
    }

}
