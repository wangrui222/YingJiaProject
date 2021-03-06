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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>资讯分类
		</h2>

		<div class="tablelist">
			<table class="table tabletop">
				<tr>
					<td class="pull-right" style="padding-right: 30px"><a
						class="btn btn-primary btn-sm"
						href="<%=basePath%>newsType/addView">新增</a></td>
				</tr>
			</table>
			<table class="table table-bordered">
				<thead>
					<tr bgcolor="#f7f7f7">
						<th width="10%">序号</th>
						<th width="10%">名称</th>
						<th width="10%">上级类别</th>
						<th width="20%">简介</th>
						<th width="10%">排序</th>
						<!-- <th width="10%">页面类型</th> -->
						<th width="15%">添加时间</th>
						<th width="15%">操作</th>
					</tr>
				</thead>
				<tbody>
					<#list pageInfo.list as t>
					<tr>
						<td>${t_index+1}</td>
						<td>${(t.name)!!}</td>
						<td>${(t.suptypeDesc)!!}</td>
						<td>${(t.info)!!}</td>
						<td>${(t.sort)!!}</td>
						<!-- <td>${(t.pagetype)!!}</td> -->
						<td></td>
						<td><a class="btn btn-primary btn-sm"
							href="<%=basePath%>newsType/editView?id=${t.id}">编辑</a> <!-- <a class="btn btn-primary btn-sm" href="javascrip:"  onclick="delNewsType('${t.id}')">删除</a> -->
						</td>
					</tr>
					</#list>
				</tbody>
			</table>
			<#include "paginate.html" /> <@paginate
			currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
			actionUrl="<%=basePath%>newsType/index"/>
		</div>
		<!-- 内容结束 -->
	</div>
	<!-- 容器结束 -->
	<script type="text/javascript">
	/* function delNewsType(tid){
		if(confirm('你确定要删除吗？')){
			$.ajax({
                type: "POST", // 用POST方式传输
                dataType: "json", // 数据格式:JSON
                url: '', // 目标地址
                data: {
                    id: tid
                },
                success: function (msg) {
                	 if (msg.code == 0) {
                         window.location.href = "<%=basePath%>newsType/index";
                     } else {
                        alert(msg.msg);
                     }
                }
            });
		}
	} */
</script>

</body>
</html>