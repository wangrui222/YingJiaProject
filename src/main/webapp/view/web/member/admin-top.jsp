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
<table height="160" class="peopleInfo" width="970" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td align="left" valign="middle" class="info">
            <a href="<%=basePath%>account/security">
                <div class="img"><img src="<%=basePath%>resources/web/images/userPic.jpg"></div>
                <h2>${(memberInfo.name)!!}，<span>您好!</span></h2>
            </a>
            <div class="safe">账户安全&nbsp;&nbsp;<span class="scroll"><em style="width:${memberInfo.securityProgress.progressVal}%"></em></span></div>
            <ul class="listIco iconfont">
                <li class="${memberInfo.securityProgress.realName?string('active','')}"><a href="#1">&#xe61c;</a><em>&#xe61b;</em></li>
                <li class="${memberInfo.securityProgress.mobilePhone?string('active','')}"><a href="#1">&#xe61d;</a><em>&#xe61b;</em></li>
                <!-- <li class="${memberInfo.securityProgress.email?string('active','')}"><a href="#1">&#xe61f;</a><em>&#xe61b;</em></li> -->
                <li class="${memberInfo.securityProgress.loginPwd?string('active','')}"><a href="#1">&#xe61a;</a><em>&#xe61b;</em></li>                                
                <li class="${memberInfo.securityProgress.withdrawPwd?string('active','')}"><a href="#1">&#xe61e;</a><em>&#xe61b;</em></li>
            </ul>
        </td>
        <td align="right">
            <a href="<%=basePath%>web/logout" class="loginOut"><span class="iconfont">&#xe618;</span>安全退出</a>
        </td>
    </tr>
</table>
<div class="countBox">
    <ul>
        <li><h2>${(memberAccount.useableBalance)!(memberInfo.account.useableBalance)}</h2><p>账户可用余额(元)<a href="javascript:;" class="iconfont">&#xe619;<span>账户可用余额</span><i></i></a></p></li>
        <li><h2>${(memberAccount.useableBalance+memberAccount.investAmount+memberAccount.totalProfit)!(memberInfo.account.useableBalance+memberInfo.account.investAmount+memberInfo.account.totalProfit)}</h2><p>账户总资产(元)<a href="javascript:;" class="iconfont">&#xe619;<span>可用余额+投资金额+累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">${(memberAccount.investAmount)!(memberInfo.account.investAmount)}</h2><p>投资金额(元)<a href="javascript:;" class="iconfont">&#xe619;<span>投资中资金</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">${(memberAccount.totalProfit)!(memberInfo.account.totalProfit)}</h2><p>累计收益(元)<a href="javascript:;" class="iconfont">&#xe619;<span>累计收益</span><i></i></a></p></li>
        <li><h2 style="color:#9d8440">${(memberAccount.imusealeBalance)!(memberInfo.account.imusealeBalance)}</h2><p>冻结金额(元)<a href="javascript:;" class="iconfont">&#xe619;<span>提现冻结金额</span><i></i></a></p></li>
    </ul>
    <a href="<%=basePath%>account/deposit" class="cz">充值</a>
    <a href="<%=basePath%>account/withdraw" class="tk">提款</a>
</div>
</body>
</html>