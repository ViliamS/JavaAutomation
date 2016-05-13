package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IPersonalDetailsSection {

    String TITLE_XPATH = getXPath(ELEMENTS.H2, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "main_c_title") + getXPath(ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Personal Details");
    String TITLE_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlMain pnlCoLoanTitle txtTitle") + getXPath_HasADescendantLabelContainsText("Title") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlCoLoanTitle_c_w_txtTitle_tb");
    String FIRST_NAME_XPATH = getXPath_DivEqualsDataPath("pnlMain pnlNames txtFirstName") + getXPath_HasADescendantLabelEqualsText("First name") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlNames_c_w_txtFirstName");
    String MIDDLE_NAME_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlMain pnlCoLoanNamesSuff txtMiddleName") + getXPath_HasADescendantLabelContainsText("Middle name") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlCoLoanNamesSuff_c_w_txtMiddleName");
    String LAST_NAME_XPATH = getXPath_DivEqualsDataPath("pnlMain pnlNames txtLastName") + getXPath_HasADescendantLabelEqualsText("Last name") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlNames_c_w_txtLastName");
    String SUFFIX_INPUT_XPATH = getXPath_DivEqualsDataPath("pnlMain pnlCoLoanNamesSuff txtSuffix") + getXPath_HasADescendantLabelContainsText("Suffix") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlCoLoanNamesSuff_c_w_txtSuffix");

    String GENDER_MALE_XPATH = getXPath_DivEqualsDataPath("pnlMain pnlGender rgrGender radMale") + getXPath_HasADescendantLabelEqualsText("Male") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "vradiobutton control") + getXPath_DirectSibling(ELEMENTS.A);
    String GENDER_FEMALE_XPATH = getXPath_DivEqualsDataPath("pnlMain pnlGender rgrGender radFemale") + getXPath_HasADescendantLabelEqualsText("Female") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "vradiobutton control") + getXPath_DirectSibling(ELEMENTS.A);

    String DATE_OF_BIRTH_XPATH = getXPath_DivEqualsDataPath("pnlMain txtDateOfBirth") + getXPath_HasADescendantLabelEqualsText("Date of birth") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlMain_c_w_txtDateOfBirth");
    String MARITAL_STATUS_XPATH = getXPath_DivEqualsDataPath("pnlMain cmbMaritalStatus") + getXPath_HasADescendantLabelEqualsText("Marital status") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlMain_c_w_cmbMaritalStatus");
    String NATIONALITY_XPATH = getXPath_DivEqualsDataPath("pnlMain cmbNationality") + getXPath_HasADescendantLabelEqualsText("Nationality") + getXPath_ContainsWicketpath(ELEMENTS.INPUT, "pnlMain_c_w_cmbNationalit");
    String SAVE_BUTTON_XPATH = getXPath_DivEqualsDataPath("pnlMain btnNext") + getXPath_DirectAButtonContainsWicketpath("btnNext_submit") + getXPath_HasADescendantSpanEqualsText("Save");

    IPersonalDetailsSection setTitle(String title);

    IPersonalDetailsSection setFirstName(String FirstName);

    IPersonalDetailsSection setMiddleName(String middleName);

    IPersonalDetailsSection setLastName(String LastName);

    IPersonalDetailsSection setSuffix(String suffix);

    IPersonalDetailsSection checkGenderMale();

    IPersonalDetailsSection checkGenderFemale();

    IPersonalDetailsSection checkGender(String gender);

    IPersonalDetailsSection setDateOfBirth(String dateOfBirth);

    IPersonalDetailsSection selectMaritalStatus(String maritalStatus);

    IPersonalDetailsSection selectNationality(String nationality);

    IPersonalDetailsSection clickSave();

    boolean isLoaded();
}