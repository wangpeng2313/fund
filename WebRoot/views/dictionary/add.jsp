<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<jsp:include page="/views/frame/inc.jsp" />
	<script>
$().ready(function() {
	// validate the comment form when it is submitted
	$("#subForm").validate();
});
</script>
	<body class="main_body">
		<form name="subForm" id="subForm"
			action="<%=request.getContextPath()%>/dictionary/addSave"
			method="post" onSubmit="return checkSubmit()">
			<table width="98%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
    <td background="#ffffff" valign="top" colspan="9">
           当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;系统管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;字典管理</td>
  </tr>
				<tr>
					<td width="60%" height="30">
						<IMG height=14
							src="<%=request.getContextPath()%>/static/images/book1.gif"
							width=20>
						&nbsp;
						<u>添加字典编码</u>
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
									&nbsp;字典类型编码：
								</td>
								<td>
									<input name="typeCode" type="text" id="typeCode" maxlength="64" required />
									<span style="color:red;">*</span>
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
									&nbsp;字典的Key：
								</td>
								<td>
									<input name="key" type="number" id="key" maxlength="16" required />
									<span style="color:red;">*</span>
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
									&nbsp;字典的VALUE：
								</td>
								<td>
									<input name="value" type="text" id="value" maxlength="16" required />
									<span style="color:red;">*</span>
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
									&nbsp;父ID：
								</td>
								<td>
									<input name="parentId" type="number" id="parentId" maxlength="16"
										value="0" required/>
									<span style="color:red;">*</span>
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
									&nbsp;排序：
								</td>
								<td>
									<input name="sort" type="number" id="sort" maxlength="16"
										value="0" required/>
									&nbsp;&nbsp;<span style="color:red;">*</span>
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
										style="width: 80%; height: 50px"></textarea>
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