package com.r2development.leveris.di;

import com.google.inject.ImplementedBy;

import java.util.Collection;
import java.util.Map;

@ImplementedBy(ErrorHandler.class)
public interface IErrorHandler {
    void set(Map<String, String> errorMessages);
    void add(String key, String value);
    Collection<String> getKeySet();
    Collection<String> getValues();
}
