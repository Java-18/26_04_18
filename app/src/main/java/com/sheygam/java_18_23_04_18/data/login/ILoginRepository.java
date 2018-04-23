package com.sheygam.java_18_23_04_18.data.login;

public interface ILoginRepository {
    void login(String email, String password, ILoginRepositoryCallback callback);
    void registration(String email, String password, ILoginRepositoryCallback callback);
}
