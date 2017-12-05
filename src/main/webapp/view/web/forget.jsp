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
	<title>忘记密码 - 盈+</title>
	<#include 'common/resources.html'>
</head>
<body>
<#include "common/top.html">
    <div class="proMain">
    	<div class="container">
            <div class="row register">
                <div class="title">
                    <div class="left">
                        <hr>
                    </div>
                    <div class="mid">
                        重设密码
                    </div>
                    <div class="right">
                        <hr>
                    </div>
                </div>
                <div class="item">
                    <div class="rLabel">
                        手机号
                    </div>
                    <div class="rInput">
                        <input placeholder="请输入手机号" id="phone" name="phone" class="form-control textInput phone" type="text"><span class="errorInfo">手机号码不能为空</span>
                    </div>
                </div>
                <div class="item">
                    <div class="rLabel">
                        验证码
                    </div>
                    <div class="rInput">
                        <input placeholder="请输入验证码" id=vCode name="code" class="form-control textInput code" type="text"><button class="btn vCodeBtn" onclick="sendMessage(60)" id="btnSendCode">获取验证码</button><span class="errorInfo"></span>
                    </div>
                </div>
                 <div class="item">
                    <div class="rLabel">
           输入新密码     
                    </div>
                    <div class="rInput">
                        <input placeholder=" 输入新密码" id="password" name="password" class="form-control textInput password" type="password"><span class="errorInfo">手机号码不能为空</span>
                    </div>
                </div>
                 <div class="item">
                    <div class="rLabel">
                        确认新密码
                    </div>
                    <div class="rInput">
                        <input placeholder="确认新密码" id="password2" name="password2" class="form-control textInput password2" type="password"><span class="errorInfo">手机号码不能为空</span>
                    </div>
                </div>
                <div class="item">
                    <div class="rLabel">
                        &nbsp;
                    </div>
                    <div class="rInput">
                        <button class="btn registBtn submit" id="checkCode">重设密码</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript" src="<%=basePath%>resources/web/js/forget.js"></script>
<script type="text/javascript">
$(function(){
	var b = "${base}";
	forget(b);
});
</script>
<#include "common/footer.html">
</body>
</html>