package com.sheygam.java_18_23_04_18.business.login;

public interface ILoginInteractorCallback {
    void onLoginSuccess();
    void onLoginError(String error);
    void onRegistrationSuccess();
    void onRegistrationError(String error);
}
