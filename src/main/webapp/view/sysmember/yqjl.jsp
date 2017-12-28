<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>邀请奖励
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>jian/sysmember/inviteRewards"
				method="post" id="form1" name="form">
				<input type="hidden" id="page" name="page">
				<table class="table tabletop">
					<tr>
						<td style="width: 90px; padding-left: 20px">姓名：</td>
						<td style="width: 140px"><input type="text"
							class="form-control" name="memberName" placeholder="姓名"
							value="${members.memberName }"></td>
						<td style="width: 100px; padding-left: 20px">手机号：</td>
						<td><input type="text" name="mobilePhone"
							class="form-control" placeholder="手机号" value="${members.mobilePhone }"></td>
						<td style="width: 90px; padding-left: 20px">邀请码：</td>
						<td style="width: 140px"><input type="text"
							class="form-control" name="invitationcode"
							placeholder="邀请码" value="${members.invitationcode }"></td>
						<td style="width: 100px; padding-left: 20px">被邀请码：</td>
						<td><input type="text" name="invitedcode"
							class="form-control" placeholder="被邀请码" value="${members.invitedcode }"></td>
						<td style="width: 140px; padding-left: 20px">是否已注册奖励：</td>
						<td><select name="awardRecordsType" class="form-control"
							style="width: 100px; height: 32px" id="status">
								<option value="">全部</option>
								<option value="0" ${awardRecords.awardRecordsType==0?"selected='selected'":"" }>否</option>
								<option value="1" ${awardRecords.awardRecordsType==1?"selected='selected'":"" }>是</option>
						</select></td>
						<td class="pull-right" style="padding-right: 20px">
							<button type="submit" class="btn btn-primary btn-sm">查询</button>
						</td>
						<td><button type="button" class="btn btn-primary btn-sm"
								onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">重置</button></td>
					</tr>
				</table>
			</form>
			<table class="table table-bordered tablebox">

				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>手机号</td>
					<td>姓名</td>
					<td>邀请码</td>
					<td>被邀请码</td>
					<td>投资金额</td>
					<td>是否已注册奖励</td>
					<td>注册时间</td>
					<td  colspan="2">操作</td>
				</tr>
				<c:forEach items="${pagelist}" var="object" varStatus="index">
					<tr class="text-center">
						<td>${index.index+1}</td>
						<td>${object[0]}</td>
						<td>${object[1]}</td>
						<td>${object[2]}</td>
						<td>${object[3]}</td>
						<td>${object[4]}</td>
						<td><c:if test="${object[5]==1}">
						        <p style="color: blue;">是</p>
								
							</c:if>
							<c:if test="${object[5]==0}">
						         <p style="color: red;">否</p>
							</c:if>
						
						
						<td>${object[7]}</td>
						
						
						
						<td>
						<c:if test="${object[5]==1}">
						   <span style="color: blue;">注册已奖励</span>
							</c:if>
							<c:if test="${object[5]==0}">
							 <a class="btn btn-primary btn-sm" href="<%=basePath%>jian/sysmember/zhucejiangli/${object[8]}">注册奖励</a>
							</c:if>	
					
						
					</td>
					<td> <a class="btn btn-primary btn-sm"
							href="<%=basePath%>jian/sysmember/inviteRewardsRecord/${object[8]}">奖励记录</a></td>
						
					</tr>
				</c:forEach>
			</table>

		</div>

		<!-- 内容结束 -->

	</div>
	<!-- 容器结束 -->

	<div class="llpage">
		<div class="in">
			<nav> <span class="count">&nbsp;第&nbsp;<b>${page}</b>&nbsp;页，&nbsp;共&nbsp;<b>${pages}</b>&nbsp;页
			</span>
			<ul class="pagination">
				<li><a class="prev_page"
					href="javascript:pageRequest(${page>1?page-1:1})">上页</a></li>
				<c:forEach begin="1" end="${pages}" var="v">
					<li><a class="now" href="javascript:pageRequest(${v})">${v}</a></li>
				</c:forEach>
				<li><a
					href="javascript:pageRequest(${page<pages?page+1:pages})"
					class="next_page" rel="next">下页</a></li>
			</ul>
			</nav>
		</div>
	</div>
</body>
<script type="text/javascript">
	function pageRequest(page) {
		document.getElementById("page").value = page;
		document.form.submit();

	}
</script>

</html>