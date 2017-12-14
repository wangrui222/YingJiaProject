<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>后台首页</title>
    </head>
<body>

                     <div class="box-right-main">
                        <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>邀请奖励</h2>

                      <div class="tablelist">
                      	<form action="<%=basePath%>jian/sysmember/inviteRewards" method="post" id="form1" name="form">
                      	<input type="hidden" id="page" name="page" > 
                        <table class="table tabletop">      
                        <tr>
                         <td style="width:90px;padding-left:20px">姓名：</td>
                        <td style="width:140px"><input type="text" class="form-control" name="memberName" placeholder="姓名" value=""></td>
                        <td style="width:100px;padding-left:20px">手机号：</td>
                        <td><input type="text"  name="mobilePhone" class="form-control" placeholder="手机号" value=""></td>
                        <td style="width:90px;padding-left:20px">邀请码：</td>
                        <td style="width:140px"><input type="text" class="form-control" name="invitationcode" placeholder="邀请码" value=""></td>
                         <td style="width:100px;padding-left:20px">被邀请码：</td>
                        <td><input type="text"  name="invitedcode" class="form-control" placeholder="被邀请码" value=""></td>
                         <td style="width:140px;padding-left:20px">是否已注册奖励：</td>
                        <td><select name="status" class="form-control" style="width:100px;height:32px" id="status">
                        	<option value="">全部</option>
                        	<option value="0">否</option>
                        	<option value="1">是</option>
                        	</select></td>
                         <td style="width:140px;padding-left:20px">是否已投资奖励：</td>
                        <td><select name="delFlag" class="form-control" style="width:100px;height:32px" id="delFlag">
                        	<option value="">全部</option>
                        	<option value="0">否</option>
                        	<option value="1">是</option>
                        	</select></td>
                       <td class="pull-right" style="padding-right:20px">
                         <button type="submit" class="btn btn-primary btn-sm">查询</button></td>
	                    <td><button type="button" class="btn btn-primary btn-sm" onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">重置</button></td>
	                 	 </tr>    
                        </table>
                        </form>
                        <table class="table table-bordered tablebox">
                       
                          <tr class="text-center" bgcolor="#f7f7f7">
                          <td>序号</td>
                          <td>手机号</td>
                          <td>姓名</td>
                          <td>邀请码</td>
                          <td>被邀请码</td>
                          <td>投资金额</td>
                          <td>是否已注册奖励</td>
                          <td>是否已投资奖励</td>
                          <td>注册时间</td>
                          <td>操作</td>
                          </tr>
                         <c:forEach items="${pagelist.getContent()}" var="mlist">
                          <tr class="text-center">
                            <td>${mlist.memberAccountId}</td>
                            <td>${mlist.members.mobilePhone}</td>
                            <td>${mlist.members.memberName}</td>
                            <td>${mlist.members.invitationcode}</td>
                            <td>${mlist.members.invitedcode}</td>
                            <td>${mlist.investAmount}</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                            	
                            			<a class="btn btn-primary btn-sm" href="javascript:" onclick="award('',0)">注册奖励</a>
                            		
                            			<span style="color: blue;">注册已奖励 |</span>
                            	
                            		
	                            			<a class="btn btn-primary btn-sm" href="javascript:" onclick="award('',1)">投资奖励 </a> 
	                            		
	                            			<span style="color: blue;">投资已奖励 |</span>
	                            	
	                            		<span style="color: blue;">投资金额未达到 |</span>
	                            
									<span>不能奖励  |</span>                    	
                            	
                            	<a class="btn btn-primary btn-sm" href="<%=basePath%>sysmember/inviteRewardsRecord?id">奖励记录</a>
                            </td>
                          </tr>
                        </c:forEach>
                        </table>

         </div>

         <!-- 内容结束 -->

	</div>
<!-- 容器结束 -->

       		<div class="llpage">
			<div class="in">
				<nav> <span class="count">&nbsp;第&nbsp;<b>${pagelist.getNumber()+1}</b>&nbsp;页，&nbsp;共&nbsp;<b>${pagelist.getTotalPages()}</b>&nbsp;页
				</span>
				<ul class="pagination">
					<li><a class="prev_page"
						href="javascript:pageRequest(${pagelist.getNumber()>1?pagelist.getNumber():1})">上页</a></li>
					<c:forEach begin="1" end="${pagelist.getTotalPages()}" var="v">
						<li><a class="now" href="javascript:pageRequest(${v})">${v}</a></li>
					</c:forEach>
					<li><a
						href="javascript:pageRequest(${pagelist.getNumber()<pagelist.getTotalPages()?pagelist.getNumber()+1+1:pagelist.getTotalPages()})"
						class="next_page" rel="next">下页</a></li>
				</ul>
				</nav>
			</div>
		</div>
</body>
<script type="text/javascript">
	function pageRequest(page) {
		document.getElementById("page").value = page;
		document.form.submit();

	}
</script>

</html>