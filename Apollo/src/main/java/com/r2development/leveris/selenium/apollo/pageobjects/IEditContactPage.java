package com.r2development.leveris.selenium.apollo.pageobjects;

public interface IEditContactPage {
    String getAddress1();
    IEditContactSection setAddress1(String address1);
    String getAddress2();
    IEditContactSection setAddress2(String address2);
    String getCity();
    IEditContactSection setCity(String city);
    String getCounty();
    IEditContactSection setCounty(String city);
    String getZip();
    IEditContactSection setZip(String zip);
    String getCountry();
    IEditContactSection setCountry(String country);

    IRecordPage clickSaveChanges();
    IRecordPage clickDiscardChanges();
}
