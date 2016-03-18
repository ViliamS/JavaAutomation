package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.di.IUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.util.*;

import static org.hamcrest.junit.MatcherAssert.assertThat;

@Singleton
public class DocumentUploadSection extends Borrower implements IDocumentUploadSection {

    public static Log log = LogFactory.getLog(DocumentUploadSection.class);

    @FindBy( xpath = TITLE_XPATH )
    protected WebElement weTitle;
    @FindBy( xpath = DESCRIPTION_XPATH )
    protected WebElement weDescription;

    @FindBy( xpath = DOCUMENTS_LIST_XPATH )
    protected WebElement weDocumentsList;

    @FindBy( xpath = DESCRIPTION_DOWNLOAD_CERT_XPATH )
    protected WebElement weDescriptionDownloadCert;
    @FindBy( xpath = DOWNLOAD_CERT_XPATH )
    protected WebElement weDownloadCert;

    @FindBy( xpath = REPORT_DOC_CONTAINER_XPATH )
    protected WebElement weReportDocContainer;

    @FindAll( @FindBy ( xpath = REPORTS_LIST_XPATH ))
    protected List<WebElement> weReportsList;


    @FindBy( xpath = UPLOAD_INPUT_XPATH )
    protected WebElement weUploadInput;
    @FindBy( xpath = SUBMIT_UPLOAD_XPATH )
    protected WebElement weSubmitUpload;

    @Inject
    protected IUser user;

//    @Inject
//    public DocumentUploadSection(WebDriver webDriver) {
//        super(webDriver);
//        PageFactory.initElements(webDriver, this);
//    }

//    @Inject
    public DocumentUploadSection(SharedDriver webDriver/*, IUser user*/) {
        super(webDriver);
//        this.user = user;
        PageFactory.initElements(webDriver, this);
    }


    @Override
    public String getTitle() {
        isVisible(TITLE_XPATH, true, 10);
        return getWebElement(TITLE_XPATH, 10).getText();
//        return weTitle.getText();
    }

    @Override
    public String getDescription() {
        isVisible(DESCRIPTION_XPATH, true);
        return weDescription.getText();
    }

    @Override
    public IDocumentUploadSection clickDocumentsList() {
        isVisible(DOCUMENTS_LIST_XPATH,true);
        weDocumentsList.click();
        return this;
    }

    @Override
    public String getDescriptionDownloadCertList() {
        isVisible(DESCRIPTION_DOWNLOAD_CERT_XPATH, true);
        return weDescriptionDownloadCert.getText();
    }

    @Override
    public IDocumentUploadSection clickDownloadCert() {
        isVisible(DOWNLOAD_CERT_XPATH, true);
        weDownloadCert.click();
        return this;
    }

    @Override
    public int getDocumentUploadSize() {
        isVisible(REPORTS_LIST_XPATH, true);
        return (getWebElements(REPORTS_LIST_XPATH)).size();
    }

    @Override
    public String getUploadName(int i) {
        String xpath = REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i)) + UPLOAD_NAME_XPATH;
        isVisible(xpath, true);
        return getWebElement(xpath).getText();
    }

    @Override
    public int getFilesUpload(int i) {
        String xpath = REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i)) + UPLOAD_COUNT_XPATH;
        isVisible(xpath, true);
        return Integer.parseInt(getWebElement(xpath).getText().split(" ")[0]);
    }

    @Override
    public String getUploadDate(int i) {
        String xpath = REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i)) + UPLOAD_DATE_XPATH;
        isVisible(xpath, true);
        return getWebElement(xpath).getText();
    }

    @Override
    public IDocumentUploadSection clickViewActions(int i) {
        String xpath = REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i)) + VIEW_OPEN_XPATH;
        isVisible(xpath, true);
        getWebElement(xpath).click();
        return this;
    }

    @Override
    public IDocumentUploadSection clickAddMoreActions(int i) {
        String xpath = REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i)) + ADD_MORE_OPEN_XPATH;
        isVisible(xpath, true);
        clickElement(By.xpath(xpath), BROWSE_FOR_FILES_XPATH);
//        isVisible(,true);
//        isVisible(BROWSE_FOR_FILES_XPATH, false);
//        try {
//            getWebElement(xpath).click();
//        } catch ( WebDriverException wde) {}
//        finally {
//            getWebElement(xpath).click();
//        }
        return this;
    }

    @Override
    public boolean getStatus(int i) {
//        String xpath = REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i)) + VIEW_OPEN_XPATH;
        return isVisible(STATUS_DONE_XPATH, true);
    }

    @Override
    public IDocumentUploadSection uploadDocument(int i, String filename) {
        String xpath = REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i)) + ADD_MORE_OPEN_XPATH;
        isVisible(xpath, true);
        clickElement(xpath, BROWSE_FOR_FILES_XPATH);
//        isVisible(BROWSE_FOR_FILES_XPATH, true);
        uploadDocument(filename);
        isVisible(TITLE_XPATH, true, 60);
        return this;
    }

    @Override
    public IDocumentUploadSection uploadDocument(IUser user, String userType, String filename, String documentType) {
        this.user = user;
        Table<String, String, Integer> tableDocumentUpload = getDocumentTable();
        clickAddMoreActions(tableDocumentUpload.get(userType, documentType));
        uploadDocument(filename);
        isVisible(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(tableDocumentUpload.get(userType, documentType))), true);
        if ( !documentType.contains("Current account") )
            getWebElementWithText(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(tableDocumentUpload.get(userType, documentType))), "1 file", 240);
