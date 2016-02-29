package com.r2development.leveris.tdd.borrower.po;

import com.r2development.leveris.selenium.borrower.pageobjects.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by anthonymottot on 19/02/2016.
 */
public class AccountPO {

    public static void main(String... args) {
        WebDriver webDriver = new ChromeDriver();
        WelcomePage welcomePage = new WelcomePage(webDriver);
    }
}
