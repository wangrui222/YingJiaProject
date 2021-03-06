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
        <#list pageInfo.list as pr>
            <#if pr.type=='GUQUAN'>
                <ul class="tbList">
                    <li class="first">
                        <span class="ico jp"></span>
                        <h2><b>${(pr.name)!!}</b></h2>
                        <i></i>
                    </li>
                    <li class="second">
                        <div class="txt1" style="width:115px; margin-left:40px;">
                            <h2>${(pr.yearRate)!!}%</h2>
                            <p>年化收益</p>
                        </div>
                        <div class="txt2" style="width:120px;margin-left:40px;">
                            <h2>${(pr.floorAmount)!!}</h2>
                            <p>起购金额(元)</p>
                        </div>
                    </li>
                    <li class="six three" style="width:290px;">
                        <p>已购人数：${(pr.buyerCount)!!}人
                            <#if financialStatus??>
                                <#if financialStatus><a class="fyblTxt" href="#1">返佣比例${(pr.ratio)!!}%</a></#if>
                            </#if>
                            <br>
                            管理人：${(pr.productManagerName)!!}<br>
                            投资方向：${(pr.investPoints)!!}
                        </p>
                    </li>
                    <li class="five"><a class="abtn" href="<%=basePath%>finance/financeView/${pr.id}">购买</a></li>
                </ul>
                <#elseif pr.type=='SIMU'>
                    <ul class="tbList">
                        <li class="first">
                            <span class="ico jp"></span>
                            <h2><b>${(pr.name)!!}</b></h2>
                            <i></i>
                        </li>
                        <li class="second" style="width:630px;">
                            <div class="txt1">
                                <h2>${(pr.yearRate)!!}%</h2>
                                <p>年化收益</p>
                            </div>
                            <div class="txt2">
                                <h2>${(pr.period)!!}</h2>
                                <p>期限(天)</p>
                            </div>
                            <div class="txt2">
                                <h2>${(pr.floorAmount)!!}
                                    <#if financialStatus??>
                                        <#if financialStatus><a class="fyblTxt" href="#1">返佣比例${(pr.ratio)!!}%</a></#if>
                                    </#if>
                                </h2>
                                <p>起购金额(元)</p>
                            </div>

                        </li>
                        <li class="five"><a class="abtn" href="<%=basePath%>finance/financeView/${pr.id}">购买</a></li>
                    </ul>
            </#if>
        </#list>
        <!-- 异步内容结束 -->
        <#include "ajax_paginate.html" />
        <@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
        actionUrl="<%=basePath%>finance/financeAjax"/>
    </div>
    <script type="text/javascript">
        function getJsonInfo(url) {
            $.get(url, 'json', function (data) {
                $(".ajaxContainer").empty();
                $(".ajaxContainer").append(data);
            });
        }
    </script>
</body>
</html>