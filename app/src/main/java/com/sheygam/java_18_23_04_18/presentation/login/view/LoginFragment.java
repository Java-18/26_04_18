package com.sheygam.java_18_23_04_18.presentation.login.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

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

import okhttp3.OkHttpClient;

public class LoginFragment extends Fragment implements ILoginView{
    private ILoginPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        Gson gson = new Gson();
        OkHttpClient okHttpClient = new OkHttpClient();
        IStoreProvider storeProvider = new SprefStoreProvider(getActivity());
        WebProvider webProvider = new WebProvider(okHttpClient);
        ILoginRepository repository = new LoginRepository(gson,webProvider,storeProvider);
        ILoginInteractor interactor = new LoginInteractor(repository);
        presenter = new LoginPresenter(interactor, handler);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        presenter.bindView(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void nextView() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void invalidateEmail(String error) {

    }

    @Override
    public void invalidatePassword(String error) {

    }

    @Override
    public void onDestroyView() {
        presenter.unbindView();
        super.onDestroyView();
    }
}
