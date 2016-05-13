package com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication;


import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import java.util.LinkedList;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IDocumentsDetail {

    String DOCUMENT_DETAIL_EDIT_LINK = getXPath_DivEqualsDataPath("pnlBlack pnlInfo lnkEdit") + getXPath_DirectAButtonContainsWicketpath("pnlInfo_c_w_lnkEdit_script") + getXPath_HasADescendantSpanEqualsText("Edit");

    String DOCUMENT_DETAIL_DELETE_LINK = getXPath(ELEMENTS.DIV, ACTIONS.AND_CONTAINS, ATTRIBUTES.DATA_PATH, new LinkedList<String>(){{add("pnlBlack rptDocuments ");add(" lnkDelete");}}) + getXPath_DirectAButtonContainsWicketpath("item_lnkDelete_submit") + getXPath_HasADescendantSpanEqualsText("Delete");

    String DOCUMENT_DETAIL_ADD_COMMENT_LINK = getXPath_DivEqualsDataPath("pnlBlack lnkAddComment") + getXPath_DirectAButtonContainsWicketpath("pnlBlack_c_w_lnkAddComment_dialog") + getXPath_HasADescendantSpanEqualsText("Add comment");

    String DOCUMENT_UPLOAD_PATH_INPUT = getXPath_DivEqualsDataPath("pnlBlack uplUpload") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "uplUpload_upload");

    String DOCUMENT_DETAIL_UPLOAD_NEW_BUTTON = getXPath_DivEqualsDataPath("pnlBlack btnUploadNew") + getXPath_DirectAButtonContainsWicketpath("btnUploadNew_submit") + getXPath_HasADescendantSpanEqualsText("Upload new");

    String DOCUMENT_DETAIL_CLOSE_X_BUTTON = getXPath_DivEqualsDataPath("pnlBlack lnkClose") + getXPath_DirectAButtonContainsWicketpath("lnkClose_cancel");

    IDocumentsSection clickDelete();

    IDocumentsSection clickCloseX();

    IDocumentsDetailEditSection clickEdit();
}