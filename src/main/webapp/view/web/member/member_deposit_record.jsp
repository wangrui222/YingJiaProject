<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
    <#include "../common/base.html">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>充值记录-会员中心-盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="${base}/resources/web/css/common.css" rel="stylesheet">
	<link href="${base}/resources/web/css/jw.css" rel="stylesheet">
    <link href="${base}/resources/web/font/iconfont.css" rel="stylesheet">
    <script src="${base}/resources/web/js/jquery.js"></script>
    <script src="${base}/resources/web/echart/dist/echarts.js"></script>
</head>
<body>
<#include "../common/top.html">
<#include "admin-top.html">
    <div class="proMain clearfix">
        <#include "admin-left.html">
        <div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="javascript:;">充值记录</a>
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">

                        <#include "member_deposit_his_list.html">
                             
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "../common/footer.html">
</body>
</html>