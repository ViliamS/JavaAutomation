package com.r2development.leveris.selenium.borrower.pageobjects.sectionobjects;

public interface IMessageSection {
    String MESSAGE_SECTION_XPATH = "//div[@wicketpath='top']";
    String MESSAGE_CONTAINER_XPATH = MESSAGE_SECTION_XPATH + "//div[@class='panel-inner']";
    String MESSAGE_TEXT_XPATH = MESSAGE_CONTAINER_XPATH + "//text()";
    String GET_ONE_NOW_XPATH = "//a[contains(., 'Get one now')]";

    void clickGetOneNow(); // GetNowQuote
    String getMessage();
}
