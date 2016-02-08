package DataModelValidator.borrowerLoanApp;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.ExcelDataMavenCycleValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MavenCycleValidatorTest {

    private static final Log log = LogFactory.getLog(MavenCycleValidatorTest.class.getName());

    public void mavenCycleValidatorTestMain() throws Exception {
        log.info("STARTED MavenCycleValidatorTest.mavenCycleValidatorTestMain()");

        String[] fieldPaths = { "DataValidator/src/test/resources/DataModelValidator/borrowerLoanApp/MavenLifeCycleTest/LatestBorrowerDataTemplate2.xls",
                                "DataValidator/src/test/resources/DataModelValidator/borrowerLoanApp/ErrorWrongMissingFields.xls",
                                "DataValidator/src/test/resources/DataModelValidator/borrowerLoanApp/ErrorWrongEndDateField.xls",
                                "DataValidator/src/test/resources/DataModelValidator/borrowerLoanApp",
                                "DataValidator/src/test/resources/DataModelValidator/borrowerLoanApp/ErrorWrongSheetName.xls",
                                "DataValidator/src/test/resources/DataModelValidator/borrowerLoanApp/AAA",
                                "DataValidator/src/test/resources/DataModelValidator/borrowerLoanApp/PassFailFolder"};

        ExcelDataMavenCycleValidator.main(fieldPaths);

    }
}
