<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld" %>
<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script>

function checkSubmit(){
	if($("#trAmount").val()==""){
		alert("基金交易份数不允许为空!");
		$("#trAmount").focus();
		return false;
	}
	
	return true;
}

$().ready(function() {
	// validate the comment form when it is submitted
	$("#subForm").validate();
});

</script>
<body class="main_body">
<form name="subForm" id="subForm"  action="<%=request.getContextPath() %>/transactionRecord/editSave" method="post" onSubmit="return checkSubmit()">
<input type="hidden" name="infoId" value="${item.infoId }">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
     <tr>
    <td background="#ffffff" valign="top" colspan="9">
           当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;交易管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易</td>
  </tr>
    <tr>
      <td width="60%" height="30"><IMG height=14 src="<%=request.getContextPath() %>/static/images/book1.gif" width=20>&nbsp;<u>修改基金交易记录</u></td>
      <td width="30%" align='right'>&nbsp;</td>
    </tr>
  </table>
  <table width="98%"  border="0" align="center" cellpadding="2" cellspacing="2" id="needset" style="border:1px solid #cfcfcf;background:#ffffff;">
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;基金名称：</td>
          <td>${item.fundInfoEntity.name }
          </td>
        </tr>
      </table></td>
    </tr>
     <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;账户号码：</td>
          <td>${item.fundAccountEntity.aCard }
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;基金交易类型：</td>
          <td><fn:dicValue type="T_R_TYPE" key="${item.trType }" />&nbsp;</td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;基金交易份数：</td>
          <td><input name="trAmount" type="text" id="trAmount" maxlength="64" size="30"  required value="${item.trAmount }" />&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
     <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;基金交易单价：</td>
          <td><input name="trPrice" type="number" id="trPrice" maxlength="11" size="30" value="${item.trPrice }"  required   />&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
  <tr>
      <td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;备注：</td>
          <td ><textarea name="remark" rows="5" id="remark" style="width:80%;height:50px">${item.remark }</textarea></td>
        </tr>
      </table>      </td>
  </tr>
  <tr>
      <td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;交易时间：</td>
          <td ><input name="trTime" value="${item.trTime }" type="text" id="trTime" maxlength="64" size="30"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
        </tr>
      </table>      </td>
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