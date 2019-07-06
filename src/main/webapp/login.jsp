<%@ page import="com.lwr.pojo.entity.User" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% 
User user = (User)session.getAttribute("user");
if(user!=null && !"".equals(user.getLoginId())){
	response.sendRedirect("home/index");
}
%>
<html>
<head>
    <script src="public/jquery-3.4.1.min.js"></script>
</head>
<body>
	<form id="form1" action="login/login" method="post">
		<div style="margin:50px 50px;">
			<table>
				<c:if test="${!empty msg}">
				<tr><td colspan="2" align="center" style="color: red"><c:out value="${msg }"/></td></tr>
				</c:if>
				<tr>
					<td>用户名：</td>
					<td><input name="loginId" value='<c:out value="${loginId }"/>'
						type="text"></td>
				</tr>
				<tr>
					<td>密 码：</td>
					<td><input name="password" value="" type="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br/>
					   <input type="button" value="登录" onclick="doLogin()"/>
					   &nbsp;<a href="register/register" style="text-decoration:none;">注册</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
<script type="text/javascript">
function doLogin(){
    var loginId = $("input[name='loginId']").val();
    if(loginId==null || loginId==""){
    	alert("用户名不能为空");
    	return;
    }
    var password = $("input[name='password']").val();	
    if(password==null || password==""){
    	alert("密码不能为空");
    	return;
    }
    $("#form1").submit();
}
</script>
