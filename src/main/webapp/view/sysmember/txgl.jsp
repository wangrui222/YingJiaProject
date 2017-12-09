<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript"
	src="<%=basePath%>resources/sys/js/bootstrap.js"></script>

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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>提现管理
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>sysmember/WithdrawManage" method="post"
				id="form1">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">姓名：</td>
						<td style="width: 180px"><input type="text" name="memberName"
							class="form-control" placeholder="姓名" value=""></td>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							name="mobilePhone" class="form-control" placeholder="手机号"
							value=""></td>
						<td style="width: 130px; padding-left: 30px">绑卡卡号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="bankCard" placeholder="绑卡卡号" value=""></td>
						<td style="width: 80px">状态：</td>
						<td style="width: 180px"><select name="status"
							class="form-control" style="width: 130px; height: 32px"
							id="status">
								<option value="">全部</option>
								<option value="1">待审核</option>
								<option value="2">已付款</option>
								<option value="3">打款中</option>
								<option value="4">打款失败</option>
								<option value="4">已解冻</option>
						</select></td>
						<td style="width: 110px; padding-left: 30px">提现时间：</td>
						<td style="width: 180px"><input type="text" name="createDate"
							class="form-control time" placeholder="提现时间" readonly="readonly"
							value=""></td>
						<td class="pull-right" style="padding-right: 30px">
							<button type="submit" class="btn btn-primary btn-sm">查询</button>
						</td>
						<td><button type="button" class="btn btn-primary btn-sm"
								onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">重置</button></td>
					</tr>
				</table>
			</form>
			<table class="table table-bordered tablebox">
				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>手机号</td>
					<td>姓名</td>
					<td>身份证</td>
					<td>提现金额</td>
					<td>提现银行</td>
					<td>提现卡号</td>
					<td>提现开户行地址</td>
					<td>提现状态</td>
					<td>提现时间</td>
					<td>账号详细</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${mlist}" var="mlist">
					<tr class="text-center">
						<td>${mlist.mwrId}</td>
						<td>${mlist.members.mobilePhone}</td>
						<td>${mlist.members.memberName}</td>
						<td>${mlist.members.memberIdentity}</td>
						<td>${mlist.amount}</td>
						<td>${mlist.bankName}</td>
						<td>${mlist.bankCard}</td>
						<td>${mlist.cardaddress}</td>
						<td>${mlist.status}</td>
						<td>${mlist.createDate}</td>
						<td><a class="btn btn-primary btn-sm"
							href="<%=basePath%>sysmember/memberInfo?id">账号详细</a></td>
						<td><a class="btn btn-primary btn-sm"
							href="<%=basePath%>sysmember/withdrawAudit?serialNumber"
							data-toggle="modal" data-target="#myModal"
							onclick="return confirm('你确定要审核通过吗')">审核</a> <a
							class="btn btn-primary btn-sm"
							href="<%=basePath%>sysmember/WithdrawUnfreeze?serialNumber"
							onclick="return confirm('你确定要解冻吗')">解冻</a> <a
							class="btn btn-primary btn-sm" data-toggle="modal"
							onclick="audit('')">审核</a> <a class="btn btn-primary btn-sm"
							href="<%=basePath%>sysmember/withdrawPayment?serialNumber&channelName=BEIFU"
							onclick="return confirm('你确定要审核通过吗')">贝付打款</a> <a
							class="btn btn-primary btn-sm"
							href="<%=basePath%>sysmember/WithdrawUnfreeze?serialNumber"
							onclick="return confirm('你确定要解冻吗')">解冻</a> <!-- <a class="btn btn-primary btn-sm" href="<%=basePath%>sysmember/WithdrawPayFuIou?serialNumber=${m.serialNumber}" onclick="return confirm('你确定要审核通过吗')">富友打款</a> -->

						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">选择打款方式</h4>
				</div>
				<form action="<%=basePath%>sysmember/withdrawAudit" method="get">
					<div class="modal-body">
						<input type="hidden" name="serialNumber" value=""
							id="serialNumber"> <select class="form-control"
							name="channelName" style="width: 200px;">
							<option value="FUIOU" selected="selected">富友</option>
							<option value="BEIFU">贝付</option>
						</select>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary btn-sm"
							data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
</body>
</html>