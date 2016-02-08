package com.r2development.leveris.bdd.borrower.model;

import java.util.LinkedHashMap;
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

    public DataModel() {
        this.data = new LinkedHashMap<>();
    }

    public String get(String key) {
        return ( data.containsKey(key) ? data.get(key) : null);
    }

    public Map<String, String> getData() {
        return data;
    }
}
