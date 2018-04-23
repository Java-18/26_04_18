package com.sheygam.java_18_23_04_18.data.dto;

public class DtoAuthToken {
    private String token;

    public DtoAuthToken() {
    }

    public DtoAuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
