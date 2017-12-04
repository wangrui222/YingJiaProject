<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<#include '../common/base.html'>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="renderer" content="webkit">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${base}/resources/sys/ying/iconfont.css">
        <link rel="stylesheet" href="${base}/resources/sys/style/bootstrap.css">
        <link rel="stylesheet" href="${base}/resources/sys/style/style.css">
        <script type="text/javascript" src="${base}/resources/sys/js/jquery.js"></script>
        <title>后台首页</title>
    </head>
    <body>
    <div class="box-right-main">
        <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>预约记录</h2>

        <div class="tablelist">
            <table class="table table-bordered tablebox">
                <tr class="text-center" bgcolor="#f7f7f7">
                    <td>序号</td>
                    <td>姓名</td>
                    <td>联系电话</td>
                    <td>地址</td>
                    <td>状态</td>
                    <td>签署拍照图</td>
                    <td>查看文档</td>
                    <td>预约时间</td>
                    <td>操作</td>
                </tr>
                <#list pageInfo.list as s>
                    <tr class="text-center">
                        <td>${s_index+1}</td>
                        <td>${(s.name)!!}</td>
                        <td>${s.phone!!}</td>
                        <td>${s.addr!!}</td>
                        <td><#if s.status=1>
                                <span style="color: green;">${s.statusDesc!!}</span>
                            <#else>
                                <span style="color: red;">${s.statusDesc!!}</span>
                            </#if></td>
                        <td>
                            <#if s.status=0>
                                ——
                            <#else>
                                <a href="${base}/${(s.signedPhotos)!!}" target="_black">查看</a>
                            </#if>
                        </td>
                        <td><#if s.status=1>
                               <a href="${base}/${(s.comment)!!}" target="_black">私募合同</a>
                                |
                               <a href="${base}/${(s.riskReveal)!!}" target="_black">风险揭示书</a>
                            <#else>
                                ——
                            </#if>
                        </td>
                        <td>${s.createDate?string('yyyy/MM/dd HH:mm:ss')}</td>
                        <td><#if s.status=2>
                            <a class="btn btn-primary btn-sm"
                               href="${base}/financeProductFunds/addContractView/${s.id}">签署</a>
                            <a class="btn btn-primary btn-sm"
                               href="${base}/financeProductFunds/signedError/${s.id}" onclick="return confirm('你确定要签署失败?')">签署失败</a>
                            <#else>
                               	 <a class="btn btn-primary btn-sm"
                               href="javascript:" disabled="disabled">${s.statusDesc!!}</a>
                            </#if>
                        </td>
                    </tr>
                </#list>
            </table>
        </div>
        <#include "../common/paginate.html" />
        <@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="${base}/financeProductFunds/financeProductSubscribe" urlParas="&financeProductFundsId=${financeProductFundsId}"/>
        <!-- 内容结束 -->
    </div>
    <!-- 容器结束 -->
    </body>
</html>