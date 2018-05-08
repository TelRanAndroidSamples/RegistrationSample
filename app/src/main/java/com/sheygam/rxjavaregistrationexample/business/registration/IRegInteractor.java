package com.sheygam.rxjavaregistrationexample.business.registration;

import io.reactivex.Completable;

public interface IRegInteractor {
    Completable registration(String email, String password);
}
