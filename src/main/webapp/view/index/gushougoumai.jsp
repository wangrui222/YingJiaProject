<%@page import="com.demo.model.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
<link
	href="<%=basePath%>resources/web/fancybox/jquery.fancybox-1.3.4.css"
	rel="stylesheet">
<script
	src="<%=basePath%>resources/web/fancybox/jquery.fancybox-1.3.4.js"></script>

<script>
        $(function () {
            $(".picList a").fancybox({
                'transitionIn': 'none',
                'transitionOut': 'none',
                'titlePosition': 'over',
                'titleFormat': function (title, currentArray, currentIndex, currentOpts) {
                    return '<span id="fancybox-title-over">Image ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
                }
            });
            $("#mytext").keyup(function () {
                var txt = parseInt($(this).val());
                if (txt >= 10) {
                    $("#count").show(100);
                    var lx = $("#num").attr("data-num");
                    var lr = txt * lx;
                    $("#num").text(lr.toFixed(2));
                } else {
                    $("#count").hide(100);
                }
            })
            $("#mytext").focus(function () {
                $("#count").hide(100);
            })
        })


    </script>
</head>
<body>
<% Subject subject = (Subject) session.getAttribute("gushougoumailist");
   Float sums = (Float)session.getAttribute("sumamount");
%>
	<div class="proMain">
		<div class="conTit">
			<span><a style="color: #9d8440;" href="<%=basePath%>subject">其他标的</a></span>
			<h2>
				<em>￥</em><%=subject.getSubjectName()%>
			</h2>
		</div>
		<table class="conTable" width="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td class="txtInfo">
					<div class="txt1">
						<h2><%=subject.getBought()%></h2>
						<p>已购人数(人)</p>
					</div>
					<div class="txt2">
						<h2><%=subject.getYearRate()+"%"%></h2>
						<p>年化收益</p>
					</div>
					<div class="txt1">
						<h2><%=subject.getPeriod()%></h2>
						<p>投资期限(天)</p>
					</div>
				</td>
				<td width="360" rowspan="2" align="center" ; valign="middle"
					height="320">
					<div class="tbBox">
						<input type="hidden" id="account" value="">
						<h2><%=sums%></h2>
						<p>已投金额(元)</p>
						<!-- <div class="li4" style="">
							<span id="checkmoney" style="color: red;"></span>
						</div> -->
						<div class="tit">
							<span class="fr"> <a style="color: #2695d5"
								class="unlogin" href="<%=basePath%>web/login">登录</a>后可见
							</span>
							<h2>账户余额</h2>
							<!-- <div id="count">
								预期所得收益<i data-num="0.001151" id="num">0</i>元
							</div> -->
						</div>
						<input id="mytext" class="txt" name="totalFee" type="text"
							placeholder="起投金额<%=subject.getFloorAmount()%>元以上"> <span
							style="float: right; margin-top: -40px; position: relative; line-height: 40px; padding: 0 10px; color: #f00;"
							id="addMoney"></span>
						<p class="preBox">
							<input type="checkbox" id="registerRule" class="registerRule"
								checked="checked"><span class="fl">同意<a
								href="<%=basePath%>web/syxy" target="_black">《产品协议》</a></span>
						</p>
						<button class="submit">确认抢购</button>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<ul class="conInfoList">
						<li class="info">
							<p>
								计息日期：<font color="#00baff"><%=subject.getCreateDate()%>
							<%-- 	<fmt:formatDate value="<%=subject.getCreateDate()%>" pattern="yyyy-MM-dd"/> --%>
								</font>
							</p>
							<p>
								还款方式：<font color="#00baff"><%=subject.getRefundWay()%>
								<%-- <fmt:formatDate value="<%=subject.getRefundWay()%>" pattern="yyyy-MM-dd"/> --%>
								</font>
							</p>
							<p>
								资金到账日：<font color="#00baff"><%=subject.getStartDate()%>
							<%-- 	<fmt:formatDate value="<%=subject.getStartDate()%>" pattern="yyyy-MM-dd"/> --%>
									至<%=subject.getEndDate()%>
							<%-- 	<fmt:formatDate value="<%=subject.getEndDate()%>" pattern="yyyy-MM-dd"/> --%>
								</font>
							</p>
						</li>
						<li class="info">
							<p>
								保障方式：<font color="#00baff"><%=subject.getSafetycontrol()%></font>
							</p>
							<p>
								资金安全：<font color="#00baff">中国人保财险承保</font>
							</p>
							<p></p>
						</li>
					</ul>
				</td>
			</tr>
		</table>
		<%-- <%=subject.getSubjectComment()%> --%>
		<div class="tbConBox">
			<div class="tab">
				<a class="select" href="#1">产品速览</a> <a href="#1">项目详情</a> <a
					href="#1">安全保障</a>
			</div>
			<div id="conBox">
				<div class="box" style="display: block">
					<table class="dbwtab" width="100%" border="1" bordercolor="#e9e9e9"
						cellspacing="0" cellpadding="0">
						<tr>
							<td class="corf9"><span>债权编号</span></td>
							<td>45454</td>

							<td class="corf9"><span>企业认证</span></td>
							<td>545241</td>
						</tr>
						<tr>
							<td class="corf9"><span>债权人</span></td>
							<td>454545</td>

							<td class="corf9"><span>保障平台</span></td>
							<td>safetycontrol</td>

						</tr>
					</table>
					<div
						style="border: solid 1px #e9e9e9; padding: 15px; margin-top: 5px;">
						<p>123</p>
					</div>
				</div>

				<div class="box" style="display: none;">
					<p>123</p>
				</div>
				<div class="box" style="display: none;">
					<p>123</p>
				</div>
			</div>
		</div>
		<div class="picList">
			认证文件展示
			<ul>
				<li><a href="<%=basePath%>upload/514/1449624836387.jpg"><img
						src="<%=basePath%>upload/514/1449624836387.jpg" /></a></li>
				<li><a href="<%=basePath%>upload/514/1449624836600.jpg"><img
						src="<%=basePath%>upload/514/1449624836600.jpg" /></a></li>
				<li><a href="<%=basePath%>upload/514/1449624836815.jpg"><img
						src="<%=basePath%>upload/514/1449624836815.jpg" /></a></li>
			</ul>
			<!-- <div style="clear:both;"></div> -->
		</div>

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
<script type="text/javascript">

    $(function () {
        $(".tbConBox .tab a").click(function () {
            if (!$(this).hasClass("select")) {
                var num = $(this).index();
                $(this).addClass("select").siblings().removeClass("select");
                $("#conBox .box").eq(num).show().siblings().hide();
            }
        });

        $(":input[name=totalFee]").focus(function () {
            $(".li4").hide();
        });

        var redPacket = $("#redPacket");
        var bbinAll = $("#bbinAll");
        var addMoney = $("#addMoney");
        var mytext = $("#mytext");
        var exists = false;
        var authBankCard=false;
        
            $(".submit").click(function () {

                if (exists == false) {
                    $("#checkmoney").html("请先登陆!");
                    $(".li4").show(100);
                    return false;
                }
            });


    });

</script>

</body>
</html>