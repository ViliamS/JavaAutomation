package com.r2development.leveris.selenium.borrower.pageobjects;

import com.google.inject.Inject;
import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetApprovalSection extends Borrower implements IGetApprovalSection {

    private static final Log log = LogFactory.getLog(GetApprovalSection.class);

    @FindBy( xpath = GET_APPROVAL_SECTION_XPATH )
    protected WebElement weGetApprovalSection;

    @FindBy( xpath = GET_APPROVAL_TITLE_XPATH )
    protected WebElement weGetApprovalTitle;

    @FindBy( xpath = GET_APPROVAL_TEXT_XPATH )
    protected WebElement weGetApprovalText;

    @FindBy( xpath = GET_APPROVAL_DOCS_LINK_XPATH )
    protected WebElement weGetApprovalDocs;

    @FindBy( xpath = GET_APPROVAL_GET_A_QUOTE_XPATH )
    protected WebElement weGetApprovalQuote;

    @FindBy( xpath = GET_APPROVAL_INVITE_COAPPLICANT_START_TASK_XPATH )
    protected WebElement weGetApprovalCoApplicantStartTask;

    @FindBy( xpath = GET_APPROVAL_INVITE_COAPPLICANT_XPATH )
    protected WebElement weGetApprovalCoApplicant;

    @FindBy( xpath = INVITE_COAPPLICANT_XPATH )
    protected WebElement weInviteCoApplicant;

    @FindBy( xpath = GO_SOLO_XPATH )
    protected WebElement weGoSolo;

    @FindBy( xpath = READY_TO_REVIEW_AND_SUBMIT_BUTTON_XPATH )
    protected WebElement weReadyToReviewAndSubmit;

    @FindBy( xpath = GET_APPROVAL_INFO_UPLOAD_XPATH )
    protected WebElement weGetApprovalInfoUpload;

    @FindBy( xpath = WHAT_DOCS_XPATH )
    protected WebElement weDocs;

    @FindBy( xpath = WHAT_DOCS_CLOSE_XPATH )
    protected WebElement weDocsClose;

    //a[@wicketpath='main_c_form_form_root_c_w_pnlContent_c_w_btnSubmitApplication_submit']
    @FindBy( xpath = GET_APPROVAL_SUBMIT_YOUR_APPLICATION_XPATH )
    protected WebElement weSubmitYourApplication;

    //label[@wicketpath='main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkDistanceMarketing_label']/following-sibling::span/a
    @FindBy( xpath = GET_APPROVAL_CHECK_DISTANCE_MARKETING_XPATH )
    protected WebElement weCheckDistanceMarketing;

    //label[@wicketpath='main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkStatutory_label']/following-sibling::span/a
    @FindBy( xpath = GET_APPROVAL_CHECK_STATUTORY_XPATH )
    protected WebElement weCheckStatutory;

    //label[@wicketpath='main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkDeclarations_label']/following-sibling::span/a
    @FindBy( xpath = GET_APPROVAL_CHECK_DECLARATION_XPATH )
    protected WebElement weCheckDeclaration;

    //a[@wicketpath='application" main_c_form_form_root_c_w_btnSubmitApplication_submit']
    @FindBy( xpath = GET_APPROVAL_FINAL_SUBMIT_APPLICATION_XPATH )
    protected WebElement weFinalSubmitApplication;

    //h2[@wicketpath='main_c_form_form_root_c_w_pnl-YourAppHasBeenSubmitted_c_w_lbl-YourAppHasBeenSubmittedTitle']
    @FindBy( xpath = GET_APPROVAL_CONFIRMATION_XPATH )
    protected WebElement weConfirmation;

    @Inject
    public GetApprovalSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getGetApprovalTitle() {
        isVisible(GET_APPROVAL_TITLE_XPATH, true);
        return weGetApprovalTitle.getText();
    }

    @Override
    public String getGetApprovalText() {
        isVisible(GET_APPROVAL_TEXT_XPATH, true);
        return weGetApprovalText.getText();
    }

    @Override
    public void clickWhatDocs() {
        isVisible(GET_APPROVAL_DOCS_LINK_XPATH, true);
        weGetApprovalDocs.click();
        isVisible(WHAT_DOCS_CONTAINER_XPATH, true);
    }

    @Override
    public void closeWhatDocs() {
        isVisible(WHAT_DOCS_CLOSE_XPATH, true);
        weDocsClose.click();
    }

    @Override
    public void closePopup() {
        isVisible(POPUP_CLOSE_XPATH, true, 10);
        clickElement(POPUP_CLOSE_XPATH);
    }

    @Override
    public IBuildQuotationPage clickGetAQuote() {
        isVisible(GET_APPROVAL_GET_A_QUOTE_XPATH, true, 5);
        weGetApprovalQuote.click();
        return new BuildQuotationPage(webDriver);
    }

    @Override
    public IPersonalDetailsPage clickInfoUpload() {
//        isVisible(GET_APPROVAL_INFO_UPLOAD_XPATH, false, 15);
//        weGetApprovalInfoUpload.click();
        clickElementViaJavascript(GET_APPROVAL_INFO_UPLOAD_XPATH);
        return new PersonalDetailsPage(webDriver);
    }

    @Override
    public IGetApprovalSection clickReviewAndSubmit() {
//        isVisible(READY_TO_REVIEW_AND_SUBMIT_BUTTON_XPATH, true, 15);
//        getWebElement(READY_TO_REVIEW_AND_SUBMIT_BUTTON_XPATH).click();
        clickElementViaJavascript(READY_TO_REVIEW_AND_SUBMIT_BUTTON_XPATH);
        return this;
    }

    @Override
    public boolean isLoaded() {
        isVisible(GET_APPROVAL_GET_A_QUOTE_XPATH, true);
        isVisible(GET_APPROVAL_INVITE_COAPPLICANT_XPATH, true);
        isVisible(GET_APPROVAL_INFO_UPLOAD_XPATH, true);
        return true;
    }

    @Override
    public IGetApprovalSection clickSubmitYourApplication() {
//        #    And user clicks "Submit your application" //a[@wicketpath='main_c_form_form_root_c_w_pnlContent_c_w_btnSubmitApplication_submit']
//        isVisible(GET_APPROVAL_SUBMIT_YOUR_APPLICATION_XPATH, true);
//        getWebElement(GET_APPROVAL_SUBMIT_YOUR_APPLICATION_XPATH).click();
//        weSubmitYourApplication.click();
        clickElementViaJavascript(GET_APPROVAL_SUBMIT_YOUR_APPLICATION_XPATH);
        return this;
    }

    @Override
    public IGetApprovalSection checkDistanceMarketing() {
//        #    And user checks... label main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkDistanceMarketing_label following-sibling::span/a
        isVisible(GET_APPROVAL_CHECK_DISTANCE_MARKETING_XPATH, true);
//        getWebElement(GET_APPROVAL_CHECK_DISTANCE_MARKETING_XPATH).click();
        clickElement(GET_APPROVAL_CHECK_DISTANCE_MARKETING_XPATH);
//        weCheckDistanceMarketing.click();
        return this;
    }

    @Override
    public IGetApprovalSection checkStatutory() {
//        #    And user checks... label main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkStatutory_label
        isVisible(GET_APPROVAL_CHECK_STATUTORY_XPATH, true);
        getWebElement(GET_APPROVAL_CHECK_STATUTORY_XPATH).click();
//        weCheckStatutory.click();
        return this;
    }

    @Override
    public IGetApprovalSection checkDeclaration() {
//        #    And user checks... label main_c_form_form_root_c_w_pnlBeforeSubmit_c_w_chkDeclarations_label
        isVisible(GET_APPROVAL_CHECK_DECLARATION_XPATH, true);
        getWebElement(GET_APPROVAL_CHECK_DECLARATION_XPATH).click();
//        weCheckDeclaration.click();
        return this;
    }

    @Override
    public IGetApprovalSection clickFinalSubmitApplication() {
//        #  main_c_form_form_root_c_w_pnl-YourAppHasBeenSubmitted_c_w_lbl-YourAppHasBeenSubmittedTitle
//        #    And user clicks "Submit a[@wicketpath='application" main_c_form_form_root_c_w_btnSubmitApplication_submit']
        isVisible(GET_APPROVAL_FINAL_SUBMIT_APPLICATION_XPATH, true);
//        getWebElement(GET_APPROVAL_FINAL_SUBMIT_APPLICATION_XPATH).click();
        clickElement(GET_APPROVAL_FINAL_SUBMIT_APPLICATION_XPATH);
        isVisible(GET_APPROVAL_CONFIRMATION_XPATH, true);
        isVisible("//div[@wicketpath='main_c_form_form_root_c_w_pnl-YourAppHasBeenSubmitted_c_w_lbl-YourAppHasBeenSubmittedTitle_l' and contains(., 'Your application has been sent')]");
//        isVisible("//div[@wicketpath='main_c_form_embeddedFormWrapper_embeddedForm_1_form_root_c_w_pnlQuote_c_w_lblQuoteDescription']", true);
//        isVisible("//div[@wicketpath='main_c_form_embeddedFormWrapper_embeddedForm_2_form_root_c_w_pnlCoapplicant_c_w_lblCoapplicantDescription']", true);
//        isVisible("//div[@wicketpath='main_c_form_embeddedFormWrapper_embeddedForm_3_form_root_c_w_pnlForms_c_w_lblFormsDescription']", true);

//        Har har = ApiSupportWebDriverStepDef.getProxyInstance().getHar();
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        File harFile = new File("/Users/anthonymottot/Automation/Git/qa_automation/Aut-Abakus/Borrower/target/Har-Borrower-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//        try {
//            har.writeTo(harFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        weFinalSubmitApplication.click();
        return this;
    }


}
