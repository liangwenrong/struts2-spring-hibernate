package com.lwr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ActionSupport是Action接口的简单实现类，ModelDriven是模型驱动接口（用于封装参数到对象）
 * 其他继承BaseAction的子类，通过配置struts的action就能访问到了
 */
@SuppressWarnings("rawtypes")
public class BaseAction extends ActionSupport implements ModelDriven {

    private static final long serialVersionUID = 1L;

    @Override
    public Object getModel() {
        return null;
    }
    
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request;
    }
    public HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }

}
