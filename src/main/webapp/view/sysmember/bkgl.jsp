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
			<span class="glyphicon glyphicon-play" style="margin-right: 5px"></span>绑卡管理
		</h2>

		<div class="tablelist">
			<form action="<%=basePath%>ldd/sysmember/dahua" method="post"
				id="form1" name="fff">
				<input type="hidden" name="page" id="pagess">
				<input type="hidden" name="del" id="dell">
				<input type="hidden" name="memberId" id="mid">
				<table class="table tabletop">
					<tr>
						<td style="width: 130px; padding-left: 30px">手机号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="mobilePhone" placeholder="手机号""></td>
						<td style="width: 130px; padding-left: 30px">绑卡姓名：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="memberName" placeholder="绑卡姓名""></td>
						<td style="width: 130px; padding-left: 30px">绑卡卡号：</td>
						<td style="width: 180px"><input type="text"
							class="form-control" name="cardNo" placeholder="绑卡卡号"}"></td>
						<!-- <td style="width: 110px; padding-left: 30px">注册时间：</td>
						<td style="width: 180px"><input type="text" name="createDate"
							class="form-control time" placeholder="注册时间" value=""></td> -->
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
					<td>手机号</td>
					<td>绑卡人姓名</td>
					<td>绑卡身份证</td>
					<td>绑卡类型</td>
					<td>绑卡卡号</td>
					<td>绑卡地址</td>
					<td>状态</td>
					<td>添加时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${list}" var="list" varStatus="vs">
					<tr class="text-center">
						<td>${vs.index+1}</td>
						<td>${list[9]}</td>
						<td>${list[10]}</td>
						<td>${list[11]}</td>
						<td>${list[1]}</td>
						<td>${list[3]}</td>
						<td>${list[7]}</td>
						<td><c:if test="${list[4]==0}">
								<span style="color: blue;">正常</span>
							</c:if> <c:if test="${list[4]==1}">
								<span style="color: red;">被删除</span>
							</c:if></td>
						<td>${list[5]}</td>
						<td><c:if test="${list[4]==0}">
						<input class="btn btn-primary btn-sm" type="submit" onclick="jb(${list[4]},${list[2]},${page});" value="解绑银行卡">
								<%-- <a href="<%=basePath%>sysmember/unBankCard/${list[0]}"
									class="btn btn-primary btn-sm"
									onclick="return confirm('你确定要解绑？')">解绑银行卡</a> --%>
							</c:if> <c:if test="${list[4]==1}">已解绑</c:if></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
		<!-- 内容结束 -->
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
	</div>
	<!-- <script type="text/javascript">
		$('.time').datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN',
			minView : 2,
			todayBtn : 1
		}).on('changeDate', function(ev) {
			$('.time').datetimepicker('hide');
		});
	</script> -->
	<script type="text/javascript">
		function pagefun(ye) {	
			document.getElementById("pagess").value=ye;		
			document.fff.submit();			
		}	
		function jb(delflag,id,page) {	
			document.getElementById("pagess").value=page;
			document.getElementById("dell").value=delflag;
			document.getElementById("mid").value=id;
			document.fff.submit();		
		}
		</script> 
</body>
</html>