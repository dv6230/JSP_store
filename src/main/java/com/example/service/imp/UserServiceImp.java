package com.example.service.imp;

import com.example.dao.UserDao;
import com.example.dao.imp.UserDaoImp;
import com.example.pojo.User;
import com.example.service.UserService;

public class UserServiceImp implements UserService {

    private UserDaoImp userDao = new UserDaoImp();

    @Override
    public void RegisterUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User Login(User user) {
        return userDao.queryUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean ExistUsername(String username) {
        if (userDao.queryUserByUserName(username) == null) {
            return false;
        } else {
            return true;
        }
    }

}
