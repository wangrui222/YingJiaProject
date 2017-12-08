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

</head>
<body>
 <div class="proMain">
    	<div class="hwpzNav">
    		<ul>
    			<li class="first"><a class="active" href="<%=basePath%>subject">固收类理财</a></li>
    			<li class="second"><a href="<%=basePath%>finance">私募基金</a></li>
    			<li class="three"><a href="<%=basePath%>oversea">海外配置</a></li>
    			<li class="four"><a href="<%=basePath%>finance">股权基金</a></li>
    		</ul>
    	</div>
        <div class="sdShaix">
        	<ul>
            	<li class="first">标的类型：</li>
               		<li><a href="<%=basePath%>subject?cid=11&type=11&yearRate=21&period=31&status=41" id="11">全部</a></li>
               		<li><a href="<%=basePath%>subject?cid=12&type=11&yearRate=21&period=31&status=41" id="12">固收类理财</a></li>
               		<li><a href="<%=basePath%>subject?cid=13&type=11&yearRate=21&period=31&status=41" id="13">车盈宝</a></li>
            </ul>
        	<ul>
            	<li class="first">年化收益：</li>
               		<li><a href="<%=basePath%>subject?cid=21&type=11&yearRate=21&period=31&status=41" id="21">全部</a></li>
               		<li><a href="<%=basePath%>subject?cid=22&type=11&yearRate=21&period=31&status=41" id="22">6.0%</a></li>
               		<li><a href="<%=basePath%>subject?cid=23&type=11&yearRate=21&period=31&status=41" id="23">7.0%</a></li>
               		<li><a href="<%=basePath%>subject?cid=24&type=11&yearRate=21&period=31&status=41" id="24">7.5%</a></li>
               		<li><a href="<%=basePath%>subject?cid=25&type=11&yearRate=21&period=31&status=41" id="25">8.0%</a></li>
               		<li><a href="<%=basePath%>subject?cid=25&type=11&yearRate=21&period=31&status=41" id="25">8.0%以上</a></li>
            </ul>
        	<ul>
            	<li class="first">项目期限：</li>
               		<li><a href="<%=basePath%>subject?cid=31&type=11&yearRate=21&period=31&status=41" id="31">全部</a></li>
               		<li><a href="<%=basePath%>subject?cid=32&type=11&yearRate=21&period=31&status=41" id="32">15天以下</a></li>
               		<li><a href="<%=basePath%>subject?cid=33&type=11&yearRate=21&period=31&status=41" id="33">15-30天</a></li>
               		<li><a href="<%=basePath%>subject?cid=34&type=11&yearRate=21&period=31&status=41" id="34">30-180天</a></li>
               		<li><a href="<%=basePath%>subject?cid=35&type=11&yearRate=21&period=31&status=41" id="35">180-365天</a></li>
               		<li><a href="<%=basePath%>subject?cid=36&type=11&yearRate=21&period=31&status=41" id="36">一年以上</a></li>
            </ul>
        	<ul>
            	<li class="first">标的状态：</li>
               		<li><a href="<%=basePath%>subject?cid=41&type=11&yearRate=21&period=31&status=41" id="41">全部</a></li>
               		<li><a href="<%=basePath%>subject?cid=42&type=11&yearRate=21&period=31&status=41" id="42">投标中</a></li>
               		<li><a href="<%=basePath%>subject?cid=43&type=11&yearRate=21&period=31&status=41" id="43">还款中</a></li>
               		<li><a href="<%=basePath%>subject?cid=44&type=11&yearRate=21&period=31&status=41" id="44">已完成</a></li>
            </ul>
        </div>

<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50" />
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。" />
<link href="<%=basePath%>resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon">

<div class="ajaxContainer">
	<!-- 异步内容开始 -->
					<ul class="tbList">
						<li class="first">
									<span class="ico zq"></span>
							<h2><em>投</em>有缘固收类1</h2>
							<i></i>
						</li>
						<li class="second">					
							
							<div class="txt1">
								<h2>6.0<span style="font-size:18px;">+1.0%</span></h2>
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
						<li class="three">
								<a href="#1">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：当天投资，立即计息<br>已购人数：421人</p>
						</li>
						<li class="four">
								
						</li>
						<li class="five">
							<a class="abtn" href="<%=basePath%>subject/subjectContent/1638">购买</a>
						</li>
					</ul>
					<ul class="tbList">
						<li class="first">
									<span class="ico cd"></span>
							<h2><em>投</em>测试车贷123</h2>
							<i></i>
						</li>
						<li class="second">					
							<div class="txt1">
								<h2>5555</h2>
								<p>标的总额(万)</p>
							</div>
							
							<div class="txt2">
								<h2>7.0<span style="font-size:18px;">+1.0%</span></h2>
								<p>年化收益</p>
							</div>
							
							
							<div class="txt2">
								<h2>5天</h2>
								<p>投资期限</p>
							</div>
						</li>
						<li class="three">
								<a href="#1">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：募集满后第二天<br>已购人数：
									0人</p>
						</li>
						<li class="four">
								<div data-num="0" class="yuan"></div>
						</li>
						<li class="five">
							<a class="abtn" href="<%=basePath%>subject/subjectContent/1637">购买</a>
						</li>
					</ul>
					<ul class="tbList">
						<li class="first">
									<span class="ico zq"></span>
							<h2><em>投</em>理财宝一号11</h2>
							<i></i>
						</li>
						<li class="second">					
							
							<div class="txt1">
								<h2>6.0<span style="font-size:18px;">+1.0%</span></h2>
								<p>年化收益</p>
							</div>
							
							<div class="txt2">
								<h2>￥100.00</h2>
								<p>起购金额(元)</p>
							</div>
							
							<div class="txt2">
								<h2>5天</h2>
								<p>投资期限</p>
							</div>
						</li>
						<li class="three">
								<a href="#1">企业担保</a><span>中国人保财险承保</span>
								<p>计息日期：当天投资，立即计息<br>已购人数：105人</p>
						</li>
						<li class="four">
								
						</li>
						<li class="five">
							<a class="abtn" href="<%=basePath%>subject/subjectContent/1628">购买</a>
						</li>
					</ul>
	<!-- 异步内容结束 -->
	
	
	<div class="llpage">
		<div class="in">
			
				<a class="prev_page">上页</a>
			
			
					<a class="now" >1</a>
			
			
				<a class="next_page" rel="next">下页</a>
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
    </script>    </div>
    
    
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?06cf97732baac1a65bed8ae95f2384aa";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

<script type="text/javascript">
$(function(){
	$('#11').addClass("select");
	$('#21').addClass("select");
	$('#31').addClass("select");
	$('#41').addClass("select");
});
</script>


</body>
</html>