package com.r2development.leveris.qa.utils.datamodelvalidator.borrowerloanapp;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;


import java.io.*;
import java.util.*;

public class ExcelDataMavenCycleValidator {

    private static final Log log = LogFactory.getLog(ExcelDataMavenCycleValidator.class.getName());

    // TODO ok it's working but we usually use a Primitive as key not a Object
    private static Map<Exception, String> relatedExceptions = new HashMap<>();
    private static Map<Exception, String> relatedAssertions = new HashMap<>();
    private static String declaredTestedPaths = "";

    public static void main(String[] arg) throws Exception {
        log.info("ExcelDataMavenCycleValidator excelDataValidationMain(String[] arg) method is executing during Maven cycle");

        // This part is handling case when there is only one entry to be verified and this only one entry is ending with .xls so its only single file verification */
        if(arg.length == 1){

            File xlsFile = new File(arg[0]);
            String fileSuffix = FilenameUtils.getExtension(xlsFile.getAbsolutePath());

            // Does argument have a suffix xls */
            if(fileSuffix.equals("xls")){

                // Does file really exists and it is not folder ending with .xls checking if it points to real file */
                if(xlsFile.isFile()) {

                    ExcelDataValidator validator = new ExcelDataValidator(arg[0]);
                    validator.excelDataValidationMain();
                    declaredTestedPaths = declaredTestedPaths + "\n Tested path PASSED : " + arg[0];

                } else {
                    // This part executes when there is folder with name containing ".xls" example folderName.xls and that is not acceptable as target to validate */
                    throw new Exception("Not valid target to validate problem was due to value : '" + arg[0] + "'");
                }
            }
        }
        // Map is going to contains results in way where
        // Map<Integer, String> - Integer is index and the String is specifying a folderPath where to look for excel files.
        // Map<String, List<String>> - String is specifying a filePath where to look for excel files and the List<String> will contains founded xls files for specified folderPath
        Map<String ,List<String>> foldersToValidateAndXLSFilesWithin = new HashMap<>();

        // For cycle going through all records of field String[] arg */
        for (String filePath : arg) {

            log.info("String filePath = '\n" + filePath + "'");

            // If filePath ends with .xls we know it is only one file to verify */
            if (filePath.endsWith(".xls")) {

                File xlsFile = new File(filePath);
                String fileSuffix = FilenameUtils.getExtension(xlsFile.getAbsolutePath());

                if(fileSuffix.equals("xls") && xlsFile.isFile()) {

                    // Double catch is for catching Exception errors and the second for catching Assertion errors
                    try {

                        // Calling overloaded method excelDataValidationMain as we test only one file */
                        ExcelDataValidator validator = new ExcelDataValidator(filePath);
                        validator.excelDataValidationMain();
                        declaredTestedPaths = declaredTestedPaths + "\n Tested path PASSED : " + filePath;


                    } catch (AssertionError assertionOrException) {

                        // Catching possible Assertion failure in previous loading and storing them for later raising as we want to test all cases and then to report the results
                        String exceptionDetailText = "Assertion Problem during validation of loading excel File = '" + filePath + "'  in filePath = '" + filePath + "'";
                        assertionCatchBody(filePath, assertionOrException, exceptionDetailText);

                    } catch (Exception exception) {

                        // Catching possible Exceptions in previous loading and storing them for later raising as we want to test all cases and then to report the results
                        String exceptionDetailText = "Exception Problem within loading of excel File = '" + filePath + "'  in filePath = '" + filePath + "'";
                        exceptionCatchBody(filePath, exception, exceptionDetailText);
                    }
                } else {
                    //This part executes when there is folder with name containing ".xls" example folderName.xls and that is not acceptable as target to validate
                    throw new Exception("Not valid target to validate problem was due to value : '" + filePath + "'");
                }
            } else {

                // This part is executing validation for set of files detected in specified folder so we need to filter all files ending with .xls and validate all of them */
                    try {

                        List<String> results = new LinkedList<>();
                        File rootFolder = new File(filePath);

                        log.info("File rootFolder = '\n" + rootFolder + "\n");

                        // Listing all files under specified folder location and filtering only those having xls as suffix */
                        File[] files = rootFolder.listFiles((FileFilter) FileFilterUtils.suffixFileFilter("xls"));

                        log.info("File[] files = '\n" + Arrays.toString(files) + "'\n");

                        //If this pathname does not denote a directory, then listFiles() returns null.
                        Assert.assertFalse("Directory not found in path '\n" + filePath + "', because File[] files == null \n", files == null);

                        for (File file : files) {
                            if (file.isFile()) {
                                results.add(file.getName());
                            }
                        }
                        // Putting each file in List to validate them later on */
                        foldersToValidateAndXLSFilesWithin.putIfAbsent(filePath, results);

                    } catch (AssertionError assertionOrException) {

                        // Catching possible Assertion failure in previous loading and storing them for later raising as we want to test all cases and then to report the results */
                        String exceptionDetailText = "Problem was in loading of directory '" + filePath + "' was not found";
                        assertionCatchBody(filePath, assertionOrException, exceptionDetailText);

                    } catch (Exception exception) {

                        // Catching possible Exceptions in previous loading and storing them for later raising as we want to test all cases and then to report the results */
                        String exceptionDetailText = "Exception Problem within loading of excel File = '" + filePath + "'  in filePath = '" + filePath + "'";
                        exceptionCatchBody(filePath, exception, exceptionDetailText);
                    }
            }
        }
        // This part is executing validation for all folders and their xls contents detected in them */
        // Validating a List of files detected withing a folder */
        ExcelDataMavenCycleValidator.validateAllXLSInFolder(foldersToValidateAndXLSFilesWithin);

        // Throwing Exception in case there was some problem in loading of some files */
        if (relatedExceptions.size() > 0 || relatedAssertions.size() > 0) {
            failureThrow(arg);
        }
    }

