package com.sheygam.java_18_23_04_18.presentation.login.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sheygam.java_18_23_04_18.App;
import com.sheygam.java_18_23_04_18.R;
import com.sheygam.java_18_23_04_18.business.login.ILoginInteractor;
import com.sheygam.java_18_23_04_18.business.login.LoginInteractor;
import com.sheygam.java_18_23_04_18.data.login.ILoginRepository;
import com.sheygam.java_18_23_04_18.data.login.LoginRepository;
import com.sheygam.java_18_23_04_18.data.providers.store.IStoreProvider;
import com.sheygam.java_18_23_04_18.data.providers.store.SprefStoreProvider;
import com.sheygam.java_18_23_04_18.data.providers.web.WebProvider;
import com.sheygam.java_18_23_04_18.di.login.LoginModule;
import com.sheygam.java_18_23_04_18.presentation.login.presenter.ILoginPresenter;
import com.sheygam.java_18_23_04_18.presentation.login.presenter.LoginPresenter;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class LoginFragment extends Fragment implements ILoginView, View.OnClickListener {
    @Inject ILoginPresenter presenter;
    private EditText inputEmail, inputPassword;
    private Button regBtn, loginBtn;
    private ProgressBar myProgress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Handler handler = new Handler();
//        Gson gson = new Gson();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        IStoreProvider storeProvider = new SprefStoreProvider(getActivity());
//        WebProvider webProvider = new WebProvider(okHttpClient);
//        ILoginRepository repository = new LoginRepository(gson,webProvider,storeProvider);
//        ILoginInteractor interactor = new LoginInteractor(repository);
//        presenter = new LoginPresenter(interactor, handler);
//        App.get().getComponent().inject(this);
        App.get().plusLoginComponent(new LoginModule()).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputEmail = view.findViewById(R.id.input_email);
        inputPassword = view.findViewById(R.id.input_password);
        loginBtn = view.findViewById(R.id.login_btn);
        regBtn = view.findViewById(R.id.reg_btn);
        myProgress = view.findViewById(R.id.my_progress);
        regBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

        presenter.bindView(this);
    }

    @Override
    public void showProgress() {
        loginBtn.setEnabled(false);
        regBtn.setEnabled(false);
        inputEmail.setEnabled(false);
        inputPassword.setEnabled(false);
        myProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loginBtn.setEnabled(true);
        regBtn.setEnabled(true);
        inputEmail.setEnabled(true);
        inputPassword.setEnabled(true);
        myProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void nextView() {
        Toast.makeText(getActivity(), "Start next view", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Error!")
                .setMessage(error)
                .setPositiveButton("Ok",null)
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    public void invalidateEmail(String error) {
        inputEmail.setError(error);
    }

    @Override
    public void invalidatePassword(String error) {
        inputPassword.setError(error);
    }

    @Override
    public void onDestroyView() {
        presenter.unbindView();
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            presenter.onLoginClicked(inputEmail.getText().toString(),
                    inputPassword.getText().toString());
        }else if(v.getId() == R.id.reg_btn){
            presenter.onRegClicked(inputEmail.getText().toString(),
                    inputPassword.getText().toString());
        }
    }

    @Override
    public void onDestroy() {
        App.get().clearLoginCamponent();
        super.onDestroy();
    }
}
