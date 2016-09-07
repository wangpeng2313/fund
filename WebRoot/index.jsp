<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统</title>
<link href="<%=request.getContextPath() %>/static/css/frame.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/static/js/jquery/jquery.js" language="javascript" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/js/frame.js" language="javascript" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/static/js/d.js" language="javascript" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/static/images/style2/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#skinlist {
    display: block;
    height: 11px;
	margin-top: 10px;
    overflow: hidden;
    width: 86px;
}
#skin div {
    float: left;
}
#skin li {
    cursor: pointer;
    float: left;
    height: 11px;
    width: 14px;
}
#def div, #s1 div, #s2 div, #s3 div, #s4 div{
    background-image: url("static/images/skinbutton.png");
    background-repeat: no-repeat;
}
#s1 div {
    background-position: 0 0px;
}
#s2 div {
    background-position: 0 -11px;
}
#s3 div {
    background-position: 0 -22px;
}
#s4 div {
    background-position: 0 -33px;
}
#s1 div.sel {
    background: url("static/images/skinbutton.png") no-repeat scroll -14px top transparent;
}
#s2 div.sel {
    background: url("static/images/skinbutton.png") no-repeat scroll -14px -11px transparent;
}
#s3 div.sel {
    background: url("static/images/skinbutton.png") no-repeat scroll -14px -22px transparent;
}
#s4 div.sel {
    background: url("static/images/skinbutton.png") no-repeat scroll -14px -33px transparent;
}
</style>

</head>
<body class="showmenu">
<div class="pagemask"></div>
<iframe class="iframemask"></iframe>
<div class="allmenu">
  <div class="allmenu-box">
    <br style='clear:both' />
  </div>
</div>
<div class="head">
  <div class="top">
    <div class="top_logo1"> <img src="<%=request.getContextPath() %>/static/images/top.jpg" width="150" height="100" alt="DedeCms Logo" title="Welcome use DedeCms" id="topdedelogo" /> </div>
    <div class="top_logo"> <img src="<%=request.getContextPath() %>/static/images/logo.png" width="200" height="60" alt="DedeCms Logo" title="Welcome use DedeCms" id="topdedelogo" /> </div>
    <div class="top_link" >
    
      <ul>
        <li class="welcome">您好：<shiro:principal property="name"/> 欢迎使用！</li>
       
        <li ><a href="<%=request.getContextPath() %>/logout" target="_top" >注销</a></li>
      </ul>
      <div class="quick" id="d1"  onclick="add()" align="right"> </div>
    </div>
  </div>
  <div class="topnav">
    <div class="menuact"> <a href="#" id="togglemenu">隐藏菜单</a>
	<!--
      <a href="#" id="allmenu">功能地图</a>
	  -->
    </div>
    <div class="nav" id="nav"> </div>
    
  </div>
</div>
<div class="left">
  <div class="menu" id="menu">
    <iframe src="<%=request.getContextPath() %>/index/menu" id="menufra" name="menu" frameborder="0"></iframe>
  </div>
</div>
<div class="right">
  <div class="main">
    <iframe id="main" name="main" frameborder="0" src="<%=request.getContextPath() %>/fundinfo/queryForPageList"></iframe>
  </div>
  </div>
</body>
</html>