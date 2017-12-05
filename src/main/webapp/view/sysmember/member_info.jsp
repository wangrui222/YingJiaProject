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
        <link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
        <title>后台首页</title>
    </head>
<body>
<div class="box-right-main">
     <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>账号详情</h2>
     
      <table class="table table-bordered tablebox">
	 	<tr style="text-align: center;background: #AFABAB;"><td colspan="4" style="padding: 10px;">账号信息</td>	</tr>
	 	<tr>
			<th width="10%">用户名</th>	
			<td width="30%">${(member.name)!!}</td>	 	
			<th width="10%">手机号</th>	
			<td width="30%">${(member.mobilePhone)!!}</td>	 	
	 	</tr>
	 	<tr>
			<th>真实姓名</th>	
			<td>${(member.memberName)!!}</td>	 	
			<th>身份证</th>	
			<td>${(member.identity)!!}</td>	 	
	 	</tr>
	 	<tr>
			<th>邀请码</th>	
			<td>${(member.invitationcode)!!}</td>	 	
			<th>被邀请码</th>	
			<td>${(member.invitedcode)!!}</td>	 	
	 	</tr>
	 	<tr>
			<th>添加时间</th>	
			<td></td>	
			<td>&nbsp;</td>	
			<td>&nbsp;</td>	 	
	 	</tr>
	 </table>
     
      <table class="table table-bordered tablebox">
	 	<tr style="text-align: center;background: #AFABAB;"><td colspan="4" style="padding: 10px;">资金信息</td></tr>
	 	<tr>
			<th width="10%">可用余额</th>	
			<td width="30%">${(account.useableBalance)!!}</td>	 	
			<th width="10%">冻结金额</th>	
			<td width="30%">${(account.imusealeBalance)!!}</td>	 	
	 	</tr>
	 	<tr>
			<th>累计收益</th>	
			<td>${(account.totalProfit)!!}</td>	 	
			<th>投资总额</th>	
			<td>${(account.investAmount)!!}</td>	 	
	 	</tr>
	 	<tr>
			<th>红包金额</th>	
			<td>${(account.bonusAmount)!!}</td>	
			<td>体验金</td>	
			<td>${(account.bbinAmount)!!}</td>	 	
	 	</tr>
	 </table>
	 
	 <table class="table table-bordered tablebox">
	 <tr style="text-align: center;background: #AFABAB;"><td colspan="4" style="padding: 10px;">理财师信息</td></tr>
	 	<tr>
			<th width="10%">真实姓名</th>	
			<td width="30%">${(planner.name)!!}</td>
			<th width="10%">机构名称</th>	
			<td width="30%">${(planner.orgname)!!}</td>	 	
	 	</tr>
	 	<tr>
			<th>我的名片</th>	
			<td><a href="<%=basePath%>${(planner.mycard)!!}" target="_black">查看</a></td>
			<th>邮寄地址</th>	
			<td>${(planner.address)!!}</td>	 	
	 	</tr>
	 	<tr>
			<th>添加时间</th>	
			<td></td>
			<td>&nbsp;</td>	
			<td>&nbsp;</td>	
	 	</tr>
	 </table>
    
     <#include "ajax_purchase.html">
     <#include "ajax_withdraw.html">
     <#include "ajax_deposit.html">
     <#include "ajax_trade.html">
</div>
</body>
</html>