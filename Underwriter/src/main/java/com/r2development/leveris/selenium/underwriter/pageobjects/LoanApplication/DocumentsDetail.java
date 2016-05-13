package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class DocumentsDetail extends LoanApplicationPage implements IDocumentsDetail{

    private static final Log log = LogFactory.getLog(DocumentsDetail.class.getName());

    private WebDriver webDriver;

    public DocumentsDetail(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IDocumentsSection clickDelete(){
        isVisible(DOCUMENT_DETAIL_DELETE_LINK, true);
        loadingCheck();
        clickElement(DOCUMENT_DETAIL_DELETE_LINK);
        loadingCheck();
        return new DocumentsSection((SharedDriver) webDriver);
    }

    @Override
    public IDocumentsSection clickCloseX(){
        loadingCheck();
        isVisible(DOCUMENT_DETAIL_CLOSE_X_BUTTON, true);
        clickElement(DOCUMENT_DETAIL_CLOSE_X_BUTTON, IDocumentsSection.DOCUMENTS_UPLOAD_BUTTON);
        loadingCheck();
        return new DocumentsSection((SharedDriver) webDriver);
    }

    @Override
    public IDocumentsDetailEditSection clickEdit(){
        isVisible(DOCUMENT_DETAIL_EDIT_LINK, true);
        loadingCheck();
        clickElement(DOCUMENT_DETAIL_EDIT_LINK, IDocumentsDetailEditSection.SAVE_BUTTON);
        loadingCheck();
        return new DocumentsDetailEditSection((SharedDriver) webDriver);
    }
}