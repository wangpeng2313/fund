<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld" %>
<%@ taglib prefix="r" uri="/WEB-INF/RadioTag.tld" %>
<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include  page="/views/frame/inc.jsp"/>
<script>

function checkSubmit(){
	if($("#accno").val()==""){
		alert("账户号码不允许为空!");
		$("#accno").focus();
		return false;
	}
	if($("#accpwd").val()==""){
		alert("密码不允许为空!");
		$("#accpwd").focus();
		return false;
	}
	if($("#accpwd").val()!=$("#reaccpwd").val()){
		alert("两次密码不相同");
		return false;
	}
	return true;
}

$().ready(function() {
	// validate the comment form when it is submitted
	$("#subForm").validate();
});


var arr = new Array();
//选择客户名称
function selectClient(){
	//window.showModalDialog
	var url = "<%=request.getContextPath() %>/bankcard/selectForPageList";
	window.open(url,"","dialogWidth=500px;dialogHeight=800px");
}
function closeSelect(id,name){
	$("#id").val(id);
	$("#clientName").val(name);
}

</script>
<body class="main_body">
<form name="subForm" id="subForm" action="<%=request.getContextPath() %>/bankcard/addSave" method="post" onSubmit="return checkSubmit()">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
    <td background="#ffffff" valign="top" colspan="9">
           当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;银行卡管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;开户管理</td>
  </tr>
    <tr>
      <td width="60%" height="30"><IMG height=14 src="<%=request.getContextPath() %>/static/images/book1.gif" width=20>&nbsp;<u>客户开户信息</u></td>
      <td width="30%" align='right'>&nbsp;</td>
    </tr>
  </table>
  <table width="98%"  border="0" align="center" cellpadding="2" cellspacing="2" id="needset" style="border:1px solid #cfcfcf;background:#ffffff;">
     <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;客户姓名：</td>
          <td>
           <input id="clientName" type="text" readonly="readonly"/><input name="id" type="hidden" id="id" maxlength="64" size="30" value="0" />&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span> [<a href="javascript:selectClient();">选择客户姓名</a>]
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;账户号码：</td>
          <td><input name="accno" type="number" id="accno" maxlength="11" size="30"  required minlength="11" />&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;账户密码：</td>
          <td><input name="accpwd" type="password" id="accpwd" maxlength="11" size="30"  required minlength="11" />&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;确认密码：</td>
          <td><input name="reaccpwd" type="password" id="reaccpwd" maxlength="11" size="30"  required minlength="11" />&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;银行卡类型：</td>
          <td>
           <fn:select type="BANK_TYPE" id="bankType" name="bankType" haveSelect="true"/>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;账户余额：</td>
          <td>
            <input name="blance" type="number" id="blance"  size="30" maxlength="10" required/>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;当前状态：</td>
          <td>
          <r:htmlRadio type="ACC_STATE" id="accstate" name="accstate" value="1" html="onclick='test(111)'"/>
          &nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;创建时间：</td>
          <td>
          <input name="createtime" type="text" id="createtime" maxlength="64" size="30"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
          </td>
        </tr>
      </table></td>
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