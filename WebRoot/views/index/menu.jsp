<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>left</title>
<base target="_self">
<link rel="StyleSheet" href="<%=request.getContextPath() %>/static/dtree/dtree.css" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/static/dtree/dtree.js"></script>
</head>
<style>
body {
	margin:auto;
	background-color:#eff5ed;
	background:url(static/images/leftmenu_bg.gif);
	padding-left:3px;
	overflow:scroll;
	overflow-x:hidden;
	scrollbar-face-color: #eff8e6;
	scrollbar-shadow-color: #edf2e3;
	scrollbar-highlight-color: #ffffff;
	scrollbar-3dlight-color: #F2F2F2;
	scrollbar-darkshadow-color: #bdbcbd;
	scrollbar-arrow-color: #bdbcbd
}
</style>
<body leftmargin="8" topmargin='8' bgcolor="#F7F7F7">
<div class="dtree">
	<script type="text/javascript">
		<!--

		d = new dTree('d');

		d.add(0,-1,'基金交易管理平台');
		d.add(111,0,'客户管理');
		d.add(1,111,'客户信息','<%=request.getContextPath() %>/ClientInfo/list',"列表",'main');
		d.add(222,0,'基金管理');
		d.add(1,222,'基金信息','<%=request.getContextPath() %>/fundinfo/queryForPageList',"列表",'main');
		d.add(2,222,'基金发行方','<%=request.getContextPath() %>/issue/queryForPageList',"列表",'main');
		d.add(444,0,'资金账户管理');
		d.add(1,444,'账户信息','<%=request.getContextPath() %>/fundAccount/queryForPageList',"列表",'main');
		d.add(555,0,'交易管理');
		d.add(1,555,'基金交易','<%=request.getContextPath() %>/transactionRecord/queryForPageList',"列表",'main');
		d.add(2,555,'交易记录','<%=request.getContextPath() %>/transactionInfo/queryForPageList',"列表",'main');
		d.add(3,555,'持仓情况','<%=request.getContextPath() %>/fundHolding/queryAll',"列表",'main');
		d.add(666,0,'查询报表');
		d.add(1,666,'综合查询','<%=request.getContextPath()%>/tu.do?method=zhu',"列表",'main');
		d.add(777,0,'银行卡管理');
		d.add(1,777,'开户管理','<%=request.getContextPath() %>/bankcard/add',"列表",'main');
		d.add(2,777,'账户挂失','<%=request.getContextPath() %>/bankcard/edit',"列表",'main');
		d.add(3,777,'账户销户','<%=request.getContextPath() %>/bankcard/delete',"列表",'main');
		d.add(4,777,'查询账户','<%=request.getContextPath() %>/bankcard/queryForPageList',"列表",'main');
		d.add(888,0,'系统管理');
		d.add(1,888,'员工管理','<%=request.getContextPath() %>/staff/queryForPageList',"列表",'main');
		d.add(2,888,'字典管理','<%=request.getContextPath() %>/dictionary/queryForPageList',"列表",'main');
		d.add(3,888,'部门管理','<%=request.getContextPath() %>/DeptInfo/queryForPageList',"列表",'main');
		d.add(4,888,'职位管理','<%=request.getContextPath() %>/position/queryForPageList',"列表",'main');
		d.add(999,0,'联系我们');
		d.add(1,999,'邮件发送','<%=request.getContextPath() %>/views/email/mail.jsp',"列表",'main');
		document.write(d);
		

		//-->
	</script>
</div>
</body>
</html>