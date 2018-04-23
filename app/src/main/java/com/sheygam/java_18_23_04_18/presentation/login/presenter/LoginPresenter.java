package com.sheygam.java_18_23_04_18.presentation.login.presenter;

import android.os.Handler;

import com.sheygam.java_18_23_04_18.business.login.EmailValidException;
import com.sheygam.java_18_23_04_18.business.login.ILoginInteractor;
import com.sheygam.java_18_23_04_18.business.login.ILoginInteractorCallback;
import com.sheygam.java_18_23_04_18.business.login.PasswordValidException;
import com.sheygam.java_18_23_04_18.presentation.login.view.ILoginView;

public class LoginPresenter implements ILoginPresenter, ILoginInteractorCallback {
    private ILoginInteractor interactor;
    private Handler handler;
    private ILoginView view;

    public LoginPresenter(ILoginInteractor interactor, Handler handler) {
        this.interactor = interactor;
        this.handler = handler;
    }

    @Override
    public void onLoginClicked(String email, String password) {
        if(view != null){
            view.showProgress();
        }
        try {
            interactor.login(email,password,this);
        } catch (EmailValidException e) {
            e.printStackTrace();
            if(view != null){
                view.hideProgress();
                view.invalidateEmail(e.getMessage());
            }
        } catch (PasswordValidException e) {
            e.printStackTrace();
            if(view != null){
                view.hideProgress();
                view.invalidatePassword(e.getMessage());
            }
        }
    }

    @Override
    public void onRegClicked(String email, String password) {

    }

    @Override
    public void bindView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public void onLoginSuccess() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(view != null){
                    view.hideProgress();
                    view.nextView();
                }
            }
        });
    }

    @Override
    public void onLoginError(final String error) {
        handler.post(new Runnable() {
            @Override
            public void run() {
               if(view != null){
                   view.hideProgress();
                   view.showError(error);
               }
            }
        });
    }

    @Override
    public void onRegistrationSuccess() {

    }

    @Override
    public void onRegistrationError(String error) {

    }
}
