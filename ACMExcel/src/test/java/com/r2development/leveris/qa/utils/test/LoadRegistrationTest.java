package com.r2development.leveris.qa.utils.test;

import com.r2development.leveris.qa.utils.ACMExcel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoadRegistrationTest {

    private static final Log log = LogFactory.getLog(LoadRegistrationTest.class);

    @Test
    public void getDataTest() throws Exception {
        //noinspection ConstantConditions
        File file = new File(LoadRegistrationTest.class.getClassLoader().getResource("LatestBorrowerDataTemplate.xls").toURI());
        String filePath = file.getPath();
        ACMExcel acmExcel = new ACMExcel(filePath);
        assertThat("File should exist", file.exists(), Is.is(true));
        Map<Integer, String> sheetNames = acmExcel.getSheetNames();
        Map<Integer, String> staticSheetNames = ACMExcel.getSheetNames(filePath);
        Map<String, Map<String, String>> excelData = acmExcel.loadDataToSheetMap(acmExcel.getSheetNames());
        Map<String, Map<String, String>> staticExcelData = ACMExcel.loadDataToSheetMap(filePath, ACMExcel.getSheetNames(filePath));

        assertThat("equalSize between non static sheetName & static sheetName failed", sheetNames.size(), equalTo(staticSheetNames.size()));
        assertThat("equalSize between non static excelData & static excelData failed", excelData.size(), equalTo(staticExcelData.size()));

        if((excelData.size() == staticExcelData.size()) && (sheetNames.size() == staticSheetNames.size()) && (excelData.size() == sheetNames.size()) && (staticExcelData.size() == staticSheetNames.size()) && (excelData.size() == staticSheetNames.size())) {
            for (int i = 0; i < excelData.size(); i++){
                Collection<String> linkedKeyList = excelData.get(sheetNames.get(i)).keySet();
                Collection<String> linkedValueList = excelData.get(sheetNames.get(i)).values();
                Collection<String> linkedKeyListStatic = staticExcelData.get(staticSheetNames.get(i)).keySet();
                Collection<String> linkedValueListStatic = staticExcelData.get(staticSheetNames.get(i)).values();
                linkedKeyList.removeAll(linkedKeyListStatic);
                linkedValueList.removeAll(linkedValueListStatic);

                assertThat("Data obtained by Static and non-Static ACMExcel methods were different. because compared list are not empty", (linkedKeyList.isEmpty()) && (linkedValueList.isEmpty()), Is.is(true));
            }
        }
        log.info("TEST PASSED");
    }
}
