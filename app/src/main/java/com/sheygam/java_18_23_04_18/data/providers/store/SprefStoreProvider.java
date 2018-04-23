package com.sheygam.java_18_23_04_18.data.providers.store;

import android.content.Context;

public class SprefStoreProvider implements IStoreProvider {
    public static final String AUTH_SP = "auth";
    public static final String TOKEN = "token";

    private Context context;

    public SprefStoreProvider(Context context) {
        this.context = context;
    }

    @Override
    public void saveToken(String token) {
        context.getSharedPreferences(AUTH_SP, Context.MODE_PRIVATE)
                .edit()
                .putString(TOKEN,token)
                .apply();
    }

    @Override
    public String getToken() {
        return context.getSharedPreferences(AUTH_SP,Context.MODE_PRIVATE)
                .getString(TOKEN,null);
    }
}
