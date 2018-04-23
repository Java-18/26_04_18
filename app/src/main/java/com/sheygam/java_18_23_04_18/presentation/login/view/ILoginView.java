package com.sheygam.java_18_23_04_18.presentation.login.view;

public interface ILoginView {
    void showProgress();
    void hideProgress();
    void nextView();
    void showError(String error);
    void invalidateEmail(String error);
    void invalidatePassword(String error);
}
