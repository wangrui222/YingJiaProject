<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
	
<meta name="keywords" content="盈+，盈，社区金融，O2O社区金融，社区金融O2O，O2O，互联网+社区金融，O2O连锁，社区门店，首家社区金融，社区金融服务，综合金融，互联网金融，体验中心，普惠金融，金融创新，社区化，普惠化，全渠道化，互联网线上平台，O2O交易，全国首家，盈十，金融衍生品，固收类理财，私募基金，股权基金，股指期货，玩转股指，商品期货，国际期货，外盘，A50，沪深300，中证500，上证50" />
<meta name="description" content="盈+——全国首家互联网金融交流体验中心，与您共盈，给财富做加法。" />
<link href="<%=basePath%>resources/web/images/icon.ico" type="image/x-icon" rel="shortcut icon">

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>订单详情 - 盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
    <link href="<%=basePath%>resources/web/font/iconfont.css" rel="stylesheet">
	<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
</head>
<body>


<script type="text/javascript">
    $(function(){
        function showIn(url){
            var info="<div class='mydig'><div class='bg'></div><div class='imgbox'><a href="+url+"></a></div></div>";
            $('body').append(info);
        }
            if (1!=null&&1==0){
                showIn("<%=basePath%>account/bbinInfo/getBbinInfo");
            }

    });

</script>  
    <div class="proMain">
    	<div class="orderBox">
        	<div class="title"><h2><span class="iconfont">&#xe606;</span>订单详情</h2></div>
            <div class="order">
            	<img src="<%=basePath%>resources/web/images/orderPic.jpg">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  
                   <tr>
                    <td width="54%"  align="right"><span>产品名称：&nbsp;</span></td>
                    <td>${yugousubject.subjectName}</td>
                  </tr>
                  <tr>
                    <td align="right"><span>投资金额：&nbsp;</span></td>
                    <td><b>${amountcount}</b>元</td>
                  </tr>
                
                  <tr>
                    <td align="right"><span>年化收益率：&nbsp;</span></td>
                    <td><b>${yugousubject.yearRate}</b>%</td>
                  </tr>
                  <tr>
                    <td align="right"><span>借款周期：&nbsp;</span></td>
                    <td><b>${yugousubject.period}</b>天 </td>
                  </tr>
                </table>
            </div>
            <table class="orderInfo" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><p>订单编号：<b>${memberTradeRecord.tradeNo}</b></p>
                <p>订单时间：
               ${SFM}
                </p></td>
                <td align="right">
                	<div class="money">
                    	<b>￥${memberTradeRecord.amount}</b>
                        <span>应付总金额(元)</span>
                    </div>
                    </td>
                  <td width="150px">
					<form action="<%=basePath%>product/fukuan " method="post" class="hiddenForm">               
						<input type="hidden" name="mtrId" value="${memberTradeRecord.mtrId}">
                		<button class="tybutton">立即付款</button>
					</form>
                </td>
              </tr>
            </table>
        </div>
    </div>
    
</body>

<script src='<%=basePath%>resources/ js/jquery.min.js'></script>
<script src='<%=basePath%>resources/js/jquery.form.js'></script>

<%--  <script type="text/javascript">
    $(function () {
        $(".hiddenForm").ajaxForm(function (url) {
            if(url.code==0){
               alert(url.msg);
               location="<%=basePath%>subject/subjectContent/1638?showTab=li";   
            }else{
            	alert(url.msg);	
            }
        });
    });
</script> --%>
</html>