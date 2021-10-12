package com.example.service;

import com.example.pojo.User;

public interface UserService {
    public void RegisterUser(User user);

    public User Login(User user);

    public boolean ExistUsername(String username);
}
