package com.r2development.leveris.bdd.borrower.runner.gui.LandingPage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.stepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Gui/LandingPageTest--NativeReports/",
                "json:target/Gui/LandingPageTest-Json/LandingPageTest.json"
        },
        strict = false,
        features = "classpath:bdd/features/gui/LandingPage/PaydayOrUnsecuredLoan.feature"
)
public class LandingPageTest {
}
