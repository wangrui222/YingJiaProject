<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon"
	rel="shortcut icon">
<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
<link href="<%=basePath%>resources/web/font/iconfont.css"
	rel="stylesheet">
<script src="<%=basePath%>resources/web/js/jquery.js"></script>
<script src="<%=basePath%>resources/web/echart/dist/echarts.js"></script>

<link href="<%=basePath%>resources/web/images/icon.ico"
	type="image/x-icon" rel="shortcut icon">
</head>
<body>

<form action="<%=basePath%>member/tiyan"
		method="post" name="frm">
		<input type="hidden" name="pageTiyan" id="pageTiyan">
	</form>

	<div class="admin-right">
		<div class="tbConBox">
			<div class="tab">
				<a class="select" href="javascript:;">体验金记录</a>
			</div>
			<div id="conBox">
				<div class="box" style="display: block">
					<div class="remind">
						<h4>
							<strong><span style="color: #827E76">体验金余额(元)：</span><span
								style="color: #9d8440">${amount}</span>&nbsp;&nbsp;&nbsp;&nbsp; </strong>
						</h4>
					</div>
					<div>
					<c:forEach items="${subjectlist}" var="a">
						<table class="tzlist" width="100%" border="1"
							bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
							<tr>
								<td>标的名称</td>
								<td style="color: #9d8440;">${a[0]}</td>
								<td>状态</td>
								<td style="color: #9d8440;">持有中</td>
							</tr>
							<tr>
								<td>投资金额</td>
								<td style="color: #9d8440;">￥${a[1]}</td>
								<td>期限</td>
								<td style="color: #9d8440;">${a[2]}</td>
							</tr>
							<tr>
								<td>收益方式</td>
								<td style="color: #9d8440;">${a[7]}</td>
								<td>年化收益率</td>
								<td style="color: #9d8440;">${a[3]}</td>
							</tr>
							<tr>
								<td>计息日</td>
								<td style="color: #9d8440;">${a[4]}</td>
								<td>预期收益</td>
								<td style="color: #9d8440;">￥${a[6]}</td>
							</tr>
							<tr>
								<td>结束日</td>
								<td style="color: #9d8440;">${a[8]}</td>
								<td>已获收益</td>
								<td style="color: #9d8440;">${a[5]}元</td>
							</tr>
						</table>
						<br>
					</c:forEach>
					</div>
					<div class="llpage">
								<div class="in">
									<a class="prev_page"
										href="javascript:fun(${pageTiyan==1?1:pageTiyan-1})">${pageTiyan==1?"首页":"上页"} </a>
									<a class="now">${pageTiyan}</a> <a class="next_page"
										href="javascript:fun(${pageTiyan==pagesTiyan?pagesTiyan:pageTiyan+1})">${pageTiyan==pagesTiyan?"尾页":"下页"}</a>
								</div>
					</div>
	
					<script type="text/javascript">
					function fun(page){
						
						document.getElementById("pageTiyan").value=page;
						document.frm.submit();
						
					}
					</script>
					
					
					
					
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>