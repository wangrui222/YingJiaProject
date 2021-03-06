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
	    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/ueditor.all.js"> </script>
	    <script type="text/javascript" charset="utf-8" src="<%=basePath%>resources/ueditor1_4_3_1/lang/zh-cn/zh-cn.js"></script>
        <title>后台首页</title>
    </head>
    <body>

    <div class="box-right-main">
        <h2>
            <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>添加公告
        </h2>

        <form action="<%=basePath%>setting/addNotice" method="post" id="valForm">
       	<div class="tablelist">
           <div class="row bdlist">
               <div class="col-md-6">
			 		<div class="form-group">
                    <label class="col-sm-1 control-label">标题<b style="color: red;">*</b>：</label>
                    <div class="col-sm-9">
                        <input class="form-control"  type="text" name="title" id="textfield" />
                        <span style="visibility: hidden">验证提示预留位置</span>
                    </div>
                	</div>
    			</div>
       	 	</div>
        </div>
       	<div class="row bdlist">
            <div class="col-md-12">
		        <h2>
		            <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>内容
		        </h2>
		        <div>
				    <div><textarea name="content" id="editor" style="width: 80%;height: 300px;"></textarea></div>
	    			<script type="text/javascript"> var ue = UE.getEditor('editor');</script>
				</div>
         	</div>
        </div>
         <div class="tablebaocun">
         	  <br>
              <button type="submit" class="btn btn-primary btn-sm" style="margin-left: 30%; margin-bottom: 20px; padding: 10px 30px">保存</button>
         </div>
        </form> 
        <!-- 内容结束 -->
    </div>
   <script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
   <!-- 容器结束 -->
   <script type="text/javascript">
		$(function() {
			
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
		            	}
		          }
		          
			 }).on('success.form.bv', function(e) {
		            // Prevent form submission
		            e.preventDefault();
		            // Get the form instance
		            var $form = $(e.target);
		            // Get the BootstrapValidator instance
		            var bv = $form.data('bootstrapValidator');
		            // Use Ajax to submit form data
		            $.post($form.attr('action'), $form.serialize(), function(result) {
		            	alert(result.msg);
		            	window.location.href="<%=basePath%>setting/noticelist";
		            }, 'json');
		        });
		
	});
	</script> 
	</body>
	</html>