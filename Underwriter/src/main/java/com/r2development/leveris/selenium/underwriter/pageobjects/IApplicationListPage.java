package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.ILoanApplicationPage;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IApplicationListPage {

    String TITLE_APPLICATION_LIST = getXPath(h2, equals, text, "Application List");
    String ASSIGNED_FILTER = getXPath(div, equals, dataPath, "cmbAssignedApplication") + getXPath_HasADescendant(label, equals, text, "ASSIGNED") + getXPath(singleSlash, input);
    String ASSIGNED_FILTER_BUTTON = getXPath_DivEqualsDataPath("cmbAssignedApplication") + getXPath_DirectSibling(button);
    String CASE_FILTER = getXPath_DivEqualsDataPath("cmbCase") + getXPath_HasADescendantLabelEqualsText("CASE") + getXPath_DirectSibling(input);
    String CASE_FILTER_BUTTON = getXPath_DivEqualsDataPath("cmbCase") + getXPath_DirectSibling(button);
    String STATUS_FILTER = getXPath_DivEqualsDataPath("pnlStatusColoan cmbStatusFilter") + getXPath_HasADescendantLabelEqualsText("STATUS") + getXPath_DirectSibling(input);
    String STATUS_FILTER_BUTTON = getXPath_DivEqualsDataPath("pnlStatusColoan cmbStatusFilter") + getXPath_DirectSibling(button);

    String ADVANCED_SEARCH_TEXT_FILTER = getXPath_DivEqualsDataPath("pnl-adv-search txtSearch") + getXPath_HasADescendantLabelContainsText("SEARCH TEXT") + getXPath_AndContainsWicketpath(singleSlash, input, "pnl-adv-search", "txtSearch");
    String ADVANCED_APPLICATION_ID_FILTER = getXPath_DivEqualsDataPath("pnl-adv-search txt-application-id") + getXPath_HasADescendantLabelContainsText("APPLICATION ID") + getXPath_ContainsWicketpath(singleSlash, input, "pnl-adv-search", "txt-application-id");

    String ADVANCED_OPTIONS = getXPath_DivEqualsDataPath("lnk-adv-options") + getXPath_DirectAButtonAndContainsWicketpath("lnk-adv-options_script");
    String SHOW_ADVANCED_OPTIONS = ADVANCED_OPTIONS + getXPath_SpanEqualsText("Show advanced options");
    String HIDE_ADVANCED_OPTIONS = ADVANCED_OPTIONS + getXPath_SpanEqualsText("Hide advanced options");

    String PROCESS_LIST_LINK = getXPath_DivEqualsDataPath("lnkProcessList") + getXPath_DirectAButtonAndContainsWicketpath("lnkProcessList_cancel") + getXPath_HasADescendantSpanEqualsText("Process list");
    String SESSION_LIST_LINK = getXPath_DivEqualsDataPath("lnkSessionList") + getXPath_DirectAButtonAndContainsWicketpath("lnkSessionList_cancel") + getXPath_HasADescendantSpanEqualsText("Session list");

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