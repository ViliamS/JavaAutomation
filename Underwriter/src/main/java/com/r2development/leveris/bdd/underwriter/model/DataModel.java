package com.r2development.leveris.bdd.underwriter.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataModel extends LinkedHashMap {

    Map<String, String> data = new LinkedHashMap<>();

    /**
     * Constructs an empty insertion-ordered <tt>LinkedHashMap</tt> instance
     * with the default initial capacity (16) and load factor (0.75).
     */
    public DataModel(Map<String, String> data) {
        this.data.putAll(data);
    }

    public DataModel(List<String> dataList) {
        int i=0;
        do {
            data.put(dataList.get(i), dataList.get(i+1));
            i=i+2;
        } while (i<(dataList.size()-1));
    }

    public String get(String key) {
        return ( data.containsKey(key) ? data.get(key) : null);
    }

    public Map<String, String> getData() {
        return data;
    }
}