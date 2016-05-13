package com.r2development.leveris.tdd.underwriter.gui;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
        glue = { "classpath:com.r2development.leveris.bdd.underwriter.stepdef;" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Gui/GuiUnderwriterTest-NativeReports/",
                "json:target/Gui/GuiUnderwriterTest-Json/GuiPaydayLoanBorrower.json"
        },
        strict = false,
        features = "classpath:bdd/features/gui/UnderwriterTest.feature"
)
public class UnderwriterTest {
}
