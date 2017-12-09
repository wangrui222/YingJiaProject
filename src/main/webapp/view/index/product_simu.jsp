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

<link href="<%=basePath%>resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon">

<link href="<%=basePath%>resources/web/font/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">

<script src="<%=basePath%>resources/web/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/web/layer/layer.js"></script>
<script src="<%=basePath%>resources/web/echart/dist/echarts.js"></script>
</head>
<body>

    <div class="ajaxContainer">
        <!-- 异步内容开始 -->
                    <ul class="tbList">
                        <li class="first">
                            <span class="ico jp"></span>
                            <h2><b>测试私募</b></h2>
                            <i></i>
                        </li>
                        <li class="second" style="width:630px;">
                            <div class="txt1">
                                <h2>15%</h2>
                                <p>年化收益</p>
                            </div>
                            <div class="txt2">
                                <h2>365</h2>
                                <p>期限(天)</p>
                            </div>
                            <div class="txt2">
                                <h2>1000000
                                </h2>
                                <p>起购金额(元)</p>
                            </div>

                        </li>
                        <li class="five"><a class="abtn"  href="simugoumai.jsp" target="iFrame2">购买</a></li>
                    </ul>
                    <ul class="tbList">
                        <li class="first">
                            <span class="ico jp"></span>
                            <h2><b>私募标的</b></h2>
                            <i></i>
                        </li>
                        <li class="second" style="width:630px;">
                            <div class="txt1">
                                <h2>15%</h2>
                                <p>年化收益</p>
                            </div>
                            <div class="txt2">
                                <h2>10</h2>
                                <p>期限(天)</p>
                            </div>
                            <div class="txt2">
                                <h2>200
                                </h2>
                                <p>起购金额(元)</p>
                            </div>

                        </li>
                        <li class="five"><a class="abtn"  href="simugoumai.jsp" target="iFrame2">购买</a></li>
                    </ul>
                    <ul class="tbList">
                        <li class="first">
                            <span class="ico jp"></span>
                            <h2><b>私募3234</b></h2>
                            <i></i>
                        </li>
                        <li class="second" style="width:630px;">
                            <div class="txt1">
                                <h2>6%</h2>
                                <p>年化收益</p>
                            </div>
                            <div class="txt2">
                                <h2>5</h2>
                                <p>期限(天)</p>
                            </div>
                            <div class="txt2">
                                <h2>324
                                </h2>
                                <p>起购金额(元)</p>
                            </div>

                        </li>
                        <li class="five"><a class="abtn"  href="simugoumai.jsp" target="iFrame2">购买</a></li>
                    </ul>
                <ul class="tbList">
                    <li class="first">
                        <span class="ico jp"></span>
                        <h2><b>股权标的</b></h2>
                        <i></i>
                    </li>
                    <li class="second">
                        <div class="txt1" style="width:115px; margin-left:40px;">
                            <h2>10%</h2>
                            <p>年化收益</p>
                        </div>
                        <div class="txt2" style="width:120px;margin-left:40px;">
                            <h2>100</h2>
                            <p>起购金额(元)</p>
                        </div>
                    </li>
                    <li class="six three" style="width:290px;">
                        <p>已购人数：345人
                            <br>
                            管理人：345<br>
                            投资方向：345
                        </p>
                    </li>
                    <li class="five"><a class="abtn"  href="simugoumai.jsp" target="iFrame2">购买</a></li>
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
            $.get(url, 'json', function (data) {
                $(".ajaxContainer").empty();
                $(".ajaxContainer").append(data);
            });
        }
    </script>    	
	</div>


</body>
</html>