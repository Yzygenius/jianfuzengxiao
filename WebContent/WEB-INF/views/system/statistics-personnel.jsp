<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="/jianfuzengxiao/statics/system/css/house.css">
<title>人员信息统计</title>
</head>
<body>
	<div class="content" style="overflow-x: scroll;">
		<div class="nav">
			<div class="Community Community0">
				<div class="nav_title">社区</div>
				<ul class="nav_list nation" style="width: 90%">
					<li class="active">全部</li>
					<li>场所一</li>
					<li>场所二</li>
					<li>场所三</li>
					<li>场所四</li>
					<li>场所五</li>
				</ul>
			</div>
			<div class="Community place">
				<div class="nav_title">场所</div>
				<ul class="nav_list quarters">
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
		<div class="total" id="total">人员总量：</div>
		<div style="display: flex; flex-wrap: wrap; min-width: 1200px;">
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">人员分类情况
				</div>
				<div class="statime"></div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									房主
								</div>
								<span id="num1">3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="percent1">25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									店主
								</div>
								<span id="num2">3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="percent2">25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 211, 80);"></div>
									租户
								</div>
								<span id="num3">3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="percent3">25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: #cea5e8;"></div>
									员工
								</div>
								<span id="num4">3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="percent4">25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background:#de9f83;"></div>
									家属
								</div>
								<span id="num5">3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="percent5">25%</span>
									</div>
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
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">人员性别分布
				</div>
				<div class="statime">
					<div class="so_far active" data-liveTypeId ="" data-type ="person">全部</div>
					<div class="so_far" data-liveTypeId ="1,3" data-type ="person">房主</div>
					<div class="so_far" data-liveTypeId ="2,4" data-type ="person">店主</div>
					<div class="so_far" data-liveTypeId ="5" data-type ="person">租户</div>
					<div class="so_far" data-liveTypeId ="7" data-type ="person">家属</div>
					<div class="so_far" data-liveTypeId ="6" data-type ="person">员工</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									男性
								</div>
								<span id="boyNum">3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="boyPer">25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									女性
								</div>
								<span id="girlNum">3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="girlPer">25%</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="chart">
						<div id="container" style="height: 100%"></div>
					</div>
				</div>
			</div>
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">人员年龄段分布
				</div>
				<div class="statime">
					<div class="so_far active" data-liveTypeId ="" data-type="age">全部</div>
					<div class="so_far" data-liveTypeId ="1,3" data-type="age">房主</div>
					<div class="so_far" data-liveTypeId ="2,4" data-type="age">店主</div>
					<div class="so_far" data-liveTypeId ="5" data-type="age">租户</div>
					<div class="so_far" data-liveTypeId ="7" data-type="age">家属</div>
					<div class="so_far" data-liveTypeId ="6" data-type="age">员工</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail ageList"
						style="display: flex; flex-wrap: wrap; max-width: 460px;">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									0-6岁
								</div>
								<span>3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									7-17岁
								</div>
								<span>3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									8-40岁
								</div>
								<span>3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									41-48岁
								</div>
								<span>3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									48-65岁
								</div>
								<span>3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									66岁以上
								</div>
								<span>3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="chart">
						<div id="house1" style="height: 100%"></div>
					</div>
				</div>
			</div>
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">人员民族分布
				</div>
				<div class="statime">
					<div class="so_far active" data-liveTypeId ="" data-type ="nation">全部</div>
					<div class="so_far" data-liveTypeId ="1,3" data-type ="nation">房主</div>
					<div class="so_far" data-liveTypeId ="2,4" data-type ="nation">店主</div>
					<div class="so_far" data-liveTypeId ="5" data-type ="nation">租户</div>
					<div class="so_far" data-liveTypeId ="7" data-type ="nation">家属</div>
					<div class="so_far" data-liveTypeId ="6" data-type ="nation">员工</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;margin-top: 20px;">
					<div class="house_detail nationM"
						style="display: flex; flex-wrap: wrap; max-width: 400px;">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									0-6岁
								</div>
								<span>3432424</span> 人
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span>25%</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="chart shape">
						<div id="houseN" style="height: 100%"></div>
				    </div>
				</div>
				
			</div>
			</div>
		</div>
	</div>
	<script src="/jianfuzengxiao/statics/system/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/echarts.min.js"></script>
	<script type="text/javascript" src="/jianfuzengxiao/statics/system/js/chart.js"></script>
	<script>
        $(function () {
        	var communityStreetId=""  //小区id
	        var communityId=""        //社区id
	        var housesTypeId=""       //房屋分类id
	        var liveTypeId =""        //人员类型是房主之类的
	        window.sessionStorage.clear();   //清除缓存
	        //性别
            $('.statime .so_far').click(function () {
                $(this).addClass('active').siblings('.so_far').removeClass('active')
        	 	sessionStorage.liveTypeId = $(this).attr('data-liveTypeId')
                if($(this).attr('data-type') == "person"){
                	 gender();
                }else if($(this).attr("data-type") == "age"){
                	age();
                }else if($(this).attr("data-type") == "nation"){
                	Nation();
                }
               
            })
            call()     //调用房屋分类
            gender()   //调用性别
            age()      //调用年龄
            Nation()   //调用民族
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
	            	$('.nation').html(list1)
	            	$('.nation').prepend('<li data-communityId ="" class="active">全部</li>')
			        $('.nation li').click(function(){
			    		$(this).addClass('active').siblings('li').removeClass('active');
			    		 sessionStorage.communityId = $(this).attr("data-communityId")
		 	         	 call()     //调用房屋分类
		 	         	 gender()   //调用性别
		 	         	 age()      //年龄
		 	         	 Nation()   //民族
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
	            	$('.quarters').html(list2)
	            	$('.quarters').prepend('<li data-communityStreetId="" class="active">全部</li>')
	            	$('.nav_num span').html(data.data.length)
		            $('.quarters li').click(function(){
				    	$(this).addClass('active').siblings('li').removeClass('active')
				        sessionStorage.communityStreetId = $(this).attr("data-communityStreetId")
		 	         	call()    //调用房屋分类
		 	         	gender()  //调用性别
		 	         	age()     //年龄
		 	         	Nation()  //民族
				    })
			     
	            },
	            error:function(jqXHR){}
	        });
            var num = $('.house').length;
            for(var i=0;i<num;i++){
                if($('.house').eq(i).find('.house_infor').length > 3){
                    $('.house').eq(i).find('.house_detail').addClass('house_many');
                    $('.house').eq(i).find('.chart').addClass('active');
                }else{
                    $('.house').eq(i).find('.house_detail').addClass('house_many0');
                }
            }
        })
        // 人员分类情况
        function call(){
            $.ajax({
	            //请求方式
	            type:'POST',
	            //发送请求的地址
	            url:'/jianfuzengxiao/system/statistics/getPersonnelType.html',
	            //服务器返回的数据类型
	            dataType:'json',
	            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
	            data:{
	            	communityId:sessionStorage.communityId,
	            	communityStreetId:sessionStorage.communityStreetId
	            },
	            success:function(data){
	            	// console.log(data.data)
	            	$('#total').html('人员总量:'+data.data.total+'人')
	            	$('#num1').html(data.data.fangzhunum)
	            	$('#percent1').html(parseInt(data.data.fangzhuratio)+'%')
	            	$('#num2').html(data.data.dianzhunum)
	            	$('#percent2').html(parseInt(data.data.dianzhuratio)+'%')
	            	$('#num3').html(data.data.zuhunum)
	            	$('#percent3').html(parseInt(data.data.zuhuratio)+'%')
	            	$('#num4').html(data.data.yuangongnum)
	            	$('#percent4').html(parseInt(data.data.yuangongratio)+'%')
	            	$('#num5').html(data.data.jiashunum)
	            	$('#percent5').html(parseInt(data.data.jiashuratio)+'%')
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
					            color:['#14e8ec','#ff6160','#ffd350','#cea5e8','#de9f83'],
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
					                {value:(data.data.fangzhuratio)*10, name:'房主'},
					                {value:(data.data.dianzhuratio)*10, name:'店主'},
					                {value:(data.data.zuhuratio)*10, name:'租户'},
					                {value:(data.data.yuangongratio)*10, name:'员工'},
					                {value:(data.data.jiashuratio)*10, name:'家属'},
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
        //人员性别
        function gender(){
        	  $.ajax({
	            //请求方式
	            type:'POST',
	            //发送请求的地址
	            url:'/jianfuzengxiao/system/statistics/getPersonnelGender.html',
	            //服务器返回的数据类型
	            dataType:'json',
	            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
	            data:{
	            	communityId:sessionStorage.communityId,
	            	communityStreetId:sessionStorage.communityStreetId,
	            	liveTypeId:sessionStorage.liveTypeId
	            },
	            success:function(data){
	            	// console.log(data)
	            	$('#boyNum').html(data.data.nannum)
	            	$('#boyPer').html(parseInt(data.data.nanratio)+'%')
	            	$('#girlNum').html(data.data.nvnum)
	            	$('#girlPer').html(parseInt(data.data.nvratio)+'%')
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
					            color:['#ff6160','#14e8ec'],
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
					                {value:(data.data.nanratio)*10, name:'女生'},
					                {value:(data.data.nvratio)*10, name:'男生'}
					            ]
					        }
					    ]
					};
					if (option0 && typeof option0 === "object") {
					    myChart0.setOption(option0, true);
					}
	            },
	            error:function(jqXHR){}
	        });
        }
        //人员年龄
        function age(){
        	 $.ajax({
	            //请求方式
	            type:'POST',
	            //发送请求的地址
	            url:'/jianfuzengxiao/system/statistics/getPersonnelAge.html',
	            //服务器返回的数据类型
	            dataType:'json',
	            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
	            data:{
	            	communityId:sessionStorage.communityId,
	            	communityStreetId:sessionStorage.communityStreetId,
	            	liveTypeId:sessionStorage.liveTypeId
	            },
	            success:function(data){
	            	console.log(data.data.length)
	            	var html = ""
	            	var countTotal=""
	            	var array=[]
	            	var color=[]
	            	if(data.data.length == 0){
	            		var ageItem = '暂时没有'
            			array.push({'value':100,'name':'无'})
            			color.push('#e977ac')
            			html+='<div class="house_infor">'+
									'<div class="owner">'+
										'<div class="owner_title">'+
											'<div class="circle style="background:#e977ac"></div>'+
											ageItem+
										'</div>'+
										'<span>0</span> 人'+
									'</div>'+
									'<div class="rate">'+
										'<div class="Proportion">'+
											'<div>占比</div>'+
											'<div>'+
												'<span>0%</span>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</div>'
	            	}else{

				        for(i=0;i<data.data.length;i++){
				        	if(data.data[i].agerange == 1){
		            			var ageItem = '0-6岁'
		            			array.push({'value':(data.data[i].ratio)*1000,'name':'0-6岁'})
		            			color.push('#e977ac')
		            			var circle = '<div class="circle" style="background:#e977ac"></div>'
			            	}else if(data.data[i].agerange == 2){
			            		var ageItem = '7-17岁'
		            			array.push({'value':(data.data[i].ratio)*1000,'name':'7-17岁'})
		            			color.push('#e45dcf')
		            			var circle = '<div class="circle" style="background:#e45dcf"></div>'
			            	}else if(data.data[i].agerange == 3){
			            		var ageItem = '18-40岁'
		            			array.push({'value':(data.data[i].ratio)*1000,'name':'18-40岁'})
		            			color.push('#7044c8')	
		            			var circle = '<div class="circle" style="background:#7044c8"></div>'
			            	}else if(data.data[i].agerange == 4){
			            		var ageItem = '41-47岁'
		            			array.push({'value':(data.data[i].ratio)*1000,'name':'41-47岁'})
		            			color.push('#3ab6c1')	
		            			var circle = '<div class="circle" style="background:#3ab6c1"></div>'
			            	}else if(data.data[i].agerange == 5){
			            		var ageItem = '48-65岁'
		            			array.push({'value':(data.data[i].ratio)*1000,'name':'48-65岁'})
		            			color.push('#97b449')	
		            			var circle = '<div class="circle" style="background:#97b449"></div>'
			            	}else if(data.data[i].agerange == 6){
			            		var ageItem = '66岁以上'
		            			array.push({'value':(data.data[i].ratio)*1000,'name':'65岁以上'})
		            			color.push('#ca9a5d')	
		            			var circle = '<div class="circle" style="background:#ca9a5d"></div>'
			            	}
				        	html+='<div class="house_infor">'+
									'<div class="owner">'+
										'<div class="owner_title">'+
											circle+
											ageItem+
										'</div>'+
										'<span>'+data.data[i].count+'</span> 人'+
									'</div>'+
									'<div class="rate">'+
										'<div class="Proportion">'+
											'<div>占比</div>'+
											'<div>'+
												'<span>'+parseInt((data.data[i].ratio)*100)+'%</span>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</div>'
				        }
			        }
			        $('.ageList').html(html)
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
					            color:color,
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
					            data:array
					        }
					    ]
					};
					;
					if (option2 && typeof option2 === "object") {
					    myChart2.setOption(option2, true);
					}

	            },
	            error:function(jqXHR){}
	        });
        }
        // 民族
       function Nation(){
			$.ajax({
	        //请求方式
	        type:'POST',
	        //发送请求的地址
	        url:'/jianfuzengxiao/system/statistics/getPersonnelNation.html',
	        //服务器返回的数据类型
	        dataType:'json',
	        //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
	        data:{
	        	communityId:sessionStorage.communityId,
	        	communityStreetId:sessionStorage.communityStreetId,
	        	liveTypeId:sessionStorage.liveTypeId
	        },
	        success:function(data){
	        	// console.log(data.data)
	        	var res = data.data;
	        	var html=""
	        	var array=[]
	            var color=['#14e8ec','#ff6160','#ffd350','#e977ac','#8ae977','#dd84ea','#75aadb','#5bd5b1','#eb9f67','#eb6780']
	            // res.push(color)
	        	// console.log(res)
	        	for(var i=0;i<res.length;i++){
	        		array.push({'value':(res[i].ratio)*1000,'name':res[i].nationName})

	        		html+='<div class="house_infor">'+
									'<div class="owner">'+
										'<div class="owner_title">'+
											'<div class="circle" style="background:'+color[i]+'"></div>'+
											res[i].nationName+
										'</div>'+
										'<span>'+res[i].count+'</span> 人'+
									'</div>'+
									'<div class="rate">'+
										'<div class="Proportion">'+
											'<div>占比</div>'+
											'<div>'+
												'<span>'+parseInt((res[i].ratio)*100)+'%</span>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</div>'
	        	}
	        	$('.nationM').html(html)
	        	var dom = document.getElementById("houseN");
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
				            color:color,
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
				            data:array
				            // [
				            //     {value:250, name:'房主通过'},
				            //     {value:375, name:'家属通过'},
				            //     {value:375, name:'租户通过'},
				            // ]
				        }
				    ]
				};
				if (option && typeof option === "object") {
				    myChart.setOption(option, true);
				}
	        },
	        error:function(jqXHR){}
	    })
	}
    //     function Nation(){
				// $.ajax({
	   //          //请求方式
	   //          type:'POST',
	   //          //发送请求的地址
	   //          url:'/jianfuzengxiao/system/statistics/getPersonnelNation.html',
	   //          //服务器返回的数据类型
	   //          dataType:'json',
	   //          //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
	   //          data:{
	   //          	communityId:sessionStorage.communityId,
	   //          	communityStreetId:sessionStorage.communityStreetId,
	   //          	liveTypeId:sessionStorage.liveTypeId
	   //          },
	   //          success:function(data){
	   //          	// console.log(data.data)
	   //          	var res = data.data;
	   //          	var dataAxis = [];
	   //          	// var countTotal=""
	   //          	var data=[]
	   //          	// var color=[]
	   //          	if(res == undefined){
	   //          		dataAxis.push('无');
	   //          	}else{
	   //          		for(var i in res){
			 //     			var ratio = parseInt(res[i].ratio*100);
				//      		dataAxis.push(res[i].nationName);
				//      		data.push(ratio)
			 //     	    }
	   //          	}
			     	
			 //        var dom = document.getElementById("shape");
				//     var myChart = echarts.init(dom);
				//     var app = {};
				//     option = null;
				//     // var dataAxis = dataAxis;
				//     // var data = data;
				//     var yMax = 100;
				//     var dataShadow = [];

				//     for (var i = 0; i < data.length; i++) {
				//         dataShadow.push(yMax);
				//     }

				//     option = {
				//     	tooltip : {
				//             trigger: 'item',
				//             transitionDuration : 0.4,  // 动画变换时间，单位s
				//             backgroundColor: 'rgba(0,0,0,0.7)',     // 提示背景颜色，默认为透明度为0.7的黑色
				//             borderColor: '#333',       // 提示边框颜色
				//             borderRadius: 4,           // 提示边框圆角，单位px，默认为4
				//             borderWidth: 0,            // 提示边框线宽，单位px，默认为0（无边框）
				//             padding: 5,                // 提示内边距，单位px，默认各方向内边距为5，
				//             // 接受数组分别设定上右下左边距，同css
				//             axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				//                 type : 'line',         // 默认为直线，可选为：'line' | 'shadow'
				//                 lineStyle : {          // 直线指示器样式设置
				//                     color: '#48b',
				//                     width: 2,
				//                     type: 'solid'
				//                 },
				//                 shadowStyle : {                       // 阴影指示器样式设置
				//                     width: 'auto',                   // 阴影大小
				//                     color: 'rgba(150,150,150,0.3)'  // 阴影颜色
				//                 }
				//             },
				//             formatter: function (params) {
				// 	            var htmlStr = '比例：'+params.value + '%';
				// 	            return htmlStr; 
				// 	        }
				//         },
				//         grid: {
				//             left: '3%',
				//             right: '4%',
				//             bottom: '3%',
				//             top:20,
				//             containLabel: true
				//         },
				//         xAxis :{
				//             type : 'category',
				//             // boundaryGap : false,
				//             data : dataAxis,

				//         },
				//         yAxis: {
				//             axisLine: {
				//                 show: false
				//             },
				//             axisTick: {
				//                 show: false
				//             },
				//             axisLabel: {
				//                 textStyle: {
				//                     color: '#333'
				//                 }
				//             }
				//         },
				//         series: [
				//             { // For shadow
				//                 type: 'bar',
				//                 itemStyle: {
				//                     normal: {color: 'rgba(0,0,0,0)'}
				//                 },
				//                 barGap:'-100%',
				//                 barCategoryGap:'50%',
				//                 data: dataShadow,
				//                 // animation: false
				//             },
				//             {
				//                 type: 'bar',
				//                 itemStyle: {
				//                     normal: {
				//                         color: new echarts.graphic.LinearGradient(
				//                             0, 0, 0, 1,
				//                             [
				//                                 {offset: 0, color: '#73F3AE'},
				//                                 {offset: 0.5, color: '#64E1CC'},
				//                                 {offset: 1, color: '#4BC2FE'}
				//                             ]
				//                         )
				//                     },
				//                     emphasis: {
				//                         color: new echarts.graphic.LinearGradient(
				//                             0, 0, 0, 1,
				//                             [
				//                                 {offset: 0, color: '#4BC2FE'},
				//                                 {offset: 0.7, color: '#64E1CC'},
				//                                 {offset: 1, color: '#73F3AE'}
				//                             ]
				//                         )
				//                     }
				//                 },
				//                 data: data
				//             }
				//         ]
				//     };

				//     if (option && typeof option === "object") {
				//         myChart.setOption(option, true);
				//     }

	   //          },
	   //          error:function(jqXHR){}
	   //      });
    //     }
   </script>
</body>
</html>