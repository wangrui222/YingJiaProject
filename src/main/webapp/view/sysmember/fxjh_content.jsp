<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/ying/iconfont.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">
<script type="text/javascript"
	src="<%=basePath%>resources/sys/js/jquery.js"></script>
<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>付息计划
		</h2>

		<div class="tablelist">
			<table class="table tabletop">
				<tr>
					<td style="padding-left: 30px">标的名称：${(subject.name)!!} &nbsp;
						&nbsp; &nbsp; &nbsp; 标的期限：${(subject.period)!!}天 &nbsp; &nbsp;
						&nbsp; &nbsp; 年化收益率：${(subject.yearRate)!!}%</td>
				</tr>
			</table>
			<table class="table table-bordered tablebox">

				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>流水号</td>
					<td>投资人手机号</td>
					<td>投资人姓名</td>
					<td>投资人身份证</td>
					<td>投资金额</td>
					<td>还款利息+本金=本息</td>
					<td>投资时间</td>
					<td>还款时间</td>
					<td>还款状态</td>
					<td>操作</td>
				</tr>

				<#list pageInfo.list as s>
				<tr class="text-center">
					<td>${s_index+1}</td>
					<td>${s.serialNumber!!}</td>
					<td>${s.member.mobilePhone!!}</td>
					<td>${s.member.memberName!!}</td>
					<td>${s.member.identity!!}</td>
					<td>元</td>
					<td><span style="color: red;">${(s.interest)!!}</span>+ <span
						style="color: red;">${(s.amount)!!}</span>= <span
						style="color: blue;"></span>元</td>
					<td>
						<%-- ${(s.updateDate?string('yyyy-MM-dd HH:mm'))!!} --%>
					</td>
					<td>
						<%-- 	<#if (subject.type=='GU_SHOU')>                        	
                        		${(s.createDate?string('yyyy-MM-dd HH:mm'))!!}
                        	<#else>
                        		${(subject.endDate?string('yyyy-MM-dd HH:mm'))!!}
                        	</#if> --%>
					</td>
					<td><#if s.ispayment.description='未付款'> <span
						style="color: red;">${(s.ispayment.description)!!}</span> <#else>
						<span style="color: blue;">${(s.ispayment.description)!!}</span>
						</#if>
					</td>
					<td><#if s.ispayment='ISPAYMENT'> <a
						href="<%=basePath%>sysmember/paymentPurchase?id=${s.id}"
						class="btn btn-primary btn-sm">立即还款</a> <#else> <a
						href="javascript:" class="btn btn-primary btn-sm"
						style="background-color: #8393A1;">已还款</a> </#if>
					</td>
				</tr>
				</#list>
			</table>
			<#include "paginate.html" /> <@paginate
			currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
			actionUrl="<%=basePath%>sysmember/paymentContent"
			urlParas="&id=${(subject.id)!!}"/>
		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->
</body>
</html>