package com.sheygam.java_18_23_04_18.business.login;

public interface ILoginInteractor {
    void login(String email, String password, ILoginInteractorCallback callback)
            throws EmailValidException,PasswordValidException;
    void registration(String email, String password, ILoginInteractorCallback callback)
            throws PasswordValidException,EmailValidException;
}
