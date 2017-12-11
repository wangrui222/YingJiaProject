<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>付息计划
		</h2>
		<div class="tablelist">
			<form action="<%=basePath%>ldd/sysmember/payment" method="post"
				id="form1" name="fff">
				<input type="hidden" name="page" id="pagess">
				<table class="table tabletop">
					<tr>
						<td style="width: 110px; padding-left: 30px">名称：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="name" placeholder="名称"></td>
						<td style="width: 80px">状态：</td>
						<td style="width: 180px"><select name="status"
							class="form-control" style="width: 130px; height: 32px"
							id="status">
								<option value="">全部</option>
								<option value="1">未发布</option>
								<option value="2">募集中</option>
								<option value="3">回款中</option>
								<option value="4">还款完成</option>
						</select></td>
						<td style="width: 80px">类型：</td>
						<td style="width: 180px"><select name="type"
							class="form-control" style="width: 130px; height: 32px" id="type">
								<option value="">全部</option>
								<option value="1">固收类</option>
								<option value="2">P2P车贷</option>
								<option value="3">P2P房贷</option>
						</select></td>
						<td class="pull-right" style="padding-right: 30px"><input
							type="submit" class="btn btn-primary btn-sm" value="查询"></td>
						<td><button type="button" class="btn btn-primary btn-sm"
								onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">重置</button></td>
					</tr>
				</table>
			</form>
			<table class="table table-bordered tablebox">
				<tr class="text-center" bgcolor="#f7f7f7">
					<td>序号</td>
					<td>合同编号</td>
					<td>标的类别</td>
					<td>标的名称</td>
					<td>标的总金额</td>
					<td>已投金额</td>
					<td>已投人数</td>
					<td>标的期限</td>
					<td>年化收益</td>
					<td>标的状态</td>
					<td>可体验金购买</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr class="text-center">
						<td>${list_index+1}</td>
						<td>${list[2]}</td>
						<td>${list[4]}</td>
						<td>${list[3]}</td>
						<td>${list[7]}</td>
						<td>${list[6]}元</td>
						<td>1人</td>
						<td>${list[10]}天</td>
						<td>${list[18]}%</td>
						<td>${list[5]}</td>
						<td>${list[29]==0?'否':'是'}</td>
						<td><c:if test="${list[29]==0}">
								<a
									href="<%=basePath%>sysmember/paymentBbinContent/id=${list[0]}"
									class="btn btn-primary btn-sm">体验金付息</a>
							</c:if> <a href="<%=basePath%>sysmember/paymentContentid=${list[0]}"
							class="btn btn-primary btn-sm">付息列表</a></td>
					</tr>
				</c:forEach>
				<tr>

					<td colspan="8">
						第${page}页，共${allpage}页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="javascript:pagefun(1);">首页</a>&nbsp; <a
						href="javascript:pagefun(${page>1?page-1:page});">上一页</a>&nbsp; <a
						href="javascript:pagefun(${page<allpage?page+1:allpage});">下一页</a>&nbsp;
						<a href="javascript:pagefun(${allpage});">尾页</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function pagefun(ye) {
		
			document.getElementById("pagess").value=ye;			
			document.fff.submit();
			
		}
		
		</script> 
</body>
</html>