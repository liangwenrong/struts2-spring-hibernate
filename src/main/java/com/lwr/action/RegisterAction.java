package com.lwr.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.lwr.pojo.entity.User;
import com.lwr.service.UserService;

public class RegisterAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private User user;
    
    @Autowired
    private UserService userService;

    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    /**
     * 跳转注册页面
     */
    public String register() {
        return SUCCESS;
    }
    
    /**
     * 提及注册
     */
    public String save() {
        if(!doCheck(user)) {
            return INPUT;
        }
        try{
            user.setCreateDate(new Date());
            userService.addUser(user);
            getSession().setAttribute("msg", "注册成功，请登录");
        }catch (Exception e) {
            getSession().setAttribute("msg", "注册失败，请重试");
            return INPUT;
        }
        return SUCCESS;
    }

    private boolean doCheck(User user) {
        return true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
