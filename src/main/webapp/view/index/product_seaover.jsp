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
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width,maximum-scale=1.0,user-scalable=yes">
<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
<title>我的加法库 - 盈+</title>

<meta name="keywords"
	content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50" />
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。" />
<link href="<%=basePath%>resources/web/images/icon.ico" type="image/x-icon"
	rel="shortcut icon">

<link href="<%=basePath%>resources/web/font/iconfont.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">

<script src="<%=basePath%>resources/web/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/web/layer/layer.js"></script>
<script src="<%=basePath%>resources/web/echart/dist/echarts.js"></script>
</head>
<body>

	<div class="proMain">

		<ul class="safeList">

			<link href="<%=basePath%>resources/web/images/icon.ico"
				type="image/x-icon" rel="shortcut icon">

			<div class="ajaxContainer">
				<!-- 异步内容开始 -->
				<li><a href="seagoumai.jsp" target="iFrame2"> <span
						style="width: 40px; height: 40px;" class="iconfont"><img
							src="<%=basePath%>upload/news/img/20160115/20160115175237364779.png"
							width="40" height="40" /></span>

						<h2>
							有缘社区
							<p>有缘社区最有缘</p>
						</h2>
						<h3>
							有缘社区
							<p>
								<i style="color: #aaa; font-style: normal;">用户群体：</i>有缘社区
							</p>
						</h3>
				</a></li>
				<li><a href="seagoumai.jsp" target="iFrame2"> <span
						style="width: 40px; height: 40px;" class="iconfont"><img
							src="<%=basePath%>upload/news/img/20160113/20160113145201551421.png"
							width="40" height="40" /></span>

						<h2>
							时尚保险
							<p>时尚保险最时尚</p>
						</h2>
						<h3>
							时尚保险最时尚
							<p>
								<i style="color: #aaa; font-style: normal;">用户群体：</i>青年人
							</p>
						</h3>
				</a></li>
				<li><a href="seagoumai.jsp" target="iFrame2"> <span
						style="width: 40px; height: 40px;" class="iconfont"><img
							src="<%=basePath%>upload/news/img/20160113/2016011314512148898.png"
							width="40" height="40" /></span>

						<h2>
							子女保险
							<p>父母之爱则为之计深远</p>
						</h2>
						<h3>
							为孩子建立一份成长关爱基金，让爱能够伴随孩子一生
							<p>
								<i style="color: #aaa; font-style: normal;">用户群体：</i>国内高净值人群
							</p>
						</h3>
				</a></li>
				<li><a href="seagoumai.jsp" target="iFrame2"> <span
						style="width: 40px; height: 40px;" class="iconfont"><img
							src="<%=basePath%>upload/news/img/20160113/20160113145109628710.png"
							width="40" height="40" /></span>

						<h2>
							养老保险
							<p>未雨绸缪让未来尽在掌握</p>
						</h2>
						<h3>
							为自己建立一份退休养老基金，享受高品质晚年生活
							<p>
								<i style="color: #aaa; font-style: normal;">用户群体：</i>国内高净值人群
							</p>
						</h3>
				</a></li>
				<li><a href="seagoumai.jsp" target="iFrame2"> <span
						style="width: 40px; height: 40px;" class="iconfont"><img
							src="<%=basePath%>upload/news/img/20160113/20160113145053861676.png"
							width="40" height="40" /></span>

						<h2>
							医疗保险
							<p>您的健康是家庭最大的财富</p>
						</h2>
						<h3>
							为自己建立一份医疗基金，防止美好生活被改变
							<p>
								<i style="color: #aaa; font-style: normal;">用户群体：</i>国内高净值人群
							</p>
						</h3>
				</a></li>
				<!-- 异步内容结束 -->


				<div class="llpage">
					<div class="in">

						<a class="prev_page">上页</a> <a class="now">1</a> <a
							class="next_page" rel="next">下页</a>
					</div>
				</div>
			</div>
			<script type="text/javascript">
		function getJsonInfo(url) {
			$.get(url, 'json', function(data) {
				$(".ajaxContainer").empty();
				$(".ajaxContainer").append(data);
			});
		}
	 </script>
		</ul>
	</div>


	<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?06cf97732baac1a65bed8ae95f2384aa";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>

</html>
>
