<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script >
function detail(rid){
		window.location.href="<%=request.getContextPath() %>/transactionInfo/detail?rid=" + rid ;
	}
	function edit(rid){
		window.location.href="<%=request.getContextPath() %>/transactionInfo/toedit?rid=" + rid ;
	}
	function del(rid){
		if(window.confirm("是否确认删除?")){
			window.location.href="<%=request.getContextPath() %>/transactionInfo/delete?rid=" + rid ;
		}
	}
	function add(){
		window.location.href="<%=request.getContextPath() %>/transactionInfo/add";
	}
	//test();
</script>
  <body class="main_body">
<form name='page_form' id="page_form" action='<%=request.getContextPath() %>/transactionInfo/queryForPageList' method='post'>
<table width='98%' id="condition_table"  border='0' cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' align="center" style="margin-top:8px;width: 980px">
  <tr>
    <td bgcolor="#FBFCE2" valign="top" colspan="9">
    当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;交易管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;交易记录</td>
  </tr>
  <tr bgcolor='#EEF4EA'>
    <td align='center' background='<%=request.getContextPath() %>/static/images/wbg.gif' bgcolor="#EEF4EA">
      <table width="100%" height="32" border='0' cellpadding='0' cellspacing='0'>
        <tr height="30">
	        <td width="20%" align="right">&nbsp;账户号码： </td>
	        <td width='30%' align="left"><input type='text' name='aId' value='${item.aId}'/></td>
	        <td height="36" align="center">
			<div class="pagelistbox">
			  <input name="imageField2" type="image" src="<%=request.getContextPath() %>/static/images/button_search.gif" width="60" height="22" border="0" class="np" />&nbsp;
			</div></td>
	    </tr>
     </table>
   </td>
  </tr>
</table>


<table width='98%'  border='0' align="center" cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' style="margin-top:8px;width: 980px">
	<tr bgcolor="#E7E7E7" >
		<td height="28" colspan="15" background="<%=request.getContextPath() %>/static/images/tbg.gif" style="padding-left:10px;">
			<table width="100%">
		      <tr>
		        <td width="50%"><b>交易记录</b>&nbsp; </td>
		        <td align="right"><input name="imageField2" type="image" src="<%=request.getContextPath() %>/static/images/button_add.gif" width="60" height="22" border="0" class="np" onClick="javascript:add();return false;" /></td>
		      </tr>
		    </table>
	    </td>
	</tr>
	<tr align="center" bgcolor="#FBFCE2" height="25">
		<td width="5%">序号</td>
        <td width="">基金交易时间</td>
        <td width="">基金类型</td>
        <td width="">账户订单ID</td>
        <td width="">银行卡</td>
        <td width="25%">资金账户状态</td>
        <td width="20%" class="last_td">操作</td>
	</tr>
	
	<c:forEach var="item" items="${items}" varStatus="index">
	<tr align='center' bgcolor="#FFFFFF" height="26" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
		<td nowrap>${index.count}</td>
		<td>${item.rdate }</td>
		<td>${item.rtype}</td>
		<td>${item.roid }</td>
		<td>${item.fundAccount.aCard}</td>
		<td>${item.fundAccount.aState}</td>
		<td><a href="#" onClick="detail(${item.rid});">查看</a> | <a href="#" onClick="del(${item.rid})">删除</a></td>
	</tr>
	</c:forEach>
	<tr align="right" bgcolor="#F9FCEF">
		<td height="36" colspan="15" align="center">
			<jsp:include  page="/views/frame/page.jsp"/>
		</td>
	</tr>
	
</table>

</form>
  </body>
</html>
