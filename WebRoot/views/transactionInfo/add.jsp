<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="/views/frame/inc.jsp" />
<script type="text/javascript">
	$().ready(function() {
		// validate the comment form when it is submitted
		$("#page_form").validate();
	});
	var arr2 = new Array();
	//选择账户卡号
	function selectFundAccount(){
		var url = "<%=request.getContextPath() %>/transactionInfo/selectForAccountList";
		window.open(url,"","dialogWidth=500px;dialogHeight=800px");
	}
	function closeSelect(aId,aCard){
		$("#aId").val(aId);
		$("#aCard").val(aCard);
	}
</script>
  <body class="main_body">
  <form name="page_form" id="page_form" action="<%=request.getContextPath() %>/transactionInfo/addSave" method="post" onSubmit="return checkSubmit()">
  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="#ffffff" valign="top" colspan="9">
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;交易管理管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;交易记录</td>
  </tr>
  <tr>
  <td width="60%" height="30"><IMG height=14 src="<%=request.getContextPath() %>/static/images/book1.gif" width=20>&nbsp;<u>添加交易记录</u></td>
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
          <td width="150" align="right">&nbsp;账户号码：</td>
          <td ><input name="aCard" type="text"  readonly="readonly" id="aCard" maxlength="16" required /><input name="aId" type="hidden" id="aId" maxlength="64" size="30" value="0"/> [<a href="javascript:selectFundAccount();">选择账户号码</a>]&nbsp;&nbsp;<span style="color:red;">*</span></td>
        </tr>
      </table>      </td>
  	</tr>
  	<tr>
  	<td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;交易时间：</td>
          <td ><input name="rdate" type="text" required id="rdate"   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  />&nbsp;&nbsp;<span style="color:red;">*</span></td>
        </tr>
      </table>      </td>
  	</tr>
  	<tr>
  	<td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;基金类型：</td>
          <td ><input name="rtype" type="text" required id="rtype" maxlength="16" />&nbsp;&nbsp;<span style="color:red;">*</span></td>
        </tr>
      </table>      </td>
  	</tr>
  	<tr>
  	<td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;账户订单ID：</td>
          <td ><input name="roid" type="text" id="roid" maxlength="16" required/>&nbsp;&nbsp;<span style="color:red;">*</span></td>
        </tr>
      </table>      </td>
  	</tr>
  	<tr>
   <td height="24" colspan="4" class="bline">
      <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
          <td ><textarea name="remark" rows="5" id="remark" style="width:40%;height:50px"></textarea>&nbsp;&nbsp;<span style="color:red;">*</span></td>
        </tr>
      </table>      </td>
  	</tr>
  
  <tr>
  <td height="24" colspan="4" class="bline">
   <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;创建时间：</td>
          <td ><input name="createTime" type="text" id="createTime" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />&nbsp;&nbsp;<span style="color:red;">*</span></td>
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
