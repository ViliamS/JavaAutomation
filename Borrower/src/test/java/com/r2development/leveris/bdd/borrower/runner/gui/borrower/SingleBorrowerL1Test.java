package com.r2development.leveris.bdd.borrower.runner.gui.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//@Cucumber.Options(
        glue = { "classpath:com.r2development.leveris.bdd.borrower.stepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Gui/GuiSingleBorrowerL1--NativeReports/",
                "json:target/Gui/GuiSingleBorrowerL1-Json/GuiSingleBorrowerL1.json"
        },
        strict = false,
        features = "classpath:bdd/features/gui/borrower/SingleBorrowerL1.feature"
)
public class SingleBorrowerL1Test {
}
