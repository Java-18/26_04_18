package com.sheygam.java_18_23_04_18;

import android.app.Application;
import android.os.Handler;

import com.sheygam.java_18_23_04_18.di.ApplicationComponet;
import com.sheygam.java_18_23_04_18.di.ApplicationModule;
import com.sheygam.java_18_23_04_18.di.DaggerApplicationComponet;
import com.sheygam.java_18_23_04_18.di.login.LoginComponent;
import com.sheygam.java_18_23_04_18.di.login.LoginModule;


public class App extends Application{
    private ApplicationComponet componet;
    private LoginComponent loginComponent;
    private static App app;

    public static App get(){
        return app;
    }

    public ApplicationComponet getComponent(){
        return componet;
    }

    @Override
    public void onCreate() {
        app = this;
        componet = prepareComponent();
        super.onCreate();
    }

    private ApplicationComponet prepareComponent(){
        return DaggerApplicationComponet.builder()
                .applicationModule(new ApplicationModule(new Handler(),this))
                .build();
    }

    public LoginComponent plusLoginComponent(LoginModule module){
        if(loginComponent == null){
            loginComponent = componet.plus(module);
        }
        return loginComponent;
    }

    public void clearLoginCamponent(){
        loginComponent = null;
    }
}
