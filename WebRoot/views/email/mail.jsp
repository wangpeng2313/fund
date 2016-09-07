<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发送普通文本格式的E-mail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/static/css/base.css" rel="stylesheet">
<script language="javascript">
function checkform(myform){
	for(i=0;i<myform.length;i++){
	    if(i!=1)
		if(myform.elements[i].value==""){
			alert(myform.elements[i].title+"不能为空！");
			myform.elements[i].focus();
			return false;
		}
	}
}
</script>
</head>
<body>
<form name="form1" method="post" action="sendEmail.jsp" onSubmit="return checkform(form1)">
<table width="649" height="454"  border="0" align="center" cellpadding="0" cellspacing="0" background="<%=request.getContextPath() %>/static/images/bg.jpg">
  <tr>
    <td width="67" height="109" background="Images/board_left.gif">&nbsp;</td>
    <td width="531" background="Images/board_left.gif">&nbsp;</td>
    <td width="51" background="Images/board_left.gif">&nbsp;</td>
  </tr>
  <tr valign="top">
    <td height="247">&nbsp;</td>
    <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="16%" height="27" align="center">收&nbsp;件&nbsp;人：</td>
        <td width="84%" colspan="2" align="left"><input name="to" type="text" id="to" title="收件人" size="60" value="1287346035@qq.com" readonly="readonly"></td>
    </tr>
      <tr>
        <td width="16%" height="27" align="center">抄&nbsp;&nbsp;&nbsp;&nbsp;送：</td>
        <td width="84%" colspan="2" align="left"><input name="cc" type="text" id="cc" title="抄送" size="60" value="1287346035@qq.com" readonly="readonly"></td>
      </tr> 
   
      <tr>
        <td height="27" align="center">发&nbsp;件&nbsp;人：</td>
        <td colspan="2" align="left"><input name="from" type="text" id="from" title="发件人" size="60" value="请输入您的邮箱地址" ></td>
      </tr>
      <tr>
        <td height="27" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
        <td colspan="2" align="left"><input name="password" type="password" id="password" title="发件人信箱密码" size="60" value=""></td>
      </tr>
      <tr>
        <td height="27" align="center">主&nbsp;&nbsp;&nbsp;&nbsp;题：</td>
        <td colspan="2" align="left"><input name="subject" type="text" id="subject" title="邮件主题" size="60"></td>
      </tr>
                     <!-- 在这里添加添加发送附件的表单 -->
        <tr>
        <td height="27" align="center">附&nbsp;&nbsp;&nbsp;&nbsp;件：</td>
        <td colspan="2" align="left"><input name="file" type="file" id="file"  title="添加附件" size="50" height="30"></td>
      </tr>
      <tr>
        <td height="93" align="center">内&nbsp;&nbsp;&nbsp;&nbsp;容：</td>
        <td colspan="2" align="left"><textarea name="content" cols="59" rows="7" class="wenbenkuang" id="content" title="邮件内容"></textarea></td>
      </tr>
      <tr>
        <td height="30" align="center">&nbsp;</td>
        <td height="40" align="right"><input name="Submit" type="submit" class="btn_grey" value="发送">
          &nbsp;
          <input name="Submit2" type="reset" class="btn_grey" value="重置">
          &nbsp;&nbsp;&nbsp;</td>
        <td align="left">&nbsp;</td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
  <tr valign="top">
    <td height="48">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>