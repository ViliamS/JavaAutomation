package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourDependentsSection extends Borrower implements IYourDependentsSection {

    private static final Log log = LogFactory.getLog(YourDependentsSection.class);

    @FindBy( xpath = YOUR_DEPENDENTS_TITLE_XPATH )
    protected WebElement weYourDependentTitle;
    @FindBy ( xpath = YOUR_DEPENDENTS_DESCRIPTION_INTRO_XPATH )
    protected WebElement weYourDependentDescriptionIntro;
    @FindBy ( xpath = YOUR_DEPENDENTS_DESCRIPTION_INTRO2_XPATH )
    protected WebElement weYourDependentDescriptionIntro2;

//    @FindBy ( xpath = YOUR_DEPENDENT_SINGLE_NO_XPATH )
//    protected WebElement weYourDependentSingleNo;
//    @FindBy ( xpath = YOUR_DEPENDENT_SINGLE_YES_XPATH )
//    protected WebElement weYourDependentSingleYes;
//    @FindBy ( xpath = YOUR_DEPENDENT_COUPLE_NO_XPATH )
//    protected WebElement weYourDependentCoupleNo;
//    @FindBy ( xpath = YOUR_DEPENDENT_COUPLE_YES_XPATH )
//    protected WebElement weYourDependentCoupleYes;

    @FindBy ( xpath = YOUR_DEPENDENTS_NONE_XPATH )
    protected WebElement weYourDependentNone;

    //div[contains(@id, 'DependentList')]
    //div[contains(@id, 'lblAge')]//span
    //a[contains(@wicketpath, 'lnkAge')]
    //div[contains(@id, 'BorrowerName')]/span
    //a[contains(@wicketpath, 'lnkDependentDelete')]

//    @FindBy ( xpath = YOUR_DEPENDENTS_APPLIES_TO_BORROWER_XPATH )
//    protected WebElement weYourDependentsAppliesToBorrower;
//    @FindBy ( xpath = YOUR_DEPENDENTS_APPLIES_TO_COAPPLICANT_XPATH )
//    protected WebElement weYourDependentsAppliesToCoapplicant;

    @FindBy ( xpath = YOUR_DEPENDENTS_DATE_OF_BIRTH_INPUT_XPATH )
    protected WebElement weYourDependentsDateOfBirthInput;

    @FindBy ( xpath = YOUR_DEPENDENTS_ADD_THIS_DEPENDENT_XPATH )
    protected WebElement weYourDependentsAddThisDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_SAVE_AND_CLOSE_XPATH )
    protected WebElement weYourDependentsSaveAndClose;
    @FindBy ( xpath = YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH )
    protected WebElement weYourDependentsAddDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_EDIT_THIS_DEPENDENT_XPATH )
    protected WebElement weYourDependentsEditThisDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_CANCEL_DEPENDENT_XPATH )
    protected WebElement weYourDependentsCancelDependent;
    @FindBy ( xpath = YOUR_DEPENDENTS_NEXT_DEPENDENT_XPATH )
    protected WebElement weYourDependentsNextDependent;

