<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld"%>
<%@ taglib prefix="r" uri="/WEB-INF/RadioTag.tld"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<jsp:include page="/views/frame/inc.jsp" />
	<script>
	function checkSubmit(){
		if($("#clientName").val()==""){
			alert("姓名不允许为空!");
			$("#clientName").focus();
			return false;
		}
		if($("#phone").val()==""){
			alert("电话不允许为空!");
			$("#phone").focus();
			return false;
		}
		if($("#sex").val()==""){
			alert("性别不允许为空!");
			$("#sex").focus();
			return false;
		}
		if($("#address").val()==""){
			alert("地址不允许为空!");
			$("#address").focus();
			return false;
		}
		if($("#clientCard").val()==""){
			alert("身份证号不允许为空!");
			$("#clientCard").focus();
			return false;
		}
		if($("#email").val()==""){
			alert("邮箱不允许为空!");
			$("#email").focus();
			return false;
		}
		if($("#graduationDate").val()==""){
			alert("创建日期不允许为空!");
			$("#graduationDate").focus();
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
	$().ready(function() {
		// validate the comment form when it is submitted
			$("#subForm").validate();
		});

	/**
	 $.ajax({ url: url, success: function(){
	 //操作
	 }});
	 **/
</script>
	<body class="main_body">
		<form id ="subForm" name="subForm"
			action="<%=request.getContextPath()%>/ClientInfo/editSave"
			method="post" onSubmit="return checkSubmit()">
			<input type="hidden" name="id" value="${item.id}">
			<table width="98%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
    <td background="#ffffff" valign="top" colspan="9">
           当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;客户管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;客户信息</td>
  </tr>
				<tr>
					<td width="60%" height="30">
						<IMG height=14
							src="<%=request.getContextPath()%>/static/images/book1.gif"
							width=20>
						&nbsp;
						<u>修改客户</u>
					</td>
					<td width="30%" align='right'>
						&nbsp;
					</td>
				</tr>
			</table>
			<table width="98%" border="0" align="center" cellpadding="2"
				cellspacing="2" id="needset"
				style="border: 1px solid #cfcfcf; background: #ffffff;">
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;姓名：
								</td>
								<td>
									<input name="clientName" type="text" id="clientName"
										maxlength="10" size="30" value="${item.clientName }" required  onblur="return isChinese(this,clientName)"/>&nbsp;&nbsp;<span style="color:red;">*</span>
									
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;性别：
								</td>
								<td>
									<r:htmlRadio type="SEX" id="sex" name="sex" value="${item.sex }"
										html="onclick='test(111)'" />
									&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red;">*</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;电话：
								</td>
								<td>
									<input name="phone" type="number" id="phone" maxlength="11" minlength ="11"  size="30"
										 value="${item.phone}" required />&nbsp;&nbsp;<span style="color:red;">*</span>
									
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;地址：
								</td>
								<td>
									<input name="address" type="text" id="address" maxlength="30"
										size="30" value="${item.address }" required/>&nbsp;&nbsp;<span style="color:red;">*</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				
					<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;身份证号：
								</td>
								<td>
									<input name="clientCard" type="number" id="clientCard" maxlength="18"
										size="30"  minlength ="18"  value="${item.clientCard }" required/>&nbsp;&nbsp;<span style="color:red;">*</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;电子邮件：
								</td>
								<td>
									<input name="email" type="email" id="email" maxlength="20"
										size="30" value="${item.email}" required/>&nbsp;&nbsp;<span style="color:red;">*</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;爱好：
								</td>
								<td>
									<input type="text" id="hobby" name="hobby"
										 value="${item.hobby}" maxlength="20"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
	
				<tr>
					<td height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;备注：
								</td>
								<td>
									<textarea name="remark" rows="5" id="remark"
										style="width: 80%; height: 50px" maxlength="100">${item.remark }</textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
							
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;创建时间：
								</td>
								<td>
									<input name="createTime" type="text" id="createTime"
										maxlength="20" size="30" value="${item.createTime }"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" required/>&nbsp;&nbsp;<span style="color:red;">*</span>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				
			</table>
			<table width="98%" border="0" cellspacing="0" cellpadding="0"
				align="center" bgcolor="#F9FCEF"
				style="border: 1px solid #cfcfcf; border-top: none;">
				<tr height="35">
					<td width="17%">
						&nbsp;
					</td>
					<td width="83%">
						<input name="imageField" type="image"
							src="<%=request.getContextPath()%>/static/images/button_save.gif"
							width="60" height="22" class="np" border="0"
							style="cursor: pointer;" />
						<input type="image"
							src="<%=request.getContextPath()%>/static/images/button_back.gif"
							width="60" height="22" class="np" border="0"
							style="cursor: pointer;"
							onClick="javascript:window.history.go(-1);return false;" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>