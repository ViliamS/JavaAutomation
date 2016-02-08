package DataModelValidator.borrowerLoanApp;

import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.IBWInterface;
import com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp.Quotation.QUOTATION;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExampleSmokeTest implements IBWInterface {

    private static final Log log = LogFactory.getLog(ExampleSmokeTest.class.getName());

    @Test
    public void validQuotationBehavior() {
        for ( QUOTATION currentValues : QUOTATION.values()) {
            log.info(currentValues);
        }
        assertEquals("Number values are incorrect", QUOTATION.values().length, 11);
    }

    @Test
    public void validQuotationTriggerPoint() {
        assertEquals("Did we change the process of Quote. Expected trigger point is not the one we want", numberOfBorrowers, QUOTATION.NUMBER_OF_BORROWERS.getFieldName());
    }

    @Test
    public void validExpectedFieldNames_Single() {
        List<String> expectedField = QUOTATION.getExpectedFieldNames("a single borrower");
        expectedField.forEach(log::info);
        assertEquals("Number expected field for a single borrower is incorrect", 8, expectedField.size());

    }

    @Test
    public void validExpectedFieldNames_Double() {
        List<String> expectedField = QUOTATION.getExpectedFieldNames("two borrowers");
        expectedField.forEach(log::info);
        assertEquals("Number expected field for a single borrower is incorrect", 11, expectedField.size());

    }

    @Test
    public void validExpectedFieldNames_nonValid() {
        List<String> expectedField = QUOTATION.getExpectedFieldNames("nonValid"); // as "a single borrower" behavior
        expectedField.forEach(log::info);

        assertEquals("Number expected default fields for non is incorrect", 8, expectedField.size());
        assertFalse("Input data should be \"a single borrower\" or \"two borrowers\"", QUOTATION.NUMBER_OF_BORROWERS.getFieldNameValue().contains("nonValid"));
    }
}
