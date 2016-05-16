package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver_Borrower;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class YourDependantsSection extends Borrower implements IYourDependantsSection {

    private static final Log log = LogFactory.getLog(YourDependantsSection.class.getName());

    public YourDependantsSection(SharedDriver_Borrower webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getTitle() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_TITLE_XPATH, 5);
        return getText(YOUR_DEPENDANTS_TITLE_XPATH);
    }

    @Override
    public String getDescription() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_DESCRIPTION_INTRO_XPATH, 0);
        return getText(YOUR_DEPENDANTS_DESCRIPTION_INTRO_XPATH);
    }

    @Override
    public String getDescription2() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_DESCRIPTION_INTRO2_XPATH, 0);
        return getText(YOUR_DEPENDANTS_DESCRIPTION_INTRO2_XPATH);
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
        clickElement(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
        typeEndWithTab(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, dateOfBirth, true);
        loadingCheck();
//        if (isVisible("//div[@id='ui-datepicker-div']", 0)) {
//            isVisible("//div[@id='ui-datepicker-div']//button[@data-event='click' and contains(., 'Done')]");
//            clickElement("//div[@id='ui-datepicker-div']//button[@data-event='click' and contains(., 'Done')]");
//        }
        return this;
    }

    @Override
    public IYourDependantsSection clickAddThisDependant() {
        // TODO to speak with Vili
        return clickAddThisDependant();
    }

    private Map<String, String> formExceptionDetails() {
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

    private boolean isDependantFormLoaded() {
        loadingCheck();
        isVisible(YOUR_DEPENDANTS_PANEL_XPATH, true, 0);
        isVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, true, 0);
        isVisible(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH, true, 0);
        return true;
    }

    private boolean isFirstScreenDisplayed() {
        if (!isVisible(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, 10)) {
            try {
                clickElementViaJavascript(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH, YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
            } catch (Exception x) {
                log.info("First screen was detected but clicking failed so trying to call second screen");
                Assert.assertEquals(
                        "Clicking on the second screen failed as well so test is quiting" +
                                "\n ------------------------------------------------------------- \n" +
                                "            Baikonur, we have a problem !!! " +
                                "\n ------------------------------------------------------------- \n",
                        isFirstDependantAlreadyAdded(),
                        true
                );
            }
            isDependantFormLoaded();
            return true;
        }
        return false;
    }

    protected boolean isFirstDependantAlreadyAdded() {


//
//        if(isVisible(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, 10)){
//            clickElementViaJavascript(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
//            isDependantFormLoaded();
//            return true;
//        }
//        log.info("Second screen was not loaded");
//        return false;

        return false;
    }

    @Override
    public IYourDependantsSection clickAddDependant() {
        loadingCheck();

        if (!isVisible(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, 1) && isVisible(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH, 1)) {
            try {
                clickElement(YOUR_DEPENDANTS_ADD_DEPENDANT_XPATH, YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
                return this;
            } catch (Exception x) {
                Assert.assertTrue("Baikonur we are on fire", false);
            }
        }

        if (isVisible(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, 1) && !isVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, 1)) {
            clickElement(YOUR_DEPENDANTS_ADD_DEPENDANTS_XPATH, YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH);
            return this;

        } else if (isVisible(YOUR_DEPENDANTS_DATE_OF_BIRTH_INPUT_XPATH, 1)) {
            return this;
        }

        Assert.assertTrue(false);
        return this;


//        loadingCheck();
//
//        if(isFirstScreenDisplayed()) {
//            return this;
//        } else if(isFirstDependantAlreadyAdded()) {
//            return this;
//        } else {
//            log.info("\n ------------------------------------------------------------------------ \n" +
//                    " | Navigation problem we are lost .... We should be Dependants main screen   | \n" +
//                    " | Or on your financial commitments page but none of those is being detected | \n" +
//                    " ------------------------------------------------------------------------- \n");
//
//            Assert.assertEquals("\n ------------------------------------------------------------------------ \n" +
//                                "            Baikonur, we have a problem !!! " +
//                                "\n ------------------------------------------------------------------------ \n",
//                    true,
//                    false
//            );
//        }
//        return this;
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