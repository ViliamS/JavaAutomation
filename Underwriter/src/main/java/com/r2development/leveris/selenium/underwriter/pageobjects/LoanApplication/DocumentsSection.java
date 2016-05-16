package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver_Underwriter;
import com.r2development.leveris.utils.Enums.UNDERWRITINGSTATUS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath;
import static com.r2development.leveris.utils.XpathBuilder.XPath.getXPath_DivEqualsDataPath;

public class DocumentsSection extends LoanApplicationPage implements IDocumentsSection{

    private static final Log log = LogFactory.getLog(DocumentsSection.class.getName());

    private WebDriver webDriver;

    public DocumentsSection(SharedDriver_Underwriter webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IDocumentsSection documentsSectionHideUnhide(ACTION action) {
        log.info("");
        switch (action) {
            case HIDE:
                return hideDocumentsSection();
            case UNHIDE:
                return unhideDocumentsSection();
        }
        return null;
    }

    IDocumentsSection unhideDocumentsSection() {
        log.info("");
        loadingCheck();
        if(isPresent(DOCUMENTS_PANEL_HIDDEN, 1)) {
            clickElement(DOCUMENTS_PANEL_TITLE, DOCUMENTS_PANEL_NOT_HIDDEN);
            loadingCheck();
        } else {
            log.info("Documents section was already opened");
        }
        return this;
    }

    IDocumentsSection hideDocumentsSection() {
        log.info("");
        loadingCheck();
        if(isVisible(DOCUMENTS_PANEL_NOT_HIDDEN, 1)) {
            clickElement(DOCUMENTS_PANEL_NOT_HIDDEN, DOCUMENTS_PANEL_HIDDEN);
            loadingCheck();
        } else {
            log.info("Documents section is already hidden");
        }
        return this;
    }

    private List<WebElement> getWebElementListOfUploadedDocuments(){
        log.info("");
        loadingCheck();
        return webDriver.findElements(By.xpath(DOCUMENTS_UPLOADED_DOCUMENTS_ROW_ENTRY));
    }

    @Override
    public boolean isDocumentInExpectedStatus(UNDERWRITINGSTATUS underwritingstatus, int documentRowIndex){

        String DOCUMENT_ICON_LOCATOR = "";

        switch (underwritingstatus){

            case ACCEPTED:
                DOCUMENT_ICON_LOCATOR = getXPath_DivEqualsDataPath("rptDocuments " + documentRowIndex + " pnlDocuments lblStatus") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "check-icon") + getXPath(ACTIONS.NOT_CONTAINS, ATTRIBUTES.CLASS, "uncheck-icon");
                try {
                    isVisible(DOCUMENT_ICON_LOCATOR, 1);
                } catch (Exception x){
                    log.info(x);
                    return false;
                }
                return true;

            case REJECTED:
                DOCUMENT_ICON_LOCATOR = getXPath_DivEqualsDataPath("rptDocuments " + documentRowIndex + " pnlDocuments lblStatus") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "uncheck-icon");
                try {
                    isVisible(DOCUMENT_ICON_LOCATOR, 1);
                } catch (Exception x){
                    log.info(x);
                    return false;
                }
                return true;

            case NOT_SET:
                DOCUMENT_ICON_LOCATOR = getXPath_DivEqualsDataPath("rptDocuments " + documentRowIndex + " pnlDocuments lblStatus") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "notset-icon");
                try {
                    isVisible(DOCUMENT_ICON_LOCATOR, 1);
                } catch (Exception x){
                    log.info(x);
                    return false;
                }
                return true;

            default:
                log.info("Not covered document state returning false... please fix the implementation in your test");
                return false;
        }
    }

    @Override
    public int getNumberOfUploadedDocuments(){
        log.info("");
        return getWebElementListOfUploadedDocuments().size();
    }

    @Override
    public IDocumentsDetail openDocument(String value){
        log.info("");
        int indexNumber = Integer.parseInt(value);
        int number = indexNumber - 1;
        return openDocument(number);
    }

    @Override
    public IDocumentsDetail openDocument(int i){
        log.info("");
        String dataPath = "rptDocuments " + i + " pnlDocuments";
        String xpath = DOCUMENT_ROW_SELECTION + getXPath(ACTIONS.EQUALS, ATTRIBUTES.DATA_PATH, dataPath);
        System.out.println(xpath);
//        clickElementViaJavascript(xpath);
//
//
//        isVisible(xpath, true, 0);
//        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
//        executor.executeScript("arguments[0].click();", findBy(xpath));


        WebElement webElement = webDriver.findElement(By.xpath(xpath));
        webElement.click();
//        webElement.sendKeys(Keys.ENTER);






        return new DocumentsDetail((SharedDriver_Underwriter) webDriver);
    }
}
