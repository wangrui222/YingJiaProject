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
    <link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">

    <script src='<%=basePath%>resources/dist/js/jquery.min.js'></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/lang/zh-cn/zh-cn.js"></script>

    <link rel="stylesheet" href="<%=basePath%>resources/date/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="<%=basePath%>resources/date/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="<%=basePath%>resources/date/bootstrap-datetimepicker.zh-CN.js"
            charset="UTF-8"></script>

    <script src='<%=basePath%>resources/js/jquery.form.js'></script>
    <script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
    <script src="<%=basePath%>resources/bootstrap-fileinput/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>resources/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js"
            type="text/javascript"></script>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/uploadify/uploadify.css">
    <script src="<%=basePath%>resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    <title>后台首页</title>
</head>
<body>

<div class="box-right-main">
    <h2>
        <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>签署合同
    </h2>
    <form id="addAccountForm" method="post" class="form-horizontal" action="<%=basePath%>financeProductFunds/addContract">
        <input type="hidden" name="id" value="${(financeProductSubscribe.id)!!}">
        <input type="hidden" name="memberId" value="${(financeProductSubscribe.memberId)!!}">
        <div class="form-group">
            <label class="col-sm-3 control-label">真实姓名：</label>
            <div class="col-lg-5">
                <input type="text" class="form-control" name="memberName" value="${(member.memberName)!!}" disabled>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">身份证：</label>
            <div class="col-lg-5">
                <input type="text" class="form-control" name="identity" value="${(member.identity)!!}" disabled>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">购买金额：</label>
            <div class="col-lg-5">
                <input type="text" class="form-control" name="amount" value="${(financeProductSubscribe.amount)!!}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">利息收益：</label>
            <div class="col-lg-5">
                <input type="text" class="form-control" name="interest" value="${(financeProductSubscribe.interest)!!}"
                />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">开始时间：</label>
            <div class="col-lg-5">
                <input type="text" class="form-control time" name="startDate"
                       value="11" readonly
                />
                <!--${(financeProductSubscribe.startDate?string('yyyy-MM-dd'))!!}  -->
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">截止时间：</label>
            <div class="col-lg-5">
                <input type="text" class="form-control time" name="endDate"
                       value="11" readonly
                />
                <!--${(financeProductSubscribe.endDate?string('yyyy-MM-dd'))!!}  -->
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">私募合同：</label>
            <div class="col-lg-5">
                <div id="urlfilelink" style="text-align:left">
                    <input type="file" id="filelink_upload">
                    <input type="hidden" name="comment" id="filelink"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">风险揭示书：</label>
            <div class="col-lg-5">
                <div id="riskReveallink" style="text-align:left">
                    <input type="file" id="riskReveal_upload">
                    <input type="hidden" name="riskReveal" id="riskReveal"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label"></label>
            <div class="col-lg-5">
                <button type="submit" class="btn btn-primary btn-sm" id="submitbtn">签署合同</button>
            </div>
        </div>
    </form>

