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
    <link rel="stylesheet" href="<%=basePath%>resources/sys/webupload/webuploader.css">
    <link rel="stylesheet" href="<%=basePath%>resources/sys/webupload/demo.css">
    <link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">

    <script type="text/javascript" src="${base }/resources/uploadify/jquery.min.js"></script>
    <script src="${base }/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${base }/resources/uploadify/uploadify.css">

    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/lang/zh-cn/zh-cn.js"></script>
    <title>后台首页</title>
</head>
<body>

<div class="box-right-main">
    <h2>
        <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>添加资讯
    </h2>

    <form action="<%=basePath%>news/editNews" method="post" id="valForm">
        <input type="hidden" name="id" value="${(news.id)!!}">
        <div class="tablelist">
            <!-- 表单 -->
            <div class="row bdlist">
                <div class="col-md-9">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">所属类别<b style="color: red;">*</b>：</label>

                        <div class="col-sm-9">
                            <select name="typeid" id="typeid" disabled="disabled" class="selectpicker form-control">
                            <#list newsTypes as nt>
                                <option value="${nt.id}">${nt.name}</option>
                            </#list>
                            </select>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">标题<b style="color: red;">*</b>：</label>

                        <div class="col-sm-9">
                            <input class="form-control" type="text" name="title" id="textfield"
                                   value="${(news.title)!!}"/>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">排序：<b style="color: red;">*</b>：</label>

                        <div class="col-sm-9">
                            <input class="form-control" type="text" name="sort" id="textfield2"
                                   value="${(news.sort)!!}"/>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">显示属性：</label>

                        <div class="col-sm-9">
                            <p><input type="checkbox" id="plactop" name="plactop" value="0">是否置顶</p>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">简介：</label>

                        <div class="col-sm-9">
                            <textarea class="form-control" name="info" id="textarea" cols="45"
                                      rows="2">${(news.info)!!}</textarea>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group link">
                        <label class="col-sm-3 control-label">链接地址：<b style="color: red;">*</b>：</label>

                        <div class="col-sm-9">
                            <input class="form-control" type="text" name="link" value="${(news.link)!!}" placeholder="h5/v1/finance/product/detail?type=GUSHOU&productId=1"/>
                            <span >固收类:GUSHOU</span><br>
                            <span >私募类:SIMU</span><br>
                            <span >股权类:GUQUAN</span><br>
                            <span >海外配置类:OVERSEA</span><br>
                            <span >ID:查看列表ID字段</span>
                        </div>
                    </div>
                    <div class="form-group cphoto">
                        <label class="col-sm-3 control-label">封面图片：</label>

                        <div class="col-sm-9">
                            <div id="url" style="text-align:left">
                                <input type="file" name="file_upload" id="file_upload">
                                <input type="hidden" name="cphoto" id="cphoto"/>
                            </div>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                    <div class="form-group filelink">
                        <label class="col-sm-3 control-label">视频/音频：</label>

                        <div class="col-sm-9">
                            <div id="urlfilelink" style="text-align:left">
                                <input type="file" name="filelink1" id="filelink_upload">
                                <input type="hidden" name="filelink" id="filelink"/>
                            </div>
                            <span style="visibility: hidden">验证提示预留位置</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row bdlist text">
            <div class="col-md-12">
                <h2>
                    <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>内容
                </h2>
                <div>
                    <div><textarea name="text" id="editor"
                                   style="width: 100%;height: 200px;">${(news.text)!!}</textarea></div>
                    <script type="text/javascript"> var ue = UE.getEditor('editor');</script>
                </div>
            </div>
        </div>

        <div class="tablebaocun">
            <br>
            <button type="submit" class="btn btn-primary btn-sm"
                    style="margin-left: 40%; margin-bottom: 20px; padding: 10px 30px">保存
            </button>
        </div>
    </form>
    <!-- 内容结束 -->
