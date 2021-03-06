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
        <title>后台首页</title>
    </head>
    <body>
    <div class="box-right-main">
        <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>海外配置</h2>
		          <table class="table tabletop">
                <tr>
                    <td class="pull-right" >
                        <a class="btn btn-primary btn-sm" href="<%=basePath%>overseaSys/overseaConfigView">新增</a>
                    </td>
                </tr>
            </table>
        <div class="tablelist">
            <table class="table table-bordered tablebox">
                <tr class="text-center" bgcolor="#f7f7f7">
                    <td>序号</td>
                    <td>ID</td>
                    <td>标题</td>
                    <td>子标题</td>
                    <td>状态</td>
                    <td>排序值</td>
                    <td>图标</td>
                    <td>添加时间</td>
                    <td>操作</td>
                </tr>
                <#list pageInfo.list as s>
                    <tr class="text-center">
                        <td>${s_index+1}</td>
                        <td>${s.id!!}</td>
                        <td>${(s.title)!!}</td>
                        <td>${(s.childTitle)!!}</td>
                        <td>${(s.statusDesc)!!}</td>
                        <td>${(s.sortColum)!!}</td>
                        <td><img src="<%=basePath%>${(s.overseaIcon)!!}" width="20" height="20"></td>
                        <td></td>
                        <td>
                            <a class="btn btn-primary btn-sm" href="<%=basePath%>overseaSys/overseaConfigSubscribe/${s.id}">查看预约</a>
                            <a class="btn btn-primary btn-sm" href="<%=basePath%>overseaSys/overseaConfigView?id=${s.id}">编辑/查看</a>
                        </td>
                    </tr>
                </#list>
            </table>
        <#include "../common/paginate.html" />
        <@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="<%=basePath%>overseaSys/overseaConfig"/>
        </div>
    </div>
    </body>
</html>