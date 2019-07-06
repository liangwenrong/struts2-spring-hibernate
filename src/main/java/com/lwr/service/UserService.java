package com.lwr.service;

import com.lwr.pojo.entity.User;

public interface UserService {
    public User getLoginUser(User user);

    public void addUser(User user);
}
