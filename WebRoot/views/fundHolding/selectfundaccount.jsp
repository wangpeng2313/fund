<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script>
function selectFundAccount(aId,aCard){
	window.opener.closeSelect(aId,aCard);
	window.close();
}
</script>
<body class="main_body">
<form name='page_form' id="page_form" action='<%=request.getContextPath() %>/fundAccount/queryforByName' method='post'>
<table width='98%' id="condition_table"  border='0' cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td align='center' background='<%=request.getContextPath() %>/static/images/wbg.gif' bgcolor="#EEF4EA">
      <table width="800" height="32" border='0' cellpadding='0' cellspacing='0'>
        <tr height="30">
	        <td width="20%" align="right">&nbsp;账户卡号： </td>
	        <td width='30%' align="left"><input type='text' name='aCard' id="aCard" value=''/></td>
	        <td width="20%" align="right"></td>
	        <td width='30%' align="left">
			</td>
	    </tr>
     </table>
   </td>
  </tr>
  <tr align="right" bgcolor="#F9FCEF">
		<td height="36" align="center">
			<div class="pagelistbox">
			  <input name="imageField2" type="image" src="<%=request.getContextPath() %>/static/images/button_search.gif" width="60" height="22" border="0" class="np" />&nbsp;
			</div></td>
	</tr>
</table>

<table width='98%'  border='0' align="center" cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' style="margin-top:8px">
	<tr bgcolor="#E7E7E7" >
		<td height="28" colspan="22" background="<%=request.getContextPath() %>/static/images/tbg.gif" style="padding-left:10px;">
			<table width="100%">
		      <tr>
		        <td width="50%"><b>账户列表</b>&nbsp; </td>
		        <td width="50%" align="right"></td>
		      </tr>
		    </table>
	    </td>
	</tr>
	<tr align="center" bgcolor="#FBFCE2" height="25">
		<td>序号</td>
		<td>账户卡号</td>
        <td>操作</td>
	</tr>
	<c:forEach var="item" items="${items}" varStatus="index">
	<tr align='center' bgcolor="#FFFFFF" height="26" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
		<td nowrap>${index.count}</td>
		<td>${item.aCard }</td>
		<td><a href="#" onClick="selectFundAccount(${item.aId},'${item.aCard }');">选择</a></td>
	</tr>
	</c:forEach>
	<tr align="right" bgcolor="#F9FCEF">
		<td height="36" colspan="9" align="center">
			<jsp:include  page="/views/frame/page.jsp"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>