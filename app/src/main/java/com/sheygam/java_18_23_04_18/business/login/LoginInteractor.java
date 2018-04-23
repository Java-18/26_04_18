package com.sheygam.java_18_23_04_18.business.login;

import com.sheygam.java_18_23_04_18.data.login.ILoginRepository;
import com.sheygam.java_18_23_04_18.data.login.ILoginRepositoryCallback;

public class LoginInteractor implements ILoginInteractor, ILoginRepositoryCallback {
    private ILoginRepository repository;
    private ILoginInteractorCallback callback;

    public LoginInteractor(ILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void login(String email, String password, ILoginInteractorCallback callback) throws EmailValidException, PasswordValidException {
        this.callback = callback;

        if(email.isEmpty()){
            throw new EmailValidException("Email empty");
        }

        if(password.length()<4){
            throw new PasswordValidException("Password too short!");
        }

        repository.login(email, password,this);
    }

    @Override
    public void registration(String email, String password, ILoginInteractorCallback callback) throws PasswordValidException, EmailValidException {

    }

    @Override
    public void onLoginSuccess() {
        callback.onLoginSuccess();
    }

    @Override
    public void onLoginError(String error) {
        callback.onLoginError(error);
    }

    @Override
    public void onRegistrationSuccess() {

    }

    @Override
    public void onRegistrationError(String error) {

    }
}
