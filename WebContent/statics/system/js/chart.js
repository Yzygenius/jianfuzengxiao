





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
                {value:250, name:'房主通过'},
                {value:375, name:'家属通过'},
                {value:375, name:'租户通过'},
            ]
        }
    ]
};
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}


var dom0 = document.getElementById("container");
var myChart0 = echarts.init(dom0);
var app0 = {};
option0 = null;
app0.title = '环形图';
option0 = {
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
                {value:600, name:'房主通过'},
                {value:400, name:'员工通过'}
            ]
        }
    ]
};
;
if (option0 && typeof option0 === "object") {
    myChart0.setOption(option0, true);
}

var dom1 = document.getElementById("house0");
var myChart1 = echarts.init(dom1);
var app1 = {};
option1 = null;
app1.title = '环形图';
option1 = {
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
                {value:600, name:'房主通过'},
                {value:400, name:'员工通过'}
            ]
        }
    ]
};
;
if (option1 && typeof option1 === "object") {
    myChart1.setOption(option1, true);
}


var dom2 = document.getElementById("house1");
var myChart2 = echarts.init(dom2);
var app2 = {};
option2 = null;
app2.title = '环形图';
option2 = {
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
                {value:600, name:'房主通过'},
                {value:400, name:'员工通过'}
            ]
        }
    ]
};
;
if (option2 && typeof option2 === "object") {
    myChart2.setOption(option2, true);
}