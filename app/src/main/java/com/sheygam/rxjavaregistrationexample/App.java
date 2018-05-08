package com.sheygam.rxjavaregistrationexample;

import android.app.Application;

import com.sheygam.rxjavaregistrationexample.di.application.AppComponent;
import com.sheygam.rxjavaregistrationexample.di.application.AppModule;
import com.sheygam.rxjavaregistrationexample.di.application.DaggerAppComponent;
import com.sheygam.rxjavaregistrationexample.di.registration.RegComponent;
import com.sheygam.rxjavaregistrationexample.di.registration.RegModule;


public class App extends Application {
    private static App app;
    private AppComponent appComponent;
    private RegComponent regComponent;

    public App() {
        app = this;
    }

    public static App get() {
        return app;
    }

    @Override
    public void onCreate() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        super.onCreate();
    }

    public RegComponent plus(RegModule module){
        if(regComponent == null){
            regComponent = appComponent.plus(module);
        }
        return regComponent;
    }

    public void clearRegComponent(){
        regComponent = null;
    }
}
