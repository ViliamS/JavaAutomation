package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.di.IUser;

//@ImplementedBy(DocumentUploadSection.class)
public interface IDocumentUploadSection {
    String TITLE_XPATH = "//h2[contains(., 'Document upload')]";
    String DESCRIPTION_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlNew_c_w_lblInfo']//span";

    String DOCUMENTS_LIST_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNew_c_w_lnkSeeDocList_dialog']";

    String DESCRIPTION_DOWNLOAD_CERT_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlNew_c_w_pnl-830_c_w_pnlSalcert_c_w_lbl-263']//span";
    String DOWNLOAD_CERT_XPATH = "//a[@wicketpath='main_c_form_form_root_c_w_pnlNew_c_w_pnl-830_c_w_pnlSalcert_c_w_btnDownloadCert_dialog']";

    String REPORT_DOC_CONTAINER_XPATH = "//div[@wicketpath='main_c_form_form_root_c_w_pnlNew_c_w_rptDocs']";

    String REPORTS_LIST_XPATH = "//div[contains(@id, 'pnlDocs') and contains(@wicketpath, 'main_c_form_form_root_c_w_pnlNew_c_w_rptDocs_c_rows_') and contains(@wicketpath, '_item_pnlDocs')]";
//    String REPORTS_LIST_NOT_UPLOADED_DOCUMENTS_XPATH = "//div[contains(@id, 'pnlDocs') and contains(@wicketpath, 'main_c_form_form_root_c_w_pnlNew_c_w_rptDocs_c_rows_') and contains(@wicketpath, '_item_pnlDocs') and contains(., 'No files yet')]";
//    "//div[contains(@wicketpath,'main_c_form_form_root_c_w_pnlNew_c_w_rptDocs_c_rows_') and contains(@wicketpath,'_item_pnlDocs_c') and not(@data-path) and @data-enabled]"
//    String REPORTS_LIST_NOT_UPLOADED_DOCUMENTS_XPATH = "//div[contains(@wicketpath,'main_c_form_form_root_c_w_pnlNew_c_w_rptDocs_c_rows_') and contains(@wicketpath,'_item_pnlDocs_c') and not(@data-path) and @data-enabled and contains(., 'No Files yet')]";
    String REPORTS_LIST_NOT_UPLOADED_DOCUMENTS_XPATH = "//div[contains(@wicketpath,'main_c_form_form_root_c_w_pnlNew_c_w_rptDocs_c_rows_') and contains(@wicketpath,'_item_pnlDocs_c') and contains(@data-path, 'pnlNew rptDocs') and contains(@id, 'lnkAddMore')]";
    String REPORT_CONTAINER_XPATH = "//div[contains(@id, 'pnlDocs') and contains(@wicketpath, 'main_c_form_form_root_c_w_pnlNew_c_w_rptDocs_c_rows_${replaceIndex}$_item_pnlDocs')]";
    String UPLOAD_NAME_XPATH = ".//div[contains(@data-path, 'lblUploadName')]//span";
    String STATUS_NOT_DONE_XPATH = "//div[contains(@data-path, 'lblStatus') and not(contains(@class, 'formdone-icon'))]";
    String STATUS_DONE_XPATH = "//div[contains(@data-path, 'lblStatus') and contains(@class, 'formdone-icon')]";
    String UPLOAD_COUNT_XPATH = "//div[contains(@data-path, 'lblUploadCount')]//span";
    String UPLOAD_DATE_XPATH = "//div[contains(@data-path, 'lblUploadDate')]//span";
    String VIEW_OPEN_XPATH = "//a[contains(@wicketpath, 'lnkView_dialog')]";
    String VIEW_CLOSE_XPATH = "//a[contains(@wicketpath, 'lnkView_close')]";
    String ADD_MORE_OPEN_XPATH = "//a[contains(@wicketpath, 'lnkAddMore_dialog')]";
    String ADD_MORE_CLOSE_XPATH = "//a[contains(@wicketpath, 'lnkAddMore_close')]";


    String BROWSE_FOR_FILES_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMain_c_w_pnl_c_w_lnkBrowse_url']";
    String UPLOAD_INPUT_XPATH = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable sc-dialog sc-fullscreen dnduploadborr']//input[@type='file']";
    String SUBMIT_UPLOAD_XPATH = "//a[@wicketpath='main_c_form_dialogWrapper_dialog_form_root_c_w_pnlMain_c_w_btnHiddenSubmit_submit']";

    String getTitle();
    String getDescription();

    IDocumentUploadSection clickDocumentsList();

    String getDescriptionDownloadCertList();
    IDocumentUploadSection clickDownloadCert();

    int getDocumentUploadSize();
    String getUploadName(int i);
    int getFilesUpload(int i);
    String getUploadDate(int i);
    IDocumentUploadSection clickViewActions(int i);
    IDocumentUploadSection clickAddMoreActions(int i);
    boolean getStatus(int i); // contains(@class, 'formdone-icon') ? true : false;

    IDocumentUploadSection uploadDocument(int i, String filename);
    IDocumentUploadSection uploadDocument(IUser user, String userType, String filename, String documentType);
    IDocumentUploadSection uploadDocument(String userType, String filename, String documentType);
    IDocumentUploadSection uploadAllDocuments();
    IDocumentUploadSection uploadAllDocuments(IUser user);
}