package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultSection extends Apollo implements IResultSection {

    private static final Log log = LogFactory.getLog(ResultSection.class);

    @FindBy( xpath = INFO_RESULT_XPATH )
    protected WebElement weItemsResult;
    private String currentItemResultText;

    @FindBy( xpath = TABLE_XPATH )
    protected WebElement weTableResult;
    private String orderBy;
    private Map<String, String> headerTableData;
    private Map<Integer, Map<String, String>> bodyTableData;

    public static IResultSection getResultSectionInstance(SharedDriver webDriver) {
        IResultSection resultSection = new ResultSection(webDriver);
        PageFactory.initElements(webDriver, resultSection);
        return resultSection;
    }

    public ResultSection(SharedDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        weItemsResult = null;
        weTableResult = null;
        orderBy = null;
        headerTableData = null;
        bodyTableData = null;
    }

    @Override
    public String getInfoData() throws Exception {
        if (!isVisible(INFO_RESULT_XPATH))
            throw new Exception("INFO Result is not visible");

        return getWebElement(INFO_RESULT_XPATH).getText();
    }

    @Override
    public IResultSection extractResult() throws Exception {
        checkTable();
        this.headerTableData = getHeaderTableData();
        this.orderBy = getOrderBy();
        this.bodyTableData = getBodyTableData();
        this.currentItemResultText = getInfoData();

        return this;
    }

    private void checkTable() throws Exception {

        if (isVisible(DANGER_RESULT_XPATH, 5)) {
            throw new Exception(getText(getWebElement(DANGER_RESULT_XPATH)));
        }

        if (!isVisible(TABLE_XPATH)) {
            throw new Exception("Result Table is not visible");
        }

        if (!isVisible(TABLE_HEADER_XPATH)) {
            throw new Exception("Result Header Table is not visible");
        }

        if (!isVisible(TABLE_HEADER_ROW_XPATH)) {
            throw new Exception("Result Row Header Table is not visible ");
        }

        if (!isVisible(TABLE_HEADER_COLUMN_XPATH)) {
            throw new Exception("Result Column Header Table is not visible");
        }

        WebElement weHeader = getWebElement(TABLE_HEADER_ROW_XPATH);
        List<WebElement> lweColumnHeader = getWebElements(weHeader, "./th");

        if ( lweColumnHeader.size() != EXPECTED_COLUMN_NUMBER )
            throw new Exception("Result Column Number is not correct : " + EXPECTED_COLUMN_NUMBER );

        WebElement weBody = getWebElement(TABLE_BODY_XPATH);
        List<WebElement> lweRow = getWebElements(weBody, "./tr");

        for ( WebElement weCurrentRow : lweRow ) {
            List<WebElement> lweColumn = getWebElements(weCurrentRow, "./td");

            if ( lweColumn.size() != EXPECTED_COLUMN_NUMBER )
                throw new Exception("Result Column Number is not correct : " + EXPECTED_COLUMN_NUMBER);
        }
    }

    private int countRowTable() {
        WebElement weBody = getWebElement(TABLE_BODY_XPATH);
        List<WebElement> lweRow = getWebElements(weBody, "./tr");

        return lweRow.size();
    }

    public Map<String, String> getHeaderTableData() {
        WebElement weHeader = getWebElement(TABLE_HEADER_ROW_XPATH);
        List<WebElement> lweColumnHeader = getWebElements(weHeader, "./th");

        Map<String, String> mHeader = new LinkedHashMap<>();
        for ( WebElement currentWebElement : lweColumnHeader ) {
            mHeader.put(getText(currentWebElement, HEADER_COLUMN_TEXT_XPATH), getClassText(currentWebElement, GLYPHICON_CHEVRON_XPATH));
        }

        return mHeader;
    }

    public String getOrderBy() {
        WebElement weHeader = getWebElement(TABLE_HEADER_XPATH);

        return getText(weHeader, ORDER_BY_COLUMN_XPATH);
    }

    private String getHeaderValue(int i) {
        return (String) this.headerTableData.keySet().toArray()[i];
    }

    private Map<Integer, Map<String, String>> getBodyTableData() {
        WebElement weBody = getWebElement(TABLE_BODY_XPATH);
        List<WebElement> lweRow = getWebElements(weBody, "./tr");

        Integer currentRow = 0;
        Map<Integer, Map<String, String>> toReturn = new LinkedHashMap<>();
        for ( WebElement weCurrentRow : lweRow ) {

            Map<String, String> currentMap = new LinkedHashMap<>();
            List<WebElement> lweColumn = getWebElements(weCurrentRow, "./td");

            for ( int i=0; i < lweColumn.size(); i++ ) {
                currentMap.put(getHeaderValue(i),getText(lweColumn.get(i)));
            }

            toReturn.put(currentRow, currentMap);
            currentRow++;
        }

        return toReturn;
    }

    private Map<String, String> getRowTableData(int row) {
        WebElement weBody = getWebElement(TABLE_BODY_XPATH);
        List<WebElement> lweRow = getWebElements(weBody, "./tr");

        Map<String, String> currentMap = new LinkedHashMap<>();
        List<WebElement> lweColumn = getWebElements(lweRow.get(row), "./td");

        for ( int i=0; i < lweColumn.size(); i++) {
            currentMap.put(getHeaderValue(i), getText(lweColumn.get(i)));
        }

        return currentMap;
    }

    @Override
    public IResultSection sortBy(String columnName, String orderBy) throws Exception {
        if( columnName == null || columnName.isEmpty() )
            throw new Exception("ColumnName cannot be null or empty");

        try {
            ORDER_TYPE.getOrder(orderBy);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        String currentXpath = ORDER_BY_SPEC_COLUMN_XPATH.replace("${replace}$", columnName);
        WebElement webElement = getWebElement(currentXpath);

        if ( ORDER_TYPE.UP.equals(ORDER_TYPE.getOrder(orderBy)) ) webElement.click();
        else {
            getWebElement(currentXpath).click();
            isVisible(currentXpath, true);
            getWebElement(currentXpath).click();
        }

        return extractResult();
    }

    @Override
    public IRecordPage selectCustomer(int row) throws Exception {
        if ( row < 0)
            throw new Exception("Result Table doesn't contain negative row");

        WebElement wBody = getWebElement(TABLE_BODY_XPATH);
        List<WebElement> lweRow = getWebElements(wBody, "./tr");

        if (!( 0<=row && row<lweRow.size()))
            throw new Exception("Result Table doesn't contain your row as out of index");

        Map<String, String> customerData = getRowTableData(row);
        lweRow.get(row).click();

        return RecordPage.getRecordPageInstance((SharedDriver) webDriver, customerData, null);
    }
}

