<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="adminLeft">
    <h2>我的投资</h2>
    <ul>
        <li><a id="member_center_menu_invests" href="${base}/account/touZiList"><em class="iconfont red">&#xe602;</em>投资记录</a></li>
        <li><a id="member_center_menu_profit_record" href="${base}/account/trades/profit/records"><em class="iconfont red">&#xe616;</em>收益记录</a></li>
        <li><a id="member_center_menu_deposit_record" href="${base}/account/deposit/records"><em class="iconfont red">&#xe616;</em>充值记录</a></li>
        <li><a id="member_center_menu_withdraw_record" href="${base}/account/withdraw/records"><em class="iconfont red">&#xe616;</em>提款记录</a></li>
        <li><a id="member_center_menu_bbinInfo_record" href="${base}/account/bbinInfo/records"><em class="iconfont red">&#xe616;</em>体验金记录</a></li>
    </ul>
    <h2>我的账户</h2>
    <ul>
        <li><a id="member_center_menu_deposit" href="${base}/account/deposit"><em class="iconfont">&#xe614;</em>账户充值</a></li>
        <li><a id="member_center_menu_security" href="${base}/account/security"><em class="iconfont">&#xe612;</em>安全信息</a></li>
        <li><a id="member_center_menu_withdraw" href="${base}/account/withdraw"><em class="iconfont">&#xe612;</em>我要提款</a></li>
        <li><a id="member_center_menu_financial" href="${base}/account/financial"><em class="iconfont">&#xe612;</em>我是理财师</a></li>
    </ul>
</div>
<script>
  var menu_item="${member_center_menu_tick!}";
 $("#"+menu_item).addClass("select");
</script>


</body>
</html>