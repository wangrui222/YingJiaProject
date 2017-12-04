<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="ajaxContainer">
	<!-- 异步内容开始 -->
	 <table class="table table-bordered tablebox">
	 <tr style="text-align: center;background: #AFABAB;"><td colspan="7" style="padding: 10px;">钱包记录</td></tr>
		<tr>
			<th width="5%">序号</th>
			<th width="15%">交易编号</th>
			<th width="15%">交易金额</th>
			<th width="15%">交易状态</th>
			<th width="15%">交易分类</th>
			<th width="15%">交易名称</th>
			<th width="15%">交易时间</th>
		</tr>
		<#list pageInfo.list as r>
			<tr>
				<td>${(r_index+1)!!}</td>
				<td>${(r.tradeNo)!!}</td>
				<td>${(r.amount)!!}</td>
				<td>
					<#if r.tradeStatus!=2><font style="color: red;">${(r.statusDesc)!!}</font>
					<#else><font style="color: green;">${(r.statusDesc)!!}</font>
					</#if>
				</td>
				<td><font color="#a58b48">${(r.tradeTypeDesc)!!}</font></td>
				<td>${(r.tradeName)!!}</td>
				<td>${r.createDate?string("yyyy-MM-dd HH:mm:ss")}</td>
			</tr>
		</#list>
	</table>
	<#include "ajax_paginate.html" />
	<@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="${base}/sysmember/ajaxTrade" urlParas="&id=${(memberId)!!}"/>
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