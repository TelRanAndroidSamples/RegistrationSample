package com.sheygam.rxjavaregistrationexample.di.registration;


import com.sheygam.rxjavaregistrationexample.presentation.registration.presenter.RegPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {RegModule.class})
@RegScope
public interface RegComponent {
    void inject(RegPresenter presenter);
}
