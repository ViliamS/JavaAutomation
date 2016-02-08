package com.r2development.leveris.bdd.borrower.runner.gui.borrower;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = { "classpath:com.r2development.abakus.bdd.borrower.stepdef" },
        monochrome = true,
        format = {
                "pretty",
                "html:target/Gui/GuiDoubleBorrowerL1-NativeReports/",
                "json:target/Gui/GuiDoubleBorrowerL1-Json/GuiDoubleBorrowerL1.json"
        },
        strict = false,
        features = "classpath:bdd/features/gui/borrower/DoubleBorrowerL1.feature"
)
public class DoubleBorrowerL1Test {
}
