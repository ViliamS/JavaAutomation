package com.r2development.leveris.selenium.apollo.pageobjects;

import com.r2development.leveris.Apollo;
import com.r2development.leveris.bdd.apollo.stepdef.SharedDriver_Apollo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.support.PageFactory;

public class MortgageSection extends Apollo implements IMortgageSection {

    private static final Log log = LogFactory.getLog(MortgageSection.class);

    public MortgageSection(SharedDriver_Apollo webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public static IMortgageSection getMortgageSectionInstance(SharedDriver_Apollo webDriver) {
        IMortgageSection mortgageSection = new MortgageSection(webDriver);
        PageFactory.initElements(webDriver, mortgageSection);
        return mortgageSection;
    }

//    @Override
//    public IMortgageSection waitForMortgageSectionToLoad() {
//        return this;
//    }
}