package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import java.util.Map;

public interface IForm {
    void FillIn(Map<String, String> data);
    void clickSaveAndClose();
}