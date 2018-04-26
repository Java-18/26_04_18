package com.sheygam.java_18_23_04_18.di.login;

import com.sheygam.java_18_23_04_18.presentation.login.view.LoginFragment;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginFragment fragment);
}