</div>
<script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
<!-- 容器结束 -->
<script type="text/javascript">
    $(function () {
        $("#typeid").val("${(news.typeid)!!}");
        $("input:checkbox[value='${(news.plactop)!!}']").attr('checked', 'checked');
        if ("${(news.cphoto)!!}" != null && "${(news.cphoto)!!}" != "") {
            $('#url').append("<div id='${(news.cphoto)!!}' class='uploadimg'> <img width=50 height=50 src='<%=basePath%>${(news.cphoto)!!}' /> " +
                    "<a href=javascript:delimg('${(news.cphoto)!!}')>删除</a> </div>");
            $("#cphoto").val("${(news.cphoto)!!}");
        }
        if ("${(news.filelink)!!}" != null && "${(news.filelink)!!}" != "") {
            $('#urlfilelink').append("<div id='${(news.filelink)!!}' class='uploadvedio'> <a href='<%=basePath%>${(news.filelink)!!}' target='_black'>${(news.filelink)!!}</a> " +
                    "<a href=javascript:delimg('${(news.filelink)!!}','filelink')>删除</a> </div>");
            $("#filelink").val("${(news.filelink)!!}");
        }


        var type = $("#typeid").val();
        if ((type == '2')||(type == '16')||(type == '17')) {
            $(".link").hide();
            $(".cphoto").show();
            $(".filelink").show();
            $(".text").hide();
            $("input[name='link']").attr("disabled", true);
            $("input[name='cphoto']").attr("disabled", false);
            $("input[name='filelink']").attr("disabled", false);
            $("input[name='text']").attr("disabled", true);
        } else if ((type == '12') || (type == '13')) {
            $(".link").hide();
            $(".cphoto").show();
            $(".filelink").hide();
            $(".text").hide();
            $("input[name='link']").attr("disabled", true);
            $("input[name='cphoto']").attr("disabled", false);
            $("input[name='filelink']").attr("disabled", true);
            $("input[name='text']").attr("disabled", true);
        } else if ((type == '18')) {
            $(".link").show();
            $(".cphoto").show();
            $(".filelink").hide();
            $(".text").hide();
            $("input[name='link']").attr("disabled", false);
            $("input[name='cphoto']").attr("disabled", false);
            $("input[name='filelink']").attr("disabled", true);
            $("input[name='text']").attr("disabled", true);
        } else {
            $(".link").hide();
            $(".cphoto").hide();
            $(".filelink").hide();
            $(".text").show();
            $("input[name='link']").attr("disabled", true);
            $("input[name='cphoto']").attr("disabled", true);
            $("input[name='filelink']").attr("disabled", true);
            $("input[name='text']").attr("disabled", false);
        }

        $('#valForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                title: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '标题不能为空!'
                        },
                        stringLength: {
                            min: 2,
                            max: 100,
                            message: '标题长度为2-100个字符!'
                        }
                    }
                },
                sort: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '排序不能为空!'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: '排序为数字!'
                        }
                    }
                },
                info: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '简介不能为空!'
                        },
                        stringLength: {
                            min: 2,
                            max: 100,
                            message: '简介长度为2-100个字符!'
                        }
                    }
                },
                link: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '链接地址不能为空!'
                        },
                        stringLength: {
                            min: 2,
                            max: 100,
                            message: '链接地址为2-100个字符!'
                        }
                    }
                },
                cphoto: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '封面图片不能为空!'
                        }
                    }
                },
                filelink: {
                    message: '',
                    validators: {
                        notEmpty: {
                            message: '视频不能为空!'
                        }
                    }
                }
            }

        });


        $('#file_upload').uploadify({
            'swf': '${base }/resources/uploadify/uploadify.swf', //指定上传控件的主体文件，默认‘uploader.swf’
            'uploader': '${base }/upload/fileupload', //指定服务器端上传处理文件
            'auto': true, //手动上传
            'buttonImage': '${base }/resources/uploadify/uploadify-browse.png', //浏览按钮背景图片
            'multi': false, //单文件上传
            'fileTypeExts': '*.gif; *.jpg; *.png;', //允许上传的文件后缀
            'fileSizeLimit': '300MB', //上传文件的大小限制，单位为B, KB, MB, 或 GB
            'successTimeout': 30, //成功等待时间
            'queueSizeLimit': 1,
            'fileObjName': 'file',
            'onUploadSuccess': function (file, data,
                                         response) {//每成功完成一次文件上传时触发一次
                var image = eval("[" + data + ']')[0];
                $(".uploadimg").remove();
                $('#url').append("<div id=" + image.msg + " class='uploadimg'> <img width=50 height=50 src=<%=basePath%>" + image.msg + " /> " +
                        "<a href=javascript:delimg('" + image.msg + "','cphoto')>删除</a> </div>");
                $("#cphoto").val(image.msg);
            },
            'onUploadError': function (file, data, response) {//当上传返回错误时触发
                $('#url').append("<li>" + data + "</li>");

            }
        });

        $('#filelink_upload').uploadify({
            'swf': '${base }/resources/uploadify/uploadify.swf', //指定上传控件的主体文件，默认‘uploader.swf’
            'uploader': '${base }/upload/videofile', //指定服务器端上传处理文件
            'auto': true, //手动上传
            'buttonImage': '${base }/resources/uploadify/uploadify-browse.png', //浏览按钮背景图片
            'multi': false, //单文件上传
            'fileTypeExts': '*.avi;*.rmvb;*.rm;*.asf;*.divx;*.mpg;*.mpeg;*.mpe;*.wmv;*.mp4;*.mkv;*.vob;*.wav;*.mp3;*.wma;*.flac;*.ape;*.aac;*.ogg;', //允许上传的文件后缀
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