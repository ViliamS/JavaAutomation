package com.r2development.leveris.selenium.apollo.pageobjects;

import static com.r2development.leveris.utils.XpathBuilder.Builder.*;

public interface IAdministrationAssignRolesPage {

    String GET_ASSIGN_ROLES_TITLE = equalsTo(div, class_att, "section-header h2 modal-title");

    String ASSIGN_ROLES_TITLE =     GET_ASSIGN_ROLES_TITLE + equalsTo(text, "Assign Roles");

    String SAVE_CHANGES_BUTTON =    equalsTo(button, type, "submit") + equalsTo(singleSlash, span, text, "Save changes");
    String CANCEL_BUTTON =          equalsTo(button, type, button) + equalsTo(singleSlash, span, text, "Cancel");
    String X_BUTTON =               equalsTo(button, class_att, "dismiss-button close") + equalsTo(text, "×");

    IAdministrationAssignRolesPage assignRole(String roleName);
    IAdministrationAssignRolesPage assignGroupRole(String roleName);
    IAdministrationUserDetailPage clickSaveChanges();
    IAdministrationUserDetailPage clickCancel();
    IAdministrationUserDetailPage clickX();
}
