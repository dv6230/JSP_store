package com.example.dao;

import com.example.pojo.User;

public interface UserDao {

    public User queryUserByUserName(String username);

    public User queryUserByUserNameAndPassword(String username, String password);

    public int saveUser(User user);

}
