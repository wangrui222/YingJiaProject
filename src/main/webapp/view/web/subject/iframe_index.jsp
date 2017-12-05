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
 <div class="gjList clearfix">
        	<ul>
        	<#list pageInfo.list as s>
            	<#if s.type=='SIMU'>
                    <li>
                        <a class="all"  target="_blank" href="${base}/finance/financeView/${s.id}">
                            <h2 class="tit"><span>募</span>${(s.name)!!}</h2>
                            <span class="fenl">私募</span>
                            <div class="count">
                                <span class="s1"><b>${(s.yearRate)?string('0.0')!!}</b>%</span>
                                <span class="s2"><b>${(s.period)!!}</b>天</span>
                                <span class="s3">年化收益</span>
                                <span class="s4">投资期限</span>
                                <span class="s5">/</span>
                            </div>
                            <p class="safe">
                                起购金额：1111111111111111元<br/>
                                <span>;</span>
								<#if financialStatus??>
									<#if financialStatus><a class="fyblTxt" href="#1">返佣比例：${(pr.ratio)!!}%</a></#if>
								</#if>
                            </p>
                            <p class="txt" style="height: 72px;">
							精品私募
                            <p class="abox"><span class="abtn">立即购买</span></p>
                        </a>
                    </li>
				<#else>
                    <li>
                        <a class="all"  target="_blank" href="${base}/finance/financeView/${s.id}">
                            <h2 class="tit"><span>募</span>${(s.name)!!}</h2>
                            <span class="fenl">股权</span>
                            <div class="count">
                                <span class="s1"><b>${(s.yearRate-1)?string('0.0')!!}</b>+1.0%</span>
                                <span class="s2"><b>${(s.buyerCount)!!}</b>人</span>
                                <span class="s3">年化收益</span>
                                <span class="s4">已购人数</span>
                                <span class="s5">/</span>
                            </div>
                            <p class="safe">
                                起购金额：1111111111111111元<br/>
                                <span></span>
								<#if financialStatus??>
									<#if financialStatus><a class="fyblTxt" href="#1">返佣比例：${(s.ratio)!!}%</a></#if>
								</#if>
                            </p>
                            <p class="txt" style="height: 72px;">
								管理人：${(s.productManagerName)!!}
                            <p class="abox"><span class="abtn">立即购买</span></p>
                        </a>
                    </li>
            	</#if>
             </#list>
            </ul>
        </div>

</body>
</html>