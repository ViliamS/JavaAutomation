package com.r2development.leveris.selenium.apollo.pageobjects;

import static com.r2development.leveris.utils.XPathBuilder.*;

public interface IAdministrationHomePage {

    String ROLES_LINK =         contains(a, href, "/administration/roles") + followingElement(h2) + equalsTo(singleSlash, span, text, "Roles");
    String USERS_LINK =         contains(a, href, "/administration/operators") + followingElement(h2) + equalsTo(singleSlash, span, text, "Users");
    String FUND_MANAGER_LINK =  contains(a, href, "/administration/funds") + followingElement(h2) + equalsTo(singleSlash, span, text,"Fund Manager");

    IAdministrationUsersPage clickUsersLink();
}
