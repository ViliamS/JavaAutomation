package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.ILoanApplicationPage;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IApplicationListPage {

    String TITLE_APPLICATION_LIST = getXPath(h2, equals, text, "Application List");
    String ASSIGNED_FILTER = getXPath(div, equals, dataPath, "cmbAssignedApplication") + getXPath_HasADescendant(label, equals, text, "ASSIGNED") + getXPath(singleSlash, input);//equalsTo(div, dataPath, "cmbAssignedApplication") + hasAsChild(equalsTo(label, text, "ASSIGNED")) + element(singleSlash, input);
    String ASSIGNED_FILTER_BUTTON = getXPath_DivEqualsDataPath("cmbAssignedApplication") + getXPath_DirectSibling(button);//equalsTo(div, dataPath, "cmbAssignedApplication") + followingElement(button);
    String CASE_FILTER = getXPath_DivEqualsDataPath("cmbCase") + getXPath_HasADescendantLabelEqualsText("CASE") + getXPath_DirectSibling(input);//equalsTo(div, dataPath, "cmbCase") + hasAsChild(equalsTo(label, text, "CASE")) + element(singleSlash, input);
    String CASE_FILTER_BUTTON = getXPath_DivEqualsDataPath("cmbCase") + getXPath_DirectSibling(button);//equalsTo(div, dataPath, "cmbCase") + followingElement(button);
    String STATUS_FILTER = getXPath_DivEqualsDataPath("pnlStatusColoan cmbStatusFilter") + getXPath_HasADescendantLabelEqualsText("STATUS") + getXPath_DirectSibling(input);//equalsTo(div, dataPath, "pnlStatusColoan cmbStatusFilter") + hasAsChild(equalsTo(label, text, "STATUS")) + element(singleSlash, input);
    String STATUS_FILTER_BUTTON = getXPath_DivEqualsDataPath("pnlStatusColoan cmbStatusFilter") + getXPath_DirectSibling(button);//equalsTo(div, dataPath, "pnlStatusColoan cmbStatusFilter") + followingElement(button);

    String ADVANCED_SEARCH_TEXT_FILTER = getXPath_DivEqualsDataPath("pnl-adv-search txtSearch") + getXPath_HasADescendantLabelEqualsText("SEARCH TEXT") + getXPath_ContainsWicketpath(input, "txtSearch");//equalsTo(div, dataPath, "pnl-adv-search txtSearch") + hasAsChild(contains(label, text, "SEARCH TEXT")) + contains(singleSlash, input, wicketpath, "txtSearch");
    String ADVANCED_APPLICATION_ID_FILTER = getXPath_DivEqualsDataPath("pnl-adv-search txt-application-id") + getXPath_HasADescendantLabelEqualsText("APPLICATION ID") + getXPath_ContainsWicketpath(input, "txt-application-id");//equalsTo(div, dataPath, "pnl-adv-search txt-application-id") + hasAsChild(contains(label, text, "APPLICATION ID")) + contains(singleSlash, input, wicketpath, "txt-application-id");

    String ADVANCED_OPTIONS = getXPath_DivEqualsDataPath("lnk-adv-options") + getXPath_DirectAButtonAndContainsWicketpath("lnk-adv-options_script");//equalsTo(div, dataPath, "lnk-adv-options") + contains(singleSlash, a, wicketpath, "lnk-adv-options_script");
    String SHOW_ADVANCED_OPTIONS = ADVANCED_OPTIONS + getXPath_SpanEqualsText("Show advanced options");//equalsTo(span, text, "Show advanced options");
    String HIDE_ADVANCED_OPTIONS = ADVANCED_OPTIONS + getXPath_SpanEqualsText("Hide advanced options");//equalsTo(span, text, "Hide advanced options");

    String PROCESS_LIST_LINK = getXPath_DivEqualsDataPath("lnkProcessList") + getXPath_DirectAButtonAndContainsWicketpath("lnkProcessList_cancel") + getXPath_HasADescendantSpanEqualsText("Process list");//equalsTo(div, dataPath, "lnkProcessList") + contains(singleSlash, a, wicketpath, "lnkProcessList_cancel") + hasAsChild(equalsTo(span, text, "Process list"));
    String SESSION_LIST_LINK = getXPath_DivEqualsDataPath("lnkSessionList") + getXPath_DirectAButtonAndContainsWicketpath("lnkSessionList_cancel") + getXPath_HasADescendantSpanEqualsText("Session list");//equalsTo(div, dataPath, "lnkSessionList") + contains(singleSlash, a, wicketpath, "lnkSessionList_cancel") + hasAsChild(equalsTo(span, text, "Session list"));

    String SORT_BY_STAGE_SUBMISSION_DATE = getXPath_DivEqualsDataPath("pnlSort lnk-sortby-submissiondate") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.A, "sortby-submissiondate_submit") + getXPath_HasADescendantSpanEqualsText("creation date");
    String SORT_BY_CREATION_DATE = getXPath_DivEqualsDataPath("pnlSort lnk-sortby-creationdate") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.A, "sortby-creationdate_submit") + getXPath_HasADescendantSpanEqualsText("stage submission date");
    String SORT_BY_ASCENDANT = getXPath_DivEqualsDataPath("pnlSort lnk-order-asc") + getXPath_DirectSibling(ELEMENTS.A);
    String SORT_BY_DESCENDANT = getXPath_DivEqualsDataPath("pnlSort lnk-order-desc") + getXPath_DirectSibling(ELEMENTS.A);

    String SEARCH_BUTTON = getXPath_DivEqualsDataPath("pnlSort btnSearch") + getXPath_ContainsWicketpath(ELEMENTS.A, "btnSearch_submit") + getXPath_HasADescendantSpanEqualsText("Search");

    ILoanApplicationPage openLoanApplicationContainingName(String loanApplicationName);

    ILoanApplicationPage openLoanApplication(String loanApplicationName);

    ILoanApplicationPage startLoanApplication(String loanApplicationName);

    ILoanApplicationPage continueLoanApplication(String loanApplicationName);

    boolean isTitleApplicationListPresent();

    IApplicationListPage setAssignedFilter(String filter);

    IApplicationListPage setCaseFilter(String filter);

    IApplicationListPage setStatusFilter(String filter);

    IApplicationListPage setSearchTextAdvancedFilter(String filter);

    IApplicationListPage setApplicationIdAdvancedFilter(String filter);

    IApplicationListPage showAdvancedOptions();

    boolean isShowAdvancedOptionsDisplayed();

    IApplicationListPage hideAdvancedOptions();

    boolean isHideAdvancedOptionsDisplayed();

    IApplicationProcessesList clickProcessList();

    ISessionListPage clickSessionList();

    IApplicationListPage sortByStageSubmissionDate();

    IApplicationListPage sortByCreationDate();

    IApplicationListPage sortByAscendant();

    IApplicationListPage sortByDescendant();

    IApplicationListPage search();
}