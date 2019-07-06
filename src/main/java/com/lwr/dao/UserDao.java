package com.lwr.dao;

import com.lwr.pojo.entity.User;

public interface UserDao {
    
    public User getLoginUser(User user);

    public void addUser(User user);

}
