<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
        <div style="margin:50px 50px;">
			<h2>欢迎您！ <a href="logOut" style="text-decoration:none;">退出</a></h2>
            <table border="1">
                <tr>
                    <td>登录名：</td>
                    <td><c:out value="${user.loginId }"/></td>
                </tr>
                <tr>
                    <td>昵称：</td>
                    <td><c:out value="${user.name }"/></td>
                </tr>
                <tr>
                    <td>手机号码：</td>
                    <td><c:out value="${user.tel }"/></td>
                </tr>
                <tr>
                    <td>注册时间：</td>
                    <td><c:out value="${user.createDate }"/></td>
                </tr>
            </table>
        </div>
</body>
</html>
