<%@page import="com.demo.model.Subject"%>
<%@page import="org.springframework.data.domain.Page"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
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

	<%
	Integer subjectType = (Integer) session.getAttribute("subjectType");
	Float yearRate = (Float) session.getAttribute("yearRate");
	Integer period = (Integer) session.getAttribute("period");
	Integer status = (Integer) session.getAttribute("status");
	if(subjectType==null){
		subjectType= 10;
	}
	if(yearRate==null){
		yearRate=(float)-1;
	}
	if(period==null){
		period= -1;
	}
	if(status==null){
		status=-1;
	}
	%>
	<form
		action="<%=basePath%>product/gushou/<%=subjectType%>/<%=yearRate%>/<%=period%>/<%=status%>"
		method="post" name="frm">
		<input type="hidden" name="page" id="page">
	</form>
	<div class="sdShaix">
		<ul>
			<!--subjectType/yearRate/period/status-->
			<li class="first">标的类型：</li>
			<li><a href="<%=basePath%>product/gushou/10/${yearRate}/${period}/${status}"
				id="11">全部</a></li>
			<li><a
				href="<%=basePath%>product/gushou/0/${yearRate}/${period}/${status}"
				id="12">固收类理财</a></li>
			<li><a
				href="<%=basePath%>product/gushou/1/${yearRate}/${period}/${status}"
				id="13">车盈宝</a></li>
		</ul>
		<ul>
			<li class="first">年化收益：</li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/-1/${period}/${status}"
				id="21">全部</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/6/${period}/${status}"
				id="22">6.0%</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/7/${period}/${status}"
				id="23">7.0%</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/7.5/${period}/${status}"
				id="24">7.5%</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/8/${period}/${status}"
				id="25">8.0%</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/9/${period}/${status}"
				id="25">8.0%以上</a></li>
		</ul>
		<ul>
			<li class="first">项目期限：</li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/-1/${status}"
				id="31">全部</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/15/${status}"
				id="32">15天以下</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/30/${status}"
				id="33">15-30天</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/180/${status}"
				id="34">30-180天</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/365/${status}"
				id="35">180-365天</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/366/${status}"
				id="36">一年以上</a></li>
		</ul>
		<ul>
			<li class="first">标的状态：</li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/${period}/-1"
				id="41">全部</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/${period}/1"
				id="42">投标中</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/${period}/2"
				id="43">还款中</a></li>
			<li><a
				href="<%=basePath%>product/gushou/${subjectType}/${yearRate}/${period}/3"
				id="44">已完成</a></li>
		</ul>
	</div>
	<!-- 
	s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status,
 	"hasSold", 
 	"hasBought"
  -->

	<div class="ajaxContainer">
		<!-- 异步内容开始 -->
	<%-- 	<%
			Page<Subject> pagesubject = (Page<Subject>) session.getAttribute("pagesubject");
			List<Subject> lists = pagesubject.getContent();
			for (int i = 0; i < lists.size(); i++) {
		%> --%>
		<c:forEach items="${pagesubject}" var="pagesubject">
		<ul class="tbList">
			<li class="first"><span class="ico zq"></span>
				<h2>${pagesubject[1]}
					<em>投</em>
				</h2> <i></i></li>
			<li class="second">
				<c:if test="${pagesubject[9]!=1}">
					<div class="txt1">
						<h2>
							${pagesubject[2]-1}<span style="font-size: 18px;">+1.0%</span>
						</h2>
						<p>年化收益</p>
					</div>
				</c:if>
				<c:if test="${pagesubject[9]==1}">
					<div class="txt1">
						<h2>${pagesubject[8]}</h2>
						<p>标的总额(万)</p>
					</div>
				</c:if>

				<c:if test="${pagesubject[9]!=1}">
					<div class="txt2">
						<h2>${pagesubject[3]}</h2>
						<p>起购金额(元)</p>
					</div>
				</c:if>
				
				
				<c:if test="${pagesubject[9]==1}">
					<div class="txt2">
						<h2>${pagesubject[2]-1}<span style="font-size:18px;">+1.0%</span></h2>
						<p>年化收益</p>
					</div>
				</c:if>

				<div class="txt2">
					<h2>${pagesubject[4]}天
					</h2>
					<p>投资期限</p>
				</div>
			</li>
			<li class="three"><a href="#1">企业担保</a><span>中国人保财险承保</span>
				<p>
					计息日期：当天投资，立即计息<br>已购人数：${pagesubject[11]==null?0:pagesubject[11]}人
				</p></li>
				
				
				<c:if test="${pagesubject[9]==1}">
					<li class="four">
						<div data-num="0" class="yuan"></div>
					</li>
				</c:if>
				<c:if test="${pagesubject[9]!=1}">
					<li class="four">
						
					</li>
				</c:if>
			<li class="five"><a class="abtn"
				href="<%=basePath%>product/gushougoumai/${pagesubject[0]}"
				target="iFrame2">购买</a></li>
		</ul>
		</c:forEach>
		
		
	
		<!-- 异步内容结束 -->
		<div class="llpage">
			<div class="in">
				<a class="prev_page"
					href="javascript:fun(${page>1?page-1:page})">${page==1?"首页":"上页"}</a>
				<a class="now">${page}</a><a class="next_page"
					href="javascript:fun(${page<pages?page+1:pages})">${page==pages?"尾页":"下页"}</a>
			</div>
		</div>
	</div>


	<script type="text/javascript">
	function fun(page){
		document.getElementById("page").value=page;
		document.frm.submit();
		
	}
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
		require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
			var labelTop = {
				normal : {
					color : '#ff503f',
					label : {
						show : false,
						position : 'center',
						formatter : '{b}',
						textStyle : {
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
						formatter : function(params) {
							return 100 - params.value + '%'
						},
						textStyle : {
							color : '#666',
							baseline : 'middle'
						}
					}
				},
			};
			var labelBottom = {
				normal : {
					color : '#f8f8f8',
					label : {
						show : true,
						position : 'center'
					},
					labelLine : {
						show : false
					}
				}
			};
			var radius = [ 30, 35 ];
			var myChart1 = document.getElementsByClassName('yuan');
			for (i = 0; i < myChart1.length; i++) {
				var num = myChart1[i].getAttribute('data-num');
				ec.init(myChart1[i]).setOption({
					series : [ {
						type : 'pie',
						center : [ '50%', '50%' ],
						radius : radius,
						x : '0%', // for funnel
						itemStyle : labelFromatter,
						data : [ {
							name : 'other',
							value : 100 - num,
							itemStyle : labelBottom
						}, {
							name : '占比',
							value : num,
							itemStyle : labelTop
						} ]
					}, ]
				});
			}
		});
	</script>

</body>
</html>