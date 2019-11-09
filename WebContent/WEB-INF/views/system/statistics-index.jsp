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
</head>
<body>
    <div class="content">
        <div class="nav">
            <div class="Community Community0">
                <div class="nav_title"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">社区</div>
                <ul class="nav_list">
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
                <ul class="nav_list">
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
                <div class="nav_num">(共计10户)</div>
            </div>
        </div>
        <div class="Statistics">
            <div class="statis"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">上报信息统计</div>
            <div class="statime">
                <div class="so_far active">上线至今</div>
                <div class="so_far custom0" id="daterange-btn">自定义</div>
                <div class="display" id="time0"><span>2019-07-23</span> 至 <span>2019-07-23</span></div>
            </div>
            <div class="clear"></div>
            <div class="display_details">
                <div class="details">
                    <div class="details_title">上报信息总量</div>
                    <div class="details_num"><span>3432424</span> 条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理（87%)</div>
                            <div>3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理（13%)</div>
                            <div>3234424</div>
                        </div>
                    </div>
                </div>
                <div class="details">
                    <div class="details_title">上报房主认证</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理（87%)</div>
                            <div>3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理（13%)</div>
                            <div>3234424</div>
                        </div>
                    </div>
                </div>
                <div class="details">
                    <div class="details_title">上报房屋租户</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理（87%)</div>
                            <div>3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理（13%)</div>
                            <div>3234424</div>
                        </div>
                    </div>
                </div>
                <div class="details">
                    <div class="details_title">上报房屋家属</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理（87%)</div>
                            <div>3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理（13%)</div>
                            <div>3234424</div>
                        </div>
                    </div>
                </div>
                <div class="details">
                    <div class="details_title">上报店主认证</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理（87%)</div>
                            <div>3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理（13%)</div>
                            <div>3234424</div>
                        </div>
                    </div>
                </div>
                <div class="details">
                    <div class="details_title">上报店铺员工</div>
                    <div class="details_num"><span>3432424</span>条</div>
                    <div class="Situation">
                        <div class="situation_success">
                            <div>已处理（87%)</div>
                            <div>3234424</div>
                        </div>
                        <div class="situation_success">
                            <div>未处理（13%)</div>
                            <div>3234424</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="curve">
            <div class="statis recently"><img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">上报信息曲线</div>
            <div class="statime recently">
                <div class="lately blue">近30天</div>
                <div class="lately orange">近7天</div>
                <div class="lately green">近半年</div>
                <div class="display"><span>2019-07-23</span> 至 <span>2019-07-24</span></div>
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
                    <div class="so_far active">上线至今</div>
                    <div class="so_far custom">自定义</div>
                    <div class="display"><span>2019-07-23</span> 至 <span>2019-07-24</span></div>
                </div>
                <div class="clear"></div>
                <div style="display: flex;align-items: center;">
                    <div class="house_detail">
                        <div class="house_infor">
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
                                    <div><span>25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span>30%</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="house_infor">
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
                                    <div><span>25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span>30%</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="house_infor">
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
                                    <div><span>25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span>30%</span></div>
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
                    <div class="so_far active">上线至今</div>
                    <div class="so_far custom">自定义</div>
                    <div class="display"><span>2019-07-23</span> 至 <span>2019-07-24</span></div>
                </div>
                <div class="clear"></div>
                <div style="display: flex;align-items: center;">
                    <div class="house_detail">
                        <div class="house_infor">
                            <div class="owner">
                                <div class="owner_title">
                                    <div class="circle"></div>
                                    店主通过
                                </div>
                                <span>3432424</span> 条
                            </div>
                            <div class="rate">
                                <div class="Proportion">
                                    <div>占比</div>
                                    <div><span>25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span>30%</span></div>
                                </div>
                            </div>
                        </div>
                        <div class="house_infor">
                            <div class="owner">
                                <div class="owner_title">
                                    <div class="circle" style="background: rgb(255,97,96);"></div>
                                    店员通过
                                </div>
                                <span>3432424</span> 条
                            </div>
                            <div class="rate">
                                <div class="Proportion">
                                    <div>占比</div>
                                    <div><span>25%</span></div>
                                </div>
                                <div class="Proportion">
                                    <div>审核通过率</div>
                                    <div><span>30%</span></div>
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
                <div class="lately blue">近30天</div>
                <div class="lately orange">近7天</div>
                <div class="lately green">近半年</div>
                <div class="display"><span>2019-07-23</span> 至 <span>2019-07-24</span></div>
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
        $('.Community li').click(function () {
            $(this).addClass('active').siblings('li').removeClass('active')
        })
    })
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
            $('#time0').html('<span>'+start.format('YYYY/MM/DD')+'</span> 至 <span>'+end.format('YYYY/MM/DD')+'</span>');
            $('#daterange-btn').addClass('active').siblings('.so_far').removeClass('active');
            //label:通过它来知道用户选择的是什么，传给后台进行相应的展示
//      console.log(label)
//             if(label=='全部'){
//                 $('#daterange-btn span').html('全部');
//             }else if(label=='今天'){
//                 $('#daterange-btn span').html(end.format('YYYY/MM/DD'));
//             }else if(label=='明天'){
//                 $('#daterange-btn span').html(start.format('YYYY/MM/DD'));
//             }else if(label=='未来七天'){
//                 $('#daterange-btn span').html(start.format('YYYY/MM/DD')+'-'+end.format('YYYY/MM/DD'));
//             }else if(label=='未来30天'){
//                 $('#daterange-btn span').html(start.format('YYYY/MM/DD')+'-'+end.format('YYYY/MM/DD'));
//             }else if(label=='未来60天'){
//                 $('#daterange-btn span').html(start.format('YYYY/MM/DD')+'-'+end.format('YYYY/MM/DD'));
//             }else{
//
//             }

        }
    );
    var chart = document.getElementById("container0");
    var echart = echarts.init(chart);
    var data0 = ['1日','2日','3日','4日','5日','6日','7日','8日'];
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
            data: [2270, 3456, 5432, 3423,5432,2270,3456,5432],
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



    var dom = document.getElementById("shape");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    var dataAxis = ['1日', '2日', '3日', '4日', '5日', '6日', '7日', '8日', '9日', '10日', '11日', '12日', '13日', '14日', '15日', '16日', '17日', '18日', '19日', '20日','1日', '2日', '3日', '4日', '5日', '6日', '7日', '8日', '9日', '10日'];
    var data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220,220, 182, 191, 234, 290, 330, 310, 123, 442, 321];
    var yMax = 500;
    var dataShadow = [];

    for (var i = 0; i < data.length; i++) {
        dataShadow.push(yMax);
    }

    option = {
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
</script>
</body>
</html>