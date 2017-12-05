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
     <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>修改用户</h2>
	<form id="addAccountForm" method="post" class="form-horizontal" action="<%=basePath%>sys/createAccount">
		<input type="hidden" name="id" value="${(user.id)!!}">
           <div class="form-group">
               <label class="col-sm-3 control-label">用户名</label>
               <div class="col-lg-5">
                   <input type="text" class="form-control" name="userName" id="userName" value="${(user.userName)!!}" disabled="disabled"/>
               </div>
           </div>
           <div class="form-group">
               <label class="col-sm-3 control-label">密码</label>
               <div class="col-lg-5">
                   <input type="password" class="form-control" name="password" />
               </div>
               <span style="color: red;padding-left: 10px;">密码不填写则不修改原账号密码</span>
           </div>
           <div class="form-group">
               <label class="col-sm-3 control-label">手机号</label>
               <div class="col-lg-5">
                   <input type="text" class="form-control" name="mobilePhone"  value="${(user.mobilePhone)!!}"/>
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
  <script src="<%=basePath%>resources/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#wy_provice").val(${(relation.roleId)!!});	
	
    $('#addAccountForm')
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
        .on('success.form.bv', function(e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
            $.post($form.attr('action'), $form.serialize(), function(result) {
            	alert(result.msg);
            	window.location.href="<%=basePath%>sys/userlist";
            }, 'json');
        });
});
</script>
</body>
</html>
