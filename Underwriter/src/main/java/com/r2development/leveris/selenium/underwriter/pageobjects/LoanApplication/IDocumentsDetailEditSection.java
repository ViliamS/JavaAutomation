package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;

import com.r2development.leveris.utils.Enums.DOCUMENTTYPE;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IDocumentsDetailEditSection {

    String DOCUMENT_TYPE = getXPath_DivAndContainsDataPath("Black", "Edit", "CoLoan", "DocumentType") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "Black", "Edit", "CoLoan", "DocumentType");
    String DOCUMENT_SUB_TYPE = getXPath_DivAndContainsDataPath("Black", "Edit", "DocSubtype") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "Black", "Edit", "DocSubtype");

    String DOCUMENT_TYPE_SELECTED_VALUE = getXPath_DivAndContainsDataPath("Black", "Edit", "DocumentType") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.SELECT, "Black", "Edit", "DocumentType", "combobox");
    String DOCUMENT_SUB_TYPE_SELECTED_VALUE = getXPath_DivAndContainsDataPath("Black", "Edit", "DocSubtype") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.SELECT, "Black", "Edit", "DocSubtype", "combobox");

    String EXPIRY_DATE = getXPath_DivAndContainsDataPath("Black", "Edit", "ExpiryDate") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "Black", "Edit", "ExpiryDate");
    String TAG_INPUT = getXPath_DivAndContainsDataPath("Black", "Edit", "Tag") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "Black", "Edit", "Tag");

    String UNDERWRITING_STATUS = getXPath_DivAndContainsDataPath("Black", "Edit", "UnderwritingStatus") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "Black", "Edit", "UnderwritingStatus");
    String SAVE_BUTTON = getXPath_DivAndContainsDataPath("Black", "Edit", "Save") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.A, "Black", "Edit", "Save") + getXPath_HasADescendantSpanEqualsText("Save");
    String CANCEL_BUTTON = getXPath_DivAndContainsDataPath("Black", "Edit", "Cancel") + getXPath_AndContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.A, "Black", "Edit", "Cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");

    String getDocumentTypeText();

    DOCUMENTTYPE getDocumentType();

    String getDocumentSubType();

    IDocumentsDetailEditSection setDocumentType(String value);

    IDocumentsDetailEditSection setDocumentSubType(String value);

    IDocumentsDetailEditSection setExpiryDate(String date);

    IDocumentsDetailEditSection setTag(String tag);

    IDocumentsDetailEditSection setUnderwritingStatus(String status);

    IDocumentsDetail clickSave();

    IDocumentsDetailEditSection clickCancel();
}
