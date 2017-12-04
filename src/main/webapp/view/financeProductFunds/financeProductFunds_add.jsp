<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<#include '../common/base.html'>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${base}/resources/sys/ying/iconfont.css">
    <link rel="stylesheet" href="${base}/resources/sys/style/bootstrap.css">
    <link rel="stylesheet" href="${base}/resources/sys/webupload/webuploader.css">
    <link rel="stylesheet" href="${base}/resources/sys/webupload/demo.css">
    <link rel="stylesheet" href="${base}/resources/sys/style/style.css">
    <link rel="stylesheet" type="text/css" href="${base}/resources/uploadify/uploadify.css">

    <link href="${base}/resources/bootstrap-fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${base}/resources/date/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" charset="utf-8" src="${base}/resources/ueditor1_4_3_1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${base}/resources/ueditor1_4_3_1/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${base}/resources/ueditor1_4_3_1/lang/zh-cn/zh-cn.js"></script>

    <link rel="stylesheet" href="${base}/resources/date/bootstrap-datetimepicker.min.css">
	<script type="text/javascript" src="${base}/resources/date/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${base}/resources/date/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <title>后台首页</title>
</head>
<body>

<div class="box-right-main">
    <h2>
        <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>私募/股权类添加
    </h2>

    <form action="${base}/financeProductFunds/addFinanceProductFunds" method="post" id="valForm">
        <div class="tablelist">
            <!-- 表单 -->
            <div class="row bdlist">
                <div class="col-md-6">
                	 <div class="form-group">
                        <label class="col-sm-3 control-label">类别：</label>

                        <div class="col-sm-9">
                           	<select class="form-control" name="type">
                           		<option value="SIMU">私募类</option>
                           		<option value="GUQUAN">股权类</option>
                           	</select>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">名称：</label>

                        <div class="col-sm-9">
                            <input name="name" class="form-control" placeholder="请输入文本" type="text">
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">起投金额(元)：</label>

                        <div class="col-sm-9">
                            <input name="floorAmount" class="form-control" placeholder="请输入文本" type="text">
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">年化收益(%)：</label>

                        <div class="col-sm-9">
                            <input name="yearRate" class="form-control" placeholder="请输入文本" type="text">
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">开始日期：</label>

                        <div class="col-sm-9">
                            <input name="startDate" class="form-control time" placeholder="请输入文本" type="text">
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">结束日期：</label>

                        <div class="col-sm-9">
                            <input name="endDate" class="form-control time" placeholder="请输入文本" type="text">
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">返佣比例：</label>

                        <div class="col-sm-9">
                            <input name="ratio" class="form-control" placeholder="请输入文本" type="text">
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-sm-3 control-label">状态：</label>

                        <div class="col-sm-9">
                           	<select class="form-control" name="status">
                           		<option value="0">未发布</option>
                           		<option value="1">募集中</option>
                           		<option value="2">已结束</option>
                           	</select>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group period">
                        <label class="col-sm-3 control-label">投资期限(天)：</label>

                        <div class="col-sm-9">
                            <input name="period" class="form-control" placeholder="请输入文本" type="text">
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="row bdlist">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>基金专题/关于基金
                </h2>

                <div>
                    <div><textarea name="productTopic" id="productTopic" style="height: 300px;"></textarea></div>
                    <script type="text/javascript"> var ue = UE.getEditor('productTopic');</script>
                </div>
            </div>
        </div>
        
         <div class="row bdlist">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>产品要素
                </h2>

                <div>
                    <div><textarea name="productFactor" id="productFactor" style="height: 300px;"></textarea></div>
                    <script type="text/javascript"> var ue = UE.getEditor('productFactor');</script>
                </div>
            </div>
        </div>
       <!-- ===私募类=== -->
      <div class="row bdlist productStrategy">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>产品策略
                </h2>

                <div>
                    <div><textarea name="productStrategy" id="productStrategy" style="height: 300px;"></textarea></div>
                    <script type="text/javascript"> var ue = UE.getEditor('productStrategy');</script>
                </div>
            </div>
        </div>
        
        
        <div class="row bdlist product">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span> 基金经理
                </h2>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-3 control-label">基金经理名称：</label>

                    <div class="col-sm-9">
                        <input name="productManagerName" id="productManagerName1" class="form-control" placeholder="请输入文本" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">基金经理头衔：</label>

                    <div class="col-sm-9">
                        <input name="productManagerTitle" class="form-control" placeholder="请输入文本" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">基金经理简介：</label>

                    <div class="col-sm-9">
                        <input name="productManagerDesc" class="form-control" placeholder="请输入文本" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">基金经理头像：</label>

                    <div class="col-sm-9">
                        <div id="avatar" style="text-align:left">
                            <input type="file" name="avatar_link" id="avatar_link">
                            <input type="hidden" name="productManagerPic" id="productManagerPic"/>
                        </div>
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row bdlist productManager">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>基金经理详情
                </h2>

                <div>
                    <div><textarea name="productManager" id="productManager" style="height: 300px;"></textarea></div>
                    <script type="text/javascript"> var ue = UE.getEditor('productManager');</script>
                </div>
            </div>
        </div>

        <div class="row bdlist">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>合同内容
                </h2>

                <div>
                    <div><textarea name="contract" id="contract" style="height: 300px;"></textarea></div>
                    <script type="text/javascript"> var ue = UE.getEditor('contract');</script>
                </div>
            </div>
        </div>

        <div class="row bdlist">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span> 银行账户
                </h2>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-3 control-label">银行账户：</label>

                    <div class="col-sm-9">
                        <input name="bankAccount" id="bankAccount" class="form-control" placeholder="请输入文本" type="text">
                        <span style="color: red;">例：招商银行杭州高新支行|1234 5678 1234 123|杭州吉威投资管理有限公司</span>
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                </div>
        </div>
         <!-- ===股权类=== -->
        <div class="row bdlist guquan" style="display: none;">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span> 股权信息
                </h2>
            </div>
            <div class="col-sm-6">
            	<div class="form-group">
                    <label class="col-sm-3 control-label">管理人名称：</label>

                    <div class="col-sm-9">
                        <input name="productManagerName" id="productManagerName2" disabled="disabled" class="form-control" placeholder="请输入文本" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">投资方向：</label>

                    <div class="col-sm-9">
                        <input name="investPoints" class="form-control" placeholder="请输入文本" disabled="disabled" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">募集金额：</label>

                    <div class="col-sm-9">
                        <input name="amount" class="form-control" placeholder="请输入文本" disabled="disabled" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">已售金额：</label>

                    <div class="col-sm-9">
                        <input name="soldAmount" class="form-control" placeholder="请输入文本" disabled="disabled" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">购买人数：</label>

                    <div class="col-sm-9">
                        <input name="buyerCount" class="form-control" placeholder="请输入文本" disabled="disabled" type="text">
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="tablebaocun">
            <br>
            <button type="submit" class="btn btn-primary btn-sm" style="margin-left: 40%; margin-bottom: 20px; padding: 10px 30px">保存</button>
        </div>
    </form>
    <!-- 内容结束 -->
