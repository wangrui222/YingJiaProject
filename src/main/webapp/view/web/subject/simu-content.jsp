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
	<title>我的加法库 - 盈+</title>
	<#include '../common/resources.html'>
    <script type="text/javascript" src="<%=basePath%>resources/web/location/area.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/web/location/location.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		showLocation();
	});
	</script>
</head>
<body>
	<#include "../common/top.html">
    <div class="sdbanner probanner"></div>
    <div class="proMain">
    	<div class="conTit">
        	<span><a style="color:#9d8440;" href="<%=basePath%>finance">其他标的</a></span>
        	<h2><em>￥</em>${(product.name)!!}</h2>
        </div>
        <table class="conTable" width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="txtInfo">
            	<div class="txt2">
                	<h2>${(product.yearRate)!!}%</h2>
                    <p>预期收益</p>
                </div>
            	<div class="txt1">
                	<h2>${(product.period)!!}</h2>
                    <p>期限(天)</p>
                </div>
                <div class="txt3">
                	<h2>${(product.floorAmount)!!}</h2>
                    <p>起投金额(元)</p>
                </div>
            </td>
            <td width="360" align="center"; valign="middle" height="320">
            	<div class="tbBox">
            	<div class="li4" style=""><span id="checkmoney" style="color: red;"></span></div>
            	<#if !(memberInfo??)><a href="<%=basePath%>web/login">登录</a>后可见</#if>
                    <p><input class="txt" name="name" type="text" value="" placeholder="请输入姓名"></p>
                    <p><input class="txt" name="phone" type="text" value="" placeholder="请输入电话号码"></p>
                    <p class="pSelect">
                    	<span class="select1 fl">
							<select id="loc_province" ></select>
                        </span>
                        <span class="select2 fr">
                            <select id="loc_city" ></select>
                        </span>
                         <input type="hidden" name="location_id"  id="location_id"/>
                    </p>
                    <#if (product.status==1)&&(compareDate==false)>
                    	<button class="submit">投资预约</button>
                   <#else>
                   		<button disabled="disabled" style="background-color: #848080;">已售罄</button>
                   </#if>
                    <div class="phone"><span>4000-999-158</span>7X24小时咨询电话</div>
                </div>
            </td>
          </tr>
        </table>
        <div class="tbConBox">
        	<div class="tab">
            	<a class="select" href="#1">基金专题</a>
                <a href="#1">基金经理</a>
                <a href="#1">产品策略</a>
                <a href="#1">产品要素</a>
            </div>
            <div id="conBox">
                <div class="box" style="display:block">
                      ${(product.productTopic)!!}        
                </div>
                <div class="box">
                	<table width="70%" class="lcrInfo" border="0" cellspacing="0" cellpadding="0">
						<tr><td><img class="rwImg" width="150" height="150" src="<%=basePath%>${(product.productManagerPic)!!}"></td></tr>
						<tr><td><h2>${(product.productManagerName)!!}</h2></td></tr>
						<tr><td><h4>${(product.productManagerTitle)!!}</h4></td></tr>
						<tr><td><h3>${(product.productManagerDesc)!!}</h3></td></tr>
						<tr><td><p>${(product.productManager)!!}</p></td></tr>
					</table>
                </div>
                 <div class="box">
                     ${(product.productStrategy)!!}   
                </div>
                 <div class="box">
                     ${(product.productFactor)!!}   
                </div>
            </div>
        </div>
    </div>

    <#include "../common/footer.html">
</body>
<script type="text/javascript">
	$(function(){

		$(".tbConBox .tab a").click(function(){
			if(!$(this).hasClass("select")){
				var num=$(this).index();
				$(this).addClass("select").siblings().removeClass("select");
				$("#conBox .box").eq(num).show().siblings().hide();
			}
		});
		
		$(":input").focus(function () {
            $(".li4").hide();
        });
		
		var exists = false;
		var authBankCard=false;
        <#if authBankCard??>
        	<#if authBankCard>
        		authBankCard=true;
        	</#if>
        </#if>
        <#if memberInfo??>
            exists = true;
            $(".submit").click(function(){
            	 if (exists == false) {
                     $("#checkmoney").html("请先登陆!");
                     $(".li4").show(100);
                     return false;
                 }
                 if(authBankCard==false){
                 	$("#checkmoney").html("请先绑定银行卡，<a href='<%=basePath%>account/security/memberBankcardView'>绑卡</a>");
                     $(".li4").show(100);
                 	return false;
                 }
	   			 var loc_province = $("#loc_province").find("option:selected").text();
	   		     var loc_city = $("#loc_city").find("option:selected").text();
	   		     var cardaddress=loc_province+"-"+loc_city;
	   		     if($("input[name='name']").val()==''){
	   		    	 $("#checkmoney").html("请输入姓名");
	   		    	 $(".li4").show(100);
	   		    	 return false;
	   		     }
	   		     if($("input[name='phone']").val()==''){
	   		    	 $("#checkmoney").html("请输入电话");
	   		    	 $(".li4").show(100);
	   		    	 return false;
	   		     }
	   		     if(loc_province=="省份"){
	   		        $("#checkmoney").html("请选择省份");
	   		     	$(".li4").show(100);
	   		        return false;
	   		     }
	   		     if(loc_city=="地级市"){
	   		    	$("#checkmoney").html("请选择地级市");
	   		    	$(".li4").show(100);
	   		        return false;
	   		     }
	   		     $("#location_id").val(cardaddress);
		   		  $.ajax({
		                type: "POST", // 用POST方式传输
		                dataType: "json", // 数据格式:JSON
		                async: true,
		                url: '<%=basePath%>finance/addfinance', // 目标地址
		                data: {
		                	productId: ${product.id},
		                	name: $("input[name='name']").val(),
		                	phone:$("input[name='phone']").val(),
		                	location_id:cardaddress
		                },
		                success: function (msg) {
		                    if (msg.code == 0) {
                                layer.open({
                                    type: 1,
                                    title: ['', 'background:#fff'],
                                    skin: '',
                                    area: ['406px', '466px'],
                                    content: '<div class="dialogs">' +
                                    '<img src="<%=basePath%>resources/web/images/dialog_ico.png"/><h1>预约申请成功</h1>'+
                                    '<a type="button" href="<%=basePath%>h5/v1/financeContract/${product.id}" target="_black">合同建档成功，等待签署</a><div class="hrs"><font>银行账户</font></div><p>招商银行杭州湖墅支行</p>'+
                                    '<p>5719 0815 9410 801</p><p style="margin-top:20px">户名：杭州吉威投资管理有限公司</p></div>'
                                });
		                    } else {
		                    	$("#checkmoney").html(msg.msg);
		                    	$(".li4").show(100);
		    	   		        return false;
		                    }
		                }
		            });
	   		});
       <#else>
            $(".submit").click(function () {
                if (exists == false) {
                    $("#checkmoney").html("请先登陆!");
                    $(".li4").show(100);
                    return false;
                }
            });
        </#if>    
		
	});
		
        
</script>
</html>