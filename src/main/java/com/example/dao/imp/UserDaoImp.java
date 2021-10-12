package com.example.dao.imp;

import com.example.dao.UserDao;
import com.example.pojo.User;

public class UserDaoImp extends BaseDao implements UserDao {

    @Override
    public User queryUserByUserName(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `t_user` WHERE username = ? ";
        return QueryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUserNameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `t_user` WHERE username = ? AND password = ?";
        return QueryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `t_user` ( `username`, `password`, `email`) VALUES (?,?,?)";
        return Update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
