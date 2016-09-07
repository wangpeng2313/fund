<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include  page="/views/frame/inc.jsp"/>
</head>
<body>
<div class="index_body">
<!--The pop-up box-->
<div class="body_popupbox01">
    
    <div class="popupbox02">
		<div class="popupbox_div popupbox_div02">
		  <div class="bottom_list">
	       	  <div class="table_title">
	                <div>提示</div>
	                <div class="right_input">
	                    <ul>
	                        <li class="checkbox_input"></li>
	                    </ul>
	                </div>
	        </div>
	        </div>
	      <div class="popupbox_buttom">
	      <div class="popupbox_image"><img src="<%=request.getContextPath() %>/images/big_icon01.png" width="50" height="50" /></div>
		  <div class="popupbox_title">${message }</div>
		  <div class="popupbox_concent"><a href="javascript:JumpUrl();return false;">如果您的浏览器没有反应,请点击这里...</a></div>
		  <div class="popupbox_button"><input type="button" value="确定" onclick="javascript:JumpUrl();return false;" /></div>
	      </div>
	    </div>
	</div>
</div>
<script type="text/javascript">
	function JumpUrl(){
		window.history.go(-1);
	}
	setTimeout('JumpUrl()',2000);
</script>
</body>
</html>
