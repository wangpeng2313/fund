<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CRM</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/base.css">
<script language="javascript" src="<%=request.getContextPath() %>/static/js/jquery.js"></script>
<script language="javascript" src="<%=request.getContextPath() %>/static/js/jquery-1.9.1.js"></script>
<script language="javascript" src="<%=request.getContextPath() %>/static/js/jquery.validate.js"></script>
<script language="JavaScript" src="<%=request.getContextPath() %>/static/My97DatePicker/WdatePicker.js"></script>
<link href="<%=request.getContextPath() %>/static/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
<script>
<%
if(request.getAttribute("message") != null){
%>
alert("<%=request.getAttribute("message")%>");
<% } %>
</script>