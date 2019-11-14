<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>上报信息统计分析</title>
    <link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/index1.css">
    <link rel="stylesheet" type="text/css" href="/jianfuzengxiao/statics/system/css/iconfont.css">
    <link href="/jianfuzengxiao/statics/system/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/jianfuzengxiao/statics/system/css/daterangepicker.css"/>
    <style type="text/css">
    </style>
</head>
<body>
    <div class="content" style="overflow-x: scroll;">
        <div class="nav">
            <div class="Community Community0">
                <div class="nav_title"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">社区</div>
                <ul class="nav_list sq" style="width: 90%">
                    <li class="active">全部</li>
                    <li>场所一</li>
                    <li>场所二</li>
                    <li>场所三</li>
                    <li>场所四</li>
                    <li>场所五</li><li>场所一</li>
                    <li>场所二</li>
                    <li>场所三</li>
                    <li>场所四</li>
                    <li>场所五</li>
                    <li>场所五</li><li>场所一</li>
                    <li>场所二</li>
                    <li>场所三</li>
                    <li>场所四</li>
                    <li>场所五</li>
                </ul>
            </div>
            <div class="Community place">
                <div class="nav_title"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">场所</div>
                <ul class="nav_list cs">
                    <li class="active">全部</li>
                    <li>小区一</li>
                    <li>小区二</li>
                    <li>小区三</li>
                    <li>小区四</li>
                    <li>小区五</li>
                    <li>街1</li>
                    <li>街2</li>
                    <li>路2</li>
                    <li>路3</li>
                </ul>
                <div class="nav_num">(共计<span>10</span>户)</div>
            </div>
        </div>
        <div class="Statistics">
            <div class="statis"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">上报信息统计</div>
            <div class="statime">
                <div class="so_far active" data-id="0">上线至今</div>
                <div class="so_far custom0" id="daterange-btn">自定义</div>
                <div class="display" id="time0" style="display:none"><span id="start"></span> 至 <span id="end"></span></div>
            </div>
            <div class="clear"></div>
            <div class="display_details">
                <!-- 总共 -->
                <div class="details" id="total">
                    <div class="details_title">上报信息总量</div>
                    <div class="details_num"><span>3432424</span> 条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理(<span class="percent">87%</span>)</div>
                            <div class="listNum0">3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理(<span class="no_pass">13%</span>)</div>
                            <div class="listNum1">3234424</div>
                        </div>
                    </div>
                </div>
                <!-- 房主 -->
                <div class="details" id="house_fz">
                    <div class="details_title">上报房主认证</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理(<span class="percent">87%</span>)</div>
                            <div class="listNum0">3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理(<span class="no_pass">13%</span>)</div>
                            <div class="listNum1">3234424</div>
                        </div>
                    </div>
                </div>
                <!-- 房屋租户 -->
                <div class="details" id="house_zh">
                    <div class="details_title">上报房屋租户</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理(<span class="percent">87%</span>)</div>
                            <div class="listNum0">3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理(<span class="no_pass">13%</span>)</div>
                            <div class="listNum1">3234424</div>
                        </div>
                    </div>
                </div>
                <!-- 房屋家属 -->
                <div class="details" id="house_js">
                    <div class="details_title">上报房屋家属</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理(<span class="percent">87%</span>)</div>
                            <div class="listNum0">3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理(<span class="no_pass">13%</span>)</div>
                            <div class="listNum1">3234424</div>
                        </div>
                    </div>
                </div>
                <!-- 店主 -->
                <div class="details" id="house_dz">
                    <div class="details_title">上报店主认证</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理(<span class="percent">87%</span>)</div>
                            <div class="listNum0">3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理(<span class="no_pass">13%</span>)</div>
                            <div class="listNum1">3234424</div>
                        </div>
                    </div>
                </div>
                <!-- 员工 -->
                <div class="details" id="house_yz">
                    <div class="details_title">上报店铺员工</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理(<span class="percent">87%</span>)</div>
                            <div class="listNum0">3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理(<span class="no_pass">13%</span>)</div>
                            <div class="listNum1">3234424</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="curve">
            <div class="statis recently"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">上报信息曲线</div>
            <div class="statime recently">
                <div class="lately blue" data-day="30">近30天</div>
                <div class="lately orange" data-day="7">近7天</div>
                <div class="lately green" data-day="180">近半年</div>
                <div class="display display0" style="display: none"><span id="willDay">2019-07-24</span>至<span id="nowDay">2019-07-23</span></div>
            </div>
            <div class="clear"></div>
            <div class="curve_details">
                <div class="curve_left">
                    <div class="cleft_title">
                        <div class="quantity">上报量</div>
                        <div class="strip"><span>3432424</span> 条</div>
                    </div>
                    <div class="cleft_num">
                        <div class="this_week">
                            <div class="week_title">本周期变化率</div>
                            <div class="week_rate">34.23%<img src="/jianfuzengxiao/statics/system/images/Upward.png" alt=""></div>
                        </div>
                        <div class="this_week">
                            <div class="week_title">比上周期变化率</div>
                            <div class="week_rate active">34.23%<img src="/jianfuzengxiao/statics/system/images/down.png" alt=""></div>
                        </div>
                        <div class="change">
                            <div class="change_title">本周期变化量</div>
                            <div class="change_num"><span>+23244</span> 条</div>
                        </div>
                    </div>
                </div>
                <div class="curve_right">
                    <div id="container0" style="height: 100%"></div>
                </div>
            </div>
        </div>
        <div style="display: flex;">
            <div class="house">
                <div class="statis"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋上报已通过</div>
                <div class="statime">
                    <div class="so_far active" data-id="1">上线至今</div>
                    <div class="so_far custom" id="daterange-btn0">自定义</div>
                    <div class="display" id="time1" style="display:none"><span id="start1"></span> 至 <span id="end1"></span></div>
                </div>
                <div class="clear"></div>
                <div style="display: flex;align-items: center;">
                    <div class="house_detail">
                        <div class="house_infor" id="fangzhu">
                            <div class="owner">
                                <div class="owner_title">
                                    <div class="circle"></div>
                                    房主通过
                                </div>
                                <span>3432424</span> 条
                            </div>
                            <div class="rate">
                                <div class="Proportion">
                                    <div>占比</div>
                                    <div><span class="zb">25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span class="pass">30%</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="house_infor" id="jiashu">
                            <div class="owner">
                                <div class="owner_title">
                                    <div class="circle" style="background: rgb(255,97,96);"></div>
                                    家属通过
                                </div>
                                <span>3432424</span> 条
                            </div>
                            <div class="rate">
                                <div class="Proportion">
                                    <div>占比</div>
                                    <div><span class="zb">25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span class="pass">30%</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="house_infor" id="zuhu">
                            <div class="owner">
                                <div class="owner_title">
                                    <div class="circle" style="background: rgb(255,211,80);"></div>
                                    租户通过
                                </div>
                                <span>3432424</span> 条
                            </div>
                            <div class="rate">
                                <div class="Proportion">
                                    <div>占比</div>
                                    <div><span class="zb">25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span class="pass">30%</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="chart">
                        <div id="house" style="height: 100%"></div>
                    </div>
                </div>
            </div>
            <div class="house">
                <div class="statis"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">门店上报已通过</div>
                <div class="statime">
                    <div class="so_far active" data-id="2">上线至今</div>
                     <div class="so_far custom" id="daterange-btn1">自定义</div>
                    <div class="display" id="time2" style="display:none"><span id="start2"></span> 至 <span id="end2"></span></div>
                </div>
                <div class="clear"></div>
                <div style="display: flex;align-items: center;">
                    <div class="house_detail" id="d_zhu">
                        <div class="house_infor">
                            <div class="owner">
                                <div class="owner_title">
                                    <div class="circle"></div>
                                    店主通过
                                </div>
                                <span class="listNum">3432424</span> 条
                            </div>
                            <div class="rate">
                                <div class="Proportion">
                                    <div>占比</div>
                                    <div><span class="percent">25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span class="success_pass">30%</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="house_infor" id="y_gong">
                            <div class="owner">
                                <div class="owner_title">
                                    <div class="circle" style="background: rgb(255,97,96);"></div>
                                    店员通过
                                </div>
                                <span class="listNum">3432424</span> 条
                            </div>
                            <div class="rate">
                                <div class="Proportion">
                                    <div>占比</div>
                                    <div><span class="percent">25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span class="success_pass">30%</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="chart">
                        <div id="container" style="height: 100%"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="curve">
            <div class="statis recently"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">上报信息曲线</div>
            <div class="statime recently">
                <div class="lately blue" data-day="before_3">近30天</div>
                <div class="lately orange" data-day="before_7">近7天</div>
                <div class="lately green" data-day="before_180">近半年</div>
                <div class="display display1" style="display: none"><span id="willDay1">2019-07-23</span> 至 <span id="nowDay1">2019-07-24</span></div>
            </div>
            <div class="clear"></div>
            <div class="curve_details">
                <div class="curve_left">
                    <div class="cleft_title">
                        <div class="quantity">上报量</div>
                        <div class="strip"><span>3432424</span> 条</div>
                    </div>
                    <div class="cleft_num">
                        <div class="this_week">
                            <div class="week_title">本周期变化率</div>
                            <div class="week_rate">34.23%<img src="/jianfuzengxiao/statics/system/images/Upward.png" alt=""></div>
                        </div>
                        <div class="this_week">
                            <div class="week_title">比上周期变化率</div>
                            <div class="week_rate active">34.23%<img src="/jianfuzengxiao/statics/system/images/down.png" alt=""></div>
                        </div>
                        <div class="change">
                            <div class="change_title">本周期变化量</div>
                            <div class="change_num"><span>+23244</span> 条</div>
                        </div>
                    </div>
                </div>
                <div class="curve_right">
                    <div id="shape" style="height: 100%"></div>
                </div>
            </div>
        </div>
    </div>
