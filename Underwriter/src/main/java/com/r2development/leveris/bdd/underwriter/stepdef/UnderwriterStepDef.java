package com.r2development.leveris.bdd.underwriter.stepdef;

import com.google.inject.Inject;

import com.r2development.leveris.bdd.underwriter.model.RiskToolData;
import com.r2development.leveris.bdd.underwriter.model.SearchFiltersData;
import com.r2development.leveris.bdd.underwriter.model.SortByData;
import com.r2development.leveris.selenium.underwriter.pageobjects.*;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.*;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.RiskToolDialogs.*;
import com.r2development.leveris.utils.Enums.*;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UnderwriterStepDef {

    private static final Log log = LogFactory.getLog(UnderwriterStepDef.class.getName());

    private WebDriver webdriver;

    private ILoginPage loginPage;
    private IApplicationListPage applicationListPage;
    private IApplicationListPageSearchSection applicationListPageSearchSection;
    private ISessionListPage sessionListPage;
    private IApplicationProcessesList processesListPage;
    private ISideMenu sideMenu;
    private IProfilePage profilePage;
    private ILoanApplicationPage loanApplicationPage;
    private ILoanOfferToolSection loanOfferToolSection;
    private IDocumentsSection documentsSection;
    private IRiskToolSection riskToolSection;
    private IDocumentsDetail documentsDetail;
    private IDocumentsDetailEditSection documentsDetailEditSection;
    private ISetFICODialog setFICODialog;
    private ISetAMLDialog setAMLDialog;
    private ISetFraudDialog setFraudDialog;
    private IRepeatCustomerDialog repeatCustomerDialog;
    private ISetScoreOverrideDialog setScoreOverrideDialog;
    private IAddNoteDialog addNoteDialog;
    private IWorkflowSection workflowSection;

    @Inject
    public UnderwriterStepDef(SharedDriver webDriver) {
        this.webdriver = webDriver;
        this.loginPage = new LoginPage(webDriver);
        this.applicationListPage = new ApplicationListPage(webDriver);
        this.sessionListPage = new SessionListPage(webDriver);
        this.processesListPage = new ApplicationProcessesList(webDriver);
        this.sideMenu = new SideMenu(webDriver);
        this.profilePage = new ProfilePage(webDriver);
        this.loanApplicationPage = new LoanApplicationPage(webDriver);
        this.applicationListPageSearchSection = new ApplicationListPageSearchSection(webDriver);
        this.loanOfferToolSection = new LoanOfferToolSection(webDriver);
        this.documentsSection = new DocumentsSection(webDriver);
        this.riskToolSection = new RiskToolSection(webDriver);
        this.documentsDetail = new DocumentsDetail(webDriver);
        this.documentsDetailEditSection = new DocumentsDetailEditSection(webDriver);
        this.setFICODialog = new SetFICODialog(webDriver);
        this.setAMLDialog = new SetAMLDialog(webDriver);
        this.setFraudDialog = new SetFraudDialog(webDriver);
        this.repeatCustomerDialog = new RepeatCustomerDialog(webDriver);
        this.setScoreOverrideDialog = new SetScoreOverrideDialog(webDriver);
        this.addNoteDialog = new AddNoteDialog(webDriver);
        this.workflowSection = new WorkflowSection(webDriver);
    }

    @Given("^Go to Underwriter Login Page$")
    public void go_to_underwriter_login_page() {
        log.info("Go to Underwriter Login Page");
        loginPage.goToUnderwriterLoginPage();
    }

    @And("^Underwriter types username : \"(.*)\"$")
    public void underwriter_types_username(String userName) {
        log.info("Underwriter types username : \"" + userName + "\"");
        loginPage.setUsername(userName);
    }

    @And("^Underwriter types password : \"(.*)\"$")
    public void underwriter_types_password(String password) {
        log.info("Underwriter types password : \"" + password + "\"");
        loginPage.setPassword(password);
    }

    @Then("^Underwriter clicks on Login button$")
    public void underwriter_clicks_on_login_button() {
        log.info("Underwriter clicks on Login button");
        loginPage.clickLogin();
    }

    @And("^Underwriter login as user : \"(.*)\" with password : \"(.*)\"$")
    public void underwriter_login_as_user_with_password(String username, String password) {
        log.info("Underwriter login as user : \"" + username + "\" with password : \"" + password + "\"");
        underwriter_types_username(username);
        underwriter_types_password(password);
        underwriter_clicks_on_login_button();
        underwriter_has_successfully_logged_in();
    }

    @And("^Underwriter has successfully logged in$")
    public void underwriter_has_successfully_logged_in() {
        log.info("Underwriter has successfully logged in");
        applicationListPage.isTitleApplicationListPresent();
    }

    @And("^Underwriter sets filters and triggers the search$")
    public void underwriter_sets_filters_and_triggers_the_search(List<String> searchFiltersData) {
        log.info("Underwriter sets filters and triggers the search");

        for (Map.Entry<String, String> setFiltersMapEntry : new SearchFiltersData(searchFiltersData).getData().entrySet()) {
            log.info("setFilterMapEntry | " + setFiltersMapEntry.getKey() + " | " + setFiltersMapEntry.getValue() + " |");

            switch (SEARCHFILTERS.getFilter(setFiltersMapEntry.getKey())) {

                case ASSIGNED:
                    underwriter_sets_assigned_filter_to(setFiltersMapEntry.getValue());
                    break;

                case CASE:
                    underwriter_sets_case_filter_to(setFiltersMapEntry.getValue());
                    break;

                case STATUS:
                    underwriter_sets_status_filter_to(setFiltersMapEntry.getValue());
                    break;

                case SEARCH_TEXT:

                    underwriter_sets_search_text_filter_to(setFiltersMapEntry.getValue());
                    break;

                case APPLICATION_ID:
                    underwriter_sets_application_id_filter_to(setFiltersMapEntry.getValue());
                    break;
            }
        }
        applicationListPage.search();
    }

    @And("^Underwriter sets (Assigned|Case|Status|Search Text|Application ID) Filter to : \"(.*)\"$")
    public void underwriter_sets_any_filter_to(String filterType, String filter) {
        log.info("Underwriter sets " + filterType + " Filter to : \"" + filter + "\"");

        switch (SEARCHFILTERS.getFilter(filterType)) {

            case ASSIGNED:
                underwriter_sets_assigned_filter_to(filter);
                break;

            case CASE:
                underwriter_sets_case_filter_to(filter);
                break;

            case STATUS:
                underwriter_sets_status_filter_to(filter);
                break;

            case SEARCH_TEXT:
                underwriter_sets_search_text_filter_to(filter);
                break;

            case APPLICATION_ID:
                underwriter_sets_application_id_filter_to(filter);
                break;
        }
    }

    @And("^Underwriter sets Assigned Filter : \"(.*)\"$")
    public void underwriter_sets_assigned_filter_to(String filter) {
        log.info("Underwriter sets Assigned Filter : \"" + filter + "\"");
        applicationListPage.setAssignedFilter(filter);
    }

    @And("^Underwriter sets Case Filter : \"(.*)\"$")
    public void underwriter_sets_case_filter_to(String filter) {
        log.info("Underwriter sets Case Filter : \"" + filter + "\"");
        applicationListPage.setCaseFilter(filter);
    }

    @And("^Underwriter sets Status Filter : \"(.*)\"$")
    public void underwriter_sets_status_filter_to(String filter) {
        log.info("Underwriter sets Status Filter : \"" + filter + "\"");
        applicationListPage.setStatusFilter(filter);
    }

    @And("^Underwriter sets Search Text Advanced Filter : \"(.*)\"$")
    public void underwriter_sets_search_text_filter_to(String filter) {
        log.info("Underwriter sets Search Text Advanced Filter : \"" + filter + "\"");
        applicationListPage.showAdvancedOptions();
        applicationListPage.setSearchTextAdvancedFilter(filter);
    }

    @And("^Underwriter sets Application ID Advanced Filter : \"(.*)\"$")
    public void underwriter_sets_application_id_filter_to(String filter) {
        log.info("Underwriter sets Application ID Advanced Filter : \"" + filter + "\"");
        applicationListPage.showAdvancedOptions();
        applicationListPage.setApplicationIdAdvancedFilter(filter);
    }

    @And("^Underwriter click on (Show|Hide) advanced options$")
    public void underwriter_click_on_advanced_options(String showHide) {
        log.info("Underwriter click on " + showHide + " advanced options");
        switch (showHide) {

            case "Show":
                applicationListPage.showAdvancedOptions();
                break;

            case "Hide":
                applicationListPage.hideAdvancedOptions();
                break;
        }
    }

    @And("^Underwriter clicks on (Show advanced options|Hide advanced options|Process list|Sessions list|Search)$")
    public void underwriter_clicks_on(String whatToClickOn) {
        log.info("Underwriter clicks on " + whatToClickOn);
        String showHide = whatToClickOn.substring(0, 4);
        switch (whatToClickOn) {

            case "Show advanced options":
                underwriter_click_on_advanced_options(showHide);
                break;

            case "Hide advanced options":
                underwriter_click_on_advanced_options(showHide);
                break;

            case "Process list":
                processesListPage = applicationListPage.clickProcessList();
                break;

            case "Sessions list":
                sessionListPage = applicationListPage.clickSessionList();
                break;

            case "Search":
                applicationListPage.search();
                break;
        }
    }

    @And("^Underwriter wants to Sort By (creation|stage submission) date$")
    public void underwriter_wants_to_sort_by(String sortBy) {
        log.info("Underwriter wants to Sort By " + sortBy + " date");
        switch (sortBy) {

            case "creation":
                applicationListPage.sortByCreationDate();
                break;

            case "stage submission":
                applicationListPage.sortByStageSubmissionDate();
                break;
        }
    }

    @And("^Underwriter sets SORT BY and sorting order")
    public void underwriter_sets_sorting(List<String> searchFiltersData) {
        log.info("Underwriter sets SORT BY and sorting order");
        SortByData sortByData = new SortByData(searchFiltersData);
        for (Map.Entry<SORTBY, SORT> mapEntry : sortByData.getData().entrySet()) {
            underwriter_wants_to_sort_by(mapEntry.getKey().getString());
            underwriter_wants_to_sort_results(mapEntry.getValue().getString());
        }
    }

    @And("^Underwriter clicks on (creation|stage submission) date to Sort results (ascendant|descendant)$")
    public void underwriter_clicks_on_date_to_sort_results(String sortBy, String ascendantOrDescendant) {
        log.info("Underwriter clicks on " + sortBy + " date to Sort results " + ascendantOrDescendant + "");
        underwriter_wants_to_sort_by(sortBy);
        underwriter_wants_to_sort_results(ascendantOrDescendant);
    }

    @And("^Underwriter wants to sort results (ascendant|descendant)$")
    public void underwriter_wants_to_sort_results(String ascendantOrDescendant) {
        log.info("Underwriter wants to sort results " + ascendantOrDescendant + "");
        switch (ascendantOrDescendant) {

            case "ascendant":
                applicationListPage.sortByAscendant();
                break;

            case "descendant":
                applicationListPage.sortByDescendant();
                break;
        }
    }

    @And("^Underwriter opens Loan Application with name : \"(.*)\"$")
    public void underwriter_opens_loan_application_with_name(String loanApplicationName) {
        log.info("Underwriter opens Loan Application with name : \"" + loanApplicationName + "\"");
        applicationListPageSearchSection.openLoanApplicationContainingName(loanApplicationName);
        underwriter_hideUnhide_the_section(ACTION.HIDE.get(), LOANAPPSECTIONS.WORKFLOW.getSectionName());
    }

    @And("^Underwriter clicks on Start button of Loan Application with name : \"(.*)\"$")
    public void underwriter_clicks_on_start_button_loan_application_with_name(String loanApplicationName) {
        log.info("Underwriter clicks on Start button of Loan Application with name : \"" + loanApplicationName + "\"");
        applicationListPageSearchSection.startLoanApplication(loanApplicationName);
    }

    @And("^Underwriter click on (Application|Profile|Notifications|Messages) in left side menu$")
    public void underwriter_clicks_on_something_in_left_side_menu(String clickOnWhat) {
        log.info("Underwriter click on " + clickOnWhat + " in left side menu");

        switch (clickOnWhat) {

            case "Application":
                sideMenu.clickApplication();
                break;

            case "Profile":
                sideMenu.clickProfile();
                break;

            case "Notifications":
                sideMenu.clickNotifications();
                break;

            case "Messages":
                sideMenu.clickMessages();
                break;
        }
    }

    @And("^Underwriter logouts from application$")
    public void underwriter_logouts_from_application() {
        log.info("Underwriter logouts from application");
        underwriter_clicks_on_something_in_left_side_menu("Profile");
        profilePage.isProfilePageTitlePresent();
        profilePage.clickLogout();
    }

    @And("^Underwriter (hide|unhide) the (Workflow|Finance Tool|Loan Offer Tool|Form Tools|Documents|Documents2|Notes|Risk Tool|Update History) section$")
    public void underwriter_hideUnhide_the_section(String stringAction, String section) throws IllegalArgumentException{
        log.info("Underwriter (" + stringAction + ") the (" + section + ") section");

        if (!(ACTION.HIDE.get().equalsIgnoreCase(stringAction)))
            if(!(ACTION.UNHIDE.get().equalsIgnoreCase(stringAction)))
                Assert.assertTrue("\n ASSERTION ERROR \n Only supported action to use are : '" + ACTION.HIDE.get() + "' and '" + ACTION.UNHIDE.get() + "' but actual is ---> '" + stringAction + "'\n", false);

        loanApplicationPage.sectionHideUnhide(LOANAPPSECTIONS.getFilter(section), ACTION.getAction(stringAction));
    }

    @And("^Underwriter opens document number \"(.*)\" and starts editing$")
    public void underwriter_opens_document_number_in_documents_section(String number){
        underwriter_hideUnhide_the_section(ACTION.UNHIDE.get(), LOANAPPSECTIONS.DOCUMENTS.getSectionName());
        loanApplicationPage.openDocument(number);
    }

    @And("^Underwriter clicks on Edit link $")
    public void underwriter_clicks_on_edit_link(){
        documentsDetail.clickEdit();
    }

    @And("^Underwriter set (Document Type|Document subtype|Expiry Date|Tag|Underwriting Status) for currently opened document$")
    public void underwriter_sets_property_of_currently_opened_document(String whatToSet){

    }

    @And("^Underwriter validates all documents$")
    public void underwriter_validates_all_documents(){

        underwriter_hideUnhide_the_section(ACTION.UNHIDE.get(), LOANAPPSECTIONS.DOCUMENTS.getSectionName());

        int i = documentsSection.getNumberOfUploadedDocuments();

        for (int x = 0; x < i; x++) {
            log.info("\n -------------------------------------- \n | Document with index '" + x + "' | \n Setting Underwriting status to ---> " + UNDERWRITINGSTATUS.ACCEPTED.getUWStatus() + " <--- | \n -------------------------------------- \n");

            documentsSection.openDocument(x);
            underwriter_clicks_on_edit_link();
            log.info("DocumentType ---> " + documentsDetailEditSection.getDocumentTypeText());
            String documentTypeCode = documentsDetailEditSection.getDocumentTypeText();
            LinkedList<DOCUMENTTYPE> list = DOCUMENTTYPE.getEnumValues();

            for (DOCUMENTTYPE entry : list){
                log.info("DOCUMENTTYPE entry ---> '" + entry + "'");

                if(entry.getDocumentCode().equalsIgnoreCase(documentTypeCode)){
                    LinkedList<String> listOfSubTypes = DocumentSubTypesMap.getDocumentSubType(entry.getDocumentType());
                    log.info("\n listOfSubTypes ---> '" + listOfSubTypes + "'");

                    if(!listOfSubTypes.getFirst().equalsIgnoreCase("None"))
                            documentsDetailEditSection.setDocumentSubType(listOfSubTypes.getFirst());
                }
            }
            documentsDetailEditSection.setUnderwritingStatus(UNDERWRITINGSTATUS.ACCEPTED.getUWStatus());
            documentsDetailEditSection.clickSave();
            documentsDetail.clickCloseX();
            documentsSection.isDocumentInExpectedStatus(UNDERWRITINGSTATUS.ACCEPTED, i);
        }

        underwriter_hideUnhide_the_section(ACTION.HIDE.get(), LOANAPPSECTIONS.DOCUMENTS.getSectionName());
    }

    @And("^Underwriter goes to Workflow section and Completes Validation Stage 1$")
    public void underwriter_goes_to_workflow_section_and_completes_validation(){
        log.info("Underwriter goes to Workflow section and Completes Validation");
        underwriter_hideUnhide_the_section(ACTION.UNHIDE.get(), LOANAPPSECTIONS.WORKFLOW.getSectionName());
        workflowSection.checkBox1(ACTION.CHECK.get());
        workflowSection.checkBox2(ACTION.CHECK.get());
        workflowSection.checkBox3(ACTION.CHECK.get());
        workflowSection.clickCompleteValidation();
        underwriter_hideUnhide_the_section(ACTION.HIDE.get(), LOANAPPSECTIONS.WORKFLOW.getSectionName());
    }

    @And("^Underwriter Manually sets KYC Check status to (Green|Amber|Red) and click Save$")
    public void underwriter_manually_sets_kyc_check_status_to_value(String status){
        log.info("Underwriter Manually sets KYC Check status to '" + status + "'");
        underwriter_in_risk_tool_section_checkOrUncheck_manually_update_checkbox(ACTION.CHECK.get());
        riskToolSection.setStatusDropDown(status);
        riskToolSection.clickSaveKYC();
        underwriter_hideUnhide_the_section(ACTION.HIDE.get(), LOANAPPSECTIONS.RISK_TOOL.getSectionName());
    }

    @And("^Underwriter in Risk Tool section (check|uncheck) Manually update checkbox$")
    public void underwriter_in_risk_tool_section_checkOrUncheck_manually_update_checkbox(String checkOrUncheck){
        log.info("Underwriter in Risk Tool section '" + checkOrUncheck + "' Manually update checkbox");

        ACTION actionCheckOrUncheck = ACTION.getAction(checkOrUncheck);
        underwriter_hideUnhide_the_section(ACTION.UNHIDE.get(), LOANAPPSECTIONS.RISK_TOOL.getSectionName());

        switch (actionCheckOrUncheck){
            case CHECK:
                riskToolSection.setManuallyUpdateCheckbox(ACTION.CHECK);
                break;

            case UNCHECK:
                riskToolSection.setManuallyUpdateCheckbox(ACTION.UNCHECK);
                break;
        }
    }

//    @And("^Underwriter goes to Risk Tool section and Finishes KYC Check$")
//    public void underwriter_goes_to_risk_tool_section_and_completes_kyc_checks(){
//        log.info("Underwriter goes to Risk Tool section and Finishes KYC Check");
//        underwriter_manually_sets_kyc_check_status_to_value("Green");
//    }

    @And("^Underwriter Sign the Loan Offer$")
    public void underwriter_goes_to_loan_offer_tool_and(){
        log.info("Underwriter Sign the Loan Offer");
        underwriter_hideUnhide_the_section(ACTION.UNHIDE.get(), LOANAPPSECTIONS.LOAN_OFFER_TOOL.getSectionName());

        Assert.assertFalse("There was displayed a message 'WARNING:\n" +
                "Score card was not fully set-up yet!'", loanOfferToolSection.isScoreWarningDisplayed());

        loanOfferToolSection.clickEditReview();

        loanOfferToolSection.selectLoanOfferVersionLatest();

        loanOfferToolSection.clickSaveOffer();

        loanOfferToolSection.addComment("Underwriter Sign the Loan Offer");

        loanOfferToolSection.clickSignReview();

    }


    @And("^Underwriter does (Set FICO|Set AML|Set Fraud|Set rep. customer|Set score override|Set note) part of KYC check$")
    public void underwriter_does_kyc_check(String partToDo, List<String> list){

        underwriter_hideUnhide_the_section(ACTION.UNHIDE.get(), LOANAPPSECTIONS.RISK_TOOL.getSectionName());

        log.info("Underwriter does '"+ partToDo +"' part of KYC check");
        RiskToolData riskToolData = new RiskToolData(list);

        switch (partToDo){

            case "Set FICO":
                riskToolSection.clickSetFICO();
                if (!StringUtils.isEmpty(riskToolData.getFICO()))
                    setFICODialog.setFICO(riskToolData.getFICO());
                if (!StringUtils.isEmpty(riskToolData.getTicketId()))
                    setFICODialog.setTicketID(riskToolData.getTicketId());
                if (!StringUtils.isEmpty(riskToolData.getComment()))
                    setFICODialog.setComment(riskToolData.getComment());
                setFICODialog.clickSave();
                break;

            case "Set AML":
                riskToolSection.clickSetAML();
                if (!StringUtils.isEmpty(riskToolData.getAML()))
                    setAMLDialog.setAMLcombobox(riskToolData.getAML());
                if (!StringUtils.isEmpty(riskToolData.getTicketId()))
                    setAMLDialog.setTicketId(riskToolData.getTicketId());
                if (!StringUtils.isEmpty(riskToolData.getComment()))
                    setAMLDialog.setComment(riskToolData.getComment());
                setAMLDialog.clickSave();
                    break;

            case "Set Fraud":
                riskToolSection.clickSetFraud();
                if (!StringUtils.isEmpty(riskToolData.getFraud()))
                    setFraudDialog.setFraud(riskToolData.getFraud());
                if (!StringUtils.isEmpty(riskToolData.getTicketId()))
                    setFraudDialog.setTickedId(riskToolData.getTicketId());
                if (!StringUtils.isEmpty(riskToolData.getComment()))
                    setFraudDialog.setComment(riskToolData.getComment());
                setFraudDialog.clickSave();
                break;

            case "Set rep. customer":
                riskToolSection.clickSetRepCustomer();
                if (!StringUtils.isEmpty(riskToolData.getRepeatCustomer()))
                    repeatCustomerDialog.setRepeatCustomerInput(riskToolData.getRepeatCustomer());
                repeatCustomerDialog.clickSave();
                break;

            case "Set score override":
                riskToolSection.clickSetScoreOverride();
                if (!StringUtils.isEmpty(riskToolData.getScore()))
                    setScoreOverrideDialog.setValue(riskToolData.getScore());
                if (!StringUtils.isEmpty(riskToolData.getNote()))
                    setScoreOverrideDialog.setNote(riskToolData.getNote());
                setScoreOverrideDialog.clickSave();
                break;

            case "Set note":
                riskToolSection.clickSetNote();
                if (!StringUtils.isEmpty(riskToolData.getNote()))
                    addNoteDialog.setNote(riskToolData.getNote());
                addNoteDialog.clickSave();
                break;
        }
    }

}