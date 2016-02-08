package com.r2development.leveris.selenium.apollo.pageobjects;

public interface IResultSection {

    String INFO_RESULT_XPATH = "//div[contains(@class, 'alert-info') and @role='alert']";
    String DANGER_RESULT_XPATH = "//div[contains(@class, 'alert-danger') and @role='alert']";

    int EXPECTED_COLUMN_NUMBER = 7;

    String TABLE_XPATH = "//table";

    String TABLE_HEADER_XPATH = TABLE_XPATH + "/thead";
    String TABLE_HEADER_ROW_XPATH = TABLE_HEADER_XPATH + "/tr";
    String TABLE_HEADER_COLUMN_XPATH = TABLE_HEADER_ROW_XPATH + "/th";

    String TABLE_BODY_XPATH = TABLE_XPATH + "/tbody";
    String TABLE_BODY_ROW_XPATH = TABLE_BODY_XPATH + "/tr";
    String TABLE_BODY_COLUMN_XPATH = TABLE_BODY_ROW_XPATH + "/td";

    String GLYPHICON_CHEVRON_XPATH = "./span[contains(@class, 'glyphicon-chevron')]";
    String HEADER_COLUMN_TEXT_XPATH = "./span[not(contains(@class, 'glyphicon')) and contains(@data-reactid, '.2')]";
    String ORDER_BY_COLUMN_XPATH = ".//span[contains(@class, 'glyphicon-chevron') and not(contains(@style, 'color'))]/following-sibling::span[not(text()=' ')]";

    String ORDER_BY_SPEC_COLUMN_XPATH = ".//span[not(contains(@style, 'color')) and text()[contains(.,'${replace}$')]]/parent::th";

    String getInfoData() throws Exception;
    IResultSection extractResult() throws Exception;
    IResultSection sortBy(String columnName, String orderBy) throws Exception;
    IRecordPage selectCustomer(int row) throws Exception;
}
