<%@page import="com.demo.model.OverseaConfig"%>
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
<script type="text/javascript"
	src="<%=basePath%>resources/web/location/area.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/web/location/location.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		showLocation();
	});
</script>
</head>
<body>
	<%
		OverseaConfig cf = (OverseaConfig) session.getAttribute("overseaConfig");
	%>
	<div class="proMain">
		<div class="conTit">
			<span><a style="color: #9d8440;" href="<%=basePath%>oversea">其他保险</a></span>
			<h2>
				<em>￥</em><%=cf.getTitle() %>
			</h2>
		</div>
		<table class="conTable" width="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td>
					<ul class="conInfoList">
						<li class="info" style="height: auto">
							<p>
								子标题：<font color="#00baff"><%=cf.getChildTitle()%></font>
							</p>
							<p>
								用户群体：<font color="#00baff"><%=cf.getUserType()%></font>
							</p>
							<p>
								描述：<font color="#00baff"><%=cf.getOcDescription()%></font>
							</p>
						</li>
					</ul>
				</td>
				<td width="360" align="center" ; valign="middle" height="320">
					<div class="tbBox">
						<div class="li4" style="">
							<span id="checkmoney" style="color: red;"></span>
						</div>
						<a href="<%=basePath%>web/login">登录</a>后可见
						<p>
							<input class="txt" name="name" type="text" value=""
								placeholder="请输入姓名">
						</p>
						<p>
							<input class="txt" name="phone" type="text" value=""
								placeholder="请输入电话号码">
						</p>
						<p class="pSelect">
							<span class="select1 fl"> <select id="loc_province"></select>
							</span> <span class="select2 fr"> <select id="loc_city"></select>
							</span> <input type="hidden" name="location_id" id="location_id" />
						</p>
						<button disabled="disabled" style="background-color: #848080;">已售罄</button>
						<div class="phone">
							<span>4000-999-158</span>7X24小时咨询电话
						</div>
					</div>
				</td>
			</tr>
		</table>

		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703340284072186.jpg"
				title="201511051446703340284072186.jpg" alt="et_01.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703344763060792.jpg"
				title="201511051446703344763060792.jpg" alt="et_02.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703350012012462.jpg"
				title="201511051446703350012012462.jpg" alt="et_03.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703355849053178.jpg"
				title="201511051446703355849053178.jpg" alt="et_04.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703360432053748.jpg"
				title="201511051446703360432053748.jpg" alt="et_05.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703363852007303.jpg"
				title="201511051446703363852007303.jpg" alt="et_06.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703367985089621.jpg"
				title="201511051446703367985089621.jpg" alt="et_07.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703371750046390.jpg"
				title="201511051446703371750046390.jpg" alt="et_08.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703375233092783.jpg"
				title="201511051446703375233092783.jpg" alt="et_09.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703378922073236.jpg"
				title="201511051446703378922073236.jpg" alt="et_10.jpg" />
		</p>
		<p style="white-space: normal; text-align: center;">
			<img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703384197058149.jpg"
				title="201511051446703384197058149.jpg" alt="et_11.jpg" />
		</p>
		<p
			style="white-space: normal; text-align: center; padding-bottom: 100px; background-color: rgb(68, 90, 151);">
			<a href="tel:4000-999-158"><img width="100%"
				src="http://pro.ying158.com/upload/ueditor-img/20151105/201511051446703389542089629.png"
				title="201511051446703389542089629.png" alt="8.png" /></a>
		</p>
		<p>
			<br />
		</p>
	</div>
</body>
</html>