<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script>
	function detail(id){
		window.location.href="<%=request.getContextPath() %>/user/detail.do?id=" + id ;
	}
	function edit(id){
		window.location.href="<%=request.getContextPath() %>/user/edit.do?id=" + id ;
	}
	function del(id,delType){
		if(delType==1){
			if(window.confirm("该设备已在网络拓朴中,是否确认删除?")){
				window.location.href="<%=request.getContextPath() %>/user/delete.do?id=" + id ;
			}
		}else{
			if(window.confirm("是否确认删除?")){
				window.location.href="<%=request.getContextPath() %>/user/delete.do?id=" + id ;
			}
		}
	}
	function add(){
		window.location.href="<%=request.getContextPath() %>/user/add.do";
	}
	//test();
</script>
<body class="main_body">
<form name='page_form' id="page_form" action='<%=request.getContextPath() %>/user/queryForPageList.do' method='post'>
<table width='98%' id="condition_table"  border='0' cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' align="center" style="margin-top:8px;width: 800px">
  <tr bgcolor='#EEF4EA'>
    <td align='center' background='<%=request.getContextPath() %>/static/images/wbg.gif' bgcolor="#EEF4EA">
      <table width="800" height="32" border='0' cellpadding='0' cellspacing='0'>
        <tr height="30">
	        <td width="20%" align="right">&nbsp;用户： </td>
	        <td width='30%' align="left"><input type='text' name='name' value=''/></td>
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

<table width='98%'  border='0' align="center" cellpadding='1' cellspacing='1' bgcolor='#cfcfcf' style="margin-top:8px;width: 800px">
	<tr bgcolor="#E7E7E7" >
		<td height="28" colspan="7" background="<%=request.getContextPath() %>/static/images/tbg.gif" style="padding-left:10px;">
			<table width="100%">
		      <tr>
		        <td width="50%"><b>用户列表</b>&nbsp; </td>
		        <td align="right"><input name="imageField2" type="image" src="<%=request.getContextPath() %>/static/images/button_add.gif" width="60" height="22" border="0" class="np" onClick="javascript:add();return false;" /></td>
		      </tr>
		    </table>
	    </td>
	</tr>
	<tr align="center" bgcolor="#FBFCE2" height="25">
		<td width="5%">序号</td>
        <td width="40%">用户名</td>
        <td width="15%">权限类型</td>
        <td width="15%">创建时间</td>
        <td width="15%" class="last_td">操作</td>
	</tr>
	
	<c:forEach var="item" items="${list}" varStatus="index">
	<tr align='center' bgcolor="#FFFFFF" height="26" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';">
		<td nowrap>${index.count + (wntPage.page_size*(wntPage.current_page-1))}</td>
		<td>${item.name }</td>
		<td>${item.name }</td>
		<td>${item.name }</td>
		<td><a href="#" onClick="detail(${item.id});">查看</a> | <a href="#" onClick="edit(${item.id});">修改</a> | <a href="#" onClick="del(${item.id})">删除</a></td>
	</tr>
	</c:forEach>
	<tr align="right" bgcolor="#F9FCEF">
		<td height="36" colspan="7" align="center">
			<jsp:include  page="/views/frame/page.jsp"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>