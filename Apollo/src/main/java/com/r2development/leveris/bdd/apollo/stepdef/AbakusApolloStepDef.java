package com.r2development.leveris.bdd.apollo.stepdef;

import com.google.inject.Inject;
import com.r2development.leveris.di.IUser;
import com.r2development.leveris.di.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AbakusApolloStepDef {

    private static final Log log = LogFactory.getLog(AbakusApolloStepDef.class);

    @Inject
    public IUser user;
//    @Inject
//    WebDriver webDriver;

    public AbakusApolloStepDef() {
    }

    @Inject
    public AbakusApolloStepDef(User user) {
//        super(webDriver);
        this.user = user;
    }
}
