<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/index.css">
<link rel="stylesheet" type="text/css" href="/jianfuzengxiao/statics/system/css/iconfont.css">
<link href="/jianfuzengxiao/statics/system/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/jianfuzengxiao/statics/system/css/daterangepicker.css" />
<title>首页</title>
</head>
<body>
	<div class="content">
		<div class="Statistics">
			<div class="statinav">
				<div class="nav_img">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">上报信息统计
				</div>
				<div class="nav_btn">
					<div class="so_far active" data-id="0">上线至今</div>
					<div class="custom" id="daterange-btn" data-id="1">自定义</div>
				</div>
				<div class="nav_time" id="time0">
					<span class="start"></span> 至 <span class="end"></span>
				</div>
			</div>
			<div class="statist">
				<div class="stat_cont scont">
					<div class="title">场所</div>
					<div class="number">
						28321<span>个</span>
					</div>
				</div>
				<div class="stat_cont stat_conts colorBtn">
					<div class="census_left">
						<div class="title">户数</div>
						<div class="number">
							<span class="totalNum" style="font-size: 36px">2831121</span><span>户</span>
						</div>
					</div>
					<div class="census_right">
						<div class="cright_top">
							<div class="cright_type">
								<div>商住房</div>
								<div id="szf">123123</div>
							</div>
							<div class="cright_type">
								<div>自住房</div>
								<div id="zzf">123123</div>
							</div>
							<div class="cright_type">
								<div>商铺</div>
								<div id="sp">123123</div>
							</div>
						</div>
						<div class="cright_total">
							<div class="total">闲置：<span id="idle">1231231</span></div>
							<div class="total">已用：<span id="used">1231231</span></div>
						</div>
					</div>
				</div>
				<div class="stat_cont scont">
					<div class="title">人员数</div>
					<div class="number">
						28321<span>个</span>
					</div>
				</div>
				<div class="stat_cont stat_conts">
					<div class="census_left">
						<div class="title">户数</div>
						<div class="number">
							<span class="totalNum" style="font-size: 36px">2831121</span><span>户</span>
						</div>
					</div>
					<div class="census_right">
						<div class="cright_type">
							<div>房主</div>
							<div>123123</div>
						</div>
						<div class="cright_type">
							<div>店主</div>
							<div>123123</div>
						</div>
						<div class="cright_type">
							<div>租户</div>
							<div>123123</div>
						</div>
						<div class="cright_type">
							<div>家属</div>
							<div>123123</div>
						</div>
						<div class="cright_type">
							<div>员工</div>
							<div>123123</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="total_infor">
			<div class="infor_left">
				<div class="topHead">
					<div class="headItem1">
						<div class="newsInfo">
							<span>最新上报信息</span>
							<p class="line"></p>
						</div>
						<div class="date">2019-11-8</div>
						<div class="today">今天</div>
					</div>
					<div class="headItem2">
						<div class="check0">
							<input type="checkbox" checked value="已处理" id="up0"> <label
								for="up0">已处理</label>
						</div>
						<div class="check0">
							<input type="checkbox" checked value="待处理" id="up1"> <label
								for="up1">待处理</label>
						</div>
					</div>
				</div>
				<div class="infoCenter">
					<div class="itemList">
						<div class="check0">
							<input type="checkbox" id="check0"> <label for="check0"></label>
						</div>
						<div class="text first">Cotilla</div>
						<div class="text second">iMac 21”</div>
						<div class="text third">Abdullah Un Noman</div>
						<div class="text fourth">Mirpur 2, Dhaka</div>
						<div class="text fifth">2</div>
						<div class="status green">Complete</div>
						<div class="status orange" style="display: none;">On Hold</div>
						<div class="status zs" style="display: none;">Pending</div>
						<div class="status red" style="display: none;">Failed</div>
						<div class="text sixth">#123DFF</div>
					</div>
					<div class="itemList">
						<div class="check0">
							<input type="checkbox" id="check1"> <label for="check1"></label>
						</div>
						<div class="text first">Cotilla</div>
						<div class="text second">iMac 21”</div>
						<div class="text third">Abdullah Un Noman</div>
						<div class="text fourth">Mirpur 2, Dhaka</div>
						<div class="text fifth">2</div>
						<div class="status green" style="display: none;">Complete</div>
						<div class="status orange" style="display: none;">On Hold</div>
						<div class="status zs">Pending</div>
						<div class="status red" style="display: none;">Failed</div>
						<div class="text sixth">#123DFF</div>
					</div>
					<div class="itemList">
						<div class="check0">
							<input type="checkbox" id="check3"> <label for="check3"></label>
						</div>
						<div class="text first">Cotilla</div>
						<div class="text second">iMac 21”</div>
						<div class="text third">Abdullah Un Noman</div>
						<div class="text fourth">Mirpur 2, Dhaka</div>
						<div class="text fifth">2</div>
						<div class="status green" style="display: none;">Complete</div>
						<div class="status orange">On Hold</div>
						<div class="status zs" style="display: none;">Pending</div>
						<div class="status red" style="display: none;">Failed</div>
						<div class="text sixth">#123DFF</div>
					</div>
				</div>
			</div>
			<div class="infor_right">
				<div class="topHead">
					<div class="headItem1">
						<div class="newsInfo">
							<span>最新上报信息</span>
							<p class="line"></p>
						</div>
						<div class="date">2019-11-8</div>
						<div class="today">今天</div>
					</div>
				</div>
				<div class="report_list">
					<p class="title">房主认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">店主认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">租户认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">家属认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">员工认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value">100%</p>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
