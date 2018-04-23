package com.sheygam.java_18_23_04_18.data.login;

import com.google.gson.Gson;
import com.sheygam.java_18_23_04_18.data.dto.DtoAuth;
import com.sheygam.java_18_23_04_18.data.dto.DtoAuthToken;
import com.sheygam.java_18_23_04_18.data.providers.store.IStoreProvider;
import com.sheygam.java_18_23_04_18.data.providers.web.WebProvider;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginRepository implements ILoginRepository {

    private Gson gson;
    private WebProvider webProvider;
    private IStoreProvider storeProvider;

    public LoginRepository(Gson gson, WebProvider webProvider, IStoreProvider storeProvider) {
        this.gson = gson;
        this.webProvider = webProvider;
        this.storeProvider = storeProvider;
    }

    @Override
    public void login(String email, String password, final ILoginRepositoryCallback callback) {
        DtoAuth auth = new DtoAuth(email,password);
        String json = gson.toJson(auth);
        webProvider.login(json, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onLoginError("Connection error!");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String jsonResponse = response.body().string();
                    DtoAuthToken authToken = gson.fromJson(jsonResponse,DtoAuthToken.class);
                    storeProvider.saveToken(authToken.getToken());
                    callback.onLoginSuccess();
                }else if(response.code() == 401){
                    callback.onLoginError("Wrong email or password!");
                }else{
                    callback.onLoginError("Server error");
                }
            }
        });
    }

    @Override
    public void registration(String email, String password, ILoginRepositoryCallback callback) {

    }
}
