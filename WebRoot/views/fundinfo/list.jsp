<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script>
	function del(id){
		if(window.confirm("是否确认删除?")){
			window.location.href="<%=request.getContextPath() %>/fundinfo/delete?id=" + id ;
		}
	}
	function add(){
		window.location.href="<%=request.getContextPath() %>/fundinfo/add";
	}
	function edit(id){
		window.location.href="<%=request.getContextPath() %>/fundinfo/edit?id=" + id;
	}
	function detail(id){
		window.location.href="<%=request.getContextPath() %>/fundinfo/detail?id=" + id;
	}
</script>
<body class="main_body">
<form name='page_form' id="page_form" action='<%=request.getContextPath() %>/fundinfo/queryForPageList' method='post'>
<table width='98%' id="condition_table"  border='0' cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' align="center" style="margin-top:8px;width: 980px;">
  <tr>
    <td bgcolor="#FBFCE2"  colspan="9">
    当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金信息</td>
  </tr>
  <tr bgcolor='#EEF4EA'>
    <td align='center' background='<%=request.getContextPath() %>/static/images/wbg.gif' bgcolor="#EEF4EA">
      <table width=100% height="32" border='0' cellpadding='0' cellspacing='0'>
        <tr height="30">
	        <td width="15%" align="right">&nbsp;基金名称： </td>
	        <td width='15%' align="left"><input type='text' name='name' value='${param.name }'/></td>
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
	
	<tr  bgcolor="#E7E7E7" >
		<td height="28" colspan="9" background="<%=request.getContextPath() %>/static/images/tbg.gif" style="padding-left:10px;">
			<table width="100%">
		      <tr>
		        <td width="50%"><b>基金信息列表</b>&nbsp; </td>
		        <td align="right"><input name="imageField2" type="image" src="<%=request.getContextPath() %>/static/images/button_add.gif" width="60" height="22" border="0" class="np" onClick="javascript:add();return false;" /></td>
		      </tr>
		    </table>
	    </td>
	</tr>
	<tr align="center" bgcolor="#FBFCE2" height="25">
		<td width="5%">序号</td>
        <td width="15%">基金名称</td>
        <td width="">基金发行方</td>
        <td width="15%">基金价格</td>
        <td width="15%">基金状态</td>
        <td width="20%" class="last_td">操作</td>
	</tr>
	
	<c:forEach var="item" items="${items}" varStatus="index">
	<tr align='center' bgcolor="#FFFFFF" height="26" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
		<td nowrap>${index.count}</td>
		<td>${item.name }</td>
		<td>${item.issue.issueName }</td>
		<td>${item.price }</td>
		<td><fn:dicValue key="${item.status }" type="F_STATUS"/> </td>
		<td><a href="#" onClick="detail(${item.infoId});">查看</a> | <a href="#" onClick="edit(${item.infoId});">修改</a> | <a href="#" onClick="del(${item.infoId})">删除</a></td>
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