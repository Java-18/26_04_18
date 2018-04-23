package com.sheygam.java_18_23_04_18.data.dto;

public class DtoAuth {
    private String email;
    private String password;

    public DtoAuth() {
    }

    public DtoAuth(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
