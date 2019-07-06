package com.lwr.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.lwr.constant.ConstantName;
import com.lwr.pojo.entity.User;
import com.lwr.service.UserService;

public class LoginAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private User user;
    
    @Autowired
    //指定bean的名称@Qualifier("userServiceImpl")
    private UserService userService;

    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public String doLogin() {
        getSession().setAttribute("loginId", user.getLoginId());
        user = userService.getLoginUser(user);
        if(user!=null && !"".equals(user.getLoginId())) {
            getSession().setAttribute(ConstantName.SESSION_USER, user);
            return SUCCESS;
        }
        getSession().setAttribute("msg", "账号或者密码错误");
        return INPUT;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
