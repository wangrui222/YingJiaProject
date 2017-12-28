<%@page import="java.util.List"%>
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
<form action="<%=basePath%>member/touzi"
		method="post" name="frm">
		<input type="hidden" name="pageTouzi" id="pageTouzi">
		<input type="hidden" name="pageYuyue" value="${pageYuyue}">
	</form>
	
	<form action="<%=basePath%>member/touzi"
		method="post" name="frm2">
		<input type="hidden" name="pageTouzi" value="${pageTouzi}">
		<input type="hidden" name="pageYuyue" id="pageYuyue">
	</form>

	<div class="admin-right">
		<div class="tbConBox">
			<div class="tab">
				<a class="select" href="javascript:;">投资记录</a>
			</div>
			<div id="conBox">
				<div class="box" style="display: block">
					<div class="ajaxContainer">
						<!-- 异步内容开始 -->
						<table class="tzlist" width="100%" border="1"
							bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
							<tr>
								<th>订单编号</th>
								<th>标的名称</th>
								<th>金额</th>
								<th>预期收益</th>
								<th>状态</th>
								<th>购买时间</th>
							</tr>
							<% List<Object[]> touzi = (List<Object[]>) request.getSession().getAttribute("touzilist"); 
							Integer pageTouzi = (Integer) request.getSession().getAttribute("pageTouzi");
							Integer pagesTouzi = (Integer) request.getSession().getAttribute("pagesTouzi");
							Integer countTouzi = (Integer) request.getSession().getAttribute("countTouzi");
							for(int i = 0; i<touzi.size();i++){
							%>		
							<%-- <c:forEach items="${sessionScope.touzilist}" var="touzi" varStatus="status"> --%>
								<tr>
									<td><%=touzi.get(i)[1] %></td>
									<td><font color="#a58b48"><%=touzi.get(i)[4] %></font></td>
									<td><font color="#ff503f">￥<%=touzi.get(i)[2] %></font></td>
									<td>￥<%=touzi.get(i)[9] %></td>
									<td>
									<%
										if(Integer.parseInt(touzi.get(i)[10].toString())==1){
									%>
										已付款
									<%}
									%> 
									<%
										if(Integer.parseInt(touzi.get(i)[10].toString())==2){
									%>
										打款中
									<%}
									%> 
									<%
										if(Integer.parseInt(touzi.get(i)[10].toString())==3){
									%>
										打款失败
									<%}
									%> 
									<%
										if(Integer.parseInt(touzi.get(i)[10].toString())==4){
									%>
										已解冻
									<%}
									%> 
									
									</td>
									<td><%=touzi.get(i)[8] %></td>
								</tr>
							<% 	}
							%>
						</table>
						<div class="listCount">
							总计<font color="#ff503f">${countTouzi}</font>笔
						</div>

							<div class="llpage">
								<div class="in">
									<a class="prev_page"
										href="javascript:fun(${pageTouzi==1?1:pageTouzi-1})">${pageTouzi==1?"首页":"上页"}</a>
									<a class="now">${pageTouzi}</a> <a class="next_page"
										href="javascript:fun(${pageTouzi==pagesTouzi?pagesTouzi:pageTouzi+1})">${pageTouzi==pagesTouzi?"尾页":"下页"}</a>
								</div>
							</div>
	
	
						
					</div>
					<script type="text/javascript">
					
					
					function fun(page){
						
						document.getElementById("pageTouzi").value=page;
						document.frm.submit();
						
					}
							function getJsonInfo(url) {
								$.get(url, 'json', function(data) {
									$(".ajaxContainer").empty();
									$(".ajaxContainer").append(data);
								});
							}
</script>
				</div>
			</div>
			<div class="tab">
				<a class="select" href="javascript:;">预约记录</a>
			</div>
			<div id="conBox">
				<div class="box" style="display: block">

					<meta name="keywords"
						content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50" />
					<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。" />
					<link href="/winplus/resources/web/images/icon.ico"
						type="image/x-icon" rel="shortcut icon">

					<div class="ajaxContainer2">
						<!-- 异步内容开始 -->
						<table class="tzlist" width="100%" border="1"
							bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
							<tr>
								<th>标的名称</th>
								<th>金额</th>
								<th>预期收益</th>
								<th>状态</th>
								<th>预约时间</th>
								<th>下载</th>
							</tr>
							<%-- <% 
							request.getSession().setAttribute("fpslist", fpslist); 
							request.getSession().setAttribute("pageYuyue", pageYuyue); 
							request.getSession().setAttribute("pagesYuyue", pagesYuyue); 
							request.getSession().setAttribute("countYuyue", countYuyue);
							
							%> --%>
							<c:forEach items="${fpslist}" var="fps">
						
							<tr>
								<td><font color="#a58b48">${fps.financeProductSubscribeName}</font></td>
								<td><font color="#ff503f">￥${fps.amount}</font></td>
								<td>￥${fps.interest}</td>
								<td>
								<!-- 0:签署拍照|1:已签约|2:审核中|3:签署失败 -->
								已签约
								</td>
								<td>${fps.createDate}</td>
								<td><a
									href="/winplus/upload/subject/file/20160307/20160307170911553839(Yes).pdf"
									target="_black">查看下载</a></td>
							</tr>
							</c:forEach>
						
						</table>
						<div class="listCount">
							总计<font color="#ff503f">${countYuyue}</font>笔
						</div>


						<div class="llpage">
								<div class="in">
									<a class="prev_page"
										href="javascript:fun2(${pageYuyue==1?1:pageYuyue-1})">${pageYuyue==1?"首页":"上页"}</a>
									<a class="now">${pageYuyue}</a> <a class="next_page"
										href="javascript:fun2(${pageYuyue==pagesYuyue?pagesYuyue:pageYuyue+1})">${pageYuyue==pagesYuyue?"尾页":"下页"}</a>
								</div>
							</div>
	
					</div>
					<script type="text/javascript">
					
					function fun2(page){
						document.getElementById("pageYuyue").value=page;
						document.frm2.submit();
						
					}
	function getJsonInfo2(url) {
		$.get(url, 'json', function(data) {
			$(".ajaxContainer2").empty();
			$(".ajaxContainer2").append(data);
		});
	}
</script>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>