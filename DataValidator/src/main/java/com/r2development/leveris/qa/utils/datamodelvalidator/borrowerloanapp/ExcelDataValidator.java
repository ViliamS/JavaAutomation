package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.CoapplicantEmploymentAndIncome.COAPP_EMPANDINCOME_civilServant;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.EmploymentAndIncome.*;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails.PERSONAL_DETAILS;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails.PERSONAL_DETAILS_coapplicant;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.PersonalDetails.PERSONAL_DETAILS_subCountry;
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
import com.r2development.leveris.qa.utils.ACMExcel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.io.IOException;
import java.util.*;

public class ExcelDataValidator {

    private static final Log log = LogFactory.getLog(ExcelDataValidator.class.getName());
    private static Map<Integer, String> sheetNames;
    public String filePath;
    public static ExcelDataValidator dataValidator;

    /**
     * Example filePath : "/src/test/resources/ExcelDataFiles/Borrower_UI_Automation.xls"
     * @param filePath - String containing path to an Excel Data Template
     * @throws IOException
     */
    public ExcelDataValidator(String filePath) throws IOException {
        this.filePath = filePath;
        ExcelDataValidator.sheetNames = ACMExcel.getSheetNames(filePath);
    }

    public static ExcelDataValidator dataValidator(String filePath) throws IOException {
        ExcelDataValidator.dataValidator = new ExcelDataValidator(filePath);
        return new ExcelDataValidator(filePath);
    }

    /**
     *
     * Checking item containing in the arrays from a Map
     *
     *  This check should be optional because we want to have
     * @return true / false depending on validation result
     */
    public Boolean doBWLoanAppSheetValidation(){
        log.info("doBWLoanAppSheetValidation()");

        Collection<String> excelSheetLoads = sheetNamesUnIndexed(ExcelDataValidator.sheetNames);
        log.info("Collection excelSheetLoads = sheetNamesUnIndexed(ExcelDataValidator.sheetNames); == '" + excelSheetLoads + "'");

        Collection<String> results = ExcelSheetVerificator.getAllPossibleSheetNames();
        log.info("Collection results = ExcelSheetVerificator.getAllPossibleSheetNames(); == '" + results + "'");

        excelSheetLoads.removeAll(results);
        log.info("Collection excelSheetLoads = excelSheetLoads.removeAll(results); == '" + excelSheetLoads + "'");

        if(excelSheetLoads.size() != 0) {
            for (int x = 0; x < excelSheetLoads.size(); x++) {

                log.info("There was not validated ["+ x +"] sheetName : '" + excelSheetLoads.toArray()[x] + "'");

                Assert.assertFalse("There was(were) not validated sheet(s) : '" + excelSheetLoads + "'", true);
            }
            return false;
        }
        return true;
    }

    /**
     * Creating a Collection of un-indexed sheetNames
     * @param sheetNames - Map<Integer, String> - this variable is provided by calling of ACMExcel library method "ACMExcel.getSheetNames(filePath);"
     * @return - Collection of sheetNames without indexes "Sheet Name.2 ... Sheet Name.INDEX" where ".INDEX" is removed for comparison with expected sheet names.
     */
    public Collection<String> sheetNamesUnIndexed(Map<Integer, String> sheetNames){
        log.debug("Method sheetNameUnIndexed(Map<Integer, String> sheetNames) call");

        Collection<String> unIndexedSheetNames = new LinkedList<>();

        for (int i = 0; i < sheetNames.size(); i++){
            unIndexedSheetNames.add(ExcelDataValidator.sheetNameUnIndexed(sheetNames.get(i)));
        }
        if(unIndexedSheetNames.size() < 1){
            Assert.assertFalse("There is some problem with expectedSheets un-indexing", true);
        }

//        Assert.assertTrue("There is some problem with expectedSheets un-indexing", (unIndexedSheetNames.size() < 1));

        return unIndexedSheetNames;
    }

