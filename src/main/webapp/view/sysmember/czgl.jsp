<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<link rel="stylesheet"
	href="<%=basePath%>resources/date/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="<%=basePath%>resources/date/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/date/bootstrap-datetimepicker.zh-CN.js"></script>

<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>充值管理
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>sysmember/rechargeManage" method="post"
				id="form1">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">订单编号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="serialNumber" placeholder="订单编号"
							value=""></td>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="mobilePhone" placeholder="手机号"
							value=""></td>
						<td style="width: 90px">订单状态：</td>
						<td style="width: 140px"><select name="status"
							class="form-control" style="width: 135px; height: 32px"
							id="status">
								<option value=-1>全部</option>
								<option value=0>充值失败</option>
								<option value=1>充值成功</option>
						</select></td>
						<td style="width: 110px; padding-left: 30px">富友订单：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="payChannelOrderNo" placeholder="富友订单"
							value=""></td>
						<td style="width: 110px; padding-left: 30px">订单时间：</td>
						<td style="width: 180px"><input type="text"
							class="form-control time" name="createDate" placeholder="订单时间"
							readonly="readonly" value="11"></td>
						<td class="pull-right" style="padding-right: 30px">
							<button type="submit" class="btn btn-primary btn-sm">查询</button>
						</td>
						<td>
							<button type="button" class="btn btn-primary btn-sm"
								onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">
								重置</button>
						</td>
					</tr>
				</table>
			</form>
			<table class="table table-bordered tablebox">

				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>订单编号</td>
					<td>手机号</td>
					<td>订单金额</td>
					<td>订单状态</td>
					<td>充值渠道</td>
					<td>富友手机充值订单</td>
					<td>订单时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${olist}" var="olist">
				<tr class="text-center">
					<td>${olist.sorId}</td>
					<td>${olist.serialNumber}</td>
					<td>${olist.members.mobilePhone}</td>
					<td>${olist.amount}</td>
					<td>${olist.status}</td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						 <a class="btn btn-primary btn-sm"
						href="<%=basePath%>sysmember/updateRecharge/">更新订单</a>
	
					</td>
				</tr>
				</c:forEach>
		
			</table>
		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->

	
	-->
</body>
</html>