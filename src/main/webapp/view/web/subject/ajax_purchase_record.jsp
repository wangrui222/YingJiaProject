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
		 <table class="tzlist" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
                      <tr>
                        <th>序号</th>
                        <th>投标人</th>
                        <th>投标金额</th>
                        <th>投标时间</th>
                      </tr>
                      <!-- 
                      <#list pageInfo.list as pr>
	                      <tr>
	                        <td>${(pr.serialNumber)!!}</td>
	                        <td>${(pr.name[0..0])!!}**</td>
	                        <td>${(pr.amount)!!}</td>
	                        <td>${(pr.createDate?string('yyyy-MM-dd'))!!}</td>
	                      </tr>
                      </#list> -->
          </table>
	<!-- 异步内容结束 -->
  <#include "ajax_paginate.html" /> 
<@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="<%=basePath%>subject/subjectContentJson/${subjectid}" />
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