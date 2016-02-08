package com.r2development.leveris.qa.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ACMExcel {

    private static final Log log = LogFactory.getLog(ACMExcel.class.getName());

//    private String filePath;
    private final String timeStamp = timeStamp();
    private File file;
//    private FileInputStream fileInputStream;
    private POIFSFileSystem loadedFile;
    private HSSFWorkbook workbook;
    private static HSSFWorkbook staticWorkbook;
    private HSSFSheet sheet;

    /**
     * Default Constructor
     * @param filePath - String with path to file we want to load
     */
    public ACMExcel(String filePath) {
//        this.filePath = filePath;
        try {
            this.file = new File(filePath);
//            this.fileInputStream = new FileInputStream(filePath);
            this.loadedFile = new POIFSFileSystem(new FileInputStream(filePath));
            this.workbook = new HSSFWorkbook(this.loadedFile);
            this.sheet = getWorkbook().getSheet("Borrower Test Data");
//            ACMExcel.staticWorkbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(filePath)));
            ACMExcel.staticWorkbook = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Static method getWorkbook
     * @param filePath - String containing filePath to the file we want to load
     * @return HSSFWorkbook - for declared filePath
     * @throws IOException
     */
    public static HSSFWorkbook getWorkbook (String filePath) throws IOException {
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.getWorkbook();
    }

    /**
     * Obtains a Workbook for currently loaded file
     * @return HSSFWorkbook for currently loadedFile
     * @throws IOException
     */
    private HSSFWorkbook getWorkbook() throws IOException {
        return new HSSFWorkbook(loadedFile);
    }

    /**
     * Method for generating Timestamp
     * @return String timeStamp in format yyyyMMddHHmmssSSS
     */
    public String timeStamp(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    /**
     * Static calling of method creating a timeStamp
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @return String timeStamp in format yyyyMMddHHmmssSSS
     */
    public static String timeStamp(String filePath){
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.timeStamp();
    }

    /**
     * It is obtaining the sheet from workbook so further actions are possible against this defined sheet
     * @param sheetName - String containing existing sheet name we want to select
     * @return - selected sheet for further actions
     * @throws IOException
     */
    private HSSFSheet setSheet(String sheetName) throws IOException {
        log.debug("this.method getSheet(String sheetName = '" + sheetName + "')");
        return this.getWorkbook().getSheet(sheetName);
    }

    /**
     * It is obtaining the sheet from workbook so further actions are possible against this defined sheet
     * @param sheetName - String containing existing sheet name we want to select
     * @return - selected sheet for further actions
     */
    public static HSSFSheet setSheet(String filePath, String sheetName) throws IOException {
        log.debug("this.method getSheet(String filePath, String sheetName = '" + sheetName + "')");
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.setSheet(sheetName);
    }

    /**
     * It is obtaining the sheet from workbook so further actions are possible against this defined sheet
     * @param sheetName - String containing existing sheet name we want to select
     * @return - selected sheet for further actions
     * @throws IOException
     */
    private HSSFSheet getSheet(String sheetName) throws IOException {
        log.debug("this.method getSheet(String sheetName = '" + sheetName + "");
        return getWorkbook().getSheet(sheetName);
    }

    /**
     * Static variant It is obtaining the sheet from workbook so further actions are possible against this defined sheet
     * @param sheetName - String containing existing sheet name we want to select
     * @return - selected sheet for further actions
     * @throws IOException
     */
    private static HSSFSheet getSheet(String filePath, String sheetName) throws IOException {
        log.debug("static method getSheet(String filePath, String sheetName = '" + sheetName + "')");
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.getSheet(sheetName);
    }

    /**
     * Gets a cell and is possible to use for any available operations.
     * @param row - row where cell is placed
     * @param column - column in which cell is placed
     * @return HSSFCell type object
     */
    private HSSFCell getCellValue(int row, int column) throws IOException {
        log.debug("this.method getCellValue(int row = '" + row + "', int column = '" + column + "')");
        return this.sheet.getRow(row).getCell(column);
    }

    /**
     * Static variant gets a cell and is possible to use for any available operations.
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @param sheetName - String containing existing sheet name we want to select... it present just because of static declaration necessity
     * @param row - row where cell is placed
     * @param column - column in which cell is placed
     * @return HSSFCell type object
     * @throws IOException
     */
    public static HSSFCell getCellValue(String filePath, String sheetName, int row, int column) throws IOException {
        log.debug("this.method getCellValue(String filePath, String sheetName, int row = '" + row + "', int column = '" + column + "')");
        ACMExcel acmExcel = new ACMExcel(filePath);
        acmExcel.setSheet(sheetName);
        return acmExcel.getCellValue(row, column);
    }

    /**
     *
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @param sheetName - String containing existing sheet name we want to select... it present just because of static declaration necessity
     * @param row - row where cell is placed
     * @param column - column in which cell is placed
     * @return - String content of cell we targeted
     * @throws IOException
     */
    public static String getStringCellValue (String filePath, String sheetName, int row, int column) throws IOException {
        log.debug("this.method getStringCellValue(String filePath, String sheetName, int row = '" + row + "', int column = '" + column + "')");
        ACMExcel acmExcel = new ACMExcel(filePath);
        acmExcel.setSheet(sheetName);
        return acmExcel.getStringCellValue(row, column);
    }

    /**
     *
     * @param row - row where cell is placed
     * @param column - column in which cell is placed
     * @return - String content of cell we targeted
     * @throws IOException
     */
    private String getStringCellValue(int row, int column) throws IOException {
        log.debug("this.method getStringCellValue(int row = '" + row + "', int column = '" + column + "')");
        return getCellValue(row, column).getStringCellValue();
    }

    /**
     * Obtains a last row number for file loaded of selected sheetName
     * @return int number of rows in current sheet
     */
    private int getLastRowNumber(){
        log.debug("this.method getLastRowNumber() \n");
        return this.sheet.getLastRowNum() + 1;
    }

    /**
     * Static variant Obtains a last row number for file loaded of selected sheetName
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @param sheetName - String containing existing sheet name we want to select... it present just because of static declaration necessity
     * @return int number of rows in current sheet
     * @throws IOException
     */
    public static int getLastRowNumber(String filePath, String sheetName) throws IOException {
        log.debug("this.method getLastRowNumber() \n");
        ACMExcel acmExcel = new ACMExcel(filePath);
        acmExcel.setSheet(sheetName);
        return acmExcel.getLastRowNumber();
    }

    /**
     * For loaded file and selected sheet and declared row it returns number of columns present
     * @param row - Declaring row we want to detect number of columns
     * @return - int how many columns is in current row
     * @throws IOException
     */
    private int getLastCellNumber(int row) throws IOException {
        log.debug("this.method getLastCellNumber(int row) \n");
        return this.sheet.getRow(row).getLastCellNum();
    }

    /**
     * For loaded file and declared sheet and row it returns number of columns present
     * @param sheetName String containing existing sheet name we want to select
     * @param row - Declaring row we want to detect number of columns
     * @return - int how many columns is in current row
     * @throws IOException
     */
    private int getLastCellNumber(String sheetName, int row) throws IOException {
        log.debug("this.method getLastCellNumber(String sheetName, int row) \n");
        this.sheet = setSheet(sheetName);
        return getWorkbook().getSheet(sheetName).getRow(row).getLastCellNum();
    }

    /**
     * Static variant For loaded file and declared sheet and row it returns number of columns present
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @param sheetName - String containing existing sheet name we want to select... it present just because of static declaration necessity
     * @param row - Declaring row we want to detect number of columns
     * @return - int how many columns is in current row
     * @throws IOException
     */
    public static int getLastCellNumber(String filePath, String sheetName, int row) throws IOException {
        log.debug("this.method getLastCellNumber() \n");
        ACMExcel acmExcel = new ACMExcel(filePath);
        acmExcel.setSheet(sheetName);
        return acmExcel.getLastCellNumber(row);
    }

    /**
     * It's closing workbook clearing it from memory
     * @throws IOException
     */
    private void closeWorkbook() throws IOException {
        log.debug("this.method closeWorkbook()");
        this.workbook.close();
    }

    /**
     * Static variant It's closing workbook clearing it from memory
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @throws IOException
     */
    public static void closeWorkbook(String filePath) throws IOException {
        log.debug("this.method closeWorkbook()");
        ACMExcel acmExcel = new ACMExcel(filePath);
        acmExcel.closeWorkbook();
    }

    /**
     *  Method is returning a Map of sheet Names distinguished by key
     *  Key is representing ordering in workbook 0 is first sheet in workbook 1 is second etc...
     *  Value is actual sheetName
     *
     * Note : Duplicity is not possible to encounter
     *
     * @return sheetNamesMap - Map<Integer,String> - containing all workbook sheetNames added into map
     */
    public Map<Integer, String> getSheetNames(){
        log.debug("this.method getSheetNames");
        Map<Integer, String> sheetNamesMap = new HashMap<>();
        int sheetNumber = this.workbook.getNumberOfSheets();

        for (int i = 0; i < sheetNumber; i++){
            sheetNamesMap.put(i, this.workbook.getSheetAt(i).getSheetName());
        }
        return sheetNamesMap;
    }

    /**
     *  Static variant of Method is returning a Map of sheet Names distinguished by key
     *  Key is representing ordering in workbook 0 is first sheet in workbook 1 is second etc...
     *  Value is actual sheetName
     *
     * Note : Duplicity is not possible to encounter
     *
     * @return sheetNamesMap - Map<Integer,String> - containing all workbook sheetNames added into map
     */
    public static Map<Integer, String> getSheetNames(String filePath) throws IOException {
        log.debug("this.method getSheetNames");
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.getSheetNames();
    }

    /**
     * Load Data into Map<String, String> with duplicity check and indexing the duplicity key
     * @param sheetName - String sheetName we want to load Data from
     * @return sheetDataMap Map<String, String>
     */
    public static Map<String, String> loadSheetDataByRows(String filePath, String sheetName) throws Exception {
        log.debug("ExcelToMapLoader loadSheetDataByRows");
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.loadSheetDataByRows(sheetName);
    }

    /**
     * Is loading data from provided sheetNames into Map<String, Map<String, String>>
     * @param sheetNames - Is a map containing sheet Names with index as a key
     * @return - Map<String, Map<String, String>> where key for sheetData is sheetName
     * @throws Exception
     */
    public Map<String, Map<String, String>> loadDataToSheetMap(Map<Integer, String> sheetNames) throws Exception {
        log.debug("ExcelToMapLoader loadDataToMap");
        Map<String, Map<String, String>> excelMap = new HashMap<>();

//        int numberOfSheets = sheetNames.size();
//        for (int i=0; i < numberOfSheets; i++) {
//            String sheetName = sheetNames.get(i);
//
//            this.sheet = setSheet(sheetName);
//            if(sheet == null){
//                throw new Exception("Sheet Name : '" + sheetName + "' is not present in loaded Excel File : '" + file.getCanonicalPath() + file.getName() + "'");
//            }
//            log.debug("Sheet Name is : '" + sheetName + "'");
//            int lastRow;
//            lastRow = getLastRowNumber();
//            Map<String, String> sheetData = new HashMap<>();
//
//            /**
//             * Reading data and putting them into Map
//             */
//            for (int row = 0; lastRow > row; row++) {
//
//                String key = getStringCellValue(row, 0);
//                log.debug("key == '" + key + "'");
//                String value = getStringCellValue(row, 1);
//                log.debug("value == '" + value + "'");
//
//                if (sheetData.get(key) != null) {
//                    log.debug("Skipping duplicate saving of Map item < '" + key + "', '" + value + "' >");
//                } else {
//                    sheetData.put(key, value);
//                    log.debug("Putted sheetData key == '" + key + "' and value == '" + value + "'");
//                }
//            }
//            if (excelMap.get(sheetNames.get(i)) == null) {
//                excelMap.put(sheetName, sheetData);
//                log.debug("Putted excelMap key == '" + sheetName + "' and value == '" + sheetData + "'");
//            } else {
//                log.debug("Skipping duplicate saving of sheetMap entry < '" + i + "', '" + sheetData + "' >");
//            }
//        }

        for ( String currentSheetNames : sheetNames.values() ) {
            this.sheet = setSheet(currentSheetNames);
            if ( sheet == null) {
                throw new Exception("Sheet Name : '" + currentSheetNames + "' is not present in loaded Excel File : '" + file.getCanonicalPath() + file.getName() + "'");
            }
            log.debug("Sheet Name is : '" + currentSheetNames + "'");

            int lastRow = getLastRowNumber();
            Map<String, String> sheetData = new HashMap<>();
            // Reading data and putting them into Map
            for (int row = 0; row < lastRow; row++) {

                String key = getStringCellValue(row, 0);
                log.debug("key == '" + key + "'");
                String value = getStringCellValue(row, 1);
                log.debug("value == '" + value + "'");

                if (sheetData.get(key) != null) {
                    log.debug("Skipping duplicate saving of Map item < '" + key + "', '" + value + "' >");
                } else {
                    sheetData.put(key, value);
                    log.debug("Putted sheetData key == '" + key + "' and value == '" + value + "'");
                }
            }
            excelMap.put(currentSheetNames, sheetData);
            log.debug("Putted excelMap key == '" + currentSheetNames + "' and value == '" + sheetData + "'");
        }

        closeWorkbook();
        return excelMap;
    }

    /**
     * Static variant Is loading data from provided sheetNames into Map<String, Map<String, String>>
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @param sheetNames - Is a map containing sheet Names with index as a key
     * @return - Map<String, Map<String, String>> where key for sheetData is sheetName
     * @throws Exception
     */
    public static Map<String, Map<String, String>> loadDataToSheetMap(String filePath, Map<Integer, String> sheetNames) throws Exception {
        log.debug("ExcelToMapLoader loadDataToMap");
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.loadDataToSheetMap(sheetNames);
    }

    /**
     * Is loading data from provided sheetNames into Map <Integer, Map<String, String>>
     * @param sheetNames - Is a map containing sheet Names with index as a key
     * @return - Map<Integer, Map<String, String>> where key is same as index from the input Map
     * @throws Exception
     */
    public Map<Integer, Map<String, String>> loadDataToMap(Map<Integer, String> sheetNames) throws Exception {

        log.debug("ExcelToMapLoader loadDataToMap");
        Map<Integer, Map<String, String>> excelMap = new HashMap<>();
        int numberOfSheets = sheetNames.size();

        for (int i=0; i < numberOfSheets; i++) {

            String sheetName = sheetNames.get(i);
            this.sheet = setSheet(sheetName);
            if(sheet == null){
                throw new Exception("Sheet Name : '" + sheetName + "' is not present in loaded Excel File : '" + file.getCanonicalPath() + file.getName() + "'");
//                throw new Exception("Sheet Name : '" + sheetName + "' is not present in loaded Excel File : '" + fileInputStream + "'");
            }
            log.debug("Sheet Name is : '" + sheetName + "'");
            int lastRow = getLastRowNumber();
            Map<String, String> sheetData = new HashMap<>();

            /**
             * Reading data and putting them into Map
             */
            for (int row = 0; row < lastRow; row++) {

                String key = getStringCellValue(row, 0);
                log.debug("key == '" + key + "'");
                String value = getStringCellValue(row, 1);
                log.debug("value == '" + value + "'");

//                if (sheetData.get(key) == null && !sheetData.containsKey(key)) {
                if (!sheetData.containsKey(key)) {
                    sheetData.put(key, value);
                    log.debug("Putted sheetData key == '" + key + "' and value == '" + value + "'");
                } else {
                    log.debug("Skipping duplicate saving of Map item < '" + key + "', '" + value + "' >");
                }
            }
            if (excelMap.get(i) == null) {
                excelMap.put(i, sheetData);
                log.debug("Putted excelMap key == '" + i + "' and value == '" + sheetData + "'");
            } else {
                log.debug("Skipping duplicate saving of sheetMap entry < '" + i + "', '" + sheetData + "' >");
            }
        }

/*
        for ( Map.Entry<Integer, String> currentEntry : sheetNames.entrySet() ) {
            this.sheet = setSheet(currentEntry.getValue());
            if(sheet == null){
                throw new Exception("Sheet Name : '" + currentEntry.getValue() + "' is not present in loaded Excel File : '" + file.getCanonicalPath() + file.getName() + "'");
            }
            log.debug("Sheet Name is : '" + currentEntry.getValue() + "'");
            int lastRow = getLastRowNumber();
            Map<String, String> sheetData = new HashMap<>();

            // Reading data and putting them into Map
            for (int row = 0; row < lastRow; row++) {

                String key = getStringCellValue(row, 0);
                log.debug("key == '" + key + "'");
                String value;
                value = getStringCellValue(row, 1);
                log.debug("value == '" + value + "'");

                if (sheetData.get(key) == null) {
                    sheetData.put(key, value);
                    log.debug("Putted sheetData key == '" + key + "' and value == '" + value + "'");
                } else {
                    log.debug("Skipping duplicate saving of Map item < '" + key + "', '" + value + "' >");
                }
            }

            excelMap.put(currentEntry.getKey(), sheetData);
            log.debug("Putted excelMap key == '" + currentEntry.getKey() + "' and value == '" + sheetData + "'");
        }
*/

        closeWorkbook();
        return excelMap;
    }

    /**
     * Is loading data from Registration Sheet it expects data in specific formatting way in Excel.
     * @return - Map<Integer, Map<String, String>> where the key is incremented per declared user.
     * @throws Exception
     */
    public Map<Integer, Map<String, String>> loadRegistrationDataToMap() throws Exception {

        Map<Integer, Map<String, String>> allUsersMap = new HashMap<>();

        this.sheet = getWorkbook().getSheet("Borrower Test Data");
        if(sheet == null){
            throw new Exception("Sheet Name : 'Borrower Test Data' is not present in loaded Excel File : '" + file.getCanonicalPath() + file.getName() + "'");
        }

        int lastCell = getLastCellNumber(0);

        int column = 0;
        for (int cell = 1; cell < lastCell; cell++, column++) {

            Map<String, String> singleUserMap = loadSingleList(getLastRowNumber(), column); // dynamic loading based on number of rows

            allUsersMap.put(column, singleUserMap);
        }
        closeWorkbook();
        return allUsersMap;
    }

    /**
     * Is being used in loadRegistrationDataToMap and this method is responsible for loading just a single user where the control parameters are maintained by outer method.
     * @param rows - number of rows to be loaded during one cycle.
     * @param column - which column is going to be loaded as a value into key value [is being always to be the first column]
     * @return - Map<String, String> - key is always the first column and value is input variable of this method
     * @throws IOException
     */
    private Map<String, String> loadSingleList(int rows, int column) throws IOException {

        Map<String, String> singleUserMap = new HashMap<>();

        for(int i = 0; i < rows; i++){

            if(getStringCellValue(i, 1).contains("${ReplaceMe}")){
                singleUserMap.put(getStringCellValue(1, 0), getStringCellValue(1, 1).replace("${ReplaceMe}", column + this.timeStamp));
            } else {
                singleUserMap.put(getStringCellValue(i, 0), getStringCellValue(i, 1));
            }
        }
        return singleUserMap;
    }

    /**
     * Static variant Is loading data from Registration Sheet it expects data in specific formatting way in Excel.
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @return - Map<Integer, Map<String, String>> where the key is incremented per declared user.
     * @throws Exception
     */
    public static Map<Integer, Map<String, String>> loadRegistrationDataToMap(String filePath) throws Exception {
        ACMExcel acmExcel = new ACMExcel(filePath);
        return  acmExcel.loadRegistrationDataToMap();
    }

    /**
     * Static variant Is loading data from provided sheetNames into Map <Integer, Map<String, String>>
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @param sheetNames - Is a map containing sheet Names with index as a key
     * @return - Map<Integer, Map<String, String>> where key is same as index from the input Map
     * @throws Exception
     */
    public static Map<Integer, Map<String, String>> loadDataToMap(String filePath, Map<Integer, String> sheetNames) throws Exception {
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.loadDataToMap(sheetNames);
    }

    /**
     * Static variant Is loading data from provided sheetNames into Map <Integer, Map<String, String>>
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * //@param sheetNames - Is a map containing sheet Names with index as a key not used
     * @return - Map<Integer, Map<String, String>> where key is same as index from the input Map
     * @throws Exception
     */
    public static Map<Integer, Map<String, String>> loadDataToMap(/*Map<Integer, String> sheetNames,*/ String filePath) throws Exception {
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.loadDataToMap(acmExcel.getSheetNames());
    }

    /**
     * Static variant Is loading data from provided sheetName into Map<String, String>
     * @param sheetName - String containing existing sheet name we want to read data from.
     * @param filePath - String with filePath we want to operate in... it present just because of static declaration necessity
     * @return - Map<String, String> with Data from defined sheetName
     * @throws Exception
     */
    public static Map<String, String> loadDataToMap(String sheetName, String filePath) throws Exception {
        ACMExcel acmExcel = new ACMExcel(filePath);
        return acmExcel.loadSheetDataByRows(sheetName);
    }

    /**
     * Load Data into Map<String, String> with duplicity check and indexing the duplicity key
     * @param sheetName - String sheetName we want to load Data from
     * @return sheetDataMap Map<String, String>
     */
    public Map<String, String> loadSheetDataByRows(String sheetName) throws Exception {
        log.debug("ACMExcel loadSheetDataByRows(String sheetName = '" + sheetName + "')");

        Map<String, String> sheetDataMap = new HashMap<>();
        Map<String, Integer> duplicityMap = new HashMap<>();

        /** Opens Excel File's sheet */
        this.sheet = setSheet(sheetName);

        /** If sheet is null throw Exception */
        if(sheet == null){
            throw new Exception("Sheet Name : '" + sheetName + "' is not present in loaded Excel File : '" + file.getCanonicalPath() + file.getName() + "'");
        }

        /** Loads sheet rows into Map<String, String> */
        for (int i = 0; i < getLastRowNumber(); i++){

            /** Get data from Excel cells */
            String key = this.getStringCellValue(i, 0);
            String value = this.getStringCellValue(i, 1);

            /** Creates entry <key, value> in Map if isn't already in Map */
            if(sheetDataMap.get(key) == null) {
                sheetDataMap.put(key, value);
                duplicityMap.put(key, 1);

            } else {

                /** Creates entry with index if it was already present and creates duplicate entry with counter */
                int duplicity = 1 + duplicityMap.get(key);
                key = key + "."  + duplicity;
                sheetDataMap.put(key, value);
                duplicityMap.replace(key, duplicity);
            }
        }
        this.closeWorkbook();
        return sheetDataMap;
    }

}
