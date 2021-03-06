<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,maximum-scale=1.0,user-scalable=yes">
    <meta name="Keywords" content="股指体验交易，股指单手交易，股指多手交易">
    <meta name="description" content="申请实盘交易账户，直接进行实盘交易。">
    <title>我的加法库 - 盈+</title>
    <#include '../common/resources.html'>
        <link href="<%=basePath%>resources/web/fancybox/jquery.fancybox-1.3.4.css" rel="stylesheet">
        <script src="<%=basePath%>resources/web/fancybox/jquery.fancybox-1.3.4.js"></script>
        <script>
            $(function () {
                $(".picList a").fancybox({
                    'transitionIn': 'none',
                    'transitionOut': 'none',
                    'titlePosition': 'over',
                    'titleFormat': function (title, currentArray, currentIndex, currentOpts) {
                        return '<span id="fancybox-title-over">Image ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
                    }
                });
                $("#mytext").keyup(function () {
                    var txt = parseInt($(this).val());
                    if (txt >= 100) {
                        $("#count").show(100);
                        var lx = $("#num").attr("data-num");
                        var lr = txt * lx;
                        $("#num").text(lr.toFixed(2));
                    } else {
                        $("#count").hide(100);
                    }
                })
                $("#mytext").focus(function () {
                    $("#count").hide(100);
                })
            })


        </script>
        </head>
