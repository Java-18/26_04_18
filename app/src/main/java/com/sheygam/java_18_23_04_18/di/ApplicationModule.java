package com.sheygam.java_18_23_04_18.di;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.sheygam.java_18_23_04_18.business.login.ILoginInteractor;
import com.sheygam.java_18_23_04_18.business.login.LoginInteractor;
import com.sheygam.java_18_23_04_18.data.login.ILoginRepository;
import com.sheygam.java_18_23_04_18.data.login.LoginRepository;
import com.sheygam.java_18_23_04_18.data.providers.store.IStoreProvider;
import com.sheygam.java_18_23_04_18.data.providers.store.SprefStoreProvider;
import com.sheygam.java_18_23_04_18.data.providers.web.WebProvider;
import com.sheygam.java_18_23_04_18.presentation.login.presenter.ILoginPresenter;
import com.sheygam.java_18_23_04_18.presentation.login.presenter.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule {

    private Handler handler;
    private Context context;

    public ApplicationModule(Handler handler, Context context) {
        this.handler = handler;
        this.context = context;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return  new Gson();
    }

    @Provides
    @Singleton
    Handler provideHandler(){
        return handler;
    }

    @Provides
    @Singleton
    IStoreProvider provideStoreProvider(){
        return new SprefStoreProvider(context);
    }

    @Provides
    @Singleton
    WebProvider provideWebProvider(OkHttpClient client){
        return new WebProvider(client);
    }


}