    /**
     * Removing an index from sheetName [handling cases when we have more same entries to fill into borrower loan application and validation would fail for any entry different
     * from expected non-indexed entry. so this method is stripping the index from inputted sheetName if is detected.
     * @param sheetName - String sheetName which we want to be sure that it is ended by "example some sheet name.2" or "BW Personal Details.X" ... so we compare only the sheetName
     * @return - sheetName without index. example : inputted was sheet name "BW Personal Details.XXX" returned would be "BW Personal Details"
     */
    public static String sheetNameUnIndexed(String sheetName){
        boolean isIndexed = sheetName.contains(".");
        if(isIndexed){
            log.info("sheetName = '" + sheetName + "' is Indexed so we must cut the index for passing verification successfully");
            int suffixToCutPosition = sheetName.indexOf(".");
            sheetName = sheetName.subSequence(0, suffixToCutPosition).toString();
            log.info("changed sheetName = '" + sheetName + "'");
        }
        return sheetName;
    }

    /**
     *
     * @param allDataMap Collection Data loaded from Excel
     * @param sheetName SheetName linked to the borrower form
     * @param dataToSearchIn data to search in
     * @return -
     */
    public static Map<String, Map<String, String>> addDataMapAddSheetNameWithIndex(Map<String, Map<String, String>> allDataMap, String sheetName, Map<String, String> dataToSearchIn){
        Map<String, Integer> duplicityMap = new LinkedHashMap<>();
        boolean isIndexed = sheetName.contains(".");

        if(allDataMap.get(sheetName) == null || !isIndexed) {
            allDataMap.put(sheetName, dataToSearchIn);
            duplicityMap.put(sheetName, 1);
        } else {
            int i = duplicityMap.getOrDefault(sheetName, 0);
            String sheetNameWithIndex = sheetName + "." + i;

            while (allDataMap.getOrDefault(sheetName + "." + i, null) == dataToSearchIn) {

                if (allDataMap.get(sheetNameWithIndex) == null) {
                    allDataMap.put(sheetNameWithIndex, dataToSearchIn);
                    duplicityMap.replace(sheetName, duplicityMap.get(sheetName) + 1);
                }
                i++;
            }
        }
        allDataMap.putIfAbsent(sheetName, dataToSearchIn);
        return allDataMap;
    }

