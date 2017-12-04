<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#include '../../common/base.html'>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no,minimal-ui" />
<meta charset="utf-8">
<link href="${base}/resources/mobileapi/css/base.css" type="text/css" rel="stylesheet">
<link href="${base}/resources/mobileapi/css/css.css" type="text/css" rel="stylesheet">
<title>盈加咨讯详情</title>
</head>
<body>

<!-- <a style="width:20px;position:fixed;top:5px;left:5px;display:block" href="javascript:history.go(-1);">
	<img src="${base}/resources/mobileapi/images/fanhui.png" width="100%">
</a> -->
<h1 class="conTit">${(news.title)!!}</h1>
<div class="content">
	<p>${(news.text)!!}</p>
</div>
</body>
</html>
