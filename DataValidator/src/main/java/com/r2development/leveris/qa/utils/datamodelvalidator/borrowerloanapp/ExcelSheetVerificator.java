package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.CoapplicantEmploymentAndIncome.*;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.EmploymentAndIncome.*;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails.PERSONAL_DETAILS;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails.PERSONAL_DETAILS_coapplicant;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Quotation.QUOTATION;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Quotation.QUOTATION_inviteCoapplicant;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Registration.BORROWER_TEST_DATA;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourAccounts.YACCOUNTS_currentAccount;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourAccounts.YACCOUNTS_savingsAccount;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourDependents.YDEPENDENTS;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFinancialAssets.*;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFinancialCommitments.*;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFunding.YFUNDING_gift;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFunding.YFUNDING_inheritance;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourFunding.YFUNDING_other;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourProperties.YPROPERTIES_holidayHome;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourProperties.YPROPERTIES_investment;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.YourProperties.YPROPERTIES_principalDwellingHouse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public enum ExcelSheetVerificator implements IBWSheetInterface {

    REGISTRATION(                                           registration),
    QUOTATION_sheetName (                                   quotation),
    INVITE_CO_APPLICANT (                                   inviteCoapplicant),
    BW_PERSONAL_DETAILS_sheetName(                          borrowerPersonalDetails),
    COAPP_PERSONAL_DETAILS_sheetName(                       coapplicantPersonalDetails),
    BW_EMPLOYMENT_AND_INCOME_PAYE(                          borrowerEmploymentAndIncomePAYE),
    BW_EMPLOYMENT_AND_INCOME_SELF_EMPLOYED(                 borrowerEmploymentAndIncomeSelfEmployed),
    BW_EMPLOYMENT_AND_INCOME_OTHER(                         borrowerEmploymentAndIncomeOther),
    BW_EMPLOYMENT_AND_INCOME_CIVIL_SERVANT(                 borrowerEmploymentAndIncomeCivilServant),
    BW_EMPLOYMENT_AND_INCOME_UNEMPLOYED_HOMEMAKER(          borrowerEmploymentAndIncomeUnemployedHomemaker),
    COAPP_EMPLOYMENT_AND_INCOME_PAYE(                       coappEmploymentAndIncomePAYE),
    COAPP_EMPLOYMENT_AND_INCOME_SELF_EMPLOYED(              coappEmploymentAndIncomeSelfEmployed),
    COAPP_EMPLOYMENT_AND_INCOME_OTHER(                      coappEmploymentAndIncomeOther),
    COAPP_EMPLOYMENT_AND_INCOME_CIVIL_SERVANT(              coappEmploymentAndIncomeCivilServant),
    COAPP_EMPLOYMENT_AND_INCOME_UNEMPLOYED_HOMEMAKER(       coappEmploymentAndIncomeUnemployedHomemaker),
    YOUR_FINANCIAL_ASSETS_INVESTMENT_AND_PRODUCT_FUNDS(     yourFinancialAssetsInvestmentProductFundsBonds),
    YOUR_FINANCIAL_ASSETS_SHARES (                          yourFinancialAssetsShares),
    YOUR_FINANCIAL_ASSETS_SHARE_OPTIONS (                   yourFinancialAssetsShareOptions),
    YOUR_FINANCIAL_ASSETS_LANDSITE (                        yourFinancialAssetsLandSite),
    YOUR_FINANCIAL_ASSETS_LIFE_POLICY (                     yourFinancialAssetsLifePolicy),
    YOUR_FINANCIAL_ASSETS_OTHER (                           yourFinancialAssetsOther),
    YOUR_ACCOUNTS_CURRENT_ACCOUNT (                         yourAccountsCurrentAccount),
    YOUR_ACCOUNTS_SAVINGS_ACCOUNT (                         yourAccountsSavingsAccount),
    YOUR_PROPERTIES_PRINCIPAL_DWELLING_HOUSE (              yourPropertiesPrincipalDwellingHouse),
    YOUR_PROPERTIES_INVESTMENT (                            yourPropertiesInvestment),
    YOUR_PROPERTIES_HOLIDAY_HOME (                          yourPropertiesHolidayHome),
    YOUR_DEPENDENTS (                                       yourDependents),
    YOUR_FINANCIAL_COMMITMENTS_PERSONAL_LOAN (              yourFinancialCommitmentsPersonalLoan),
    YOUR_FINANCIAL_COMMITMENTS_CAR_LOAN (                   yourFinancialCommitmentsCarLoan),
    YOUR_FINANCIAL_COMMITMENTS_STUDENT_LOAN (               yourFinancialCommitmentsStudentLoan),
    YOUR_FINANCIAL_COMMITMENTS_CREDIT_CARD (                yourFinancialCommitmentsCreditCard),
    YOUR_FINANCIAL_COMMITMENTS_OTHER (                      yourFinancialCommitmentsOther),
    YOUR_FINANCIAL_COMMITMENTS_MAINTENANCE_PAYMENT (        yourFinancialCommitmentsMaintenancePayment),
    YOUR_FUNDING_GIFT(                                      yourFundingGift),
    YOUR_FUNDING_INHERITANCE(                               yourFundingInheritance),
    YOUR_FUNDING_OTHER(                                     yourFundingOther);

    private String sheetName;

    /**
     * For logging purposes
     */
    private static final Log log = LogFactory.getLog(ExcelSheetVerificator.class.getName());

    /**
     * This works as Constructor for enum declaration
     * @param sheetName - String with content of sheetName
     */
    ExcelSheetVerificator(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * Returns Enum value from the data table above
     * @return - String for specified Enum entry
     */
    public String getSheetName(){
        return sheetName;
    }

    /**
     * Not used as I figured out things I need to do in a different way... but keeping it here pro strycka prihodu
     * @param method -
     * @param sheetName -
     * @param strings -
     * @return -
     * @throws ReflectiveOperationException
     */
    public static Object getEnumMethod(String method, String sheetName, String ... strings) throws ReflectiveOperationException {

        Class<?> classLoader = ExcelSheetVerificator.getSpecificSheetClassLoader(sheetName);

        assert classLoader != null;
        Method methodClassLoading = classLoader.getClass().getMethod(method, LinkedList.class);

        return methodClassLoading.invoke(Objects.requireNonNull(classLoader));
    }

    /**
     * Not used as I figured out things I need to do in a different way... but keeping it here pro strycka prihodu
     * @param sheetName -
     * @return -
     * @throws ClassNotFoundException
     */
    public static Class<?> getSpecificSheetClassLoader(String sheetName) throws ClassNotFoundException {
        log.debug("ExcelSheetVerificator method getSheetEnumClass(\n" +
                "String switchCaseReturns = '" + sheetName + "',\n" +
                ")");

        switch(sheetName){

            case registration :
                return BORROWER_TEST_DATA.getClassLoader().getClass();

            case quotation :
                return QUOTATION.getClassLoader().getClass();

            case inviteCoapplicant :
                return QUOTATION_inviteCoapplicant.getEnumClassLoader();

            case borrowerPersonalDetails :
                return PERSONAL_DETAILS.getEnumClassLoader();

            case coapplicantPersonalDetails :
                return PERSONAL_DETAILS_coapplicant.getEnumClassLoader();

            case borrowerEmploymentAndIncomePAYE :
                return EMPANDINCOME_paye.getEnumClassLoader();

            case borrowerEmploymentAndIncomeSelfEmployed :
                return EMPANDINCOME_selfEmployed.getEnumClassLoader();

            case borrowerEmploymentAndIncomeOther :
                return EMPANDINCOME_other.getEnumClassLoader();

            case borrowerEmploymentAndIncomeCivilServant :
                return EMPANDINCOME_civilServant.getEnumClassLoader();

            case borrowerEmploymentAndIncomeUnemployedHomemaker :
                return EMPANDINCOME_unemployedHomemaker.getEnumClassLoader();

            case coappEmploymentAndIncomePAYE :
                return COAPP_EMPANDINCOME_paye.getEnumClassLoader();

            case coappEmploymentAndIncomeSelfEmployed :
                return COAPP_EMPANDINCOME_selfEmployed.getEnumClassLoader();

            case coappEmploymentAndIncomeOther :
                return COAPP_EMPANDINCOME_other.getEnumClassLoader();

            case coappEmploymentAndIncomeCivilServant :
                return COAPP_EMPANDINCOME_civilServant.getEnumClassLoader();

            case coappEmploymentAndIncomeUnemployedHomemaker :
                return COAPP_EMPANDINCOME_unemployedHomemaker.getEnumClassLoader();

            case yourFinancialAssetsInvestmentProductFundsBonds :
                return FASSETS_investmentProductFundsBonds.getEnumClassLoader();

            case yourFinancialAssetsShares :
                return FASSETS_shares.getEnumClassLoader();

            case yourFinancialAssetsShareOptions :
                return FASSETS_shareOptions.getEnumClassLoader();

            case yourFinancialAssetsLandSite :
                return FASSETS_landSite.getEnumClassLoader();

            case yourFinancialAssetsLifePolicy :
                return FASSETS_lifePolicy.getEnumClassLoader();

            case yourFinancialAssetsOther :
                return FASSETS_other.getEnumClassLoader();

            case yourAccountsSavingsAccount :
                return YACCOUNTS_savingsAccount.getEnumClassLoader();

            case yourAccountsCurrentAccount :
                return YACCOUNTS_currentAccount.getEnumClassLoader();

            case yourPropertiesPrincipalDwellingHouse :
                return YPROPERTIES_principalDwellingHouse.getEnumClassLoader();

            case yourPropertiesHolidayHome :
                return YPROPERTIES_holidayHome.getEnumClassLoader();

            case yourPropertiesInvestment :
                return YPROPERTIES_investment.getEnumClassLoader();

            case yourDependents :
                return YDEPENDENTS.getEnumClassLoader();

            case yourFinancialCommitmentsCarLoan :
                return FCOMMITMENTS_carLoan.getEnumClassLoader();

            case yourFinancialCommitmentsCreditCard :
                return FCOMMITMENTS_creditCard.getEnumClassLoader();

            case yourFinancialCommitmentsMaintenancePayment :
                return FCOMMITMENTS_maintenancePayment.getEnumClassLoader();

            case yourFinancialCommitmentsOther :
                return FCOMMITMENTS_other.getEnumClassLoader();

            case yourFinancialCommitmentsPersonalLoan :
                return FCOMMITMENTS_personalLoan.getEnumClassLoader();

            case yourFinancialCommitmentsStudentLoan :
                return FCOMMITMENTS_studentLoan.getEnumClassLoader();

            case yourFundingGift :
                return YFUNDING_gift.getEnumClassLoader();

            case yourFundingInheritance :
                return YFUNDING_inheritance.getEnumClassLoader();

            case yourFundingOther :
                return YFUNDING_other.getEnumClassLoader();
        }
        return null;
    }

    /**
     * Provides set of SheetNames that we expect to be present for Borrower Loan Application Excel Sheet
     * @return - List<String> expectedSheetNames
     */
    public static List<String> getAllPossibleSheetNames(){
        log.debug("ExcelSheetVerificator executing method getAllPossibleSheetNames");

        List<String> sheetNames = new LinkedList<>();

        for(int i = 0; i < ExcelSheetVerificator.values().length; i++ ){

            sheetNames.add(i, ExcelSheetVerificator.values()[i].getSheetName());

            log.debug("sheetNames[i] = '" + i + ", " + sheetNames.get(i) + "'");
        }
        log.debug("expectedSheetNames = '" + sheetNames + "'");
        return sheetNames;
    }
}
