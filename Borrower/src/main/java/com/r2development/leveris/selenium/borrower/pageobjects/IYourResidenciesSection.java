package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IYourResidenciesSection {

    String TITLE_RESIDENCY_DETAILS = getXPath(ELEMENTS.H3, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Residency details");
    String FORM_TITLE = getXPath_DivEqualsDataPath("lblFormTitle") + getXPath_DirectSibling(ELEMENTS.DIV);

    String GET_FORM_TITLE = FORM_TITLE + getXPath_DirectSibling(ELEMENTS.SPAN);
    String TITLE_CURRENT_RESIDENCY_DETAILS = FORM_TITLE + getXPath_DirectSibling(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Current residency details");
    String TITLE_OTHER_PREVIOUS_RESIDENCY_DETAILS = FORM_TITLE + getXPath_DirectSibling(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Other / previous residency details");

    String ADDRESS_LINE1 = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency pnlAddressField") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Address line 1") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.ID, "autocompleteBox");
    String ADDRESS_LINE2 = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency txtAddressLine2") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Address line 2") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txtAddressLine2");
    String TOWN_CITY = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency txtTownCity") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Town/city") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txtTownCity");
    String COUNTY_STATE = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency pnlCounty pnlEnglandCounty cmbCountyState2") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "County/state") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "cmbCountyState2");
    String POST_CODE_ZIP = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency txtPostcode") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Postcode/ZIP") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txtPostcode");
    String COUNTRY = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency cmbCountry") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Country") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "cmbCountry");
    String START_DATE = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency txtStartDate") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Start date") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txtStartDate");
    String END_DATE = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency txtEndDate") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "End date") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "txtEndDate");
    String RESIDENTAL_STATUS = getXPath_DivEqualsDataPath("pnlMortgageApplicationResidency cmbResidentialStatus") + getXPath_HasADescendant(ELEMENTS.LABEL, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Residential status") + getXPath(ELEMENTS.INPUT, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "cmbResidentialStatus");
    String CANCEL = getXPath_DivEqualsDataPath("btnCancel") + getXPath_HasADescendant(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Cancel") + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "btnCancel_cancel");
    String SAVE_AND_CLOSE = getXPath_DivEqualsDataPath("btnNext") + getXPath_HasADescendant(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Save and close") + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "btnNext_submit");


    String getFormTitle();

    boolean isCurrentResidencyFormTitlePresent();

    boolean isOtherPreviousResidencyFormTitlePresent();

    IYourResidenciesSection setAddressLine1(String addressLine1);

    IYourResidenciesSection setAddressLine2(String addressLine2);

    IYourResidenciesSection setTownCity(String townCity);

    IYourResidenciesSection setCountyState(String countyState);

    IYourResidenciesSection setPostCodeZip(String postCodeZip);

    IYourResidenciesSection setCountry(String country);

    IYourResidenciesSection setStartDate(String startDate);

    IYourResidenciesSection setEndDate(String endDate);

    IYourResidenciesSection setResidentalStatus(String residentalStatus);

    IYourResidenciesSection clickCancel();

    IYourResidenciesSection clickSaveAndClose();

}