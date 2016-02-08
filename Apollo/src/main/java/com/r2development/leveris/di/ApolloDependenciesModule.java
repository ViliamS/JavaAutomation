package com.r2development.leveris.di;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;

public class ApolloDependenciesModule extends AbstractModule {
    final User user;

    @Inject
    ApolloDependenciesModule(User user) {
        this.user = user;
    }

    @Override
    protected void configure() {
//        bind(IWebDriverService.class).to(WebDriverService.class);
        bind(User.class).toInstance(user);
    }
}
