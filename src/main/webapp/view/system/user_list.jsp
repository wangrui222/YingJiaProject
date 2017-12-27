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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>管理员账号
		</h2>

		<div class="tablelist">
			<table class="table tabletop">
				<tr>
					<td class="pull-right" style="padding-right: 30px"><button
							type="button" class="btn btn-primary btn-sm add">新增</button></td>

				</tr>
			</table>
			<table class="table table-bordered tablebox">
				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>用户名</td>
					<td>角色</td>
					<td>手机号</td>
					<td>创建时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${list}" var="list" varStatus="vs">
					<tr class="text-center">
						<td>${vs.index+1}</td>
						<td>${list[1]}</td>
						<td>${list[2]}</td>
						<td>${list[3]}</td>
						<td>${list[4]}</td>
						<td><a
							href="<%=basePath%>lddsystem/system/eidtUserView/${list[0]}"
							class="btn btn-primary btn-sm">编辑</a><a href="javascript:;"
							uid="${list[0]}" class="btn btn-primary btn-sm delUser">删除</a> <%-- <a href="<%=basePath%>lddsystem/system/deleteAccount/${list[0]}"
							class="btn btn-primary btn-sm" onclick="out();">删除</a> --%></td>
					</tr>
				</c:forEach>
			</table>
			<%-- <#include "/common/paginate.html" /> <@paginate
			currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
			actionUrl="<%=basePath%>setting/feedbackList"/> --%>
		</div>
		<!-- 内容结束 -->
		<%
			String name = request.getSession().getAttribute("usersname").toString();
		%>
		<input type="hidden" id="name" name="name" value="<%=name%>">
	</div>
	<!-- 容器结束 -->
</body>
<!-- <#if (pagelist.results)?exists && pagelist.results?size gt 0> <#list
pagelist.results as user> </#list> </#if> -->

<script type="text/javascript">
	$(function() {
		$(".add").click(function() {
			window.location.href = "<%=basePath%>lddsystem/system/addAccountPage";
		});

		 $(".delUser").click(function() {
			 alert(1111111111);
			 var uid = $(this).attr("uid");
			 var loginuserName=document.getElementById("name").value;
			 if(confirm("你确定要删除吗？")){
				 $.ajax({
						type : "POST", // 用POST方式传输
						url:'<%=basePath%>lddsystem/system/deleteAccount',
							data : {
								"loginuserName" : loginuserName,
								"userId" : uid
							},
							success : function(data) {							
								if (data.code==0) {
									alert("此账户正在登陆状态，不能删除");								
								}else{
									alert("可以删除");	
									window.location="<%=basePath%>lddsystem/system/deleteotherAccount/"+uid;
									alert("删除成功");	
								}
							}
						});
				
			} 
		}); 
	});
	
<%-- function out() {
	alert(123);
	var loginuserName=document.getElementById("name").value;
	alert(loginuserName);
	var uid=${list[0]};
	alert(uid);
	$.ajax({
		type : "POST", // 用POST方式传输
		url:'<%=basePath%>lddsystem/system/checkusers',
			data : {
				"loginuserName" : loginuserName,
				"userId" : 
			},
			success : function(data) {
				if (data.code == '0') {
					$(".msg").html(data.msg).show();
				} else if (data.code == '1') {
					$(".msg").html(data.msg).show();

				}
			}
		});
	} --%>
</script>
</html>