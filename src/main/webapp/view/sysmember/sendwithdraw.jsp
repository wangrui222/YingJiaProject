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
	<title>注册 - 盈+</title>
	<#include '../web/resources.html'>
	<script type="text/javascript">
function submitForm(){
document.getElementById("form").submit();
}
</script>
</head>
<body onload="javascript:submitForm();">
 <form name="pay" method="post" action="${(fuiouwithdraw)!!}" id = "form">
<input type="hidden" value = '${(merid)!!}' name="merid"/>
<input type="hidden" value = '${(reqtype)!!}' name="reqtype"/>
<input type="hidden" value = '${(xml)!!}' name="xml"/>
<input type="hidden" value = '${(mac)!!}' name="mac"/>
</form>
</body>
</html>l>