package com.r2development.leveris.di;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.r2development.leveris.selenium.borrower.pageobjects.DocumentUploadSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BorrowerDependenciesModule /*extends AbstractModule*/ implements Module {
//    @Override
//    protected void configure() {
////        bind(IBorrower.class).to(Abakus.class);
//        bind(WebDriver.class).to(ChromeDriver.class);
//        bind(IUser.class).to(User.class);
//    }

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
        binder.bind(IUser.class).to(User.class).asEagerSingleton();
        binder.bind(IHttpResponse.class).to(HttpResponse.class).asEagerSingleton();
//        binder.bind(User.class).toConstructor(DocumentUploadSection.class);
//        binder.bind(IDocumentUploadSection.class).to(DocumentUploadSection.class).asEagerSingleton();
//        binder.requestInjection(DocumentUploadSection.class);

        try {
            binder.bind(User.class).toConstructor(
                User.class.getConstructor(DocumentUploadSection.class)
            );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        switch (System.getProperty("browser")) {
            case "Chrome":
                binder.bind(WebDriver.class).to(ChromeDriver.class);
                break;
            case "Firefox":
//                binder.bind(WebDriver.class).to(FirefoxDriver.class);
                break;
        }
    }
}