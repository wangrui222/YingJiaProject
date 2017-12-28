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
<script type="text/javascript" src="<%=basePath%>resources/sys/js/jquery.js"></script>
<title>后台首页</title>
</head>
<body>
	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>添加角色
		</h2>

		<form id="addroleForm" class="form-horizontal col-xs-pull-3" 
			name="addroleForm" method="post" action="<%=basePath%>lddsystem/system/addRole">
			<div class="form-group">
				<label class="col-sm-3 control-label">角色名</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="cname" id="cname" onchange="change();" clientidmode="Static"/>
					<p class="msg"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">英文名</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="ename" id="ename" />
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">描述</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="remark" id="remark" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label"></label>
				<div class="col-lg-5">
					<button type="submit" class="btn btn-primary btn-sm">确认</button>
				</div>
			</div>
		</form>
	</div>

	<script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript">
$(document).ready(function() {
    $('#addroleForm')
        .bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	cname: {
                    message: '角色名不能为空',
                    validators: {
                        notEmpty: {
                            message: '角色名不能为空'
                        }
                    }
                },
                ename: {
                    validators: {
                        notEmpty: {
                            message: '权限不能为空'
                        }
                    }
                }
            }
        })
        
});
function change() {
	var cname=document.getElementById("cname").value;	
	$.ajax({
		type : "POST", // 用POST方式传输
		url:'<%=basePath%>lddsystem/system/checkUserRole',
				data : {
					"cname" : cname,
				},
				success : function(data) {			
					if(data.code ==0){					
						$(".msg").html(data.msg).show();					
					}else if(data.code ==1){
						document.getElementById("cname").value="";
						$(".msg").html(data.msg).show();
					}
				}
			});
		}
	</script>
</script>
</body>
</html>
