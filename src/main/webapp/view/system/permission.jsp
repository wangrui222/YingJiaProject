<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>角色管理</title>
<meta name="content-type" content="text/html; charset=UTF-8">
</head>
<body>
	<form name="roleForm" method="post"
		action="${base}/sys/updateRolePermission" class="roleForm">
		<input type="hidden" name="roleId" value="${roleId!''}" />
		<table class="table">
			<tr style="background: #f5f5f5">
				<td>主菜单</td>
				<td style="padding-left: 45px">子菜单名称</td>
			</tr>
			<tr>
				<td><input class="ruleMenuTitle" name="enameStr"
					type="checkbox">
				<td><input class="rulePowerList er" name="enameStr"
					type="checkbox" value="${(permission.ename)!''}" />${(permission.cname)!''}<br />
				</td>
			</tr>
		</table>
		<div class="col-sm-12  col-sm-offset-5 ">
			<button type="submit" class="btn btn-primary btn-sm submit">确认</button>
		</div>
	</form>

	<script type="text/javascript">
$(function(){
		//一级选中
		$(".roleForm").delegate(".ruleMenuTitle","click",function(event){
				var ts = $(this),
				tsChk = ts.prop("checked"),
				ruleMenuTitle = ts.parent().parent(),
				rulePowerList = ruleMenuTitle.find("input");
				rulePowerList.each(function(k,e) {
					$(e).prop("checked",tsChk);
				});
				event.stopPropagation();
		});
});
</script>
</body>
</html>