    /**
     * Method for triggering Exception if there were some AssertionErrors or Exception caught and stored
     * @throws Exception - With failure description containing all caught Assertions or Exceptions texts
     */
    private static void failureThrow(String[] arg) throws Exception {
        List<String> failures = new LinkedList<>();
        String exceptionText = "";
        String araToCompareIfProcessed = "";

        for (Map.Entry<Exception, String> relatedException : relatedExceptions.entrySet()) {
            //noinspection ThrowableResultOfMethodCallIgnored
            String failureDescription = relatedException.getKey().toString() + "\n Failed for folderPath or filePath" + relatedException.getValue();
            failures.add(failureDescription);

            for (String filePath : arg) {
                if (relatedException.getValue().equalsIgnoreCase(filePath)) {
                    declaredTestedPaths = declaredTestedPaths + "\n Tested path FAILED : " + filePath;
                }
            }
        }
        for (Map.Entry<Exception, String> relatedAssertion : relatedAssertions.entrySet()) {
            //noinspection ThrowableResultOfMethodCallIgnored
            String failureDescription = relatedAssertion.getKey().toString() + "\n" + relatedAssertion.getValue();
            failures.add(failureDescription);

            for (String filePath : arg) {
                if (relatedAssertion.getValue().equalsIgnoreCase(filePath)) {
                    declaredTestedPaths = declaredTestedPaths + "\n Tested path FAILED : " + filePath;
                }
            }
        }

        for (String failure : failures ){
            exceptionText = exceptionText + failure;
        }

        for (String filePath : arg){
            araToCompareIfProcessed = araToCompareIfProcessed + "\n Path that should be Tested : " + filePath;
        }

        log.info(araToCompareIfProcessed);

        log.info(declaredTestedPaths);

        throw new Exception(exceptionText);
    }

