<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
	<#include '../common/base.html'>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="renderer" content="webkit">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${base}/resources/sys/ying/iconfont.css">
    <link rel="stylesheet" href="${base}/resources/sys/style/bootstrap.css">
    <link rel="stylesheet" href="${base}/resources/sys/style/style.css">
    <script type="text/javascript" src="${base}/resources/sys/js/jquery.js"></script>
	<title>后台首页</title>
</head>
<body>

                     <div class="box-right-main">
                        <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>角色管理</h2>

                      <div class="tablelist">
                        <table class="table tabletop">
                        <tr>
                         <td class="pull-right" style="padding-right:30px"><button type="button" class="btn btn-primary btn-sm add">新增</button></td>
                        </tr>     
                        </table>
                     <table class="table table-bordered tablebox">
                       <tr class="text-center" bgcolor="#f7f7f7">
                         <td>序号</td>
				         <td>角色名</td>
				         <td>角色描述</td>
				         <td>创建时间</td>
				          <td>菜单配置</td>
				      </tr>
				      <#list pageInfo.list as role>
					      <tr class="text-center">
					         <td>${role.id}</td>
					         <td>${role.cname!''}</td>
					         <td>${(role.remark)!''}</td>
					         <td>${role.createDate?string('yyyy/MM/dd HH:mm:ss')}</td>
							 <td><a href="${base}/sys/permisssion?roleId=${role.id}" value="${role.id}" class="btn btn-primary btn-sm">菜单配置</a></td>
					      </tr>
					   </#list> 
					</table>
					<#include "/common/paginate.html" />
<@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="${base}/setting/feedbackList"/>
         </div>

         <!-- 内容结束 -->

	</div>
<!-- 容器结束 -->
</body>
<script type="text/javascript">
    $(function () {
        $(".add").click(function () {
        	window.location.href="${base}/sys/addRolePage";
        });
        
        $(".delRole").click(function () {
        	var roleid = $(this).attr("roleid");
        		$.post(
        			"${base}/sys/delRole/"+roleid,
        			function(result) {
        				alert(result.msg);
	           			if(result.code==0){
	           				location.reload();;
	           			};
            }, 'json');
        });
    });
</script>
</html>