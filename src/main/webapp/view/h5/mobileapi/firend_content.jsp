<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>盈+好友邀请</title>
<link href="<%=basePath%>resources/mobileapi/css/base.css" type="text/css" rel="stylesheet">
<link href="<%=basePath%>resources/mobileapi/css/css.css" type="text/css" rel="stylesheet">
<link href="<%=basePath%>resources/mobileapi/font/iconfont.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>resources/sys/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
    var tipBox = $(".tipBox"),
		mask = $(".mask");
    var ua = navigator.userAgent.toLowerCase();

    function is_weixin() {
        if (ua.match(/MicroMessenger/i) == "micromessenger") {
            return true;
        } else {
            return false;
        }
    }
    $('.aTxt').click(function () {
        if (/iphone|ipad|ipod/.test(ua)) {
            if (is_weixin()) {
            	alert("请在浏览器中打开");
            }
            else {
                window.location.href = "<%=basePath%>download/app/ios";
            }
        }
        else if (/android/.test(ua)) {
            if (is_weixin()) {
            	alert("请在浏览器中打开");
            }
            else {
                window.location.href = "../../../../resources/app/YingJia.apk";
            }
        }

    });

    mask.click(function () {
        tipBox.css({ "display": "none" });
        mask.css({ "display": "none" });
        tipBox.animate({ "height": "0px" });
    });
})	
</script>
</head>
<body>

<div class="firendPic"><img width="100%" src="<%=basePath%>resources/mobileapi/images/hyPic.jpg"></div>
<div class="yqmBox">
    <ul class="yqmTable">
        <li class="first" style="border-radius: 0.6rem;"><p style="font-size:2rem;line-height:5rem">邀请码：${(invitationCode)!!}</p></li>  
    </ul>
</div>
<div class="yqmBox">
<ul class="logo">
	<li><img src="<%=basePath%>resources/mobileapi/images/yjLogo.png"></div></li>
</ul>
<a class="aTxt apple" href="javascript:" ><span class="iconfont">&#xe60b;</span>IOS版本下载</a>
<a class="aTxt andour" href="javascript:"><span class="iconfont">&#xe60a;</span>安卓版本下载</a>
</div>
</body>
</html>