<body>
<#include "../common/top.html">
    <div class="sdbanner probanner"></div>
    <div class="proMain">
        <div class="conTit">
            <span><a style="color:#9d8440;" href="<%=basePath%>subject">其他标的</a></span>
            <h2><em>￥</em>${(subject.name)!!}</h2>
        </div>
        <table class="conTable" width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td class="txtInfo">
                    <div class="txt1">
                        <h2>${(subject.amount)!!}</h2>
                        <p>标的总额(元)</p>
                    </div>
                    <div class="txt2">
                        <h2>${(subject.yearRate)!!}%</h2>
                        <p>年化收益</p>
                    </div>
                    <div class="txt1">
                        <h2>${(subject.period)!!}</h2>
                        <p>投资期限(天)</p>
                    </div>
                </td>
                <td width="360" rowspan="2" align="center" ; valign="middle" height="320">
                    <div class="tbBox">
                        <input type="hidden" id="account" value="${(memberInfo.account.useableBalance)!!}">
                        <h2>${(subject.amount-summount)!!}</h2>
                        <p>可投金额(元)</p>
                        <div class="li4" style=""><span id="checkmoney" style="color: red;"></span></div>
                        <div class="tit">
                    	<span class="fr">
							<#if memberInfo??>
                                ${memberInfo.account.useableBalance}元&nbsp;&nbsp;<a href="<%=basePath%>account/deposit">充值&nbsp;&nbsp;&nbsp;</a>
                                <#else>
                                    <a style="color:#2695d5" class="unlogin" href="<%=basePath%>web/login">登录</a>后可见
                            </#if>
						</span>
                            <h2>账户余额</h2>
                            <div id="count">预期所得收益<i
                                    data-num="${(subject.yearRate/36500*subject.period)?string('0.000000')}"
                                    id="num">0</i>元
                            </div>
                        </div>
                        <input id="mytext" class="txt" name="totalFee" type="text"
                               placeholder="起投金额${(subject.floorAmount)!!}元以上">
                        <span style="float: right;margin-top: -40px;position: relative; line-height: 40px; padding: 0 10px;color: #f00;" id="addMoney"></span>
                        <p class="preBox">
                            <input type="checkbox" id="registerRule" class="registerRule" checked="checked"><span
                                class="fl">同意<a href="<%=basePath%>web/syxy" target="_black">《产品协议》</a></span>
                            <#if memberInfo??>
                                <button id="redPacket">使用红包</button>
                            </#if>
                        </p>
                        <#if ((subject.amount-summount)>0)&&(subject.status.ordinal()==1)&&(compareDate==false)>
                            <button class="submit">确认抢购</button>
                            <#else>
                                <button disabled style="background-color:#c3c3c3; ">已售罄</button>
                        </#if>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <ul class="conInfoList">
                        <li class="info">
                            <p>还款方式：<font color="#666">${(subject.refundWay.description)!!}</font>&nbsp;&nbsp;&nbsp;&nbsp;保障方式：<font
                                    color="#00baff">${(subject.safeguardWay.description)!!}</font></p>
                            <p>投标进度：<span class="scroll"><em style="width:${(jingdu)!!}%"></em></span><font
                                    color="#666">${(sydate)!!}</font></p>
                        </li>
                        <li id="pie" class="pie" data-num="${(summount/(subject.amount)*100)?string(0.00000)}"></li>
                    </ul>
                </td>
            </tr>
        </table>
        <div class="tbConBox">
            <div class="tab">
                <#if showTab == "detail">
                    <a class="select" href="#1">产品速览</a>
                    <a href="#1">项目详情</a>
                    <a href="#1">安全保障</a>
                    <a href="#1">投资列表</a>
                    <#else>
                        <a href="#1">产品速览</a>
                        <a href="#1">项目详情</a>
                        <a href="#1">安全保障</a>
                        <a class="select" href="#1">投资列表</a>
                </#if>
            </div>
            <div id="conBox">
                <#if showTab == "detail">
                    <div class="box" style="display:block">
                        <#else>
                            <div class="box">
                </#if>

                <table class="dbwtab" width="100%" border="1" bordercolor="#e9e9e9" cellspacing="0" cellpadding="0">

                    <tr>
                        <#list fieldRecords as fs>
                            <td class="corf9"><span>${(fs.fieldId.description)!!}</span></td>
                            <td>${(fs.fieldValue)!!}</td>
                            <#if ((fs_index+1) % 2 == 0) && fs_has_next>
                    </tr>
                    <tr></#if>
                        </#list>
                    </tr>
                </table>
                <div style="border:solid 1px #e9e9e9; padding:15px; margin-top:5px;">${(subject.comment)!!}</div>
                <div class="picList">
                    认证文件展示
                    <ul>
                        <#list subjectFiles as file>
                            <li><a href="<%=basePath%>${file.path}/${file.fileName}"><img
                                    src="<%=basePath%>${file.path}/${file.fileName}"/></a></li>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="box" style="display:none;">
                ${(subject.projectDetails)!!}
            </div>
            <div class="box" style="display:none;">
                ${(subject.safetyControl)!!}
            </div>
            <#if showTab == "detail">
                <div class="box">
                    <#else>
                        <div class="box" style="display:block">
            </#if>
            <#include "ajax_purchase_record.html">
        </div>
    </div>
    </div>
    </div>
    <#include "../common/footer.html">
