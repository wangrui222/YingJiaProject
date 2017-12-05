<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no,minimal-ui" />
<meta charset="utf-8">
<link href="${base}/resources/mobileapi/css/base.css" type="text/css" rel="stylesheet">
<link href="${base}/resources/mobileapi/css/css.css" type="text/css" rel="stylesheet">
<title>盈+详情</title>
</head>
<body>
<div class="content">
	<p>${(news.text)!!}</p>
</div>
</body>
</html>
