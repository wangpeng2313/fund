<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<jsp:include page="/views/frame/inc.jsp" />
	<body class="main_body">
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
					<u>查看详情</u>
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
								&nbsp;客户姓名：
							</td>
							<td>
								${item.clientName }
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
								&nbsp;客户性别：
							</td>
						
						  <td><fn:dicValue type="SEX" key="${item.sex }" />&nbsp;</td>
							
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="255" height="24" colspan="4" class="bline">
					<table width="800" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="150" align="right">
								&nbsp;学生电话：
							</td>
							<td>
								${item.phone }
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
								&nbsp 地址：
							</td>
							<td>
								${item.address }
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
								&nbsp 身份证号：
							</td>
							<td>
								${item.clientCard}
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
								&nbsp;Email：
							</td>
							<td>
								${item.email }
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
								&nbsp;爱好：
							</td>
							<td>
								${item.hobby }
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
								${item.remark }
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
								&nbsp;创建时间：
							</td>
							<td>
								${item.createTime }
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
					<input type="image"
						src="<%=request.getContextPath()%>/static/images/button_back.gif"
						width="60" height="22" class="np" border="0"
						style="cursor: pointer;"
						onClick="javascript:window.history.go(-1);return false;" />
				</td>
			</tr>
		</table>
	</body>
</html>