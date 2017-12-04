<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<#macro paginate currentPage totalPage actionUrl urlParas="">
	<#if (totalPage <= 0) || (currentPage > totalPage)><#return></#if>
	<#local startPage = currentPage - 4>
	<#if (startPage < 1)><#local startPage = 1></#if>
	
	<#local endPage = currentPage + 4>
	<#if (endPage > totalPage)><#local endPage = totalPage></#if>
	
	<div class="llpage">
		<div class="in">
			<#if (currentPage <= 8)>
				<#local startPage = 1>
			</#if>
			<#if ((totalPage - currentPage) < 8)>
				<#local endPage = totalPage>
			</#if>
			
			<#if (currentPage == 1)>
				<a class="prev_page">上页</a>
			<#else>
				<a href="javascript:getJsonInfo2('${actionUrl}?page=#{currentPage - 1}${urlParas!}')" class="prev_page">上页</a>
			</#if>
			
			<#if (currentPage > 8)>
				<a href="javascript:getJsonInfo2('${actionUrl}?page=#{1}${urlParas!}')">#{1}</a>
				<a href="javascript:getJsonInfo2('${actionUrl}?page=#{2}${urlParas!}')">#{2}</a>
				<span class="gap">…</span>
			</#if>
			
			<#list startPage..endPage as i>
				<#if currentPage == i>
					<a class="now" >#{i}</a>
				<#else>
					<a href="javascript:getJsonInfo2('${actionUrl}?page=#{i}${urlParas!}')">#{i}</a>
				</#if>
			</#list>
			
			<#if ((totalPage - currentPage) >= 8)>
				<span class="gap">…</span>
				<a href="javascript:getJsonInfo2('${actionUrl}?page=#{totalPage - 1}${urlParas!}')">#{totalPage - 1}</a>
				<a href="javascript:getJsonInfo2('${actionUrl}?page=#{totalPage}${urlParas!}')">#{totalPage}</a>
			</#if>
			
			<#if (currentPage == totalPage)>
				<a class="next_page" rel="next">下页</a>
			<#else>
				<a href="javascript:getJsonInfo2('${actionUrl}?page=#{currentPage + 1}${urlParas!}')" class="next_page" rel="next">下页</a>
			</#if>
		</div>
	</div>
</#macro>

</body>
</html>