<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="/WEB-INF/DictionaryTag.tld"%>
<%@ taglib prefix="r" uri="/WEB-INF/RadioTag.tld"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<jsp:include page="/views/frame/inc.jsp" />
	<script>

$().ready(function() {
	// validate the comment form when it is submitted
	$("#subForm").validate();
});

var arr = new Array();
//选择基金名称
function selectFundInfo(){
	var url = "<%=request.getContextPath() %>/transactionRecord/selectForPageList";
	window.open(url,"","dialogWidth=500px;dialogHeight=800px");
}
function closeSelectInfo(infoId,name){
	$("#infoId").val(infoId);
	$("#name").val(name);
}
var arr2 = new Array();
//选择账户卡号
function selectFundAccount(){
	var url = "<%=request.getContextPath() %>/transactionRecord/selectForAccountList";
	window.open(url,"","dialogWidth=500px;dialogHeight=800px");
}
function closeSelect(aId,aCard){
	$("#aId").val(aId);
	$("#aCard").val(aCard);
}
/**
$.ajax({ url: url, success: function(){
  //操作
}});
**/
</script>
	<body class="main_body">
		<form name="subForm" id="subForm"
			action="<%=request.getContextPath()%>/fundHolding/editSave" method="post">
			<table width="98%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
    <td background="#ffffff" valign="top" colspan="9">
           当前位置：
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;基金交易管理系统&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;交易管理&nbsp;&nbsp;
    <img src="<%=request.getContextPath() %>/static/images/arrow.png" align="absmiddle">&nbsp;&nbsp;持仓情况</td>
  </tr>
				<tr>
					<td width="60%" height="30">
						<IMG height=14
							src="<%=request.getContextPath()%>/static/images/book1.gif"
							width=20>
						&nbsp;
						<u>修改持仓信息</u>
					</td>
					<td width="30%" align='right'>
						&nbsp;<input type="hidden" name="hId" id="hId" value="${item.hId}">
					</td>
				</tr>
			</table>
			<table width="98%" border="0" align="center" cellpadding="2"
				cellspacing="2" id="needset"
				style="border: 1px solid #cfcfcf; background: #ffffff;">
				<tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;账户号码：</td>
          <td>
           ${item.fundAccountEntity.aCard} 
          </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td width="255" height="24" colspan="4" class="bline"><table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="150" align="right">&nbsp;基金名称：</td>
          <td>
           ${item.fundInfoEntity.name}
          </td>
        </tr>
      </table></td>
    </tr>
				<tr>
					<td width="255" height="24" colspan="4" class="bline">
						<table width="800" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right">
									&nbsp;交易金份数：
								</td>
								<td>
									<input name="amount" type="number" value="${item.amount}" id="amount" maxlength="11"
										size="30" required />
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
										style="width: 80%; height: 50px">${item.remark }</textarea>
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
										maxlength="64" size="30" value="${item.createTime}"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
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