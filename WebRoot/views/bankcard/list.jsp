<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script type="text/javascript">

function del(id){
	if(window.confirm("是否确认删除?")){
		window.location.href="<%=request.getContextPath()%>/bankcard/deleteById.do?id=" + id ;
	}
}
</script>
<body class="main_body">
<form name='page_form' id="page_form" action='<%=request.getContextPath() %>/bankcard/queryForPageList' method='post'>
<table width='98%' id="condition_table"  border='0' cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' align="center" style="margin-top:8px;width: 980px">
  <tr>
    <td bgcolor="#FBFCE2" valign="top" colspan="9">
    当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;银行卡管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;开户管理</td>
  </tr>
  <tr bgcolor='#EEF4EA'>
    <td align='center' background='<%=request.getContextPath() %>/static/images/wbg.gif' bgcolor="#EEF4EA">
      <table width=100% height="32" border='0' cellpadding='0' cellspacing='0'>
        <tr height="30">
	        <td width="15%" align="right">&nbsp;账户号： </td>
	        <td width='15%' align="left"><input type='text' name='accno' value='${param.accno }'/></td>
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
		<td height="28" colspan="9" background="<%=request.getContextPath() %>/static/images/tbg.gif" style="padding-left:10px;">
			<table width="100%">
		      <tr>
		        <td width="50%"><b>银行卡信息列表</b>&nbsp; </td>
		      </tr>
		    </table>
	    </td>
	</tr>
	<tr align="center" bgcolor="#FBFCE2" height="25">
		<td width="5%">序号</td>
        <td width="">客户姓名</td>
        <td width="">账户号</td>
        <td width="9%">银行代号</td>
        <td width="">创建日期</td>
        <td width="9%">存款余额</td>
        <td width="20%" class="last_td">状态</td>
        <td>操作</td>
	</tr>
	
	<c:forEach var="item" items="${items}" varStatus="index">
	<tr align='center' bgcolor="#FFFFFF" height="26" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
		<td nowrap>${index.count}</td>
		<td>${item.client.clientName }</td>
		<td>${item.accno }</td>
		<td><fn:dicValue key="${item.bankType}" type="BANK_TYPE"/> </td>
		<td>${item.createtime }</td>
		<td>${item.blance }</td>
		<td>
		<c:if test="${item.accstate==1}">
			<p style="color:blue"><fn:dicValue key="${item.accstate}" type="ACC_STATE" /></p> 
		</c:if>
		<c:if test="${item.accstate==2}">
			<p style="color:orange"><fn:dicValue key="${item.accstate}" type="ACC_STATE" /></p>
		</c:if>
		<c:if test="${item.accstate==3}">
			<p style="color:red"><fn:dicValue key="${item.accstate}" type="ACC_STATE" /></p> 
		</c:if>
		</td>
		<td><a href="#" onClick="del(${item.accId})">删除</a></td>
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