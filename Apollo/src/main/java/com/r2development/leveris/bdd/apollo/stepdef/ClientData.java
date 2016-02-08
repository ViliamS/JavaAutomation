package com.r2development.leveris.bdd.apollo.stepdef;

import java.util.HashMap;
import java.util.Map;

// TODO to move to guice di object
public class ClientData {

    Map<String, String> clientData;

    public ClientData(){
        clientData = new HashMap<>();
        clientData.put("Fulltext search", "");
        clientData.put("First Name", "");
        clientData.put("Middle Name", "");
        clientData.put("Last Name", "");
        clientData.put("Date Of Birth", "");
        clientData.put("Email", "");
        clientData.put("Phone", "");
        clientData.put("Address Line 1", "");
        clientData.put("Address Line 2", "");
    }

    public void put(String key, String value) {
        clientData.put(key, value);
    }

    public void putAll(Map<String, String> clientData) {
        this.clientData.putAll(clientData);
    }

    public Map<String, String> getClientData() {
        return clientData;
    }
}
