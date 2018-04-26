package com.sheygam.java_18_23_04_18.di;

import com.sheygam.java_18_23_04_18.di.login.LoginComponent;
import com.sheygam.java_18_23_04_18.di.login.LoginModule;
import com.sheygam.java_18_23_04_18.presentation.login.view.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponet {
    LoginComponent plus(LoginModule loginModule);
}
