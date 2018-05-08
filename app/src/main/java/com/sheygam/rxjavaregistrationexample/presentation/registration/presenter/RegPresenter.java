package com.sheygam.rxjavaregistrationexample.presentation.registration.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.sheygam.rxjavaregistrationexample.App;
import com.sheygam.rxjavaregistrationexample.business.registration.EmailValidException;
import com.sheygam.rxjavaregistrationexample.business.registration.IRegInteractor;
import com.sheygam.rxjavaregistrationexample.business.registration.PasswordValidException;
import com.sheygam.rxjavaregistrationexample.di.registration.RegModule;
import com.sheygam.rxjavaregistrationexample.presentation.registration.view.IRegView;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class RegPresenter extends MvpPresenter<IRegView> {

    @Inject
    IRegInteractor interactor;

    private Disposable disposable;

    public RegPresenter() {
        App.get().plus(new RegModule()).inject(this);
    }

    public void registration(String email, String password){
        getViewState().showProgress();
        disposable = interactor.registration(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess,this::handleError);
    }

    private void handleError(Throwable throwable) {
        getViewState().hideProgress();

        if (throwable instanceof EmailValidException){
            getViewState().emailValidError(throwable.getMessage());
        }else if(throwable instanceof PasswordValidException){
            getViewState().passwordValidError(throwable.getMessage());
        }else if(throwable instanceof IOException){
            getViewState().showError("Connection error!");
        }else{
            getViewState().showError(throwable.getMessage());
        }
    }

    private void handleSuccess() {
        getViewState().hideProgress();
        getViewState().showSuccess();
    }


    @Override
    public void onDestroy() {
        if(disposable!=null){
            disposable.dispose();
        }
        App.get().clearRegComponent();
        super.onDestroy();
    }
}
