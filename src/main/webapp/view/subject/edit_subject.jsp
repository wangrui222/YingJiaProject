<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=basePath%>resources/sys/ying/iconfont.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/bootstrap.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/webupload/webuploader.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/webupload/demo.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">
<link href="<%=basePath%>resources/bootstrap-fileinput/css/fileinput.css"
	media="all" rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>resources/ueditor1_4_3_1/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>resources/ueditor1_4_3_1/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>resources/ueditor1_4_3_1/lang/zh-cn/zh-cn.js"></script>
<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>产品信息详细页
		</h2>

		<form action="<%=basePath%>subject/sys/edit" method="post" id="valForm">
			<input type="hidden" name="folderId" value="${(subject.folderId)!!}">
			<input type="hidden" name="id" value="${id}">
			<div class="tablelist">
				<!-- 表单 -->
				<div class="row bdlist">
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-sm-3 control-label">名称：</label>

							<div class="col-sm-9">
								<input name="name" class="form-control" placeholder="请输入文本"
									type="text" value="${(subject.name)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">合同编号：</label>

							<div class="col-sm-9">
								<input name="serialNo" class="form-control" placeholder="请输入文本"
									type="text" value="${(subject.serialNo)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">起投金额(元)：</label>

							<div class="col-sm-9">
								<input name="floorAmount" class="form-control"
									placeholder="请输入文本" type="text"
									value="${(subject.floorAmount)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">年化收益(%)：</label>

							<div class="col-sm-9">
								<input name="yearRate" class="form-control" placeholder="请输入文本"
									type="text" value="${(subject.yearRate)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">状态：</label>

							<div class="col-sm-9">
								<select class="form-control" name="status">
									<option value="${statu}">${statu.description}</option>
									<option value="${statu}">${statu.description}</option>
								</select> <span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">投资期限(天)：</label>

							<div class="col-sm-9">
								<input name="period" class="form-control" placeholder="请输入文本"
									type="text" value="${(subject.period)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">借款人姓名：</label>

							<div class="col-sm-9">
								<input name="borrowername" class="form-control"
									placeholder="请输入文本" type="text"
									value="${(subject.borrowername)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group amount">
							<label class="col-sm-3 control-label">总金额(元)：</label>

							<div class="col-sm-9">
								<input name="amount" class="form-control" placeholder="请输入文本"
									type="text" value="${(subject.amount)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-sm-3 control-label">类型</label>
							<div class="col-sm-9">
								<input type="hidden" name="type" value="${subject.type}"
									id="type"> <select class="form-control" name="type1"
									disabled="disabled">
									<option value="${type}">${type.description}</option> </#if>
									</#list>
								</select> <span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">借款用途</label>

							<div class="col-sm-9">
								<input name="purpose" class="form-control" placeholder="请输入文本"
									type="text" value="${(subject.purpose)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">保障方式</label>

							<div class="col-sm-9">
								<select class="form-control" name="safeguardWay">
									
									<option value="${way}">${way.description}</option>
									</#list>
								</select> <span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group experStatus">
							<label class="col-sm-3 control-label">可使用体验金</label>

							<div class="col-sm-9">
								<select class="form-control" name="experStatus">
									<option value="0" >否</option>
									<option value="1" >是</option>
								</select> <span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group raiseStart">
							<label class="col-sm-3 control-label">募集开始时间：</label>
							<div class="col-sm-9">
								<input name="raiseStart" class="form-control time"
									placeholder="请输入文本" type="text"
									value="">
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group raiseEnd">
							<label class="col-sm-3 control-label">募集结束时间：</label>

							<div class="col-sm-9">
								<input name="raiseEnd" class="form-control time"
									placeholder="请输入文本" type="text"
									value="">
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group startDate">
							<label class="col-sm-3 control-label">标的开始时间：</label>

							<div class="col-sm-9">
								<input name="startDate" class="form-control time"
									placeholder="请输入文本" type="text"
									value="">
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group endDate">
							<label class="col-sm-3 control-label">标的结束时间：</label>

							<div class="col-sm-9">
								<input name="endDate" class="form-control time"
									placeholder="请输入文本" type="text"
									value=""> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group bought">
							<label class="col-sm-3 control-label">已购人数：</label>

							<div class="col-sm-9">
								<input name="bought" class="form-control" placeholder="请输入文本"
									type="text" value="${(subject.bought)!''}"> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>

					</div>
				</div>
				<#include "typical_field_edit.html">

				<div class="row bdlist">
					<div class="col-md-12">
						<h2>
							<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>产品速览
						</h2>
						<div>
							<script id="editor" type="text/plain" name="comment"
								style="height: 500px;">${(subject.comment)!!}</script>
						</div>
					</div>
				</div>
				<div class="row bdlist">
					<div class="col-md-12">
						<h2>
							<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>项目详情
						</h2>
						<div>
							<script id="editor1" type="text/plain" name="projectDetails"
								style="height: 500px;">${(subject.projectDetails)!!}</script>
						</div>
					</div>
				</div>
				<div class="row bdlist">
					<div class="col-md-12">
						<h2>
							<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>安全保障
						</h2>
						<div>
							<script id="editor2" type="text/plain" name="safetyControl"
								style="height: 500px;">${(subject.safetyControl)!!}</script>
						</div>
					</div>
				</div>

				<div class="tablebaocun">
					<br>
					<button type="submit" class="btn btn-primary btn-sm"
						style="margin-left: 40%; margin-bottom: 20px; padding: 10px 30px">保存</button>
				</div>

			</div>
		</form>
		<div class="row bdlist ajaxContainer"><#include
			"ajax_fileupload.html"></div>
		<!-- 内容结束 -->
	</div>
	<!-- 容器结束 -->
