<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>理财师管理
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>ldd/sysmember/financia" method="post"
				id="form1" name="fff">
				<input type="hidden" name="page" id="pagess">
				<input type="hidden" name="ss" id="statu">
				<input type="hidden" name="memberId" id="mid">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							name="mobilePhone" class="form-control" placeholder="手机号""></td>
						<td style="width: 110px; padding-left: 30px">真实姓名：</td>
						<td style="width: 180px"><input type="text"
							name="financialPlannerName" class="form-control"
							placeholder="真实姓名""></td>
						<td style="width: 80px">状态：</td>
						<td style="width: 180px"><select name="status"
							class="form-control" style="width: 130px; height: 32px"
							id="status">
								<option value="">全部</option>
								<option value="1">待审核</option>
								<option value="2">认证成功</option>
								<option value="3">认证失败</option>
						</select></td>
						<td style="width: 110px; padding-left: 30px">注册时间：</td>
						<td style="width: 180px"><input type="text" name="createDate"
							class="form-control time" placeholder="注册时间" value=""></td>
						<td class="pull-right" style="padding-right: 10px"><input
							type="submit" class="btn btn-primary btn-sm" value="查询"></td>
						<td><button type="button" class="btn btn-primary btn-sm"
								onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">重置</button></td>
					</tr>
				</table>
			</form>
			<table class="table table-bordered tablebox">
				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>手机号</td>
					<td>真实姓名</td>
					<td>机构名称</td>
					<td>我的名片</td>
					<td>邮寄地址</td>
					<td>状态</td>
					<td>注册时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${list}" var="list" varStatus="vs">
					<tr class="text-center">
						<td>${vs.index+1}</td>
						<td>${list[9]}</td>
						<td>${list[2]}</td>
						<td>${list[3]}</td>
						<td><a href="<%=basePath%>${list[4]}" target="_black">查看</a></td>
						<td>${list[5]}</td>
						<td><c:if test="${list[6]==0}">
								<span style="color: red;">待认证</span>
							</c:if> <c:if test="${list[6]!=0}">
								<span style="color: blue;">认证成功</span>
							</c:if></td>
						<td><f:formatDate value="${list[7]}" pattern="yyyy-MM-dd" /></td>
						<td><c:if test="${list[6]==0}">
								<input class="btn btn-primary btn-sm" type="submit" onclick="sh(${list[6]},${list[0]},${page});" value="审核">
								<%-- <a class="btn btn-primary btn-sm"
									href="<%=basePath%>ldd/sysmember/financiaAudit/${list[1]}">审核</a> --%>
							</c:if> <c:if test="${list[6]!=0}">
								<span style="color: blue;">认证成功</span>
							</c:if></td>
					</tr>

				</c:forEach>
				<tr>

					<td colspan="8">
						第${page}页，共${allpage}页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="javascript:pagefun(1);">首页</a>&nbsp; <a
						href="javascript:pagefun(${page>1?page-1:page});">上一页</a>&nbsp;
						<a href="javascript:pagefun(${page<allpage?page+1:allpage});">下一页</a>&nbsp;
						<a href="javascript:pagefun(${allpage});">尾页</a>
					</td>
				</tr>
			</table>

		</div>
		<script type="text/javascript">
		function pagefun(ye) {		
			document.getElementById("pagess").value=ye;			
			document.fff.submit();			
		}
		function sh(statu,id,page) {	
			alert(id);
			document.getElementById("pagess").value=page;
			document.getElementById("statu").value=statu;
			document.getElementById("mid").value=id;
			document.fff.submit();		
		}
		</script> 
</body>
</html>