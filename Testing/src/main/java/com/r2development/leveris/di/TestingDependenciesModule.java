package com.r2development.leveris.di;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.r2development.leveris.BROWSER_TYPE;
import com.r2development.leveris.di.User;
import org.apache.commons.lang3.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingDependenciesModule implements Module {

    final User user;

    @Inject
    TestingDependenciesModule(User user) {
        this.user = user;
    }

    /**
     * Contributes bindings and other configurations for this module to {@code binder}.
     * <p>
     * <p><strong>Do not invoke this method directly</strong> to install submodules. Instead use
     * {@link Binder#install(Module)}, which ensures that {@link Provides provider methods} are
     * discovered.
     *
     * @param binder -
     */
    @Override
    public void configure(Binder binder) {
//        binder.bind(IUser.class).to(User.class).asEagerSingleton();
        binder.bind(User.class).toInstance(user);

        switch (EnumUtils.getEnum(BROWSER_TYPE.class, System.getProperty("browser"))) {
            case CHROME:
                binder.bind(WebDriver.class).to(ChromeDriver.class);
                break;
        }
    }
}
