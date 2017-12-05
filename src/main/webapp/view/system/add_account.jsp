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
        <link rel="stylesheet" href="<%=basePath%>/resources/sys/ying/iconfont.css">
        <link rel="stylesheet" href="<%=basePath%>/resources/sys/style/bootstrap.css">
        <link rel="stylesheet" href="<%=basePath%>/resources/sys/style/style.css">
        <script type="text/javascript" src="<%=basePath%>/resources/sys/js/jquery.js"></script>
	<title>后台首页</title>
</head>
<body>
    <div class="box-right-main">
     <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>添加用户</h2>
	<form id="addAccountForm" method="post" class="form-horizontal" action="<%=basePath%>/sys/createAccount">
           <div class="form-group">
               <label class="col-sm-3 control-label">用户名</label>
               <div class="col-lg-5">
                   <input type="text" class="form-control" name="userName" id="userName"/>
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-3 control-label">密码</label>
               <div class="col-lg-5">
                   <input type="password" class="form-control" name="password"
                          />
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-3 control-label">重复密码</label>
               <div class="col-lg-5">
                   <input type="password" class="form-control" name="confirmPassword"
                      />
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-3 control-label">手机号</label>
               <div class="col-lg-5">
                   <input type="text" class="form-control" name="mobilePhone"
                      />
               </div>
           </div>
           <div class="form-group">
                <div class="group">
                	<label class="col-sm-3 control-label">角色</label>
            	<div class="col-lg-5">
           		<#if rolelist?exists && rolelist?size gt 0>
                <select id="wy_provice"  name="roleId" data-bv-notempty data-bv-notempty-message="请选择角色" class="form-control">
                <option value="" >选择角色</option>
                <#list rolelist as role>
                	<option value="${role.id}" >${role.cname}</option>
                </#list>
                </select>
           		</#if>
           		</div>
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
  <script src="<%=basePath%>/resources/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#addAccountForm')
        .bootstrapValidator({
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
                        },
                        remote: {
                            url: '<%=basePath%>/sys/checkUserExsit'+$("#userName").val(),
                            message: '用户名名称已被占用'
                        }
                    }
                },
                password: {
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
                            field: 'password',
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
        .on('success.form.bv', function(e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
            $.post($form.attr('action'), $form.serialize(), function(result) {
            	alert(result.msg);
            	window.location.href="<%=basePath%>/sys/userlist";
            }, 'json');
        });
});
</script>
</body>
</html>
