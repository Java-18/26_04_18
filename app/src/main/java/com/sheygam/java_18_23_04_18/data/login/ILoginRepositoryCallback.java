package com.sheygam.java_18_23_04_18.data.login;

public interface ILoginRepositoryCallback {
    void onLoginSuccess();
    void onLoginError(String error);
    void onRegistrationSuccess();
    void onRegistrationError(String error);
}
