<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
    <#include "../common/base.html">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
	<meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
	<meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
	<title>交易记录-会员中心-盈+</title>
	<link href="http://www.ying158.com/images/icon.ico" type="image/x-icon" rel="shortcut icon">
	<link href="<%=basePath%>resources/web/css/common.css" rel="stylesheet">
	<link href="<%=basePath%>resources/web/css/jw.css" rel="stylesheet">
    <link href="<%=basePath%>resources/web/font/iconfont.css" rel="stylesheet">
    <script src="<%=basePath%>resources/web/js/jquery.js"></script>
    <script src="<%=basePath%>resources/web/echart/dist/echarts.js"></script>
</head>
<body>
<#include "../common/top.html">
<#include "admin-top.html">
    <div class="proMain clearfix">
        <#include "admin-left.html">
        <div class="admin-right">
        	<div class="tbConBox">
                <div class="tab">
                    <a class="select" href="javascript:;">交易记录</a>
                </div>
                <div id="conBox">
                    <div class="box" style="display:block">
                    	<div class="topTit">
                        	<div class="selectbox">
                            	<select>
                                    <option>投资记录</option>
                                    <option>充值记录</option>
                                    <option>收益记录</option>
                                    <option>提款记录</option>
                                </select>
                                <button>查询</button>
                            </div>
                        	最近30天记录(共<font color="#ff503f">${tradeInfoList?size}</font>笔)
                        </div>
                                                      	           	           	                                
                        <table class="tzlist" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">
                          <tr>
                            <th width="25%">订单号</th>                         
                            <th width="15%">金额</th>
                            <th  width="35%">备注</th>
                            <th width="20%">时间</th>
                          </tr>
							<#list tradeInfoList as r>
								<tr>
									<td>${r.serialNumber!!}</td>
									<td><font color="#ff503f">${r.amount?string.currency}</font></td>
									<td>${r.desc!!}</td>
									<td>${r.actionTime?string("yyyy-MM-dd")}</td>
								</tr>
							</#list>                          
                        </table>      
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "../common/footer.html">
</body>
</html>