</body>
<script src='<%=basePath%>resources/dist/js/jquery.min.js'></script>
<script src='<%=basePath%>resources/js/jquery.form.js'></script>
<script type="text/javascript">
    $(function () {
        $(".tbConBox .tab a").click(function () {
            if (!$(this).hasClass("select")) {
                var num = $(this).index();
                $(this).addClass("select").siblings().removeClass("select");
                $("#conBox .box").eq(num).show().siblings().hide();
            }
        });

        $(":input[name=totalFee]").focus(function () {
            $(".li4").hide();
        });

        var redPacket = $("#redPacket");
        var addMoney = $("#addMoney");

        var exists = false;
        var authBankCard=false;
        <#if authBankCard??>
        	<#if authBankCard>
        		authBankCard=true;
        	</#if>
        </#if>
        <#if memberInfo??>
            exists = true;
            //使用红包
            $("#redPacket").click(function () {
                if (redPacket.hasClass("active")) {//选中
                    redPacket.removeClass("active");
                    addMoney.html("");
                } else {//未选中
                    redPacket.addClass("active");
                    addMoney.html("+"+${(memberInfo.account.bonusAmount)!!});
                }
            });


            $(".submit").click(function () {
                if (exists == false) {
                    $("#checkmoney").html("请先登陆!");
                    $(".li4").show(100);
                    return false;
                }
                if(authBankCard==false){
                 	$("#checkmoney").html("请先绑定银行卡，<a href='<%=basePath%>account/security/memberBankcardView'>绑卡</a>");
                     $(".li4").show(100);
                 	return false;
                }
                var value = $(":input[name=totalFee]").val();
                if (value == null || value == '') {
                    $("#checkmoney").html("金额不能为空");
                    $(".li4").show(100);
                    return false;
                }
                value = parseInt(value);
                if (value <${(subject.floorAmount)!!}) {
                    $("#checkmoney").html("起投金额在${(subject.floorAmount)!!}以上");
                    $(".li4").show(100);
                    return false;
                }
                if (value >${(subject.amount-summount)!!}) {
                    $("#checkmoney").html("投资金额大于可投金额");
                    $(".li4").show(100);
                    return false;
                }
                var bonusFee = 0;
                var bbinStatus = 0;
                var acountval = $("#account").val();
                if (acountval != -1) {
                    if ((acountval - value) < 0) {
                        $("#checkmoney").html("账号余额不足，请充值");
                        return false;
                    }
                }
                if (redPacket.hasClass("active")) {//选中红包
                    bonusFee =${(memberInfo.account.bonusAmount)!!};
                }
                $.ajax({
                    type: "POST", // 用POST方式传输
                    dataType: "json", // 数据格式:JSON
                    async: true,
                    url: '<%=basePath%>subjectPur/order', // 目标地址
                    data: {
                        subjectId:${(subject.id)!!},
                        totalFee: value,
                        bonusFee: bonusFee,
                        bbinStatus: bbinStatus
                    },
                    success: function (msg) {
                        if (msg.code == 0) {
                            window.location.href = "<%=basePath%>subjectPur/orderView?tradeNo=" + msg.msg + "&bbinStatus=" + bbinStatus;
                        } else {
                            $("#checkmoney").html(msg.msg);
                            $(".li4").show(100);
                        }
                    }
                });

            });
        <#else>
            $(".submit").click(function () {
                if (exists == false) {
                    $("#checkmoney").html("请先登陆!");
                    $(".li4").show(100);
                    return false;
                }
            });
        </#if>



    });




    require.config({
        paths: {
            echarts: '<%=basePath%>resources/web/echart/dist/'
        }
    });
    require(
            [
                'echarts',
                'echarts/chart/pie'
            ],
            function (ec) {
                var labelTop = {
                    normal: {
                        color: '#ff503f',
                        label: {
                            show: false,
                            position: 'center',
                            formatter: '{b}',
                            textStyle: {
                                baseline: 'bottom'
                            }
                        },
                        labelLine: {
                            show: false
                        }
                    }
                };
                var labelFromatter = {
                    normal: {
                        label: {
                            formatter: function (params) {
                                return 100 - params.value + '%'
                            },
                            textStyle: {
                                color: '#666',
                                baseline: 'middle'
                            }
                        }
                    },
                };
                var labelBottom = {
                    normal: {
                        color: '#f8f8f8',
                        label: {
                            show: true,
                            position: 'center'
                        },
                        labelLine: {
                            show: false
                        }
                    }
                };
                var radius = [40, 48];
                var myChart1 = ec.init(document.getElementById('pie'));
                var num = document.getElementById('pie').getAttribute('data-num');
                myChart1.setOption({
                    series: [
                        {
                            type: 'pie',
                            center: ['50%', '50%'],
                            radius: radius,
                            x: '0%', // for funnel
                            itemStyle: labelFromatter,
                            data: [
                                {name: 'other', value: 100 - num, itemStyle: labelBottom},
                                {name: '占比', value: num, itemStyle: labelTop}
                            ]
                        },
                    ]
                });
            }
    );
</script>
</html>