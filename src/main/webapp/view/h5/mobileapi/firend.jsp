<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>盈加邀请好友获利</title>
<link href="<%=basePath%>resources/mobileapi/css/base.css" type="text/css" rel="stylesheet">
<link href="<%=basePath%>resources/mobileapi/css/css.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="firendPic"><img width="100%" src="<%=basePath%>resources/mobileapi/images/hyPic.jpg"></div>
<ul class="firendCount">
	<li><p>邀请人数</p><span>${(headCount)!!}</span></li>
    <li><p>已返金额</p><span>${(headAmount)!!}</span></li>
    <li><p>待返金额</p><span>${(surplusAmount)!!}</span></li>
</ul>
<div class="yqmBox">
    <ul class="yqmTable">
        <li class="first"><p>邀请码：<span>${(invitationCode)!!}</span></p></li>
        <li class="last"><button onclick="goSubmitOrder()">邀请</button></li>
    </ul>
</div>
<div class="yqInfo">
	<h2>奖励一：邀请好友注册</h2>
    <p>1、即日起成功邀请好友注册，好友可获得8.88元投资红包！</p>
    <h2>奖励二：邀请好友首次投资</h2>
    <p>2、好友成功投资10元以上，您可获得5元投资红包，不限邀请人数！</p>
</div>
<div class="yqTable">
	<p align="center" style="font-size:4vw;padding:1vh 0 2vh"><b>我邀请的好友列表</b></p>
	<table width="90%" border="1" borderColor="#dddddd">
		<tr>
			<th>姓名</th>
			<th>手机号</th>
			<th>是否投资</th>
		</tr>
		<#if inviteList?exists && inviteList?size gt 0> 
			<#list inviteList as so>
		<tr>
			<td>${so.name}</td>
			<td>${so.phone}</td>
			<td>${so.isInvestment}</td>
		</tr>
		</#list>
		</#if>
	</table>
	<br/>
</div>

<script type="text/javascript">
	function goSubmitOrder() {
		var ua = navigator.userAgent;
		if (ua.match(/iPhone|iPod/i) != null) {
			var myActionType = 'IOS';
			
			var myAppName = 'YingJia';
			var myActionParameters = {
				"shareCphoto" : "${httpurl}resources/mobileapi/images/yingjia.png",
				"shareTitle" : "盈+App邀请分享",
				"shareContent" : "好友邀请您注册盈+理财App,注册即有大礼相送~",
				"shareUrl" : "${httpurl}h5/v1/friendsContent/${(invitationCode)!!}"
			}; 
			var jsonString = (JSON.stringify(myActionParameters));
			var escapedJsonParameters = encodeURI(jsonString);
			var url = myAppName + '://' + myActionType + "#"
					+ escapedJsonParameters;
			document.location.href = url;
		} else {
			var myActionType = 'Android';
			
			share.invite("${httpurl}resources/mobileapi/images/yingjia.png" , "盈+App邀请分享" , "好友邀请您注册盈+理财App,注册即有大礼相送~" , "${httpurl}h5/v1/friendsContent/${(invitationCode)!!}");
		}
		
	}
</script>

</body>
</html>
