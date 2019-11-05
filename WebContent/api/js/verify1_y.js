//只有trigger 和 wheels 是必要参数  其他都是选填参数
// 加载房屋街道
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
                },
                callback:function(indexArr, data){
                    document.getElementById('add_btn0').value = data[0].value;
                    // document.getElementById('add_btna').style.display='block';
                    quarter(2,data[0].id);
                }
            });
        }, 
    })
    // 选择小区
    function quarter(housesStatus,communityId){
        var arr = $('.mobileSelect')
        console.log(arr.length)
        for(var i = 0; i< arr.length;i++){
            if(arr.eq(i).find('.title').html() === "请选择小区" || arr.eq(i).find('.title').html() === "请选择小区/街道"){
                arr.eq(i).remove();
            }
        }
        if(housesStatus == 1){
            title = '请选择小区'
        }else if(housesStatus == 2){
            title = '请选择小区/街道'
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
                    title: title,
                    wheels: [
                        {data : uplinkData0}
                    ],
                    transitionEnd:function(indexArr, data){
                        console.log(data);
                    },
                    callback:function(indexArr, data){
                        console.log(data);
                        document.getElementById('add_btnb').value = data[0].value;
                        if(housesStatus == 1){
                            quarters0(housesStatus,communityId,data[0].id);
                        }else if(housesStatus == 2){
                            if(data[0].communityStreetStatus == 1){
                                var UplinkData = [{id:1,value:'内铺'},{id:2,value:'外铺'}]
                                var mobileSelecta = new MobileSelect({
                                    trigger: '#add_btn1',
                                    title: '内铺/外铺',
                                    wheels: [
                                        {data : UplinkData}
                                    ],
                                    transitionEnd:function(indexArr, data){
                                    },
                                    callback:function(indexArr, data){
                                        document.getElementById('add_btn1').value = data[0].value;
                                        Number(housesStatus,communityId,data[0].communityStreetStatus,data[0].id);
                                    }
                                });
                                mobileSelecta.show(1500)
                            }else if(data[0].communityStreetStatus == 2){
                                Number(housesStatus,communityId,data[0].communityStreetStatus);
                            }
                        }
                        
                    }
                }); 
                mobileSelect1.show(1500);
            }, 
        })
    }
    //选择门店的号
    function Number(housesStatus,communityId,communityStreetStatus,storeLocation){
        var arr = $('.mobileSelect')
        console.log(arr.length)
        for(var i = 0; i< arr.length;i++){
            if(arr.eq(i).find('.title').html() === "请选择楼号"){
                arr.eq(i).remove();
            }
        }
        var infor = {
            'keyword': 'E',
            'communityId':communityId,
            'housesStatus':housesStatus,   
            'communityStreetStatus':communityStreetStatus
        }
        if(storeLocation !== undefined || storeLocation !== 'undefined'){
            infor.storeLocation = storeLocation
        }
        $.ajax({
        　　type: 'POST', 
            url: '/jianfuzengxiao/api/common/getSelHousesList.html',    //规定连同请求发送到服务器的数据；
            data: infor,  //映射或字符串值，规定连同请求发送到服务器的数据；
            dataType:'json',
            success: function(data){
                var uplinkData0 = data.data;
                for(var i in uplinkData0){
                    for(var j in uplinkData0[i]){
                        if(j == 'houseNumber'){
                            uplinkData0[i]['value'] = uplinkData0[i][j]//修改属性名为“value”
                            delete uplinkData0[i]['houseNumber']//删除“nationName”
                        }
                        // if(j == 'storiedBuildingNumber'){
                        //     uplinkData0[i]['id'] = uplinkData0[i][j]//修改属性id为“id”
                        //     delete uplinkData0[i]['storiedBuildingNumber']//删除“nationId”
                        // }
                    }
                }
                var mobileSelectb = new MobileSelect({
                    trigger: '#add_btn2',
                    title: '请选择门店号',
                    wheels: [
                        {data : uplinkData0}
                    ],
                    transitionEnd:function(indexArr, data){
                    },
                    callback:function(indexArr, data){
                        document.getElementById('add_btn2').value = data[0].value;
                        layer.load(1);
                        var housesId = data[0].housesId;
                        $.ajax({
                        　　type: 'POST', 
                            url: '/jianfuzengxiao/api/personnel/getVerifyHouses.html',    //规定连同请求发送到服务器的数据；
                            data: {
                                'userId':sessionStorage.userId,
                                'housesId':housesId
                            },  //映射或字符串值，规定连同请求发送到服务器的数据；
                            dataType:'json',
                            success: function(data){
                                layer.closeAll('loading');
                                var infor = data.data;
                                if(data.code == 1){
                                    $('.select_house').fadeOut(0);
                                    $('.select_time .box-one').fadeOut(0);
                                    $('.images').html('');
                                    // layer.msg('添加成功');
                                    if(data.data.housesMode == 1){
                                        $('#support').fadeIn(200);
                                        $('#support').find('.store').fadeIn(200);
                                        $('#support .store').html('<div class="box-title"><img src="images/yang/house4.png" alt=""><span>'+
                                            infor.communityStreetName+infor.houseNumber+'号'+'</span>'+
                                            '<span class="zc">自持</span></div><div class="box-cont">'+infor.housesAddress+'</div>'+
                                            '<div class="inputInput"><p>企业名称</p><input type="text" placeholder="填写企业名称" id="ent_name"></div>');
                                        $('#support .store').attr('data-houseId',housesId);
                                        $('#submit').attr('data-type',3);
                                    }else if(data.data.housesMode == 2){
                                        $('#lease').fadeIn(200);
                                        $('#lease').find('.store').fadeIn(200);
                                        $('#lease .store .box-title').html('<img src="images/yang/house4.png" alt=""><span>'+
                                            infor.communityStreetName+infor.houseNumber+'号'+'</span>');
                                        $('#lease .store .box-cont').html(infor.housesAddress);
                                        $('#lease .store').attr('data-houseId',housesId);
                                        $('#submit').attr('data-type',4);
                                    }
                                }else{
                                    layer.msg(data.msg);
                                }
                                $('.new_select').click(function(){
                                    $('.select_house').fadeIn(0);
                                    $('.select_time').fadeOut(0);
                                })
                            }, 
                        })
                    }
                }); 
                mobileSelectb.show(1500);
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
                    },
                    callback:function(indexArr, data){
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
                    },
                    callback:function(indexArr, data){
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
                    }
                }
                var mobileSelect4 = new MobileSelect({
                    trigger: '#add_btne',
                    title: '请选择门牌号',
                    wheels: [
                        {data : uplinkData0}
                    ],
                    transitionEnd:function(indexArr, data){
                        // console.log(data);
                    },
                    callback:function(indexArr, data){
                        // console.log(data);
                        document.getElementById('add_btne').value = data[0].value;
                        layer.load(1);
                        var housesId = data[0].housesId;
                        $.ajax({
                        　　type: 'POST', 
                            url: '/jianfuzengxiao/api/personnel/getVerifyHouses.html',    //规定连同请求发送到服务器的数据；
                            data: {
                                'userId':sessionStorage.userId,
                                'housesId':housesId
                            },  //映射或字符串值，规定连同请求发送到服务器的数据；
                            dataType:'json',
                            success: function(data){
                                layer.closeAll('loading');
                                var infor = data.data;
                                if(data.code == 1){
                                    $('.select_house').fadeOut(0);
                                    $('.select_time .box-one').fadeOut(0);
                                    $('.images').html('');
                                    if(data.data.housesMode == 1){
                                        $('#support').fadeIn(200);
                                        $('#support').find('.house').fadeIn(200);
                                        $('#support .house').html('<div class="box-title"><img src="images/yang/house4.png" alt=""><span>'+
                                            infor.communityStreetName+infor.storiedBuildingNumber+'号楼'+infor.unit+'单元'+infor.houseNumber+'</span>'+
                                            '<span class="zc">自持</span></div><div class="box-cont">'+infor.housesAddress+'</div>')
                                        $('#support .house').attr('data-houseId',housesId);
                                        $('#submit').attr('data-type',1);
                                    }else if(data.data.housesMode == 2){
                                        $('#lease').fadeIn(200);
                                        $('#lease').find('.house').fadeIn(200);
                                        $('#lease .house .box-title').html('<img src="images/yang/house3.png" alt=""><span>'+
                                            infor.communityStreetName+infor.storiedBuildingNumber+'号楼'+infor.unit+'单元'+infor.houseNumber+'</span>');
                                        $('#lease .house .box-cont').html(infor.housesAddress);
                                        $('#lease .house').attr('data-houseId',housesId);
                                        $('#submit').attr('data-type',2)
                                    }
                                }else{
                                    layer.msg(data.msg);
                                }
                                $('.new_select').click(function(){
                                    $('.select_house').fadeIn(0);
                                    $('.select_time').fadeOut(0);
                                })
                            }, 
                        })
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
        var cont = $('.upload_box.first span').html();
        $('.upload_box.first span').html(cont)
    } else {
        layer.load(1);
        var formData = new FormData();
        formData.append('file',file1_name.files[0]);
        formData.append('picType','C');
        console.log(formData);
        $.ajax({
            //发送请求的地址
             url:'/jianfuzengxiao/api/common/uploadFile.html',
            //请求方式
            type:'POST',
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:formData,
            contentType: false,
            processData: false,
            success:function(res){
                console.log(res);
                if(parseInt(res.code) == 1){
                    layer.closeAll('loading');
                    var add = $('.upload_box.first').parents('.box-one').find('.images')
                    add.append('<div class="addimg"><div class="cloase"><img src="images/list/cloase.png" alt=""></div><img class="add_img" src="'+res.data.absolutePath+'" alt=""></div>')
                    layer.msg('上传成功');
                }else{
                    layer.msg(res.msg);
                }
            },
            error:function(jqXHR){
            }
        }); 
        $('.upload_box.first span').html("点击继续上传");
        $('.upload_box.first').addClass('active');
    }
})
$(".upload_box.second input[type=file]").change(function() {
    var file1_name1 = document.getElementById('file2')
    console.log(file1_name1.files[0])
    if (file1_name1.files[0] == undefined) {
        var cont = $('.upload_box.second span').html();
        $('.upload_box.second span').html(cont)
    } else {
        layer.load(1);
        var formData = new FormData();
        formData.append('file',file1_name1.files[0]);
        formData.append('picType','C');
        console.log(formData);
        $.ajax({
            //发送请求的地址
             url:'/jianfuzengxiao/api/common/uploadFile.html',
            //请求方式
            type:'POST',
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:formData,
            contentType: false,
            processData: false,
            success:function(res){
                console.log(res);
                if(parseInt(res.code) == 1){
                    layer.closeAll('loading');
                    var add = $('.upload_box.second').parents('.box-one').find('.images')
                    add.append('<div class="addimg"><div class="cloase"><img src="images/list/cloase.png" alt=""></div><img class="add_img" src="'+res.data.absolutePath+'" alt=""></div>')
                    layer.msg('上传成功');
                }else{
                    layer.msg(res.msg);
                }
            },
            error:function(jqXHR){
            }
        }); 
        $('.upload_box.second span').html("点击继续上传");
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