package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static com.r2development.leveris.utils.XpathBuilder.Builder.*;

public class AdministrationAssignRolesPage extends AdministrationTopBanner implements IAdministrationAssignRolesPage {

    private static final Log log = LogFactory.getLog(AdministrationAssignRolesPage.class.getName());

    WebDriver webDriver;

    public AdministrationAssignRolesPage(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IAdministrationAssignRolesPage assignRole(String roleName){
        log.info("");
        isVisible(ASSIGN_ROLES_TITLE, 15);

        //div[@class='group']//div[@class='checkbox']//label/frag[text()='segment']/../../input

        String ROLES_ROW_ENTRY = equalsTo(div, class_att, "group") + equalsTo(div, class_att, checkbox) + element(label) + equalsTo(singleSlash, frag, text, roleName) + "/../.." + followingElement(input);
        if(isVisible(ROLES_ROW_ENTRY, 0))
            clickElement(ROLES_ROW_ENTRY);
        else
            Assert.assertTrue("\n Role name ---> '" + roleName + "' <--- not found!", false);
        return this;
    }

    @Override
    public IAdministrationAssignRolesPage assignGroupRole(String roleName){
        log.info("");
        isVisible(ASSIGN_ROLES_TITLE, 15);
        String ROLES_ROW_ENTRY = equalsTo(div, class_att, "group") + equalsTo(div, class_att, checkbox) + element(label) + equalsTo(singleSlash, frag, text, roleName) + "/../.." + followingElement(input);
        if(isVisible(ROLES_ROW_ENTRY, 0))
            clickElement(ROLES_ROW_ENTRY);
        else
            Assert.assertTrue("\n Group Role name ---> '" + roleName + "' <--- not found!", false);
        return this;
    }

    @Override
    public IAdministrationUserDetailPage clickSaveChanges(){
        log.info("");
        isVisible(SAVE_CHANGES_BUTTON, true);
        clickElement(SAVE_CHANGES_BUTTON);
        return new AdministrationUserDetailPage((SharedDriver) webDriver);
    }

    @Override
    public IAdministrationUserDetailPage clickCancel(){
        log.info("");
        isVisible(CANCEL_BUTTON, true);
        clickElement(CANCEL_BUTTON);
        return new AdministrationUserDetailPage((SharedDriver) webDriver);
    }

    @Override
    public IAdministrationUserDetailPage clickX(){
        log.info("");
        isVisible(X_BUTTON, true);
        clickElement(X_BUTTON);
        return new AdministrationUserDetailPage((SharedDriver) webDriver);
    }



}