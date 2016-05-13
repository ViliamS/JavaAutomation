package com.r2development.leveris.utils.Enums;

public enum SORT {

    ASC("asc"),
    DESC("desc"),
    EMPTY("");

    private String sort;

    SORT(String sort) {
        this.sort = sort;
    }

    public String getString() {
        return sort;
    }

    public static SORT getEnumSort(String sort){
        return SORT.valueOf(sort.toUpperCase());
    }
}