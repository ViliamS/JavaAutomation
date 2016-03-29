package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.dependant;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;

import java.util.Map;

public class Dependant implements IDependant, IHeaderForm, IForm, ICancelSaveClose {

//    private final WebDriver webDriver;

    public Dependant(SharedDriver webDriver) {
//        this.webDriver = webDriver;
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
    public void FillIn(Map<String, String> data) {

    }

    @Override
    public IDependant typeDateOfBirth(String dateOfBirth) {
        return null;
    }

    @Override
    public void clickCancel() {
    }

    @Override
    public void clickSaveAndClose() {
    }
}