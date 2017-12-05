<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
	<#include "../common/base.html">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>账户充值-会员中心-盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
	<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
    <link href="<%=basePath%>resources/web/font/iconfont.css" rel="stylesheet">
    <script src="<%=basePath%>resources/web/js/jquery.js"></script>
    <script src="<%=basePath%>resources/web/js/bootstrap.js"></script>
    <script>
	$(function(){
		$(".picTab a").click(function(){
			if(!$(this).hasClass("select")){
				var num=$(this).index();
				$(this).addClass("select").siblings().removeClass("select");
				$(".txtCon p").eq(num).show().siblings().hide();
			}
		})
		$(".tbConBox .tab a").click(function(){
			if(!$(this).hasClass("select")){
				var num=$(this).index();
				$(this).addClass("select").siblings().removeClass("select");
				$("#conBox .box").eq(num).show().siblings().hide();
			}
		})
	})	
    </script>
</head>
<body>
<#include "admin-top.html">
	<div class="proMain clearfix">
		<#include "admin-left.html">
        <div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="javascript:;">充值结果</a>
             
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">
                        <div class="formBox">
                        	<div class="czbox">
								<table class="tzlist" width="300px" border="0" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
										<tr>
											<td width="40%">交易号：</td>
											<td>${record.serialNumber}</td>
										</tr>
										<tr>
											<td>充值金额：</td>
											<td>${record.amount}元</td>
										</tr>
										<tr>
											<td>支付方式：</td>
											<td>${record.payChannelNameDesc}</td>
										</tr>
										<tr>
											<td>充值结果：</td>
											<td>${record.statusDesc}</td>
										</tr>										
								</table>                        	
                     		                       	                        	
                        	</div>
                        </div>

                    </div>
                    
                </div>
            </div>
        </div>
    </div>
	<#include "../common/footer.html">


</body>
</html>