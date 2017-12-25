<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">

<meta name="keywords"
	content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50" />
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。" />
<link href="<%=basePath%>resources/web/images/icon.ico"
	type="image/x-icon" rel="shortcut icon">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/ying/iconfont.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/ying/font2.css">
<link rel="stylesheet"
	href="<%=basePath%>resources/sys/style/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">
<title>盈+后台管理中心</title>
</head>
<body>
	<shiro:hasRole name="admin">

	</shiro:hasRole>
	<!-- 容器开始 -->
	<div class="container-layout">
		<!-- 头部开始	 -->
		<div class="row">
			<div id="top">
				<div class="col-sm-2">
					<div class="top-left">
						<img src="<%=basePath%>resources/sys/images/logo.jpg" alt="">
					</div>
				</div>

				<div class="col-sm-10">
					<div class="top-right">
						<ul class="nav nav-pills">
							<li><p>
									<span class="iconfont">&#xe605;</span>
								</p>
								<p>
									<!-- 用户名  -->
									<shiro:principal></shiro:principal>

								</p></li>
							<li style="width: 100px"><p>
									<a href="<%=basePath%>wangrui/logout"><span
										class="iconfont">&#xe606;</span></a>
								</p>
								<p>退出</p></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- 头部结束 -->

		<!-- 内容开始 -->
		<div class="row">
			<div id="box">
				<div class="col-sm-2">
					<div class="box-left">
						<ul class="nav nav-pills nav-stacked">
							<shiro:hasRole name="admin">

								<li><a href="javascript:;" class="titlea"><span
										class="iconfont">&#xe609;</span>理财产品</a></li>
								<ul class="list-group">
									<li class="list-group-item"><a
										href="<%=basePath%>view/subject/gu_shou.jsp" target="rightkj">固收类</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>view/financeProductFunds/financeProductFunds_list.jsp"
										target="rightkj">私募/股权类</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>overseaSys/overseaConfig" target="rightkj">海外配置</a></li>
								</ul>
							</shiro:hasRole>
							<li><a href="javascript:;" class="titlea"><span
									class="iconfont">&#xe60c;</span>钱包管理</a></li>
							<ul class="list-group">
								<li class="list-group-item"><a
									href="<%=basePath%>dailycash/list" target="rightkj">钱包缴费记录</a></li>
							</ul>
							<li><a href="javascript:;" class="titlea"><span
									class="iconfont">&#xe60b;</span>学院管理</a></li>
							<ul class="list-group">
								<li class="list-group-item"><a
									href="<%=basePath%>newsType/index" target="rightkj">资讯分类</a></li>
								<li class="list-group-item"><a
									href="<%=basePath%>news/index" target="rightkj">资讯管理</a></li>

							</ul>

							<shiro:hasRole name="admin">
								<li><a href="javascript:;" class="titlea"><span
										class="iconfont">&#xe608;</span>会员管理</a></li>
								<ul class="list-group">
									<li class="list-group-item"><a
										href="<%=basePath%>ldd/sysmember/index" target="rightkj"></span>账号管理</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>ldd/sysmember/financia" target="rightkj">理财师审核</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>ldd/sysmember/dahua" target="rightkj">绑卡管理</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>ldd/sysmember/payment" target="rightkj">付息计划</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>jian/sysmember/rechargeManage"
										target="rightkj">充值管理</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>jian/sysmember/WithdrawManage"
										target="rightkj">提现管理</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>jian/sysmember/inviteRewards"
										target="rightkj">邀请奖励</a></li>
								</ul>

								<li><a href="javascript:;" class="titlea"><span
										class="iconfont">&#xe60a;</span>盈+统计</a></li>
								<ul class="list-group">
									<li class="list-group-item"><a
										href="<%=basePath%>statistics/financeList" target="rightkj">财务统计</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>statistics/userStatistics" target="rightkj">用户综合统计</a></li>
								</ul>

								<li><a href="javascript:;" class="titlea"><span
										class="iconfont">&#xe60a;</span>盈+设置</a></li>
								<ul class="list-group">
									<li class="list-group-item"><a
										href="<%=basePath%>setting/noticelist" target="rightkj">公告管理</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>setting/feedbackList" target="rightkj">意见反馈</a></li>
								</ul>
								<li><a href="javascript:;" class="titlea"><span
										class="iconfont">&#xe60d;</span>系统设置</a></li>
								<ul class="list-group">
									<li class="list-group-item"><a
										href="<%=basePath%>lddsystem/system/userlist/${usersname}" target="rightkj">账户设置</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>lddsystem/system/rolelist" target="rightkj">角色设置</a></li>
									<li class="list-group-item"><a
										href="<%=basePath%>lddsystem/system/updatePasswdPage/${usersname}"
										target="rightkj">密码设置</a></li>
								</ul>
						</ul>
						</shiro:hasRole>
					</div>
				</div>
				<div class="col-sm-10">
					<div class="box-right">
						<iframe width="100%" id="kuangjia" name="rightkj" frameborder=0
							scrolling=auto src="<%=basePath%>sys/index"></iframe>
					</div>
				</div>
				<form action="<%=basePath%>ldd/sysmember/index" method="post"
					id="form1" name="fff">
					<input type="hidden" name="page" id="name">
				</form>
				<!-- 内容结束 -->
			</div>
			<!-- 容器结束 -->
</body>
<script src="<%=basePath%>resources/sys/js/jquery.js"></script>
<script src="<%=basePath%>resources/sys/js/bootstrap.js"></script>
<script src="<%=basePath%>resources/sys/js/yj.js"></script>
<script type="text/javascript">
  function name() {
	  
	document.getElementById("name").value=;
}
  </script>
</html>
