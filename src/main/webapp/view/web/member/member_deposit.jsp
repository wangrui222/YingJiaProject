<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
	<#include "../common/base.html">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>账户充值-会员中心-盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
	<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
    <link href="<%=basePath%>resources/web/font/iconfont.css" rel="stylesheet">
    <script src="<%=basePath%>resources/web/js/jquery.js"></script>
    <script src="<%=basePath%>resources/web/js/bootstrap.js"></script>
    <script>
	$(function(){
		$(".picTab a").click(function(){
			if(!$(this).hasClass("select")){
				var num=$(this).index();
				$(this).addClass("select").siblings().removeClass("select");
				$(".txtCon p").eq(num).show().siblings().hide();
			}
		})
		$(".tbConBox .tab a").click(function(){
			if(!$(this).hasClass("select")){
				var num=$(this).index();
				$(this).addClass("select").siblings().removeClass("select");
				$("#conBox .box").eq(num).show().siblings().hide();
			}
		})
	})	

	var baseContext = "${base}";

    </script>
    <style type="text/css">
    .finish_pay {

		padding: 30px 0 30px 75px;
		color: #343434;
		font-size: 14px;
	}
	.finish_pay	.toTargetPage {
		color: #ff7e03;
		font-weight: bold;
	}
	.finish_pay	.payOver, .finish_pay .payError {

		line-height: 30px;
		height: 30px;
		padding-left: 15px;
	}	
	
	.finish_pay	.payOver a, .finish_pay .payError a {
		color: #2676c9;
		text-decoration: underline;
		margin-right: 10px;
	}	

    </style>
</head>
<body>
<#include "../common/top.html">
<#include "admin-top.html">
	<div class="proMain clearfix">
		<#include "admin-left.html">
        <div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="javascript:;">网银充值</a>
                    <a href="javascript:;" id="hisTabLink">充值记录</a>
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">
                    	<div class="picTab">
                    		<a class="select" href="javascript:">
                            	<img height="42px" src="<%=basePath%>resources/web/images/fuiou.png">
                                <p>通过富友支付平台进行网银充值</p>
                            </a>
                        </div>   
                        <div class="formBox">
                        	<div class="czbox">
                        		<form id="depositForm" action="<%=basePath%>account/deposit/gopay" method="POST" target="_blank">
									<div>充值银行卡：<strong>${(memberBankcards.bankName)!!}-${(memberBankcards.cardNo)!!}</strong></div><br>
	                        		<div>充值金额：<input class="tytxt" id="fee" name="fee" type="text"></div>
	                        		<button class="tybutton" id="btn_go_pay" type="button">前往充值</button>
	                        	</form>
                        	</div>
                        </div>
                        <div class="txtCon">
                            <p style="display: block;">上海富友金融网络技术有限公司自2008年创立至今，已发展成为一家大型综合性金融支付服务集团公司——注册资本2.0007亿元，实收资本3.8亿元，下设6家全资子公司，同时拥有6张支付及金融服务牌照，并在全国设立了35家分公司。富友以“打造便利金融生活”为愿景，以“专业——分享——价值”为理念，以“专业创新，差异化经营”为手段，立志成为网络金融和网络生活服务的领先者——用便利金融，让生活更美好。 2011年获得中国人民银行颁发的银行卡收单和互联网支付牌照，同时获得人民银行颁发的预付卡发行与受理牌照。2013年富友金融获得中国银联“收单外包机构注册认证”，在全国范围建立银行卡收单服务网络。2014年成为“上海市网络信贷服务业企业联盟”成员单位，在目前国家已颁布牌照的269家第三方支付公司中，获此殊荣的仅有4家公司</p>
                        </div> 
                    </div>
                    <div class="box">
                     <#include "member_deposit_his_list.html">
                    </div>
                </div>
            </div>
        </div>
    </div>
	<#include "../common/footer.html">
<div class="modal fade errorInfo infoModal" id="withdrawErrorModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">
            <div class="modal-header">
                <span>通知</span>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
                <div id="withdrawError"></div>
                <button class="btn btn-success confirmBtn" data-dismiss="modal">确认</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade errorInfo infoModal" id="withdrawNoticeModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">
            <div class="modal-header">
                <span>提示信息</span>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
            <div class="finish_pay">
				<p class="toTargetPage">请您在新打开的支付页面上完成充值！</p>				
				<p class="payOver">充值成功：<a href="javascript:;" id="showHistory">查看充值记录</a></p>
			</div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

$("#btn_go_pay").click(function() {
	var depositAmount = $("#fee").val();
    if ($.trim(depositAmount) == "") {
        $("#withdrawError").html("请填写充值金额");
        $("#withdrawErrorModal").modal();
        $("#fee").focus();
        return;
    }
    if (isNaN(depositAmount)) {
        $("#withdrawError").html("请填写正确的充值金额");
        $("#withdrawErrorModal").modal();
        $("#fee").val("");
        $("#fee").focus();
        return;
    }
    if (depositAmount <1) {
        $("#withdrawError").html("充值金额不可少于1元");
        $("#withdrawErrorModal").modal();
        $("#fee").val("");
        $("#fee").focus();
        return;
    } 
    $("#depositForm").submit();
    $("#withdrawNoticeModal").modal();
}); 


$("#showHistory").click(function() {
    $("#withdrawNoticeModal").modal("hide");
    $("#hisTabLink").click();
    getJsonInfo(baseContext+'/account/deposit/retriveDepositRecordJson?page=1');

});
</script>
</body>
</html>