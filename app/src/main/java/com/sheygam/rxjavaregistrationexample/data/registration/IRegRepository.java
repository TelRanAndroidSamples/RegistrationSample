package com.sheygam.rxjavaregistrationexample.data.registration;

import io.reactivex.Completable;

public interface IRegRepository {
    Completable registration(String email, String password);
}
