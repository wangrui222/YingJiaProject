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
<div class="logo container">
    <div class="row">
        <div class="logoImg">
            <a target="_parent"  href="http://www.ying158.com/home"><img src="${base}/resources/web/images/logo2.png" onmouseover="this.src = '${base}/resources/web/images/logo1.png'" onmouseout="this.src = '${base}/resources/web/images/logo2.png'"></a>
        </div>
        <div class="telInfo">
            <img src="${base}/resources/web/images/400Icon.png" onmousemove="this.src = '${base}/resources/web/images/400IconActive.png'" onmouseout="	this.src = '${base}/resources/web/images/400Icon.png'">
            <div class="detail">

                <#if memberInfo??>
                    	<div style="font-size:16px;float:right;margin-top:5px;color:#917739;">  欢迎${(memberInfo.name)!!},<a target="_parent"  href="${base}/account/touZiList">[会员中心]</a>,<a target="_parent"  href="${base}/web/logout">[退出]</a></div>
                <#else>
                        <a style="font-size:18px;float:right;margin-top:5px;color:#917739;" target="_parent" href="${base}/web/login">登录</a>
                        <a style="font-size:18px;float:right;margin-right:15px;margin-top:5px;color:#917739;" target="_parent" href="${base}/web/regis">注册</a>
                </#if>
                <br>4000-999-158
            </div>
        </div>
    </div>
</div>
</body>
</html>