//            isVisible(IGetApprovalSection.READY_TO_REVIEW_AND_SUBMIT_BUTTON_XPATH, true);
        return this;
    }

    @Override
    public IDocumentUploadSection uploadDocument(String userType, String filename, String documentType) {
        Table<String, String, Integer> tableDocumentUpload = getDocumentTable();
        clickAddMoreActions(tableDocumentUpload.get(userType, documentType));
        uploadDocument(filename);
        isVisible(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(tableDocumentUpload.get(userType, documentType))), true);
        getWebElementWithText(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(tableDocumentUpload.get(userType, documentType))), "1 file", 240);
        return this;
    }

    @Override
    public IDocumentUploadSection uploadAllDocuments() {
//        Set<String> tableRemainingDocumentUpload = getRemainingDocumentTable();
//        log.debug("index: " + tableRemainingDocumentUpload.toArray().toString());
//        for ( String currentIndex : tableRemainingDocumentUpload) {
////            clickAddMoreActions(Integer.valueOf(currentIndex)+1);
//            uploadDocument(Integer.valueOf(currentIndex) + 1, "file.txt");
//        }

        Table<String, String, Integer> tableDocumentUpload = getDocumentTable();
        List<Integer> listIndex = new LinkedList<>(tableDocumentUpload.values());
        Collections.sort(listIndex);
        Set<Integer> listFinalIndex = new HashSet<>(listIndex);
        int numberDocuments = listFinalIndex.size();

//        log.info("Table Document Upload: " + numberDocuments + ", " + listFinalIndex);
        for ( Integer index : listFinalIndex ) {
            log.info("nd:" + numberDocuments + ", " + index);
            clickAddMoreActions(index);
            uploadDocument("file.txt");
            if ( numberDocuments != 1) {
                isVisible(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(index)), true);
                getWebElementWithText(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(index)), "1 file", 60);
                numberDocuments--;
            }
        }

        return this;
    }

    @Override
    public IDocumentUploadSection uploadAllDocuments(IUser user) {
        this.user = user;
        Table<String, String, Integer> tableDocumentUpload = getDocumentTable();
        List<Integer> listIndex = new LinkedList<>(tableDocumentUpload.values());
        Collections.sort(listIndex);
        Set<Integer> listFinalIndex = new HashSet<>(listIndex);
        int numberDocuments = listFinalIndex.size();

//        log.info("Table Document Upload: " + numberDocuments + ", " + listFinalIndex);
        for ( Integer index : listFinalIndex ) {
            log.info("nd:" + numberDocuments + ", " + index);
            clickAddMoreActions(index);
            uploadDocument("file.txt");
            if ( numberDocuments != 1) {
                isVisible(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(index)), true);
                getWebElementWithText(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(index)), "1 file", 60);
                numberDocuments--;
            }
        }

        return this;
    }

    private void uploadDocument(String filename) {
        File file = null;
        try {
            //noinspection ConstantConditions
            file = new File(DocumentUploadSection.class.getClassLoader().getResource(filename).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //noinspection ConstantConditions
        assertThat("File should exist", file.exists(), Is.is(true));

        isVisible(BROWSE_FOR_FILES_XPATH, false);
        isInvisible(UPLOAD_INPUT_XPATH, false);
        weUploadInput.sendKeys(file.getAbsolutePath());
        isInvisible(SUBMIT_UPLOAD_XPATH, false);
        isVisible(TITLE_XPATH);
        // TODO IMPLEMENT CASE of Design Test ... to check if the class formicon-done is injected
    }

    private List<String> getDocumentSet() {
        List<String> toReturn = new LinkedList<>();
        Set<String> uploadNames = new LinkedHashSet<>();

        for( WebElement currentWebElement : weReportsList) {
            String uploadName = currentWebElement.findElement(By.xpath(UPLOAD_NAME_XPATH)).getText();
            uploadNames.add(uploadName);
        }

        toReturn.addAll(uploadNames);
        return toReturn;
    }

    // TODO to redesign : internal automation framework bug
    private Table<String, String, Integer> getDocumentTable() {
        Table<String, String, Integer> toReturn = HashBasedTable.create();
        for( int i=0; i < weReportsList.size(); i++) {
            WebElement currentWebElement = weReportsList.get(i);
            String uploadName;
            try {
                isVisible(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i+1)), true);
                uploadName = currentWebElement.findElement(By.xpath(UPLOAD_NAME_XPATH)).getText();
            } catch ( StaleElementReferenceException sere) {
                isVisible(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i+1)), true);
                uploadName = getText(REPORT_CONTAINER_XPATH.replace("${replaceIndex}$", String.valueOf(i+1)));
            }
//            if ( uploadName.contains(user.getFirstName()) )
//            toReturn.put("Borrower", uploadName.replace(user.getFirstName() + " - ", ""), i+1);
            toReturn.put("Borrower", uploadName, i+1);
        }

        return toReturn;
    }

}
