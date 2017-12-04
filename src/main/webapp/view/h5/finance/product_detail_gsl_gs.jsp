<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no,minimal-ui" />
<meta charset="utf-8">
<#include '../../common/base.html'>
<link href="${base}/resources/mobileapi/css/base.css" type="text/css" rel="stylesheet">
<link href="${base}/resources/mobileapi/css/mui.min.css" type="text/css" rel="stylesheet">
<link href="${base}/resources/mobileapi/css/css.css" type="text/css" rel="stylesheet">
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
            alpha += 5;
            alpha > 100 && (alpha = 100);
            tabConLi[index].style.opacity = alpha / 100;
            tabConLi[index].style.filter = "alpha(opacity=" + alpha + ")";
            alpha == 100 && clearInterval(timer);
        },
        2)
    }
}
</script>
</head>
<body>
<div class="info">
	<h2 class="Tit">${(product.name)!!}</h2>
    <ul class="yqTable bor5">
    	<li class="first" style="border:none"><span class="mt0"><em>${(product.yearRate-1)?string('#.0')}</em>+1.0%</span>&nbsp;&nbsp;年利率</li>
        <li class="last" style="border:none;"><span>${(product.period)!!}</span>天</li>
    </ul>
    <ul class="countTab">
    	<li class="first">${(product.floorAmount)!!}元起投</li>
        <li>${(hasBought)!!}人已购</li>
        <li class="last"><#if (hasSold>100000)>
							${(hasSold/10000)!!}万元
						<#else>
							${(hasSold)!!}元
						</#if>已投</li>
    </ul>
</div>
<ul class="syjj">
	<li class="first">收益简述</li>
    <li class="last"><p>每万元投资收益<span>${(gotPerTenK)!!}元</span></p><p>计息日期：购买后当天计息</p></li>
</ul>
<ul class="tabNav">
	<li class="active"><a href="javascript:;">产品速览</a></li>
	<li><a href="javascript:;">项目详情</a></li>
    <li><a href="javascript:;">安全保障</a></li>
</ul>
<ul class="tabCon">
	<li class="tabConLi" style="display:block"><p>${(product.comment)!!}</p></li>
	<li class="tabConLi"><p>${(product.projectDetails)!!}</p></li>
    <li class="tabConLi">
    	<h2 class="safeTit">担保方式<span>${product.safeguardWay.description}</span></h2>
        <h3>担保方介绍</h3>
        <p>${(product.safetyControl)!!}</p>
    </li>
</ul>
<#if (product.status.ordinal()==1)>
	<a class="yyBtn" href="javascript:void(0);" onClick="goSubmitOrder();">我要投资</a>
 <#else>
	<a class="yyBtn" href="javascript:void(0);" style="background-color: #848080;">已售罄</a>
</#if>
<script src="${base}/resources/mobileapi/js/mui.min.js"></script>
<script src="${base}/resources/mobileapi/js/mui.previewimage.js"></script>
<script src="${base}/resources/mobileapi/js/mui.zoom.js"></script>
<script>
mui.previewImage();
	function goSubmitOrder() {
		var myAppName = 'YingJia';
		var id="${product.id}";
		var type="GUSHOU";
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
</body>
</html>
