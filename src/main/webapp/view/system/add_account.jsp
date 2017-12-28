
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=basePath%>/resources/sys/ying/iconfont.css">
<link rel="stylesheet"
	href="<%=basePath%>/resources/sys/style/bootstrap.css">
<link rel="stylesheet"
	href="<%=basePath%>/resources/sys/style/style.css">

<title>后台首页</title>
</head>
<body>
	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>添加用户
		</h2>
		<form id="saveaccount" method="post" class="form-horizontal"
			action="<%=basePath%>lddsystem/system/createAccount">
			<div class="form-group">
				<label class="col-sm-3 control-label">用户名</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" id="uname" name="userName"
						onchange="change();" clientidmode="Static"/>
						<p class="msg"></p>
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">密码</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="usersPassword" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">重复密码</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="confirmPassword" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">手机号</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="mobilePhone" />
				</div>
			</div>
			<div class="form-group">
				<div class="group">
					<label class="col-sm-3 control-label">角色</label>
					<div class="col-lg-5">
						<select id="wy_provice" name="roleId" data-bv-notempty
							data-bv-notempty-message="请选择角色" class="form-control">
							<option value="">选择角色</option>
							<c:forEach items="${list}" var="list">
								<option value="${list.userRoleId}">${list.cname}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label"></label>
				<div class="col-lg-5">
					<input type="submit" class="btn btn-primary btn-sm" value="确认">
				</div>
			</div>
		</form>

	</div>
	<script src="<%=basePath%>/resources/dist/js/jquery.min.js"></script>
	<script src="<%=basePath%>/resources/dist/js/bootstrapValidator.js"></script>
	<script type="text/javascript">
$(document).ready(function() {
	$('#saveaccount').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	userName: {
                    message: '用户名不能为空',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 2,
                            max: 30,
                            message: '用户名长度必须为2-30个字符'
                        }
                    }
                },
                usersPassword: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: '确认密码不能为空'
                        },
                        identical: {
                            field: 'usersPassword',
                            message: '两次密码不一致'
                        }
                    }
                },
                mobilePhone: {
                    validators: {
                        notEmpty: {
                            message: '手机号不能为空'
                        },
                        regexp: {
                            regexp: /^1[3-9][0-9]\d{8}$/,
                            message: '手机号格式不正确'
                        }
                    }
                }
            }
        })
      
});

function change() {
	var uname=document.getElementById("uname").value;	
	$.ajax({
		type : "POST", // 用POST方式传输
		url:'<%=basePath%>lddsystem/system/checkUserExsit',
				data : {
					"userName" : uname,
				},
				success : function(data) {			
					if(data.code==0){
						$(".msg").html(data.msg).show();
					}else if(data.code==1){
						document.getElementById("uname").value="";
						$(".msg").html(data.msg).show();
						
					}
				}
			});
		}
	</script>
</body>
</html>
