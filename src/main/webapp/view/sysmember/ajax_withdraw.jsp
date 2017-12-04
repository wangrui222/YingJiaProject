<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="ajaxContainer2">
	<!-- 异步内容开始 -->
	 <table class="table table-bordered tablebox">
	 <tr style="text-align: center;background: #AFABAB;"><td colspan="7" style="padding: 10px;">提现记录</td></tr>
		<tr>
			<th width="5%">序号</th>
			<th width="15%">提现编号</th>
			<th width="15%">提现金额</th>
			<th width="15%">提现状态</th>
			<th width="15%">提现银行</th>
			<th width="15%">提现卡号</th>
			<th width="15%">提现时间</th>
		</tr>
		<#list pageInfoWithdraw.list as r>
			<tr>
				<td>${(r_index+1)!!}</td>
				<td>${(r.serialNumber)!!}</td>
				<td>${(r.amount)!!}</td>
				<td>
					<#if r.status==0><font style="color: red;">${(r.statusDesc)!!}</font>
					<#else><font style="color: green;">${(r.statusDesc)!!}</font>
					</#if>
				</td>
				<td><font color="#a58b48">${(r.bankName)!!}</font></td>
				<td>${(r.bankCard)!!}</td>
				<td>${r.createDate?string("yyyy-MM-dd HH:mm:ss")}</td>
			</tr>
		</#list>
	</table>
	<#include "ajax_paginate2.html" />
	<@paginate currentPage=(pageInfoWithdraw.pageNum)!0 totalPage=(pageInfoWithdraw.pages)!0 actionUrl="${base}/sysmember/ajaxWithdraw" urlParas="&id=${(memberId)!!}"/>
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