package com.r2development.leveris.selenium.borrower.pageobjects;

import com.r2development.leveris.Borrower;
import com.r2development.leveris.bdd.borrower.stepdef.SharedDriver;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import net.lightbody.bmp.core.har.Har;

public class BuildQuoteSection extends Borrower implements IBuildQuoteSection {

    private static final Log log = LogFactory.getLog(BuildQuoteSection.class);

    @FindBy( xpath = BUILD_QUOTE_NUMBER_BORROWER_XPATH)
    protected WebElement weNumberBorrower;

    @FindBy( xpath = BUILD_QUOTE_GET_MY_QUOTE_XPATH )
    protected WebElement weGetQuote;

    @FindBy( xpath = BUILD_QUOTE_GET_MY_QUOTE_FAILURE_XPATH )
    protected WebElement weGetQuoteFailure;

//    @Inject
    public BuildQuoteSection(SharedDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public IBuildQuoteSection selectNumberOfBorrower(String nbBorrower) {
        selectFromDropDown(BUILD_QUOTE_NUMBER_BORROWER_XPATH, nbBorrower);
        return this;
    }

    @Override
    public IBuildQuoteSection clickNumberOfBorrower(String nbBorrowers) {
        switch (nbBorrowers) {
            case "two borrowers":
                if ( isVisible(BUILD_QUOTE_NUMBER_BORROWER_JOINT_LINK_XPATH, 5))
                    clickElement(BUILD_QUOTE_NUMBER_BORROWER_JOINT_LINK_XPATH);
                break;
            case "a single borrower":
                if ( isVisible(BUILD_QUOTE_NUMBER_BORROWER_SINGLE_LINK_XPATH, 5))
                    clickElement(BUILD_QUOTE_NUMBER_BORROWER_SINGLE_LINK_XPATH);
                break;
        }
        return this;
    }

    @Override
    public IBuildQuoteSection selectMortgageType(String mortgageType) {
        selectFromDropDown(BUILD_QUOTE_MORTGAGE_TYPE_XPATH, mortgageType);
        return this;
    }

    @Override
    public IBuildQuoteSection clickMortgageType(String mortgageType) {
        switch (mortgageType) {
            case "first-time buyer(s)":
                if ( isVisible(BUILD_QUOTE_MORTGAGE_TYPE_FIRST_TIME_BUYER_LINK_XPATH, 5))
                    clickElement(BUILD_QUOTE_MORTGAGE_TYPE_FIRST_TIME_BUYER_LINK_XPATH);
                break;
            case "mover(s":
                if ( isVisible(BUILD_QUOTE_MORTGAGE_TYPE_MOVER_LINK_XPATH, 5))
                    clickElement(BUILD_QUOTE_MORTGAGE_TYPE_MOVER_LINK_XPATH);
                break;
        }
        return this;
    }

    @Override
    public IBuildQuoteSection typeAge(String age) {
        type(BUILD_QUOTE_AGE_XPATH, age);
        return this;
    }

    @Override
    public IBuildQuoteSection typePartnerAge(String age) {
        if ( isVisible(BUILD_QUOTE_PARTNER_AGE_XPATH, 5 ))
            type(BUILD_QUOTE_PARTNER_AGE_XPATH, age);
        return this;
    }

    @Override
    public IBuildQuoteSection selectMaritalStatus(String maritalStatus) {
//        selectFromDropDown(BUILD_QUOTE_MARITAL_STATUS_XPATH, maritalStatus);

//        single|separated|married/civil partner\(s\)|divorced/dissolved civil partnership|widowed
        switch (maritalStatus) {
            case "single":
                clickElement(BUILD_QUOTE_MARITAL_STATUS_SINGLE_XPATH);
                break;
            case "separated":
                clickElement(BUILD_QUOTE_MARITAL_STATUS_SEPARATED_XPATH);
                break;
            case "married/civil partner\\(s\\)":
                clickElement(BUILD_QUOTE_MARITAL_STATUS_MARRIED_XPATH);
                break;
            case "divorced/dissolved civil partnership":
                clickElement(BUILD_QUOTE_MARITAL_STATUS_DIVORCED_XPATH);
                break;
            case "widowed":
                clickElement(BUILD_QUOTE_MARITAL_STATUS_WIDOWED_XPATH);
                break;
            default:
                log.error("Houston, we have an issue : marital status " + maritalStatus + " not valid");
        }

        return this;
    }

    @Override
    public IBuildQuoteSection typeTotalDependants(String totalDependants) {
        if (!StringUtils.isEmpty(totalDependants))
            type(BUILD_QUOTE_TOTAL_DEPENDANTS_XPATH, totalDependants);
        return this;
    }

    @Override
    public IBuildQuoteSection selectIncomeType(String incomeType) {

        switch (incomeType) {
            case "an employee":
                if ( isVisible(BUILD_QUOTE_INCOME_TYPE_EMPLOYEE_XPATH, 5) )
                    clickElement(BUILD_QUOTE_INCOME_TYPE_EMPLOYEE_XPATH);
                break;
            case "a civil servant":
                if ( isVisible(BUILD_QUOTE_INCOME_TYPE_CIVIL_SERVANT_XPATH, 5) )
                    clickElement(BUILD_QUOTE_INCOME_TYPE_CIVIL_SERVANT_XPATH);
                break;
            case "self employed":
                if ( isVisible(BUILD_QUOTE_INCOME_TYPE_SELF_EMPLOYEE_XPATH, 5) )
                    clickElement(BUILD_QUOTE_INCOME_TYPE_SELF_EMPLOYEE_XPATH);
                break;
            default:
        }

        return this;
    }

    @Override
    public IBuildQuoteSection selectPartnerIncomeType(String incomeType) {
        switch (incomeType) {
            case "an employee":
                if ( isVisible(BUILD_QUOTE_PARTNER_INCOME_TYPE_EMPLOYEE_XPATH, 5) )
                    clickElement(BUILD_QUOTE_PARTNER_INCOME_TYPE_EMPLOYEE_XPATH);
                break;
            case "a civil servant":
                if ( isVisible(BUILD_QUOTE_PARTNER_INCOME_TYPE_CIVIL_SERVANT_XPATH, 5) )
                    clickElement(BUILD_QUOTE_PARTNER_INCOME_TYPE_CIVIL_SERVANT_XPATH);
                break;
            case "self employed":
                if ( isVisible(BUILD_QUOTE_PARTNER_INCOME_TYPE_SELF_EMPLOYEE_XPATH, 5) )
                    clickElement(BUILD_QUOTE_PARTNER_INCOME_TYPE_SELF_EMPLOYEE_XPATH);
                break;
            default:
        }
        return this;
    }

    @Override
    public IBuildQuoteSection typeIncomeAmount(String incomeAmount) {
        if ( isVisible(BUILD_QUOTE_INCOME_AMOUNT_XPATH, 5) )
            type(BUILD_QUOTE_INCOME_AMOUNT_XPATH, incomeAmount);
        return this;
    }

    @Override
    public IBuildQuoteSection typePartnerIncomeAmount(String incomeAmount) {
        if ( isVisible(BUILD_QUOTE_PARTNER_INCOME_AMOUNT_XPATH, 5) )
            type(BUILD_QUOTE_PARTNER_INCOME_AMOUNT_XPATH, incomeAmount);
        return this;
    }

    @Override
    public IBuildQuoteSection typeMonthlyCreditCommitments(String monthCreditCommitment) {
        isVisible(BUILD_QUOTE_MONTHLY_CREDIT_COMMITMENT_XPATH, true, 5);
        type(BUILD_QUOTE_MONTHLY_CREDIT_COMMITMENT_XPATH, monthCreditCommitment);
        return this;
    }

    @Override
    public IBuildQuoteSection2 clickGetQuote() {
        isVisible(BUILD_QUOTE_GET_MY_QUOTE_XPATH, true);
        weGetQuote.click();
//        Har har = ApiSupportWebDriverStepDef.getProxyInstance().getHar();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        File harFile = new File("/Users/anthonymottot/Automation/Git/qa_automation/Aut-Abakus/Borrower/target/Har-" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//        try {
//            har.writeTo(harFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return new BuildQuoteSection2(webDriver);
    }

//    @Override
//    public IBuildQuoteSection2 clickGetQuoteFailure() {
////        isVisible(BUILD_QUOTE_GET_MY_QUOTE_FAILURE_XPATH, true);
//        weGetQuoteFailure.click();
//        return new BuildQuoteSection2(webDriver);
//    }

    @Override
    public boolean isLoaded() {
        return true;
    }
}
