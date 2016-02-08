package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.di.IUser;
import com.r2development.leveris.di.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class DocumentUploadPage extends HeaderAndBottomAndFormsMenuSection implements IFormsMenu, IDocumentUploadPage {

    private static Log log = LogFactory.getLog(DocumentUploadPage.class);

    protected IDocumentUploadSection documentUploadSection;
    protected IFormsMenu formsMenu;
    protected IUser user;

    public DocumentUploadPage(WebDriver webDriver) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        documentUploadSection = new DocumentUploadSection(webDriver);
        formsMenu = new FormsMenu(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    public DocumentUploadPage(WebDriver webDriver, User user) {
        super(webDriver);
        headerSection = new HeaderSection(webDriver);
        documentUploadSection = new DocumentUploadSection(webDriver, user);
        formsMenu = new FormsMenu(webDriver);
        bottomSection = new BottomSection(webDriver);
    }

    @Override
    public String getTitle() {
        return documentUploadSection.getTitle();
    }

    @Override
    public String getDescription() {
        return documentUploadSection.getDescription();
    }

    @Override
    public IDocumentUploadPage clickDocumentsList() {
        documentUploadSection.clickDocumentsList();
        return this;
    }

    @Override
    public String getDescriptionDownloadCertList() {
        return documentUploadSection.getDescriptionDownloadCertList();
    }

    @Override
    public IDocumentUploadPage clickDownloadCert() {
        documentUploadSection.clickDownloadCert();
        return this;
    }

    @Override
    public int getDocumentUploadSize() {
        return documentUploadSection.getDocumentUploadSize();
    }

    @Override
    public String getUploadName(int i) {
        return documentUploadSection.getUploadName(i);
    }

    @Override
    public int getFilesUpload(int i) {
        return documentUploadSection.getFilesUpload(i);
    }

    @Override
    public String getUploadDate(int i) {
        return documentUploadSection.getUploadDate(i);
    }

    @Override
    public IDocumentUploadPage clickViewActions(int i) {
        documentUploadSection.clickViewActions(i);
        return this;
    }

    @Override
    public IDocumentUploadPage clickAddMoreActions(int i) {
        documentUploadSection.clickAddMoreActions(i);
        return this;
    }

    @Override
    public boolean getStatus(int i) {
        return documentUploadSection.getStatus(i);
    }

    @Override
    public IDocumentUploadPage uploadDocument(int i, String filename) {
        documentUploadSection.uploadDocument(i, filename);
        return this;
    }

    @Override
    public IDocumentUploadPage uploadDocument(User user, String userType, String filename, String documentType) {
        documentUploadSection.uploadDocument(user, userType, filename, documentType);
        return this;
    }

    @Override
    public IDocumentUploadPage uploadDocument(String userType, String filename, String documentType) {
        documentUploadSection.uploadDocument(userType, filename, documentType);
        return this;
    }

    @Override
    public IDocumentUploadPage uploadAllDocuments() {
        documentUploadSection.uploadAllDocuments();
        return this;
    }

    @Override
    public IDocumentUploadPage uploadAllDocuments(User user) {
        documentUploadSection.uploadAllDocuments(user);
        return this;
    }
}
