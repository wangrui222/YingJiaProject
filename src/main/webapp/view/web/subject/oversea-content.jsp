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
        	<span><a style="color:#9d8440;" href="<%=basePath%>oversea">其他保险</a></span>
        	<h2><em>￥</em>${(overseaConfig.title)!!}</h2>
        </div>
        <table class="conTable" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <ul class="conInfoList">
                        <li class="info" style="height:auto">
                            <p>子标题：<font color="#00baff">${(overseaConfig.childTitle)!!}</font></p>
                            <p>用户群体：<font color="#00baff">${(overseaConfig.userType)!!}</font></p>
                            <p>描述：<font color="#00baff">${(overseaConfig.description)!!} </font></p>
                        </li>
                    </ul>
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
					<#if (overseaConfig.status==1)&&(compareDate==false)>
                        <button class="submit">投资预约</button>
					<#else>
                        <button disabled="disabled" style="background-color: #848080;">已售罄</button>
					</#if>
                        <div class="phone"><span>4000-999-158</span>7X24小时咨询电话</div>
                    </div>
                </td>
            </tr>
        </table>

        ${(overseaConfig.content)!!}
    </div>
     <#include "../common/footer.html">
</body>
<script type="text/javascript">
    $(function(){

        $(":input").focus(function () {
            $(".li4").hide();
        });

        var exists = false;
        var authBankCard=false;
        /* <#if authBankCard??>
        	<#if authBankCard>
        		authBankCard=true;
        	</#if>
        </#if>
    <#if memberInfo??>
        exists = true; */
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
                url: '<%=basePath%>oversea/addOversea', // 目标地址
                data: {
                    overseaId: 1111111111111,
                    name: $("input[name='name']").val(),
                    phone:$("input[name='phone']").val(),
                    addr:cardaddress
                },
                success:function (msg) {
                    if (msg.code == 0) {
                        alert(msg.msg);
                        window.location.reload(true);
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