</div>
<!-- 容器结束 -->
</body>
<script src='${base}/resources/dist/js/jquery.min.js'></script>
<script src='${base}/resources/js/jquery.form.js'></script>
<script src="${base}/resources/dist/js/bootstrapValidator.min.js"></script>
<script src="${base}/resources/bootstrap-fileinput/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${base}/resources/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js" type="text/javascript"></script>
<script src="${base}/resources/bootstrap-fileinput/js/fileinput.min.js" type="text/javascript"></script>
<script src="${base}/resources/bootstrap-fileinput/js/fileinput_locale_LANG.js" type="text/javascript"></script>
<script src="${base}/resources/bootstrap-fileinput/js/fileinput_locale_zh.js" type="text/javascript"></script>

<script src="${base}/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>

<script type="text/javascript" src="${base}/resources/date/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${base}/resources/date/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

<script type="text/javascript">
	$(":input[name=type]").change(function(){
    var type = $(this).val();
    if(type=='SIMU'){
    	$(".guquan").hide();
    	$(".period").show();
    	$(".productStrategy").show();
    	$(".product").show();
    	$(".productManager").show();

    	$("input[name='investPoints']").attr("disabled",true);
    	$("input[name='amount']").attr("disabled",true);
    	$("input[name='soldAmount']").attr("disabled",true);
    	$("input[name='buyerCount']").attr("disabled",true);
    	$("input[name='period']").attr("disabled",false);
    	$("input[name='productStrategy']").attr("disabled",false);
    	$("#productManagerName1").attr("disabled",false);
    	$("#productManagerName2").attr("disabled",true);
    	$("input[name='productManagerTitle']").attr("disabled",false);
    	$("input[name='productManagerDesc']").attr("disabled",false);
    	$("input[name='productManagerPic']").attr("disabled",false);
    	$("input[name='productManager']").attr("disabled",false);
    }else{
    	$(".guquan").show();
    	$(".period").hide();
    	$(".productStrategy").hide();
    	$(".product").hide();
    	$(".productManager").hide();

    	$("input[name='investPoints']").attr("disabled",false);
    	$("input[name='amount']").attr("disabled",false);
    	$("input[name='soldAmount']").attr("disabled",false);
    	$("input[name='buyerCount']").attr("disabled",false);
    	$("input[name='period']").attr("disabled",true);
    	$("input[name='productStrategy']").attr("disabled",true);
    	$("#productManagerName1").attr("disabled",true);
    	$("#productManagerName2").attr("disabled",false);
    	$("input[name='productManagerTitle']").attr("disabled",true);
    	$("input[name='productManagerDesc']").attr("disabled",true);
    	$("input[name='productManagerPic']").attr("disabled",true);
    	$("input[name='productManager']").attr("disabled",true);
    }
	
	});

     $(function () {
    	 $('.time').datetimepicker({
 			format : 'yyyy-mm-dd',
 			language: 'zh-CN',
 		    weekStart: 1,
 		    todayBtn: 1,			
 			todayHighlight: 1,
 			startView: 2,
 			minView: 2,
 			forceParse: 0,
 			autoclose : 1
 		}).on('changeDate', function(ev) {
 			$(this).focus();
 			$('.time').datetimepicker('hide');
 			$('#valForm').bootstrapValidator('revalidateField', 'startDate');
			$('#valForm').bootstrapValidator('revalidateField', 'endDate');
 		});
    	 
    	 
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
                            message: '名称不能为空!'
                        },

                        stringLength: {
                            min: 2,
                            max: 100,
                            message: '名称长度为2-100个字符!'
                        }
                    }
                },
                floorAmount: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '起投金额不能为空!'
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
                
                productManagerName: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '基金经理名称不能为空!'
                        },

                        stringLength: {
                            min: 2,
                            max: 100,
                            message: '基金经理名称长度为2-100个字符!'
                        }
                    }
                },
                productManagerTitle: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '基金经理头衔不能为空!'
                        },
                        stringLength: {
                            min: 2,
                            max: 100,
                            message: '基金经理头衔长度为2-100个字符!'
                        }
                    }
                },
                productManagerPic: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '基金经理头像不能为空!'
                        }
                    }
                },
                productManagerDesc: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '基金经理简介不能为空!'
                        },

                        stringLength: {
                            min: 2,
                            max: 1000,
                            message: '基金经理简介长度为2-1000个字符!'
                        }
                    }
                },
                investPoints: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '投资方向不能为空!'
                        },

                        stringLength: {
                            min: 2,
                            max: 100,
                            message: '投资方向长度为2-100个字符!'
                        }
                    }
                },
                amount: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '募集金额不能为空!'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: '募集金额为数字!'
                        }
                    }
                },
                soldAmount: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '已售金额不能为空!'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: '已售金额为数字!'
                        }
                    }
                },
                buyerCount: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '购买人数不能为空!'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: '购买人数为数字!'
                        }
                    }
                },
                startDate: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '开始日期不能为空!'
                        }
                    }
                },
                endDate: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '结束日期不能为空!'
                        }
                    }
                },
                ratio: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '返佣比例不能为空!'
                        }
                    }
                },
                bankAccount: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '银行账号不能为空!'
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
                alert(result.msg);
                window.location.href = "${base}/financeProductFunds/list";
            }, 'json');
        });
        $('#avatar_link').uploadify({
            'swf': '${base }/resources/uploadify/uploadify.swf', //指定上传控件的主体文件，默认‘uploader.swf’
            'uploader': '${base }/upload/fileupload', //指定服务器端上传处理文件
            'auto': true, //手动上传
            'buttonImage': '${base }/resources/uploadify/uploadify-browse.png', //浏览按钮背景图片
            'multi': false, //单文件上传
            'fileTypeExts': '*.gif; *.jpg; *.png;', //允许上传的文件后缀
            'fileSizeLimit': '10MB', //上传文件的大小限制，单位为B, KB, MB, 或 GB
            'successTimeout': 30, //成功等待时间
            'queueSizeLimit': 1,
            'fileObjName': 'file',
            'onUploadSuccess': function (file, data,response) {//每成功完成一次文件上传时触发一次
                var image = eval("[" + data + ']')[0];
                $(".uploadvedio").remove();
                $('#avatar').append("<div id=" + image.msg + " class='uploadvedio'> <a href=${base}/" + image.msg + " target='_black'>" + image.msg + "</a> " +
                        "<a href=javascript:delimg('" + image.msg + "','productManagerPic')>删除</a> </div>");
                $("#productManagerPic").val(image.msg);
            },
            'onUploadError': function (file, data, response) {//当上传返回错误时触发
                $('#avatar').append("<li>" + data + "</li>");

            }
        });
    });

    <!--删除图片-->
    function delimg(obj, tval) {
        var url = "${base}/upload/delimg";
        $.post(url, {'imgpath': obj}, function (data) {
            if (data.code == 0) {
                document.getElementById(obj).remove();
                document.getElementById(tval).value = "";
            }
        });
    }
</script>
</html>
