<%@page import="org.springframework.data.domain.Page"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.model.FinanceProductFunds"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="<%=basePath%>resources/web/images/icon.ico"
	type="image/x-icon" rel="shortcut icon">

<link href="<%=basePath%>resources/web/font/iconfont.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">

<script src="<%=basePath%>resources/web/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/web/layer/layer.js"></script>
<script src="<%=basePath%>resources/web/echart/dist/echarts.js"></script>
</head>
<body>


		<%
			Page<FinanceProductFunds> pagesubject  = (Page<FinanceProductFunds>) request.getSession().getAttribute("pageFinanceProductFunds");
			String name = (String)request.getSession().getAttribute("name");
		%>
	

	<form action="<%=basePath%>product/simu" method="post" name="frm">
		<input type="hidden" name="page" id="page">
			<input type="hidden" name="name" value="${name}">
	</form>
	
	<div class="ajaxContainer">
		<!-- 异步内容开始 -->
		<%
			List<FinanceProductFunds> list = (List<FinanceProductFunds>) request.getSession().getAttribute("financeProductFunds");
			for (FinanceProductFunds fpf : list) {
		%>
		<ul class="tbList">
			<li class="first"><span class="ico jp"></span>
				<h2>
					<b><%=fpf.getFinanceProductFundsName()%></b>
				</h2> <i></i></li>
			<li class="second" style="width: 630px;">
				<div class="txt1">
					<h2><%=fpf.getYearRate()+"%"%></h2>
					<p>年化收益</p>
				</div>
				<div class="txt2">
					<h2><%=fpf.getPeriod()%></h2>
					<p>期限(天)</p>
				</div>
				<div class="txt2">
					<h2><%=fpf.getFloorAmount()%></h2>
					<p>起购金额(元)</p>
				</div>

			</li>
			<li class="five"><a class="abtn" href="<%=basePath%>product/simugoumai/<%=fpf.getFinanceProductFundsId()%>" 
				target="iFrame2">购买</a></li>
		</ul>
		<%
			}
		%>
		<!-- 异步内容结束 -->


		<div class="llpage">
			<div class="in">
				<a class="prev_page"
					href="javascript:fun(<%=pagesubject.getNumber() + 1 > 1 ? (pagesubject.getNumber()) : pagesubject.getNumber() + 1%>)"><%=pagesubject.getNumber() + 1==1?"首页":"上页" %></a>
				<a class="now"><%=pagesubject.getNumber() + 1%></a> <a class="next_page"
					href="javascript:fun(<%=pagesubject.getNumber() + 1 < pagesubject.getTotalPages()
					? (pagesubject.getNumber() + 2)
					: pagesubject.getTotalPages()%>)"><%=pagesubject.getNumber() + 1 == pagesubject.getTotalPages()?"尾页":"下页"%></a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function fun(page){
		document.getElementById("page").value=page;
		document.frm.submit();
		
	}
		function getJsonInfo(url) {
			$.get(url, 'json', function(data) {
				$(".ajaxContainer").empty();
				$(".ajaxContainer").append(data);
			});
		}
	</script>
</body>
</html>