//    @Inject
    YourDependentsSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        isVisible(YOUR_DEPENDENTS_TITLE_XPATH, true, 10);
        return weYourDependentTitle.getText();
    }

    @Override
    public String getDescription() {
        isVisible(YOUR_DEPENDENTS_DESCRIPTION_INTRO_XPATH, true);
        return weYourDependentDescriptionIntro.getText();
    }

    @Override
    public String getDescription2() {
        isVisible(YOUR_DEPENDENTS_DESCRIPTION_INTRO2_XPATH, true);
        return weYourDependentDescriptionIntro2.getText();
    }

    @Override
    public IYourDependentsSection clickNone() {
        isVisible(YOUR_DEPENDENTS_NONE_XPATH, true);
        weYourDependentNone.click();
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
    public IYourDependentsSection clickWaitWeHaveDependents() {
        return null;
    }

//    @Deprecated @Override
//    public IYourDependentsSection checkAccountAppliesToBorrower(String borrower) {
//        isVisible(YOUR_DEPENDENTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower));
//        getWebElement(YOUR_DEPENDENTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower)).click();
//        return this;
//    }
//
//        @Override
//    public IYourDependentsSection checkAccountAppliesToCoapplicant(String coapplicant) {
//        isVisible(YOUR_DEPENDENTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant));
//        getWebElement(YOUR_DEPENDENTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant)).click();
//        return this;
//    }

    @Override
    public IYourDependentsSection typeDateOfBirth(String dateOfBirth) {
//        isVisible(YOUR_DEPENDENTS_DATE_OF_BIRTH_INPUT_XPATH, true);
//        weYourDependentsDateOfBirthInput.click();
//        weYourDependentsDateOfBirthInput.sendKeys(dateOfBirth);
        sendKeysElement(YOUR_DEPENDENTS_DATE_OF_BIRTH_INPUT_XPATH, dateOfBirth, 60);
        if ( isVisible("//div[@id='ui-datepicker-div']") ) {
            isVisible("//div[@id='ui-datepicker-div']//button[@data-event='click' and contains(., 'Done')]");
            clickElement("//div[@id='ui-datepicker-div']//button[@data-event='click' and contains(., 'Done')]");
        }
        return this;
    }

    @Override
    public IYourDependentsSection clickAddThisDependent() {
        isVisible(YOUR_DEPENDENTS_ADD_THIS_DEPENDENT_XPATH, true);
        weYourDependentsAddThisDependent.click();
        return this;
    }

    @Override
    public IYourDependentsSection clickSaveAndClose() {
        isVisible(YOUR_DEPENDENTS_SAVE_AND_CLOSE_XPATH, true, 15);
        weYourDependentsSaveAndClose.click();
        isNotVisible(YOUR_DEPENDENTS_PANEL_XPATH, true, 10);
        try {
            isVisible(YOUR_DEPENDENTS_TITLE_XPATH, true);
        } catch( TimeoutException te ) {
            isVisible(YOUR_DEPENDENTS_TITLE2_XPATH, true);
        }
        return this;
    }

    @Override
    public IYourDependentsSection clickAddDependent() {
        try {
            isVisible(YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH, true);
            getWebElement(YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH).click();
            //        weYourDependentsAddDependent.click();
        } catch (Exception e) {
            isVisible(YOUR_DEPENDENTS_ADD_DEPENDENT2_XPATH, true);
            clickElementViaJavascript(YOUR_DEPENDENTS_ADD_DEPENDENT2_XPATH, YOUR_DEPENDENTS_DATE_OF_BIRTH_INPUT_XPATH);
        }

//        isNotVisible(YOUR_DEPENDENTS_PANEL_XPATH, true, 15);
        isVisible(YOUR_DEPENDENTS_PANEL_XPATH, 5);
        isVisible(YOUR_DEPENDENTS_DATE_OF_BIRTH_INPUT_XPATH, 5);
        isVisible(YOUR_DEPENDENTS_ADD_DEPENDENT_XPATH, 5);
        return this;
    }

    @Override
    public IYourDependentsSection clickCancel() {
        isVisible(YOUR_DEPENDENTS_CANCEL_DEPENDENT_XPATH, true);
        weYourDependentsCancelDependent.click();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDone() {
        isVisible(YOUR_DEPENDENTS_DONE_XPATH, true);
        clickElementViaJavascript(YOUR_DEPENDENTS_DONE_XPATH);
        return new YourFinancialCommitmentsPage(webDriver);
    }

    @Override
    public String getDependentAge(int index) {
        return null;
    }

    @Override
    public IYourDependentsSection editDependent(int index) {
        return null;
    }

    @Override
    public IYourDependentsSection deleteDependent(int index) {
        return this;
    }

}
