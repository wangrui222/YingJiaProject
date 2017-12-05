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
	<h2 class="Tit">${product.name}</h2>
	<div class="lineBox">
	    <ul class="yqTable bor5">
	    	<li class="first"><span class="mt0"><em>${(product.yearRate-1)?string('#.0')}</em>+1.0%</span>&nbsp;&nbsp;年利率</li>
	        <li class="last"><span>${product.period}</span>天</li>
	    </ul>
	    <div style="width:${(hasSold/product.amount*100)!!}%" class="line"></div>
    </div>
    <ul class="countTab">
    	<li class="first">${product.floorAmount}元起投</li>
        <li>${hasBought}人已购</li>
        <li class="last">剩<span>${(product.amount-hasSold)}</span>/${product.amount}元</li>
    </ul>
</div>

<ul class="syjj">
	<li class="first">收益简述</li>
    <li class="last"><p>每万元投资收益<span>${gotPerTenK}元</span></p><p>计息日期：募集满后第二天</p></li>
</ul>
<ul class="tabNav">
	<li class="active"><a href="javascript:;">产品速览</a></li>
	<li><a href="javascript:;">项目详情</a></li>
    <li><a href="javascript:;">安全保障</a></li>
    <li><a href="javascript:;">投资记录</a></li>
</ul>
<ul class="tabCon">
	<li class="tabConLi" style="display:block"><p>${(product.comment)!!}</p></li>
	<li class="tabConLi"><p>${(product.projectDetails)!!}</p></li>
    <li class="tabConLi">
    	<h2 class="safeTit">担保方式<span>${product.safeguardWay.description}</span></h2>
        <h3>担保方介绍</h3>
        <p>${(product.safetyControl)!!}</p>
    </li>
    <li class="tabConLi">
    		<div class="tabList">
				<#if purchaseList?has_content>
				<#list purchaseList as pr>
 				<dl>
 					<#if pr.member.name?has_content>
					<dd>${(pr.member.mobilePhone)?substring(0,3)}***</dd>
					<#else>
					<dd>******</dd>
					</#if>
					<dd>${(pr.amount)!!}</dd>
					<dd></dd>
				</dl> 
				</#list>
				</#if>
			</div>
   	</li>
</ul>

<#if (product.status.ordinal()==1) && (product.amount>hasSold) && (compareDate==false)>
	<a class="yyBtn" href="javascript:void(0);" onClick="goSubmitOrder();">我要投资</a>
 <#else>
	<a class="yyBtn" href="javascript:void(0);" style="background-color: #848080;">已售罄</a>
</#if>
<script src="<%=basePath%>resources/mobileapi/js/mui.min.js"></script>
<script src="<%=basePath%>resources/mobileapi/js/mui.previewimage.js"></script>
<script src="<%=basePath%>resources/mobileapi/js/mui.zoom.js"></script>
<script>
mui.previewImage();
function goSubmitOrder() {
    var myAppName = 'YingJia';
    var id="${product.id}";
    var type="P2PCHE";
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
