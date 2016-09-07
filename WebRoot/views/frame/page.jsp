<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pagelistbox">
<span>共 ${itemsPaginator.totalPages} 页/ ${itemsPaginator.totalCount} 条记录 当前第 ${itemsPaginator.page} 页</span>
<c:if test="${itemsPaginator.prePage != itemsPaginator.page }">  
    <a href="javascript:return false;" onclick="goPage(1);return false;">首页</a>
    <a href="javascript:return false;" onclick="goPage(${itemsPaginator.prePage});return false;">上一页</a>  
</c:if>  
<c:if test="${itemsPaginator.page == 1}"> 
<a href="javascript:return false;" ><font color="#999999">首页</font></a>
<a href="javascript:return false;" ><font color="#999999">上一页</font></a>  
</c:if>
<c:if test="${itemsPaginator.nextPage != itemsPaginator.page }">
    <a href="javascript:return false;" onclick="goPage(${itemsPaginator.nextPage});return false;">下一页</a>  
    <a href="javascript:return false;" onclick="goPage(${itemsPaginator.totalPages});return false;">末页</a>  
</c:if>  
<c:if test="${itemsPaginator.nextPage == itemsPaginator.page}">
<a href="javascript:return false;" ><font color="#999999">下一页</font></a>  
<a href="javascript:return false;" ><font color="#999999">末页</font></a> 
</c:if> 
</div>
<script>
//分页 form id 为page_form
function goPage(current_page){	
	//j("#current_page").val(current_page);
	//j("#page_form").submit();
	document.getElementById("pageIndex").value = current_page;
	document.getElementById("page_form").submit();
}
</script>
<input type="hidden" name="pageSize" id="pageSize" value="${itemsPaginator.limit }">
<input type="hidden" name="pageIndex" id="pageIndex" value="${itemsPaginator.page }">