<script src="/jianfuzengxiao/statics/system/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/moment.js"></script>

<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/daterangepicker.js"></script>
<script>
	$(function() {
		houseInfor()
		personInfor()
		var itemList = ""
		for (var i = 0; i <= 10; i++) {
			itemList += '<div class="itemList">'
					+ '<div class="check0">'
					+ '<input type="checkbox" class="select" id="check'+i+'" >'
					+ '<label for="check'+i+'"></label>'
					+ '</div>'
					+ '<div class="text first">Cotilla</div>'
					+ '<div class="text second">iMac 21”</div>'
					+ '<div class="text third">Abdullah Un Noman</div>'
					+ '<div class="text fourth">Mirpur 2, Dhaka</div>'
					+ '<div class="text fifth"> 2 </div>'
					+ '<div class="status green">Complete</div>'
					+ '<div class="status orange" style="display: none;">On Hold</div>'
					+ '<div class="status zs" style="display: none;">Pending</div>'
					+ '<div class="status red" style="display: none;">Failed</div>'
					+ '<div class="text sixth">#123DFF</div>' + '</div>'
		}
		$('.infoCenter').html(itemList);
		$('.select').each(function() {
			$(this).click(function() {
				if ($(this).is(":checked")) {
					$(this).parents('.itemList').addClass('active');
				} else {
					$(this).parents('.itemList').removeClass('active');
				}
			})
		})
		$('.nav_btn div').click(function() {
			$(this).addClass('active').siblings().removeClass('active');
			if ($('.so_far').hasClass('active')) {
				$('.nav_time').fadeOut(0);
			} else {
				$('.nav_time').fadeIn(0);
			}
			if($(this).attr("data-id") == "0"){
				houseInfor()
				personInfor()
			}
		})
	})
	//首页房屋信息统计
	function houseInfor(start,end){
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getHousesCount.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
            	startTime:start,
            	stopTime:end
            },
            success:function(data){
            	$('.totalNum').html(data.data.housescount)
            	$('#szf').html(data.data.szf)
            	$('#zzf').html(data.data.zjf)
            	$('#sp').html(data.data.sp)
            	$('#idle').html(data.data.idle)
            	$('#used').html(data.data.used)
            },
            error:function(jqXHR){}
        });
	}
	//人员信息统计
	function personInfor(start,end){
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getPersonnelCount.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
            	startTime:start,
            	stopTime:end
            },
            success:function(data){
            	console.log(data)
            },
            error:function(jqXHR){}
        });

	}
	//时间
	$('#daterange-btn').daterangepicker(
			{
				ranges : {
					'自定义' : [ moment(), moment().subtract(-1, 'days') ],
					'本周' : [ moment(), moment() ],
					'上周' : [ moment().subtract(-1, 'days'),
							moment().subtract(-1, 'days') ],
					'本月' : [ moment(), moment().subtract(-6, 'days') ],
					'上月' : [ moment(), moment().subtract(-29, 'days') ],
					'今年' : [ moment(), moment().subtract(-59, 'days'), ]
				},
				startDate : moment(),
				endDate : moment()
			},
			function(start, end, label) {
				$('#time0').html(
						'<span>' + start.format('YYYY/MM/DD')
								+ '</span> 至 <span>' + end.format('YYYY/MM/DD')
								+ '</span>');
				houseInfor(start.format('YYYY/MM/DD'),end.format('YYYY/MM/DD'))
				personInfor(start.format('YYYY/MM/DD'),end.format('YYYY/MM/DD'))
				// $('#daterange-btn').addClass('active').siblings('.so_far').removeClass('active');
			});
</script>
</html>