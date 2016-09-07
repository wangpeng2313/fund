<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转提示</title>
<jsp:include  page="/views/frame/inc.jsp"/>
<style>div{line-height:160%;}</style></head>
<body leftmargin='0' topmargin='0' bgcolor='#FFFFFF'>
<center>

<br />
<div style='width:450px;padding:0px;border:1px solid #DADADA;'>
<div style='padding:6px;font-size:12px;border-bottom:1px solid #DADADA;background:#DBEEBD url(<%=request.getContextPath() %>/images/wbg_defautl.gif)';'><b>提示信息！</b></div>
<div style='height:130px;font-size:10pt;background:#ffffff'><br />
<B style="color: green">${message }!</B>
<br />
<a href="<%=request.getContextPath() %>/${url }">如果您的浏览器没有反应,请点击这里...</a>
</div>
<script type="text/javascript">
	function JumpUrl(){
		window.location = "<%=request.getContextPath() %>/${url }";
	}
	setTimeout('JumpUrl()',2000);
</script>
</div>
</center>


</body>
</html>