package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class AdministrationUserDetailPageEditDetails extends Apollo implements IAdministrationUserDetailPageEditDetails {

    private static final Log log = LogFactory.getLog(AdministrationUserDetailPageEditDetails.class.getName());

    WebDriver webDriver;

    public AdministrationUserDetailPageEditDetails(SharedDriver_Apollo webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

}