<script src="/jianfuzengxiao/statics/system/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/echarts.min.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/chart.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/moment.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/daterangepicker.js"></script>
<script>
    $(function () {
        var communityStreetId=""  //小区id
        var communityId=""        //社区id
        window.sessionStorage.clear();   //清除缓存
        inforStat()  //上报信息统计
        house_fw()   //房屋上报信息
        house_md()   //门店信息上报
        curve()      //曲线
        $('.Community li').click(function () {
            $(this).addClass('active').siblings('li').removeClass('active')
        })
        $('.statime .so_far').click(function() {
            $(this).addClass('active').siblings().removeClass('active');
            if ($(this).hasClass('active')) {
                $('#time0').fadeOut(0);
                $('#time1').fadeOut(0);
                $('#time2').fadeOut(0);

            } else {
                $('#time0').fadeIn(0);
                $('#time1').fadeIn(0);
                $('#time2').fadeIn(0);
            }
            if($(this).attr("data-id") == "0"){
                $('#start').html('')
                $('#end').html('')
               inforStat()
            }else if($(this).attr("data-id") == "1"){
               $('#start1').html('')
               $('#end1').html('')
               house_fw()   //房屋上报信息
            }else if($(this).attr("data-id") == "2"){
              $('#start2').html('')
              $('#end2').html('')
               house_md()  //门店信息上报
            }
        })
     // 社区
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/common/getCommunityList.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{},
            success:function(data){
                var list1=""
                // console.log(data.data)
                for(var i=0; i<data.data.length;i++){
                    list1 += '<li data-communityId = '+data.data[i].communityId+'>'+data.data[i].communityName+'</li>'
                }
                $('.sq').html(list1)
                $('.sq').prepend('<li data-communityId ="" class="active">全部</li>')
                $('.sq li').click(function(){
                    var start = $('#start').html()
                    var end = $('#end').html()
                    var start1 = $('#start1').html()
                    var end1 = $('#end1').html()
                    var start2 = $('#start2').html()
                    var end2 = $('#end2').html()
                    $(this).addClass('active').siblings('li').removeClass('active');
                     sessionStorage.communityId = $(this).attr("data-communityId");
                     inforStat(start,end)   //信息统计
                     house_fw(start1,end1)    //房屋统计
                     house_md(start2,end2)    //门店统计
                     curve()

                })
            },
            error:function(jqXHR){}
        });
         // 小区
         $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/common/getCommunityStreetList.html ',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{},
            success:function(data){

                // console.log(data.data);
                var list2=""
                for(var i=0; i<data.data.length;i++){
                    list2 += '<li data-communityStreetId = '+data.data[i].communityStreetId+'>'+data.data[i].communityStreetName+'</li>'
                }
                $('.cs').html(list2)
                $('.cs').prepend('<li data-communityStreetId="" class="active">全部</li>')
                $('.nav_num span').html(data.data.length)
                $('.cs li').click(function(){
                     var start = $('#start').html()
                     var end = $('#end').html()
                     var start1 = $('#start1').html()
                     var end1 = $('#end1').html()
                     var start2 = $('#start2').html()
                     var end2 = $('#end2').html()
                    $(this).addClass('active').siblings('li').removeClass('active')
                    sessionStorage.communityStreetId = $(this).attr("data-communityStreetId")
                     inforStat(start,end)     //信息统计
                     house_fw(start1,end1)    //房屋统计
                     house_md(start2,end2)    //门店统计
                     curve()
                })
             
            },
            error:function(jqXHR){}
        });
        
         var today=new Date();
         var year=today.getFullYear();        //获取当前年
         var month=today.getMonth()+1;   //获取当前月
         var date=today.getDate();            //获取当前日
         var nowDay = year+'-'+month+"-"+date;
         $('.statime .lately').click(function(){
             if($(this).attr("data-day") == "30"){
                  hq_date(30)
                  var day = hq_date(30)
                  $('#nowDay').html(nowDay)
                  $('#willDay').html(day)
                  $('.display0').fadeIn(0);
                  curve(day,nowDay)

             }else if($(this).attr("data-day") == "7"){
                  hq_date(7)
                  var day = hq_date(7)
                  $('#nowDay').html(nowDay)
                  $('#willDay').html(day)
                  $('.display0').fadeIn(0);
                  curve(day,nowDay)


             }else if($(this).attr("data-day") == "180"){
                  hq_date(180)
                  var day = hq_date(180)
                 $('#nowDay').html(nowDay)
                  $('#willDay').html(day)
                  $('.display0').fadeIn(0);
                  curve(day,nowDay)
             }else if($(this).attr("data-day") == "before_3"){
                  hq_date(30)
                  var day = hq_date(30)
                  $('#nowDay1').html(nowDay)
                  $('#willDay1').html(day)
                  $('.display1').fadeIn(0);
                  curve(day,nowDay)
             }else if($(this).attr("data-day") == "before_7"){
                console.log('7')
                  hq_date(7)
                  var day = hq_date(7)
                  $('#nowDay1').html(nowDay)
                  $('#willDay1').html(day)
                  $('.display1').fadeIn(0);
                  curve(day,nowDay)
             }else if($(this).attr("data-day") == "before_180"){
                console.log('180')

                  hq_date(180)
                  var day = hq_date(180)
                  $('#nowDay1').html(nowDay)
                  $('#willDay1').html(day)
                  $('.display1').fadeIn(0);
                  curve(day,nowDay)
             }
         })
    })
    // 获取时间函数
    function hq_date(sky){
        var today=new Date();
        var day=today.setDate(today.getDate()-sky);
        day=new Date(day);
        //获取当前年
        var year=day.getFullYear();
        //获取当前月
        var month=day.getMonth()+1;
        //获取当前日
        var date = day.getDate();
        day = year+'-'+month+"-"+date;
        return day;
    }
    // 上报信息统计
    function inforStat(start,end){
         $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getReportInfo.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
                communityId:sessionStorage.communityId,
                communityStreetId:sessionStorage.communityStreetId,
                startTime:start,
                stopTime:end
            },
            success:function(data){
               console.log(data.data)
               $('#total .details_num span').html(data.data.total)
               $('#total .percent').html(parseInt((data.data.totalPassRatio)*100) + '%')
               $('#total .listNum0').html(data.data.totalPass+'条')
               $('#total .no_pass').html(parseInt((data.data.totalWaitRatio)*100) + '%')
               $('#total .listNum1').html(data.data.totalWait+'条')

               $('#house_fz .details_num span').html(data.data.fangzhunum)
               $('#house_fz .percent').html(parseInt((data.data.fangzhuPassRatio)*100) + '%')
               $('#house_fz .listNum0').html(data.data.fangzhuPass+'条')
               $('#house_fz .no_pass').html(parseInt((data.data.fangzhuWaitRatio)*100) + '%')
               $('#house_fz .listNum1').html(data.data.fangzhuWait+'条')

               $('#house_zh .details_num span').html(data.data.zuhunum)
               $('#house_zh .percent').html(parseInt((data.data.zuhuPassRatio)*100) + '%')
               $('#house_zh .listNum0').html(data.data.zuhuPass+'条')
               $('#house_zh .no_pass').html(parseInt((data.data.zuhuWaitRatio)*100) + '%')
               $('#house_zh .listNum1').html(data.data.zuhuWait+'条')

               $('#house_js .details_num span').html(data.data.jiashunum)
               $('#house_js .percent').html(parseInt((data.data.jiashuPassRatio)*100) + '%')
               $('#house_js .listNum0').html(data.data.jiashuPass+'条')
               $('#house_js .no_pass').html(parseInt((data.data.jiashuWaitRatio)*100) + '%')
               $('#house_js .listNum1').html(data.data.jiashuWait+'条')

               $('#house_dz .details_num span').html(data.data.dianzhunum)
               $('#house_dz .percent').html(parseInt((data.data.dianzhuPassRatio)*100) + '%')
               $('#house_dz .listNum0').html(data.data.dianzhuPass+'条')
               $('#house_dz .no_pass').html(parseInt((data.data.dianzhuWaitRatio)*100) + '%')
               $('#house_dz .listNum1').html(data.data.dianzhuWait+'条')

               $('#house_yz .details_num span').html(data.data.yuangongnum)
               $('#house_yz .percent').html(parseInt((data.data.yuangongPassRatio)*100) + '%')
               $('#house_yz .listNum0').html(data.data.yuangongPass+'条')
               $('#house_yz .no_pass').html(parseInt((data.data.yuangongWaitRatio)*100) + '%')
               $('#house_yz .listNum1').html(data.data.yuangongWait+'条')
            },
            error:function(jqXHR){}
        });
    }
    // 房屋上报
    function house_fw(start,end){
        $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getFangwuReportPass.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
                communityId:sessionStorage.communityId,
                communityStreetId:sessionStorage.communityStreetId,
                startTime:start,
                stopTime:end
            },
            success:function(data){
             // console.log(data.data)
             $('#fangzhu .owner span').html(data.data.fangzhuPass)
             $('#fangzhu .zb').html(parseInt((data.data.fangzhuRatio)*100)+'%')
             $('#fangzhu .pass').html(parseInt((data.data.fangzhuPassRatio)*100)+'%')
             $('#zuhu .owner span').html(data.data.zuhuPass)
             $('#zuhu .zb').html(parseInt((data.data.zuhuRatio)*100)+'%')
             $('#zuhu .pass').html(parseInt((data.data.zuhuPassRatio)*100)+'%')
             $('#jiashu .owner span').html(data.data.jiashuPass)
             $('#jiashu .zb').html(parseInt((data.data.jiashuRatio)*100)+'%')
             $('#jiashu .pass').html(parseInt((data.data.jiashuPassRatio)*100)+'%')
             var dom = document.getElementById("house");
                var myChart = echarts.init(dom);
                var app = {};
                option = null;
                app.title = '环形图';
                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    series: [
                        {
                            name:'访问来源',
                            type:'pie',
                            radius: ['40%', '80%'],
                            avoidLabelOverlap: false,
                            color:['#14e8ec','#ff6160','#ffd350'],
                            label: {
                                normal: {
                                    show: false,
                                    position: 'center'
                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '16',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data:[
                                {value:(data.data.fangzhuPassRatio)*1000, name:'房主通过'},
                                {value:(data.data.jiashuPassRatio)*1000, name:'家属通过'},
                                {value:(data.data.zuhuPassRatio)*1000, name:'租户通过'},
                            ]
                        }
                    ]
                };
                if (option && typeof option === "object") {
                    myChart.setOption(option, true);
                }
            },
            error:function(jqXHR){}
        });

    }
    // 门店上报
    function house_md(start,end){
         $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getMendianReportPass.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
                communityId:sessionStorage.communityId,
                communityStreetId:sessionStorage.communityStreetId,
                startTime:start,
                stopTime:end
            },
            success:function(data){
             // console.log(data.data)
             $('#d_zhu .listNum').html(data.data.dianzhuPass)
             $('#d_zhu .percent').html(parseInt((data.data.dianzhuRatio)*100) +'%')
             $('#d_zhu .success_pass').html(parseInt((data.data.dianzhuPassRatio)*100)+'%')
             $('#y_gong .listNum').html(data.data.yuangongPass)
             $('#y_gong .percent').html(parseInt((data.data.yuangongRatio)*100)+'%')
             $('#y_gong .success_pass').html(parseInt((data.data.yuangongPassRatio)*100)+'%')
             var dom = document.getElementById("container");
                var myChart = echarts.init(dom);
                var app = {};
                option = null;
                app.title = '环形图';
                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    series: [
                        {
                            name:'访问来源',
                            type:'pie',
                            radius: ['40%', '80%'],
                            avoidLabelOverlap: false,
                            color:['#14e8ec','#ff6160'],
                            label: {
                                normal: {
                                    show: false,
                                    position: 'center'
                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '16',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data:[
                                {value:(data.data.dianzhuPassRatio)*1000, name:'店主通过'},
                                {value:(data.data.jiashuPassRatio)*1000, name:'电员通过'},
                            ]
                        }
                    ]
                };
                if (option && typeof option === "object") {
                    myChart.setOption(option, true);
                }
            },
            error:function(jqXHR){}
        });
    }
    // 上报曲线图
    function curve(start,end){
         $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getReportCurve.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
                communityId:sessionStorage.communityId,
                communityStreetId:sessionStorage.communityStreetId,
                startTime:start,
                stopTime:end
            },
            success:function(data){
                // console.log(data.data)
                var date=[];
                var count=[];
                var count1=[];
                for(var i=0;i<data.data.length;i++){
                   date.push(data.data[i].day+'日')
                   count.push(data.data[i].count)
                   count1.push(parseInt(data.data[i].count))
                }
                // console.log(date)
                // console.log(count)
                tu1(date,count);
                tu2(date,count1)
            },
            error:function(jqXHR){}
        });
    }

    $('.ranges_1 ul').remove();
    $('#daterange-btn').daterangepicker({
            ranges: {
                '自定义': [moment(), moment().subtract(-1, 'days')],
                '本周': [moment(), moment()],
                '上周': [moment().subtract(-1, 'days'), moment().subtract(-1, 'days')],
                '本月': [moment(),moment().subtract(-6, 'days')],
                '上月': [moment(),moment().subtract(-29, 'days')],
                '今年': [moment(),moment().subtract(-59, 'days'), ]
            },
            startDate: moment(),
            endDate: moment()
        },
        function(start, end,label) {
            $('#time0').html('<span id="start">'+start.format('YYYY/MM/DD')+'</span> 至 <span id="end">'+end.format('YYYY/MM/DD')+'</span>');
            $('#time0').fadeIn(0);
            inforStat(start.format('YYYY/MM/DD'),end.format('YYYY/MM/DD'))
        }
    );
    $('#daterange-btn0').daterangepicker({
            ranges: {
                '自定义': [moment(), moment().subtract(-1, 'days')],
                '本周': [moment(), moment()],
                '上周': [moment().subtract(-1, 'days'), moment().subtract(-1, 'days')],
                '本月': [moment(),moment().subtract(-6, 'days')],
                '上月': [moment(),moment().subtract(-29, 'days')],
                '今年': [moment(),moment().subtract(-59, 'days'), ]
            },
            startDate: moment(),
            endDate: moment()
        },
        function(start, end,label) {
            $('#time1').html('<span id="start1">'+start.format('YYYY/MM/DD')+'</span> 至 <span id="end1">'+end.format('YYYY/MM/DD')+'</span>');
            $('#time1').fadeIn(0);
            house_fw(start.format('YYYY/MM/DD'),end.format('YYYY/MM/DD'))
        }
    );
     $('#daterange-btn1').daterangepicker({
            ranges: {
                '自定义': [moment(), moment().subtract(-1, 'days')],
                '本周': [moment(), moment()],
                '上周': [moment().subtract(-1, 'days'), moment().subtract(-1, 'days')],
                '本月': [moment(),moment().subtract(-6, 'days')],
                '上月': [moment(),moment().subtract(-29, 'days')],
                '今年': [moment(),moment().subtract(-59, 'days'), ]
            },
            startDate: moment(),
            endDate: moment()
        },
        function(start, end,label) {
            $('#time2').html('<span id="start2">'+start.format('YYYY/MM/DD')+'</span> 至 <span id="end2">'+end.format('YYYY/MM/DD')+'</span>');
            $('#time2').fadeIn(0);
            house_md(start.format('YYYY/MM/DD'),end.format('YYYY/MM/DD'))
        }
    );
    function tu1(date,count){
        var chart = document.getElementById("container0");
            var echart = echarts.init(chart);
            // var data0 = ['1日','2日','3日','4日','5日','6日','7日','8日'];
            var data0 =date;
            var optioni = {
                title: {
                    text: ''
                },
                tooltip : {
                    // trigger: 'axis',
                    trigger: 'item',           // 触发类型，默认数据触发，见下图，可选为：'item' ¦ 'axis'
                    showDelay: 20,             // 显示延迟，添加显示延迟可以避免频繁切换，单位ms
                    hideDelay: 100,            // 隐藏延迟，单位ms
                    transitionDuration : 0.4,  // 动画变换时间，单位s
                    backgroundColor: 'rgba(0,0,0,0.7)',     // 提示背景颜色，默认为透明度为0.7的黑色
                    borderColor: '#333',       // 提示边框颜色
                    borderRadius: 4,           // 提示边框圆角，单位px，默认为4
                    borderWidth: 0,            // 提示边框线宽，单位px，默认为0（无边框）
                    padding: 5,                // 提示内边距，单位px，默认各方向内边距为5，
                    // 接受数组分别设定上右下左边距，同css
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'line',         // 默认为直线，可选为：'line' | 'shadow'
                        lineStyle : {          // 直线指示器样式设置
                            color: '#48b',
                            width: 2,
                            type: 'solid'
                        },
                        shadowStyle : {                       // 阴影指示器样式设置
                            width: 'auto',                   // 阴影大小
                            color: 'rgba(150,150,150,0.3)'  // 阴影颜色
                        }
                    },
                    textStyle: {
                        color: '#fff'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    top:20,
                    containLabel: true
                },

                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : data0
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series: [{
                    name: '上报信息',
                    type: 'line',
                    // data: [2270, 3456, 5432, 3423,5432,2270,3456,5432],
                    data: count,
                    smooth: true,
                    symbol: 'emptyCircle',
                    symbolSize: 10,
                    itemStyle: {
                        normal: {
                            color: {
                                type: 'linear',
                                x: 0,
                                y: 0,
                                x2: 0,
                                y2: 1,
                                colorStops: [{
                                    offset: 0, color: '#00FFF4' // 0% 处的颜色
                                }, {
                                    offset: 1, color: '#6F63F3' // 100% 处的颜色
                                }],
                                globalCoord: false // 缺省为 false
                            },
                        }
                    },
                    lineStyle: {
                        normal: {
                            color: {
                                type: 'linear',
                                x: 0,
                                y: 0,
                                x2: 0,
                                y2: 1,
                                colorStops: [{
                                    offset: 0, color: '#6F63F3' // 0% 处的颜色
                                }, {
                                    offset: 1, color: '#00FFF4' // 100% 处的颜色
                                }],
                                globalCoord: false // 缺省为 false
                            },
                            width: 4
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: "rgba(51,255,25,0)",
                        }
                    }
                }]
            };
            echart.setOption(optioni);
     }
    function tu2(date,count1){
        var dom = document.getElementById("shape");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        // var dataAxis = ['1日', '2日', '3日', '4日', '5日', '6日', '7日', '8日', '9日', '10日', '11日', '12日', '13日', '14日', '15日', '16日', '17日', '18日', '19日', '20日','1日', '2日', '3日', '4日', '5日', '6日', '7日', '8日', '9日', '10日'];
        var dataAxis =  date;
        // var data = [10,4,3,2,1];
        var data = count1;
        // var yMax = 500;
        var yMax= ""
        var dataShadow = [];

        for (var i = 0; i < data.length; i++) {
            dataShadow.push(yMax);
        }

        option = {
            tooltip : {
                // trigger: 'axis',
                trigger: 'item',           // 触发类型，默认数据触发，见下图，可选为：'item' ¦ 'axis'
                showDelay: 20,             // 显示延迟，添加显示延迟可以避免频繁切换，单位ms
                hideDelay: 100,            // 隐藏延迟，单位ms
                transitionDuration : 0.4,  // 动画变换时间，单位s
                backgroundColor: 'rgba(0,0,0,0.7)',     // 提示背景颜色，默认为透明度为0.7的黑色
                borderColor: '#333',       // 提示边框颜色
                borderRadius: 4,           // 提示边框圆角，单位px，默认为4
                borderWidth: 0,            // 提示边框线宽，单位px，默认为0（无边框）
                padding: 5,                // 提示内边距，单位px，默认各方向内边距为5，
                // 接受数组分别设定上右下左边距，同css
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'line',         // 默认为直线，可选为：'line' | 'shadow'
                    lineStyle : {          // 直线指示器样式设置
                        color: '#48b',
                        width: 2,
                        type: 'solid'
                    },
                    shadowStyle : {                       // 阴影指示器样式设置
                        width: 'auto',                   // 阴影大小
                        color: 'rgba(150,150,150,0.3)'  // 阴影颜色
                    }
                },
                textStyle: {
                    color: '#fff'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                top:20,
                containLabel: true
            },
            xAxis :{
                type : 'category',
                // boundaryGap : false,
                data : dataAxis,

            },
            yAxis: {
                axisLine: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    textStyle: {
                        color: '#333'
                    }
                }
            },
            series: [
                { // For shadow
                    type: 'bar',
                    itemStyle: {
                        normal: {color: 'rgba(0,0,0,0)'}
                    },
                    barGap:'-100%',
                    barCategoryGap:'50%',
                    data: dataShadow,
                    animation: false
                },
                {
                    type: 'bar',
                    itemStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#73F3AE'},
                                    {offset: 0.5, color: '#64E1CC'},
                                    {offset: 1, color: '#4BC2FE'}
                                ]
                            )
                        },
                        emphasis: {
                            color: new echarts.graphic.LinearGradient(
                                0, 0, 0, 1,
                                [
                                    {offset: 0, color: '#4BC2FE'},
                                    {offset: 0.7, color: '#64E1CC'},
                                    {offset: 1, color: '#73F3AE'}
                                ]
                            )
                        }
                    },
                    data: data
                }
            ]
        };

        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }
   
</script>
</body>
</html>