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
     <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>修改密码</h2>
	
<form id="savePassword" method="post" class="form-horizontal" action="<%=basePath%>lddsystem/system/savePasswd">
		<%
			String name = request.getSession().getAttribute("usersname").toString();
		%>
		<input type="hidden" id="uname" name="userName" value="<%=name%>">


	<div class="tablelist">
	  <div class="row bdlist">
               <div class="col-md-5">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">原密码：</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="oldpassword" id="oldpwd" placeholder="请输入密码" type="password" onchange="out();" clientidmode="Static">
                                    	<p class="msg"></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">新密码：</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="usersPassword" placeholder="请输入密码" type="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">重复新密码：</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="confirmPassword" placeholder="请输入密码" type="password">
                                    </div>
                                </div>
                                 <div class="form-group">
	                                 <div class="col-sm-9">
	                                 <label class="col-sm-3 control-label"></label>
	                                <button type="submit" class="btn btn-primary btn-sm" style="margin-left:40px;">确认修改</button>
                             		</div>
                             	</div>
                             </div>
     </div>
      </div>
 </form>

</div>
<script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#savePassword').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	oldpassword: {
                    message: '原密码不能为空',
                    validators: {
                        notEmpty: {
                            message: '原密码不能为空'
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: '原密码长度错误'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: '原密码格式错误'
                        }
                    }
                },
                usersPassword: {
                    validators: {
                        notEmpty: {
                            message: '新密码不能为空'
                        },
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: '新密码不能为空'
                        },
                        identical: {
                            field: 'usersPassword',
                            message: '新密码不一致'
                        }
                    }
                }
            }
        })
        
});

function out() {
	var oldpwd=document.getElementById("oldpwd").value;	
	var userName=document.getElementById("uname").value;
	$.ajax({
		type : "POST", // 用POST方式传输
		url:'<%=basePath%>lddsystem/system/checkPasswordExsit',
				data : {
					"oldpassword" : oldpwd,
					"userName" : userName
				},
				success : function(data) {			
					if(data.code==0){
						document.getElementById("oldpwd").value="";
						$(".msg").html(data.msg).show();
					}else if(data.code==1){					
						$(".msg").html(data.msg).show();						
					}
				}
			});
};
</script>
</body>
</html>