package com.r2development.leveris.selenium.apollo.pageobjects;

import static com.r2development.leveris.utils.XPathBuilder.*;

public interface IAdministrationTopBanner {

    String ROLES_LINK =         equalsTo(a, href, "/administration/roles") + equalsTo(text, "Roles");
    String USERS_LINK =         equalsTo(a, href, "/administration/operators") + equalsTo(text, "Users");
    String FUND_MANAGER_LINK =  equalsTo(a, href, "/administration/funds") + equalsTo(text, "Fund Manager");

    IAdministrationUsersPage clickBannerLinkUsers();
    void clickBannerLinkRoles();
    void clickBannerLinkFundManager();

}
