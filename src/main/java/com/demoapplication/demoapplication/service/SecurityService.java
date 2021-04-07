package com.demoapplication.demoapplication.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
