package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.account;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import com.r2development.leveris.selenium.borrower.pageobjects.IYourDependantsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import org.openqa.selenium.WebDriver;

public class AccountsList implements IAccountsList/*, IHeaderForm*/ {

    private final WebDriver webDriver;

    public AccountsList(SharedDriver_Borrower webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public IForm selectAccountType(String accountFormType) {
        IForm toReturn = null;
        switch (accountFormType) {
            case "Current account":
                toReturn = this.clickCurrentAccount();
                break;
            case "Savings account":
                toReturn = this.clickSavingsAccount();
                break;
            case "Scrapping account":
                toReturn = this.clickAccountScraping();
                break;
            default:
        }
        return toReturn;
    }

    @Override
    public IForm clickCurrentAccount() {
        System.out.println("clickCurrentAccount");
        return new CurrentAccount((SharedDriver_Borrower) webDriver);
    }

    @Override
    public IForm clickSavingsAccount() {
        System.out.println("clickCurrentAccount");
        return new SavingsAccount((SharedDriver_Borrower) webDriver);
    }

    @Override
    public IForm clickAccountScraping() {
        return null;
    }

    @Override
    public IYourDependantsPage clickDone() {
        return null;
    }
}