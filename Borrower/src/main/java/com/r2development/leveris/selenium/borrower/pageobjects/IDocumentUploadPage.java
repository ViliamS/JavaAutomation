package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.di.User;

public interface IDocumentUploadPage {
    String getTitle();
    String getDescription();

    IDocumentUploadPage clickDocumentsList();

    String getDescriptionDownloadCertList();
    IDocumentUploadPage clickDownloadCert();

    int getDocumentUploadSize();
    String getUploadName(int i);
    int getFilesUpload(int i);
    String getUploadDate(int i);
    IDocumentUploadPage clickViewActions(int i);
    IDocumentUploadPage clickAddMoreActions(int i);
    boolean getStatus(int i);

    IDocumentUploadPage uploadDocument(int i, String filename);
    IDocumentUploadPage uploadDocument(User user, String userType, String filename, String documentType);
    IDocumentUploadPage uploadDocument(String userType, String filename, String documentType);
    IDocumentUploadPage uploadAllDocuments();
    IDocumentUploadPage uploadAllDocuments(User user);
}
