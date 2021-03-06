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
        <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>海外配置预约记录</h2>

        <div class="tablelist">
            <table class="table table-bordered tablebox">
                <tr class="text-center" bgcolor="#f7f7f7">
                    <td>序号</td>
                    <td>姓名</td>
                    <td>联系电话</td>
                    <td>地址</td>
                    <td>预约时间</td>
                </tr>
                <#list pageInfo.list as s>
                    <tr class="text-center">
                        <td>${s_index+1}</td>
                        <td>${(s.name)!!}</td>
                        <td>${s.phone!!}</td>
                        <td>${s.addr!!}</td>
                        <td>${s.createDate?string('yyyy-MM-dd HH:mm:ss')}</td>
                    </tr>
                </#list>
            </table>
        </div>
        <#include "../common/paginate.html" />
        <@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="<%=basePath%>overseaSys/overseaConfigSubscribe" urlParas="&id=${id}"/>
        <!-- 内容结束 -->
    </div>
    <!-- 容器结束 -->
    </body>
</html>