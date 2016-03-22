package com.r2development.leveris.tdd.borrower;

import com.r2development.leveris.selenium.borrower.pageobjects.IYourAccountsPage;
import com.r2development.leveris.selenium.borrower.pageobjects.YourAccountsPage;

/**
 * Created by anthonymottot on 18/03/2016.
 */
public class RedesignPageObject {

    public final static void main(String... arg) {

        IYourAccountsPage yourAccountsPage = new YourAccountsPage(null);
        yourAccountsPage
            .selectAccount("Current account")
            .typeCurrentStatementDate("01/01/2000")
//            .typeCurrentAccountName("test")
            .typeCurrentSortCode1("12")
            .typeCurrentSortCode2("34")
            .typeCurrentSortCode3("56")
            .typeCurrentAccountNumber("123456789")
            .typeCurrentAccountBalance("2000")
            .typeCurrentOverdraftLimit("2001")
            .selectCurrentSavingSource("Gift")
            .typeCurrentRegularMonthlySavings("2002")
//            .clickSaveAndClose()

//            .fillIn(
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("formType","Current account");
//                        put("accountProvider","test account provider");
//                        put("statementDate","01/01/2000");
//                        put("accountName","test Current Account");
//                        put("sortCode1","12");
//                        put("sortCode2","34");
//                        put("sortCode3","56");
//                        put("accountNumber","1234567890");
//                        put("accountBalance","2001");
//                        put("overdraftLimit","2002");
//                        put("sourceOfSaving","Gift");
//                        put("regularMonthlySaving","200");
//                    }
//                }
//            )

            .selectAccount("Savings account")
//            .typeSavingAccountProvider("testSaving")
//            .clickSaveAndClose()

//            .fillIn(
//                new LinkedHashMap<String, String>() {
//                    {
//                        put("formType","Current account");
//                        put("statementDate","01/01/2000");
//                        put("accountName","test Current Account");
//                        put("sortCode1","12");
//                        put("sortCode2","34");
//                        put("sortCode3","56");
//                        put("accountNumber","1234567890");
//                        put("accountBalance","2001");
//                        put("overdraftLimit","2002");
//                        put("sourceOfSaving","Gift");
//                        put("regularMonthlySaving","200");
//                    }
//                }
//            )

            .clickDone();
    }

}
