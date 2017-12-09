<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/ying/iconfont.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">

<script type="text/javascript"
	src="<%=basePath%>resources/sys/js/jquery.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>resources/date/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="<%=basePath%>resources/date/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/date/bootstrap-datetimepicker.zh-CN.js"></script>

<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>账号管理
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>ldd/sysmember/index" method="post" id="form1" name="fff">
				<input type="hidden" name="page" id="pagess">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">用户名：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="names" placeholder="用户名""></td>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							name="mobilePhone" class="form-control" placeholder="手机号""></td>
						<td style="width: 110px; padding-left: 30px">姓名：</td>
						<td style="width: 180px"><input type="text" name="memberName"
							class="form-control" placeholder="姓名""></td>
						<td style="width: 110px; padding-left: 30px">邀请码：</td>
						<td style="width: 180px"><input type="text"
							name="invitationcode" class="form-control" placeholder="邀请码""></td>
						<td style="width: 110px; padding-left: 30px">注册时间：</td>
						
						<td style="width: 180px"><input type="text" name="createDate"
							class="form-control time" placeholder="注册时间" value="" ></td>
						<td class="pull-right" style="padding-right: 10px">
						<input type="submit" class="btn btn-primary btn-sm" value="查询"></td>
						<td><button type="button" class="btn btn-primary btn-sm"
								onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">重置</button></td>
					
					
					</tr>
				</table>
			</form>
			<table class="table table-bordered tablebox">
				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>手机号</td>
					<td>用户名</td>
					<td>姓名</td>
					<td>身份证</td>
					<td>邀请码</td>
					<td>注册时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${lists}" var="memberslist">
				<tr class="text-center">
					<td>${memberslist.memberId}</td>
					<td>${memberslist.mobilePhone}</td>
					<td>${memberslist.names}</td>
					<td>${memberslist.memberName}</td>
					<td>${memberslist.memberIdentity}</td>
					<td>${memberslist.invitationcode}</td>
					<td><f:formatDate value="${memberslist.createDate}" pattern="yyyy-MM-dd"/></td>
					<td><a class="btn btn-primary btn-sm"
						href="<%=basePath%>ldd/sysmember/memberInfo/${memberslist.memberId}">账号详情</a></td>
				</tr>
				</c:forEach>
				<tr>
				
					<td colspan="8">
						第${pages}页，共${counts}页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:pagefun(1);">首页</a>&nbsp;
						<a href="javascript:pagefun(${pages>1?pages-1:pages});">上一页</a>&nbsp;
						<a href="javascript:pagefun(${pages<counts?pages+1:counts});">下一页</a>&nbsp;
						<a href="javascript:pagefun(${counts});">尾页</a>
					</td>
				</tr>
			</table>
		</div>
		<!-- 内容结束 -->
	</div>
	
	 <script type="text/javascript">
		function pagefun(ye) {
			alert(11);
			document.getElementById("pagess").value=ye;
			alert(11);
			document.fff.submit();
			alert(11);
		}
		
		</script> 
</body>
</html>