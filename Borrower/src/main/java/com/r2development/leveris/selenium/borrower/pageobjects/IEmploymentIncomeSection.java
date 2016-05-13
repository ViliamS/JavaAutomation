package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.Enums.PREFIX;
import com.r2development.leveris.utils.XpathBuilder.XPathValues;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;


public interface IEmploymentIncomeSection {

    String EMPLOYMENT_INCOMES_CATEGORY_XPATH = getXPath(ELEMENTS.LABEL, ACTIONS.CONTAINS, ATTRIBUTES.ANY, "Category");
    String EMPLOYMENT_INCOMES_FEEDBACK_DIALOG_XPATH = getXPath(ELEMENTS.DIV, ACTIONS.CONTAINS, ATTRIBUTES.ANY, "main_c_form_dialogWrapper_dialog_feedbackBox");
    String ERROR = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "There are error items.");
    String EMPLOYMENT_INCOMES_DIALOG_XPATH = getXPath(ELEMENTS.DIV, ACTIONS.EQUALS, ATTRIBUTES.WICKETPATH, "main_c_form_dialogWrapper_dialog");
    String EMPLOYMENT_INCOMES_ADD_PAYE_XPATH = getXPath_DivEqualsDataPath("pnlNoEmplyments pnlPaye lnkAddPaye") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.OR_CONTAINS, ATTRIBUTES.WICKETPATH, new XPathValues("pnlPaye_c_w_lnkAddPaye_dialog", "pnlPaye_c_w_lnkAddPaye_submit"));
    String EMPLOYMENT_INCOMES_ADD_SELF_EMPLOYED_XPATH = getXPath_DivEqualsDataPath("pnlNoEmplyments pnlSelfEmployed lnkAddSelfEmployed") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.OR_CONTAINS, ATTRIBUTES.WICKETPATH, new XPathValues("lnkAddSelfEmployed_submit", "lnkAddSelfEmployed_dialog"));
    String EMPLOYMENT_INCOMES_ADD_UNEMPLOYED_XPATH = getXPath_DivEqualsDataPath("pnlNoEmplyments pnlUnemployed lnkAddUnemployment") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.OR_CONTAINS, ATTRIBUTES.WICKETPATH, new XPathValues("lnkAddUnemployment_dialog", "lnkAddUnemployment_submit"));
    String EMPLOYMENT_INCOMES_ADD_OTHER_XPATH = getXPath_DivEqualsDataPath("pnlNoEmplyments pnlOther lnkAddHomemaker") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.A, ACTIONS.OR_CONTAINS, ATTRIBUTES.WICKETPATH, new XPathValues("lnkAddHomemaker_dialog", "lnkAddHomemaker_submit"));

    /**
     * were replaced with help of usage of ACTIONS.OR_CONTAINS --> ATTRIBUTES.WICKETPATH, new XPathValues("pnlPaye_c_w_lnkAddPaye_dialog", "pnlPaye_c_w_lnkAddPaye_submit")
     * <p>
     * String EMPLOYMENT_INCOMES_DIALOG_ADD_PAYE_XPATH = EMPLOYMENT_INCOMES_ADD_PAYE_XPATH;
     * String EMPLOYMENT_INCOMES_DIALOG_ADD_SELF_EMPLOYED_XPATH = EMPLOYMENT_INCOMES_ADD_SELF_EMPLOYED_XPATH;
     * String EMPLOYMENT_INCOMES_DIALOG_ADD_UNEMPLOYED_XPATH = EMPLOYMENT_INCOMES_ADD_UNEMPLOYED_XPATH;
     * String EMPLOYMENT_INCOMES_DIALOG_ADD_OTHER_XPATH = EMPLOYMENT_INCOMES_ADD_OTHER_XPATH;
     */
    String INPUT_OCCUPATION_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlEmployed cmbJobTitle") + getXPath_HasADescendantLabelEqualsText("Occupation") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String INPUT_EMPLOYMENT_NAME_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlEmployed txtEmployerName") + getXPath_HasADescendant(getXPath(ELEMENTS.LABEL, ACTIONS.AND_CONTAINS, ATTRIBUTES.TEXT, new XPathValues("Employer", "s name"))) + getXPath_DirectSibling(ELEMENTS.INPUT);
    String INPUT_EMPLOYMENT_TYPE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlEmployed cmbEmplType") + getXPath_HasADescendantLabelEqualsText("Employment type") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String INPUT_START_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlEmployed txtEmplStartDate") + getXPath_HasADescendantLabelEqualsText("Start date") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String INPUT_END_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlEmployed txtEmplEndDate") + getXPath_HasADescendantLabelContainsText("End date") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String INPUT_CURRENTLY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlEmployed pnlEmplCurrently chkEmplCurrently") + getXPath_HasADescendantLabelEqualsText("Currently") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath_DirectSibling(ELEMENTS.A);
    String INPUT_NET_INCOME_MONTHLY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlEmployed pnlNetIncomeEmpl crbEmplNetIcome") + getXPath_HasADescendant(getXPath(ELEMENTS.LABEL, ACTIONS.AND_CONTAINS, ATTRIBUTES.TEXT, new XPathValues("Net Income", "monthly"))) + getXPath_DirectSibling(ELEMENTS.INPUT);

    String EMPLOYMENT_INCOME_PAYE_FORM_OCCUPATION_XPATH = INPUT_OCCUPATION_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYER_NAME_XPATH = INPUT_EMPLOYMENT_NAME_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_EMPLOYMENT_TYPE_XPATH = INPUT_EMPLOYMENT_TYPE_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_START_DATE_XPATH = INPUT_START_DATE_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_END_DATE_XPATH = INPUT_END_DATE_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_CURRENTLY_XPATH = INPUT_CURRENTLY_XPATH;
    String EMPLOYMENT_INCOME_PAYE_FORM_NET_INCOME_MONTHLY_XPATH = INPUT_NET_INCOME_MONTHLY_XPATH;

    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_OCCUPATION_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed cmbSelfOccupation") + getXPath_HasADescendantLabelContainsText("Occupation") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NAME_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed txtBusinessName") + getXPath_HasADescendantLabelContainsText("Business name") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_1_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed pnlAddressField1") + getXPath(div, ACTIONS.CONTAINS, ATTRIBUTES.ID, "googlediv") + getXPath_HasADescendantLabelContainsText("Address line 1") + getXPath(PREFIX.DOUBLE_SLASH, ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_ADDRESS_LINE_2_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed txtAddressLine2") + getXPath_HasADescendantLabelContainsText("Address line 2") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_TOWN_CITY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed txtCity") + getXPath_HasADescendantLabelContainsText("Town/City") + getXPath_DirectSibling(ELEMENTS.INPUT);

    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTY_STATE_SELECT_XPATH = getXPath(ELEMENTS.DIV, ACTIONS.OR_EQUALS, ATTRIBUTES.DATA_PATH, new XPathValues("pnlDetail pnlSelfEmployed pnlCounty pnlEnglishCounty cmbEnglandCounty", "pnlDetail pnlSelfEmployed pnlCounty pnlIrelandCounty cmbIrelandCounty")) + getXPath_HasADescendantLabelContainsText("County/State") + getXPath_DirectSibling(ELEMENTS.INPUT);

    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_COUNTRY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed cmbCountry") + getXPath_HasADescendantLabelEqualsText("Country") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_BUSINESS_NATURE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed txtNatureOfBusiness") + getXPath_HasADescendantLabelContainsText("Nature of business") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_START_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed txtDateBussEstablished") + getXPath_HasADescendantLabelContainsText("Start date") + getXPath_DirectSibling(ELEMENTS.INPUT);

    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_END_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed txtBusinessEndDate") + getXPath_HasADescendantLabelContainsText("End date") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "pnlSelfEmployed_c_w_txtBusinessEndDate");

    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_CURRENTLY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlSelfEmployed chkBusinessCurrently") + getXPath_HasADescendantLabelContainsText("Currently") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath_DirectSibling(ELEMENTS.A);
    String EMPLOYMENT_INCOME_SELF_EMPLOYMENT_FORM_NET_INCOME_MONTHLY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlNetIcomeSelf crbNetIcomeSelf") + getXPath_HasADescendant(getXPath(ELEMENTS.LABEL, ACTIONS.AND_CONTAINS, ATTRIBUTES.TEXT, new XPathValues("Net Income", "monthly"))) + getXPath_DirectSibling(ELEMENTS.INPUT);

    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_START_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlUnemployed txtUnemployedStartDate") + getXPath_HasADescendantLabelContainsText("Start date") + getXPath_DirectSibling(ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_END_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlUnemployed txtUnemployedEndDate") + getXPath_HasADescendant(getXPath(ELEMENTS.LABEL, ACTIONS.AND_CONTAINS, ATTRIBUTES.TEXT, "End date")) + getXPath_DirectSibling(ELEMENTS.INPUT);
    String EMPLOYMENT_INCOME_UNEMPLOYED_FORM_CURRENTLY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlUnemployed chkUnemployedCurrently") + getXPath_HasADescendant(getXPath(ELEMENTS.FONT, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Currently")) + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath_DirectSibling(ELEMENTS.A);

    String EMPLOYMENT_INCOME_OTHER_FORM_NET_INCOME_MONTHLY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlNetIcomeOther crbNetIcomeOther") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "pnlNetIcomeOther_c_w_crbNetIcomeOther");
    String EMPLOYMENT_INCOME_OTHER_FORM_NET_ADDITIONAL_INCOME_SOURCE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlOther txtSourceAdditionalIncome") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "pnlOther_c_w_txtSourceAdditionalIncome");
    String EMPLOYMENT_INCOME_OTHER_FORM_START_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlOtherDates txtOtherStartDate") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "pnlOtherDates_c_w_txtOtherStartDate");
    String EMPLOYMENT_INCOME_OTHER_FORM_END_DATE_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlOtherDates txtOtherEndDate") + getXPath_ContainsWicketpath(PREFIX.SINGLE_SLASH, ELEMENTS.INPUT, "pnlOtherDates_c_w_txtOtherEndDate");
    String EMPLOYMENT_INCOME_OTHER_FORM_CURRENTLY_XPATH = getXPath_DivEqualsDataPath("pnlDetail pnlOtherDates chkOtherCurrently") + getXPath(PREFIX.SINGLE_SLASH, ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.CLASS, "vcheckbox control") + getXPath_DirectSibling(ELEMENTS.A);

    String SAVE_AND_CLOSE_XPATH = getXPath_DivEqualsDataPath("pnlDetail btnEmploymentAdd") + getXPath_DirectAButtonContainsWicketpath("btnEmploymentAdd_submit") + getXPath_HasADescendantSpanEqualsText("Save and Close");
    String CANCEL_XPATH = getXPath_DivEqualsDataPath("pnlDetail btnCancel") + getXPath_DirectAButtonContainsWicketpath("btnCancel_cancel") + getXPath_HasADescendantSpanEqualsText("Cancel");
    String ADD_XPATH = getXPath_DivEqualsDataPath("pnlEmpList btnAddEmp") + getXPath_DirectAButtonContainsWicketpath("btnAddEmp_dialog") + getXPath_HasADescendantSpanEqualsText("Add");
    String DONE_XPATH = getXPath_DivEqualsDataPath("pnlEmpList btnImDone") + getXPath_DirectAButtonAndContainsWicketpath("pnlEmpList", "btnImDone", "submit") + getXPath_HasADescendantSpanText(ACTIONS.AND_CONTAINS, "I", "m done");

    IEmploymentIncomeSection selectCategory(String category);

    IEmploymentIncomeSection clickCategory(String category);

    IEmploymentIncomeSection selectPaye_Occupation(String occupation);

    IEmploymentIncomeSection typePaye_EmploymentName(String employmentName);

    IEmploymentIncomeSection selectPaye_EmploymentType(String employmentType);

    IEmploymentIncomeSection typePaye_StartDate(String startDate);

    IEmploymentIncomeSection typePaye_EndDate(String endDate);

    IEmploymentIncomeSection checkPaye_Currently(String currently);

    IEmploymentIncomeSection typePaye_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomeSection selectSelfEmployment_Occupation(String occupation);

    IEmploymentIncomeSection typeSelfEmployment_StartDate(String startDate);

    IEmploymentIncomeSection typeSelfEmployment_EndDate(String endDate);

    IEmploymentIncomeSection checkSelfEmployment_Currently(String currently);

    IEmploymentIncomeSection typeSelfEmployment_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomeSection typeSelfEmployment_BusinessName(String businessName);

    IEmploymentIncomeSection typeSelfEmployment_AddressLine1(String addressLine1);

    IEmploymentIncomeSection typeSelfEmployment_AddressLine2(String addressLine2);

    IEmploymentIncomeSection typeSelfEmployment_TownCity(String townCity);

    IEmploymentIncomeSection selectSelfEmployment_CountyState(String countyState);

    IEmploymentIncomeSection selectSelfEmployment_Country(String country);

    IEmploymentIncomeSection typeSelfEmployment_BusinessNature(String businessNature);

    IEmploymentIncomeSection typeOther_StartDate(String startDate);

    IEmploymentIncomeSection typeOther_EndDate(String endDate);

    IEmploymentIncomeSection checkOther_Currently(String currently);

    IEmploymentIncomeSection typeUnemployment_StartDate(String startDate);

    IEmploymentIncomeSection typeUnemployment_EndDate(String endDate);

    IEmploymentIncomeSection checkUnemployment_Currently(String currently);

    IEmploymentIncomeSection typeOther_NetIncomeMonthly(String netIncomeMonthly);

    IEmploymentIncomeSection typeOther_AdditionalIncomeSource(String additionalIncomeSource);

    IEmploymentIncomeSection typeOther_EarningTime(String earningTIme);

    IEmploymentIncomeSection clickSaveAndClose();

    IEmploymentIncomeSection clickCancel();

    IEmploymentIncomeSection clickAdd();

    IYourAccountsPage clickDone();

    IEmploymentIncomeSection clickDelete(int index);

    IEmploymentIncomeSection clickDelete(String detailCategory);

    IEmploymentIncomeSection clickEdit(int index);

    IEmploymentIncomeSection clickEdit(String detailCategory);
}