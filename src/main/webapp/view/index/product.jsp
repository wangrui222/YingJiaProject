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
    			<li class="first"><a class="active" href="product_gushou.jsp" target="iFrame1">固收类理财</a></li>
    			<li class="second"><a href="product_simu.jsp" target="iFrame1">私募基金</a></li>
    			<li class="three"><a href="product_seaover.jsp" target="iFrame1">海外配置</a></li>
    			<li class="four"><a href="product_guquan.jsp" target="iFrame1">股权基金</a></li>
    		</ul>
    	</div>
    <iframe id="iFrame1" name="iFrame1" width="100%" onload="this.height=iFrame1.document.body.scrollHeight" frameborder="0" src="product_gushou.jsp" scrolling="no"></iframe>
  </div>
     <%-- 
      <jsp:include page="product_gushou.jsp" flush="false"></jsp:include> 
        <jsp:include page="product_simu.jsp" flush="false"></jsp:include> 
        <jsp:include page="product_seaover.jsp" flush="false"></jsp:include> 
        <jsp:include page="product_guquan.jsp" flush="false"></jsp:include> --%> 
       
    





</body>
</html>