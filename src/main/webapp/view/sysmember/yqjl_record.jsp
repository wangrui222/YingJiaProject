<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=basePath%>resources/sys/ying/iconfont.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">
<script type="text/javascript" src="<%=basePath%>resources/sys/js/jquery.js"></script>
<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>奖励记录
		</h2>
		<table class="table tabletop">
		<c:forEach items="${olist}" var="object">
			<tr>
				<td style="width: 300px; padding-left: 30px">邀请手机号：<span
					style="color: red;" ></span>${object[0] }</td>
				<td style="width: 200px; padding-left: 30px; float: left;">邀请码：<span
					style="color: red;">${object[1]}</span></td>
			</tr>
			</c:forEach>
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
					<c:forEach items="${mlist}" var="object"  varStatus="index">
				<tr class="text-center">
					<td>${index.index+1}</td>
					<td>${object[1]}</td>
					<td>${object[2]}</td>
					<td>
					<c:if test="${object[3]==0 }">注册奖励</c:if>
					<c:if test="${object[3]==1 }">投资奖励</c:if>
					</td>
					<td>￥${object[4]}</td>
					<td>${object[5]}</td>
				</tr>
				 </c:forEach>
			</table>
 
		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->
</body>
</html>