    /**
     * Provides a checkPoint for cases where just a part of sheetName is present, because the second part is actually trigger point
     * @param sheetName - String with whole sheet Name that is going to be verified
     * @return true - if passed / false - if failed
     */
    public static boolean checkContainsSheet(String sheetName){
        sheetName = sheetNameUnIndexed(sheetName);
        List<String> sheetNames = ExcelSheetVerificator.getAllPossibleSheetNames();

        for(int i = 0; i < sheetNames.size(); i++) {
            log.debug("check round '" + i + "' verification of LoadedSheetName = '" + sheetName + "' vs. \n" +
                               "                                                                                   '" + sheetNames.get(i) + "'"
            );
            if (sheetNames.get(i).contains(sheetName)){
                log.debug("Passed returning true");
                return true;
            }
        }
        log.debug("Failed returning false");
        return false;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isSizeSameMapLinkedListComparison(List<String> expectedFields, Map<String, String> dataToVerifyWhole) throws Exception { log.info("");
        List<String> dataToVerify = new LinkedList<>(convertMapToLinkedList(dataToVerifyWhole));

//        Collection<String> all = dataToVerify;
//        all.removeAll(expectedFields);
//        List<String> differences = dataToVerify;
//        differences.removeAll(expectedFields);

        Assert.assertEquals("FAILED in asserting the number of expected fields against loaded from excelSheet\n" +
                "Different from expected was/were '" + dataToVerify.size() + "' field(s) \n" +
                "Differs for those : '" + dataToVerify.toString() + "' \n" +
                "//////////////////////////////////////////////////////////////////////////////////////////////\n" +
                "/                                Difference was detected  !!!                                /\n" +
                "/             for filePath : '" + filePath + "'\n" +
                "/                                THE LIST DIFFERS in following values :                      /\n" +
                "/                   ['" + dataToVerify.removeAll(expectedFields) + "']\n" +
                "//////////////////////////////////////////////////////////////////////////////////////////////\n",
                0,
                dataToVerify.size());

        if(dataToVerify.size() != 0) {
            log.info(dataToVerify);
           return failedBranchReporting(dataToVerify, expectedFields);
        }
        ExcelDataValidator.checkIfFieldsAreExpected(expectedFields, dataToVerifyWhole);
        return true;
    }

    public boolean failedBranchReporting(List<String> dataToVerify, List<String> expectedFields) {

        // TODO speak with Viliam why "redundant" code
            Assert.assertTrue("FAILED in asserting the number of expected fields against loaded from excelSheet\n" +
                            "Different from expected was/were '" + dataToVerify.size() + "' field(s) \n" +
                            "Differs for those : '" + dataToVerify.toString() + "' \n" +
                            "//////////////////////////////////////////////////////////////////////////////////////////////\n" +
                            "/                                                                                            /\n" +
                            "/                                Difference was detected  !!!                                /\n" +
                            "/                                                                                            /\n" +
                            "/             for filePath : '" + filePath + "'\n" +
                            "/                                                                                            /\n" +
                            "/                                THE LIST DIFFERS in following values :                      /\n" +
                            "/                                                                                            /\n" +
                            "/                   ['" + dataToVerify.removeAll(expectedFields) + "']\n" +
                            "/                                                                                            /\n" +
                            "//////////////////////////////////////////////////////////////////////////////////////////////\n",
                                false);
        return false;
    }

    /**
     * Moving data from Map to Linked List we take care only for first column as it containing fieldNames which we are interested only in them
     * todo - [for data generation we need here to implement the generator part handling the generation of the second column]
     * @param dataToConvert - Input Map<String sheetFiledNames, String sheetFieldNamesContent>
     * @return - only LinkedList<sheetFieldNames> for comparison with another LinkedList
     */
    public static List<String> convertMapToLinkedList(Map<String, String> dataToConvert){
        List<String> convertedData = new LinkedList<>();
        Collection<String> data = dataToConvert.keySet();
        convertedData.addAll(data);
        return convertedData;
    }

    /**
     * Comparing DataValidator data template envelope that will be compared with ACMExcel loaded data to be tested
     * @param expectedValues - List<String> Comparing DataValidator data template envelope
     * @param dataToVerify -Map<String, String> dataToVerify - ACMExcel loaded data to be tested
     * @throws Exception
     */
    public static void checkIfFieldsAreExpected(List<String> expectedValues, Map<String, String> dataToVerify) throws Exception {

        log.info("");

        for (int i = 0; i < dataToVerify.size(); i++) {
            String fieldToCheck = expectedValues.get(i);
            boolean excelFieldToCheck = false;
            try {
                excelFieldToCheck = dataToVerify.keySet().contains(fieldToCheck);
            } catch (NullPointerException e) {
                log.info(e);

                log.info(
                        "FAILED because of '" + e + "' [dataToVerify.get(fieldToCheck).equalsIgnoreCase(null)]\n" +
                                "Expected was : \n" +
                                "fieldToCheck = '" + fieldToCheck + "'\n" +
                                "but wasn't present in Map<String, String> \n" +
                                "dataToVerify : '" + dataToVerify + "'\n"
                );
                //Failed branch to list what was expected and with what it was compared
                for (String expectedField : expectedValues) {
                    Object[] validateKeys;
                    log.info("Field Expected : '" + expectedField + "'");

                    Collection<String> keysToValidate = dataToVerify.keySet();
                    validateKeys = keysToValidate.toArray();

                    for (Object validateKey : validateKeys) {
                        log.info("Keys to validate : '" + Arrays.toString(validateKeys) + "'");
                        Assert.assertTrue("FAILED", validateKey.toString().equalsIgnoreCase(expectedField));
                        log.info("Problem detected in : " + validateKey + ".equalsIgnoreCase( " + expectedField + " ) is not true");
                    }
                }
                Assert.assertTrue("Catch Error see log for more details around current issue", false);
            }
            Assert.assertTrue("Fields are not same!", excelFieldToCheck);
        }
    }

    /**
     * Main method executed during excel validation and is containing the excelDataValidationMain functionality
     * @return - Loaded data is possible to load into code by this method so data will be validated before using in Tests [intended usage outcome purpose]
     * @throws Exception - In case it fails
     */
    public Map<String, Map<String, String>> excelDataValidationMain() throws Exception { log.info("");
        List<String> expectedFieldNames;
        dataValidator = dataValidator(filePath);
        Map<Integer, String> sheetNames = ACMExcel.getSheetNames(filePath);

        Assert.assertTrue(
                        "//////////////////////////////////////////////////////////////////////////////////////////////\n" +
                        "/                            FAILED in validating the Excel Sheet                             \n" +
                        "//////////////////////////////////////////////////////////////////////////////////////////////\n",
                doBWLoanAppSheetValidation());

        Map<String, String> dataToSearchIn;
        Map<String, Map<String, String>> allDataMap = new HashMap<>();

        for (int i = 0; i < sheetNames.size(); i++) {
            String readExcelSheetName = sheetNameUnIndexed(sheetNames.get(i));
            boolean missedSheet = false;
            List<String> missedSheetNames = new LinkedList<>();
            Map<String, Integer> duplicity = new LinkedHashMap<>();

            switch(readExcelSheetName) {

                default:
                    log.info("============================\n" +
                             "    case default : Missed sheet \n" +
                             "    ============================\n");
                    missedSheet = true;
                    log.info("No Match for current readExcelSheetName = '" + readExcelSheetName + "'");
//                    Collection<String> collection = missedSheetNames;
                    if(!missedSheetNames.contains(readExcelSheetName)) {
                        missedSheetNames.add(readExcelSheetName);
                        duplicity.put(readExcelSheetName, 1);
                    } else {
                        readExcelSheetName = readExcelSheetName + "." + duplicity.get(readExcelSheetName);
                        duplicity.put(readExcelSheetName, duplicity.get(readExcelSheetName));
                    }
                    break;

                //todo - Multiple user validation isn't implemented as we do not have such case yet in Cucumber and because to check that would require additional information as input for validation [How many users are we expecting vs. detected] this check isn't present.
                case IBWInterface.registration:
                    log.info("=================================\n" +
                             "    case IBWInterface.registration : \n" +
                             "    =================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = BORROWER_TEST_DATA.getExpectedFieldNames();

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                        Assert.assertTrue(readExcelSheetName + " loaded Excel sheet have wrong content present data validation failed", false);
                    }
                    allDataMap.putIfAbsent(readExcelSheetName, ACMExcel.loadRegistrationDataToMap(filePath).get(0)); //todo this 0 should be substituted by comparison of users expected vs. users detected(getSheetsLastColumnNumber - 1).
                    break;


                case IBWInterface.quotation:
                    log.info("==============================\n" +
                             "    case IBWInterface.quotation : \n" +
                             "    ==============================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String numberOfBorrowers = dataToSearchIn.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    expectedFieldNames = QUOTATION.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                        Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.inviteCoapplicant:
                    log.info("======================================\n" +
                             "    case IBWInterface.inviteCoapplicant : \n" +
                             "    ======================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = QUOTATION_inviteCoapplicant.getExpectedFieldNames();

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                        Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.borrowerPersonalDetails:
                    log.info("============================================\n" +
                             "    case IBWInterface.borrowerPersonalDetails : \n" +
                             "    ============================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String  gender = dataToSearchIn.get(PERSONAL_DETAILS.GENDER.getFieldName()),
                            maritalStatus = dataToSearchIn.get(PERSONAL_DETAILS.MARITAL_STATUS.getFieldName()),
                            nationality = dataToSearchIn.get(PERSONAL_DETAILS.NATIONALITY.getFieldName()),
                            country = dataToSearchIn.get(PERSONAL_DETAILS_subCountry.COUNTRY.getFieldName()),
                            thisAccommodationIs = dataToSearchIn.get(PERSONAL_DETAILS.THIS_ACCOMMODATION_IS.getFieldName()),
                            haveYouLivedOnThisAddressFor3Y = dataToSearchIn.get(PERSONAL_DETAILS.HAVE_YOU_LIVED_ON_THIS_ADDRESS_FOR_3Y.getFieldName());
                    expectedFieldNames = PERSONAL_DETAILS.getExpectedFieldNames(gender, maritalStatus, nationality, country, thisAccommodationIs, haveYouLivedOnThisAddressFor3Y);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.coapplicantPersonalDetails:
                    log.info("===============================================\n" +
                            "    case IBWInterface.coapplicantPersonalDetails : \n" +
                            "    ===============================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String  coappGender = dataToSearchIn.get(PERSONAL_DETAILS_coapplicant.GENDER.getFieldName()),
                            coappMaritalStatus = dataToSearchIn.get(PERSONAL_DETAILS_coapplicant.MARITAL_STATUS.getFieldName()),
                            coappNationality = dataToSearchIn.get(PERSONAL_DETAILS_coapplicant.NATIONALITY.getFieldName()),
                            coappCountry = dataToSearchIn.get(PERSONAL_DETAILS_coapplicant.COUNTRY.getFieldName()),
                            coappThisAccommodationIs = dataToSearchIn.get(PERSONAL_DETAILS_coapplicant.THIS_ACCOMMODATION_IS.getFieldName()),
                            coappHaveYouLivedOnThisAddressFor3Y = dataToSearchIn.get(PERSONAL_DETAILS_coapplicant.HAVE_YOU_LIVED_ON_THIS_ADDRESS_FOR_3Y.getFieldName());
                    expectedFieldNames = PERSONAL_DETAILS_coapplicant.getExpectedFieldNames(coappGender, coappMaritalStatus, coappNationality, coappCountry, coappThisAccommodationIs, coappHaveYouLivedOnThisAddressFor3Y);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.borrowerEmploymentAndIncomePAYE:
                    log.info("====================================================\n" +
                            "    case IBWInterface.borrowerEmploymentAndIncomePAYE : \n" +
                            "    ====================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String employmentType = dataToSearchIn.get(EMPANDINCOME_paye.EMPLOYMENT_TYPE.getFieldName()),
                            currently = dataToSearchIn.get(EMPANDINCOME_subCurrently.CURRENTLY.getFieldName());
                    expectedFieldNames = EMPANDINCOME_paye.getExpectedFieldNames(employmentType, currently);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.borrowerEmploymentAndIncomeSelfEmployed:
                    log.info("============================================================\n" +
                            "    case IBWInterface.borrowerEmploymentAndIncomeSelfEmployed : \n" +
                            "    ============================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    country = dataToSearchIn.get(EMPANDINCOME_selfEmployed.COUNTRY.getFieldName());
                    currently = dataToSearchIn.get(EMPANDINCOME_subCurrently.CURRENTLY.getFieldName());
                    expectedFieldNames = EMPANDINCOME_selfEmployed.getExpectedFieldNames(country, currently);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.borrowerEmploymentAndIncomeOther :
                    log.info("=====================================================\n" +
                            "    case IBWInterface.borrowerEmploymentAndIncomeOther : \n" +
                            "    =====================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = EMPANDINCOME_other.getExpectedFieldNames();

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.borrowerEmploymentAndIncomeCivilServant :
                    log.info("============================================================\n" +
                            "    case IBWInterface.borrowerEmploymentAndIncomeCivilServant : \n" +
                            "    ============================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    log.info("dataToSearchIn = '" + dataToSearchIn + "'");
                    employmentType = dataToSearchIn.get(IBWInterface.employmentType);
                    log.info("employmentType = dataToSearchIn.get(IBWInterface.employmentType == '" + dataToSearchIn.get(IBWInterface.employmentType) + "')");

                    if(!employmentType.equalsIgnoreCase(IBWInterface.employmentTypeContractValue)){
                        currently = dataToSearchIn.get(EMPANDINCOME_civilServant.CURRENTLY.getFieldName());
                        expectedFieldNames = EMPANDINCOME_civilServant.getExpectedFieldNames(employmentType, currently);
                    } else {
                        expectedFieldNames = EMPANDINCOME_civilServant.getExpectedFieldNames(employmentType);
                    }
                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.borrowerEmploymentAndIncomeUnemployedHomemaker :
                    log.info("===================================================================\n" +
                            "    case IBWInterface.borrowerEmploymentAndIncomeUnemployedHomemaker : \n" +
                            "    ===================================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String currently3 = dataToSearchIn.get(EMPANDINCOME_unemployedHomemaker.CURRENTLY.getFieldName());
                    expectedFieldNames = EMPANDINCOME_unemployedHomemaker.getExpectedFieldNames(currently3);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.coappEmploymentAndIncomePAYE :
                    log.info("=================================================\n" +
                            "    case IBWInterface.coappEmploymentAndIncomePAYE : \n" +
                            "    =================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String  employmentTypeCoapp = dataToSearchIn.get(EMPANDINCOME_paye.EMPLOYMENT_TYPE.getFieldName()),
                            currentlyCoapp = dataToSearchIn.get(EMPANDINCOME_subCurrently.CURRENTLY.getFieldName());
                    expectedFieldNames = EMPANDINCOME_paye.getExpectedFieldNames(employmentTypeCoapp, currentlyCoapp);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.coappEmploymentAndIncomeSelfEmployed :
                    log.info("=========================================================\n" +
                             "    case IBWInterface.coappEmploymentAndIncomeSelfEmployed : \n" +
                             "    =========================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String  countryCoapp1 = dataToSearchIn.get(EMPANDINCOME_selfEmployed.COUNTRY.getFieldName()),
                            currentlyCoapp1 = dataToSearchIn.get(EMPANDINCOME_selfEmployed.CURRENTLY.getFieldName());
                    expectedFieldNames = EMPANDINCOME_selfEmployed.getExpectedFieldNames(countryCoapp1, currentlyCoapp1);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.coappEmploymentAndIncomeOther :
                    log.info("==================================================\n" +
                            "    case IBWInterface.coappEmploymentAndIncomeOther : \n" +
                            "    ==================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = EMPANDINCOME_other.getExpectedFieldNames();

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.coappEmploymentAndIncomeCivilServant :
                    log.info("=========================================================\n" +
                            "    case IBWInterface.coappEmploymentAndIncomeCivilServant : \n" +
                            "    =========================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    employmentType = dataToSearchIn.get(IBWInterface.employmentType);
                    log.info("dataToSearchIn = '" + dataToSearchIn + "'");
                    log.info("employmentType = dataToSearchIn.get(IBWInterface.employmentType == '" + dataToSearchIn.get(IBWInterface.employmentType) + "')");

                    if(!employmentType.equalsIgnoreCase(IBWInterface.employmentTypeContractValue)){
                        currently = dataToSearchIn.get(COAPP_EMPANDINCOME_civilServant.CURRENTLY.getFieldName());
                        expectedFieldNames = COAPP_EMPANDINCOME_civilServant.getExpectedFieldNames(employmentType, currently);
                    } else {
                        expectedFieldNames = COAPP_EMPANDINCOME_civilServant.getExpectedFieldNames(employmentType);
                    }
                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.coappEmploymentAndIncomeUnemployedHomemaker :
                    log.info("================================================================\n" +
                            "    case IBWInterface.coappEmploymentAndIncomeUnemployedHomemaker : \n" +
                            "    ================================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    String currentlyCoapp3 = dataToSearchIn.get(EMPANDINCOME_unemployedHomemaker.CURRENTLY.getFieldName());
                    expectedFieldNames = EMPANDINCOME_unemployedHomemaker.getExpectedFieldNames(currentlyCoapp3);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialAssetsInvestmentProductFundsBonds :
                    log.info("===================================================================\n" +
                            "    case IBWInterface.yourFinancialAssetsInvestmentProductFundsBonds : \n" +
                            "    ===================================================================\n");
                    Map<String, String> quotationData = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    numberOfBorrowers = quotationData.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FASSETS_investmentProductFundsBonds.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialAssetsShares :
                    log.info("==============================================\n" +
                            "    case IBWInterface.yourFinancialAssetsShares : \n" +
                            "    ==============================================\n");
                    Map<String, String> quotationData_shares = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    numberOfBorrowers = quotationData_shares.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FASSETS_shares.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialAssetsShareOptions :
                    log.info("====================================================\n" +
                            "    case IBWInterface.yourFinancialAssetsShareOptions : \n" +
                            "    ====================================================\n");
                    Map<String, String> quotationData_shareOptions = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    numberOfBorrowers = quotationData_shareOptions.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FASSETS_shareOptions.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialAssetsLandSite :
                    log.info("================================================\n" +
                            "    case IBWInterface.yourFinancialAssetsLandSite : \n" +
                            "    ================================================\n");
                    Map<String, String> quotationData_landSite = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    numberOfBorrowers = quotationData_landSite.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FASSETS_landSite.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialAssetsLifePolicy :
                    log.info("=====================================================\n" +
                            "    case IBWInterface.yourFinancialAssetsLifePolicy : \n" +
                            "    =====================================================\n");
                    Map<String, String> quotationData_lifePolicy = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    numberOfBorrowers = quotationData_lifePolicy.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FASSETS_lifePolicy.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialAssetsOther :
                    log.info("=============================================\n" +
                            "    case IBWInterface.yourFinancialAssetsOther : \n" +
                            "    =============================================\n");
                    Map<String, String> quotationData_other = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    numberOfBorrowers = quotationData_other.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FASSETS_other.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourAccountsSavingsAccount :
                    log.info("===============================================\n" +
                            "    case IBWInterface.yourAccountsSavingsAccount : \n" +
                            "    ===============================================\n");
                    Map<String, String> quotationData_savingsAccount = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    numberOfBorrowers = quotationData_savingsAccount.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    log.info("readExcelSheetName = '" + readExcelSheetName + "'");
                    log.info("expectedFieldNames for YACCOUNTS_savingsAccount");
                    expectedFieldNames = YACCOUNTS_savingsAccount.getExpectedFieldNames(numberOfBorrowers);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourAccountsCurrentAccount :
                    log.info("===============================================\n" +
                            "    case IBWInterface.yourAccountsCurrentAccount : \n" +
                            "    ===============================================\n");
                    Map<String, String> quotationData_currentAccount = ACMExcel.loadSheetDataByRows(filePath, IBWInterface.quotation);
                    String numberOfBorrowersCurrentAccount = quotationData_currentAccount.get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    log.info("readExcelSheetName = '" + readExcelSheetName + "'");
                    log.info("expectedFieldNames for YACCOUNTS_currentAccount");
                    List<String> expectedFieldNamesCurrentAccount = YACCOUNTS_currentAccount.getExpectedFieldNames(numberOfBorrowersCurrentAccount);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNamesCurrentAccount, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourPropertiesPrincipalDwellingHouse :
                    log.info("=========================================================\n" +
                            "    case IBWInterface.yourPropertiesPrincipalDwellingHouse : \n" +
                            "    =========================================================\n");
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    log.info("readExcelSheetName = '" + readExcelSheetName + "'");
                    String numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    expectedFieldNames = YPROPERTIES_principalDwellingHouse.getExpectedFieldNames(numberOfBorrowersValue, dataToSearchIn);
                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourPropertiesHolidayHome :
                    log.info("==============================================\n" +
                            "    case IBWInterface.yourPropertiesHolidayHome : \n" +
                            "    ==============================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = YPROPERTIES_holidayHome.getExpectedFieldNames(numberOfBorrowersValue, dataToSearchIn);
                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourPropertiesInvestment :
                    log.info("=============================================\n" +
                            "    case IBWInterface.yourPropertiesInvestment : \n" +
                            "    =============================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = YPROPERTIES_investment.getExpectedFieldNames(numberOfBorrowersValue, dataToSearchIn);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourDependentsValue :
                    log.info("========================================\n" +
                            "    case IBWInterface.yourDependentsValue : \n" +
                            "    ========================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = YDEPENDENTS.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialCommitmentsPersonalLoan :
                    log.info("=========================================================\n" +
                            "    case IBWInterface.yourFinancialCommitmentsPersonalLoan : \n" +
                            "    =========================================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FCOMMITMENTS_personalLoan.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialCommitmentsCarLoan :
                    log.info("====================================================\n" +
                            "    case IBWInterface.yourFinancialCommitmentsCarLoan : \n" +
                            "    ====================================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FCOMMITMENTS_carLoan.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialCommitmentsStudentLoan :
                    log.info("========================================================\n" +
                            "    case IBWInterface.yourFinancialCommitmentsStudentLoan : \n" +
                            "    ========================================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FCOMMITMENTS_studentLoan.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialCommitmentsCreditCard :
                    log.info("=======================================================\n" +
                            "    case IBWInterface.yourFinancialCommitmentsCreditCard : \n" +
                            "    =======================================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FCOMMITMENTS_creditCard.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialCommitmentsOther :
                    log.info("==================================================\n" +
                            "    case IBWInterface.yourFinancialCommitmentsOther : \n" +
                            "    ==================================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FCOMMITMENTS_other.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFinancialCommitmentsMaintenancePayment :
                    log.info("===============================================================\n" +
                            "    case IBWInterface.yourFinancialCommitmentsMaintenancePayment : \n" +
                            "    ===============================================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = FCOMMITMENTS_maintenancePayment.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFundingGift :
                    log.info("====================================\n" +
                            "    case IBWInterface.yourFundingGift : \n" +
                            "    ====================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = YFUNDING_gift.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFundingInheritance :
                    log.info("===========================================\n" +
                            "    case IBWInterface.yourFundingInheritance : \n" +
                            "    ===========================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = YFUNDING_inheritance.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }

                case IBWInterface.yourFundingOther :
                    log.info("=====================================\n" +
                             "    case IBWInterface.yourFundingOther : \n" +
                             "    =====================================\n");
                    numberOfBorrowersValue = ACMExcel.loadSheetDataByRows(filePath, ExcelSheetVerificator.QUOTATION_sheetName.getSheetName()).get(QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
                    dataToSearchIn = ACMExcel.loadSheetDataByRows(filePath, readExcelSheetName);
                    expectedFieldNames = YFUNDING_other.getExpectedFieldNames(numberOfBorrowersValue);

                    if (!dataValidator.isSizeSameMapLinkedListComparison(expectedFieldNames, dataToSearchIn)) {
                                                Assert.assertTrue(readExcelSheetName + " loaded Excel variables have incorrect number of them!!!", false);
                    } else {
                        addDataMapAddSheetNameWithIndex(allDataMap, readExcelSheetName, dataToSearchIn);
                        break;
                    }
            }
            if(missedSheet){
                log.info("DataModelValidator missed following\n" +
                        "sheets : '" + missedSheetNames);
                Assert.assertTrue("Test Failed due not valid Excel file '" + filePath + "' for Excel sheet name '" + missedSheetNames + "'", false);
            }
        }
        log.info("Loading almost finished file : '" + filePath + "'");
        return allDataMap;
    }
}
