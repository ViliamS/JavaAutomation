package com.r2development.leveris.tdd.borrower.api;

import com.r2development.leveris.di.User;
import com.r2development.leveris.utils.HttpUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.hamcrest.core.Is;
import org.joda.time.DateTime;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.r2development.leveris.utils.HttpUtils.requestHttpGet;
import static com.r2development.leveris.utils.HttpUtils.requestHttpPost;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class Quote {

    @Deprecated
    public static void main(String... arg) throws Exception {

        HttpClient httpClient = HttpUtils.createHttpClient();
        HttpClientContext localContext = HttpUtils.initContext("dv2app.opoqodev.com", "/stable-borrower");

        requestHttpGet(
                httpClient,
                System.getProperty("borrower.url") + "/",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                false
        );

        requestHttpPost(
                httpClient,
                System.getProperty("borrower.url") + "/form.1?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoan:c:w:pnlUnsecuredLoan0:c:w:btnContinue0:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                        put("root:c:w:pnlUnsecuredLoan:c:w:pnlUnsecuredLoan0:c:w:btnContinue0:submit", "1");
                    }
                },
                localContext,
                false
        );

        Map<String, String> quote1Parameters = new LinkedHashMap<>();

        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:cmbLoanPurpose:combobox", "PERSONAL");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbNetMonthlyIncome:tb", "1");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbMonthlyExpenses:tb", "2");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:txtNumberOfDependents:tb", "3");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:pnlAmountToBorrowUnsecured:c:w:crbAmountToBorrowUnsecured:tb", "4000");
        quote1Parameters.put("stepToken", "2");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit", "1");

//        root:c:w:pnlUnsecuredLoanQuotation:c:w:cmbLoanPurpose:combobox:PERSONAL
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:crbNetMonthlyIncome:tb:1
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:crbMonthlyExpenses:tb:2
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:txtNumberOfDependents:tb:3
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:crbAmountToBorrow:tb:4
//        stepToken:2
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit:1

        requestHttpPost(
                httpClient,
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                quote1Parameters,
                localContext,
                false
        );

        Map<String, String> applyParameters = new LinkedHashMap<>();
        applyParameters.put("root:c:w:pnlUnsecuredLoanCalculator:c:w:pnlCalculator:c:w:txtAmount:tb", "1");
        applyParameters.put("root:c:w:pnlUnsecuredLoanCalculator:c:w:pnlCalculator:c:w:txtMonthlyInstalment:tb", "2");
        applyParameters.put("stepToken", "3");
        applyParameters.put("root:c:w:pnlUnsecuredLoanCalculator:c:w:btnApply:submit", "1");

//        root:c:w:pnlUnsecuredLoanCalculator:c:w:pnlCalculator:c:w:txtAmount:tb:1
//        root:c:w:pnlUnsecuredLoanCalculator:c:w:pnlCalculator:c:w:txtMonthlyInstalment:tb:2
//        stepToken:6
//        root:c:w:pnlUnsecuredLoanCalculator:c:w:btnApply:submit:1

        requestHttpPost(
                httpClient,
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:btnApplyOnline:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                applyParameters,
                localContext,
                false
        );

        Map<String, String> registrationParameters = new LinkedHashMap<>();
        String firstName = "Anthony";
        registrationParameters.put("root:c:w:pnlMain:c:w:txtName:tb", "Anthony");
        String email = "anthony.mottot.test0001" + DateTime.now().toString("yyyyMMddhhmmssSSS")+"@abakus.com";
        registrationParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", email);
        String phoneNumber = "123456789";
        registrationParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", phoneNumber);
        String pwd = "Password1122";
        registrationParameters.put("root:c:w:pnlMain:c:w:txtPassword:tb", pwd);
        registrationParameters.put("root:c:w:pnlMain:c:w:chkTermsOfBusiness:checkbox", "on");
        registrationParameters.put("root:c:w:pnlMain:c:w:chkDataProtectionPolicy:checkbox", "on");
        registrationParameters.put("stepToken", "4");
        registrationParameters.put("root:c:w:pnlMain:c:w:btnRegister:submit", "1");

        User user = new User(firstName, email, pwd, phoneNumber);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPwd(pwd);

        requestHttpPost(
                httpClient,
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnRegister:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                registrationParameters,
                localContext,
                false
        );

        File file = new File(Quote.class.getClassLoader().getResource("tnsnames.ora").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));

        System.setProperty("oracle.net.tns_admin", file.getParentFile().getAbsolutePath());

        Class.forName("oracle.jdbc.OracleDriver");
//        Orasql.executeSqlUpdateQuery("jdbc:oracle:thin:@DV2000.LEVERIS", "stable_mchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + user.getEmail() + "'");

        requestHttpGet(
                httpClient,
                System.getProperty("borrower.url") + "/form.1?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:1:link::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                localContext,
                false
        );

        Map<String, String> loginParameters = new LinkedHashMap<>();
        loginParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", user.getEmail());
        loginParameters.put("root:c:w:pnlMain:c:w:pwdPassword:tb", user.getPwd());
        loginParameters.put("stepToken", "1");
        loginParameters.put("root:c:w:pnlMain:c:w:btnLogin:submit", "1");

        requestHttpPost(
                httpClient,
                System.getProperty("borrower.url") + "/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:-1",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        put("Content-Type", "application/x-www-form-urlencoded");
                    }
                },
                loginParameters,
                localContext,
                false
        );
    }
}
