package com.r2development.leveris.utils.Enums;

import java.util.Collections;
import java.util.LinkedList;

public enum SEARCHFILTERS {

    ASSIGNED("Assigned"),
    CASE("Case"),
    STATUS("Status"),
    SEARCH_TEXT("Search text"),
    APPLICATION_ID("Application id");

    private String filterName;

    SEARCHFILTERS(String filterName){
        this.filterName = filterName;
    }

    public String getFilterName(){
        return filterName;
    }

    private static  String transformationOfStringToEnumName(String text){
        return text.toUpperCase().replace(" ", "_");
    }

    public static SEARCHFILTERS getFilter(String filterName){
        return SEARCHFILTERS.valueOf(SEARCHFILTERS.transformationOfStringToEnumName(filterName));
    }

    public static LinkedList<SEARCHFILTERS> getEnumValues(){
        LinkedList<SEARCHFILTERS> enumValuesList = new LinkedList<>();
        Collections.addAll(enumValuesList, SEARCHFILTERS.values());
        return enumValuesList;
    }
}