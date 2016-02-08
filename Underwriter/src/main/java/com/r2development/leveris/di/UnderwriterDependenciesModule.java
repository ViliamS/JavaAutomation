package com.r2development.leveris.di;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.r2development.leveris.di.*;
import com.r2development.leveris.di.IHttpResponse;

public class UnderwriterDependenciesModule implements Module {
    final User user;

    @Inject
    UnderwriterDependenciesModule(User user) {
        this.user = user;
    }

    @Override
    public void configure(Binder binder) {
//        bind(IWebDriverService.class).to(WebDriverService.class);
        binder.bind(User.class).toInstance(user);
        binder.bind(IHttpResponse.class).to(com.r2development.leveris.di.HttpResponse.class).asEagerSingleton();
    }
}
