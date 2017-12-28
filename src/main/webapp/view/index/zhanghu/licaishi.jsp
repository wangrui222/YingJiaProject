<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon"
	rel="shortcut icon">
<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
<link href="<%=basePath%>resources/web/font/iconfont.css"
	rel="stylesheet">
<script src="<%=basePath%>resources/web/js/jquery.js"></script>
<script src="<%=basePath%>resources/web/echart/dist/echarts.js"></script>

<link href="<%=basePath%>resources/web/images/icon.ico"
	type="image/x-icon" rel="shortcut icon">


<script>
            $(function () {
                $(".picTab a").click(function () {
                    if (!$(this).hasClass("select")) {
                        var num = $(this).index();
                        $(this).addClass("select").siblings().removeClass("select");
                        $(".txtCon p").eq(num).show().siblings().hide();
                    }
                })
                $(".tbConBox .tab a").click(function () {
                    if (!$(this).hasClass("select")) {
                        var num = $(this).index();
                        $(this).addClass("select").siblings().removeClass("select");
                        $("#conBox .box").eq(num).show().siblings().hide();
                    }
                })
            })
            var baseContext = "/winplus";
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

.uploadify {
	left: 0px;
}
</style>
</head>
<body>

		<div class="admin-right">
			<div class="tbConBox">
				<div class="tab">
					<a class="select" href="javascript:;">我是理财师</a>
				</div>
				<div id="conBox">
					<div class="box" style="display: block">
						<div class="remind">
							<strong>理财师身份认证</strong>
						</div>
						
						<form action="<%=basePath%>member/licaishi" method="post"
							id="form1" enctype="multipart/form-data">
							<table class="txTable" width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td width="140" align="right">真实姓名：</td>
									<td><input class="tytxt" type="text" name="financialPlannerName"
										value="${financialplanner.financialPlannerName==null?'':financialplanner.financialPlannerName}" 
										 ${financialplanner.financialPlannerName==null?'':"disabled style='display: inline; width: 250px;'"} /></td>
								</tr>
								<tr>
									<td align="right">机构名称：</td>
									<td><input class="tytxt" type="text" name="orgname"
										value="${financialplanner.orgname==null?'':financialplanner.orgname}"
										${financialplanner.orgname==null?'':"disabled style='display: inline; width: 250px;'"} />
									</td>
										 
								</tr>
								<tr>
									<td align="right">我的名片：</td>
									<td>
									
									<c:if test="${financialplanner.mycard!=null}">
									<img width=50 height=50
										src="<%=basePath%>upload/${financialplanner.mycard}">
									</c:if>
									<c:if test="${financialplanner.mycard==null}">
										<div id="url">
                                               <input type="file"  name="mycards" id="file_upload">
                                               <!-- <input type="hidden" name="mycard" id="cphoto"/> -->
                                        </div>
									
									</c:if>
									</td>

								</tr>

								<tr>
									<td align="right">我的邮寄地址：</td>
									<td><input type="text" class="tytxt" name="address"
										value="${financialplanner.address==null?'':financialplanner.address}" 
										${financialplanner.address==null?'':"disabled style='display: inline; width: 250px;'"} /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									  <td>
                                              <c:if test="${financialplanner!=null}">
                                                  <button type="button" class="tybutton" style="background-color: #2c5976">认证成功</button>
                                              </c:if>
                                               <c:if test="${financialplanner==null}">
                                                  <button type="submit" class="tybutton">提交</button>
                                              </c:if>
                                      </td>
								</tr>
								
								
                                          
                              
							</table>
						</form>
						
						
					</div>
				</div>
			</div>
		</div>


	<div class="modal fade errorInfo infoModal" id="withdrawErrorModal"
		role="dialog">
		<div class="modal-dialog">
			<div class="modal-content jddModalContnt"
				style="border-radius: 0px; width: 400px;">
				<div class="modal-header">
					<span>通知</span>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="withdrawError"></div>
					<button class="btn btn-success confirmBtn" data-dismiss="modal">确认</button>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
                $(function(){
                    $("#withdrawConfirm").click(function () {
                        var name = $("input[name='name']").val();
                        var orgname = $("input[name='orgname']").val();
                        var mycard = $("input[name='mycard']").val();
                        var address = $("input[name='address']").val();
                        if ($.trim(name) == "") {
                            $("#withdrawError").html("请填写真实姓名");
                            $("#withdrawErrorModal").modal();
                            $("input[name='name']").focus();
                            return;
                        }
                        if ($.trim(orgname) == "") {
                            $("#withdrawError").html("请填写机构名称");
                            $("#withdrawErrorModal").modal();
                            $("input[name='orgname']").focus();
                            return;
                        }
                        if ($.trim(mycard) == "") {
                            $("#withdrawError").html("请上传名片");
                            $("#withdrawErrorModal").modal();
                            return;
                        }
                        if ($.trim(address) == "") {
                            $("#withdrawError").html("请填写邮寄地址");
                            $("#withdrawErrorModal").modal();
                            $("input[name='address']").focus();
                            return;
                        }
                        $("#withdrawConfirm").addClass("disabled");
                        $("#form1").submit();
                    });

                    $('#file_upload').uploadify({
                        'swf': '/winplus/resources/uploadify/uploadify.swf', //指定上传控件的主体文件，默认‘uploader.swf’
                        'uploader': '/winplus/upload/fileupload', //指定服务器端上传处理文件
                        'auto': true, //手动上传
                        'buttonImage': '/winplus/resources/uploadify/uploadify-browse.png', //浏览按钮背景图片
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
                            $('#url').append("<div id=" + image.msg + " class='uploadimg'> <img width=50 height=50 src=/winplus/" + image.msg + " /> " +
                                    "<a href=javascript:delimg('" + image.msg + "','cphoto')>删除</a> </div>");
                            $("#cphoto").val(image.msg);
                        },
                        'onUploadError': function (file, data, response) {//当上传返回错误时触发
                            $('#url').append("<li>" + data + "</li>");

                        }
                    });


                });

                function delimg(obj, tval) {
                    var url = "/winplus/upload/delimg";
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