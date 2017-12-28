<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>体验金付息计划
		</h2>

		<div class="tablelist">
			<table class="table tabletop">
				<tr>
					<td style="padding-left: 30px">标的名称：${subject[0]} &nbsp;
						&nbsp; &nbsp; &nbsp; 标的期限：${subject[1]}天 &nbsp; &nbsp; &nbsp;
						&nbsp; 年化收益率：${subject[2]}%</td>
				</tr>
			</table>
			<table class="table table-bordered tablebox">

				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>流水号</td>
					<td>投资人手机号</td>
					<td>投资人姓名</td>
					<td>投资人身份证</td>
					<td>投资体验金</td>
					<td>还款利息</td>
					<td>还款时间</td>
					<td>还款状态</td>
					<!-- <td>操作</td> -->
				</tr>
				<c:forEach items="${list}" var="list" varStatus="vs">
					<tr class="text-center">
						<td>${vs.index+1}</td>
						<td>${list[4]}</td>
						<td>${list[5]}</td>
						<td>${list[6]}</td>
						<td>${list[7]}</td>
						<td>${list[8]}<span style="color: blue;"></span>元
						</td>
						<td>${list[9]}<span style="color: red;"></span>元
						</td>
						<td>${list[10]}</td>
						<td><c:if test="${list[11]==0}">
								<span style="color: red;">已还款</span>
							</c:if>
							<c:if test="${list[11]==1}">
								<span style="color: blue;">未还款</span>
							</c:if></td>
						<%-- <td>
                        	<c:if test="${list[11]==1}">
                        	<a href="<%=basePath%>ldd/sysmember/paymentBbin/${list[0]}" class="btn btn-primary btn-sm">立即还款</a>
                        	</c:if><c:if test="${list[11]==0}">
                        	<a href="javascript:" class="btn btn-primary btn-sm" style="background-color: #8393A1;">已还款</a>
                        	</c:if>
                        </td> --%>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div class="llpage">
			<div class="in">
				<nav> <span class="count">&nbsp;第&nbsp;<b>${page}</b>&nbsp;页，&nbsp;共&nbsp;<b>${allpage}</b>&nbsp;页
				</span>
				<ul class="pagination">
					<li><a class="prev_page"
						href="javascript:pagefun(${page>1?page-1:page});">上页</a></li>
					<c:forEach begin="1" end="${allpage}" var="v">
						<li><a class="now" href="javascript:pagefun(${v})">${v}</a></li>
					</c:forEach>
					<li><a
						href="javascript:pagefun(${page<allpage?page+1:allpage});"
						class="next_page" rel="next">下页</a></li>
				</ul>
				</nav>
			</div>
		</div>
		<!-- 内容结束 -->
		<form action="<%=basePath%>ldd/sysmember/paymentBbinContent/${subject[3]}" name="fff">
		<input type="hidden" name="page" id="pagess">
		</form>
	</div>
	<script type="text/javascript">
		function pagefun(ye) {
			document.getElementById("pagess").value = ye;
			document.fff.submit();
		}
	</script>
	<!-- 容器结束 -->
</body>
</html>