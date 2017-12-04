<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
    <head>
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
                        <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>公告管理</h2>

                    <div class="tablelist">
                    <form action="${base}/setting/noticelist" method="post" id="form1">
                  		<table class="table tabletop">
                        <tr>
                        <td style="width:110px;padding-left:30px">标题：</td>
                        <td style="width:180px"><input type="text" class="form-control" name="title" placeholder="公告标题"></td>
                        <td class="pull-right" >
	                        <a class="btn btn-primary btn-sm" href="javascript:;" onclick="javascript:$('#form1').submit();">搜索</a>
	                        <a class="btn btn-primary btn-sm" href="${base}/setting/addNoticePage">新增</a>
	                    </td>
                        </tr>     
                        </table>
                        </form>
                        <table class="table table-bordered tablebox">
                         
                          <tr class="text-center" bgcolor="#f7f7f7">
                          <td>序号</td>
                          <td>类别</td>
                          <td>公告标题</td>
                          <td>添加时间</td>
                          <td>操作</td>
                          </tr>
                          <#list pageInfo.list as b>
                          <tr class="text-center">
                            <td>${b_index+1}</td>
                            <td>${b.messageType.getName()}</td>
                            <td>${(b.title)!!}</td>
                            <td></td>
                            <td><a class="btn btn-primary btn-sm" href="${base}/setting/viewNotice/${b.ownerId}">查看</a>&nbsp;&nbsp;
                            	<a class="btn btn-primary btn-sm" href="${base}/setting/editNoticePage/${b.ownerId}">编辑</a></td>
                          </tr>
                         </#list>
                        </table>
		
			<#include "paginate.html" />
			<@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="${base}/setting/noticelist"/>
         </div>

         <!-- 内容结束 -->

  </div>
<!-- 容器结束 -->
</body>
</html>
