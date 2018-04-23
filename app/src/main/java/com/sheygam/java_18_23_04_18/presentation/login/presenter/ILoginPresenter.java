package com.sheygam.java_18_23_04_18.presentation.login.presenter;

import com.sheygam.java_18_23_04_18.presentation.login.view.ILoginView;

public interface ILoginPresenter {
    void onLoginClicked(String email, String password);
    void onRegClicked(String email, String password);
    void bindView(ILoginView view);
    void unbindView();
}
