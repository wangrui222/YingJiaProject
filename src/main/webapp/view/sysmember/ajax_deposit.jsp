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
<div class="ajaxContainer3">
	<!-- 异步内容开始 -->
	 <table class="table table-bordered tablebox">
	 <tr style="text-align: center;background: #AFABAB;"><td colspan="7" style="padding: 10px;">充值记录</td></tr>
		<tr>
			<th width="5%">序号</th>
			<th width="15%">充值编号</th>
			<th width="15%">充值金额</th>
			<th width="15%">充值状态</th>
			<th width="15%">充值渠道</th>
			<th width="15%">充值渠道编号</th>
			<th width="15%">充值时间</th>
		</tr>
		<#list pageInfoDeposit.list as r>
			<tr>
				<td>${(r_index+1)!!}</td>
				<td>${(r.serialNumber)!!}</td>
				<td>${(r.amount)!!}</td>
				<td>
					<#if r.status==0><font style="color: red;">${(r.statusDesc)!!}</font>
					<#else><font style="color: green;">${(r.statusDesc)!!}</font>
					</#if>
				</td>
				<td><font color="#a58b48">${(r.payChannelNameDesc)!!}</font></td>
				<td>${(r.payChannelOrderNo)!!}</td>
				<td>${r.createDate?string("yyyy-MM-dd HH:mm:ss")}</td>
			</tr>
		</#list>
	</table>
	<#include "ajax_paginate3.html" />
	<@paginate currentPage=(pageInfoDeposit.pageNum)!0 totalPage=(pageInfoDeposit.pages)!0 actionUrl="<%=basePath%>sysmember/ajaxDeposit" urlParas="&id=${(memberId)!!}"/>
</div>
<script type="text/javascript">
	function getJsonInfo3(url) {
		$.get(url, 'json', function(data) {
			$(".ajaxContainer3").empty();
			$(".ajaxContainer3").append(data);
		});
	}
</script>
</body>
</html>