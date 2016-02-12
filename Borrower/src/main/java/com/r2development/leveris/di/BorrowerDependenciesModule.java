package com.r2development.leveris.di;

import com.google.inject.AbstractModule;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BorrowerDependenciesModule extends AbstractModule /*implements Module*/ {

    private IUser user;
    private WebDriver webDriver;

    @Override
    protected void configure() {

        if ( StringUtils.isEmpty(System.getProperty("environment")))
            System.setProperty("environment", "dev2");
        if ( StringUtils.isEmpty(System.getProperty("domain")))
            System.setProperty("domain", "http://dv2app.opoqodev.com/");
        if ( StringUtils.isEmpty(System.getProperty("borrower")))
            System.setProperty("borrower", "http://dv2app.opoqodev.com/stable-borrower");
        if ( System.getProperty("browser") == null)
            System.setProperty("browser", "chrome");
        if ( StringUtils.isEmpty(System.getProperty("timestamp")))
            System.setProperty("timestamp", DateTime.now().toString("yyyyMMddHHmmssSSS"));

        switch (System.getProperty("browser")) {
            case "chrome":
                webDriver = new ChromeDriver();
                bind(WebDriver.class).toInstance(webDriver);
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                bind(WebDriver.class).to(FirefoxDriver.class);
                break;
        }

        user = new User();
        bind(IUser.class).toInstance(user);
    }

}