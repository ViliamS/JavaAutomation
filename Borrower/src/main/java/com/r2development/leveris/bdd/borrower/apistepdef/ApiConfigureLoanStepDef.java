package com.r2development.leveris.bdd.borrower.apistepdef;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.r2development.leveris.bdd.borrower.model.QuoteData;
import com.r2development.leveris.di.IABorrowerHttpContext;
import com.r2development.leveris.di.IBorrowerHttpResponse;
import com.r2development.leveris.di.IUser;
import cucumber.api.java.en.And;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.r2development.leveris.utils.HttpUtils.CONSUME_QUIETLY;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;

//import io.github.bonigarcia.wdm.PhantomJsDriverManager;

@Singleton
public class ApiConfigureLoanStepDef extends ApiOpoqoBorrowerStepDef {

    private static final Log log = LogFactory.getLog(ApiConfigureLoanStepDef.class.getName());

    protected boolean toSkip = false;
    protected QuoteData quoteData = new QuoteData();

    @Inject
    IABorrowerHttpContext localContext;
    @Inject
    IBorrowerHttpResponse httpResponse;
    @Inject
    IUser user;

    @Inject
    public ApiConfigureLoanStepDef(IBorrowerHttpResponse httpResponse, IUser user) {
        this.httpResponse = httpResponse;
        this.user = user;
    }

    @And("^(Borrower) starts (\"Tweak your loan details\"|\"Payment method\"|\"Target account setup\"|\"Digitally sign the loan offer\")$")
    public void user_tweaks_his_loan_details(String user, String task) throws IOException {

        String formName = StringUtils.EMPTY;
        switch ( task ) {
            case "\"Tweak your loan details\"":
                formName = "LoanConfigurationCollapsed";
                break;
            case "\"Payment method\"":
                formName = "PaymentMethodSetupCollapsed";
                break;
            case "\"Target account setup\"":
                formName = "TargetAccountSetupCollapsed";
                break;
            case "\"Digitally sign the loan offer\"":
                formName = "LoanAgreementCollapsed";
                break;
            default:
        }

        Document configureLoanScreen = Jsoup.parse(httpResponse.getHttpResponse());
        Elements evaluateElements =  configureLoanScreen.select("evaluate[encoding~=wicket]");
        String textContainingWorkItemId = "";
        for ( Element currentElement : evaluateElements) {
            if ( currentElement.outerHtml().contains(formName)) {
                textContainingWorkItemId = currentElement.text();
                break;
            }
        }

        Pattern pWorkItemId = Pattern.compile("\"workItemId\":\"([a-z0-9]+)\"");
        Matcher mWorkItemId = pWorkItemId.matcher(textContainingWorkItemId);
        String workItemId = null;
        while (mWorkItemId.find()) {
            workItemId = mWorkItemId.group(1);
        }
        final String finalWorkItemId = workItemId;

        String btnTaskHidden = Jsoup.parse(configureLoanScreen.select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_btnTasksHidden_submit]").attr("onclick");
        Pattern pBtnTaskHidden = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnTaskHidden = pBtnTaskHidden.matcher(btnTaskHidden);
        String btnTaskHiddenWicketInterface = StringUtils.EMPTY;
        while(mBtnTaskHidden.find()) {
            btnTaskHiddenWicketInterface = mBtnTaskHidden.group(1);
        }

        String taskHiddenResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnTaskHiddenWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:txtWorkItemViewTaskId:tb", finalWorkItemId);
                        put("stepToken", "1");
                        put("root:c:w:btnTasksHidden:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(taskHiddenResponse);
    }

    @And("(Borrower) submits \"Tweak your loan details\"")
    public void user_submits_tweak_your_loan_details(String user) throws IOException {

        Document configureLoanScreen = Jsoup.parse(httpResponse.getHttpResponse());
        Elements evaluateElements =  configureLoanScreen.select("evaluate[encoding~=wicket]");
        String textContainingPnlMortgageCalc = "";
        for ( Element currentElement : evaluateElements) {
            if ( currentElement.outerHtml().contains("#pnlMortgageCalc")) {
                textContainingPnlMortgageCalc = currentElement.text();
                break;
            }
        }

        Pattern pMortgageCalc = Pattern.compile("parseJSON\\(.*loanValue.:(.*),\"minLoanValue.*\"repaymentValue\":(.*)}'");
        Matcher mMortgageCalc = pMortgageCalc.matcher(textContainingPnlMortgageCalc);
        String tmpLoanValue = null;
        String tmpRepaymentValue = null;
        while (mMortgageCalc.find()) {
            tmpLoanValue = mMortgageCalc.group(1);
            tmpRepaymentValue = mMortgageCalc.group(2);
        }
        final String finalLoanValue = String.valueOf(Double.valueOf(tmpLoanValue));
        final String finalRepaymentValue = String.valueOf(Math.round(Double.valueOf(tmpRepaymentValue)));

        String btnSubmitLoanDetails = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_btnApplyOnline_submit]").attr("onclick");
        Pattern pBtnSubmitLoanDetails = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnSubmitLoanDetails = pBtnSubmitLoanDetails.matcher(btnSubmitLoanDetails);
        String btnSubmitLoanDetailsWicketInterface = StringUtils.EMPTY;
        while(mBtnSubmitLoanDetails.find()) {
            btnSubmitLoanDetailsWicketInterface = mBtnSubmitLoanDetails.group(1);
        }

        String submitLoanDetailsResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnSubmitLoanDetailsWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlMain:c:w:pnlMortgageCalc:data", "{\"loanValue\":"+ finalLoanValue + ",\"repaymentValue\":" + finalRepaymentValue + ",\"changedParam\":\"P\"}");
                        put("stepToken", "1");
                        put("root:c:w:btnApplyOnline:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(submitLoanDetailsResponse);
    }

    @And("^(Borrower) submits \"Payment method\"$")
    public void user_submits_payment_method(String user, Map<String, String> paymentMethodData) throws IOException {

        String btnSubmitPaymentMethod = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_btnSubmit_submit]").attr("onclick");
        Pattern pBtnSubmitPaymentMethod = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnSubmitPaymentMethod = pBtnSubmitPaymentMethod.matcher(btnSubmitPaymentMethod);
        String btnSubmitPaymentMethodWicketInterface = StringUtils.EMPTY;
        while(mBtnSubmitPaymentMethod.find()) {
            btnSubmitPaymentMethodWicketInterface = mBtnSubmitPaymentMethod.group(1);
        }

        String submitPaymentMethodResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnSubmitPaymentMethodWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:cmbPreferredDay:combobox", "3");
                        put("stepToken", "1");
                        put("root:c:w:btnSubmit:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(submitPaymentMethodResponse);

        String btnBack2Dashboard = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_btnBack_submit]").attr("onclick");
        Pattern pBtnBack2Dashboard = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnBack2Dashboard = pBtnBack2Dashboard.matcher(btnBack2Dashboard);
        String btnBack2DashboardWicketInterface = StringUtils.EMPTY;
        while(mBtnBack2Dashboard.find()) {
            btnBack2DashboardWicketInterface = mBtnBack2Dashboard.group(1);
        }

        String Back2DashboardResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnBack2DashboardWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:btnBack:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(Back2DashboardResponse);
    }

