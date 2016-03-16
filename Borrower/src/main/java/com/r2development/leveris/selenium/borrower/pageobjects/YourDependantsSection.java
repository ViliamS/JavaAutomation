package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class YourDependantsSection extends Borrower implements IYourDependantsSection {

    private static final Log log = LogFactory.getLog(YourDependantsSection.class);

    @FindBy(xpath = YOUR_DEPENDANTS_TITLE_XPATH)
    protected WebElement weYourDependantTitle;
    @FindBy(xpath = YOUR_DEPENDANTS_DESCRIPTION_INTRO_XPATH)
    protected WebElement weYourDependantDescriptionIntro;
    @FindBy(xpath = YOUR_DEPENDANTS_DESCRIPTION_INTRO2_XPATH)
    protected WebElement weYourDependantDescriptionIntro2;

//    @FindBy ( xpath = YOUR_DEPENDANT_SINGLE_NO_XPATH )
//    protected WebElement weYourDependantSingleNo;
//    @FindBy ( xpath = YOUR_DEPENDANT_SINGLE_YES_XPATH )
//    protected WebElement weYourDependantSingleYes;
//    @FindBy ( xpath = YOUR_DEPENDANT_COUPLE_NO_XPATH )
//    protected WebElement weYourDependantCoupleNo;
//    @FindBy ( xpath = YOUR_DEPENDANT_COUPLE_YES_XPATH )
//    protected WebElement weYourDependantCoupleYes;

    @FindBy(xpath = YOUR_DEPENDANTS_NONE_XPATH)
    protected WebElement weYourDependantNone;

    //div[contains(@id, 'DependentList')]
    //div[contains(@id, 'lblAge')]//span
    //a[contains(@wicketpath, 'lnkAge')]
    //div[contains(@id, 'BorrowerName')]/span
    //a[contains(@wicketpath, 'lnkDependentDelete')]

//    @FindBy ( xpath = YOUR_DEPENDANTS_APPLIES_TO_BORROWER_XPATH )
//    protected WebElement weYourDependantsAppliesToBorrower;
//    @FindBy ( xpath = YOUR_DEPENDANTS_APPLIES_TO_COAPPLICANT_XPATH )
//    protected WebElement weYourDependantsAppliesToCoapplicant;

    @FindBy(xpath = YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH)
    protected WebElement weYourDependantsDateOfBirthInput;

    @FindBy(xpath = YOUR_DEPENDANTS_ADD_THIS_DEPENDANT_XPATH)
    protected WebElement weYourDependantsAddThisDependant;
    @FindBy(xpath = YOUR_DEPENDANTS_SAVE_AND_CLOSE_XPATH)
    protected WebElement weYourDependantssaveAndClose;
    @FindBy(xpath = YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH)
    protected WebElement weYourDependantsAddDependant;
    @FindBy(xpath = YOUR_DEPENDANTS_EDIT_THIS_DEPENDANT_XPATH)
    protected WebElement weYourDependantsEditThisDependant;
    @FindBy(xpath = YOUR_DEPENDANTS_CANCEL_DEPENDANT_XPATH)
    protected WebElement weYourDependantsCancelDependant;
    @FindBy(xpath = YOUR_DEPENDANTS_NEXT_DEPENDANT_XPATH)
    protected WebElement weYourDependantsNextDependant;

    //    @Inject
    YourDependantsSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_TITLE_XPATH, 0);
        return weYourDependantTitle.getText();
    }

    @Override
    public String getDescription() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_DESCRIPTION_INTRO_XPATH, 0);
        return weYourDependantDescriptionIntro.getText();
    }

    @Override
    public String getDescription2() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_DESCRIPTION_INTRO2_XPATH, 0);
        return weYourDependantDescriptionIntro2.getText();
    }

    @Override
    public IYourDependantsSection clickNone() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_NONE_XPATH, 0);
        clickElement(YOUR_DEPENDANTS_NONE_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourDependantsSection clickNext() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_NEXT_DEPENDANT_XPATH, 0);
        clickElement(YOUR_DEPENDANTS_NEXT_DEPENDANT_XPATH);
        loadingCheck();
//        weYourDependantsNextDependent.click();
//        if(isVisible(INDICATOR_SMALL_ON, false, 5))
//            isInvisible(INDICATOR_SMALL_OFF, 5);
        return this;
    }

    @Override
    public IYourDependantsSection clickWaitWeHaveDependants() {
        return null;
    }

