package com.r2development.leveris.selenium.apollo.pageobjects;


import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class EditContactPage extends Apollo implements IEditContactPage, IHeaderSection, IEditContactSection {

    private static final Log log = LogFactory.getLog(EditContactPage.class);

    private SharedDriver webDriver;

    protected IHeaderSection headerSection;
    protected IEditContactSection editContactSection;

    EditContactPage(SharedDriver webDriver, Map<String, String> oldContactData) {
        super(webDriver);
        headerSection = HeaderSection.getHeaderSectionInstance(webDriver);
        editContactSection = EditContactSection.getEditContactSectionInstance(webDriver, oldContactData);
    }

    EditContactPage(SharedDriver webDriver, IHeaderSection headerSection, IEditContactSection editContactSection) {
        super(webDriver);
        this.headerSection = headerSection;
        this.editContactSection = editContactSection;
    }

    EditContactPage(SharedDriver webDriver, IHeaderSection headerSection, Map<String, String> oldContactData) {
        super(webDriver);
        this.headerSection = headerSection;
        this.editContactSection = EditContactSection.getEditContactSectionInstance(webDriver, oldContactData);
    }

    EditContactPage(SharedDriver webDriver, IEditContactSection editContactSection) {
        super(webDriver);
        this.headerSection = HeaderSection.getHeaderSectionInstance(webDriver);
        this.editContactSection = editContactSection;
    }

    public static IEditContactPage getEditContactPageInstance(SharedDriver webDriver, Map<String, String> oldContactData) {
//        IEditContactPage editContactPage = new IEditContactPage(webDriver, oldContactData).waitForPageToLoad();
        IEditContactPage editContactPage = new EditContactPage(webDriver, oldContactData);
        PageFactory.initElements(webDriver, editContactPage);
        return editContactPage;
    }

    public static IEditContactPage getEditContactPageInstance(SharedDriver webDriver, IHeaderSection headerSection, IEditContactSection editContactSection) {
//        IEditContactPage editContactPage = new IEditContactPage(webDriver, oldContactData).waitForPageToLoad();
        IEditContactPage editContactPage = new EditContactPage(webDriver, headerSection, editContactSection);
        PageFactory.initElements(webDriver, editContactPage);
        return editContactPage;
    }

    public static IEditContactPage getEditContactPageInstance(SharedDriver webDriver, IHeaderSection headerSection, Map<String, String> oldContactData) {
//        IEditContactPage editContactPage = new IEditContactPage(webDriver, oldContactData).waitForPageToLoad();
        IEditContactPage editContactPage = new EditContactPage(webDriver, headerSection, oldContactData);
        PageFactory.initElements(webDriver, editContactPage);
        return editContactPage;
    }

    public static IEditContactPage getEditContactPageInstance(SharedDriver webDriver, IEditContactSection editContactSection) {
//        IEditContactPage editContactPage = new IEditContactPage(webDriver, oldContactData).waitForPageToLoad();
        IEditContactPage editContactPage = new EditContactPage(webDriver, editContactSection);
        PageFactory.initElements(webDriver, editContactPage);
        return editContactPage;
    }


    @Override
    public String getAddress1() {
        return editContactSection.getAddress1();
    }

    @Override
    public IEditContactSection setAddress1(String address1) {
        return editContactSection.setAddress1(address1);
    }

    @Override
    public String getAddress2() {
        return editContactSection.getAddress2();
    }

    @Override
    public IEditContactSection setAddress2(String address2) {
        return editContactSection.setAddress2(address2);
    }

    @Override
    public String getCity() {
        return editContactSection.getCity();
    }

    @Override
    public IEditContactSection setCity(String city) {
        return editContactSection.setCity(city);
    }

    @Override
    public String getCounty() {
        return editContactSection.getCounty();
    }

    @Override
    public IEditContactSection setCounty(String city) {
        return editContactSection.setCity(city);
    }

    @Override
    public String getZip() {
        return editContactSection.getZip();
    }

    @Override
    public IEditContactSection setZip(String zip) {
        return editContactSection.setZip(zip);
    }

    @Override
    public String getCountry() {
        return editContactSection.getCountry();
    }

    @Override
    public IEditContactSection setCountry(String country) {
        return editContactSection.setCountry(country);
    }

    @Override
    public IRecordPage clickSaveChanges() {
        return editContactSection.clickSaveChanges();
    }

    @Override
    public IRecordPage clickDiscardChanges() {
        return editContactSection.clickDiscardChanges();
    }

    @Override
    public ILoginPage clickLogOutButton() {
        return headerSection.clickLogOutButton();
    }

    @Override
    public String getVersion() {
        return headerSection.getVersion();
    }

    @Override
    public Map<String, String> clickClientOverviewMenu() {
        return headerSection.clickClientOverviewMenu();
    }

    @Override
    public void clickClientOverviewItemMenu() {
        headerSection.clickClientOverviewItemMenu();
    }

    @Override
    public void clickPaymentItemMenu() {
        headerSection.clickPaymentItemMenu();
    }
}

