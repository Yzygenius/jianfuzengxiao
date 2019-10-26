$(function () {
    var swiper1 = new Swiper('.swiper1 .swiper-container', {
        slidesPerView: 1,
        spaceBetween: 0,//间隙
        loop: true,
        autoplay: {
            delay: 3000,
            disableOnInteraction: false,
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
            bulletActiveClass: 'addclass',
            bulletClass:'addclass0'
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
});


/* 推荐企业 */
$.ajax({
	url:"/jikuang/company/getCompanyInfoList.html",
	type:"post",
	dataType:"json",
	data:{'accountType': 'E','isRecommend': 'B'},
	success:function(data){
		var rows=data.data;
		var str="";
		$('#recommendedEnterprisesList').html('');
		for(var i=0;i<3;i++){	
			str += '<div class="swiper-slide swiper2_img">'+
			'<a href="/jikuang/wap/company_detail.html?id='+
			rows[i].companyId+'"> <img src="/jikuang/'+rows[i].companyThumb+'" alt=""></a>'+
			'<p class="p1">'+rows[i].companyName+'</p></div>';
		}			
		$('#recommendedEnterprisesList').append(str);
		swiper2()
	},
	error: function(data){console.log(data)}
});




$(function(){
	/* 推荐产品  */
	$.ajax({
		url : "/jikuang/goods/getGoodsInfoList.html",
		type:"post",
		dataType:"json",
		success: function(data){
			var rows = data.data
				// 推荐产品
				$('#productList .same_title').siblings().remove();
				var str = '';
				var size=6;
				var length=rows.length;
				if(length<6){
					size=length;
				}
				for(var i=0;i<size;i++){
					var companyName=rows[i].companyName;
					var companyNames=companyName.substring(0,9)+"...";
					str += '<div class="prod_con"><img src="/jikuang/statics/api/images/pro'+(i+1)+'.jpg">'+
							'<div class="detail"><a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'">'+
							'<p class="conpany_name">'+companyNames+'</p></a>'+
							'<p class="price">￥'+rows[i].price+'</p>'+
							'<span class="kind">'+rows[i].productName+'</span></div></div>';
				/*
					<img src="/jikuang/statics/wap/images/index/tu1.png" alt="">
	                <div class="detail">
	                    <p class="conpany_name">曲阳县佳瑞矿产品有限公司</p>
	                    <p class="price">￥<span>69.<span class="small">00</span></span></p>
	                    <span class="kind">建筑石料用灰岩</span>
	                </div>*/
				
				
				}
				$('#productList').append(str);
				
				/*mySwiper1()*/
				
				/* //推荐产品第二行  
				$('#productSecondList').html('');
				str = '';
				console.log(rows.length);
				for(var i=3;i<parseInt(rows.length);i++){
					console.log(rows[i].companyThumb);
					var companyName=rows[i].companyName;
					var companyNames=companyName.substring(0,9)+"...";
					str += '<div class="swiper-slide"><img src="/jikuang/statics/api/images/pro'+i+'.jpg">';//rows[i].imgThumb
					str += '<a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'"><p class="conpany_name">'+companyNames+'</p></a><div class="productPrice">';
					str += '<p class="price">￥'+rows[i].price+'</p><p class="kind">'+rows[i].productName+'</p></div></div>';
				}
				$('#productSecondList').append(str);
				*/
				/*mySwiper2()*/
				//产品交易
				str = '';
				for(var i=0;i<rows.length;i++){
					str += '<ul><li class=firsts>'+rows[i].productName+'</li>';
					str += '<li class=second><a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'">'+rows[i].companyName+'</a></li>';
					str += '<li class=third>'+rows[i].price+'元/吨</li>';
					str += '<li class=fourth>'+rows[i].areaName+'</li>';
					str += '<li class=fifth>'+rows[i].createTime+'</li></ul>';
				}
				$('#priceCheckList').append(str);		
		},
		error: function(data){console.log(data)}
	});
		
	
	
	// 厂家信息
	$.ajax({
		url:"/jikuang/company/getCompanyInfoList.html",
		type:"post",
		dataType:"json",
		data: {'accountType': 'E'},
		success : function(data) {
			var rows = data.data;
			$('#companyInfoList').html('');
			str = '';
			for (var i = 0; i < 5; i++) {
				str += '<ul><li class="first con_name"><a href="/jikuang/wap/company_detail.html?id='+rows[i].companyId+'">'+ rows[i].companyName + '</a></li>';
				str += '<li class="second">' + rows[i].minesType+ '</li>';
				str += '<li class="third">' + rows[i].productionYear+ '万吨</li>';
				str += '<li class="fourth">' + rows[i].areaName+'</li></ul>';
				/*str += '<li class="fourth">' + rows[i].contactName+ '</li>';
				str += '<li class="fifth">' + rows[i].contactTel+ '</li></ul>';*/
			}
			$('#companyInfoList').append(str);
		},
		error: function(data){console.log(data)}
	});
	
	//企业动态 
	$.ajax({
		url:"/jikuang/news/getNewsInfoList.html",
		type:"post",
		dataType:"json",
		data:{'newsType':'C'},
		success:function(data){
			var rows=data.data;
			//第一行
			$("#newsList_one").html('');
			var str='';
			
			for(var i=0;i<1;i++){
				var content = rows[i].introduction;
				var contents = content.substring(0,40)+'...';
				str += '<div class="newImg"><img src="/jikuang/statics/api/images/kuang'+(i+1)+'.jpg"alt=""></div>';//rows[i].coverThumb
				str += '<div class="newInfor"><a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'"><h5>'+rows[i].title+'</h5></a>';
				str += '<p><span>'+contents+'</span></p><div>';
			}
			$('#newsList_one').append(str);

			//第二行
			$("#newsList_two").html('');
			str = '';
			for(var i=1;i<2;i++){
				var content = rows[i].introduction;
				var contents = content.substring(0,40)+'...';
				str += '<div class="newImg"><img src="/jikuang/statics/api/images/kuang'+(i+1)+'.jpg"alt=""></div>';//rows[i].coverThumb
				str += '<div class="newInfor"><a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'"><h5>'+rows[i].title+'</h5></a>';
				str += '<p><span>'+contents+'</span></p><div>';
			}
			$('#newsList_two').append(str);
			
			//第三行
			$("#newsList_three").html('');
			str = '';
			for(var i=2;i<3;i++){
				var content = rows[i].introduction;
				var contents = content.substring(0,40)+'...';
				str += '<div class="newImg"><img src="/jikuang/statics/api/images/kuang'+(i+1)+'.jpg"alt=""></div>';//rows[i].coverThumb
				str += '<div class="newInfor"><a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'"><h5>'+rows[i].title+'</h5></a>';
				str += '<p><span>'+contents+'</span></p></div>';
			}
			$('#newsList_three').append(str);
			
			//第四行
			$("#newsList_four").html('');
			str = '';
			for(var i=3;i<4;i++){
				var content = rows[i].introduction;
				var contents = content.substring(0,40)+'...';
				str += '<div class="newImg"><img src="/jikuang/statics/api/images/kuang'+(i+1)+'.jpg"alt=""></div>';//rows[i].coverThumb
				str += '<div class="newInfor"><a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'"><h5>'+rows[i].title+'</h5></a>';
				str += '<p><span>'+contents+'</span></p></div>';
			}
			$('#newsList_four').append(str);
			
			$('#newImg').each(function(){
				$(this).height($(this).width());
				$(this).next('span').height($(this).width());
			})
		},
		error: function(data){console.log(data)}
	});
	
	/* 政策法规 */ 
	$.ajax({
		url:"/jikuang/news/getNewsInfoList.html",
		type:"post",
		dataType:"json",
		data:{'newsType':'A'},
		success:function(data){
			var rows=data.data;
			$('#lawsList').html('');
			var str = '';
			for(var i=0;i<3;i++){
				str += '<div class="swiper-slide foot_banner">'+
				'<a href="/jikuang/wap/dynamic_detail.html?newsId='+rows[i].newsId+'">'+
				'<img src="'+rows[i].coverThumb+'" alt=""></a></div>';
			}
			$('#lawsList').append(str)
			swiper3()
		},
		error: function(data){console.log(data)}
	});
});

function menuTriangle(){
	$('#menuTitleNav ul li').eq(0).addClass('active');
}
function swiper2(){
	var swiper2 = new Swiper('.swiper2 .swiper-container', {
        direction:'vertical',
        autoplay: {
            delay: 5000,
            disableOnInteraction: false,
        },
        loop:true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
            bulletActiveClass: 'addclass',
            bulletClass:'addclass0'
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
}
function swiper3(){
	var swiper3 = new Swiper('.swiper3 .swiper-container', {
        slidesPerView: 1,
        spaceBetween: 0,//间隙
        loop: true,
        autoplay: {
            delay: 3000,
            disableOnInteraction: false,
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
            bulletActiveClass: 'addclass',
            bulletClass:'addclass0'
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
}
