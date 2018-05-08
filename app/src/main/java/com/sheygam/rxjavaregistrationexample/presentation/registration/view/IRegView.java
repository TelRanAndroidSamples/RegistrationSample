package com.sheygam.rxjavaregistrationexample.presentation.registration.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IRegView extends MvpView{
    void showProgress();
    void hideProgress();
    void showError(String error);
    void emailValidError(String error);
    void passwordValidError(String error);
    void showSuccess();
}
