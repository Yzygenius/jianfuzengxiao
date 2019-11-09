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
<title>房屋信息统计</title>
</head>
<body>
	<div class="content">
		<div class="nav">
			<div class="Community Community0">
				<div class="nav_title">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">社区
				</div>
				<ul class="nav_list nation" style="width: 90%">
					<li class="active">全部</li>
					<li>场所一</li>
					<li>场所二</li>
					<li>场所三</li>
					<li>场所四</li>
					<li>场所五</li>
					<li>场所一</li>
					<li>场所二</li>
					<li>场所三</li>
					<li>场所四</li>
					<li>场所五</li>
					<li>场所五</li>
					<li>场所一</li>
					<li>场所二</li>
					<li>场所三</li>
					<li>场所四</li>
					<li>场所五</li>
				</ul>
			</div>
			<div class="Community place">
				<div class="nav_title">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">场所
				</div>
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
				<div class="nav_num">(共计<span>10</span>户)</div>
			</div>
		</div>
		<div class="total">房屋总量：<span>23373</span>户</div>
		<div style="display: flex; flex-wrap: wrap; min-width: 1200px;">
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋分类情况
				</div>
				<div class="statime"></div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									自建房
								</div>
								<span id="num1">3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="percent1">50%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									商住房
								</div>
								<span id="num2">3432424</span> 户
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
							<div class="owner" style="width: 82px">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 211, 80);"></div>
									商铺
								</div>
								<span id="num3">3432424</span> 户
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
					</div>
					<div class="chart">
						<div id="house" style="height: 100%"></div>
					</div>
				</div>
			</div>
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋出租情况
				</div>
				<div class="statime">
					<div class="so_far active" data-housesTypeId = "" data-rent="rent">全部</div>
					<div class="so_far" data-housesTypeId = "1" data-rent="rent">自建房</div>
					<div class="so_far" data-housesTypeId = "2" data-rent="rent">商住房</div>
					<div class="so_far" data-housesTypeId = "3" data-rent="rent">商铺</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									<span>已出租</span>
								</div>
								<span id="leaseNum1">3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="leaseCent1">25%</span>
									</div>
								</div>
							</div>
						</div>
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle" style="background: rgb(255, 97, 96);"></div>
									<span>未出租</span>
								</div>
								<span id="leaseNum2">3432424</span> 户
							</div>
							<div class="rate">
								<div class="Proportion">
									<div>占比</div>
									<div>
										<span id="leaseCent2">25%</span>
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
			<div class="house" style="display: none">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋利用情况
				</div>
				<div class="statime">
					<div class="so_far active">全部</div>
					<div class="so_far">自建房</div>
					<div class="so_far">商住房</div>
					<div class="so_far">门店</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									闲置
								</div>
								<span>3432424</span> 户
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
									已用
								</div>
								<span>3432424</span> 户
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
						<div id="house0" style="height: 100%"></div>
					</div>
				</div>
			</div>
			<div class="house">
				<div class="statis">
					<img src="/jianfuzengxiao/statics/system/images/Path_2.png" alt="">房屋户型情况
				</div>
				<div class="statime">
					<div class="so_far active" data-housesTypeId = "" data-rent="apart">全部</div>
					<div class="so_far"data-housesTypeId = "1" data-rent="apart">自建房</div>
					<div class="so_far"data-housesTypeId = "2" data-rent="apart">商住房</div>
					<div class="so_far"data-housesTypeId = "3" data-rent="apart">商铺</div>
				</div>
				<div class="clear"></div>
				<div style="display: flex; align-items: center;">
					<div class="house_detail houseKind">
						<div class="house_infor">
							<div class="owner">
								<div class="owner_title">
									<div class="circle"></div>
									户型名称1
								</div>
								<span>3432424</span> 户
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
									户型名称1
								</div>
								<span>3432424</span> 户
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
	        window.sessionStorage.clear();   //清除缓存
	        call();  //调用房屋分类
	        rent();  //调用出租信息
	        apartment();
            $('.statime .so_far').click(function () {
                $(this).addClass('active').siblings('.so_far').removeClass('active')
                sessionStorage.housesTypeId = $(this).attr("data-housesTypeId")
                if($(this).attr('data-rent') == 'rent'){
                	rent();   //点击房屋类型调用出租信息
            	}else if($(this).attr('data-rent') == 'apart'){
 					apartment();
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
	            	$('.nation').html(list1)
	            	$('.nation').prepend('<li data-communityId ="" class="active">全部</li>')
			        $('.nation li').click(function(){
			    		$(this).addClass('active').siblings('li').removeClass('active');
			    		 sessionStorage.communityId = $(this).attr("data-communityId")
		 	         	 call()  //调用房屋分类
		 	         	 rent()  //调用出租信息
		 	         	 apartment();   //户型
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
		 	         	call()  //调用房屋分类
		 	         	rent()  //调用出租信息
		 	         	apartment(); //户型
				    })
			     
	            },
	            error:function(jqXHR){}
	        });
        })
        // 房屋分类情况
        function call(){
            $.ajax({
	            //请求方式
	            type:'POST',
	            //发送请求的地址
	            url:'/jianfuzengxiao/system/statistics/getHousesType.html',
	            //服务器返回的数据类型
	            dataType:'json',
	            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
	            data:{
	            	communityId:sessionStorage.communityId,
	            	communityStreetId:sessionStorage.communityStreetId
	            },
	            success:function(data){
	                var array=[]
	            	if(data.data.total == 0){
		            	$('#num1').html(0)
	                    $('#percent1').html(0+'%')
	                    $('#num2').html(0)
	                    $('#percent2').html(0+'%')
	                    $('#num3').html(0)
	                    $('#percent3').html(0+'%')
                        array.push({'value':100,'name':'无'})

	            	}else{
	            		$('#num1').html(data.data.zjf)
	                    $('#percent1').html(data.data.zjfratio+'%')
	                    $('#num2').html(data.data.szf)
	                    $('#percent2').html(data.data.szfratio+'%')
	                    $('#num3').html(data.data.sp)
	                    $('#percent3').html(data.data.spratio+'%')
	                    array.push({value:(data.data.zjfratio)*10, name:'自建房'},{value:(data.data.szfratio)*10, name:'商住房'},{value:(data.data.spratio)*10, name:'门店'})
	            	}
                    
	            	// console.log(data.data)
                    $('.total span').html(data.data.total)
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
					            data:array
					            // data:[
					            //     // {value:250, name:'自建房'},
					            //     // {value:375, name:'商住房'},
					            //     // {value:375, name:'门店'},
					            //     // {value:(data.data.zjfratio)*10, name:'自建房'},
					            //     // {value:(data.data.szfratio)*10, name:'商住房'},
					            //     // {value:(data.data.spratio)*10, name:'门店'},
					            // ]
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
        // 房屋出租情况
        function rent(){
         $.ajax({
            //请求方式
            type:'POST',
            //发送请求的地址
            url:'/jianfuzengxiao/system/statistics/getHousesRent.html',
            //服务器返回的数据类型
            dataType:'json',
            //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
            data:{
            	communityId:sessionStorage.communityId,
            	communityStreetId:sessionStorage.communityStreetId,
            	housesTypeId:sessionStorage.housesTypeId
            },
            success:function(data){
            	// console.log(data.data)
            	$('#leaseNum1').html(data.data.rent)
            	$('#leaseCent1').html((data.data.rentratio)*100+'%')
            	$('#leaseNum2').html(data.data.waitrent)
            	$('#leaseCent2').html((data.data.waitrentratio)*100+'%')
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
				                {value:(data.data.rentratio)*1000, name:'已出租'},
				                {value:(data.data.waitrentratio)*1000, name:'未出租'}
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
     //房屋户型情况
    function apartment(){
      $.ajax({
        //请求方式
        type:'POST',
        //发送请求的地址
        url:'/jianfuzengxiao/system/statistics/getHouseType.html',
        //服务器返回的数据类型
        dataType:'json',
        //发送到服务器的数据，对象必须为key/value的格式，jquery会自动转换为字符串格式
        data:{
        	communityId:sessionStorage.communityId,
        	communityStreetId:sessionStorage.communityStreetId,
        	housesTypeId:sessionStorage.housesTypeId
        },
        success:function(data){
        	console.log(data)
        	var html=""
        	var color=[]
        	var array=[]
        	for(var i = 0;i<data.data.length;i++){
               color.push('#0091FF');
			   array.push({'value':(data.data[i].ratio)*1000,'name':data.data[i].houseType})
			   if(data.data[i].count == 0){
			   	var  houseName = '无'
			   }else{
			   	var houseName = data.data[i].houseType
			   }
               html += 	'<div class="house_infor">'+
							'<div class="owner">'+
								'<div class="owner_title">'+
									'<div class="circle"></div>'+
									houseName+
								'</div>'+
								'<span>'+data.data[i].count+'</span> 户'+
							'</div>'+
							'<div class="rate">'+
								'<div class="Proportion">'+
									'<div>占比</div>'+
									'<div>'+
										'<span>'+(data.data[i].ratio)*100+'%</span>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'
        	}
        	$('.house_detail.houseKind').html(html)
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

    </script>
</body>
</html>