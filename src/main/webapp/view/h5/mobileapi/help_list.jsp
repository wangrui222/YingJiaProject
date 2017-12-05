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
<title>盈加帮助中心</title>
<link href="<%=basePath%>resources/mobileapi/css/base.css" type="text/css" rel="stylesheet">
<link href="<%=basePath%>resources/mobileapi/css/css.css" type="text/css" rel="stylesheet">
<link href="<%=basePath%>resources/mobileapi/font/iconfont.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>resources/sys/js/jquery.js"></script>
</head>
<body>
<ul class="helpNav">
	<a href="<%=basePath%>h5/v1/helpList?typeid=3"><li id="3"><span class="iconfont">&#xe600;</span><p>常见问题</p></li></a>
    <a href="<%=basePath%>h5/v1/helpList?typeid=4"><li id="4"><span class="iconfont">&#xe601;</span><p>理财介绍</p></li></a>
    <a href="<%=basePath%>h5/v1/helpList?typeid=5"><li id="5"><span class="iconfont">&#xe602;</span><p>资金安全</p></li></a>
    <a href="<%=basePath%>h5/v1/helpList?typeid=6"><li id="6"><span class="iconfont">&#xe603;</span><p>操作帮助</p></li></a>
    <a href="<%=basePath%>h5/v1/helpList?typeid=7"><li id="7"><span class="iconfont">&#xe604;</span><p>私募基金</p></li></a>
    <a href="<%=basePath%>h5/v1/helpList?typeid=8"><li id="8"><span class="iconfont">&#xe605;</span><p>股权基金</p></li></a>
    <a href="<%=basePath%>h5/v1/helpList?typeid=9"><li id="9"><span class="iconfont">&#xe606;</span><p>支付相关</p></li></a>
    <a href="<%=basePath%>h5/v1/helpList?typeid=10"><li id="10"><span class="iconfont">&#xe607;</span><p>邀请返利</p></li></a>
</ul>
<ul class="newsList">
	    <a href="<%=basePath%>h5/v1/helpContent?id=${n.id}"><li><span class="iconfont">&#xe609;</span>${(n.title)!!}</li></a>
</ul>
</body>
<script type="text/javascript">
	$("#"+${(typeid)!!}).addClass("active");
</script>
</html>
