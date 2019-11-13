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
<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/xadmin.css" media="all">
<style type="text/css">
	#page{
		position: absolute;
    	bottom: 0;
	}
</style>
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
		<!-- 		<div class="stat_cont scont">
					<div class="title">人员数</div>
					<div class="number">
						<span id="personNum" style="font-size: 36px"></span><span>个</span>
					</div>
				</div> -->
				<div class="stat_cont stat_conts">
					<div class="census_left">
						<div class="title">人员数</div>
						<div class="number">
							<span id="personNum" style="font-size: 36px">2831121</span><span>人</span>
						</div>
					</div>
					<div class="census_right">
						<div class="cright_type">
							<div>房主</div>
							<div id="fz">123123</div>
						</div>
						<div class="cright_type">
							<div>店主</div>
							<div id="dz">123123</div>
						</div>
						<div class="cright_type">
							<div>租户</div>
							<div id="zh">123123</div>
						</div>
						<div class="cright_type">
							<div>家属</div>
							<div id="js">123123</div>
						</div>
						<div class="cright_type">
							<div>员工</div>
							<div id="yg">123123</div>
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
							<input type="checkbox" value="已处理" id="up0"> <label
								for="up0">已处理</label>
						</div>
						<div class="check0">
							<input type="checkbox" value="待处理" id="up1"> <label
								for="up1">待处理</label>
						</div>
					</div>
				</div>
				<div id="todayReportInfo" class="infoCenter">
					<table class="layui-table">
						<thead>
							<tr>
								<th>姓名</th>
								<th>性别</th>
								<th>民族</th>
								<th>联系电话</th>
								<th>类型</th>
								<th>居住地址</th>
								<th>居住时间</th>
								<th>状态</th>
								<th>最新上报时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="x-img">
			
						</tbody>
					</table>
			
					<div id="page"></div>
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
							<p class="value" id="f1">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value" id="f2">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value" id="f3">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value" id="f4">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">店主认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value" id="d1">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value" id="d2">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value" id="d3">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value" id="d4">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">租户认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value" id="z1">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value" id="z2">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value" id="z3">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value" id="z4">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">家属认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value" id="j1">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value" id="j2">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value" id="j3">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value" id="j4">100%</p>
						</div>
					</div>

				</div>
				<div class="report_list">
					<p class="title">员工认证上报</p>
					<div class="block">
						<div class="item">
							<p class="ques">总量</p>
							<p class="value" id="y1">1231</p>
						</div>
						<div class="item">
							<p class="ques">待处理</p>
							<p class="value"id="y2">1231</p>
						</div>
						<div class="item">
							<p class="ques">已处理</p>
							<p class="value"id="y3">1231</p>
						</div>
						<div class="item">
							<p class="ques">处理率</p>
							<p class="value"id="y4">100%</p>
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
<script src="/jianfuzengxiao/statics/system/lib/layui/layui.js" charset="utf-8"></script>
<script src="/jianfuzengxiao/statics/system/js/xadmin.js" charset="utf-8"></script>
<script>
	var $, form, layer, laydate, lement, laypage;
	var status = '1,2,3';
	$(function() {
		layui.use([ 'laydate', 'form', 'element', 'laypage', 'layer' ], function() {
			//var total;
			$ = layui.jquery//jquery
			, form = layui.form
			, layer = layui.layer//弹出层
			, laydate = layui.laydate//日期插件
			, lement = layui.element//面包导航
			, laypage = layui.laypage;//分页
			
			page()
			
			$('#up0').change(function(){
				if($(this).prop('checked')){
					status = '2,3'
				}
				if($('#up1').prop('checked') == true){
					status = '1'
				}
				if($(this).prop('checked') == true && $('#up1').prop('checked') == true){
					status = '1,2,3'
				}
				if($(this).prop('checked') == false && $('#up1').prop('checked') == false){
					status = '1,2,3'
				}
				page()
			})
			$('#up1').change(function(){
				if($(this).prop('checked')){
					status = '1'
				}
				if($('#up0').prop('checked') == true){
					status = '2,3'
				}
				if($(this).prop('checked') == true && $('#up0').prop('checked') == true){
					status = '1,2,3'
				}
				if($(this).prop('checked') == false && $('#up0').prop('checked') == false){
					status = '1,2,3'
				}
				page()
			})
		})
		
		houseInfor()
		personInfor()
		kind()
		
		
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
	
	//上报信息详情
	function banner_details(obj, title, url, w, h) {
		var id = $(obj).parent('td').siblings('[row=ids]').text();
		x_admin_show(title, url + '?personnelId=' + id, w, h);
	}
	
	function page() {
		$.ajax({
			url : "/jianfuzengxiao/system/statistics/getTodayReportPage.html",
			type : 'post',
			dataType : "json",
			data: {'status': status},
			success : function(result) {
				laypage.render({
					elem : 'page',
					count : result.data.total,
					theme: '#1E9FFF',
					jump : function(obj) {
						todayReportInfo(obj.curr)
					}
				})
				if(result.data.total == 0){
					$('#page').hide()
				}else{
					$('#page').show()
				}
			}
		})
	}
	
	//今日上报信息
	function todayReportInfo(page){
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getTodayReportPage.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
            	'page': page,
            	'status': status
            },
            success:function(result){
            	//console.log(result)
            	$('#x-img').html('');
				var data = result.data.rows;
				for (var i = 0; i < data.length; i++) {
					var tr = $('#clone-tr').find('tr').clone();
					tr.find('[row=ids]').text(data[i].personnelId);
					tr.find('[row=username]').text(data[i].username);
					if(data[i].gender == 1){
						tr.find('[row=gender]').text('男');
					}else if(data[i].gender == 2) {
						tr.find('[row=gender]').text('女');
					}else{
						tr.find('[row=gender]').text('');
					}
					tr.find('[row=nationName]').text(data[i].nationName);
					tr.find('[row=telephone]').text(data[i].telephone);
					tr.find('[row=liveTypeName]').text(data[i].liveTypeName);
					//居住地址
					
					if(data[i].housesStatus == 1){
						tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+data[i].storiedBuildingNumber+'号楼'+data[i].unit+'单元'+data[i].houseNumber+'号');
					}else if(data[i].housesStatus == 2){
						if(data[i].storeLocation == 1){
							tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+'内铺'+data[i].houseNumber+'号');
						}else if(data[i].storeLocation == 2){
							tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+'外铺'+data[i].houseNumber+'号');
						}else{
							tr.find('[row=leaseAddress]').text(data[i].communityName+data[i].communityStreetName+data[i].houseNumber+'号');
						}
						
					}else{
						tr.find('[row=leaseAddress]').text('');
					}
					
					if(data[i].liveTypeId == 1 || data[i].liveTypeId == 2 || data[i].liveTypeId == 7){//长期
						tr.find('[row=leaseTime]').text('长期');
					}else{
						tr.find('[row=leaseTime]').text(data[i].leaseStartTime+' - '+data[i].leaseStopTime);
					}
					if(data[i].status == 1){
						tr.find('[row=status]').text('待审核');
					}else if(data[i].status == 2){
						tr.find('[row=status]').text('已通过审核');
					}else if(data[i].status == 3){
						tr.find('[row=status]').text('未通过审核');
					}
					//最新上报时间
					tr.find('[row=auditTime]').text(data[i].updateTime);
					$('#x-img').append(tr);
				}
            },
            error:function(jqXHR){}
        });
	}
	
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
            	if(data.data.housescount == 0){
					$('.totalNum').html(0)
	            	$('#szf').html(0)
	            	$('#zzf').html(0)
	            	$('#sp').html(0)
	            	$('#idle').html(0)
	            	$('#used').html(0)
            	}else{
            		$('.totalNum').html(data.data.housescount)
	            	$('#szf').html(data.data.szf)
	            	$('#zzf').html(data.data.zjf)
	            	$('#sp').html(data.data.sp)
	            	$('#idle').html(data.data.idle)
	            	$('#used').html(data.data.used)
            	}
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
            	// console.log(data)
            	if(data.data.percount == 0){
            		$('#personNum').html(0)
	            	$('#fz').html(0)
	            	$('#dz').html(0)
	            	$('#zh').html(0)
	            	$('#js').html(0)
	            	$('#yg').html(0)
            	}else{
					$('#personNum').html(data.data.percount)
	            	$('#fz').html(data.data.fangzhunum)
	            	$('#dz').html(data.data.dianzhunum)
	            	$('#zh').html(data.data.zuhunum)
	            	$('#js').html(data.data.jiashunum)
	            	$('#yg').html(data.data.yuangongnum)
            	}
            	
            },
            error:function(jqXHR){}
        });

	}
	function kind(){
		// 房主
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getTodayReportPer.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
               live_type_id:"1,3"
            },
            success:function(data){
            	console.log(data)
            	if(data.data.total == 0){
            		$('#f1').html(0)
	            	$('#f2').html(0)
	            	$('#f3').html(0)
	            	$('#f4').html(0+'%')
            	}else{
            		$('#f1').html(data.data.total)
	            	$('#f2').html(data.data.waitaudit)
	            	$('#f3').html(data.data.audit)
	            	$('#f4').html(data.data.auditratio+'%')
            	}
            	

            },
            error:function(jqXHR){}
        });

        // 店主
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getTodayReportPer.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
               live_type_id:"2,4"
            },
            success:function(data){
            	console.log(data)
            	if(data.data.total == 0){
            		$('#d1').html(0)
	            	$('#d2').html(0)
	            	$('#d3').html(0)
	            	$('#d4').html(0+'%')
            	}else{
            		$('#d1').html(data.data.total)
	            	$('#d2').html(data.data.waitaudit)
	            	$('#d3').html(data.data.audit)
	            	$('#d4').html(data.data.auditratio+'%')
            	}
            	

            },
            error:function(jqXHR){}
        });
         // 租户
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getTodayReportPer.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
               live_type_id:"5"
            },
            success:function(data){
            	console.log(data)
            	if(data.data.total == 0){
            		$('#z1').html(0)
	            	$('#z2').html(0)
	            	$('#z3').html(0)
	            	$('#z4').html(0+'%')
            	}else{
					$('#z1').html(data.data.total)
	            	$('#z2').html(data.data.waitaudit)
	            	$('#z3').html(data.data.audit)
	            	$('#z4').html(data.data.auditratio+'%')
            	}
            	

            },
            error:function(jqXHR){}
        });
         // 家属
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getTodayReportPer.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
               live_type_id:"7"
            },
            success:function(data){
            	console.log(data)
            	if(data.data.total == 0){
            		$('#j1').html(0)
	            	$('#j2').html(0)
	            	$('#j3').html(0)
	            	$('#j4').html(0+'%')
            	}else{
            		$('#j1').html(data.data.total)
	            	$('#j2').html(data.data.waitaudit)
	            	$('#j3').html(data.data.audit)
	            	$('#j4').html(data.data.auditratio+'%')
            	}
            	

            },
            error:function(jqXHR){}
        });
         // 员工
		$.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getTodayReportPer.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
               live_type_id:"6"
            },
            success:function(data){
            	console.log(data)
            	if(data.data.total == 0){
            		$('#y1').html(0)
	            	$('#y2').html(0)
	            	$('#y3').html(0)
	            	$('#y4').html(0+'%')
            	}else{
            		$('#y1').html(data.data.total)
	            	$('#y2').html(data.data.waitaudit)
	            	$('#y3').html(data.data.audit)
	            	$('#y4').html(data.data.auditratio+'%')
            	}
            	

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

<table id="clone-tr" style="display: none;">
	<tr>
		<!-- <td row="checkBoxId"><input type="checkbox" class="checkId"
			value="" name=""></td> -->
		<td row="ids" style="display: none;"></td>
		<td row="username"></td>
		<td row="gender">
			<!-- <div style="width:200px;height:22px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap"></div> -->
		</td>
		<td row="nationName"></td>
		<td row="telephone"></td>
		<td row="liveTypeName"></td>
		<td row="leaseAddress"></td>
		<td row="leaseTime"></td>
		<td row="status"></td>
		<td row="auditTime"></td>
		<td class="td-manage">
			<button class="layui-btn layui-btn layui-btn-xs layui-btn-normal"
				onclick="banner_details(this,'查看','/jianfuzengxiao/system/per/toAuditYezhuDetail.html', 1000, 620)">
				<i class="layui-icon">&#xe615;</i>查看
			</button>
			<!-- <button class="layui-btn layui-btn layui-btn-xs"
				onclick="banner_edit(this,'编辑','/jianfuzengxiao/system/houses/toUpdateHousesFw.html', 820)">
				<i class="layui-icon">&#xe642;</i>编辑
			</button> -->
			<!-- <button class="layui-btn-danger layui-btn layui-btn-xs"
				onclick="banner_del(this)" href="javascript:;">
				<i class="layui-icon">&#xe640;</i>删除
			</button> -->
		</td>
	</tr>
</table>
</html>