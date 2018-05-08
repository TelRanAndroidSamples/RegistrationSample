package com.sheygam.rxjavaregistrationexample.di.application;

import com.sheygam.rxjavaregistrationexample.di.registration.RegComponent;
import com.sheygam.rxjavaregistrationexample.di.registration.RegModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    RegComponent plus(RegModule module);
}
