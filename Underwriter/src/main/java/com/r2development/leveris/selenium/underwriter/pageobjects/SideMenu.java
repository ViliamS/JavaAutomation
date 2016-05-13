package com.r2development.leveris.selenium.underwriter.pageobjects;

import com.r2development.leveris.Underwriter;
import com.r2development.leveris.bdd.underwriter.stepdef.SharedDriver;
import com.r2development.leveris.selenium.underwriter.pageobjects.LoanApplication.ILoanApplicationPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

public class SideMenu extends Underwriter implements ISideMenu {

    private static final Log log = LogFactory.getLog(SideMenu.class.getName());

    private WebDriver webDriver;

    protected IApplicationListPage applicationListPage;
    protected ILoanApplicationPage loanApplicationPage;
    protected IProfilePage profilePage;
    protected IApplicationProcessesList applicationProcessesList;
    protected ISessionListPage sessionListPage;

    public SideMenu(SharedDriver webDriver){
        super(webDriver);
        this.webDriver = webDriver;
    }

    @Override
    public IProfilePage clickProfile(){
        isVisible(PROFILE, true);
        clickElement(PROFILE);
        return profilePage;
    }

    @Override
    public IApplicationListPage clickApplication(){
        isVisible(APPLICATION, true);
        clickElement(APPLICATION);
        return applicationListPage;
    }

    @Override
    public void clickNotifications(){
        isVisible(NOTIFICATIONS);
        clickElement(NOTIFICATIONS);
    }

    @Override
    public void clickMessages(){
        isVisible(MESSAGES);
        clickElement(MESSAGES);
    }
}