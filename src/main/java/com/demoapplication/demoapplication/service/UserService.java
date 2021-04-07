package com.demoapplication.demoapplication.service;

import com.demoapplication.demoapplication.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
