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
	<div class="proMain">
		<div class="hwpzNav">
			<ul>
				<li class="first"><a href="<%=basePath%>product/gushou/10/-1/-1/-1"
					target="iFrame1">固收类理财</a></li>
				<li class="second"><a
					href="<%=basePath%>product/simu?name=SIMU" target="iFrame1">私募基金</a></li>
				<li class="three"><a href="<%=basePath%>product/seaover"
					target="iFrame1">海外配置</a></li>
				<li class="four"><a
					href="<%=basePath%>product/simu?name=GUQUAN" target="iFrame1">股权基金</a></li>
			</ul>
		</div>
		
		<iframe id="iFrame1" name="iFrame1" width="100%" height="600"
			onload="this.height=iFrame1.document.body.scrollHeight"
			frameborder="0" src="product_gushou.jsp" scrolling="no"></iframe>
	</div>
</body>
</html>