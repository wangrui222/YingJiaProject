<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<script type="text/javascript" src="/js/jquery-3.2.0.js"></script>
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
<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
<title>后台首页</title>
</head>
<body>
	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>账号详情
		</h2>

		<table class="table table-bordered tablebox">
			<tr style="text-align: center; background: #AFABAB;">
				<td colspan="4" style="padding: 10px;">账号信息</td>
			</tr>
			
			<tr>
				<th width="10%">用户名</th>
				<td width="30%">${memberslist.names}</td>
				<th width="10%">手机号</th>
				<td width="30%">${memberslist.mobilePhone}</td>
			</tr>
			<tr>
				<th>真实姓名</th>
				<td>${memberslist.memberName}</td>
				<th>身份证</th>
				<td>${memberslist.memberIdentity}</td>
			</tr>
			<tr>
				<th>邀请码</th>
				<td>${memberslist.invitationcode}</td>
				<th>被邀请码</th>
				<td>${memberslist.invitedcode}</td>
			</tr>
			<tr>
				<th>添加时间</th>
				<td>${memberslist.createDate}</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			
		</table>


		<table class="table table-bordered tablebox">
			<tr style="text-align: center; background: #AFABAB;">
				<td colspan="4" style="padding: 10px;">资金信息</td>
			</tr>
			<tr>
				<th width="10%">可用余额</th>
				<td width="30%">${membersaccountlist.useableBalance}</td>
				<th width="10%">冻结金额</th>
				<td width="30%">${membersaccountlist.imusealeBalance}</td>
			</tr>
			<tr>
				<th>累计收益</th>
				<td>${membersaccountlist.totalProfit}</td>
				<th>投资总额</th>
				<td>${membersaccountlist.investAmount}</td>
			</tr>
			<tr>
				<th>红包金额</th>
				<td>${membersaccountlist.bonusAmount}</td>
				<td>体验金</td>
				<td>${membersaccountlist.bbinAmount}</td>
			</tr>
		</table>
		<table class="table table-bordered tablebox">
			<tr style="text-align: center; background: #AFABAB;">
				<td colspan="4" style="padding: 10px;">理财师信息</td>
			</tr>
			<tr>
				<th width="10%">真实姓名</th>
				<td width="30%">${FinancialPlannerlist.financialPlannerName}</td>
				<th width="10%">机构名称</th>
				<td width="30%">${FinancialPlannerlist.orgname}</td>
			</tr>
			<tr>
				<th>我的名片</th>
				<td><a href="<%=basePath%>${FinancialPlannerlist.mycard}"
					target="_black">查看</a></td>
				<th>邮寄地址</th>
				<td>${FinancialPlannerlist.address}</td>
			</tr>
			<tr>
				<th>添加时间</th>
				<td>${FinancialPlannerlist.createDate}</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		<table class="table table-bordered tablebox">
			<tr style="text-align: center; background: #AFABAB;">
				<td colspan="7" style="padding: 10px;">投资记录</td>
			</tr>
			<tr>
				<th width="5%">序号</th>
				<th width="15%">投资编号</th>
				<th width="15%">投资金额</th>
				<th width="15%">投资状态</th>
				<th width="15%">投资标的名称</th>
				<th width="15%">投资收益</th>
				<th width="15%">投资时间</th>
			</tr>
			<c:forEach items="${subjectpurchaserecord}" var="subjectpurchaserecord"
				varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>${subjectpurchaserecord.serialNumber}</td>
				<td>${subjectpurchaserecord.amount}</td>
				<td>
					<#if r.ispayment.ordinal()==0><font style="color: red;">${(r.ispayment.description)!!}</font>
					<#else><font style="color: green;">${(r.ispayment.description)!!}</font>
					</#if>
				</td>
				<td><font color="#a58b48">${subjectpurchaserecord.}</font></td>
				<td>${subjectpurchaserecord.}</td>
				<td>${subjectpurchaserecord.}</td>
			</tr>
		</c:forEach>
		
		</table>
		<table class="table table-bordered tablebox">
			<tr style="text-align: center; background: #AFABAB;">
				<td colspan="7" style="padding: 10px;">充值记录</td>
			</tr>
			<tr>
				<th width="5%">序号</th>
				<th width="15%">充值编号</th>
				<th width="15%">充值金额</th>
				<th width="15%">充值状态</th>
				<th width="15%">充值渠道</th>
				<th width="15%">充值渠道编号</th>
				<th width="15%">充值时间</th>
			</tr>
			<c:forEach items="${memberdepositrecord}" var="memberdepositrecord"
				varStatus="vs">
				<tr>
					<td>${vs.index+1}</td>
					<td>${memberdepositrecord.serialNumber}</td>
					<td>${memberdepositrecord.amount}</td>
					<td><c:if test="${memberdepositrecord.status==0}"><font style="color: red;">失败</font>
						</c:if><c:if test="${memberdepositrecord.status !=0}"><font style="color: green;">完成</font>
						</c:if>
					</td>
					<td><font color="#a58b48">${memberdepositrecord.payChannelName}</font></td>
					<td>${memberdepositrecord.payChannelOrderNo}</td>
					<td>${memberdepositrecord.createDate}</td>
				</tr>
			</c:forEach>

		</table>
		<table class="table table-bordered tablebox">
			<tr style="text-align: center; background: #AFABAB;">
				<td colspan="7" style="padding: 10px;">钱包记录</td>
			</tr>
			<tr>
				<th width="5%">序号</th>
				<th width="15%">交易编号</th>
				<th width="15%">交易金额</th>
				<th width="15%">交易状态</th>
				<th width="15%">交易分类</th>
				<th width="15%">交易名称</th>
				<th width="15%">交易时间</th>
			</tr>
			<c:forEach items="${membertraderecord}" var="membertraderecord"
				varStatus="vs">
				<tr>
					<td>${vs.index+1}</td>
					<td>${membertraderecord.tradeNo}</td>
					<td>${membertraderecord.amount}</td>
					<td><c:if test="${membertraderecord.tradeStatus ==0}">
							<span style="color: blue;">完成</span>
						</c:if> <c:if test="${membertraderecord.tradeStatus !=0}">
							<span style="color: red;">失败</span>
						</c:if></td>
					<td><font color="#a58b48">${membertraderecord.tradeType}</font></td>
					<td>${membertraderecord.tradeName}</td>
					<td>${membertraderecord.createDate}</td>
				</tr>
			</c:forEach>
		</table>
		<table class="table table-bordered tablebox">
			<tr style="text-align: center; background: #AFABAB;">
				<td colspan="7" style="padding: 10px;">提现记录</td>
			</tr>
			<tr>
				<th width="5%">序号</th>
				<th width="15%">提现编号</th>
				<th width="15%">提现金额</th>
				<th width="15%">提现状态</th>
				<th width="15%">提现银行</th>
				<th width="15%">提现卡号</th>
				<th width="15%">提现时间</th>
			</tr>
			<c:forEach items="${memberWithdrawRecord}" var="memberWithdrawRecord"
				varStatus="vs">
				<tr>
					<td>${vs.index+1}</td>
					<td>${memberWithdrawRecord.serialNumber}</td>
					<td>${memberWithdrawRecord.amount}</td>
					<td><c:if test="${memberWithdrawRecord.status !=0}">
							<span style="color: blue;">完成</span>
						</c:if> <c:if test="${memberWithdrawRecord.status ==0}">
							<span style="color: red;">失败</span>
						</c:if></td>
					<td><font color="#a58b48">${memberWithdrawRecord.bankName}</font></td>
					<td>${memberWithdrawRecord.bankCard}</td>
					<td>${memberWithdrawRecord.createDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>


</html>