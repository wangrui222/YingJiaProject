<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<form action="<%=basePath%>member/tikuan"
		method="post" name="frm">
		<input type="hidden" name="pageTikuan" id="pageTikuan">
	</form>



	<div class="admin-right">
		<div class="tbConBox">
			<div class="tab">
				<a class="select" href="javascript:;">提款记录</a>
			</div>
			<div id="conBox">
				<div class="box" style="display: block">


					<div class="ajaxContainer">
						<table class="tzlist" width="100%" border="1"
							bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
							<tr>
								<th width="20%">时间</th>
								<th width="30%">订单号</th>
								<th width="20%">金额</th>
								<th width="10%">状态</th>
							</tr>
							
							<c:forEach items="${memberWithdrawRecordList}" var="mwr">
							<tr>
								<td>${mwr.createDate}</td>
								<td>${mwr.serialNumber}</td>
								<td><font color="#ff503f">￥${mwr.amount}</font></td>
								<td>
									<c:choose>
											<c:when test="${mwr.status==0}">
									         	  待审核
									       </c:when>
											<c:when test="${mwr.status==1}">
									             	已打款 
									       </c:when>
									       <c:when test="${mwr.status==2}">
									             	打款中
									       </c:when>
									       <c:when test="${mwr.status==3}">
									             	打款失败 
									       </c:when>

									</c:choose>
								</td>
							</tr>
							</c:forEach>
							
						</table>

						<div class="llpage">
							<div class="in">
								<a class="prev_page"
									href="javascript:fun(${pageTikuan==1?1:pageTikuan-1})">${pageTikuan==1?"首页":"上页"}
								</a> <a class="now">${pageTikuan}</a> <a class="next_page"
									href="javascript:fun(${pageTikuan==pagesTikuan?pagesTikuan:pageTikuan+1})">${pageTikuan==pagesTikuan?"尾页":"下页"}</a>
							</div>
						</div>


					</div>
					<script type="text/javascript">
					function fun(page){
						document.getElementById("pageTikuan").value=page;
						document.frm.submit();
						
					}
					</script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>