package com.r2development.leveris.bdd.borrower.stepdef;

import com.google.inject.Singleton;
import com.r2development.leveris.selenium.borrower.pageobjects.DocumentUploadPage;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

@Singleton
public class DocumentUploadStepDef extends BorrowerStepDef implements CLV312Workaround {

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

    private static final Log log = LogFactory.getLog(DocumentUploadStepDef.class);

    DocumentUploadStepDef() {
        documentUploadPage = new DocumentUploadPage(WebDriverService.getWebDriverInstance(), user);
    }

    @When("^user clicks on \"documents list\"$")
    public void user_clicks_on_documents_list() {
        documentUploadPage.clickDocumentsList();
    }

    @When("^user clicks on \"DOWNLOAD CERT\"$")
    public void user_clicks_on_download_cert() {
        documentUploadPage.clickDownloadCert();
    }

    @When("^(Borrower|Coapplicant|Borrower and Coapplicant) user upload(?:s) the file (.*) as (.*) document$")
    public void user_uploads_document(String userType, String filename, String documentType) {
        documentUploadPage.uploadDocument(user, userType, filename, documentType); // TODO to review : not nice, but temporary solution to go forward .
//        documentUploadPage.uploadDocument(userType, filename, documentType);
    }

    @When("^Upload all documents$")
    public void upload_all_documents() throws InterruptedException {
        workaroundCLV312(null);
        documentUploadPage = new DocumentUploadPage(WebDriverService.getWebDriverInstance(), user);
//        documentUploadPage.uploadAllDocuments(user);
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
