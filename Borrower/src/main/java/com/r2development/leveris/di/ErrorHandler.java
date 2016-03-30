package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import java.util.Collection;
import java.util.Map;

@Singleton
public class ErrorHandler  /*extends DataModel*/ implements Provider<Map<String,String>> {

    private Map<String, String> errorMessages;

    @Inject
    ErrorHandler(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void set(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public void add(String key, String value) {
        errorMessages.put(key, value);
    }

    public Collection<String> getKeySet() {
        return errorMessages.keySet();
    }

    public Collection<String> getValues() {
        return errorMessages.values();
    }

    @Override
    public Map<String, String> get() {
        return errorMessages;
    }
}
