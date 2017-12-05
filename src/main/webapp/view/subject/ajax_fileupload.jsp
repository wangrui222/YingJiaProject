<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-12">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>标的附件
		</h2>

		<form action="<%=basePath%>subject/sys/attchment"
			enctype="multipart/form-data" method="post" class="attachmentForm">
			<label class="control-label col-sm-3 ">图片预览</label> <input
				id="input-24" type="file" multiple class="file-loading" name="files">
			<input type="hidden" name="folderId" value="${(folderId)!!}">
		</form>
	</div>


	<script src='<%=basePath%>resources/dist/js/jquery.min.js'></script>
	<script src='<%=basePath%>resources/js/jquery.form.js'></script>
	<script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
	<script src="<%=basePath%>resources/bootstrap-fileinput/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="<%=basePath%>resources/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js"
		type="text/javascript"></script>
	<script src="<%=basePath%>resources/bootstrap-fileinput/js/fileinput.min.js"
		type="text/javascript"></script>
	<script
		src="<%=basePath%>resources/bootstrap-fileinput/js/fileinput_locale_LANG.js"
		type="text/javascript"></script>
	<script
		src="<%=basePath%>resources/bootstrap-fileinput/js/fileinput_locale_zh.js"
		type="text/javascript"></script>

	<link rel="stylesheet"
		href="<%=basePath%>resources/date/bootstrap-datetimepicker.min.css">
	<script type="text/javascript"
		src="<%=basePath%>resources/date/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="<%=basePath%>resources/date/bootstrap-datetimepicker.zh-CN.js"
		charset="UTF-8"></script>

	<script type="text/javascript">
 $(function () {
	 		/* <#if subjectFiles?? > */
  			$("#input-24").fileinput({
                initialPreview: [
                    <#list subjectFiles as file>
                       /*  '<img src="<%=basePath%>${file.path}/${file.fileName}" class="file-preview-image" >'+
                        '<a href="javascript:delimg(${file.id})" id="${file.id}">删除</a>', */
                    </#list>
                ],
                language: "zh",
                overwriteInitial: false,
                maxFileSize: 1000,
                allowedFileTypes: ["image"],
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                initialCaption: "选择上传的附件图片",
            });
			</#if>
            $("#input-24").closest("form").ajaxForm(function (data) {
                $(".attachmentForm :submit").attr("disabled","disabled");
                $(":input[name=folderId]").val(data);
                alert("上传成功");
            })
        });
        
        
        function delimg(imgid){
        	var url="<%=basePath%>subject/sys/editViewJson";		
        	$.get(url,/* {'imgid':imgid,'folderId':${(folderId)!!}} */"",function(data){
        		$(".ajaxContainer").empty();
    			$(".ajaxContainer").append(data);
        	}); 
        }
    </script>
</body>
</html>
