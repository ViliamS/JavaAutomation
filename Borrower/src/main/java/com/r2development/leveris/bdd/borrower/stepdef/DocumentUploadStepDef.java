package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Inject;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.selenium.borrower.pageobjects.DocumentUploadPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IBorrowerHomePage;
import com.r2development.leveris.selenium.borrower.pageobjects.IDocumentUploadPage;
import com.r2development.leveris.selenium.borrower.pageobjects.IPersonalDetailsPage;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

//@Singleton
public class DocumentUploadStepDef /*extends BorrowerStepDef*/ implements CLV312Workaround {

    private static final Log log = LogFactory.getLog(DocumentUploadStepDef.class.getName());

    enum DOCUMENT {
        PROOF_IDENTITY,
        PROOF_ADDRESS,
        MARRIAGE_CERTIFICATE,
        P60,
        CERTIFIED_ACCOUNT_LAST_YEAR,
        CERTIFIED_ACCOUNT_PREVIOUS_LAST_YEAR,
        CURRENT_PAYSLIP,
        PREVIOUS_PAYSLIP,
        SALARY_CERTIFICATE,
        CONFIRMATION_TAX_AFFAIRS,
        CURRENT_ACCOUNT,
        CREDIT_CARD_PROVIDER

    }
    @Inject
    IUser user;
    private IDocumentUploadPage documentUploadPage;
    private IBorrowerHomePage borrowerHomePage;
    private IPersonalDetailsPage borrowerPersonalDetailsPage;
//    private final WebDriver webDriver;

    @Inject
    DocumentUploadStepDef(SharedDriver_Borrower webDriver/*, IUser user*/) {
//        super(webDriver);
//        documentUploadPage = new DocumentUploadPage(WebDriverService.getWebDriverInstance(), user);
//        this.webDriver = webDriver;
//        this.user = user;
//        documentUploadPage = new DocumentUploadPage(webDriver, user);
        documentUploadPage = new DocumentUploadPage(webDriver);
    }

    @When("^Borrower clicks on \"documents list\"$")
    public void user_clicks_on_documents_list() {
        documentUploadPage.clickDocumentsList();
    }

    @When("^Borrower clicks on \"DOWNLOAD CERT\"$")
    public void user_clicks_on_download_cert() {
        documentUploadPage.clickDownloadCert();
    }

    @When("^(Borrower) upload(?:s) the file (.*) as (.*) document$")
    public void user_uploads_document(String userType, String filename, String documentType) {
        documentUploadPage.uploadDocument(user, userType, filename, documentType); // TODO to review : not nice, but temporary solution to go forward .
//        documentUploadPage.uploadDocument(userType, filename, documentType);
    }

    @When("^Borrower uploads all documents$")
    public void upload_all_documents() throws InterruptedException {
//        workaroundCLV312(null);
//        documentUploadPage = new DocumentUploadPage(WebDriverService.getWebDriverInstance(), user);
//        documentUploadPage = new DocumentUploadPage(webDriver, user);
//        documentUploadPage.uploadAllDocuments(user);
        documentUploadPage.getTitle();
        documentUploadPage.uploadAllDocuments();
    }

    @Override
    public void workaroundCLV312(String borrowerOrCoapplicant) {
        borrowerHomePage.clickInfoUpload();

        boolean toGoOn = false;
        while ( !toGoOn ) {
            try {
                borrowerPersonalDetailsPage.clickDocumentUpload();
                documentUploadPage.getTitle();
                toGoOn = true;
            } catch ( TimeoutException te) {
                log.debug("Problem of clicking on Document Upload link or getting the document upload title.");
            }
        }
    }
}
