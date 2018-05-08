package com.sheygam.rxjavaregistrationexample.di.registration;

import com.sheygam.rxjavaregistrationexample.business.registration.IRegInteractor;
import com.sheygam.rxjavaregistrationexample.business.registration.RegInteractor;
import com.sheygam.rxjavaregistrationexample.data.provider.store.SprefProvider;
import com.sheygam.rxjavaregistrationexample.data.provider.web.Api;
import com.sheygam.rxjavaregistrationexample.data.registration.IRegRepository;
import com.sheygam.rxjavaregistrationexample.data.registration.RegRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RegModule {
    @Provides
    @RegScope
    IRegRepository provideRepository(Api api, SprefProvider storeProvider){
        return new RegRepository(api,storeProvider);
    }

    @Provides
    @RegScope
    IRegInteractor provideInteractor(IRegRepository repository){
        return new RegInteractor(repository);
    }
}
