package com.r2development.leveris.selenium.apollo.pageobjects;

import static com.r2development.leveris.utils.XpathBuilder.Builder.*;

public interface IAdministrationTopBanner {

    String ROLES_LINK =         equalsTo(a, href, "/administration/roles") + equalsTo(text, "Roles");
    String USERS_LINK =         equalsTo(a, href, "/administration/operators") + equalsTo(text, "Users");
    String FUND_MANAGER_LINK =  equalsTo(a, href, "/administration/funds") + equalsTo(text, "Fund Manager");

    String ADMIN_FIRSTNAME_LASTNAME_LINK =  equalsTo(li, role, "presentation") + equalsTo(class_att, dropdown) + equalsTo(singleSlash, a, role, button) + equalsTo(class_att, "pointer dropdown-toggle");
    String ADMIN_FN_LN_DROPDOWN_OPEN =      equalsTo(li, role, "presentation") + equalsTo(class_att, dropdown + " open");
    String LOGOUT_LINK = ADMIN_FN_LN_DROPDOWN_OPEN + equalsTo(singleSlash, ul, class_att, "dropdown-menu") + followingElement(li) + equalsTo(singleSlash, a, role, button) + equalsTo(text, "Logout");

    IAdministrationUsersPage clickBannerLinkUsers();
    void clickBannerLinkRoles();
    void clickBannerLinkFundManager();
    IAdministrationTopBanner clickAdminFirstNameLastNameLink();
    IAdministrationLoginPage logouts();

}
