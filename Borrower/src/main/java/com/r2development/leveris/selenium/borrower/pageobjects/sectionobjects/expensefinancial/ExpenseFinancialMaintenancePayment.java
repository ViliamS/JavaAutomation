package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.expensefinancial;

import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.ICancelSaveClose;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IForm;
import com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects.IHeaderForm;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Created by anthonymottot on 18/03/2016.
 */
public class ExpenseFinancialMaintenancePayment implements IExpenseFinancialMaintenancePayment, IHeaderForm, IForm, ICancelSaveClose {

    private final WebDriver webDriver;

    public ExpenseFinancialMaintenancePayment(SharedDriver webDriver) {
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
    public void FillIn(Map<String, String> data) {

    }

    @Override
    public IExpenseFinancialMaintenancePayment typeMaintenancepPayment(String payment) {
        return null;
    }

    @Override
    public void clickCancel() {

    }

    @Override
    public void clickSaveAndClose() {

    }
}
