package com.r2development.leveris.utils;

import org.hamcrest.core.Is;

import java.io.File;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;

public class ExcelUtils /*implements IBorrower*/ {

    public static boolean checkExcelExists() {
        File file = null;
        try {
            //noinspection ConstantConditions
            file = new File(ExcelUtils.class.getClassLoader().getResource(System.getProperty("excelFilename")).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //noinspection ConstantConditions
        return file.exists();
    }

    public static String getAbsolutePath() {
        File file = null;
        try {
            //noinspection ConstantConditions
            file = new File(ExcelUtils.class.getClassLoader().getResource(System.getProperty("excelFilename")).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //noinspection ConstantConditions
        assertThat("File should exist", file.exists(), Is.is(true));
        return file.getAbsolutePath();
    }
}
