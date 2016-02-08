package DataModelValidator.borrowerLoanApp;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelDataValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.util.Map;

public class DataValidatorNegativeTest {

    private final Log log = LogFactory.getLog(DataValidatorNegativeTest.class.getName());

    /**
     * Testing DataValidation of Negative case Wrong Sheet Name
     */
    @Test
    public void sheetIncorrectNumberOfVariablesTest() throws Exception, AssertionError {
        /** Test 1 */
        //noinspection ConstantConditions
        URI uriPath = DataValidatorNegativeTest.class.getClassLoader().getResource("LatestBorrowerDataTemplate.xls").toURI();
        Assert.assertNotNull("Problem accessing resources of current test : DataValidatorNegativeTest.class.getClassLoader().getResource(\"LatestBorrowerDataTemplate.xls\").toURI()", uriPath);
        File file = new File(uriPath);
        String filePath = file.getPath();
        Assert.assertNotNull("filePath == null", filePath);
        ExcelDataValidator dataValidator = new ExcelDataValidator(filePath);
        try {
            dataValidator.excelDataValidationMain();
        } catch (AssertionError assertionError) {
            log.info(assertionError.toString());
            String expectedAssertionError = "java.lang.AssertionError: Bw - Employment and Income - Self Employed loaded Excel variables have incorrect number of them!!!";
            Assert.assertEquals("Assertion is different from expected.", assertionError.toString(), expectedAssertionError);
        }
    }

    /**
     * Testing DataValidation of Negative case Wrong Sheet Name
     */
    @Test
    public void wrongSheetNameTest() throws Exception, AssertionError {
        /** Test 2 */
        //noinspection ConstantConditions
        URI uriPath = DataValidatorNegativeTest.class.getClassLoader().getResource("ErrorWrongSheetName.xls").toURI();
        Assert.assertNotNull("Problem accessing resources of current test : DataValidatorNegativeTest.class.getClassLoader().getResource(\"ErrorWrongSheetName.xls\").toURI()", uriPath);
        File file = new File(uriPath);
        String filePath = file.getPath();
        Assert.assertNotNull("filePath == null", filePath);
        ExcelDataValidator dataValidator = new ExcelDataValidator(filePath);
        try {
            dataValidator.excelDataValidationMain();
        } catch (AssertionError assertionError) {
            log.info(assertionError.toString());
            String expectedAssertionError = "java.lang.AssertionError: \n" +
                    "//////////////////////////////////////////////////////////////////////////////////////////////\n" +
                    "/                            FAILED in validating the Excel Sheet                             \n" +
                    "/         There was(were) not validated sheet(s) : '[Employment and Income - Self Employed]'\n" +
                    "//////////////////////////////////////////////////////////////////////////////////////////////\n" +
                    "";
            log.info(expectedAssertionError);
            Assert.assertEquals("Assertion is different from expected.", assertionError.toString(), expectedAssertionError);
        }
    }

    /**
     * Testing DataValidation of Negative case for Missing Fields
     */
    @Test
    public void missingFieldsTest() throws Exception, AssertionError {
        /** Test 3 */
        //noinspection ConstantConditions
        URI uriPath = DataValidatorNegativeTest.class.getClassLoader().getResource("ErrorWrongMissingFields.xls").toURI();
        Assert.assertNotNull("Problem accessing resources of current test : DataValidatorNegativeTest.class.getClassLoader().getResource(\"ErrorWrongMissingFields.xls\").toURI()", uriPath);
        File file = new File(uriPath);
        String filePath = file.getPath();
        Assert.assertNotNull("filePath == null", filePath);
        ExcelDataValidator dataValidator = new ExcelDataValidator(filePath);
        try {
            dataValidator.excelDataValidationMain();
        } catch (AssertionError assertionError) {
            log.info(assertionError.toString());
            String expectedAssertionError =
                    "java.lang.AssertionError: FAILED in asserting the number of expected fields against loaded from excelSheet\n" +
                            "Different from expected was/were '1' field(s) \n" +
                            "Differs for those : '[IBAN]' \n" +
                            "//////////////////////////////////////////////////////////////////////////////////////////////\n" +
                            "/                                Difference was detected  !!!                                /\n" +
                            "/             for filePath : '" + System.getProperty("user.dir") + "/target/classes/ErrorWrongMissingFields.xls'\n" +
                            "/                                THE LIST DIFFERS in following values :                      /\n" +
                            "/                   ['[IBAN]']\n" +
                            "//////////////////////////////////////////////////////////////////////////////////////////////\n" +
                            " expected:<0> but was:<1>";
            log.info(expectedAssertionError);
            Assert.assertEquals("Assertion is different from expected.", assertionError.toString(), expectedAssertionError);
        }
    }

    /**
     * Testing DataValidation of Template for Co-applicant & Borrower
     */
    @Test
    public void borrowerAndCoappTemplateTest() throws Exception, AssertionError {
        /** Test 4 */
        //noinspection ConstantConditions
        URI uriPath = DataValidatorNegativeTest.class.getClassLoader().getResource("LatestBorrowerDataTemplate.xls").toURI();
        Assert.assertNotNull("Problem accessing resources of current test : DataValidatorNegativeTest.class.getClassLoader().getResource(\"LatestBorrowerDataTemplate.xls\").toURI() == null", uriPath);
        File file = new File(uriPath);
        String filePath = file.getPath();
        Assert.assertNotNull("filePath == null", filePath);
        ExcelDataValidator dataValidator = new ExcelDataValidator(filePath);
        Map<String, Map<String, String>> allDataMap = dataValidator.excelDataValidationMain();
        Assert.assertTrue("Failed due to missing data in output variables fiveDimensionalDataStore Map " + allDataMap.size(), allDataMap.size() == 36);
    }

    /**
     * Testing DataValidation of Template for Just One Borrower - Without Co-applicant
     */
    @Test
    public void justBorrowerTemplateTest() throws Exception, AssertionError {
        /** Test 5 */
        //noinspection ConstantConditions
        URI uriPath = DataValidatorNegativeTest.class.getClassLoader().getResource("LatestBorrowerDataTemplateOneBW.xls").toURI();
        Assert.assertNotNull("Problem accessing resources of current test : DataValidatorNegativeTest.class.getClassLoader().getResource(\"LatestBorrowerDataTemplateOneBW.xls\").toURI() == null", uriPath);
        File file = new File(uriPath);
        String filePath = file.getPath();
        Assert.assertNotNull("filePath == null", filePath);
        ExcelDataValidator dataValidator = new ExcelDataValidator(filePath);
        Map<String, Map<String, String>> allDataMap = dataValidator.excelDataValidationMain();
        Assert.assertTrue("Failed due to missing data in output variables fiveDimensionalDataStore Map " + allDataMap.size(), allDataMap.size()==36);
    }
}
