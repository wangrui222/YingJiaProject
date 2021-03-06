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
<link rel="stylesheet" href="<%=basePath%>resources/sys/ying/iconfont.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">
<script type="text/javascript" src="<%=basePath%>resources/sys/js/jquery.js"></script>
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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>钱包缴费记录
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>dailycash/list" method="post" id="form1">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">交易号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="tradeNo"
							value="${(tradeRecord.tradeNo)!!}" placeholder="交易号"></td>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="member.mobilePhone"
							value="${(tradeRecord.member.mobilePhone)!!}" placeholder="手机号"></td>
						<td style="width: 110px; padding-left: 30px">交易类型：</td>
						<td style="width: 180px"><select name="tradeType"
							class="form-control" style="width: 130px; height: 32px"
							id="tradeType">
								<option value="">全部</option>
								<option value="MOBILE_RECHARGE">手机充值</option>
								<option value="PUC_CHARGE">生活缴费</option>
								<option value="SINOPEC_RECHARGE">石化充值</option>
						</select></td>
						<td style="width: 110px; padding-left: 30px">交易状态：</td>
						<td style="width: 180px"><select name="tradeStatus"
							class="form-control" style="width: 130px; height: 32px"
							id="tradeStatus">
								<option value="-1">全部</option>
								<option value="0">等待付款</option>
								<option value="1">交易关闭</option>
								<option value="2">交易成功</option>
								<option value="3">失败</option>
								<option value="4">处理中</option>
								<option value="5">退款</option>
						</select></td>
						<td style="width: 110px; padding-left: 30px">交易时间：</td>
						<td style="width: 180px"><input type="text" name="createDate"
							class="form-control time" placeholder="交易时间" readonly="readonly"
							value="dailycash/list.jsp"></td>
						<!--${(tradeRecord.createDate?string('yyyy-MM-dd'))!!}  -->
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
					<td>交易号</td>
					<td>交易人手机号</td>
					<td>交易类型</td>
					<td>交易名称</td>
					<td>交易金额</td>
					<td>交易状态</td>
					<td>交易时间</td>
				</tr>
				<#list pageInfo.list as mt>
				<tr class="text-center">
					<td>${mt_index+1}</td>
					<td>${(mt.tradeNo)!!}</td>
					<td>${(mt.member.mobilePhone)!!}</td>
					<td>${(mt.tradeTypeDesc)!!}</td>
					<td>${(mt.tradeName)!!}</td>
					<td>${(mt.amount)!!}</td>
					<td><#if mt.tradeStatus!=2> <font style="color: red;">${(mt.statusDesc)!!}</font>
						<#else> <font style="color: green;">${(mt.statusDesc)!!}</font>
						</#if>
					</td>
					<td>${(mt.createDate)?string('yyyy-MM-dd HH:mm:ss')!!}</td>
				</tr>
				</#list>
			</table>
			<#include "/common/paginate.html" /> <@paginate
			currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
			actionUrl="<%=basePath%>dailycash/list"
			urlParas="&tradeNo=${(tradeRecord.tradeNo)!!}&member.mobilePhone=${(tradeRecord.member.mobilePhone)!!}&tradeType=${(tradeRecord.tradeType)!!}&tradeStatus=${(tradeRecord.tradeStatus)!!}&createDate=${(tradeRecord.createDate?string('yyyy-MM-dd'))!!}"/>
		</div>

		<!-- 内容结束 -->

	</div>
	<script type="text/javascript">
  	$(function(){
  		$("#tradeType").val("${(tradeRecord.tradeType)!!}");
  		$("#tradeStatus").val("${(tradeRecord.tradeStatus)!!}");
  	});
  	$('.time').datetimepicker({
		format : 'yyyy-mm-dd',
		language: 'zh-CN',
		minView: 2,
	    todayBtn: 1
	}).on('changeDate', function(ev) {
		$('.time').datetimepicker('hide');
	});
  </script>
	<!-- 容器结束 -->
</body>
</html>