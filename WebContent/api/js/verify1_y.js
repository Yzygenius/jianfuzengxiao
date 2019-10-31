//只有trigger 和 wheels 是必要参数  其他都是选填参数
var mobileSelect = new MobileSelect({
    trigger: '#add_btn',
    title: '请选择您的地址',
    wheels: [
        {data : UplinkData}
    ],
    transitionEnd:function(indexArr, data){
        console.log(data);
    },
    callback:function(indexArr, data){
        console.log(data);
    }
});
var mobileSelect1 = new MobileSelect({
    trigger: '#add_btn0',
    title: '请选择您的地址',
    wheels: [
        {data : UplinkData0}
    ],
    transitionEnd:function(indexArr, data){
        console.log(data);
    },
    callback:function(indexArr, data){
        console.log(data);
    }
});
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