</div>
<script type="text/javascript">
    $(function () {
        $('.time').datetimepicker({
            format: 'yyyy-mm-dd',
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0,
            autoclose: 1
        }).on('changeDate', function (ev) {
            $(this).focus();
            $('.time').datetimepicker('hide');
            $('#addAccountForm').bootstrapValidator('revalidateField', 'startDate');
            $('#addAccountForm').bootstrapValidator('revalidateField', 'endDate');
        });


        $('#addAccountForm')
                .bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        amount: {
                            validators: {
                                notEmpty: {
                                    message: '购买金额不能为空'
                                },
                                regexp: {
                                    regexp: /^[0-9]+$/,
                                    message: '购买金额格式不正确'
                                }
                            }
                        },
                        interest: {
                            validators: {
                                notEmpty: {
                                    message: '利息收益不能为空'
                                },
                                regexp: {
                                    regexp: /^[0-9]+$/,
                                    message: '利息收益格式不正确'
                                }
                            }
                        },
                        startDate: {
                            validators: {
                                notEmpty: {
                                    message: '开始时间不能为空'
                                }
                            }
                        },
                        endDate: {
                            validators: {
                                notEmpty: {
                                    message: '截止时间不能为空'
                                }
                            }
                        },
                        comment: {
                            validators: {
                                notEmpty: {
                                    message: '待签署文档不能为空'
                                }
                            }
                        }
                    }
                })
                .on('success.form.bv', function (e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    $.post($form.attr('action'), $form.serialize(), function (result) {
                        if (result.code == 0) {
                            alert(result.msg);
                            window.location.href = "<%=basePath%>financeProductFunds/financeProductSubscribe?financeProductFundsId=" +${(financeProductSubscribe.productId)};
                        } else {
                            alert(result.msg);
                            $("#submitbtn").removeAttr("disabled");
                        }
                    }, 'json');
                });


        $('#riskReveal_upload').uploadify({
            'swf': '${base }/resources/uploadify/uploadify.swf', //指定上传控件的主体文件，默认‘uploader.swf’
            'uploader': '${base }/financeProductFunds/contractfile', //指定服务器端上传处理文件
            'auto': true, //手动上传
            'buttonImage': '${base }/resources/uploadify/uploadify-browse.png', //浏览按钮背景图片
            'multi': false, //单文件上传
            'fileTypeExts': '*.pdf', //允许上传的文件后缀
            'fileSizeLimit': '300MB', //上传文件的大小限制，单位为B, KB, MB, 或 GB
            'successTimeout': 30, //成功等待时间
            'queueSizeLimit': 1,
            'fileObjName': 'file',
            'onUploadSuccess': function (file, data,
                                         response) {//每成功完成一次文件上传时触发一次
                var image = eval("[" + data + ']')[0];
                $(".upload_riskReveal").remove();
                $('#riskReveallink').append("<div id=" + image.msg + " class='upload_riskReveal'> <a href=<%=basePath%>" + image.msg + " target='_black'>" + image.msg + "</a> " +
                        "<a href=javascript:delimg('" + image.msg + "','riskReveal')>删除</a> </div>");
                $("#riskReveal").val(image.msg);
            },
            'onUploadError': function (file, data, response) {//当上传返回错误时触发
                $('#riskReveallink').append("<li>" + data + "</li>");

            }
        });

        $('#filelink_upload').uploadify({
            'swf': '${base }/resources/uploadify/uploadify.swf', //指定上传控件的主体文件，默认‘uploader.swf’
            'uploader': '${base }/financeProductFunds/contractfile', //指定服务器端上传处理文件
            'auto': true, //手动上传
            'buttonImage': '${base }/resources/uploadify/uploadify-browse.png', //浏览按钮背景图片
            'multi': false, //单文件上传
            'fileTypeExts': '*.pdf', //允许上传的文件后缀
            'fileSizeLimit': '300MB', //上传文件的大小限制，单位为B, KB, MB, 或 GB
            'successTimeout': 30, //成功等待时间
            'queueSizeLimit': 1,
            'fileObjName': 'file',
            'onUploadSuccess': function (file, data,
                                         response) {//每成功完成一次文件上传时触发一次
                var image = eval("[" + data + ']')[0];
                $(".uploadvedio").remove();
                $('#urlfilelink').append("<div id=" + image.msg + " class='uploadvedio'> <a href=<%=basePath%>" + image.msg + " target='_black'>" + image.msg + "</a> " +
                        "<a href=javascript:delimg('" + image.msg + "','filelink')>删除</a> </div>");
                $("#filelink").val(image.msg);
            },
            'onUploadError': function (file, data, response) {//当上传返回错误时触发
                $('#urlfilelink').append("<li>" + data + "</li>");

            }
        });



    });

    <!--删除图片-->
    function delimg(obj, tval) {
        var url = "<%=basePath%>upload/delimg";
        $.post(url, {'imgpath': obj}, function (data) {
            if (data.code == 0) {
                document.getElementById(obj).remove();
                document.getElementById(tval).value = "";
            }
        });
    }
</script>
</body>
</html>
