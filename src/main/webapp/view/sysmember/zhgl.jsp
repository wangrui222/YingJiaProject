<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${base}/resources/sys/ying/iconfont.css">
<link rel="stylesheet" href="${base}/resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="${base}/resources/sys/style/style.css">

<script type="text/javascript" src="${base}/resources/sys/js/jquery.js"></script>
<link rel="stylesheet"
	href="${base}/resources/date/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="${base}/resources/date/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="${base}/resources/date/bootstrap-datetimepicker.zh-CN.js"></script>

<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>账号管理
		</h2>

		<div class="tablelist">
			<form action="${base}/sysmember/index" method="post" id="form1">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">用户名：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="name" placeholder="用户名"
							value="${(member.name)!!}"></td>
						<td style="width: 110px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							name="mobilePhone" class="form-control" placeholder="手机号"
							value="${(member.mobilePhone)!!}"></td>
						<td style="width: 110px; padding-left: 30px">姓名：</td>
						<td style="width: 180px"><input type="text" name="memberName"
							class="form-control" placeholder="姓名"
							value="${(member.memberName)!!}"></td>
						<td style="width: 110px; padding-left: 30px">邀请码：</td>
						<td style="width: 180px"><input type="text"
							name="invitationcode" class="form-control" placeholder="邀请码"
							value="${(member.invitationcode)!!}"></td>
						<td style="width: 110px; padding-left: 30px">注册时间：</td>
						<td style="width: 180px"><input type="text" name="createDate"
							class="form-control time" placeholder="注册时间" readonly="readonly"
							value=""></td>
						<td class="pull-right" style="padding-right: 10px"><button
								type="submit" class="btn btn-primary btn-sm">查询</button></td>
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
				<#list pageInfo.list as m>
				<tr class="text-center">
					<td>${m_index+1}</td>
					<td>${(m.mobilePhone)!!}</td>
					<td>${(m.name)!!}</td>
					<td>${(m.memberName)!!}</td>
					<td>
						<%-- <#if (m.identity)??&&(m.identity)?length gt 0>
                            		${(m.identity[0..5])!!}***${(m.identity[14..17])!!}
                            	</#if> --%>
					</td>
					<td>${(m.invitationcode)!!}</td>
					<td>
						<%-- ${(m.createDate?string('yyyy-MM-dd HH:mm:ss'))!!} --%>
					</td>
					<td><a class="btn btn-primary btn-sm"
						href="${base}/sysmember/memberInfo?id=${m.id}">账号详情</a></td>
				</tr>
				</#list>
			</table>
			<#include "paginate.html" /> <@paginate
			currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0
			actionUrl="${base}/sysmember/index"
			urlParas="&name=${(member.name)!!}&mobilePhone=${(member.mobilePhone)!!}&memberName=${(member.memberName)!!}&invitationcode=${(member.invitationcode)!!}&createDate=${(member.createDate?string('yyyy-MM-dd'))!!}"/>

		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->
	<script type="text/javascript">
		$('.time').datetimepicker({
			format : 'yyyy-mm-dd',
			language: 'zh-CN',
			minView: 2,
		    todayBtn: 1
		}).on('changeDate', function(ev) {
			$('.time').datetimepicker('hide');
		});
		
		</script>
</body>
</html>