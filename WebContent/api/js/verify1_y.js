//只有trigger 和 wheels 是必要参数  其他都是选填参数
// 加载房屋街道
// var mobileSelecta = new MobileSelect({
//     trigger: '#add_btn0',
//     title: '请选择您的地址',
//     wheels: [
//         {data : UplinkData0}
//     ],
//     transitionEnd:function(indexArr, data){
//         console.log(data);
//     },
//     callback:function(indexArr, data){
//         console.log(data);
//     }
// });
    $.ajax({
    　　type: 'POST', 
        url: '/jianfuzengxiao/api/common/getSelHousesList.html',    //规定连同请求发送到服务器的数据；
        data: {
            'keyword':'A',
            'housesStatus':1
        },   //映射或字符串值，规定连同请求发送到服务器的数据；
        dataType:'json',
        success: function(data){
            var uplinkData0 = data.data;
            for(var i in uplinkData0){
                for(var j in uplinkData0[i]){
                    if(j == 'communityName'){
                        uplinkData0[i]['value'] = uplinkData0[i][j]//修改属性名为“value”
                        delete uplinkData0[i]['communityName']//删除“nationName”
                    }
                    if(j == 'communityId'){
                        uplinkData0[i]['id'] = uplinkData0[i][j]//修改属性id为“id”
                        delete uplinkData0[i]['communityId']//删除“nationId”
                    }
                }
            }
            var mobileSelect0 = new MobileSelect({
                trigger: '#add_btna',
                title: '请选择社区',
                wheels: [
                    {data : uplinkData0}
                ],
                transitionEnd:function(indexArr, data){
                    console.log(data);
                },
                callback:function(indexArr, data){
                    document.getElementById('add_btna').value = data[0].value;
                    // document.getElementById('add_btna').style.display='block';
                    quarter(1,data[0].id);
                }
            });
            var mobileSelecta = new MobileSelect({
                trigger: '#add_btn0',
                title: '请选择社区',
                wheels: [
                    {data : uplinkData0}
                ],
                transitionEnd:function(indexArr, data){
                    console.log(data);
                },
                callback:function(indexArr, data){
                    document.getElementById('add_btn0').value = data[0].value;
                    // document.getElementById('add_btna').style.display='block';
                    quarter(2,data[0].id);
                }
            });
            // $('#house').click(function(){
            //     mobileSelect0.show(1500);
            // })
        }, 
    })
    // 选择小区
    function quarter(housesStatus,communityId){
        var arr = $('.mobileSelect')
        console.log(arr.length)
        for(var i = 0; i< arr.length;i++){
            if(arr.eq(i).find('.title').html() === "请选择小区"){
                arr.eq(i).remove();
            }
        }
        $.ajax({
        　　type: 'POST', 
            url: '/jianfuzengxiao/api/common/getSelHousesList.html',    //规定连同请求发送到服务器的数据；
            data: {
                'keyword': 'B',
                'communityId':communityId,
                'housesStatus':housesStatus
            },   //映射或字符串值，规定连同请求发送到服务器的数据；
            dataType:'json',
            success: function(data){
                var uplinkData0 = data.data;
                for(var i in uplinkData0){
                    for(var j in uplinkData0[i]){
                        if(j == 'communityStreetName'){
                            uplinkData0[i]['value'] = uplinkData0[i][j]//修改属性名为“value”
                            delete uplinkData0[i]['communityStreetName']//删除“nationName”
                        }
                        if(j == 'communityStreetId'){
                            uplinkData0[i]['id'] = uplinkData0[i][j]//修改属性id为“id”
                            delete uplinkData0[i]['communityStreetId']//删除“nationId”
                        }
                    }
                }
                var mobileSelect1 = new MobileSelect({
                    trigger: '#add_btnb',
                    title: '请选择小区',
                    wheels: [
                        {data : uplinkData0}
                    ],
                    transitionEnd:function(indexArr, data){
                        console.log(data);
                    },
                    callback:function(indexArr, data){
                        console.log(data);
                        document.getElementById('add_btnb').value = data[0].value;
                        quarters0(housesStatus,communityId,data[0].id);
                    }
                }); 
                mobileSelect1.show(1500);
            }, 
        })
    }
    // 选择楼号
    function quarters0(housesStatus,communityId,communityStreetId){
        var arr = $('.mobileSelect')
        console.log(arr.length)
        for(var i = 0; i< arr.length;i++){
            if(arr.eq(i).find('.title').html() === "请选择楼号"){
                arr.eq(i).remove();
            }
        }
        $.ajax({
        　　type: 'POST', 
            url: '/jianfuzengxiao/api/common/getSelHousesList.html',    //规定连同请求发送到服务器的数据；
            data: {
                'keyword': 'C',
                'communityId':communityId,
                'housesStatus':housesStatus,
                'communityStreetId':communityStreetId
            },   //映射或字符串值，规定连同请求发送到服务器的数据；
            dataType:'json',
            success: function(data){
                var uplinkData0 = data.data;
                for(var i in uplinkData0){
                    for(var j in uplinkData0[i]){
                        if(j == 'storiedBuildingNumber'){
                            uplinkData0[i]['value'] = uplinkData0[i][j]//修改属性名为“value”
                            delete uplinkData0[i]['storiedBuildingNumber']//删除“nationName”
                        }
                        if(j == 'storiedBuildingNumber'){
                            uplinkData0[i]['id'] = uplinkData0[i][j]//修改属性id为“id”
                            delete uplinkData0[i]['storiedBuildingNumber']//删除“nationId”
                        }
                    }
                }
                var mobileSelect2 = new MobileSelect({
                    trigger: '#add_btnc',
                    title: '请选择楼号',
                    wheels: [
                        {data : uplinkData0}
                    ],
                    transitionEnd:function(indexArr, data){
                        console.log(data);
                    },
                    callback:function(indexArr, data){
                        console.log(data);
                        document.getElementById('add_btnc').value = data[0].value;
                        quartersnum(housesStatus,communityId,communityStreetId,data[0].id);
                    }
                }); 
                mobileSelect2.show(1500);
            }, 
        })
    }
    // 选择单元
    function quartersnum(housesStatus,communityId,communityStreetId,storiedBuildingNumber){
        var arr = $('.mobileSelect')
        console.log(arr.length)
        for(var i = 0; i< arr.length;i++){
            if(arr.eq(i).find('.title').html() === "请选择单元"){
                arr.eq(i).remove();
            }
        }
        $.ajax({
        　　type: 'POST', 
            url: '/jianfuzengxiao/api/common/getSelHousesList.html',    //规定连同请求发送到服务器的数据；
            data: {
                'keyword': 'D',
                'communityId':communityId,
                'housesStatus':housesStatus,
                'communityStreetId':communityStreetId,
                'storiedBuildingNumber':storiedBuildingNumber
            },   //映射或字符串值，规定连同请求发送到服务器的数据；
            dataType:'json',
            success: function(data){
                var uplinkData0 = data.data;
                for(var i in uplinkData0){
                    for(var j in uplinkData0[i]){
                        if(j == 'unit'){
                            uplinkData0[i]['value'] = uplinkData0[i][j]//修改属性名为“value”
                            delete uplinkData0[i]['unit']//删除“nationName”
                        }
                        if(j == 'unit'){
                            uplinkData0[i]['id'] = uplinkData0[i][j]//修改属性id为“id”
                            delete uplinkData0[i]['unit']//删除“nationId”
                        }
                    }
                }
                var mobileSelect3 = new MobileSelect({
                    trigger: '#add_btnd',
                    title: '请选择单元',
                    wheels: [
                        {data : uplinkData0}
                    ],
                    transitionEnd:function(indexArr, data){
                        console.log(data);
                    },
                    callback:function(indexArr, data){
                        console.log(data);
                        document.getElementById('add_btnd').value = data[0].value;
                        quartersn(housesStatus,communityId,communityStreetId,storiedBuildingNumber,data[0].id);
                    }
                }); 
                mobileSelect3.show(1500);
            }, 
        })
    }
    // 选择门牌号
    function quartersn(housesStatus,communityId,communityStreetId,storiedBuildingNumber,unit){
        var arr = $('.mobileSelect')
        console.log(arr.length)
        for(var i = 0; i< arr.length;i++){
            if(arr.eq(i).find('.title').html() === "请选择门牌号"){
                arr.eq(i).remove();
            }
        }
        $.ajax({
        　　type: 'POST', 
            url: '/jianfuzengxiao/api/common/getSelHousesList.html',    //规定连同请求发送到服务器的数据；
            data: {
                'keyword': 'E',
                'communityId':communityId,
                'housesStatus':housesStatus,
                'communityStreetId':communityStreetId,
                'storiedBuildingNumber':storiedBuildingNumber,
                'unit':unit
            },   //映射或字符串值，规定连同请求发送到服务器的数据；
            dataType:'json',
            success: function(data){
                var uplinkData0 = data.data;
                for(var i in uplinkData0){
                    for(var j in uplinkData0[i]){
                        if(j == 'houseNumber'){
                            uplinkData0[i]['value'] = uplinkData0[i][j]//修改属性名为“value”
                            delete uplinkData0[i]['houseNumber']//删除“nationName”
                        }
                        // if(j == 'communityStreetId'){
                        //     uplinkData0[i]['id'] = uplinkData0[i][j]//修改属性id为“id”
                        //     delete uplinkData0[i]['communityStreetId']//删除“nationId”
                        // }
                    }
                }
                var mobileSelect4 = new MobileSelect({
                    trigger: '#add_btne',
                    title: '请选择门牌号',
                    wheels: [
                        {data : uplinkData0}
                    ],
                    transitionEnd:function(indexArr, data){
                        console.log(data);
                    },
                    callback:function(indexArr, data){
                        console.log(data);
                        document.getElementById('add_btne').value = data[0].value;
                    }
                }); 
                mobileSelect4.show(1500);
            }, 
        })
    }
