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
	<div class="sdShaix">
		<ul>
			<li class="first">标的类型：</li>
			<li><a
				href="<%=basePath%>subject?cid=11&type=11&yearRate=21&period=31&status=41"
				id="11">全部</a></li>
			<li><a
				href="<%=basePath%>subject?cid=12&type=11&yearRate=21&period=31&status=41"
				id="12">固收类理财</a></li>
			<li><a
				href="<%=basePath%>subject?cid=13&type=11&yearRate=21&period=31&status=41"
				id="13">车盈宝</a></li>
		</ul>
		<ul>
			<li class="first">年化收益：</li>
			<li><a
				href="<%=basePath%>subject?cid=21&type=11&yearRate=21&period=31&status=41"
				id="21">全部</a></li>
			<li><a
				href="<%=basePath%>subject?cid=22&type=11&yearRate=21&period=31&status=41"
				id="22">6.0%</a></li>
			<li><a
				href="<%=basePath%>subject?cid=23&type=11&yearRate=21&period=31&status=41"
				id="23">7.0%</a></li>
			<li><a
				href="<%=basePath%>subject?cid=24&type=11&yearRate=21&period=31&status=41"
				id="24">7.5%</a></li>
			<li><a
				href="<%=basePath%>subject?cid=25&type=11&yearRate=21&period=31&status=41"
				id="25">8.0%</a></li>
			<li><a
				href="<%=basePath%>subject?cid=25&type=11&yearRate=21&period=31&status=41"
				id="25">8.0%以上</a></li>
		</ul>
		<ul>
			<li class="first">项目期限：</li>
			<li><a
				href="<%=basePath%>subject?cid=31&type=11&yearRate=21&period=31&status=41"
				id="31">全部</a></li>
			<li><a
				href="<%=basePath%>subject?cid=32&type=11&yearRate=21&period=31&status=41"
				id="32">15天以下</a></li>
			<li><a
				href="<%=basePath%>subject?cid=33&type=11&yearRate=21&period=31&status=41"
				id="33">15-30天</a></li>
			<li><a
				href="<%=basePath%>subject?cid=34&type=11&yearRate=21&period=31&status=41"
				id="34">30-180天</a></li>
			<li><a
				href="<%=basePath%>subject?cid=35&type=11&yearRate=21&period=31&status=41"
				id="35">180-365天</a></li>
			<li><a
				href="<%=basePath%>subject?cid=36&type=11&yearRate=21&period=31&status=41"
				id="36">一年以上</a></li>
		</ul>
		<ul>
			<li class="first">标的状态：</li>
			<li><a
				href="<%=basePath%>subject?cid=41&type=11&yearRate=21&period=31&status=41"
				id="41">全部</a></li>
			<li><a
				href="<%=basePath%>subject?cid=42&type=11&yearRate=21&period=31&status=41"
				id="42">投标中</a></li>
			<li><a
				href="<%=basePath%>subject?cid=43&type=11&yearRate=21&period=31&status=41"
				id="43">还款中</a></li>
			<li><a
				href="<%=basePath%>subject?cid=44&type=11&yearRate=21&period=31&status=41"
				id="44">已完成</a></li>
		</ul>
	</div>
<!-- SELECT s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status,
  (COALESCE(SUM(r.amount),0)+ (SELECT COALESCE(SUM(sb.amount),0) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id)) as "hasSold", 
  (COUNT(r.spr_id)+s.bought+(SELECT COUNT(sb.sbpr_id) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id) )  as "hasBought"
  FROM SUBJECT s LEFT JOIN subject_purchase_record r ON s.subject_id = r.subject_id where s.status!=0 GROUP BY  s.subject_id,s.subject_name
  ,s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status
  order by s.create_date desc,s.status  -->

	<div class="ajaxContainer">
		<!-- 异步内容开始 -->
		<%for(int a =0; a<5;a++){%>
		<ul class="tbList">
			<li class="first"><span class="ico zq"></span>
				<h2>
					<em>投</em>有缘固收类1
				</h2> <i></i></li>
			<li class="second">

				<div class="txt1">
					<h2>
						6.0<span style="font-size: 18px;">+1.0%</span>
					</h2>
					<p>年化收益</p>
				</div>

				<div class="txt2">
					<h2>￥100.00</h2>
					<p>起购金额(元)</p>
				</div>

				<div class="txt2">
					<h2>6天</h2>
					<p>投资期限</p>
				</div>
			</li>
			<li class="three"><a href="#1">企业担保</a><span>中国人保财险承保</span>
				<p>
					计息日期：当天投资，立即计息<br>已购人数：421人
				</p></li>
			<li class="four">
				<div data-num="0" class="yuan"></div>
			</li>
			<li class="five"><a class="abtn" href="gushougoumai.jsp"
				target="iFrame2">购买</a></li>
		</ul>
		<%}%>
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
		require.config({
            paths: {
                echarts: '<%=basePath%>resources/web/echart/dist/'
            }
        });
		require(
			[
				'echarts',
				'echarts/chart/pie'
			],
			function (ec) {
				var labelTop = {
						normal : {
							color:'#ff503f',
							label : {
								show : false,
								position : 'center',
								formatter : '{b}',
								textStyle: {
									baseline : 'bottom'
								}
							},
							labelLine : {
								show : false
							}
						}
					};
				var labelFromatter = {
					normal : {
						label : {
							formatter : function (params){
								return 100 - params.value + '%'
							},
							textStyle: {
								color:'#666',
								baseline : 'middle'
							}
						}
					},
				};
				var labelBottom = {
					normal : {
						color: '#f8f8f8',
						label : {
							show : true,
							position : 'center'
						},
						labelLine : {
							show : false
						}
					}
				};
				var radius = [30,35];
				var myChart1 =document.getElementsByClassName('yuan');
				for(i=0;i<myChart1.length;i++){
					var num = myChart1[i].getAttribute('data-num');
					ec.init(myChart1[i]).setOption({
						series : [
							{
								type : 'pie',
								center : ['50%', '50%'],
								radius : radius,
								x: '0%', // for funnel
								itemStyle : labelFromatter,
								data : [
									{name:'other', value:100-num, itemStyle : labelBottom},
									{name:'占比', value:num,itemStyle : labelTop}
								]
							},
						]
					});
				}
			}
		);
    </script>

</body>
</html>