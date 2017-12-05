<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<#include "../common/base.html">
<div class="ajaxContainer">
	<table class="tzlist" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
		<tr>
			<th width="30%">订单号</th>
			<th width="20%">金额</th>
			<th width="20%">状态</th>
			<th width="30%">时间</th>
		</tr>
		<#list pageInfo.list as r>
			<tr>
				<td>${r.serialNumber!!}</td>
				<td><font color="#ff503f">${r.amount?string.currency}</font></td>
				<td>${r.statusDesc}</td>
				<td>${r.createDate?string("yyyy-MM-dd HH:mm")}</td>
			</tr>
		</#list>
	</table>
	<#include "ajax_paginate.html" /> 
	<@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="<%=basePath%>account/deposit/retriveDepositRecordJson"/>


</div>
<script type="text/javascript">
	function getJsonInfo(url) {
		$.get(url, 'json', function(data) {
			$(".ajaxContainer").empty();
			$(".ajaxContainer").append(data);
		});
	}
</script>
</body>
</html>