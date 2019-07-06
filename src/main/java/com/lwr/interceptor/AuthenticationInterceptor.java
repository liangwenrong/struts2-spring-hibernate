package com.lwr.interceptor;

import java.util.Map;

import com.lwr.constant.ConstantName;
import com.lwr.pojo.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = ActionContext.getContext();
        Map<String, ?> session = ctx.getSession();
        User user = (User) session.get(ConstantName.SESSION_USER);
        if (user != null && !"".equals(user.getLoginId())) {
            return invocation.invoke();
        }
        return "login";
    }

}