$(".upload_box.first input[type=file]").change(function() {
    var file1_name = document.getElementById('file1')
    console.log(file1_name.files[0])
    if (file1_name.files[0] == undefined) {
        $('.upload_box.first span').html("上传租赁合同")
    } else {
        $('.upload_box.first span').html("已添加租赁合同");
        $('.upload_box.first').addClass('active');
    }
})
$(".upload_box.second input[type=file]").change(function() {
    var file1_name1 = document.getElementById('file2')
    if (file1_name1.files[0] == undefined) {
        $('.upload_box.second span').html("上传租赁合同")
    } else {
        $('.upload_box.second span').html("已添加租赁合同")
        $('.upload_box.second').addClass('active');
    }
})
var date1 = $.selectDate("#date1",{
    start:1994,
    end:2050,
    select:[2012,2,15],
    title:'请选择居住开始时间'
},function (data) {
    // console.log(data);
    $("#date1").html(data.year+"-"+data.month+"-"+data.day);
    $(this).hide()
    setTimeout(function(){
        date2.show()
    }, 300);
});
var date2 = $.selectDate("#date2",{
    start:1994,
    end:2050,
    select:[2012,2,15],
    title:'请选择居住结束时间'
},function (data) {
    // console.log(data);
    $("#date2").html(data.year+"-"+data.month+"-"+data.day);
    date1.hide()
    $(this).hide()
});
/* 控制第一个选择器显示 */
$("#select_date1").click(function () {
    date1.show();
    date2.hide();
})
var date3 = $.selectDate("#date3",{
    start:1994,
    end:2050,
    select:[2012,2,15],
    title:'请选择居住开始时间'
},function (data) {
    // console.log(data);
    $("#date3").html(data.year+"-"+data.month+"-"+data.day);
    $(this).hide()
    setTimeout(function(){
        date4.show()
    }, 300);
});
var date4 = $.selectDate("#date4",{
    start:1994,
    end:2050,
    select:[2012,2,15],
    title:'请选择居住截止时间'
},function (data) {
    // console.log(data);
    $("#date4").html(data.year+"-"+data.month+"-"+data.day);
    date3.hide()
    $(this).hide()
});
/* 控制第三个选择器显示 */
$("#select_date2").click(function () {
    date3.show();
    date4.hide();
})