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
<title>盈加APP</title>
<script>
window.onload=function(){
	var tabLi= document.getElementsByClassName("tabNav")[0].getElementsByTagName("li");
	var tabConLi= document.getElementsByClassName("tabCon")[0].getElementsByClassName("tabConLi");
	var oImg=document.getElementsByClassName("tabCon")[0].getElementsByTagName("img");
	
	for(i=0;i<oImg.length;i++){
		oImg[i].setAttribute("data-preview-src", "");
	}
	var timer = null;
	for(i=0;i<tabLi.length;i++){
		tabLi[i].index = i;
		tabLi[i].onclick=function(){
			show(this.index)
		}
	}
	function show(a) {
        index = a;
        var alpha = 0;
        for (var j = 0; j < tabConLi.length; j++) {
            tabLi[j].className = "";
            tabConLi[j].style.opacity = 0;
			tabConLi[j].style.display='none';
            tabConLi[j].style.filter = "alpha(opacity=0)";
        }
        tabLi[index].className = "tabConLi active";
		tabConLi[index].style.display='block';
        clearInterval(timer);
        timer = setInterval(function() {
            alpha += 1;
            alpha > 100 && (alpha = 100);
            tabConLi[index].style.opacity = alpha / 100;
            tabConLi[index].style.filter = "alpha(opacity=" + alpha + ")";
            alpha == 100 && clearInterval(timer);
        },
        3)
    }
}
</script>
</head>
<body>
<div class="info">
	<h2 class="Tit">${product.name}</h2>
	<div class="lineBox">
	    <ul class="yqTable">
	    	<li class="first">预期收益<span><em>${product.yearRate-1}</em>+1.00%</span></li>
	        <li class="last">起投资金<span>${product.floorAmount/10000}</span>万</li>
	    </ul>
	    <div style="width:${product.soldAmount/product.amount*100}%" class="line"></div>
    </div>
    <p class="money"><span>${product.soldAmount/10000}万/${product.amount/10000}万</span>${product.buyerCount}人已购</p>
    <p class="peoInfo">管理人：<span>${product.productManagerName}</span></p>
    <p class="peoInfo">投资方向：<span>${product.investPoints}</span></p>
    <p class="peoInfo">开始日期：<span>11</span></p>
    <p class="peoInfo">结束日期：<span>11</span></p>
</div>
<ul class="tabNav">
	<li class="active"><a href="javascript:;">关于基金</a></li>
    <li><a href="javascript:;">产品要素</a></li>
</ul>
<ul class="tabCon">
	<li class="tabConLi" style="display:block"><p>${product.productTopic}</p></li>
    <li class="tabConLi">
    	<p>${product.productFactor}</p>
    </li>
</ul>
<#if (product.status==1) && (product.amount>product.soldAmount) && (compareDate==false)>
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
    var id="${product.id}";
    var type="GUQUAN";
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
