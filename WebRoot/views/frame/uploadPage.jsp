<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld" %>
<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script>
$().ready(function() {
	// validate the comment form when it is submitted
	$("#subForm").validate();
});
if("${fileName}"!=''){
	alert("文件上传成功!");
	window.opener.reUpload("${fileName}");
	window.close();
}
</script>
<body class="main_body">
<form name="subForm" id="subForm" action="<%=request.getContextPath() %>/util/upload" method="post" enctype="multipart/form-data">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="60%" height="30"><IMG height=14 src="<%=request.getContextPath() %>/static/images/book1.gif" width=20>&nbsp;<u>文件上传</u></td>
      <td width="30%" align='right'>&nbsp;</td>
    </tr>
  </table>
  <table width="98%"  border="0" align="center" cellpadding="2" cellspacing="2" id="needset" style="border:1px solid #cfcfcf;background:#ffffff;">
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;请选择文件：</td>
          <td><input name="file" type="file" required/><span>*</span>
          </td>
        </tr>
      </table></td>
    </tr>
  </table>
  <table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" bgcolor="#F9FCEF" style="border:1px solid #cfcfcf;border-top:none;">
   <tr height="35">
    <td width="17%">&nbsp;</td>
    <td width="83%">
    	<input name="imageField" type="image" src="<%=request.getContextPath() %>/static/images/button_save.gif" width="60" height="22" class="np" border="0"  style="cursor:pointer;"/></td>
   </tr>
</table>
</form>
</body>
</html>