    @And("^(Borrower) submits \"Target account setup\"$")
    public void user_submits_target_account_setup(String user, Map<String, String> targetAccountSetupdData) throws IOException {

        String btnSubmitTargetAccountSetup = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlTargetAccountSetup_c_w_btnSubmit_submit]").attr("onclick");
        Pattern pBtnSubmitTargetAccountSetup = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnSubmitTargetAccountSetup = pBtnSubmitTargetAccountSetup.matcher(btnSubmitTargetAccountSetup);
        String btnSubmitTargetAccountSetupWicketInterface = StringUtils.EMPTY;
        while (mBtnSubmitTargetAccountSetup.find()) {
            btnSubmitTargetAccountSetupWicketInterface = mBtnSubmitTargetAccountSetup.group(1);
        }

        String submitTargetAccountSetupResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnSubmitTargetAccountSetupWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("root:c:w:pnlTargetAccountSetup:c:w:txtAccountName:tb", "Tester AutomationA");
                        put("root:c:w:pnlTargetAccountSetup:c:w:txtSortCode1:tb", "10");
                        put("root:c:w:pnlTargetAccountSetup:c:w:txtSortCode2:tb", "79");
                        put("root:c:w:pnlTargetAccountSetup:c:w:txtSortCode3:tb", "99");
                        put("root:c:w:pnlTargetAccountSetup:c:w:txtAccountNumber:tb", "88837491");
                        put("stepToken", "1");
                        put("root:c:w:pnlTargetAccountSetup:c:w:btnSubmit:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(submitTargetAccountSetupResponse);

        String btnBack2Dashboard = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[id~=cancel]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlTargetSetupSummary_c_w_btnBack_cancel]").attr("onclick");
        Pattern pBtnBack2Dashboard = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnBack2Dashboard = pBtnBack2Dashboard.matcher(btnBack2Dashboard);
        String btnBack2DashboardWicketInterface = StringUtils.EMPTY;
        while (mBtnBack2Dashboard.find()) {
            btnBack2DashboardWicketInterface = mBtnBack2Dashboard.group(1);
        }

