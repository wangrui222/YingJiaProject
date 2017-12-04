<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${base}/resources/sys/ying/iconfont.css">
<link rel="stylesheet" href="${base}/resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="${base}/resources/sys/style/style.css">
<script type="text/javascript" src="${base}/resources/sys/js/jquery.js"></script>
<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>奖励记录
		</h2>
		<table class="table tabletop">
			<tr>
				<td style="width: 300px; padding-left: 30px">邀请手机号：<span
					style="color: red;">${(member.mobilePhone)!!}</span></td>
				<td style="width: 200px; padding-left: 30px; float: left;">邀请码：<span
					style="color: red;">${(member.invitationcode)!!}</span></td>
			</tr>
		</table>
		<div class="tablelist">
			<table class="table table-bordered tablebox">
				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>邀请人手机号</td>
					<td>被邀请人手机号</td>
					<td>奖励类型</td>
					<td>奖励金额</td>
					<td>奖励时间</td>
				</tr>
				<#list pageInfo.list as ar>
				<tr class="text-center">
					<td>${ar_index+1}</td>
					<td>${(ar.invitingid.mobilePhone)!!}</td>
					<td>${(ar.byinvitingid.mobilePhone)!!}</td>
					<td>${(ar.type.desc)!!}</td>
					<td>￥${(ar.amount)!!}</td>
					<td></td>
				</tr>
				</#list>
			</table>
			<#include "paginate.html" /> <@paginate
			currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
			actionUrl="${base}/sysmember/inviteRewardsRecord" />

		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->
</body>
</html>