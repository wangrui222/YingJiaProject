<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>resources/sys/ying/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>resources/sys/style/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>resources/sys/style/style.css">
    <script type="text/javascript" src="<%=basePath%>resources/sys/js/jquery.js"></script>
    <link rel="stylesheet" href="<%=basePath%>resources/date/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="<%=basePath%>resources/date/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/date/bootstrap-datetimepicker.zh-CN.js"></script>
<title>用户综合查询</title>
</head>
<body>
<div class="box-right-main">
  <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>用户综合统计</h2>
  <div class="tablelist">
  <form action="<%=basePath%>statistics/userStatistics" method="post" id="form1">
    <table class="table" width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
    	<td class="pad0" width="70">手机号码：</td>
    	<td width="200"><input class="form-control" type="text" name="mobilePhone" value="${(mobilePhone)!!}"></td>
    	<td class="pad0">
             <button class="btn btn-primary btn-sm">查询</button>
        </td>
        <td colspan="3" class="pad0">
            <button type="button" class="btn btn-primary btn-sm" onclick="finan()">重置</button>
        </td>
        <td colspan="3" width="500"></td>
    </tr>
    <tr>
        <td class="pad0">开始时间：</td>
        <td><input class="form-control time" name="startDate" type="text" value="${(startDate)!!}" readonly></td>
        <td class="pad0">结束时间：</td>
        <td><input class="form-control time" name="endDate" type="text" value="${(endDate)!!}" readonly></td>
	    <td width="70" class="pad0">交易类型：</td>
	    <td width="200">
	        	<select class="form-control" name="type" id="type">
	            	<option value="">全部</option>
	            	<option value="充值">充值</option>
	            	<option value="投资">投资</option>
	            	<option value="生活消费">生活消费</option>
	            	<option value="红包返利">红包返利</option>
	            	<option value="提现">提现</option>
	            </select>
	     </td>
	     <td width="70" class="pad0">交易方式：</td>
	     <td width="200">
	        	<select class="form-control" name="dealway" id="dealway">
	            	<option value="">全部</option>
	            	<option value="富友">富友</option>
	            	<option value="贝付">贝付</option>
	            </select>
	     </td>
	     <td width="500"></td>
      </tr>
    </table>
    </form>
    <div class="row">
    	<div class="col-md-6 serBox">
        	<h3>基本信息</h3>
        	<table class="table table-bordered" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="120" align="center" class="searTit">真实姓名</td>
                <td>${(member.memberName)!!}</td>
                <td width="120" align="center" class="searTit">身份证号</td>
                <td>${(member.identity)!!}</td>
              </tr>
              <tr>
                <td align="center" class="searTit">手机</td>
                <td>${(member.mobilePhone)!!}</td>
                <td align="center" class="searTit">注册时间</td>
                <td></td>
              </tr>
              <tr>
                <td align="center" class="searTit">微信账号</td>
                <td>${(member.weixinaccoun)???string('是','否')!!}</td>
                <td align="center" class="searTit">QQ账号</td>
                <td>${(member.qqaccount)???string('是','否')!!}</td>
              </tr>
              <tr>
                <td align="center" class="searTit">邀请码</td>
                <td>${(member.invitationcode)!!}</td>
                <td align="center" class="searTit">被邀请码</td>
                <td>${(member.invitedcode)!!}</td>
              </tr>
            </table>
        </div>
        <div class="col-md-6 serBox">
        	<h3>基本信息</h3>
        	<table class="table table-bordered" width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="120" align="center" class="searTit">充值金额</td>
                <td>${(deposit.amount)!!}</td>
                <td width="120" align="center" class="searTit">提现金额</td>
                <td>${(withdraw.amount)!!}</td>
              </tr>
              <tr>
                <td align="center" class="searTit">投资金额</td>
                <td>${(gushouAmount.amount)!!}</td>
                <td align="center" class="searTit">生活消费</td>
                <td>${(memberTradePuc.amount)!!}</td>
              </tr>
                <tr>
                    <td align="center" class="searTit">收益金额</td>
                    <td>${(gushouAmount.interest)!!}</td>
                    <td align="center" class="searTit">红包返利</td>
                    <td>${(awardRegch.amount)!!}</td>
                </tr>
              <tr>
                <td align="center" class="searTit">可用余额</td>
                <td>${(memberAccount.useableBalance)!!}</td>
                <td align="center" class="searTit">冻结余额</td>
                <td>${(memberAccount.imusealeBalance)!!}</td>
              </tr>
              <tr>
                <td align="center" class="searTit">红包余额</td>
                <td>${(memberAccount.bonusAmount)!!}</td>
                <td align="center" class="searTit">体验金</td>
                <td>${(memberAccount.bbinAmount)!!}</td>
              </tr>
            </table>
        </div>
        
    </div>
    <h3 class="jyTit">交易记录</h3>
    <table class="table table-bordered listTab" width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <th width="5%">序号</th>
        <th width="10%">交易编号</th>
        <th width="10%">交易类型</th>
        <th width="10%">金额</th>
        <th width="10%">具体项目</th>
        <th width="10%">交易状态</th>
        <th width="10%">交易时间</th>
        <th>备注</th>
      </tr>
        <#if pageInfo??>
        <#list pageInfo.list as us>
      <tr>
        <td>${(us_index+1)}</td>
        <td>${(us.serialNumber)!!}</td>
        <td>${(us.type)!!}</td>
        <td>${(us.amount)!!}</td>
        <td>${(us.dealway)!!}</td>
        <td>${(us.status)!!}</td>
        <td></td>
        <td>${(us.remark)!!}</td>
      </tr>
        </#list>
        </#if>
    </table>
      <#include "paginate.html" />
      <@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="<%=basePath%>statistics/userStatistics"
      urlParas="&mobilePhone=${(mobilePhone)!!}&type=${(type)!!}&dealway=${(dealway)!!}&startDate=${(startDate)!!}&endDate=${(endDate)!!}"/>


  </div>
  
  <!-- 内容结束 --> 
  
</div>
<script type="text/javascript">
    $('.time').datetimepicker({
        format : 'yyyy-mm-dd',
        language: 'zh-CN',
        minView: 2,
        todayBtn: 1
    }).on('changeDate', function(ev) {
        $('.time').datetimepicker('hide');
    });

    $("#type").val("${(type)!!}");
    $("#dealway").val("${(dealway)!!}");

    function finan(){
        $("input[name='mobilePhone']").val("");
        $("input[name='startDate']").val("");
        $("input[name='endDate']").val("");
        $("input[name='type']").val("");
        $("input[name='dealway']").val("");
    }

</script>
<!-- 容器结束 -->
</body>
</html>