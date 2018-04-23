package com.sheygam.java_18_23_04_18.data.providers.web;


import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class WebProvider {
    private static final String BASE_URL = "https://telranstudentsproject.appspot.com/_ah/api/contactsApi/v1";
    private OkHttpClient client;
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public WebProvider(OkHttpClient client) {
        this.client = client;
    }

    public void login(String json, Callback callback){
        RequestBody body = RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(BASE_URL + "/login")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public void registration(String json, Callback callback){
        RequestBody body = RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(BASE_URL + "/registration")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
