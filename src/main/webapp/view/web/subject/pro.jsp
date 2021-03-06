<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>产品中心- 盈+</title>
	<#include '../common/resources.html'>
</head>
<body>
<#include "../common/top.html">
    <div class="sdbanner probanner"></div>
    <div class="proMain">
    	<div class="hwpzNav">
    		<ul>
    			<li class="first"><a class="active" href="<%=basePath%>subject">固收类理财</a></li>
    			<li class="second"><a href="<%=basePath%>finance">私募基金</a></li>
    			<li class="three"><a href="<%=basePath%>oversea">海外配置</a></li>
    			<li class="four"><a href="<%=basePath%>finance">股权基金</a></li>
    		</ul>
    	</div>
        <div class="sdShaix">
         <#list plist as p>
        	<ul>
            	<li class="first">${p.name}：</li>
               <#list p.pchild as ch>
               		<li><a href="<%=basePath%>subject?cid=${ch.id}&type=${type}&yearRate=${yearRate}&period=${period}&status=${status}" id="${ch.id}">${ch.name}</a></li>
               </#list>
            </ul>
          </#list>
        </div>
		<#include "ajax_subjects.html">
    </div>
   
	 <#include "../common/footer.html">
<script type="text/javascript">
$(function(){
	$('#${type}').addClass("select");
	$('#${yearRate}').addClass("select");
	$('#${period}').addClass("select");
	$('#${status}').addClass("select");
});
</script>
</body>
</html>