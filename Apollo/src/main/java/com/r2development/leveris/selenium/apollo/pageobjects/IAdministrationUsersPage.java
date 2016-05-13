package com.r2development.leveris.selenium.apollo.pageobjects;

import com.google.common.collect.LinkedListMultimap;

import java.util.LinkedList;

import static com.r2development.leveris.utils.XpathBuilder.Builder.*;

public interface IAdministrationUsersPage {

    String GET_TITLE =          equalsTo(div, class_att, "container") + equalsTo(div, class_att, "group") + followingElement(h1) + followingElement(span);
    String USERS_TITLE =        equalsTo(div, class_att, "container") + equalsTo(singleSlash, span, "Users");
    String ADD_USER_BUTTON =    equalsTo(button, class_att, "btn btn-primary pull-right") + contains(singleSlash, span, text, "+ Add user");
    String SEARCH_BUTTON =      equalsTo(button, type, "submit") + equalsTo(span, text, "Search");
    String SEARCH_INPUT =       equalsTo(input, class_att, "form-control");

    String EMAIL_ADDRESS_USED_AS_LOGIN_INPUT =  equalsTo(input, name, "userName");
    String FIRST_NAME_INPUT =                   equalsTo(input, name, "firstName");
    String LAST_NAME_INPUT =                    equalsTo(input, name, "lastName");
    String PHONE_NUMBER_INPUT =                 equalsTo(input, name, "phoneNumber");

    LinkedListMultimap<String, LinkedList<String>> xPathAttributeMap = xPathAttributesMap(class_att, new LinkedList<String>(){{add("row");}});

//    Table<String, String, Map<String, List<String>>> xpathGaunaMap = ;

    String SEARCH_RESULT_TEXT = equalsTo(div, class_att, "row") + andContains(singleSlash, div, class_att, new LinkedList<String>(){{add("col"); add("md"); add("12");}}) + equalsTo(singleSlash, div, class_att, "group") + equalsTo(singleSlash, div, class_att, "alert alert-info") + followingElement(span);

    LinkedList<String> classAttributeValues = new LinkedList<String>(){{add("date"); add("input"); add("group");}};

    String DATE_OF_BIRTH_DAY_INPUT =    andContains(div, class_att, classAttributeValues) + contains(singleSlash, input, datareactid, "1a.0.1");
    String DATE_OF_BIRTH_MONTH_INPUT =  andContains(div, class_att, classAttributeValues) + contains(singleSlash, input, datareactid, "1a.0.2");
    String DATE_OF_BIRTH_YEAR_INPUT =   andContains(div, class_att, classAttributeValues) + contains(singleSlash, input, datareactid, "1a.0.3");
    String SAVE_CHANGES_BUTTON =        equalsTo(button, type, "submit") + equalsTo(singleSlash, span, text, "Save changes");

    IAdministrationUsersPage clickSearch();
    IAdministrationUsersPage setSearch(String searchedValue);
    IAdministrationUsersPage clickAddUser();
    String getTitle();
    String getFoundXItemsText();
    boolean isResultExpected(String searchResultString);
    IAdministrationUsersPage setEmailAddressUsedAsLogin(String setLogin);
    IAdministrationUsersPage setFirstName(String firstName);
    IAdministrationUsersPage setLastName(String lastName);
    IAdministrationUsersPage setPhoneNumber(String phoneNumber);
    IAdministrationUsersPage setDateOfBirth(String day, String month, String year);
    IAdministrationUsersPage setDateOfBirth(String dateOfBirth);
    IAdministrationUsersPage setDateOfBirthTest(String dateOfBirth);
    IAdministrationUserDetailPage clickSaveChanges();

}