        String Back2DashboardResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnBack2DashboardWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:btnBack:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(Back2DashboardResponse);
    }

    @And("^(Borrower) agrees the loan agreement$")
    public void user_agrees_the_loan_agreement(String user) throws IOException {
        String btnAgreeLoanAgreement = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_btnAgreeTerms_submit]").attr("onclick");
        Pattern pBtnAgreeLoanAgreement = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnAgreeLoanAgreement = pBtnAgreeLoanAgreement.matcher(btnAgreeLoanAgreement);
        String btnAgreeLoanAgreementWicketInterface = StringUtils.EMPTY;
        while (mBtnAgreeLoanAgreement.find()) {
            btnAgreeLoanAgreementWicketInterface = mBtnAgreeLoanAgreement.group(1);
        }

        String agreeLoanAgreementResponse = StringUtils.EMPTY;
        boolean togoon = true;
        int counter = 1;
        do {
            try {
                agreeLoanAgreementResponse = requestHttpPost(
                        httpClient,
                        //                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                        System.getProperty("borrower.url") + "/form.2?" + btnAgreeLoanAgreementWicketInterface,
                        new LinkedHashMap<String, String>() {
                            {
                                put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                            }
                        },
                        new LinkedHashMap<String, String>() {
                            {
                                put("stepToken", "1");
                                put("root:c:w:btnAgreeTerms:submit", "1");
                            }
                        },
                        localContext.getHttpContext(),
                        CONSUME_QUIETLY
                );
            }catch (IOException | AssertionError e) {
                togoon = false;
                counter++;
            }
        }
        while ( !togoon && counter <= 3);
        Assert.assertEquals("Houston, we have a problem to get generated the document !", true, togoon);
        httpResponse.setHttpResponse(agreeLoanAgreementResponse);
    }

    @And("^(Borrower) signs the loan offer document$")
    public void user_signs_the_loan_offer_document(String userApp) throws IOException {
        String urlAdobeDocument = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[id~=url]").select("a[wicketpath~=main_c_form_form_root_c_w_lnkLinkToAdobe]").attr("href");

//        HttpClient httpAdobeClient = HttpUtils.createHttpClient();
//        CookieStore cookieStore = new BasicCookieStore();
//        HttpClientContext localAdobeContext = HttpClientContext.create();
//
////        BasicClientCookie cookieScUnload = new BasicClientCookie("sc-unload", "obu");
////        cookieScUnload.setDomain(domain);
////        cookieScUnload.setPath(application);
////        cookieStore.addCookie(cookieScUnload);
//        BasicClientCookie cookieTest = new BasicClientCookie("cookietest", "1");
//        cookieTest.setDomain("na1.echosign.com");
//        cookieTest.setPath("/");
//        cookieStore.addCookie(cookieTest);
//        localAdobeContext.setCookieStore(cookieStore);
//
//        requestHttpGet(
//                httpAdobeClient,
//                urlAdobeDocument,
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//                        put("Host", "secure.na1.echosign.com");
//                        put("Referer", "http://dv2app.opoqodev.com/stable-borrower/form.2");
//                        put("Upgrade-Insecure-Requests", "1");
//                    }
//                },
//                localAdobeContext,
//                CONSUME_QUIETLY
//        );

        StringBuffer verificationErrors = new StringBuffer();
        DesiredCapabilities dCaps;

        dCaps = new DesiredCapabilities();
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", false);
        dCaps.setCapability("loadImages", false);

//        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  "/usr/bin/phantomjs");

        if ( System.getProperty("webdriver.phantomjs.driver") != null && System.getProperty("webdriver.phantomjs.driver").contains("phantomjs") ) {
//        dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  "/usr/bin/phantomjs");
//            System.setProperty("webdriver.phantomjs.driver", System.getProperty("JENKINS_HOME"));
            dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,  System.getProperty("webdriver.phantomjs.driver"));
            log.info("JENKINS: " + System.getProperty("webdriver.phantomjs.driver"));
        }
