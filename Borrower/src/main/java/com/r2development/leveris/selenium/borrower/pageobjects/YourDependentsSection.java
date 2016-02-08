package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourDependentsSection extends Borrower implements IYourDependentsSection {

    private static final Log log = LogFactory.getLog(YourDependentsSection.class);

    @FindBy( xpath = YOUR_DEPENDENT_TITLE_XPATH )
    protected WebElement weYourDependentTitle;
    @FindBy ( xpath = YOUR_DEPENDENT_DESCRIPTION_XPATH )
    protected WebElement weYourDependentDescription;

    @FindBy ( xpath = YOUR_DEPENDENT_SINGLE_NO_XPATH )
    protected WebElement weYourDependentSingleNo;
    @FindBy ( xpath = YOUR_DEPENDENT_SINGLE_YES_XPATH )
    protected WebElement weYourDependentSingleYes;
    @FindBy ( xpath = YOUR_DEPENDENT_COUPLE_NO_XPATH )
    protected WebElement weYourDependentCoupleNo;
    @FindBy ( xpath = YOUR_DEPENDENT_COUPLE_YES_XPATH )
    protected WebElement weYourDependentCoupleYes;

    //div[contains(@id, 'DependentList')]
    //div[contains(@id, 'lblAge')]//span
    //a[contains(@wicketpath, 'lnkAge')]
    //div[contains(@id, 'BorrowerName')]/span
    //a[contains(@wicketpath, 'lnkDependentDelete')]

    @FindBy ( xpath = YOUR_DEPENDENTS_APPLIES_TO_BORROWER_XPATH )
    protected WebElement weYourDependentsAppliesToBorrower;
    @FindBy ( xpath = YOUR_DEPENDENTS_APPLIES_TO_COAPPLICANT_XPATH )
    protected WebElement weYourDependentsAppliesToCoapplicant;
    @FindBy ( xpath = YOUR_DEPENDENTS_DATE_OF_BIRTH_XPATH )
    protected WebElement weYourDependentsDateOfBirth;

    @FindBy ( xpath = YOUR_DEPENDENTS_ADD_THIS_DEPENDENT_XPATH )
    protected WebElement weYourDependentsAddThisDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH )
    protected WebElement weYourDependentsAddDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_EDIT_THIS_DEPENDENT_XPATH )
    protected WebElement weYourDependentsEditThisDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_CANCEL_DEPENDENT_XPATH )
    protected WebElement weYourDependentsCancelDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_NEXT_DEPENDENT_XPATH )
    protected WebElement weYourDependentsNextDependent;


    YourDependentsSection(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        isVisible(YOUR_DEPENDENT_TITLE_XPATH, true, 10);
        return weYourDependentTitle.getText();
    }

    @Override
    public String getDescription() {
        isVisible(YOUR_DEPENDENT_DESCRIPTION_XPATH, true);
        return weYourDependentDescription.getText();
    }

    @Override
    public IYourDependentsSection clickSingleYes() {
        isVisible(YOUR_DEPENDENT_SINGLE_YES_XPATH, true);
        weYourDependentSingleYes.click();
        return this;
    }

    @Override
    public IYourDependentsSection clickSingleNo() {
        isVisible(YOUR_DEPENDENT_SINGLE_NO_XPATH, true);
        weYourDependentSingleNo.click();
        return this;
    }

    @Override
    public IYourDependentsSection clickCoupleYes() {
        isVisible(YOUR_DEPENDENT_COUPLE_YES_XPATH, true);
        weYourDependentCoupleYes.click();
        return this;
    }

    @Override
    public IYourDependentsSection clickCoupleNo() {
        isVisible(YOUR_DEPENDENT_COUPLE_NO_XPATH, true);
        weYourDependentCoupleNo.click();
        return this;
    }

    @Override
    public IYourDependentsSection checkAccountAppliesToBorrower(String borrower) {
        isVisible(YOUR_DEPENDENTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower));
        getWebElement(YOUR_DEPENDENTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower)).click();
        return this;
    }

    @Override
    public IYourDependentsSection checkAccountAppliesToCoapplicant(String coapplicant) {
        isVisible(YOUR_DEPENDENTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant));
        getWebElement(YOUR_DEPENDENTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant)).click();
        return this;
    }

    @Override
    public IYourDependentsSection typeDateOfBirth(String dateOfBirth) {
        isVisible(YOUR_DEPENDENTS_DATE_OF_BIRTH_XPATH, true);
        weYourDependentsDateOfBirth.click();
        weYourDependentsDateOfBirth.sendKeys(dateOfBirth);
        return this;
    }

    @Override
    public IYourDependentsSection clickAddThisDependent() {
        isVisible(YOUR_DEPENDENTS_ADD_THIS_DEPENDENT_XPATH, true);
        weYourDependentsAddThisDependent.click();
        return this;
    }

    @Override
    public IYourDependentsSection clickCancel() {
        isVisible(YOUR_DEPENDENTS_CANCEL_DEPENDENT_XPATH, true);
        weYourDependentsCancelDependent.click();
        return this;
    }

    @Override
    public IYourDependentsSection clickAddDependent() {
        isVisible(YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH, true);
        weYourDependentsAddDependent.click();
        return this;
    }

    @Override
    public IYourDependentsSection clickNext() {
        isVisible(YOUR_DEPENDENTS_NEXT_DEPENDENT_XPATH, true);
        clickElement(YOUR_DEPENDENTS_NEXT_DEPENDENT_XPATH);
//        weYourDependentsNextDependent.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourDependentsSection clickEditThisDependent(int index) {
        // TODO to handle the index
        isVisible(YOUR_DEPENDENTS_EDIT_THIS_DEPENDENT_XPATH, true);
        weYourDependentsEditThisDependent.click();
        return this;
    }

    @Override
    public String getDependentAge(int index) {
        return null;
    }

    @Override
    public String getBorrowerName(int index) {
        return null;
    }

    @Override
    public IYourDependentsSection deleteDependent(int index) {
        return this;
    }

    @Override
    public IYourDependentsSection clickDependentPanel(int index) {
        return this;
    }
}
