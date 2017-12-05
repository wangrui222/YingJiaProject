<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no,minimal-ui" />
<meta charset="utf-8">
    <link href="<%=basePath%>resources/mobileapi/css/base.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>resources/mobileapi/css/mui.min.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>resources/mobileapi/css/css.css" type="text/css" rel="stylesheet">
<title>盈加-海外配置</title>
</head>
<body>
<div>
	${(overseaConfig.content)!!}
</div>
<#if (overseaConfig.status==1)&&(compareDate==false)>
	<a class="yyBtn" href="javascript:void(0);" onClick="goSubscribe();">投资预约</a>
<#else>
	<a class="yyBtn" href="javascript:void(0);" style="background-color: #848080;">已售罄</a>
</#if>
</body>
<script src="<%=basePath%>resources/mobileapi/js/mui.min.js"></script>
<script src="<%=basePath%>resources/mobileapi/js/mui.previewimage.js"></script>
<script src="<%=basePath%>resources/mobileapi/js/mui.zoom.js"></script>
<script>
    mui.previewImage();
    function goSubscribe() {
        var myAppName = 'YingJia';
        var id="${overseaConfig.id}";
        var type="OVERSEA";
        var ua = navigator.userAgent;
        if (ua.match(/iPhone|iPod/i) != null) {
            var myActionType = 'IOS';
            var url =myAppName + '://' + myActionType + "/"+id+"/"+type;
            document.location.href = url;
        } else {
            var myActionType = 'Android';
            main.callback(myAppName,myActionType,id,type);
        }
    }
</script>
</html>
