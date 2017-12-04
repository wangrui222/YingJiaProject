<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>用戶管理</title>
    <meta name="content-type" content="text/html; charset=UTF-8">
  </head>
  <body>
        <div class="fh_right_box">
           <h3><span class="iconfont" style="font-size:20px;color:#38c2b0">&#xe621;</span>&nbsp;日志管理</h3>
           <img src="${base}/resources/images/hr.jpg" class="xian"/>
        </div>
	    <table class="table table-striped" style="text-align:center">
	       <tr>
	         <td>序号</td>
	         <td>账号</td>
	         <td>类型</td>
	         <td>操作ip</td>
	         <td>操作时间</td>
	         <td>操作</td>
	      </tr>
	      <#if (pagelist.results)?exists && pagelist.results?size gt 0>
	      <#list pagelist.results as log>
		      <tr>
		         <td>${log.id}</td>
		         <td>${log.user.userName}</td>
		         <td>${log.action.getName()}</td>
		         <td>${(log.loginIp)!"未知"}</td>
		         <td>${log.createDate?string('yyyy/MM/dd HH:mm:ss')}</td>
		         <td><span>查看</span></td>
		      </tr>
		   </#list> 
	      </#if>
		</table>
		<form action="" id="pagerForm">
		 <#include '../common/paginate.html'>
		</form>  
</body>
</html>
