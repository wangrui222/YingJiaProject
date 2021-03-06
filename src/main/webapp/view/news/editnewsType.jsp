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
        <title>后台首页</title>
    </head>
    <body>

    <div class="box-right-main">
        <h2>
            <span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>编辑资讯分类
        </h2>

        <form action="<%=basePath%>newsType/editNewsType" method="post" id="valForm">
        <input type="hidden" name="id" value="${(newstype.id)!!}">
            <div class="tablelist">
                <!-- 表单 -->
                <div class="row bdlist">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">上级类别<b style="color: red;">*</b>：</label>

                            <div class="col-sm-9">
                               <select  class="selectpicker form-control" name="suptype" id="suptype">
                               		<option value="0">根类别</option>
									<#list newsTypes as nt>	
									<option value="${nt.id}">${nt.name}</option>
									</#list>
								</select>
                                <span style="visibility: hidden">验证提示预留位置</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">类别名称<b style="color: red;">*</b>：</label>

                            <div class="col-sm-9">
                                <input class="form-control"  type="text" name="name" id="textfield"  value="${(newstype.name)!!}"/>
                                <span style="visibility: hidden">验证提示预留位置</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">排序<b style="color: red;">*</b>：</label>

                            <div class="col-sm-9">
                               <input class="form-control"  type="text" name="sort" id="textfield2"  value="${(newstype.sort)!!}"/>
                                <span style="visibility: hidden">验证提示预留位置</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">简介：</label>

                            <div class="col-sm-9">
                               <textarea class="form-control"  name="info" id="textarea" cols="45" rows="2">${(newstype.info)!!}</textarea>
                                <span style="visibility: hidden">验证提示预留位置</span>
                            </div>
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
    <script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
    <!-- 容器结束 -->
    <script type="text/javascript">
		$(function() {
			$("#suptype").val("${(newstype.suptype)!!}");
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
			            	}
		          }
		          
			 });
		});
		
	</script> 
    </body>
    </html>