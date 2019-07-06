package com.lwr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwr.dao.UserDao;
import com.lwr.pojo.entity.User;
import com.lwr.service.UserService;

//@Service不加参数，默认使用类名LoginServiceImpl首字母小写也就是loginServiceImpl作为bean名称
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Override
    public User getLoginUser(User user) {
        return userDao.getLoginUser(user);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

}
