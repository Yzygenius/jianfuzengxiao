<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/font.css">
    <link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/xadmin.css">
    <link rel="stylesheet" href="/jianfuzengxiao/statics/system/assets/css/flipclock.css">
</head>
<body>

<div class="centerView" data-type="index" th:fragment="content">
<!-- 内容区域 -->
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row am-cf">
            <div class="am-u-sm-12 am-u-md-8">
                <div class="widget am-cf am-text-center">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl" style="font-size: 24px;margin: 20px 0 0 35px;">
                            <span id="today"></span>
                        </div>
                    </div>
                    <div class="widget-body-md widget-body am-fr">
                        <div class="clock" style="margin:2em;"></div>
                    </div>
                </div>
            </div>

<!--             <div class="am-u-sm-12 am-u-md-4">
                <div class="widget am-cf am-text-center">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">工具箱</div>
                    </div>
                    <div class="widget-body widget-body-md am-fr">
                        <table style="width: 100%;height: 100%;text-align: center;">
                            <tr>
                                <th>
                                    <div style="cursor:pointer" data-am-modal="{target: '#calculatorModal', closeViaDimmer: 0, width: 300, height: 360}">
                                        <img src="/jianfuzengxiao/statics/system/assets/icon/calculator.png" style="width: 60px">
                                    </div>
                                    <small>计算器</small>
                                </th>
                                <th>
                                    <div style="cursor:pointer" data-am-modal="{target: '#weatherModal', closeViaDimmer: 0, width: 900, height: 225}">
                                        <img src="/jianfuzengxiao/statics/system/assets/icon/weather.png" style="width: 60px">
                                    </div>
                                    <small>天气</small>
                                </th>
                                <th>
                                    <div style="cursor:pointer" data-am-modal="{target: '#todomvcModal', closeViaDimmer: 0, width: 800, height: 600}">
                                        <img src="/jianfuzengxiao/statics/system/assets/icon/notepad.png" style="width: 60px">
                                    </div>
                                    <small>备忘录</small>
                                </th>
                            </tr>
                            <tr>
                                <th></th>
                                <th></th>
                                <th></th>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div> -->


<!--         <div class="row am-cf">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
                <div class="tpl-user-card am-text-center widget-body-lg">
                    <div class="tpl-user-card-title">
                        月度最佳员工
                    </div>
                    <img class="achievement-image" src="" alt="" id="bestImg">
                    <div class="achievement-subheading" id="bestName">

                    </div>
                    <div class="achievement-description">
                        再接再厉，勇创新高！
                    </div>
                </div>
            </div>

            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg">
                <div class="widget am-cf widget-body-lg">
                    <div class="widget-body  am-fr">
                        <div class="am-scrollable-horizontal ">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">站内信</div>
                            </div>
                            <div class="widget-body widget-body-md am-fr">
                                <p id="messageP">暂无最新信息</p>
                                <span id="MessageRealnameS" style="float: right"></span><br/>
                                <span id="MessageSendTimeS" style="float: right"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg">
                <div class="widget am-cf widget-body-lg">
                    <div class="widget-body  am-fr">
                        <div class="am-scrollable-horizontal ">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">公告板</div>
                            </div>
                            <div class="widget-body widget-body-md am-fr">
                                <p id="noticeP">暂无最新信息</p>
                                <span id="NoticeRealnameS" style="float: right"></span><br/>
                                <span id="NoticeSendTimeS" style="float: right"></span>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> -->
    </div>
</div>
<script type="text/javascript" src="/jianfuzengxiao/statics/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/assets/js/flipclock.min.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/welcome.js"></script>

<script>
    $(document).ready(function() {
        $('#indexA').attr('class','active');
        //翻页钟插件初始化
         var clock = $('.clock').FlipClock({
            clockFace: 'TwentyFourHourClock'
        });
        $("#today").text(getCurrentDateTime() + " 农历 " + showCal());
        //最佳员工
       // getBestImageNum();
        //getBestUserName();
        //最后一条信息和公告
        //getLastMessage();
        //getLastNotice(); 
    });
</script>
</div>
</body>
</html>