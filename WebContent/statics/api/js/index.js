$(function(){
	searchStartTime = new DateBox('#searchStartTime',DateBox.TypeDay)
	searchStartTime.setDateText('2018-03-01')
	$('#searchStartTime').css({'display':'inline-block','width':'170px'})
	searchEndTime = new DateBox('#searchEndTime',DateBox.TypeDay)
	searchEndTime.setDateText('2019-01-01')
	$('#searchEndTime').css({'display':'inline-block','width':'170px'})
	/* 推荐企业 */
	$.getJsonA("/jikuang/company/getCompanyInfoList.html",{'accountType': 'E','isRecommend': 'B'},function(data){
		if(data.success){
			var rows = data.data;
			/* 推荐企业 */ 
			$('#recommendedEnterprisesList').html('');
			var str = '';
			for(var i=0;i<rows.length;i++){
				if(i>2){
					break
				}
				str += '<li><img src="/jikuang/'+rows[i].companyThumb+'" alt=""><p class="companyName">'+rows[i].companyName+'</p>';
				str += '<div class="mask"> <a href="/jikuang/company/tomcd.html?id='+rows[i].companyId+'">查看详情</a> </div></li>';
			}
			$('#recommendedEnterprisesList').append(str);
			$('.mainContent ul li').mouseover(function(){
				$(this).find('.mask').show();
			})
			$('.mainContent ul li').mouseout(function(){
				$(this).find('.mask').hide();
			}) 
			
		}
	},true);
	
	/* 厂家信息 */ 
	$.getJsonA("/jikuang/company/getCompanyInfoList.html",{'accountType': 'E'},function(data){
		if(data.success){
			var rows = data.data;
			$('#companyInfoList tr').eq(0).siblings().remove();
			
			str = '';
			for(var i=0;i<rows.length;i++){
				if(i>4){
					break;
				}
				str += '<tr><td><div class="companyName" class="companyName" onclick="toCompany('+rows[i].companyId+')">'+rows[i].companyName+'</div></td>';
				str += '<td>'+rows[i].minesType+'</td>';
				str += '<td>'+rows[i].productionYear+'</td>';
				str += '<td>'+rows[i].reserves+'</td>';
				str += '<td>'+rows[i].areaName+'</td>';
				str += '<td>'+rows[i].contactName+'</td>';
				//str += '<td>'+rows[i].contactTel+'</td></tr>';
				str += '<td></td></tr>';
			}
			$('#companyInfoList').append(str);
		}
	},true);
	
	/* 推荐产品 */ 
	$.getJsonA("/jikuang/goods/getGoodsInfoList.html",{},function(data){
		if(data.success){
			var rows = data.data;
			if(rows.length > 10){
				/* 推荐产品第一行 */ 
				$('#productFirstList').html('');
				var str = '';
				for(var i=0;i<parseInt(rows.length/2);i++){
					str += '<div class="swiper-slide"><img src="/jikuang/'+rows[i].imgThumb+'">';
					str += '<p class="productName" onclick="toCompany('+rows[i].companyId+')">'+rows[i].companyName+'</p><div class="productPrice">';
					str += '<p>￥'+rows[i].price+'</p><p>'+rows[i].productName+'</p></div></div>';
				}
				$('#productFirstList').append(str);
				
				mySwiper1()
				
				/* 推荐产品第二行 */ 
				$('#productSecondList').html('');
				str = '';
				for(var i=parseInt(rows.length/2);i<rows.length;i++){
					str += '<div class="swiper-slide"><img src="/jikuang/'+rows[i].imgThumb+'">';
					str += '<p class="productName" onclick="toCompany('+rows[i].companyId+')">'+rows[i].companyName+'</p><div class="productPrice">';
					str += '<p>￥'+rows[i].price+'</p><p>'+rows[i].productName+'</p></div></div>';
				}
				$('#productSecondList').append(str);
				
				mySwiper2()
			}else{
				/* 推荐产品第一行 */ 
				$('#productFirstList').html('');
				var str = '';
				for(var i=0;i<rows.length;i++){
					str += '<div class="swiper-slide"><img src="/jikuang/'+rows[i].imgThumb+'">';
					str += '<p class="productName" onclick="toCompany('+rows[i].companyId+')">'+rows[i].companyName+'</p><div class="productPrice">';
					str += '<p>￥'+rows[i].price+'</p><p>'+rows[i].productName+'</p></div></div>';
				}
				$('#productFirstList').append(str);
				
				mySwiper1()
				$('#productSecond').hide()
			}
			
			/* 价格查询 */
			str = '';
			for(var i=0;i<rows.length;i++){
				str += '<tr><td>'+rows[i].productName+'</td>';
				str += '<td>'+rows[i].minesTypeName+'</td>';
				str += '<td><div class="companyName" onclick="toCompany('+rows[i].companyId+')">'+rows[i].companyName+'</div></td>';
				str += '<td>'+rows[i].price+'元/吨</td>';
				str += '<td>'+rows[i].areaName+'</td>';
				str += '<td>'+rows[i].createTime+'</td></tr>';
			}
			$('#priceCheckList').append(str);
		}
	},true);
		
	/* 矿业资讯 */ 
	$.getJsonA("/jikuang/news/getNewsInfoList.html",{'newsType': 'C'},function(data){
		if(data.success){
			var rows = data.data;
			$('#newsList').html('');
			var str = '';
			for(var i=0;i<4;i++){
				str += '<li><img src="/jikuang/statics/api/images/kuang'+(i+1)+'.jpg"> <span>';//rows[i].coverThumb
				str += '<div class="newsTitle"><a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=7" target="_blank">'+rows[i].title+'</a></div>';
				str += '<div class="newsContent">'+rows[i].introduction+'<a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=7" style="color:#fa6d35;margin-left:10px" target="_blank">查看更多</a></div></span></li>';
			}
			$('#newsList').append(str);
			$('#newsList img').each(function(){
				$(this).height($(this).width());
				$(this).next('span').height($(this).width());
			})
		}
	},true);
	
	/* 政策法规 */ 
	$.getJsonA("/jikuang/news/getNewsInfoList.html",{'newsType': 'A'},function(data){
		if(data.success){
			var rows = data.data
			$('#lawsList').html('');
			var str = '';
			for(var i=0;i<3;i++){
				str += '<li><a href="/jikuang/news/topld.html?newsId='+rows[i].newsId+'&page=5"><img src="/jikuang/statics/api/images/laws'+(i+1)+'.png" alt=""></a></li>';
			}
			$('#lawsList').append(str);
		}
	},true);
	
	mySwiper()

});
function menuTriangle(){
	$('#menuTitleNav ul li').eq(0).addClass('active');
}
function mySwiper(){
	var mySwiper = new Swiper('.menuSwiper',{
		autoplay:true,
		loop:true,
		speed:1000,
		pagination:{
			el: '.menuSwiper .swiper-pagination',
			clickable: true,
			clickableClass : 'my-pagination-clickable',
		},
	})
}
function mySwiper1(){
	var mySwiper1 = new Swiper('.product1',{
		slidesPerView : 5,
		spaceBetween : 20,
		slidesPerGroup: 5,
		navigation: {
			nextEl: '.productRight1',
			prevEl: '.productLeft1',
		}
	})
	var sliderImageHeight = $('.product1 img').width()/1.2;
	$('.product1 .swiper-slide img').css('height',sliderImageHeight +'px')
}
function mySwiper2(){
	var mySwiper2 = new Swiper('.product2',{
		slidesPerView : 5,
		spaceBetween : 20,
		slidesPerGroup: 5,
		navigation: {
			nextEl: '.productRight2',
			prevEl: '.productLeft2',
		}
	})
	var sliderImageHeight = $('.product2 img').width()/1.2;
	$('.product2 .swiper-slide img').css('height',sliderImageHeight +'px')
}
function toCompany(id){
	window.location.href="/jikuang/company/tomcd.html?id="+id;
}