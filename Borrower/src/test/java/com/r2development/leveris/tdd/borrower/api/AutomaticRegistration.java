package com.r2development.leveris.tdd.borrower.api;

import com.r2development.leveris.utils.HttpUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

public class AutomaticRegistration {

    public static void main(String... arg) throws IOException, InterruptedException {

        HttpClient httpClient = HttpUtils.createHttpClient();
        HttpClientContext localContext = HttpUtils.initContext("appdev1.loftkeys.com", "/stable-borrower");

        requestHttpGet(
                httpClient,
                "https://appdev1.loftkeys.com/stable-borrower/",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                false
        );

        requestHttpGet(
                httpClient,
                "https://appdev1.loftkeys.com/stable-borrower/home?useCase=automaticregistration",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                false
        );

        Map<String, String> automationRegistration = new LinkedHashMap<>();
//        DateTime now = DateTime.now();
//        automationRegistration.put("root:c:w:pnlMain:c:w:txtId:tb", "anthony.mottot.test00001" + now.toString("yyyyMMddHHmmssSSS") + "@abakus.com");
        automationRegistration.put("root:c:w:pnlMain:c:w:txtId:tb", "anthony.mottot.test00001" + System.getProperty("timestamp"));


        boolean quoteComplete = true;
        boolean coapplicant = true;
        //noinspection ConstantConditions
        if ( quoteComplete ) {
            automationRegistration.put("root:c:w:pnlMain:c:w:chkQuote:checkbox", "on");
            //noinspection ConstantConditions
            if ( coapplicant ) {
                automationRegistration.put("root:c:w:pnlMain:c:w:chkCoapp:checkbox", "on");
//                automationRegistration.put("root:c:w:pnlMain:c:w:pnlQuote:c:w:txtCoapp:tb", "anthony.mottot.coapplicant.test0001" + now.toString("yyyyMMddHHmmssSSS") + "@abakus.com");
                automationRegistration.put("root:c:w:pnlMain:c:w:pnlQuote:c:w:txtCoapp:tb", "anthony.mottot.coapplicant.test0001" + System.getProperty("timestamp") + "@abakus.com");
            }
        }

        automationRegistration.putAll(
            new LinkedHashMap<String, String>() {
            {
                put("stepToken", "1");
                put("root:c:w:pnlMain:c:w:btn-register:submit", "1");
            }
        });

        requestHttpPost(
                httpClient,
                "https://appdev1.loftkeys.com/stable-borrower/form.2?wicket:interface=:3:main:c:form:form:root:c:w:pnlMain:c:w:btn-register:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                automationRegistration,
                localContext,
                false
        );


        // ===============================================
        // ===============================================
        // ===============================================

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ui-prioritize-in-gpu-process");
//        String userdata = "--user-data-dir=./target/" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String userdata = "--user-data-dir=./target/" + System.getProperty("timestamp");
        options.addArguments(userdata);
        WebDriver webDriver = new ChromeDriver(options);

        webDriver.get("https://appdev1.loftkeys.com/stable-borrower/home?useCase=automaticregistration");
        new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtId_tb']")));
//        webDriver.findElement(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtId_tb']")).sendKeys("anthony.mottot.test00001" + now.toString("yyyyMMddHHmmssSSS") + "@abakus.com");
        webDriver.findElement(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_txtId_tb']")).sendKeys("anthony.mottot.test00001" + System.getProperty("timestamp") + "@abakus.com");
        new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_chkQuote']//a")));
        webDriver.findElement(By.xpath("//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_chkQuote']//a")).click();
        new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_chkCoapp']//a")));
        webDriver.findElement(By.xpath("//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_chkCoapp']//a")).click();
        new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlQuote_c_w_txtCoapp_tb']")));
//        webDriver.findElement(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlQuote_c_w_txtCoapp_tb']")).sendKeys("anthony.mottot.coapplicant.test0001" + now.toString("yyyyMMddHHmmssSSS") + "@abakus.com");
        webDriver.findElement(By.xpath("//input[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_pnlQuote_c_w_txtCoapp_tb']")).sendKeys("anthony.mottot.coapplicant.test0001" + System.getProperty("timestamp") + "@abakus.com");

        new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_btn-register']/a")));
        webDriver.findElement(By.xpath("//div[@wicketpath='main_c_form_form_root_c_w_pnlMain_c_w_btn-register']/a")).click();

        Thread.sleep(5000);

        webDriver.quit();

    }
}
