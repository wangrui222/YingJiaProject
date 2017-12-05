<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
	<#include "../common/base.html">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>提款-会员中心-盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="${base}/resources/web/css/common.css" rel="stylesheet">
	<link href="${base}/resources/web/css/jw.css" rel="stylesheet">
    <link href="${base}/resources/web/font/iconfont.css" rel="stylesheet">
    <script src="${base}/resources/web/js/jquery.js"></script>
    <script src="${base}/resources/web/js/bootstrap.js"></script>
	<script type="text/javascript" src="${base}/resources/web/location/area.js"></script>
	<script type="text/javascript" src="${base}/resources/web/location/location.js"></script>
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
//	$(document).ready(function() {
//		showLocation();
//	});
	var baseContext = "${base}";
    </script>
    <style>
.clearfix:after {
	content: '\0020';
	display: block;
	height: 0;
	clear: both;
}

.clearfix {
	*zoom: 1;
}

#conBox .box .title {
	font-weight: bold;
	font-size: 20px;
	padding-top: 20px;
	padding-left: 30px;
	margin-bottom: 40px;
}

/*.myBankCards {*/
	/**/
/*}*/

/*.myBankCards .card {*/
	/*float: left;*/
	/*width: 180px;*/
	/*border: 1px solid #eaeaea;*/
	/*padding: 5px;*/
	/*position: relative;*/
	/*margin-left: 35px;*/
	/*margin-bottom: 20px;*/
/*}*/

/*.myBankCards .card .banklogo {*/
	/*width: 150px;*/
	/*height: 45px;*/
/*}*/

/*.myBankCards .card img {*/
	/*width: 150px;*/
	/*margin-left: 10px;*/
/*}*/

/*.myBankCards .card .cardno {*/
	/*margin-top: 5px;*/
	/*margin-left: 15px;*/
/*}*/

/*.myBankCards .card .btns {*/
	/*position: absolute;*/
	/*right: 1px;*/
	/*bottom: 1px;*/
	/*display: none;*/
/*}*/

/*.myBankCards .card .btns a {*/
	/*background: #d7d7d7;*/
	/*color: #9b8888;*/
	/*text-decoration: none;*/
/*}*/
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
                    <a class="select" href="javascript:;">我要提款</a>
                    <a href="javascript:;">提款记录</a>                    
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">
													
                        <table class="txTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="140" align="right">账户余额：</td>
                            <td><strong>${memberAccount.useableBalance}</strong>元</td>
                          </tr>
							<tr>
								<td align="right"> 提款银行卡： </td>
								<td><strong>${(memberBankcards.bankName)!!}-${(memberBankcards.cardNo)!!}</strong>
									<input type="hidden" id="withdrawBankCard" value="${(memberBankcards.cardNo)!!}"></td>
							</tr>
                          <tr>
                            <td align="right">提款金额：</td>
                            <td><input class="tytxt" type="text" id="withdrawAmount" style="width:250px"></td>
                          </tr>

                          <tr>
                            <td align="right"> 提款密码：</td>
                            <td>
                            <#if withdrawPasswordSetted>
                            <input type="password" class="tytxt" id="withdrawPW" style="display: inline;width:250px;">
                            <#else>  
								<a href="javascript:;" onclick="$('#setWithdrawPWModel').modal(); return false;">设置提款密码</a>
							</#if> 
                            </td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td><button class="tybutton" id="withdrawConfirm">提交</button></td>
                          </tr>
                        </table> 
                    </div>
                    <div class="box">                    	
                          <#include "member_withdraw_his_list.html">
                    </div>
                </div>
            </div>
        </div>
    </div>
	<#include "../common/footer.html">
<div id="setWithdrawPWModel" class="modal fade infoModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content" style="border-radius: 0px;">
			<div class="modal-header">
				<span>设置提款密码</span>
				<button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			</div>
			<div class="modal-body text-center">
				<form class="form-horizontal" id="setWithdrawPWForm">
					<div class="form-group" id="withdrawPWGroup">
						<label class="control-label col-sm-3" for="withdrawPW">提款密码: </label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="withdrawPW" placeholder="提款密码" />
						</div>
						<div class="col-sm-4 help-block text-left">
							<span class="error-info"></span>
						</div>
					</div>
					<div class="form-group" id="withdrawPWConfirmGroup">
						<label class="control-label col-sm-3" for="withdrawPWConfirm">确认提款密码: </label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="withdrawPWConfirm" placeholder="确认提款密码" />
						</div>
						<div class="col-sm-4 help-block text-left">
							<span class="error-info"></span>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" onclick="setWithdrawPw();">提交</button>
				<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

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

