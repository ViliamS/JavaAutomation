package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class RecordPage extends Apollo implements IRecordPage, IMortgageSection, IContactSection, IHeaderSection {

    private static final Log log = LogFactory.getLog(RecordPage.class);

    private IHeaderSection headerSection;
    private IContactSection contactSection;
    private IMortgageSection mortgageSection;

    public static IRecordPage getRecordPageInstance(SharedDriver webDriver) {
//        IRecordPage recordPage = new RecordPage(webDriver).waitForPageToLoad();
        IRecordPage recordPage = new RecordPage(webDriver);
        PageFactory.initElements(webDriver, recordPage);
        return recordPage;
    }

    public static IRecordPage getRecordPageInstance(SharedDriver webDriver, Map<String, String> contactData, Map<String, String> contactData2) {
//        IRecordPage recordPage = new RecordPage(webDriver, contactData).waitForPageToLoad();
        IRecordPage recordPage = new RecordPage(webDriver, contactData, contactData2);
        PageFactory.initElements(webDriver, recordPage);
        return recordPage;
    }

    public static IRecordPage getRecordPageInstance(SharedDriver webDriver, IContactSection iContactSection) {
//        IRecordPage recordPage = new RecordPage(webDriver).waitForPageToLoad();
        IRecordPage recordPage = new RecordPage(webDriver);
        PageFactory.initElements(webDriver, recordPage);
        return recordPage;
    }

    public static IRecordPage getRecordPageInstance(SharedDriver webDriver, IMortgageSection iMortgageSection) {
//        IRecordPage recordPage = new RecordPage(webDriver).waitForPageToLoad();
        IRecordPage recordPage = new RecordPage(webDriver);
        PageFactory.initElements(webDriver, recordPage);
        return recordPage;
    }

    public RecordPage(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = HeaderSection.getHeaderSectionInstance(webDriver);
        contactSection = ContactSection.getContactSectionInstance(webDriver);
        mortgageSection = MortgageSection.getMortgageSectionInstance(webDriver);
    }

    public RecordPage(SharedDriver webDriver, Map<String, String> contactData, Map<String, String> contactData2) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = HeaderSection.getHeaderSectionInstance(webDriver);
        contactSection = ContactSection.getContactSectionInstance(webDriver, contactData, contactData2);
        mortgageSection = MortgageSection.getMortgageSectionInstance(webDriver);
    }

    public RecordPage(SharedDriver webDriver, IContactSection iContactSection) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = HeaderSection.getHeaderSectionInstance(webDriver);
        contactSection = iContactSection;
        mortgageSection = MortgageSection.getMortgageSectionInstance(webDriver);
    }

    RecordPage(SharedDriver webDriver, IHeaderSection iheaderSection, IContactSection iContactSection, IMortgageSection iMortgageSection) {
        super(webDriver);
        this.webDriver = webDriver;
        headerSection = iheaderSection;
        contactSection = iContactSection;
        mortgageSection = iMortgageSection;
    }

//    private IRecordPage waitForPageToLoad() {
//        headerSection.waitForHeaderSectionToLoad();
//        contactSection.waitForContactSectionToLoad();
//        mortgage.waitForMortgageSectionToLoad();
//        return this;
//    }

//    @Override
//    public IHeaderSection waitForHeaderSectionToLoad() {
//        return headerSection.waitForHeaderSectionToLoad();
//    }

//    @Override
//    public IContactSection waitForContactSectionToLoad() {
//        return contactSection.waitForContactSectionToLoad();
//    }

//    @Override
//    public IMortgageSection waitForMortgageSectionToLoad() {
//        return mortgage.waitForMortgageSectionToLoad();
//    }

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
        // TODO implementation
        return null;
    }

    @Override
    public void clickClientOverviewItemMenu() {
        // TODO implementation
    }

    @Override
    public void clickPaymentItemMenu() {
        // TODO implementation
    }

    @Override
    public boolean checkContactData() {
        return contactSection.checkContactData();
    }

    @Override
    public IEditContactPage editContactData() {
        return contactSection.editContactData();
    }

    @Override
    public boolean checkUpdatedContactData() {
        return contactSection.checkUpdatedContactData();
    }
}

