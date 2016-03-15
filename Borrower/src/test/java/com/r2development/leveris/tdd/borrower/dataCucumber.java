package com.r2development.leveris.tdd.borrower;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.hamcrest.core.Is;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.junit.MatcherAssert.assertThat;

public class dataCucumber {

    enum InitFieldRow {
        TEST_CASE(2),
        BORROWER_NUMBER(2),
        MORTGAGE_TYPE(3),
        BORROWER_AGE(4),
        PARTNER_AGE(5),
        BORROWER_MARITAL_STATUS(6),
        BORROWER_TOTAL_DEPENDANTS(7),
        BORROWER_INCOME_TYPE(8),
        BORROWER_INCOME_AMOUNT(9),
        PARTNER_INCOME_TYPE(10),
        PARTNER_INCOME_AMOUNT(11),
        MONTHLY_CREDIT_COMMITMENTS(12),
        IS_ELIGIBLE(13),
        MAX_LOAN_AMOUNT(14),
        MONTHLY_PAYMENT(15),
        MINIMUM_DEPOSIT(16);
        private final int value;

        InitFieldRow(int value) { this.value = value; }
        public int getValue() { return value; }
//        public static InitFieldRow getField(String fieldAlias) {
//            String val = org.apache.commons.lang3.StringUtils.trimToEmpty(fieldAlias).toUpperCase();
//            com.google.common.base.Optional<InitFieldRow> possible = Enums.getIfPresent(InitFieldRow.class, val);
//            if (!possible.isPresent()) {
//                throw new IllegalArgumentException(val + "? There is no such Environment!");
//            }
//            return possible.get();
//        }
    }

