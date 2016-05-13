package com.r2development.leveris.utils.Enums;

import java.util.Collections;
import java.util.LinkedList;

public enum LOANAPPSECTIONS {

    //Workflow|Finance Tool|Loan Offer Tool|Form Tools|Documents|Documents 2|Notes|Risk Tool|Update History

    WORKFLOW("Workflow"),
    FINANCE_TOOL("Finance Tool"),
    LOAN_OFFER_TOOL("Loan Offer Tool"),
    FORM_TOOLS("Form Tools"),
    DOCUMENTS("Documents"),
    DOCUMENTS2("Documents 2"),
    NOTES("Notes"),
    RISK_TOOL("Risk Tool"),
    UPDATE_HISTORY("Update History");

    private String section;

    LOANAPPSECTIONS(String section) {
        this.section = section;
    }

    public String getSectionName() {
        return section;
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_");
    }

    public static LOANAPPSECTIONS getFilter(String filterName) {
        return LOANAPPSECTIONS.valueOf(LOANAPPSECTIONS.transformationOfStringToEnumName(filterName));
    }

    public static LinkedList<LOANAPPSECTIONS> getEnumValues() {
        LinkedList<LOANAPPSECTIONS> enumValuesList = new LinkedList<>();
        Collections.addAll(enumValuesList, LOANAPPSECTIONS.values());
        return enumValuesList;
    }

}