//        PhantomJsDriverManager.getInstance().setup("2.0.0");
        WebDriver webDriver = new PhantomJSDriver(dCaps);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 60);

        log.info("AdobeSign: " + urlAdobeDocument);
        webDriver.get(urlAdobeDocument);
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='popover-content'][text()='Start']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='popover-content'][text()='Start']")).click();
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//input[@name='echosign_email'][@value='" + user.getEmail() + "']"));
                    return true;
                });
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@role='button'][@aria-label='Click here to sign']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@role='button'][@aria-label='Click here to sign']")).click();
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//div[@class='modal-content']"));
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//div[@class='signature-panel-inner']"));
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//form//input[@class='form-control signature-name']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//form//input[@class='form-control signature-name']")).sendKeys("Test Automation");
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//button[@class='btn btn-primary apply'][text()='Apply']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='modal fade type in'][@style='display: block;']//button[@class='btn btn-primary apply'][text()='Apply']")).click();
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='agreement-footer']//div[@class='terms-of-use container-fluid'][@style='min-height: 50px; height: auto; display: block; margin-bottom: 0px; overflow: visible;']//button[@class='btn btn-primary click-to-esign'][text()='Click to sign']"));
                    return true;
                });
        webDriver.findElement(By.xpath("//div[@class='agreement-footer']//div[@class='terms-of-use container-fluid'][@style='min-height: 50px; height: auto; display: block; margin-bottom: 0px; overflow: visible;']//button[@class='btn btn-primary click-to-esign'][text()='Click to sign']")).click();

        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='interstitial'][@style='display: block;']"));
                    return true;
                });
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//div[@class='interstitial'][@style='display: none;']"));
                    return true;
                });
        webDriverWait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver driver) -> {
                    driver.findElement(By.xpath("//h1[@class='title'][contains(., 'You have successfully signed the agreement')]"));
                    return true;
                });
        webDriver.quit();

        String btnBack2Dashboard = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=form]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_btnNext_submit]").attr("onclick");
        Pattern pBtnBack2Dashboard = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnBack2Dashboard = pBtnBack2Dashboard.matcher(btnBack2Dashboard);
        String btnBack2DashboardWicketInterface = StringUtils.EMPTY;
        while (mBtnBack2Dashboard.find()) {
            btnBack2DashboardWicketInterface = mBtnBack2Dashboard.group(1);
        }

        String back2DashboardResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnBack2DashboardWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "2");
                        put("root:c:w:btnNext:submit", "1");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(back2DashboardResponse);
    }

//    a id submit21e wicketpath main_c_form_form_root_c_w_pnlFinalNumbTweaked_c_w_btnFinalNumbTweakedGoForMoney_submit
//    root:c:w:txtWorkItemViewTaskId:tb
//    root:c:w:pnlFinalNumbTweaked:c:w:btnFinalNumbTweakedGoForMoney:submit 1
//    stepToken 1

    @And("(Borrower) goes for money")
    public void user_goes_for_money(String user) throws IOException {
        String btnGetMoney = Jsoup.parse(Jsoup.parse(httpResponse.getHttpResponse()).select("component[id~=main]").select("component[encoding~=wicket]").text()).select("a[id~=submit]").select("a[wicketpath~=main_c_form_form_root_c_w_pnlFinalNumbTweaked_c_w_btnFinalNumbTweakedGoForMoney_submit]").attr("onclick");
        Pattern pBtnGetMoney = Pattern.compile("\\?(wicket:interface=.*)&");
        Matcher mBtnGetMoney = pBtnGetMoney.matcher(btnGetMoney);
        String btnGetMoneyWicketInterface = StringUtils.EMPTY;
        while (mBtnGetMoney.find()) {
            btnGetMoneyWicketInterface = mBtnGetMoney.group(1);
        }

        String getMoneyResponse = requestHttpPost(
                httpClient,
//                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnTasksHidden:submit::IBehaviorListener:0:",
                System.getProperty("borrower.url") + "/form.2?" + btnGetMoneyWicketInterface,
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlFinalNumbTweaked:c:w:btnFinalNumbTweakedGoForMoney:submit", "1");
                        put("root:c:w:txtWorkItemViewTaskId:tb", "");
                    }
                },
                localContext.getHttpContext(),
                CONSUME_QUIETLY
        );
        httpResponse.setHttpResponse(getMoneyResponse);
    }

}
