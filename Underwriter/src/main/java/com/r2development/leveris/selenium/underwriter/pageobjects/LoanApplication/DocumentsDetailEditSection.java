package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.utils.Enums.DOCUMENTTYPE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentsDetailEditSection extends DocumentsDetail implements IDocumentsDetailEditSection {

    private static final Log log = LogFactory.getLog(DocumentsDetailEditSection.class.getName());

    private WebDriver webDriver;

    public DocumentsDetailEditSection(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IDocumentsDetailEditSection setDocumentType(String value) {
        log.info("");
        isVisible(DOCUMENT_TYPE, true);
        setComboboxInput(DOCUMENT_TYPE, value);
        return this;
    }

    @Override
    public DOCUMENTTYPE getDocumentType(){
        log.info("");
        return DOCUMENTTYPE.getDocumentType(getDocumentTypeText());
    }

    @Override
    public String getDocumentTypeText(){
        log.info("");
        loadingCheck();
        isPresent(DOCUMENT_TYPE_SELECTED_VALUE, 1);
        WebElement webElement = webDriver.findElement(By.xpath(DOCUMENT_TYPE_SELECTED_VALUE));
        log.info("\n ----- \n new DocumentsDetailEditSection(webDriver).getDocumentTypeText(); returns ---> '" + getAttribute(webElement, "value") + "'");
        return getAttribute(webElement, "value");
    }

    @Override
    public IDocumentsDetailEditSection setDocumentSubType(String value) {
        log.info("");
        isVisible(DOCUMENT_SUB_TYPE, true);
        setComboboxInput(DOCUMENT_SUB_TYPE, value);
        return this;
    }

    @Override
    public String getDocumentSubType(){
        log.info("");
        try {
            loadingCheck();
            isPresent(DOCUMENT_SUB_TYPE_SELECTED_VALUE, 1);
        } catch (Exception e){
            log.info(e);
            log.info("Sub Type Not Present for Document Type : '" + getDocumentTypeText() + "'");
            return "Sub Type Not Present for Document Type : '" + getDocumentTypeText() + "'";
        }
        return getText(DOCUMENT_SUB_TYPE_SELECTED_VALUE);
    }

    @Override
    public IDocumentsDetailEditSection setExpiryDate(String date) {
        log.info("");
        isVisible(EXPIRY_DATE, true);
        type(EXPIRY_DATE, date);
        return this;
    }

    @Override
    public IDocumentsDetailEditSection setTag(String tag) {
        log.info("");
        isVisible(TAG_INPUT, true);
        type(TAG_INPUT, tag);
        return this;
    }

    @Override
    public IDocumentsDetailEditSection setUnderwritingStatus(String status) {
        log.info("");
        loadingCheck();
        isVisible(UNDERWRITING_STATUS, true);
        setComboboxInput(UNDERWRITING_STATUS, status);
        loadingCheck();
        return this;
    }

    @Override
    public IDocumentsDetail clickSave() {
        log.info("");
        loadingCheck();
        isVisible(SAVE_BUTTON, true);
        clickElement(SAVE_BUTTON);
        loadingCheck();
        return new DocumentsDetail((SharedDriver) webDriver);
    }

    @Override
    public IDocumentsDetailEditSection clickCancel() {
        log.info("");
        loadingCheck();
        isVisible(CANCEL_BUTTON, true);
        clickElement(CANCEL_BUTTON);
        loadingCheck();
        return this;
    }
}