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
        <h2><span class="glyphicon glyphicon-play" style="margin-right:5px"></span>固收类/P2P</h2>

        <div class="tablelist">
        <form action="${base}/subject/sys/gushouList" method="post" id="form1">
            <table class="table tabletop">
                <tr>
                    <td style="width:110px;padding-left:30px">名称：</td>
                    <td style="width:180px"><input type="text" class="form-control" name="name" placeholder="名称" value="${(subject.name)!!}"></td>
                    <td style="width:80px">状态：</td>
                    <td style="width:180px"><select name="status" id="status" class="form-control" style="width:130px;height:32px">
                   		<option value="QUAN_BU">全部</option>
                        <option value="NOT_PUBLISHED">未发布</option>
                        <option value="RAISING">募集中</option>
                        <option value="REFUNDING">回款中</option>
                        <option value="OVER">还款完成</option>
                    </select></td>
                    <td style="width:80px">类型：</td>
                    <td style="width:180px"><select name="type" id="type" class="form-control" style="width:130px;height:32px">
                    	<option value="QUAN_BU">全部</option>
                        <option value="GU_SHOU">固收类</option>
                        <option value="P2P_CHE">P2P车贷</option>
                        <option value="P2P_FANG">P2P房贷</option>
                    </select></td>
                    <td class="pull-right" >
                         <button type="submit" class="btn btn-primary btn-sm">查询</button></td>
                    <td><button type="button" class="btn btn-primary btn-sm" onclick="$('#form1').find(':input').not(':button, :submit, :reset').val('').removeAttr('checked').removeAttr('selected');">重置</button></td>
                    <td class="pull-right">
                        <a class="btn btn-primary btn-sm" href="${base}/subject/sys/addView">新增</a>
                    </td>
                </tr>
            </table>
           </form>
            <table class="table table-bordered tablebox">
                <tr class="text-center" bgcolor="#f7f7f7">
                    <td>序号</td>
                    <td>ID</td>
                    <td>合同编号</td>
                    <td>类型</td>
                    <td>名称</td>
                    <td>标的总金额</td>
                    <td>已投总金额</td>
                    <td>投资期限</td>
                    <td>起投金额</td>
                    <td>年化收益</td>
                    <td>状态</td>
                    <td>可使用体验金</td>
                    <td>添加时间</td>
                    <td>操作</td>
                </tr>
                <#list pageInfo.list as s>
                    <tr class="text-center">
                        <td>${s_index+1}</td>
                        <td>${s.id!!}</td>
                        <td>${s.serialNo!!}</td>
                        <td>${s.type.description!!}</td>
                        <td>${s.name!!}</td>
                        <td></td>
                        <td></td>
                        <td>${s.period!!}天</td>
                        <td>${s.floorAmount!!}元</td>
                        <td>${s.yearRate!!}%</td>
                        <td>${(s.status.description)!!}</td>
                        <td>${(s.experStatus==0)?string('否','是')}</td>
                        <td></td>
                        <td><a class="btn btn-primary btn-sm" href="${base}/subject/sys/editView/${s.id}">编辑/查看</a> <a class="btn btn-primary btn-sm" href="${base}/subject/sys/subjectPurchase?subjcetId=${s.id}">查看投资</a></td>
                    </tr>
                </#list>
            </table>
        </div>
        <#include "paginate.html" />
        <@paginate currentPage=(pageInfo.pageNum)!0 totalPage=(pageInfo.pages)!0 actionUrl="${base}/subject/sys/gushouList" 
        	urlParas="&name=${(subject.name)!!}&status=${(subject.status)!!}&type=${(subject.type)!!}"/>
        <!-- 内容结束 -->
    </div>
    <!-- 容器结束 -->
    <script type="text/javascript">
    	$(function(){
    		$("#status").val("${(subject.status)!!}");
    		$("#type").val("${(subject.type)!!}");
    	});
    
    </script>
    </body>
</html>