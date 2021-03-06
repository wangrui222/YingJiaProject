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

<script type="text/javascript"
	src="${base }/resources/uploadify/jquery.min.js"></script>
<script src="${base }/resources/uploadify/jquery.uploadify.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${base }/resources/uploadify/uploadify.css">
<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>编辑资讯分类
		</h2>

		<form action="<%=basePath%>newsType/editNewsType" method="post"
			id="valForm">
			<input type="hidden" name="id" value="${(newstype.id)!!}">
			<div class="tablelist">
				<!-- 表单 -->
				<div class="row bdlist">
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-sm-3 control-label">上级类别<b
								style="color: red;">*</b>：
							</label>

							<div class="col-sm-9">
								<select class="selectpicker form-control" name="suptype"
									id="suptype">
									<option value="0">根类别</option> <#list newsTypes as nt>
									<option value="${nt.id}">${nt.name}</option> </#list>
								</select> <span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">类别名称<b
								style="color: red;">*</b>：
							</label>

							<div class="col-sm-9">
								<input class="form-control" type="text" name="name"
									id="textfield" value="${(newstype.name)!!}" /> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">排序<b
								style="color: red;">*</b>：
							</label>

							<div class="col-sm-9">
								<input class="form-control" type="text" name="sort"
									id="textfield2" value="${(newstype.sort)!!}" /> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">页面SEO标题：</label>

							<div class="col-sm-9">
								<textarea class="form-control" name="seotitle" id="textarea2"
									cols="45" rows="2">${(newstype.seotitle)!!}</textarea>
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">简介：</label>

							<div class="col-sm-9">
								<textarea class="form-control" name="info" id="textarea"
									cols="45" rows="2">${(newstype.info)!!}</textarea>
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">内容选项：</label>

							<div class="col-sm-9">
								<textarea class="form-control" name="text" id="textarea3"
									cols="45" rows="2">${(newstype.text)!!}</textarea>
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
					</div>


					<div class="col-md-6">

						<div class="form-group">
							<label class="col-sm-3 control-label">链接地址</label>

							<div class="col-sm-9">
								<input class="form-control" type="text" name="link"
									id="textfield3" value="${(newstype.link)!!}" /> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">备注</label>

							<div class="col-sm-9">
								<input class="form-control" type="text" name="note"
									id="textfield4" value="${(newstype.note)!!}" /> <span
									style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">页面类型</label>

							<div class="col-sm-9">
								<p align="left">
									<input type="radio" name="pagetype" id="radio" value="列表" />列表
									<input type="radio" name="pagetype" id="radio2" value="单页" />
									单页
								</p>
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group raiseStart">
							<label class="col-sm-3 control-label">页面SEO描述：</label>

							<div class="col-sm-9">
								<textarea class="form-control" name="seodes" id="textarea2"
									cols="45" rows="2">${(newstype.seodes)!!}</textarea>
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group raiseEnd">
							<label class="col-sm-3 control-label">页面SEO关键字：</label>

							<div class="col-sm-9">
								<textarea class="form-control" name="seokey" id="textarea3"
									cols="45" rows="2">${(newstype.seokey)!!}</textarea>
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">封面图片：</label>

							<div class="col-sm-9">
								<div id="url">
									<input type="file" name="file_upload" id="file_upload">
									<input type="hidden" name="cphoto" id="cphoto" />
								</div>
								<span style="visibility: hidden">验证提示预留位置</span>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="tablebaocun">
				<br>
				<button type="submit" class="btn btn-primary btn-sm"
					style="margin-left: 40%; margin-bottom: 20px; padding: 10px 30px">保存</button>
			</div>
		</form>
		<!-- 内容结束 -->
	</div>
	<script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
	<!-- 容器结束 -->
	<script type="text/javascript">
		$(function() {
			$("#suptype").val("${(newstype.suptype)!!}");
			$("input:radio[value='${(newstype.pagetype)!!}']").attr('checked','checked');
			if("${newstype.cphoto}"!=null&&"${newstype.cphoto}"!=""){
				$('#url').append("<div id='${newstype.cphoto}' class='uploadimg'> <img width=50 height=50 src='<%=basePath%>${newstype.cphoto}' /> "+
						"<a href=javascript:delimg('${newstype.cphoto}')>删除</a> </div>");
				$("#cphoto").val("${newstype.cphoto}");
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
		                            message: '类别名称不能为空!'
		                        },
		                        stringLength: {
		                            min: 2,
		                            max: 100,
		                            message: '类别名称长度为2-100个字符!'
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
		            	}
		          }
		          
			 });
		
		
		$('#file_upload').uploadify({
			'swf' : '${base }/resources/uploadify/uploadify.swf', //指定上传控件的主体文件，默认‘uploader.swf’
			'uploader' : '${base }/upload/fileupload', //指定服务器端上传处理文件
			'auto' : true, //手动上传
			'buttonImage' : '${base }/resources/uploadify/uploadify-browse.png', //浏览按钮背景图片
			'multi' : false, //单文件上传
			'fileTypeExts' : '*.gif; *.jpg; *.png;', //允许上传的文件后缀
			'fileSizeLimit' : '300MB', //上传文件的大小限制，单位为B, KB, MB, 或 GB
			'successTimeout' : 30, //成功等待时间
			'queueSizeLimit' : 1,
			'fileObjName':'file',
			'onUploadSuccess' : function(file, data,
					response) {//每成功完成一次文件上传时触发一次
				var image=eval("["+data+']')[0];
				$(".uploadimg").remove();
				$('#url').append("<div id="+image.msg+" class='uploadimg'> <img width=50 height=50 src=<%=basePath%>"+image.msg+" /> "+
						"<a href=javascript:delimg('"+image.msg+"')>删除</a> </div>");
				$("#cphoto").val(image.msg);
			},
			'onUploadError' : function(file, data, response) {//当上传返回错误时触发
				$('#url').append("<li>" + data + "</li>");
				
			}								
		});
		
		});
		<!--删除图片-->
		function delimg(obj){
			var url="<%=basePath%>upload/delimg";		
			$.post(url,{'imgpath':obj},function(data){
					if(data.code==0){
						document.getElementById(obj).remove();	
						document.getElementById("cphoto").value="";
					}
			});
		}
		
	</script>
</body>
</html>
ml>
