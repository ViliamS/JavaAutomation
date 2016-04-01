package com.r2development.leveris.selenium.apollo.pageobjects;

import java.util.HashMap;
import java.util.Map;

import static com.r2development.leveris.utils.XPathBuilder.*;

public interface IAdministrationUsersPage {

    String GET_TITLE =          equalsTo(div, class_att, "container") + equalsTo(div, class_att, "group") + followingElement(h1) + followingElement(span);
    String USERS_TITLE =        equalsTo(div, class_att, "container") + equalsTo(singleSlash, span, "Users");
    String ADD_USER_BUTTON =    equalsTo(button, class_att, "btn btn-primary pull-right");
    String SEARCH_BUTTON =      equalsTo(button, type, "submit") + equalsTo(span, text, "Search");
    String SEARCH_INPUT =       equalsTo(input, class_att, "form-control");

    Map<String, String> andContainsClassMap = new HashMap<String, String>() {
        {
            put(class_att, "col");
            put(class_att, "md");
            put(class_att, "12");
        }
    };

    String SEARCH_RESULT_TEXT =          equalsTo(div, class_att, "row") + andContains(singleSlash, div, andContainsClassMap) + equalsTo(singleSlash, div, class_att, "group") + equalsTo(singleSlash, div, role, "alert");

    IAdministrationUsersPage clickSearch();
    IAdministrationUsersPage setSearch(String searchedValue);
    IAdministrationUsersPage clickAddUser();
    String getTitle();
    String getFoundXItemsText();
    boolean isResultExpected(String searchResultString);

}
