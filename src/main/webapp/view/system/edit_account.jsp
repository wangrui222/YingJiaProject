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
	href="<%=basePath%>resources/sys/ying/iconfont.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">
<script type="text/javascript"
	src="<%=basePath%>resources/sys/js/jquery.js"></script>
<title>后台首页</title>
</head>
<body>
	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>修改用户
		</h2>
		<form id="updateAccountForm" method="post" class="form-horizontal"
			action="<%=basePath%>lddsystem/system/updateAccount" name="form">
			<input type="hidden" name="usersId" value="${object[0]}">
			<% String name=request.getSession().getAttribute("usersname").toString(); %>	
			<input type="hidden" id="name" name="name" value="<%=name %>">
			<div class="form-group">
				<label class="col-sm-3 control-label">用户名</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="userName"
						 value="${object[1]}" readonly="readonly" id="uname"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">密码</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="usersPassword"/>
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">手机号</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="mobilePhone"
						value="${object[3]}" />
				</div>
			</div>
			<div class="form-group">
				<div class="group">
					<label class="col-sm-3 control-label">角色</label>
					<div class="col-lg-5">

						<select id="wy_provice" name="roleId" data-bv-notempty
							data-bv-notempty-message="请选择角色" class="form-control">
							<option value="">选择角色</option>
							<c:forEach items="${rolelist}" var="rolelist">
								<option value="${rolelist.userRoleId}">${rolelist.cname}</option>
							</c:forEach>
						</select>

					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label"></label>
				<div class="col-lg-5">
					<button type="submit" class="btn btn-primary btn-sm" onclick="out();">确认</button>
				</div>
			</div>
		</form>

	</div>
	<script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript">

$(document).ready(function() {	
   $('#updateAccountForm')
        .bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
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
function out() {
 	var loginuserName=document.getElementById("name").value;
	var uname=document.getElementById("uname").value;
	if (loginuserName==uname) {
		var r = confirm('您正在修改当前登陆账户信息，你确定这么做吗?');
		if(r){
			alert("修改成功，需要重新登陆！");	
		}else{
			document.getElementById("name").value="";
		}
		
	}
	<%-- $.ajax({
		type : "POST", // 用POST方式传输
		url:'<%=basePath%>lddsystem/system/checkusersExsit',
				data : {				
					"userName" : userName,
				},
				success : function(data) {			
					if(data.code == '0'){
						$(".msg").html(data.msg).show();
					}else if(data.code == '1'){					
						$(".msg").html(data.msg).show();
						
					}
				}
			}); --%>
};
</script>

</body>
</html>
