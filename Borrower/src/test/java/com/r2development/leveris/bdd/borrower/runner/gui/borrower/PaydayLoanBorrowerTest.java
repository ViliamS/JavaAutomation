package com.r2development.leveris.bdd.borrower.runner.gui.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.stepdef; com.r2development.leveris.di.BorrowerDependenciesModule.java" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Gui/GuiPaydayLoanBorrower-NativeReports/",
                "json:target/Gui/GuiPaydayLoanBorrower-Json/GuiPaydayLoanBorrower.json"
        },
        strict = false,
        features = "classpath:bdd/features/gui/borrower/PaydayLoanBorrower.feature"
)
public class PaydayLoanBorrowerTest {
}
