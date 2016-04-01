package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContactSection extends Apollo implements IContactSection {

    private static final Log log = LogFactory.getLog(ContactSection.class);

    private SharedDriver webDriver;

    private Map<String, String> contactDataFromSearch;
    private Map<String, String> contactDataFromEditContactPage;

    @FindBy( xpath = FULLNAME_XPATH)
    protected WebElement weFullName;

    @FindBy( xpath = DATE_OF_BIRTH_XPATH)
    protected WebElement weDateOfBirth;

    @FindBy( xpath = EMAIL_XPATH)
    protected WebElement weEmail;

//    @FindBy( xpath = PHONE_XPATH)
//    WebElement wePhone;

    @FindBy( xpath = ADDRESS_XPATH)
    protected WebElement weAddress;

    @FindBy( xpath = EDIT_CONTACT_XPATH)
    protected WebElement weEditContact;


    ContactSection(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    ContactSection(SharedDriver webDriver, Map<String, String> contactData, Map<String, String> contractData2) {
        super(webDriver);
        this.webDriver = webDriver;
        contactDataFromSearch = contactData;
        contactDataFromEditContactPage = contractData2;
//        replace();
    }

    public static IContactSection getContactSectionInstance(SharedDriver webDriver) {
        IContactSection contactSection = new ContactSection(webDriver);
        PageFactory.initElements(webDriver, contactSection);
        return contactSection;
    }

    public static IContactSection getContactSectionInstance(SharedDriver webDriver, Map<String, String> contactData, Map<String, String> contactData2) {
        IContactSection contactSection = new ContactSection(webDriver, contactData, contactData2);
        PageFactory.initElements(webDriver, contactSection);
        return contactSection;
    }


//    @Override
//    public IContactSection waitForContactSectionToLoad() {
//        return this;
//    }

    @Override
    public boolean checkContactData() {
        boolean toReturn = true;

        if ( contactDataFromSearch.get("First Name") != null && contactDataFromSearch.get("Last Name") != null) {
            if (!isVisible(FULLNAME_XPATH.replace("${replace}$", contactDataFromSearch.get("First Name") + contactDataFromSearch.get("Last Name")), 5)) {
                toReturn = false;
//                log.error( " ContactData Firstname and LastName are not displayed");
            }
//            isVisible(FULLNAME_XPATH.replace("${replace}$", contactDataFromSearch.get("First Name") + contactDataFromSearch.get("Last Name")));
        }

        if ( contactDataFromSearch.get("Date of Birth") != null) {
            if (!isVisible(DATE_OF_BIRTH_XPATH.replace("${replace}$", contactDataFromSearch.get("Date of Birth")), 5)) {
                toReturn = false;
//                log.error( " ContactData Date Of Birth are not displayed");
            }
//            isVisible(DATE_OF_BIRTH_XPATH.replace("${replace}$", contactDataFromSearch.get("Date of Birth")));
        }

        if(contactDataFromSearch.get("Email") != null) {
            if (!isVisible(EMAIL_XPATH.replace("${replace}$", contactDataFromSearch.get("Email")), 5)) {
                toReturn = false;
//                log.error( " ContactData Email are not displayed");
            }
//            isVisible(EMAIL_XPATH.replace("${replace}$", contactDataFromSearch.get("Email")));
        }

        if(contactDataFromSearch.get("Address") != null) {
            if (!isVisible(ADDRESS_XPATH.replace("${replace}$", contactDataFromSearch.get("Address")), 5)) {
                toReturn = false;
//                log.error( " ContactData Address are not displayed");
            }
//            isVisible(ADDRESS_XPATH.replace("${replace}$", contactDataFromSearch.get("Address")));
        }

//        toReturn = true;
        return toReturn;
    }

    private Map<String, String> replace() {
        Map<String, String> xpath = new LinkedHashMap<>();
        if (contactDataFromSearch != null) {
            if ( contactDataFromSearch.get("First Name") != null && contactDataFromSearch.get("Last Name") != null)
                 xpath.put("fullname",FULLNAME_XPATH.replace("${replace}$", contactDataFromSearch.get("First Name") + contactDataFromSearch.get("Last Name")));
            if ( contactDataFromSearch.get("Date Of Birth") != null)
                xpath.put("dob", DATE_OF_BIRTH_XPATH.replace("${replace}$", contactDataFromSearch.get("Date Of Birth")));
            if ( contactDataFromSearch.get("Email") != null)
                xpath.put("email", EMAIL_XPATH.replace("${replace}$", contactDataFromSearch.get("Email")));
            if ( contactDataFromSearch.get("Address") != null)
                xpath.put("address", ADDRESS_XPATH.replace("${replace}$", contactDataFromSearch.get("Address")));
        }

        return xpath;
    }

    @Override
    public IEditContactPage editContactData() {
        isVisible(EDIT_CONTACT_XPATH);
        weEditContact.click();
        return EditContactPage.getEditContactPageInstance(webDriver, contactDataFromSearch);
    }

    @Override
    public boolean checkUpdatedContactData() {
        String[] updatedData = getWebElement(EXTRACT_CONTACT_DATA).getText().split(",");

        // TODO to implement with guice injection

        return true;
    }
}

