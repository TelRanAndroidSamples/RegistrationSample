package com.sheygam.rxjavaregistrationexample.presentation.registration.view;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.sheygam.rxjavaregistrationexample.R;
import com.sheygam.rxjavaregistrationexample.presentation.registration.presenter.RegPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends MvpAppCompatActivity implements IRegView{

    @BindView(R.id.inputEmail)EditText inputEmail;
    @BindView(R.id.inputPassword)EditText inputPassword;
    @BindView(R.id.regBtn)Button regBtn;
    @BindView(R.id.myProgress)ProgressBar myProgress;

    @InjectPresenter
    RegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.regBtn)
    void regBtnClicked(){
        presenter.registration(inputEmail.getText().toString(),inputPassword.getText().toString());
    }

    @Override
    public void showProgress() {
        myProgress.setVisibility(View.VISIBLE);
        inputEmail.setVisibility(View.INVISIBLE);
        inputPassword.setVisibility(View.INVISIBLE);
        regBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        myProgress.setVisibility(View.INVISIBLE);
        inputEmail.setVisibility(View.VISIBLE);
        inputPassword.setVisibility(View.VISIBLE);
        regBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(error)
                .setPositiveButton("Ok",null)
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    public void emailValidError(String error) {
        inputEmail.setError(error);
    }

    @Override
    public void passwordValidError(String error) {
        inputPassword.setError(error);
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "Registration ok", Toast.LENGTH_SHORT).show();
    }
}
