package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.Enums.UNDERWRITINGSTATUS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTION;
import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.XPathValues;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IDocumentsSection {

    String DOCUMENTS_TAB =                getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_4");
    String DOCUMENTS_PANEL_TITLE =        DOCUMENTS_TAB + getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TITLE, "Documents 1") + getXPath(ACTIONS.NOT_EQUALS, ATTRIBUTES.TITLE, "Documents 2") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_4_header");

    String DOCUMENTS_PANEL_HIDE =         DOCUMENTS_TAB + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "collapse");
    String DOCUMENTS_PANEL_HIDDEN =       getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_4_header") + getXPath_HasADescendant(getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "collapse") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: none"));
    String DOCUMENTS_PANEL_NOT_HIDDEN =   DOCUMENTS_PANEL_HIDE + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.STYLE, "display: block");

    String DOCUMENTS_UPLOAD_BUTTON = getXPath_DivEqualsDataPath("btnUpload") + getXPath_DirectAButtonContainsWicketpath("btnUpload_submit") + getXPath_HasADescendantSpanEqualsText("Upload");
    String DOCUMENTS_UPLOADED_DOCUMENTS_ROW_ENTRY = getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "multiFlow_panels_4_p_c_form_form_root_c_w_rptDocuments_c_rows_") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.DATA_TYPE, "panel");

    String DOCUMENT_ROW_SELECTION = getXPath(ELEMENTS.DIV, ACTIONS.AND_CONTAINS, ATTRIBUTES.DATA_PATH, XPathValues.setXPathValues("rptDocuments", "pnlDocuments")) + getXPath(ACTIONS.EQUALS, ATTRIBUTES.DATA_TYPE, "panel") + getXPath(ACTIONS.CONTAINS, ATTRIBUTES.CLASS, "clickable") + getXPath_HasADescendant(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "link");


    IDocumentsSection documentsSectionHideUnhide(ACTION action);

    int getNumberOfUploadedDocuments();

    IDocumentsDetail openDocument(String indexNumber);
    IDocumentsDetail openDocument(int i);

    boolean isDocumentInExpectedStatus(UNDERWRITINGSTATUS underwritingstatus, int documentRowIndex);

}
//