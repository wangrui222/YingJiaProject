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
			<form action="<%=basePath%>jian/sysmember/rechargeManage"
				method="post" name="form" id="form1">
				<input type="hidden" name="page" id="page">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">订单编号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="serialNumber" placeholder="订单编号"
							value="${memberDepositRecord.serialNumber}"></td>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="mobilePhone" placeholder="手机号"
							value="${members.mobilePhone}"></td>
						<td style="width: 90px">订单状态：</td>
						<td style="width: 180px">
						<td style="width: 140px"><select name="status"
							class="form-control" style="width: 135px; height: 32px"
							id="status">
								<option value=-1>全部</option>
								<c:forEach items="${slist }" var="s">
								<option value="${s.value}" ${s.value==memberDepositRecord.status?"selected='selected'":""} >${s.name}</option>
								</c:forEach>
						</select></td>
						
						<td style="width: 110px; padding-left: 30px">富友订单：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="payChannelOrderNo" placeholder="富友订单"
							value="${memberDepositRecord.payChannelOrderNo}"></td>
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
				</tr>
				<c:forEach items="${plist}" var="object" varStatus="index">
					<tr class="text-center">
						<td>${index.index+1}</td>
						<td>${object[1] }</td>
						<td>${object[2] }</td>
						<td>${object[3] }</td>
						<td>
						<c:if test="${object[4]==1 }">
						<p style="color: blue;">充值成功</p>
						</c:if>
						<c:if test="${object[4]==0 }">
						<p style="color: red;">充值失败</p>
						</c:if>
							
							</td>
						<td>${object[5]}</td>
						<td>${object[6]}</td>
						<td>${object[7]}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<div class="llpage">
			<div class="in">
				<nav> <span class="count">&nbsp;第&nbsp;<b>${page}</b>&nbsp;页，&nbsp;共&nbsp;<b>${pages}</b>&nbsp;页
				</span>
				<ul class="pagination">
					<li><a class="prev_page"
						href="javascript:pageRequest(${page>1?page-1:1})">上页</a></li>
					<c:forEach begin="1" end="${pages}" var="v">
						<li><a class="now" href="javascript:pageRequest(${v})">${v}</a></li>
					</c:forEach>
					<li><a
						href="javascript:pageRequest(${page<pages?page+1:pages})"
						class="next_page" rel="next">下页</a></li>
				</ul>
				</nav>
			</div>
		</div>
		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->

</body>
<script type="text/javascript">
	function pageRequest(page) {
		document.getElementById("page").value = page;
		document.form.submit();
        alert(page)
	}
</script>
</html>