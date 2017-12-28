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
<script type="text/javascript"
	src="<%=basePath%>resources/sys/js/bootstrap.js"></script>

<link rel="stylesheet"
	href="<%=basePath%>resources/date/bootstrap-datetimepicker.min.css">
<script type="text/javascript"
	src="<%=basePath%>resources/date/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/date/bootstrap-datetimepicker.zh-CN.js"></script>
<title>后台首页</title>
</head>
<body>

	<div class="box-right-main">
		<h2>
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>提现管理
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>jian/sysmember/WithdrawManage"
				method="post" name="form" id="form1">
				<input type="hidden" id="page" name="page">
				<table class="table tabletop">
					<tr>
					<td>
					    <td style="width: 110px; padding-left: 30px">流水号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="serialNumber" placeholder="流水号"
							value="${subjectPurchaseRecord.serialNumber }"></td>
							 <td style="width: 110px; padding-left: 30px">状态：</td>
						<td>
						<select name="status"
							class="form-control" style="width: 130px; height: 32px"
							id="status">
								<option value="-1">全部</option>
								<c:forEach items="${slist}" var="s">
									<option value="${s.value }"
										${s.value==subjectPurchaseRecord.status?"selected='selected'":"" }>${s.name}</option>
								</c:forEach>
						</select></td>
						<td class="pull-right" style="padding-right: 30px">
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
					<td>流水号</td>
					<td>购买金额</td>
					<td>创建时间</td>
					<td>修改时间</td>
					<td>结算利息</td>
					<td>最后记息日</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${pagelist.getContent()}" var="mlist"
					varStatus="index">
					<tr class="text-center">
						<td>${index.index+1}</td>
						<td>${mlist.serialNumber}</td>
						<td>${mlist.amount}</td>
						<td>${mlist.createDate}</td>
						<td>${mlist.updateDate}</td>
						<td>${mlist.interest}</td>
						<td>${mlist.lastProfitDay}</td>
						<td>
						<c:if test="${mlist.status==0}">
								<p style="color: red">未到期</p>
							</c:if>
						<c:if test="${mlist.status==1}">
								<p style="color: pink">待审核</p>
							</c:if> <c:if test="${mlist.status==2}">
								<p style="color: red">未解冻</p>
							</c:if> <c:if test="${mlist.status==3}">
								<p style="color: yellow">未打款</p>
							</c:if> <c:if test="${mlist.status==4}">
								<p style="color: green">已打款</p>
							</c:if></td>
						<td>
						<c:if test="${mlist.status==0}">
								<p>未到期</p>
							</c:if>
						
						<c:if test="${mlist.status==1}">
								<a class="btn btn-primary btn-sm"  
									onclick="javascript:tx(${mlist.sprId},'shenhe')">审核</a>
							</c:if> <c:if test="${mlist.status==2}">
								<a class="btn btn-primary btn-sm"
									onclick="tx(${mlist.sprId},'jiedong')">解冻</a>
							</c:if> <c:if test="${mlist.status==3}">
								<a class="btn btn-primary btn-sm"		
									onclick="tx(${mlist.sprId},'dakuan')">贝付打款</a>
							</c:if> <c:if test="${mlist.status==4}">
								<p>已打款</p>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="llpage">
			<div class="in">
				<nav> <span class="count">&nbsp;第&nbsp;<b>${pagelist.getNumber()+1}</b>&nbsp;页，&nbsp;共&nbsp;<b>${pagelist.getTotalPages()}</b>&nbsp;页
				</span>
				<ul class="pagination">
					<li><a class="prev_page"
						href="javascript:pageRequest(${pagelist.getNumber()>1?pagelist.getNumber():1})">上页</a></li>
					<c:forEach begin="1" end="${pagelist.getTotalPages()}" var="v">
						<li><a class="now" href="javascript:pageRequest(${v})">${v}</a></li>
					</c:forEach>
					<li><a
						href="javascript:pageRequest(${pagelist.getNumber()+1<pagelist.getTotalPages()?pagelist.getNumber()+1+1:pagelist.getTotalPages()})"
						class="next_page" rel="next">下页</a></li>
				</ul>
				</nav>
			</div>
		</div>
		<!-- 内容结束 -->

	</div>

</body>
<script type="text/javascript">
	function pageRequest(page) {
		document.getElementById("page").value = page;
		document.form.submit();

	}
	function tx(sprId,flag){
		
		$.get('http://localhost:8080/YingJiaProject/jian/sysmember/withdrawAudit/'+sprId+'/'+flag,function(data){
			if(data.code=="success"){
				alert("操作成功");
				location.reload(); 
			}
			
		})
		
	}
	  
</script>
</html>