</body>
<script type="text/javascript">
//实例化编辑器
var ue = UE.getEditor('editor');
var ue = UE.getEditor('editor1');
var ue = UE.getEditor('editor2');

	$(document).ready(function() {
		$('.time').datetimepicker({
			format : 'yyyy-mm-dd',
			language: 'zh-CN',
		    weekStart: 1,
		    todayBtn: 1,			
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0,
			autoclose : true
		}).on('changeDate', function(ev) {
			$(this).focus();
			$('.time').datetimepicker('hide');
			$('#valForm').bootstrapValidator('revalidateField', 'raiseStart');
			$('#valForm').bootstrapValidator('revalidateField', 'raiseEnd');
			$('#valForm').bootstrapValidator('revalidateField', 'startDate');
			$('#valForm').bootstrapValidator('revalidateField', 'endDate');
		});
	});

</script>

<script type="text/javascript">
        $(function () {
        	 var type = $("#type").val();
             if(type=='GU_SHOU'){
            	 $(".bought").show();
             	$(".amount").hide();
             	$(".raiseStart").hide();
             	$(".raiseEnd").hide();
            	$(".startDate").hide();
            	$(".endDate").hide();
            	$(".experStatus").show();
            	$("input[name='bought']").attr("disabled",false);
            	$("input[name='amount']").attr("disabled",true);
            	$("input[name='raiseStart']").attr("disabled",true);
            	$("input[name='raiseEnd']").attr("disabled",true);
            	$("input[name='startDate']").attr("disabled",true);
            	$("input[name='endDate']").attr("disabled",true);
            	$("input[name='experStatus']").attr("disabled",false);
             }else{
            	$(".bought").hide();
             	$(".amount").show();
             	$(".raiseStart").show();
             	$(".raiseEnd").show();
             	$(".startDate").show();
            	$(".endDate").show();
            	$(".experStatus").hide();
            	$("input[name='bought']").attr("disabled",true);
            	$("input[name='amount']").attr("disabled",false);
            	$("input[name='raiseStart']").attr("disabled",false);
            	$("input[name='raiseEnd']").attr("disabled",false);
            	$("input[name='startDate']").attr("disabled",false);
            	$("input[name='endDate']").attr("disabled",false);
            	$("input[name='experStatus']").attr("disabled",true);
             }
            $('#valForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    name: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '标的名称不能为空!'
                            },

                            stringLength: {
                                min: 2,
                                max: 100,
                                message: '标的名称长度为2-100个字符!'
                            }
                        }
                    },
                    serialNo: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '合同号不能为空!'
                            },
                            stringLength: {
                                min: 6,
                                max: 20,
                                message: '合同号号称长度为6-20个数字?'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '合同号不符合规范!'
                            }
                        }
                    },
                    floorAmount: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '起投金额不能为空!'
                            },
                            stringLength: {
                                min: 1,
                                max: 11,
                                message: '起投金额为1的倍数的金额!'
                            },
                            regexp: {
                                regexp: /^[0-9]+$/,
                                message: '起投金额为数字!'
                            }
                        }
                    },
                    yearRate: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '年化率不能为空!'
                            },
                            regexp: {
                                regexp: /^(([0-9]|([1-9][0-9]{0,9}))((\.[0-9]{1,2})?))$/,
                                message: '年化率为数字!'
                            }
                        }
                    },
                    period: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '投资期限不能为空!'
                            },
                            regexp: {
                                regexp: /^[0-9]+$/,
                                message: '投资期限为多少天!'
                            }
                        }
                    },
                    borrowername: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '借款人姓名不能为空!'
                            },
                            stringLength: {
                                min: 2,
                                max: 100,
                                message: '借款人姓名长度为2-100个字符!'
                            }
                        }
                    },
                    amount: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '总金额不能为空!'
                            },
                            stringLength: {
                                min: 3,
                                max: 20,
                                message: '总金额不能少于100'
                            },
                            regexp: {
                                regexp: /^[0-9]+$/,
                                message: '总金额为数字!'
                            }
                        }
                    },
                    raiseStart: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '募集开始日期不能为空!'
                            }
                        }
                    },
                    raiseEnd: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '募集结束日期不能为空!'
                            }
                        }
                    },
                    startDate: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '标的开始日期不能为空!'
                            }
                        }
                    },
                    endDate: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '标的结束日期不能为空!'
                            }
                        }
                    },
                    purpose: {
                        message: '',
                        validators: {
                            notEmpty: {
                                message: '借款用途不能为空!'
                            },
                            stringLength: {
                                min: 3,
                                max: 200,
                                message: '借款用途长度为3-200个字符!'
                            }
                        }
                    }
                }
            }).on('success.form.bv', function (e) {
                // Prevent form submission
                e.preventDefault();
                // Get the form instance
                var $form = $(e.target);
                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');
                $.post($form.attr('action'), $form.serialize(), function (result) {
                	alert("编辑成功");
                	window.location.href="<%=basePath%>subject/sys/gushouList";
                }, 'json');
            });
        });
    </script>
</html></html>