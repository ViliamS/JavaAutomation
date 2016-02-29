package com.r2development.leveris.bdd.borrower.model;

import java.util.List;
import java.util.Map;

public class FinancialData extends DataModel {

    public FinancialData(Map<String, String> financialData) {
        super(financialData);
    }

    public FinancialData(List<String> financialData) {
        super(financialData);
    }

}
