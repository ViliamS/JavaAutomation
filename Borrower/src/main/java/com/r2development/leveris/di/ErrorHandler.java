package com.r2development.leveris.di;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Collection;
import java.util.Map;

@Singleton
public class ErrorHandler  /*extends DataModel*/ implements IErrorHandler {

    Map<String, String> errorMessages;

    @Inject
    ErrorHandler(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
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
}
