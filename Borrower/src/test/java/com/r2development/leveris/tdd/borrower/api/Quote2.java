package com.r2development.leveris.tdd.borrower.api;

import com.r2development.leveris.di.User;
import com.r2development.leveris.qa.utils.Orasql;
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

public class Quote2 {

    public static void main(String... arg) throws Exception {

        HttpClient httpClient = HttpUtils.createHttpClient();
        HttpClientContext localContext = HttpUtils.initContext("dv2app.opoqodev.com", "/stable-borrower");

        requestHttpGet(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/",
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
                "http://dv2app.opoqodev.com/stable-borrower/form.1?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoan:c:w:pnlUnsecuredLoan1:c:w:btnContinue1:submit::IBehaviorListener:0:",
                new LinkedHashMap<String, String>() {
                    {
                        put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    }
                },
                new LinkedHashMap<String, String>() {
                    {
                        put("stepToken", "1");
                    }
                },
                localContext,
                false
        );

        Map<String, String> quote1Parameters = new LinkedHashMap<>();
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:cmbLoanPurpose:combobox", "PAYDAY");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbNetMonthlyIncome:tb", "1");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbMonthlyExpenses:tb", "2");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:txtNumberOfDependents:tb", "3");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:crbAmountToBorrow:tb", "4");
        quote1Parameters.put("stepToken", "2");
        quote1Parameters.put("root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit", "1");

//        root:c:w:pnlUnsecuredLoanQuotation:c:w:cmbLoanPurpose:combobox:PERSONAL
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:crbNetMonthlyIncome:tb:1
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:crbMonthlyExpenses:tb:2
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:txtNumberOfDependents:tb:3
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:crbAmountToBorrow:tb:4
//        stepToken:2
//        root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit:1

        String quote1Response = requestHttpPost(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoanQuotation:c:w:btnContinue:submit::IBehaviorListener:0:-1",
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

        String applyResponse = requestHttpPost(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlUnsecuredLoanCalculator:c:w:btnApply:submit::IBehaviorListener:0:-1",
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
        System.out.println("Email : " + email);
        registrationParameters.put("root:c:w:pnlMain:c:w:txtEmailAddress:tb", email);
        String phoneNumber = "123456789";
        registrationParameters.put("root:c:w:pnlMain:c:w:txtPhoneNumber:tb", phoneNumber);
        String pwd = "Password1122";
        registrationParameters.put("root:c:w:pnlMain:c:w:txtPassword:tb", pwd);
        registrationParameters.put("root:c:w:pnlMain:c:w:chkTermsOfBusiness:checkbox", "on");
        registrationParameters.put("root:c:w:pnlMain:c:w:chkDataProtectionPolicy:checkbox", "on");
        registrationParameters.put("stepToken", "4");
        registrationParameters.put("root:c:w:pnlMain:c:w:btnRegister:submit", "1");

        User user = new User(firstName, email, pwd, phoneNumber, "", "");
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPwd(pwd);

//        root:c:w:pnlMain:c:w:txtName:tb:Anthony
//        root:c:w:pnlMain:c:w:txtEmailAddress:tb:anthony.mottot.test000120160209113000000@abakus.com
//        root:c:w:pnlMain:c:w:txtPhoneNumber:tb:123456789
//        root:c:w:pnlMain:c:w:txtPassword:tb:Password1122
//        root:c:w:pnlMain:c:w:chkTermsOfBusiness:checkbox:on
//        root:c:w:pnlMain:c:w:chkDataProtectionPolicy:checkbox:on
//        stepToken:7
//        root:c:w:pnlMain:c:w:btnRegister:submit:1

//        http://dv2app.opoqodev.com/stable-borrower/form.1?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnRegister:submit::IBehaviorListener:0:-1&scrollPos=41&random=0.5611498283687979


        String registrationResponse = requestHttpPost(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnRegister:submit::IBehaviorListener:0:",
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

        File file = new File(Quote2.class.getClassLoader().getResource("tnsnames.ora").toURI());
        assertThat("File should exist", file.exists(), Is.is(true));

        System.setProperty("oracle.net.tns_admin", file.getParentFile().getAbsolutePath());

        Class.forName("oracle.jdbc.OracleDriver");
        Orasql.executeSqlUpdateQuery("jdbc:oracle:thin:@DV2000.LEVERIS", "stable_mchuser", "heslo", "update mch_user set isemailaddressvalid = 'true', isphonenumbervalid = 'true', isregistrationcomplete = 'true' where userloginid = '" + user.getEmail() + "'");

        String loginLinkResponse = requestHttpGet(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.1?wicket:interface=:1:initialMenuWrapper:initialMenu:root:item:1:link::IBehaviorListener:0:",
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

        String loginResponse = requestHttpPost(
                httpClient,
                "http://dv2app.opoqodev.com/stable-borrower/form.2?wicket:interface=:1:main:c:form:form:root:c:w:pnlMain:c:w:btnLogin:submit::IBehaviorListener:0:-1",
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
