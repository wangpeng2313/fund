<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script type="text/javascript">
function checkSubmit(){
	if($("#deptName").val()==""){
		alert("姓名不允许为空!");
		$("#deptName").focus();
		return false;
	}
	
	return true;
}
function isChinese(obj,obj_name){  
	var reg=/^[\u0391-\uFFE5]+$/;    
	if(obj.value!=""&&!reg.test(obj.value)){   
	alert('必须输入中文！');   
	 obj.value = "";   
	  obj.focus();   
		  return false;   
		   }   
		}   
</script>
  <body class="main_body">
  <form name="page_form" action="<%=request.getContextPath() %>/DeptInfo/edit" method="post" onSubmit="return checkSubmit()">
  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="#ffffff" valign="top" colspan="9">
           当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;系统管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;部门管理</td>
  </tr>
  <tr>
  <td width="60%" height="30"><IMG height=14 src="<%=request.getContextPath() %>/static/images/book1.gif" width=20>&nbsp;<u>修改部门信息</u></td>
    <td width="30%" align='right'>&nbsp;</td>
  </tr>
  </table>
  
  <table width="98%" border="0" align="center" cellpadding="2" cellspacing="2" id="needset" style="border:1px solid #cfcfcf;background:#ffffff;">
  	<tr>
  		<td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellpadding="0" cellspacing="0">
  		
  		</table></td>
  	</tr>
  	
  	<tr>
  	<td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;部门名称：</td>
          <td ><input type="hidden" name="deptId" value="${item.deptId}">
          <input name="deptName" type="text" id="deptName" maxlength="16" value="${item.deptName }" onblur="return isChinese(this,deptName)"/><span style="color:red;">*</span></td>
        </tr>
      </table>      </td>
  	</tr>
  	<tr>
   <td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
          <td ><input type="text" name="remark" id="remark" maxlength="16" value="${item.remark }"/><span style="color:red;">*</span></td>
        </tr>
      </table>      </td>
  	</tr>
  
  <tr>
  <td height="24" colspan="4" class="bline">
   <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;创建时间：</td>
          <td ><input name="createTime" type="text" id="createTime" value="${item.createTime }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />&nbsp;&nbsp;<span style="color:red;">*</span></td>
        </tr>
      </table>  
      </td>    
      </tr>
      </table>
   <table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" bgcolor="#F9FCEF" style="border:1px solid #cfcfcf;border-top:none;">
   <tr height="35">
    <td width="17%">&nbsp;</td>
    <td width="83%">
    	<input name="imageField" type="image" src="<%=request.getContextPath() %>/static/images/button_save.gif" width="60" height="22" class="np" border="0"  style="cursor:pointer;"/>
       <input type="image" src="<%=request.getContextPath() %>/static/images/button_back.gif" width="60" height="22" class="np" border="0" style="cursor:pointer;" onClick="javascript:window.history.go(-1);return false;"/></td>
   </tr>
</table>
  
  </form>
  
  </body>
</html>
