var id=GetQueryString('id');
var mapPosition=[];
$.ajax({
	url: '/jikuang/goods/getGoodsInfoList.html',
	type: 'POST',
	dataType: 'json',
	data: {'goodsId':id},
	success: function(data){
		var rows = data.data[0];
		//公司简介
		$('.banner').html('<img src="/jikuang/'+rows.companyThumb+'" alt="">')
		$('.inforText').html('<p>'+rows.companySynopsis+'</p>')
		//企业信息
		//accountType(企业E,政府市级别 C, 政府县级别 D,普通用户G)
		if(rows.accountType!=""){
			if(rows.accountType=="E"){
				rows.accountType="企业";
			}else if(rows.accountType=="C"){
				rows.accountType="政府市级别";
			}else if(rows.accountType=="G"){
				rows.accountType="普通用户";
			}
		}
	
		$('.introduce').html('<p class="comName">'+rows.companyName+'</p>'+
				'<p class="compete"><span>竞争力</span><img src="/jikuang/statics/wap/images/company/start.png" alt=""><img src="/jikuang/statics/wap/images/company/start.png" alt=""><img src="/jikuang/statics/wap/images/company/start.png" alt=""><img src="/jikuang/statics/wap/images/company/start.png" alt=""><img src="/jikuang/statics/wap/images/company/start.png" alt=""></p>'+
				'<p class="peoName"><img src="/jikuang/statics/wap/images/company/people.png" alt=""><span>'+rows.contactName+'</span></p>'+ 
                '<div class="careful">'+
                    '<p>注册资本: <span>'+rows.regCapital+'万人民币</span></p>'+
                    '<p>企业类型: <span>'+rows.accountType+'</span></p>'+
                    '<p>主要经营: <span class="style">'+rows.minesTypeName+'</span></p>'+
                '</div>')
        //地理位置
        $('.img').html(mapPosition = [rows.longitude,rows.latitude]);
        $('#location').html(rows.provName + rows.cityName + rows.areaName)
        $('.swiper-wrapper').html('<div class="swiper-slide botImg"><img src="/jikuang/'+rows.imgThumb+'" alt=""></div>'+
        		'<div class="swiper-slide botImg"><img src="/jikuang/'+rows.imgThumb2+'" alt=""></div>'+
        		'<div class="swiper-slide botImg"><img src="/jikuang/'+rows.imgThumb3+'" alt=""></div>'+
        		'<div class="swiper-slide botImg"><img src="/jikuang/'+rows.imgThumb4+'" alt=""></div>')
         companyMap()
        $('.mater').html('<p class="materTit">'+rows.productName+'</p>'+
            '<div class="materP"><span style="10px;">价格</span><p class="prices"><span>￥'+rows.price+'/吨</span></p></div>'+
            '<div class="materP"><span>所在地</span><p>'+rows.provName+rows.cityName+'</p></div>'+
            '<div class="materP"><span>储量 (万吨)</span><p>'+rows.reserves+'</p></div>'+
            '<div class="materP"><span>年产量(万吨)</span><p>'+rows.productionYear+'</p></div>')
	} /*rows.areaName县级*/
})


function menuTriangle(){
	$('#menuTitleNav ul li').eq(1).addClass('active');
}
function companyMap(){
	var map = new AMap.Map('companyLocationMap', {
		zoom:11,//级别
		center: mapPosition,//中心点坐标
		viewMode:'3D'//使用3D视图
	}); 
	var marker = new AMap.Marker({
		 position: mapPosition
	})
	map.add(marker);
}

/*
var mySwiper = new Swiper('.swiper-container',{
	navigation: {
      nextEl: '.productRight',
      prevEl: '.productLeft',
    }
})*/
$(document).ready(function(){
	var sliderImageHeight = $('.swiper-container .swiper-slide').width()/1.2;
	$('.swiper-container .swiper-slide img').css('height',sliderImageHeight)
})