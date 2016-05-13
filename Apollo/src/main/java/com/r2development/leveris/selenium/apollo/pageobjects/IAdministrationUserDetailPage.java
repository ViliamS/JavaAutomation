package com.r2development.leveris.selenium.apollo.pageobjects;

import static com.r2development.leveris.utils.XpathBuilder.Builder.*;

public interface IAdministrationUserDetailPage {


    String USER_NAME_TITLE =                equalsTo(div, class_att, "row") + element(span);  //can be used to verify presence of user, but cannot be used to getText of user name.

    String GET_ALERT_TEXT =                 equalsTo(div, class_att, "alert alert-danger clearfix") + followingElement(span);
    String ALERT_ACTIVATION_NOT_SENT_TEXT = GET_ALERT_TEXT + equalsTo(text, "Activation email has not been sent yet");

    String BUTTON_TEXT_SPAN =               equalsTo(button, type, button) + followingElement(span);
    String SEND_ACTIVATION_EMIAL_BUTTON =   BUTTON_TEXT_SPAN + equalsTo(text, "Send activation email");
    String EDIT_DETAILS_BUTTON =            BUTTON_TEXT_SPAN + equalsTo(text, "Edit details");
    String MANAGE_ROLES_BUTTON =            BUTTON_TEXT_SPAN + equalsTo(text, "+ Manage roles");
    String BACK_BUTTON =                    BUTTON_TEXT_SPAN + equalsTo(text, "Back");

    String USER_DETAILS_DATA =              element(p) + followingElement(span) + followingElement(span);
    String USER_DATA_DATE_OF_BIRTH =        USER_DETAILS_DATA + equalsTo(datareactid, ".0.0.2.2.0.0.0.1.2.0.1");
    String USER_DATA_EMAIL =                USER_DETAILS_DATA + contains(text, "email:");

    String GET_USER_TYPE_BADGE =            equalsTo(span, class_att, "badge");
    String OPERATOR_USER_TYPE_BADGE =       GET_USER_TYPE_BADGE + equalsTo(text, "Operator");

    IAdministrationUserDetailPage clickSendActivationEmail();
    IAdministrationAssignRolesPage clickManageRoles();
    IAdministrationUsersPage clickBack();
    IAdministrationUserDetailPageEditDetails clickEditDetails();
    String getDateOfBirth();
    String getEmail();
    String getAlert();

}
