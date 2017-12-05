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
	<title>订单详情 - 盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="${base}/resources/web/css/common.css" rel="stylesheet">
    <link href="${base}/resources/web/font/iconfont.css" rel="stylesheet">
	<link href="${base}/resources/web/css/jw.css" rel="stylesheet">
</head>
<body>
<#include "../common/top.html">
    <div class="sdbanner probanner"></div>
    <div class="proMain">
    	<div class="orderBox">
        	<div class="title"><h2><span class="iconfont">&#xe606;</span>订单详情</h2></div>
            <div class="order">
            	<img src="${base}/resources/web/images/orderPic.jpg">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  
                   <tr>
                    <td width="54%"  align="right"><span>产品名称：&nbsp;</span></td>
                    <td>${subjectName!!}</td>
                  </tr>
                  <tr>
                    <td align="right"><span>投资金额：&nbsp;</span></td>
                    <td><b>${totalFee}</b>元</td>
                  </tr>
                
                  <tr>
                    <td align="right"><span>年化收益率：&nbsp;</span></td>
                    <td><b>${yearRate}</b>%</td>
                  </tr>
                  <tr>
                    <td align="right"><span>借款周期：&nbsp;</span></td>
                    <td><b>${period}</b>天 </td>
                  </tr>
                </table>
            </div>
            <table class="orderInfo" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><p>订单编号：<b>${tradeNo}</b></p><p>订单时间：${date?string("yyyy年MM月dd日 HH时mm分")}</p></td>
                <td align="right">
                	<div class="money">
                    	<b>11111111111111</b>
                        <span>应付总金额(元)</span>
                    </div>
                    </td>
                  <td width="150px">
					<form action="${base}/subjectPur/orderEnsure/${tradeNo}" method="post" class="hiddenForm">
                        <input type="hidden" name="bbinStatus" value="${(bbinStatus)!!}">
                		<button class="tybutton">立即付款</button>
					</form>
                </td>
              </tr>
            </table>
        </div>
    </div>
	<#include "../common/footer.html">
</body>
<script src='${base}/resources/dist/js/jquery.min.js'></script>
<script src='${base}/resources/js/jquery.form.js'></script>
<script type="text/javascript">
    $(function () {
        $(".hiddenForm").ajaxForm(function (url) {
            if(url.code==0){
               alert(url.msg);
               location="${base}/subject/subjectContent/${subjectId}?showTab=list"
            }else{
            	alert(url.msg);	
            }
        });
    });
</script>
</html>