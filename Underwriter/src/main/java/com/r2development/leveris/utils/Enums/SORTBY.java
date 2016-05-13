package com.r2development.leveris.utils.Enums;

public enum SORTBY {

    STAGE_SUBMISSION_DATE("stage submission date"),
    CREATION_DATE("creation date"),
    EMPTY("");

    private String sortBy;

    SORTBY(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getString() {
        return sortBy;
    }

    public static SORTBY getEnumSortBy(String sortBy){
        return SORTBY.valueOf(transformationOfStringToEnumName(sortBy));
    }

    private static  String transformationOfStringToEnumName(String text){
        return text.toUpperCase().replace(" ", "_");
    }
}