//    @Deprecated @Override
//    public IYourDependantsSection checkAccountAppliesToBorrower(String borrower) {
//        isVisible(YOUR_DEPENDANTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower));
//        getWebElement(YOUR_DEPENDANTS_APPLIES_TO_BORROWER_XPATH.replace("${replaceBorrower}$", borrower)).click();
//        return this;
//    }
//
//        @Override
//    public IYourDependantsSection checkAccountAppliesToCoapplicant(String coapplicant) {
//        isVisible(YOUR_DEPENDANTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant));
//        getWebElement(YOUR_DEPENDANTS_APPLIES_TO_COAPPLICANT_XPATH.replace("${replaceCoapplicant}$", coapplicant)).click();
//        return this;
//    }

    @Override
    public IYourDependantsSection typeDateOfBirth(String dateOfBirth) {
//        isVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, true);
//        weYourDependantsDateOfBirthInput.click();
//        weYourDependantsDateOfBirthInput.sendKeys(dateOfBirth);
        loadingCheck();
        type(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, dateOfBirth);
        loadingCheck();
        if (isVisible("//div[@id='ui-datepicker-div']", 0)) {
            isVisible("//div[@id='ui-datepicker-div']//button[@data-event='click' and contains(., 'Done')]");
            clickElement("//div[@id='ui-datepicker-div']//button[@data-event='click' and contains(., 'Done')]");
        }
        return this;
    }

    @Override
    public IYourDependantsSection clickAddThisDependant() {
        loadingCheck();
        if(isVisible(YOUR_DEPENDANTS_ADD_THIS_DEPENDANT_XPATH, 0)) {
            clickElement(YOUR_DEPENDANTS_ADD_THIS_DEPENDANT_XPATH);
            return this;
        } else if((isVisible(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, 0) || isVisible(YOUR_DEPENDANTS_ADD_DEPENDANT2_XPATH, 0)) && !isNotVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, 0)) {
            clickAddDependant();
            return this;
        } else if(isVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, 0))
            return this;

        Assert.assertTrue("We've got lost!!! go home looser ", false);
        return this;
    }

    private Map<String, String> formExceptionDetails(){
        Map<String, String> formExceptionDetails = new LinkedHashMap<>();
        formExceptionDetails.put(
                "FormName",
                "\n Adding of dependant failed because save button is still present! " +
                        "\n Extracting exception text from the form \n"
        );
        formExceptionDetails.put(
                "GetExceptionResult1",
                "\n -------------------------------" +
                        "\n | Not being able to save the form @!wtf!@ | " +
                        "\n | it is due to : '"
        );
        formExceptionDetails.put(
                "GetExceptionResult2",
                "' is displayed on page | " +
                        "\n ------------------------------- \n"
        );
        formExceptionDetails.put(
                "FormAction",
                "Failed clickSaveAndClose"
        );
        return formExceptionDetails;
    }

    @Override
    public IYourDependantsSection clickSaveAndClose() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_SAVE_AND_CLOSE_XPATH, 0);
        clickElement(YOUR_DEPENDANTS_SAVE_AND_CLOSE_XPATH);
        loadingCheck();

//        isNotVisible(YOUR_DEPENDANTS_PANEL_XPATH, true, 10);
//        try {
//            isVisible(YOUR_DEPENDANTS_TITLE_XPATH, true);
//        } catch (TimeoutException te) {
//            isVisible(YOUR_DEPENDANTS_TITLE2_XPATH, true);
//        }
        formSubmitPostSync(YOUR_DEPENDANTS_SAVE_AND_CLOSE_XPATH, formExceptionDetails());
        return this;
    }

    @Override
    public IYourDependantsSection clickAddDependant() {
        loadingCheck();

        if (!isVisible(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, 0) && !isVisible(YOUR_DEPENDANTS_SAVE_AND_CLOSE_XPATH, 0) && !isVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, 0) && !isVisible(FINANCIAL_COMMITMENTS_NAVIGATION_CHECK_XPATH, 0)) {
            if (isVisible(YOUR_DEPENDANTS_ADD_DEPENDANT2_XPATH, 0) && !isVisible(FINANCIAL_COMMITMENTS_NAVIGATION_CHECK_XPATH, 0)) {
                clickElement(YOUR_DEPENDANTS_ADD_DEPENDANT2_XPATH, YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
            } else {
                if(isVisible(FINANCIAL_COMMITMENTS_NAVIGATION_CHECK_XPATH)) {
                    log.info("\n ---------------------------------------------------------------------- \n" +
                            " | Navigation problem we are already on Your financial commitments page | \n" +
                            " ----------------------------------------------------------------------- \n");
                    return this;
                }
                else {
                    log.info("\n ------------------------------------------------------------------------ \n" +
                            " | Navigation problem we are lost .... We should be Dependants main screen   | \n" +
                            " | Or on your financial commitments page but none of those is being detected | \n" +
                            " ------------------------------------------------------------------------- \n");
                return this;
                }
            }
        } else if(isVisible(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, 10)) {
            clickElement(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
        }

//        try {
//            isVisible(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH, true);
//            clickElement(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH);
//            // getWebElement(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH).click();
//            //        weYourDependantsAddDependant.click();
//        } catch (Exception e) {
//            isVisible(YOUR_DEPENDANTS_ADD_DEPENDANT2_XPATH, true);
//            clickElementViaJavascript(YOUR_DEPENDANTS_ADD_DEPENDANT2_XPATH, YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
//        }
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_PANEL_XPATH, true, 0);
        isVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, true, 0);
        isVisible(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH, true, 0);
        return this;
    }

    @Override
    public IYourDependantsSection clickCancel() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_CANCEL_DEPENDANT_XPATH, 0);
        clickElement(YOUR_DEPENDANTS_CANCEL_DEPENDANT_XPATH);
        loadingCheck();
        return this;
    }

    @Override
    public IYourFinancialCommitmentsPage clickDone() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_DONE_XPATH, 0);
        clickElementViaJavascript(YOUR_DEPENDANTS_DONE_XPATH);
        loadingCheck();
        return new YourFinancialCommitmentsPage(webDriver);
    }

    @Override
    public String getDependantAge(int index) {
        return null;
    }

    @Override
    public IYourDependantsSection editDependant(int index) {
        return null;
    }

    @Override
    public IYourDependantsSection deleteDependant(int index) {
        return this;
    }
}
