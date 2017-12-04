<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#macro paginate currentPage totalPage actionUrl urlParas="">
	<#if (totalPage <= 0) || (currentPage > totalPage)><#return></#if>
	<#local startPage = currentPage - 4>
	<#if (startPage < 1)><#local startPage = 1></#if>
	
	<#local endPage = currentPage + 4>
	<#if (endPage > totalPage)><#local endPage = totalPage></#if>
	
	<div class="llpage">
		<div class="in">
			<nav>
				<span class="count">第&nbsp;<b>#{currentPage}</b>&nbsp;页，&nbsp;共&nbsp;<b>#{totalPage}</b>&nbsp;页</span>
				<ul class="pagination">
					<#if (currentPage <= 8)>
						<#local startPage = 1>
					</#if>
					<#if ((totalPage - currentPage) < 8)>
						<#local endPage = totalPage>
					</#if>

					<#if (currentPage == 1)>
						<li><a class="prev_page">上页</a></li>
					<#else>
						<li><a href="${actionUrl}?page=#{currentPage - 1}${urlParas!}" class="prev_page">上页</a></li>
					</#if>

					<#if (currentPage > 8)>
						<li><a href="${actionUrl}?page=#{1}${urlParas!}">#{1}</a></li>
						<li><a href="${actionUrl}?page=#{2}${urlParas!}">#{2}</a></li>
						<span class="gap">…</span>
					</#if>

					<#list startPage..endPage as i>
						<#if currentPage == i>
							<li><a class="now" >#{i}</a></li>
						<#else>
							<li><a href="${actionUrl}?page=#{i}${urlParas!}">#{i}</a></li>
						</#if>
					</#list>

					<#if ((totalPage - currentPage) >= 8)>
						<span class="gap">…</span>
						<li><a href="${actionUrl}?page=#{totalPage - 1}${urlParas!}">#{totalPage - 1}</a></li>
						<li><a href="${actionUrl}?page=#{totalPage}${urlParas!}">#{totalPage}</a></li>
					</#if>

					<#if (currentPage == totalPage)>
						<li><a class="next_page" rel="next">下页</a></li>
					<#else>
						<li><a href="${actionUrl}?page=#{currentPage + 1}${urlParas!}" class="next_page" rel="next">下页</a></li>
					</#if>
				</ul>
			</nav>
		</div>
	</div>
</#macro>
