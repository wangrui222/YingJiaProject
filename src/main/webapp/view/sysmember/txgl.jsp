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
			<form action="<%=basePath%>jian/sysmember/WithdrawManage"
				method="post" name="form" id="form1">
				<input type="hidden" id="page" name="page">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">姓名：</td>
						<td style="width: 180px"><input type="text"
							name="members.memberName" class="form-control" placeholder="姓名"
							value="${memberWithdrawRecord.members.memberName}"></td>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							name="members.mobilePhone" class="form-control" placeholder="手机号"
							value="${memberWithdrawRecord.members.mobilePhone }"></td>
						<td style="width: 130px; padding-left: 30px">绑卡卡号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="bankCard" placeholder="绑卡卡号"
							value="${memberWithdrawRecord.bankCard }"></td>
						<td style="width: 80px">状态：</td>
						<td style="width: 180px"><select name="status"
							class="form-control" style="width: 130px; height: 32px"
							id="status">
								<option value="-1">全部</option>
								<c:forEach items="${slist }" var="s">
									<option value="${s.value }"
										${s.value==memberWithdrawRecord.status?"selected='selected'":"" }>${s.name}</option>
								</c:forEach>
						</select></td>
						<!--  
						<td style="width: 110px; padding-left: 30px">提现时间：</td>
						<td style="width: 180px"><input type="text" name="createDate"
							class="form-control time" placeholder="提现时间" readonly="readonly"
							value=""></td>-->
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
				<c:forEach items="${pagelist.getContent()}" var="mlist"
					varStatus="index">
					<tr class="text-center">
						<td>${index.index+1}</td>
						<td>${mlist.members.mobilePhone}</td>
						<td>${mlist.members.memberName}</td>
						<td>${mlist.members.memberIdentity}</td>
						<td>${mlist.amount}</td>
						<td>${mlist.bankName}</td>
						<td>${mlist.bankCard}</td>
						<td>${mlist.cardaddress}</td>
						<td><c:if test="${mlist.status==0}">
								<p style="color: red">待审核</p>
							</c:if> <c:if test="${mlist.status==1}">
								<p style="color: green">已付款</p>
							</c:if> <c:if test="${mlist.status==2}">
								<p style="color: yellow">打款中</p>
							</c:if> <c:if test="${mlist.status==3}">
								<p style="color: red">打款失败</p>
							</c:if> <c:if test="${mlist.status==4}">
								<p style="color: green">已解冻</p>
							</c:if></td>
						<td>${mlist.createDate}</td>
						<td><a class="btn btn-primary btn-sm"
							href="<%=basePath%>ldd/sysmember/memberInfo/${mlist.members.memberId}">账号详细</a></td>
						<td><c:if test="${mlist.status==0}">
								<a class="btn btn-primary btn-sm" onclick="audit(${mlist.members.memberId})"
									data-toggle="modal" data-target="#myModal">审核</a>
								<a class="btn btn-primary btn-sm"
									href="<%=basePath%>jian/sysmember/withdrawPayment/serialNumber/channelName=BEIFU"
									onclick="return confirm('你确定要审核通过吗')">贝付打款</a>
								<a class="btn btn-primary btn-sm"
									href="<%=basePath%>jian/sysmember/WithdrawUnfreeze/${mlist.mwrId}"
									onclick="return confirm('你确定要解冻吗')">解冻</a>
							</c:if> <c:if test="${mlist.status==3}">
								<a class="btn btn-primary btn-sm" onclick="audit(${mlist.members.memberId})"
									data-toggle="modal" data-target="#myModal"
									onclick="return confirm('你确定要审核通过吗')">审核</a>
								<a class="btn btn-primary btn-sm"
									href="<%=basePath%>jian/sysmember/WithdrawUnfreeze/${mlist.mwrId}"
									onclick="return confirm('你确定要解冻吗')">解冻</a>
							</c:if> <c:if test="${mlist.status==1}">
								<p>已审核</p>
							</c:if> <c:if test="${mlist.status==4}">
								<p>已解冻</p>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="llpage">
			<div class="in">
				<nav> <span class="count">&nbsp;第&nbsp;<b>${pagelist.getNumber()+1}</b>&nbsp;页，&nbsp;共&nbsp;<b>${pagelist.getTotalPages()}</b>&nbsp;页
				</span>
				<ul class="pagination">
					<li><a class="prev_page"
						href="javascript:pageRequest(${pagelist.getNumber()>1?pagelist.getNumber():1})">上页</a></li>
					<c:forEach begin="1" end="${pagelist.getTotalPages()}" var="v">
						<li><a class="now" href="javascript:pageRequest(${v})">${v}</a></li>
					</c:forEach>
					<li><a
						href="javascript:pageRequest(${pagelist.getNumber()+1<pagelist.getTotalPages()?pagelist.getNumber()+1+1:pagelist.getTotalPages()})"
						class="next_page" rel="next">下页</a></li>
				</ul>
				</nav>
			</div>
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
				<form action="<%=basePath%>jian/sysmember/withdrawAudit"
					method="get">
					<div class="modal-body">
						<input type="hidden" id="memberId" name="memberId"> <select
							class="form-control" name="channelName" style="width: 200px;">
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
	</div>
</body>
<script type="text/javascript">
	function pageRequest(page) {
		document.getElementById("page").value = page;
		document.form.submit();

	}
	function audit(memberId){
		document.getElementById("memberId").value=memberId;
		document.getElementById("myModal").modal();
		
	}
	  
</script>
</html>