    @Test
    public void arrange() throws IOException {

        File file = null;
        try {
            //noinspection ConstantConditions
            file = new File(dataCucumber.class.getClassLoader().getResource("dataCucumber.txt").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //noinspection ConstantConditions
        assertThat("File should exist", file.exists(), Is.is(true));

        List<String> lines = FileUtils.readLines(file, "UTF-8");
        List<String> columns = new LinkedList<>();
        Map<String, List<String>> tc = new LinkedHashMap<>();
        int line=1;
        for ( String currentLine : lines ) {
            String[] currentLineArray = currentLine.split("\\|");

            if ( line == 1) {
//                for (int i=1; i < currentLineArray.length - 2; i++) {
//                    columns.add(currentLineArray[i]);
//                }
                columns.addAll(Arrays.asList(currentLineArray).subList(1, currentLineArray.length - 2));
            }
            else {
                List<String> values = new LinkedList<>();
                for (int i = 1; i < currentLineArray.length - 2; i++) {
                    if (i == 13 && (org.apache.commons.lang3.StringUtils.isEmpty(currentLineArray[i]) || org.apache.commons.lang3.StringUtils.containsOnly(" ", currentLineArray[i]))) {
                        values.add(currentLineArray[i]);
                    }
                    else if (i != 13 && org.apache.commons.lang3.StringUtils.isEmpty(currentLineArray[i])) {
                        values.add(currentLineArray[i]);
                    } else {
                        values.add(currentLineArray[i]);
                    }
                }
                tc.put(currentLineArray[1], values);
            }

            line++;
        }

        for ( Map.Entry<String, List<String>> currentTC : tc.entrySet()) {
//            System.out.println(currentTC.getKey() + ";");
            for ( int i=1; i < currentTC.getValue().size(); i++) {
                System.out.println(columns.get(i) + ";" + currentTC.getValue().get(i));
            }
        }

    }

    @Test
    public void sendActualData() {
        Map<String, Map<String, String>> actualData  = new LinkedHashMap<>();

        actualData.put(
            "UAT - TC 1",
            new LinkedHashMap<String, String>() {
                {
                    put("MaxLoanAmount", "105000.00");
                    put("MonthlyPayment", "4969.44");
                    put("MinimumDeposit", "350000.00");
                }
            }
        );
        actualData.put(
            "UAT - TC 2",
            new LinkedHashMap<String, String>() {
                {
                    put("MaxLoanAmount", "700000.00");
                    put("MonthlyPayment", "3312.74");
                    put("MinimumDeposit", "147500.00");
                }
            }
        );

        for ( Map.Entry<String, Map<String, String>> currentList : actualData.entrySet()) {
            String currentScenario = currentList.getKey();
            System.out.println(currentScenario);
            Map<String, String> currentActualData = currentList.getValue();
            for ( Map.Entry<String, String> currentActualDataEntry : currentActualData.entrySet() ) {
                String currentActualDataKey = currentActualDataEntry.getKey();
                String currentActualDataValue = currentActualDataEntry.getValue();
                System.out.println(currentActualDataKey + " - " + currentActualDataValue);
            }
        }
    }

    @Test
    public void readWriteExcel() throws IOException {

        File file = null;
        try {
            //noinspection ConstantConditions
            file = new File(dataCucumber.class.getClassLoader().getResource("ReportCalQuote.xls").toURI());
        } catch (NullPointerException | URISyntaxException e) {
            e.printStackTrace();
        }
        //noinspection SimplifiableConditionalExpression
        assertThat("File should exist", file != null ? file.exists() : false, Is.is(true));

        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        try
        {
            //noinspection ConstantConditions
            fileIn = new FileInputStream(file);
            POIFSFileSystem fs = new POIFSFileSystem(fileIn);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);

            // Test Case
            for ( int i=0; i<112; i++) {
                HSSFRow row = sheet.getRow(15*i+InitFieldRow.TEST_CASE.getValue());
                System.out.println(row.getCell(0).getStringCellValue());
            }

            // Max Loan Amount
            for ( int i=0; i<112; i++) {
                HSSFRow row = sheet.getRow(15*i+InitFieldRow.MAX_LOAN_AMOUNT.getValue());
                System.out.println(row.getCell(1).getStringCellValue());
            }

            // Monthly Payment
            for ( int i=0; i<112; i++) {
                HSSFRow row = sheet.getRow(15*i+InitFieldRow.MONTHLY_CREDIT_COMMITMENTS.getValue());
                System.out.println(row.getCell(1).getStringCellValue());
            }

            // Minimum Deposit
            for ( int i=0; i<112; i++) {
                HSSFRow row = sheet.getRow(15*i+InitFieldRow.MINIMUM_DEPOSIT.getValue());
                System.out.println(row.getCell(1).getStringCellValue());
            }

            HSSFRow rowZero = sheet.getRow(0);
            int i = rowZero.getLastCellNum();
            System.out.println("last column: " + i);

            if (org.apache.commons.lang3.StringUtils.isEmpty(rowZero.getCell(i-1).getStringCellValue()) ) {
                // we need to add here

                Map<String, Map<String, String>> actualData  = new LinkedHashMap<>();

                actualData.put(
                        "UAT - TC 1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("MaxLoanAmount", "105000.00");
                                put("MonthlyPayment", "4969.44");
                                put("MinimumDeposit", "350000.00");
                            }
                        }
                );
                actualData.put(
                        "UAT - TC 2",
                        new LinkedHashMap<String, String>() {
                            {
                                put("MaxLoanAmount", "700000.00");
                                put("MonthlyPayment", "3312.74");
                                put("MinimumDeposit", "147500.00");
                            }
                        }
                );

                for ( Map.Entry<String, Map<String, String>> currentList : actualData.entrySet()) {
                    String currentScenario = currentList.getKey();
                    System.out.println(currentList);
                    Map<String, String> currentActualData = currentList.getValue();
                    for ( Map.Entry<String, String> currentActualDataEntry : currentActualData.entrySet() ) {
                        String currentActualDataKey = currentActualDataEntry.getKey();
                        String currentActualDataValue = currentActualDataEntry.getValue();
                        System.out.println(currentActualDataKey + " - " + currentActualDataValue);

                        Pattern p = Pattern.compile("UAT - TC (\\d{1,3})");
                        Matcher m = p.matcher(currentScenario);

                        int scenario = 0;
                        while (m.find()) {
                            scenario = Integer.parseInt(m.group(1));
                        }

                        System.out.println("Scenario: "  + scenario);

                        InitFieldRow enumValue = null;
                        switch (currentActualDataKey) {
                            case "MaxLoanAmount":
                                enumValue = InitFieldRow.MAX_LOAN_AMOUNT;
                                break;
                            case "MonthlyPayment":
                                enumValue = InitFieldRow.MONTHLY_PAYMENT;
                                break;
                            case "MinimumDeposit":
                                enumValue = InitFieldRow.MINIMUM_DEPOSIT;
                                break;
                            default:
                        }
                        //noinspection ConstantConditions
                        HSSFRow row = sheet.getRow(15*(scenario-1)+enumValue.getValue());
                        row.getCell(i-1).setCellValue(currentActualDataValue);
                    }
                }

                DateTime now = DateTime.now();
                sheet.getRow(0).getCell(i-1).setCellValue(now.toString("yyyyMMddHHmmss"));

            }
            else {
                // we create new column and add here
                if ( rowZero.getCell(i) == null ) {
                    rowZero.createCell(i);
                }

                Map<String, Map<String, String>> actualData  = new LinkedHashMap<>();

                actualData.put(
                        "UAT - TC 1",
                        new LinkedHashMap<String, String>() {
                            {
                                put("MaxLoanAmount", "105000.00");
                                put("MonthlyPayment", "4969.44");
                                put("MinimumDeposit", "350000.00");
                            }
                        }
                );
                actualData.put(
                        "UAT - TC 2",
                        new LinkedHashMap<String, String>() {
                            {
                                put("MaxLoanAmount", "700000.00");
                                put("MonthlyPayment", "3312.74");
                                put("MinimumDeposit", "147500.00");
                            }
                        }
                );

                for ( Map.Entry<String, Map<String, String>> currentList : actualData.entrySet()) {
                    String currentScenario = currentList.getKey();
                    System.out.println(currentList);
                    Map<String, String> currentActualData = currentList.getValue();
                    for ( Map.Entry<String, String> currentActualDataEntry : currentActualData.entrySet() ) {
                        String currentActualDataKey = currentActualDataEntry.getKey();
                        String currentActualDataValue = currentActualDataEntry.getValue();
                        System.out.println(currentActualDataKey + " - " + currentActualDataValue);

                        Pattern p = Pattern.compile("UAT - TC (\\d{1,3})");
                        Matcher m = p.matcher(currentScenario);

                        int scenario = 0;
                        while (m.find()) {
                            scenario = Integer.parseInt(m.group(1));
                        }

                        System.out.println("Scenario: "  + scenario);

                        InitFieldRow enumValue = null;
                        switch (currentActualDataKey) {
                            case "MaxLoanAmount":
                                enumValue = InitFieldRow.MAX_LOAN_AMOUNT;
                                break;
                            case "MonthlyPayment":
                                enumValue = InitFieldRow.MONTHLY_PAYMENT;
                                break;
                            case "MinimumDeposit":
                                enumValue = InitFieldRow.MINIMUM_DEPOSIT;
                                break;
                            default:
                        }
                        //noinspection ConstantConditions
                        HSSFRow row = sheet.getRow(15*(scenario-1)+enumValue.getValue());
                        if(row.getCell(i) == null)
                            row.createCell(i);
                        row.getCell(i).setCellValue(currentActualDataValue);
                    }
                }

                DateTime now = DateTime.now();
                sheet.getRow(0).getCell(i).setCellValue(now.toString("yyyyMMddHHmmss"));

            }


//            HSSFCell cell = row.getCell(3);
//            if (cell == null)
//                cell = row.createCell(3);
//            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//            cell.setCellValue("a test");

            // Write the output to a file
            fileOut = new FileOutputStream("./src/test/resources/ReportCalQuote.xls");
            wb.write(fileOut);
        } finally {
            if (fileOut != null)
                fileOut.close();
            if (fileIn != null)
                fileIn.close();
        }
    }
}