<div class="modal fade errorInfo infoModal" id="setWithdrawPWResultModel" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content jddModalContnt" style="border-radius: 0px;width:400px;">
					<div class="modal-header">
						<span>通知</span>
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
					</div>
					<div class="modal-body">
						<div id="setwithdrawError"></div>
						<button class="btn btn-success confirmBtn" data-dismiss="modal">确认</button>
					</div>
				</div>
			</div>
</div>
<!--<div id="delBankCardModel" class="modal fade infoModal" role="dialog">-->
	<!--<div class="modal-dialog">-->
		<!--<div class="modal-content" style="border-radius: 0px;">-->
			<!--<div class="modal-header">-->
				<!--<span>删除银行卡</span>-->
				<!--<button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>-->
			<!--</div>-->
			<!--<div class="modal-body text-center">-->
				<!--<p>您确定要删除此银行卡?</p>-->
				<!--<input type="hidden" id="wannaDelBankCardId" val="">-->
			<!--</div>-->
			<!--<div class="modal-footer">-->
				<!--<button type="button" class="btn btn-success" onclick="delBankCard();">确定</button>-->
				<!--<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal">取消</button>-->
			<!--</div>-->
		<!--</div>-->
	<!--</div>-->
<!--</div>-->

<script type="text/javascript">
	$("#setWithdrawPWResultModel").on('hidden.bs.modal', function () { window.location.reload(); });
	function withdrawPWError(txt) {
		if (txt) {
			$('#setWithdrawPWForm #withdrawPWGroup').addClass('has-error');
			$('#setWithdrawPWForm #withdrawPWGroup .error-info').text(txt);
		} else {
			$('#setWithdrawPWForm #withdrawPWGroup').removeClass('has-error');
			$('#setWithdrawPWForm #withdrawPWGroup .error-info').text('');
		}
	}

	function withdrawPWConfirmError(txt) {
		if (txt) {
			$('#setWithdrawPWForm #withdrawPWConfirmGroup').addClass('has-error');
			$('#setWithdrawPWForm #withdrawPWConfirmGroup .error-info').text(txt);
		} else {
			$('#setWithdrawPWForm #withdrawPWConfirmGroup').removeClass('has-error');
			$('#setWithdrawPWForm #withdrawPWConfirmGroup .error-info').text('');
		}
	}

	var setWithdrawPw = function() {
		var withdrawPw = $("#setWithdrawPWModel #withdrawPW").val();
		var pattter = new RegExp(/^[a-zA-Z0-9!@#$%^&*()_+|]{8,30}$/);
		if (!withdrawPw) {
			withdrawPWError('提款密码不能为空');
			return;
		} else {
			if (!pattter.test(withdrawPw)) {
				withdrawPWError('8-30位数字和字母组成');
				return;
			}
			withdrawPWError(false);
		}
		var withdrawPwConfirm = $("#setWithdrawPWModel #withdrawPWConfirm").val();
		if (!withdrawPwConfirm) {
			withdrawPWConfirmError('确认提款密码不能为空');
			return;
		} else {
			if (withdrawPwConfirm != withdrawPw) {
				withdrawPWConfirmError('两次输入的提款密码不一致');
				return;
			}
			withdrawPWConfirmError(false);
		}
		$.ajax({
			type : "POST", 
			dataType : "json", 
			async : true,
			url : '${base}/account/withdraw/setwithdrawpwd', 
			data : {
				password : withdrawPw		
			},
			success : function(resp) {
				if (resp.code == 0) {
					$("#setwithdrawError").html("设置提款密码成功");
				} else {
					$("#setwithdrawError").html(resp.msg);
				}
				$("#setWithdrawPWModel").modal("hide");
				$("#setWithdrawPWResultModel").modal();
			}
		});
	}

	$("#withdrawConfirm").click(function () {
		var bankCard = $("#withdrawBankCard").val();
		var withdrawAmount = $("#withdrawAmount").val();
		var withdrawPW = $("#withdrawPW").val();
		if ($.trim(withdrawAmount) == "") {
			$("#withdrawError").html("请填写提款金额");
			$("#withdrawErrorModal").modal();
			$("#withdrawAmount").focus();
			return;
		}
		if (isNaN(withdrawAmount)) {
			$("#withdrawError").html("请填写正确的提款金额");
			$("#withdrawErrorModal").modal();
			$("#withdrawAmount").val("");
			$("#withdrawAmount").focus();
			return;
		}
		if (withdrawAmount < 10) {
			$("#withdrawError").html("提款金额不可少于10元");
			$("#withdrawErrorModal").modal();
			$("#withdrawAmount").val("");
			$("#withdrawAmount").focus();
			return;
		}
		if ($.trim(withdrawPW) == "") {
			$("#withdrawError").html("请填写提款密码");
			$("#withdrawErrorModal").modal();
			$("#withdrawPW").focus();
			return;
		}
		$("#withdrawConfirm").addClass("disabled");

		$.ajax({
			type : "POST",
			dataType : "json",
			async : true,
			url : '${base}/account/withdraw/submitWithdraw',
			data : {
				amount : withdrawAmount,
				withdrawalPassword:withdrawPW,
				bankCard: bankCard

			},
			success : function(resp) {

				if (resp.code == 0) {
					$("#withdrawError").html("提款申请提交成功");
					$("#withdrawErrorModal").modal();
					$("#withdrawErrorModal").on('hide.bs.modal', function () {
						window.location.reload();
					});
					setTimeout(function () { $("#withdrawErrorModal").modal('hide'); }, 3000);
				} else {
					$("#withdrawError").html(resp.msg);
					$("#withdrawErrorModal").modal();
				}
				$("#withdrawConfirm").removeClass("disabled");
			}
		});

	});
	
	//绑定银行卡
//    $("#bankCardConfirm").click(function () {
//        var bankCard = $("#bankCardNum").val();
//        var bankCardConfirm = $("#bankCardNumConfirm").val();
//        var type = $("#type").val();
//        var loc_province = $("#loc_province").find("option:selected").text();
//        var loc_city = $("#loc_city").find("option:selected").text();
//        var loc_town = $("#loc_town").find("option:selected").text();
//        var cardaddress=loc_province+"-"+loc_city+"-"+loc_town;
//        var cardaddress1 = $("#cardaddress1").val();
//        if(loc_province=="省份"){
//        	$("#withdrawError").html("请选择省份");
//            $("#withdrawErrorModal").modal();
//            return;
//        }
//        if(loc_city=="地级市"){
//        	$("#withdrawError").html("请选择地级市");
//            $("#withdrawErrorModal").modal();
//            return;
//        }
//        if (bankCard == "" || bankCard == undefined) {
//            $("#withdrawError").html("请输入银行卡号");
//            $("#withdrawErrorModal").modal();
//            return;
//        }
//
//        if (bankCardConfirm == "" || bankCardConfirm == undefined) {
//            $("#withdrawError").html("请再次输入银行卡号");
//            $("#withdrawErrorModal").modal();
//            return;
//        }
//        if (bankCardConfirm != bankCard) {
//            $("#withdrawError").html("两次输入的银行卡号不一致");
//            $("#withdrawErrorModal").modal();
//            return;
//        }
//        var userName = $("#username").val();
//
//        $("#bankCardConfirm").addClass("disabled");
//		$.ajax({
//			type : "POST",
//			dataType : "json",
//			async : true,
//			url : '${base}/account/withdraw/addBankCard',
//			data : {
//				userName : userName,
//				bankCard: bankCard,
//				type:type,
//				cardaddress:cardaddress+"-"+cardaddress1
//			},
//			success : function(resp) {
//				if (resp.code == 0) {
//					window.location.href = baseContext + "/account/withdraw?tabIndex=2";
//				} else {
//					 $("#withdrawError").html(resp.msg);
//			         $("#withdrawErrorModal").modal();
//				}
//
//			}
//		});
//
//    });
	


//    $(".myBankCards .card").mouseover(function () {
//        $(this).find(".btns").show();
//    });
//
//    $(".myBankCards .card").mouseout(function () {
//        $(this).find(".btns").hide();
//    });
//
//    function confimDelBankCard(bankId){
//    	$("#wannaDelBankCardId").val(bankId);
//    	$("#delBankCardModel").modal();
//    }
//    function delBankCard(){
//    	var bankId = $("#wannaDelBankCardId").val();
//		$.ajax({
//			type : "POST",
//			dataType : "json",
//			async : true,
//			url : '${base}/account/withdraw/delBankCard',
//			data : {
//				id : bankId
//			},
//			success : function(resp) {
//				if (resp.code == 0) {
//					window.location.href = baseContext + "/account/withdraw?tabIndex=2";
//				} else {
//
//				}
//			}
//		});
//
//    	$("#delBankCardModel").modal("hide");
//    }
//
//	var tabIndex="${tabIndex}";
//	if(tabIndex=="2"){
//		$("#bankMgrTab").click();
//	}
</script>

</body>
</html>