    /**
     * Method responsible for gathering all caught exceptions
     * @param exception - Error Text of caught exception
     * @param exceptionDetailText - Detailed text for closer description in what context was Exception caught
     */
    private static void exceptionCatchBody (String filePath, Exception exception, String exceptionDetailText){
        Exception exceptionDetail = new Exception(exceptionDetailText + "\n" + exception);
        relatedExceptions.put(exceptionDetail, filePath);
    }

    /**
     * Method responsible for gathering all caught assertions
     * @param assertion - Error Text of caught AssertionError
     * @param assertionDetailText - Detailed text for closer description in what context was Assertion error caught
     */
    private static void assertionCatchBody (String filePath, AssertionError assertion, String assertionDetailText){
        Exception exceptionDetail = new Exception(assertionDetailText + "\n" + assertion);
        relatedAssertions.put(exceptionDetail, filePath);
    }

    /**
     *
     * @param foldersToValidateAndXLSFilesWithin - String is specifying a filePath where to look for excel files and the List<String> will contains founded xls files for specified folderPath
     * @return - True is Validation passed otherwise return Exception
     * @throws Exception
     */
    private static boolean validateAllXLSInFolder(Map<String, List<String>> foldersToValidateAndXLSFilesWithin) throws Exception, AssertionError {
        log.info("ExcelDataMavenCycleValidator executing a Method validateAllXLSInFolder(List<String>> foldersToValidateAndXLSFilesWithin)\n" +
                "Map<String, List<String>> foldersToValidateAndXLSFilesWithin = '" + foldersToValidateAndXLSFilesWithin + "'\n" +
                "\n");

        String folderPath;
        String finalFilePath="";

        // For each specified folderPath we get the .XLS files it contains */
        for (Map.Entry<String, List<String>> validateFolderPathEntry : foldersToValidateAndXLSFilesWithin.entrySet()) {

                List<String> filesToRead = validateFolderPathEntry.getValue();
                folderPath = validateFolderPathEntry.getKey();

                // For each .XLS file within specified folder we execute the Data Structure validation*/
                for (String fileToRead : filesToRead) {

                    try {
                        finalFilePath = folderPath + "/" + fileToRead;
                        ExcelDataValidator validator = new ExcelDataValidator(finalFilePath);
                        validator.excelDataValidationMain();
                        declaredTestedPaths = declaredTestedPaths + "\n Tested folderPath IN PROGRESS : '" + folderPath + "' PASSED for file : '" + fileToRead + "'";

                    } catch (AssertionError assertion) {

                        declaredTestedPaths = declaredTestedPaths + "\n Tested folderPath IN PROGRESS BUT FAILURE CATCH : '" + folderPath + "' FAILED for file : '" + fileToRead + "'";
                        // Catching possible Assertion failure in previous loading and storing them for later raising as we want to test all cases and then to report the results */
                        String exceptionDetailText =    "Problem in validating folderPath = '" + folderPath + "' and it's File = '" + finalFilePath.replace(folderPath + "/", "") + "'\n" +
                                                        "Relative finalFilePath = '" + finalFilePath + "'";
                        assertionCatchBody(finalFilePath, assertion, exceptionDetailText);

                    } catch (Exception exception) {

                        declaredTestedPaths = declaredTestedPaths + "\n Tested folderPath IN PROGRESS BUT FAILURE CATCH : '" + folderPath + "' FAILED for file : '" + fileToRead + "'";
                        // Catching possible Exceptions in previous loading and storing them for later raising as we want to test all cases and then to report the results */
                        String exceptionDetailText =    "Problem in validating folderPath = '" + folderPath + "' and it's File = '" + finalFilePath.replace(folderPath + "/", "") + "'\n" +
                                                        "Relative filePath = '" + finalFilePath + "'";
                        exceptionCatchBody(finalFilePath, exception, exceptionDetailText);
                    }
                }
                declaredTestedPaths = declaredTestedPaths + "\n Tested folderPath FINISHED : '" + folderPath + "'";
        }
        log.info("ALL folderPath Validations FINISHED");
        return true;
    }
}
