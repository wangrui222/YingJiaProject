<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<#include "../common/base.html">
<div class="ajaxContainer">
	<!-- 异步内容开始 -->
	<#list pageInfo.list as ca>
		<li>
				<a href="<%=basePath%>oversea/overseaView/${(ca.id)!!}">
				<span style="width: 40px;height: 40px;" class="iconfont"><img src="<%=basePath%>${(ca.overseaIcon)!!}" width="40" height="40"/></span>

				<h2>${(ca.title)!!}<p>${(ca.childTitle)!!}</p></h2>
				<h3>${(ca.description)!!}<p><i style="color: #aaa; font-style: normal;">用户群体：</i>${(ca.userType)!!}</p></h3>
			</a>
		</li>
	</#list>
	<!-- 异步内容结束 -->
<#include "ajax_paginate.html" /> 
<@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="<%=basePath%>oversea/overseaAjax" urlParas=""/>
</div>
<script type="text/javascript">
	function getJsonInfo(url) {
		$.get(url, 'json', function(data) {
			$(".ajaxContainer").empty();
			$(".ajaxContainer").append(data);
		});
	}
    </script>
</body>
</html>