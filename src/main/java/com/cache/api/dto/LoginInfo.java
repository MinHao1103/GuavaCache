package com.cache.api.dto;

public class LoginInfo {
    private String token;
    private String account;

    public LoginInfo(String token, String account) {
        this.token = token;
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}