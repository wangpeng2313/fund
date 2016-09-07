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
	if($("#staffName").val()==""){
		alert("名称不允许为空!");
		$("#staffName").focus();
		return false;
	}
	if($("#tel").val()==""){
		alert("电话号码不允许为空!");
		$("#tel").focus();
		return false;
	}
	if($("#deptName").val()==""){
		alert("部门名称不允许为空!");
		$("#deptName").focus();
		return false;
	}
	if($("#sex").val()==""){
		alert("性别不允许为空!");
		$("#sex").focus();
		return false;
	}
	if($("#cardNo").val()==""){
		alert("身份证号不允许为空!");
		$("#cardNo").focus();
		return false;
	}
	if($("#email").val()==""){
		alert("电子邮箱不允许为空!");
		$("#email").focus();
		return false;
	}
	if($("#bankNo").val()==""){
		alert("银行卡号不允许为空!");
		$("#bankNo").focus();
		return false;
	}
	if($("#education").val()==""){
		alert("学历不允许为空!");
		$("#education").focus();
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
function changeCity(obj){
	
	var url = "<%=request.getContextPath()%>/dictionary/queryForCityList?parentId=" + $(obj).val();
	$.ajax({ url: url, success: function(cityList){
		//alert(data[1].value);
		var options = "";
		for(var i = 0 ; i < cityList.length ;i++){
			options+="<option value='"+ cityList[i].key +"'>" + cityList[i].value + "</option>";
		}
		//alert(options);
		$("#city").html("<option value=0>--请选择--</option>"+options);
	}});
}
function selectFile(){
	var url = "<%=request.getContextPath()%>/util/uploadPage?type=img";
	window.open(url,"","dialogWidth=300px;dialogHeight=100px");
}
function reUpload(v){
	$("#testFile").val(v);
}
</script>

<body class="main_body">
<form name="subForm" action="<%=request.getContextPath() %>/staff/editSave" method="post" onSubmit="return checkSubmit()">
<input type="hidden" name="staffId" value="${item.staffId }">
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
    <td background="#ffffff" valign="top" colspan="9">
           当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;系统管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;员工管理</td>
  </tr>
    <tr>
      <td width="60%" height="30"><IMG height=14 src="<%=request.getContextPath() %>/static/images/book1.gif" width=20>&nbsp;<u>修改员工信息</u></td>
      <td width="30%" align='right'>&nbsp;</td>
    </tr>
  </table>
  <table width="98%"  border="0" align="center" cellpadding="2" cellspacing="2" id="needset" style="border:1px solid #cfcfcf;background:#ffffff;">
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;姓名：</td>
          <td><input name="staffName" type="text" id="staffName" maxlength="64" size="30" value="${item.staffName }" required onblur="return isChinese(this,staffName)"/>&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;上传照片：</td>
          <td><input name="testFile" id="testFile" type="text" readonly="readonly" value="${item.testFile }"/><a href="javascript:selectFile();">请选择文件</a>&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
     <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;电话：</td>
          <td><input name="tel" type="number" id="tel" maxlength="11" size="30" value="${item.tel }" required/>&nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
     <tr>
    <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;性别：</td>
          <td>
          <r:htmlRadio type="SEX" id="sex" name="sex" value="${item.sex }" html="onclick='test(111)'"/>
          &nbsp;&nbsp;<span style="color:red;">*</span>
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;身份证号：</td>
          <td>




									<input name="cardNo" type="number" id="cardNo" maxlength="18"
										size="30" value="${item.cardNo }" minlength="18" required />
									&nbsp;&nbsp;
									<span style="color: red;">*</span>

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
									<input name="email" type="email" id="email" maxlength="64"
										size="30" value="${item.email }" />
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
									&nbsp;银行卡类型：
								</td>
								<td>
									<fn:select type="BANK_TYPE" id="bankType" name="bankType"
										haveSelect="true" value="${item.bankType }" />
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
									&nbsp;银行卡号：
								</td>
								<td>
									<input name="bankNo" type="text" id="bankNo" maxlength="64"
										size="30" value="${item.bankNo }" />&nbsp;&nbsp;
									<span style="color: red;">*</span>
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
									&nbsp;所在省：
								</td>
								<td>
									<fn:select type="PROVINCE" id="province" name="province"
										haveSelect="true" value="${item.province }"
										html="onchange='changeCity(this)'" />
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
									&nbsp;所在市：
								</td>
								<td>
									<fn:select type="CITY" id="city" name="city" haveSelect="true"
										value="${item.city }" parentId="${item.province }" />
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
									&nbsp;学历：
								</td>
								<td>
									<fn:select type="EDUCATION" id="education" name="education"
										haveSelect="true" value="${item.education }" />
									&nbsp;&nbsp;
									<span style="color: red;">*</span>
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
									&nbsp;毕业院校：
								</td>
								<td>
									<input name="school" type="text" id="school" maxlength="64"
										size="30" value="${item.school }" />
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
									&nbsp;毕业时间：
								</td>
								<td>
									<input name="graduationDate" type="text" id="graduationDate"
										maxlength="64" size="30" value="${item.graduationDate }"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
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
										style="width: 80%; height: 50px">${item.remark }</textarea>
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