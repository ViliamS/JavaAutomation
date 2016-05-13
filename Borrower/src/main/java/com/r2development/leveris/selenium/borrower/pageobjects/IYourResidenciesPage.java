package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.utils.XpathBuilder.Enums.ACTIONS;
import com.r2development.leveris.utils.XpathBuilder.Enums.ATTRIBUTES;
import com.r2development.leveris.utils.XpathBuilder.Enums.ELEMENTS;
import com.r2development.leveris.utils.XpathBuilder.XPathValues;

import static com.r2development.leveris.utils.XpathBuilder.XPath.*;

public interface IYourResidenciesPage {
//
//    String CURRENT_RESIDENCY =          orContains(div, dataPath, new LinkedList<String>(){{addEntry("pnlNoEmplyments lnkAddCurrentResidency");  addEntry("pnlNoEmplyments lnkCurrentResidency");}}) +    followingElement(a);
//    String OTHER_PREVIOUS_RESIDENCY =   orContains(div, dataPath, new LinkedList<String>(){{addEntry("pnlNoEmplyments lnkAddOtherResidency");    addEntry("pnlNoEmplyments lnkOtherResidency");}}) +      followingElement(a);
//    String ADD_BUTTON =                 equalsTo(div, dataPath, "pnlResidencyList btnAdd") + "[" + equalsTo(span, text, "Add") + "]" + contains(singleSlash, a, wicketpath, "btnAdd_dialog");
//    String DONE_BUTTON =                equalsTo(div, dataPath, "pnlResidencyList btnImDone") + "[" + andContains(span, text, new LinkedList<String>() {{addEntry("I"); addEntry("m done");}}) + "]" + contains(singleSlash, a, wicketpath, "btnImDone_submit");

    String CURRENT_RESIDENCY = getXPath(ELEMENTS.DIV, ACTIONS.OR_CONTAINS, ATTRIBUTES.DATA_PATH, XPathValues.getXPathValues("pnlNoEmplyments lnkAddCurrentResidency", "pnlNoEmplyments lnkCurrentResidency")) + getXPath_DirectSibling(ELEMENTS.A);
    String OTHER_PREVIOUS_RESIDENCY = getXPath(ELEMENTS.DIV, ACTIONS.OR_CONTAINS, ATTRIBUTES.DATA_PATH, XPathValues.getXPathValues("pnlNoEmplyments lnkAddOtherResidency", "pnlNoEmplyments lnkOtherResidency")) + getXPath_DirectSibling(ELEMENTS.A);
    String ADD_BUTTON = getXPath_DivEqualsDataPath("pnlResidencyList btnAdd") + getXPath_HasADescendant(ELEMENTS.SPAN, ACTIONS.EQUALS, ATTRIBUTES.TEXT, "Add") + getXPath(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "btnAdd_dialog");
    String DONE_BUTTON = getXPath_DivEqualsDataPath("pnlResidencyList btnImDone") + getXPath_HasADescendant(ELEMENTS.SPAN, ACTIONS.AND_CONTAINS, ATTRIBUTES.TEXT, XPathValues.getXPathValues("I", "m done")) + getXPath_DirectSibling(ELEMENTS.A, ACTIONS.CONTAINS, ATTRIBUTES.WICKETPATH, "btnImDone_submit");

    IYourResidenciesSection clickCurrentResidency();

    IYourResidenciesSection clickOtherPreviousResidency();

    IYourResidenciesSection clickAdd();

    IEmploymentIncomesPage clickDone();

}
