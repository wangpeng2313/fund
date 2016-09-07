<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>登录页</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery-1.8.0.js"></script>
    <link href="<%=request.getContextPath()%>/static/css/base.css" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/static/css/login.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript">
			function check(form){
				aa=form.username.value;
    			bb=form.password.value;	
				if (aa==""){
					alert("请输入用户名!");
					form.username.focus();
					return false;
				}else if (bb==""){
					alert("请输入密码!");
					form.password.focus();
					return false;
				}
			}
		</script>
<body>
<div id="login-box" >
  <div class="login-main">

<form id="loginForm" action="<%=request.getContextPath()%>/login" method="post" class="form-horizontal" onsubmit="return check(loginForm)" style="margin-left: 450px">
		<%
			String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
			if(error!=null){
		%>
			<div class="alert alert-error input-medium controls">
				
				<button class="close" data-dismiss="alert">×</button>登录失败，请重试.
			
			</div>
		
		<%
			}
		%>
		<div class="control-group" >
			<label for="username" class="control-label">用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="username" name="username"  value="${username}" style="width: 212px ;height: 25px"/></label>
			<br/><br/>
			<label for="password" class="control-label">密&nbsp;&nbsp;码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="password" name="password" style="width: 212px;height: 25px"/></label>
		</div>
			<br>
		<div class="control-group" style="margin-left: 60px">
			<div class="controls" >
				<label class="checkbox" for="rememberMe">&nbsp;&nbsp;<input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我</label>
				&nbsp;&nbsp;<input id="submit_btn" class="btn btn-primary" type="submit" value="登录"/> 
				&nbsp;&nbsp;
				<a class="btn" href="<%=request.getContextPath()%>/register">注册</a>
			 </div>
		</div>
	</form>
  </div>
</div>
	<script>
		$(document).ready(function() {
			$("#loginForm").validate();
		});
	</script>
</body>
</html>
