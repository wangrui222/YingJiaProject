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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>意见反馈
		</h2>

		<div class="tablelist">
			<!-- <table class="table tabletop">
                        <tr>
                        <td style="width:110px;padding-left:30px">意见：</td>
                        <td style="width:180px"><input type="text"></td>
                        <td style="width:90px">是否显示：</td>
                        <td><select name="" id="" style="width:135px;height:32px">
                            <option value="">123456</option>
                          </select></td>
                       
                        <td class="pull-right" style="padding-right:30px"><button type="button" class="btn btn-primary btn-sm">查询</button><button type="button" class="btn btn-primary btn-sm">新增</button></td>
                        </tr>     
                        </table> -->
			<table class="table table-bordered tablebox">

				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>意见提交人</td>
					<td>意见内容</td>
					<td>添加时间</td>
				</tr>
				<#list pageInfo.list as b>
				<tr class="text-center">
					<td>${b_index+1}</td>
					<td>${(b.memberId.mobilePhone)!!}</td>
					<td>${(b.content)!!}</td>
					<td></td>
				</tr>
				</#list>
			</table>

			<#include "/common/paginate.html" /> <@paginate
			currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
			actionUrl="<%=basePath%>setting/feedbackList"/>
		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->
</body>
</html>