package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

import java.util.Map;

/**
 * Created by anthonymottot on 17/03/2016.
 */
public interface IForm {
    void FillIn(Map<String, String> data);
    void clickSaveAndClose();
}
