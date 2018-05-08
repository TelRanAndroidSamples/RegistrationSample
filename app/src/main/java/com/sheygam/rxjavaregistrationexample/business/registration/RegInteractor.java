package com.sheygam.rxjavaregistrationexample.business.registration;

import com.sheygam.rxjavaregistrationexample.data.registration.IRegRepository;

import io.reactivex.Completable;

public class RegInteractor implements IRegInteractor{
    private IRegRepository repository;

    public RegInteractor(IRegRepository repository) {
        this.repository = repository;
    }

    @Override
    public Completable registration(String email, String password) {
        if (!isEmailValid(email)){
            return Completable.error(new EmailValidException("Wrong email format"));
        }

        if (!isPasswordValid(password)){
            return Completable.error(new PasswordValidException("Minimum 4 symbols"));
        }

        return repository.registration(email,password);
    }

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPasswordValid(String password){
        return password.length()>=4;
    }
}
