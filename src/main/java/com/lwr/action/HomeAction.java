package com.lwr.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.lwr.constant.ConstantName;
import com.lwr.pojo.entity.User;
import com.lwr.utils.FileUtil;

public class HomeAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    //多个文件的集合
    private File[] upload;
    // /多个上传文件的类型集合
    private String[] uploadContentType;
    // 多个上传文件的文件名集合
    private String[] uploadFileName;

    public String goHome() {
        User user = (User) getSession().getAttribute(ConstantName.SESSION_USER);
        getRequest().setAttribute("user", user);
        return SUCCESS;
    }

    public String logOut() {
        getSession().invalidate();
        return INPUT;
    }

    public String toUpload() {
        return SUCCESS;
    }
    
    /**
     * 简单功能，未完善
     * fileUpload拦截器缓存文件到本地，结束后再清除
     */
    public String upload() {
        if(upload==null) {
            return ERROR;
        }
        String forder = "F:/upload/";
        if(upload.length > 0) {
            File dir = new File(forder);
            if(!dir.exists()) {
                dir.mkdirs();
            }
        }
        for (int i=0; i<upload.length; i++) {
            if(upload[i]==null) {
                continue;
            }
            try {
                String fileName = uploadFileName[i];
                String name = fileName.substring(0, fileName.lastIndexOf("."));
                String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
                fileName = name + "_"+new Date().getTime() +suffix;
                FileUtil.copy(upload[i],new File(forder+fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SUCCESS;
    }

    public File[] getUpload() {
        return upload;
    }

    public void setUpload(File[] upload) {
        this.upload = upload;
    }

    public String[] getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String[] getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

}
