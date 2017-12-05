<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>我的加法库 - 盈+</title>
	<#include '../common/resources.html'>
</head>
<body>
	<#include "../common/top.html">
    <div class="sdbanner probanner"></div>
    <div class="proMain">
    	<div class="hwpzNav">
    		<ul>
    			<li class="first"><a href="${base}/subject">固收类理财</a></li>
    			<li class="second"><a href="${base}/finance">私募基金</a></li>
    			<li class="three"><a class="active" href="${base}/oversea">海外配置</a></li>
    			<li class="four"><a href="${base}/finance">股权基金</a></li>
    		</ul>
    	</div>
    	<ul class="safeList">
    		<#include "ajax_oversea.html">
    	</ul>
    </div>
   	
   	 <#include "../common/footer.html">
</body>

</html>