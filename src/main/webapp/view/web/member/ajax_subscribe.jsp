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
<div class="ajaxContainer2">
	<!-- 异步内容开始 -->
	<table class="tzlist" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
		<tr>
			<th>标的名称</th>
			<th>金额</th>
			<th>预期收益</th>
			<th>状态</th>
			<th>预约时间</th>
			<th>下载</th>
		</tr>
		<#list pageInfo2.list as r>
			<tr>
				<td><font color="#a58b48">${r.financeProductFunds.name}</font></td>
				<td><font color="#ff503f">${r.amount?string.currency}</font></td>
				<td>1111111111111</td>
				<td>${r.statusDesc}</td>
				<td>${r.createDate?string("yyyy-MM-dd")}</td>
				<td><a href="<%=basePath%>${r.comment}" target="_black">查看下载</a></td>
			</tr>
		</#list>
	</table>
	<div class="listCount">总计<font color="#ff503f">${pageInfo2.total}</font>笔</div>
	<#include "ajax_paginate2.html" /> 
	<@paginate currentPage=(pageInfo2.pageNum)!0 totalPage=(pageInfo2.pages)!0 actionUrl="<%=basePath%>account/toSubscribeJson"/>
</div>
<script type="text/javascript">
	function getJsonInfo2(url) {
		$.get(url, 'json', function(data) {
			$(".ajaxContainer2").empty();
			$(".ajaxContainer2").append(data);
		});
	}
</script>
</body>
</html>