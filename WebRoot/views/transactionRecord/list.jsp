<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script>
	function del(id){
		if(window.confirm("是否确认删除?")){
			window.location.href="<%=request.getContextPath() %>/transactionRecord/delete?trId=" + id ;
		}
	}
	function add(){
		window.location.href="<%=request.getContextPath() %>/transactionRecord/add";
	}
	function edit(id){
		window.location.href="<%=request.getContextPath() %>/transactionRecord/edit?trId=" + id;
	}
	function detail(id){
		window.location.href="<%=request.getContextPath() %>/transactionRecord/detail?trId=" + id;
	}
</script>
<body class="main_body">
<form name='page_form' id="page_form" action='<%=request.getContextPath() %>/transactionRecord/queryForPageList' method='post'>

<table width='98%'  border='0' align="center" cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' style="margin-top:8px;width: px">
	<tr>
    <td bgcolor="#FBFCE2" valign="top" colspan="9">
    当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;交易管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易</td>
  </tr>
	<tr bgcolor="#E7E7E7" >
		<td height="28" colspan="9" background="<%=request.getContextPath() %>/static/images/tbg.gif" style="padding-left:10px;">
			<table width="100%">
		      <tr>
		        <td width="50%"><b>基金交易信息列表</b>&nbsp; </td>
		        <td align="right"><input name="imageField2" type="image" src="<%=request.getContextPath() %>/static/images/button_add.gif" width="60" height="22" border="0" class="np" onClick="javascript:add();return false;" /></td>
		      </tr>
		    </table>
	    </td>
	</tr>
	<tr align="center" bgcolor="#FBFCE2" height="25">
		<td width="5%">序号</td>
        <td width="">基金名称</td>
        <td width="">账户号码</td>
        <td width="15%">基金交易份数</td>
        <td width="15%">基金交易单价</td>
        <td width="20%" class="last_td">操作</td>
	</tr>
	
	<c:forEach var="item" items="${items}" varStatus="index">
	<tr align='center' bgcolor="#FFFFFF" height="26" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
		<td nowrap>${index.count}</td>
		<td>${item.fundInfoEntity.name }</td>
		<td>${item.fundAccountEntity.aCard }</td>
		<td>${item.trAmount }</td>
		<td>${item.trPrice }</td>
		<td><a href="#" onClick="detail(${item.trId});">查看</a> | <a href="#" onClick="edit(${item.trId});">修改</a> | <a href="#" onClick="del(${item.trId})">删除</a></td>
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