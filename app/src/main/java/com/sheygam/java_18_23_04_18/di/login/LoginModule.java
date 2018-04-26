package com.sheygam.java_18_23_04_18.di.login;

import android.os.Handler;

import com.google.gson.Gson;
import com.sheygam.java_18_23_04_18.business.login.ILoginInteractor;
import com.sheygam.java_18_23_04_18.business.login.LoginInteractor;
import com.sheygam.java_18_23_04_18.data.login.ILoginRepository;
import com.sheygam.java_18_23_04_18.data.login.LoginRepository;
import com.sheygam.java_18_23_04_18.data.providers.store.IStoreProvider;
import com.sheygam.java_18_23_04_18.data.providers.web.WebProvider;
import com.sheygam.java_18_23_04_18.presentation.login.presenter.ILoginPresenter;
import com.sheygam.java_18_23_04_18.presentation.login.presenter.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    @LoginScope
    ILoginRepository provadeLoginRepository(Gson gson, IStoreProvider storeProvider, WebProvider webProvider){
        return new LoginRepository(gson,webProvider,storeProvider);
    }

    @Provides
    @LoginScope
    ILoginInteractor provideLoginInteractor(ILoginRepository repository){
        return new LoginInteractor(repository);
    }

    @Provides
    @LoginScope
    ILoginPresenter provideLoginPresenter(ILoginInteractor interactor, Handler handler){
        return new LoginPresenter(interactor,handler);
    }
}
