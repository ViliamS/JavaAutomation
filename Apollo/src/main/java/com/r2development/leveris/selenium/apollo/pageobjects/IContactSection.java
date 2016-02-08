package com.r2development.leveris.selenium.apollo.pageobjects;

interface IContactSection {

    String BACK_TO_SEARCH_XPATH = "//button[contains(@class, 'btn-default btn') and contains(., '<')]";
    String FULLNAME_XPATH = "//h1[contains(., '${replace}$')]";
    String DATE_OF_BIRTH_XPATH = "//p[contains(@class, 'additional-personal-info') and contains(., 'born ${replace}$')]";
    String EMAIL_XPATH = "//a[contains(@href, 'mailto:') and contains(@href, '${replace}$') and contains(., '${replace}$')]";
    //    String PHONE_XPATH = "//span[contains(.,'${replace}$')]";
    String ADDRESS_XPATH = "//span[contains(.,'${replace}$')]";

    String EDIT_CONTACT_XPATH = "//span[text()[contains(.,'Edit personal info')]]";
    String EXTRACT_CONTACT_DATA = "//i[contains(@class,'fa-home')]/following-sibling::span[not(text()[contains(.,' ')])]";

    //IContactSection waitForContactSectionToLoad();
    boolean checkContactData();
    boolean checkUpdatedContactData();
    IEditContactPage editContactData();
}
